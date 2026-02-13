package j$.time.format;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class u {
    public static final u ALWAYS;
    public static final u EXCEEDS_PAD;
    public static final u NEVER;
    public static final u NORMAL;
    public static final u NOT_NEGATIVE;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ u[] f9248a;

    public static u valueOf(String str) {
        return (u) Enum.valueOf(u.class, str);
    }

    public static u[] values() {
        return (u[]) f9248a.clone();
    }

    static {
        u uVar = new u("NORMAL", 0);
        NORMAL = uVar;
        u uVar2 = new u("ALWAYS", 1);
        ALWAYS = uVar2;
        u uVar3 = new u("NEVER", 2);
        NEVER = uVar3;
        u uVar4 = new u("NOT_NEGATIVE", 3);
        NOT_NEGATIVE = uVar4;
        u uVar5 = new u("EXCEEDS_PAD", 4);
        EXCEEDS_PAD = uVar5;
        f9248a = new u[]{uVar, uVar2, uVar3, uVar4, uVar5};
    }
}
