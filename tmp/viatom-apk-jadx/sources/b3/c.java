package b3;

import j$.util.DesugarCollections;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f832a = new c();

    /* renamed from: b, reason: collision with root package name */
    public static final Map f833b = DesugarCollections.synchronizedMap(new LinkedHashMap());

    public static a a(d dVar) {
        Map map = f833b;
        map.getClass();
        Object obj = map.get(dVar);
        if (obj != null) {
            return (a) obj;
        }
        androidx.core.view.accessibility.a.s(dVar, "Cannot get dependency ", ". Dependencies should be added at class load time.");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a9 A[Catch: all -> 0x00c2, TRY_ENTER, TryCatch #0 {all -> 0x00c2, blocks: (B:21:0x0096, B:24:0x00a9, B:25:0x00c1), top: B:30:0x0096 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0095 -> B:30:0x0096). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(y6.c r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof b3.b
            if (r0 == 0) goto L13
            r0 = r10
            b3.b r0 = (b3.b) r0
            int r1 = r0.f831i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f831i = r1
            goto L18
        L13:
            b3.b r0 = new b3.b
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.g
            int r1 = r0.f831i
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L3d
            if (r1 != r2) goto L36
            java.lang.Object r1 = r0.f
            java.util.Map r4 = r0.e
            java.util.Map r4 = (java.util.Map) r4
            a8.i r5 = r0.f830d
            b3.d r6 = r0.f829c
            java.util.Iterator r7 = r0.f828b
            java.util.Map r8 = r0.f827a
            java.util.Map r8 = (java.util.Map) r8
            s6.a.e(r10)
            goto L96
        L36:
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r10)
            r10 = 0
            return r10
        L3d:
            s6.a.e(r10)
            java.util.Map r10 = b3.c.f833b
            r10.getClass()
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            int r4 = r10.size()
            int r4 = t6.a0.h0(r4)
            r1.<init>(r4)
            java.util.Set r10 = r10.entrySet()
            java.util.Iterator r10 = r10.iterator()
            r7 = r10
            r4 = r1
        L5c:
            boolean r10 = r7.hasNext()
            if (r10 == 0) goto Lc7
            java.lang.Object r10 = r7.next()
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10
            java.lang.Object r1 = r10.getKey()
            java.lang.Object r5 = r10.getKey()
            r6 = r5
            b3.d r6 = (b3.d) r6
            java.lang.Object r10 = r10.getValue()
            b3.a r10 = (b3.a) r10
            a8.i r5 = r10.f825a
            r10 = r4
            java.util.Map r10 = (java.util.Map) r10
            r0.f827a = r10
            r0.f828b = r7
            r0.f829c = r6
            r0.f830d = r5
            r0.e = r10
            r0.f = r1
            r0.f831i = r2
            java.lang.Object r10 = r5.lock(r3, r0)
            x6.a r8 = x6.a.f13718a
            if (r10 != r8) goto L95
            return r8
        L95:
            r8 = r4
        L96:
            r6.getClass()     // Catch: java.lang.Throwable -> Lc2
            b3.a r10 = a(r6)     // Catch: java.lang.Throwable -> Lc2
            w1.i r10 = r10.f826b     // Catch: java.lang.Throwable -> Lc2
            if (r10 == 0) goto La9
            r5.unlock(r3)
            r4.put(r1, r10)
            r4 = r8
            goto L5c
        La9:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> Lc2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc2
            java.lang.String r1 = "Subscriber "
            r0.<init>(r1)     // Catch: java.lang.Throwable -> Lc2
            r0.append(r6)     // Catch: java.lang.Throwable -> Lc2
            java.lang.String r1 = " has not been registered."
            r0.append(r1)     // Catch: java.lang.Throwable -> Lc2
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Lc2
            r10.<init>(r0)     // Catch: java.lang.Throwable -> Lc2
            throw r10     // Catch: java.lang.Throwable -> Lc2
        Lc2:
            r10 = move-exception
            r5.unlock(r3)
            throw r10
        Lc7:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: b3.c.b(y6.c):java.lang.Object");
    }
}
