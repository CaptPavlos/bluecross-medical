package n7;

import com.google.android.gms.internal.measurement.a4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l4.x2;
import t6.t;

/* loaded from: classes3.dex */
public abstract class i extends j {
    public static f T(g7.l lVar, Object obj) {
        lVar.getClass();
        return obj == null ? b.f11569a : new d(new x2(obj, 27), lVar);
    }

    public static List U(f fVar) {
        Iterator it = fVar.iterator();
        if (!it.hasNext()) {
            return t.f12808a;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return a4.u(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
