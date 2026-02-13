package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.IntStream;
import java.util.Iterator;
import java.util.stream.BaseStream;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;

/* loaded from: classes2.dex */
public final /* synthetic */ class e implements g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseStream f9557a;

    public /* synthetic */ e(BaseStream baseStream) {
        this.f9557a = baseStream;
    }

    public static /* synthetic */ g g(BaseStream baseStream) {
        if (baseStream == null) {
            return null;
        }
        return baseStream instanceof f ? ((f) baseStream).f9567a : baseStream instanceof DoubleStream ? c0.g((DoubleStream) baseStream) : baseStream instanceof java.util.stream.IntStream ? IntStream.VivifiedWrapper.convert((java.util.stream.IntStream) baseStream) : baseStream instanceof LongStream ? l1.g((LongStream) baseStream) : baseStream instanceof java.util.stream.Stream ? x6.g((java.util.stream.Stream) baseStream) : new e(baseStream);
    }

    @Override // java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        this.f9557a.close();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        BaseStream baseStream = this.f9557a;
        if (obj instanceof e) {
            obj = ((e) obj).f9557a;
        }
        return baseStream.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f9557a.hashCode();
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ boolean isParallel() {
        return this.f9557a.isParallel();
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ Iterator iterator() {
        return this.f9557a.iterator();
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ g onClose(Runnable runnable) {
        return g(this.f9557a.onClose(runnable));
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ g parallel() {
        return g(this.f9557a.parallel());
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ g sequential() {
        return g(this.f9557a.sequential());
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ Spliterator spliterator() {
        return j$.util.f1.a(this.f9557a.spliterator());
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ g unordered() {
        return g(this.f9557a.unordered());
    }
}
