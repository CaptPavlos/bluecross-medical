package androidx.collection;

import g7.p;
import s6.w;
import w6.c;
import y6.e;
import y6.h;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@e(c = "androidx.collection.MutableScatterMap$MutableMapWrapper$keys$1$iterator$1$iterator$1", f = "ScatterMap.kt", l = {1431}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class MutableScatterMap$MutableMapWrapper$keys$1$iterator$1$iterator$1 extends h implements p {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MutableScatterMap<K, V> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutableScatterMap$MutableMapWrapper$keys$1$iterator$1$iterator$1(MutableScatterMap<K, V> mutableScatterMap, c cVar) {
        super(2, cVar);
        this.this$0 = mutableScatterMap;
    }

    @Override // y6.a
    public final c create(Object obj, c cVar) {
        MutableScatterMap$MutableMapWrapper$keys$1$iterator$1$iterator$1 mutableScatterMap$MutableMapWrapper$keys$1$iterator$1$iterator$1 = new MutableScatterMap$MutableMapWrapper$keys$1$iterator$1$iterator$1(this.this$0, cVar);
        mutableScatterMap$MutableMapWrapper$keys$1$iterator$1$iterator$1.L$0 = obj;
        return mutableScatterMap$MutableMapWrapper$keys$1$iterator$1$iterator$1;
    }

    @Override // g7.p
    public final Object invoke(n7.h hVar, c cVar) {
        return ((MutableScatterMap$MutableMapWrapper$keys$1$iterator$1$iterator$1) create(hVar, cVar)).invokeSuspend(w.f12711a);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0090  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0048 -> B:22:0x008e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x004a -> B:14:0x005c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0065 -> B:19:0x0085). Please report as a decompilation issue!!! */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            r18 = this;
            r0 = r18
            int r1 = r0.label
            r2 = 0
            r3 = 8
            r4 = 1
            if (r1 == 0) goto L29
            if (r1 != r4) goto L22
            int r1 = r0.I$3
            int r5 = r0.I$2
            long r6 = r0.J$0
            int r8 = r0.I$1
            int r9 = r0.I$0
            java.lang.Object r10 = r0.L$1
            long[] r10 = (long[]) r10
            java.lang.Object r11 = r0.L$0
            n7.h r11 = (n7.h) r11
            s6.a.e(r19)
            goto L85
        L22:
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r1)
            r1 = 0
            return r1
        L29:
            s6.a.e(r19)
            java.lang.Object r1 = r0.L$0
            n7.h r1 = (n7.h) r1
            androidx.collection.MutableScatterMap<K, V> r5 = r0.this$0
            long[] r5 = r5.metadata
            int r6 = r5.length
            int r6 = r6 + (-2)
            if (r6 < 0) goto L93
            r7 = r2
        L3a:
            r8 = r5[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L8e
            int r10 = r7 - r6
            int r10 = ~r10
            int r10 = r10 >>> 31
            int r10 = 8 - r10
            r11 = r10
            r10 = r5
            r5 = r11
            r11 = r1
            r1 = r2
            r16 = r8
            r9 = r6
            r8 = r7
            r6 = r16
        L5c:
            if (r1 >= r5) goto L88
            r12 = 255(0xff, double:1.26E-321)
            long r12 = r12 & r6
            r14 = 128(0x80, double:6.3E-322)
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 >= 0) goto L85
            int r2 = r8 << 3
            int r2 = r2 + r1
            java.lang.Integer r3 = new java.lang.Integer
            r3.<init>(r2)
            r0.L$0 = r11
            r0.L$1 = r10
            r0.I$0 = r9
            r0.I$1 = r8
            r0.J$0 = r6
            r0.I$2 = r5
            r0.I$3 = r1
            r0.label = r4
            r11.a(r3, r0)
            x6.a r1 = x6.a.f13718a
            return r1
        L85:
            long r6 = r6 >> r3
            int r1 = r1 + r4
            goto L5c
        L88:
            if (r5 != r3) goto L93
            r7 = r8
            r6 = r9
            r5 = r10
            r1 = r11
        L8e:
            if (r7 == r6) goto L93
            int r7 = r7 + 1
            goto L3a
        L93:
            s6.w r1 = s6.w.f12711a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableScatterMap$MutableMapWrapper$keys$1$iterator$1$iterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
