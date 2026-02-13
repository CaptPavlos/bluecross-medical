package m8;

import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.mspa.USRegulationData;
import com.inmobi.cmp.model.ChoiceError;
import g7.l;
import kotlin.jvm.internal.m;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends m implements l {

    /* renamed from: a, reason: collision with root package name */
    public static final d f11248a = new d(1);

    @Override // g7.l
    public final Object invoke(Object obj) {
        w wVar;
        ChoiceCmpCallback callback;
        ChoiceCmpCallback callback2;
        USRegulationData uSRegulationData = (USRegulationData) obj;
        w wVar2 = w.f12711a;
        if (uSRegulationData == null || (callback2 = ChoiceCmp.INSTANCE.getCallback()) == null) {
            wVar = null;
        } else {
            callback2.onReceiveUSRegulationsConsent(uSRegulationData);
            wVar = wVar2;
        }
        if (wVar == null && (callback = ChoiceCmp.INSTANCE.getCallback()) != null) {
            callback.onCmpError(ChoiceError.ERROR_WHILE_SAVING_CONSENT);
        }
        return wVar2;
    }
}
