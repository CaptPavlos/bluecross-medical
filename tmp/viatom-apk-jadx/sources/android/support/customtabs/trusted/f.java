package android.support.customtabs.trusted;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public interface f extends IInterface {
    public static final String h = "android$support$customtabs$trusted$ITrustedWebActivityService".replace('$', '.');

    Bundle areNotificationsEnabled(Bundle bundle);

    void cancelNotification(Bundle bundle);

    Bundle extraCommand(String str, Bundle bundle, IBinder iBinder);

    Bundle getActiveNotifications();

    Bundle getSmallIconBitmap();

    int getSmallIconId();

    Bundle notifyNotificationWithChannel(Bundle bundle);
}
