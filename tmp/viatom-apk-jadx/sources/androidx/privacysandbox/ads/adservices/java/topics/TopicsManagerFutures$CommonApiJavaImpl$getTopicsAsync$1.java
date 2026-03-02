package androidx.privacysandbox.ads.adservices.java.topics;

import androidx.privacysandbox.ads.adservices.java.topics.TopicsManagerFutures;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsRequest;
import androidx.privacysandbox.ads.adservices.topics.TopicsManager;
import g7.p;
import r7.w;
import s6.a;
import w6.c;
import y6.e;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@e(c = "androidx.privacysandbox.ads.adservices.java.topics.TopicsManagerFutures$CommonApiJavaImpl$getTopicsAsync$1", f = "TopicsManagerFutures.kt", l = {55}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class TopicsManagerFutures$CommonApiJavaImpl$getTopicsAsync$1 extends i implements p {
    final /* synthetic */ GetTopicsRequest $request;
    int label;
    final /* synthetic */ TopicsManagerFutures.CommonApiJavaImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicsManagerFutures$CommonApiJavaImpl$getTopicsAsync$1(TopicsManagerFutures.CommonApiJavaImpl commonApiJavaImpl, GetTopicsRequest getTopicsRequest, c cVar) {
        super(2, cVar);
        this.this$0 = commonApiJavaImpl;
        this.$request = getTopicsRequest;
    }

    @Override // y6.a
    public final c create(Object obj, c cVar) {
        return new TopicsManagerFutures$CommonApiJavaImpl$getTopicsAsync$1(this.this$0, this.$request, cVar);
    }

    @Override // g7.p
    public final Object invoke(w wVar, c cVar) {
        return ((TopicsManagerFutures$CommonApiJavaImpl$getTopicsAsync$1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                a.e(obj);
                return obj;
            }
            androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        a.e(obj);
        TopicsManager topicsManager = this.this$0.mTopicsManager;
        GetTopicsRequest getTopicsRequest = this.$request;
        this.label = 1;
        Object topics = topicsManager.getTopics(getTopicsRequest, this);
        x6.a aVar = x6.a.f13718a;
        return topics == aVar ? aVar : topics;
    }
}
