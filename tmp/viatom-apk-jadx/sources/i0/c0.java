package i0;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c0 implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final int f8862a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f8863b;

    public c0(e eVar, int i10) {
        this.f8863b = eVar;
        this.f8862a = i10;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        e eVar = this.f8863b;
        if (iBinder == null) {
            e.x(eVar);
            return;
        }
        synchronized (eVar.h) {
            try {
                e eVar2 = this.f8863b;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                eVar2.f8869i = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof u)) ? new u(iBinder) : (u) iInterfaceQueryLocalInterface;
            } catch (Throwable th) {
                throw th;
            }
        }
        e eVar3 = this.f8863b;
        int i10 = this.f8862a;
        e0 e0Var = new e0(eVar3, 0, null);
        a0 a0Var = eVar3.f;
        a0Var.sendMessage(a0Var.obtainMessage(7, i10, -1, e0Var));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        e eVar;
        synchronized (this.f8863b.h) {
            eVar = this.f8863b;
            eVar.f8869i = null;
        }
        int i10 = this.f8862a;
        a0 a0Var = eVar.f;
        a0Var.sendMessage(a0Var.obtainMessage(6, i10, 1));
    }
}
