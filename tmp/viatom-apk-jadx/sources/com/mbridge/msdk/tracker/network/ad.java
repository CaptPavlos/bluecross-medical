package com.mbridge.msdk.tracker.network;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class ad extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public final r f5383a;

    /* renamed from: b, reason: collision with root package name */
    private long f5384b;

    /* renamed from: c, reason: collision with root package name */
    private int f5385c;

    /* renamed from: d, reason: collision with root package name */
    private String f5386d;

    public ad() {
        this.f5385c = 0;
        this.f5386d = "";
        this.f5383a = null;
    }

    public abstract int a();

    public final void a(long j10) {
        this.f5384b = j10;
    }

    public final int b() {
        return this.f5385c;
    }

    public final String c() {
        return this.f5386d;
    }

    public final void a(int i10) {
        this.f5385c = i10;
    }

    public final void a(String str) {
        this.f5386d = str;
    }

    public ad(r rVar) {
        this.f5385c = 0;
        this.f5386d = "";
        this.f5383a = rVar;
    }

    public ad(String str) {
        super(str);
        this.f5385c = 0;
        this.f5386d = "";
        this.f5383a = null;
    }

    public ad(Throwable th) {
        super(th);
        this.f5385c = 0;
        this.f5386d = "";
        this.f5383a = null;
    }
}
