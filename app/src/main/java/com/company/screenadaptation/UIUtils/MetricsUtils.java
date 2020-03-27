package com.company.screenadaptation.UIUtils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

/**
 * ┏┓　   ┏┓
 * ┏┛┻━━━━━┛┻━┓
 * ┃　　　　   ┃
 * ┃　━　━　   ┃
 * ████━████   ┃
 * ┃　　　　   ┃
 * ┃　 ┻　    ┃
 * ┗━┓      ┏━┛
 * 　┃      ┃
 * 　┃ 0BUG ┗━━━┓
 * 　┃0Error     ┣┓
 * 　┃0Warning   ┏┛
 * 　┗┓┓┏━┳┓┏┛ ━
 * 　　┃┫┫ ┃┫┫
 * 　　┗┻┛ ┗┻┛
 * Created by clz on 2020/3/26
 */
public class MetricsUtils {
    private static MetricsUtils metricsUtils;
    private int mDisplayHeight;
    private int mDisplayWidth;
    private static float STANDER_WIDTH = 1080;
    private static float STANDER_HEIGHT = 1920;
    private  int mSystemBarHeight;

    public static MetricsUtils getInstance(Context context) {
        if (metricsUtils == null) {
            metricsUtils = new MetricsUtils(context);
        }
        return metricsUtils;
    }

    public static MetricsUtils getInstance() {
        if (metricsUtils == null) {
            throw new RuntimeException("MetricsUtils 应该先调用有构造方法进行初始化");
        }
        return metricsUtils;
    }

    public MetricsUtils(Context context) {
        if (mDisplayHeight == 0 | mDisplayWidth == 0) {
            WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            if (windowManager != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                mSystemBarHeight = getStateBarHeight(context);
                //横屏
                if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                    mDisplayWidth = displayMetrics.heightPixels;
                    mDisplayHeight = displayMetrics.widthPixels - mSystemBarHeight;
                    Log.i("clz", "MetricsUtils1: " + mDisplayWidth);
                    Log.i("clz", "MetricsUtils1: " + mDisplayHeight);
                } else {
                    mDisplayHeight = displayMetrics.heightPixels - mSystemBarHeight;
                    mDisplayWidth = displayMetrics.widthPixels;
                    Log.i("clz", "MetricsUtils: " + mDisplayWidth);
                    Log.i("clz", "MetricsUtils: " + mDisplayHeight);
                }
            }
        }

    }

    public static MetricsUtils notifyInstance(Context context) {
        metricsUtils = new MetricsUtils(context);
        return metricsUtils;
    }

    private int getStateBarHeight(Context context) {
        int resId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resId > 0) {
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(resId);
            return dimensionPixelSize;
        }
        return 0;
    }

    public float getVerticalScale() {
        return mDisplayHeight / (STANDER_HEIGHT - mSystemBarHeight);
    }

    public float getHorizontalScale() {
        return mDisplayWidth / STANDER_WIDTH;
    }

    public int getWidth(int width) {
        return Math.round(width * getHorizontalScale());
    }

    public int getHeight(int height) {
        return Math.round(height * getVerticalScale());
    }

    public int getLeftMargin(int leftMargin) {
        return Math.round(leftMargin * getHorizontalScale());
    }

    public int getRightMargin(int rightMargin) {
        return Math.round(rightMargin * getHorizontalScale());
    }

    public int getTopMargin(int topMargin) {
        return Math.round(topMargin * getVerticalScale());
    }

    public int getBottomMargin(int bottomMargin) {
        return Math.round(bottomMargin * getVerticalScale());
    }
}
