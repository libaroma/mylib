package com.mylib.hyz.libblog.utils;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;

public class ResourcesUtils {
    public static int getColorValue(Context context, int id) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(id, typedValue, true);
        return Color.parseColor((String) typedValue.coerceToString());
    }
}
