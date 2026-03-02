package androidx.privacysandbox.ads.adservices.java.appsetid;

import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManager;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import k1.b;
import kotlin.jvm.internal.g;
import r7.i0;
import r7.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class AppSetIdManagerFutures {
    public static final Companion Companion = new Companion(null);

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Api33Ext4JavaImpl extends AppSetIdManagerFutures {
        private final AppSetIdManager mAppSetIdManager;

        public Api33Ext4JavaImpl(AppSetIdManager appSetIdManager) {
            appSetIdManager.getClass();
            this.mAppSetIdManager = appSetIdManager;
        }

        @Override // androidx.privacysandbox.ads.adservices.java.appsetid.AppSetIdManagerFutures
        @DoNotInline
        public b getAppSetIdAsync() {
            return CoroutineAdapterKt.asListenableFuture$default(y.d(y.a(i0.f12407a), new AppSetIdManagerFutures$Api33Ext4JavaImpl$getAppSetIdAsync$1(this, null)), null, 1, null);
        }
    }

    public static final AppSetIdManagerFutures from(Context context) {
        return Companion.from(context);
    }

    public abstract b getAppSetIdAsync();

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final AppSetIdManagerFutures from(Context context) {
            context.getClass();
            AppSetIdManager appSetIdManagerObtain = AppSetIdManager.Companion.obtain(context);
            if (appSetIdManagerObtain != null) {
                return new Api33Ext4JavaImpl(appSetIdManagerObtain);
            }
            return null;
        }

        private Companion() {
        }
    }
}
