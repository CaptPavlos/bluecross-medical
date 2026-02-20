package android.support.v4.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.util.Log;
import androidx.core.app.BundleCompat;
import androidx.media.MediaBrowserProtocol;
import d0.i;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class h extends MediaBrowser.ConnectionCallback {

    /* renamed from: a, reason: collision with root package name */
    public final i f387a;

    public h(i iVar) {
        this.f387a = iVar;
    }

    @Override // android.media.browse.MediaBrowser.ConnectionCallback
    public final void onConnected() throws RemoteException {
        android.support.v4.media.session.d dVar;
        c cVar = (c) this.f387a.f6781b;
        b bVar = cVar.mConnectionCallbackInternal;
        if (bVar != null) {
            d dVar2 = (d) bVar;
            a aVar = dVar2.f383d;
            MediaBrowser mediaBrowser = dVar2.f381b;
            Bundle extras = mediaBrowser.getExtras();
            if (extras != null) {
                extras.getInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 0);
                IBinder binder = BundleCompat.getBinder(extras, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER);
                if (binder != null) {
                    Bundle bundle = dVar2.f382c;
                    a4.f fVar = new a4.f(1);
                    fVar.f218b = new Messenger(binder);
                    fVar.f219c = bundle;
                    dVar2.f = fVar;
                    Messenger messenger = new Messenger(aVar);
                    dVar2.g = messenger;
                    aVar.getClass();
                    aVar.f379b = new WeakReference(messenger);
                    try {
                        a4.f fVar2 = dVar2.f;
                        Context context = dVar2.f380a;
                        Messenger messenger2 = dVar2.g;
                        fVar2.getClass();
                        Bundle bundle2 = new Bundle();
                        bundle2.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, context.getPackageName());
                        bundle2.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, (Bundle) fVar2.f219c);
                        Message messageObtain = Message.obtain();
                        messageObtain.what = 6;
                        messageObtain.arg1 = 1;
                        messageObtain.setData(bundle2);
                        messageObtain.replyTo = messenger2;
                        ((Messenger) fVar2.f218b).send(messageObtain);
                    } catch (RemoteException unused) {
                        Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
                    }
                }
                IBinder binder2 = BundleCompat.getBinder(extras, MediaBrowserProtocol.EXTRA_SESSION_BINDER);
                int i10 = android.support.v4.media.session.c.f411a;
                if (binder2 == null) {
                    dVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = binder2.queryLocalInterface("android.support.v4.media.session.IMediaSession");
                    if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof android.support.v4.media.session.d)) {
                        android.support.v4.media.session.b bVar2 = new android.support.v4.media.session.b();
                        bVar2.f410a = binder2;
                        dVar = bVar2;
                    } else {
                        dVar = (android.support.v4.media.session.d) iInterfaceQueryLocalInterface;
                    }
                }
                if (dVar != null) {
                    dVar2.h = MediaSessionCompat$Token.a(mediaBrowser.getSessionToken(), dVar);
                }
            }
        }
        cVar.onConnected();
    }

    @Override // android.media.browse.MediaBrowser.ConnectionCallback
    public final void onConnectionFailed() {
        ((c) this.f387a.f6781b).onConnectionFailed();
    }

    @Override // android.media.browse.MediaBrowser.ConnectionCallback
    public final void onConnectionSuspended() {
        c cVar = (c) this.f387a.f6781b;
        b bVar = cVar.mConnectionCallbackInternal;
        if (bVar != null) {
            d dVar = (d) bVar;
            dVar.f = null;
            dVar.g = null;
            dVar.h = null;
            a aVar = dVar.f383d;
            aVar.getClass();
            aVar.f379b = new WeakReference(null);
        }
        cVar.onConnectionSuspended();
    }
}
