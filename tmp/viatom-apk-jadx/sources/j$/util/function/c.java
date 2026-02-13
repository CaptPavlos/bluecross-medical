package j$.util.function;

import j$.time.g;
import j$.util.Objects;
import j$.util.stream.Collectors;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;

/* loaded from: classes2.dex */
public final /* synthetic */ class c implements Function, BiConsumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9430a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function f9431b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function f9432c;

    public /* synthetic */ c(Function function, Function function2, int i10) {
        this.f9430a = i10;
        this.f9431b = function;
        this.f9432c = function2;
    }

    public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        return j$.com.android.tools.r8.a.b(this, biConsumer);
    }

    public /* synthetic */ Function andThen(Function function) {
        switch (this.f9430a) {
        }
        return Function$CC.$default$andThen(this, function);
    }

    public /* synthetic */ Function compose(Function function) {
        switch (this.f9430a) {
        }
        return Function$CC.$default$compose(this, function);
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        switch (this.f9430a) {
            case 0:
                return this.f9432c.apply(this.f9431b.apply(obj));
            default:
                return this.f9431b.apply(this.f9432c.apply(obj));
        }
    }

    @Override // java.util.function.BiConsumer
    public void accept(Object obj, Object obj2) {
        Set set = Collectors.f9498a;
        Object objApply = this.f9431b.apply(obj2);
        Object objRequireNonNull = Objects.requireNonNull(this.f9432c.apply(obj2));
        Object objT = j$.util.c.t((Map) obj, objApply, objRequireNonNull);
        if (objT == null) {
            return;
        }
        g.g("Duplicate key %s (attempted merging values %s and %s)", new Object[]{objApply, objT, objRequireNonNull});
    }
}
