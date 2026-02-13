package com.mbridge.msdk.newreward.a.b;

import com.mbridge.msdk.newreward.function.c.c.q;
import com.mbridge.msdk.newreward.function.c.c.x;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import java.io.IOException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k implements a {
    @Override // com.mbridge.msdk.newreward.a.b.a
    public final void a(Object obj, final b bVar) throws IOException {
        com.mbridge.msdk.newreward.function.c.a.a aVar = (com.mbridge.msdk.newreward.function.c.a.a) obj;
        com.mbridge.msdk.newreward.function.c.c.m mVarA = aVar.a();
        if (aVar.h() != null && aVar.h().isDynamicView()) {
            if (bVar != null) {
                bVar.reqSuccessful(aVar);
            }
        } else if (mVarA != null) {
            mVarA.l().a(0, new x() { // from class: com.mbridge.msdk.newreward.a.b.k.1
                @Override // com.mbridge.msdk.newreward.function.c.c.x
                public final void a(com.mbridge.msdk.newreward.function.c.a.b bVar2, com.mbridge.msdk.newreward.function.c.a.a aVar2, q qVar, MBridgeError mBridgeError) {
                    if (bVar2.y()) {
                        bVar.reqSuccessful(aVar2);
                    }
                }

                @Override // com.mbridge.msdk.newreward.function.c.c.x
                public final void b(com.mbridge.msdk.newreward.function.c.a.b bVar2, com.mbridge.msdk.newreward.function.c.a.a aVar2, q qVar) {
                    if (bVar2.y()) {
                        bVar.reqSuccessful(aVar2);
                    }
                }

                @Override // com.mbridge.msdk.newreward.function.c.c.x
                public final void a(com.mbridge.msdk.newreward.function.c.a.b bVar2, com.mbridge.msdk.newreward.function.c.a.a aVar2, q qVar) {
                }

                @Override // com.mbridge.msdk.newreward.function.c.c.x
                public final void b(com.mbridge.msdk.newreward.function.c.a.b bVar2, com.mbridge.msdk.newreward.function.c.a.a aVar2, q qVar, MBridgeError mBridgeError) {
                    if (bVar2.y()) {
                        bVar.reqSuccessful(aVar2);
                    }
                }
            });
        } else if (bVar != null) {
            bVar.reqSuccessful(aVar);
        }
    }
}
