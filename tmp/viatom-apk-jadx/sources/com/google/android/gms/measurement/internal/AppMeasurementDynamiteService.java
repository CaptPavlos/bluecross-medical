package com.google.android.gms.measurement.internal;

import a3.x;
import a4.f;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.window.layout.c;
import androidx.work.WorkRequest;
import c1.b5;
import c1.c2;
import c1.c3;
import c1.c5;
import c1.g3;
import c1.i3;
import c1.k3;
import c1.m2;
import c1.n3;
import c1.n4;
import c1.p4;
import c1.r1;
import c1.r2;
import c1.s1;
import c1.s2;
import c1.t2;
import c1.u;
import c1.u0;
import c1.u1;
import c1.v;
import c1.v2;
import c1.w0;
import c1.w2;
import c1.y2;
import c1.z;
import c1.z0;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.internal.measurement.k0;
import com.google.android.gms.internal.measurement.n0;
import com.google.android.gms.internal.measurement.p0;
import com.google.android.gms.internal.measurement.s0;
import com.google.android.gms.internal.measurement.v0;
import com.google.android.gms.internal.measurement.x0;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import i0.y;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import k1.a;
import o2.e;
import q0.b;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@DynamiteApi
/* loaded from: classes3.dex */
public class AppMeasurementDynamiteService extends k0 {

    /* renamed from: a, reason: collision with root package name */
    public u1 f2292a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayMap f2293b;

    public AppMeasurementDynamiteService() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        this.f2292a = null;
        this.f2293b = new ArrayMap();
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void beginAdUnitExposure(@NonNull String str, long j10) throws RemoteException {
        c();
        z zVar = this.f2292a.f1484n;
        u1.j(zVar);
        zVar.h(j10, str);
    }

