package r7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m0 implements x0 {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f12413a;

    public m0(boolean z9) {
        this.f12413a = z9;
    }

    @Override // r7.x0
    public final k1 b() {
        return null;
    }

    @Override // r7.x0
    public final boolean isActive() {
        return this.f12413a;
    }

    public final String toString() {
        return a3.a.m(new StringBuilder("Empty{"), this.f12413a ? "Active" : "New", '}');
    }
}
