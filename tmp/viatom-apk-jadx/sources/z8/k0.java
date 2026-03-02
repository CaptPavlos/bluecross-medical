package z8;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.zip.Inflater;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k0 extends p {
    public static final z e;

    /* renamed from: b, reason: collision with root package name */
    public final z f14484b;

    /* renamed from: c, reason: collision with root package name */
    public final p f14485c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f14486d;

    static {
        String str = z.f14517b;
        e = t3.h.i("/", false);
    }

    public k0(z zVar, p pVar, LinkedHashMap linkedHashMap) {
        pVar.getClass();
        this.f14484b = zVar;
        this.f14485c = pVar;
        this.f14486d = linkedHashMap;
    }

    @Override // z8.p
    public final void a(z zVar, z zVar2) throws IOException {
        zVar2.getClass();
        throw new IOException("zip file systems are read-only");
    }

    @Override // z8.p
    public final void b(z zVar) throws IOException {
        throw new IOException("zip file systems are read-only");
    }

    @Override // z8.p
    public final void c(z zVar) throws IOException {
        throw new IOException("zip file systems are read-only");
    }

    @Override // z8.p
    public final o e(z zVar) throws Throwable {
        b0 b0Var;
        zVar.getClass();
        z zVar2 = e;
        zVar2.getClass();
        a9.h hVar = (a9.h) this.f14486d.get(a9.c.b(zVar2, zVar, true));
        Throwable th = null;
        if (hVar == null) {
            return null;
        }
        long j10 = hVar.g;
        boolean z9 = hVar.f345b;
        o oVar = new o(!z9, z9, z9 ? null : Long.valueOf(hVar.f347d), null, hVar.f, null);
        if (j10 == -1) {
            return oVar;
        }
        v vVarF = this.f14485c.f(this.f14484b);
        try {
            b0Var = new b0(vVarF.b(j10));
            try {
                vVarF.close();
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            if (vVarF != null) {
                try {
                    vVarF.close();
                } catch (Throwable th4) {
                    s6.a.a(th3, th4);
                }
            }
            b0Var = null;
            th = th3;
        }
        if (th != null) {
            throw th;
        }
        b0Var.getClass();
        o oVarF = a9.b.f(b0Var, oVar);
        oVarF.getClass();
        return oVarF;
    }

    @Override // z8.p
    public final v f(z zVar) {
        throw new UnsupportedOperationException("not implemented yet!");
    }

    @Override // z8.p
    public final v g(z zVar) throws IOException {
        throw new IOException("zip entries are not writable");
    }

    @Override // z8.p
    public final h0 h(z zVar) throws Throwable {
        b0 b0Var;
        Throwable th;
        zVar.getClass();
        z zVar2 = e;
        zVar2.getClass();
        a9.h hVar = (a9.h) this.f14486d.get(a9.c.b(zVar2, zVar, true));
        if (hVar == null) {
            f.e(zVar, "no such file: ");
            return null;
        }
        long j10 = hVar.f347d;
        v vVarF = this.f14485c.f(this.f14484b);
        try {
            b0Var = new b0(vVarF.b(hVar.g));
            try {
                vVarF.close();
                th = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            if (vVarF != null) {
                try {
                    vVarF.close();
                } catch (Throwable th4) {
                    s6.a.a(th3, th4);
                }
            }
            b0Var = null;
            th = th3;
        }
        if (th != null) {
            throw th;
        }
        b0Var.getClass();
        a9.b.f(b0Var, null);
        if (hVar.e == 0) {
            return new a9.e(b0Var, j10, true);
        }
        return new a9.e(new u(new b0(new a9.e(b0Var, hVar.f346c, true)), new Inflater(true)), j10, false);
    }
}
