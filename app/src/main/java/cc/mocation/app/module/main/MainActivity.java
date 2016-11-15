package cc.mocation.app.module.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import cc.mocation.app.R;
import cc.mocation.app.module.main.view.MainView;
import cc.mocation.app.module.base.MvpActivity;
import cc.mocation.app.presenter.loader.PresenterFactory;
import cc.mocation.app.module.main.presenter.MainPresenter;
import cc.mocation.app.injection.components.AppComponent;
import cc.mocation.app.module.main.injection.MainViewModule;
import cc.mocation.app.module.main.injection.DaggerMainViewComponent;

import javax.inject.Inject;

public final class MainActivity extends MvpActivity<MainPresenter, MainView> implements MainView {
    @Inject
    PresenterFactory<MainPresenter> mPresenterFactory;

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Your code here
        // Do not call mPresenter from here, it will be null! Wait for onStart or onPostCreate.
    }

    @Override
    protected void setupComponent(@NonNull AppComponent parentComponent) {
        DaggerMainViewComponent.builder()
                .appComponent(parentComponent)
                .mainViewModule(new MainViewModule())
                .build()
                .inject(this);
    }

    @NonNull
    @Override
    protected PresenterFactory<MainPresenter> getPresenterFactory() {
        return mPresenterFactory;
    }
}
