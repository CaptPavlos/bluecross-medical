package c0;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
import g0.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c implements i {

    /* renamed from: a, reason: collision with root package name */
    public final Status f975a;

    /* renamed from: b, reason: collision with root package name */
    public final GoogleSignInAccount f976b;

    public c(GoogleSignInAccount googleSignInAccount, Status status) {
        this.f976b = googleSignInAccount;
        this.f975a = status;
    }

    @Override // g0.i
    public final Status getStatus() {
        return this.f975a;
    }
}
