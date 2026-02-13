package com.mbridge.msdk.newreward.function.c.c;

import java.io.File;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class b extends d<File> {

    /* renamed from: b, reason: collision with root package name */
    private File f4718b;

    public b(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.function.c.a.a aVar) {
        super(bVar, aVar);
    }

    public final void a(File file) {
        this.f4718b = file;
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.d
    public final boolean g() {
        return true;
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.o
    public final boolean h() {
        return true;
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.a
    public final /* bridge */ /* synthetic */ Object a() {
        return this.f4718b;
    }
}
