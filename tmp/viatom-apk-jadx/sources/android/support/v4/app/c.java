package android.support.v4.app;

import android.app.Notification;
import android.os.IInterface;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public interface c extends IInterface {

    /* renamed from: i, reason: collision with root package name */
    public static final String f367i = "android$support$v4$app$INotificationSideChannel".replace('$', '.');

    void cancel(String str, int i10, String str2);

    void cancelAll(String str);

    void notify(String str, int i10, String str2, Notification notification);
}
