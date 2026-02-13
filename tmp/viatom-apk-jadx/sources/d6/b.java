package d6;

import android.util.Log;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract /* synthetic */ class b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f7455a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32};

    public static void a(int i10, String str, String str2, Throwable th, Boolean bool) {
        if (i10 != 1 && i10 != 2 && i10 != 3 && i10 != 4 && i10 != 5) {
            throw null;
        }
        if (l.a(bool, Boolean.TRUE)) {
            if (i10 == 0) {
                throw null;
            }
            int i11 = i10 - 1;
            if (i11 == 0) {
                Log.v(str, str2, th);
                return;
            }
            if (i11 == 1) {
                Log.d(str, str2, th);
                return;
            }
            if (i11 == 2) {
                Log.i(str, str2, th);
            } else if (i11 == 3) {
                Log.w(str, str2, th);
            } else {
                if (i11 != 4) {
                    return;
                }
                Log.e(str, str2, th);
            }
        }
    }

    public static void b(String str, String str2, Exception exc, int i10) {
        Boolean bool = Boolean.TRUE;
        if ((i10 & 1) != 0) {
            str = "Inmobi Cmp";
        }
        if ((i10 & 4) != 0) {
            exc = null;
        }
        if ((i10 & 8) != 0) {
            bool = Boolean.FALSE;
        }
        str2.getClass();
        a(5, str, str2, exc, bool);
    }
}
