package com.sye.seeing;

import android.app.Application;
import android.os.Build;
import android.os.StrictMode;

import com.sye.seeing.dagger2.component.AppComponent;
import com.sye.seeing.dagger2.component.DaggerAppComponent;
import com.sye.seeing.dagger2.module.AppModule;

/**
 * @author Secray
 * @date 2016.11.08
 */

public class App extends Application {
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initAppComponent();
        initStrictMode();
    }

    private void initAppComponent() {
        mAppComponent = DaggerAppComponent.builder().
                appModule(new AppModule(this)).build();
    }


    public AppComponent getAppComponent() {
        return this.mAppComponent;
    }


    private void initStrictMode() {
        if (BuildConfig.LOG_DEBUG && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());
        }
    }
}
