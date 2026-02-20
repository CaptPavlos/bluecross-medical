package g0;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k extends BasePendingResult {

    /* renamed from: k, reason: collision with root package name */
    public final Status f8195k;

    public k(Status status) {
        super(null);
        this.f8195k = status;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final i b(Status status) {
        return this.f8195k;
    }
}
