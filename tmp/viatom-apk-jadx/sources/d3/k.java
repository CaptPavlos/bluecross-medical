package d3;

import java.util.concurrent.atomic.AtomicReference;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class k implements u7.i, kotlin.jvm.internal.h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f6827a;

    public k(AtomicReference atomicReference) {
        this.f6827a = atomicReference;
    }

    @Override // u7.i
    public final Object emit(Object obj, w6.c cVar) {
        this.f6827a.set((g) obj);
        return w.f12711a;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof u7.i) && (obj instanceof kotlin.jvm.internal.h)) {
            return getFunctionDelegate().equals(((kotlin.jvm.internal.h) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.h
    public final s6.c getFunctionDelegate() {
        return new kotlin.jvm.internal.a(this.f6827a);
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }
}
