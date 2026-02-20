package androidx.datastore.core;

import androidx.annotation.GuardedBy;
import g7.l;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class FileStorage<T> implements Storage<T> {
    public static final Companion Companion = new Companion(null);

    @GuardedBy("activeFilesLock")
    private static final Set<String> activeFiles = new LinkedHashSet();
    private static final Object activeFilesLock = new Object();
    private final l coordinatorProducer;
    private final g7.a produceFile;
    private final Serializer<T> serializer;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: androidx.datastore.core.FileStorage$1, reason: invalid class name */
    public static final class AnonymousClass1 extends m implements l {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // g7.l
        public final InterProcessCoordinator invoke(File file) {
            file.getClass();
            return InterProcessCoordinator_jvmKt.createSingleProcessCoordinator(file);
        }
    }

    public FileStorage(Serializer<T> serializer, l lVar, g7.a aVar) {
        serializer.getClass();
        lVar.getClass();
        aVar.getClass();
        this.serializer = serializer;
        this.coordinatorProducer = lVar;
        this.produceFile = aVar;
    }

    @Override // androidx.datastore.core.Storage
    public StorageConnection<T> createConnection() throws IOException {
        File canonicalFile = ((File) this.produceFile.invoke()).getCanonicalFile();
        synchronized (activeFilesLock) {
            String absolutePath = canonicalFile.getAbsolutePath();
            Set<String> set = activeFiles;
            if (set.contains(absolutePath)) {
                throw new IllegalStateException(("There are multiple DataStores active for the same file: " + absolutePath + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
            }
            absolutePath.getClass();
            set.add(absolutePath);
        }
        return new FileStorageConnection(canonicalFile, this.serializer, (InterProcessCoordinator) this.coordinatorProducer.invoke(canonicalFile), new AnonymousClass2(canonicalFile));
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final Set<String> getActiveFiles$datastore_core_release() {
            return FileStorage.activeFiles;
        }

        public final Object getActiveFilesLock$datastore_core_release() {
            return FileStorage.activeFilesLock;
        }

        private Companion() {
        }
    }

    public /* synthetic */ FileStorage(Serializer serializer, l lVar, g7.a aVar, int i10, g gVar) {
        this(serializer, (i10 & 2) != 0 ? AnonymousClass1.INSTANCE : lVar, aVar);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: androidx.datastore.core.FileStorage$createConnection$2, reason: invalid class name */
    public static final class AnonymousClass2 extends m implements g7.a {
        final /* synthetic */ File $file;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(File file) {
            super(0);
            this.$file = file;
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public final void m40invoke() {
            Companion companion = FileStorage.Companion;
            Object activeFilesLock$datastore_core_release = companion.getActiveFilesLock$datastore_core_release();
            File file = this.$file;
            synchronized (activeFilesLock$datastore_core_release) {
                companion.getActiveFiles$datastore_core_release().remove(file.getAbsolutePath());
            }
        }

        @Override // g7.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m40invoke();
            return w.f12711a;
        }
    }
}
