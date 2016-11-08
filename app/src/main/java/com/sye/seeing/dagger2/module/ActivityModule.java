package com.sye.seeing.dagger2.module;

import android.app.Activity;
import android.content.Context;

import com.sye.seeing.dagger2.ContextType;

import dagger.Module;
import dagger.Provides;

/**
 * @author Secray
 * @date 2016.11.08
 */

@Module
public class ActivityModule {
    private final Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @com.sye.seeing.dagger2.Activity
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @com.sye.seeing.dagger2.Activity
    @ContextType("Activity")
    Context provideActivityContext() {
        return mActivity;
    }
}
