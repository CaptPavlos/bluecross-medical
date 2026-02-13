package androidx.core.math;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class MathUtils {
    private MathUtils() {
    }

    public static long addExact(long j10, long j11) {
        long j12 = j10 + j11;
        if ((j10 >= 0) == (j11 >= 0)) {
            if ((j10 >= 0) != (j12 >= 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return j12;
    }

    public static double clamp(double d8, double d10, double d11) {
        return d8 < d10 ? d10 : d8 > d11 ? d11 : d8;
    }

    public static long decrementExact(long j10) {
        if (j10 != Long.MIN_VALUE) {
            return j10 - 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long incrementExact(long j10) {
        if (j10 != Long.MAX_VALUE) {
            return j10 + 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long multiplyExact(long j10, long j11) {
        long j12 = j10 * j11;
        if (j10 == 0 || j11 == 0 || (j12 / j10 == j11 && j12 / j11 == j10)) {
            return j12;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long negateExact(long j10) {
        if (j10 != Long.MIN_VALUE) {
            return -j10;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long subtractExact(long j10, long j11) {
        long j12 = j10 - j11;
        if ((j10 < 0) != (j11 < 0)) {
            if ((j10 < 0) != (j12 < 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return j12;
    }

    public static int toIntExact(long j10) {
        if (j10 > 2147483647L || j10 < -2147483648L) {
            throw new ArithmeticException("integer overflow");
        }
        return (int) j10;
    }

    public static float clamp(float f, float f10, float f11) {
        return f < f10 ? f10 : f > f11 ? f11 : f;
    }

    public static int clamp(int i10, int i11, int i12) {
        return i10 < i11 ? i11 : i10 > i12 ? i12 : i10;
    }

    public static long clamp(long j10, long j11, long j12) {
        return j10 < j11 ? j11 : j10 > j12 ? j12 : j10;
    }

    public static int negateExact(int i10) {
        if (i10 != Integer.MIN_VALUE) {
            return -i10;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int decrementExact(int i10) {
        if (i10 != Integer.MIN_VALUE) {
            return i10 - 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int incrementExact(int i10) {
        if (i10 != Integer.MAX_VALUE) {
            return i10 + 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int multiplyExact(int i10, int i11) {
        int i12 = i10 * i11;
        if (i10 == 0 || i11 == 0 || (i12 / i10 == i11 && i12 / i11 == i10)) {
            return i12;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int addExact(int i10, int i11) {
        int i12 = i10 + i11;
        if ((i10 >= 0) == (i11 >= 0)) {
            if ((i10 >= 0) != (i12 >= 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return i12;
    }

    public static int subtractExact(int i10, int i11) {
        int i12 = i10 - i11;
        if ((i10 < 0) != (i11 < 0)) {
            if ((i10 < 0) != (i12 < 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return i12;
    }
}
