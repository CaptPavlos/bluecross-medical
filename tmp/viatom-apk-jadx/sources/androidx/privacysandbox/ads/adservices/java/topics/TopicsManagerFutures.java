package androidx.privacysandbox.ads.adservices.java.topics;

import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsRequest;
import androidx.privacysandbox.ads.adservices.topics.TopicsManager;
import k1.b;
import kotlin.jvm.internal.g;
import r7.i0;
import r7.y;
import w7.n;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class TopicsManagerFutures {
    public static final Companion Companion = new Companion(null);

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class CommonApiJavaImpl extends TopicsManagerFutures {
        private final TopicsManager mTopicsManager;

        public CommonApiJavaImpl(TopicsManager topicsManager) {
            topicsManager.getClass();
            this.mTopicsManager = topicsManager;
        }

        @Override // androidx.privacysandbox.ads.adservices.java.topics.TopicsManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_TOPICS")
        @DoNotInline
        public b getTopicsAsync(GetTopicsRequest getTopicsRequest) {
            getTopicsRequest.getClass();
            e eVar = i0.f12407a;
            return CoroutineAdapterKt.asListenableFuture$default(y.d(y.a(n.f13548a), new TopicsManagerFutures$CommonApiJavaImpl$getTopicsAsync$1(this, getTopicsRequest, null)), null, 1, null);
        }
    }

    public static final TopicsManagerFutures from(Context context) {
        return Companion.from(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_TOPICS")
    public abstract b getTopicsAsync(GetTopicsRequest getTopicsRequest);

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final TopicsManagerFutures from(Context context) {
            context.getClass();
            TopicsManager topicsManagerObtain = TopicsManager.Companion.obtain(context);
            if (topicsManagerObtain != null) {
                return new CommonApiJavaImpl(topicsManagerObtain);
            }
            return null;
        }

        private Companion() {
        }
    }
}
