package com.sye.seeing.widget.fab;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;

/**
 * Float Action Button can scroll and hide or show depended by user gesture
 *
 * @author kui.xie
 * @date 2016-05-26
 */
public class ScrollFloatActionButton extends FloatingActionButton {
    private boolean mForceHide = false;

    public ScrollFloatActionButton(Context context) {
        super(context);
    }

    public ScrollFloatActionButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollFloatActionButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public boolean isForceHide() {
        return mForceHide;
    }

    public void setForceHide(boolean forceHide) {
        this.mForceHide = forceHide;
        if (!forceHide) {
            setVisibility(VISIBLE);
        } else {
            setVisibility(GONE);
        }
    }

    //if hide，disable animation
    public boolean canAnimation() {
        return !isForceHide();
    }
}
