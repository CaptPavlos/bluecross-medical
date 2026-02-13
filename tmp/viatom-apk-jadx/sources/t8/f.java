package t8;

import javax.net.ssl.SSLSocketFactory;
import p8.b0;
import p8.j;
import p8.s;
import p8.t;
import p8.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f implements t {

    /* renamed from: a, reason: collision with root package name */
    public final w f12874a;

    /* renamed from: b, reason: collision with root package name */
    public Object f12875b;

    public f(w wVar) {
        this.f12874a = wVar;
    }

    public static boolean d(b0 b0Var, s sVar) {
        s sVar2 = b0Var.f12063a.f12205a;
        return sVar2.f12157d.equals(sVar.f12157d) && sVar2.e == sVar.e && sVar2.f12154a.equals(sVar.f12154a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0181 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0071 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00fd  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [p8.d0, s8.a, t8.b] */
    /* JADX WARN: Type inference failed for: r10v4 */
    @Override // p8.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final p8.b0 a(t8.e r18) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 524
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t8.f.a(t8.e):p8.b0");
    }

    public final p8.a b(s sVar) {
        SSLSocketFactory sSLSocketFactory;
        y8.c cVar;
        j jVar;
        boolean zEquals = sVar.f12154a.equals("https");
        w wVar = this.f12874a;
        if (zEquals) {
            sSLSocketFactory = wVar.f12184k;
            cVar = wVar.f12186m;
            jVar = wVar.f12187n;
        } else {
            sSLSocketFactory = null;
            cVar = null;
            jVar = null;
        }
        return new p8.a(sVar.f12157d, sVar.e, wVar.f12191r, wVar.f12183j, sSLSocketFactory, cVar, jVar, wVar.f12188o, wVar.f12179b, wVar.f12180c, wVar.g);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001d, code lost:
    
        if (r5 == false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(java.io.IOException r3, s8.f r4, boolean r5, p8.z r6) throws java.io.IOException {
        /*
            r2 = this;
            r4.g(r3)
            p8.w r0 = r2.f12874a
            boolean r0 = r0.f12193u
            r1 = 0
            if (r0 != 0) goto Lb
            goto L2c
        Lb:
            if (r5 == 0) goto L10
            r6.getClass()
        L10:
            boolean r6 = r3 instanceof java.net.ProtocolException
            if (r6 == 0) goto L15
            return r1
        L15:
            boolean r6 = r3 instanceof java.io.InterruptedIOException
            if (r6 == 0) goto L20
            boolean r3 = r3 instanceof java.net.SocketTimeoutException
            if (r3 == 0) goto L2c
            if (r5 != 0) goto L2c
            goto L32
        L20:
            boolean r5 = r3 instanceof javax.net.ssl.SSLHandshakeException
            if (r5 == 0) goto L2d
            java.lang.Throwable r5 = r3.getCause()
            boolean r5 = r5 instanceof java.security.cert.CertificateException
            if (r5 == 0) goto L2d
        L2c:
            return r1
        L2d:
            boolean r3 = r3 instanceof javax.net.ssl.SSLPeerUnverifiedException
            if (r3 == 0) goto L32
            return r1
        L32:
            p8.e0 r3 = r4.f12738c
            if (r3 != 0) goto L5c
            s8.c r3 = r4.f12737b
            if (r3 == 0) goto L45
            int r5 = r3.f12730b
            java.util.ArrayList r3 = r3.f12729a
            int r3 = r3.size()
            if (r5 >= r3) goto L45
            goto L5c
        L45:
            s8.d r3 = r4.g
            int r4 = r3.e
            java.util.List r5 = r3.f12734d
            int r5 = r5.size()
            if (r4 >= r5) goto L52
            goto L5c
        L52:
            java.util.ArrayList r3 = r3.g
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L5b
            goto L5c
        L5b:
            return r1
        L5c:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: t8.f.c(java.io.IOException, s8.f, boolean, p8.z):boolean");
    }
}
