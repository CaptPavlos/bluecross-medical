package android.support.v4.media.session;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.ResultReceiver;
import androidx.core.app.BundleCompat;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
class MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver extends ResultReceiver {

    /* renamed from: a, reason: collision with root package name */
    public WeakReference f388a;

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i10, Bundle bundle) {
        d dVar;
        h hVar = (h) this.f388a.get();
        if (hVar == null || bundle == null) {
            return;
        }
        synchronized (hVar.f416b) {
            MediaSessionCompat$Token mediaSessionCompat$Token = hVar.e;
            IBinder binder = BundleCompat.getBinder(bundle, "android.support.v4.media.session.EXTRA_BINDER");
            int i11 = c.f411a;
            if (binder == null) {
                dVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = binder.queryLocalInterface("android.support.v4.media.session.IMediaSession");
                if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof d)) {
                    b bVar = new b();
                    bVar.f410a = binder;
                    dVar = bVar;
                } else {
                    dVar = (d) iInterfaceQueryLocalInterface;
                }
            }
            mediaSessionCompat$Token.f394b = dVar;
            MediaSessionCompat$Token mediaSessionCompat$Token2 = hVar.e;
            bundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE");
            mediaSessionCompat$Token2.getClass();
            hVar.a();
        }
    }
}
