package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class l7 implements k5 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9663a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IntConsumer f9664b;

    public /* synthetic */ l7(IntConsumer intConsumer, int i10) {
        this.f9663a = i10;
        this.f9664b = intConsumer;
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
        switch (this.f9663a) {
            case 0:
                w3.c();
                throw null;
            default:
                w3.c();
                throw null;
        }
    }

    @Override // j$.util.stream.k5, j$.util.stream.m5
    public final void accept(int i10) {
        switch (this.f9663a) {
            case 0:
                this.f9664b.accept(i10);
                break;
            default:
                ((r6) this.f9664b).accept(i10);
                break;
        }
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void accept(long j10) {
        switch (this.f9663a) {
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
    public final /* bridge */ /* synthetic */ void n(Object obj) {
        switch (this.f9663a) {
            case 0:
                d((Integer) obj);
                break;
            default:
                d((Integer) obj);
                break;
        }
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f9663a) {
        }
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        switch (this.f9663a) {
        }
        return j$.com.android.tools.r8.a.e(this, intConsumer);
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void c(long j10) {
        int i10 = this.f9663a;
    }

    @Override // j$.util.stream.k5
    public final /* synthetic */ void d(Integer num) {
        switch (this.f9663a) {
            case 0:
                w3.g(this, num);
                break;
            default:
                w3.g(this, num);
                break;
        }
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ boolean e() {
        switch (this.f9663a) {
        }
        return false;
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void end() {
        int i10 = this.f9663a;
    }
}
