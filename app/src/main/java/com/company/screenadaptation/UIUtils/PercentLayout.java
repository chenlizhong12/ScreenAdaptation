package com.company.screenadaptation.UIUtils;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.company.screenadaptation.R;

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
public class PercentLayout extends RelativeLayout {

    public PercentLayout(Context context) {
        super(context);
    }

    public PercentLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PercentLayout(Context context, AttributeSet attrs, int defStyleAttr) {

        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View view = getChildAt(i);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (checkLayoutParams(layoutParams)) {
                LayoutParams lp = (LayoutParams) layoutParams;
                if (lp.mWidthPercent > 0) {
                    layoutParams.width = (int) (widthSize * lp.mWidthPercent);
                }
                if (lp.mHeightPercent > 0) {
                    layoutParams.height = (int) (heightSize * lp.mHeightPercent);
                }
                if (lp.mLeftMarginPercent > 0) {
                    ((LayoutParams) layoutParams).leftMargin = (int) (widthSize * lp.mLeftMarginPercent);
                }
                if (lp.mRightMarginPercent > 0) {
                    ((LayoutParams) layoutParams).rightMargin = (int) (widthSize * lp.mRightMarginPercent);
                }
                if (lp.mTopMarginPercent > 0) {
                    ((LayoutParams) layoutParams).topMargin = (int) (heightSize * lp.mTopMarginPercent);
                }
                if (lp.mBottomMarginPercent > 0) {
                    ((LayoutParams) layoutParams).bottomMargin = (int) (heightSize * lp.mBottomMarginPercent);
                }

            }

        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof LayoutParams;
    }
    public LayoutParams generateLayoutParams(AttributeSet attrs){
        return new LayoutParams(getContext(), attrs);
    }

    public static class LayoutParams extends RelativeLayout.LayoutParams{

        private float mWidthPercent;
        private float mHeightPercent;
        private float mLeftMarginPercent;
        private float mRightMarginPercent;
        private float mTopMarginPercent;
        private float mBottomMarginPercent;

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            //解析自定义属性
            TypedArray a = c.obtainStyledAttributes(attrs,R.styleable.percentLayout);
            mWidthPercent = a.getFloat(R.styleable.percentLayout_widthPercent, 0);
            mHeightPercent = a.getFloat(R.styleable.percentLayout_heightPercent, 0);
            mLeftMarginPercent = a.getFloat(R.styleable.percentLayout_leftMarginPercent, 0);
            mRightMarginPercent = a.getFloat(R.styleable.percentLayout_rightMarginPercent, 0);
            mTopMarginPercent = a.getFloat(R.styleable.percentLayout_rightMarginPercent, 0 );
            mBottomMarginPercent = a.getFloat(R.styleable.percentLayout_rightMarginPercent, 0);
            a.recycle();
        }
    }
}
