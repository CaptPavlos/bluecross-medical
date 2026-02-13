package androidx.datastore.core;

import androidx.datastore.core.handlers.NoOpCorruptionHandler;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import com.google.android.gms.internal.measurement.a4;
import java.util.List;
import r7.i0;
import r7.w;
import r7.y;
import t6.t;
import y7.d;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class DataStoreFactory {
    public static final DataStoreFactory INSTANCE = new DataStoreFactory();

    private DataStoreFactory() {
    }

    public static DataStore create$default(DataStoreFactory dataStoreFactory, Serializer serializer, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, w wVar, g7.a aVar, int i10, Object obj) {
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
        return dataStoreFactory.create(serializer, replaceFileCorruptionHandler2, list2, wVar, aVar);
    }

    public final <T> DataStore<T> create(Storage<T> storage, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, List<? extends DataMigration<T>> list, w wVar) {
        storage.getClass();
        list.getClass();
        wVar.getClass();
        if (replaceFileCorruptionHandler == null) {
            replaceFileCorruptionHandler = (ReplaceFileCorruptionHandler<T>) new NoOpCorruptionHandler();
        }
        return new DataStoreImpl(storage, a4.u(DataMigrationInitializer.Companion.getInitializer(list)), replaceFileCorruptionHandler, wVar);
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

    public final <T> DataStore<T> create(Serializer<T> serializer, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, List<? extends DataMigration<T>> list, w wVar, g7.a aVar) {
        serializer.getClass();
        list.getClass();
        wVar.getClass();
        aVar.getClass();
        return create(new FileStorage(serializer, null, aVar, 2, null), replaceFileCorruptionHandler, list, wVar);
    }

    public final <T> DataStore<T> create(Serializer<T> serializer, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, g7.a aVar) {
        serializer.getClass();
        aVar.getClass();
        return create$default(this, serializer, replaceFileCorruptionHandler, null, null, aVar, 12, null);
    }

    public static /* synthetic */ DataStore create$default(DataStoreFactory dataStoreFactory, Storage storage, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, w wVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i10 & 4) != 0) {
            list = t.f12808a;
        }
        if ((i10 & 8) != 0) {
            wVar = y.a(Actual_jvmKt.ioDispatcher().plus(y.c()));
        }
        return dataStoreFactory.create(storage, replaceFileCorruptionHandler, list, wVar);
    }
}
