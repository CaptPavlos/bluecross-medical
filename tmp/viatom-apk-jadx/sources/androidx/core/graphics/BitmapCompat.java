package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.google.gson.internal.a;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class BitmapCompat {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @RequiresApi(27)
    public static class Api27Impl {
        private Api27Impl() {
        }

        @DoNotInline
        public static Bitmap copyBitmapIfHardware(Bitmap bitmap) {
            if (bitmap.getConfig() != Bitmap.Config.HARDWARE) {
                return bitmap;
            }
            Bitmap.Config hardwareBitmapConfig = Bitmap.Config.ARGB_8888;
            if (Build.VERSION.SDK_INT >= 31) {
                hardwareBitmapConfig = Api31Impl.getHardwareBitmapConfig(bitmap);
            }
            return bitmap.copy(hardwareBitmapConfig, true);
        }

        @DoNotInline
        public static Bitmap createBitmapWithSourceColorspace(int i10, int i11, Bitmap bitmap, boolean z9) {
            Bitmap.Config config = bitmap.getConfig();
            ColorSpace colorSpace = bitmap.getColorSpace();
            ColorSpace colorSpace2 = ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
            if (z9 && !bitmap.getColorSpace().equals(colorSpace2)) {
                config = Bitmap.Config.RGBA_F16;
                colorSpace = colorSpace2;
            } else if (bitmap.getConfig() == Bitmap.Config.HARDWARE) {
                config = Bitmap.Config.ARGB_8888;
                if (Build.VERSION.SDK_INT >= 31) {
                    config = Api31Impl.getHardwareBitmapConfig(bitmap);
                }
            }
            return Bitmap.createBitmap(i10, i11, config, bitmap.hasAlpha(), colorSpace);
        }

        @DoNotInline
        public static boolean isAlreadyF16AndLinear(Bitmap bitmap) {
            return bitmap.getConfig() == Bitmap.Config.RGBA_F16 && bitmap.getColorSpace().equals(ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB));
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static void setPaintBlendMode(Paint paint) {
            paint.setBlendMode(BlendMode.SRC);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @RequiresApi(31)
    public static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        public static Bitmap.Config getHardwareBitmapConfig(Bitmap bitmap) {
            return bitmap.getHardwareBuffer().getFormat() == 22 ? Bitmap.Config.RGBA_F16 : Bitmap.Config.ARGB_8888;
        }
    }

    private BitmapCompat() {
    }

    @NonNull
    public static Bitmap createScaledBitmap(@NonNull Bitmap bitmap, int i10, int i11, @Nullable Rect rect, boolean z9) {
        float f;
        int i12;
        double dFloor;
        Bitmap bitmapCreateBitmap;
        int i13;
        int i14;
        boolean z10;
        char c10;
        if (i10 <= 0 || i11 <= 0) {
            a.n("dstW and dstH must be > 0!");
            return null;
        }
        if (rect != null && (rect.isEmpty() || rect.left < 0 || rect.right > bitmap.getWidth() || rect.top < 0 || rect.bottom > bitmap.getHeight())) {
            a.n("srcRect must be contained by srcBm!");
            return null;
        }
        int i15 = Build.VERSION.SDK_INT;
        Bitmap bitmapCopyBitmapIfHardware = i15 >= 27 ? Api27Impl.copyBitmapIfHardware(bitmap) : bitmap;
        int iWidth = rect != null ? rect.width() : bitmap.getWidth();
        int iHeight = rect != null ? rect.height() : bitmap.getHeight();
        float f10 = i10 / iWidth;
        float f11 = i11 / iHeight;
        int i16 = rect != null ? rect.left : 0;
        int i17 = rect != null ? rect.top : 0;
        if (i16 == 0 && i17 == 0 && i10 == bitmap.getWidth() && i11 == bitmap.getHeight()) {
            return (bitmap.isMutable() && bitmap == bitmapCopyBitmapIfHardware) ? bitmap.copy(bitmap.getConfig(), true) : bitmapCopyBitmapIfHardware;
        }
        Paint paint = new Paint(1);
        paint.setFilterBitmap(true);
        if (i15 >= 29) {
            Api29Impl.setPaintBlendMode(paint);
        } else {
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        }
        if (iWidth == i10 && iHeight == i11) {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(i10, i11, bitmapCopyBitmapIfHardware.getConfig());
            new Canvas(bitmapCreateBitmap2).drawBitmap(bitmapCopyBitmapIfHardware, -i16, -i17, paint);
            return bitmapCreateBitmap2;
        }
        double dLog = Math.log(2.0d);
        if (f10 > 1.0f) {
            f = 1.0f;
            i12 = i16;
            dFloor = Math.ceil(Math.log(f10) / dLog);
        } else {
            f = 1.0f;
            i12 = i16;
            dFloor = Math.floor(Math.log(f10) / dLog);
        }
        int i18 = (int) dFloor;
        int iCeil = (int) (f11 > f ? Math.ceil(Math.log(f11) / dLog) : Math.floor(Math.log(f11) / dLog));
        if (!z9 || i15 < 27 || Api27Impl.isAlreadyF16AndLinear(bitmap)) {
            bitmapCreateBitmap = null;
            i13 = i12;
            i14 = 0;
        } else {
            Bitmap bitmapCreateBitmapWithSourceColorspace = Api27Impl.createBitmapWithSourceColorspace(i18 > 0 ? sizeAtStep(iWidth, i10, 1, i18) : iWidth, iCeil > 0 ? sizeAtStep(iHeight, i11, 1, iCeil) : iHeight, bitmap, true);
            new Canvas(bitmapCreateBitmapWithSourceColorspace).drawBitmap(bitmapCopyBitmapIfHardware, -i12, -i17, paint);
            Bitmap bitmap2 = bitmapCopyBitmapIfHardware;
            bitmapCopyBitmapIfHardware = bitmapCreateBitmapWithSourceColorspace;
            bitmapCreateBitmap = bitmap2;
            i14 = 1;
            i17 = 0;
            i13 = 0;
        }
        Rect rect2 = new Rect(i13, i17, iWidth, iHeight);
        Rect rect3 = new Rect();
        int i19 = i18;
        int i20 = iCeil;
        while (true) {
            if (i19 == 0 && i20 == 0) {
                break;
            }
            if (i19 < 0) {
                i19++;
            } else if (i19 > 0) {
                i19--;
            }
            if (i20 < 0) {
                i20++;
            } else if (i20 > 0) {
                i20--;
            }
            int i21 = i20;
            int i22 = i14;
            int i23 = i19;
            rect3.set(0, 0, sizeAtStep(iWidth, i10, i19, i18), sizeAtStep(iHeight, i11, i21, iCeil));
            boolean z11 = i23 == 0 && i21 == 0;
            boolean z12 = bitmapCreateBitmap != null && bitmapCreateBitmap.getWidth() == i10 && bitmapCreateBitmap.getHeight() == i11;
            if (bitmapCreateBitmap == null || bitmapCreateBitmap == bitmap) {
                z10 = z11;
            } else {
                if (z9) {
                    z10 = z11;
                    if (Build.VERSION.SDK_INT < 27 || Api27Impl.isAlreadyF16AndLinear(bitmapCreateBitmap)) {
                    }
                    new Canvas(bitmapCreateBitmap).drawBitmap(bitmapCopyBitmapIfHardware, rect2, rect3, paint);
                    rect2.set(rect3);
                    Bitmap bitmap3 = bitmapCopyBitmapIfHardware;
                    bitmapCopyBitmapIfHardware = bitmapCreateBitmap;
                    bitmapCreateBitmap = bitmap3;
                    i20 = i21;
                    i14 = i22;
                    i19 = i23;
                } else {
                    z10 = z11;
                }
                if (!z10 || (z12 && i22 == 0)) {
                    c10 = 27;
                }
                new Canvas(bitmapCreateBitmap).drawBitmap(bitmapCopyBitmapIfHardware, rect2, rect3, paint);
                rect2.set(rect3);
                Bitmap bitmap32 = bitmapCopyBitmapIfHardware;
                bitmapCopyBitmapIfHardware = bitmapCreateBitmap;
                bitmapCreateBitmap = bitmap32;
                i20 = i21;
                i14 = i22;
                i19 = i23;
            }
            if (bitmapCreateBitmap != bitmap && bitmapCreateBitmap != null) {
                bitmapCreateBitmap.recycle();
            }
            int iSizeAtStep = sizeAtStep(iWidth, i10, i23 > 0 ? i22 : i23, i18);
            int iSizeAtStep2 = sizeAtStep(iHeight, i11, i21 > 0 ? i22 : i21, iCeil);
            c10 = 27;
            if (Build.VERSION.SDK_INT >= 27) {
                bitmapCreateBitmap = Api27Impl.createBitmapWithSourceColorspace(iSizeAtStep, iSizeAtStep2, bitmap, z9 && !z10);
            } else {
                bitmapCreateBitmap = Bitmap.createBitmap(iSizeAtStep, iSizeAtStep2, bitmapCopyBitmapIfHardware.getConfig());
            }
            new Canvas(bitmapCreateBitmap).drawBitmap(bitmapCopyBitmapIfHardware, rect2, rect3, paint);
            rect2.set(rect3);
            Bitmap bitmap322 = bitmapCopyBitmapIfHardware;
            bitmapCopyBitmapIfHardware = bitmapCreateBitmap;
            bitmapCreateBitmap = bitmap322;
            i20 = i21;
            i14 = i22;
            i19 = i23;
        }
        if (bitmapCreateBitmap != bitmap && bitmapCreateBitmap != null) {
            bitmapCreateBitmap.recycle();
        }
        return bitmapCopyBitmapIfHardware;
    }

    public static int getAllocationByteCount(@NonNull Bitmap bitmap) {
        return bitmap.getAllocationByteCount();
    }

    public static boolean hasMipMap(@NonNull Bitmap bitmap) {
        return bitmap.hasMipMap();
    }

    public static void setHasMipMap(@NonNull Bitmap bitmap, boolean z9) {
        bitmap.setHasMipMap(z9);
    }

    @VisibleForTesting
    public static int sizeAtStep(int i10, int i11, int i12, int i13) {
        return i12 == 0 ? i11 : i12 > 0 ? i10 * (1 << (i13 - i12)) : i11 << ((-i12) - 1);
    }
}
