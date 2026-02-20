package i0;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a0 extends com.google.android.gms.internal.measurement.h0 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f8859b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(e eVar, Looper looper) {
        super(looper, 5);
        this.f8859b = eVar;
    }

    @Override // com.google.android.gms.internal.measurement.h0, android.os.Handler
    public final void handleMessage(Message message) throws ClassNotFoundException {
        Boolean bool;
        int i10 = this.f8859b.f8882w.get();
        int i11 = message.arg1;
        int i12 = message.what;
        if (i10 != i11) {
            if (i12 == 2 || i12 == 1 || i12 == 7) {
                t tVar = (t) message.obj;
                tVar.getClass();
                tVar.d();
                return;
            }
            return;
        }
        if ((i12 == 1 || i12 == 7 || i12 == 4 || i12 == 5) && !this.f8859b.e()) {
            t tVar2 = (t) message.obj;
            tVar2.getClass();
            tVar2.d();
            return;
        }
        int i13 = message.what;
        if (i13 == 4) {
            e eVar = this.f8859b;
            eVar.t = new f0.b(message.arg2);
            if (!eVar.f8880u && !TextUtils.isEmpty(eVar.u()) && !TextUtils.isEmpty(null)) {
                try {
                    Class.forName(eVar.u());
                    e eVar2 = this.f8859b;
                    if (!eVar2.f8880u) {
                        eVar2.z(null, 3);
                        return;
                    }
                } catch (ClassNotFoundException unused) {
                }
            }
            e eVar3 = this.f8859b;
            f0.b bVar = eVar3.t;
            if (bVar == null) {
                bVar = new f0.b(8);
            }
            eVar3.f8870j.b(bVar);
            System.currentTimeMillis();
            return;
        }
        if (i13 == 5) {
            e eVar4 = this.f8859b;
            f0.b bVar2 = eVar4.t;
            if (bVar2 == null) {
                bVar2 = new f0.b(8);
            }
            eVar4.f8870j.b(bVar2);
            System.currentTimeMillis();
            return;
        }
        if (i13 == 3) {
            Object obj = message.obj;
            this.f8859b.f8870j.b(new f0.b(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null));
            System.currentTimeMillis();
            return;
        }
        if (i13 == 6) {
            this.f8859b.z(null, 5);
            b bVar3 = this.f8859b.f8875o;
            if (bVar3 != null) {
                bVar3.c(message.arg2);
            }
            System.currentTimeMillis();
            e.y(this.f8859b, 5, 1, null);
            return;
        }
        if (i13 == 2 && !this.f8859b.h()) {
            t tVar3 = (t) message.obj;
            tVar3.getClass();
            tVar3.d();
            return;
        }
        int i14 = message.what;
        if (i14 != 2 && i14 != 1 && i14 != 7) {
            Log.wtf("GmsClient", a3.a.f(i14, "Don't know how to handle message: "), new Exception());
            return;
        }
        t tVar4 = (t) message.obj;
        synchronized (tVar4) {
            try {
                bool = tVar4.f8950a;
                if (tVar4.f8951b) {
                    Log.w("GmsClient", "Callback proxy " + tVar4.toString() + " being reused. This is not safe.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (bool != null) {
            e eVar5 = tVar4.f;
            int i15 = tVar4.f8953d;
            if (i15 != 0) {
                eVar5.z(null, 1);
                Bundle bundle = tVar4.e;
                tVar4.a(new f0.b(i15, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
            } else if (!tVar4.b()) {
                eVar5.z(null, 1);
                tVar4.a(new f0.b(8, null));
            }
        }
        synchronized (tVar4) {
            tVar4.f8951b = true;
        }
        tVar4.d();
    }
}
