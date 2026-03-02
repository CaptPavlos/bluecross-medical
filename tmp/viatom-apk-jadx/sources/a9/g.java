package a9;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import s6.m;
import z8.h0;
import z8.l;
import z8.o;
import z8.p;
import z8.v;
import z8.z;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g extends p {

    /* renamed from: c, reason: collision with root package name */
    public static final z f342c;

    /* renamed from: b, reason: collision with root package name */
    public final m f343b;

    static {
        String str = z.f14517b;
        f342c = t3.h.i("/", false);
    }

    public g(ClassLoader classLoader) {
        this.f343b = new m(new f(classLoader, 0));
    }

    public static String i(z zVar) throws EOFException {
        z zVarD;
        z zVar2 = f342c;
        zVar2.getClass();
        l lVar = zVar2.f14518a;
        zVar.getClass();
        z zVarB = c.b(zVar2, zVar, true);
        l lVar2 = zVarB.f14518a;
        int iA = c.a(zVarB);
        z zVar3 = iA == -1 ? null : new z(lVar2.o(0, iA));
        int iA2 = c.a(zVar2);
        if (!kotlin.jvm.internal.l.a(zVar3, iA2 != -1 ? new z(lVar.o(0, iA2)) : null)) {
            throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + zVarB + " and " + zVar2).toString());
        }
        ArrayList arrayListA = zVarB.a();
        ArrayList arrayListA2 = zVar2.a();
        int iMin = Math.min(arrayListA.size(), arrayListA2.size());
        int i10 = 0;
        while (i10 < iMin && kotlin.jvm.internal.l.a(arrayListA.get(i10), arrayListA2.get(i10))) {
            i10++;
        }
        if (i10 == iMin && lVar2.e() == lVar.e()) {
            String str = z.f14517b;
            zVarD = t3.h.i(".", false);
        } else {
            if (arrayListA2.subList(i10, arrayListA2.size()).indexOf(c.e) != -1) {
                throw new IllegalArgumentException(("Impossible relative path to resolve: " + zVarB + " and " + zVar2).toString());
            }
            z8.i iVar = new z8.i();
            l lVarC = c.c(zVar2);
            if (lVarC == null && (lVarC = c.c(zVarB)) == null) {
                lVarC = c.f(z.f14517b);
            }
            int size = arrayListA2.size();
            for (int i11 = i10; i11 < size; i11++) {
                iVar.i(c.e);
                iVar.i(lVarC);
            }
            int size2 = arrayListA.size();
            while (i10 < size2) {
                iVar.i((l) arrayListA.get(i10));
                iVar.i(lVarC);
                i10++;
            }
            zVarD = c.d(iVar, false);
        }
        return zVarD.f14518a.r();
    }

    @Override // z8.p
    public final void a(z zVar, z zVar2) throws IOException {
        zVar2.getClass();
        throw new IOException(this + " is read-only");
    }

    @Override // z8.p
    public final void b(z zVar) throws IOException {
        throw new IOException(this + " is read-only");
    }

    @Override // z8.p
    public final void c(z zVar) throws IOException {
        throw new IOException(this + " is read-only");
    }

    @Override // z8.p
    public final o e(z zVar) throws EOFException {
        zVar.getClass();
        if (!o2.e.b(zVar)) {
            return null;
        }
        String strI = i(zVar);
        for (s6.i iVar : (List) this.f343b.getValue()) {
            o oVarE = ((p) iVar.f12693a).e(((z) iVar.f12694b).d(strI));
            if (oVarE != null) {
                return oVarE;
            }
        }
        return null;
    }

    @Override // z8.p
    public final v f(z zVar) throws EOFException, FileNotFoundException {
        if (!o2.e.b(zVar)) {
            z8.f.e(zVar, "file not found: ");
            return null;
        }
        String strI = i(zVar);
        for (s6.i iVar : (List) this.f343b.getValue()) {
            try {
                return ((p) iVar.f12693a).f(((z) iVar.f12694b).d(strI));
            } catch (FileNotFoundException unused) {
            }
        }
        z8.f.e(zVar, "file not found: ");
        return null;
    }

    @Override // z8.p
    public final v g(z zVar) throws IOException {
        throw new IOException("resources are not writable");
    }

    @Override // z8.p
    public final h0 h(z zVar) throws EOFException, FileNotFoundException {
        zVar.getClass();
        if (!o2.e.b(zVar)) {
            z8.f.e(zVar, "file not found: ");
            return null;
        }
        String strI = i(zVar);
        for (s6.i iVar : (List) this.f343b.getValue()) {
            try {
                return ((p) iVar.f12693a).h(((z) iVar.f12694b).d(strI));
            } catch (FileNotFoundException unused) {
            }
        }
        z8.f.e(zVar, "file not found: ");
        return null;
    }
}
