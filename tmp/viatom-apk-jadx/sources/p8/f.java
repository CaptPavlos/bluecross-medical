package p8;

import c1.g1;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import l4.n5;
import z8.h0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: k, reason: collision with root package name */
    public static final String f12084k;

    /* renamed from: l, reason: collision with root package name */
    public static final String f12085l;

    /* renamed from: a, reason: collision with root package name */
    public final String f12086a;

    /* renamed from: b, reason: collision with root package name */
    public final r f12087b;

    /* renamed from: c, reason: collision with root package name */
    public final String f12088c;

    /* renamed from: d, reason: collision with root package name */
    public final x f12089d;
    public final int e;
    public final String f;
    public final r g;
    public final q h;

    /* renamed from: i, reason: collision with root package name */
    public final long f12090i;

    /* renamed from: j, reason: collision with root package name */
    public final long f12091j;

    static {
        x8.h hVar = x8.h.f13740a;
        hVar.getClass();
        f12084k = "OkHttp-Sent-Millis";
        hVar.getClass();
        f12085l = "OkHttp-Received-Millis";
    }

    public f(h0 h0Var) throws IOException {
        try {
            h0Var.getClass();
            z8.b0 b0Var = new z8.b0(h0Var);
            this.f12086a = b0Var.readUtf8LineStrict(Long.MAX_VALUE);
            this.f12088c = b0Var.readUtf8LineStrict(Long.MAX_VALUE);
            n5 n5Var = new n5(18);
            int iA = g.a(b0Var);
            for (int i10 = 0; i10 < iA; i10++) {
                n5Var.Q(b0Var.readUtf8LineStrict(Long.MAX_VALUE));
            }
            this.f12087b = new r(n5Var);
            a6.o oVarD = a6.o.d(b0Var.readUtf8LineStrict(Long.MAX_VALUE));
            this.f12089d = (x) oVarD.f278c;
            this.e = oVarD.f277b;
            this.f = (String) oVarD.f279d;
            n5 n5Var2 = new n5(18);
            int iA2 = g.a(b0Var);
            for (int i11 = 0; i11 < iA2; i11++) {
                n5Var2.Q(b0Var.readUtf8LineStrict(Long.MAX_VALUE));
            }
            String str = f12084k;
            String strT = n5Var2.T(str);
            String str2 = f12085l;
            String strT2 = n5Var2.T(str2);
            n5Var2.p0(str);
            n5Var2.p0(str2);
            this.f12090i = strT != null ? Long.parseLong(strT) : 0L;
            this.f12091j = strT2 != null ? Long.parseLong(strT2) : 0L;
            this.g = new r(n5Var2);
            if (this.f12086a.startsWith("https://")) {
                String utf8LineStrict = b0Var.readUtf8LineStrict(Long.MAX_VALUE);
                if (utf8LineStrict.length() > 0) {
                    throw new IOException("expected \"\" but was \"" + utf8LineStrict + "\"");
                }
                this.h = new q(!b0Var.exhausted() ? f0.a(b0Var.readUtf8LineStrict(Long.MAX_VALUE)) : f0.SSL_3_0, l.a(b0Var.readUtf8LineStrict(Long.MAX_VALUE)), q8.c.k(a(b0Var)), q8.c.k(a(b0Var)));
            } else {
                this.h = null;
            }
            h0Var.close();
        } catch (Throwable th) {
            h0Var.close();
            throw th;
        }
    }

    public static List a(z8.b0 b0Var) throws IOException, CertificateException {
        int iA = g.a(b0Var);
        if (iA == -1) {
            return Collections.EMPTY_LIST;
        }
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            ArrayList arrayList = new ArrayList(iA);
            for (int i10 = 0; i10 < iA; i10++) {
                String utf8LineStrict = b0Var.readUtf8LineStrict(Long.MAX_VALUE);
                z8.i iVar = new z8.i();
                iVar.i(z8.l.c(utf8LineStrict));
                arrayList.add(certificateFactory.generateCertificate(new z8.g(iVar, 0)));
            }
            return arrayList;
        } catch (CertificateException e) {
            com.google.gson.internal.a.m(e.getMessage());
            return null;
        }
    }

    public static void b(z8.a0 a0Var, List list) throws IOException, CertificateEncodingException {
        try {
            a0Var.b(list.size());
            a0Var.writeByte(10);
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                byte[] encoded = ((Certificate) list.get(i10)).getEncoded();
                z8.l lVar = z8.l.f14487d;
                encoded.getClass();
                a0Var.writeUtf8(new z8.l(Arrays.copyOf(encoded, encoded.length)).a());
                a0Var.writeByte(10);
            }
        } catch (CertificateEncodingException e) {
            com.google.gson.internal.a.m(e.getMessage());
        }
    }

    public final void c(g1 g1Var) {
        z8.a0 a0Var = new z8.a0(g1Var.j(0));
        String str = this.f12086a;
        a0Var.writeUtf8(str);
        a0Var.writeByte(10);
        a0Var.writeUtf8(this.f12088c);
        a0Var.writeByte(10);
        r rVar = this.f12087b;
        a0Var.b(rVar.d());
        a0Var.writeByte(10);
        int iD = rVar.d();
        for (int i10 = 0; i10 < iD; i10++) {
            a0Var.writeUtf8(rVar.b(i10));
            a0Var.writeUtf8(": ");
            a0Var.writeUtf8(rVar.e(i10));
            a0Var.writeByte(10);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f12089d == x.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.e);
        String str2 = this.f;
        if (str2 != null) {
            sb.append(' ');
            sb.append(str2);
        }
        a0Var.writeUtf8(sb.toString());
        a0Var.writeByte(10);
        r rVar2 = this.g;
        a0Var.b(rVar2.d() + 2);
        a0Var.writeByte(10);
        int iD2 = rVar2.d();
        for (int i11 = 0; i11 < iD2; i11++) {
            a0Var.writeUtf8(rVar2.b(i11));
            a0Var.writeUtf8(": ");
            a0Var.writeUtf8(rVar2.e(i11));
            a0Var.writeByte(10);
        }
        a0Var.writeUtf8(f12084k);
        a0Var.writeUtf8(": ");
        a0Var.b(this.f12090i);
        a0Var.writeByte(10);
        a0Var.writeUtf8(f12085l);
        a0Var.writeUtf8(": ");
        a0Var.b(this.f12091j);
        a0Var.writeByte(10);
        if (str.startsWith("https://")) {
            a0Var.writeByte(10);
            q qVar = this.h;
            a0Var.writeUtf8(qVar.f12149b.f12126a);
            a0Var.writeByte(10);
            b(a0Var, qVar.f12150c);
            b(a0Var, qVar.f12151d);
            a0Var.writeUtf8(qVar.f12148a.f12095a);
            a0Var.writeByte(10);
        }
        a0Var.close();
    }

    public f(b0 b0Var) {
        r rVar;
        z zVar = b0Var.f12063a;
        this.f12086a = zVar.f12205a.f12158i;
        int i10 = t8.d.f12865a;
        r rVar2 = b0Var.h.f12063a.f12207c;
        r rVar3 = b0Var.f;
        Set setF = t8.d.f(rVar3);
        if (setF.isEmpty()) {
            rVar = new r(new n5(18));
        } else {
            n5 n5Var = new n5(18);
            int iD = rVar2.d();
            for (int i11 = 0; i11 < iD; i11++) {
                String strB = rVar2.b(i11);
                if (setF.contains(strB)) {
                    String strE = rVar2.e(i11);
                    n5.S(strB, strE);
                    n5Var.R(strB, strE);
                }
            }
            rVar = new r(n5Var);
        }
        this.f12087b = rVar;
        this.f12088c = zVar.f12206b;
        this.f12089d = b0Var.f12064b;
        this.e = b0Var.f12065c;
        this.f = b0Var.f12066d;
        this.g = rVar3;
        this.h = b0Var.e;
        this.f12090i = b0Var.f12069k;
        this.f12091j = b0Var.f12070l;
    }
}
