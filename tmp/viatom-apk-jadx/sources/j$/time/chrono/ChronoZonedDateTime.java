package j$.time.chrono;

import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.b;

/* loaded from: classes2.dex */
public interface ChronoZonedDateTime<D extends b> extends j$.time.temporal.m, Comparable<ChronoZonedDateTime<?>> {
    l getChronology();

    ZoneOffset getOffset();

    ZoneId getZone();

    ChronoZonedDateTime m(ZoneId zoneId);

    long toEpochSecond();

    Instant toInstant();

    b toLocalDate();

    e toLocalDateTime();

    j$.time.k toLocalTime();
}
