package com.google.android.material.datepicker;

import androidx.annotation.Nullable;
import java.util.Calendar;
import java.util.TimeZone;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
class TimeSource {
    private static final TimeSource SYSTEM_TIME_SOURCE = new TimeSource(null, null);

    @Nullable
    private final Long fixedTimeMs;

    @Nullable
    private final TimeZone fixedTimeZone;

    private TimeSource(@Nullable Long l10, @Nullable TimeZone timeZone) {
        this.fixedTimeMs = l10;
        this.fixedTimeZone = timeZone;
    }

    public static TimeSource fixed(long j10) {
        return new TimeSource(Long.valueOf(j10), null);
    }

    public static TimeSource system() {
        return SYSTEM_TIME_SOURCE;
    }

    public Calendar now(@Nullable TimeZone timeZone) {
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l10 = this.fixedTimeMs;
        if (l10 != null) {
            calendar.setTimeInMillis(l10.longValue());
        }
        return calendar;
    }

    public static TimeSource fixed(long j10, @Nullable TimeZone timeZone) {
        return new TimeSource(Long.valueOf(j10), timeZone);
    }

    public Calendar now() {
        return now(this.fixedTimeZone);
    }
}
