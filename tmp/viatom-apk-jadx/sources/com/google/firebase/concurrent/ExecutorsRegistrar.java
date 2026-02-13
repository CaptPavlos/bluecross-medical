package com.google.firebase.concurrent;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.StrictMode;
import com.google.android.gms.internal.measurement.a4;
import com.google.firebase.components.ComponentRegistrar;
import f9.p;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import p1.b;
import p1.c;
import p1.d;
import p8.u;
import q1.e;
import q1.m;
import q1.q;
import r1.a;
import r1.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@SuppressLint({"ThreadPoolCreation"})
/* loaded from: classes3.dex */
public class ExecutorsRegistrar implements ComponentRegistrar {

    /* renamed from: a, reason: collision with root package name */
    public static final m f2420a = new m(new e(2));

    /* renamed from: b, reason: collision with root package name */
    public static final m f2421b = new m(new e(3));

    /* renamed from: c, reason: collision with root package name */
    public static final m f2422c = new m(new e(4));

    /* renamed from: d, reason: collision with root package name */
    public static final m f2423d = new m(new e(5));

    public static f a() {
        StrictMode.ThreadPolicy.Builder builderDetectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
        builderDetectNetwork.detectResourceMismatches();
        if (Build.VERSION.SDK_INT >= 26) {
            builderDetectNetwork.detectUnbufferedIo();
        }
        return new f(Executors.newFixedThreadPool(4, new a("Firebase Background", 10, builderDetectNetwork.penaltyLog().build())), (ScheduledExecutorService) f2423d.get());
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public final List getComponents() {
        q qVar = new q(p1.a.class, ScheduledExecutorService.class);
        q[] qVarArr = {new q(p1.a.class, ExecutorService.class), new q(p1.a.class, Executor.class)};
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        hashSet.add(qVar);
        for (q qVar2 : qVarArr) {
            a4.i(qVar2, "Null interface");
        }
        Collections.addAll(hashSet, qVarArr);
        q1.a aVar = new q1.a(null, new HashSet(hashSet), new HashSet(hashSet2), 0, 0, new u(5), hashSet3);
        q qVar3 = new q(b.class, ScheduledExecutorService.class);
        q[] qVarArr2 = {new q(b.class, ExecutorService.class), new q(b.class, Executor.class)};
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        HashSet hashSet6 = new HashSet();
        hashSet4.add(qVar3);
        for (q qVar4 : qVarArr2) {
            a4.i(qVar4, "Null interface");
        }
        Collections.addAll(hashSet4, qVarArr2);
        q1.a aVar2 = new q1.a(null, new HashSet(hashSet4), new HashSet(hashSet5), 0, 0, new u(6), hashSet6);
        q qVar5 = new q(c.class, ScheduledExecutorService.class);
        q[] qVarArr3 = {new q(c.class, ExecutorService.class), new q(c.class, Executor.class)};
        HashSet hashSet7 = new HashSet();
        HashSet hashSet8 = new HashSet();
        HashSet hashSet9 = new HashSet();
        hashSet7.add(qVar5);
        for (q qVar6 : qVarArr3) {
            a4.i(qVar6, "Null interface");
        }
        Collections.addAll(hashSet7, qVarArr3);
        q1.a aVar3 = new q1.a(null, new HashSet(hashSet7), new HashSet(hashSet8), 0, 0, new u(7), hashSet9);
        p pVarB = q1.a.b(new q(d.class, Executor.class));
        pVarB.f = new u(8);
        return Arrays.asList(aVar, aVar2, aVar3, pVarB.d());
    }
}
