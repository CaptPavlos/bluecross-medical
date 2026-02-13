package com.mbridge.msdk.thrid.okhttp;

import androidx.window.layout.c;
import com.google.gson.internal.a;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okhttp.internal.tls.CertificateChainCleaner;
import com.mbridge.msdk.thrid.okio.ByteString;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class CertificatePinner {
    public static final CertificatePinner DEFAULT = new Builder().build();
    private final CertificateChainCleaner certificateChainCleaner;
    private final Set<Pin> pins;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Builder {
        private final List<Pin> pins = new ArrayList();

        public Builder add(String str, String... strArr) {
            if (str == null) {
                c.k("pattern == null");
                return null;
            }
            for (String str2 : strArr) {
                this.pins.add(new Pin(str, str2));
            }
            return this;
        }

        public CertificatePinner build() {
            return new CertificatePinner(new LinkedHashSet(this.pins), null);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Pin {
        private static final String WILDCARD = "*.";
        final String canonicalHostname;
        final ByteString hash;
        final String hashAlgorithm;
        final String pattern;

        public Pin(String str, String str2) {
            this.pattern = str;
            this.canonicalHostname = str.startsWith(WILDCARD) ? HttpUrl.get("http://".concat(str.substring(2))).host() : HttpUrl.get("http://".concat(str)).host();
            if (str2.startsWith("sha1/")) {
                this.hashAlgorithm = "sha1/";
                this.hash = ByteString.decodeBase64(str2.substring(5));
            } else {
                if (!str2.startsWith("sha256/")) {
                    a.n("pins must start with 'sha256/' or 'sha1/': ".concat(str2));
                    throw null;
                }
                this.hashAlgorithm = "sha256/";
                this.hash = ByteString.decodeBase64(str2.substring(7));
            }
            if (this.hash != null) {
                return;
            }
            a.n("pins must be base64: ".concat(str2));
            throw null;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Pin)) {
                return false;
            }
            Pin pin = (Pin) obj;
            return this.pattern.equals(pin.pattern) && this.hashAlgorithm.equals(pin.hashAlgorithm) && this.hash.equals(pin.hash);
        }

        public int hashCode() {
            return this.hash.hashCode() + androidx.constraintlayout.core.widgets.analyzer.a.o(androidx.constraintlayout.core.widgets.analyzer.a.o(527, 31, this.pattern), 31, this.hashAlgorithm);
        }

        public boolean matches(String str) {
            if (!this.pattern.startsWith(WILDCARD)) {
                return str.equals(this.canonicalHostname);
            }
            int iIndexOf = str.indexOf(46);
            if ((str.length() - iIndexOf) - 1 != this.canonicalHostname.length()) {
                return false;
            }
            String str2 = this.canonicalHostname;
            return str.regionMatches(false, iIndexOf + 1, str2, 0, str2.length());
        }

        public String toString() {
            return this.hashAlgorithm + this.hash.base64();
        }
    }

    public CertificatePinner(Set<Pin> set, CertificateChainCleaner certificateChainCleaner) {
        this.pins = set;
        this.certificateChainCleaner = certificateChainCleaner;
    }

    public static String pin(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            a.n("Certificate pinning requires X509 certificates");
            return null;
        }
        return "sha256/" + sha256((X509Certificate) certificate).base64();
    }

    public static ByteString sha1(X509Certificate x509Certificate) {
        return ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha1();
    }

    public static ByteString sha256(X509Certificate x509Certificate) {
        return ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha256();
    }

    public void check(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<Pin> listFindMatchingPins = findMatchingPins(str);
        if (listFindMatchingPins.isEmpty()) {
            return;
        }
        CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
        if (certificateChainCleaner != null) {
            list = certificateChainCleaner.clean(list, str);
        }
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i10);
            int size2 = listFindMatchingPins.size();
            ByteString byteStringSha256 = null;
            ByteString byteStringSha1 = null;
            for (int i11 = 0; i11 < size2; i11++) {
                Pin pin = listFindMatchingPins.get(i11);
                if (pin.hashAlgorithm.equals("sha256/")) {
                    if (byteStringSha256 == null) {
                        byteStringSha256 = sha256(x509Certificate);
                    }
                    if (pin.hash.equals(byteStringSha256)) {
                        return;
                    }
                } else {
                    if (!pin.hashAlgorithm.equals("sha1/")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + pin.hashAlgorithm);
                    }
                    if (byteStringSha1 == null) {
                        byteStringSha1 = sha1(x509Certificate);
                    }
                    if (pin.hash.equals(byteStringSha1)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i12 = 0; i12 < size3; i12++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i12);
            sb.append("\n    ");
            sb.append(pin(x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        int size4 = listFindMatchingPins.size();
        for (int i13 = 0; i13 < size4; i13++) {
            Pin pin2 = listFindMatchingPins.get(i13);
            sb.append("\n    ");
            sb.append(pin2);
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CertificatePinner)) {
            return false;
        }
        CertificatePinner certificatePinner = (CertificatePinner) obj;
        return Util.equal(this.certificateChainCleaner, certificatePinner.certificateChainCleaner) && this.pins.equals(certificatePinner.pins);
    }

    public List<Pin> findMatchingPins(String str) {
        List<Pin> arrayList = Collections.EMPTY_LIST;
        for (Pin pin : this.pins) {
            if (pin.matches(str)) {
                if (arrayList.isEmpty()) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(pin);
            }
        }
        return arrayList;
    }

    public int hashCode() {
        CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
        return this.pins.hashCode() + ((certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0) * 31);
    }

    public CertificatePinner withCertificateChainCleaner(CertificateChainCleaner certificateChainCleaner) {
        return Util.equal(this.certificateChainCleaner, certificateChainCleaner) ? this : new CertificatePinner(this.pins, certificateChainCleaner);
    }

    public void check(String str, Certificate... certificateArr) throws SSLPeerUnverifiedException {
        check(str, Arrays.asList(certificateArr));
    }
}
