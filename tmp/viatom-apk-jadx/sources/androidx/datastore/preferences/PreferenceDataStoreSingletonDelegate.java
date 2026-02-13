package androidx.datastore.preferences;

import android.content.Context;
import androidx.annotation.GuardedBy;
import androidx.datastore.core.DataMigration;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.core.PreferenceDataStoreFactory;
import androidx.datastore.preferences.core.Preferences;
import g7.l;
import i7.a;
import java.util.List;
import m7.k;
import r7.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class PreferenceDataStoreSingletonDelegate implements a {

    @GuardedBy("lock")
    private volatile DataStore<Preferences> INSTANCE;
    private final ReplaceFileCorruptionHandler<Preferences> corruptionHandler;
    private final Object lock;
    private final String name;
    private final l produceMigrations;
    private final w scope;

    public PreferenceDataStoreSingletonDelegate(String str, ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, l lVar, w wVar) {
        str.getClass();
        lVar.getClass();
        wVar.getClass();
        this.name = str;
        this.corruptionHandler = replaceFileCorruptionHandler;
        this.produceMigrations = lVar;
        this.scope = wVar;
        this.lock = new Object();
    }

    @Override // i7.a
    public DataStore<Preferences> getValue(Context context, k kVar) {
        DataStore<Preferences> dataStore;
        context.getClass();
        kVar.getClass();
        DataStore<Preferences> dataStore2 = this.INSTANCE;
        if (dataStore2 != null) {
            return dataStore2;
        }
        synchronized (this.lock) {
            try {
                if (this.INSTANCE == null) {
                    Context applicationContext = context.getApplicationContext();
                    PreferenceDataStoreFactory preferenceDataStoreFactory = PreferenceDataStoreFactory.INSTANCE;
                    ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler = this.corruptionHandler;
                    l lVar = this.produceMigrations;
                    applicationContext.getClass();
                    this.INSTANCE = preferenceDataStoreFactory.create(replaceFileCorruptionHandler, (List<? extends DataMigration<Preferences>>) lVar.invoke(applicationContext), this.scope, new PreferenceDataStoreSingletonDelegate$getValue$1$1(applicationContext, this));
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
