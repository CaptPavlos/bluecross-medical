package y8;

import com.google.android.gms.internal.measurement.l5;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import p8.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a extends l5 {

    /* renamed from: a, reason: collision with root package name */
    public final d f14133a;

    public a(d dVar) {
        this.f14133a = dVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof a) && ((a) obj).f14133a.equals(this.f14133a);
    }

    public final int hashCode() {
        return this.f14133a.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.l5
    public final List l(List list, String str) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException, SSLPeerUnverifiedException {
        ArrayDeque arrayDeque = new ArrayDeque(list);
        ArrayList arrayList = new ArrayList();
        arrayList.add(arrayDeque.removeFirst());
        boolean z9 = false;
        for (int i10 = 0; i10 < 9; i10++) {
            X509Certificate x509Certificate = (X509Certificate) androidx.constraintlayout.core.widgets.analyzer.a.t(arrayList, 1);
            X509Certificate x509CertificateFindByIssuerAndSignature = this.f14133a.findByIssuerAndSignature(x509Certificate);
            if (x509CertificateFindByIssuerAndSignature == null) {
                Iterator it = arrayDeque.iterator();
                while (it.hasNext()) {
                    X509Certificate x509Certificate2 = (X509Certificate) it.next();
                    if (x509Certificate.getIssuerDN().equals(x509Certificate2.getSubjectDN())) {
                        try {
                            x509Certificate.verify(x509Certificate2.getPublicKey());
                            it.remove();
                            arrayList.add(x509Certificate2);
                        } catch (GeneralSecurityException unused) {
                            continue;
                        }
                    }
                }
                if (!z9) {
                    u.o(x509Certificate, "Failed to find a trusted cert that signed ");
                    return null;
                }
                return arrayList;
            }
            if (arrayList.size() > 1 || !x509Certificate.equals(x509CertificateFindByIssuerAndSignature)) {
                arrayList.add(x509CertificateFindByIssuerAndSignature);
            }
            if (x509CertificateFindByIssuerAndSignature.getIssuerDN().equals(x509CertificateFindByIssuerAndSignature.getSubjectDN())) {
                try {
                    x509CertificateFindByIssuerAndSignature.verify(x509CertificateFindByIssuerAndSignature.getPublicKey());
                    return arrayList;
                } catch (GeneralSecurityException unused2) {
                }
            }
            z9 = true;
        }
        u.o(arrayList, "Certificate chain too long: ");
        return null;
    }
}
