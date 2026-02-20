package com.mbridge.msdk.newreward.function.command.a;

import com.mbridge.msdk.newreward.function.command.e;
import com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.ReportReceiver;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends com.mbridge.msdk.newreward.function.command.a {

    /* renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.command.receiver.b f4759a;

    public b(Object obj) {
        this.f4759a = new ReportReceiver(obj);
    }

    @Override // com.mbridge.msdk.newreward.function.command.a
    public final <T extends e> T a(com.mbridge.msdk.newreward.function.command.b bVar) {
        com.mbridge.msdk.newreward.function.command.receiver.b bVar2;
        if (bVar != null && (bVar2 = this.f4759a) != null) {
            bVar2.a(bVar);
        }
        return null;
    }

    @Override // com.mbridge.msdk.newreward.function.command.a
    public final void a(com.mbridge.msdk.newreward.function.command.b bVar, com.mbridge.msdk.newreward.a.b.b bVar2) {
    }
}
