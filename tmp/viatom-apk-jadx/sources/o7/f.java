package o7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: d, reason: collision with root package name */
    public static final f f11759d;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f11760a;

    /* renamed from: b, reason: collision with root package name */
    public final d f11761b;

    /* renamed from: c, reason: collision with root package name */
    public final e f11762c;

    static {
        d dVar = d.f11756a;
        e eVar = e.f11757b;
        f11759d = new f(false, dVar, eVar);
        new f(true, dVar, eVar);
    }

    public f(boolean z9, d dVar, e eVar) {
        dVar.getClass();
        eVar.getClass();
        this.f11760a = z9;
        this.f11761b = dVar;
        this.f11762c = eVar;
    }

    public final String toString() {
        StringBuilder sbV = a3.a.v("HexFormat(\n    upperCase = ");
        sbV.append(this.f11760a);
        sbV.append(",\n    bytes = BytesHexFormat(\n");
        this.f11761b.a(sbV, "        ");
        sbV.append('\n');
        sbV.append("    ),");
        sbV.append('\n');
        sbV.append("    number = NumberHexFormat(");
        sbV.append('\n');
        this.f11762c.a(sbV, "        ");
        sbV.append('\n');
        sbV.append("    )");
        sbV.append('\n');
        sbV.append(")");
        return sbV.toString();
    }
}
