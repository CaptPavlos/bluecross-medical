package m8;

import java.util.ArrayList;
import kotlin.jvm.internal.l;
import t6.t;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f11240a;

    /* renamed from: b, reason: collision with root package name */
    public final Boolean f11241b;

    /* renamed from: c, reason: collision with root package name */
    public Boolean f11242c;

    /* renamed from: d, reason: collision with root package name */
    public final n6.a f11243d;
    public final ArrayList e;
    public Object f;
    public final boolean g;

    public b(Integer num, Boolean bool, n6.a aVar, ArrayList arrayList, boolean z9) {
        Boolean bool2 = Boolean.FALSE;
        this.f11240a = num;
        this.f11241b = bool;
        this.f11242c = bool2;
        this.f11243d = aVar;
        this.e = arrayList;
        this.f = t.f12808a;
        this.g = z9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f11240a.equals(bVar.f11240a) && this.f11241b.equals(bVar.f11241b) && l.a(this.f11242c, bVar.f11242c) && this.f11243d.equals(bVar.f11243d) && this.e.equals(bVar.e) && l.a(this.f, bVar.f) && this.g == bVar.g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int iHashCode = (this.f11241b.hashCode() + (this.f11240a.hashCode() * 961)) * 31;
        Boolean bool = this.f11242c;
        int iHashCode2 = (this.e.hashCode() + ((this.f11243d.hashCode() + ((iHashCode + (bool == null ? 0 : bool.hashCode())) * 31)) * 31)) * 31;
        Object obj = this.f;
        int iHashCode3 = (iHashCode2 + (obj != null ? obj.hashCode() : 0)) * 31;
        boolean z9 = this.g;
        int i10 = z9;
        if (z9 != 0) {
            i10 = 1;
        }
        return iHashCode3 + i10;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MSPAPurpose(id=");
        sb.append(this.f11240a);
        sb.append(", category=, defaultValue=");
        sb.append(this.f11241b);
        sb.append(", value=");
        sb.append(this.f11242c);
        sb.append(", consentBanner=");
        sb.append(this.f11243d);
        sb.append(", purposes=");
        sb.append(this.e);
        sb.append(", applicableSensitivePurposes=");
        sb.append(this.f);
        sb.append(", noticeOnly=");
        return androidx.constraintlayout.core.widgets.analyzer.a.z(sb, this.g, ')');
    }
}
