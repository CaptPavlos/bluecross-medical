package android.support.customtabs.trusted;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class d implements f {

    /* renamed from: a, reason: collision with root package name */
    public IBinder f365a;

    @Override // android.support.customtabs.trusted.f
    public final Bundle areNotificationsEnabled(Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.h);
            l1.b.f(0, bundle, parcelObtain);
            this.f365a.transact(6, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            Parcelable.Creator creator = Bundle.CREATOR;
            return (Bundle) l1.b.e(parcelObtain2);
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f365a;
    }

    @Override // android.support.customtabs.trusted.f
    public final void cancelNotification(Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.h);
            l1.b.f(0, bundle, parcelObtain);
            this.f365a.transact(3, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.trusted.f
    public final Bundle extraCommand(String str, Bundle bundle, IBinder iBinder) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.h);
            parcelObtain.writeString(str);
            l1.b.f(0, bundle, parcelObtain);
            parcelObtain.writeStrongBinder(iBinder);
            this.f365a.transact(9, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            Parcelable.Creator creator = Bundle.CREATOR;
            return (Bundle) l1.b.e(parcelObtain2);
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.trusted.f
    public final Bundle getActiveNotifications() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.h);
            this.f365a.transact(5, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            Parcelable.Creator creator = Bundle.CREATOR;
            return (Bundle) l1.b.e(parcelObtain2);
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.trusted.f
    public final Bundle getSmallIconBitmap() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.h);
            this.f365a.transact(7, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            Parcelable.Creator creator = Bundle.CREATOR;
            return (Bundle) l1.b.e(parcelObtain2);
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.trusted.f
    public final int getSmallIconId() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.h);
            this.f365a.transact(4, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.trusted.f
    public final Bundle notifyNotificationWithChannel(Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.h);
            l1.b.f(0, bundle, parcelObtain);
            this.f365a.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            Parcelable.Creator creator = Bundle.CREATOR;
            return (Bundle) l1.b.e(parcelObtain2);
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
