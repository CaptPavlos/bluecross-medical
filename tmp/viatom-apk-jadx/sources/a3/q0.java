package a3;

import android.content.Context;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q0 implements c3.b, r.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f154a;

    /* renamed from: b, reason: collision with root package name */
    public final p6.a f155b;

    public /* synthetic */ q0(p6.a aVar, int i10) {
        this.f154a = i10;
        this.f155b = aVar;
    }

    @Override // p6.a
    public final Object get() {
        switch (this.f154a) {
            case 0:
                return new p0((a1) this.f155b.get());
            default:
                return new w.j((Context) this.f155b.get(), Integer.valueOf(w.j.f13313d).intValue(), "com.google.android.datatransport.events");
        }
    }
}
