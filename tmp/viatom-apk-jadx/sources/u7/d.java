package u7;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class d implements v7.i {

    /* renamed from: a, reason: collision with root package name */
    public final w6.h f12982a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12983b;

    /* renamed from: c, reason: collision with root package name */
    public final t7.a f12984c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f12985d;
    public final Object e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(h hVar, w6.h hVar2, int i10, t7.a aVar, int i11) {
        this((Object) hVar, (i11 & 2) != 0 ? w6.i.f13523a : hVar2, (i11 & 4) != 0 ? -3 : i10, (i11 & 8) != 0 ? t7.a.f12813a : aVar, 1);
        this.f12985d = 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0015  */
    @Override // v7.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final u7.h a(w6.h r5, int r6, t7.a r7) {
        /*
            r4 = this;
            w6.h r0 = r4.f12982a
            w6.h r5 = r5.plus(r0)
            t7.a r1 = t7.a.f12813a
            t7.a r2 = r4.f12984c
            int r3 = r4.f12983b
            if (r7 == r1) goto Lf
            goto L26
        Lf:
            r7 = -3
            if (r3 != r7) goto L13
            goto L25
        L13:
            if (r6 != r7) goto L17
        L15:
            r6 = r3
            goto L25
        L17:
            r7 = -2
            if (r3 != r7) goto L1b
            goto L25
        L1b:
            if (r6 != r7) goto L1e
            goto L15
        L1e:
            int r6 = r6 + r3
            if (r6 < 0) goto L22
            goto L25
        L22:
            r6 = 2147483647(0x7fffffff, float:NaN)
        L25:
            r7 = r2
        L26:
            boolean r0 = kotlin.jvm.internal.l.a(r5, r0)
            if (r0 == 0) goto L31
            if (r6 != r3) goto L31
            if (r7 != r2) goto L31
            return r4
        L31:
            u7.d r5 = r4.d(r5, r6, r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: u7.d.a(w6.h, int, t7.a):u7.h");
    }

    public final Object b(i iVar, w6.c cVar) {
        Object objG = r7.y.g(new b9.p(iVar, this, (w6.c) null, 26), cVar);
        return objG == x6.a.f13718a ? objG : s6.w.f12711a;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [g7.p, y6.i] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Iterable, java.lang.Object] */
    public Object c(t7.s sVar, w6.c cVar) {
        switch (this.f12985d) {
            case 0:
                Object objInvoke = ((y6.i) this.e).invoke(sVar, cVar);
                return objInvoke == x6.a.f13718a ? objInvoke : s6.w.f12711a;
            case 1:
                Object objCollect = ((h) this.e).collect(new v7.o(sVar), cVar);
                s6.w wVar = s6.w.f12711a;
                x6.a aVar = x6.a.f13718a;
                if (objCollect != aVar) {
                    objCollect = wVar;
                }
                return objCollect == aVar ? objCollect : wVar;
            default:
                v7.o oVar = new v7.o(sVar);
                Iterator it = this.e.iterator();
                while (it.hasNext()) {
                    r7.y.q(sVar, null, null, new p4.i0((h) it.next(), oVar, (w6.c) null, 14), 3);
                }
                return s6.w.f12711a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0083  */
    @Override // u7.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object collect(u7.i r7, w6.c r8) {
        /*
            r6 = this;
            int r0 = r6.f12985d
            switch(r0) {
                case 1: goto La;
                default: goto L5;
            }
        L5:
            java.lang.Object r7 = r6.b(r7, r8)
            return r7
        La:
            int r0 = r6.f12983b
            r1 = -3
            x6.a r2 = x6.a.f13718a
            s6.w r3 = s6.w.f12711a
            if (r0 != r1) goto L83
            w6.h r0 = r8.getContext()
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            e5.u0 r4 = new e5.u0
            r5 = 2
            r4.<init>(r5)
            w6.h r5 = r6.f12982a
            java.lang.Object r1 = r5.fold(r1, r4)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L32
            w6.h r1 = r0.plus(r5)
            goto L37
        L32:
            r1 = 0
            w6.h r1 = r7.y.j(r0, r5, r1)
        L37:
            boolean r4 = kotlin.jvm.internal.l.a(r1, r0)
            if (r4 == 0) goto L4d
            java.lang.Object r0 = r6.e
            u7.h r0 = (u7.h) r0
            java.lang.Object r7 = r0.collect(r7, r8)
            if (r7 != r2) goto L48
            goto L49
        L48:
            r7 = r3
        L49:
            if (r7 != r2) goto L8a
        L4b:
            r3 = r7
            goto L8a
        L4d:
            w6.d r4 = w6.d.f13522a
            w6.f r5 = r1.get(r4)
            w6.f r0 = r0.get(r4)
            boolean r0 = kotlin.jvm.internal.l.a(r5, r0)
            if (r0 == 0) goto L83
            w6.h r0 = r8.getContext()
            boolean r4 = r7 instanceof v7.o
            if (r4 != 0) goto L70
            boolean r4 = r7 instanceof v7.k
            if (r4 == 0) goto L6a
            goto L70
        L6a:
            l4.xb r4 = new l4.xb
            r4.<init>(r7, r0)
            r7 = r4
        L70:
            p4.i0 r0 = new p4.i0
            r4 = 0
            r5 = 13
            r0.<init>(r6, r4, r5)
            java.lang.Object r4 = w7.a.k(r1)
            java.lang.Object r7 = v7.c.b(r1, r7, r4, r0, r8)
            if (r7 != r2) goto L8a
            goto L4b
        L83:
            java.lang.Object r7 = r6.b(r7, r8)
            if (r7 != r2) goto L8a
            goto L4b
        L8a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: u7.d.collect(u7.i, w6.c):java.lang.Object");
    }

    /* JADX WARN: Type inference failed for: r10v2, types: [g7.p, y6.i] */
    public d d(w6.h hVar, int i10, t7.a aVar) {
        switch (this.f12985d) {
            case 0:
                return new d((y6.i) this.e, hVar, i10, aVar);
            case 1:
                return new d(this.e, hVar, i10, aVar, 1);
            default:
                return new d(this.e, hVar, i10, aVar, 2);
        }
    }

    public final String e() {
        ArrayList arrayList = new ArrayList(4);
        w6.i iVar = w6.i.f13523a;
        w6.h hVar = this.f12982a;
        if (hVar != iVar) {
            arrayList.add("context=" + hVar);
        }
        int i10 = this.f12983b;
        if (i10 != -3) {
            arrayList.add("capacity=" + i10);
        }
        t7.a aVar = t7.a.f12813a;
        t7.a aVar2 = this.f12984c;
        if (aVar2 != aVar) {
            arrayList.add("onBufferOverflow=" + aVar2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('[');
        return a3.a.m(sb, t6.l.h0(arrayList, ", ", null, null, null, 62), ']');
    }

    public String toString() {
        switch (this.f12985d) {
            case 0:
                return "block[" + ((y6.i) this.e) + "] -> " + e();
            case 1:
                return ((h) this.e) + " -> " + e();
            default:
                return e();
        }
    }

    public d(w6.h hVar, int i10, t7.a aVar) {
        this.f12982a = hVar;
        this.f12983b = i10;
        this.f12984c = aVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(Object obj, w6.h hVar, int i10, t7.a aVar, int i11) {
        this(hVar, i10, aVar);
        this.f12985d = i11;
        this.e = obj;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public d(g7.p pVar, w6.h hVar, int i10, t7.a aVar) {
        this(hVar, i10, aVar);
        this.f12985d = 0;
        this.e = (y6.i) pVar;
    }
}
