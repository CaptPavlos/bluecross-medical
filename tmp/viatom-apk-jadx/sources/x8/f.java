package x8;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f extends h {

    /* renamed from: c, reason: collision with root package name */
    public final Method f13735c;

    /* renamed from: d, reason: collision with root package name */
    public final Method f13736d;

    public f(Method method, Method method2) {
        this.f13735c = method;
        this.f13736d = method2;
    }

    @Override // x8.h
    public final void e(SSLSocket sSLSocket, String str, List list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            ArrayList arrayListB = h.b(list);
            this.f13735c.invoke(sSLParameters, arrayListB.toArray(new String[arrayListB.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw q8.c.a("unable to set ssl parameters", e);
        }
    }

    @Override // x8.h
    public final String h(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f13736d.invoke(sSLSocket, null);
            if (str != null) {
                if (!str.equals("")) {
                    return str;
                }
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw q8.c.a("unable to get selected protocols", e);
        }
    }
}
