package g2;

import androidx.datastore.preferences.core.Preferences;
import g7.p;
import r7.w;
import u7.h;
import u7.i0;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends i implements p {

    /* renamed from: a, reason: collision with root package name */
    public int f8213a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f8214b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Preferences.Key f8215c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(f fVar, Preferences.Key key, w6.c cVar) {
        super(2, cVar);
        this.f8214b = fVar;
        this.f8215c = key;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        return new c(this.f8214b, this.f8215c, cVar);
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((c) create((w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        int i10 = this.f8213a;
        if (i10 == 0) {
            s6.a.e(obj);
            h data = this.f8214b.f8226c.getData();
            this.f8213a = 1;
            obj = i0.j(data, this);
            x6.a aVar = x6.a.f13718a;
            if (obj == aVar) {
                return aVar;
            }
        } else {
            if (i10 != 1) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
        }
        Preferences preferences = (Preferences) obj;
        if (preferences == null || (obj2 = preferences.get(this.f8215c)) == null) {
            return -1L;
        }
        return obj2;
    }
}
