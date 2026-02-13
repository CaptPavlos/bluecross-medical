package g2;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKt;
import g7.p;
import r7.w;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e extends i implements p {

    /* renamed from: a, reason: collision with root package name */
    public int f8219a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f8220b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Preferences.Key f8221c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Long f8222d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(f fVar, Preferences.Key key, Long l10, w6.c cVar) {
        super(2, cVar);
        this.f8220b = fVar;
        this.f8221c = key;
        this.f8222d = l10;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        return new e(this.f8220b, this.f8221c, this.f8222d, cVar);
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((e) create((w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.f8219a;
        if (i10 != 0) {
            if (i10 == 1) {
                s6.a.e(obj);
                return obj;
            }
            androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        s6.a.e(obj);
        DataStore dataStore = this.f8220b.f8226c;
        d dVar = new d(this.f8221c, this.f8222d, null);
        this.f8219a = 1;
        Object objEdit = PreferencesKt.edit(dataStore, dVar, this);
        x6.a aVar = x6.a.f13718a;
        return objEdit == aVar ? aVar : objEdit;
    }
}
