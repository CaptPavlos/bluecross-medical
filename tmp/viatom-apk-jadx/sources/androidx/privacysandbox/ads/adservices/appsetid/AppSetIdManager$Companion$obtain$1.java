package androidx.privacysandbox.ads.adservices.appsetid;

import android.content.Context;
import g7.l;
import kotlin.jvm.internal.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class AppSetIdManager$Companion$obtain$1 extends m implements l {
    final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppSetIdManager$Companion$obtain$1(Context context) {
        super(1);
        this.$context = context;
    }

    @Override // g7.l
    public final AppSetIdManagerApi31Ext9Impl invoke(Context context) {
        context.getClass();
        return new AppSetIdManagerApi31Ext9Impl(this.$context);
    }
}
