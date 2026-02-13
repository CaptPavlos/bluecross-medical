package d0;

import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import i0.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g extends BasePendingResult {

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ int f6777k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(g0.g gVar, int i10) {
        super(gVar);
        this.f6777k = i10;
        y.h(gVar, "GoogleApiClient must not be null");
        y.h(b0.a.f818a, "Api must not be null");
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* bridge */ /* synthetic */ g0.i b(Status status) {
        int i10 = this.f6777k;
        return status;
    }

    public final void f(g0.b bVar) {
        switch (this.f6777k) {
            case 0:
                e eVar = (e) bVar;
                j jVar = (j) eVar.t();
                f fVar = new f(this, 0);
                GoogleSignInOptions googleSignInOptions = eVar.f6774z;
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.writeInterfaceToken(jVar.f2253k);
                int i10 = u0.c.f12882a;
                parcelObtain.writeStrongBinder(fVar);
                if (googleSignInOptions == null) {
                    parcelObtain.writeInt(0);
                } else {
                    parcelObtain.writeInt(1);
                    googleSignInOptions.writeToParcel(parcelObtain, 0);
                }
                jVar.a(parcelObtain, 102);
                break;
            default:
                e eVar2 = (e) bVar;
                j jVar2 = (j) eVar2.t();
                f fVar2 = new f(this, 1);
                GoogleSignInOptions googleSignInOptions2 = eVar2.f6774z;
                Parcel parcelObtain2 = Parcel.obtain();
                parcelObtain2.writeInterfaceToken(jVar2.f2253k);
                int i11 = u0.c.f12882a;
                parcelObtain2.writeStrongBinder(fVar2);
                if (googleSignInOptions2 == null) {
                    parcelObtain2.writeInt(0);
                } else {
                    parcelObtain2.writeInt(1);
                    googleSignInOptions2.writeToParcel(parcelObtain2, 0);
                }
                jVar2.a(parcelObtain2, 103);
                break;
        }
    }

    public final void g(Status status) {
        y.a("Failed result must not be success", !(status.f1858a <= 0));
        e(b(status));
    }
}
