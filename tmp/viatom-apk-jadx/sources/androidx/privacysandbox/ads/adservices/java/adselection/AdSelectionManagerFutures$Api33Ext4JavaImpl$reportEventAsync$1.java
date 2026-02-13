package androidx.privacysandbox.ads.adservices.java.adselection;

import androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager;
import androidx.privacysandbox.ads.adservices.adselection.ReportEventRequest;
import androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures;
import g7.p;
import r7.w;
import s6.a;
import w6.c;
import y6.e;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@e(c = "androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures$Api33Ext4JavaImpl$reportEventAsync$1", f = "AdSelectionManagerFutures.kt", l = {350}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AdSelectionManagerFutures$Api33Ext4JavaImpl$reportEventAsync$1 extends i implements p {
    final /* synthetic */ ReportEventRequest $reportEventRequest;
    int label;
    final /* synthetic */ AdSelectionManagerFutures.Api33Ext4JavaImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdSelectionManagerFutures$Api33Ext4JavaImpl$reportEventAsync$1(AdSelectionManagerFutures.Api33Ext4JavaImpl api33Ext4JavaImpl, ReportEventRequest reportEventRequest, c cVar) {
        super(2, cVar);
        this.this$0 = api33Ext4JavaImpl;
        this.$reportEventRequest = reportEventRequest;
    }

    @Override // y6.a
    public final c create(Object obj, c cVar) {
        return new AdSelectionManagerFutures$Api33Ext4JavaImpl$reportEventAsync$1(this.this$0, this.$reportEventRequest, cVar);
    }

    @Override // g7.p
    public final Object invoke(w wVar, c cVar) {
        return ((AdSelectionManagerFutures$Api33Ext4JavaImpl$reportEventAsync$1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.label;
        if (i10 == 0) {
            a.e(obj);
            AdSelectionManager adSelectionManager = this.this$0.mAdSelectionManager;
            adSelectionManager.getClass();
            ReportEventRequest reportEventRequest = this.$reportEventRequest;
            this.label = 1;
            Object objReportEvent = adSelectionManager.reportEvent(reportEventRequest, this);
            x6.a aVar = x6.a.f13718a;
            if (objReportEvent == aVar) {
                return aVar;
            }
        } else {
            if (i10 != 1) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            a.e(obj);
        }
        return s6.w.f12711a;
    }
}
