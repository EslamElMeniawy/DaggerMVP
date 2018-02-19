package elmeniawy.eslam.daggermvp.main_screen;

import dagger.Binds;
import dagger.Module;

/**
 * MainViewModule
 * <p>
 * Created by Eslam El-Meniawy on 19-Feb-2018.
 * CITC - Mansoura University
 */

@Module
public abstract class MainViewModule {
    @Binds
    abstract MainContract.MainView provideMainView(MainActivity mainActivity);
}
