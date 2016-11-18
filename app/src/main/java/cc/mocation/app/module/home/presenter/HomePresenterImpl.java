package cc.mocation.app.module.home.presenter;

import cc.mocation.app.data.DataManager;
import cc.mocation.app.presenter.BasePresenterImpl;
import cc.mocation.app.module.home.view.HomeView;

import javax.inject.Inject;

public final class HomePresenterImpl extends BasePresenterImpl<HomeView> implements HomePresenter {
  // The view is available using the mView variable
  private DataManager mDataManager;

  @Inject public HomePresenterImpl(DataManager dataManager) {
    mDataManager = dataManager;
  }

  @Override public void onStart(boolean firstStart) {
    super.onStart(firstStart);

    // Your code here. Your view is available using mView and will not be null until next onStop()
  }

  @Override public void onStop() {
    // Your code here, mView will be null after this method until next onStart()

    super.onStop();
  }

  @Override public void onPresenterDestroyed() {
        /*
         * Your code here. After this method, your presenter (and view) will be completely destroyed
         * so make sure to cancel any HTTP call or database connection
         */

    super.onPresenterDestroyed();
  }
}