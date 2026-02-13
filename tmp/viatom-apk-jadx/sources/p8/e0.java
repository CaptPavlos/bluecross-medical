package p8;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    public final a f12081a;

    /* renamed from: b, reason: collision with root package name */
    public final Proxy f12082b;

    /* renamed from: c, reason: collision with root package name */
    public final InetSocketAddress f12083c;

    public e0(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (aVar == null) {
            androidx.window.layout.c.k("address == null");
            throw null;
        }
        if (inetSocketAddress == null) {
            androidx.window.layout.c.k("inetSocketAddress == null");
            throw null;
        }
        this.f12081a = aVar;
        this.f12082b = proxy;
        this.f12083c = inetSocketAddress;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        return e0Var.f12081a.equals(this.f12081a) && e0Var.f12082b.equals(this.f12082b) && e0Var.f12083c.equals(this.f12083c);
    }

    public final int hashCode() {
        return this.f12083c.hashCode() + ((this.f12082b.hashCode() + ((this.f12081a.hashCode() + 527) * 31)) * 31);
    }

    public final String toString() {
        return "Route{" + this.f12083c + "}";
    }
}
