package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class c8 implements m5 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9547a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Consumer f9548b;

    public /* synthetic */ c8(Consumer consumer, int i10) {
        this.f9547a = i10;
        this.f9548b = consumer;
    }

    private final /* synthetic */ void a(long j10) {
    }

    private final /* synthetic */ void b(long j10) {
    }

    private final /* synthetic */ void f() {
    }

    private final /* synthetic */ void g() {
    }

    @Override // j$.util.stream.m5, j$.util.stream.j5, java.util.function.DoubleConsumer
    public final /* synthetic */ void accept(double d8) {
        switch (this.f9547a) {
            case 0:
                w3.c();
                throw null;
            default:
                w3.c();
                throw null;
        }
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void accept(int i10) {
        switch (this.f9547a) {
            case 0:
                w3.k();
                throw null;
            default:
                w3.k();
                throw null;
        }
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void accept(long j10) {
        switch (this.f9547a) {
            case 0:
                w3.l();
                throw null;
            default:
                w3.l();
                throw null;
        }
    }

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public final void n(Object obj) {
        switch (this.f9547a) {
            case 0:
                ((w6) this.f9548b).n(obj);
                break;
            default:
                this.f9548b.n(obj);
                break;
        }
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f9547a) {
        }
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void c(long j10) {
        int i10 = this.f9547a;
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ boolean e() {
        switch (this.f9547a) {
        }
        return false;
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void end() {
        int i10 = this.f9547a;
    }
}
