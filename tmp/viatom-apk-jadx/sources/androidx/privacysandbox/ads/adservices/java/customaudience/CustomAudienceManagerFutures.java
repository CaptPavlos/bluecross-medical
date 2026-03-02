package androidx.privacysandbox.ads.adservices.java.customaudience;

import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.customaudience.CustomAudienceManager;
import androidx.privacysandbox.ads.adservices.customaudience.FetchAndJoinCustomAudienceRequest;
import androidx.privacysandbox.ads.adservices.customaudience.JoinCustomAudienceRequest;
import androidx.privacysandbox.ads.adservices.customaudience.LeaveCustomAudienceRequest;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import k1.b;
import kotlin.jvm.internal.g;
import r7.i0;
import r7.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class CustomAudienceManagerFutures {
    public static final Companion Companion = new Companion(null);

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Api33Ext4JavaImpl extends CustomAudienceManagerFutures {
        private final CustomAudienceManager mCustomAudienceManager;

        public Api33Ext4JavaImpl(CustomAudienceManager customAudienceManager) {
            this.mCustomAudienceManager = customAudienceManager;
        }

        @Override // androidx.privacysandbox.ads.adservices.java.customaudience.CustomAudienceManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public b fetchAndJoinCustomAudienceAsync(FetchAndJoinCustomAudienceRequest fetchAndJoinCustomAudienceRequest) {
            fetchAndJoinCustomAudienceRequest.getClass();
            return CoroutineAdapterKt.asListenableFuture$default(y.d(y.a(i0.f12407a), new CustomAudienceManagerFutures$Api33Ext4JavaImpl$fetchAndJoinCustomAudienceAsync$1(this, fetchAndJoinCustomAudienceRequest, null)), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.customaudience.CustomAudienceManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public b joinCustomAudienceAsync(JoinCustomAudienceRequest joinCustomAudienceRequest) {
            joinCustomAudienceRequest.getClass();
            return CoroutineAdapterKt.asListenableFuture$default(y.d(y.a(i0.f12407a), new CustomAudienceManagerFutures$Api33Ext4JavaImpl$joinCustomAudienceAsync$1(this, joinCustomAudienceRequest, null)), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.customaudience.CustomAudienceManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public b leaveCustomAudienceAsync(LeaveCustomAudienceRequest leaveCustomAudienceRequest) {
            leaveCustomAudienceRequest.getClass();
            return CoroutineAdapterKt.asListenableFuture$default(y.d(y.a(i0.f12407a), new CustomAudienceManagerFutures$Api33Ext4JavaImpl$leaveCustomAudienceAsync$1(this, leaveCustomAudienceRequest, null)), null, 1, null);
        }
    }

    public static final CustomAudienceManagerFutures from(Context context) {
        return Companion.from(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @ExperimentalFeatures.Ext10OptIn
    public abstract b fetchAndJoinCustomAudienceAsync(FetchAndJoinCustomAudienceRequest fetchAndJoinCustomAudienceRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    public abstract b joinCustomAudienceAsync(JoinCustomAudienceRequest joinCustomAudienceRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    public abstract b leaveCustomAudienceAsync(LeaveCustomAudienceRequest leaveCustomAudienceRequest);

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final CustomAudienceManagerFutures from(Context context) {
            context.getClass();
            CustomAudienceManager customAudienceManagerObtain = CustomAudienceManager.Companion.obtain(context);
            if (customAudienceManagerObtain != null) {
                return new Api33Ext4JavaImpl(customAudienceManagerObtain);
            }
            return null;
        }

        private Companion() {
        }
    }
}
