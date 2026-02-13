package j$.util.function;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

/* loaded from: classes2.dex */
public final /* synthetic */ class a implements BinaryOperator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9426a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Comparator f9427b;

    public /* synthetic */ a(Comparator comparator, int i10) {
        this.f9426a = i10;
        this.f9427b = comparator;
    }

    public final /* synthetic */ BiFunction andThen(Function function) {
        switch (this.f9426a) {
        }
        return j$.com.android.tools.r8.a.c(this, function);
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f9426a) {
            case 0:
                if (this.f9427b.compare(obj, obj2) < 0) {
                    break;
                }
                break;
            default:
                if (this.f9427b.compare(obj, obj2) > 0) {
                    break;
                }
                break;
        }
        return obj2;
    }
}
