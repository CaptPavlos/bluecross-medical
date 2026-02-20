package u4;

import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f12895a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12896b;

    /* renamed from: c, reason: collision with root package name */
    public String f12897c;

    public b(String str, String str2) {
        str.getClass();
        str2.getClass();
        this.f12895a = str;
        this.f12896b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return l.a(this.f12895a, bVar.f12895a) && l.a(this.f12896b, bVar.f12896b);
    }

    public final int hashCode() {
        return this.f12896b.hashCode() + (this.f12895a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AppToBackup(packageName=");
        sb.append(this.f12895a);
        sb.append(", name=");
        return a3.a.m(sb, this.f12896b, ')');
    }
}
