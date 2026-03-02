package j$.time;

/* loaded from: classes2.dex */
public final /* synthetic */ class g {
    public static /* synthetic */ void a(long j10) {
        throw new IllegalArgumentException("Skip must be non-negative: " + j10);
    }

    public static /* synthetic */ void b(Object obj, String str) {
        throw new j$.time.temporal.t(str + obj);
    }

    public static /* synthetic */ void c(String str) {
        throw new IllegalArgumentException(str);
    }

    public static /* synthetic */ void d(String str, int i10) {
        throw new b(str + i10);
    }

    public static /* synthetic */ void e(String str, int i10, Object obj) {
        throw new b(str + i10 + obj);
    }

    public static /* synthetic */ void f(String str, Object obj, Object obj2) {
        throw new ClassCastException(str + obj + ((Object) ", actual: ") + obj2);
    }

    public static /* synthetic */ void g(String str, Object[] objArr) {
        throw new IllegalStateException(String.format(str, objArr));
    }

    public static /* synthetic */ void h(Object obj, String str) {
        throw new b(str + obj);
    }

    public static /* synthetic */ void i(String str, int i10) {
        throw new IllegalArgumentException(str + i10);
    }
}
