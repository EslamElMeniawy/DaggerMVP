package elmeniawy.eslam.daggermvp.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import elmeniawy.eslam.daggermvp.App;

/**
 * AppModule
 * <p>
 * Created by Eslam El-Meniawy on 19-Feb-2018.
 * CITC - Mansoura University
 *
 * This is where you will inject application-wide dependencies.
 */

@Module
class AppModule {
    @Provides
    Context provideContext(App application) {
        return application.getApplicationContext();
    }

    /*@Singleton
    @Provides
    CommonGreetingRepository provideCommonHelloService() {
        return new CommonGreetingRepository();
    }*/
}
