package com.noahcrt.zlmutils.modules;

import android.content.Context;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @title: Logg
 * @description: log帮助类
 * @author: zlm
 * @date: 2021年11月15日 0015 15:28:01
 */
public class Logg {
    private static boolean sEnablePrint = true;

    public static void init(Context context) {
        sEnablePrint = ApkUtil.isApkInDebug(context);
    }

    /**
     * 打印日志时获取当前的程序文件名、行号、方法名 输出格式为：[FileName | LineNumber | MethodName]
     *
     * @return tag
     */
    public static String getTag() {
        if (!sEnablePrint) {
            return "";
        }
        StackTraceElement traceElement = Thread.currentThread().getStackTrace()[3];
        return "[" + traceElement.getFileName() + " | "
                + traceElement.getLineNumber() + " | "
                + traceElement.getMethodName() + "]";
    }

    private static String getTagInside() {
        if (!sEnablePrint) {
            return "";
        }
        StackTraceElement traceElement = Thread.currentThread().getStackTrace()[4];
        return "[" + traceElement.getFileName() + " | "
                + traceElement.getLineNumber() + " | "
                + traceElement.getMethodName() + "]";
    }

    public static void i(String tag, String log) {
        if (sEnablePrint) {
            Log.i(tag, log);
        }
    }

    public static void e(String tag, String log) {
        if (sEnablePrint) {
            Log.e(tag, log);
        }
    }

    public static void d(String tag, String log) {
        if (sEnablePrint) {
            Log.d(tag, log);
        }
    }

    public static void w(String tag, String log) {
        if (sEnablePrint) {
            Log.w(tag, log);
        }
    }

    public static void v(String tag, String log) {
        if (sEnablePrint) {
            Log.v(tag, log);
        }
    }

    public static void i(String log) {
        if (sEnablePrint) {
            Log.i(getTagInside(), log);
        }
    }

    public static void e(String log) {
        if (sEnablePrint) {
            Log.e(getTagInside(), log);
        }
    }

    public static void d(String log) {
        if (sEnablePrint) {
            Log.d(getTagInside(), log);
        }
    }

    public static void w(String log) {
        if (sEnablePrint) {
            Log.w(getTagInside(), log);
        }
    }

    public static void v(String log) {
        if (sEnablePrint) {
            Log.v(getTagInside(), log);
        }
    }

    public static void timeRecord(String log) {
        if (sEnablePrint) {
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss.SSS");
            Log.v(getTagInside(), log + "  当前时间：" + sdf.format(new Date()));
        }
    }
}
