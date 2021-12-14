package com.noahcrt.zlmutils.modules;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

public class VersionUtil {
    public static String appVersionCode = null;
    public static String appVersionName = null;
    private static boolean inited = false;

    public static void init(Context context) {
        appVersionCode = getLocalVersion(context) + "";
        appVersionName = getLocalVersionName(context);
        inited = true;
    }

    public static String getAppVersionCode() {
        if (!inited) {
            throw new RuntimeException("VersionUtil is not init");
        }
        return appVersionCode;
    }

    public static String getAppVersionName() {
        if (!inited) {
            throw new RuntimeException("VersionUtil is not init");
        }
        return appVersionName;
    }

    /**
     * 获取本地软件版本号
     */
    public static int getLocalVersion(Context ctx) {
        int localVersion = 0;
        try {
            PackageInfo packageInfo = ctx.getApplicationContext()
                    .getPackageManager()
                    .getPackageInfo(ctx.getPackageName(), 0);
            localVersion = packageInfo.versionCode;
            Log.d("VersionUtil", "本地软件版本号。。" + localVersion);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return localVersion;
    }

    /**
     * 获取本地软件版本号名称
     */
    public static String getLocalVersionName(Context ctx) {
        String localVersion = "";
        try {
            PackageInfo packageInfo = ctx.getApplicationContext()
                    .getPackageManager()
                    .getPackageInfo(ctx.getPackageName(), 0);
            localVersion = packageInfo.versionName;
            Log.d("VersionUtil", "本地软件版本号名称。。" + localVersion);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return localVersion;
    }
}
