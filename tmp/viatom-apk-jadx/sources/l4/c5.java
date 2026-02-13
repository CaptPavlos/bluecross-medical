package l4;

import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c5 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f10289a;

    public c5(ArrayList arrayList) {
        this.f10289a = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c5) && this.f10289a.equals(((c5) obj).f10289a);
    }

    public final int hashCode() {
        return this.f10289a.hashCode();
    }

    public final String toString() {
        return a3.a.p(new StringBuilder("NotificationRegistryData(notificationsRegistry="), this.f10289a, ')');
    }
}
