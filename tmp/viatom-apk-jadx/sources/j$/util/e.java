package j$.util;

import java.io.Serializable;
import java.util.Comparator;
import java.util.function.Function;

/* loaded from: classes2.dex */
public final /* synthetic */ class e implements Comparator, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9416a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Comparator f9417b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f9418c;

    public /* synthetic */ e(f fVar, Comparator comparator) {
        this.f9418c = fVar;
        this.f9417b = comparator;
    }

    public /* synthetic */ e(Function function, Comparator comparator) {
        this.f9417b = comparator;
        this.f9418c = function;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f9416a) {
            case 0:
                f fVar = (f) this.f9418c;
                Comparator comparator = this.f9417b;
                int iCompare = fVar.compare(obj, obj2);
                return iCompare != 0 ? iCompare : comparator.compare(obj, obj2);
            default:
                Comparator comparator2 = this.f9417b;
                Function function = (Function) this.f9418c;
                return comparator2.compare(function.apply(obj), function.apply(obj2));
        }
    }
}
