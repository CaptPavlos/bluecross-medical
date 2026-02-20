package l4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class rb {

    /* renamed from: a, reason: collision with root package name */
    public final int f10802a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10803b;

    public rb(int i10, int i11) {
        this.f10802a = i10;
        this.f10803b = i11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof rb)) {
            return false;
        }
        rb rbVar = (rb) obj;
        return this.f10802a == rbVar.f10802a && this.f10803b == rbVar.f10803b;
    }

    public final int hashCode() {
        return (this.f10802a * 31) + this.f10803b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("UserNotifiersData(downloadsCount=");
        sb.append(this.f10802a);
        sb.append(", updatesCount=");
        return a3.a.k(sb, this.f10803b, ')');
    }
}
