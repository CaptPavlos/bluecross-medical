package p8;

import com.google.android.gms.internal.measurement.l5;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j {

    /* renamed from: c, reason: collision with root package name */
    public static final j f12112c = new j(new LinkedHashSet(new ArrayList()), null);

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f12113a;

    /* renamed from: b, reason: collision with root package name */
    public final l5 f12114b;

    public j(LinkedHashSet linkedHashSet, l5 l5Var) {
        this.f12113a = linkedHashSet;
        this.f12114b = l5Var;
    }

    public static String b(X509Certificate x509Certificate) throws NoSuchAlgorithmException {
        if (!com.mbridge.msdk.dycreator.baseview.a.w(x509Certificate)) {
            com.google.gson.internal.a.n("Certificate pinning requires X509 certificates");
            return null;
        }
        StringBuilder sb = new StringBuilder("sha256/");
        byte[] encoded = x509Certificate.getPublicKey().getEncoded();
        z8.l lVar = z8.l.f14487d;
        encoded.getClass();
        byte[] bArrCopyOf = Arrays.copyOf(encoded, encoded.length);
        z8.l lVar2 = new z8.l(bArrCopyOf);
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(bArrCopyOf, 0, lVar2.e());
        byte[] bArrDigest = messageDigest.digest();
        bArrDigest.getClass();
        sb.append(new z8.l(bArrDigest).a());
        return sb.toString();
    }

    public final void a(String str, List list) {
        List list2 = Collections.EMPTY_LIST;
        Iterator it = this.f12113a.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            com.google.gson.internal.a.k();
            return;
        }
        if (list2.isEmpty()) {
            return;
        }
        l5 l5Var = this.f12114b;
        if (l5Var != null) {
            list = l5Var.l(list, str);
        }
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (list2.size() > 0) {
                list2.get(0).getClass();
                com.google.gson.internal.a.k();
                return;
            }
        }
        StringBuilder sb = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
        int size2 = list.size();
        for (int i11 = 0; i11 < size2; i11++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i11);
            sb.append("\n    ");
            sb.append(b(x509Certificate));
            sb.append(": ");
            sb.append(x509Certificate.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        int size3 = list2.size();
        for (int i12 = 0; i12 < size3; i12++) {
            if (list2.get(i12) != null) {
                com.google.gson.internal.a.k();
                return;
            }
            sb.append("\n    null");
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return q8.c.i(this.f12114b, jVar.f12114b) && this.f12113a.equals(jVar.f12113a);
    }

    public final int hashCode() {
        l5 l5Var = this.f12114b;
        return this.f12113a.hashCode() + ((l5Var != null ? l5Var.hashCode() : 0) * 31);
    }
}
