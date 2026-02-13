package j$.util;

import j$.util.function.Consumer$CC;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public final class g1 implements Iterator, Consumer {

    /* renamed from: a, reason: collision with root package name */
    public boolean f9441a = false;

    /* renamed from: b, reason: collision with root package name */
    public Object f9442b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Spliterator f9443c;

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public g1(Spliterator spliterator) {
        this.f9443c = spliterator;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f9441a = true;
        this.f9442b = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (!this.f9441a) {
            this.f9443c.tryAdvance(this);
        }
        return this.f9441a;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.f9441a && !hasNext()) {
            throw new NoSuchElementException();
        }
        this.f9441a = false;
        return this.f9442b;
    }
}
