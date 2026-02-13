package z5;

import android.widget.PopupWindow;
import g7.p;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class j implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f14437a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PopupWindow f14438b;

    public /* synthetic */ j(n nVar, PopupWindow popupWindow) {
        this.f14437a = nVar;
        this.f14438b = popupWindow;
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        Integer num = (Integer) obj;
        num.getClass();
        String str = (String) obj2;
        str.getClass();
        this.f14437a.f14447d.invoke(num, str);
        this.f14438b.dismiss();
        return w.f12711a;
    }
}
