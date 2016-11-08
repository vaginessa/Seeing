package com.sye.seeing.dagger2.module;

import android.content.Context;

import com.sye.seeing.App;
import com.sye.seeing.dagger2.ContextType;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Secray
 * @date 2016.11.08
 */

@Module
public class AppModule {
    private final App mApp;

    public AppModule(App app) {
        this.mApp = app;
    }

    @Singleton
    @Provides
    App provideApplication() {
        return mApp;
    }

    @Provides
    @Singleton
    @ContextType
    Context provideApplicationContext() {
        return mApp.getApplicationContext();
    }
}

