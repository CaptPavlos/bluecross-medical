package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class ActivityResultContract<I, O> {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class SynchronousResult<T> {
        private final T value;

        public SynchronousResult(T t) {
            this.value = t;
        }

        public final T getValue() {
            return this.value;
        }
    }

    public abstract Intent createIntent(Context context, I i10);

    public SynchronousResult<O> getSynchronousResult(Context context, I i10) {
        context.getClass();
        return null;
    }

    public abstract O parseResult(int i10, Intent intent);
}
