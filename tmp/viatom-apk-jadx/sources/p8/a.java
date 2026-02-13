package p8;

import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final s f12045a;

    /* renamed from: b, reason: collision with root package name */
    public final b f12046b;

    /* renamed from: c, reason: collision with root package name */
    public final SocketFactory f12047c;

    /* renamed from: d, reason: collision with root package name */
    public final b f12048d;
    public final List e;
    public final List f;
    public final ProxySelector g;
    public final SSLSocketFactory h;

    /* renamed from: i, reason: collision with root package name */
    public final HostnameVerifier f12049i;

    /* renamed from: j, reason: collision with root package name */
    public final j f12050j;

    public a(String str, int i10, b bVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, y8.c cVar, j jVar, b bVar2, List list, List list2, ProxySelector proxySelector) {
        h5.c cVar2 = new h5.c(1);
        String str2 = sSLSocketFactory != null ? "https" : "http";
        if (str2.equalsIgnoreCase("http")) {
            cVar2.f8481b = "http";
        } else {
            if (!str2.equalsIgnoreCase("https")) {
                com.google.gson.internal.a.n("unexpected scheme: ".concat(str2));
                throw null;
            }
            cVar2.f8481b = "https";
        }
        if (str == null) {
            androidx.window.layout.c.k("host == null");
            throw null;
        }
        String strB = q8.c.b(s.h(str, 0, str.length(), false));
        if (strB == null) {
            com.google.gson.internal.a.n("unexpected host: ".concat(str));
            throw null;
        }
        cVar2.e = strB;
        if (i10 <= 0 || i10 > 65535) {
            com.google.gson.internal.a.n(a3.a.f(i10, "unexpected port: "));
            throw null;
        }
        cVar2.f = i10;
        this.f12045a = cVar2.a();
        if (bVar == null) {
            androidx.window.layout.c.k("dns == null");
            throw null;
        }
        this.f12046b = bVar;
        if (socketFactory == null) {
            androidx.window.layout.c.k("socketFactory == null");
            throw null;
        }
        this.f12047c = socketFactory;
        if (bVar2 == null) {
            androidx.window.layout.c.k("proxyAuthenticator == null");
            throw null;
        }
        this.f12048d = bVar2;
        if (list == null) {
            androidx.window.layout.c.k("protocols == null");
            throw null;
        }
        this.e = q8.c.k(list);
        if (list2 == null) {
            androidx.window.layout.c.k("connectionSpecs == null");
            throw null;
        }
        this.f = q8.c.k(list2);
        if (proxySelector == null) {
            androidx.window.layout.c.k("proxySelector == null");
            throw null;
        }
        this.g = proxySelector;
        this.h = sSLSocketFactory;
        this.f12049i = cVar;
        this.f12050j = jVar;
    }

    public final boolean a(a aVar) {
        return this.f12046b.equals(aVar.f12046b) && this.f12048d.equals(aVar.f12048d) && this.e.equals(aVar.e) && this.f.equals(aVar.f) && this.g.equals(aVar.g) && q8.c.i(null, null) && q8.c.i(this.h, aVar.h) && q8.c.i(this.f12049i, aVar.f12049i) && q8.c.i(this.f12050j, aVar.f12050j) && this.f12045a.e == aVar.f12045a.e;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f12045a.equals(aVar.f12045a) && a(aVar);
    }

    public final int hashCode() {
        int iHashCode = (this.g.hashCode() + ((this.f.hashCode() + ((this.e.hashCode() + ((this.f12048d.hashCode() + ((this.f12046b.hashCode() + androidx.constraintlayout.core.widgets.analyzer.a.o(527, 31, this.f12045a.f12158i)) * 31)) * 31)) * 31)) * 31)) * 961;
        SSLSocketFactory sSLSocketFactory = this.h;
        int iHashCode2 = (iHashCode + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.f12049i;
        int iHashCode3 = (iHashCode2 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        j jVar = this.f12050j;
        return iHashCode3 + (jVar != null ? jVar.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Address{");
        s sVar = this.f12045a;
        sb.append(sVar.f12157d);
        sb.append(":");
        sb.append(sVar.e);
        sb.append(", proxySelector=");
        sb.append(this.g);
        sb.append("}");
        return sb.toString();
    }
}
