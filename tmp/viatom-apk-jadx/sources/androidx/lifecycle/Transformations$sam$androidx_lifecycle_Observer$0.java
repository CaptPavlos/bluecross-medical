package androidx.lifecycle;

import g7.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class Transformations$sam$androidx_lifecycle_Observer$0 implements Observer, kotlin.jvm.internal.h {
    private final /* synthetic */ l function;

    public Transformations$sam$androidx_lifecycle_Observer$0(l lVar) {
        lVar.getClass();
        this.function = lVar;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof Observer) && (obj instanceof kotlin.jvm.internal.h)) {
            return kotlin.jvm.internal.l.a(getFunctionDelegate(), ((kotlin.jvm.internal.h) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.h
    public final s6.c getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // androidx.lifecycle.Observer
    public final /* synthetic */ void onChanged(Object obj) {
        this.function.invoke(obj);
    }
}
