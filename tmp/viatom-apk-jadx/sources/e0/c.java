package e0;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7595a;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f7595a) {
            case 0:
                int iQ = a.a.Q(parcel);
                Intent intent = null;
                while (parcel.dataPosition() < iQ) {
                    int i10 = parcel.readInt();
                    if (((char) i10) != 1) {
                        a.a.O(parcel, i10);
                    } else {
                        intent = (Intent) a.a.s(parcel, i10, Intent.CREATOR);
                    }
                }
                a.a.y(parcel, iQ);
                return new a(intent);
            default:
                return new g(parcel.readStrongBinder());
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        switch (this.f7595a) {
            case 0:
                return new a[i10];
            default:
                return new g[i10];
        }
    }
}
