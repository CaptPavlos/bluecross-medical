package com.google.android.material.color.utilities;

import j$.util.function.Function$CC;
import java.util.function.Function;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2331a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2332b;

    public /* synthetic */ a(Object obj, int i10) {
        this.f2331a = i10;
        this.f2332b = obj;
    }

    public /* synthetic */ Function andThen(Function function) {
        int i10 = this.f2331a;
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f2331a) {
            case 0:
                return DynamicColor.lambda$fromArgb$0((TonalPalette) this.f2332b, (DynamicScheme) obj);
            case 1:
                return DynamicColor.lambda$fromArgb$1((Hct) this.f2332b, (DynamicScheme) obj);
            default:
                return ((TemperatureCache) this.f2332b).lambda$getHctsByTemp$0((Hct) obj);
        }
    }

    public /* synthetic */ Function compose(Function function) {
        int i10 = this.f2331a;
        return Function$CC.$default$compose(this, function);
    }
}
