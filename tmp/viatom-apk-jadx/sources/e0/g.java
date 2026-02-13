package e0;

import android.os.IBinder;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g implements Parcelable {
    public static final Parcelable.Creator<g> CREATOR = new c(1);

    /* renamed from: a, reason: collision with root package name */
    public final Messenger f7601a;

    public g(IBinder iBinder) {
        this.f7601a = new Messenger(iBinder);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            Messenger messenger = this.f7601a;
            messenger.getClass();
            IBinder binder = messenger.getBinder();
            Messenger messenger2 = ((g) obj).f7601a;
            messenger2.getClass();
            return binder.equals(messenger2.getBinder());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public final int hashCode() {
        Messenger messenger = this.f7601a;
        messenger.getClass();
        return messenger.getBinder().hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        Messenger messenger = this.f7601a;
        messenger.getClass();
        parcel.writeStrongBinder(messenger.getBinder());
    }
}
