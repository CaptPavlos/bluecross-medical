package b;

import android.app.Activity;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.cmpapi.status.CmpStatus;
import com.inmobi.cmp.core.cmpapi.status.DisplayStatus;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.MyDownloads;
import com.uptodown.activities.RecommendedActivity;
import com.uptodown.activities.Updates;
import com.uptodown.activities.WishlistActivity;
import g7.p;
import n4.d1;
import n4.w0;
import r7.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class j extends y6.i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f795a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(int i10, w6.c cVar, int i11) {
        super(i10, cVar);
        this.f795a = i11;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f795a) {
            case 0:
                return new j(2, cVar, 0);
            default:
                return new j(2, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        w wVar = (w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f795a) {
            case 0:
                j jVar = new j(2, cVar, 0);
                s6.w wVar2 = s6.w.f12711a;
                jVar.invokeSuspend(wVar2);
                return wVar2;
            default:
                j jVar2 = (j) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                jVar2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        d1 d1Var;
        n4.b bVar;
        int i10 = this.f795a;
        s6.w wVar = s6.w.f12711a;
        switch (i10) {
            case 0:
                s6.a.e(obj);
                ChoiceCmp choiceCmp = ChoiceCmp.INSTANCE;
                i.a aVar = i.a.f8856a;
                choiceCmp.getClass();
                ChoiceCmpCallback callback = choiceCmp.getCallback();
                if (callback != null) {
                    callback.onCmpLoaded(choiceCmp.ping$app_release(true, CmpStatus.LOADED, DisplayStatus.HIDDEN));
                }
                if (i9.a.f9105a != null) {
                    choiceCmp.a(i9.a.b());
                    break;
                }
                break;
            default:
                s6.a.e(obj);
                Activity activity = o4.b.g;
                if (activity != null) {
                    if (!(activity instanceof Updates)) {
                        if (!(activity instanceof MyDownloads)) {
                            if (!(activity instanceof MyApps)) {
                                if (!(activity instanceof WishlistActivity)) {
                                    if ((activity instanceof RecommendedActivity) && (d1Var = ((RecommendedActivity) activity).W) != null) {
                                        d1Var.b();
                                        break;
                                    }
                                } else {
                                    d1 d1Var2 = ((WishlistActivity) activity).W;
                                    if (d1Var2 != null) {
                                        d1Var2.b();
                                        break;
                                    }
                                }
                            } else {
                                n4.p pVar = ((MyApps) activity).W;
                                if (pVar != null) {
                                    pVar.e = -1;
                                    break;
                                }
                            }
                        } else {
                            MyDownloads myDownloads = (MyDownloads) activity;
                            n4.b bVar2 = myDownloads.J;
                            Integer numValueOf = bVar2 != null ? Integer.valueOf(bVar2.e) : null;
                            if (numValueOf != null && numValueOf.intValue() >= 0 && (bVar = myDownloads.J) != null) {
                                bVar.notifyItemChanged(numValueOf.intValue());
                            }
                            n4.b bVar3 = myDownloads.J;
                            if (bVar3 != null) {
                                bVar3.e = -1;
                                break;
                            }
                        }
                    } else {
                        Updates updates = (Updates) activity;
                        w0 w0Var = updates.X;
                        if (w0Var != null) {
                            w0Var.g = -1;
                        }
                        UptodownApp.l0 = null;
                        updates.G0();
                        break;
                    }
                }
                break;
        }
        return wVar;
    }
}
