package com.wakim.customfont;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by web155 on 22/5/18.
 */

public class CustomFontEditText extends EditText {

    public CustomFontEditText(Context context) {
        this(context, null);
    }

    public CustomFontEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray array = context.obtainStyledAttributes(attrs,
                R.styleable.CustomFontTextView, 0, 0);
        String path_font = array.getString(R.styleable.CustomFontTextView_fontPath);
        ColorStateList path_color = array.getColorStateList(R.styleable.CustomFontTextView_fontColor);

        array.recycle();

        setCustomTypeFace(context, path_font!=null ? path_font:"fonts/OpenSans-Regular.ttf");


        setCustomTypeFaceColor(path_color!=null ? path_color:ColorStateList.valueOf(Color.BLACK));
    }

    private void setCustomTypeFace(Context context, String path_font) {
        Typeface typeFaces = Typeface.createFromAsset(context.getAssets(), path_font);
        this.setTypeface(typeFaces);
    }


    private void setCustomTypeFaceColor(ColorStateList path_color){
        this.setTextColor(path_color);
    }
}
