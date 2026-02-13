package d0;

import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import p8.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f extends u0.b implements IInterface {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f6775b;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ g f6776k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(g gVar, int i10) {
        super("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks", 0);
        this.f6775b = i10;
        this.f6776k = gVar;
    }

    @Override // u0.b
    public final boolean G(int i10, Parcel parcel, Parcel parcel2) {
        switch (i10) {
            case 101:
                u0.c.b(parcel);
                u.p();
                return false;
            case 102:
                Status status = (Status) u0.c.a(parcel, Status.CREATOR);
                u0.c.b(parcel);
                switch (this.f6775b) {
                    case 0:
                        this.f6776k.e(status);
                        break;
                    default:
                        throw new UnsupportedOperationException();
                }
            case 103:
                Status status2 = (Status) u0.c.a(parcel, Status.CREATOR);
                u0.c.b(parcel);
                switch (this.f6775b) {
                    case 1:
                        this.f6776k.e(status2);
                        break;
                    default:
                        throw new UnsupportedOperationException();
                }
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
