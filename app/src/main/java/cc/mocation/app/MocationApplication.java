package cc.mocation.app;

import android.app.Application;
import android.content.Context;
import android.os.StrictMode;

import com.frogermcs.androiddevmetrics.AndroidDevMetrics;
import com.jakewharton.threetenabp.AndroidThreeTen;
import com.squareup.leakcanary.LeakCanary;

import cc.mocation.app.injection.components.AppComponent;
import cc.mocation.app.injection.components.DaggerAppComponent;
import cc.mocation.app.injection.modules.AppModule;
import timber.log.Timber;

import static android.os.Build.VERSION.SDK_INT;
import static android.os.Build.VERSION_CODES.GINGERBREAD;

/**
 * Created by laputan on 16/11/13.
 */

public class MocationApplication extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidThreeTen.init(this);
        this.initializeInjector();
        if (BuildConfig.DEBUG) {
            AndroidDevMetrics.initWith(this);
            Timber.plant(new Timber.DebugTree());
            LeakCanary.install(this);
            if (LeakCanary.isInAnalyzerProcess(this)) {
                // This process is dedicated to LeakCanary for heap analysis.
                // You should not init your app in this process.
                return;
            }
            enabledStrictMode();

        }


    }

    private void initializeInjector() {
        this.mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static MocationApplication get(Context context) {
        return (MocationApplication) context.getApplicationContext();
    }

    private void enabledStrictMode() {
        if (SDK_INT >= GINGERBREAD) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder() //
                    .detectAll() //
                    .penaltyLog() //
                    .penaltyDeath() //
                    .build());
        }
    }

    public AppComponent getAppComponent() {
        return this.mAppComponent;
    }
}
