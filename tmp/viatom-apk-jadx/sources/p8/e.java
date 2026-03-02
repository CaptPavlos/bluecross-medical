package p8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e extends d0 {

    /* renamed from: a, reason: collision with root package name */
    public final r8.e f12078a;

    /* renamed from: b, reason: collision with root package name */
    public final z8.b0 f12079b;

    /* renamed from: c, reason: collision with root package name */
    public final String f12080c;

    public e(r8.e eVar, String str) {
        this.f12078a = eVar;
        this.f12080c = str;
        this.f12079b = new z8.b0(new d(eVar.f12473c[1], eVar));
    }

    @Override // p8.d0
    public final long a() {
        try {
            String str = this.f12080c;
            if (str != null) {
                return Long.parseLong(str);
            }
            return -1L;
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    @Override // p8.d0
    public final z8.k b() {
        return this.f12079b;
    }
}
