package i0;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.core.os.EnvironmentCompat;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i0 implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j0 f8911a;

    public /* synthetic */ i0(j0 j0Var) {
        this.f8911a = j0Var;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 0) {
            synchronized (this.f8911a.f8918a) {
                try {
                    g0 g0Var = (g0) message.obj;
                    h0 h0Var = (h0) this.f8911a.f8918a.get(g0Var);
                    if (h0Var != null && h0Var.f8907a.isEmpty()) {
                        if (h0Var.f8909c) {
                            h0Var.g.f8920c.removeMessages(1, h0Var.e);
                            j0 j0Var = h0Var.g;
                            j0Var.f8921d.c(j0Var.f8919b, h0Var);
                            h0Var.f8909c = false;
                            h0Var.f8908b = 2;
                        }
                        this.f8911a.f8918a.remove(g0Var);
                    }
                } finally {
                }
            }
            return true;
        }
        if (i10 != 1) {
            return false;
        }
        synchronized (this.f8911a.f8918a) {
            try {
                g0 g0Var2 = (g0) message.obj;
                h0 h0Var2 = (h0) this.f8911a.f8918a.get(g0Var2);
                if (h0Var2 != null && h0Var2.f8908b == 3) {
                    Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback ".concat(String.valueOf(g0Var2)), new Exception());
                    ComponentName componentName = h0Var2.f;
                    if (componentName == null) {
                        g0Var2.getClass();
                        componentName = null;
                    }
                    if (componentName == null) {
                        String str = g0Var2.f8905b;
                        y.g(str);
                        componentName = new ComponentName(str, EnvironmentCompat.MEDIA_UNKNOWN);
                    }
                    h0Var2.onServiceDisconnected(componentName);
                }
            } finally {
            }
        }
        return true;
    }
}
