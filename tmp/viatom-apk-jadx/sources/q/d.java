package q;

import android.content.Context;
import com.google.android.datatransport.cct.CctBackendFactory;
import i0.k;
import java.util.HashMap;
import l4.p2;
import t3.h;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final k f12215a;

    /* renamed from: b, reason: collision with root package name */
    public final p2 f12216b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f12217c;

    public d(Context context, p2 p2Var) {
        k kVar = new k(context, 21);
        this.f12217c = new HashMap();
        this.f12215a = kVar;
        this.f12216b = p2Var;
    }

    public final synchronized e a(String str) {
        if (this.f12217c.containsKey(str)) {
            return (e) this.f12217c.get(str);
        }
        CctBackendFactory cctBackendFactoryO = this.f12215a.o(str);
        if (cctBackendFactoryO == null) {
            return null;
        }
        p2 p2Var = this.f12216b;
        e eVarCreate = cctBackendFactoryO.create(new b((Context) p2Var.f10716c, (h) p2Var.f10717d, (h) p2Var.f10715b, str));
        this.f12217c.put(str, eVarCreate);
        return eVarCreate;
    }
}
