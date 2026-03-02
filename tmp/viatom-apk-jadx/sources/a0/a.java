package a0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f6c;

    public /* synthetic */ a(int i10, String str, boolean z9) {
        this.f4a = i10;
        this.f5b = str;
        this.f6c = z9;
    }

    public String toString() {
        switch (this.f4a) {
            case 0:
                String str = this.f5b;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
                sb.append("{");
                sb.append(str);
                sb.append("}");
                sb.append(this.f6c);
                return sb.toString();
            default:
                return super.toString();
        }
    }
}
