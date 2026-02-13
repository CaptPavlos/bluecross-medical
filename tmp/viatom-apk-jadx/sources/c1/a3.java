package c1;

import j$.util.function.Function$CC;
import java.util.function.Function;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class a3 implements Function {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ a3 f1009a = new a3();

    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.Function
    public final /* synthetic */ Object apply(Object obj) {
        return Long.valueOf(((k4) obj).f1309b);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }
}
