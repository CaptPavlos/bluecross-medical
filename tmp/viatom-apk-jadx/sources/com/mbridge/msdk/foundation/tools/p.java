package com.mbridge.msdk.foundation.tools;

import android.graphics.Bitmap;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Array;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public static int f4025a = 2048;

    public static Bitmap a(Bitmap bitmap, int i10) {
        boolean z9;
        int i11;
        int i12;
        int i13 = i10 <= 0 ? 10 : i10;
        int width = bitmap.getWidth() / i13;
        int height = bitmap.getHeight() / i13;
        int i14 = 0;
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, false);
        int width2 = bitmapCreateScaledBitmap.getWidth();
        int height2 = bitmapCreateScaledBitmap.getHeight();
        int i15 = width2 * height2;
        int[] iArr = new int[i15];
        bitmapCreateScaledBitmap.getPixels(iArr, 0, width2, 0, 0, width2, height2);
        int i16 = width2 - 1;
        int i17 = height2 - 1;
        int[] iArr2 = new int[i15];
        int[] iArr3 = new int[i15];
        int[] iArr4 = new int[i15];
        int[] iArr5 = new int[Math.max(width2, height2)];
        int[] iArr6 = new int[20736];
        for (int i18 = 0; i18 < 20736; i18++) {
            iArr6[i18] = i18 / 81;
        }
        boolean z10 = true;
        char c10 = 17;
        int[][] iArr7 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 17, 3);
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        while (true) {
            z9 = z10;
            int i22 = 8;
            if (i19 >= height2) {
                break;
            }
            int i23 = i14;
            int i24 = i23;
            int i25 = i24;
            int i26 = i25;
            int i27 = i26;
            int i28 = i27;
            int i29 = i28;
            int i30 = i29;
            char c11 = c10;
            int i31 = -8;
            int i32 = i30;
            while (i31 <= i22) {
                int i33 = i22;
                int i34 = iArr[Math.min(i16, Math.max(i31, i14)) + i20];
                int[] iArr8 = iArr7[i31 + 8];
                iArr8[i14] = (i34 & 16711680) >> 16;
                iArr8[z9 ? 1 : 0] = (i34 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr8[2] = i34 & 255;
                int iAbs = 9 - Math.abs(i31);
                int i35 = iArr8[i14];
                i32 = (i35 * iAbs) + i32;
                int i36 = iArr8[z9 ? 1 : 0];
                i23 = (i36 * iAbs) + i23;
                int i37 = iArr8[2];
                i24 = (iAbs * i37) + i24;
                if (i31 > 0) {
                    i28 += i35;
                    i29 += i36;
                    i30 += i37;
                } else {
                    i25 += i35;
                    i26 += i36;
                    i27 += i37;
                }
                i31++;
                i22 = i33;
            }
            int i38 = i14;
            while (i38 < width2) {
                iArr2[i20] = iArr6[i32];
                iArr3[i20] = iArr6[i23];
                iArr4[i20] = iArr6[i24];
                int i39 = i32 - i25;
                int i40 = i23 - i26;
                int i41 = i24 - i27;
                int[] iArr9 = iArr7[(i22 + 9) % 17];
                int i42 = i25 - iArr9[i14];
                int i43 = i26 - iArr9[z9 ? 1 : 0];
                int i44 = i27 - iArr9[2];
                if (i19 == 0) {
                    i12 = i14;
                    iArr5[i38] = Math.min(i38 + 9, i16);
                } else {
                    i12 = i14;
                }
                int i45 = iArr[i21 + iArr5[i38]];
                int i46 = (i45 & 16711680) >> 16;
                iArr9[i12] = i46;
                int i47 = (i45 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr9[z9 ? 1 : 0] = i47;
                int i48 = i45 & 255;
                iArr9[2] = i48;
                int i49 = i28 + i46;
                int i50 = i29 + i47;
                int i51 = i30 + i48;
                i32 = i39 + i49;
                i23 = i40 + i50;
                i24 = i41 + i51;
                i22 = (i22 + 1) % 17;
                int[] iArr10 = iArr7[i22 % 17];
                int i52 = iArr10[i12];
                i25 = i42 + i52;
                int i53 = iArr10[z9 ? 1 : 0];
                i26 = i43 + i53;
                int i54 = iArr10[2];
                i27 = i44 + i54;
                i28 = i49 - i52;
                i29 = i50 - i53;
                i30 = i51 - i54;
                i20++;
                i38++;
                i14 = i12;
            }
            i21 += width2;
            i19++;
            z10 = z9 ? 1 : 0;
            c10 = c11;
        }
        int i55 = i14;
        int i56 = 8;
        while (i14 < width2) {
            int i57 = (-8) * width2;
            int i58 = i14;
            int[] iArr11 = iArr4;
            int i59 = -8;
            int i60 = i56;
            int i61 = i55;
            int i62 = i61;
            int i63 = i62;
            int i64 = i63;
            int i65 = i64;
            int i66 = i65;
            int i67 = i66;
            int i68 = i67;
            int i69 = i68;
            while (i59 <= i60) {
                int i70 = i55;
                int iMax = Math.max(i70, i57) + i58;
                int[] iArr12 = iArr7[i59 + 8];
                iArr12[i70] = iArr2[iMax];
                iArr12[z9 ? 1 : 0] = iArr3[iMax];
                iArr12[2] = iArr11[iMax];
                int iAbs2 = 9 - Math.abs(i59);
                i61 = (iArr2[iMax] * iAbs2) + i61;
                i62 = (iArr3[iMax] * iAbs2) + i62;
                i63 = (iArr11[iMax] * iAbs2) + i63;
                if (i59 > 0) {
                    i67 += iArr12[0];
                    i68 += iArr12[z9 ? 1 : 0];
                    i69 += iArr12[2];
                } else {
                    i64 += iArr12[0];
                    i65 += iArr12[z9 ? 1 : 0];
                    i66 += iArr12[2];
                }
                if (i59 < i17) {
                    i57 += width2;
                }
                i59++;
                i60 = 8;
                i55 = 0;
            }
            int i71 = i58;
            int i72 = 8;
            for (int i73 = 0; i73 < height2; i73++) {
                iArr[i71] = (iArr[i71] & ViewCompat.MEASURED_STATE_MASK) | (iArr6[i61] << 16) | (iArr6[i62] << 8) | iArr6[i63];
                int i74 = i61 - i64;
                int i75 = i62 - i65;
                int i76 = i63 - i66;
                int[] iArr13 = iArr7[(i72 + 9) % 17];
                int i77 = i64 - iArr13[0];
                int i78 = i65 - iArr13[z9 ? 1 : 0];
                int i79 = i66 - iArr13[2];
                if (i58 == 0) {
                    i11 = i72;
                    iArr5[i73] = Math.min(i73 + 9, i17) * width2;
                } else {
                    i11 = i72;
                }
                int i80 = i58 + iArr5[i73];
                int i81 = iArr2[i80];
                iArr13[0] = i81;
                int i82 = iArr3[i80];
                iArr13[z9 ? 1 : 0] = i82;
                int i83 = iArr11[i80];
                iArr13[2] = i83;
                int i84 = i67 + i81;
                int i85 = i68 + i82;
                int i86 = i69 + i83;
                i61 = i74 + i84;
                i62 = i75 + i85;
                i63 = i76 + i86;
                i72 = (i11 + 1) % 17;
                int[] iArr14 = iArr7[i72];
                int i87 = iArr14[0];
                i64 = i77 + i87;
                int i88 = iArr14[z9 ? 1 : 0];
                i65 = i78 + i88;
                int i89 = iArr14[2];
                i66 = i79 + i89;
                i67 = i84 - i87;
                i68 = i85 - i88;
                i69 = i86 - i89;
                i71 += width2;
            }
            i56 = 8;
            i55 = 0;
            i14 = i58 + 1;
            iArr4 = iArr11;
        }
        bitmapCreateScaledBitmap.setPixels(iArr, 0, width2, 0, 0, width2, height2);
        return bitmapCreateScaledBitmap;
    }
}
