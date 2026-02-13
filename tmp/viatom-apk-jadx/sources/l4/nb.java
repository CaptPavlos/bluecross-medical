package l4;

import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class nb {

    /* renamed from: a, reason: collision with root package name */
    public final h5.h1 f10666a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f10667b;

    public nb(h5.h1 h1Var, ArrayList arrayList) {
        this.f10666a = h1Var;
        this.f10667b = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof nb)) {
            return false;
        }
        nb nbVar = (nb) obj;
        return this.f10666a.equals(nbVar.f10666a) && this.f10667b.equals(nbVar.f10667b);
    }

    public final int hashCode() {
        return this.f10667b.hashCode() + (this.f10666a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("UserDevicesData(thisDevice=");
        sb.append(this.f10666a);
        sb.append(", userDevices=");
        return a3.a.p(sb, this.f10667b, ')');
    }
}
