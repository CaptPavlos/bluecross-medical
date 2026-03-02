package j$.time.format;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class t {
    public static final t LENIENT;
    public static final t SMART;
    public static final t STRICT;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ t[] f9247a;

    public static t valueOf(String str) {
        return (t) Enum.valueOf(t.class, str);
    }

    public static t[] values() {
        return (t[]) f9247a.clone();
    }

    static {
        t tVar = new t("STRICT", 0);
        STRICT = tVar;
        t tVar2 = new t("SMART", 1);
        SMART = tVar2;
        t tVar3 = new t("LENIENT", 2);
        LENIENT = tVar3;
        f9247a = new t[]{tVar, tVar2, tVar3};
    }
}
