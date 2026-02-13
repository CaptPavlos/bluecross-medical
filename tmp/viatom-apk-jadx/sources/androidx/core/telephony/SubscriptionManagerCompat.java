package androidx.core.telephony;

import android.os.Build;
import android.telephony.SubscriptionManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RequiresApi(22)
/* loaded from: classes.dex */
public class SubscriptionManagerCompat {
    private static Method sGetSlotIndexMethod;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static int getSlotIndex(int i10) {
            return SubscriptionManager.getSlotIndex(i10);
        }
    }

    private SubscriptionManagerCompat() {
    }

    public static int getSlotIndex(int i10) throws SecurityException {
        if (i10 == -1) {
            return -1;
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 29) {
            return Api29Impl.getSlotIndex(i10);
        }
        try {
            if (sGetSlotIndexMethod == null) {
                Class cls = Integer.TYPE;
                if (i11 >= 26) {
                    sGetSlotIndexMethod = SubscriptionManager.class.getDeclaredMethod("getSlotIndex", cls);
                } else {
                    sGetSlotIndexMethod = SubscriptionManager.class.getDeclaredMethod("getSlotId", cls);
                }
                sGetSlotIndexMethod.setAccessible(true);
            }
            Integer num = (Integer) sGetSlotIndexMethod.invoke(null, Integer.valueOf(i10));
            if (num != null) {
                return num.intValue();
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        return -1;
    }
}
