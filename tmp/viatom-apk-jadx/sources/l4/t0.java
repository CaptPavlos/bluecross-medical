package l4;

import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t0 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f10835a;

    public t0(ArrayList arrayList) {
        this.f10835a = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof t0) && this.f10835a.equals(((t0) obj).f10835a);
    }

    public final int hashCode() {
        return this.f10835a.hashCode();
    }

    public final String toString() {
        return a3.a.p(new StringBuilder("FreeUpSpaceData(tmpUserApps="), this.f10835a, ')');
    }
}
