package androidx.core.util;

import androidx.annotation.RequiresApi;
import w6.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RequiresApi(24)
/* loaded from: classes.dex */
public final class ConsumerKt {
    @RequiresApi(24)
    public static final <T> java.util.function.Consumer<T> asConsumer(c cVar) {
        return new ContinuationConsumer(cVar);
    }
}
