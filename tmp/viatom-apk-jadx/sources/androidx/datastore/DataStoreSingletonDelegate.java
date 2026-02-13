package androidx.datastore;

import android.content.Context;
import androidx.annotation.GuardedBy;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.core.okio.OkioSerializer;
import androidx.datastore.core.okio.OkioStorage;
import g7.l;
import i7.a;
import java.util.List;
import m7.k;
import r7.w;
import z8.p;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class DataStoreSingletonDelegate<T> implements a {

    @GuardedBy("lock")
    private volatile DataStore<T> INSTANCE;
    private final ReplaceFileCorruptionHandler<T> corruptionHandler;
    private final String fileName;
    private final Object lock;
    private final l produceMigrations;
    private final w scope;
    private final OkioSerializer<T> serializer;

    public DataStoreSingletonDelegate(String str, OkioSerializer<T> okioSerializer, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, l lVar, w wVar) {
        str.getClass();
        okioSerializer.getClass();
        lVar.getClass();
        wVar.getClass();
        this.fileName = str;
        this.serializer = okioSerializer;
        this.corruptionHandler = replaceFileCorruptionHandler;
        this.produceMigrations = lVar;
        this.scope = wVar;
        this.lock = new Object();
    }

    @Override // i7.a
    public DataStore<T> getValue(Context context, k kVar) {
        DataStore<T> dataStore;
        context.getClass();
        kVar.getClass();
        DataStore<T> dataStore2 = this.INSTANCE;
        if (dataStore2 != null) {
            return dataStore2;
        }
        synchronized (this.lock) {
            try {
                if (this.INSTANCE == null) {
                    Context applicationContext = context.getApplicationContext();
                    DataStoreFactory dataStoreFactory = DataStoreFactory.INSTANCE;
                    OkioStorage okioStorage = new OkioStorage(p.f14501a, this.serializer, null, new DataStoreSingletonDelegate$getValue$1$1(applicationContext, this), 4, null);
                    ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler = this.corruptionHandler;
                    l lVar = this.produceMigrations;
                    applicationContext.getClass();
                    this.INSTANCE = dataStoreFactory.create(okioStorage, replaceFileCorruptionHandler, (List) lVar.invoke(applicationContext), this.scope);
                }
                dataStore = this.INSTANCE;
                dataStore.getClass();
            } catch (Throwable th) {
                throw th;
            }
        }
        return dataStore;
    }
}
