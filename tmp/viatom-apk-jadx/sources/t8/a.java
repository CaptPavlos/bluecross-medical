package t8;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.net.ProtocolException;
import p8.a0;
import p8.b0;
import p8.d0;
import p8.t;
import p8.z;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a implements t {
    @Override // p8.t
    public final b0 a(e eVar) throws IOException {
        b bVar = eVar.f12868c;
        s8.f fVar = eVar.f12867b;
        z zVar = eVar.f;
        long jCurrentTimeMillis = System.currentTimeMillis();
        eVar.h.getClass();
        bVar.c(zVar);
        a.a.G(zVar.f12206b);
        bVar.finishRequest();
        a0 responseHeaders = bVar.readResponseHeaders(false);
        responseHeaders.f12051a = zVar;
        responseHeaders.e = fVar.a().f;
        responseHeaders.f12057k = jCurrentTimeMillis;
        responseHeaders.f12058l = System.currentTimeMillis();
        b0 b0VarA = responseHeaders.a();
        int i10 = b0VarA.f12065c;
        if (i10 == 100) {
            a0 responseHeaders2 = bVar.readResponseHeaders(false);
            responseHeaders2.f12051a = zVar;
            responseHeaders2.e = fVar.a().f;
            responseHeaders2.f12057k = jCurrentTimeMillis;
            responseHeaders2.f12058l = System.currentTimeMillis();
            b0VarA = responseHeaders2.a();
            i10 = b0VarA.f12065c;
        }
        a0 a0VarD = b0VarA.d();
        a0VarD.g = bVar.b(b0VarA);
        b0 b0VarA2 = a0VarD.a();
        d0 d0Var = b0VarA2.g;
        if (CampaignEx.JSON_NATIVE_VIDEO_CLOSE.equalsIgnoreCase(b0VarA2.f12063a.f12207c.a("Connection")) || CampaignEx.JSON_NATIVE_VIDEO_CLOSE.equalsIgnoreCase(b0VarA2.b("Connection"))) {
            fVar.e();
        }
        if ((i10 != 204 && i10 != 205) || d0Var.a() <= 0) {
            return b0VarA2;
        }
        StringBuilder sbR = a3.a.r(i10, "HTTP ", " had non-zero Content-Length: ");
        sbR.append(d0Var.a());
        throw new ProtocolException(sbR.toString());
    }
}
