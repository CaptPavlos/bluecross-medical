package c5;

import c1.w4;
import com.uptodown.core.activities.FileExplorerActivity;
import java.util.concurrent.atomic.AtomicInteger;
import l4.n5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h0 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1691a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f1692b;

    /* renamed from: c, reason: collision with root package name */
    public int f1693c;

    /* renamed from: d, reason: collision with root package name */
    public Object f1694d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(w4 w4Var, String str, int i10, n5 n5Var, w6.c cVar) {
        super(2, cVar);
        this.f1694d = w4Var;
        this.e = str;
        this.f1693c = i10;
        this.f = n5Var;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f1691a) {
            case 0:
                return new h0((w4) this.f1694d, (String) this.e, this.f1693c, (n5) this.f, cVar);
            case 1:
                return new h0((FileExplorerActivity) this.e, (kotlin.jvm.internal.v) this.f, cVar);
            default:
                return new h0((u7.h[]) this.f1694d, this.f1693c, (AtomicInteger) this.e, (t7.e) this.f, cVar);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f1691a) {
        }
        return ((h0) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00a8 -> B:45:0x00c1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00bd -> B:45:0x00c1). Please report as a decompilation issue!!! */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c5.h0.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(FileExplorerActivity fileExplorerActivity, kotlin.jvm.internal.v vVar, w6.c cVar) {
        super(2, cVar);
        this.e = fileExplorerActivity;
        this.f = vVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(u7.h[] hVarArr, int i10, AtomicInteger atomicInteger, t7.e eVar, w6.c cVar) {
        super(2, cVar);
        this.f1694d = hVarArr;
        this.f1693c = i10;
        this.e = atomicInteger;
        this.f = eVar;
    }
}
