package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public abstract class r0 implements f8, g8 {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f9719a;

    public /* synthetic */ void accept(double d8) {
        w3.c();
        throw null;
    }

    public /* synthetic */ void accept(int i10) {
        w3.k();
        throw null;
    }

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
    public final /* synthetic */ boolean e() {
        return false;
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void end() {
    }

    public r0(boolean z9) {
        this.f9719a = z9;
    }

    @Override // j$.util.stream.f8
    public final int f() {
        if (this.f9719a) {
            return 0;
        }
        return z6.f9828r;
    }

    public final void g(a aVar, Spliterator spliterator) {
        if (this.f9719a) {
            new s0(aVar, spliterator, this).invoke();
        } else {
            new t0(aVar, spliterator, aVar.R(this)).invoke();
        }
    }
}
