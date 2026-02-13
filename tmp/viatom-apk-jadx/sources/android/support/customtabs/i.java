package android.support.customtabs;

import android.os.Bundle;
import android.os.IInterface;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public interface i extends IInterface {
    public static final String e = "android$support$customtabs$IEngagementSignalsCallback".replace('$', '.');

    void onGreatestScrollPercentageIncreased(int i10, Bundle bundle);

    void onSessionEnded(boolean z9, Bundle bundle);

    void onVerticalScrollEvent(boolean z9, Bundle bundle);
}
