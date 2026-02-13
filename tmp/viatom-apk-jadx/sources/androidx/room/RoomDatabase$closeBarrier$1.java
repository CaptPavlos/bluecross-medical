package androidx.room;

import kotlin.jvm.internal.k;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public /* synthetic */ class RoomDatabase$closeBarrier$1 extends k implements g7.a {
    public RoomDatabase$closeBarrier$1(Object obj) {
        super(0, obj, RoomDatabase.class, "onClosed", "onClosed()V", 0);
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m84invoke() {
        ((RoomDatabase) this.receiver).onClosed();
    }

    @Override // g7.a
    public /* bridge */ /* synthetic */ Object invoke() {
        m84invoke();
        return w.f12711a;
    }
}
