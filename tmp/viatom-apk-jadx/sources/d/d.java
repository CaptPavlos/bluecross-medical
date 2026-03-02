package d;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.media.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class d implements Parcelable {
    public static final Parcelable.Creator<d> CREATOR = new f(20);

    /* renamed from: a, reason: collision with root package name */
    public b f6761a;

    public final void b(int i10, Bundle bundle) {
        b bVar = this.f6761a;
        if (bVar != null) {
            try {
                bVar.E(i10, bundle);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        synchronized (this) {
            try {
                if (this.f6761a == null) {
                    this.f6761a = new c(this);
                }
                parcel.writeStrongBinder(this.f6761a.asBinder());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(int i10, Bundle bundle) {
    }
}
