package v7;

import androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1;
import r7.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public t7.i f13185a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f13186b;

    /* renamed from: c, reason: collision with root package name */
    public int f13187c;

    /* renamed from: d, reason: collision with root package name */
    public int f13188d;
    public int e;
    public /* synthetic */ Object f;
    public final /* synthetic */ u7.h[] g;
    public final /* synthetic */ WorkConstraintsTracker$track$$inlined$combine$1.AnonymousClass2 h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ WorkConstraintsTracker$track$$inlined$combine$1.AnonymousClass3 f13189i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ u7.i f13190j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(u7.h[] hVarArr, WorkConstraintsTracker$track$$inlined$combine$1.AnonymousClass2 anonymousClass2, WorkConstraintsTracker$track$$inlined$combine$1.AnonymousClass3 anonymousClass3, u7.i iVar, w6.c cVar) {
        super(2, cVar);
        this.g = hVarArr;
        this.h = anonymousClass2;
        this.f13189i = anonymousClass3;
        this.f13190j = iVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        g gVar = new g(this.g, this.h, this.f13189i, this.f13190j, cVar);
        gVar.f = obj;
        return gVar;
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((g) create((w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0099, code lost:
    
        r19 = r11;
        r11 = r9;
        r9 = r19;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c0 A[LOOP:0: B:32:0x00c0->B:58:?, LOOP_START, PHI: r8 r12
      0x00c0: PHI (r8v3 int) = (r8v2 int), (r8v4 int) binds: [B:29:0x00bb, B:58:?] A[DONT_GENERATE, DONT_INLINE]
      0x00c0: PHI (r12v4 t6.w) = (r12v3 t6.w), (r12v14 t6.w) binds: [B:29:0x00bb, B:58:?] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0130  */
    /* JADX WARN: Type inference failed for: r10v10, types: [t7.i] */
    /* JADX WARN: Type inference failed for: r10v6, types: [t7.i] */
    /* JADX WARN: Type inference failed for: r10v8, types: [t7.i] */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x0127 -> B:53:0x012c). Please report as a decompilation issue!!! */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v7.g.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
