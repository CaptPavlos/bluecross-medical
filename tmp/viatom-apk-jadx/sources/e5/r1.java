package e5;

import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class r1 extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f7845a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f7846b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ t1 f7847c;

    /* renamed from: d, reason: collision with root package name */
    public int f7848d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r1(t1 t1Var, y6.c cVar) {
        super(cVar);
        this.f7847c = t1Var;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f7846b = obj;
        this.f7848d |= Integer.MIN_VALUE;
        return t1.a(this.f7847c, this);
    }
}
