package h4;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import h0.r;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f8449a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f8450b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public r f8451c;

    /* renamed from: d, reason: collision with root package name */
    public c f8452d;

    public d(Context context) {
        this.f8449a = context;
    }

    public final void a() {
        int i10 = Build.VERSION.SDK_INT;
        Context context = this.f8449a;
        if (i10 < 24) {
            r rVar = new r(new a(this, 0), new a(this, 1));
            this.f8451c = rVar;
            context.registerReceiver(rVar, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } else {
            c cVar = new c(this);
            this.f8452d = cVar;
            Object systemService = context.getSystemService("connectivity");
            systemService.getClass();
            ((ConnectivityManager) systemService).registerDefaultNetworkCallback(cVar);
        }
    }
}
