package com.nesger.recyclerview.utils;

import android.util.Log;

/**
 * @author nesger.zhan
 */
public class LogUtils {
    //总开关
    public final static boolean SWITCH = true;

    private final static boolean V = SWITCH && true;
    private final static boolean D = SWITCH && true;
    private final static boolean I = SWITCH && true;
    private final static boolean W = SWITCH && true;
    private final static boolean E = SWITCH && true;
    public static final String NESGER_LOG = "nesger";

    public static void v(String tag, String msg) {
        if (V) {
            Log.v(tag + ":" + getScope(), msg);
        }
    }

    public static void d(String tag, String msg) {
        if (D) {
            Log.d(tag + ":" + getScope(), msg);
        }
    }

    public static void i(String tag, String msg) {
        if (I) {
            Log.i(tag + ":" + getScope(), msg);
        }
    }

    public static void w(String tag, String msg) {
        if (W) {
            Log.w(tag + ":" + getScope(), msg);
        }
    }

    public static void e(String tag, String msg) {
        if (E) {
            Log.e(tag + ":" + getScope(), msg);
        }
    }

    /**
     * 打印异常详细信息,推荐使用
     *
     * @param tag
     * @param e
     */
    public static void e(String tag, Exception e) {
        if (E) {
            Log.e(tag + ":" + getScope(), "", e);
        }
    }


    private static final int DEFAULT_STACK_TRACE_LINE_COUNT = 4;

    private static String getScope() {
        StackTraceElement trace = Thread.currentThread().getStackTrace()[DEFAULT_STACK_TRACE_LINE_COUNT];
        return "(" + trace.getFileName() + ":" + trace.getLineNumber() + ")";
    }

}
