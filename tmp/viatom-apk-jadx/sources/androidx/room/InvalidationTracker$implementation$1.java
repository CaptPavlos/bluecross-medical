package androidx.room;

import g7.l;
import java.util.Set;
import kotlin.jvm.internal.k;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public /* synthetic */ class InvalidationTracker$implementation$1 extends k implements l {
    public InvalidationTracker$implementation$1(Object obj) {
        super(1, obj, InvalidationTracker.class, "notifyInvalidatedObservers", "notifyInvalidatedObservers(Ljava/util/Set;)V", 0);
    }

    public final void invoke(Set<Integer> set) {
        set.getClass();
        ((InvalidationTracker) this.receiver).notifyInvalidatedObservers(set);
    }

    @Override // g7.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Set<Integer>) obj);
        return w.f12711a;
    }
}
