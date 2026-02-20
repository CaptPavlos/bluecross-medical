package c1;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class b2 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1055a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f1056b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d5 f1057c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f1058d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;

    public /* synthetic */ b2(d2 d2Var, d5 d5Var, Bundle bundle, k0 k0Var, String str) {
        this.f1058d = d2Var;
        this.f1057c = d5Var;
        this.e = bundle;
        this.f = k0Var;
        this.f1056b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        x3 x3Var;
        i0 i0Var;
        b5 b5Var;
        i0 i0Var2;
        switch (this.f1055a) {
            case 0:
                d2 d2Var = (d2) this.f1058d;
                d5 d5Var = this.f1057c;
                Bundle bundle = (Bundle) this.e;
                k0 k0Var = (k0) this.f;
                String str = this.f1056b;
                v4 v4Var = d2Var.f1108a;
                v4Var.B();
                try {
                    k0Var.B(v4Var.d0(bundle, d5Var));
                    return;
                } catch (RemoteException e) {
                    v4Var.a().f.d(str, "Failed to return trigger URIs for app", e);
                    return;
                }
            case 1:
                AtomicReference atomicReference2 = (AtomicReference) this.f1058d;
                synchronized (atomicReference2) {
                    try {
                        try {
                            x3Var = (x3) this.f;
                            i0Var = x3Var.f1572d;
                        } catch (Throwable th) {
                            ((AtomicReference) this.f1058d).notify();
                            throw th;
                        }
                    } catch (RemoteException e3) {
                        w0 w0Var = ((x3) this.f).f1149a.f;
                        u1.m(w0Var);
                        w0Var.f.e("(legacy) Failed to get conditional properties; remote exception", null, this.f1056b, e3);
                        ((AtomicReference) this.f1058d).set(Collections.EMPTY_LIST);
                        atomicReference = (AtomicReference) this.f1058d;
                    }
                    if (i0Var == null) {
                        w0 w0Var2 = x3Var.f1149a.f;
                        u1.m(w0Var2);
                        w0Var2.f.e("(legacy) Failed to get conditional properties; not connected to service", null, this.f1056b, (String) this.e);
                        atomicReference2.set(Collections.EMPTY_LIST);
                        atomicReference2.notify();
                        return;
                    }
                    if (TextUtils.isEmpty(null)) {
                        atomicReference2.set(i0Var.s(this.f1056b, (String) this.e, this.f1057c));
                    } else {
                        atomicReference2.set(i0Var.m(null, this.f1056b, (String) this.e));
                    }
                    x3Var.t();
                    atomicReference = (AtomicReference) this.f1058d;
                    atomicReference.notify();
                    return;
                }
            default:
                com.google.android.gms.internal.measurement.n0 n0Var = (com.google.android.gms.internal.measurement.n0) this.e;
                String str2 = (String) this.f1058d;
                String str3 = this.f1056b;
                x3 x3Var2 = (x3) this.f;
                ArrayList arrayList = new ArrayList();
                try {
                    try {
                        i0Var2 = x3Var2.f1572d;
                    } catch (Throwable th2) {
                        b5 b5Var2 = x3Var2.f1149a.f1479i;
                        u1.k(b5Var2);
                        b5Var2.V(n0Var, arrayList);
                        throw th2;
                    }
                } catch (RemoteException e7) {
                    w0 w0Var3 = x3Var2.f1149a.f;
                    u1.m(w0Var3);
                    w0Var3.f.e("Failed to get conditional properties; remote exception", str3, str2, e7);
                }
                if (i0Var2 != null) {
                    arrayList = b5.W(i0Var2.s(str3, str2, this.f1057c));
                    x3Var2.t();
                    b5Var = x3Var2.f1149a.f1479i;
                    u1.k(b5Var);
                    b5Var.V(n0Var, arrayList);
                    return;
                }
                u1 u1Var = x3Var2.f1149a;
                w0 w0Var4 = u1Var.f;
                u1.m(w0Var4);
                w0Var4.f.d(str3, "Failed to get conditional properties; not connected to service", str2);
                b5Var = u1Var.f1479i;
                u1.k(b5Var);
                b5Var.V(n0Var, arrayList);
                return;
        }
    }

    public b2(x3 x3Var, String str, String str2, d5 d5Var, com.google.android.gms.internal.measurement.n0 n0Var) {
        this.f1056b = str;
        this.f1058d = str2;
        this.f1057c = d5Var;
        this.e = n0Var;
        this.f = x3Var;
    }

    public b2(x3 x3Var, AtomicReference atomicReference, String str, String str2, d5 d5Var) {
        this.f1058d = atomicReference;
        this.f1056b = str;
        this.e = str2;
        this.f1057c = d5Var;
        this.f = x3Var;
    }
}
