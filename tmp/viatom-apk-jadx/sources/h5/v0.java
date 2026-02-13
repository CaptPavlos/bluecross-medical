package h5;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class v0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f8777a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f8778b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8779c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f8780d;
    public final String e;
    public final boolean f;
    public final int g;

    public v0(Context context) {
        context.getClass();
        this.f8777a = t1.A(context, "Language");
        this.f8778b = v5.i.a(context);
        this.f8779c = t1.x(context);
        this.f8780d = t1.r(context, "only_wifi", true);
        this.e = t1.B(context, "download_updates_options", "2");
        this.f = t1.r(context, "install_apk_rooted", false);
        this.g = TypedValues.TransitionType.TYPE_AUTO_TRANSITION;
    }

    public final Object a(Context context, p pVar, y6.c cVar) throws Throwable {
        a3.x xVar = new a3.x(context, pVar, this);
        y7.e eVar = r7.i0.f12407a;
        Object objZ = r7.y.z(new a6.n(xVar, null, 11), y7.d.f14116a, cVar);
        s6.w wVar = s6.w.f12711a;
        x6.a aVar = x6.a.f13718a;
        if (objZ != aVar) {
            objZ = wVar;
        }
        return objZ == aVar ? objZ : wVar;
    }
}
