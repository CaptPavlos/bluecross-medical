package p8;

import java.text.DateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p {

    /* renamed from: j, reason: collision with root package name */
    public static final Pattern f12139j = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: k, reason: collision with root package name */
    public static final Pattern f12140k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: l, reason: collision with root package name */
    public static final Pattern f12141l = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: m, reason: collision with root package name */
    public static final Pattern f12142m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a, reason: collision with root package name */
    public final String f12143a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12144b;

    /* renamed from: c, reason: collision with root package name */
    public final long f12145c;

    /* renamed from: d, reason: collision with root package name */
    public final String f12146d;
    public final String e;
    public final boolean f;
    public final boolean g;
    public final boolean h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f12147i;

    public p(String str, String str2, long j10, String str3, String str4, boolean z9, boolean z10, boolean z11, boolean z12) {
        this.f12143a = str;
        this.f12144b = str2;
        this.f12145c = j10;
        this.f12146d = str3;
        this.e = str4;
        this.f = z9;
        this.g = z10;
        this.f12147i = z11;
        this.h = z12;
    }

    public static int a(String str, int i10, int i11, boolean z9) {
        while (i10 < i11) {
            char cCharAt = str.charAt(i10);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || (cCharAt >= '0' && cCharAt <= '9') || ((cCharAt >= 'a' && cCharAt <= 'z') || ((cCharAt >= 'A' && cCharAt <= 'Z') || cCharAt == ':'))) == (!z9)) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long b(int r14, java.lang.String r15) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p8.p.b(int, java.lang.String):long");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return pVar.f12143a.equals(this.f12143a) && pVar.f12144b.equals(this.f12144b) && pVar.f12146d.equals(this.f12146d) && pVar.e.equals(this.e) && pVar.f12145c == this.f12145c && pVar.f == this.f && pVar.g == this.g && pVar.h == this.h && pVar.f12147i == this.f12147i;
    }

    public final int hashCode() {
        int iO = androidx.constraintlayout.core.widgets.analyzer.a.o(androidx.constraintlayout.core.widgets.analyzer.a.o(androidx.constraintlayout.core.widgets.analyzer.a.o(androidx.constraintlayout.core.widgets.analyzer.a.o(527, 31, this.f12143a), 31, this.f12144b), 31, this.f12146d), 31, this.e);
        long j10 = this.f12145c;
        return ((((((((iO + ((int) (j10 ^ (j10 >>> 32)))) * 31) + (!this.f ? 1 : 0)) * 31) + (!this.g ? 1 : 0)) * 31) + (!this.h ? 1 : 0)) * 31) + (!this.f12147i ? 1 : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f12143a);
        sb.append('=');
        sb.append(this.f12144b);
        if (this.h) {
            long j10 = this.f12145c;
            if (j10 == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(((DateFormat) t8.c.f12862a.get()).format(new Date(j10)));
            }
        }
        if (!this.f12147i) {
            sb.append("; domain=");
            sb.append(this.f12146d);
        }
        sb.append("; path=");
        sb.append(this.e);
        if (this.f) {
            sb.append("; secure");
        }
        if (this.g) {
            sb.append("; httponly");
        }
        return sb.toString();
    }
}
