package cc.mocation.app.injection.modules;

import java.lang.ref.WeakReference;

import cc.mocation.app.injection.ActivityScope;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class ActivityModule<T> {

    protected final WeakReference<T> activity;


    public ActivityModule(T activity) {
        this.activity = new WeakReference<>(activity);
    }

    @Provides
    @ActivityScope
    public T provideActivity() {
        return activity.get();
    }


}
