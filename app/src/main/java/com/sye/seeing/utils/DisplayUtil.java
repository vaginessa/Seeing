package com.sye.seeing.utils;

import android.content.Context;

/**
 * @author kui.xie
 * @date 2016-06-02
 */
public class DisplayUtil {
    public static int[] SWIPE_REFRESH_COLORS = new int[]{
            android.R.color.holo_blue_bright, android.R.color.holo_green_light,
            android.R.color.holo_orange_light, android.R.color.holo_red_light
    };

    public static int dp2px(Context context, float dpValue) {
        final float density = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * density + 0.5f);
    }

    public static int px2dp(Context context, float pxValue) {
        final float density = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / density + 0.5f);
    }
}
