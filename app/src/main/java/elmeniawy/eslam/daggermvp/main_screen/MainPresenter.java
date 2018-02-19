package elmeniawy.eslam.daggermvp.main_screen;

import com.jakewharton.rxrelay2.BehaviorRelay;

import java.util.ArrayList;
import java.util.List;

import elmeniawy.eslam.daggermvp.mvp.BasePresenter;
import elmeniawy.eslam.daggermvp.network.model.Movie;
import elmeniawy.eslam.daggermvp.network.model.SearchResponse;
import elmeniawy.eslam.daggermvp.rx.SchedulersFacade;
import io.reactivex.Observable;
import timber.log.Timber;

/**
 * MainPresenter
 * <p>
 * Created by Eslam El-Meniawy on 19-Feb-2018.
 * CITC - Mansoura University
 */

public class MainPresenter extends BasePresenter<MainContract.MainView>
        implements MainContract.MainPresenter {

    private final LoadResultsUseCase loadResultsUseCase;

    private final SchedulersFacade schedulersFacade;

    private final BehaviorRelay<RequestState> requestStateObserver
            = BehaviorRelay.createDefault(RequestState.IDLE);

    MainPresenter(MainContract.MainView view,
                  LoadResultsUseCase loadResultsUseCase,
                  SchedulersFacade schedulersFacade) {
        super(view);
        this.loadResultsUseCase = loadResultsUseCase;
        this.schedulersFacade = schedulersFacade;

        observeRequestState();
    }

    @Override
    public void loadResults(String title) {
        loadResults(loadResultsUseCase.execute(title));
    }

    private void loadResults(Observable<SearchResponse> resultsObservable) {
        addDisposable(resultsObservable
                .subscribeOn(schedulersFacade.io())
                .observeOn(schedulersFacade.ui())
                .doOnSubscribe(s -> publishRequestState(RequestState.LOADING))
                .doOnComplete(() -> publishRequestState(RequestState.COMPLETE))
                .doOnError(t -> publishRequestState(RequestState.ERROR))
                .subscribe(this::displayResults, view::displayResultsError)
        );
    }

    private void publishRequestState(RequestState requestState) {
        addDisposable(Observable.just(requestState)
                .observeOn(schedulersFacade.ui())
                .subscribe(requestStateObserver));
    }

    private void observeRequestState() {
        requestStateObserver.subscribe(requestState -> {
            switch (requestState) {
                case IDLE:
                    break;
                case LOADING:
                    view.showError(false);
                    view.showResults(false);
                    view.setLoadingIndicator(true);
                    break;
                case COMPLETE:
                    view.setLoadingIndicator(false);
                    break;
                case ERROR:
                    view.showResults(false);
                    view.showError(true);
                    view.setLoadingIndicator(false);
                    break;
            }
        }, Timber::e);
    }

    private void displayResults(SearchResponse response) {
        if (response.getStatus().equals("ok")) {
            if (response.getData().getCount() > 0) {
                List<String> titles = new ArrayList<>();
                List<String> images = new ArrayList<>();

                for (Movie movie :
                        response.getData().getMovies()) {
                    titles.add(movie.getTitle());
                    images.add(movie.getImage());
                }

                view.showError(false);
                view.displayResults(titles, images);
                view.showResults(true);
            } else {
                view.showResults(false);
                view.displayErrorMessage("No results");
                view.showError(true);
            }
        } else {
            view.showResults(false);
            view.displayErrorMessage(response.getStatusMessage());
            view.showError(true);
        }
    }
}
