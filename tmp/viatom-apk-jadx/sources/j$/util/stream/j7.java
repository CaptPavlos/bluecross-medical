package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class j7 implements j5 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9626a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DoubleConsumer f9627b;

    public /* synthetic */ j7(DoubleConsumer doubleConsumer, int i10) {
        this.f9626a = i10;
        this.f9627b = doubleConsumer;
    }

    private final /* synthetic */ void a(long j10) {
    }

    private final /* synthetic */ void b(long j10) {
    }

    private final /* synthetic */ void f() {
    }

    private final /* synthetic */ void g() {
    }

    @Override // j$.util.stream.j5, java.util.function.DoubleConsumer
    public final void accept(double d8) {
        switch (this.f9626a) {
            case 0:
                this.f9627b.accept(d8);
                break;
            default:
                ((p6) this.f9627b).accept(d8);
                break;
        }
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void accept(int i10) {
        switch (this.f9626a) {
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
        switch (this.f9626a) {
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
        switch (this.f9626a) {
            case 0:
                n((Double) obj);
                break;
            default:
                n((Double) obj);
                break;
        }
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f9626a) {
        }
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        switch (this.f9626a) {
        }
        return j$.com.android.tools.r8.a.d(this, doubleConsumer);
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void c(long j10) {
        int i10 = this.f9626a;
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ boolean e() {
        switch (this.f9626a) {
        }
        return false;
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void end() {
        int i10 = this.f9626a;
    }

    @Override // j$.util.stream.j5
    public final /* synthetic */ void n(Double d8) {
        switch (this.f9626a) {
            case 0:
                w3.d(this, d8);
                break;
            default:
                w3.d(this, d8);
                break;
        }
    }
}
