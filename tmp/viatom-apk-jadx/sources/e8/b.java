package e8;

import com.google.android.gms.internal.measurement.a4;
import java.util.List;
import kotlin.jvm.internal.l;
import t6.t;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b implements e {

    /* renamed from: a, reason: collision with root package name */
    public final f f7954a;

    /* renamed from: b, reason: collision with root package name */
    public final m7.c f7955b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7956c;

    public b(f fVar, m7.c cVar) {
        cVar.getClass();
        this.f7954a = fVar;
        this.f7955b = cVar;
        this.f7956c = fVar.f7964a + '<' + ((kotlin.jvm.internal.f) cVar).c() + '>';
    }

    @Override // e8.e
    public final String a() {
        return this.f7956c;
    }

    @Override // e8.e
    public final boolean c() {
        return false;
    }

    @Override // e8.e
    public final int d(String str) {
        str.getClass();
        return this.f7954a.d(str);
    }

    @Override // e8.e
    public final int e() {
        return this.f7954a.f7966c;
    }

    public final boolean equals(Object obj) {
        b bVar = obj instanceof b ? (b) obj : null;
        return bVar != null && this.f7954a.equals(bVar.f7954a) && l.a(bVar.f7955b, this.f7955b);
    }

    @Override // e8.e
    public final String f(int i10) {
        return this.f7954a.e[i10];
    }

    @Override // e8.e
    public final List g(int i10) {
        return this.f7954a.g[i10];
    }

    @Override // e8.e
    public final List getAnnotations() {
        return t.f12808a;
    }

    @Override // e8.e
    public final a4 getKind() {
        return this.f7954a.f7965b;
    }

    @Override // e8.e
    public final e h(int i10) {
        return this.f7954a.f[i10];
    }

    public final int hashCode() {
        return this.f7956c.hashCode() + (((kotlin.jvm.internal.f) this.f7955b).hashCode() * 31);
    }

    @Override // e8.e
    public final boolean i(int i10) {
        return this.f7954a.h[i10];
    }

    @Override // e8.e
    public final boolean isInline() {
        return false;
    }

    public final String toString() {
        return "ContextDescriptor(kClass: " + this.f7955b + ", original: " + this.f7954a + ')';
    }
}
