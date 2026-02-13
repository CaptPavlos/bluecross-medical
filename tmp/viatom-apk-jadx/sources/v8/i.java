package v8;

import java.io.IOException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i extends q8.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f13230b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f13231c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ q f13232d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(q qVar, Object[] objArr, int i10, long j10) {
        super("OkHttp Window Update %s stream %d", objArr);
        this.f13232d = qVar;
        this.f13230b = i10;
        this.f13231c = j10;
    }

    @Override // q8.a
    public final void a() {
        q qVar = this.f13232d;
        try {
            qVar.f13261r.l(this.f13230b, this.f13231c);
        } catch (IOException unused) {
            qVar.b();
        }
    }
}
