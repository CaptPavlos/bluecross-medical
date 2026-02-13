package c1;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o3 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1388a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f1389b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f1390c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d5 f1391d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ x3 f;
    public final /* synthetic */ Object g;

    public o3(x3 x3Var, String str, String str2, d5 d5Var, boolean z9, com.google.android.gms.internal.measurement.n0 n0Var) {
        this.f1389b = str;
        this.f1390c = str2;
        this.f1391d = d5Var;
        this.e = z9;
        this.g = n0Var;
        this.f = x3Var;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        b5 b5Var;
        i0 i0Var;
        u1 u1Var;
        AtomicReference atomicReference;
        x3 x3Var;
        i0 i0Var2;
        switch (this.f1388a) {
            case 0:
                String str = this.f1390c;
                String str2 = this.f1389b;
                com.google.android.gms.internal.measurement.n0 n0Var = (com.google.android.gms.internal.measurement.n0) this.g;
                x3 x3Var2 = this.f;
                Bundle bundle = new Bundle();
                try {
                    try {
                        i0Var = x3Var2.f1572d;
                        u1Var = x3Var2.f1149a;
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (RemoteException e) {
                    e = e;
                }
                if (i0Var == null) {
                    w0 w0Var = u1Var.f;
                    u1.m(w0Var);
                    w0Var.f.d(str2, "Failed to get user properties; not connected to service", str);
                    b5Var = u1Var.f1479i;
                    u1.k(b5Var);
                    b5Var.U(n0Var, bundle);
                    return;
                }
                List<y4> listI = i0Var.i(str2, str, this.e, this.f1391d);
                Bundle bundle2 = new Bundle();
                if (listI != null) {
                    for (y4 y4Var : listI) {
                        String str3 = y4Var.e;
                        String str4 = y4Var.f1610b;
                        if (str3 != null) {
                            bundle2.putString(str4, str3);
                        } else {
                            Long l10 = y4Var.f1612d;
                            if (l10 != null) {
                                bundle2.putLong(str4, l10.longValue());
                            } else {
                                Double d8 = y4Var.g;
                                if (d8 != null) {
                                    bundle2.putDouble(str4, d8.doubleValue());
                                }
                            }
                        }
                    }
                }
                try {
                    x3Var2.t();
                    b5 b5Var2 = u1Var.f1479i;
                    u1.k(b5Var2);
                    b5Var2.U(n0Var, bundle2);
                    return;
                } catch (RemoteException e3) {
                    e = e3;
                    bundle = bundle2;
                    w0 w0Var2 = x3Var2.f1149a.f;
                    u1.m(w0Var2);
                    w0Var2.f.d(str2, "Failed to get user properties; remote exception", e);
                    b5Var = x3Var2.f1149a.f1479i;
                    u1.k(b5Var);
                    b5Var.U(n0Var, bundle);
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    bundle = bundle2;
                    b5 b5Var3 = x3Var2.f1149a.f1479i;
                    u1.k(b5Var3);
                    b5Var3.U(n0Var, bundle);
                    throw th;
                }
            default:
                AtomicReference atomicReference2 = (AtomicReference) this.g;
                synchronized (atomicReference2) {
                    try {
                        try {
                            x3Var = this.f;
                            i0Var2 = x3Var.f1572d;
                        } catch (RemoteException e7) {
                            w0 w0Var3 = this.f.f1149a.f;
                            u1.m(w0Var3);
                            w0Var3.f.e("(legacy) Failed to get user properties; remote exception", null, this.f1389b, e7);
                            ((AtomicReference) this.g).set(Collections.EMPTY_LIST);
                            atomicReference = (AtomicReference) this.g;
                        }
                        if (i0Var2 == null) {
                            w0 w0Var4 = x3Var.f1149a.f;
                            u1.m(w0Var4);
                            w0Var4.f.e("(legacy) Failed to get user properties; not connected to service", null, this.f1389b, this.f1390c);
                            atomicReference2.set(Collections.EMPTY_LIST);
                            atomicReference2.notify();
                            return;
                        }
                        if (TextUtils.isEmpty(null)) {
                            atomicReference2.set(i0Var2.i(this.f1389b, this.f1390c, this.e, this.f1391d));
                        } else {
                            atomicReference2.set(i0Var2.f(null, this.f1389b, this.f1390c, this.e));
                        }
                        x3Var.t();
                        atomicReference = (AtomicReference) this.g;
                        atomicReference.notify();
                        return;
                    } catch (Throwable th3) {
                        ((AtomicReference) this.g).notify();
                        throw th3;
                    }
                }
        }
    }

    public o3(x3 x3Var, AtomicReference atomicReference, String str, String str2, d5 d5Var, boolean z9) {
        this.g = atomicReference;
        this.f1389b = str;
        this.f1390c = str2;
        this.f1391d = d5Var;
        this.e = z9;
        this.f = x3Var;
    }
}
