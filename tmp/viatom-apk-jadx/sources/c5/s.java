package c5;

import c1.w4;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1749a = 1;

    /* renamed from: b, reason: collision with root package name */
    public v5.g f1750b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f1751c;

    /* renamed from: d, reason: collision with root package name */
    public Iterator f1752d;
    public ArrayList e;
    public int f;
    public /* synthetic */ Object g;
    public final /* synthetic */ t h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ ArrayList f1753i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ w4 f1754j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(t tVar, ArrayList arrayList, w4 w4Var, w6.c cVar) {
        super(2, cVar);
        this.h = tVar;
        this.f1753i = arrayList;
        this.f1754j = w4Var;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f1749a) {
            case 0:
                s sVar = new s(this.f1753i, this.h, this.f1754j, cVar);
                sVar.g = obj;
                return sVar;
            default:
                s sVar2 = new s(this.h, this.f1753i, this.f1754j, cVar);
                sVar2.g = obj;
                return sVar2;
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f1749a) {
        }
        return ((s) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01a9  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00e0 -> B:35:0x00e3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x019f -> B:59:0x01a2). Please report as a decompilation issue!!! */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 464
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c5.s.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(ArrayList arrayList, t tVar, w4 w4Var, w6.c cVar) {
        super(2, cVar);
        this.f1753i = arrayList;
        this.h = tVar;
        this.f1754j = w4Var;
    }
}
