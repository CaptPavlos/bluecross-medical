package v8;

import java.io.IOException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k extends q8.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f13236b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ z8.i f13237c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f13238d;
    public final /* synthetic */ q e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(q qVar, Object[] objArr, int i10, z8.i iVar, int i11, boolean z9) {
        super("OkHttp %s Push Data[%s]", objArr);
        this.e = qVar;
        this.f13236b = i10;
        this.f13237c = iVar;
        this.f13238d = i11;
    }

    @Override // q8.a
    public final void a() {
        try {
            z zVar = this.e.f13253j;
            z8.i iVar = this.f13237c;
            int i10 = this.f13238d;
            zVar.getClass();
            iVar.skip(i10);
            this.e.f13261r.i(this.f13236b, 6);
            synchronized (this.e) {
                this.e.t.remove(Integer.valueOf(this.f13236b));
            }
        } catch (IOException unused) {
        }
    }
}
