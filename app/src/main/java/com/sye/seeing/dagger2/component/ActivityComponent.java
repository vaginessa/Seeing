package com.sye.seeing.dagger2.component;

import android.content.Context;

import com.sye.seeing.ui.MainActivity;
import com.sye.seeing.dagger2.Activity;
import com.sye.seeing.dagger2.ContextType;
import com.sye.seeing.dagger2.module.ActivityModule;

import dagger.Component;

/**
 * @author Secray
 * @date 2016.11.08
 */

@Activity
@Component(modules = ActivityModule.class, dependencies = AppComponent.class)
public interface ActivityComponent {
    android.app.Activity activity();

    void inject(MainActivity activity);

    @ContextType("Activity")
    Context getActivityContext();

    @ContextType
    Context getApplicationContext();
}
