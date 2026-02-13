package androidx.work.impl.utils;

import android.net.NetworkRequest;
import androidx.work.Logger;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class NetworkRequestCompat {
    public static final Companion Companion = new Companion(null);
    private static final String TAG;
    private final Object wrapped;

    static {
        String strTagWithPrefix = Logger.tagWithPrefix("NetworkRequestCompat");
        strTagWithPrefix.getClass();
        TAG = strTagWithPrefix;
    }

    public /* synthetic */ NetworkRequestCompat(Object obj, int i10, g gVar) {
        this((i10 & 1) != 0 ? null : obj);
    }

    public static /* synthetic */ NetworkRequestCompat copy$default(NetworkRequestCompat networkRequestCompat, Object obj, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            obj = networkRequestCompat.wrapped;
        }
        return networkRequestCompat.copy(obj);
    }

    public final Object component1() {
        return this.wrapped;
    }

    public final NetworkRequestCompat copy(Object obj) {
        return new NetworkRequestCompat(obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof NetworkRequestCompat) && l.a(this.wrapped, ((NetworkRequestCompat) obj).wrapped);
    }

    public final NetworkRequest getNetworkRequest() {
        return (NetworkRequest) this.wrapped;
    }

    public final Object getWrapped() {
        return this.wrapped;
    }

    public int hashCode() {
        Object obj = this.wrapped;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        return "NetworkRequestCompat(wrapped=" + this.wrapped + ')';
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final String getTAG() {
            return NetworkRequestCompat.TAG;
        }

        private Companion() {
        }
    }

    public NetworkRequestCompat(Object obj) {
        this.wrapped = obj;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public NetworkRequestCompat() {
        g gVar = null;
        this(gVar, 1, gVar);
    }
}
