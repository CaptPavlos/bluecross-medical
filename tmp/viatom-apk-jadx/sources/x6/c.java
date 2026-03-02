package x6;

import g7.p;
import kotlin.jvm.internal.a0;
import w6.h;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public int f13723a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f13724b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w6.c f13725c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(w6.c cVar, h hVar, p pVar, w6.c cVar2) {
        super(cVar, hVar);
        this.f13724b = pVar;
        this.f13725c = cVar2;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.f13723a;
        if (i10 != 0) {
            if (i10 != 1) {
                androidx.window.layout.c.g("This coroutine had already completed");
                return null;
            }
            this.f13723a = 2;
            s6.a.e(obj);
            return obj;
        }
        this.f13723a = 1;
        s6.a.e(obj);
        p pVar = this.f13724b;
        pVar.getClass();
        a0.b(2, pVar);
        return pVar.invoke(this.f13725c, this);
    }
}
