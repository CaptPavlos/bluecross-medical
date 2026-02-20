package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.util.Log;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f385b = Log.isLoggable("MediaBrowserCompat", 3);

    /* renamed from: a, reason: collision with root package name */
    public final d f386a;

    public g(Context context, ComponentName componentName, c cVar) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f386a = new e(context, componentName, cVar);
        } else {
            this.f386a = new d(context, componentName, cVar);
        }
    }
}
