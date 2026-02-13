package u8;

import a6.o;
import java.io.EOFException;
import java.io.IOException;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import l4.n5;
import p8.c0;
import p8.r;
import p8.s;
import p8.u;
import p8.w;
import p8.x;
import p8.z;
import z8.a0;
import z8.b0;
import z8.f0;
import z8.j;
import z8.k;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g implements t8.b {

    /* renamed from: a, reason: collision with root package name */
    public final w f13086a;

    /* renamed from: b, reason: collision with root package name */
    public final s8.f f13087b;

    /* renamed from: c, reason: collision with root package name */
    public final k f13088c;

    /* renamed from: d, reason: collision with root package name */
    public final j f13089d;
    public int e = 0;
    public long f = 262144;

    public g(w wVar, s8.f fVar, b0 b0Var, a0 a0Var) {
        this.f13086a = wVar;
        this.f13087b = fVar;
        this.f13088c = b0Var;
        this.f13089d = a0Var;
    }

    @Override // t8.b
    public final f0 a(z zVar, long j10) {
        if ("chunked".equalsIgnoreCase(zVar.f12207c.a("Transfer-Encoding"))) {
            if (this.e == 1) {
                this.e = 2;
                return new b(this);
            }
            u.f(this.e, "state: ");
            return null;
        }
        if (j10 == -1) {
            androidx.window.layout.c.g("Cannot stream a request body without chunked encoding or a known content length!");
            return null;
        }
        if (this.e == 1) {
            this.e = 2;
            return new d(this, j10);
        }
        u.f(this.e, "state: ");
        return null;
    }

    @Override // t8.b
    public final c0 b(p8.b0 b0Var) throws IOException {
        s8.f fVar = this.f13087b;
        fVar.e.getClass();
        b0Var.b("Content-Type");
        if (!t8.d.b(b0Var)) {
            return new c0(0L, new b0(d(0L)), 1);
        }
        if ("chunked".equalsIgnoreCase(b0Var.b("Transfer-Encoding"))) {
            s sVar = b0Var.f12063a.f12205a;
            if (this.e == 4) {
                this.e = 5;
                return new c0(-1L, new b0(new c(this, sVar)), 1);
            }
            u.f(this.e, "state: ");
            return null;
        }
        long jA = t8.d.a(b0Var);
        if (jA != -1) {
            return new c0(jA, new b0(d(jA)), 1);
        }
        if (this.e != 4) {
            u.f(this.e, "state: ");
            return null;
        }
        this.e = 5;
        fVar.e();
        return new c0(-1L, new b0(new f(this)), 1);
    }

    @Override // t8.b
    public final void c(z zVar) {
        Proxy.Type type = this.f13087b.a().f12718c.f12082b.type();
        StringBuilder sb = new StringBuilder();
        sb.append(zVar.f12206b);
        sb.append(' ');
        s sVar = zVar.f12205a;
        if (sVar.f12154a.equals("https") || type != Proxy.Type.HTTP) {
            String str = sVar.f12158i;
            int iIndexOf = str.indexOf(47, sVar.f12154a.length() + 3);
            String strSubstring = str.substring(iIndexOf, q8.c.h(str, iIndexOf, str.length(), "?#"));
            String strE = sVar.e();
            if (strE != null) {
                strSubstring = strSubstring + '?' + strE;
            }
            sb.append(strSubstring);
        } else {
            sb.append(sVar);
        }
        sb.append(" HTTP/1.1");
        e(zVar.f12207c, sb.toString());
    }

    public final e d(long j10) {
        if (this.e != 4) {
            u.f(this.e, "state: ");
            return null;
        }
        this.e = 5;
        e eVar = new e(this);
        eVar.e = j10;
        if (j10 == 0) {
            eVar.a(true, null);
        }
        return eVar;
    }

    public final void e(r rVar, String str) {
        if (this.e != 0) {
            u.f(this.e, "state: ");
            return;
        }
        j jVar = this.f13089d;
        jVar.writeUtf8(str).writeUtf8("\r\n");
        int iD = rVar.d();
        for (int i10 = 0; i10 < iD; i10++) {
            jVar.writeUtf8(rVar.b(i10)).writeUtf8(": ").writeUtf8(rVar.e(i10)).writeUtf8("\r\n");
        }
        jVar.writeUtf8("\r\n");
        this.e = 1;
    }

    @Override // t8.b
    public final void finishRequest() {
        this.f13089d.flush();
    }

    @Override // t8.b
    public final void flushRequest() {
        this.f13089d.flush();
    }

    @Override // t8.b
    public final p8.a0 readResponseHeaders(boolean z9) {
        k kVar = this.f13088c;
        int i10 = this.e;
        if (i10 != 1 && i10 != 3) {
            u.f(this.e, "state: ");
            return null;
        }
        try {
            String utf8LineStrict = kVar.readUtf8LineStrict(this.f);
            this.f -= utf8LineStrict.length();
            o oVarD = o.d(utf8LineStrict);
            int i11 = oVarD.f277b;
            p8.a0 a0Var = new p8.a0();
            a0Var.f12052b = (x) oVarD.f278c;
            a0Var.f12053c = i11;
            a0Var.f12054d = (String) oVarD.f279d;
            n5 n5Var = new n5(18);
            while (true) {
                String utf8LineStrict2 = kVar.readUtf8LineStrict(this.f);
                this.f -= utf8LineStrict2.length();
                if (utf8LineStrict2.length() == 0) {
                    break;
                }
                p8.b.e.getClass();
                n5Var.Q(utf8LineStrict2);
            }
            ArrayList arrayList = (ArrayList) n5Var.f10654b;
            String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            n5 n5Var2 = new n5(18);
            Collections.addAll((ArrayList) n5Var2.f10654b, strArr);
            a0Var.f = n5Var2;
            if (z9 && i11 == 100) {
                return null;
            }
            if (i11 == 100) {
                this.e = 3;
                return a0Var;
            }
            this.e = 4;
            return a0Var;
        } catch (EOFException e) {
            IOException iOException = new IOException("unexpected end of stream on " + this.f13087b);
            iOException.initCause(e);
            throw iOException;
        }
    }
}
