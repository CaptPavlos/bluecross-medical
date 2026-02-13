package u7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class i0 {

    /* renamed from: a, reason: collision with root package name */
    public static final e2.a f13005a = new e2.a("NO_VALUE");

    /* renamed from: b, reason: collision with root package name */
    public static final e2.a f13006b = new e2.a("NONE");

    /* renamed from: c, reason: collision with root package name */
    public static final e2.a f13007c = new e2.a("PENDING");

    public static final m0 a(Object obj) {
        if (obj == null) {
            obj = v7.c.f13178b;
        }
        return new m0(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(u7.o0 r4, g7.q r5, java.lang.Throwable r6, y6.c r7) {
        /*
            boolean r0 = r7 instanceof u7.k
            if (r0 == 0) goto L13
            r0 = r7
            u7.k r0 = (u7.k) r0
            int r1 = r0.f13016c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f13016c = r1
            goto L18
        L13:
            u7.k r0 = new u7.k
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f13015b
            int r1 = r0.f13016c
            r2 = 1
            if (r1 == 0) goto L30
            if (r1 != r2) goto L29
            java.lang.Throwable r6 = r0.f13014a
            s6.a.e(r7)     // Catch: java.lang.Throwable -> L27
            goto L40
        L27:
            r4 = move-exception
            goto L43
        L29:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r4)
            r4 = 0
            return r4
        L30:
            s6.a.e(r7)
            r0.f13014a = r6     // Catch: java.lang.Throwable -> L27
            r0.f13016c = r2     // Catch: java.lang.Throwable -> L27
            java.lang.Object r4 = r5.invoke(r4, r6, r0)     // Catch: java.lang.Throwable -> L27
            x6.a r5 = x6.a.f13718a
            if (r4 != r5) goto L40
            return r5
        L40:
            s6.w r4 = s6.w.f12711a
            return r4
        L43:
            if (r6 == 0) goto L4a
            if (r6 == r4) goto L4a
            s6.a.a(r4, r6)
        L4a:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: u7.i0.b(u7.o0, g7.q, java.lang.Throwable, y6.c):java.lang.Object");
    }

    public static final void c(Object[] objArr, long j10, Object obj) {
        objArr[((int) j10) & (objArr.length - 1)] = obj;
    }

    public static final c d(g7.p pVar) {
        return new c(pVar, w6.i.f13523a, -2, t7.a.f12813a);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.io.Serializable e(u7.h r4, u7.i r5, y6.c r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof u7.q
            if (r0 == 0) goto L13
            r0 = r6
            u7.q r0 = (u7.q) r0
            int r1 = r0.f13043c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f13043c = r1
            goto L18
        L13:
            u7.q r0 = new u7.q
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f13042b
            int r1 = r0.f13043c
            r2 = 1
            if (r1 == 0) goto L30
            if (r1 != r2) goto L29
            kotlin.jvm.internal.x r4 = r0.f13041a
            s6.a.e(r6)     // Catch: java.lang.Throwable -> L27
            goto L4a
        L27:
            r5 = move-exception
            goto L4e
        L29:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r4)
            r4 = 0
            return r4
        L30:
            s6.a.e(r6)
            kotlin.jvm.internal.x r6 = new kotlin.jvm.internal.x
            r6.<init>()
            u7.f r1 = new u7.f     // Catch: java.lang.Throwable -> L4c
            r1.<init>(r5, r6)     // Catch: java.lang.Throwable -> L4c
            r0.f13041a = r6     // Catch: java.lang.Throwable -> L4c
            r0.f13043c = r2     // Catch: java.lang.Throwable -> L4c
            java.lang.Object r4 = r4.collect(r1, r0)     // Catch: java.lang.Throwable -> L4c
            x6.a r5 = x6.a.f13718a
            if (r4 != r5) goto L4a
            return r5
        L4a:
            r4 = 0
            return r4
        L4c:
            r5 = move-exception
            r4 = r6
        L4e:
            java.lang.Object r4 = r4.f10138a
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            if (r4 == 0) goto L5a
            boolean r6 = r4.equals(r5)
            if (r6 != 0) goto L7c
        L5a:
            w6.h r6 = r0.getContext()
            r7.t r0 = r7.t.f12437b
            w6.f r6 = r6.get(r0)
            r7.a1 r6 = (r7.a1) r6
            if (r6 == 0) goto L7d
            boolean r0 = r6.isCancelled()
            if (r0 != 0) goto L6f
            goto L7d
        L6f:
            java.util.concurrent.CancellationException r6 = r6.e()
            if (r6 == 0) goto L7d
            boolean r6 = r6.equals(r5)
            if (r6 != 0) goto L7c
            goto L7d
        L7c:
            throw r5
        L7d:
            if (r4 != 0) goto L80
            return r5
        L80:
            boolean r6 = r5 instanceof java.util.concurrent.CancellationException
            if (r6 == 0) goto L88
            s6.a.a(r4, r5)
            throw r4
        L88:
            s6.a.a(r5, r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: u7.i0.e(u7.h, u7.i, y6.c):java.io.Serializable");
    }

    public static final h f(h hVar) {
        boolean z9 = hVar instanceof v7.i;
        t7.a aVar = t7.a.f12814b;
        return z9 ? v7.c.a((v7.i) hVar, null, 0, aVar, 1) : new d(hVar, (w6.h) null, 0, aVar, 2);
    }

    public static final h g(h hVar) {
        return ((hVar instanceof k0) || (hVar instanceof g)) ? hVar : new g(hVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0084, code lost:
    
        if (r1.emit(r10, r0) == r5) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0072 A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #1 {all -> 0x0035, blocks: (B:13:0x002f, B:25:0x0055, B:29:0x006a, B:31:0x0072, B:20:0x0046, B:24:0x0051), top: B:52:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0084 -> B:14:0x0032). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object h(u7.i r7, t7.i r8, boolean r9, y6.c r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof u7.j
            if (r0 == 0) goto L13
            r0 = r10
            u7.j r0 = (u7.j) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            u7.j r0 = new u7.j
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.e
            int r1 = r0.f
            r2 = 0
            r3 = 2
            r4 = 1
            x6.a r5 = x6.a.f13718a
            if (r1 == 0) goto L4a
            if (r1 == r4) goto L3e
            if (r1 != r3) goto L37
            boolean r9 = r0.f13011d
            t7.b r7 = r0.f13010c
            t7.i r8 = r0.f13009b
            u7.i r1 = r0.f13008a
            s6.a.e(r10)     // Catch: java.lang.Throwable -> L35
        L32:
            r10 = r7
            r7 = r1
            goto L55
        L35:
            r7 = move-exception
            goto L8f
        L37:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r7)
            r7 = 0
            return r7
        L3e:
            boolean r9 = r0.f13011d
            t7.b r7 = r0.f13010c
            t7.i r8 = r0.f13009b
            u7.i r1 = r0.f13008a
            s6.a.e(r10)     // Catch: java.lang.Throwable -> L35
            goto L6a
        L4a:
            s6.a.e(r10)
            boolean r10 = r7 instanceof u7.o0
            if (r10 != 0) goto Laa
            t7.b r10 = r8.iterator()     // Catch: java.lang.Throwable -> L35
        L55:
            r0.f13008a = r7     // Catch: java.lang.Throwable -> L35
            r0.f13009b = r8     // Catch: java.lang.Throwable -> L35
            r0.f13010c = r10     // Catch: java.lang.Throwable -> L35
            r0.f13011d = r9     // Catch: java.lang.Throwable -> L35
            r0.f = r4     // Catch: java.lang.Throwable -> L35
            java.lang.Object r1 = r10.b(r0)     // Catch: java.lang.Throwable -> L35
            if (r1 != r5) goto L66
            goto L86
        L66:
            r6 = r1
            r1 = r7
            r7 = r10
            r10 = r6
        L6a:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L35
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L35
            if (r10 == 0) goto L87
            java.lang.Object r10 = r7.c()     // Catch: java.lang.Throwable -> L35
            r0.f13008a = r1     // Catch: java.lang.Throwable -> L35
            r0.f13009b = r8     // Catch: java.lang.Throwable -> L35
            r0.f13010c = r7     // Catch: java.lang.Throwable -> L35
            r0.f13011d = r9     // Catch: java.lang.Throwable -> L35
            r0.f = r3     // Catch: java.lang.Throwable -> L35
            java.lang.Object r10 = r1.emit(r10, r0)     // Catch: java.lang.Throwable -> L35
            if (r10 != r5) goto L32
        L86:
            return r5
        L87:
            if (r9 == 0) goto L8c
            r8.a(r2)
        L8c:
            s6.w r7 = s6.w.f12711a
            return r7
        L8f:
            throw r7     // Catch: java.lang.Throwable -> L90
        L90:
            r10 = move-exception
            if (r9 == 0) goto La9
            boolean r9 = r7 instanceof java.util.concurrent.CancellationException
            if (r9 == 0) goto L9a
            r2 = r7
            java.util.concurrent.CancellationException r2 = (java.util.concurrent.CancellationException) r2
        L9a:
            if (r2 != 0) goto La6
            java.util.concurrent.CancellationException r2 = new java.util.concurrent.CancellationException
            java.lang.String r9 = "Channel was consumed, consumer had failed"
            r2.<init>(r9)
            r2.initCause(r7)
        La6:
            r8.a(r2)
        La9:
            throw r10
        Laa:
            u7.o0 r7 = (u7.o0) r7
            java.lang.Throwable r7 = r7.f13036a
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: u7.i0.h(u7.i, t7.i, boolean, y6.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0061 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object i(u7.h r5, y6.c r6) {
        /*
            e2.a r0 = v7.c.f13178b
            boolean r1 = r6 instanceof u7.y
            if (r1 == 0) goto L15
            r1 = r6
            u7.y r1 = (u7.y) r1
            int r2 = r1.f13070d
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.f13070d = r2
            goto L1a
        L15:
            u7.y r1 = new u7.y
            r1.<init>(r6)
        L1a:
            java.lang.Object r6 = r1.f13069c
            int r2 = r1.f13070d
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2d
            u7.x r5 = r1.f13068b
            kotlin.jvm.internal.x r1 = r1.f13067a
            s6.a.e(r6)     // Catch: v7.a -> L2b
            goto L5d
        L2b:
            r6 = move-exception
            goto L59
        L2d:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r5)
        L32:
            r5 = 0
            return r5
        L34:
            s6.a.e(r6)
            kotlin.jvm.internal.x r6 = new kotlin.jvm.internal.x
            r6.<init>()
            r6.f10138a = r0
            u7.x r2 = new u7.x
            r4 = 0
            r2.<init>(r6, r4)
            r1.f13067a = r6     // Catch: v7.a -> L55
            r1.f13068b = r2     // Catch: v7.a -> L55
            r1.f13070d = r3     // Catch: v7.a -> L55
            java.lang.Object r5 = r5.collect(r2, r1)     // Catch: v7.a -> L55
            x6.a r1 = x6.a.f13718a
            if (r5 != r1) goto L53
            return r1
        L53:
            r1 = r6
            goto L5d
        L55:
            r5 = move-exception
            r1 = r6
            r6 = r5
            r5 = r2
        L59:
            java.lang.Object r2 = r6.f13173a
            if (r2 != r5) goto L68
        L5d:
            java.lang.Object r5 = r1.f10138a
            if (r5 == r0) goto L62
            return r5
        L62:
            java.lang.String r5 = "Expected at least one element"
            com.google.gson.internal.a.o(r5)
            goto L32
        L68:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: u7.i0.i(u7.h, y6.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object j(u7.h r4, y6.c r5) {
        /*
            boolean r0 = r5 instanceof u7.z
            if (r0 == 0) goto L13
            r0 = r5
            u7.z r0 = (u7.z) r0
            int r1 = r0.f13074d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f13074d = r1
            goto L18
        L13:
            u7.z r0 = new u7.z
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f13073c
            int r1 = r0.f13074d
            r2 = 1
            if (r1 == 0) goto L32
            if (r1 != r2) goto L2b
            u7.x r4 = r0.f13072b
            kotlin.jvm.internal.x r0 = r0.f13071a
            s6.a.e(r5)     // Catch: v7.a -> L29
            goto L59
        L29:
            r5 = move-exception
            goto L55
        L2b:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r4)
            r4 = 0
            return r4
        L32:
            s6.a.e(r5)
            kotlin.jvm.internal.x r5 = new kotlin.jvm.internal.x
            r5.<init>()
            u7.x r1 = new u7.x
            r3 = 1
            r1.<init>(r5, r3)
            r0.f13071a = r5     // Catch: v7.a -> L51
            r0.f13072b = r1     // Catch: v7.a -> L51
            r0.f13074d = r2     // Catch: v7.a -> L51
            java.lang.Object r4 = r4.collect(r1, r0)     // Catch: v7.a -> L51
            x6.a r0 = x6.a.f13718a
            if (r4 != r0) goto L4f
            return r0
        L4f:
            r0 = r5
            goto L59
        L51:
            r4 = move-exception
            r0 = r5
            r5 = r4
            r4 = r1
        L55:
            java.lang.Object r1 = r5.f13173a
            if (r1 != r4) goto L5c
        L59:
            java.lang.Object r4 = r0.f10138a
            return r4
        L5c:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: u7.i0.j(u7.h, y6.c):java.lang.Object");
    }

    public static final h k(h hVar, r7.s sVar) {
        if (sVar.get(r7.t.f12437b) != null) {
            androidx.constraintlayout.core.state.b.i(sVar, "Flow context cannot contain job in it. Had ");
            return null;
        }
        if (sVar.equals(w6.i.f13523a)) {
            return hVar;
        }
        if (hVar instanceof v7.i) {
            return v7.c.a((v7.i) hVar, sVar, 0, null, 6);
        }
        return new d(hVar, (w6.h) sVar, 0, (t7.a) null, 12);
    }
}
