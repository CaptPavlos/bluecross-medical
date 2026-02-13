package android.support.v4.media;

import d0.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class c {
    b mConnectionCallbackInternal;
    final Object mConnectionCallbackObj = new h(new i(this, 2));

    public abstract void onConnected();

    public abstract void onConnectionFailed();

    public abstract void onConnectionSuspended();

    public void setInternalConnectionCallback(b bVar) {
        this.mConnectionCallbackInternal = bVar;
    }
}
