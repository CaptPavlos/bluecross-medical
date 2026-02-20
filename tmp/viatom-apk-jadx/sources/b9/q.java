package b9;

import kotlin.jvm.internal.x;
import r7.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public int f928a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x f929b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ x f930c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f931d;
    public final /* synthetic */ boolean e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(x xVar, x xVar2, String str, boolean z9, w6.c cVar) {
        super(2, cVar);
        this.f929b = xVar;
        this.f930c = xVar2;
        this.f931d = str;
        this.e = z9;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        return new q(this.f929b, this.f930c, this.f931d, this.e, cVar);
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((q) create((w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.f928a;
        if (i10 == 0) {
            s6.a.e(obj);
            h hVar = s.f937b;
            d dVar = (d) this.f929b.f10138a;
            c cVar = (c) this.f930c.f10138a;
            boolean z9 = !this.e;
            this.f928a = 1;
            Object objD = hVar.d(dVar, cVar, this.f931d, z9, this);
            x6.a aVar = x6.a.f13718a;
            if (objD == aVar) {
                return aVar;
            }
        } else {
            if (i10 != 1) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
        }
        return s6.w.f12711a;
    }
}
