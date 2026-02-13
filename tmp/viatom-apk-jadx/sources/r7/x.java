package r7;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public static final x f12445a;

    /* renamed from: b, reason: collision with root package name */
    public static final x f12446b;

    /* renamed from: c, reason: collision with root package name */
    public static final x f12447c;

    /* renamed from: d, reason: collision with root package name */
    public static final x f12448d;
    public static final /* synthetic */ x[] e;

    static {
        x xVar = new x("DEFAULT", 0);
        f12445a = xVar;
        x xVar2 = new x("LAZY", 1);
        f12446b = xVar2;
        x xVar3 = new x("ATOMIC", 2);
        f12447c = xVar3;
        x xVar4 = new x("UNDISPATCHED", 3);
        f12448d = xVar4;
        e = new x[]{xVar, xVar2, xVar3, xVar4};
    }

    public static x valueOf(String str) {
        return (x) Enum.valueOf(x.class, str);
    }

    public static x[] values() {
        return (x[]) e.clone();
    }
}
