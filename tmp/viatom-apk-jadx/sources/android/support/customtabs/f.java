package android.support.customtabs;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public interface f extends IInterface {

    /* renamed from: d, reason: collision with root package name */
    public static final String f361d = "android$support$customtabs$ICustomTabsService".replace('$', '.');

    Bundle extraCommand(String str, Bundle bundle);

    boolean isEngagementSignalsApiAvailable(c cVar, Bundle bundle);

    boolean mayLaunchUrl(c cVar, Uri uri, Bundle bundle, List list);

    boolean newSession(c cVar);

    boolean newSessionWithExtras(c cVar, Bundle bundle);

    int postMessage(c cVar, String str, Bundle bundle);

    boolean receiveFile(c cVar, Uri uri, int i10, Bundle bundle);

    boolean requestPostMessageChannel(c cVar, Uri uri);

    boolean requestPostMessageChannelWithExtras(c cVar, Uri uri, Bundle bundle);

    boolean setEngagementSignalsCallback(c cVar, IBinder iBinder, Bundle bundle);

    boolean updateVisuals(c cVar, Bundle bundle);

    boolean validateRelationship(c cVar, int i10, Uri uri, Bundle bundle);

    boolean warmup(long j10);
}
