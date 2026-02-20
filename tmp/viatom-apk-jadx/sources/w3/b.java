package w3;

import android.view.View;
import j$.util.DesugarCollections;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class b extends e {

    /* renamed from: d, reason: collision with root package name */
    public static final b f13497d = new b();

    @Override // w3.e
    public final void a(boolean z9) {
        Iterator it = DesugarCollections.unmodifiableCollection(c.f13498c.f13499a).iterator();
        while (it.hasNext()) {
            y3.a aVar = ((t3.j) it.next()).e;
            if (aVar.f13783b.get() != 0) {
                i.f13511a.a(aVar.f(), "setState", z9 ? "foregrounded" : "backgrounded", aVar.f13782a);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // w3.e
    public final boolean b() {
        Iterator it = DesugarCollections.unmodifiableCollection(c.f13498c.f13500b).iterator();
        while (it.hasNext()) {
            View view = (View) ((t3.j) it.next()).f12794d.get();
            if (view != null && view.hasWindowFocus()) {
                return true;
            }
        }
        return false;
    }
}
