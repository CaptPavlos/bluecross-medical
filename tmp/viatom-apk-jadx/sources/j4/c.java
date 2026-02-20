package j4;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends f0 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f9921a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f9922b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public AssetManager f9923c;

    public c(Context context) {
        this.f9921a = context;
    }

    @Override // j4.f0
    public final boolean b(c0 c0Var) {
        Uri uri = (Uri) c0Var.f9925b;
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }

    @Override // j4.f0
    public final e0 e(c0 c0Var, int i10) {
        if (this.f9923c == null) {
            synchronized (this.f9922b) {
                try {
                    if (this.f9923c == null) {
                        this.f9923c = this.f9921a.getAssets();
                    }
                } finally {
                }
            }
        }
        return new e0(t1.T(this.f9923c.open(((Uri) c0Var.f9925b).toString().substring(22))), 2);
    }
}
