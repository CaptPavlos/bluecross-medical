package j$.time.format;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class v {
    public static final v FULL;
    public static final v FULL_STANDALONE;
    public static final v NARROW;
    public static final v NARROW_STANDALONE;
    public static final v SHORT;
    public static final v SHORT_STANDALONE;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ v[] f9249a;

    public static v valueOf(String str) {
        return (v) Enum.valueOf(v.class, str);
    }

    public static v[] values() {
        return (v[]) f9249a.clone();
    }

    static {
        v vVar = new v("FULL", 0);
        FULL = vVar;
        v vVar2 = new v("FULL_STANDALONE", 1);
        FULL_STANDALONE = vVar2;
        v vVar3 = new v("SHORT", 2);
        SHORT = vVar3;
        v vVar4 = new v("SHORT_STANDALONE", 3);
        SHORT_STANDALONE = vVar4;
        v vVar5 = new v("NARROW", 4);
        NARROW = vVar5;
        v vVar6 = new v("NARROW_STANDALONE", 5);
        NARROW_STANDALONE = vVar6;
        f9249a = new v[]{vVar, vVar2, vVar3, vVar4, vVar5, vVar6};
    }
}
