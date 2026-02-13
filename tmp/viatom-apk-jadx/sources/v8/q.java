package v8;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import z8.b0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q implements Closeable {

    /* renamed from: u, reason: collision with root package name */
    public static final ThreadPoolExecutor f13247u;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f13248a;

    /* renamed from: b, reason: collision with root package name */
    public final m f13249b;

    /* renamed from: d, reason: collision with root package name */
    public final String f13251d;
    public int e;
    public int f;
    public boolean g;
    public final ScheduledThreadPoolExecutor h;

    /* renamed from: i, reason: collision with root package name */
    public final ThreadPoolExecutor f13252i;

    /* renamed from: j, reason: collision with root package name */
    public final z f13253j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f13254k;

    /* renamed from: m, reason: collision with root package name */
    public long f13256m;

    /* renamed from: n, reason: collision with root package name */
    public final h0.a0 f13257n;

    /* renamed from: o, reason: collision with root package name */
    public final h0.a0 f13258o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f13259p;

    /* renamed from: q, reason: collision with root package name */
    public final Socket f13260q;

    /* renamed from: r, reason: collision with root package name */
    public final x f13261r;

    /* renamed from: s, reason: collision with root package name */
    public final o f13262s;
    public final LinkedHashSet t;

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f13250c = new LinkedHashMap();

    /* renamed from: l, reason: collision with root package name */
    public long f13255l = 0;

    static {
        SynchronousQueue synchronousQueue = new SynchronousQueue();
        byte[] bArr = q8.c.f12289a;
        f13247u = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, synchronousQueue, new q8.b("OkHttp Http2Connection", true));
    }

    public q(h0.p pVar) {
        h0.a0 a0Var = new h0.a0(4);
        this.f13257n = a0Var;
        h0.a0 a0Var2 = new h0.a0(4);
        this.f13258o = a0Var2;
        this.f13259p = false;
        this.t = new LinkedHashSet();
        this.f13253j = z.f13295a;
        boolean z9 = pVar.f8393a;
        this.f13248a = z9;
        this.f13249b = (m) pVar.f;
        int i10 = z9 ? 1 : 2;
        this.f = i10;
        if (z9) {
            this.f = i10 + 2;
        }
        if (z9) {
            a0Var.i(7, 16777216);
        }
        String str = (String) pVar.f8395c;
        this.f13251d = str;
        byte[] bArr = q8.c.f12289a;
        Locale locale = Locale.US;
        this.h = new ScheduledThreadPoolExecutor(1, new q8.b(androidx.constraintlayout.core.widgets.analyzer.a.x("OkHttp ", str, " Writer"), false));
        this.f13252i = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new q8.b(androidx.constraintlayout.core.widgets.analyzer.a.x("OkHttp ", str, " Push Observer"), true));
        a0Var2.i(7, 65535);
        a0Var2.i(5, 16384);
        this.f13256m = a0Var2.c();
        this.f13260q = (Socket) pVar.f8394b;
        this.f13261r = new x((z8.a0) pVar.e, z9);
        this.f13262s = new o(this, new s((b0) pVar.f8396d, z9));
    }

    public final void a(int i10, int i11) throws IOException {
        w[] wVarArr = null;
        try {
            h(i10);
            e = null;
        } catch (IOException e) {
            e = e;
        }
        synchronized (this) {
            try {
                if (!this.f13250c.isEmpty()) {
                    wVarArr = (w[]) this.f13250c.values().toArray(new w[this.f13250c.size()]);
                    this.f13250c.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (wVarArr != null) {
            for (w wVar : wVarArr) {
                try {
                    wVar.c(i11);
                } catch (IOException e3) {
                    if (e != null) {
                        e = e3;
                    }
                }
            }
        }
        try {
            this.f13261r.close();
        } catch (IOException e7) {
            if (e == null) {
                e = e7;
            }
        }
        try {
            this.f13260q.close();
        } catch (IOException e10) {
            e = e10;
        }
        this.h.shutdown();
        this.f13252i.shutdown();
        if (e != null) {
            throw e;
        }
    }

    public final void b() {
        try {
            a(2, 2);
        } catch (IOException unused) {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        a(1, 6);
    }

    public final synchronized w d(int i10) {
        return (w) this.f13250c.get(Integer.valueOf(i10));
    }

    public final synchronized int e() {
        h0.a0 a0Var;
        a0Var = this.f13258o;
        return (a0Var.f8352b & 16) != 0 ? ((int[]) a0Var.f8353c)[4] : Integer.MAX_VALUE;
    }

    public final synchronized w f(int i10) {
        w wVar;
        wVar = (w) this.f13250c.remove(Integer.valueOf(i10));
        notifyAll();
        return wVar;
    }

    public final void flush() {
        this.f13261r.flush();
    }

    public final void h(int i10) {
        synchronized (this.f13261r) {
            synchronized (this) {
                if (this.g) {
                    return;
                }
                this.g = true;
                this.f13261r.e(this.e, i10, q8.c.f12289a);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
    
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r4), r8.f13261r.f13290d);
        r6 = r2;
        r8.f13256m -= r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(int r9, boolean r10, z8.i r11, long r12) {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto Ld
            v8.x r12 = r8.f13261r
            r12.b(r10, r9, r11, r3)
            return
        Ld:
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L5e
            monitor-enter(r8)
        L12:
            long r4 = r8.f13256m     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L56
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 > 0) goto L32
            java.util.LinkedHashMap r2 = r8.f13250c     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L56
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L56
            boolean r2 = r2.containsKey(r4)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L56
            if (r2 == 0) goto L2a
            r8.wait()     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L56
            goto L12
        L28:
            r9 = move-exception
            goto L5c
        L2a:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L56
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L56
            throw r9     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L56
        L32:
            long r4 = java.lang.Math.min(r12, r4)     // Catch: java.lang.Throwable -> L28
            int r2 = (int) r4     // Catch: java.lang.Throwable -> L28
            v8.x r4 = r8.f13261r     // Catch: java.lang.Throwable -> L28
            int r4 = r4.f13290d     // Catch: java.lang.Throwable -> L28
            int r2 = java.lang.Math.min(r2, r4)     // Catch: java.lang.Throwable -> L28
            long r4 = r8.f13256m     // Catch: java.lang.Throwable -> L28
            long r6 = (long) r2     // Catch: java.lang.Throwable -> L28
            long r4 = r4 - r6
            r8.f13256m = r4     // Catch: java.lang.Throwable -> L28
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L28
            long r12 = r12 - r6
            v8.x r4 = r8.f13261r
            if (r10 == 0) goto L51
            int r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r5 != 0) goto L51
            r5 = 1
            goto L52
        L51:
            r5 = r3
        L52:
            r4.b(r5, r9, r11, r2)
            goto Ld
        L56:
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L28
            r9.<init>()     // Catch: java.lang.Throwable -> L28
            throw r9     // Catch: java.lang.Throwable -> L28
        L5c:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L28
            throw r9
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: v8.q.i(int, boolean, z8.i, long):void");
    }

    public final void j(int i10, int i11) {
        try {
            this.h.execute(new h(this, new Object[]{this.f13251d, Integer.valueOf(i10)}, i10, i11));
        } catch (RejectedExecutionException unused) {
        }
    }

    public final void k(int i10, long j10) {
        try {
            this.h.execute(new i(this, new Object[]{this.f13251d, Integer.valueOf(i10)}, i10, j10));
        } catch (RejectedExecutionException unused) {
        }
    }
}
