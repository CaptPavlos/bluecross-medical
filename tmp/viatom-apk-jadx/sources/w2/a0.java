package w2;

import android.content.Intent;
import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessagingService;
import l4.x4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a0 extends Binder {

    /* renamed from: a, reason: collision with root package name */
    public final x4 f13421a;

    public a0(x4 x4Var) {
        this.f13421a = x4Var;
    }

    public final void a(b0 b0Var) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException("Binding only allowed within app");
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "service received new intent via bind strategy");
        }
        Intent intent = b0Var.f13424a;
        FirebaseMessagingService firebaseMessagingService = (FirebaseMessagingService) this.f13421a.f10987b;
        h1.i iVar = new h1.i();
        firebaseMessagingService.f2438a.execute(new androidx.work.impl.c(firebaseMessagingService, intent, iVar, 5));
        iVar.f8418a.a(new androidx.arch.core.executor.a(2), new v.e(b0Var, 6));
    }
}
