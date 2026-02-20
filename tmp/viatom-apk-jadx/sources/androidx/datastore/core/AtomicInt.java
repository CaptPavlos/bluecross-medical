package androidx.datastore.core;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class AtomicInt {
    private final AtomicInteger delegate;

    public AtomicInt(int i10) {
        this.delegate = new AtomicInteger(i10);
    }

    public final int decrementAndGet() {
        return this.delegate.decrementAndGet();
    }

    public final int get() {
        return this.delegate.get();
    }

    public final int getAndIncrement() {
        return this.delegate.getAndIncrement();
    }

    public final int incrementAndGet() {
        return this.delegate.incrementAndGet();
    }

    public /* synthetic */ AtomicInt(int i10, int i11, g gVar) {
        this((i11 & 1) != 0 ? 0 : i10);
    }
}
