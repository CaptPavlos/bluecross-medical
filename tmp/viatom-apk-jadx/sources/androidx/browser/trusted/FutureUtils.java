package androidx.browser.trusted;

import androidx.annotation.NonNull;
import androidx.concurrent.futures.ResolvableFuture;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
class FutureUtils {
    private FutureUtils() {
    }

    @NonNull
    public static <T> k1.b immediateFailedFuture(@NonNull Throwable th) {
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        resolvableFutureCreate.setException(th);
        return resolvableFutureCreate;
    }
}
