package w3;

import j$.util.DesugarCollections;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class k {

    /* renamed from: d, reason: collision with root package name */
    public static final k f13516d;

    /* renamed from: a, reason: collision with root package name */
    public WeakReference f13517a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f13518b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f13519c;

    static {
        k kVar = new k();
        kVar.f13518b = false;
        kVar.f13519c = false;
        f13516d = kVar;
    }

    public final void a(boolean z9, boolean z10) {
        if ((z10 || z9) == (this.f13519c || this.f13518b)) {
            return;
        }
        Iterator it = DesugarCollections.unmodifiableCollection(c.f13498c.f13499a).iterator();
        while (it.hasNext()) {
            y3.a aVar = ((t3.j) it.next()).e;
            boolean z11 = z10 || z9;
            if (aVar.f13783b.get() != 0) {
                i.f13511a.a(aVar.f(), "setDeviceLockState", z11 ? "locked" : "unlocked");
            }
        }
    }
}
