package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.support.v4.media.MediaMetadataCompat;
import java.lang.ref.WeakReference;
import p8.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class g extends Binder implements a {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f414a;

    public g(f fVar) {
        attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback");
        this.f414a = new WeakReference(fVar);
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
        if (i10 == 1598968902) {
            parcel2.writeString("android.support.v4.media.session.IMediaControllerCallback");
            return true;
        }
        switch (i10) {
            case 1:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                String string = parcel.readString();
                Bundle bundle = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                f fVar = (f) this.f414a.get();
                if (fVar != null) {
                    fVar.postToHandler(1, string, bundle);
                }
                return true;
            case 2:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                u.m();
                return false;
            case 3:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                PlaybackStateCompat playbackStateCompatCreateFromParcel = parcel.readInt() != 0 ? PlaybackStateCompat.CREATOR.createFromParcel(parcel) : null;
                f fVar2 = (f) this.f414a.get();
                if (fVar2 != null) {
                    fVar2.postToHandler(2, playbackStateCompatCreateFromParcel, null);
                }
                return true;
            case 4:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                if (parcel.readInt() != 0) {
                    MediaMetadataCompat.CREATOR.createFromParcel(parcel);
                }
                u.m();
                return false;
            case 5:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                parcel.createTypedArrayList(MediaSessionCompat$QueueItem.CREATOR);
                u.m();
                return false;
            case 6:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                if (parcel.readInt() != 0) {
                }
                u.m();
                return false;
            case 7:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                if (parcel.readInt() != 0) {
                }
                u.m();
                return false;
            case 8:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                if (parcel.readInt() != 0) {
                    ParcelableVolumeInfo.CREATOR.createFromParcel(parcel);
                }
                u.m();
                return false;
            case 9:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                int i12 = parcel.readInt();
                f fVar3 = (f) this.f414a.get();
                if (fVar3 != null) {
                    fVar3.postToHandler(9, Integer.valueOf(i12), null);
                }
                return true;
            case 10:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                parcel.readInt();
                return true;
            case 11:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                boolean z9 = parcel.readInt() != 0;
                f fVar4 = (f) this.f414a.get();
                if (fVar4 != null) {
                    fVar4.postToHandler(11, Boolean.valueOf(z9), null);
                }
                return true;
            case 12:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                int i13 = parcel.readInt();
                f fVar5 = (f) this.f414a.get();
                if (fVar5 != null) {
                    fVar5.postToHandler(12, Integer.valueOf(i13), null);
                }
                return true;
            case 13:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                f fVar6 = (f) this.f414a.get();
                if (fVar6 != null) {
                    fVar6.postToHandler(13, null, null);
                }
                return true;
            default:
                return super.onTransact(i10, parcel, parcel2, i11);
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
