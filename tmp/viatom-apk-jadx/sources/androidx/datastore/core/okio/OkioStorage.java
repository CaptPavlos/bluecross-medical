package androidx.datastore.core.okio;

import androidx.datastore.core.InterProcessCoordinator;
import androidx.datastore.core.Storage;
import androidx.datastore.core.StorageConnection;
import g7.a;
import g7.p;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import s6.f;
import s6.w;
import z8.z;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class OkioStorage<T> implements Storage<T> {
    public static final Companion Companion = new Companion(null);
    private static final Set<String> activeFiles = new LinkedHashSet();
    private static final Synchronizer activeFilesLock = new Synchronizer();
    private final f canonicalPath$delegate;
    private final p coordinatorProducer;
    private final z8.p fileSystem;
    private final a producePath;
    private final OkioSerializer<T> serializer;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: androidx.datastore.core.okio.OkioStorage$1, reason: invalid class name */
    public static final class AnonymousClass1 extends m implements p {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        @Override // g7.p
        public final InterProcessCoordinator invoke(z zVar, z8.p pVar) {
            zVar.getClass();
            pVar.getClass();
            return OkioStorageKt.createSingleProcessCoordinator(zVar);
        }
    }

    public OkioStorage(z8.p pVar, OkioSerializer<T> okioSerializer, p pVar2, a aVar) {
        pVar.getClass();
        okioSerializer.getClass();
        pVar2.getClass();
        aVar.getClass();
        this.fileSystem = pVar;
        this.serializer = okioSerializer;
        this.coordinatorProducer = pVar2;
        this.producePath = aVar;
        this.canonicalPath$delegate = new s6.m(new OkioStorage$canonicalPath$2(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final z getCanonicalPath() {
        return (z) this.canonicalPath$delegate.getValue();
    }

    @Override // androidx.datastore.core.Storage
    public StorageConnection<T> createConnection() {
        String strR = getCanonicalPath().f14518a.r();
        synchronized (activeFilesLock) {
            Set<String> set = activeFiles;
            if (set.contains(strR)) {
                throw new IllegalStateException(("There are multiple DataStores active for the same file: " + strR + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
            }
            set.add(strR);
        }
        return new OkioStorageConnection(this.fileSystem, getCanonicalPath(), this.serializer, (InterProcessCoordinator) this.coordinatorProducer.invoke(getCanonicalPath(), this.fileSystem), new AnonymousClass2(this));
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final Set<String> getActiveFiles$datastore_core_okio() {
            return OkioStorage.activeFiles;
        }

        public final Synchronizer getActiveFilesLock() {
            return OkioStorage.activeFilesLock;
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: androidx.datastore.core.okio.OkioStorage$createConnection$2, reason: invalid class name */
    public static final class AnonymousClass2 extends m implements a {
        final /* synthetic */ OkioStorage<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(OkioStorage<T> okioStorage) {
            super(0);
            this.this$0 = okioStorage;
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public final void m42invoke() {
            Companion companion = OkioStorage.Companion;
            Synchronizer activeFilesLock = companion.getActiveFilesLock();
            OkioStorage<T> okioStorage = this.this$0;
            synchronized (activeFilesLock) {
                companion.getActiveFiles$datastore_core_okio().remove(okioStorage.getCanonicalPath().f14518a.r());
            }
        }

        @Override // g7.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m42invoke();
            return w.f12711a;
        }
    }

    public /* synthetic */ OkioStorage(z8.p pVar, OkioSerializer okioSerializer, p pVar2, a aVar, int i10, g gVar) {
        this(pVar, okioSerializer, (i10 & 4) != 0 ? AnonymousClass1.INSTANCE : pVar2, aVar);
    }
}
