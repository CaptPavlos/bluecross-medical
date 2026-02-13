package l4;

import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class x9 extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f11000a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f11001b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ y9 f11002c;

    /* renamed from: d, reason: collision with root package name */
    public int f11003d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x9(y9 y9Var, y6.c cVar) {
        super(cVar);
        this.f11002c = y9Var;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f11001b = obj;
        this.f11003d |= Integer.MIN_VALUE;
        return y9.b(this.f11002c, null, null, this);
    }
}
