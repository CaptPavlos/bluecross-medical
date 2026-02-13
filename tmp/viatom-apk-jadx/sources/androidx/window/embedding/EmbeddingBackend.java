package androidx.window.embedding;

import android.app.Activity;
import androidx.core.util.Consumer;
import androidx.window.core.ExperimentalWindowApi;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@ExperimentalWindowApi
/* loaded from: classes.dex */
public interface EmbeddingBackend {
    Set<EmbeddingRule> getSplitRules();

    boolean isSplitSupported();

    void registerRule(EmbeddingRule embeddingRule);

    void registerSplitListenerForActivity(Activity activity, Executor executor, Consumer<List<SplitInfo>> consumer);

    void setSplitRules(Set<? extends EmbeddingRule> set);

    void unregisterRule(EmbeddingRule embeddingRule);

    void unregisterSplitListenerForActivity(Consumer<List<SplitInfo>> consumer);
}
