package j$.time.format;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class k implements f {
    public static final k INSENSITIVE;
    public static final k LENIENT;
    public static final k SENSITIVE;
    public static final k STRICT;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ k[] f9228a;

    @Override // j$.time.format.f
    public final boolean e(p pVar, StringBuilder sb) {
        return true;
    }

    public static k valueOf(String str) {
        return (k) Enum.valueOf(k.class, str);
    }

    public static k[] values() {
        return (k[]) f9228a.clone();
    }

    static {
        k kVar = new k("SENSITIVE", 0);
        SENSITIVE = kVar;
        k kVar2 = new k("INSENSITIVE", 1);
        INSENSITIVE = kVar2;
        k kVar3 = new k("STRICT", 2);
        STRICT = kVar3;
        k kVar4 = new k("LENIENT", 3);
        LENIENT = kVar4;
        f9228a = new k[]{kVar, kVar2, kVar3, kVar4};
    }

    @Override // java.lang.Enum
    public final String toString() {
        int iOrdinal = ordinal();
        if (iOrdinal == 0) {
            return "ParseCaseSensitive(true)";
        }
        if (iOrdinal == 1) {
            return "ParseCaseSensitive(false)";
        }
        if (iOrdinal == 2) {
            return "ParseStrict(true)";
        }
        if (iOrdinal == 3) {
            return "ParseStrict(false)";
        }
        throw new IllegalStateException("Unreachable");
    }
}
