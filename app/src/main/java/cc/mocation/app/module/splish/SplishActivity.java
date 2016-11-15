package cc.mocation.app.module.splish;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;

import cc.mocation.app.R;
import cc.mocation.app.injection.components.AppComponent;
import cc.mocation.app.module.base.MvpActivity;
import cc.mocation.app.module.splish.injection.DaggerSplishViewComponent;
import cc.mocation.app.module.splish.injection.SplishViewModule;
import cc.mocation.app.module.splish.presenter.SplishPresenter;
import cc.mocation.app.module.splish.view.SplishView;
import cc.mocation.app.navigation.Navigator;
import cc.mocation.app.presenter.loader.PresenterFactory;

import javax.inject.Inject;

public final class SplishActivity extends MvpActivity<SplishPresenter, SplishView> implements SplishView {



    @Inject
    PresenterFactory<SplishPresenter> mPresenterFactory;

    // Your presenter is available using the mPresenter variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splish);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mNavigator.navigateToMain(SplishActivity.this);
            }
        },2000);


        // Your code here
        // Do not call mPresenter from here, it will be null! Wait for onStart or onPostCreate.
    }

    @Override
    protected void setupComponent(@NonNull AppComponent parentComponent) {
        DaggerSplishViewComponent.builder()
                .appComponent(parentComponent)
                .splishViewModule(new SplishViewModule())
                .build()
                .inject(this);
    }

    @NonNull
    @Override
    protected PresenterFactory<SplishPresenter> getPresenterFactory() {
        return mPresenterFactory;
    }
}
