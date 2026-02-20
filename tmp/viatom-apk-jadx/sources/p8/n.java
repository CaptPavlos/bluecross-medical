package p8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f12131a;

    /* renamed from: b, reason: collision with root package name */
    public String[] f12132b;

    /* renamed from: c, reason: collision with root package name */
    public String[] f12133c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f12134d;

    public n(o oVar) {
        this.f12131a = oVar.f12135a;
        this.f12132b = oVar.f12137c;
        this.f12133c = oVar.f12138d;
        this.f12134d = oVar.f12136b;
    }

    public final void a(String... strArr) {
        if (!this.f12131a) {
            androidx.window.layout.c.g("no cipher suites for cleartext connections");
        } else if (strArr.length != 0) {
            this.f12132b = (String[]) strArr.clone();
        } else {
            com.google.gson.internal.a.n("At least one cipher suite is required");
        }
    }

    public final void b(String... strArr) {
        if (!this.f12131a) {
            androidx.window.layout.c.g("no TLS versions for cleartext connections");
        } else if (strArr.length != 0) {
            this.f12133c = (String[]) strArr.clone();
        } else {
            com.google.gson.internal.a.n("At least one TLS version is required");
        }
    }

    public n(boolean z9) {
        this.f12131a = z9;
    }
}
