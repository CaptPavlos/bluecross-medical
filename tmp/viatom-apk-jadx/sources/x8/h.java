package x8;

import com.google.android.gms.internal.measurement.l5;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import l4.p2;
import p8.w;
import p8.x;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f13740a;

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f13741b;

    static {
        h hVar;
        p2 p2Var;
        p2 p2Var2;
        Class<byte[]> cls = byte[].class;
        d dVar = null;
        try {
            try {
                Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                hVar = null;
            }
        } catch (ClassNotFoundException unused2) {
            Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
        }
        int i10 = 12;
        p2 p2Var3 = new p2(dVar, "setUseSessionTickets", new Class[]{Boolean.TYPE}, i10);
        p2 p2Var4 = new p2(dVar, "setHostname", new Class[]{String.class}, i10);
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            p2Var = new p2(cls, "getAlpnSelectedProtocol", new Class[0], i10);
            p2Var2 = new p2(dVar, "setAlpnProtocols", new Class[]{byte[].class}, i10);
            hVar = new d(p2Var3, p2Var4, p2Var, p2Var2);
        } else {
            try {
                Class.forName("android.net.Network");
                p2Var = new p2(cls, "getAlpnSelectedProtocol", new Class[0], i10);
                p2Var2 = new p2(dVar, "setAlpnProtocols", new Class[]{byte[].class}, i10);
            } catch (ClassNotFoundException unused3) {
                p2Var = null;
                p2Var2 = null;
            }
            hVar = new d(p2Var3, p2Var4, p2Var, p2Var2);
        }
        if (hVar == null) {
            if (!("conscrypt".equals(System.getProperty("okhttp.platform")) ? true : "Conscrypt".equals(Security.getProviders()[0].getName())) || (hVar = e.m()) == null) {
                try {
                    hVar = new f(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", null));
                } catch (NoSuchMethodException unused4) {
                    hVar = null;
                }
                if (hVar == null) {
                    try {
                        Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN");
                        dVar = new d(cls2.getMethod("put", SSLSocket.class, Class.forName("org.eclipse.jetty.alpn.ALPN$Provider")), cls2.getMethod("get", SSLSocket.class), cls2.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
                    } catch (ClassNotFoundException | NoSuchMethodException unused5) {
                    }
                    hVar = dVar != null ? dVar : new h();
                }
            }
        }
        f13740a = hVar;
        f13741b = Logger.getLogger(w.class.getName());
    }

    public static ArrayList b(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            x xVar = (x) list.get(i10);
            if (xVar != x.HTTP_1_0) {
                arrayList.add(xVar.f12200a);
            }
        }
        return arrayList;
    }

    public l5 c(X509TrustManager x509TrustManager) {
        return new y8.a(d(x509TrustManager));
    }

    public y8.d d(X509TrustManager x509TrustManager) {
        return new y8.b(x509TrustManager.getAcceptedIssuers());
    }

    public void f(Socket socket, InetSocketAddress inetSocketAddress, int i10) {
        socket.connect(inetSocketAddress, i10);
    }

    public SSLContext g() {
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }

    public String h(SSLSocket sSLSocket) {
        return null;
    }

    public Object i() {
        if (f13741b.isLoggable(Level.FINE)) {
            return new Throwable("response.body().close()");
        }
        return null;
    }

    public boolean j(String str) {
        return true;
    }

    public void k(int i10, String str, Throwable th) {
        f13741b.log(i10 == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void l(String str, Object obj) {
        if (obj == null) {
            str = str.concat(" To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        k(5, str, (Throwable) obj);
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void e(SSLSocket sSLSocket, String str, List list) {
    }
}
