package j$.time.format;

import j$.time.ZoneId;

/* loaded from: classes2.dex */
public final class o implements j$.time.temporal.n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j$.time.chrono.b f9238a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j$.time.temporal.n f9239b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j$.time.chrono.l f9240c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ZoneId f9241d;

    @Override // j$.time.temporal.n
    public final /* synthetic */ int e(j$.time.temporal.q qVar) {
        return j$.time.temporal.r.a(this, qVar);
    }

    public o(j$.time.chrono.b bVar, j$.time.temporal.n nVar, j$.time.chrono.l lVar, ZoneId zoneId) {
        this.f9238a = bVar;
        this.f9239b = nVar;
        this.f9240c = lVar;
        this.f9241d = zoneId;
    }

    @Override // j$.time.temporal.n
    public final boolean c(j$.time.temporal.q qVar) {
        j$.time.chrono.b bVar = this.f9238a;
        if (bVar != null && qVar.isDateBased()) {
            return bVar.c(qVar);
        }
        return this.f9239b.c(qVar);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.u g(j$.time.temporal.q qVar) {
        j$.time.chrono.b bVar = this.f9238a;
        if (bVar != null && qVar.isDateBased()) {
            return bVar.g(qVar);
        }
        return this.f9239b.g(qVar);
    }

    @Override // j$.time.temporal.n
    public final long q(j$.time.temporal.q qVar) {
        j$.time.chrono.b bVar = this.f9238a;
        if (bVar != null && qVar.isDateBased()) {
            return bVar.q(qVar);
        }
        return this.f9239b.q(qVar);
    }

    @Override // j$.time.temporal.n
    public final Object k(a aVar) {
        if (aVar == j$.time.temporal.r.f9301b) {
            return this.f9240c;
        }
        if (aVar == j$.time.temporal.r.f9300a) {
            return this.f9241d;
        }
        if (aVar == j$.time.temporal.r.f9302c) {
            return this.f9239b.k(aVar);
        }
        return aVar.a(this);
    }

    public final String toString() {
        String str;
        String str2 = "";
        j$.time.chrono.l lVar = this.f9240c;
        if (lVar != null) {
            str = " with chronology " + lVar;
        } else {
            str = "";
        }
        ZoneId zoneId = this.f9241d;
        if (zoneId != null) {
            str2 = " with zone " + zoneId;
        }
        return this.f9239b + str + str2;
    }
}
