package android.support.customtabs;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.measurement.l5;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class d implements f {

    /* renamed from: a, reason: collision with root package name */
    public IBinder f360a;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f360a;
    }

    @Override // android.support.customtabs.f
    public final Bundle extraCommand(String str, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.f361d);
            parcelObtain.writeString(str);
            l5.O(parcelObtain, bundle, 0);
            this.f360a.transact(5, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return (Bundle) l5.d(parcelObtain2, Bundle.CREATOR);
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.f
    public final boolean isEngagementSignalsApiAvailable(c cVar, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.f361d);
            parcelObtain.writeStrongInterface(cVar);
            l5.O(parcelObtain, bundle, 0);
            this.f360a.transact(13, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.f
    public final boolean mayLaunchUrl(c cVar, Uri uri, Bundle bundle, List list) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.f361d);
            parcelObtain.writeStrongInterface(cVar);
            l5.O(parcelObtain, uri, 0);
            l5.O(parcelObtain, bundle, 0);
            if (list == null) {
                parcelObtain.writeInt(-1);
            } else {
                int size = list.size();
                parcelObtain.writeInt(size);
                for (int i10 = 0; i10 < size; i10++) {
                    l5.O(parcelObtain, (Parcelable) list.get(i10), 0);
                }
            }
            this.f360a.transact(4, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.f
    public final boolean newSession(c cVar) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.f361d);
            parcelObtain.writeStrongInterface(cVar);
            this.f360a.transact(3, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.f
    public final boolean newSessionWithExtras(c cVar, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.f361d);
            parcelObtain.writeStrongInterface(cVar);
            l5.O(parcelObtain, bundle, 0);
            this.f360a.transact(10, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.f
    public final int postMessage(c cVar, String str, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.f361d);
            parcelObtain.writeStrongInterface(cVar);
            parcelObtain.writeString(str);
            l5.O(parcelObtain, bundle, 0);
            this.f360a.transact(8, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.f
    public final boolean receiveFile(c cVar, Uri uri, int i10, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.f361d);
            parcelObtain.writeStrongInterface(cVar);
            l5.O(parcelObtain, uri, 0);
            parcelObtain.writeInt(i10);
            l5.O(parcelObtain, bundle, 0);
            this.f360a.transact(12, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.f
    public final boolean requestPostMessageChannel(c cVar, Uri uri) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.f361d);
            parcelObtain.writeStrongInterface(cVar);
            l5.O(parcelObtain, uri, 0);
            this.f360a.transact(7, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.f
    public final boolean requestPostMessageChannelWithExtras(c cVar, Uri uri, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.f361d);
            parcelObtain.writeStrongInterface(cVar);
            l5.O(parcelObtain, uri, 0);
            l5.O(parcelObtain, bundle, 0);
            this.f360a.transact(11, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.f
    public final boolean setEngagementSignalsCallback(c cVar, IBinder iBinder, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.f361d);
            parcelObtain.writeStrongInterface(cVar);
            parcelObtain.writeStrongBinder(iBinder);
            l5.O(parcelObtain, bundle, 0);
            this.f360a.transact(14, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.f
    public final boolean updateVisuals(c cVar, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.f361d);
            parcelObtain.writeStrongInterface(cVar);
            l5.O(parcelObtain, bundle, 0);
            this.f360a.transact(6, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.f
    public final boolean validateRelationship(c cVar, int i10, Uri uri, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.f361d);
            parcelObtain.writeStrongInterface(cVar);
            parcelObtain.writeInt(i10);
            l5.O(parcelObtain, uri, 0);
            l5.O(parcelObtain, bundle, 0);
            this.f360a.transact(9, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.f
    public final boolean warmup(long j10) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.f361d);
            parcelObtain.writeLong(j10);
            this.f360a.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
