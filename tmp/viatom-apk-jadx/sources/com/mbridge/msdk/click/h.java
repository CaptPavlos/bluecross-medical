package com.mbridge.msdk.click;

import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.browser.trusted.sharing.ShareTarget;
import com.mbridge.msdk.foundation.download.Command;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static final String f2817a = "h";

    /* renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.c.g f2818b;

    /* renamed from: c, reason: collision with root package name */
    private String f2819c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f2820d = true;
    private final int e = 3145728;
    private com.mbridge.msdk.click.entity.a f;

    public h() {
        com.mbridge.msdk.c.g gVarS = androidx.constraintlayout.core.widgets.analyzer.a.s(com.mbridge.msdk.c.h.a());
        this.f2818b = gVarS;
        if (gVarS == null) {
            com.mbridge.msdk.c.h.a();
            this.f2818b = com.mbridge.msdk.c.i.a();
        }
    }

    public final com.mbridge.msdk.click.entity.a a(String str, boolean z9, boolean z10, CampaignEx campaignEx) {
        HttpURLConnection httpURLConnection;
        int i10;
        HttpURLConnection httpURLConnection2 = null;
        if (!URLUtil.isNetworkUrl(str)) {
            return null;
        }
        String strReplace = str.replace(" ", "%20");
        this.f = new com.mbridge.msdk.click.entity.a();
        try {
            httpURLConnection = (HttpURLConnection) new URL(strReplace).openConnection();
        } catch (Throwable th) {
            th = th;
        }
        try {
            httpURLConnection.setRequestMethod(ShareTarget.METHOD_GET);
            if ((!z9 && !z10) || campaignEx == null) {
                httpURLConnection.setRequestProperty(Command.HTTP_HEADER_USER_AGENT, ab.g());
            }
            if (z9 && campaignEx != null && campaignEx.getcUA() == 1) {
                httpURLConnection.setRequestProperty(Command.HTTP_HEADER_USER_AGENT, ab.g());
            }
            if (z10 && campaignEx != null && campaignEx.getImpUA() == 1) {
                httpURLConnection.setRequestProperty(Command.HTTP_HEADER_USER_AGENT, ab.g());
            }
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            if (this.f2818b.aJ() && !TextUtils.isEmpty(this.f2819c)) {
                httpURLConnection.setRequestProperty("referer", this.f2819c);
            }
            httpURLConnection.setConnectTimeout(MBridgeCommon.DEFAULT_LOAD_TIMEOUT);
            httpURLConnection.setReadTimeout(MBridgeCommon.DEFAULT_LOAD_TIMEOUT);
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.connect();
            this.f.f2804a = httpURLConnection.getHeaderField("Location");
            this.f.f2807d = httpURLConnection.getHeaderField("Referer");
            this.f.f = httpURLConnection.getResponseCode();
            this.f.f2805b = httpURLConnection.getContentType();
            this.f.e = httpURLConnection.getContentLength();
            this.f.f2806c = httpURLConnection.getContentEncoding();
            boolean zEqualsIgnoreCase = "gzip".equalsIgnoreCase(this.f.f2806c);
            com.mbridge.msdk.click.entity.a aVar = this.f;
            if (aVar.f == 200 && this.f2820d && (i10 = aVar.e) > 0 && i10 < 3145728 && !TextUtils.isEmpty(strReplace)) {
                try {
                    String strA = a(httpURLConnection.getInputStream(), zEqualsIgnoreCase);
                    if (!TextUtils.isEmpty(strA)) {
                        byte[] bytes = strA.getBytes();
                        if (bytes.length > 0 && bytes.length < 3145728) {
                            this.f.g = strA.trim();
                        }
                    }
                } catch (Throwable th2) {
                    af.b(f2817a, th2.getMessage());
                }
            }
            this.f2819c = strReplace;
            httpURLConnection.disconnect();
            return this.f;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection2 = httpURLConnection;
            try {
                this.f.h = th.getMessage();
                return this.f;
            } finally {
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0040 A[Catch: all -> 0x000f, TryCatch #5 {all -> 0x000f, blocks: (B:4:0x0008, B:9:0x0013, B:22:0x003c, B:24:0x0040, B:25:0x004d), top: B:41:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0058 A[Catch: Exception -> 0x0031, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x0031, blocks: (B:18:0x002d, B:27:0x0058), top: B:39:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String a(java.io.InputStream r4, boolean r5) throws java.lang.Throwable {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            if (r5 == 0) goto L13
            java.util.zip.GZIPInputStream r5 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> Lf java.lang.Exception -> L11
            r5.<init>(r4)     // Catch: java.lang.Throwable -> Lf java.lang.Exception -> L11
            r4 = r5
            goto L13
        Lf:
            r4 = move-exception
            goto L60
        L11:
            r4 = move-exception
            goto L3c
        L13:
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> Lf java.lang.Exception -> L11
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> Lf java.lang.Exception -> L11
            r2.<init>(r4)     // Catch: java.lang.Throwable -> Lf java.lang.Exception -> L11
            r5.<init>(r2)     // Catch: java.lang.Throwable -> Lf java.lang.Exception -> L11
        L1d:
            java.lang.String r4 = r5.readLine()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2a
            if (r4 == 0) goto L2d
            r0.append(r4)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2a
            goto L1d
        L27:
            r4 = move-exception
            r1 = r5
            goto L60
        L2a:
            r4 = move-exception
            r1 = r5
            goto L3c
        L2d:
            r5.close()     // Catch: java.lang.Exception -> L31
            goto L5b
        L31:
            r4 = move-exception
            java.lang.String r5 = com.mbridge.msdk.click.h.f2817a
            java.lang.String r4 = r4.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r5, r4)
            goto L5b
        L3c:
            com.mbridge.msdk.click.entity.a r5 = r3.f     // Catch: java.lang.Throwable -> Lf
            if (r5 != 0) goto L4d
            com.mbridge.msdk.click.entity.a r5 = new com.mbridge.msdk.click.entity.a     // Catch: java.lang.Throwable -> Lf
            r5.<init>()     // Catch: java.lang.Throwable -> Lf
            r3.f = r5     // Catch: java.lang.Throwable -> Lf
            java.lang.String r2 = r4.getMessage()     // Catch: java.lang.Throwable -> Lf
            r5.h = r2     // Catch: java.lang.Throwable -> Lf
        L4d:
            java.lang.String r5 = com.mbridge.msdk.click.h.f2817a     // Catch: java.lang.Throwable -> Lf
            java.lang.String r4 = r4.getMessage()     // Catch: java.lang.Throwable -> Lf
            com.mbridge.msdk.foundation.tools.af.b(r5, r4)     // Catch: java.lang.Throwable -> Lf
            if (r1 == 0) goto L5b
            r1.close()     // Catch: java.lang.Exception -> L31
        L5b:
            java.lang.String r4 = r0.toString()
            return r4
        L60:
            if (r1 == 0) goto L70
            r1.close()     // Catch: java.lang.Exception -> L66
            goto L70
        L66:
            r5 = move-exception
            java.lang.String r0 = com.mbridge.msdk.click.h.f2817a
            java.lang.String r5 = r5.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r0, r5)
        L70:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.h.a(java.io.InputStream, boolean):java.lang.String");
    }
}
