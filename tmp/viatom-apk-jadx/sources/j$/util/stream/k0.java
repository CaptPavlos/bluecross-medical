package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public abstract class k0 implements g8 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f9635a;

    /* renamed from: b, reason: collision with root package name */
    public Object f9636b;

    @Override // j$.util.stream.m5, j$.util.stream.j5, java.util.function.DoubleConsumer
    public /* synthetic */ void accept(double d8) {
        w3.c();
        throw null;
    }

    @Override // j$.util.stream.m5
    public /* synthetic */ void accept(int i10) {
        w3.k();
        throw null;
    }

    @Override // j$.util.stream.m5
    public /* synthetic */ void accept(long j10) {
        w3.l();
        throw null;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void c(long j10) {
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void end() {
    }

    @Override // java.util.function.Consumer
    /* renamed from: accept, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final void n(Object obj) {
        if (this.f9635a) {
            return;
        }
        this.f9635a = true;
        this.f9636b = obj;
    }

    @Override // j$.util.stream.m5
    public final boolean e() {
        return this.f9635a;
    }
}
