package g8;

import com.google.android.gms.internal.measurement.a4;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w0 implements e8.e, k {

    /* renamed from: a, reason: collision with root package name */
    public final e8.e f8339a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8340b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f8341c;

    public w0(e8.e eVar) {
        eVar.getClass();
        this.f8339a = eVar;
        this.f8340b = eVar.a() + '?';
        this.f8341c = o0.b(eVar);
    }

    @Override // e8.e
    public final String a() {
        return this.f8340b;
    }

    @Override // g8.k
    public final Set b() {
        return this.f8341c;
    }

    @Override // e8.e
    public final boolean c() {
        return true;
    }

    @Override // e8.e
    public final int d(String str) {
        str.getClass();
        return this.f8339a.d(str);
    }

    @Override // e8.e
    public final int e() {
        return this.f8339a.e();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof w0) {
            return kotlin.jvm.internal.l.a(this.f8339a, ((w0) obj).f8339a);
        }
        return false;
    }

    @Override // e8.e
    public final String f(int i10) {
        return this.f8339a.f(i10);
    }

    @Override // e8.e
    public final List g(int i10) {
        return this.f8339a.g(i10);
    }

    @Override // e8.e
    public final List getAnnotations() {
        return this.f8339a.getAnnotations();
    }

    @Override // e8.e
    public final a4 getKind() {
        return this.f8339a.getKind();
    }

    @Override // e8.e
    public final e8.e h(int i10) {
        return this.f8339a.h(i10);
    }

    public final int hashCode() {
        return this.f8339a.hashCode() * 31;
    }

    @Override // e8.e
    public final boolean i(int i10) {
        return this.f8339a.i(i10);
    }

    @Override // e8.e
    public final boolean isInline() {
        return this.f8339a.isInline();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8339a);
        sb.append('?');
        return sb.toString();
    }
}
