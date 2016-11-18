package cc.mocation.app.module.home.injection;

import cc.mocation.app.injection.ActivityScope;
import cc.mocation.app.injection.modules.ActivityModule;
import cc.mocation.app.module.home.HomeActivity;
import cc.mocation.app.injection.components.AppComponent;
import cc.mocation.app.module.home.HomePageFragment;
import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = HomeViewModule.class)
public interface HomeViewComponent {
    void inject(HomeActivity activity);

    void inject(HomePageFragment activity);
}