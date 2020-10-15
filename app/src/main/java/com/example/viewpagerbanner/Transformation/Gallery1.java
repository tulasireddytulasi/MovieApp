package com.example.viewpagerbanner.Transformation;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;

import androidx.viewpager.widget.ViewPager;

/**
 * ViewPager Time difference when sliding left and right
 */
public class Gallery1 implements ViewPager.PageTransformer {

    private int maxTranslateOffsetX;
    private ViewPager viewPager;

    public Gallery1() {
        this.maxTranslateOffsetX = dip2px(180);
    }

    public void transformPage(View view, float position) {
        if (viewPager == null) {
            viewPager = (ViewPager) view.getParent();
        }

        int leftInScreen = view.getLeft() - viewPager.getScrollX();
        int centerXInViewPager = leftInScreen + view.getMeasuredWidth() / 2;
        int offsetX = centerXInViewPager - viewPager.getMeasuredWidth() / 2;
        float offsetRate = (float) offsetX * 0.38f / viewPager.getMeasuredWidth();
        float scaleFactor = 1 - Math.abs(offsetRate);
        if (scaleFactor > 0) {
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);
            view.setTranslationX(-maxTranslateOffsetX * offsetRate);
        }
    }

    /**
     * dp to px
     *
     * @param dp dip
     * @return int
     */
    public static int dip2px(float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                Resources.getSystem().getDisplayMetrics());
    }

}