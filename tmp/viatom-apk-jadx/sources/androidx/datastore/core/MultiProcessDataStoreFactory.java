package androidx.datastore.core;

import androidx.datastore.core.handlers.NoOpCorruptionHandler;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import com.google.android.gms.internal.measurement.a4;
import g7.l;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.m;
import r7.i0;
import r7.w;
import r7.y;
import t6.t;
import y7.d;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class MultiProcessDataStoreFactory {
    public static final MultiProcessDataStoreFactory INSTANCE = new MultiProcessDataStoreFactory();

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: androidx.datastore.core.MultiProcessDataStoreFactory$create$1, reason: invalid class name */
    public static final class AnonymousClass1 extends m implements l {
        final /* synthetic */ w $scope;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(w wVar) {
            super(1);
            this.$scope = wVar;
        }

        @Override // g7.l
        public final InterProcessCoordinator invoke(File file) {
            file.getClass();
            return new MultiProcessCoordinator(this.$scope.getCoroutineContext(), file);
        }
    }

    private MultiProcessDataStoreFactory() {
    }

    public static DataStore create$default(MultiProcessDataStoreFactory multiProcessDataStoreFactory, Serializer serializer, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, w wVar, g7.a aVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            replaceFileCorruptionHandler = null;
        }
        ReplaceFileCorruptionHandler replaceFileCorruptionHandler2 = replaceFileCorruptionHandler;
        if ((i10 & 4) != 0) {
            list = t.f12808a;
        }
        List list2 = list;
        if ((i10 & 8) != 0) {
            e eVar = i0.f12407a;
            wVar = y.a(d.f14116a.plus(y.c()));
        }
        return multiProcessDataStoreFactory.create(serializer, replaceFileCorruptionHandler2, list2, wVar, aVar);
    }

    public final <T> DataStore<T> create(Serializer<T> serializer, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, List<? extends DataMigration<T>> list, w wVar, g7.a aVar) {
        serializer.getClass();
        list.getClass();
        wVar.getClass();
        aVar.getClass();
        FileStorage fileStorage = new FileStorage(serializer, new AnonymousClass1(wVar), aVar);
        List listU = a4.u(DataMigrationInitializer.Companion.getInitializer(list));
        if (replaceFileCorruptionHandler == null) {
            replaceFileCorruptionHandler = (ReplaceFileCorruptionHandler<T>) new NoOpCorruptionHandler();
        }
        return new DataStoreImpl(fileStorage, listU, replaceFileCorruptionHandler, wVar);
    }

    public static DataStore create$default(MultiProcessDataStoreFactory multiProcessDataStoreFactory, Storage storage, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, w wVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i10 & 4) != 0) {
            list = t.f12808a;
        }
        if ((i10 & 8) != 0) {
            e eVar = i0.f12407a;
            wVar = y.a(d.f14116a.plus(y.c()));
        }
        return multiProcessDataStoreFactory.create(storage, replaceFileCorruptionHandler, list, wVar);
    }

    public final <T> DataStore<T> create(Serializer<T> serializer, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, List<? extends DataMigration<T>> list, g7.a aVar) {
        serializer.getClass();
        list.getClass();
        aVar.getClass();
        return create$default(this, serializer, replaceFileCorruptionHandler, list, null, aVar, 8, null);
    }

    public final <T> DataStore<T> create(Serializer<T> serializer, g7.a aVar) {
        serializer.getClass();
        aVar.getClass();
        return create$default(this, serializer, null, null, null, aVar, 14, null);
    }

    public final <T> DataStore<T> create(Storage<T> storage) {
        storage.getClass();
        return create$default(this, storage, null, null, null, 14, null);
    }

    public final <T> DataStore<T> create(Storage<T> storage, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler) {
        storage.getClass();
        return create$default(this, storage, replaceFileCorruptionHandler, null, null, 12, null);
    }

    public final <T> DataStore<T> create(Storage<T> storage, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, List<? extends DataMigration<T>> list) {
        storage.getClass();
        list.getClass();
        return create$default(this, storage, replaceFileCorruptionHandler, list, null, 8, null);
    }

    public final <T> DataStore<T> create(Storage<T> storage, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, List<? extends DataMigration<T>> list, w wVar) {
        storage.getClass();
        list.getClass();
        wVar.getClass();
        List listU = a4.u(DataMigrationInitializer.Companion.getInitializer(list));
        if (replaceFileCorruptionHandler == null) {
            replaceFileCorruptionHandler = (ReplaceFileCorruptionHandler<T>) new NoOpCorruptionHandler();
        }
        return new DataStoreImpl(storage, listU, replaceFileCorruptionHandler, wVar);
    }

    public final <T> DataStore<T> create(Serializer<T> serializer, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, g7.a aVar) {
        serializer.getClass();
        aVar.getClass();
        return create$default(this, serializer, replaceFileCorruptionHandler, null, null, aVar, 12, null);
    }
}
