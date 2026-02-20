package l4;

import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o8 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f10694a;

    public o8(ArrayList arrayList) {
        this.f10694a = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof o8) && this.f10694a.equals(((o8) obj).f10694a);
    }

    public final int hashCode() {
        return this.f10694a.hashCode();
    }

    public final String toString() {
        return a3.a.p(new StringBuilder("RollbackData(rollbackApps="), this.f10694a, ')');
    }
}
