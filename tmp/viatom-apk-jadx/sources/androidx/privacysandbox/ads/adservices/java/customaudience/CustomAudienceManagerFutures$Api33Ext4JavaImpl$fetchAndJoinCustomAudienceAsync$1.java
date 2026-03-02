package androidx.privacysandbox.ads.adservices.java.customaudience;

import androidx.privacysandbox.ads.adservices.customaudience.CustomAudienceManager;
import androidx.privacysandbox.ads.adservices.customaudience.FetchAndJoinCustomAudienceRequest;
import androidx.privacysandbox.ads.adservices.java.customaudience.CustomAudienceManagerFutures;
import g7.p;
import r7.w;
import s6.a;
import w6.c;
import y6.e;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@e(c = "androidx.privacysandbox.ads.adservices.java.customaudience.CustomAudienceManagerFutures$Api33Ext4JavaImpl$fetchAndJoinCustomAudienceAsync$1", f = "CustomAudienceManagerFutures.kt", l = {156}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class CustomAudienceManagerFutures$Api33Ext4JavaImpl$fetchAndJoinCustomAudienceAsync$1 extends i implements p {
    final /* synthetic */ FetchAndJoinCustomAudienceRequest $request;
    int label;
    final /* synthetic */ CustomAudienceManagerFutures.Api33Ext4JavaImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomAudienceManagerFutures$Api33Ext4JavaImpl$fetchAndJoinCustomAudienceAsync$1(CustomAudienceManagerFutures.Api33Ext4JavaImpl api33Ext4JavaImpl, FetchAndJoinCustomAudienceRequest fetchAndJoinCustomAudienceRequest, c cVar) {
        super(2, cVar);
        this.this$0 = api33Ext4JavaImpl;
        this.$request = fetchAndJoinCustomAudienceRequest;
    }

    @Override // y6.a
    public final c create(Object obj, c cVar) {
        return new CustomAudienceManagerFutures$Api33Ext4JavaImpl$fetchAndJoinCustomAudienceAsync$1(this.this$0, this.$request, cVar);
    }

    @Override // g7.p
    public final Object invoke(w wVar, c cVar) {
        return ((CustomAudienceManagerFutures$Api33Ext4JavaImpl$fetchAndJoinCustomAudienceAsync$1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.label;
        if (i10 == 0) {
            a.e(obj);
            CustomAudienceManager customAudienceManager = this.this$0.mCustomAudienceManager;
            customAudienceManager.getClass();
            FetchAndJoinCustomAudienceRequest fetchAndJoinCustomAudienceRequest = this.$request;
            this.label = 1;
            Object objFetchAndJoinCustomAudience = customAudienceManager.fetchAndJoinCustomAudience(fetchAndJoinCustomAudienceRequest, this);
            x6.a aVar = x6.a.f13718a;
            if (objFetchAndJoinCustomAudience == aVar) {
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
