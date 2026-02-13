package com.mbridge.msdk.foundation.same.report;

import com.mbridge.msdk.tracker.network.r;
import com.mbridge.msdk.tracker.network.w;
import com.mbridge.msdk.tracker.v;
import java.io.UnsupportedEncodingException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m extends v {
    @Override // com.mbridge.msdk.tracker.v
    public final w<String> a(r rVar) {
        String str;
        try {
            str = new String(rVar.f5444b, com.mbridge.msdk.tracker.network.toolbox.f.a(rVar.f5445c));
        } catch (UnsupportedEncodingException unused) {
            str = new String(rVar.f5444b);
        }
        return w.a(str, com.mbridge.msdk.tracker.network.toolbox.f.a(rVar));
    }
}
