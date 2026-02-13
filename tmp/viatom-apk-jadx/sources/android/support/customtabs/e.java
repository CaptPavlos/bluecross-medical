package android.support.customtabs;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.l5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class e extends Binder implements f {
    static final int TRANSACTION_extraCommand = 5;
    static final int TRANSACTION_isEngagementSignalsApiAvailable = 13;
    static final int TRANSACTION_mayLaunchUrl = 4;
    static final int TRANSACTION_newSession = 3;
    static final int TRANSACTION_newSessionWithExtras = 10;
    static final int TRANSACTION_postMessage = 8;
    static final int TRANSACTION_receiveFile = 12;
    static final int TRANSACTION_requestPostMessageChannel = 7;
    static final int TRANSACTION_requestPostMessageChannelWithExtras = 11;
    static final int TRANSACTION_setEngagementSignalsCallback = 14;
    static final int TRANSACTION_updateVisuals = 6;
    static final int TRANSACTION_validateRelationship = 9;
    static final int TRANSACTION_warmup = 2;

    public e() {
        attachInterface(this, f.f361d);
    }

    public static f asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f.f361d);
        if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof f)) {
            return (f) iInterfaceQueryLocalInterface;
        }
        d dVar = new d();
        dVar.f360a = iBinder;
        return dVar;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        String str = f.f361d;
        if (i10 >= 1 && i10 <= 16777215) {
            parcel.enforceInterface(str);
        }
        if (i10 == 1598968902) {
            parcel2.writeString(str);
            return true;
        }
        switch (i10) {
            case 2:
                boolean zWarmup = warmup(parcel.readLong());
                parcel2.writeNoException();
                parcel2.writeInt(zWarmup ? 1 : 0);
                return true;
            case 3:
                boolean zNewSession = newSession(b.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeInt(zNewSession ? 1 : 0);
                return true;
            case 4:
                c cVarAsInterface = b.asInterface(parcel.readStrongBinder());
                Uri uri = (Uri) l5.d(parcel, Uri.CREATOR);
                Parcelable.Creator creator = Bundle.CREATOR;
                boolean zMayLaunchUrl = mayLaunchUrl(cVarAsInterface, uri, (Bundle) l5.d(parcel, creator), parcel.createTypedArrayList(creator));
                parcel2.writeNoException();
                parcel2.writeInt(zMayLaunchUrl ? 1 : 0);
                return true;
            case 5:
                Bundle bundleExtraCommand = extraCommand(parcel.readString(), (Bundle) l5.d(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                l5.O(parcel2, bundleExtraCommand, 1);
                return true;
            case 6:
                boolean zUpdateVisuals = updateVisuals(b.asInterface(parcel.readStrongBinder()), (Bundle) l5.d(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                parcel2.writeInt(zUpdateVisuals ? 1 : 0);
                return true;
            case 7:
                boolean zRequestPostMessageChannel = requestPostMessageChannel(b.asInterface(parcel.readStrongBinder()), (Uri) l5.d(parcel, Uri.CREATOR));
                parcel2.writeNoException();
                parcel2.writeInt(zRequestPostMessageChannel ? 1 : 0);
                return true;
            case 8:
                int iPostMessage = postMessage(b.asInterface(parcel.readStrongBinder()), parcel.readString(), (Bundle) l5.d(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                parcel2.writeInt(iPostMessage);
                return true;
            case 9:
                boolean zValidateRelationship = validateRelationship(b.asInterface(parcel.readStrongBinder()), parcel.readInt(), (Uri) l5.d(parcel, Uri.CREATOR), (Bundle) l5.d(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                parcel2.writeInt(zValidateRelationship ? 1 : 0);
                return true;
            case 10:
                boolean zNewSessionWithExtras = newSessionWithExtras(b.asInterface(parcel.readStrongBinder()), (Bundle) l5.d(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                parcel2.writeInt(zNewSessionWithExtras ? 1 : 0);
                return true;
            case 11:
                boolean zRequestPostMessageChannelWithExtras = requestPostMessageChannelWithExtras(b.asInterface(parcel.readStrongBinder()), (Uri) l5.d(parcel, Uri.CREATOR), (Bundle) l5.d(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                parcel2.writeInt(zRequestPostMessageChannelWithExtras ? 1 : 0);
                return true;
            case 12:
                boolean zReceiveFile = receiveFile(b.asInterface(parcel.readStrongBinder()), (Uri) l5.d(parcel, Uri.CREATOR), parcel.readInt(), (Bundle) l5.d(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                parcel2.writeInt(zReceiveFile ? 1 : 0);
                return true;
            case 13:
                boolean zIsEngagementSignalsApiAvailable = isEngagementSignalsApiAvailable(b.asInterface(parcel.readStrongBinder()), (Bundle) l5.d(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                parcel2.writeInt(zIsEngagementSignalsApiAvailable ? 1 : 0);
                return true;
            case 14:
                boolean engagementSignalsCallback = setEngagementSignalsCallback(b.asInterface(parcel.readStrongBinder()), parcel.readStrongBinder(), (Bundle) l5.d(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                parcel2.writeInt(engagementSignalsCallback ? 1 : 0);
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
