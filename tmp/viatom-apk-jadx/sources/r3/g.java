package r3;

import java.util.HashMap;
import java.util.List;
import m3.h;
import m3.i;
import p3.w;
import p8.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g extends a {
    @Override // r3.a
    public final void b(String str, p3.b bVar) {
        p3.c cVar = (p3.c) bVar;
        if (str == null || str.length() != 4) {
            throw new o3.a(androidx.constraintlayout.core.widgets.analyzer.a.x("Invalid uspv1 string: '", str, "'"));
        }
        try {
            List list = w.f11917a;
            cVar.get("Version").setValue(Integer.valueOf(Integer.parseInt(str.substring(0, 1))));
            cVar.get("Notice").setValue(Character.valueOf(str.charAt(1)));
            cVar.get("OptOutSale").setValue(Character.valueOf(str.charAt(2)));
            cVar.get("LspaCovered").setValue(Character.valueOf(str.charAt(3)));
        } catch (Exception e) {
            u.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode UspV1CoreSegment '", str, "'"), e);
        }
    }

    @Override // r3.a
    public final String d(p3.b bVar) {
        p3.c cVar = (p3.c) bVar;
        StringBuilder sb = new StringBuilder("");
        List list = w.f11917a;
        sb.append(cVar.get("Version").getValue());
        StringBuilder sbV = a3.a.v(sb.toString());
        sbV.append(cVar.get("Notice").getValue());
        StringBuilder sbV2 = a3.a.v(sbV.toString());
        sbV2.append(cVar.get("OptOutSale").getValue());
        StringBuilder sbV3 = a3.a.v(sbV2.toString());
        sbV3.append(cVar.get("LspaCovered").getValue());
        return sbV3.toString();
    }

    @Override // r3.a
    public final p3.b f() {
        p3.c cVar = new p3.c();
        HashMap map = new HashMap();
        cVar.f11879a = map;
        List list = w.f11917a;
        h hVar = new h();
        hVar.f11187c = null;
        hVar.f11186b = new i(0);
        hVar.setValue(1);
        map.put("Version", hVar);
        map.put("Notice", new h(new e(19)));
        map.put("OptOutSale", new h(new e(20)));
        map.put("LspaCovered", new h(new e(21)));
        return cVar;
    }
}
