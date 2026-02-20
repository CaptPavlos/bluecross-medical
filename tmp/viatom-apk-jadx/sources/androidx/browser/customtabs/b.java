package androidx.browser.customtabs;

import android.os.Bundle;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f446a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EngagementSignalsCallback f447b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f448c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Bundle f449d;

    public /* synthetic */ b(EngagementSignalsCallback engagementSignalsCallback, boolean z9, Bundle bundle, int i10) {
        this.f446a = i10;
        this.f447b = engagementSignalsCallback;
        this.f448c = z9;
        this.f449d = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f446a) {
            case 0:
                this.f447b.onSessionEnded(this.f448c, this.f449d);
                break;
            case 1:
                this.f447b.onVerticalScrollEvent(this.f448c, this.f449d);
                break;
            case 2:
                this.f447b.onVerticalScrollEvent(this.f448c, this.f449d);
                break;
            default:
                this.f447b.onSessionEnded(this.f448c, this.f449d);
                break;
        }
    }
}
