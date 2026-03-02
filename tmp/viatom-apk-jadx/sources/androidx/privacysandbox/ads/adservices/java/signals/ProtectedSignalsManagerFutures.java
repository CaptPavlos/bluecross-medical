package androidx.privacysandbox.ads.adservices.java.signals;

import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import androidx.privacysandbox.ads.adservices.signals.ProtectedSignalsManager;
import androidx.privacysandbox.ads.adservices.signals.UpdateSignalsRequest;
import k1.b;
import kotlin.jvm.internal.g;
import r7.i0;
import r7.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class ProtectedSignalsManagerFutures {
    public static final Companion Companion = new Companion(null);

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class JavaImpl extends ProtectedSignalsManagerFutures {
        private final ProtectedSignalsManager mProtectedSignalsManager;

        public JavaImpl(ProtectedSignalsManager protectedSignalsManager) {
            this.mProtectedSignalsManager = protectedSignalsManager;
        }

        @Override // androidx.privacysandbox.ads.adservices.java.signals.ProtectedSignalsManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_PROTECTED_SIGNALS")
        @DoNotInline
        public b updateSignalsAsync(UpdateSignalsRequest updateSignalsRequest) {
            updateSignalsRequest.getClass();
            return CoroutineAdapterKt.asListenableFuture$default(y.d(y.a(i0.f12407a), new ProtectedSignalsManagerFutures$JavaImpl$updateSignalsAsync$1(this, updateSignalsRequest, null)), null, 1, null);
        }
    }

    public static final ProtectedSignalsManagerFutures from(Context context) {
        return Companion.from(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_PROTECTED_SIGNALS")
    public abstract b updateSignalsAsync(UpdateSignalsRequest updateSignalsRequest);

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final ProtectedSignalsManagerFutures from(Context context) {
            context.getClass();
            ProtectedSignalsManager protectedSignalsManagerObtain = ProtectedSignalsManager.Companion.obtain(context);
            if (protectedSignalsManagerObtain != null) {
                return new JavaImpl(protectedSignalsManagerObtain);
            }
            return null;
        }

        private Companion() {
        }
    }
}
