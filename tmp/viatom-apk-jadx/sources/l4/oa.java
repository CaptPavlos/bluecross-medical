package l4;

import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class oa {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f10696a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f10697b;

    public oa(ArrayList arrayList, ArrayList arrayList2) {
        this.f10696a = arrayList;
        this.f10697b = arrayList2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof oa)) {
            return false;
        }
        oa oaVar = (oa) obj;
        return this.f10696a.equals(oaVar.f10696a) && this.f10697b.equals(oaVar.f10697b);
    }

    public final int hashCode() {
        return this.f10697b.hashCode() + (this.f10696a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AvatarsData(avatars=");
        sb.append(this.f10696a);
        sb.append(", turboAvatars=");
        return a3.a.p(sb, this.f10697b, ')');
    }
}
