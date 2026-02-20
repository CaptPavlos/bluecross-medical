package v8;

import java.io.IOException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h extends q8.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f13227b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f13228c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ q f13229d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(q qVar, Object[] objArr, int i10, int i11) {
        super("OkHttp %s stream %d", objArr);
        this.f13229d = qVar;
        this.f13227b = i10;
        this.f13228c = i11;
    }

    @Override // q8.a
    public final void a() {
        q qVar = this.f13229d;
        try {
            qVar.f13261r.i(this.f13227b, this.f13228c);
        } catch (IOException unused) {
            qVar.b();
        }
    }
}
