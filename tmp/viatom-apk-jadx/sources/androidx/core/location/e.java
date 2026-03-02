package androidx.core.location;

import android.location.Location;
import androidx.core.util.Consumer;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f482a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Consumer f483b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Location f484c;

    public /* synthetic */ e(Consumer consumer, Location location, int i10) {
        this.f482a = i10;
        this.f483b = consumer;
        this.f484c = location;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f482a) {
            case 0:
                this.f483b.accept(this.f484c);
                break;
            default:
                this.f483b.accept(this.f484c);
                break;
        }
    }
}
