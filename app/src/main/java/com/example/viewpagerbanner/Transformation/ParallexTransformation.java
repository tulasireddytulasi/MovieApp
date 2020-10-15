package com.example.viewpagerbanner.Transformation;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import com.example.viewpagerbanner.R;

public class ParallexTransformation implements ViewPager.PageTransformer {
    @Override
    public void transformPage(@NonNull View view, float position) {
        if(position >= -1 && position <= 1){
            view.findViewById(R.id.image).setTranslationX(-position * view.getWidth()/2);
        }else {
            view.setAlpha(1);
        }
    }
}
