package androidx.privacysandbox.ads.adservices.customaudience;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import androidx.privacysandbox.ads.adservices.internal.BackCompatManager;
import kotlin.jvm.internal.g;
import w6.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class CustomAudienceManager {
    public static final Companion Companion = new Companion(null);

    @SuppressLint({"NewApi", "ClassVerificationFailure"})
    public static final CustomAudienceManager obtain(Context context) {
        return Companion.obtain(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @ExperimentalFeatures.Ext10OptIn
    public abstract Object fetchAndJoinCustomAudience(FetchAndJoinCustomAudienceRequest fetchAndJoinCustomAudienceRequest, c cVar);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    public abstract Object joinCustomAudience(JoinCustomAudienceRequest joinCustomAudienceRequest, c cVar);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    public abstract Object leaveCustomAudience(LeaveCustomAudienceRequest leaveCustomAudienceRequest, c cVar);

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        @SuppressLint({"NewApi", "ClassVerificationFailure"})
        public final CustomAudienceManager obtain(Context context) {
            context.getClass();
            AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
            if (adServicesInfo.adServicesVersion() >= 4) {
                return new CustomAudienceManagerApi33Ext4Impl(context);
            }
            if (adServicesInfo.extServicesVersionS() >= 9) {
                return (CustomAudienceManager) BackCompatManager.INSTANCE.getManager(context, "CustomAudienceManager", new CustomAudienceManager$Companion$obtain$1(context));
            }
            return null;
        }

        private Companion() {
        }
    }
}
