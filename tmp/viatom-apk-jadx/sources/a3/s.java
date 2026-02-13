package a3;

import android.content.Intent;
import android.util.Log;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.room.AmbiguousColumnResolver;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomConnectionManager;
import androidx.room.RoomRawQuery;
import androidx.room.RoomSQLiteQuery;
import androidx.room.support.AutoClosingRoomOpenHelper;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.WorkQuery;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.StatusRunnable;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MyDownloads;
import j$.util.DesugarCollections;
import j$.util.Objects;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class s implements g7.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f159a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f160b;

    public /* synthetic */ s(Object obj, int i10) {
        this.f159a = i10;
        this.f160b = obj;
    }

    @Override // g7.l
    public final Object invoke(Object obj) {
        int i10 = this.f159a;
        s6.w wVar = s6.w.f12711a;
        Object obj2 = this.f160b;
        switch (i10) {
            case 0:
                CorruptionException corruptionException = (CorruptionException) obj;
                corruptionException.getClass();
                Log.w("FirebaseSessions", "CorruptionException in session data DataStore", corruptionException);
                return new o0(((p0) obj2).f151a.a(null), null, null);
            case 1:
                return AmbiguousColumnResolver.resolve$lambda$19((kotlin.jvm.internal.x) obj2, (List) obj);
            case 2:
                return CoroutinesRoom.Companion.createFlow$lambda$1((Callable) obj2, (SQLiteConnection) obj);
            case 3:
                return RoomConnectionManager._init_$lambda$1((RoomConnectionManager) obj2, (SupportSQLiteDatabase) obj);
            case 4:
                return RoomRawQuery.bindingFunction$lambda$1((g7.l) obj2, (SQLiteStatement) obj);
            case 5:
                return RoomSQLiteQuery.toRoomRawQuery$lambda$1((RoomSQLiteQuery) obj2, (SQLiteStatement) obj);
            case 6:
                return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.setLocale$lambda$10((Locale) obj2, (SupportSQLiteDatabase) obj);
            case 7:
                return StatusRunnable.forUUID$lambda$1((UUID) obj2, (WorkDatabase) obj);
            case 8:
                return StatusRunnable.forWorkQuerySpec$lambda$4((WorkQuery) obj2, (WorkDatabase) obj);
            case 9:
                return StatusRunnable.forStringIds$lambda$0((List) obj2, (WorkDatabase) obj);
            case 10:
                e8.a aVar = (e8.a) obj;
                aVar.getClass();
                e8.a.a(aVar, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, g8.b1.f8242b);
                e8.a.a(aVar, "value", a.a.k("kotlinx.serialization.Polymorphic<" + ((kotlin.jvm.internal.f) ((c8.d) obj2).f1816a).c() + '>', e8.g.f7971c, new e8.e[0]));
                return wVar;
            case 11:
                e8.f fVar = (e8.f) obj2;
                int iIntValue = ((Integer) obj).intValue();
                return fVar.e[iIntValue] + ": " + fVar.f[iIntValue].a();
            case 12:
                g8.q0 q0Var = (g8.q0) obj2;
                int iIntValue2 = ((Integer) obj).intValue();
                return q0Var.e[iIntValue2] + ": " + q0Var.h(iIntValue2).a();
            case 13:
                e4.e eVar = (e4.e) obj;
                eVar.getClass();
                ((i4.g) eVar).a((f4.a) obj2);
                return wVar;
            case 14:
                MainActivity mainActivity = (MainActivity) obj2;
                int i11 = MainActivity.B0;
                Intent intent = new Intent(mainActivity, (Class<?>) MyDownloads.class);
                float f = UptodownApp.E;
                mainActivity.startActivity(intent, k4.c.a(mainActivity));
                return wVar;
            case 15:
                o2.i iVar = (o2.i) obj2;
                MutablePreferences mutablePreferences = (MutablePreferences) obj;
                Preferences.Key key = o2.i.f11706c;
                Iterator<Map.Entry<Preferences.Key<?>, Object>> it = mutablePreferences.asMap().entrySet().iterator();
                long j10 = 0;
                while (true) {
                    if (it.hasNext()) {
                        Map.Entry<Preferences.Key<?>, Object> next = it.next();
                        if (next.getValue() instanceof Set) {
                            Preferences.Key<?> key2 = next.getKey();
                            Set set = (Set) next.getValue();
                            String strD = iVar.d(System.currentTimeMillis());
                            if (set.contains(strD)) {
                                Object[] objArr = {strD};
                                HashSet hashSet = new HashSet(1);
                                Object obj3 = objArr[0];
                                Objects.requireNonNull(obj3);
                                if (hashSet.add(obj3)) {
                                    mutablePreferences.set(key2, DesugarCollections.unmodifiableSet(hashSet));
                                    j10++;
                                } else {
                                    androidx.window.layout.c.j(obj3, "duplicate element: ");
                                }
                            } else {
                                mutablePreferences.remove(key2);
                            }
                        }
                    } else if (j10 == 0) {
                        mutablePreferences.remove(key);
                    } else {
                        mutablePreferences.set(key, Long.valueOf(j10));
                    }
                }
                return null;
            default:
                return obj == ((t6.a) obj2) ? "(this Collection)" : String.valueOf(obj);
        }
    }
}
