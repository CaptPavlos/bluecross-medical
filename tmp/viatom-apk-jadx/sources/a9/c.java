package a9;

import z8.l;
import z8.z;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final l f331a;

    /* renamed from: b, reason: collision with root package name */
    public static final l f332b;

    /* renamed from: c, reason: collision with root package name */
    public static final l f333c;

    /* renamed from: d, reason: collision with root package name */
    public static final l f334d;
    public static final l e;

    static {
        l lVar = l.f14487d;
        f331a = r0.f.u("/");
        f332b = r0.f.u("\\");
        f333c = r0.f.u("/\\");
        f334d = r0.f.u(".");
        e = r0.f.u("..");
    }

    public static final int a(z zVar) {
        l lVar = zVar.f14518a;
        if (lVar.e() != 0) {
            if (lVar.j(0) != 47) {
                if (lVar.j(0) == 92) {
                    if (lVar.e() > 2 && lVar.j(1) == 92) {
                        l lVar2 = f332b;
                        lVar2.getClass();
                        int iG = lVar.g(lVar2.i(), 2);
                        return iG == -1 ? lVar.e() : iG;
                    }
                } else if (lVar.e() > 2 && lVar.j(1) == 58 && lVar.j(2) == 92) {
                    char cJ = (char) lVar.j(0);
                    if ('a' <= cJ && cJ < '{') {
                        return 3;
                    }
                    if ('A' <= cJ && cJ < '[') {
                        return 3;
                    }
                }
            }
            return 1;
        }
        return -1;
    }

    public static final z b(z zVar, z zVar2, boolean z9) {
        zVar2.getClass();
        if (a(zVar2) != -1 || zVar2.e() != null) {
            return zVar2;
        }
        l lVarC = c(zVar);
        if (lVarC == null && (lVarC = c(zVar2)) == null) {
            lVarC = f(z.f14517b);
        }
        z8.i iVar = new z8.i();
        iVar.i(zVar.f14518a);
        if (iVar.f14479b > 0) {
            iVar.i(lVarC);
        }
        iVar.i(zVar2.f14518a);
        return d(iVar, z9);
    }

    public static final l c(z zVar) {
        l lVar = zVar.f14518a;
        l lVar2 = f331a;
        if (l.h(lVar, lVar2) != -1) {
            return lVar2;
        }
        l lVar3 = zVar.f14518a;
        l lVar4 = f332b;
        if (l.h(lVar3, lVar4) != -1) {
            return lVar4;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011c A[EDGE_INSN: B:101:0x011c->B:84:0x011c BREAK  A[LOOP:1: B:53:0x00ab->B:116:0x00ab], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x013a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final z8.z d(z8.i r17, boolean r18) throws java.io.EOFException {
        /*
            Method dump skipped, instructions count: 343
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a9.c.d(z8.i, boolean):z8.z");
    }

    public static final l e(byte b10) {
        if (b10 == 47) {
            return f331a;
        }
        if (b10 == 92) {
            return f332b;
        }
        com.google.gson.internal.a.n(a3.a.f(b10, "not a directory separator: "));
        return null;
    }

    public static final l f(String str) {
        if (kotlin.jvm.internal.l.a(str, "/")) {
            return f331a;
        }
        if (kotlin.jvm.internal.l.a(str, "\\")) {
            return f332b;
        }
        com.google.gson.internal.a.n(a3.a.i("not a directory separator: ", str));
        return null;
    }
}
