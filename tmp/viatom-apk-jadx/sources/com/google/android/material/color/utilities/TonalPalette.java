package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public final class TonalPalette {
    Map<Integer, Integer> cache = new HashMap();
    double chroma;
    double hue;
    Hct keyColor;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class KeyColor {
        private static final double MAX_CHROMA_VALUE = 200.0d;
        private final Map<Integer, Double> chromaCache = new HashMap();
        private final double hue;
        private final double requestedChroma;

        public KeyColor(double d8, double d10) {
            this.hue = d8;
            this.requestedChroma = d10;
        }

        private double maxChroma(int i10) {
            if (this.chromaCache.get(Integer.valueOf(i10)) == null) {
                this.chromaCache.put(Integer.valueOf(i10), Double.valueOf(Hct.from(this.hue, MAX_CHROMA_VALUE, i10).getChroma()));
            }
            return this.chromaCache.get(Integer.valueOf(i10)).doubleValue();
        }

        public Hct create() {
            int i10 = 100;
            int i11 = 0;
            while (i11 < i10) {
                int i12 = (i11 + i10) / 2;
                int i13 = i12 + 1;
                boolean z9 = maxChroma(i12) < maxChroma(i13);
                if (maxChroma(i12) >= this.requestedChroma - 0.01d) {
                    if (Math.abs(i11 - 50) < Math.abs(i10 - 50)) {
                        i10 = i12;
                    } else {
                        if (i11 == i12) {
                            return Hct.from(this.hue, this.requestedChroma, i11);
                        }
                        i11 = i12;
                    }
                } else if (z9) {
                    i11 = i13;
                } else {
                    i10 = i12;
                }
            }
            return Hct.from(this.hue, this.requestedChroma, i11);
        }
    }

    private TonalPalette(double d8, double d10, Hct hct) {
        this.hue = d8;
        this.chroma = d10;
        this.keyColor = hct;
    }

    public static TonalPalette fromHct(Hct hct) {
        return new TonalPalette(hct.getHue(), hct.getChroma(), hct);
    }

    public static TonalPalette fromHueAndChroma(double d8, double d10) {
        return new TonalPalette(d8, d10, new KeyColor(d8, d10).create());
    }

    public static TonalPalette fromInt(int i10) {
        return fromHct(Hct.fromInt(i10));
    }

    public double getChroma() {
        return this.chroma;
    }

    public Hct getHct(double d8) {
        return Hct.from(this.hue, this.chroma, d8);
    }

    public double getHue() {
        return this.hue;
    }

    public Hct getKeyColor() {
        return this.keyColor;
    }

    public int tone(int i10) {
        Integer numValueOf = this.cache.get(Integer.valueOf(i10));
        if (numValueOf == null) {
            numValueOf = Integer.valueOf(Hct.from(this.hue, this.chroma, i10).toInt());
            this.cache.put(Integer.valueOf(i10), numValueOf);
        }
        return numValueOf.intValue();
    }
}
