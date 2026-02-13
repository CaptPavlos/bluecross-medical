package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.Size;
import androidx.work.WorkRequest;
import c1.d3;
import com.google.android.gms.internal.measurement.l1;
import com.google.android.gms.internal.measurement.x0;
import com.google.android.gms.internal.measurement.z0;
import i0.y;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import l1.g;
import m1.a;
import r0.f;
import r2.c;
import r2.d;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class FirebaseAnalytics {

    /* renamed from: b, reason: collision with root package name */
    public static volatile FirebaseAnalytics f2418b;

    /* renamed from: a, reason: collision with root package name */
    public final l1 f2419a;

    public FirebaseAnalytics(l1 l1Var) {
        y.g(l1Var);
        this.f2419a = l1Var;
    }

    @NonNull
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @Keep
    public static FirebaseAnalytics getInstance(@NonNull Context context) {
        if (f2418b == null) {
            synchronized (FirebaseAnalytics.class) {
                try {
                    if (f2418b == null) {
                        f2418b = new FirebaseAnalytics(l1.c(context, null));
                    }
                } finally {
                }
            }
        }
        return f2418b;
    }

    @Nullable
    @Keep
    public static d3 getScionFrontendApiImplementation(Context context, @Nullable Bundle bundle) {
        l1 l1VarC = l1.c(context, bundle);
        if (l1VarC == null) {
            return null;
        }
        return new a(l1VarC);
    }

    @NonNull
    @Keep
    public String getFirebaseInstanceId() {
        try {
            Object obj = c.f12348m;
            return (String) f.j(((c) g.c().b(d.class)).d(), WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        } catch (ExecutionException e3) {
            throw new IllegalStateException(e3.getCause());
        } catch (TimeoutException unused) {
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        }
    }

    @Keep
    @MainThread
    @Deprecated
    public void setCurrentScreen(@NonNull Activity activity, @Nullable @Size(max = 36, min = 1) String str, @Nullable @Size(max = 36, min = 1) String str2) {
        x0 x0VarB = x0.b(activity);
        l1 l1Var = this.f2419a;
        l1Var.getClass();
        l1Var.a(new z0(l1Var, x0VarB, str, str2));
    }
}
