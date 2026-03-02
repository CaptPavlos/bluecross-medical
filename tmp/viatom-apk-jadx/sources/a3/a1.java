package a3;

import java.util.Locale;
import java.util.UUID;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a1 {

    /* renamed from: a, reason: collision with root package name */
    public final o1 f22a;

    /* renamed from: b, reason: collision with root package name */
    public final p1 f23b;

    public a1(o1 o1Var, p1 p1Var) {
        o1Var.getClass();
        p1Var.getClass();
        this.f22a = o1Var;
        this.f23b = p1Var;
    }

    public final t0 a(t0 t0Var) {
        String str;
        this.f23b.getClass();
        UUID uuidRandomUUID = UUID.randomUUID();
        uuidRandomUUID.getClass();
        String string = uuidRandomUUID.toString();
        string.getClass();
        String lowerCase = o7.u.b0(string, "-", "", false).toLowerCase(Locale.ROOT);
        lowerCase.getClass();
        String str2 = (t0Var == null || (str = t0Var.f162b) == null) ? lowerCase : str;
        int i10 = t0Var != null ? t0Var.f163c + 1 : 0;
        this.f22a.getClass();
        return new t0(o1.a().f138b, lowerCase, str2, i10);
    }
}
