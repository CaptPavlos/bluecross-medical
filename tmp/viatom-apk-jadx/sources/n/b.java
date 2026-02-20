package n;

import java.net.URL;
import java.util.regex.Pattern;
import r2.j;
import t3.h;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public long f11259a;

    /* renamed from: b, reason: collision with root package name */
    public int f11260b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f11261c;

    public b() {
        if (h.f12786b == null) {
            Pattern pattern = j.f12362b;
            h.f12786b = new h(3);
        }
        h hVar = h.f12786b;
        if (j.f12363c == null) {
            j.f12363c = new j(hVar);
        }
        this.f11261c = j.f12363c;
    }

    public synchronized long a(int i10) {
        if (!(i10 == 429 || (i10 >= 500 && i10 < 600))) {
            return 86400000L;
        }
        double dPow = Math.pow(2.0d, this.f11260b);
        ((j) this.f11261c).getClass();
        return (long) Math.min(dPow + ((long) (Math.random() * 1000.0d)), 1800000L);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean b() {
        /*
            r4 = this;
            monitor-enter(r4)
            int r0 = r4.f11260b     // Catch: java.lang.Throwable -> L1b
            if (r0 == 0) goto L1d
            java.lang.Object r0 = r4.f11261c     // Catch: java.lang.Throwable -> L1b
            r2.j r0 = (r2.j) r0     // Catch: java.lang.Throwable -> L1b
            t3.h r0 = r0.f12364a     // Catch: java.lang.Throwable -> L1b
            r0.getClass()     // Catch: java.lang.Throwable -> L1b
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L1b
            long r2 = r4.f11259a     // Catch: java.lang.Throwable -> L1b
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L19
            goto L1d
        L19:
            r0 = 0
            goto L1e
        L1b:
            r0 = move-exception
            goto L20
        L1d:
            r0 = 1
        L1e:
            monitor-exit(r4)
            return r0
        L20:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L1b
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: n.b.b():boolean");
    }

    public synchronized void c() {
        this.f11260b = 0;
    }

    public synchronized void d(int i10) {
        if ((i10 >= 200 && i10 < 300) || i10 == 401 || i10 == 404) {
            c();
            return;
        }
        this.f11260b++;
        long jA = a(i10);
        ((j) this.f11261c).f12364a.getClass();
        this.f11259a = System.currentTimeMillis() + jA;
    }

    public b(int i10, URL url, long j10) {
        this.f11260b = i10;
        this.f11261c = url;
        this.f11259a = j10;
    }
}
