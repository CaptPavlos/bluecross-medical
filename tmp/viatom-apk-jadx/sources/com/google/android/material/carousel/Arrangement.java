package com.google.android.material.carousel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public final class Arrangement {
    private static final float MEDIUM_ITEM_FLEX_PERCENTAGE = 0.1f;
    final float cost;
    final int largeCount;
    float largeSize;
    int mediumCount;
    float mediumSize;
    final int priority;
    int smallCount;
    float smallSize;

    public Arrangement(int i10, float f, float f10, float f11, int i11, float f12, int i12, float f13, int i13, float f14) {
        this.priority = i10;
        this.smallSize = MathUtils.clamp(f, f10, f11);
        this.smallCount = i11;
        this.mediumSize = f12;
        this.mediumCount = i12;
        this.largeSize = f13;
        this.largeCount = i13;
        fit(f14, f10, f11, f13);
        this.cost = cost(f13);
    }

    private float calculateLargeSize(float f, int i10, float f10, int i11, int i12) {
        if (i10 <= 0) {
            f10 = 0.0f;
        }
        float f11 = i11 / 2.0f;
        return (f - ((i10 + f11) * f10)) / (i12 + f11);
    }

    private float cost(float f) {
        if (isValid()) {
            return Math.abs(f - this.largeSize) * this.priority;
        }
        return Float.MAX_VALUE;
    }

    @Nullable
    public static Arrangement findLowestCostArrangement(float f, float f10, float f11, float f12, @NonNull int[] iArr, float f13, @NonNull int[] iArr2, float f14, @NonNull int[] iArr3) {
        Arrangement arrangement = null;
        int i10 = 1;
        for (int i11 : iArr3) {
            int length = iArr2.length;
            int i12 = 0;
            while (i12 < length) {
                int i13 = iArr2[i12];
                int length2 = iArr.length;
                int i14 = 0;
                while (i14 < length2) {
                    int i15 = length;
                    int i16 = i12;
                    int i17 = i10;
                    int i18 = length2;
                    int i19 = i14;
                    Arrangement arrangement2 = new Arrangement(i17, f10, f11, f12, iArr[i14], f13, i13, f14, i11, f);
                    if (arrangement == null || arrangement2.cost < arrangement.cost) {
                        if (arrangement2.cost == 0.0f) {
                            return arrangement2;
                        }
                        arrangement = arrangement2;
                    }
                    int i20 = i17 + 1;
                    i14 = i19 + 1;
                    i12 = i16;
                    i10 = i20;
                    length = i15;
                    length2 = i18;
                }
                i12++;
                i10 = i10;
                length = length;
            }
        }
        return arrangement;
    }

    private void fit(float f, float f10, float f11, float f12) {
        float space = f - getSpace();
        int i10 = this.smallCount;
        if (i10 > 0 && space > 0.0f) {
            float f13 = this.smallSize;
            this.smallSize = Math.min(space / i10, f11 - f13) + f13;
        } else if (i10 > 0 && space < 0.0f) {
            float f14 = this.smallSize;
            this.smallSize = Math.max(space / i10, f10 - f14) + f14;
        }
        int i11 = this.smallCount;
        float f15 = i11 > 0 ? this.smallSize : 0.0f;
        this.smallSize = f15;
        float fCalculateLargeSize = calculateLargeSize(f, i11, f15, this.mediumCount, this.largeCount);
        this.largeSize = fCalculateLargeSize;
        float f16 = (this.smallSize + fCalculateLargeSize) / 2.0f;
        this.mediumSize = f16;
        int i12 = this.mediumCount;
        if (i12 <= 0 || fCalculateLargeSize == f12) {
            return;
        }
        float f17 = (f12 - fCalculateLargeSize) * this.largeCount;
        float fMin = Math.min(Math.abs(f17), f16 * 0.1f * i12);
        float f18 = this.mediumSize;
        if (f17 > 0.0f) {
            this.mediumSize = f18 - (fMin / this.mediumCount);
            this.largeSize = (fMin / this.largeCount) + this.largeSize;
        } else {
            this.mediumSize = (fMin / this.mediumCount) + f18;
            this.largeSize -= fMin / this.largeCount;
        }
    }

    private float getSpace() {
        return (this.smallSize * this.smallCount) + (this.mediumSize * this.mediumCount) + (this.largeSize * this.largeCount);
    }

    private boolean isValid() {
        int i10 = this.largeCount;
        if (i10 <= 0 || this.smallCount <= 0 || this.mediumCount <= 0) {
            return i10 <= 0 || this.smallCount <= 0 || this.largeSize > this.smallSize;
        }
        float f = this.largeSize;
        float f10 = this.mediumSize;
        return f > f10 && f10 > this.smallSize;
    }

    public int getItemCount() {
        return this.smallCount + this.mediumCount + this.largeCount;
    }

    @NonNull
    public String toString() {
        return "Arrangement [priority=" + this.priority + ", smallCount=" + this.smallCount + ", smallSize=" + this.smallSize + ", mediumCount=" + this.mediumCount + ", mediumSize=" + this.mediumSize + ", largeCount=" + this.largeCount + ", largeSize=" + this.largeSize + ", cost=" + this.cost + "]";
    }
}
