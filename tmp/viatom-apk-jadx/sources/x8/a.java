package x8;

import com.google.android.gms.internal.measurement.l5;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import p8.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a extends l5 {

    /* renamed from: a, reason: collision with root package name */
    public final Object f13726a;

    /* renamed from: b, reason: collision with root package name */
    public final Method f13727b;

    public a(Object obj, Method method) {
        this.f13726a = obj;
        this.f13727b = method;
    }

    public final boolean equals(Object obj) {
        return obj instanceof a;
    }

    public final int hashCode() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.l5
    public final List l(List list, String str) throws SSLPeerUnverifiedException {
        try {
            return (List) this.f13727b.invoke(this.f13726a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
        } catch (IllegalAccessException e) {
            u.h(e);
            return null;
        } catch (InvocationTargetException e3) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e3.getMessage());
            sSLPeerUnverifiedException.initCause(e3);
            throw sSLPeerUnverifiedException;
        }
    }
}
