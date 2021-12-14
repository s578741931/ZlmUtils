package com.noahcrt.zlmutils.modules;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.util.Locale;

/**
 * 系统工具类
 * Created by zhuwentao on 2016-07-18.
 */
public class SystemUtil {
    public static final String TAG = SystemUtil.class.getSimpleName();

    /**
     * 获取当前手机系统语言。
     *
     * @return 返回当前系统语言。例如：当前设置的是“中文-中国”，则返回“zh-CN”
     */
    public static String getSystemLanguage() {
        return Locale.getDefault().getLanguage();
    }

    /**
     * 获取当前系统上的语言列表(Locale列表)
     *
     * @return 语言列表
     */
    public static Locale[] getSystemLanguageList() {
        return Locale.getAvailableLocales();
    }

    /**
     * 获取当前手机系统版本号
     *
     * @return 系统版本号
     */
    public static String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    /**
     * 获取当前SDK号
     *
     * @return SDK号
     */
    public static String getSystemVersionCode() {
        return Build.VERSION.SDK_INT + "";
    }

    /**
     * 获取手机型号
     *
     * @return 手机型号
     */
    public static String getSystemModel() {
        return Build.MODEL;
    }

    /**
     * 获取手机厂商
     *
     * @return 手机厂商
     */
    public static String getDeviceBrand() {
        return Build.BRAND;
    }

    /**
     * 获取手机IMEI(需要“android.permission.READ_PHONE_STATE”权限)
     *
     * @return 手机IMEI
     */
    public static String getIMEI(Context ctx) {
        TelephonyManager tm = (TelephonyManager) ctx.getSystemService(Activity.TELEPHONY_SERVICE);
        if (tm != null) {
            return tm.getDeviceId();
        }
        return null;
    }

    /**
     * 获取安卓id
     *
     * @return 返回安卓id，这个id可以标识唯一一台设备（通常情况下）
     */
    public static String getAndroidID(Context context) {
        String androidID = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        return androidID;
    }

    /**
     * 获取安卓序列号
     *
     * @return 返回安卓序列号，这个id可以标识唯一一台设备（通常情况下）
     */
    public static String getSerial() {
        String serial = Build.SERIAL;
        return serial;
    }

    /**
     * 打印系统参数
     */
    public static void logSystemParameter(Context context) {
        Log.d(TAG, "手机厂商：" + SystemUtil.getDeviceBrand());
        Log.d(TAG, "手机型号：" + SystemUtil.getSystemModel());
        Log.d(TAG, "手机当前系统语言：" + SystemUtil.getSystemLanguage());
        Log.d(TAG, "Android系统版本号：" + SystemUtil.getSystemVersion());
        Log.d(TAG, "Android系统SDK号：" + SystemUtil.getSystemVersionCode());
        Log.d(TAG, "AndroidID：" + SystemUtil.getAndroidID(context));
        Log.d(TAG, "Android序列号：" + SystemUtil.getSerial());
    }

    /**
     * 获取系统参数
     *
     * @return
     */
    public static String getSystemParameter(Context context) {
        return "手机厂商：" + SystemUtil.getDeviceBrand() + "\n" +
                "手机型号：" + SystemUtil.getSystemModel() + "\n" +
                "手机当前系统语言：" + SystemUtil.getSystemLanguage() + "\n" +
                "Android系统版本号：" + SystemUtil.getSystemVersion() + "\n" +
                "Android系统SDK号：" + SystemUtil.getSystemVersionCode() + "\n" +
                "AndroidID：" + SystemUtil.getAndroidID(context) + "\n" +
                "Android序列号：" + SystemUtil.getSerial();
    }
}