package z8;

import java.util.ArrayList;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f14497a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f14498b;

    /* renamed from: c, reason: collision with root package name */
    public final Long f14499c;

    /* renamed from: d, reason: collision with root package name */
    public final Long f14500d;
    public final Long e;
    public final Long f;
    public final Map g = t6.a0.l0(t6.u.f12809a);

    public o(boolean z9, boolean z10, Long l10, Long l11, Long l12, Long l13) {
        this.f14497a = z9;
        this.f14498b = z10;
        this.f14499c = l10;
        this.f14500d = l11;
        this.e = l12;
        this.f = l13;
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        if (this.f14497a) {
            arrayList.add("isRegularFile");
        }
        if (this.f14498b) {
            arrayList.add("isDirectory");
        }
        Long l10 = this.f14499c;
        if (l10 != null) {
            arrayList.add("byteCount=" + l10);
        }
        Long l11 = this.f14500d;
        if (l11 != null) {
            arrayList.add("createdAt=" + l11);
        }
        Long l12 = this.e;
        if (l12 != null) {
            arrayList.add("lastModifiedAt=" + l12);
        }
        Long l13 = this.f;
        if (l13 != null) {
            arrayList.add("lastAccessedAt=" + l13);
        }
        Map map = this.g;
        if (!map.isEmpty()) {
            arrayList.add("extras=" + map);
        }
        return t6.l.h0(arrayList, ", ", "FileMetadata(", ")", null, 56);
    }
}
