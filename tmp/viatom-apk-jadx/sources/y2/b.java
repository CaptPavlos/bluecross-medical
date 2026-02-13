package y2;

import j$.util.DesugarCollections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f13777a;

    /* renamed from: b, reason: collision with root package name */
    public final c f13778b;

    public b(Set set, c cVar) {
        this.f13777a = b(set);
        this.f13778b = cVar;
    }

    public static String b(Set set) {
        StringBuilder sb = new StringBuilder();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            sb.append(aVar.f13775a);
            sb.append('/');
            sb.append(aVar.f13776b);
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public final String a() {
        Set setUnmodifiableSet;
        c cVar = this.f13778b;
        synchronized (((HashSet) cVar.f13781b)) {
            setUnmodifiableSet = DesugarCollections.unmodifiableSet((HashSet) cVar.f13781b);
        }
        boolean zIsEmpty = setUnmodifiableSet.isEmpty();
        String str = this.f13777a;
        if (zIsEmpty) {
            return str;
        }
        return str + ' ' + b(cVar.x());
    }
}
