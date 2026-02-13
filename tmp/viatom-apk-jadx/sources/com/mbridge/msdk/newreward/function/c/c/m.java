package com.mbridge.msdk.newreward.function.c.c;

import android.text.TextUtils;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m extends c {

    /* renamed from: c, reason: collision with root package name */
    private final String f4726c;

    public m(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.function.c.a.a aVar, String str) {
        super(bVar, aVar);
        this.f4726c = str;
        b(true);
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.c
    public final boolean a_() {
        return true;
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.o
    public final int b_() {
        return 7;
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.o
    public final String j() {
        return TextUtils.isEmpty(this.f4726c) ? "" : this.f4726c;
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.o
    public final q l() {
        return new v(b(), c(), this);
    }
}
