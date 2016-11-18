package cc.mocation.app.module.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cc.mocation.app.R;
import cc.mocation.app.module.base.MvpFragment;
import cc.mocation.app.module.home.injection.HomeViewComponent;
import cc.mocation.app.module.home.view.HomePageView;
import cc.mocation.app.module.home.presenter.HomePagePresenter;
import cc.mocation.app.presenter.loader.PresenterFactory;

import javax.inject.Inject;

public final class HomePageFragment extends MvpFragment<HomePagePresenter, HomePageView>
    implements HomePageView {

  @Inject PresenterFactory<HomePagePresenter> mPresenterFactory;

  // Your presenter is available using the mPresenter variable

  public HomePageFragment() {
    // Required empty public constructor
  }

  /**
   * Use this factory method to create a new instance of
   * this fragment using the provided parameters.
   *
   * @return A new instance of fragment HomePageFragment.
   */
  // TODO: Rename and change types and number of parameters
  public static HomePageFragment newInstance() {
    HomePageFragment fragment = new HomePageFragment();
    Bundle args = new Bundle();
    fragment.setArguments(args);
    return fragment;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_home_page, container, false);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    // Your code here
    // Do not call mPresenter from here, it will be null! Wait for onStart
  }

  @Override protected void setupComponent() {
    this.getComponent(HomeViewComponent.class).inject(this);
  }

  @NonNull @Override protected PresenterFactory<HomePagePresenter> getPresenterFactory() {
    return mPresenterFactory;
  }
}
