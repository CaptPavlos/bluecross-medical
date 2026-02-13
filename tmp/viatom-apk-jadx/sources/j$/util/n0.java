package j$.util;

import j$.util.stream.m5;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class n0 implements LongConsumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9476a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Consumer f9477b;

    public /* synthetic */ n0(Consumer consumer, int i10) {
        this.f9476a = i10;
        this.f9477b = consumer;
    }

    @Override // java.util.function.LongConsumer
    public final void accept(long j10) {
        switch (this.f9476a) {
            case 0:
                this.f9477b.accept(Long.valueOf(j10));
                break;
            default:
                ((m5) this.f9477b).accept(j10);
                break;
        }
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        switch (this.f9476a) {
        }
        return j$.com.android.tools.r8.a.f(this, longConsumer);
    }
}
