package com.mbridge.msdk.newreward.function.c.c;

import java.io.File;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n extends a<File> {

    /* renamed from: b, reason: collision with root package name */
    private final y f4727b;

    /* renamed from: c, reason: collision with root package name */
    private File f4728c;

    public n(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.function.c.a.a aVar) {
        super(bVar, aVar);
        this.f4727b = new y(b(), c(), this, 100);
    }

    public final void a(File file) {
        this.f4728c = file;
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.o
    public final int b_() {
        return 1;
    }

    public final File g() {
        return this.f4728c;
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.o
    public final boolean h() {
        if (c() == null || c().h() == null) {
            return true;
        }
        ArrayList<Integer> rsIgnoreCheckRule = c().h().getRsIgnoreCheckRule();
        if (rsIgnoreCheckRule == null) {
            return false;
        }
        return rsIgnoreCheckRule.contains(0);
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.o
    public final String j() {
        return (c() == null || c().h() == null) ? "" : c().h().getVideoUrlEncode();
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.o
    public final boolean k() {
        return true;
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.o
    public final q l() {
        return this.f4727b;
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.a
    public final /* bridge */ /* synthetic */ File a() {
        return this.f4728c;
    }
}
