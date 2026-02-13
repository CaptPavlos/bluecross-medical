package v8;

import java.io.IOException;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w {

    /* renamed from: b, reason: collision with root package name */
    public long f13281b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13282c;

    /* renamed from: d, reason: collision with root package name */
    public final q f13283d;
    public ArrayList e;
    public boolean f;
    public final u g;
    public final t h;

    /* renamed from: a, reason: collision with root package name */
    public long f13280a = 0;

    /* renamed from: i, reason: collision with root package name */
    public final v f13284i = new v(this);

    /* renamed from: j, reason: collision with root package name */
    public final v f13285j = new v(this);

    /* renamed from: k, reason: collision with root package name */
    public int f13286k = 0;

    public w(int i10, q qVar, boolean z9, boolean z10, ArrayList arrayList) {
        if (qVar == null) {
            androidx.window.layout.c.k("connection == null");
            throw null;
        }
        this.f13282c = i10;
        this.f13283d = qVar;
        this.f13281b = qVar.f13258o.c();
        u uVar = new u(this, qVar.f13257n.c());
        this.g = uVar;
        t tVar = new t(this);
        this.h = tVar;
        uVar.e = z10;
        tVar.f13273c = z9;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r2 = this;
            monitor-enter(r2)
            v8.u r0 = r2.g     // Catch: java.lang.Throwable -> L16
            boolean r1 = r0.e     // Catch: java.lang.Throwable -> L16
            if (r1 != 0) goto L1a
            boolean r0 = r0.f13278d     // Catch: java.lang.Throwable -> L16
            if (r0 == 0) goto L1a
            v8.t r0 = r2.h     // Catch: java.lang.Throwable -> L16
            boolean r1 = r0.f13273c     // Catch: java.lang.Throwable -> L16
            if (r1 != 0) goto L18
            boolean r0 = r0.f13272b     // Catch: java.lang.Throwable -> L16
            if (r0 == 0) goto L1a
            goto L18
        L16:
            r0 = move-exception
            goto L31
        L18:
            r0 = 1
            goto L1b
        L1a:
            r0 = 0
        L1b:
            boolean r1 = r2.g()     // Catch: java.lang.Throwable -> L16
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L16
            if (r0 == 0) goto L27
            r0 = 6
            r2.c(r0)
            return
        L27:
            if (r1 != 0) goto L30
            v8.q r0 = r2.f13283d
            int r1 = r2.f13282c
            r0.f(r1)
        L30:
            return
        L31:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L16
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: v8.w.a():void");
    }

    public final void b() throws IOException {
        t tVar = this.h;
        if (tVar.f13272b) {
            com.google.gson.internal.a.m("stream closed");
        } else {
            if (tVar.f13273c) {
                com.google.gson.internal.a.m("stream finished");
                return;
            }
            int i10 = this.f13286k;
            if (i10 != 0) {
                throw new a0(i10);
            }
        }
    }

    public final void c(int i10) {
        if (d(i10)) {
            this.f13283d.f13261r.i(this.f13282c, i10);
        }
    }

    public final boolean d(int i10) {
        synchronized (this) {
            try {
                if (this.f13286k != 0) {
                    return false;
                }
                if (this.g.e && this.h.f13273c) {
                    return false;
                }
                this.f13286k = i10;
                notifyAll();
                this.f13283d.f(this.f13282c);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final t e() {
        synchronized (this) {
            try {
                if (!this.f && !f()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.h;
    }

    public final boolean f() {
        return this.f13283d.f13248a == ((this.f13282c & 1) == 1);
    }

    public final synchronized boolean g() {
        try {
            if (this.f13286k != 0) {
                return false;
            }
            u uVar = this.g;
            if (uVar.e || uVar.f13278d) {
                t tVar = this.h;
                if (tVar.f13273c || tVar.f13272b) {
                    if (this.f) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void h() {
        boolean zG;
        synchronized (this) {
            this.g.e = true;
            zG = g();
            notifyAll();
        }
        if (zG) {
            return;
        }
        this.f13283d.f(this.f13282c);
    }

    public final void i(ArrayList arrayList) {
        boolean zG;
        synchronized (this) {
            zG = true;
            try {
                this.f = true;
                if (this.e == null) {
                    this.e = arrayList;
                    zG = g();
                    notifyAll();
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.addAll(this.e);
                    arrayList2.add(null);
                    arrayList2.addAll(arrayList);
                    this.e = arrayList2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zG) {
            return;
        }
        this.f13283d.f(this.f13282c);
    }

    public final synchronized void j(int i10) {
        if (this.f13286k == 0) {
            this.f13286k = i10;
            notifyAll();
        }
    }
}
