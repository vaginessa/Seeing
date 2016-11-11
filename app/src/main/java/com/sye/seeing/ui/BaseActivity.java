package com.sye.seeing.ui;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import com.sye.seeing.App;
import com.sye.seeing.dagger2.component.ActivityComponent;
import com.sye.seeing.dagger2.component.DaggerActivityComponent;
import com.sye.seeing.dagger2.module.ActivityModule;
import com.sye.seeing.utils.WLog;

import java.lang.reflect.Method;

import butterknife.ButterKnife;

/**
 * @author Secray
 * @date 2016.11.11
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initDependencyInjector();
        ButterKnife.bind(this);
        initToolbar();
    }

    protected void initDependencyInjector() {
        App app = (App) getApplication();
        mActivityComponent = DaggerActivityComponent.builder().
                appComponent(app.getAppComponent()).
                activityModule(new ActivityModule(this)).
                build();
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (menu != null) {
            if (menu.getClass().getSimpleName().equals("MenuBuilder")) {
                try {
                    Method m = menu.getClass().getDeclaredMethod(
                            "setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                } catch (Exception e) {
                    WLog.e("onMenuOpened...unable to set icons for overflow menu");
                }
            }
        }
        return super.onPrepareOptionsMenu(menu);
    }

    protected abstract @LayoutRes int getLayout();

    protected abstract void initToolbar();
}
