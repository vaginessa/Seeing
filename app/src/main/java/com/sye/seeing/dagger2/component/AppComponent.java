package com.sye.seeing.dagger2.component;

import android.content.Context;

import com.sye.seeing.App;
import com.sye.seeing.dagger2.ContextType;
import com.sye.seeing.dagger2.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Secray
 * @date 2016.11.08
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    App app();

    @ContextType("App")
    Context getApplicationContext();
}
