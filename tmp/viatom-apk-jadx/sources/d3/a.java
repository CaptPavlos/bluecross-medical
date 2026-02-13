package d3;

import android.content.Context;
import android.os.Bundle;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a implements o {

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f6803a;

    public a(Context context) {
        context.getClass();
        Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        this.f6803a = bundle == null ? Bundle.EMPTY : bundle;
    }

    @Override // d3.o
    public final Boolean a() {
        Bundle bundle = this.f6803a;
        if (bundle.containsKey("firebase_sessions_enabled")) {
            return Boolean.valueOf(bundle.getBoolean("firebase_sessions_enabled"));
        }
        return null;
    }

    @Override // d3.o
    public final p7.a b() {
        Bundle bundle = this.f6803a;
        if (bundle.containsKey("firebase_sessions_sessions_restart_timeout")) {
            return new p7.a(l1.b.O(bundle.getInt("firebase_sessions_sessions_restart_timeout"), p7.c.SECONDS));
        }
        return null;
    }

    @Override // d3.o
    public final Double c() {
        Bundle bundle = this.f6803a;
        if (bundle.containsKey("firebase_sessions_sampling_rate")) {
            return Double.valueOf(bundle.getDouble("firebase_sessions_sampling_rate"));
        }
        return null;
    }

    @Override // d3.o
    public final Object d(w6.c cVar) {
        return w.f12711a;
    }
}
