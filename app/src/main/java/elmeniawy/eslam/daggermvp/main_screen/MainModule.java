package elmeniawy.eslam.daggermvp.main_screen;

import dagger.Module;
import dagger.Provides;
import elmeniawy.eslam.daggermvp.rx.SchedulersFacade;

/**
 * MainModule
 * <p>
 * Created by Eslam El-Meniawy on 19-Feb-2018.
 * CITC - Mansoura University
 * <p>
 * Define MainActivity-specific dependencies here.
 */

@Module
public class MainModule {
    @Provides
    MainRepository provideMainResultsRepository() {
        return new MainRepository();
    }

    @Provides
    MainPresenter provideMainPresenter(MainContract.MainView mainView,
                                       LoadResultsUseCase loadResultsUseCase,
                                       SchedulersFacade schedulersFacade) {
        return new MainPresenter(mainView, loadResultsUseCase, schedulersFacade);
    }
}
