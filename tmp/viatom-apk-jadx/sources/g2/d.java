package g2;

import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import g7.p;
import s6.w;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends i implements p {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f8216a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Preferences.Key f8217b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Long f8218c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Preferences.Key key, Long l10, w6.c cVar) {
        super(2, cVar);
        this.f8217b = key;
        this.f8218c = l10;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        d dVar = new d(this.f8217b, this.f8218c, cVar);
        dVar.f8216a = obj;
        return dVar;
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        d dVar = (d) create((MutablePreferences) obj, (w6.c) obj2);
        w wVar = w.f12711a;
        dVar.invokeSuspend(wVar);
        return wVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        s6.a.e(obj);
        ((MutablePreferences) this.f8216a).set(this.f8217b, this.f8218c);
        return w.f12711a;
    }
}
