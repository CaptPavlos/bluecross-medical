package androidx.collection;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import g7.p;
import s6.w;
import w6.c;
import y6.e;
import y6.h;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@e(c = "androidx.collection.ScatterMap$MapWrapper$entries$1$iterator$1", f = "ScatterMap.kt", l = {TypedValues.TransitionType.TYPE_FROM}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ScatterMap$MapWrapper$entries$1$iterator$1 extends h implements p {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ScatterMap<K, V> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScatterMap$MapWrapper$entries$1$iterator$1(ScatterMap<K, V> scatterMap, c cVar) {
        super(2, cVar);
        this.this$0 = scatterMap;
    }

    @Override // y6.a
    public final c create(Object obj, c cVar) {
        ScatterMap$MapWrapper$entries$1$iterator$1 scatterMap$MapWrapper$entries$1$iterator$1 = new ScatterMap$MapWrapper$entries$1$iterator$1(this.this$0, cVar);
        scatterMap$MapWrapper$entries$1$iterator$1.L$0 = obj;
        return scatterMap$MapWrapper$entries$1$iterator$1;
    }

    @Override // g7.p
    public final Object invoke(n7.h hVar, c cVar) {
        return ((ScatterMap$MapWrapper$entries$1$iterator$1) create(hVar, cVar)).invokeSuspend(w.f12711a);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x004d -> B:22:0x009d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x004f -> B:14:0x0061). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x006a -> B:19:0x0094). Please report as a decompilation issue!!! */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            r19 = this;
            r0 = r19
            int r1 = r0.label
            r2 = 0
            r3 = 8
            r4 = 1
            if (r1 == 0) goto L2e
            if (r1 != r4) goto L27
            int r1 = r0.I$3
            int r5 = r0.I$2
            long r6 = r0.J$0
            int r8 = r0.I$1
            int r9 = r0.I$0
            java.lang.Object r10 = r0.L$2
            long[] r10 = (long[]) r10
            java.lang.Object r11 = r0.L$1
            androidx.collection.ScatterMap r11 = (androidx.collection.ScatterMap) r11
            java.lang.Object r12 = r0.L$0
            n7.h r12 = (n7.h) r12
            s6.a.e(r20)
            goto L94
        L27:
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r1)
            r1 = 0
            return r1
        L2e:
            s6.a.e(r20)
            java.lang.Object r1 = r0.L$0
            n7.h r1 = (n7.h) r1
            androidx.collection.ScatterMap<K, V> r5 = r0.this$0
            long[] r6 = r5.metadata
            int r7 = r6.length
            int r7 = r7 + (-2)
            if (r7 < 0) goto La2
            r8 = r2
        L3f:
            r9 = r6[r8]
            long r11 = ~r9
            r13 = 7
            long r11 = r11 << r13
            long r11 = r11 & r9
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r11 = r11 & r13
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 == 0) goto L9d
            int r11 = r8 - r7
            int r11 = ~r11
            int r11 = r11 >>> 31
            int r11 = 8 - r11
            r12 = r11
            r11 = r5
            r5 = r12
            r12 = r1
            r1 = r2
            r17 = r9
            r10 = r6
            r9 = r7
            r6 = r17
        L61:
            if (r1 >= r5) goto L97
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r6
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L94
            int r2 = r8 << 3
            int r2 = r2 + r1
            androidx.collection.MapEntry r3 = new androidx.collection.MapEntry
            java.lang.Object[] r13 = r11.keys
            r13 = r13[r2]
            java.lang.Object[] r14 = r11.values
            r2 = r14[r2]
            r3.<init>(r13, r2)
            r0.L$0 = r12
            r0.L$1 = r11
            r0.L$2 = r10
            r0.I$0 = r9
            r0.I$1 = r8
            r0.J$0 = r6
            r0.I$2 = r5
            r0.I$3 = r1
            r0.label = r4
            r12.a(r3, r0)
            x6.a r1 = x6.a.f13718a
            return r1
        L94:
            long r6 = r6 >> r3
            int r1 = r1 + r4
            goto L61
        L97:
            if (r5 != r3) goto La2
            r7 = r9
            r6 = r10
            r5 = r11
            r1 = r12
        L9d:
            if (r8 == r7) goto La2
            int r8 = r8 + 1
            goto L3f
        La2:
            s6.w r1 = s6.w.f12711a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ScatterMap$MapWrapper$entries$1$iterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
