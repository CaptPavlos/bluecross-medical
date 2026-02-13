package j4;

import android.graphics.BitmapFactory;
import android.net.NetworkInfo;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class f0 {
    public static void a(int i10, int i11, int i12, int i13, BitmapFactory.Options options, c0 c0Var) {
        int iMin;
        double dFloor;
        if (i13 > i11 || i12 > i10) {
            if (i11 == 0) {
                dFloor = Math.floor(i12 / i10);
            } else if (i10 == 0) {
                dFloor = Math.floor(i13 / i11);
            } else {
                int iFloor = (int) Math.floor(i13 / i11);
                int iFloor2 = (int) Math.floor(i12 / i10);
                c0Var.getClass();
                iMin = Math.min(iFloor, iFloor2);
            }
            iMin = (int) dFloor;
        } else {
            iMin = 1;
        }
        options.inSampleSize = iMin;
        options.inJustDecodeBounds = false;
    }

    public static BitmapFactory.Options c(c0 c0Var) {
        boolean zB = c0Var.b();
        if (!zB) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = zB;
        options.inInputShareable = false;
        options.inPurgeable = false;
        return options;
    }

    public abstract boolean b(c0 c0Var);

    public int d() {
        return 0;
    }

    public abstract e0 e(c0 c0Var, int i10);

    public boolean f(NetworkInfo networkInfo) {
        return false;
    }
}
