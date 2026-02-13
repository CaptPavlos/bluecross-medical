package c5;

import android.content.Context;
import c1.w4;
import h5.e1;
import java.io.File;
import java.util.ArrayList;
import l4.bc;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1707a = 2;

    /* renamed from: b, reason: collision with root package name */
    public int f1708b;

    /* renamed from: c, reason: collision with root package name */
    public Object f1709c;

    /* renamed from: d, reason: collision with root package name */
    public Object f1710d;
    public Object e;
    public Object f;
    public /* synthetic */ Object g;
    public final /* synthetic */ Object h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f1711i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(bc bcVar, Context context, String str, int i10, kotlin.jvm.internal.x xVar, kotlin.jvm.internal.v vVar, e1 e1Var, String str2, w6.c cVar) {
        super(2, cVar);
        this.f1709c = bcVar;
        this.f1710d = context;
        this.e = str;
        this.f1708b = i10;
        this.f = xVar;
        this.g = vVar;
        this.h = e1Var;
        this.f1711i = str2;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f1707a) {
            case 0:
                k kVar = new k((w2.r) this.h, (ArrayList) this.e, (w4) this.f1711i, cVar);
                kVar.g = obj;
                return kVar;
            case 1:
                return new k((bc) this.f1709c, (Context) this.f1710d, (String) this.e, this.f1708b, (kotlin.jvm.internal.x) this.f, (kotlin.jvm.internal.v) this.g, (e1) this.h, (String) this.f1711i, cVar);
            default:
                return new k((File) this.g, (ArrayList) this.f1710d, (x4.y) this.h, (b9.h) this.f1711i, cVar);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) throws Throwable {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f1707a) {
            case 0:
                return ((k) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
            case 1:
                k kVar = (k) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                kVar.invokeSuspend(wVar2);
                return wVar2;
            default:
                return ((k) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02f1  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0117 -> B:13:0x004d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x02b6 -> B:68:0x0212). Please report as a decompilation issue!!! */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 766
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c5.k.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(File file, ArrayList arrayList, x4.y yVar, b9.h hVar, w6.c cVar) {
        super(2, cVar);
        this.g = file;
        this.f1710d = arrayList;
        this.h = yVar;
        this.f1711i = hVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(w2.r rVar, ArrayList arrayList, w4 w4Var, w6.c cVar) {
        super(2, cVar);
        this.h = rVar;
        this.e = arrayList;
        this.f1711i = w4Var;
    }
}
