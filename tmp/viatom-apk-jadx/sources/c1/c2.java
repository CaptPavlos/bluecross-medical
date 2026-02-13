package c1;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import j$.util.Objects;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class c2 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1072a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Serializable f1073b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1074c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f1075d;
    public final /* synthetic */ Object e;

    public c2(c3 c3Var, AtomicReference atomicReference, String str, String str2) {
        this.f1072a = 3;
        this.f1074c = atomicReference;
        this.f1073b = str;
        this.f1075d = str2;
        Objects.requireNonNull(c3Var);
        this.e = c3Var;
    }

    private final void a() {
        i0 i0Var;
        x3 x3Var = (x3) this.f1074c;
        AtomicReference atomicReference = (AtomicReference) this.f1073b;
        d5 d5Var = (d5) this.e;
        o4 o4Var = (o4) this.f1075d;
        synchronized (atomicReference) {
            try {
                i0Var = x3Var.f1572d;
            } catch (RemoteException e) {
                w0 w0Var = x3Var.f1149a.f;
                u1.m(w0Var);
                w0Var.f.c(e, "[sgtm] Failed to get upload batches; remote exception");
                atomicReference.notifyAll();
            }
            if (i0Var != null) {
                i0Var.z(d5Var, o4Var, new q3(x3Var, atomicReference));
                x3Var.t();
            } else {
                w0 w0Var2 = x3Var.f1149a.f;
                u1.m(w0Var2);
                w0Var2.f.b("[sgtm] Failed to get upload batches; not connected to service");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:90:0x035d  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() throws android.database.SQLException {
        /*
            Method dump skipped, instructions count: 1160
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.c2.run():void");
    }

    public /* synthetic */ c2(d2 d2Var, Bundle bundle, String str, d5 d5Var) {
        this.f1072a = 2;
        this.f1074c = d2Var;
        this.f1075d = bundle;
        this.f1073b = str;
        this.e = d5Var;
    }

    public /* synthetic */ c2(x3 x3Var, AtomicReference atomicReference, d5 d5Var, o4 o4Var) {
        this.f1072a = 7;
        this.f1074c = x3Var;
        this.f1073b = atomicReference;
        this.e = d5Var;
        this.f1075d = o4Var;
    }

    public /* synthetic */ c2(Object obj, Serializable serializable, j0.a aVar, Object obj2, int i10) {
        this.f1072a = i10;
        this.f1074c = obj;
        this.f1073b = serializable;
        this.f1075d = aVar;
        this.e = obj2;
    }

    public /* synthetic */ c2(int i10, Object obj, Object obj2, Object obj3, String str) {
        this.f1072a = i10;
        this.f1074c = obj2;
        this.f1073b = str;
        this.f1075d = obj3;
        this.e = obj;
    }

    public c2(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.n0 n0Var, v vVar, String str) {
        this.f1072a = 1;
        this.f1074c = n0Var;
        this.f1075d = vVar;
        this.f1073b = str;
        this.e = appMeasurementDynamiteService;
    }

    public c2(d0.i iVar, String str, String str2, Bundle bundle) {
        this.f1072a = 8;
        this.f1073b = str;
        this.f1074c = str2;
        this.f1075d = bundle;
        this.e = iVar;
    }
}
