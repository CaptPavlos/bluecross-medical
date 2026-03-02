package android.support.v4.media;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.support.v4.media.session.m;
import android.util.Log;
import androidx.media.MediaBrowserProtocol;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class a extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f378a;

    /* renamed from: b, reason: collision with root package name */
    public WeakReference f379b;

    public a(d dVar) {
        this.f378a = new WeakReference(dVar);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        WeakReference weakReference = this.f379b;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        WeakReference weakReference2 = this.f378a;
        if (weakReference2.get() == null) {
            return;
        }
        Bundle data = message.getData();
        m.a(data);
        d dVar = (d) weakReference2.get();
        Messenger messenger = (Messenger) this.f379b.get();
        try {
            int i10 = message.what;
            if (i10 == 1) {
                m.a(data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS));
                data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID);
                dVar.getClass();
                return;
            }
            if (i10 == 2) {
                dVar.getClass();
                return;
            }
            if (i10 != 3) {
                Log.w("MediaBrowserCompat", "Unhandled message: " + message + "\n  Client version: 1\n  Service version: " + message.arg1);
                return;
            }
            m.a(data.getBundle(MediaBrowserProtocol.DATA_OPTIONS));
            m.a(data.getBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS));
            String string = data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID);
            data.getParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST);
            if (dVar.g != messenger) {
                return;
            }
            if (dVar.e.get(string) != null) {
                throw new ClassCastException();
            }
            if (g.f385b) {
                Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + string);
            }
        } catch (BadParcelableException unused) {
            Log.e("MediaBrowserCompat", "Could not unparcel the data.");
            if (message.what == 1) {
                dVar.getClass();
            }
        }
    }
}
