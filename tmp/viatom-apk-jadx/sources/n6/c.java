package n6;

import java.util.List;
import kotlin.jvm.internal.l;
import t6.t;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f11565a;

    /* renamed from: b, reason: collision with root package name */
    public final a f11566b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f11567c;

    public /* synthetic */ c() {
        this("", new a(null, null, 15), t.f12808a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return l.a(this.f11565a, cVar.f11565a) && l.a(this.f11566b, cVar.f11566b) && l.a(this.f11567c, cVar.f11567c);
    }

    public final int hashCode() {
        String str = this.f11565a;
        return this.f11567c.hashCode() + ((this.f11566b.hashCode() + ((str == null ? 0 : str.hashCode()) * 31)) * 31);
    }

    public final String toString() {
        return "GBCPurposeResponse(language=" + ((Object) this.f11565a) + ", banner=" + this.f11566b + ", purposes=" + this.f11567c + ')';
    }

    public c(String str, a aVar, List list) {
        this.f11565a = str;
        this.f11566b = aVar;
        this.f11567c = list;
    }
}
