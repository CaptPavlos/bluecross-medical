package com.mbridge.msdk.newreward.function.c.c;

import android.text.TextUtils;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e extends b {

    /* renamed from: b, reason: collision with root package name */
    private final s f4721b;

    public e(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.function.c.a.a aVar) {
        super(bVar, aVar);
        this.f4721b = new s(b(), c(), this);
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.o
    public final int b_() {
        return 3;
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.o
    public final String j() {
        return (b() == null || TextUtils.isEmpty(b().B())) ? "" : b().B();
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.o
    public final q l() {
        return this.f4721b;
    }
}
