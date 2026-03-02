package androidx.collection;

import g7.p;
import s6.w;
import w6.c;
import y6.e;
import y6.h;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@e(c = "androidx.collection.MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1", f = "ScatterSet.kt", l = {1060}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1 extends h implements p {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ MutableScatterSet<E> this$0;
    final /* synthetic */ MutableScatterSet$MutableSetWrapper$iterator$1 this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1(MutableScatterSet mutableScatterSet, MutableScatterSet$MutableSetWrapper$iterator$1 mutableScatterSet$MutableSetWrapper$iterator$1, c cVar) {
        super(2, cVar);
        this.this$0 = mutableScatterSet;
        this.this$1 = mutableScatterSet$MutableSetWrapper$iterator$1;
    }

    @Override // y6.a
    public final c create(Object obj, c cVar) {
        MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1 mutableScatterSet$MutableSetWrapper$iterator$1$iterator$1 = new MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1(this.this$0, this.this$1, cVar);
        mutableScatterSet$MutableSetWrapper$iterator$1$iterator$1.L$0 = obj;
        return mutableScatterSet$MutableSetWrapper$iterator$1$iterator$1;
    }

    @Override // g7.p
    public final Object invoke(n7.h hVar, c cVar) {
        return ((MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1) create(hVar, cVar)).invokeSuspend(w.f12711a);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a6  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0053 -> B:22:0x00a4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0055 -> B:14:0x0069). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0072 -> B:19:0x0098). Please report as a decompilation issue!!! */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            r20 = this;
            r0 = r20
            int r1 = r0.label
            r2 = 0
            r3 = 8
            r4 = 1
            if (r1 == 0) goto L32
            if (r1 != r4) goto L2b
            int r1 = r0.I$3
            int r5 = r0.I$2
            long r6 = r0.J$0
            int r8 = r0.I$1
            int r9 = r0.I$0
            java.lang.Object r10 = r0.L$3
            long[] r10 = (long[]) r10
            java.lang.Object r11 = r0.L$2
            androidx.collection.MutableScatterSet r11 = (androidx.collection.MutableScatterSet) r11
            java.lang.Object r12 = r0.L$1
            androidx.collection.MutableScatterSet$MutableSetWrapper$iterator$1 r12 = (androidx.collection.MutableScatterSet$MutableSetWrapper$iterator$1) r12
            java.lang.Object r13 = r0.L$0
            n7.h r13 = (n7.h) r13
            s6.a.e(r21)
            goto L98
        L2b:
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r1)
            r1 = 0
            return r1
        L32:
            s6.a.e(r21)
            java.lang.Object r1 = r0.L$0
            n7.h r1 = (n7.h) r1
            androidx.collection.MutableScatterSet<E> r5 = r0.this$0
            androidx.collection.MutableScatterSet$MutableSetWrapper$iterator$1 r6 = r0.this$1
            long[] r7 = r5.metadata
            int r8 = r7.length
            int r8 = r8 + (-2)
            if (r8 < 0) goto La9
            r9 = r2
        L45:
            r10 = r7[r9]
            long r12 = ~r10
            r14 = 7
            long r12 = r12 << r14
            long r12 = r12 & r10
            r14 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r12 = r12 & r14
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 == 0) goto La4
            int r12 = r9 - r8
            int r12 = ~r12
            int r12 = r12 >>> 31
            int r12 = 8 - r12
            r13 = r9
            r9 = r8
            r8 = r13
            r13 = r1
            r1 = r2
            r18 = r10
            r11 = r5
            r10 = r7
            r5 = r12
            r12 = r6
            r6 = r18
        L69:
            if (r1 >= r5) goto L9b
            r14 = 255(0xff, double:1.26E-321)
            long r14 = r14 & r6
            r16 = 128(0x80, double:6.3E-322)
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 >= 0) goto L98
            int r2 = r8 << 3
            int r2 = r2 + r1
            r12.setCurrent(r2)
            java.lang.Object[] r3 = r11.elements
            r2 = r3[r2]
            r0.L$0 = r13
            r0.L$1 = r12
            r0.L$2 = r11
            r0.L$3 = r10
            r0.I$0 = r9
            r0.I$1 = r8
            r0.J$0 = r6
            r0.I$2 = r5
            r0.I$3 = r1
            r0.label = r4
            r13.a(r2, r0)
            x6.a r1 = x6.a.f13718a
            return r1
        L98:
            long r6 = r6 >> r3
            int r1 = r1 + r4
            goto L69
        L9b:
            if (r5 != r3) goto La9
            r1 = r9
            r9 = r8
            r8 = r1
            r7 = r10
            r5 = r11
            r6 = r12
            r1 = r13
        La4:
            if (r9 == r8) goto La9
            int r9 = r9 + 1
            goto L45
        La9:
            s6.w r1 = s6.w.f12711a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
