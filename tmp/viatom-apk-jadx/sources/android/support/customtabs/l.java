package android.support.customtabs;

import android.os.Bundle;
import android.os.IInterface;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public interface l extends IInterface {
    public static final String f = "android$support$customtabs$IPostMessageService".replace('$', '.');

    void onMessageChannelReady(c cVar, Bundle bundle);

    void onPostMessage(c cVar, String str, Bundle bundle);
}
