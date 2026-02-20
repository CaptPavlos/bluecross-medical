package u7;

import androidx.datastore.core.DataStoreImpl$data$1$invokeSuspend$$inlined$map$1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m implements h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DataStoreImpl$data$1$invokeSuspend$$inlined$map$1 f13025a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g7.q f13026b;

    public m(DataStoreImpl$data$1$invokeSuspend$$inlined$map$1 dataStoreImpl$data$1$invokeSuspend$$inlined$map$1, g7.q qVar) {
        this.f13025a = dataStoreImpl$data$1$invokeSuspend$$inlined$map$1;
        this.f13026b = qVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // u7.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(u7.i r9, w6.c r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof u7.l
            if (r0 == 0) goto L13
            r0 = r10
            u7.l r0 = (u7.l) r0
            int r1 = r0.f13018b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f13018b = r1
            goto L18
        L13:
            u7.l r0 = new u7.l
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.f13017a
            int r1 = r0.f13018b
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            x6.a r6 = x6.a.f13718a
            if (r1 == 0) goto L4f
            if (r1 == r4) goto L43
            if (r1 == r3) goto L3b
            if (r1 != r2) goto L34
            java.lang.Object r9 = r0.f13020d
            v7.l r9 = (v7.l) r9
            s6.a.e(r10)     // Catch: java.lang.Throwable -> L32
            goto L7b
        L32:
            r10 = move-exception
            goto L85
        L34:
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r9)
            r9 = 0
            return r9
        L3b:
            java.lang.Object r9 = r0.f13020d
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            s6.a.e(r10)
            goto L9f
        L43:
            u7.i r9 = r0.e
            java.lang.Object r1 = r0.f13020d
            u7.m r1 = (u7.m) r1
            s6.a.e(r10)     // Catch: java.lang.Throwable -> L4d
            goto L62
        L4d:
            r9 = move-exception
            goto L8b
        L4f:
            s6.a.e(r10)
            androidx.datastore.core.DataStoreImpl$data$1$invokeSuspend$$inlined$map$1 r10 = r8.f13025a     // Catch: java.lang.Throwable -> L89
            r0.f13020d = r8     // Catch: java.lang.Throwable -> L89
            r0.e = r9     // Catch: java.lang.Throwable -> L89
            r0.f13018b = r4     // Catch: java.lang.Throwable -> L89
            java.lang.Object r10 = r10.collect(r9, r0)     // Catch: java.lang.Throwable -> L89
            if (r10 != r6) goto L61
            goto L9e
        L61:
            r1 = r8
        L62:
            v7.l r10 = new v7.l
            w6.h r3 = r0.getContext()
            r10.<init>(r9, r3)
            g7.q r9 = r1.f13026b     // Catch: java.lang.Throwable -> L81
            r0.f13020d = r10     // Catch: java.lang.Throwable -> L81
            r0.e = r5     // Catch: java.lang.Throwable -> L81
            r0.f13018b = r2     // Catch: java.lang.Throwable -> L81
            java.lang.Object r9 = r9.invoke(r10, r5, r0)     // Catch: java.lang.Throwable -> L81
            if (r9 != r6) goto L7a
            goto L9e
        L7a:
            r9 = r10
        L7b:
            r9.releaseIntercepted()
            s6.w r9 = s6.w.f12711a
            return r9
        L81:
            r9 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
        L85:
            r9.releaseIntercepted()
            throw r10
        L89:
            r9 = move-exception
            r1 = r8
        L8b:
            u7.o0 r10 = new u7.o0
            r10.<init>(r9)
            g7.q r1 = r1.f13026b
            r0.f13020d = r9
            r0.e = r5
            r0.f13018b = r3
            java.lang.Object r10 = u7.i0.b(r10, r1, r9, r0)
            if (r10 != r6) goto L9f
        L9e:
            return r6
        L9f:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: u7.m.collect(u7.i, w6.c):java.lang.Object");
    }
}
