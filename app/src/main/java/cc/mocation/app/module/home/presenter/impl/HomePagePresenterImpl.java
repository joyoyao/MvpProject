package cc.mocation.app.module.home.presenter.impl;
import cc.mocation.app.module.home.presenter.HomePagePresenter;
import cc.mocation.app.module.home.view.HomePageView;
import cc.mocation.app.presenter.BasePresenterImpl;

import javax.inject.Inject;

public final class HomePagePresenterImpl extends BasePresenterImpl<HomePageView> implements HomePagePresenter {

    // The view is available using the mView variable

    @Inject
    public HomePagePresenterImpl() {
    }

    @Override
    public void onStart(boolean firstStart) {
        super.onStart(firstStart);

        // Your code here. Your view is available using mView and will not be null until next onStop()
    }

    @Override
    public void onStop() {
        // Your code here, mView will be null after this method until next onStart()

        super.onStop();
    }

    @Override
    public void onPresenterDestroyed() {
        /*
         * Your code here. After this method, your presenter (and view) will be completely destroyed
         * so make sure to cancel any HTTP call or database connection
         */

        super.onPresenterDestroyed();
    }
}