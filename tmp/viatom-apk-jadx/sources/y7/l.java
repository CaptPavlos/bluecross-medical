package y7;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f14129b = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "lastScheduledTask$volatile");

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f14130c = AtomicIntegerFieldUpdater.newUpdater(l.class, "producerIndex$volatile");

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f14131d = AtomicIntegerFieldUpdater.newUpdater(l.class, "consumerIndex$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater e = AtomicIntegerFieldUpdater.newUpdater(l.class, "blockingTasksInBuffer$volatile");

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReferenceArray f14132a = new AtomicReferenceArray(128);
    private volatile /* synthetic */ int blockingTasksInBuffer$volatile;
    private volatile /* synthetic */ int consumerIndex$volatile;
    private volatile /* synthetic */ Object lastScheduledTask$volatile;
    private volatile /* synthetic */ int producerIndex$volatile;

    public final h a(h hVar) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f14130c;
        if (atomicIntegerFieldUpdater.get(this) - f14131d.get(this) == 127) {
            return hVar;
        }
        if (hVar.f14122b) {
            e.incrementAndGet(this);
        }
        int i10 = atomicIntegerFieldUpdater.get(this) & 127;
        while (true) {
            AtomicReferenceArray atomicReferenceArray = this.f14132a;
            if (atomicReferenceArray.get(i10) == null) {
                atomicReferenceArray.lazySet(i10, hVar);
                atomicIntegerFieldUpdater.incrementAndGet(this);
                return null;
            }
            Thread.yield();
        }
    }

    public final h b() {
        h hVar;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f14131d;
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 - f14130c.get(this) == 0) {
                return null;
            }
            int i11 = i10 & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i10, i10 + 1) && (hVar = (h) this.f14132a.getAndSet(i11, null)) != null) {
                if (hVar.f14122b) {
                    e.decrementAndGet(this);
                }
                return hVar;
            }
        }
    }

    public final h c(int i10, boolean z9) {
        int i11 = i10 & 127;
        AtomicReferenceArray atomicReferenceArray = this.f14132a;
        h hVar = (h) atomicReferenceArray.get(i11);
        if (hVar != null && hVar.f14122b == z9) {
            while (!atomicReferenceArray.compareAndSet(i11, hVar, null)) {
                if (atomicReferenceArray.get(i11) != hVar) {
                }
            }
            if (z9) {
                e.decrementAndGet(this);
            }
            return hVar;
        }
        return null;
    }
}
