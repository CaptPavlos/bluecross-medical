package p8;

import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import l4.x4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m {
    public static final ThreadPoolExecutor g;
    public boolean f;

    /* renamed from: c, reason: collision with root package name */
    public final a4.a f12129c = new a4.a(this, 20);

    /* renamed from: d, reason: collision with root package name */
    public final ArrayDeque f12130d = new ArrayDeque();
    public final x4 e = new x4(19);

    /* renamed from: a, reason: collision with root package name */
    public final int f12127a = 5;

    /* renamed from: b, reason: collision with root package name */
    public final long f12128b = 300000000000L;

    static {
        SynchronousQueue synchronousQueue = new SynchronousQueue();
        byte[] bArr = q8.c.f12289a;
        g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, synchronousQueue, new q8.b("OkHttp ConnectionPool", true));
    }

    public final long a(long j10) {
        synchronized (this) {
            try {
                Iterator it = this.f12130d.iterator();
                s8.a aVar = null;
                long j11 = Long.MIN_VALUE;
                int i10 = 0;
                int i11 = 0;
                while (it.hasNext()) {
                    s8.a aVar2 = (s8.a) it.next();
                    if (b(aVar2, j10) > 0) {
                        i11++;
                    } else {
                        i10++;
                        long j12 = j10 - aVar2.f12726o;
                        if (j12 > j11) {
                            aVar = aVar2;
                            j11 = j12;
                        }
                    }
                }
                long j13 = this.f12128b;
                if (j11 < j13 && i10 <= this.f12127a) {
                    if (i10 > 0) {
                        return j13 - j11;
                    }
                    if (i11 > 0) {
                        return j13;
                    }
                    this.f = false;
                    return -1L;
                }
                this.f12130d.remove(aVar);
                q8.c.d(aVar.e);
                return 0L;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int b(s8.a aVar, long j10) {
        ArrayList arrayList = aVar.f12725n;
        int i10 = 0;
        while (i10 < arrayList.size()) {
            Reference reference = (Reference) arrayList.get(i10);
            if (reference.get() != null) {
                i10++;
            } else {
                x8.h.f13740a.l("A connection to " + aVar.f12718c.f12081a.f12045a + " was leaked. Did you forget to close a response body?", ((s8.e) reference).f12735a);
                arrayList.remove(i10);
                aVar.f12722k = true;
                if (arrayList.isEmpty()) {
                    aVar.f12726o = j10 - this.f12128b;
                    return 0;
                }
            }
        }
        return arrayList.size();
    }
}
