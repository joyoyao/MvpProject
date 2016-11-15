package cc.mocation.app.module.main.injection;

import android.support.annotation.NonNull;

import cc.mocation.app.module.main.presenter.MainPresenter;
import cc.mocation.app.module.main.presenter.MainPresenterImpl;
import cc.mocation.app.presenter.loader.PresenterFactory;
import dagger.Module;
import dagger.Provides;

@Module
public final class MainViewModule {


    @Provides
    public PresenterFactory<MainPresenter> providePresenterFactory() {
        return new PresenterFactory<MainPresenter>() {
            @NonNull
            @Override
            public MainPresenter create() {
                return new MainPresenterImpl();
            }
        };
    }
}
