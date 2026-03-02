package androidx.privacysandbox.ads.adservices.internal;

import android.os.Build;
import android.os.ext.SdkExtensions;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class AdServicesInfo {
    public static final AdServicesInfo INSTANCE = new AdServicesInfo();

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @RequiresApi(30)
    public static final class Extensions30ExtImpl {
        public static final Extensions30ExtImpl INSTANCE = new Extensions30ExtImpl();

        private Extensions30ExtImpl() {
        }

        @DoNotInline
        public final int getAdExtServicesVersionS() {
            return SdkExtensions.getExtensionVersion(31);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @RequiresApi(30)
    public static final class Extensions30Impl {
        public static final Extensions30Impl INSTANCE = new Extensions30Impl();

        private Extensions30Impl() {
        }

        @DoNotInline
        public final int getAdServicesVersion() {
            return SdkExtensions.getExtensionVersion(1000000);
        }
    }

    private AdServicesInfo() {
    }

    public final int adServicesVersion() {
        if (Build.VERSION.SDK_INT >= 33) {
            return Extensions30Impl.INSTANCE.getAdServicesVersion();
        }
        return 0;
    }

    public final int extServicesVersionS() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 == 31 || i10 == 32) {
            return Extensions30ExtImpl.INSTANCE.getAdExtServicesVersionS();
        }
        return 0;
    }
}
