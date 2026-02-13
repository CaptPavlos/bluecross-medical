package i0;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class h extends e implements g0.b {
    public final Set y;

    /* JADX WARN: Illegal instructions before constructor call */
    public h(Context context, Looper looper, int i10, d5.j jVar, g0.e eVar, g0.f fVar, int i11) {
        j0 j0VarA = j0.a(context);
        f0.e eVar2 = f0.e.f8001d;
        y.g(eVar);
        y.g(fVar);
        super(context, looper, j0VarA, eVar2, i10, new l(eVar), new l(fVar), (String) jVar.e);
        Set set = (Set) jVar.f7135c;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (!set.contains((Scope) it.next())) {
                androidx.window.layout.c.g("Expanding scopes is not permitted, use implied scopes instead");
                throw null;
            }
        }
        this.y = set;
    }

    @Override // g0.b
    public final Set b() {
        return l() ? this.y : Collections.EMPTY_SET;
    }

    @Override // i0.e
    public final Account p() {
        return null;
    }

    @Override // i0.e
    public final Set s() {
        return this.y;
    }
}
