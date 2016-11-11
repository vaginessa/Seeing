package com.sye.seeing.utils;

import android.util.Log;

import com.sye.seeing.BuildConfig;


/**
 * @author Secray
 * @date 2016.11.11
 * manage the log output
 */
public class WLog {
    private static boolean isDebug = BuildConfig.LOG_DEBUG;
    private static final String TAG = "Seeing";

    //use your tag output log
    public static void w(String tag, String msg) {
        if (isDebug) {
            Log.w(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (isDebug) {
            Log.i(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (isDebug) {
            Log.i(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (isDebug) {
            Log.d(tag, msg);
        }
    }

    public static void v(String tag, String msg) {
        if (isDebug) {
            Log.i(tag, msg);
        }
    }

    //use default tag output log
    public static void i(String msg) {
        if (isDebug) {
            Log.i(TAG, msg);
        }
    }

    public static void w(String msg) {
        if (isDebug) {
            Log.i(TAG, msg);
        }
    }

    public static void v(String msg) {
        if (isDebug) {
            Log.i(TAG, msg);
        }
    }

    public static void e(String msg) {
        if (isDebug) {
            Log.i(TAG, msg);
        }
    }

    public static void d(String msg) {
        if (isDebug) {
            Log.d(TAG, msg);
        }
    }
}
