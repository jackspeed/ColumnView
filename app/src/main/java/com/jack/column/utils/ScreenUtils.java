package com.jack.column.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;


import java.lang.reflect.Field;

public class ScreenUtils {
    private static double RATIO = 0.85;

    public static int screenWidth;
    public static int screenHeight;
    public static int screenMin;// 宽高中，小的一边
    public static int screenMax;// 宽高中，较大的值

    public static float density;
    public static float scaleDensity;
    public static float xdpi;
    public static float ydpi;
    public static int   densityDpi;

    public static int dialogWidth;
    public static int statusbarheight;
    public static int navbarheight;

    public static int getDialogWidth() {
        dialogWidth = (int) (screenMin * RATIO);
        return dialogWidth;
    }

    public static void init(Context context) {
        if (null == context) {
            return;
        }
        DisplayMetrics dm = context.getApplicationContext().getResources().getDisplayMetrics();
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels;
        screenMin = (screenWidth > screenHeight) ? screenHeight : screenWidth;
        density = dm.density;
        scaleDensity = dm.scaledDensity;
        xdpi = dm.xdpi;
        ydpi = dm.ydpi;
        densityDpi = dm.densityDpi;
    }


    public static void GetInfo(Context context) {
        if (null == context) {
            return;
        }
        DisplayMetrics dm = context.getApplicationContext().getResources().getDisplayMetrics();
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels;
        screenMin = (screenWidth > screenHeight) ? screenHeight : screenWidth;
        screenMax = (screenWidth < screenHeight) ? screenHeight : screenWidth;
        density = dm.density;
        scaleDensity = dm.scaledDensity;
        xdpi = dm.xdpi;
        ydpi = dm.ydpi;
        densityDpi = dm.densityDpi;
        statusbarheight = getStatusBarHeight(context);
        navbarheight = getNavBarHeight(context);
    }


    public static int getStatusBarHeight(Context context) {
        Class c = null;
        Object obj = null;
        Field field = null;
        boolean x = false;
        int sbar = 0;

        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            int x1 = Integer.parseInt(field.get(obj).toString());
            sbar = context.getResources().getDimensionPixelSize(x1);
        } catch (Exception var7) {
            var7.printStackTrace();
        }

        return sbar;
    }

    public static int getNavBarHeight(Context context) {
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        return resourceId > 0 ? resources.getDimensionPixelSize(resourceId) : 0;
    }

    public static int dip2px(float dipValue,Context context) {
        float scale = getDisplayDensity(context);
        return (int) (dipValue * scale + 0.5F);
    }

    public static int px2dip(float pxValue,Context context) {
        float scale = getDisplayDensity(context);
        return (int) (pxValue / scale + 0.5F);
    }

    private static float getDisplayDensity(Context context) {
        if (density == 0.0F) {
            GetInfo(context);
        }

        return density;
    }

    public static int getDisplayWidth(Context context) {
        if (screenWidth == 0) {
            GetInfo(context);
        }

        return screenWidth;
    }

    public static int getDisplayHeight(Context context) {
        if (screenHeight == 0) {
            GetInfo(context);
        }

        return screenHeight;
    }

    public static int getSceenMin(Context context) {
        if (screenMin == 0) {
            GetInfo(context);
        }

        return screenMin;
    }
}
