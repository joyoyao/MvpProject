package cc.mocation.app.module.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import cc.mocation.app.R;
import cc.mocation.app.injection.HasComponent;
import cc.mocation.app.injection.components.AppComponent;
import cc.mocation.app.module.base.MvpActivity;
import cc.mocation.app.module.home.injection.DaggerHomeViewComponent;
import cc.mocation.app.module.home.injection.HomeViewComponent;
import cc.mocation.app.module.home.injection.HomeViewModule;
import cc.mocation.app.module.home.presenter.HomePresenter;
import cc.mocation.app.module.home.view.HomeNavBar;
import cc.mocation.app.module.home.view.HomeView;
import cc.mocation.app.presenter.loader.PresenterFactory;

public final class HomeActivity extends MvpActivity<HomePresenter, HomeView>
    implements HomeView, HomeNavBar.OnHomeNavChangeListener, HasComponent<HomeViewComponent> {
  // Your presenter is available using the mPresenter variable

  @Inject PresenterFactory<HomePresenter> mPresenterFactory;

  @BindView(R.id.home_control) HomeNavBar homeNavBar;

  private HomeViewComponent mHomeViewComponent;

  private HomePageFragment mHomePageFragment;


  public static void start(Activity activity) {
    Intent intent = new Intent(activity, HomeActivity.class);
    activity.startActivity(intent);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);
    ButterKnife.bind(this);
    homeNavBar.setOnHomeNavChangeListener(this);
    // Your code here
    // Do not call mPresenter from here, it will be null! Wait for onStart or onPostCreate.
  }

  @Override protected void setupComponent(@NonNull AppComponent parentComponent) {
    mHomeViewComponent = DaggerHomeViewComponent.builder()
        .appComponent(parentComponent)
        .homeViewModule(new HomeViewModule())
        .build();
    mHomeViewComponent.inject(this);
  }

  @NonNull @Override protected PresenterFactory<HomePresenter> getPresenterFactory() {
    return mPresenterFactory;
  }

  @Override public void setNavChange(int index) {
    onNavChnage(index);
  }

  protected void onNavChnage(int tab) {
    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    hideFragments(transaction);
    switch (tab) {
      case 0:
        if (mHomePageFragment == null) {
          mHomePageFragment = HomePageFragment.newInstance();
          transaction.add(R.id.fragment_container, mHomePageFragment);
        } else {
          transaction.show(mHomePageFragment);
        }
        break;
      default:
        break;
    }
    transaction.commit();
  }

  private void hideFragments(FragmentTransaction transaction) {
    if (mHomePageFragment != null) {
      transaction.hide(mHomePageFragment);
    }
  }

  @Override public HomeViewComponent getComponent() {
    return mHomeViewComponent;
  }
}
