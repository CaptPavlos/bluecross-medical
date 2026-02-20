package k3;

import j$.util.function.Function$CC;
import java.util.function.Function;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10042a;

    public /* synthetic */ Function andThen(Function function) {
        int i10 = this.f10042a;
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f10042a) {
            case 0:
                return (Integer) ((Object[]) obj)[1];
            case 1:
                return obj.toString();
            default:
                return (String) q3.b.f12257b.get((Integer) obj);
        }
    }

    public /* synthetic */ Function compose(Function function) {
        int i10 = this.f10042a;
        return Function$CC.$default$compose(this, function);
    }
}
