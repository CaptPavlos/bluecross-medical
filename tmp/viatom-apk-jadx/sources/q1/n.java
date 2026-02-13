package q1;

import j$.util.DesugarCollections;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n implements q2.b {

    /* renamed from: a, reason: collision with root package name */
    public volatile Set f12244a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Set f12245b;

    public final synchronized void a() {
        try {
            Iterator it = this.f12244a.iterator();
            while (it.hasNext()) {
                this.f12245b.add(((q2.b) it.next()).get());
            }
            this.f12244a = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // q2.b
    public final Object get() {
        if (this.f12245b == null) {
            synchronized (this) {
                try {
                    if (this.f12245b == null) {
                        this.f12245b = Collections.newSetFromMap(new ConcurrentHashMap());
                        a();
                    }
                } finally {
                }
            }
        }
        return DesugarCollections.unmodifiableSet(this.f12245b);
    }
}
