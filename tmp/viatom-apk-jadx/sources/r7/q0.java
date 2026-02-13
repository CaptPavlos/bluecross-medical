package r7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class q0 implements Runnable, Comparable, k0 {
    private volatile Object _heap;

    /* renamed from: a, reason: collision with root package name */
    public long f12429a;

    /* renamed from: b, reason: collision with root package name */
    public int f12430b = -1;

    public q0(long j10) {
        this.f12429a = j10;
    }

    public final w7.x b() {
        Object obj = this._heap;
        if (obj instanceof w7.x) {
            return (w7.x) obj;
        }
        return null;
    }

    public final int c(long j10, r0 r0Var, s0 s0Var) {
        synchronized (this) {
            if (this._heap == y.f12450b) {
                return 2;
            }
            synchronized (r0Var) {
                try {
                    q0[] q0VarArr = r0Var.f13563a;
                    q0 q0Var = q0VarArr != null ? q0VarArr[0] : null;
                    if (s0.g.get(s0Var) != 0) {
                        return 1;
                    }
                    if (q0Var == null) {
                        r0Var.f12433c = j10;
                    } else {
                        long j11 = q0Var.f12429a;
                        if (j11 - j10 < 0) {
                            j10 = j11;
                        }
                        if (j10 - r0Var.f12433c > 0) {
                            r0Var.f12433c = j10;
                        }
                    }
                    long j12 = this.f12429a;
                    long j13 = r0Var.f12433c;
                    if (j12 - j13 < 0) {
                        this.f12429a = j13;
                    }
                    r0Var.a(this);
                    return 0;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        long j10 = this.f12429a - ((q0) obj).f12429a;
        if (j10 > 0) {
            return 1;
        }
        return j10 < 0 ? -1 : 0;
    }

    public final void d(r0 r0Var) {
        if (this._heap != y.f12450b) {
            this._heap = r0Var;
        } else {
            com.google.gson.internal.a.n("Failed requirement.");
        }
    }

    @Override // r7.k0
    public final void dispose() {
        synchronized (this) {
            try {
                Object obj = this._heap;
                e2.a aVar = y.f12450b;
                if (obj == aVar) {
                    return;
                }
                r0 r0Var = obj instanceof r0 ? (r0) obj : null;
                if (r0Var != null) {
                    r0Var.b(this);
                }
                this._heap = aVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        return "Delayed[nanos=" + this.f12429a + ']';
    }
}
