package j$.util.stream;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;

/* loaded from: classes2.dex */
public final class b4 extends w3 {
    public final /* synthetic */ int h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f9519i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f9520j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f9521k;

    public /* synthetic */ b4(a7 a7Var, Object obj, Object obj2, Object obj3, int i10) {
        this.h = i10;
        this.f9520j = obj;
        this.f9521k = obj2;
        this.f9519i = obj3;
    }

    @Override // j$.util.stream.w3
    public final r4 Z() {
        switch (this.h) {
            case 0:
                return new y3((Supplier) this.f9519i, (ObjLongConsumer) this.f9521k, (p) this.f9520j);
            case 1:
                return new e4((Supplier) this.f9519i, (ObjDoubleConsumer) this.f9521k, (p) this.f9520j);
            case 2:
                return new g4(this.f9519i, (BiFunction) this.f9521k, (BinaryOperator) this.f9520j);
            case 3:
                return new k4((Supplier) this.f9519i, (BiConsumer) this.f9521k, (BiConsumer) this.f9520j);
            default:
                return new o4((Supplier) this.f9519i, (ObjIntConsumer) this.f9521k, (p) this.f9520j);
        }
    }
}
