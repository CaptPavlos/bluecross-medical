package com.mbridge.msdk.foundation.same.b;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends b {
    public d(String str) {
        super(str);
    }

    @Override // com.mbridge.msdk.foundation.same.b.b
    public final List<a> a() {
        ArrayList<a> arrayList = new ArrayList<>();
        a(arrayList, c.MBRIDGE_RES_MANAGER_DIR, "mb/res");
        a(arrayList, c.AD_MOVIES, "mb/res/Movies").a(c.MBRIDGE_VC, "mb/res/.MBridge_VC");
        a aVarA = a(arrayList, c.AD_MBRIDGE_700, "mb/res/.mbridge700");
        aVarA.a(c.MBRIDGE_700_IMG, "mb/res/img");
        aVarA.a(c.MBRIDGE_700_IMG_PICASSO, "mb/res/picasso");
        aVarA.a(c.MBRIDGE_700_RES, "mb/res/res");
        aVarA.a(c.MBRIDGE_700_HTML, "mb/res/html");
        aVarA.a(c.MBRIDGE_700_XML, "mb/res/xml");
        aVarA.a(c.MBRIDGE_700_CONFIG, "mb/config");
        c cVar = c.MBRIDGE_OTHER;
        a(arrayList, cVar, "mb/other");
        a(arrayList, c.MBRIDGE_CRASH_INFO, "mb/crashinfo");
        a(arrayList, cVar, "mb/other");
        return arrayList;
    }
}
