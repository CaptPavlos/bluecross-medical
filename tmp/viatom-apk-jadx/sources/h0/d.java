package h0;

import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.internal.measurement.h0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends h0 {
    @Override // com.google.android.gms.internal.measurement.h0, android.os.Handler
    public final void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 != 1) {
            if (i10 != 2) {
                Log.wtf("BasePendingResult", a3.a.f(i10, "Don't know how to handle message: "), new Exception());
                return;
            } else {
                ((BasePendingResult) message.obj).c(Status.h);
                return;
            }
        }
        Pair pair = (Pair) message.obj;
        if (pair.first != null) {
            com.google.gson.internal.a.k();
            return;
        }
        try {
            throw null;
        } catch (RuntimeException e) {
            b0 b0Var = BasePendingResult.f1862j;
            throw e;
        }
    }
}
