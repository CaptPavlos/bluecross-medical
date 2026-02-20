package j;

import androidx.lifecycle.ViewModel;
import c.h;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.portalconfig.GBCConsentValue;
import d0.i;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class c extends ViewModel {

    /* renamed from: a, reason: collision with root package name */
    public final i f9866a;

    /* renamed from: b, reason: collision with root package name */
    public final ChoiceCmpCallback f9867b;

    /* renamed from: c, reason: collision with root package name */
    public final n6.c f9868c;

    /* renamed from: d, reason: collision with root package name */
    public final o8.i f9869d;

    public c(i iVar, ChoiceCmpCallback choiceCmpCallback, n6.c cVar, o8.i iVar2) {
        this.f9866a = iVar;
        this.f9867b = choiceCmpCallback;
        this.f9868c = cVar;
        this.f9869d = iVar2;
    }

    public static GBCConsentValue a(String str, List list) {
        Object next;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((h) next).f964a.f10088a == g.d(str)) {
                break;
            }
        }
        h hVar = (h) next;
        return hVar == null ? GBCConsentValue.DENIED : l.a(hVar.f965b, Boolean.TRUE) ? GBCConsentValue.GRANTED : GBCConsentValue.DENIED;
    }
}
