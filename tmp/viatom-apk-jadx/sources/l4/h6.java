package l4;

import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h6 extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f10458a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f10459b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i6 f10460c;

    /* renamed from: d, reason: collision with root package name */
    public int f10461d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h6(i6 i6Var, y6.c cVar) {
        super(cVar);
        this.f10460c = i6Var;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f10459b = obj;
        this.f10461d |= Integer.MIN_VALUE;
        return i6.a(this.f10460c, null, this);
    }
}
