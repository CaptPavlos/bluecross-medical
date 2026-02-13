package androidx.privacysandbox.ads.adservices.topics;

import android.content.Context;
import g7.l;
import kotlin.jvm.internal.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class TopicsManager$Companion$obtain$2 extends m implements l {
    final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicsManager$Companion$obtain$2(Context context) {
        super(1);
        this.$context = context;
    }

    @Override // g7.l
    public final TopicsManagerApi31Ext9Impl invoke(Context context) {
        context.getClass();
        return new TopicsManagerApi31Ext9Impl(this.$context);
    }
}
