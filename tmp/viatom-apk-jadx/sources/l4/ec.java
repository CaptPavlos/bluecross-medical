package l4;

import com.uptodown.activities.VirusTotalReport;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class ec extends kotlin.jvm.internal.m implements g7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10372a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VirusTotalReport f10373b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ec(VirusTotalReport virusTotalReport, int i10) {
        super(0);
        this.f10372a = i10;
        this.f10373b = virusTotalReport;
    }

    @Override // g7.a
    public final Object invoke() {
        switch (this.f10372a) {
            case 0:
                return this.f10373b.getViewModelStore();
            default:
                return this.f10373b.getDefaultViewModelCreationExtras();
        }
    }
}
