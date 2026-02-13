package j$.util;

/* loaded from: classes2.dex */
public abstract class t1 {

    /* renamed from: a, reason: collision with root package name */
    public static final p1 f9839a = new p1();

    /* renamed from: b, reason: collision with root package name */
    public static final n1 f9840b = new n1();

    /* renamed from: c, reason: collision with root package name */
    public static final o1 f9841c = new o1();

    /* renamed from: d, reason: collision with root package name */
    public static final m1 f9842d = new m1();

    public static void a(int i10, int i11, int i12) {
        if (i11 <= i12) {
            if (i11 < 0) {
                throw new ArrayIndexOutOfBoundsException(i11);
            }
            if (i12 > i10) {
                throw new ArrayIndexOutOfBoundsException(i12);
            }
            return;
        }
        throw new ArrayIndexOutOfBoundsException("origin(" + i11 + ") > fence(" + i12 + ")");
    }
}
