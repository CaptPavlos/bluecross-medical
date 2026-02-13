package l1;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e implements h0.b {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReference f10172a = new AtomicReference();

    @Override // h0.b
    public final void a(boolean z9) {
        synchronized (g.f10175k) {
            try {
                ArrayList arrayList = new ArrayList(g.f10176l.values());
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    g gVar = (g) obj;
                    if (gVar.e.get()) {
                        Log.d("FirebaseApp", "Notifying background state change listeners.");
                        Iterator it = gVar.f10181i.iterator();
                        while (it.hasNext()) {
                            g gVar2 = ((d) it.next()).f10171a;
                            if (!z9) {
                                ((o2.d) gVar2.h.get()).c();
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
