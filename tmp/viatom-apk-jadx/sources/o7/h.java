package o7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h extends t6.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f11767a;

    public h(i iVar) {
        this.f11767a = iVar;
    }

    @Override // t6.a, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof String) {
            return super.contains((String) obj);
        }
        return false;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        String strGroup = this.f11767a.f11768a.group(i10);
        return strGroup == null ? "" : strGroup;
    }

    @Override // t6.a
    public final int getSize() {
        return this.f11767a.f11768a.groupCount() + 1;
    }

    @Override // t6.e, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof String) {
            return super.indexOf((String) obj);
        }
        return -1;
    }

    @Override // t6.e, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof String) {
            return super.lastIndexOf((String) obj);
        }
        return -1;
    }
}
