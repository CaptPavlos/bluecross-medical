package c1;

import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.util.Calendar;
import java.util.Locale;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q extends f2 {

    /* renamed from: c, reason: collision with root package name */
    public long f1405c;

    /* renamed from: d, reason: collision with root package name */
    public String f1406d;

    @Override // c1.f2
    public final boolean h() {
        Calendar calendar = Calendar.getInstance();
        this.f1405c = (calendar.get(16) + calendar.get(15)) / ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS;
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        String lowerCase = language.toLowerCase(locale2);
        String lowerCase2 = locale.getCountry().toLowerCase(locale2);
        this.f1406d = androidx.constraintlayout.core.widgets.analyzer.a.y(new StringBuilder(String.valueOf(lowerCase).length() + 1 + String.valueOf(lowerCase2).length()), lowerCase, "-", lowerCase2);
        return false;
    }

    public final long k() {
        i();
        return this.f1405c;
    }

    public final String l() {
        i();
        return this.f1406d;
    }
}
