package m8;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.l;
import t6.t;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f11236a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11237b;

    /* renamed from: c, reason: collision with root package name */
    public final List f11238c;

    /* renamed from: d, reason: collision with root package name */
    public Object f11239d;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, t6.t] */
    public a(int i10, String str, ArrayList arrayList) {
        str = (i10 & 1) != 0 ? "" : str;
        int i11 = i10 & 4;
        ?? r02 = t.f12808a;
        arrayList = i11 != 0 ? r02 : arrayList;
        this.f11236a = str;
        this.f11237b = "";
        this.f11238c = arrayList;
        this.f11239d = r02;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return l.a(this.f11236a, aVar.f11236a) && l.a(this.f11237b, aVar.f11237b) && l.a(this.f11238c, aVar.f11238c) && l.a(this.f11239d, aVar.f11239d);
    }

    public final int hashCode() {
        String str = this.f11236a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f11237b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List list = this.f11238c;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        Object obj = this.f11239d;
        return iHashCode3 + (obj != null ? obj.hashCode() : 0);
    }

    public final String toString() {
        return "MSPAConfig(jurisdiction=" + ((Object) this.f11236a) + ", state=" + ((Object) this.f11237b) + ", purposes=" + this.f11238c + ", applicablePurposes=" + this.f11239d + ')';
    }
}
