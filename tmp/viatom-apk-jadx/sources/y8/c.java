package y8;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c implements HostnameVerifier {

    /* renamed from: a, reason: collision with root package name */
    public static final c f14135a = new c();

    public static ArrayList a(X509Certificate x509Certificate) throws CertificateParsingException {
        List listB = b(x509Certificate, 7);
        List listB2 = b(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(listB2.size() + listB.size());
        arrayList.addAll(listB);
        arrayList.addAll(listB2);
        return arrayList;
    }

    public static List b(X509Certificate x509Certificate, int i10) throws CertificateParsingException {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.EMPTY_LIST;
            }
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i10 && (str = (String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.EMPTY_LIST;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[LOOP:1: B:11:0x003a->B:70:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean c(java.lang.String r8, java.security.cert.X509Certificate r9) throws java.security.cert.CertificateParsingException {
        /*
            java.util.regex.Pattern r0 = q8.c.g
            java.util.regex.Matcher r0 = r0.matcher(r8)
            boolean r0 = r0.matches()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L2b
            r0 = 7
            java.util.List r9 = b(r9, r0)
            int r0 = r9.size()
            r3 = r1
        L18:
            if (r3 >= r0) goto Le7
            java.lang.Object r4 = r9.get(r3)
            java.lang.String r4 = (java.lang.String) r4
            boolean r4 = r8.equalsIgnoreCase(r4)
            if (r4 == 0) goto L28
            goto Le6
        L28:
            int r3 = r3 + 1
            goto L18
        L2b:
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r8 = r8.toLowerCase(r0)
            r0 = 2
            java.util.List r9 = b(r9, r0)
            java.util.Iterator r9 = r9.iterator()
        L3a:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto Le7
            java.lang.Object r0 = r9.next()
            java.lang.String r0 = (java.lang.String) r0
            if (r8 == 0) goto Lb9
            int r3 = r8.length()
            if (r3 == 0) goto Lb9
            java.lang.String r3 = "."
            boolean r4 = r8.startsWith(r3)
            if (r4 != 0) goto Lb9
            java.lang.String r4 = ".."
            boolean r5 = r8.endsWith(r4)
            if (r5 == 0) goto L5f
            goto Lb9
        L5f:
            if (r0 == 0) goto Lb9
            int r5 = r0.length()
            if (r5 == 0) goto Lb9
            boolean r5 = r0.startsWith(r3)
            if (r5 != 0) goto Lb9
            boolean r4 = r0.endsWith(r4)
            if (r4 == 0) goto L74
            goto Lb9
        L74:
            boolean r4 = r8.endsWith(r3)
            if (r4 != 0) goto L7f
            java.lang.String r4 = r8.concat(r3)
            goto L80
        L7f:
            r4 = r8
        L80:
            boolean r5 = r0.endsWith(r3)
            if (r5 != 0) goto L8a
            java.lang.String r0 = r0.concat(r3)
        L8a:
            java.util.Locale r3 = java.util.Locale.US
            java.lang.String r0 = r0.toLowerCase(r3)
            java.lang.String r3 = "*"
            boolean r3 = r0.contains(r3)
            if (r3 != 0) goto L9d
            boolean r0 = r4.equals(r0)
            goto Le4
        L9d:
            java.lang.String r3 = "*."
            boolean r5 = r0.startsWith(r3)
            if (r5 == 0) goto Lb9
            r5 = 42
            int r5 = r0.indexOf(r5, r2)
            r6 = -1
            if (r5 == r6) goto Laf
            goto Lb9
        Laf:
            int r5 = r4.length()
            int r7 = r0.length()
            if (r5 >= r7) goto Lbb
        Lb9:
            r0 = r1
            goto Le4
        Lbb:
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto Lc2
            goto Lb9
        Lc2:
            java.lang.String r0 = r0.substring(r2)
            boolean r3 = r4.endsWith(r0)
            if (r3 != 0) goto Lcd
            goto Lb9
        Lcd:
            int r3 = r4.length()
            int r0 = r0.length()
            int r3 = r3 - r0
            if (r3 <= 0) goto Le3
            int r3 = r3 + (-1)
            r0 = 46
            int r0 = r4.lastIndexOf(r0, r3)
            if (r0 == r6) goto Le3
            goto Lb9
        Le3:
            r0 = r2
        Le4:
            if (r0 == 0) goto L3a
        Le6:
            return r2
        Le7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: y8.c.c(java.lang.String, java.security.cert.X509Certificate):boolean");
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        try {
            return c(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }
}
