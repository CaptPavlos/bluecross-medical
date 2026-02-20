package j$.util.stream;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

/* loaded from: classes2.dex */
public final /* synthetic */ class p implements BinaryOperator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9699a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BiConsumer f9700b;

    public /* synthetic */ p(BiConsumer biConsumer, int i10) {
        this.f9699a = i10;
        this.f9700b = biConsumer;
    }

    public final /* synthetic */ BiFunction andThen(Function function) {
        switch (this.f9699a) {
        }
        return j$.com.android.tools.r8.a.c(this, function);
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f9699a) {
            case 0:
                this.f9700b.accept(obj, obj2);
                break;
            case 1:
                this.f9700b.accept(obj, obj2);
                break;
            default:
                this.f9700b.accept(obj, obj2);
                break;
        }
        return obj;
    }
}
