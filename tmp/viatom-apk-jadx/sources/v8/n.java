package v8;

import java.io.IOException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n extends q8.a {

    /* renamed from: b, reason: collision with root package name */
    public final boolean f13240b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13241c;

    /* renamed from: d, reason: collision with root package name */
    public final int f13242d;
    public final /* synthetic */ q e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(q qVar, boolean z9, int i10, int i11) {
        super("OkHttp %s ping %08x%08x", qVar.f13251d, Integer.valueOf(i10), Integer.valueOf(i11));
        this.e = qVar;
        this.f13240b = z9;
        this.f13241c = i10;
        this.f13242d = i11;
    }

    @Override // q8.a
    public final void a() {
        boolean z9;
        q qVar = this.e;
        boolean z10 = this.f13240b;
        int i10 = this.f13241c;
        int i11 = this.f13242d;
        if (!z10) {
            synchronized (qVar) {
                z9 = qVar.f13254k;
                qVar.f13254k = true;
            }
            if (z9) {
                qVar.b();
                return;
            }
        }
        try {
            qVar.f13261r.h(z10, i10, i11);
        } catch (IOException unused) {
            qVar.b();
        }
    }
}
