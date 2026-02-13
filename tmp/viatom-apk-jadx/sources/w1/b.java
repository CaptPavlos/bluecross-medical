package w1;

import java.io.File;
import z1.b0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final b0 f13321a;

    /* renamed from: b, reason: collision with root package name */
    public final String f13322b;

    /* renamed from: c, reason: collision with root package name */
    public final File f13323c;

    public b(b0 b0Var, String str, File file) {
        this.f13321a = b0Var;
        if (str == null) {
            androidx.window.layout.c.k("Null sessionId");
            throw null;
        }
        this.f13322b = str;
        this.f13323c = file;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f13321a.equals(bVar.f13321a) && this.f13322b.equals(bVar.f13322b) && this.f13323c.equals(bVar.f13323c);
    }

    public final int hashCode() {
        return ((((this.f13321a.hashCode() ^ 1000003) * 1000003) ^ this.f13322b.hashCode()) * 1000003) ^ this.f13323c.hashCode();
    }

    public final String toString() {
        return "CrashlyticsReportWithSessionId{report=" + this.f13321a + ", sessionId=" + this.f13322b + ", reportFile=" + this.f13323c + "}";
    }
}
