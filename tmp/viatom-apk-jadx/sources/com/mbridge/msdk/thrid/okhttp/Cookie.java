package com.mbridge.msdk.thrid.okhttp;

import androidx.constraintlayout.core.widgets.analyzer.a;
import androidx.window.layout.c;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okhttp.internal.http.HttpDate;
import com.mbridge.msdk.thrid.okhttp.internal.publicsuffix.PublicSuffixDatabase;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import z8.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class Cookie {
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final boolean secure;
    private final String value;
    private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    public Cookie(Builder builder) {
        String str = builder.name;
        if (str == null) {
            c.k("builder.name == null");
            throw null;
        }
        String str2 = builder.value;
        if (str2 == null) {
            c.k("builder.value == null");
            throw null;
        }
        String str3 = builder.domain;
        if (str3 == null) {
            c.k("builder.domain == null");
            throw null;
        }
        this.name = str;
        this.value = str2;
        this.expiresAt = builder.expiresAt;
        this.domain = str3;
        this.path = builder.path;
        this.secure = builder.secure;
        this.httpOnly = builder.httpOnly;
        this.persistent = builder.persistent;
        this.hostOnly = builder.hostOnly;
    }

    private static int dateCharacterOffset(String str, int i10, int i11, boolean z9) {
        while (i10 < i11) {
            char cCharAt = str.charAt(i10);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || (cCharAt >= '0' && cCharAt <= '9') || ((cCharAt >= 'a' && cCharAt <= 'z') || ((cCharAt >= 'A' && cCharAt <= 'Z') || cCharAt == ':'))) == (!z9)) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    private static boolean domainMatch(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !Util.verifyAsIpAddress(str);
    }

    public static Cookie parse(long j10, HttpUrl httpUrl, String str) throws NumberFormatException {
        long j11;
        String str2;
        int length = str.length();
        char c10 = ';';
        int iDelimiterOffset = Util.delimiterOffset(str, 0, length, ';');
        int iDelimiterOffset2 = Util.delimiterOffset(str, 0, iDelimiterOffset, '=');
        String domain = null;
        if (iDelimiterOffset2 == iDelimiterOffset) {
            return null;
        }
        String strTrimSubstring = Util.trimSubstring(str, 0, iDelimiterOffset2);
        if (strTrimSubstring.isEmpty() || Util.indexOfControlOrNonAscii(strTrimSubstring) != -1) {
            return null;
        }
        String strTrimSubstring2 = Util.trimSubstring(str, iDelimiterOffset2 + 1, iDelimiterOffset);
        if (Util.indexOfControlOrNonAscii(strTrimSubstring2) != -1) {
            return null;
        }
        int i10 = iDelimiterOffset + 1;
        boolean z9 = false;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = true;
        long expires = 253402300799999L;
        long maxAge = -1;
        String strSubstring = null;
        while (i10 < length) {
            int iDelimiterOffset3 = Util.delimiterOffset(str, i10, length, c10);
            int iDelimiterOffset4 = Util.delimiterOffset(str, i10, iDelimiterOffset3, '=');
            String strTrimSubstring3 = Util.trimSubstring(str, i10, iDelimiterOffset4);
            String strTrimSubstring4 = iDelimiterOffset4 < iDelimiterOffset3 ? Util.trimSubstring(str, iDelimiterOffset4 + 1, iDelimiterOffset3) : "";
            if (strTrimSubstring3.equalsIgnoreCase("expires")) {
                try {
                    expires = parseExpires(strTrimSubstring4, 0, strTrimSubstring4.length());
                    z11 = true;
                } catch (NumberFormatException | IllegalArgumentException unused) {
                }
            } else if (strTrimSubstring3.equalsIgnoreCase("max-age")) {
                maxAge = parseMaxAge(strTrimSubstring4);
                z11 = true;
            } else if (strTrimSubstring3.equalsIgnoreCase("domain")) {
                domain = parseDomain(strTrimSubstring4);
                z12 = false;
            } else if (strTrimSubstring3.equalsIgnoreCase(MBridgeConstans.DYNAMIC_VIEW_WX_PATH)) {
                strSubstring = strTrimSubstring4;
            } else if (strTrimSubstring3.equalsIgnoreCase("secure")) {
                z9 = true;
            } else if (strTrimSubstring3.equalsIgnoreCase("httponly")) {
                z10 = true;
            }
            i10 = iDelimiterOffset3 + 1;
            c10 = ';';
        }
        if (maxAge == Long.MIN_VALUE) {
            j11 = Long.MIN_VALUE;
        } else if (maxAge != -1) {
            long j12 = j10 + (maxAge <= 9223372036854775L ? maxAge * 1000 : Long.MAX_VALUE);
            j11 = (j12 < j10 || j12 > HttpDate.MAX_DATE) ? 253402300799999L : j12;
        } else {
            j11 = expires;
        }
        String strHost = httpUrl.host();
        if (domain == null) {
            str2 = strHost;
        } else {
            if (!domainMatch(strHost, domain)) {
                return null;
            }
            str2 = domain;
        }
        if (strHost.length() != str2.length() && PublicSuffixDatabase.get().getEffectiveTldPlusOne(str2) == null) {
            return null;
        }
        if (strSubstring == null || !strSubstring.startsWith("/")) {
            String strEncodedPath = httpUrl.encodedPath();
            int iLastIndexOf = strEncodedPath.lastIndexOf(47);
            strSubstring = iLastIndexOf != 0 ? strEncodedPath.substring(0, iLastIndexOf) : "/";
        }
        return new Cookie(strTrimSubstring, strTrimSubstring2, j11, str2, strSubstring, z9, z10, z12, z11);
    }

    public static List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        List<String> listValues = headers.values("Set-Cookie");
        int size = listValues.size();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < size; i10++) {
            Cookie cookie = parse(httpUrl, listValues.get(i10));
            if (cookie != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(cookie);
            }
        }
        return arrayList != null ? DesugarCollections.unmodifiableList(arrayList) : Collections.EMPTY_LIST;
    }

    private static String parseDomain(String str) {
        if (str.endsWith(".")) {
            f.a();
            return null;
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        String strCanonicalizeHost = Util.canonicalizeHost(str);
        if (strCanonicalizeHost != null) {
            return strCanonicalizeHost;
        }
        f.a();
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static long parseExpires(java.lang.String r12, int r13, int r14) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.Cookie.parseExpires(java.lang.String, int, int):long");
    }

    private static long parseMaxAge(String str) throws NumberFormatException {
        try {
            long j10 = Long.parseLong(str);
            if (j10 <= 0) {
                return Long.MIN_VALUE;
            }
            return j10;
        } catch (NumberFormatException e) {
            if (str.matches("-?\\d+")) {
                return str.startsWith("-") ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e;
        }
    }

    private static boolean pathMatch(HttpUrl httpUrl, String str) {
        String strEncodedPath = httpUrl.encodedPath();
        if (strEncodedPath.equals(str)) {
            return true;
        }
        if (strEncodedPath.startsWith(str)) {
            return str.endsWith("/") || strEncodedPath.charAt(str.length()) == '/';
        }
        return false;
    }

    public String domain() {
        return this.domain;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        return cookie.name.equals(this.name) && cookie.value.equals(this.value) && cookie.domain.equals(this.domain) && cookie.path.equals(this.path) && cookie.expiresAt == this.expiresAt && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly;
    }

    public long expiresAt() {
        return this.expiresAt;
    }

    public int hashCode() {
        int iO = a.o(a.o(a.o(a.o(527, 31, this.name), 31, this.value), 31, this.domain), 31, this.path);
        long j10 = this.expiresAt;
        return ((((((((iO + ((int) (j10 ^ (j10 >>> 32)))) * 31) + (!this.secure ? 1 : 0)) * 31) + (!this.httpOnly ? 1 : 0)) * 31) + (!this.persistent ? 1 : 0)) * 31) + (!this.hostOnly ? 1 : 0);
    }

    public boolean hostOnly() {
        return this.hostOnly;
    }

    public boolean httpOnly() {
        return this.httpOnly;
    }

    public boolean matches(HttpUrl httpUrl) {
        if ((this.hostOnly ? httpUrl.host().equals(this.domain) : domainMatch(httpUrl.host(), this.domain)) && pathMatch(httpUrl, this.path)) {
            return !this.secure || httpUrl.isHttps();
        }
        return false;
    }

    public String name() {
        return this.name;
    }

    public String path() {
        return this.path;
    }

    public boolean persistent() {
        return this.persistent;
    }

    public boolean secure() {
        return this.secure;
    }

    public String toString(boolean z9) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append('=');
        sb.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(HttpDate.format(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            sb.append("; domain=");
            if (z9) {
                sb.append(".");
            }
            sb.append(this.domain);
        }
        sb.append("; path=");
        sb.append(this.path);
        if (this.secure) {
            sb.append("; secure");
        }
        if (this.httpOnly) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public String value() {
        return this.value;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Builder {
        String domain;
        boolean hostOnly;
        boolean httpOnly;
        String name;
        boolean persistent;
        boolean secure;
        String value;
        long expiresAt = HttpDate.MAX_DATE;
        String path = "/";

        private Builder domain(String str, boolean z9) {
            if (str == null) {
                c.k("domain == null");
                return null;
            }
            String strCanonicalizeHost = Util.canonicalizeHost(str);
            if (strCanonicalizeHost == null) {
                com.google.gson.internal.a.n("unexpected domain: ".concat(str));
                return null;
            }
            this.domain = strCanonicalizeHost;
            this.hostOnly = z9;
            return this;
        }

        public Cookie build() {
            return new Cookie(this);
        }

        public Builder expiresAt(long j10) {
            if (j10 <= 0) {
                j10 = Long.MIN_VALUE;
            }
            if (j10 > HttpDate.MAX_DATE) {
                j10 = 253402300799999L;
            }
            this.expiresAt = j10;
            this.persistent = true;
            return this;
        }

        public Builder hostOnlyDomain(String str) {
            return domain(str, true);
        }

        public Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        public Builder name(String str) {
            if (str == null) {
                c.k("name == null");
                return null;
            }
            if (str.trim().equals(str)) {
                this.name = str;
                return this;
            }
            com.google.gson.internal.a.n("name is not trimmed");
            return null;
        }

        public Builder path(String str) {
            if (str.startsWith("/")) {
                this.path = str;
                return this;
            }
            com.google.gson.internal.a.n("path must start with '/'");
            return null;
        }

        public Builder secure() {
            this.secure = true;
            return this;
        }

        public Builder value(String str) {
            if (str == null) {
                c.k("value == null");
                return null;
            }
            if (str.trim().equals(str)) {
                this.value = str;
                return this;
            }
            com.google.gson.internal.a.n("value is not trimmed");
            return null;
        }

        public Builder domain(String str) {
            return domain(str, false);
        }
    }

    private Cookie(String str, String str2, long j10, String str3, String str4, boolean z9, boolean z10, boolean z11, boolean z12) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j10;
        this.domain = str3;
        this.path = str4;
        this.secure = z9;
        this.httpOnly = z10;
        this.hostOnly = z11;
        this.persistent = z12;
    }

    public String toString() {
        return toString(false);
    }

    public static Cookie parse(HttpUrl httpUrl, String str) {
        return parse(System.currentTimeMillis(), httpUrl, str);
    }
}
