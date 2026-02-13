package s8;

import c1.u0;
import com.mbridge.msdk.foundation.download.Command;
import h0.p;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import p8.e0;
import p8.j;
import p8.q;
import p8.s;
import p8.x;
import p8.z;
import u8.g;
import v8.m;
import v8.w;
import w2.r;
import x8.h;
import z8.a0;
import z8.b0;
import z8.g0;
import z8.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a extends m {

    /* renamed from: b, reason: collision with root package name */
    public final p8.m f12717b;

    /* renamed from: c, reason: collision with root package name */
    public final e0 f12718c;

    /* renamed from: d, reason: collision with root package name */
    public Socket f12719d;
    public Socket e;
    public q f;
    public x g;
    public v8.q h;

    /* renamed from: i, reason: collision with root package name */
    public b0 f12720i;

    /* renamed from: j, reason: collision with root package name */
    public a0 f12721j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f12722k;

    /* renamed from: l, reason: collision with root package name */
    public int f12723l;

    /* renamed from: m, reason: collision with root package name */
    public int f12724m = 1;

    /* renamed from: n, reason: collision with root package name */
    public final ArrayList f12725n = new ArrayList();

    /* renamed from: o, reason: collision with root package name */
    public long f12726o = Long.MAX_VALUE;

    public a(p8.m mVar, e0 e0Var) {
        this.f12717b = mVar;
        this.f12718c = e0Var;
    }

    @Override // v8.m
    public final void a(v8.q qVar) {
        synchronized (this.f12717b) {
            this.f12724m = qVar.e();
        }
    }

    @Override // v8.m
    public final void b(w wVar) {
        wVar.c(5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x007e, code lost:
    
        r10 = r9.f12718c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0084, code lost:
    
        if (r10.f12081a.h == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008e, code lost:
    
        if (r10.f12082b.type() != java.net.Proxy.Type.HTTP) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0092, code lost:
    
        if (r9.f12719d == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a1, code lost:
    
        throw new s8.b(new java.net.ProtocolException("Too many tunnel connections attempted: 21"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a4, code lost:
    
        if (r9.h == null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a6, code lost:
    
        r10 = r9.f12717b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a8, code lost:
    
        monitor-enter(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a9, code lost:
    
        r9.f12724m = r9.h.e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b1, code lost:
    
        monitor-exit(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b6, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(int r10, int r11, int r12, boolean r13, p8.b r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s8.a.c(int, int, int, boolean, p8.b):void");
    }

    public final void d(int i10, int i11, p8.b bVar) throws IOException {
        e0 e0Var = this.f12718c;
        Proxy proxy = e0Var.f12082b;
        InetSocketAddress inetSocketAddress = e0Var.f12083c;
        this.f12719d = (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.HTTP) ? e0Var.f12081a.f12047c.createSocket() : new Socket(proxy);
        bVar.getClass();
        this.f12719d.setSoTimeout(i11);
        try {
            h.f13740a.f(this.f12719d, inetSocketAddress, i10);
            try {
                Socket socket = this.f12719d;
                Logger logger = y.f14516a;
                socket.getClass();
                g0 g0Var = new g0(socket);
                InputStream inputStream = socket.getInputStream();
                inputStream.getClass();
                this.f12720i = new b0(new z8.c(g0Var, new z8.c(inputStream, g0Var)));
                Socket socket2 = this.f12719d;
                socket2.getClass();
                g0 g0Var2 = new g0(socket2);
                OutputStream outputStream = socket2.getOutputStream();
                outputStream.getClass();
                this.f12721j = new a0(new z8.b(0, g0Var2, new z8.b(1, outputStream, g0Var2)));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e3) {
            ConnectException connectException = new ConnectException("Failed to connect to " + inetSocketAddress);
            connectException.initCause(e3);
            throw connectException;
        }
    }

    public final void e(int i10, int i11, int i12, p8.b bVar) throws IOException {
        r rVar = new r(22);
        e0 e0Var = this.f12718c;
        s sVar = e0Var.f12081a.f12045a;
        if (sVar == null) {
            androidx.window.layout.c.k("url == null");
            return;
        }
        rVar.f13463c = sVar;
        rVar.B("Host", q8.c.j(sVar, true));
        rVar.B("Proxy-Connection", "Keep-Alive");
        rVar.B(Command.HTTP_HEADER_USER_AGENT, "okhttp/3.10.0");
        z zVarS = rVar.s();
        s sVar2 = zVarS.f12205a;
        d(i10, i11, bVar);
        String str = "CONNECT " + q8.c.j(sVar2, true) + " HTTP/1.1";
        b0 b0Var = this.f12720i;
        g gVar = new g(null, null, b0Var, this.f12721j);
        b0Var.f14456a.timeout().g(i11);
        this.f12721j.f14450a.timeout().g(i12);
        gVar.e(zVarS.f12207c, str);
        gVar.finishRequest();
        p8.a0 responseHeaders = gVar.readResponseHeaders(false);
        responseHeaders.f12051a = zVarS;
        p8.b0 b0VarA = responseHeaders.a();
        int i13 = b0VarA.f12065c;
        long jA = t8.d.a(b0VarA);
        if (jA == -1) {
            jA = 0;
        }
        u8.e eVarD = gVar.d(jA);
        q8.c.p(eVarD, Integer.MAX_VALUE);
        eVarD.close();
        if (i13 == 200) {
            if (this.f12720i.f14457b.exhausted() && this.f12721j.f14451b.exhausted()) {
                return;
            }
            com.google.gson.internal.a.m("TLS tunnel buffered too many bytes!");
            return;
        }
        if (i13 != 407) {
            com.google.gson.internal.a.m(a3.a.f(i13, "Unexpected response code for CONNECT: "));
        } else {
            e0Var.f12081a.f12048d.getClass();
            com.google.gson.internal.a.m("Failed to authenticate with proxy");
        }
    }

    public final void f(u0 u0Var, p8.b bVar) throws Throwable {
        int i10;
        SSLSocket sSLSocket;
        if (this.f12718c.f12081a.h == null) {
            this.g = x.HTTP_1_1;
            this.e = this.f12719d;
            return;
        }
        bVar.getClass();
        p8.a aVar = this.f12718c.f12081a;
        SSLSocketFactory sSLSocketFactory = aVar.h;
        s sVar = aVar.f12045a;
        SSLSocket sSLSocket2 = null;
        try {
            try {
                i10 = 1;
                sSLSocket = (SSLSocket) sSLSocketFactory.createSocket(this.f12719d, sVar.f12157d, sVar.e, true);
            } catch (Throwable th) {
                th = th;
            }
        } catch (AssertionError e) {
            e = e;
        }
        try {
            boolean z9 = u0Var.a(sSLSocket).f12136b;
            if (z9) {
                h.f13740a.e(sSLSocket, sVar.f12157d, aVar.e);
            }
            sSLSocket.startHandshake();
            SSLSession session = sSLSocket.getSession();
            if ("NONE".equals(session.getProtocol()) || "SSL_NULL_WITH_NULL_NULL".equals(session.getCipherSuite())) {
                throw new IOException("a valid ssl session was not established");
            }
            q qVarA = q.a(session);
            List list = qVarA.f12150c;
            int i11 = 0;
            if (!aVar.f12049i.verify(sVar.f12157d, session)) {
                X509Certificate x509Certificate = (X509Certificate) list.get(0);
                throw new SSLPeerUnverifiedException("Hostname " + sVar.f12157d + " not verified:\n    certificate: " + j.b(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + y8.c.a(x509Certificate));
            }
            aVar.f12050j.a(sVar.f12157d, list);
            String strH = z9 ? h.f13740a.h(sSLSocket) : null;
            this.e = sSLSocket;
            Logger logger = y.f14516a;
            g0 g0Var = new g0(sSLSocket);
            InputStream inputStream = sSLSocket.getInputStream();
            inputStream.getClass();
            this.f12720i = new b0(new z8.c(g0Var, new z8.c(inputStream, g0Var)));
            Socket socket = this.e;
            socket.getClass();
            g0 g0Var2 = new g0(socket);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.getClass();
            this.f12721j = new a0(new z8.b(i11, g0Var2, new z8.b(i10, outputStream, g0Var2)));
            this.f = qVarA;
            this.g = strH != null ? x.a(strH) : x.HTTP_1_1;
            h.f13740a.a(sSLSocket);
            if (this.g == x.HTTP_2) {
                this.e.setSoTimeout(0);
                p pVar = new p();
                pVar.f = m.f13239a;
                pVar.f8393a = true;
                Socket socket2 = this.e;
                String str = this.f12718c.f12081a.f12045a.f12157d;
                b0 b0Var = this.f12720i;
                a0 a0Var = this.f12721j;
                pVar.f8394b = socket2;
                pVar.f8395c = str;
                pVar.f8396d = b0Var;
                pVar.e = a0Var;
                pVar.f = this;
                v8.q qVar = new v8.q(pVar);
                this.h = qVar;
                v8.x xVar = qVar.f13261r;
                synchronized (xVar) {
                    try {
                        if (xVar.e) {
                            throw new IOException("closed");
                        }
                        if (xVar.f13288b) {
                            Logger logger2 = v8.x.g;
                            if (logger2.isLoggable(Level.FINE)) {
                                String strF = v8.e.f13216a.f();
                                byte[] bArr = q8.c.f12289a;
                                Locale locale = Locale.US;
                                logger2.fine(">> CONNECTION " + strF);
                            }
                            z8.j jVar = xVar.f13287a;
                            byte[] bArr2 = v8.e.f13216a.f14488a;
                            jVar.write(Arrays.copyOf(bArr2, bArr2.length));
                            xVar.f13287a.flush();
                        }
                    } finally {
                    }
                }
                qVar.f13261r.j(qVar.f13257n);
                if (qVar.f13257n.c() != 65535) {
                    qVar.f13261r.l(0, r11 - 65535);
                }
                new Thread(qVar.f13262s).start();
            }
        } catch (AssertionError e3) {
            e = e3;
            if (!q8.c.n(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (Throwable th2) {
            th = th2;
            sSLSocket2 = sSLSocket;
            if (sSLSocket2 != null) {
                h.f13740a.a(sSLSocket2);
            }
            q8.c.d(sSLSocket2);
            throw th;
        }
    }

    public final boolean g(p8.a aVar, e0 e0Var) {
        if (this.f12725n.size() >= this.f12724m || this.f12722k) {
            return false;
        }
        p8.b bVar = p8.b.e;
        e0 e0Var2 = this.f12718c;
        p8.a aVar2 = e0Var2.f12081a;
        bVar.getClass();
        boolean zA = aVar2.a(aVar);
        s sVar = aVar.f12045a;
        if (!zA) {
            return false;
        }
        if (sVar.f12157d.equals(e0Var2.f12081a.f12045a.f12157d)) {
            return true;
        }
        if (this.h == null || e0Var == null) {
            return false;
        }
        Proxy.Type type = e0Var.f12082b.type();
        Proxy.Type type2 = Proxy.Type.DIRECT;
        if (type != type2 || e0Var2.f12082b.type() != type2 || !e0Var2.f12083c.equals(e0Var.f12083c) || e0Var.f12081a.f12049i != y8.c.f14135a || !j(sVar)) {
            return false;
        }
        try {
            aVar.f12050j.a(sVar.f12157d, this.f.f12150c);
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public final boolean h(boolean z9) throws SocketException {
        boolean z10;
        if (!this.e.isClosed() && !this.e.isInputShutdown() && !this.e.isOutputShutdown()) {
            v8.q qVar = this.h;
            if (qVar != null) {
                synchronized (qVar) {
                    z10 = qVar.g;
                }
                return !z10;
            }
            if (z9) {
                try {
                    int soTimeout = this.e.getSoTimeout();
                    try {
                        this.e.setSoTimeout(1);
                        boolean zExhausted = this.f12720i.exhausted();
                        Socket socket = this.e;
                        if (zExhausted) {
                            socket.setSoTimeout(soTimeout);
                            return false;
                        }
                        socket.setSoTimeout(soTimeout);
                        return true;
                    } catch (Throwable th) {
                        this.e.setSoTimeout(soTimeout);
                        throw th;
                    }
                } catch (SocketTimeoutException unused) {
                } catch (IOException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public final t8.b i(p8.w wVar, t8.e eVar, f fVar) throws SocketException {
        int i10 = eVar.f12871j;
        if (this.h != null) {
            return new v8.g(eVar, fVar, this.h);
        }
        this.e.setSoTimeout(i10);
        this.f12720i.f14456a.timeout().g(i10);
        this.f12721j.f14450a.timeout().g(eVar.f12872k);
        return new g(wVar, fVar, this.f12720i, this.f12721j);
    }

    public final boolean j(s sVar) {
        int i10 = sVar.e;
        String str = sVar.f12157d;
        s sVar2 = this.f12718c.f12081a.f12045a;
        if (i10 == sVar2.e) {
            if (str.equals(sVar2.f12157d)) {
                return true;
            }
            q qVar = this.f;
            if (qVar != null && y8.c.c(str, (X509Certificate) qVar.f12150c.get(0))) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Connection{");
        e0 e0Var = this.f12718c;
        sb.append(e0Var.f12081a.f12045a.f12157d);
        sb.append(":");
        sb.append(e0Var.f12081a.f12045a.e);
        sb.append(", proxy=");
        sb.append(e0Var.f12082b);
        sb.append(" hostAddress=");
        sb.append(e0Var.f12083c);
        sb.append(" cipherSuite=");
        q qVar = this.f;
        sb.append(qVar != null ? qVar.f12149b : "none");
        sb.append(" protocol=");
        sb.append(this.g);
        sb.append('}');
        return sb.toString();
    }
}
