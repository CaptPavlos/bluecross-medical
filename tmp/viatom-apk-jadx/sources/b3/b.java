package b3;

import a8.i;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public Map f827a;

    /* renamed from: b, reason: collision with root package name */
    public Iterator f828b;

    /* renamed from: c, reason: collision with root package name */
    public d f829c;

    /* renamed from: d, reason: collision with root package name */
    public i f830d;
    public Map e;
    public Object f;
    public /* synthetic */ Object g;
    public final /* synthetic */ c h;

    /* renamed from: i, reason: collision with root package name */
    public int f831i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar, y6.c cVar2) {
        super(cVar2);
        this.h = cVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.g = obj;
        this.f831i |= Integer.MIN_VALUE;
        return this.h.b(this);
    }
}
