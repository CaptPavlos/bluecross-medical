package e0;

import com.google.android.gms.common.api.Status;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class m extends Exception {
    /* JADX WARN: Illegal instructions before constructor call */
    public m(Status status) {
        int i10 = status.f1858a;
        String str = status.f1859b;
        super(i10 + ": " + (str == null ? "" : str));
    }
}
