package z8;

import java.io.File;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class z implements Comparable {

    /* renamed from: b, reason: collision with root package name */
    public static final String f14517b;

    /* renamed from: a, reason: collision with root package name */
    public final l f14518a;

    static {
        String str = File.separator;
        str.getClass();
        f14517b = str;
    }

    public z(l lVar) {
        lVar.getClass();
        this.f14518a = lVar;
    }

    public final ArrayList a() {
        ArrayList arrayList = new ArrayList();
        int iA = a9.c.a(this);
        l lVar = this.f14518a;
        if (iA == -1) {
            iA = 0;
        } else if (iA < lVar.e() && lVar.j(iA) == 92) {
            iA++;
        }
        int iE = lVar.e();
        int i10 = iA;
        while (iA < iE) {
            if (lVar.j(iA) == 47 || lVar.j(iA) == 92) {
                arrayList.add(lVar.o(i10, iA));
                i10 = iA + 1;
            }
            iA++;
        }
        if (i10 < lVar.e()) {
            arrayList.add(lVar.o(i10, lVar.e()));
        }
        return arrayList;
    }

    public final String b() {
        l lVar = a9.c.f331a;
        l lVarP = this.f14518a;
        int iL = l.l(lVarP, lVar);
        if (iL == -1) {
            iL = l.l(lVarP, a9.c.f332b);
        }
        if (iL != -1) {
            lVarP = l.p(lVarP, iL + 1, 0, 2);
        } else if (e() != null && lVarP.e() == 2) {
            lVarP = l.f14487d;
        }
        return lVarP.r();
    }

    public final z c() {
        l lVar = a9.c.f334d;
        l lVar2 = this.f14518a;
        if (kotlin.jvm.internal.l.a(lVar2, lVar)) {
            return null;
        }
        l lVar3 = a9.c.f331a;
        if (kotlin.jvm.internal.l.a(lVar2, lVar3)) {
            return null;
        }
        l lVar4 = a9.c.f332b;
        if (kotlin.jvm.internal.l.a(lVar2, lVar4)) {
            return null;
        }
        l lVar5 = a9.c.e;
        lVar2.getClass();
        lVar5.getClass();
        int iE = lVar2.e();
        byte[] bArr = lVar5.f14488a;
        if (lVar2.m(iE - bArr.length, lVar5, bArr.length) && (lVar2.e() == 2 || lVar2.m(lVar2.e() - 3, lVar3, 1) || lVar2.m(lVar2.e() - 3, lVar4, 1))) {
            return null;
        }
        int iL = l.l(lVar2, lVar3);
        if (iL == -1) {
            iL = l.l(lVar2, lVar4);
        }
        if (iL == 2 && e() != null) {
            if (lVar2.e() == 3) {
                return null;
            }
            return new z(l.p(lVar2, 0, 3, 1));
        }
        if (iL == 1) {
            lVar4.getClass();
            if (lVar2.m(0, lVar4, lVar4.e())) {
                return null;
            }
        }
        if (iL != -1 || e() == null) {
            return iL == -1 ? new z(lVar) : iL == 0 ? new z(l.p(lVar2, 0, 1, 1)) : new z(l.p(lVar2, 0, iL, 1));
        }
        if (lVar2.e() == 2) {
            return null;
        }
        return new z(l.p(lVar2, 0, 2, 1));
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        z zVar = (z) obj;
        zVar.getClass();
        return this.f14518a.compareTo(zVar.f14518a);
    }

    public final z d(String str) {
        str.getClass();
        i iVar = new i();
        iVar.q(str);
        return a9.c.b(this, a9.c.d(iVar, false), false);
    }

    public final Character e() {
        l lVar = a9.c.f331a;
        l lVar2 = this.f14518a;
        if (l.h(lVar2, lVar) != -1 || lVar2.e() < 2 || lVar2.j(1) != 58) {
            return null;
        }
        char cJ = (char) lVar2.j(0);
        if (('a' > cJ || cJ >= '{') && ('A' > cJ || cJ >= '[')) {
            return null;
        }
        return Character.valueOf(cJ);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof z) && kotlin.jvm.internal.l.a(((z) obj).f14518a, this.f14518a);
    }

    public final int hashCode() {
        return this.f14518a.hashCode();
    }

    public final File toFile() {
        return new File(this.f14518a.r());
    }

    public final String toString() {
        return this.f14518a.r();
    }
}
