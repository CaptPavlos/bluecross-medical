package j$.util.stream;

import java.util.function.LongConsumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class e2 implements LongConsumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9559a;

    public /* synthetic */ e2(int i10) {
        this.f9559a = i10;
    }

    private final void accept$j$$util$stream$Node$OfLong$0(long j10) {
    }

    private final void accept$j$$util$stream$StreamSpliterators$SliceSpliterator$OfLong$0(long j10) {
    }

    @Override // java.util.function.LongConsumer
    public final void accept(long j10) {
        int i10 = this.f9559a;
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        switch (this.f9559a) {
        }
        return j$.com.android.tools.r8.a.f(this, longConsumer);
    }
}
