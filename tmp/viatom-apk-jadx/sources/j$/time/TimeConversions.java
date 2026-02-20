package j$.time;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* loaded from: classes2.dex */
public class TimeConversions {
    public static Duration convert(java.time.Duration duration) {
        if (duration == null) {
            return null;
        }
        long seconds = duration.getSeconds();
        long nano = duration.getNano();
        Duration duration2 = Duration.f9127c;
        return Duration.e(j$.com.android.tools.r8.a.x(seconds, j$.com.android.tools.r8.a.B(nano, C.NANOS_PER_SECOND)), (int) j$.com.android.tools.r8.a.A(nano, C.NANOS_PER_SECOND));
    }

    public static java.time.Instant convert(Instant instant) {
        if (instant == null) {
            return null;
        }
        return java.time.Instant.ofEpochSecond(instant.f9131a, instant.f9132b);
    }

    public static java.time.Duration convert(Duration duration) {
        if (duration == null) {
            return null;
        }
        return java.time.Duration.ofSeconds(duration.f9128a, duration.f9129b);
    }
}
