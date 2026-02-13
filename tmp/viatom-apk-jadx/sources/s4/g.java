package s4;

import androidx.documentfile.provider.DocumentFile;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public Object f12566a;

    /* renamed from: b, reason: collision with root package name */
    public DocumentFile f12567b;

    /* renamed from: c, reason: collision with root package name */
    public DocumentFile f12568c;

    /* renamed from: d, reason: collision with root package name */
    public DocumentFile[] f12569d;
    public int e;
    public int f;
    public /* synthetic */ Object g;
    public final /* synthetic */ n h;

    /* renamed from: i, reason: collision with root package name */
    public int f12570i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(n nVar, y6.c cVar) {
        super(cVar);
        this.h = nVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.g = obj;
        this.f12570i |= Integer.MIN_VALUE;
        return this.h.a(null, null, this);
    }
}
