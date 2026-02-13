package v0;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import androidx.core.content.ContextCompat;
import h0.r;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class c extends ContextCompat {
    public static void a(Context context, r rVar, IntentFilter intentFilter) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 33) {
            context.registerReceiver(rVar, intentFilter, i10 >= 33 ? 2 : 0);
        } else {
            context.registerReceiver(rVar, intentFilter);
        }
    }
}
