package t3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f12775a;

    /* renamed from: b, reason: collision with root package name */
    public static final e f12776b;

    /* renamed from: c, reason: collision with root package name */
    public static final e f12777c;

    /* renamed from: d, reason: collision with root package name */
    public static final e f12778d;
    public static final /* synthetic */ e[] e;

    static {
        e eVar = new e("VIDEO_CONTROLS", 0);
        f12775a = eVar;
        e eVar2 = new e("CLOSE_AD", 1);
        f12776b = eVar2;
        e eVar3 = new e("NOT_VISIBLE", 2);
        f12777c = eVar3;
        e eVar4 = new e("OTHER", 3);
        f12778d = eVar4;
        e = new e[]{eVar, eVar2, eVar3, eVar4};
    }

    public static e valueOf(String str) {
        return (e) Enum.valueOf(e.class, str);
    }

    public static e[] values() {
        return (e[]) e.clone();
    }
}
