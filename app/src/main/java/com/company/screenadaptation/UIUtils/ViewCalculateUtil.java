package com.company.screenadaptation.UIUtils;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
public class ViewCalculateUtil {
    private static ViewCalculateUtil mViewCalculateUtil;
    public ViewCalculateUtil(Context context) {

    }

    public static ViewCalculateUtil getInstance(Context context) {
        if (mViewCalculateUtil == null) {
            mViewCalculateUtil = new ViewCalculateUtil(context);
        }
        return mViewCalculateUtil;
    }

    public static void setViewRelativeLayoutParams (View view, int width, int height , int leftMargin,
     int  topMargin, int rightMargin, int bottomMargin) {
       RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) view.getLayoutParams();
        if (params != null) {
            if (width != RelativeLayout.LayoutParams.MATCH_PARENT && width != RelativeLayout.LayoutParams.WRAP_CONTENT
            && width != RelativeLayout.LayoutParams.FILL_PARENT) {
                params.width = MetricsUtils.getInstance().getWidth(width);
            } else {
                params.width = width;
            }
            if (height != RelativeLayout.LayoutParams.MATCH_PARENT && height != RelativeLayout.LayoutParams.WRAP_CONTENT
            && height != RelativeLayout.LayoutParams.FILL_PARENT) {
                params.height = MetricsUtils.getInstance().getHeight(height);
            } else {
                params.height = width;
            }
            params.leftMargin = MetricsUtils.getInstance().getLeftMargin(leftMargin);
            params.rightMargin = MetricsUtils.getInstance().getLeftMargin(rightMargin);
            params.topMargin = MetricsUtils.getInstance().getLeftMargin(topMargin);
            params.bottomMargin = MetricsUtils.getInstance().getLeftMargin(bottomMargin);
            view.setLayoutParams(params);
        }
    }

    public static void setTextSize(TextView view, int size)
    {
        view.setTextSize(TypedValue.COMPLEX_UNIT_PX, MetricsUtils.getInstance().getHeight(size));
    }

    public static void setViewLinearLayoutParam(View view, int width, int height)
    {

        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (width != RelativeLayout.LayoutParams.MATCH_PARENT && width != RelativeLayout.LayoutParams.WRAP_CONTENT && width != RelativeLayout.LayoutParams.FILL_PARENT)
        {
            layoutParams.width = MetricsUtils.getInstance( ).getWidth(width);
        }
        else
        {
            layoutParams.width = width;
        }
        if (height != RelativeLayout.LayoutParams.MATCH_PARENT && height != RelativeLayout.LayoutParams.WRAP_CONTENT && height != RelativeLayout.LayoutParams.FILL_PARENT)
        {
            layoutParams.height = MetricsUtils.getInstance( ).getHeight(height);
        }
        else
        {
            layoutParams.height = height;
        }

        view.setLayoutParams(layoutParams);
    }

    public static void setViewGroupLayoutParam(View view, int width, int height)
    {

        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (width != RelativeLayout.LayoutParams.MATCH_PARENT && width != RelativeLayout.LayoutParams.WRAP_CONTENT && width != RelativeLayout.LayoutParams.FILL_PARENT)
        {
            layoutParams.width = MetricsUtils.getInstance( ).getWidth(width);
        }
        else
        {
            layoutParams.width = width;
        }
        if (height != RelativeLayout.LayoutParams.MATCH_PARENT && height != RelativeLayout.LayoutParams.WRAP_CONTENT && height != RelativeLayout.LayoutParams.FILL_PARENT)
        {
            layoutParams.height = MetricsUtils.getInstance( ).getHeight(height);
        }
        else
        {
            layoutParams.height = height;
        }
        view.setLayoutParams(layoutParams);
    }

    /**
     * 设置LinearLayout中 view的高度宽度
     *
     * @param view
     * @param width
     * @param height
     */
    public static void setViewLinearLayoutParam(View view, int width, int height, int topMargin, int bottomMargin, int lefMargin,
                                                int rightMargin)
    {

        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (width != RelativeLayout.LayoutParams.MATCH_PARENT && width != RelativeLayout.LayoutParams.WRAP_CONTENT && width != RelativeLayout.LayoutParams.FILL_PARENT)
        {
            layoutParams.width = MetricsUtils.getInstance( ).getWidth(width);
        }
        else
        {
            layoutParams.width = width;
        }
        if (height != RelativeLayout.LayoutParams.MATCH_PARENT && height != RelativeLayout.LayoutParams.WRAP_CONTENT && height != RelativeLayout.LayoutParams.FILL_PARENT)
        {
            layoutParams.height = MetricsUtils.getInstance( ).getHeight(height);
        }
        else
        {
            layoutParams.height = height;
        }

        layoutParams.topMargin = MetricsUtils.getInstance( ).getHeight(topMargin);
        layoutParams.bottomMargin = MetricsUtils.getInstance( ).getHeight(bottomMargin);
        layoutParams.leftMargin = MetricsUtils.getInstance( ).getWidth(lefMargin);
        layoutParams.rightMargin = MetricsUtils.getInstance( ).getWidth(rightMargin);
        view.setLayoutParams(layoutParams);
    }

}
