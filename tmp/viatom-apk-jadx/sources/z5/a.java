package z5;

import android.app.NotificationManager;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import h5.q;
import h5.r;
import java.util.Iterator;
import l4.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14405a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w f14406b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d f14407c;

    public /* synthetic */ a(w wVar, d dVar) {
        this.f14405a = 1;
        this.f14406b = wVar;
        this.f14407c = dVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f14405a) {
            case 0:
                d dVar = this.f14407c;
                h5.h hVar = dVar.f14413a;
                RelativeLayout relativeLayout = dVar.f14414b;
                boolean zD = a.a.D(hVar.f8566a);
                String str = hVar.f8595w;
                if (zD) {
                    str.getClass();
                    a.a.l(str);
                    Context context = relativeLayout.getContext();
                    context.getClass();
                    Object systemService = context.getSystemService("notification");
                    systemService.getClass();
                    ((NotificationManager) systemService).cancel(261);
                } else {
                    str.getClass();
                    if (a.a.F(str)) {
                        String str2 = hVar.f8595w;
                        str2.getClass();
                        a.a.l(str2);
                    } else {
                        t3.h hVar2 = v5.g.f13148u;
                        Context context2 = relativeLayout.getContext();
                        context2.getClass();
                        v5.g gVarL = hVar2.l(context2);
                        gVarL.a();
                        q qVarY = gVarL.y(String.valueOf(hVar.A));
                        if (qVarY != null) {
                            if (qVarY.o()) {
                                gVarL.j(qVarY);
                            } else {
                                Iterator it = qVarY.f8716v.iterator();
                                it.getClass();
                                while (it.hasNext()) {
                                    Object next = it.next();
                                    next.getClass();
                                    r rVar = (r) next;
                                    rVar.f = 0L;
                                    rVar.f8724i = 0;
                                    gVarL.e0(rVar);
                                }
                            }
                        }
                        gVarL.b();
                    }
                }
                dVar.b(this.f14406b);
                break;
            case 1:
                Context context3 = view.getContext();
                context3.getClass();
                d dVar2 = this.f14407c;
                h5.h hVar3 = dVar2.f14413a;
                w wVar = this.f14406b;
                l1.b.h(context3, wVar, hVar3, new c(dVar2, wVar, 1), true);
                break;
            default:
                this.f14407c.b(this.f14406b);
                break;
        }
    }

    public /* synthetic */ a(d dVar, w wVar, int i10) {
        this.f14405a = i10;
        this.f14407c = dVar;
        this.f14406b = wVar;
    }
}
