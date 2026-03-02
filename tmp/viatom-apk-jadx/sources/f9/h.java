package f9;

import a3.x;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public x f8145a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f8146b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ x f8147c;

    /* renamed from: d, reason: collision with root package name */
    public int f8148d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(x xVar, y6.c cVar) {
        super(cVar);
        this.f8147c = xVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f8146b = obj;
        this.f8148d |= Integer.MIN_VALUE;
        return this.f8147c.h(this);
    }
}
