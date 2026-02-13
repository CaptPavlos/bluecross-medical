package c1;

import android.os.Bundle;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class v2 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1513a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f1514b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c3 f1515c;

    public v2(c3 c3Var, AtomicReference atomicReference, int i10) {
        this.f1513a = i10;
        switch (i10) {
            case 1:
                this.f1514b = atomicReference;
                Objects.requireNonNull(c3Var);
                this.f1515c = c3Var;
                break;
            case 2:
                this.f1514b = atomicReference;
                Objects.requireNonNull(c3Var);
                this.f1515c = c3Var;
                break;
            case 3:
                this.f1514b = atomicReference;
                Objects.requireNonNull(c3Var);
                this.f1515c = c3Var;
                break;
            case 4:
                this.f1514b = atomicReference;
                Objects.requireNonNull(c3Var);
                this.f1515c = c3Var;
                break;
            default:
                this.f1514b = atomicReference;
                Objects.requireNonNull(c3Var);
                this.f1515c = c3Var;
                break;
        }
    }

    private final void a() {
        AtomicReference atomicReference = this.f1514b;
        synchronized (atomicReference) {
            try {
                try {
                    u1 u1Var = this.f1515c.f1149a;
                    atomicReference.set(u1Var.f1478d.m(u1Var.r().m(), f0.f1160c0));
                } finally {
                    this.f1514b.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void b() {
        AtomicReference atomicReference = this.f1514b;
        synchronized (atomicReference) {
            try {
                try {
                    u1 u1Var = this.f1515c.f1149a;
                    atomicReference.set(Long.valueOf(u1Var.f1478d.n(u1Var.r().m(), f0.f1163d0)));
                } finally {
                    this.f1514b.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void c() {
        AtomicReference atomicReference = this.f1514b;
        synchronized (atomicReference) {
            try {
                try {
                    u1 u1Var = this.f1515c.f1149a;
                    atomicReference.set(Integer.valueOf(u1Var.f1478d.o(u1Var.r().m(), f0.f1165e0)));
                } finally {
                    this.f1514b.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void d() {
        AtomicReference atomicReference = this.f1514b;
        synchronized (atomicReference) {
            try {
                try {
                    u1 u1Var = this.f1515c.f1149a;
                    atomicReference.set(Double.valueOf(u1Var.f1478d.p(u1Var.r().m(), f0.f1167f0)));
                } finally {
                    this.f1514b.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() throws JSONException {
        switch (this.f1513a) {
            case 0:
                AtomicReference atomicReference = this.f1514b;
                synchronized (atomicReference) {
                    try {
                        try {
                            u1 u1Var = this.f1515c.f1149a;
                            atomicReference.set(Boolean.valueOf(u1Var.f1478d.q(u1Var.r().m(), f0.f1158b0)));
                        } finally {
                            this.f1514b.notify();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            case 1:
                a();
                return;
            case 2:
                b();
                return;
            case 3:
                c();
                return;
            case 4:
                d();
                return;
            case 5:
                c3 c3Var = this.f1515c;
                h1 h1Var = c3Var.f1149a.e;
                u1.k(h1Var);
                Bundle bundleI = h1Var.f1251n.I();
                x3 x3VarP = c3Var.f1149a.p();
                AtomicReference atomicReference2 = this.f1514b;
                x3VarP.g();
                x3VarP.h();
                x3VarP.u(new c2(x3VarP, atomicReference2, x3VarP.w(false), bundleI, 6));
                return;
            default:
                x3 x3VarP2 = this.f1515c.f1149a.p();
                o4 o4VarB = o4.b(j3.SGTM_CLIENT);
                AtomicReference atomicReference3 = this.f1514b;
                x3VarP2.g();
                x3VarP2.h();
                x3VarP2.u(new c2(x3VarP2, atomicReference3, x3VarP2.w(false), o4VarB));
                return;
        }
    }

    public /* synthetic */ v2(c3 c3Var, AtomicReference atomicReference, int i10, boolean z9) {
        this.f1513a = i10;
        this.f1515c = c3Var;
        this.f1514b = atomicReference;
    }
}
