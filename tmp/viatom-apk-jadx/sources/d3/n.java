package d3;

import a3.o1;
import androidx.datastore.core.DataStore;
import java.util.concurrent.atomic.AtomicReference;
import r7.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final o1 f6834a;

    /* renamed from: b, reason: collision with root package name */
    public final DataStore f6835b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicReference f6836c;

    public n(w6.h hVar, o1 o1Var, DataStore dataStore) {
        hVar.getClass();
        o1Var.getClass();
        dataStore.getClass();
        this.f6834a = o1Var;
        this.f6835b = dataStore;
        this.f6836c = new AtomicReference();
        y.q(y.a(hVar), null, null, new l(this, null, 0), 3);
    }

    public final g a() throws Throwable {
        AtomicReference atomicReference = this.f6836c;
        if (atomicReference.get() == null) {
            Object objU = y.u(w6.i.f13523a, new l(this, null, 1));
            while (!atomicReference.compareAndSet(null, objU) && atomicReference.get() == null) {
            }
        }
        Object obj = atomicReference.get();
        obj.getClass();
        return (g) obj;
    }

    public final boolean b() {
        Long l10 = a().e;
        Integer num = a().f6818d;
        if (l10 == null || num == null) {
            return true;
        }
        this.f6834a.getClass();
        return o1.a().f139c - l10.longValue() >= ((long) num.intValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(d3.g r6, y6.c r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof d3.m
            if (r0 == 0) goto L13
            r0 = r7
            d3.m r0 = (d3.m) r0
            int r1 = r0.f6833c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6833c = r1
            goto L18
        L13:
            d3.m r0 = new d3.m
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f6831a
            int r1 = r0.f6833c
            r2 = 1
            if (r1 == 0) goto L2e
            if (r1 != r2) goto L27
            s6.a.e(r7)     // Catch: java.io.IOException -> L25
            goto L59
        L25:
            r6 = move-exception
            goto L46
        L27:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r6)
            r6 = 0
            return r6
        L2e:
            s6.a.e(r7)
            androidx.datastore.core.DataStore r7 = r5.f6835b     // Catch: java.io.IOException -> L25
            a6.n r1 = new a6.n     // Catch: java.io.IOException -> L25
            r3 = 0
            r4 = 14
            r1.<init>(r6, r3, r4)     // Catch: java.io.IOException -> L25
            r0.f6833c = r2     // Catch: java.io.IOException -> L25
            java.lang.Object r6 = r7.updateData(r1, r0)     // Catch: java.io.IOException -> L25
            x6.a r7 = x6.a.f13718a
            if (r6 != r7) goto L59
            return r7
        L46:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "Failed to update config values: "
            r7.<init>(r0)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.String r7 = "FirebaseSessions"
            android.util.Log.w(r7, r6)
        L59:
            s6.w r6 = s6.w.f12711a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: d3.n.c(d3.g, y6.c):java.lang.Object");
    }
}
