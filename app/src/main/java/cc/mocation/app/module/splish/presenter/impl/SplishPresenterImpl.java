package cc.mocation.app.module.splish.presenter.impl;
import cc.mocation.app.module.splish.presenter.SplishPresenter;
import cc.mocation.app.module.splish.view.SplishView;
import cc.mocation.app.presenter.BasePresenterImpl;

import javax.inject.Inject;

public final class SplishPresenterImpl extends BasePresenterImpl<SplishView> implements SplishPresenter {
    /**
     * The interactor
     */

    // The view is available using the mView variable

    @Inject
    public SplishPresenterImpl() {
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