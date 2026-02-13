package androidx.window.layout;

import android.app.Activity;
import androidx.core.util.Consumer;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public interface WindowBackend {
    void registerLayoutChangeCallback(Activity activity, Executor executor, Consumer<WindowLayoutInfo> consumer);

    void unregisterLayoutChangeCallback(Consumer<WindowLayoutInfo> consumer);
}
