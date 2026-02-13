package com.mbridge.msdk.newreward.function.c.c;

import android.text.TextUtils;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class a<Resource> implements o {

    /* renamed from: b, reason: collision with root package name */
    private final com.mbridge.msdk.newreward.function.c.a.b f4715b;

    /* renamed from: c, reason: collision with root package name */
    private final com.mbridge.msdk.newreward.function.c.a.a f4716c;

    /* renamed from: d, reason: collision with root package name */
    private int f4717d = 0;
    private boolean e = false;
    private boolean f = false;

    /* renamed from: a, reason: collision with root package name */
    protected boolean f4714a = false;

    public a(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.function.c.a.a aVar) {
        this.f4715b = bVar;
        this.f4716c = aVar;
    }

    public abstract Resource a();

    public final void a(boolean z9) {
        this.f4714a = z9;
    }

    public final com.mbridge.msdk.newreward.function.c.a.b b() {
        return this.f4715b;
    }

    public final com.mbridge.msdk.newreward.function.c.a.a c() {
        return this.f4716c;
    }

    public boolean d() {
        return TextUtils.isEmpty(j()) || h() || this.e;
    }

    public boolean e() {
        return TextUtils.isEmpty(j()) || k() || this.f;
    }

    public final int f() {
        return this.f4717d;
    }

    public final void a(int i10) {
        this.f4717d = i10;
    }

    public final void b(boolean z9) {
        this.e = z9;
    }
}
