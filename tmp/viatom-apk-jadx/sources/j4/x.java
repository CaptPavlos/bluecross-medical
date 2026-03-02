package j4;

import android.net.NetworkInfo;
import android.net.Uri;
import java.io.IOException;
import l4.n5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class x extends f0 {

    /* renamed from: a, reason: collision with root package name */
    public final d0.i f10008a;

    /* renamed from: b, reason: collision with root package name */
    public final g0 f10009b;

    public x(d0.i iVar, g0 g0Var) {
        this.f10008a = iVar;
        this.f10009b = g0Var;
    }

    @Override // j4.f0
    public final boolean b(c0 c0Var) {
        String scheme = ((Uri) c0Var.f9925b).getScheme();
        return "http".equals(scheme) || "https".equals(scheme);
    }

    @Override // j4.f0
    public final int d() {
        return 2;
    }

    @Override // j4.f0
    public final e0 e(c0 c0Var, int i10) throws v, w {
        p8.i iVar;
        if (i10 == 0) {
            iVar = null;
        } else if ((i10 & 4) != 0) {
            iVar = p8.i.f12102n;
        } else {
            p8.h hVar = new p8.h();
            if ((i10 & 1) != 0) {
                hVar.f12098a = true;
            }
            if ((i10 & 2) != 0) {
                hVar.f12099b = true;
            }
            iVar = new p8.i(hVar);
        }
        w2.r rVar = new w2.r(22);
        rVar.H(((Uri) c0Var.f9925b).toString());
        if (iVar != null) {
            String string = iVar.toString();
            if (string.isEmpty()) {
                ((n5) rVar.f13464d).p0("Cache-Control");
            } else {
                rVar.B("Cache-Control", string);
            }
        }
        p8.z zVarS = rVar.s();
        p8.w wVar = (p8.w) this.f10008a.f6781b;
        wVar.getClass();
        p8.y yVar = new p8.y(wVar, zVarS);
        wVar.f.getClass();
        yVar.f12203c = p8.b.f12062d;
        synchronized (yVar) {
            if (yVar.e) {
                throw new IllegalStateException("Already Executed");
            }
            yVar.e = true;
        }
        yVar.f12202b.f12875b = x8.h.f13740a.i();
        yVar.f12203c.getClass();
        try {
            try {
                wVar.f12178a.j(yVar);
                p8.b0 b0VarA = yVar.a();
                wVar.f12178a.n(yVar);
                p8.d0 d0Var = b0VarA.g;
                int i11 = b0VarA.f12065c;
                if (i11 < 200 || i11 >= 300) {
                    d0Var.close();
                    throw new w(a3.a.f(b0VarA.f12065c, "HTTP "));
                }
                int i12 = b0VarA.f12067i == null ? 3 : 2;
                if (i12 == 2 && d0Var.a() == 0) {
                    d0Var.close();
                    throw new v("Received response with 0 content-length header.");
                }
                if (i12 == 3 && d0Var.a() > 0) {
                    g0 g0Var = this.f10009b;
                    long jA = d0Var.a();
                    l lVar = g0Var.f9957b;
                    lVar.sendMessage(lVar.obtainMessage(4, Long.valueOf(jA)));
                }
                return new e0(d0Var.b(), i12);
            } catch (IOException e) {
                yVar.f12203c.getClass();
                throw e;
            }
        } catch (Throwable th) {
            yVar.f12201a.f12178a.n(yVar);
            throw th;
        }
    }

    @Override // j4.f0
    public final boolean f(NetworkInfo networkInfo) {
        return networkInfo == null || networkInfo.isConnected();
    }
}
