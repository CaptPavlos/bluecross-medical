package android.support.customtabs;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.a4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class b extends Binder implements c {
    static final int TRANSACTION_extraCallback = 3;
    static final int TRANSACTION_extraCallbackWithResult = 7;
    static final int TRANSACTION_onActivityLayout = 10;
    static final int TRANSACTION_onActivityResized = 8;
    static final int TRANSACTION_onMessageChannelReady = 4;
    static final int TRANSACTION_onMinimized = 11;
    static final int TRANSACTION_onNavigationEvent = 2;
    static final int TRANSACTION_onPostMessage = 5;
    static final int TRANSACTION_onRelationshipValidationResult = 6;
    static final int TRANSACTION_onUnminimized = 12;
    static final int TRANSACTION_onWarmupCompleted = 9;

    public b() {
        attachInterface(this, c.f359c);
    }

    public static c asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(c.f359c);
        if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof c)) {
            return (c) iInterfaceQueryLocalInterface;
        }
        a aVar = new a();
        aVar.f358a = iBinder;
        return aVar;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        String str = c.f359c;
        if (i10 >= 1 && i10 <= 16777215) {
            parcel.enforceInterface(str);
        }
        if (i10 == 1598968902) {
            parcel2.writeString(str);
            return true;
        }
        switch (i10) {
            case 2:
                onNavigationEvent(parcel.readInt(), (Bundle) a4.d(parcel, Bundle.CREATOR));
                return true;
            case 3:
                extraCallback(parcel.readString(), (Bundle) a4.d(parcel, Bundle.CREATOR));
                return true;
            case 4:
                onMessageChannelReady((Bundle) a4.d(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 5:
                onPostMessage(parcel.readString(), (Bundle) a4.d(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 6:
                onRelationshipValidationResult(parcel.readInt(), (Uri) a4.d(parcel, Uri.CREATOR), parcel.readInt() != 0, (Bundle) a4.d(parcel, Bundle.CREATOR));
                return true;
            case 7:
                Bundle bundleExtraCallbackWithResult = extraCallbackWithResult(parcel.readString(), (Bundle) a4.d(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                a4.e(parcel2, bundleExtraCallbackWithResult, 1);
                return true;
            case 8:
                onActivityResized(parcel.readInt(), parcel.readInt(), (Bundle) a4.d(parcel, Bundle.CREATOR));
                return true;
            case 9:
                onWarmupCompleted((Bundle) a4.d(parcel, Bundle.CREATOR));
                return true;
            case 10:
                onActivityLayout(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), (Bundle) a4.d(parcel, Bundle.CREATOR));
                return true;
            case 11:
                onMinimized((Bundle) a4.d(parcel, Bundle.CREATOR));
                return true;
            case 12:
                onUnminimized((Bundle) a4.d(parcel, Bundle.CREATOR));
                return true;
            default:
                return super.onTransact(i10, parcel, parcel2, i11);
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }
}
