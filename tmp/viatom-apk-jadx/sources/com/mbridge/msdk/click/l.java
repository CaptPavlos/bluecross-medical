package com.mbridge.msdk.click;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.download.Command;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    private static volatile AtomicInteger f2833a = new AtomicInteger(1);

    /* renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.c.g f2834b;

    /* renamed from: c, reason: collision with root package name */
    private String f2835c;

    /* renamed from: d, reason: collision with root package name */
    private int f2836d = 9377;

    public l() {
        com.mbridge.msdk.c.g gVarS = androidx.constraintlayout.core.widgets.analyzer.a.s(com.mbridge.msdk.c.h.a());
        this.f2834b = gVarS;
        if (gVarS == null) {
            com.mbridge.msdk.c.h.a();
            this.f2834b = com.mbridge.msdk.c.i.a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x01c8 A[Catch: Exception -> 0x0189, TRY_ENTER, TRY_LEAVE, TryCatch #4 {Exception -> 0x0189, blocks: (B:62:0x0182, B:63:0x0185, B:69:0x01a2, B:78:0x01c8), top: B:98:0x0013 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.mbridge.msdk.click.entity.a a(java.lang.String r20, java.lang.String r21) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 485
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.l.a(java.lang.String, java.lang.String):com.mbridge.msdk.click.entity.a");
    }

    private JSONObject b(String str, CampaignEx campaignEx, boolean z9, boolean z10) {
        JSONObject jSONObject = new JSONObject();
        try {
            Uri uri = Uri.parse(str);
            if (uri != null) {
                String host = uri.getHost();
                String path = uri.getPath();
                String encodedQuery = uri.getEncodedQuery();
                this.f2835c = host;
                jSONObject.put("uri", "https://" + host + path);
                jSONObject.put(DataSchemeDataSource.SCHEME_DATA, encodedQuery);
            }
        } catch (Throwable th) {
            af.b("SocketSpider", th.getMessage());
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (!z9 && !z10) {
                jSONObject2.put(Command.HTTP_HEADER_USER_AGENT, ab.g());
            }
            if (campaignEx != null) {
                if (z9 && campaignEx.getcUA() == 1) {
                    jSONObject2.put(Command.HTTP_HEADER_USER_AGENT, ab.g());
                }
                if (z10 && campaignEx.getImpUA() == 1) {
                    jSONObject2.put(Command.HTTP_HEADER_USER_AGENT, ab.g());
                }
            } else {
                jSONObject2.put(Command.HTTP_HEADER_USER_AGENT, ab.g());
            }
            jSONObject2.put("Accept-Encoding", "gzip");
            if (this.f2834b.aJ() && !TextUtils.isEmpty(str)) {
                jSONObject2.put("referer", str);
            }
            jSONObject.put("header", jSONObject2);
        } catch (Throwable th2) {
            af.b("SocketSpider", th2.getMessage());
        }
        return jSONObject;
    }

    public final com.mbridge.msdk.click.entity.a a(String str, CampaignEx campaignEx, boolean z9, boolean z10) {
        com.mbridge.msdk.click.entity.a aVar = new com.mbridge.msdk.click.entity.a();
        aVar.g = str;
        if (TextUtils.isEmpty(str)) {
            aVar.h = "request url can not null.";
            return aVar;
        }
        String strReplace = str.replace(" ", "%20");
        JSONObject jSONObjectB = b(strReplace, campaignEx, z9, z10);
        if (jSONObjectB.length() == 0) {
            aVar.h = "request content generation failed.";
            return aVar;
        }
        if (TextUtils.isEmpty(jSONObjectB.optString("uri"))) {
            aVar.h = "request url parse error.";
            return aVar;
        }
        if (campaignEx != null) {
            int trackingTcpPort = campaignEx.getTrackingTcpPort();
            if (trackingTcpPort == 0) {
                trackingTcpPort = 9377;
            }
            this.f2836d = trackingTcpPort;
        }
        if (TextUtils.isEmpty(this.f2835c)) {
            aVar.h = "request url parse error.";
            return aVar;
        }
        return a(strReplace, jSONObjectB.toString());
    }

    private String a(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[1024];
        while (true) {
            int i10 = gZIPInputStream.read(bArr2, 0, 1024);
            if (i10 > 0) {
                byteArrayOutputStream.write(bArr2, 0, i10);
            } else {
                gZIPInputStream.close();
                byteArrayInputStream.close();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toString();
            }
        }
    }
}
