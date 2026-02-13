package g0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j extends UnsupportedOperationException {

    /* renamed from: a, reason: collision with root package name */
    public final f0.d f8194a;

    public j(f0.d dVar) {
        this.f8194a = dVar;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return "Missing ".concat(String.valueOf(this.f8194a));
    }
}
