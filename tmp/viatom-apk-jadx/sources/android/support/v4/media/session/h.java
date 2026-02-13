package android.support.v4.media.session;

import android.content.Context;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public final MediaController f415a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f416b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f417c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f418d = new HashMap();
    public final MediaSessionCompat$Token e;

    public h(Context context, MediaSessionCompat$Token mediaSessionCompat$Token) {
        this.e = mediaSessionCompat$Token;
        MediaController mediaController = new MediaController(context, (MediaSession.Token) mediaSessionCompat$Token.f393a);
        this.f415a = mediaController;
        if (mediaSessionCompat$Token.f394b == null) {
            MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver mediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver = new MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver(null);
            mediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver.f388a = new WeakReference(this);
            mediaController.sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, mediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver);
        }
    }

    public final void a() {
        MediaSessionCompat$Token mediaSessionCompat$Token = this.e;
        if (mediaSessionCompat$Token.f394b == null) {
            return;
        }
        ArrayList arrayList = this.f417c;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            f fVar = (f) obj;
            g gVar = new g(fVar);
            this.f418d.put(fVar, gVar);
            fVar.mIControllerCallback = gVar;
            try {
                b bVar = (b) mediaSessionCompat$Token.f394b;
                bVar.getClass();
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcelObtain.writeStrongBinder(gVar);
                    bVar.f410a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    fVar.postToHandler(13, null, null);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
            }
        }
        arrayList.clear();
    }
}
