package c1;

import android.os.RemoteException;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class y1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1600a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f1601b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1602c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f1603d;

    public y1(x3 x3Var, AtomicReference atomicReference, d5 d5Var) {
        this.f1600a = 5;
        this.f1603d = atomicReference;
        this.f1601b = d5Var;
        Objects.requireNonNull(x3Var);
        this.f1602c = x3Var;
    }

    private final void a() {
        AtomicReference atomicReference;
        x3 x3Var;
        u1 u1Var;
        h1 h1Var;
        AtomicReference atomicReference2 = (AtomicReference) this.f1603d;
        synchronized (atomicReference2) {
            try {
                try {
                    x3Var = (x3) this.f1602c;
                    u1Var = x3Var.f1149a;
                    h1Var = u1Var.e;
                    u1.k(h1Var);
                } catch (RemoteException e) {
                    w0 w0Var = ((x3) this.f1602c).f1149a.f;
                    u1.m(w0Var);
                    w0Var.f.c(e, "Failed to get app instance id");
                    atomicReference = (AtomicReference) this.f1603d;
                }
                if (h1Var.n().i(j2.ANALYTICS_STORAGE)) {
                    i0 i0Var = x3Var.f1572d;
                    if (i0Var != null) {
                        atomicReference2.set(i0Var.r((d5) this.f1601b));
                        String str = (String) atomicReference2.get();
                        if (str != null) {
                            c3 c3Var = x3Var.f1149a.f1483m;
                            u1.l(c3Var);
                            c3Var.g.set(str);
                            h1 h1Var2 = u1Var.e;
                            u1.k(h1Var2);
                            h1Var2.g.o(str);
                        }
                        x3Var.t();
                        atomicReference = (AtomicReference) this.f1603d;
                        atomicReference.notify();
                        return;
                    }
                    w0 w0Var2 = u1Var.f;
                    u1.m(w0Var2);
                    w0Var2.f.b("Failed to get app instance id");
                } else {
                    w0 w0Var3 = u1Var.f;
                    u1.m(w0Var3);
                    w0Var3.f1542k.b("Analytics storage consent denied; will not get app instance id");
                    c3 c3Var2 = x3Var.f1149a.f1483m;
                    u1.l(c3Var2);
                    c3Var2.g.set(null);
                    h1 h1Var3 = u1Var.e;
                    u1.k(h1Var3);
                    h1Var3.g.o(null);
                    atomicReference2.set(null);
                }
                atomicReference2.notify();
            } catch (Throwable th) {
                ((AtomicReference) this.f1603d).notify();
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x040f  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1470
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.y1.run():void");
    }

    public /* synthetic */ y1(Object obj, Object obj2, Object obj3, int i10) {
        this.f1600a = i10;
        this.f1603d = obj2;
        this.f1601b = obj3;
        this.f1602c = obj;
    }

    public /* synthetic */ y1(Object obj, Object obj2, Object obj3, int i10, boolean z9) {
        this.f1600a = i10;
        this.f1603d = obj;
        this.f1601b = obj2;
        this.f1602c = obj3;
    }

    public /* synthetic */ y1(Object obj, d5 d5Var, Object obj2, int i10) {
        this.f1600a = i10;
        this.f1602c = obj;
        this.f1601b = d5Var;
        this.f1603d = obj2;
    }
}
