package elmeniawy.eslam.daggermvp.main_screen;

import javax.inject.Inject;

import elmeniawy.eslam.daggermvp.network.model.SearchResponse;
import io.reactivex.Observable;

/**
 * LoadResultsUseCase
 * <p>
 * Created by Eslam El-Meniawy on 19-Feb-2018.
 * CITC - Mansoura University
 */

public class LoadResultsUseCase {
    private final MainRepository mainRepository;

    @Inject
    LoadResultsUseCase(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    Observable<SearchResponse> execute(String title) {
        return mainRepository.getResults(title);
    }
}
