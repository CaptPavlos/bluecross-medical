package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public final class CorePalette {

    /* renamed from: a1, reason: collision with root package name */
    public TonalPalette f2318a1;

    /* renamed from: a2, reason: collision with root package name */
    public TonalPalette f2319a2;

    /* renamed from: a3, reason: collision with root package name */
    public TonalPalette f2320a3;
    public TonalPalette error;

    /* renamed from: n1, reason: collision with root package name */
    public TonalPalette f2321n1;

    /* renamed from: n2, reason: collision with root package name */
    public TonalPalette f2322n2;

    private CorePalette(int i10, boolean z9) {
        Hct hctFromInt = Hct.fromInt(i10);
        double hue = hctFromInt.getHue();
        double chroma = hctFromInt.getChroma();
        if (z9) {
            this.f2318a1 = TonalPalette.fromHueAndChroma(hue, chroma);
            this.f2319a2 = TonalPalette.fromHueAndChroma(hue, chroma / 3.0d);
            this.f2320a3 = TonalPalette.fromHueAndChroma(60.0d + hue, chroma / 2.0d);
            this.f2321n1 = TonalPalette.fromHueAndChroma(hue, Math.min(chroma / 12.0d, 4.0d));
            this.f2322n2 = TonalPalette.fromHueAndChroma(hue, Math.min(chroma / 6.0d, 8.0d));
        } else {
            this.f2318a1 = TonalPalette.fromHueAndChroma(hue, Math.max(48.0d, chroma));
            this.f2319a2 = TonalPalette.fromHueAndChroma(hue, 16.0d);
            this.f2320a3 = TonalPalette.fromHueAndChroma(60.0d + hue, 24.0d);
            this.f2321n1 = TonalPalette.fromHueAndChroma(hue, 4.0d);
            this.f2322n2 = TonalPalette.fromHueAndChroma(hue, 8.0d);
        }
        this.error = TonalPalette.fromHueAndChroma(25.0d, 84.0d);
    }

    public static CorePalette contentOf(int i10) {
        return new CorePalette(i10, true);
    }

    public static CorePalette of(int i10) {
        return new CorePalette(i10, false);
    }
}
