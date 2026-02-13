package f0;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import androidx.core.app.PendingIntentCompat;
import com.google.android.gms.internal.measurement.h0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j extends h0 {

    /* renamed from: b, reason: collision with root package name */
    public final Context f8014b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f8015c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(e eVar, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper(), 3);
        this.f8015c = eVar;
        this.f8014b = context.getApplicationContext();
    }

    @Override // com.google.android.gms.internal.measurement.h0, android.os.Handler
    public final void handleMessage(Message message) throws Resources.NotFoundException, PackageManager.NameNotFoundException {
        int i10 = message.what;
        if (i10 != 1) {
            androidx.constraintlayout.core.widgets.analyzer.a.B(i10, "Don't know how to handle this message: ", "GoogleApiAvailability");
            return;
        }
        int i11 = f.f8002a;
        e eVar = this.f8015c;
        Context context = this.f8014b;
        int iB = eVar.b(context, i11);
        int i12 = g.e;
        if (iB == 1 || iB == 2 || iB == 3 || iB == 9) {
            Intent intentA = eVar.a(context, iB, "n");
            eVar.g(context, iB, intentA == null ? null : PendingIntentCompat.getActivity(context, 0, intentA, 134217728, false));
        }
    }
}
