package com.google.android.material.color.utilities;

import j$.util.function.Function$CC;
import java.util.function.Function;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class g implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2339a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MaterialDynamicColors f2340b;

    public /* synthetic */ g(MaterialDynamicColors materialDynamicColors, int i10) {
        this.f2339a = i10;
        this.f2340b = materialDynamicColors;
    }

    public /* synthetic */ Function andThen(Function function) {
        int i10 = this.f2339a;
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f2339a) {
            case 0:
                return this.f2340b.lambda$secondaryFixed$119((DynamicScheme) obj);
            case 1:
                return this.f2340b.lambda$onPrimaryFixedVariant$115((DynamicScheme) obj);
            case 2:
                return this.f2340b.lambda$onPrimaryFixedVariant$116((DynamicScheme) obj);
            case 3:
                return this.f2340b.lambda$tertiaryFixedDim$136((DynamicScheme) obj);
            case 4:
                return this.f2340b.lambda$onTertiary$84((DynamicScheme) obj);
            case 5:
                return this.f2340b.lambda$onError$96((DynamicScheme) obj);
            case 6:
                return this.f2340b.lambda$onPrimaryContainer$62((DynamicScheme) obj);
            case 7:
                return this.f2340b.lambda$onPrimaryContainer$63((DynamicScheme) obj);
            case 8:
                return this.f2340b.lambda$secondaryFixedDim$122((DynamicScheme) obj);
            case 9:
                return this.f2340b.lambda$primaryFixed$105((DynamicScheme) obj);
            case 10:
                return this.f2340b.lambda$primaryFixedDim$108((DynamicScheme) obj);
            case 11:
                return this.f2340b.lambda$tertiaryContainer$86((DynamicScheme) obj);
            case 12:
                return this.f2340b.lambda$tertiaryContainer$87((DynamicScheme) obj);
            default:
                return this.f2340b.highestSurface((DynamicScheme) obj);
        }
    }

    public /* synthetic */ Function compose(Function function) {
        int i10 = this.f2339a;
        return Function$CC.$default$compose(this, function);
    }
}
