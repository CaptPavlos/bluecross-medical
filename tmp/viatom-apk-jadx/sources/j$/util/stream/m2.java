package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.BinaryOperator;
import java.util.function.LongFunction;

/* loaded from: classes2.dex */
public final class m2 extends n2 {

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ int f9669k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m2(a aVar, Spliterator spliterator, LongFunction longFunction, BinaryOperator binaryOperator, int i10) {
        super(aVar, spliterator, longFunction, binaryOperator);
        this.f9669k = i10;
    }

    @Override // j$.util.stream.n2, j$.util.stream.d
    public final d c(Spliterator spliterator) {
        switch (this.f9669k) {
        }
        return new n2(this, spliterator);
    }

    @Override // j$.util.stream.n2, j$.util.stream.d
    public final /* bridge */ /* synthetic */ Object a() {
        switch (this.f9669k) {
        }
        return a();
    }
}
