package com.google.appinventor.components.runtime.util;

import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;

public class PaintUtil {
    private PaintUtil() {
    }

    public static void changePaint(Paint paint, int argb) {
        paint.setColor(16777215 & argb);
        paint.setAlpha((argb >> 24) & 255);
        paint.setXfermode(null);
    }

    public static void changePaintTransparent(Paint paint) {
        paint.setAlpha(0);
        paint.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
    }
}
