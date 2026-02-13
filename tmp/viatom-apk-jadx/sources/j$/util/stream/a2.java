package j$.util.stream;

import java.util.function.DoubleConsumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class a2 implements DoubleConsumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9510a;

    public /* synthetic */ a2(int i10) {
        this.f9510a = i10;
    }

    private final void accept$j$$util$stream$Node$OfDouble$0(double d8) {
    }

    private final void accept$j$$util$stream$StreamSpliterators$SliceSpliterator$OfDouble$0(double d8) {
    }

    @Override // java.util.function.DoubleConsumer
    public final void accept(double d8) {
        int i10 = this.f9510a;
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        switch (this.f9510a) {
        }
        return j$.com.android.tools.r8.a.d(this, doubleConsumer);
    }
}
