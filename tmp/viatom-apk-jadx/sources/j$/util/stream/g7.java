package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public final class g7 extends h7 implements Consumer {

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f9588b;

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public g7(int i10) {
        this.f9588b = new Object[i10];
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i10 = this.f9598a;
        this.f9598a = i10 + 1;
        this.f9588b[i10] = obj;
    }
}
