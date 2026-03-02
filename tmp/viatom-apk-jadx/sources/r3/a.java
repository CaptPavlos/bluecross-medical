package r3;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: b, reason: collision with root package name */
    public String f12366b = null;

    /* renamed from: c, reason: collision with root package name */
    public boolean f12367c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f12368d = true;

    /* renamed from: a, reason: collision with root package name */
    public final p3.b f12365a = f();

    public final void a(String str) {
        this.f12366b = str;
        this.f12367c = false;
        this.f12368d = false;
    }

    public abstract void b(String str, p3.b bVar);

    public final String c() {
        String str = this.f12366b;
        if (str == null || str.isEmpty() || this.f12367c) {
            this.f12366b = d(this.f12365a);
            this.f12367c = false;
            this.f12368d = true;
        }
        return this.f12366b;
    }

    public abstract String d(p3.b bVar);

    public final Object e(String str) {
        boolean z9 = this.f12368d;
        p3.b bVar = this.f12365a;
        if (!z9) {
            b(this.f12366b, bVar);
            this.f12367c = false;
            this.f12368d = true;
        }
        if (bVar.a(str)) {
            return bVar.get(str).getValue();
        }
        throw new o3.b(androidx.constraintlayout.core.widgets.analyzer.a.x("Invalid field: '", str, "'"));
    }

    public abstract p3.b f();

    public final void g(String str, Object obj) {
        boolean z9 = this.f12368d;
        p3.b bVar = this.f12365a;
        if (!z9) {
            b(this.f12366b, bVar);
            this.f12367c = false;
            this.f12368d = true;
        }
        if (!bVar.a(str)) {
            throw new o3.b(a3.a.C(str, " not found"));
        }
        bVar.get(str).setValue(obj);
        this.f12367c = true;
    }
}
