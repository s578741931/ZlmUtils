package com.noahcrt.zlmutils.modules;

import android.content.Context;
import android.widget.Toast;

/**
 * @title: Toastt
 * @description: Toastt帮助类
 * @author: zlm
 * @date: 2021年12月06日 0006 10:35:15
 */
public class Toastt {
    private static boolean sEnableShow = true;
    private static Context sBasecontext;

    public static void init(Context basecontext) {
        sEnableShow = ApkUtil.isApkInDebug(basecontext);
        sBasecontext = basecontext;
    }

    public static void show(String text) {
        if (sEnableShow) {
            Toast.makeText(sBasecontext, text, Toast.LENGTH_SHORT).show();
        }
    }

    public static void showShort(String text) {
        if (sEnableShow) {
            Toast.makeText(sBasecontext, text, Toast.LENGTH_SHORT).show();
        }
    }

    public static void showLong(String text) {
        if (sEnableShow) {
            Toast.makeText(sBasecontext, text, Toast.LENGTH_LONG).show();
        }
    }
}
