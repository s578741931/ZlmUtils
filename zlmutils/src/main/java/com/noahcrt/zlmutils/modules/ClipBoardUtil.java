package com.noahcrt.zlmutils.modules;

import android.content.ClipboardManager;
import android.content.Context;
import android.widget.Toast;

/**
 * @title: ClipBoardUtil
 * @description: 剪切板工具类
 * @author: zlm
 * @date: 2021年12月14日 0014 10:48:36
 */
public class ClipBoardUtil {


    public static void copyClipBoard(Context context, String srt) {
        if (srt != null && !srt.equals("")) {
            ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            // 将文本内容放到系统剪贴板里。
            cm.setText(srt);
            Toast.makeText(context, "已复制到剪切板", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(context, "复制失败", Toast.LENGTH_SHORT).show();
        }
    }
}
