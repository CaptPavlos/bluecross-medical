package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public final class q0 extends r0 {

    /* renamed from: b, reason: collision with root package name */
    public final Consumer f9711b;

    @Override // java.util.function.Supplier
    public final /* bridge */ /* synthetic */ Object get() {
        return null;
    }

    @Override // j$.util.stream.f8
    public final Object a(a aVar, Spliterator spliterator) {
        aVar.Q(spliterator, this);
        return null;
    }

    @Override // j$.util.stream.f8
    public final /* bridge */ /* synthetic */ Object b(a aVar, Spliterator spliterator) {
        g(aVar, spliterator);
        return null;
    }

    public q0(Consumer consumer, boolean z9) {
        super(z9);
        this.f9711b = consumer;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f9711b.accept(obj);
    }
}
