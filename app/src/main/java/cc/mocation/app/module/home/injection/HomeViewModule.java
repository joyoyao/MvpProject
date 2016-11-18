package cc.mocation.app.module.home.injection;

import android.support.annotation.NonNull;

import cc.mocation.app.data.DataManager;
import cc.mocation.app.module.home.presenter.HomePagePresenter;
import cc.mocation.app.module.home.presenter.HomePresenter;
import cc.mocation.app.module.home.presenter.HomePresenterImpl;
import cc.mocation.app.module.home.presenter.impl.HomePagePresenterImpl;
import cc.mocation.app.presenter.loader.PresenterFactory;
import dagger.Module;
import dagger.Provides;

@Module
public final class HomeViewModule {


    @Provides
    public PresenterFactory<HomePresenter> providePresenterFactory(final DataManager dataManager) {
        return new PresenterFactory<HomePresenter>() {
            @NonNull
            @Override
            public HomePresenter create() {
                return new HomePresenterImpl(dataManager);
            }
        };
    }


    @Provides
    public PresenterFactory<HomePagePresenter> provideHomePresenterFactory() {
        return new PresenterFactory<HomePagePresenter>() {
            @NonNull
            @Override
            public HomePagePresenter create() {
                return new HomePagePresenterImpl();
            }
        };
    }
}
