package g2;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import androidx.datastore.preferences.SharedPreferencesMigrationKt;
import androidx.datastore.preferences.core.PreferencesFactory;
import com.google.android.gms.internal.measurement.a4;
import g7.l;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.y;
import m7.k;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ k[] f8223d;

    /* renamed from: a, reason: collision with root package name */
    public final String f8224a;

    /* renamed from: b, reason: collision with root package name */
    public final ThreadLocal f8225b;

    /* renamed from: c, reason: collision with root package name */
    public final DataStore f8226c;

    static {
        s sVar = new s(kotlin.jvm.internal.d.NO_RECEIVER, f.class, "dataStore", "getDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0);
        y.f10139a.getClass();
        f8223d = new k[]{sVar};
    }

    public f(Context context, String str) {
        context.getClass();
        this.f8224a = str;
        this.f8225b = new ThreadLocal();
        final int i10 = 0;
        final int i11 = 1;
        this.f8226c = (DataStore) PreferenceDataStoreDelegateKt.preferencesDataStore$default(str, new ReplaceFileCorruptionHandler(new l(this) { // from class: g2.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ f f8210b;

            {
                this.f8210b = this;
            }

            @Override // g7.l
            public final Object invoke(Object obj) {
                switch (i10) {
                    case 0:
                        CorruptionException corruptionException = (CorruptionException) obj;
                        corruptionException.getClass();
                        Log.w(y.a(f.class).c(), "CorruptionException in " + this.f8210b.f8224a + " DataStore running in process " + Process.myPid(), corruptionException);
                        return PreferencesFactory.createEmpty();
                    default:
                        Context context2 = (Context) obj;
                        context2.getClass();
                        return a4.u(SharedPreferencesMigrationKt.SharedPreferencesMigration$default(context2, this.f8210b.f8224a, null, 4, null));
                }
            }
        }), new l(this) { // from class: g2.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ f f8210b;

            {
                this.f8210b = this;
            }

            @Override // g7.l
            public final Object invoke(Object obj) {
                switch (i11) {
                    case 0:
                        CorruptionException corruptionException = (CorruptionException) obj;
                        corruptionException.getClass();
                        Log.w(y.a(f.class).c(), "CorruptionException in " + this.f8210b.f8224a + " DataStore running in process " + Process.myPid(), corruptionException);
                        return PreferencesFactory.createEmpty();
                    default:
                        Context context2 = (Context) obj;
                        context2.getClass();
                        return a4.u(SharedPreferencesMigrationKt.SharedPreferencesMigration$default(context2, this.f8210b.f8224a, null, 4, null));
                }
            }
        }, null, 8, null).getValue(context, f8223d[0]);
    }

    public final void a(l lVar) {
    }
}
