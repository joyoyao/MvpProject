package cc.mocation.app.module.splish.injection;

import android.support.annotation.NonNull;

import cc.mocation.app.module.splish.presenter.SplishPresenter;
import cc.mocation.app.module.splish.presenter.impl.SplishPresenterImpl;

import cc.mocation.app.presenter.loader.PresenterFactory;
import dagger.Module;
import dagger.Provides;

@Module
public final class SplishViewModule {

    @Provides
    public PresenterFactory<SplishPresenter> providePresenterFactory() {
        return new PresenterFactory<SplishPresenter>() {
            @NonNull
            @Override
            public SplishPresenter create() {
                return new SplishPresenterImpl();
            }
        };
    }
}
