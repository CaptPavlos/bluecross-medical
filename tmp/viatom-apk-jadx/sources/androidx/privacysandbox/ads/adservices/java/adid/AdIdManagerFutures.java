package androidx.privacysandbox.ads.adservices.java.adid;

import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.adid.AdIdManager;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import k1.b;
import kotlin.jvm.internal.g;
import r7.i0;
import r7.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class AdIdManagerFutures {
    public static final Companion Companion = new Companion(null);

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Api33Ext4JavaImpl extends AdIdManagerFutures {
        private final AdIdManager mAdIdManager;

        public Api33Ext4JavaImpl(AdIdManager adIdManager) {
            adIdManager.getClass();
            this.mAdIdManager = adIdManager;
        }

        @Override // androidx.privacysandbox.ads.adservices.java.adid.AdIdManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_AD_ID")
        @DoNotInline
        public b getAdIdAsync() {
            return CoroutineAdapterKt.asListenableFuture$default(y.d(y.a(i0.f12407a), new AdIdManagerFutures$Api33Ext4JavaImpl$getAdIdAsync$1(this, null)), null, 1, null);
        }
    }

    public static final AdIdManagerFutures from(Context context) {
        return Companion.from(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_AD_ID")
    public abstract b getAdIdAsync();

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final AdIdManagerFutures from(Context context) {
            context.getClass();
            AdIdManager adIdManagerObtain = AdIdManager.Companion.obtain(context);
            if (adIdManagerObtain != null) {
                return new Api33Ext4JavaImpl(adIdManagerObtain);
            }
            return null;
        }

        private Companion() {
        }
    }
}
