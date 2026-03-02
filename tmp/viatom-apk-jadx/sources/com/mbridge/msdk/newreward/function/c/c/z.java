package com.mbridge.msdk.newreward.function.c.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class z extends q {

    /* renamed from: a, reason: collision with root package name */
    private final com.mbridge.msdk.newreward.function.c.a.b f4754a;

    /* renamed from: b, reason: collision with root package name */
    private final com.mbridge.msdk.newreward.function.c.a.a f4755b;

    /* renamed from: c, reason: collision with root package name */
    private final c f4756c;

    public z(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.function.c.a.a aVar, c cVar) {
        this.f4754a = bVar;
        this.f4755b = aVar;
        this.f4756c = cVar;
        cVar.b(true);
        cVar.a(false);
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.p
    public final void a(int i10, x xVar) {
        if (xVar != null) {
            xVar.a(this.f4754a, this.f4755b, this);
            xVar.b(this.f4754a, this.f4755b, this);
        }
    }
}
