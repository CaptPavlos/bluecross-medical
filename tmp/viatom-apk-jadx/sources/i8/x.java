package i8;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class x {

    /* renamed from: c, reason: collision with root package name */
    public static final x f9101c;

    /* renamed from: d, reason: collision with root package name */
    public static final x f9102d;
    public static final x e;
    public static final x f;
    public static final /* synthetic */ x[] g;
    public static final /* synthetic */ z6.b h;

    /* renamed from: a, reason: collision with root package name */
    public final char f9103a;

    /* renamed from: b, reason: collision with root package name */
    public final char f9104b;

    static {
        x xVar = new x("OBJ", 0, '{', '}');
        f9101c = xVar;
        x xVar2 = new x("LIST", 1, '[', ']');
        f9102d = xVar2;
        x xVar3 = new x("MAP", 2, '{', '}');
        e = xVar3;
        x xVar4 = new x("POLY_OBJ", 3, '[', ']');
        f = xVar4;
        x[] xVarArr = {xVar, xVar2, xVar3, xVar4};
        g = xVarArr;
        h = new z6.b(xVarArr);
    }

    public x(String str, int i10, char c10, char c11) {
        this.f9103a = c10;
        this.f9104b = c11;
    }

    public static x valueOf(String str) {
        return (x) Enum.valueOf(x.class, str);
    }

    public static x[] values() {
        return (x[]) g.clone();
    }
}