    public final void c() {
        if (this.f2292a != null) {
            return;
        }
        c.g("Attempting to perform action before initialize.");
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void clearConditionalUserProperty(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle) throws RemoteException {
        c();
        c3 c3Var = this.f2292a.f1483m;
        u1.l(c3Var);
        c3Var.u(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void clearMeasurementEnabled(long j10) throws RemoteException {
        c();
        c3 c3Var = this.f2292a.f1483m;
        u1.l(c3Var);
        c3Var.h();
        r1 r1Var = c3Var.f1149a.g;
        u1.m(r1Var);
        r1Var.p(new a(c3Var, null, 6, false));
    }

    public final void d(String str, n0 n0Var) {
        c();
        b5 b5Var = this.f2292a.f1479i;
        u1.k(b5Var);
        b5Var.P(str, n0Var);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void endAdUnitExposure(@NonNull String str, long j10) throws RemoteException {
        c();
        z zVar = this.f2292a.f1484n;
        u1.j(zVar);
        zVar.i(j10, str);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void generateEventId(n0 n0Var) throws RemoteException {
        c();
        b5 b5Var = this.f2292a.f1479i;
        u1.k(b5Var);
        long jD0 = b5Var.d0();
        c();
        b5 b5Var2 = this.f2292a.f1479i;
        u1.k(b5Var2);
        b5Var2.Q(n0Var, jD0);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void getAppInstanceId(n0 n0Var) throws RemoteException {
        c();
        r1 r1Var = this.f2292a.g;
        u1.m(r1Var);
        r1Var.p(new s1(this, n0Var, 0));
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void getCachedAppInstanceId(n0 n0Var) throws RemoteException {
        c();
        c3 c3Var = this.f2292a.f1483m;
        u1.l(c3Var);
        d((String) c3Var.g.get(), n0Var);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void getConditionalUserProperties(String str, String str2, n0 n0Var) throws RemoteException {
        c();
        r1 r1Var = this.f2292a.g;
        u1.m(r1Var);
        r1Var.p(new c2(4, this, n0Var, str2, str));
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void getCurrentScreenClass(n0 n0Var) throws RemoteException {
        c();
        c3 c3Var = this.f2292a.f1483m;
        u1.l(c3Var);
        n3 n3Var = c3Var.f1149a.f1482l;
        u1.l(n3Var);
        k3 k3Var = n3Var.f1367c;
        d(k3Var != null ? k3Var.f1305b : null, n0Var);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void getCurrentScreenName(n0 n0Var) throws RemoteException {
        c();
        c3 c3Var = this.f2292a.f1483m;
        u1.l(c3Var);
        n3 n3Var = c3Var.f1149a.f1482l;
        u1.l(n3Var);
        k3 k3Var = n3Var.f1367c;
        d(k3Var != null ? k3Var.f1304a : null, n0Var);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void getGmpAppId(n0 n0Var) throws RemoteException {
        c();
        c3 c3Var = this.f2292a.f1483m;
        u1.l(c3Var);
        d(c3Var.v(), n0Var);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void getMaxUserProperties(String str, n0 n0Var) throws RemoteException {
        c();
        c3 c3Var = this.f2292a.f1483m;
        u1.l(c3Var);
        y.d(str);
        c3Var.f1149a.getClass();
        c();
        b5 b5Var = this.f2292a.f1479i;
        u1.k(b5Var);
        b5Var.R(n0Var, 25);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void getSessionId(n0 n0Var) throws RemoteException {
        c();
        c3 c3Var = this.f2292a.f1483m;
        u1.l(c3Var);
        r1 r1Var = c3Var.f1149a.g;
        u1.m(r1Var);
        r1Var.p(new a(c3Var, n0Var));
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void getTestFlag(n0 n0Var, int i10) throws RemoteException {
        c();
        if (i10 == 0) {
            b5 b5Var = this.f2292a.f1479i;
            u1.k(b5Var);
            c3 c3Var = this.f2292a.f1483m;
            u1.l(c3Var);
            AtomicReference atomicReference = new AtomicReference();
            r1 r1Var = c3Var.f1149a.g;
            u1.m(r1Var);
            b5Var.P((String) r1Var.q(atomicReference, 15000L, "String test flag value", new v2(c3Var, atomicReference, 1)), n0Var);
            return;
        }
        if (i10 == 1) {
            b5 b5Var2 = this.f2292a.f1479i;
            u1.k(b5Var2);
            c3 c3Var2 = this.f2292a.f1483m;
            u1.l(c3Var2);
            AtomicReference atomicReference2 = new AtomicReference();
            r1 r1Var2 = c3Var2.f1149a.g;
            u1.m(r1Var2);
            b5Var2.Q(n0Var, ((Long) r1Var2.q(atomicReference2, 15000L, "long test flag value", new v2(c3Var2, atomicReference2, 2))).longValue());
            return;
        }
        if (i10 == 2) {
            b5 b5Var3 = this.f2292a.f1479i;
            u1.k(b5Var3);
            c3 c3Var3 = this.f2292a.f1483m;
            u1.l(c3Var3);
            AtomicReference atomicReference3 = new AtomicReference();
            r1 r1Var3 = c3Var3.f1149a.g;
            u1.m(r1Var3);
            double dDoubleValue = ((Double) r1Var3.q(atomicReference3, 15000L, "double test flag value", new v2(c3Var3, atomicReference3, 4))).doubleValue();
            Bundle bundle = new Bundle();
            bundle.putDouble(CampaignEx.JSON_KEY_AD_R, dDoubleValue);
            try {
                n0Var.u(bundle);
                return;
            } catch (RemoteException e) {
                w0 w0Var = b5Var3.f1149a.f;
                u1.m(w0Var);
                w0Var.f1540i.c(e, "Error returning double value to wrapper");
                return;
            }
        }
        if (i10 == 3) {
            b5 b5Var4 = this.f2292a.f1479i;
            u1.k(b5Var4);
            c3 c3Var4 = this.f2292a.f1483m;
            u1.l(c3Var4);
            AtomicReference atomicReference4 = new AtomicReference();
            r1 r1Var4 = c3Var4.f1149a.g;
            u1.m(r1Var4);
            b5Var4.R(n0Var, ((Integer) r1Var4.q(atomicReference4, 15000L, "int test flag value", new v2(c3Var4, atomicReference4, 3))).intValue());
            return;
        }
        if (i10 != 4) {
            return;
        }
        b5 b5Var5 = this.f2292a.f1479i;
        u1.k(b5Var5);
        c3 c3Var5 = this.f2292a.f1483m;
        u1.l(c3Var5);
        AtomicReference atomicReference5 = new AtomicReference();
        r1 r1Var5 = c3Var5.f1149a.g;
        u1.m(r1Var5);
        b5Var5.T(n0Var, ((Boolean) r1Var5.q(atomicReference5, 15000L, "boolean test flag value", new v2(c3Var5, atomicReference5, 0))).booleanValue());
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void getUserProperties(String str, String str2, boolean z9, n0 n0Var) throws RemoteException {
        c();
        r1 r1Var = this.f2292a.g;
        u1.m(r1Var);
        r1Var.p(new s2(this, n0Var, str, str2, z9));
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void initForTests(@NonNull Map map) throws RemoteException {
        c();
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void initialize(q0.a aVar, v0 v0Var, long j10) throws RemoteException {
        u1 u1Var = this.f2292a;
        if (u1Var == null) {
            Context context = (Context) b.J(aVar);
            y.g(context);
            this.f2292a = u1.s(context, v0Var, Long.valueOf(j10));
        } else {
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            w0Var.f1540i.b("Attempting to initialize multiple times");
        }
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void isDataCollectionEnabled(n0 n0Var) throws RemoteException {
        c();
        r1 r1Var = this.f2292a.g;
        u1.m(r1Var);
        r1Var.p(new s1(this, n0Var, 1));
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void logEvent(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle, boolean z9, boolean z10, long j10) throws RemoteException {
        c();
        c3 c3Var = this.f2292a.f1483m;
        u1.l(c3Var);
        c3Var.l(str, str2, bundle, z9, z10, j10);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void logEventAndBundle(String str, String str2, Bundle bundle, n0 n0Var, long j10) throws RemoteException {
        c();
        y.d(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        v vVar = new v(str2, new u(bundle), MBridgeConstans.DYNAMIC_VIEW_WX_APP, j10);
        r1 r1Var = this.f2292a.g;
        u1.m(r1Var);
        r1Var.p(new c2(this, n0Var, vVar, str));
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void logHealthData(int i10, @NonNull String str, @NonNull q0.a aVar, @NonNull q0.a aVar2, @NonNull q0.a aVar3) throws RemoteException {
        c();
        Object objJ = aVar == null ? null : b.J(aVar);
        Object objJ2 = aVar2 == null ? null : b.J(aVar2);
        Object objJ3 = aVar3 != null ? b.J(aVar3) : null;
        w0 w0Var = this.f2292a.f;
        u1.m(w0Var);
        w0Var.p(i10, true, false, str, objJ, objJ2, objJ3);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void onActivityCreated(@NonNull q0.a aVar, @NonNull Bundle bundle, long j10) throws RemoteException {
        c();
        Activity activity = (Activity) b.J(aVar);
        y.g(activity);
        onActivityCreatedByScionActivityInfo(x0.b(activity), bundle, j10);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void onActivityCreatedByScionActivityInfo(x0 x0Var, Bundle bundle, long j10) {
        c();
        c3 c3Var = this.f2292a.f1483m;
        u1.l(c3Var);
        y2 y2Var = c3Var.f1076c;
        if (y2Var != null) {
            c3 c3Var2 = this.f2292a.f1483m;
            u1.l(c3Var2);
            c3Var2.z();
            y2Var.j(x0Var, bundle);
        }
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void onActivityDestroyed(@NonNull q0.a aVar, long j10) throws RemoteException {
        c();
        Activity activity = (Activity) b.J(aVar);
        y.g(activity);
        onActivityDestroyedByScionActivityInfo(x0.b(activity), j10);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void onActivityDestroyedByScionActivityInfo(x0 x0Var, long j10) throws RemoteException {
        c();
        c3 c3Var = this.f2292a.f1483m;
        u1.l(c3Var);
        y2 y2Var = c3Var.f1076c;
        if (y2Var != null) {
            c3 c3Var2 = this.f2292a.f1483m;
            u1.l(c3Var2);
            c3Var2.z();
            y2Var.k(x0Var);
        }
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void onActivityPaused(@NonNull q0.a aVar, long j10) throws RemoteException {
        c();
        Activity activity = (Activity) b.J(aVar);
        y.g(activity);
        onActivityPausedByScionActivityInfo(x0.b(activity), j10);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void onActivityPausedByScionActivityInfo(x0 x0Var, long j10) throws RemoteException {
        c();
        c3 c3Var = this.f2292a.f1483m;
        u1.l(c3Var);
        y2 y2Var = c3Var.f1076c;
        if (y2Var != null) {
            c3 c3Var2 = this.f2292a.f1483m;
            u1.l(c3Var2);
            c3Var2.z();
            y2Var.l(x0Var);
        }
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void onActivityResumed(@NonNull q0.a aVar, long j10) throws RemoteException {
        c();
        Activity activity = (Activity) b.J(aVar);
        y.g(activity);
        onActivityResumedByScionActivityInfo(x0.b(activity), j10);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void onActivityResumedByScionActivityInfo(x0 x0Var, long j10) throws RemoteException {
        c();
        c3 c3Var = this.f2292a.f1483m;
        u1.l(c3Var);
        y2 y2Var = c3Var.f1076c;
        if (y2Var != null) {
            c3 c3Var2 = this.f2292a.f1483m;
            u1.l(c3Var2);
            c3Var2.z();
            y2Var.m(x0Var);
        }
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void onActivitySaveInstanceState(q0.a aVar, n0 n0Var, long j10) throws RemoteException {
        c();
        Activity activity = (Activity) b.J(aVar);
        y.g(activity);
        onActivitySaveInstanceStateByScionActivityInfo(x0.b(activity), n0Var, j10);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void onActivitySaveInstanceStateByScionActivityInfo(x0 x0Var, n0 n0Var, long j10) throws RemoteException {
        c();
        c3 c3Var = this.f2292a.f1483m;
        u1.l(c3Var);
        y2 y2Var = c3Var.f1076c;
        Bundle bundle = new Bundle();
        if (y2Var != null) {
            c3 c3Var2 = this.f2292a.f1483m;
            u1.l(c3Var2);
            c3Var2.z();
            y2Var.n(x0Var, bundle);
        }
        try {
            n0Var.u(bundle);
        } catch (RemoteException e) {
            w0 w0Var = this.f2292a.f;
            u1.m(w0Var);
            w0Var.f1540i.c(e, "Error returning bundle value to wrapper");
        }
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void onActivityStarted(@NonNull q0.a aVar, long j10) throws RemoteException {
        c();
        Activity activity = (Activity) b.J(aVar);
        y.g(activity);
        onActivityStartedByScionActivityInfo(x0.b(activity), j10);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void onActivityStartedByScionActivityInfo(x0 x0Var, long j10) throws RemoteException {
        c();
        c3 c3Var = this.f2292a.f1483m;
        u1.l(c3Var);
        if (c3Var.f1076c != null) {
            c3 c3Var2 = this.f2292a.f1483m;
            u1.l(c3Var2);
            c3Var2.z();
        }
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void onActivityStopped(@NonNull q0.a aVar, long j10) throws RemoteException {
        c();
        Activity activity = (Activity) b.J(aVar);
        y.g(activity);
        onActivityStoppedByScionActivityInfo(x0.b(activity), j10);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void onActivityStoppedByScionActivityInfo(x0 x0Var, long j10) throws RemoteException {
        c();
        c3 c3Var = this.f2292a.f1483m;
        u1.l(c3Var);
        if (c3Var.f1076c != null) {
            c3 c3Var2 = this.f2292a.f1483m;
            u1.l(c3Var2);
            c3Var2.z();
        }
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void performAction(Bundle bundle, n0 n0Var, long j10) throws RemoteException {
        c();
        n0Var.u(null);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void registerOnMeasurementEventListener(s0 s0Var) throws RemoteException {
        Object c5Var;
        c();
        ArrayMap arrayMap = this.f2293b;
        synchronized (arrayMap) {
            try {
                c5Var = (m2) arrayMap.get(Integer.valueOf(s0Var.b()));
                if (c5Var == null) {
                    c5Var = new c5(this, s0Var);
                    arrayMap.put(Integer.valueOf(s0Var.b()), c5Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        c3 c3Var = this.f2292a.f1483m;
        u1.l(c3Var);
        c3Var.h();
        if (c3Var.e.add(c5Var)) {
            return;
        }
        w0 w0Var = c3Var.f1149a.f;
        u1.m(w0Var);
        w0Var.f1540i.b("OnEventListener already registered");
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void resetAnalyticsData(long j10) throws RemoteException {
        c();
        c3 c3Var = this.f2292a.f1483m;
        u1.l(c3Var);
        c3Var.g.set(null);
        r1 r1Var = c3Var.f1149a.g;
        u1.m(r1Var);
        r1Var.p(new t2(c3Var, j10, 1));
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void retrieveAndUploadBatches(p0 p0Var) throws MalformedURLException {
        i3 i3Var;
        c();
        c3 c3Var = this.f2292a.f1483m;
        u1.l(c3Var);
        c3Var.h();
        u1 u1Var = c3Var.f1149a;
        r1 r1Var = u1Var.g;
        u1.m(r1Var);
        if (r1Var.m()) {
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            w0Var.f.b("Cannot retrieve and upload batches from analytics worker thread");
            return;
        }
        r1 r1Var2 = u1Var.g;
        u1.m(r1Var2);
        if (Thread.currentThread() == r1Var2.f1426d) {
            w0 w0Var2 = u1Var.f;
            u1.m(w0Var2);
            w0Var2.f.b("Cannot retrieve and upload batches from analytics network thread");
            return;
        }
        boolean zC = e.c();
        w0 w0Var3 = u1Var.f;
        if (zC) {
            u1.m(w0Var3);
            w0Var3.f.b("Cannot retrieve and upload batches from main thread");
            return;
        }
        u1.m(w0Var3);
        w0Var3.f1545n.b("[sgtm] Started client-side batch upload work.");
        boolean z9 = false;
        int size = 0;
        int i10 = 0;
        while (!z9) {
            w0 w0Var4 = u1Var.f;
            u1.m(w0Var4);
            w0Var4.f1545n.b("[sgtm] Getting upload batches from service (FE)");
            AtomicReference atomicReference = new AtomicReference();
            r1 r1Var3 = u1Var.g;
            u1.m(r1Var3);
            r1Var3.q(atomicReference, WorkRequest.MIN_BACKOFF_MILLIS, "[sgtm] Getting upload batches", new v2(c3Var, atomicReference, 6, false));
            p4 p4Var = (p4) atomicReference.get();
            if (p4Var == null) {
                break;
            }
            List list = p4Var.f1404a;
            if (list.isEmpty()) {
                break;
            }
            w0 w0Var5 = u1Var.f;
            u1.m(w0Var5);
            w0Var5.f1545n.c(Integer.valueOf(list.size()), "[sgtm] Retrieved upload batches. count");
            size += list.size();
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z9 = false;
                    break;
                }
                n4 n4Var = (n4) it.next();
                try {
                    URL url = new URI(n4Var.f1375c).toURL();
                    AtomicReference atomicReference2 = new AtomicReference();
                    c1.n0 n0VarR = c3Var.f1149a.r();
                    n0VarR.h();
                    y.g(n0VarR.g);
                    String str = n0VarR.g;
                    u1 u1Var2 = c3Var.f1149a;
                    w0 w0Var6 = u1Var2.f;
                    u1.m(w0Var6);
                    u0 u0Var = w0Var6.f1545n;
                    Long lValueOf = Long.valueOf(n4Var.f1373a);
                    u0Var.e("[sgtm] Uploading data from app. row_id, url, uncompressed size", lValueOf, n4Var.f1375c, Integer.valueOf(n4Var.f1374b.length));
                    if (!TextUtils.isEmpty(n4Var.g)) {
                        w0 w0Var7 = u1Var2.f;
                        u1.m(w0Var7);
                        w0Var7.f1545n.d(lValueOf, "[sgtm] Uploading data from app. row_id", n4Var.g);
                    }
                    HashMap map = new HashMap();
                    Bundle bundle = n4Var.f1376d;
                    for (String str2 : bundle.keySet()) {
                        String string = bundle.getString(str2);
                        if (!TextUtils.isEmpty(string)) {
                            map.put(str2, string);
                        }
                    }
                    g3 g3Var = u1Var2.f1485o;
                    u1.m(g3Var);
                    byte[] bArr = n4Var.f1374b;
                    x xVar = new x(c3Var, atomicReference2, n4Var, 6);
                    g3Var.i();
                    y.g(url);
                    y.g(bArr);
                    r1 r1Var4 = g3Var.f1149a.g;
                    u1.m(r1Var4);
                    r1Var4.s(new z0(g3Var, str, url, bArr, map, xVar));
                    try {
                        b5 b5Var = u1Var2.f1479i;
                        u1.k(b5Var);
                        u1 u1Var3 = b5Var.f1149a;
                        u1Var3.f1481k.getClass();
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        long j10 = jCurrentTimeMillis + ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS;
                        synchronized (atomicReference2) {
                            for (long jCurrentTimeMillis2 = ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS; atomicReference2.get() == null && jCurrentTimeMillis2 > 0; jCurrentTimeMillis2 = j10 - System.currentTimeMillis()) {
                                try {
                                    atomicReference2.wait(jCurrentTimeMillis2);
                                    u1Var3.f1481k.getClass();
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                    } catch (InterruptedException unused) {
                        w0 w0Var8 = c3Var.f1149a.f;
                        u1.m(w0Var8);
                        w0Var8.f1540i.b("[sgtm] Interrupted waiting for uploading batch");
                    }
                    i3Var = atomicReference2.get() == null ? i3.UNKNOWN : (i3) atomicReference2.get();
                } catch (MalformedURLException | URISyntaxException e) {
                    w0 w0Var9 = c3Var.f1149a.f;
                    u1.m(w0Var9);
                    w0Var9.f.e("[sgtm] Bad upload url for row_id", n4Var.f1375c, Long.valueOf(n4Var.f1373a), e);
                    i3Var = i3.FAILURE;
                }
                if (i3Var != i3.SUCCESS) {
                    if (i3Var == i3.BACKOFF) {
                        z9 = true;
                        break;
                    }
                } else {
                    i10++;
                }
            }
        }
        w0 w0Var10 = u1Var.f;
        u1.m(w0Var10);
        w0Var10.f1545n.d(Integer.valueOf(size), "[sgtm] Completed client-side batch upload work. total, success", Integer.valueOf(i10));
        try {
            p0Var.e();
        } catch (RemoteException e3) {
            u1 u1Var4 = this.f2292a;
            y.g(u1Var4);
            w0 w0Var11 = u1Var4.f;
            u1.m(w0Var11);
            w0Var11.f1540i.c(e3, "Failed to call IDynamiteUploadBatchesCallback");
        }
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void setConditionalUserProperty(@NonNull Bundle bundle, long j10) throws RemoteException {
        c();
        u1 u1Var = this.f2292a;
        if (bundle == null) {
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            w0Var.f.b("Conditional user property must not be null");
        } else {
            c3 c3Var = u1Var.f1483m;
            u1.l(c3Var);
            c3Var.t(bundle, j10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void setConsentThirdParty(@NonNull Bundle bundle, long j10) throws RemoteException {
        c();
        c3 c3Var = this.f2292a.f1483m;
        u1.l(c3Var);
        c3Var.A(bundle, -20, j10);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void setCurrentScreen(@NonNull q0.a aVar, @NonNull String str, @NonNull String str2, long j10) throws RemoteException {
        c();
        Activity activity = (Activity) b.J(aVar);
        y.g(activity);
        setCurrentScreenByScionActivityInfo(x0.b(activity), str, str2, j10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0086, code lost:
    
        if (r3 <= 500) goto L31;
     */
    @Override // com.google.android.gms.internal.measurement.l0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setCurrentScreenByScionActivityInfo(com.google.android.gms.internal.measurement.x0 r6, java.lang.String r7, java.lang.String r8, long r9) throws android.os.RemoteException {
        /*
            r5 = this;
            r5.c()
            c1.u1 r9 = r5.f2292a
            c1.n3 r9 = r9.f1482l
            c1.u1.l(r9)
            c1.u1 r10 = r9.f1149a
            c1.g r0 = r10.f1478d
            boolean r0 = r0.u()
            if (r0 != 0) goto L21
            c1.w0 r6 = r10.f
            c1.u1.m(r6)
            c1.u0 r6 = r6.f1542k
            java.lang.String r7 = "setCurrentScreen cannot be called while screen reporting is disabled."
            r6.b(r7)
            return
        L21:
            c1.k3 r0 = r9.f1367c
            if (r0 != 0) goto L32
            c1.w0 r6 = r10.f
            c1.u1.m(r6)
            c1.u0 r6 = r6.f1542k
            java.lang.String r7 = "setCurrentScreen cannot be called while no activity active"
            r6.b(r7)
            return
        L32:
            j$.util.concurrent.ConcurrentHashMap r1 = r9.f
            int r2 = r6.f2254a
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object r3 = r1.get(r2)
            if (r3 != 0) goto L4d
            c1.w0 r6 = r10.f
            c1.u1.m(r6)
            c1.u0 r6 = r6.f1542k
            java.lang.String r7 = "setCurrentScreen must be called with an activity in the activity lifecycle"
            r6.b(r7)
            return
        L4d:
            if (r8 != 0) goto L55
            java.lang.String r8 = r6.f2255b
            java.lang.String r8 = r9.n(r8)
        L55:
            java.lang.String r3 = r0.f1305b
            java.lang.String r0 = r0.f1304a
            boolean r3 = j$.util.Objects.equals(r3, r8)
            boolean r0 = j$.util.Objects.equals(r0, r7)
            if (r3 == 0) goto L73
            if (r0 != 0) goto L66
            goto L73
        L66:
            c1.w0 r6 = r10.f
            c1.u1.m(r6)
            c1.u0 r6 = r6.f1542k
            java.lang.String r7 = "setCurrentScreen cannot be called with the same class and name"
            r6.b(r7)
            return
        L73:
            r0 = 500(0x1f4, float:7.0E-43)
            if (r7 == 0) goto L9e
            int r3 = r7.length()
            if (r3 <= 0) goto L89
            int r3 = r7.length()
            c1.g r4 = r10.f1478d
            r4.getClass()
            if (r3 > r0) goto L89
            goto L9e
        L89:
            c1.w0 r6 = r10.f
            c1.u1.m(r6)
            c1.u0 r6 = r6.f1542k
            int r7 = r7.length()
            java.lang.String r8 = "Invalid screen name length in setCurrentScreen. Length"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r6.c(r7, r8)
            return
        L9e:
            int r3 = r8.length()
            if (r3 <= 0) goto Ld9
            int r3 = r8.length()
            c1.g r4 = r10.f1478d
            r4.getClass()
            if (r3 > r0) goto Ld9
            c1.w0 r0 = r10.f
            c1.u1.m(r0)
            c1.u0 r0 = r0.f1545n
            if (r7 != 0) goto Lbb
            java.lang.String r3 = "null"
            goto Lbc
        Lbb:
            r3 = r7
        Lbc:
            java.lang.String r4 = "Setting current screen to name, class"
            r0.d(r3, r4, r8)
            c1.k3 r0 = new c1.k3
            c1.b5 r10 = r10.f1479i
            c1.u1.k(r10)
            long r3 = r10.d0()
            r0.<init>(r7, r8, r3)
            r1.put(r2, r0)
            java.lang.String r6 = r6.f2255b
            r7 = 1
            r9.p(r6, r0, r7)
            return
        Ld9:
            c1.w0 r6 = r10.f
            c1.u1.m(r6)
            c1.u0 r6 = r6.f1542k
            int r7 = r8.length()
            java.lang.String r8 = "Invalid class name length in setCurrentScreen. Length"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r6.c(r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.AppMeasurementDynamiteService.setCurrentScreenByScionActivityInfo(com.google.android.gms.internal.measurement.x0, java.lang.String, java.lang.String, long):void");
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void setDataCollectionEnabled(boolean z9) throws RemoteException {
        c();
        c3 c3Var = this.f2292a.f1483m;
        u1.l(c3Var);
        c3Var.h();
        r1 r1Var = c3Var.f1149a.g;
        u1.m(r1Var);
        r1Var.p(new r2(c3Var, z9));
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void setDefaultEventParameters(@NonNull Bundle bundle) {
        c();
        c3 c3Var = this.f2292a.f1483m;
        u1.l(c3Var);
        Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        r1 r1Var = c3Var.f1149a.g;
        u1.m(r1Var);
        r1Var.p(new w2(c3Var, bundle2, 2));
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void setEventInterceptor(s0 s0Var) throws RemoteException {
        c();
        f fVar = new f(6, this, s0Var);
        r1 r1Var = this.f2292a.g;
        u1.m(r1Var);
        boolean zM = r1Var.m();
        u1 u1Var = this.f2292a;
        if (!zM) {
            r1 r1Var2 = u1Var.g;
            u1.m(r1Var2);
            r1Var2.p(new a(this, fVar, 8, false));
            return;
        }
        c3 c3Var = u1Var.f1483m;
        u1.l(c3Var);
        c3Var.g();
        c3Var.h();
        f fVar2 = c3Var.f1077d;
        if (fVar != fVar2) {
            y.i(fVar2 == null, "EventInterceptor already set.");
        }
        c3Var.f1077d = fVar;
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void setInstanceIdProvider(com.google.android.gms.internal.measurement.u0 u0Var) throws RemoteException {
        c();
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void setMeasurementEnabled(boolean z9, long j10) throws RemoteException {
        c();
        c3 c3Var = this.f2292a.f1483m;
        u1.l(c3Var);
        Boolean boolValueOf = Boolean.valueOf(z9);
        c3Var.h();
        r1 r1Var = c3Var.f1149a.g;
        u1.m(r1Var);
        r1Var.p(new a(c3Var, boolValueOf, 6, false));
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void setMinimumSessionDuration(long j10) throws RemoteException {
        c();
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void setSessionTimeoutDuration(long j10) throws RemoteException {
        c();
        c3 c3Var = this.f2292a.f1483m;
        u1.l(c3Var);
        r1 r1Var = c3Var.f1149a.g;
        u1.m(r1Var);
        r1Var.p(new t2(c3Var, j10, 0));
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void setSgtmDebugInfo(@NonNull Intent intent) throws RemoteException {
        c();
        c3 c3Var = this.f2292a.f1483m;
        u1.l(c3Var);
        u1 u1Var = c3Var.f1149a;
        Uri data = intent.getData();
        if (data == null) {
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            w0Var.f1543l.b("Activity intent has no data. Preview Mode was not enabled.");
            return;
        }
        String queryParameter = data.getQueryParameter("sgtm_debug_enable");
        if (queryParameter == null || !queryParameter.equals("1")) {
            w0 w0Var2 = u1Var.f;
            u1.m(w0Var2);
            w0Var2.f1543l.b("[sgtm] Preview Mode was not enabled.");
            u1Var.f1478d.f1227c = null;
            return;
        }
        String queryParameter2 = data.getQueryParameter("sgtm_preview_key");
        if (TextUtils.isEmpty(queryParameter2)) {
            return;
        }
        w0 w0Var3 = u1Var.f;
        u1.m(w0Var3);
        w0Var3.f1543l.c(queryParameter2, "[sgtm] Preview Mode was enabled. Using the sgtmPreviewKey: ");
        u1Var.f1478d.f1227c = queryParameter2;
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void setUserId(@NonNull String str, long j10) throws RemoteException {
        c();
        c3 c3Var = this.f2292a.f1483m;
        u1.l(c3Var);
        u1 u1Var = c3Var.f1149a;
        if (str != null && TextUtils.isEmpty(str)) {
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            w0Var.f1540i.b("User ID must be non-empty or null");
        } else {
            r1 r1Var = u1Var.g;
            u1.m(r1Var);
            r1Var.p(new a(9, c3Var, str));
            c3Var.q(null, "_id", str, true, j10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void setUserProperty(@NonNull String str, @NonNull String str2, @NonNull q0.a aVar, boolean z9, long j10) throws SecurityException, RemoteException {
        c();
        Object objJ = b.J(aVar);
        c3 c3Var = this.f2292a.f1483m;
        u1.l(c3Var);
        c3Var.q(str, str2, objJ, z9, j10);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void unregisterOnMeasurementEventListener(s0 s0Var) throws RemoteException {
        Object c5Var;
        c();
        ArrayMap arrayMap = this.f2293b;
        synchronized (arrayMap) {
            c5Var = (m2) arrayMap.remove(Integer.valueOf(s0Var.b()));
        }
        if (c5Var == null) {
            c5Var = new c5(this, s0Var);
        }
        c3 c3Var = this.f2292a.f1483m;
        u1.l(c3Var);
        c3Var.h();
        if (c3Var.e.remove(c5Var)) {
            return;
        }
        w0 w0Var = c3Var.f1149a.f;
        u1.m(w0Var);
        w0Var.f1540i.b("OnEventListener had not been registered");
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public void setConsent(@NonNull Bundle bundle, long j10) throws RemoteException {
    }
}
