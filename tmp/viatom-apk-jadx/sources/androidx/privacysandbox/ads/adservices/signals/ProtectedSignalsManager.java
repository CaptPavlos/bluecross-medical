package androidx.privacysandbox.ads.adservices.signals;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import kotlin.jvm.internal.g;
import w6.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class ProtectedSignalsManager {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "ProtectedSignalsManager";

    @SuppressLint({"NewApi"})
    @ExperimentalFeatures.Ext12OptIn
    public static final ProtectedSignalsManager obtain(Context context) {
        return Companion.obtain(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_PROTECTED_SIGNALS")
    @ExperimentalFeatures.Ext12OptIn
    public abstract Object updateSignals(UpdateSignalsRequest updateSignalsRequest, c cVar);

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        @SuppressLint({"NewApi"})
        @ExperimentalFeatures.Ext12OptIn
        public final ProtectedSignalsManager obtain(Context context) {
            context.getClass();
            if (AdServicesInfo.INSTANCE.adServicesVersion() < 12) {
                Log.d(ProtectedSignalsManager.TAG, "Adservices less than 12, returning null for ProtectedSignalsManager.obtain.");
                return null;
            }
            Log.d(ProtectedSignalsManager.TAG, "Adservices version 12 detected, obtaining ProtectedSignalsManagerImpl.");
            android.adservices.signals.ProtectedSignalsManager protectedSignalsManager = android.adservices.signals.ProtectedSignalsManager.get(context);
            protectedSignalsManager.getClass();
            return new ProtectedSignalsManagerImpl(protectedSignalsManager);
        }

        private Companion() {
        }
    }
}
