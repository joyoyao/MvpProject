package cc.mocation.app.injection.modules;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import cc.mocation.app.injection.ApplicationContext;
import cc.mocation.app.navigation.Navigator;
import dagger.Module;
import dagger.Provides;

/**
 * Provide application-level dependencies.
 */
@Module
public class AppModule {
    protected final Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }


    @Singleton
    @Provides
    Navigator provideNavigator() {
        return new Navigator();
    }

//    @Provides
//    @Singleton
//    RibotsService provideRibotsService() {
//        return RibotsService.Creator.newRibotsService();
//    }

}
