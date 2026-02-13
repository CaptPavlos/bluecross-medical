package s6;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l implements f, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12696c = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);

    /* renamed from: a, reason: collision with root package name */
    public volatile g7.a f12697a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f12698b;

    @Override // s6.f
    public final Object getValue() {
        Object obj = this.f12698b;
        t tVar = t.f12708a;
        if (obj != tVar) {
            return obj;
        }
        g7.a aVar = this.f12697a;
        if (aVar != null) {
            Object objInvoke = aVar.invoke();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12696c;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, tVar, objInvoke)) {
                if (atomicReferenceFieldUpdater.get(this) != tVar) {
                }
            }
            this.f12697a = null;
            return objInvoke;
        }
        return this.f12698b;
    }

    @Override // s6.f
    public final boolean isInitialized() {
        return this.f12698b != t.f12708a;
    }

    public final String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
