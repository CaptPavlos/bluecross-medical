package androidx.datastore.core;

import g7.p;
import w6.f;
import w6.g;
import w6.h;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class UpdatingDataContextElement implements f {
    public static final Companion Companion = new Companion(null);
    private static final String NESTED_UPDATE_ERROR_MESSAGE = "Calling updateData inside updateData on the same DataStore instance is not supported\nsince updates made in the parent updateData call will not be visible to the nested\nupdateData call. See https://issuetracker.google.com/issues/241760537 for details.";
    private final DataStoreImpl<?> instance;
    private final UpdatingDataContextElement parent;

    public UpdatingDataContextElement(UpdatingDataContextElement updatingDataContextElement, DataStoreImpl<?> dataStoreImpl) {
        dataStoreImpl.getClass();
        this.parent = updatingDataContextElement;
        this.instance = dataStoreImpl;
    }

    public final void checkNotUpdating(DataStore<?> dataStore) {
        dataStore.getClass();
        if (this.instance == dataStore) {
            throw new IllegalStateException(NESTED_UPDATE_ERROR_MESSAGE.toString());
        }
        UpdatingDataContextElement updatingDataContextElement = this.parent;
        if (updatingDataContextElement != null) {
            updatingDataContextElement.checkNotUpdating(dataStore);
        }
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
        return Companion.Key.INSTANCE;
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
    public static final class Companion {

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        public static final class Key implements g {
            public static final Key INSTANCE = new Key();

            private Key() {
            }
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final String getNESTED_UPDATE_ERROR_MESSAGE$datastore_core_release() {
            return UpdatingDataContextElement.NESTED_UPDATE_ERROR_MESSAGE;
        }

        private Companion() {
        }
    }
}
