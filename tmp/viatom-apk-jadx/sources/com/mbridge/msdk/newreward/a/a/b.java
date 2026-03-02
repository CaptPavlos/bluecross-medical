package com.mbridge.msdk.newreward.a.a;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.function.command.c;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends a {
    public b(c cVar) {
        super(cVar);
    }

    @Override // com.mbridge.msdk.newreward.a.b.b
    public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
        if (bVar != null && this.f4513c != null) {
            try {
                if (bVar.i() == -1) {
                    this.f4513c.a(System.currentTimeMillis());
                }
                this.f4513c.b(bVar.i() + "");
                com.mbridge.msdk.foundation.same.net.e.c.a().a(this.f4513c.B() + "_" + this.f4513c.C() + "_" + this.f4513c.H() + "_" + this.f4513c.h(), bVar.i(), bVar.k(), System.currentTimeMillis());
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        if (this.f4513c.d() || this.f4513c.e() || this.f4513c.f()) {
            a(this.f4512b, bVar);
        } else {
            a(bVar);
        }
    }

    @Override // com.mbridge.msdk.newreward.a.b.b
    public final void reqSuccessful(Object obj) {
        Map map = (Map) obj;
        a(((Integer) map.get(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY)).intValue(), map.get("object"));
    }
}
