package androidx.room;

import g7.p;
import java.util.concurrent.atomic.AtomicInteger;
import w6.e;
import w6.f;
import w6.g;
import w6.h;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class TransactionElement implements f {
    public static final Key Key = new Key(null);
    private final AtomicInteger referenceCount;
    private final e transactionDispatcher;

    public TransactionElement(e eVar) {
        eVar.getClass();
        this.transactionDispatcher = eVar;
        this.referenceCount = new AtomicInteger(0);
    }

    public final void acquire() {
        this.referenceCount.incrementAndGet();
    }

    @Override // w6.h
    public <R> R fold(R r6, p pVar) {
        return (R) t1.o(this, r6, pVar);
    }

    @Override // w6.h
    public <E extends f> E get(g gVar) {
        return (E) t1.p(this, gVar);
    }

    @Override // w6.f
    public g getKey() {
        return Key;
    }

    public final e getTransactionDispatcher$room_runtime_release() {
        return this.transactionDispatcher;
    }

    @Override // w6.h
    public h minusKey(g gVar) {
        return t1.K(this, gVar);
    }

    @Override // w6.h
    public h plus(h hVar) {
        return t1.M(this, hVar);
    }

    public final void release() {
        if (this.referenceCount.decrementAndGet() >= 0) {
            return;
        }
        androidx.window.layout.c.g("Transaction was never started or was already released.");
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Key implements g {
        public /* synthetic */ Key(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Key() {
        }
    }
}
