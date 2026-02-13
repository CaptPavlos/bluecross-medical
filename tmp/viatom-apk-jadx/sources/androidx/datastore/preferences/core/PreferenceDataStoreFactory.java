package androidx.datastore.preferences.core;

import androidx.datastore.core.DataMigration;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;
import androidx.datastore.core.FileStorage;
import androidx.datastore.core.Storage;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import g7.a;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.m;
import r7.i0;
import r7.w;
import r7.y;
import t6.t;
import y7.d;
import y7.e;
import z8.z;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class PreferenceDataStoreFactory {
    public static final PreferenceDataStoreFactory INSTANCE = new PreferenceDataStoreFactory();

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: androidx.datastore.preferences.core.PreferenceDataStoreFactory$createWithPath$1, reason: invalid class name */
    public static final class AnonymousClass1 extends m implements a {
        final /* synthetic */ a $produceFile;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(a aVar) {
            super(0);
            this.$produceFile = aVar;
        }

        @Override // g7.a
        public final File invoke() {
            return ((z) this.$produceFile.invoke()).toFile();
        }
    }

    private PreferenceDataStoreFactory() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DataStore create$default(PreferenceDataStoreFactory preferenceDataStoreFactory, Storage storage, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, w wVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i10 & 4) != 0) {
            list = t.f12808a;
        }
        if ((i10 & 8) != 0) {
            wVar = y.a(Actual_jvmAndroidKt.ioDispatcher().plus(y.c()));
        }
        return preferenceDataStoreFactory.create((Storage<Preferences>) storage, (ReplaceFileCorruptionHandler<Preferences>) replaceFileCorruptionHandler, (List<? extends DataMigration<Preferences>>) list, wVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DataStore createWithPath$default(PreferenceDataStoreFactory preferenceDataStoreFactory, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, w wVar, a aVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i10 & 2) != 0) {
            list = t.f12808a;
        }
        if ((i10 & 4) != 0) {
            wVar = y.a(Actual_jvmAndroidKt.ioDispatcher().plus(y.c()));
        }
        return preferenceDataStoreFactory.createWithPath(replaceFileCorruptionHandler, list, wVar, aVar);
    }

    public final DataStore<Preferences> create(ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, List<? extends DataMigration<Preferences>> list, w wVar, a aVar) {
        list.getClass();
        wVar.getClass();
        aVar.getClass();
        return new PreferenceDataStore(create(new FileStorage(PreferencesFileSerializer.INSTANCE, null, new PreferenceDataStoreFactory$create$delegate$1(aVar), 2, null), replaceFileCorruptionHandler, list, wVar));
    }

    public final DataStore<Preferences> createWithPath(ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, List<? extends DataMigration<Preferences>> list, w wVar, a aVar) {
        list.getClass();
        wVar.getClass();
        aVar.getClass();
        return create(replaceFileCorruptionHandler, list, wVar, new AnonymousClass1(aVar));
    }

    public final DataStore<Preferences> createWithPath(ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, List<? extends DataMigration<Preferences>> list, a aVar) {
        list.getClass();
        aVar.getClass();
        return createWithPath$default(this, replaceFileCorruptionHandler, list, null, aVar, 4, null);
    }

    public final DataStore<Preferences> createWithPath(a aVar) {
        aVar.getClass();
        return createWithPath$default(this, null, null, null, aVar, 7, null);
    }

    public final DataStore<Preferences> createWithPath(ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, a aVar) {
        aVar.getClass();
        return createWithPath$default(this, replaceFileCorruptionHandler, null, null, aVar, 6, null);
    }

    public final DataStore<Preferences> create(Storage<Preferences> storage, ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler) {
        storage.getClass();
        return create$default(this, storage, replaceFileCorruptionHandler, (List) null, (w) null, 12, (Object) null);
    }

    public final DataStore<Preferences> create(Storage<Preferences> storage, ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, List<? extends DataMigration<Preferences>> list) {
        storage.getClass();
        list.getClass();
        return create$default(this, storage, replaceFileCorruptionHandler, list, (w) null, 8, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static DataStore create$default(PreferenceDataStoreFactory preferenceDataStoreFactory, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, w wVar, a aVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i10 & 2) != 0) {
            list = t.f12808a;
        }
        if ((i10 & 4) != 0) {
            e eVar = i0.f12407a;
            wVar = y.a(d.f14116a.plus(y.c()));
        }
        return preferenceDataStoreFactory.create((ReplaceFileCorruptionHandler<Preferences>) replaceFileCorruptionHandler, (List<? extends DataMigration<Preferences>>) list, wVar, aVar);
    }

    public final DataStore<Preferences> create(ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, a aVar) {
        aVar.getClass();
        return create$default(this, replaceFileCorruptionHandler, (List) null, (w) null, aVar, 6, (Object) null);
    }

    public final DataStore<Preferences> create(ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, List<? extends DataMigration<Preferences>> list, a aVar) {
        list.getClass();
        aVar.getClass();
        return create$default(this, replaceFileCorruptionHandler, list, (w) null, aVar, 4, (Object) null);
    }

    public final DataStore<Preferences> create(a aVar) {
        aVar.getClass();
        return create$default(this, (ReplaceFileCorruptionHandler) null, (List) null, (w) null, aVar, 7, (Object) null);
    }

    public final DataStore<Preferences> create(Storage<Preferences> storage) {
        storage.getClass();
        return create$default(this, storage, (ReplaceFileCorruptionHandler) null, (List) null, (w) null, 14, (Object) null);
    }

    public final DataStore<Preferences> create(Storage<Preferences> storage, ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, List<? extends DataMigration<Preferences>> list, w wVar) {
        storage.getClass();
        list.getClass();
        wVar.getClass();
        return new PreferenceDataStore(DataStoreFactory.INSTANCE.create(storage, replaceFileCorruptionHandler, list, wVar));
    }
}
