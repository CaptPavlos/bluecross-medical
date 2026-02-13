package androidx.browser.customtabs;

import android.os.Bundle;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f450a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EngagementSignalsCallback f451b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f452c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Bundle f453d;

    public /* synthetic */ c(EngagementSignalsCallback engagementSignalsCallback, int i10, Bundle bundle, int i11) {
        this.f450a = i11;
        this.f451b = engagementSignalsCallback;
        this.f452c = i10;
        this.f453d = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f450a) {
            case 0:
                this.f451b.onGreatestScrollPercentageIncreased(this.f452c, this.f453d);
                break;
            default:
                this.f451b.onGreatestScrollPercentageIncreased(this.f452c, this.f453d);
                break;
        }
    }
}
