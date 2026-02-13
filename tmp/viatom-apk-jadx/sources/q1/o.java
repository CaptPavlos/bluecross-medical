package q1;

import p8.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o implements q2.b {

    /* renamed from: c, reason: collision with root package name */
    public static final u f12246c = new u(2);

    /* renamed from: d, reason: collision with root package name */
    public static final e f12247d = new e(1);

    /* renamed from: a, reason: collision with root package name */
    public q2.a f12248a;

    /* renamed from: b, reason: collision with root package name */
    public volatile q2.b f12249b;

    public o(u uVar, q2.b bVar) {
        this.f12248a = uVar;
        this.f12249b = bVar;
    }

    public final void a(q2.a aVar) {
        q2.b bVar;
        q2.b bVar2;
        q2.b bVar3 = this.f12249b;
        e eVar = f12247d;
        if (bVar3 != eVar) {
            aVar.b(bVar3);
            return;
        }
        synchronized (this) {
            bVar = this.f12249b;
            if (bVar != eVar) {
                bVar2 = bVar;
            } else {
                this.f12248a = new androidx.privacysandbox.ads.adservices.java.internal.a(3, this.f12248a, aVar);
                bVar2 = null;
            }
        }
        if (bVar2 != null) {
            aVar.b(bVar);
        }
    }

    @Override // q2.b
    public final Object get() {
        return this.f12249b.get();
    }
}
