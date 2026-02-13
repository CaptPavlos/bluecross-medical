package d9;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final g f7584a;

    /* renamed from: b, reason: collision with root package name */
    public final p f7585b;

    /* renamed from: c, reason: collision with root package name */
    public final k f7586c;

    /* renamed from: d, reason: collision with root package name */
    public final e f7587d;
    public final a e;

    public /* synthetic */ t() {
        this(new g(), new p(null, null, null, null, null, null, null, null, null, null, 1023), new k(), new e(), new a());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return kotlin.jvm.internal.l.a(this.f7584a, tVar.f7584a) && kotlin.jvm.internal.l.a(this.f7585b, tVar.f7585b) && kotlin.jvm.internal.l.a(this.f7586c, tVar.f7586c) && kotlin.jvm.internal.l.a(this.f7587d, tVar.f7587d) && kotlin.jvm.internal.l.a(this.e, tVar.e);
    }

    public final int hashCode() {
        return this.e.hashCode() + ((this.f7587d.hashCode() + ((this.f7586c.hashCode() + ((this.f7585b.hashCode() + (this.f7584a.hashCode() * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "TranslationsText(coreUiLabels=" + this.f7584a + ", premiumUiLabels=" + this.f7585b + ", mobileUiLabels=" + this.f7586c + ", consentOrPay=" + this.f7587d + ", advanced=" + this.e + ')';
    }

    public t(g gVar, p pVar, k kVar, e eVar, a aVar) {
        this.f7584a = gVar;
        this.f7585b = pVar;
        this.f7586c = kVar;
        this.f7587d = eVar;
        this.e = aVar;
    }
}
