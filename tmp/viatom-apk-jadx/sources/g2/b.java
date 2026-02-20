package g2;

import androidx.datastore.preferences.core.Preferences;
import g7.p;
import java.util.Map;
import r7.w;
import t6.u;
import u7.h;
import u7.i0;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends i implements p {

    /* renamed from: a, reason: collision with root package name */
    public int f8211a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f8212b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar, w6.c cVar) {
        super(2, cVar);
        this.f8212b = fVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        return new b(this.f8212b, cVar);
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((b) create((w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        Map<Preferences.Key<?>, Object> mapAsMap;
        int i10 = this.f8211a;
        if (i10 == 0) {
            s6.a.e(obj);
            h data = this.f8212b.f8226c.getData();
            this.f8211a = 1;
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
        return (preferences == null || (mapAsMap = preferences.asMap()) == null) ? u.f12809a : mapAsMap;
    }
}
