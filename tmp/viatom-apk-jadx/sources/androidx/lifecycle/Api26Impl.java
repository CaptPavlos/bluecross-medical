package androidx.lifecycle;

import androidx.annotation.RequiresApi;
import j$.time.Duration;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RequiresApi(26)
/* loaded from: classes.dex */
public final class Api26Impl {
    public static final Api26Impl INSTANCE = new Api26Impl();

    private Api26Impl() {
    }

    public final long toMillis(Duration duration) {
        duration.getClass();
        return duration.toMillis();
    }
}
