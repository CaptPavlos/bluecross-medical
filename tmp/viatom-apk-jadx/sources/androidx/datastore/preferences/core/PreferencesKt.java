package androidx.datastore.preferences.core;

import androidx.datastore.core.DataStore;
import g7.p;
import s6.a;
import s6.w;
import w6.c;
import y6.e;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class PreferencesKt {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.datastore.preferences.core.PreferencesKt$edit$2", f = "Preferences.kt", l = {358}, m = "invokeSuspend")
    /* renamed from: androidx.datastore.preferences.core.PreferencesKt$edit$2, reason: invalid class name */
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ p $transform;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(p pVar, c cVar) {
            super(2, cVar);
            this.$transform = pVar;
        }

        @Override // y6.a
        public final c create(Object obj, c cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$transform, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // g7.p
        public final Object invoke(Preferences preferences, c cVar) {
            return ((AnonymousClass2) create(preferences, cVar)).invokeSuspend(w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
                a.e(obj);
                return mutablePreferences;
            }
            a.e(obj);
            MutablePreferences mutablePreferences2 = ((Preferences) this.L$0).toMutablePreferences();
            p pVar = this.$transform;
            this.L$0 = mutablePreferences2;
            this.label = 1;
            Object objInvoke = pVar.invoke(mutablePreferences2, this);
            x6.a aVar = x6.a.f13718a;
            return objInvoke == aVar ? aVar : mutablePreferences2;
        }
    }

    public static final Object edit(DataStore<Preferences> dataStore, p pVar, c cVar) {
        return dataStore.updateData(new AnonymousClass2(pVar, null), cVar);
    }
}
