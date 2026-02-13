package s6;

import java.io.Serializable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class x implements f, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public g7.a f12712a;

    /* renamed from: b, reason: collision with root package name */
    public Object f12713b;

    @Override // s6.f
    public final Object getValue() {
        if (this.f12713b == t.f12708a) {
            g7.a aVar = this.f12712a;
            aVar.getClass();
            this.f12713b = aVar.invoke();
            this.f12712a = null;
        }
        return this.f12713b;
    }

    @Override // s6.f
    public final boolean isInitialized() {
        return this.f12713b != t.f12708a;
    }

    public final String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
