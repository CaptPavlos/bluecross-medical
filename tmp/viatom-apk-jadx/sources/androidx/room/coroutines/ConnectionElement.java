package androidx.room.coroutines;

import g7.p;
import w6.f;
import w6.g;
import w6.h;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final class ConnectionElement implements f {
    public static final Key Key = new Key(null);
    private final PooledConnectionImpl connectionWrapper;

    public ConnectionElement(PooledConnectionImpl pooledConnectionImpl) {
        pooledConnectionImpl.getClass();
        this.connectionWrapper = pooledConnectionImpl;
    }

    @Override // w6.h
    public <R> R fold(R r6, p pVar) {
        return (R) t1.o(this, r6, pVar);
    }

    @Override // w6.h
    public <E extends f> E get(g gVar) {
        return (E) t1.p(this, gVar);
    }

    public final PooledConnectionImpl getConnectionWrapper() {
        return this.connectionWrapper;
    }

    @Override // w6.f
    public g getKey() {
        return Key;
    }

    @Override // w6.h
    public h minusKey(g gVar) {
        return t1.K(this, gVar);
    }

    @Override // w6.h
    public h plus(h hVar) {
        return t1.M(this, hVar);
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
