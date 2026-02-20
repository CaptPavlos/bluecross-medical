package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class n7 implements l5 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9686a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LongConsumer f9687b;

    public /* synthetic */ n7(LongConsumer longConsumer, int i10) {
        this.f9686a = i10;
        this.f9687b = longConsumer;
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
        switch (this.f9686a) {
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
        switch (this.f9686a) {
            case 0:
                w3.k();
                throw null;
            default:
                w3.k();
                throw null;
        }
    }

    @Override // j$.util.stream.l5, j$.util.stream.m5
    public final void accept(long j10) {
        switch (this.f9686a) {
            case 0:
                this.f9687b.accept(j10);
                break;
            default:
                ((t6) this.f9687b).accept(j10);
                break;
        }
    }

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public final /* bridge */ /* synthetic */ void n(Object obj) {
        switch (this.f9686a) {
            case 0:
                l((Long) obj);
                break;
            default:
                l((Long) obj);
                break;
        }
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f9686a) {
        }
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        switch (this.f9686a) {
        }
        return j$.com.android.tools.r8.a.f(this, longConsumer);
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void c(long j10) {
        int i10 = this.f9686a;
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ boolean e() {
        switch (this.f9686a) {
        }
        return false;
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void end() {
        int i10 = this.f9686a;
    }

    @Override // j$.util.stream.l5
    public final /* synthetic */ void l(Long l10) {
        switch (this.f9686a) {
            case 0:
                w3.i(this, l10);
                break;
            default:
                w3.i(this, l10);
                break;
        }
    }
}
