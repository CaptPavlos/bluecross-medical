package b;

import b9.s;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.core.model.Vector;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import g7.p;
import java.util.ArrayList;
import java.util.UUID;
import kotlin.jvm.internal.u;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class l extends y6.i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f796a;

    /* renamed from: b, reason: collision with root package name */
    public int f797b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(int i10, w6.c cVar, int i11) {
        super(i10, cVar);
        this.f796a = i11;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f796a) {
            case 0:
                return new l(2, cVar, 0);
            case 1:
                return new l(2, cVar, 1);
            default:
                return new l(2, cVar, 2);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        w6.c cVar = (w6.c) obj2;
        switch (this.f796a) {
            case 0:
                return new l(2, cVar, 0).invokeSuspend(w.f12711a);
            case 1:
                return new l(2, cVar, 1).invokeSuspend(w.f12711a);
            default:
                return new l(2, cVar, 2).invokeSuspend(w.f12711a);
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        String str;
        int i10 = this.f796a;
        x6.a aVar = x6.a.f13718a;
        w wVar = w.f12711a;
        switch (i10) {
            case 0:
                int i11 = this.f797b;
                if (i11 == 0) {
                    s6.a.e(obj);
                    ChoiceCmp choiceCmp = ChoiceCmp.INSTANCE;
                    this.f797b = 1;
                    if (ChoiceCmp.access$showCMP(choiceCmp, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i11 != 1) {
                        androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    s6.a.e(obj);
                }
                return wVar;
            case 1:
                int i12 = this.f797b;
                if (i12 == 0) {
                    s6.a.e(obj);
                    ChoiceCmp choiceCmp2 = ChoiceCmp.INSTANCE;
                    this.f797b = 1;
                    if (ChoiceCmp.access$loadCmpInfo(choiceCmp2, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i12 != 1) {
                        androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    s6.a.e(obj);
                }
                return wVar;
            default:
                int i13 = this.f797b;
                if (i13 == 0) {
                    s6.a.e(obj);
                    UUID uuid = s.f936a;
                    this.f797b = 1;
                    b9.h hVar = s.f937b;
                    hVar.h("Confirm", CampaignEx.JSON_NATIVE_VIDEO_CLICK);
                    ArrayList arrayList = (ArrayList) hVar.h;
                    boolean z9 = j.g.f9878a;
                    ArrayList arrayList2 = new ArrayList();
                    Vector vector = j.g.f9879b;
                    vector.forEach(new j.e(arrayList2, 0));
                    u uVar = new u();
                    uVar.f10135a = true;
                    vector.forEach(new j.f(uVar, 0));
                    if (uVar.f10135a) {
                        str = "All";
                    } else {
                        u uVar2 = new u();
                        uVar2.f10135a = true;
                        vector.forEach(new j.f(uVar2, 1));
                        str = uVar2.f10135a ? "Reject" : "Partial";
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.addAll(arrayList);
                    b9.m mVar = new b9.m(arrayList3, arrayList2, str);
                    arrayList.clear();
                    ((d0.i) hVar.f).p(93, str);
                    Object objB = hVar.b(3, mVar, b9.d.NR, this);
                    if (objB != aVar) {
                        objB = wVar;
                    }
                    if (objB == aVar) {
                        return aVar;
                    }
                } else {
                    if (i13 != 1) {
                        androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    s6.a.e(obj);
                }
                return wVar;
        }
    }
}
