package v8;

import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import l4.n5;
import p8.b0;
import p8.c0;
import z8.f0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g implements t8.b {
    public static final List e;
    public static final List f;

    /* renamed from: a, reason: collision with root package name */
    public final t8.e f13223a;

    /* renamed from: b, reason: collision with root package name */
    public final s8.f f13224b;

    /* renamed from: c, reason: collision with root package name */
    public final q f13225c;

    /* renamed from: d, reason: collision with root package name */
    public w f13226d;

    static {
        z8.l lVar = z8.l.f14487d;
        z8.l lVarU = r0.f.u("connection");
        z8.l lVarU2 = r0.f.u("host");
        z8.l lVarU3 = r0.f.u("keep-alive");
        z8.l lVarU4 = r0.f.u("proxy-connection");
        z8.l lVarU5 = r0.f.u("transfer-encoding");
        z8.l lVarU6 = r0.f.u("te");
        z8.l lVarU7 = r0.f.u("encoding");
        z8.l lVarU8 = r0.f.u("upgrade");
        e = q8.c.l(lVarU, lVarU2, lVarU3, lVarU4, lVarU6, lVarU5, lVarU7, lVarU8, b.f, b.g, b.h, b.f13206i);
        f = q8.c.l(lVarU, lVarU2, lVarU3, lVarU4, lVarU6, lVarU5, lVarU7, lVarU8);
    }

    public g(t8.e eVar, s8.f fVar, q qVar) {
        this.f13223a = eVar;
        this.f13224b = fVar;
        this.f13225c = qVar;
    }

    @Override // t8.b
    public final f0 a(p8.z zVar, long j10) {
        return this.f13226d.e();
    }

    @Override // t8.b
    public final c0 b(b0 b0Var) {
        this.f13224b.e.getClass();
        b0Var.b("Content-Type");
        return new c0(t8.d.a(b0Var), new z8.b0(new f(this, this.f13226d.g)), 1);
    }

    @Override // t8.b
    public final void c(p8.z zVar) {
        int i10;
        w wVar;
        if (this.f13226d != null) {
            return;
        }
        zVar.getClass();
        p8.r rVar = zVar.f12207c;
        ArrayList arrayList = new ArrayList(rVar.d() + 4);
        arrayList.add(new b(b.f, zVar.f12206b));
        z8.l lVar = b.g;
        p8.s sVar = zVar.f12205a;
        String str = sVar.f12158i;
        int iIndexOf = str.indexOf(47, sVar.f12154a.length() + 3);
        String strSubstring = str.substring(iIndexOf, q8.c.h(str, iIndexOf, str.length(), "?#"));
        String strE = sVar.e();
        if (strE != null) {
            strSubstring = strSubstring + '?' + strE;
        }
        arrayList.add(new b(lVar, strSubstring));
        String strA = zVar.f12207c.a("Host");
        if (strA != null) {
            arrayList.add(new b(b.f13206i, strA));
        }
        arrayList.add(new b(b.h, sVar.f12154a));
        int iD = rVar.d();
        for (int i11 = 0; i11 < iD; i11++) {
            String lowerCase = rVar.b(i11).toLowerCase(Locale.US);
            z8.l lVar2 = z8.l.f14487d;
            z8.l lVarU = r0.f.u(lowerCase);
            if (!e.contains(lVarU)) {
                arrayList.add(new b(lVarU, rVar.e(i11)));
            }
        }
        q qVar = this.f13225c;
        boolean z9 = !false;
        synchronized (qVar.f13261r) {
            synchronized (qVar) {
                try {
                    if (qVar.f > 1073741823) {
                        qVar.h(5);
                    }
                    if (qVar.g) {
                        throw new a();
                    }
                    i10 = qVar.f;
                    qVar.f = i10 + 2;
                    wVar = new w(i10, qVar, z9, false, arrayList);
                    if (wVar.g()) {
                        qVar.f13250c.put(Integer.valueOf(i10), wVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            qVar.f13261r.k(arrayList, i10, z9);
        }
        qVar.f13261r.flush();
        this.f13226d = wVar;
        wVar.f13284i.g(this.f13223a.f12871j);
        this.f13226d.f13285j.g(this.f13223a.f12872k);
    }

    @Override // t8.b
    public final void finishRequest() {
        this.f13226d.e().close();
    }

    @Override // t8.b
    public final void flushRequest() {
        this.f13225c.flush();
    }

    @Override // t8.b
    public final p8.a0 readResponseHeaders(boolean z9) throws ProtocolException, NumberFormatException {
        ArrayList arrayList;
        w wVar = this.f13226d;
        synchronized (wVar) {
            if (!wVar.f()) {
                throw new IllegalStateException("servers cannot read response headers");
            }
            wVar.f13284i.h();
            while (wVar.e == null && wVar.f13286k == 0) {
                try {
                    try {
                        wVar.wait();
                    } catch (InterruptedException unused) {
                        throw new InterruptedIOException();
                    }
                } catch (Throwable th) {
                    wVar.f13284i.k();
                    throw th;
                }
            }
            wVar.f13284i.k();
            arrayList = wVar.e;
            if (arrayList == null) {
                throw new a0(wVar.f13286k);
            }
            wVar.e = null;
        }
        n5 n5Var = new n5(18);
        int size = arrayList.size();
        a6.o oVarD = null;
        for (int i10 = 0; i10 < size; i10++) {
            b bVar = (b) arrayList.get(i10);
            if (bVar != null) {
                z8.l lVar = bVar.f13207a;
                String strR = bVar.f13208b.r();
                if (lVar.equals(b.e)) {
                    oVarD = a6.o.d("HTTP/1.1 ".concat(strR));
                } else if (!f.contains(lVar)) {
                    p8.b bVar2 = p8.b.e;
                    String strR2 = lVar.r();
                    bVar2.getClass();
                    n5Var.R(strR2, strR);
                }
            } else if (oVarD != null && oVarD.f277b == 100) {
                n5Var = new n5(18);
                oVarD = null;
            }
        }
        if (oVarD == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        p8.a0 a0Var = new p8.a0();
        a0Var.f12052b = p8.x.HTTP_2;
        a0Var.f12053c = oVarD.f277b;
        a0Var.f12054d = (String) oVarD.f279d;
        ArrayList arrayList2 = (ArrayList) n5Var.f10654b;
        String[] strArr = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
        n5 n5Var2 = new n5(18);
        Collections.addAll((ArrayList) n5Var2.f10654b, strArr);
        a0Var.f = n5Var2;
        if (z9) {
            p8.b.e.getClass();
            if (a0Var.f12053c == 100) {
                return null;
            }
        }
        return a0Var;
    }
}
