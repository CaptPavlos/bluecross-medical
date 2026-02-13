package j$.com.android.tools.r8;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import j$.time.ZoneOffset;
import j$.time.c;
import j$.time.chrono.ChronoZonedDateTime;
import j$.time.chrono.a0;
import j$.time.chrono.g0;
import j$.time.chrono.i;
import j$.time.chrono.m;
import j$.time.chrono.o;
import j$.time.chrono.s;
import j$.time.chrono.v;
import j$.time.g;
import j$.time.temporal.n;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.concurrent.l;
import j$.util.concurrent.t;
import j$.util.function.b;
import j$.util.function.d;
import j$.util.function.e;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import sun.misc.Unsafe;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ long A(long j10, long j11) {
        long j12 = j10 % j11;
        if (j12 == 0) {
            return 0L;
        }
        return (((j10 ^ j11) >> 63) | 1) > 0 ? j12 : j12 + j11;
    }

    public static /* synthetic */ long B(long j10, long j11) {
        long j12 = j10 / j11;
        return (j10 - (j11 * j12) != 0 && (((j10 ^ j11) >> 63) | 1) < 0) ? j12 - 1 : j12;
    }

    public static /* synthetic */ long C(long j10, long j11) {
        long j12 = j10 - j11;
        if (((j11 ^ j10) >= 0) || ((j10 ^ j12) >= 0)) {
            return j12;
        }
        throw new ArithmeticException();
    }

    public static /* synthetic */ long w(long j10, int i10) {
        long j11 = i10;
        int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(~j11) + Long.numberOfLeadingZeros(j11) + Long.numberOfLeadingZeros(~j10) + Long.numberOfLeadingZeros(j10);
        if (iNumberOfLeadingZeros > 65) {
            return j10 * j11;
        }
        if (iNumberOfLeadingZeros >= 64) {
            if ((j11 != Long.MIN_VALUE) | (j10 >= 0)) {
                long j12 = j10 * j11;
                if (j10 == 0 || j12 / j10 == j11) {
                    return j12;
                }
            }
        }
        throw new ArithmeticException();
    }

    public static /* synthetic */ long x(long j10, long j11) {
        long j12 = j10 + j11;
        if (((j11 ^ j10) < 0) || ((j10 ^ j12) >= 0)) {
            return j12;
        }
        throw new ArithmeticException();
    }

    public static /* synthetic */ Map.Entry y(Object obj, Object obj2) {
        return new AbstractMap.SimpleImmutableEntry(Objects.requireNonNull(obj), Objects.requireNonNull(obj2));
    }

    public static /* synthetic */ boolean z(Unsafe unsafe, Object obj, long j10, l lVar) {
        while (true) {
            Unsafe unsafe2 = unsafe;
            Object obj2 = obj;
            long j11 = j10;
            l lVar2 = lVar;
            if (unsafe2.compareAndSwapObject(obj2, j11, (Object) null, lVar2)) {
                return true;
            }
            if (unsafe2.getObject(obj2, j11) != null) {
                return false;
            }
            unsafe = unsafe2;
            obj = obj2;
            j10 = j11;
            lVar = lVar2;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [j$.util.function.b] */
    public static b d(final DoubleConsumer doubleConsumer, final DoubleConsumer doubleConsumer2) {
        Objects.requireNonNull(doubleConsumer2);
        return new DoubleConsumer() { // from class: j$.util.function.b
            public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer3) {
                return j$.com.android.tools.r8.a.d(this, doubleConsumer3);
            }

            @Override // java.util.function.DoubleConsumer
            public final void accept(double d8) {
                doubleConsumer.accept(d8);
                doubleConsumer2.accept(d8);
            }
        };
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [j$.util.function.d] */
    public static d e(final IntConsumer intConsumer, final IntConsumer intConsumer2) {
        Objects.requireNonNull(intConsumer2);
        return new IntConsumer() { // from class: j$.util.function.d
            public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer3) {
                return j$.com.android.tools.r8.a.e(this, intConsumer3);
            }

            @Override // java.util.function.IntConsumer
            public final void accept(int i10) {
                intConsumer.accept(i10);
                intConsumer2.accept(i10);
            }
        };
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [j$.util.function.e] */
    public static e f(final LongConsumer longConsumer, final LongConsumer longConsumer2) {
        Objects.requireNonNull(longConsumer2);
        return new LongConsumer() { // from class: j$.util.function.e
            public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer3) {
                return j$.com.android.tools.r8.a.f(this, longConsumer3);
            }

            @Override // java.util.function.LongConsumer
            public final void accept(long j10) {
                longConsumer.accept(j10);
                longConsumer2.accept(j10);
            }
        };
    }

    public static t b(BiConsumer biConsumer, BiConsumer biConsumer2) {
        Objects.requireNonNull(biConsumer2);
        return new t(1, biConsumer, biConsumer2);
    }

    public static t c(BiFunction biFunction, Function function) {
        Objects.requireNonNull(function);
        return new t(biFunction, function);
    }

    public static void j(ConcurrentMap concurrentMap, BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        for (Map.Entry entry : concurrentMap.entrySet()) {
            try {
                biConsumer.accept(entry.getKey(), entry.getValue());
            } catch (IllegalStateException unused) {
            }
        }
    }

    public static String D(Object obj, Object obj2) {
        String string;
        String string2;
        String str = "null";
        if (obj == null || (string = obj.toString()) == null) {
            string = "null";
        }
        int length = string.length();
        if (obj2 != null && (string2 = obj2.toString()) != null) {
            str = string2;
        }
        int length2 = str.length();
        char[] cArr = new char[length + length2 + 1];
        string.getChars(0, length, cArr, 0);
        cArr[length] = '=';
        str.getChars(0, length2, cArr, length + 1);
        return new String(cArr);
    }

    public static boolean o(m mVar, q qVar) {
        return qVar instanceof j$.time.temporal.a ? qVar == j$.time.temporal.a.ERA : qVar != null && qVar.e(mVar);
    }

    public static j$.time.chrono.l v(n nVar) {
        Objects.requireNonNull(nVar, "temporal");
        Object objRequireNonNull = (j$.time.chrono.l) nVar.k(r.f9301b);
        s sVar = s.f9188c;
        if (objRequireNonNull == null) {
            objRequireNonNull = Objects.requireNonNull(sVar, "defaultObj");
        }
        return (j$.time.chrono.l) objRequireNonNull;
    }

    public static int k(ChronoZonedDateTime chronoZonedDateTime, q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            int i10 = i.f9168a[((j$.time.temporal.a) qVar).ordinal()];
            if (i10 == 1) {
                throw new j$.time.temporal.t("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
            }
            if (i10 != 2) {
                return chronoZonedDateTime.toLocalDateTime().e(qVar);
            }
            return chronoZonedDateTime.getOffset().f9142b;
        }
        return r.a(chronoZonedDateTime, qVar);
    }

    public static int l(m mVar, q qVar) {
        if (qVar == j$.time.temporal.a.ERA) {
            return mVar.getValue();
        }
        return r.a(mVar, qVar);
    }

    public static long m(m mVar, q qVar) {
        if (qVar == j$.time.temporal.a.ERA) {
            return mVar.getValue();
        }
        if (qVar instanceof j$.time.temporal.a) {
            throw new j$.time.temporal.t(c.a("Unsupported field: ", qVar));
        }
        return qVar.g(mVar);
    }

    public static j$.time.chrono.l E(String str) {
        ConcurrentHashMap concurrentHashMap = j$.time.chrono.a.f9149a;
        Objects.requireNonNull(str, "id");
        while (true) {
            ConcurrentHashMap concurrentHashMap2 = j$.time.chrono.a.f9149a;
            j$.time.chrono.l lVar = (j$.time.chrono.l) concurrentHashMap2.get(str);
            if (lVar == null) {
                lVar = (j$.time.chrono.l) j$.time.chrono.a.f9150b.get(str);
            }
            if (lVar != null) {
                return lVar;
            }
            if (concurrentHashMap2.get(ExifInterface.TAG_RW2_ISO) != null) {
                Iterator it = ServiceLoader.load(j$.time.chrono.l.class).iterator();
                while (it.hasNext()) {
                    j$.time.chrono.l lVar2 = (j$.time.chrono.l) it.next();
                    if (str.equals(lVar2.d()) || str.equals(lVar2.i())) {
                        return lVar2;
                    }
                }
                g.h(str, "Unknown chronology: ");
                return null;
            }
            o oVar = o.f9176l;
            oVar.getClass();
            j$.time.chrono.a.e(oVar, "Hijrah-umalqura");
            v vVar = v.f9191c;
            vVar.getClass();
            j$.time.chrono.a.e(vVar, "Japanese");
            a0 a0Var = a0.f9151c;
            a0Var.getClass();
            j$.time.chrono.a.e(a0Var, "Minguo");
            g0 g0Var = g0.f9162c;
            g0Var.getClass();
            j$.time.chrono.a.e(g0Var, "ThaiBuddhist");
            try {
                for (j$.time.chrono.a aVar : Arrays.asList(new j$.time.chrono.a[0])) {
                    if (!aVar.d().equals(ExifInterface.TAG_RW2_ISO)) {
                        j$.time.chrono.a.e(aVar, aVar.d());
                    }
                }
                s sVar = s.f9188c;
                sVar.getClass();
                j$.time.chrono.a.e(sVar, ExifInterface.TAG_RW2_ISO);
            } catch (Throwable th) {
                throw new ServiceConfigurationError(th.getMessage(), th);
            }
        }
    }

    public static Object s(m mVar, j$.time.format.a aVar) {
        if (aVar == r.f9302c) {
            return j$.time.temporal.b.ERAS;
        }
        return r.c(mVar, aVar);
    }

    public static Object q(j$.time.chrono.e eVar, j$.time.format.a aVar) {
        if (aVar == r.f9300a || aVar == r.e || aVar == r.f9303d) {
            return null;
        }
        if (aVar == r.g) {
            return eVar.toLocalTime();
        }
        if (aVar == r.f9301b) {
            return eVar.getChronology();
        }
        if (aVar == r.f9302c) {
            return j$.time.temporal.b.NANOS;
        }
        return aVar.a(eVar);
    }

    public static boolean n(j$.time.chrono.b bVar, q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).isDateBased();
        }
        return qVar != null && qVar.e(bVar);
    }

    public static long t(j$.time.chrono.e eVar, ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
        return ((eVar.toLocalDate().r() * 86400) + eVar.toLocalTime().H()) - zoneOffset.f9142b;
    }

    public static Object r(ChronoZonedDateTime chronoZonedDateTime, j$.time.format.a aVar) {
        if (aVar == r.e || aVar == r.f9300a) {
            return chronoZonedDateTime.getZone();
        }
        if (aVar == r.f9303d) {
            return chronoZonedDateTime.getOffset();
        }
        if (aVar == r.g) {
            return chronoZonedDateTime.toLocalTime();
        }
        if (aVar == r.f9301b) {
            return chronoZonedDateTime.getChronology();
        }
        if (aVar == r.f9302c) {
            return j$.time.temporal.b.NANOS;
        }
        return aVar.a(chronoZonedDateTime);
    }

    public static int h(j$.time.chrono.e eVar, j$.time.chrono.e eVar2) {
        int iU = eVar.toLocalDate().compareTo(eVar2.toLocalDate());
        return (iU == 0 && (iU = eVar.toLocalTime().compareTo(eVar2.toLocalTime())) == 0) ? ((j$.time.chrono.a) eVar.getChronology()).d().compareTo(eVar2.getChronology().d()) : iU;
    }

    public static Object p(j$.time.chrono.b bVar, j$.time.format.a aVar) {
        if (aVar == r.f9300a || aVar == r.e || aVar == r.f9303d || aVar == r.g) {
            return null;
        }
        if (aVar == r.f9301b) {
            return bVar.getChronology();
        }
        if (aVar == r.f9302c) {
            return j$.time.temporal.b.DAYS;
        }
        return aVar.a(bVar);
    }

    public static j$.time.temporal.m a(j$.time.chrono.b bVar, j$.time.temporal.m mVar) {
        return mVar.a(bVar.r(), j$.time.temporal.a.EPOCH_DAY);
    }

    public static long u(ChronoZonedDateTime chronoZonedDateTime) {
        return ((chronoZonedDateTime.toLocalDate().r() * 86400) + chronoZonedDateTime.toLocalTime().H()) - chronoZonedDateTime.getOffset().f9142b;
    }

    public static int i(ChronoZonedDateTime chronoZonedDateTime, ChronoZonedDateTime chronoZonedDateTime2) {
        int iCompare = Long.compare(chronoZonedDateTime.toEpochSecond(), chronoZonedDateTime2.toEpochSecond());
        return (iCompare == 0 && (iCompare = chronoZonedDateTime.toLocalTime().f9260d - chronoZonedDateTime2.toLocalTime().f9260d) == 0 && (iCompare = chronoZonedDateTime.toLocalDateTime().compareTo(chronoZonedDateTime2.toLocalDateTime())) == 0 && (iCompare = chronoZonedDateTime.getZone().d().compareTo(chronoZonedDateTime2.getZone().d())) == 0) ? ((j$.time.chrono.a) chronoZonedDateTime.getChronology()).d().compareTo(chronoZonedDateTime2.getChronology().d()) : iCompare;
    }

    public static int g(j$.time.chrono.b bVar, j$.time.chrono.b bVar2) {
        int iCompare = Long.compare(bVar.r(), bVar2.r());
        if (iCompare != 0) {
            return iCompare;
        }
        return ((j$.time.chrono.a) bVar.getChronology()).d().compareTo(bVar2.getChronology().d());
    }
}
