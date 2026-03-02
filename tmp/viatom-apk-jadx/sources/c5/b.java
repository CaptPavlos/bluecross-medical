package c5;

import android.content.Context;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1655a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f1656b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(int i10, Context context, w6.c cVar) {
        super(2, cVar);
        this.f1655a = i10;
        this.f1656b = context;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f1655a) {
            case 0:
                return new b(0, this.f1656b, cVar);
            default:
                return new b(1, this.f1656b, cVar);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f1655a) {
            case 0:
                b bVar = (b) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                bVar.invokeSuspend(wVar2);
                return wVar2;
            default:
                b bVar2 = (b) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                bVar2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0186 A[Catch: all -> 0x01df, TryCatch #4 {all -> 0x01df, blocks: (B:67:0x0170, B:68:0x0180, B:70:0x0186, B:72:0x019b, B:74:0x019f, B:77:0x01a6, B:80:0x01bd, B:82:0x01da, B:86:0x01e1, B:89:0x01ec, B:91:0x01f0, B:93:0x01fa), top: B:107:0x0170 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01fa A[Catch: all -> 0x01df, TRY_LEAVE, TryCatch #4 {all -> 0x01df, blocks: (B:67:0x0170, B:68:0x0180, B:70:0x0186, B:72:0x019b, B:74:0x019f, B:77:0x01a6, B:80:0x01bd, B:82:0x01da, B:86:0x01e1, B:89:0x01ec, B:91:0x01f0, B:93:0x01fa), top: B:107:0x0170 }] */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 568
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c5.b.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
