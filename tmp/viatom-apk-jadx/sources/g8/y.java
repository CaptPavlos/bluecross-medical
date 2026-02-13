package g8;

import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class y extends q0 {

    /* renamed from: l, reason: collision with root package name */
    public final boolean f8342l;

    public y(String str, z zVar) {
        super(str, zVar, 1);
        this.f8342l = true;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, s6.f] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object, s6.f] */
    @Override // g8.q0
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof y) {
            e8.e eVar = (e8.e) obj;
            if (this.f8314a.equals(eVar.a())) {
                y yVar = (y) obj;
                if (yVar.f8342l && Arrays.equals((e8.e[]) this.f8319j.getValue(), (e8.e[]) yVar.f8319j.getValue())) {
                    int iE = eVar.e();
                    int i10 = this.f8316c;
                    if (i10 == iE) {
                        for (int i11 = 0; i11 < i10; i11++) {
                            if (kotlin.jvm.internal.l.a(h(i11).a(), eVar.h(i11).a()) && kotlin.jvm.internal.l.a(h(i11).getKind(), eVar.h(i11).getKind())) {
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // g8.q0
    public final int hashCode() {
        return super.hashCode() * 31;
    }

    @Override // g8.q0, e8.e
    public final boolean isInline() {
        return this.f8342l;
    }
}
