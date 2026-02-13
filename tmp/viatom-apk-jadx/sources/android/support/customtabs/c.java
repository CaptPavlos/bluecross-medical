package android.support.customtabs;

import android.net.Uri;
import android.os.Bundle;
import android.os.IInterface;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public interface c extends IInterface {

    /* renamed from: c, reason: collision with root package name */
    public static final String f359c = "android$support$customtabs$ICustomTabsCallback".replace('$', '.');

    void extraCallback(String str, Bundle bundle);

    Bundle extraCallbackWithResult(String str, Bundle bundle);

    void onActivityLayout(int i10, int i11, int i12, int i13, int i14, Bundle bundle);

    void onActivityResized(int i10, int i11, Bundle bundle);

    void onMessageChannelReady(Bundle bundle);

    void onMinimized(Bundle bundle);

    void onNavigationEvent(int i10, Bundle bundle);

    void onPostMessage(String str, Bundle bundle);

    void onRelationshipValidationResult(int i10, Uri uri, boolean z9, Bundle bundle);

    void onUnminimized(Bundle bundle);

    void onWarmupCompleted(Bundle bundle);
}
