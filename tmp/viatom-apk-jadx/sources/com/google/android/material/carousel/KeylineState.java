package com.google.android.material.carousel;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.window.layout.c;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.utilities.Contrast;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public final class KeylineState {
    private final int carouselSize;
    private final int firstFocalKeylineIndex;
    private final float itemSize;
    private final List<Keyline> keylines;
    private final int lastFocalKeylineIndex;
    private int totalVisibleFocalItems;

    private KeylineState(float f, List<Keyline> list, int i10, int i11, int i12) {
        this.itemSize = f;
        this.keylines = DesugarCollections.unmodifiableList(list);
        this.firstFocalKeylineIndex = i10;
        this.lastFocalKeylineIndex = i11;
        while (i10 <= i11) {
            if (list.get(i10).cutoff == 0.0f) {
                this.totalVisibleFocalItems++;
            }
            i10++;
        }
        this.carouselSize = i12;
    }

    public static KeylineState lerp(KeylineState keylineState, KeylineState keylineState2, float f) {
        if (keylineState.getItemSize() != keylineState2.getItemSize()) {
            com.google.gson.internal.a.n("Keylines being linearly interpolated must have the same item size.");
            return null;
        }
        List<Keyline> keylines = keylineState.getKeylines();
        List<Keyline> keylines2 = keylineState2.getKeylines();
        if (keylines.size() != keylines2.size()) {
            com.google.gson.internal.a.n("Keylines being linearly interpolated must have the same number of keylines.");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < keylineState.getKeylines().size(); i10++) {
            arrayList.add(Keyline.lerp(keylines.get(i10), keylines2.get(i10), f));
        }
        return new KeylineState(keylineState.getItemSize(), arrayList, AnimationUtils.lerp(keylineState.getFirstFocalKeylineIndex(), keylineState2.getFirstFocalKeylineIndex(), f), AnimationUtils.lerp(keylineState.getLastFocalKeylineIndex(), keylineState2.getLastFocalKeylineIndex(), f), keylineState.carouselSize);
    }

    public static KeylineState reverse(KeylineState keylineState, int i10) {
        Builder builder = new Builder(keylineState.getItemSize(), i10);
        float f = (i10 - keylineState.getLastKeyline().locOffset) - (keylineState.getLastKeyline().maskedItemSize / 2.0f);
        int size = keylineState.getKeylines().size() - 1;
        while (size >= 0) {
            Keyline keyline = keylineState.getKeylines().get(size);
            builder.addKeyline((keyline.maskedItemSize / 2.0f) + f, keyline.mask, keyline.maskedItemSize, size >= keylineState.getFirstFocalKeylineIndex() && size <= keylineState.getLastFocalKeylineIndex(), keyline.isAnchor);
            f += keyline.maskedItemSize;
            size--;
        }
        return builder.build();
    }

    public int getCarouselSize() {
        return this.carouselSize;
    }

    public Keyline getFirstFocalKeyline() {
        return this.keylines.get(this.firstFocalKeylineIndex);
    }

    public int getFirstFocalKeylineIndex() {
        return this.firstFocalKeylineIndex;
    }

    public Keyline getFirstKeyline() {
        return this.keylines.get(0);
    }

    @Nullable
    public Keyline getFirstNonAnchorKeyline() {
        for (int i10 = 0; i10 < this.keylines.size(); i10++) {
            Keyline keyline = this.keylines.get(i10);
            if (!keyline.isAnchor) {
                return keyline;
            }
        }
        return null;
    }

    public List<Keyline> getFocalKeylines() {
        return this.keylines.subList(this.firstFocalKeylineIndex, this.lastFocalKeylineIndex + 1);
    }

    public float getItemSize() {
        return this.itemSize;
    }

    public List<Keyline> getKeylines() {
        return this.keylines;
    }

    public Keyline getLastFocalKeyline() {
        return this.keylines.get(this.lastFocalKeylineIndex);
    }

    public int getLastFocalKeylineIndex() {
        return this.lastFocalKeylineIndex;
    }

    public Keyline getLastKeyline() {
        return (Keyline) a3.a.e(1, this.keylines);
    }

    @Nullable
    public Keyline getLastNonAnchorKeyline() {
        for (int size = this.keylines.size() - 1; size >= 0; size--) {
            Keyline keyline = this.keylines.get(size);
            if (!keyline.isAnchor) {
                return keyline;
            }
        }
        return null;
    }

    public int getNumberOfNonAnchorKeylines() {
        Iterator<Keyline> it = this.keylines.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (it.next().isAnchor) {
                i10++;
            }
        }
        return this.keylines.size() - i10;
    }

    public int getTotalVisibleFocalItems() {
        return this.totalVisibleFocalItems;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Keyline {
        final float cutoff;
        final boolean isAnchor;
        final float leftOrTopPaddingShift;
        final float loc;
        final float locOffset;
        final float mask;
        final float maskedItemSize;
        final float rightOrBottomPaddingShift;

        public Keyline(float f, float f10, float f11, float f12, boolean z9, float f13, float f14, float f15) {
            this.loc = f;
            this.locOffset = f10;
            this.mask = f11;
            this.maskedItemSize = f12;
            this.isAnchor = z9;
            this.cutoff = f13;
            this.leftOrTopPaddingShift = f14;
            this.rightOrBottomPaddingShift = f15;
        }

        public static Keyline lerp(Keyline keyline, Keyline keyline2, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f) {
            return new Keyline(AnimationUtils.lerp(keyline.loc, keyline2.loc, f), AnimationUtils.lerp(keyline.locOffset, keyline2.locOffset, f), AnimationUtils.lerp(keyline.mask, keyline2.mask, f), AnimationUtils.lerp(keyline.maskedItemSize, keyline2.maskedItemSize, f));
        }

        public Keyline(float f, float f10, float f11, float f12) {
            this(f, f10, f11, f12, false, 0.0f, 0.0f, 0.0f);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Builder {
        private static final int NO_INDEX = -1;
        private static final float UNKNOWN_LOC = Float.MIN_VALUE;
        private final int carouselSize;
        private final float itemSize;
        private Keyline tmpFirstFocalKeyline;
        private Keyline tmpLastFocalKeyline;
        private final List<Keyline> tmpKeylines = new ArrayList();
        private int firstFocalKeylineIndex = -1;
        private int lastFocalKeylineIndex = -1;
        private float lastKeylineMaskedSize = 0.0f;
        private int latestAnchorKeylineIndex = -1;

        public Builder(float f, int i10) {
            this.itemSize = f;
            this.carouselSize = i10;
        }

        private static float calculateKeylineLocationForItemPosition(float f, float f10, int i10, int i11) {
            return (i11 * f10) + (f - (i10 * f10));
        }

        @NonNull
        public Builder addAnchorKeyline(float f, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10, float f11) {
            return addKeyline(f, f10, f11, false, true);
        }

        @NonNull
        public Builder addKeyline(float f, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10, float f11, boolean z9, boolean z10, float f12, float f13, float f14) {
            if (f11 <= 0.0f) {
                return this;
            }
            if (z10) {
                if (z9) {
                    com.google.gson.internal.a.n("Anchor keylines cannot be focal.");
                    return null;
                }
                int i10 = this.latestAnchorKeylineIndex;
                if (i10 != -1 && i10 != 0) {
                    com.google.gson.internal.a.n("Anchor keylines must be either the first or last keyline.");
                    return null;
                }
                this.latestAnchorKeylineIndex = this.tmpKeylines.size();
            }
            Keyline keyline = new Keyline(Float.MIN_VALUE, f, f10, f11, z10, f12, f13, f14);
            Keyline keyline2 = this.tmpFirstFocalKeyline;
            if (z9) {
                if (keyline2 == null) {
                    this.tmpFirstFocalKeyline = keyline;
                    this.firstFocalKeylineIndex = this.tmpKeylines.size();
                }
                if (this.lastFocalKeylineIndex != -1 && this.tmpKeylines.size() - this.lastFocalKeylineIndex > 1) {
                    com.google.gson.internal.a.n("Keylines marked as focal must be placed next to each other. There cannot be non-focal keylines between focal keylines.");
                    return null;
                }
                if (f11 != this.tmpFirstFocalKeyline.maskedItemSize) {
                    com.google.gson.internal.a.n("Keylines that are marked as focal must all have the same masked item size.");
                    return null;
                }
                this.tmpLastFocalKeyline = keyline;
                this.lastFocalKeylineIndex = this.tmpKeylines.size();
            } else {
                if (keyline2 == null && keyline.maskedItemSize < this.lastKeylineMaskedSize) {
                    com.google.gson.internal.a.n("Keylines before the first focal keyline must be ordered by incrementing masked item size.");
                    return null;
                }
                if (this.tmpLastFocalKeyline != null && keyline.maskedItemSize > this.lastKeylineMaskedSize) {
                    com.google.gson.internal.a.n("Keylines after the last focal keyline must be ordered by decreasing masked item size.");
                    return null;
                }
            }
            this.lastKeylineMaskedSize = keyline.maskedItemSize;
            this.tmpKeylines.add(keyline);
            return this;
        }

        @NonNull
        public Builder addKeylineRange(float f, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10, float f11, int i10, boolean z9) {
            if (i10 > 0 && f11 > 0.0f) {
                for (int i11 = 0; i11 < i10; i11++) {
                    addKeyline((i11 * f11) + f, f10, f11, z9);
                }
            }
            return this;
        }

        @NonNull
        public KeylineState build() {
            if (this.tmpFirstFocalKeyline == null) {
                c.g("There must be a keyline marked as focal.");
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < this.tmpKeylines.size(); i10++) {
                Keyline keyline = this.tmpKeylines.get(i10);
                arrayList.add(new Keyline(calculateKeylineLocationForItemPosition(this.tmpFirstFocalKeyline.locOffset, this.itemSize, this.firstFocalKeylineIndex, i10), keyline.locOffset, keyline.mask, keyline.maskedItemSize, keyline.isAnchor, keyline.cutoff, keyline.leftOrTopPaddingShift, keyline.rightOrBottomPaddingShift));
            }
            return new KeylineState(this.itemSize, arrayList, this.firstFocalKeylineIndex, this.lastFocalKeylineIndex, this.carouselSize);
        }

        @NonNull
        public Builder addKeylineRange(float f, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10, float f11, int i10) {
            return addKeylineRange(f, f10, f11, i10, false);
        }

        @NonNull
        public Builder addKeyline(float f, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10, float f11) {
            return addKeyline(f, f10, f11, false);
        }

        @NonNull
        public Builder addKeyline(float f, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10, float f11, boolean z9) {
            return addKeyline(f, f10, f11, z9, false);
        }

        @NonNull
        public Builder addKeyline(float f, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10, float f11, boolean z9, boolean z10, float f12) {
            return addKeyline(f, f10, f11, z9, z10, f12, 0.0f, 0.0f);
        }

        @NonNull
        public Builder addKeyline(float f, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10, float f11, boolean z9, boolean z10) {
            float fAbs;
            float f12 = f11 / 2.0f;
            float f13 = f - f12;
            float f14 = f12 + f;
            int i10 = this.carouselSize;
            if (f14 > i10) {
                fAbs = Math.abs(f14 - Math.max(f14 - f11, i10));
            } else {
                fAbs = 0.0f;
                if (f13 < 0.0f) {
                    fAbs = Math.abs(f13 - Math.min(f13 + f11, 0.0f));
                }
            }
            return addKeyline(f, f10, f11, z9, z10, fAbs);
        }
    }
}
