package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a6 extends h {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1875c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a6(String str, int i10) {
        super(str);
        this.f1875c = i10;
    }

    @Override // com.google.android.gms.internal.measurement.h
    public final n a(w2.r rVar, List list) {
        switch (this.f1875c) {
            case 0:
                return n.f2091a0;
            case 1:
            case 2:
                return this;
            case 3:
                return new g(Double.valueOf(0.0d));
            default:
                return n.f2091a0;
        }
    }
}
