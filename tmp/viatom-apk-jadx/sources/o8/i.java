package o8;

import d9.p;
import java.util.ArrayList;
import t6.t;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public j f11813a;

    /* renamed from: b, reason: collision with root package name */
    public c f11814b;

    /* renamed from: c, reason: collision with root package name */
    public h f11815c;

    /* renamed from: d, reason: collision with root package name */
    public d9.g f11816d;
    public final d9.k e;
    public p f;
    public final k g;
    public long h;

    public i(j jVar, c cVar, h hVar, d9.g gVar, p pVar, k kVar, long j10, int i10) {
        c cVar2;
        j jVar2 = (i10 & 1) != 0 ? new j(new ArrayList(), new ArrayList(), new ArrayList()) : jVar;
        int i11 = i10 & 2;
        t tVar = t.f12808a;
        if (i11 != 0) {
            Boolean bool = Boolean.FALSE;
            cVar2 = new c("", tVar, tVar, "", "", "", "", tVar, tVar, tVar, tVar, tVar, false, "", "", "", true, "", tVar, tVar, tVar, tVar, tVar, tVar, tVar, tVar, 0, "", false, "", "", "", 2, null, "", "", false, "", false, tVar, tVar, "", tVar, false, false, "", "", new d(bool, bool, bool), new f(), new b(), new l("", "", ""), tVar);
        } else {
            cVar2 = cVar;
        }
        h hVar2 = (i10 & 4) != 0 ? new h(tVar, "", "") : hVar;
        d9.g gVar2 = (i10 & 8) != 0 ? new d9.g() : gVar;
        d9.k kVar2 = new d9.k();
        p pVar2 = (i10 & 32) != 0 ? new p(null, null, null, null, null, null, null, null, null, null, 1023) : pVar;
        k kVar3 = (i10 & 64) != 0 ? null : kVar;
        long j11 = (i10 & 128) != 0 ? 0L : j10;
        this.f11813a = jVar2;
        this.f11814b = cVar2;
        this.f11815c = hVar2;
        this.f11816d = gVar2;
        this.e = kVar2;
        this.f = pVar2;
        this.g = kVar3;
        this.h = j11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return kotlin.jvm.internal.l.a(this.f11813a, iVar.f11813a) && kotlin.jvm.internal.l.a(this.f11814b, iVar.f11814b) && kotlin.jvm.internal.l.a(this.f11815c, iVar.f11815c) && kotlin.jvm.internal.l.a(this.f11816d, iVar.f11816d) && kotlin.jvm.internal.l.a(this.e, iVar.e) && kotlin.jvm.internal.l.a(this.f, iVar.f) && kotlin.jvm.internal.l.a(this.g, iVar.g) && this.h == iVar.h;
    }

    public final int hashCode() {
        int iHashCode = (this.f.hashCode() + ((this.e.hashCode() + ((this.f11816d.hashCode() + ((this.f11815c.hashCode() + ((this.f11814b.hashCode() + (this.f11813a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        k kVar = this.g;
        int iHashCode2 = (iHashCode + (kVar == null ? 0 : kVar.hashCode())) * 31;
        long j10 = this.h;
        return ((int) (j10 ^ (j10 >>> 32))) + iHashCode2;
    }

    public final String toString() {
        return "PortalConfig(premiumProperties=" + this.f11813a + ", coreConfig=" + this.f11814b + ", nonIabVendorsInfo=" + this.f11815c + ", coreUiLabels=" + this.f11816d + ", mobileUiLabels=" + this.e + ", premiumUiLabels=" + this.f + ", theme=" + this.g + ", currentTimeStamp=" + this.h + ')';
    }
}
