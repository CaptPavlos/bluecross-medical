package h5;

import android.content.Context;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public long f8460a;

    /* renamed from: b, reason: collision with root package name */
    public String f8461b;

    /* renamed from: c, reason: collision with root package name */
    public int f8462c;

    /* renamed from: d, reason: collision with root package name */
    public long f8463d;
    public long e;

    public final void a(Context context) {
        t1.Q(this.f8460a, context, "fcm_app_id");
        t1.R(context, "fcm_packagename", this.f8461b);
        t1.O(context, this.f8462c, "fcm_download_id");
        t1.Q(this.f8463d, context, "fcm_received_timestamp");
        t1.Q(this.e, context, "fcm_shown_timestamp");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("NotificationFCM(appId=");
        sb.append(this.f8460a);
        sb.append(", packageName=");
        sb.append(this.f8461b);
        sb.append(", downloadId=");
        return a3.a.k(sb, this.f8462c, ')');
    }
}
