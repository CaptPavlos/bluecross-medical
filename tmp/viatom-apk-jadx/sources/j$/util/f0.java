package j$.util;

import j$.util.stream.m5;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class f0 implements DoubleConsumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9423a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Consumer f9424b;

    public /* synthetic */ f0(Consumer consumer, int i10) {
        this.f9423a = i10;
        this.f9424b = consumer;
    }

    @Override // java.util.function.DoubleConsumer
    public final void accept(double d8) {
        switch (this.f9423a) {
            case 0:
                this.f9424b.accept(Double.valueOf(d8));
                break;
            default:
                ((m5) this.f9424b).accept(d8);
                break;
        }
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        switch (this.f9423a) {
        }
        return j$.com.android.tools.r8.a.d(this, doubleConsumer);
    }
}
