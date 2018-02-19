package elmeniawy.eslam.daggermvp.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import elmeniawy.eslam.daggermvp.main_screen.MainActivity;
import elmeniawy.eslam.daggermvp.main_screen.MainModule;
import elmeniawy.eslam.daggermvp.main_screen.MainViewModule;

/**
 * BuildersModule
 * <p>
 * Created by Eslam El-Meniawy on 19-Feb-2018.
 * CITC - Mansoura University
 *
 * Binds all sub-components within the app.
 */

@Module
public abstract class BuildersModule {
   @ContributesAndroidInjector(modules = {MainViewModule.class, MainModule.class})
    abstract MainActivity bindMainActivity();

    // Add bindings for other sub-components here
}
