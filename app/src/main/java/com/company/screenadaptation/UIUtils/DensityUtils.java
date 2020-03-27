package com.company.screenadaptation.UIUtils;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.util.DisplayMetrics;

import androidx.annotation.NonNull;

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
public class DensityUtils {
    private static float appDensity;
    private static float appScaleDensity;
    private static final float STAND_DENSITY = 320;

    public static void setDensity(final Application application, Activity activity) {
        final DisplayMetrics displayMetrics = application.getResources().getDisplayMetrics();
        if (appDensity == 0) {
            appDensity = displayMetrics.density;
            appScaleDensity = displayMetrics.scaledDensity;
            application.registerComponentCallbacks(new ComponentCallbacks() {
                @Override
                public void onConfigurationChanged(@NonNull Configuration newConfig) {
                    if (newConfig != null && newConfig.fontScale > 0) {
                        appScaleDensity = application.getResources().getDisplayMetrics().scaledDensity;
                    }
                }

                @Override
                public void onLowMemory() {

                }
            });
        }
        float targetAppDensity = displayMetrics.widthPixels/STAND_DENSITY;
        float targetAppScaleDensity = targetAppDensity * appScaleDensity/ appDensity;
        float targetDensityDpi = targetAppDensity * 160;
        DisplayMetrics metrics = activity.getResources().getDisplayMetrics();
        metrics.density = targetAppDensity;
        metrics.scaledDensity = targetAppScaleDensity;
        metrics.densityDpi = (int) targetDensityDpi;
    }
}
