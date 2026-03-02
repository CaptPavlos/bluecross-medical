package androidx.datastore.preferences.core;

import androidx.datastore.core.DataStore;
import g7.p;
import s6.a;
import s6.w;
import u7.h;
import w6.c;
import y6.e;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class PreferenceDataStore implements DataStore<Preferences> {
    private final DataStore<Preferences> delegate;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.datastore.preferences.core.PreferenceDataStore$updateData$2", f = "PreferenceDataStoreFactory.kt", l = {94}, m = "invokeSuspend")
    /* renamed from: androidx.datastore.preferences.core.PreferenceDataStore$updateData$2, reason: invalid class name */
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
            if (i10 == 0) {
                a.e(obj);
                Preferences preferences = (Preferences) this.L$0;
                p pVar = this.$transform;
                this.label = 1;
                obj = pVar.invoke(preferences, this);
                x6.a aVar = x6.a.f13718a;
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                a.e(obj);
            }
            Preferences preferences2 = (Preferences) obj;
            preferences2.getClass();
            ((MutablePreferences) preferences2).freeze$datastore_preferences_core_release();
            return preferences2;
        }
    }

    public PreferenceDataStore(DataStore<Preferences> dataStore) {
        dataStore.getClass();
        this.delegate = dataStore;
    }

    @Override // androidx.datastore.core.DataStore
    public h getData() {
        return this.delegate.getData();
    }

    @Override // androidx.datastore.core.DataStore
    public Object updateData(p pVar, c cVar) {
        return this.delegate.updateData(new AnonymousClass2(pVar, null), cVar);
    }
}
