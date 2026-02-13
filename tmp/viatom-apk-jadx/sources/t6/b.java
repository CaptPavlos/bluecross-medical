package t6;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {
    public static void a(int i10, int i11, int i12) {
        if (i10 < 0 || i11 > i12) {
            com.google.gson.internal.a.f(i12, a3.a.q(i10, i11, "startIndex: ", ", endIndex: ", ", size: "));
        } else {
            if (i10 <= i11) {
                return;
            }
            com.google.gson.internal.a.n(androidx.constraintlayout.core.widgets.analyzer.a.u(i10, i11, "startIndex: ", " > endIndex: "));
        }
    }

    public static void b(int i10, int i11) {
        if (i10 < 0 || i10 >= i11) {
            p8.u.k(androidx.constraintlayout.core.widgets.analyzer.a.u(i10, i11, "index: ", ", size: "));
        }
    }

    public static void c(int i10, int i11) {
        if (i10 < 0 || i10 > i11) {
            p8.u.k(androidx.constraintlayout.core.widgets.analyzer.a.u(i10, i11, "index: ", ", size: "));
        }
    }

    public static void d(int i10, int i11, int i12) {
        if (i10 < 0 || i11 > i12) {
            com.google.gson.internal.a.f(i12, a3.a.q(i10, i11, "fromIndex: ", ", toIndex: ", ", size: "));
        } else {
            if (i10 <= i11) {
                return;
            }
            com.google.gson.internal.a.n(androidx.constraintlayout.core.widgets.analyzer.a.u(i10, i11, "fromIndex: ", " > toIndex: "));
        }
    }

    public static int e(int i10, int i11) {
        int i12 = i10 + (i10 >> 1);
        if (i12 - i11 < 0) {
            i12 = i11;
        }
        return i12 - 2147483639 > 0 ? i11 > 2147483639 ? Integer.MAX_VALUE : 2147483639 : i12;
    }
}
