package c6;

import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.mspa.USRegulationData;
import com.inmobi.cmp.model.ChoiceError;
import g7.l;
import kotlin.jvm.internal.m;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g extends m implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1807a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f1808b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(h hVar, int i10) {
        super(1);
        this.f1807a = i10;
        this.f1808b = hVar;
    }

    @Override // g7.l
    public final Object invoke(Object obj) {
        w wVar;
        w wVar2;
        switch (this.f1807a) {
            case 0:
                USRegulationData uSRegulationData = (USRegulationData) obj;
                ChoiceCmpCallback choiceCmpCallback = this.f1808b.f1811c;
                o8.c cVar = i9.a.h().f11814b;
                String str = cVar.U;
                if (str != null) {
                    i9.a.j().p(86, str);
                }
                i9.a.j().p(87, cVar.f11788o);
                i9.a.j().q(88, j.g.f9878a);
                w wVar3 = w.f12711a;
                if (uSRegulationData == null || choiceCmpCallback == null) {
                    wVar = null;
                } else {
                    choiceCmpCallback.onReceiveUSRegulationsConsent(uSRegulationData);
                    wVar = wVar3;
                }
                if (wVar == null && choiceCmpCallback != null) {
                    choiceCmpCallback.onCmpError(ChoiceError.ERROR_WHILE_SAVING_CONSENT);
                }
                return wVar3;
            default:
                ChoiceCmpCallback choiceCmpCallback2 = this.f1808b.f1811c;
                USRegulationData uSRegulationData2 = (USRegulationData) obj;
                w wVar4 = w.f12711a;
                if (uSRegulationData2 == null || choiceCmpCallback2 == null) {
                    wVar2 = null;
                } else {
                    choiceCmpCallback2.onReceiveUSRegulationsConsent(uSRegulationData2);
                    wVar2 = wVar4;
                }
                if (wVar2 == null && choiceCmpCallback2 != null) {
                    choiceCmpCallback2.onCmpError(ChoiceError.ERROR_WHILE_SAVING_CONSENT);
                }
                return wVar4;
        }
    }
}
