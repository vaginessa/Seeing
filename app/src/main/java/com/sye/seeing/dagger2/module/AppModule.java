package com.sye.seeing.dagger2.module;

import android.content.Context;

import com.sye.seeing.App;
import com.sye.seeing.dagger2.ContextType;
import com.sye.seeing.dao.DaoMaster;
import com.sye.seeing.dao.DaoSession;

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


    @Provides
    @Singleton
    DaoMaster.DevOpenHelper provideDevOpenHelper(@ContextType Context context) {
        return new DaoMaster.DevOpenHelper(context, "markdown", null);
    }

    @Singleton
    @Provides
    DaoMaster provideDaoMaster(DaoMaster.DevOpenHelper helper) {
        return new DaoMaster(helper.getWritableDatabase());
    }

    @Singleton
    @Provides
    DaoSession provideDaoSession(DaoMaster master) {
        return master.newSession();
    }
}

