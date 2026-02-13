package n3;

import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.ZonedDateTime;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f11281a = Pattern.compile("^[0-1]*$", 2);

    public static ZonedDateTime a(String str) {
        if (!f11281a.matcher(str).matches() || str.length() != 36) {
            throw new o3.a(androidx.constraintlayout.core.widgets.analyzer.a.x("Undecodable Datetime '", str, "'"));
        }
        if (!h.f11290a.matcher(str).matches()) {
            throw new o3.a(androidx.constraintlayout.core.widgets.analyzer.a.x("Undecodable FixedLong '", str, "'"));
        }
        long j10 = 0;
        int i10 = 0;
        while (i10 < str.length()) {
            int i11 = i10 + 1;
            if (str.charAt(str.length() - i11) == '1') {
                j10 += 1 << i10;
            }
            i10 = i11;
        }
        return ZonedDateTime.ofInstant(Instant.ofEpochMilli(j10 * 100), ZoneId.of("UTC"));
    }
}
