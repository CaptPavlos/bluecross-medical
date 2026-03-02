package i8;

import h0.a0;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public s6.b f9085a;

    /* renamed from: b, reason: collision with root package name */
    public a0 f9086b;

    /* renamed from: c, reason: collision with root package name */
    public LinkedHashMap f9087c;

    /* renamed from: d, reason: collision with root package name */
    public String f9088d;
    public /* synthetic */ Object e;
    public final /* synthetic */ a0 f;
    public int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(a0 a0Var, y6.a aVar) {
        super(aVar);
        this.f = a0Var;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.g |= Integer.MIN_VALUE;
        return a0.a(this.f, null, this);
    }
}
