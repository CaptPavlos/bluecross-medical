package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.Messenger;
import android.support.v4.media.session.MediaSessionCompat$Token;
import androidx.collection.ArrayMap;
import androidx.media.MediaBrowserProtocol;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class d implements b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f380a;

    /* renamed from: b, reason: collision with root package name */
    public final MediaBrowser f381b;

    /* renamed from: c, reason: collision with root package name */
    public final Bundle f382c;

    /* renamed from: d, reason: collision with root package name */
    public final a f383d = new a(this);
    public final ArrayMap e = new ArrayMap();
    public a4.f f;
    public Messenger g;
    public MediaSessionCompat$Token h;

    public d(Context context, ComponentName componentName, c cVar) {
        this.f380a = context;
        Bundle bundle = new Bundle();
        this.f382c = bundle;
        bundle.putInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 1);
        cVar.setInternalConnectionCallback(this);
        this.f381b = new MediaBrowser(context, componentName, (MediaBrowser.ConnectionCallback) cVar.mConnectionCallbackObj, bundle);
    }
}
