package c1;

import android.content.Context;
import android.os.Bundle;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n2 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1363a;

    /* renamed from: b, reason: collision with root package name */
    public final Boolean f1364b;

    /* renamed from: c, reason: collision with root package name */
    public final long f1365c;

    /* renamed from: d, reason: collision with root package name */
    public final com.google.android.gms.internal.measurement.v0 f1366d;
    public final boolean e;
    public final Long f;
    public final String g;

    public n2(Context context, com.google.android.gms.internal.measurement.v0 v0Var, Long l10) {
        this.e = true;
        i0.y.g(context);
        Context applicationContext = context.getApplicationContext();
        i0.y.g(applicationContext);
        this.f1363a = applicationContext;
        this.f = l10;
        if (v0Var != null) {
            this.f1366d = v0Var;
            this.e = v0Var.f2202c;
            this.f1365c = v0Var.f2201b;
            this.g = v0Var.e;
            Bundle bundle = v0Var.f2203d;
            if (bundle != null) {
                this.f1364b = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
