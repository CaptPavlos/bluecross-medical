package j$.util;

import j$.util.stream.m5;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class j0 implements IntConsumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9458a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Consumer f9459b;

    public /* synthetic */ j0(Consumer consumer, int i10) {
        this.f9458a = i10;
        this.f9459b = consumer;
    }

    @Override // java.util.function.IntConsumer
    public final void accept(int i10) {
        switch (this.f9458a) {
            case 0:
                this.f9459b.accept(Integer.valueOf(i10));
                break;
            default:
                ((m5) this.f9459b).accept(i10);
                break;
        }
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        switch (this.f9458a) {
        }
        return j$.com.android.tools.r8.a.e(this, intConsumer);
    }
}
