package com.company.screenadaptation.UIUtils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

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
public class ScreenAdapterRelativeLayout extends RelativeLayout {
    boolean flag;

    public ScreenAdapterRelativeLayout(Context context) {
        super(context);
    }

    public ScreenAdapterRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScreenAdapterRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!flag) {
            float horizontalScale = MetricsUtils.getInstance(getContext()).getHorizontalScale();
            float verticalScale = MetricsUtils.getInstance(getContext()).getVerticalScale();
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = getChildAt(i);
                LayoutParams params = (LayoutParams) child.getLayoutParams();
                params.width = (int) (params.width * horizontalScale);
                params.height = (int) (params.height * verticalScale);
                params.leftMargin = (int) (params.leftMargin * horizontalScale);
                params.rightMargin = (int) (params.rightMargin * horizontalScale);
                params.topMargin = (int) (params.topMargin * verticalScale);
                params.bottomMargin = (int) (params.bottomMargin * verticalScale);
            }
            flag = true;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
