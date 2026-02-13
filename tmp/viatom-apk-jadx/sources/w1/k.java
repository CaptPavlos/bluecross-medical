package w1;

import android.os.Bundle;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f13347a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f13348b;

    public k(l lVar, long j10) {
        this.f13348b = lVar;
        this.f13347a = j10;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Bundle bundle = new Bundle();
        bundle.putInt("fatal", 1);
        bundle.putLong(CampaignEx.JSON_KEY_TIMESTAMP, this.f13347a);
        this.f13348b.f13357k.k(bundle);
        return null;
    }
}
