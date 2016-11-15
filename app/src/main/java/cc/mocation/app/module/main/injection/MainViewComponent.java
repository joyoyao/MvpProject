package cc.mocation.app.module.main.injection;

import cc.mocation.app.injection.ActivityScope;
import cc.mocation.app.module.main.MainActivity;
import cc.mocation.app.injection.components.AppComponent;
import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = MainViewModule.class)
public interface MainViewComponent {
    void inject(MainActivity activity);
}