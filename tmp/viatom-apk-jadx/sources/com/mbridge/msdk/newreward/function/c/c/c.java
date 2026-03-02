package com.mbridge.msdk.newreward.function.c.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class c extends d<String> {

    /* renamed from: b, reason: collision with root package name */
    protected Boolean f4719b;

    /* renamed from: c, reason: collision with root package name */
    private String f4720c;

    public c(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.function.c.a.a aVar) {
        super(bVar, aVar);
        this.f4719b = null;
    }

    public final void a(String str) {
        this.f4720c = str;
    }

    public abstract boolean a_();

    @Override // com.mbridge.msdk.newreward.function.c.c.d
    public final boolean g() {
        return false;
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.o
    public final boolean h() {
        Boolean bool = this.f4719b;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean zA_ = a_();
        this.f4719b = Boolean.valueOf(zA_);
        return zA_;
    }

    public final String i() {
        return this.f4720c;
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.a
    public final /* bridge */ /* synthetic */ Object a() {
        return this.f4720c;
    }
}
