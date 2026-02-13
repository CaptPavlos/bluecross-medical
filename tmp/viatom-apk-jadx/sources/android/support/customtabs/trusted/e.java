package android.support.customtabs.trusted;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class e extends Binder implements f {
    static final int TRANSACTION_areNotificationsEnabled = 6;
    static final int TRANSACTION_cancelNotification = 3;
    static final int TRANSACTION_extraCommand = 9;
    static final int TRANSACTION_getActiveNotifications = 5;
    static final int TRANSACTION_getSmallIconBitmap = 7;
    static final int TRANSACTION_getSmallIconId = 4;
    static final int TRANSACTION_notifyNotificationWithChannel = 2;

    public static f asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f.h);
        if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof f)) {
            return (f) iInterfaceQueryLocalInterface;
        }
        d dVar = new d();
        dVar.f365a = iBinder;
        return dVar;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        String str = f.h;
        if (i10 >= 1 && i10 <= 16777215) {
            parcel.enforceInterface(str);
        }
        if (i10 == 1598968902) {
            parcel2.writeString(str);
            return true;
        }
        switch (i10) {
            case 2:
                Parcelable.Creator creator = Bundle.CREATOR;
                Bundle bundleNotifyNotificationWithChannel = notifyNotificationWithChannel((Bundle) l1.b.e(parcel));
                parcel2.writeNoException();
                l1.b.f(1, bundleNotifyNotificationWithChannel, parcel2);
                return true;
            case 3:
                Parcelable.Creator creator2 = Bundle.CREATOR;
                cancelNotification((Bundle) l1.b.e(parcel));
                parcel2.writeNoException();
                return true;
            case 4:
                int smallIconId = getSmallIconId();
                parcel2.writeNoException();
                parcel2.writeInt(smallIconId);
                return true;
            case 5:
                Bundle activeNotifications = getActiveNotifications();
                parcel2.writeNoException();
                l1.b.f(1, activeNotifications, parcel2);
                return true;
            case 6:
                Parcelable.Creator creator3 = Bundle.CREATOR;
                Bundle bundleAreNotificationsEnabled = areNotificationsEnabled((Bundle) l1.b.e(parcel));
                parcel2.writeNoException();
                l1.b.f(1, bundleAreNotificationsEnabled, parcel2);
                return true;
            case 7:
                Bundle smallIconBitmap = getSmallIconBitmap();
                parcel2.writeNoException();
                l1.b.f(1, smallIconBitmap, parcel2);
                return true;
            case 8:
            default:
                return super.onTransact(i10, parcel, parcel2, i11);
            case 9:
                String string = parcel.readString();
                Parcelable.Creator creator4 = Bundle.CREATOR;
                Bundle bundleExtraCommand = extraCommand(string, (Bundle) l1.b.e(parcel), parcel.readStrongBinder());
                parcel2.writeNoException();
                l1.b.f(1, bundleExtraCommand, parcel2);
                return true;
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }
}
