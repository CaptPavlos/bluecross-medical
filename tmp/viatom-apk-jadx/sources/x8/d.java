package x8;

import android.os.Build;
import android.util.Log;
import com.google.android.gms.internal.measurement.l5;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import l4.p2;
import p8.x;
import z8.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends h {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f13733c = 1;

    /* renamed from: d, reason: collision with root package name */
    public final Object f13734d;
    public final Object e;
    public final Object f;
    public final Object g;
    public final Object h;

    public d(p2 p2Var, p2 p2Var2, p2 p2Var3, p2 p2Var4) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        Method method;
        Method method2;
        Method method3 = null;
        try {
            Class<?> cls = Class.forName("dalvik.system.CloseGuard");
            Method method4 = cls.getMethod("get", null);
            method = cls.getMethod("open", String.class);
            method2 = cls.getMethod("warnIfOpen", null);
            method3 = method4;
        } catch (Exception unused) {
            method = null;
            method2 = null;
        }
        this.h = new c(method3, method, method2);
        this.f13734d = p2Var;
        this.e = p2Var2;
        this.f = p2Var3;
        this.g = p2Var4;
    }

    public static boolean m(String str, Class cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            try {
                return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", null).invoke(obj, null)).booleanValue();
            } catch (NoSuchMethodException unused2) {
                return true;
            }
        }
    }

    @Override // x8.h
    public void a(SSLSocket sSLSocket) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        switch (this.f13733c) {
            case 1:
                try {
                    ((Method) this.f).invoke(null, sSLSocket);
                    return;
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw q8.c.a("unable to remove alpn", e);
                }
            default:
                return;
        }
    }

    @Override // x8.h
    public l5 c(X509TrustManager x509TrustManager) throws ClassNotFoundException {
        switch (this.f13733c) {
            case 0:
                try {
                    Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
                    break;
                } catch (Exception unused) {
                    return super.c(x509TrustManager);
                }
        }
        return super.c(x509TrustManager);
    }

    @Override // x8.h
    public y8.d d(X509TrustManager x509TrustManager) throws NoSuchMethodException, SecurityException {
        switch (this.f13733c) {
            case 0:
                try {
                    Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
                    declaredMethod.setAccessible(true);
                    return new b(x509TrustManager, declaredMethod);
                } catch (NoSuchMethodException unused) {
                    return new y8.b(x509TrustManager.getAcceptedIssuers());
                }
            default:
                return super.d(x509TrustManager);
        }
    }

    @Override // x8.h
    public final void e(SSLSocket sSLSocket, String str, List list) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int i10 = this.f13733c;
        Object obj = this.f13734d;
        Object obj2 = this.g;
        switch (i10) {
            case 0:
                p2 p2Var = (p2) obj2;
                if (str != null) {
                    ((p2) obj).d(sSLSocket, Boolean.TRUE);
                    ((p2) this.e).d(sSLSocket, str);
                }
                if (p2Var == null || p2Var.b(sSLSocket.getClass()) == null) {
                    return;
                }
                i iVar = new i();
                int size = list.size();
                for (int i11 = 0; i11 < size; i11++) {
                    x xVar = (x) list.get(i11);
                    if (xVar != x.HTTP_1_0) {
                        iVar.k(xVar.f12200a.length());
                        iVar.q(xVar.f12200a);
                    }
                }
                try {
                    p2Var.c(sSLSocket, iVar.readByteArray(iVar.f14479b));
                    return;
                } catch (InvocationTargetException e) {
                    Throwable targetException = e.getTargetException();
                    if (targetException instanceof RuntimeException) {
                        throw ((RuntimeException) targetException);
                    }
                    AssertionError assertionError = new AssertionError("Unexpected exception");
                    assertionError.initCause(targetException);
                    throw assertionError;
                }
            default:
                try {
                    ((Method) obj).invoke(null, sSLSocket, Proxy.newProxyInstance(h.class.getClassLoader(), new Class[]{(Class) obj2, (Class) this.h}, new g(h.b(list))));
                    return;
                } catch (IllegalAccessException | InvocationTargetException e3) {
                    throw q8.c.a("unable to set alpn", e3);
                }
        }
    }

    @Override // x8.h
    public void f(Socket socket, InetSocketAddress inetSocketAddress, int i10) throws IOException {
        switch (this.f13733c) {
            case 0:
                try {
                    socket.connect(inetSocketAddress, i10);
                    return;
                } catch (AssertionError e) {
                    if (!q8.c.n(e)) {
                        throw e;
                    }
                    throw new IOException(e);
                } catch (ClassCastException e3) {
                    if (Build.VERSION.SDK_INT != 26) {
                        throw e3;
                    }
                    IOException iOException = new IOException("Exception in connect");
                    iOException.initCause(e3);
                    throw iOException;
                } catch (SecurityException e7) {
                    IOException iOException2 = new IOException("Exception in connect");
                    iOException2.initCause(e7);
                    throw iOException2;
                }
            default:
                super.f(socket, inetSocketAddress, i10);
                return;
        }
    }

    @Override // x8.h
    public final String h(SSLSocket sSLSocket) {
        switch (this.f13733c) {
            case 0:
                p2 p2Var = (p2) this.f;
                if (p2Var == null || p2Var.b(sSLSocket.getClass()) == null) {
                    return null;
                }
                try {
                    byte[] bArr = (byte[]) p2Var.c(sSLSocket, new Object[0]);
                    if (bArr != null) {
                        return new String(bArr, q8.c.f12292d);
                    }
                    return null;
                } catch (InvocationTargetException e) {
                    Throwable targetException = e.getTargetException();
                    if (targetException instanceof RuntimeException) {
                        throw ((RuntimeException) targetException);
                    }
                    AssertionError assertionError = new AssertionError("Unexpected exception");
                    assertionError.initCause(targetException);
                    throw assertionError;
                }
            default:
                try {
                    g gVar = (g) Proxy.getInvocationHandler(((Method) this.e).invoke(null, sSLSocket));
                    boolean z9 = gVar.f13738b;
                    if (!z9 && gVar.f13739c == null) {
                        h.f13740a.k(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", null);
                        return null;
                    }
                    if (z9) {
                        return null;
                    }
                    return gVar.f13739c;
                } catch (IllegalAccessException e3) {
                    e = e3;
                    throw q8.c.a("unable to get selected protocol", e);
                } catch (InvocationTargetException e7) {
                    e = e7;
                    throw q8.c.a("unable to get selected protocol", e);
                }
        }
    }

    @Override // x8.h
    public Object i() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        switch (this.f13733c) {
            case 0:
                c cVar = (c) this.h;
                Method method = cVar.f13730a;
                if (method == null) {
                    return null;
                }
                try {
                    Object objInvoke = method.invoke(null, null);
                    cVar.f13731b.invoke(objInvoke, "response.body().close()");
                    return objInvoke;
                } catch (Exception unused) {
                    return null;
                }
            default:
                return super.i();
        }
    }

    @Override // x8.h
    public boolean j(String str) throws ClassNotFoundException {
        switch (this.f13733c) {
            case 0:
                try {
                    Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
                    return m(str, cls, cls.getMethod("getInstance", null).invoke(null, null));
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    return true;
                } catch (IllegalAccessException e) {
                    e = e;
                    throw q8.c.a("unable to determine cleartext support", e);
                } catch (IllegalArgumentException e3) {
                    e = e3;
                    throw q8.c.a("unable to determine cleartext support", e);
                } catch (InvocationTargetException e7) {
                    e = e7;
                    throw q8.c.a("unable to determine cleartext support", e);
                }
            default:
                return super.j(str);
        }
    }

    @Override // x8.h
    public void k(int i10, String str, Throwable th) {
        int iMin;
        switch (this.f13733c) {
            case 0:
                int i11 = i10 != 5 ? 3 : 5;
                if (th != null) {
                    str = str + '\n' + Log.getStackTraceString(th);
                }
                int length = str.length();
                int i12 = 0;
                while (i12 < length) {
                    int iIndexOf = str.indexOf(10, i12);
                    if (iIndexOf == -1) {
                        iIndexOf = length;
                    }
                    while (true) {
                        iMin = Math.min(iIndexOf, i12 + 4000);
                        Log.println(i11, "OkHttp", str.substring(i12, iMin));
                        if (iMin >= iIndexOf) {
                            break;
                        } else {
                            i12 = iMin;
                        }
                    }
                    i12 = iMin + 1;
                }
                break;
            default:
                super.k(i10, str, th);
                break;
        }
    }

    @Override // x8.h
    public void l(String str, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        switch (this.f13733c) {
            case 0:
                c cVar = (c) this.h;
                cVar.getClass();
                if (obj != null) {
                    try {
                        cVar.f13732c.invoke(obj, null);
                        break;
                    } catch (Exception unused) {
                    }
                }
                k(5, str, null);
                break;
            default:
                super.l(str, obj);
                break;
        }
    }

    public d(Method method, Method method2, Method method3, Class cls, Class cls2) {
        this.f13734d = method;
        this.e = method2;
        this.f = method3;
        this.g = cls;
        this.h = cls2;
    }
}
