package h1;

import java.util.concurrent.ExecutionException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k implements f, e, c {

    /* renamed from: a, reason: collision with root package name */
    public final Object f8421a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final int f8422b;

    /* renamed from: c, reason: collision with root package name */
    public final p f8423c;

    /* renamed from: d, reason: collision with root package name */
    public int f8424d;
    public int e;
    public int f;
    public Exception g;
    public boolean h;

    public k(int i10, p pVar) {
        this.f8422b = i10;
        this.f8423c = pVar;
    }

    public final void a() {
        int i10 = this.f8424d;
        int i11 = this.e;
        int i12 = i10 + i11 + this.f;
        int i13 = this.f8422b;
        if (i12 == i13) {
            Exception exc = this.g;
            p pVar = this.f8423c;
            if (exc == null) {
                if (this.h) {
                    pVar.m();
                    return;
                } else {
                    pVar.l(null);
                    return;
                }
            }
            pVar.k(new ExecutionException(i11 + " out of " + i13 + " underlying tasks failed", this.g));
        }
    }

    @Override // h1.f
    public final void h(Object obj) {
        synchronized (this.f8421a) {
            this.f8424d++;
            a();
        }
    }

    @Override // h1.c
    public final void n() {
        synchronized (this.f8421a) {
            this.f++;
            this.h = true;
            a();
        }
    }

    @Override // h1.e
    public final void u(Exception exc) {
        synchronized (this.f8421a) {
            this.e++;
            this.g = exc;
            a();
        }
    }
}
