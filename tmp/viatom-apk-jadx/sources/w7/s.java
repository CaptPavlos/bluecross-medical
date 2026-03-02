package w7;

import androidx.core.internal.view.SupportMenu;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import r7.n1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class s extends b implements n1 {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f13554d = AtomicIntegerFieldUpdater.newUpdater(s.class, "cleanedAndPointers$volatile");

    /* renamed from: c, reason: collision with root package name */
    public final long f13555c;
    private volatile /* synthetic */ int cleanedAndPointers$volatile;

    public s(long j10, s sVar, int i10) {
        super(sVar);
        this.f13555c = j10;
        this.cleanedAndPointers$volatile = i10 << 16;
    }

    @Override // w7.b
    public final boolean c() {
        return f13554d.get(this) == f() && b() != null;
    }

    public final boolean e() {
        return f13554d.addAndGet(this, SupportMenu.CATEGORY_MASK) == f() && b() != null;
    }

    public abstract int f();

    public abstract void g(int i10, w6.h hVar);

    public final void h() {
        if (f13554d.incrementAndGet(this) == f()) {
            d();
        }
    }

    public final boolean i() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i10;
        do {
            atomicIntegerFieldUpdater = f13554d;
            i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 == f() && b() != null) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, 65536 + i10));
        return true;
    }
}
