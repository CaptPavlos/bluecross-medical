package j1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final Object f9887a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f9888b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f9889c;

    public e(Object obj, Object obj2, Object obj3) {
        this.f9887a = obj;
        this.f9888b = obj2;
        this.f9889c = obj3;
    }

    public final IllegalArgumentException a() {
        Object obj = this.f9887a;
        String strValueOf = String.valueOf(obj);
        String strValueOf2 = String.valueOf(this.f9888b);
        String strValueOf3 = String.valueOf(obj);
        String strValueOf4 = String.valueOf(this.f9889c);
        StringBuilder sb = new StringBuilder(strValueOf4.length() + strValueOf3.length() + strValueOf2.length() + strValueOf.length() + 39);
        sb.append("Multiple entries with same key: ");
        sb.append(strValueOf);
        sb.append("=");
        sb.append(strValueOf2);
        sb.append(" and ");
        sb.append(strValueOf3);
        sb.append("=");
        sb.append(strValueOf4);
        return new IllegalArgumentException(sb.toString());
    }
}
