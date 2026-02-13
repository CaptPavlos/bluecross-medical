package x8;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b implements y8.d {

    /* renamed from: a, reason: collision with root package name */
    public final X509TrustManager f13728a;

    /* renamed from: b, reason: collision with root package name */
    public final Method f13729b;

    public b(X509TrustManager x509TrustManager, Method method) {
        this.f13729b = method;
        this.f13728a = x509TrustManager;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f13728a.equals(bVar.f13728a) && this.f13729b.equals(bVar.f13729b);
    }

    @Override // y8.d
    public final X509Certificate findByIssuerAndSignature(X509Certificate x509Certificate) {
        try {
            TrustAnchor trustAnchor = (TrustAnchor) this.f13729b.invoke(this.f13728a, x509Certificate);
            if (trustAnchor != null) {
                return trustAnchor.getTrustedCert();
            }
            return null;
        } catch (IllegalAccessException e) {
            throw q8.c.a("unable to get issues and signature", e);
        } catch (InvocationTargetException unused) {
            return null;
        }
    }

    public final int hashCode() {
        return (this.f13729b.hashCode() * 31) + this.f13728a.hashCode();
    }
}
