package k0;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import d5.j;
import f0.d;
import h0.n;
import i0.h;
import i0.o;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends h {

    /* renamed from: z, reason: collision with root package name */
    public final o f10038z;

    public c(Context context, Looper looper, j jVar, o oVar, n nVar, n nVar2) {
        super(context, looper, SubsamplingScaleImageView.ORIENTATION_270, jVar, nVar, nVar2, 0);
        this.f10038z = oVar;
    }

    @Override // i0.e
    public final int i() {
        return 203400000;
    }

    @Override // i0.e
    public final IInterface n(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        return iInterfaceQueryLocalInterface instanceof a ? (a) iInterfaceQueryLocalInterface : new a(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService", 2);
    }

    @Override // i0.e
    public final d[] q() {
        return v0.b.f13118b;
    }

    @Override // i0.e
    public final Bundle r() {
        o oVar = this.f10038z;
        oVar.getClass();
        Bundle bundle = new Bundle();
        String str = oVar.f8936a;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }

    @Override // i0.e
    public final String u() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    @Override // i0.e
    public final String v() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    @Override // i0.e
    public final boolean w() {
        return true;
    }
}
