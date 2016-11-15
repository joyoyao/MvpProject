package cc.mocation.app.module.splish.injection;

import cc.mocation.app.injection.ActivityScope;
import cc.mocation.app.injection.components.AppComponent;
import cc.mocation.app.module.splish.SplishActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = SplishViewModule.class)
public interface SplishViewComponent {
    void inject(SplishActivity activity);
}