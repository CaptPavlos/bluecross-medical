package j$.time.chrono;

import j$.time.LocalDateTime;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Locale;

/* loaded from: classes2.dex */
public abstract class a implements l {

    /* renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f9149a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f9150b = new ConcurrentHashMap();

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return d().compareTo(((l) obj).d());
    }

    static {
        new Locale("ja", "JP", "JP");
    }

    public static l e(l lVar, String str) {
        String strI;
        l lVar2 = (l) f9149a.putIfAbsent(str, lVar);
        if (lVar2 == null && (strI = lVar.i()) != null) {
            f9150b.putIfAbsent(strI, lVar);
        }
        return lVar2;
    }

    @Override // j$.time.chrono.l
    public e p(LocalDateTime localDateTime) {
        try {
            return o(localDateTime).s(j$.time.k.x(localDateTime));
        } catch (j$.time.b e) {
            throw new j$.time.b("Unable to obtain ChronoLocalDateTime from TemporalAccessor: " + LocalDateTime.class, e);
        }
    }

    @Override // j$.time.chrono.l
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && d().compareTo(((a) obj).d()) == 0;
    }

    @Override // j$.time.chrono.l
    public final int hashCode() {
        return getClass().hashCode() ^ d().hashCode();
    }

    @Override // j$.time.chrono.l
    public final String toString() {
        return d();
    }
}
