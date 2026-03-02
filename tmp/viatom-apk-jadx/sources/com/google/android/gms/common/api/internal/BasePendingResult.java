package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import g0.g;
import g0.i;
import h0.b0;
import h0.d;
import h0.j;
import h0.q;
import i0.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@KeepName
/* loaded from: classes3.dex */
public abstract class BasePendingResult<R extends i> {

    /* renamed from: j, reason: collision with root package name */
    public static final b0 f1862j = new b0(0);
    public i e;
    public Status f;
    public volatile boolean g;
    public boolean h;

    /* renamed from: a, reason: collision with root package name */
    public final Object f1863a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final CountDownLatch f1864b = new CountDownLatch(1);

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f1865c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReference f1866d = new AtomicReference();

    /* renamed from: i, reason: collision with root package name */
    public boolean f1867i = false;

    public BasePendingResult(g gVar) {
        new d(gVar != null ? ((q) gVar).f8397b.f : Looper.getMainLooper(), 3);
        new WeakReference(gVar);
    }

    public final void a(j jVar) {
        synchronized (this.f1863a) {
            try {
                if (d()) {
                    jVar.a(this.f);
                } else {
                    this.f1865c.add(jVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract i b(Status status);

    public final void c(Status status) {
        synchronized (this.f1863a) {
            try {
                if (!d()) {
                    e(b(status));
                    this.h = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean d() {
        return this.f1864b.getCount() == 0;
    }

    public final void e(i iVar) {
        synchronized (this.f1863a) {
            try {
                if (this.h) {
                    return;
                }
                d();
                y.i(!d(), "Results have already been set");
                y.i(!this.g, "Result has already been consumed");
                this.e = iVar;
                this.f = iVar.getStatus();
                this.f1864b.countDown();
                ArrayList arrayList = this.f1865c;
                int size = arrayList.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((j) arrayList.get(i10)).a(this.f);
                }
                arrayList.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
