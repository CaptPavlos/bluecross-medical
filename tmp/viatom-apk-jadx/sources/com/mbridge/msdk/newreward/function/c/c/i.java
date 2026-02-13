package com.mbridge.msdk.newreward.function.c.c;

import android.text.TextUtils;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i extends c {
    public i(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.function.c.a.a aVar) {
        super(bVar, aVar);
        b(true);
        a(false);
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.c
    public final boolean a_() {
        return true;
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.o
    public final int b_() {
        return 3;
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.o
    public final String j() {
        if (c() == null) {
            return "";
        }
        String strB = b().B();
        return TextUtils.isEmpty(strB) ? "" : strB;
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.o
    public final q l() {
        return new z(b(), c(), this);
    }
}
