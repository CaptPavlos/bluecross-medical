package androidx.browser.customtabs;

import android.os.Bundle;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public interface EngagementSignalsCallback {
    void onGreatestScrollPercentageIncreased(@IntRange(from = 1, to = 100) int i10, @NonNull Bundle bundle);

    void onSessionEnded(boolean z9, @NonNull Bundle bundle);

    void onVerticalScrollEvent(boolean z9, @NonNull Bundle bundle);
}
