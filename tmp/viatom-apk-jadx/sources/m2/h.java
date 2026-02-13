package m2;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h implements j2.g {

    /* renamed from: a, reason: collision with root package name */
    public boolean f11172a = false;

    /* renamed from: b, reason: collision with root package name */
    public boolean f11173b = false;

    /* renamed from: c, reason: collision with root package name */
    public j2.c f11174c;

    /* renamed from: d, reason: collision with root package name */
    public final f f11175d;

    public h(f fVar) {
        this.f11175d = fVar;
    }

    @Override // j2.g
    public final j2.g b(String str) {
        if (this.f11172a) {
            throw new j2.b("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f11172a = true;
        this.f11175d.i(this.f11174c, str, this.f11173b);
        return this;
    }

    @Override // j2.g
    public final j2.g c(boolean z9) {
        if (this.f11172a) {
            throw new j2.b("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f11172a = true;
        this.f11175d.c(this.f11174c, z9 ? 1 : 0, this.f11173b);
        return this;
    }
}
