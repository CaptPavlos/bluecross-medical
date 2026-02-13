package androidx.datastore.preferences;

import android.content.Context;
import androidx.datastore.core.DataMigration;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.core.Preferences;
import g7.l;
import i7.a;
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
public final class PreferenceDataStoreDelegateKt {
    public static final a preferencesDataStore(String str, ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, l lVar, w wVar) {
        str.getClass();
        lVar.getClass();
        wVar.getClass();
        return new PreferenceDataStoreSingletonDelegate(str, replaceFileCorruptionHandler, lVar, wVar);
    }

    public static a preferencesDataStore$default(String str, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, l lVar, w wVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i10 & 4) != 0) {
            lVar = AnonymousClass1.INSTANCE;
        }
        if ((i10 & 8) != 0) {
            e eVar = i0.f12407a;
            wVar = y.a(d.f14116a.plus(y.c()));
        }
        return preferencesDataStore(str, replaceFileCorruptionHandler, lVar, wVar);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: androidx.datastore.preferences.PreferenceDataStoreDelegateKt$preferencesDataStore$1, reason: invalid class name */
    public static final class AnonymousClass1 extends m implements l {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // g7.l
        public final List<DataMigration<Preferences>> invoke(Context context) {
            context.getClass();
            return t.f12808a;
        }
    }
}
