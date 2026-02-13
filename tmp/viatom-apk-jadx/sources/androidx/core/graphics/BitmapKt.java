package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Point;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import g7.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class BitmapKt {
    public static final Bitmap applyCanvas(Bitmap bitmap, l lVar) {
        lVar.invoke(new Canvas(bitmap));
        return bitmap;
    }

    public static final boolean contains(Bitmap bitmap, PointF pointF) {
        float f = pointF.x;
        if (f < 0.0f || f >= bitmap.getWidth()) {
            return false;
        }
        float f10 = pointF.y;
        return f10 >= 0.0f && f10 < ((float) bitmap.getHeight());
    }

    public static final Bitmap createBitmap(int i10, int i11, Bitmap.Config config) {
        return Bitmap.createBitmap(i10, i11, config);
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i10, int i11, Bitmap.Config config, boolean z9, ColorSpace colorSpace, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        if ((i12 & 8) != 0) {
            z9 = true;
        }
        if ((i12 & 16) != 0) {
            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        return Bitmap.createBitmap(i10, i11, config, z9, colorSpace);
    }

    public static final int get(Bitmap bitmap, int i10, int i11) {
        return bitmap.getPixel(i10, i11);
    }

    public static final Bitmap scale(Bitmap bitmap, int i10, int i11, boolean z9) {
        return Bitmap.createScaledBitmap(bitmap, i10, i11, z9);
    }

    public static /* synthetic */ Bitmap scale$default(Bitmap bitmap, int i10, int i11, boolean z9, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            z9 = true;
        }
        return Bitmap.createScaledBitmap(bitmap, i10, i11, z9);
    }

    public static final void set(Bitmap bitmap, int i10, int i11, @ColorInt int i12) {
        bitmap.setPixel(i10, i11, i12);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final Bitmap createBitmap(int i10, int i11, Bitmap.Config config, boolean z9, ColorSpace colorSpace) {
        return Bitmap.createBitmap(i10, i11, config, z9, colorSpace);
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i10, int i11, Bitmap.Config config, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return Bitmap.createBitmap(i10, i11, config);
    }

    public static final boolean contains(Bitmap bitmap, Point point) {
        int i10;
        int width = bitmap.getWidth();
        int i11 = point.x;
        return i11 >= 0 && i11 < width && (i10 = point.y) >= 0 && i10 < bitmap.getHeight();
    }
}
