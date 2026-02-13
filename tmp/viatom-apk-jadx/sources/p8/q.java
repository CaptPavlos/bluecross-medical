package p8;

import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final f0 f12148a;

    /* renamed from: b, reason: collision with root package name */
    public final l f12149b;

    /* renamed from: c, reason: collision with root package name */
    public final List f12150c;

    /* renamed from: d, reason: collision with root package name */
    public final List f12151d;

    public q(f0 f0Var, l lVar, List list, List list2) {
        this.f12148a = f0Var;
        this.f12149b = lVar;
        this.f12150c = list;
        this.f12151d = list2;
    }

    public static q a(SSLSession sSLSession) throws SSLPeerUnverifiedException {
        Certificate[] peerCertificates;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            androidx.window.layout.c.g("cipherSuite == null");
            return null;
        }
        l lVarA = l.a(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            androidx.window.layout.c.g("tlsVersion == null");
            return null;
        }
        f0 f0VarA = f0.a(protocol);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
            peerCertificates = null;
        }
        List listL = peerCertificates != null ? q8.c.l(peerCertificates) : Collections.EMPTY_LIST;
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new q(f0VarA, lVarA, listL, localCertificates != null ? q8.c.l(localCertificates) : Collections.EMPTY_LIST);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f12148a.equals(qVar.f12148a) && this.f12149b.equals(qVar.f12149b) && this.f12150c.equals(qVar.f12150c) && this.f12151d.equals(qVar.f12151d);
    }

    public final int hashCode() {
        return this.f12151d.hashCode() + ((this.f12150c.hashCode() + ((this.f12149b.hashCode() + ((this.f12148a.hashCode() + 527) * 31)) * 31)) * 31);
    }
}
