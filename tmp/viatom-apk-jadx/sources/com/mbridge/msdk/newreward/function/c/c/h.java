package com.mbridge.msdk.newreward.function.c.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h extends c {
    public h(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.function.c.a.a aVar) {
        super(bVar, aVar);
        b(true);
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.c
    public final boolean a_() {
        return true;
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.o
    public final int b_() {
        return 8;
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.o
    public final String j() {
        return (c() == null || c().h() == null) ? "" : c().h().getEndScreenUrl();
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.o
    public final q l() {
        return new v(b(), c(), this);
    }
}
