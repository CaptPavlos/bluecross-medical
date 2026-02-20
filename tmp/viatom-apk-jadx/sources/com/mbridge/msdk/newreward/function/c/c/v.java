package com.mbridge.msdk.newreward.function.c.c;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadProgress;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.OnProgressStateListener;
import com.mbridge.msdk.foundation.download.core.DownloadRequest;
import com.mbridge.msdk.foundation.download.download.HTMLResourceManager;
import com.mbridge.msdk.foundation.download.download.ResourceManager;
import com.mbridge.msdk.foundation.download.resource.MBResourceManager;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import java.security.NoSuchAlgorithmException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class v extends q implements OnDownloadStateListener<com.mbridge.msdk.newreward.function.c.a.b>, OnProgressStateListener<com.mbridge.msdk.newreward.function.c.a.b> {

    /* renamed from: a, reason: collision with root package name */
    private final String f4735a;

    /* renamed from: b, reason: collision with root package name */
    private final String f4736b;

    /* renamed from: c, reason: collision with root package name */
    private final String f4737c;

    /* renamed from: d, reason: collision with root package name */
    private final com.mbridge.msdk.newreward.function.c.a.b f4738d;
    private final com.mbridge.msdk.newreward.function.c.a.a e;
    private final c f;
    private final String g;
    private DownloadRequest<?> h;

    /* renamed from: i, reason: collision with root package name */
    private x f4739i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f4740j;

    /* renamed from: k, reason: collision with root package name */
    private String f4741k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f4742l;

    public v(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.function.c.a.a aVar, c cVar) throws NoSuchAlgorithmException {
        this.f4740j = false;
        this.f4742l = false;
        this.f4738d = bVar;
        this.e = aVar;
        this.f = cVar;
        String strJ = cVar.j();
        this.g = strJ;
        if (!TextUtils.isEmpty(strJ)) {
            this.f4742l = strJ.contains(".zip") && strJ.contains(ResourceManager.KEY_MD5FILENAME);
        }
        String strA = com.mbridge.msdk.foundation.same.b.e.a(this.f4742l ? com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_RES : com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_HTML);
        String md5 = SameMD5.getMD5(aq.b(strJ));
        this.f4735a = md5;
        this.f4736b = a3.a.C(strA, "/");
        this.f4737c = a3.a.j(strA, "/", md5);
        cVar.a(true);
        String resDirFromCampaign = this.f4742l ? ResourceManager.getinstance().getResDirFromCampaign(strJ) : HTMLResourceManager.getInstance().getHtmlContentFromUrl(strJ);
        if (TextUtils.isEmpty(resDirFromCampaign)) {
            return;
        }
        this.f4740j = true;
        cVar.a(1);
        cVar.a(resDirFromCampaign);
        cVar.b(true);
        cVar.a(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0097  */
    @Override // com.mbridge.msdk.newreward.function.c.c.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(int r7, com.mbridge.msdk.newreward.function.c.c.x r8) {
        /*
            r6 = this;
            r6.f4739i = r8
            if (r8 == 0) goto Lb
            com.mbridge.msdk.newreward.function.c.a.b r7 = r6.f4738d
            com.mbridge.msdk.newreward.function.c.a.a r0 = r6.e
            r8.a(r7, r0, r6)
        Lb:
            boolean r7 = r6.f4740j
            if (r7 == 0) goto L1b
            com.mbridge.msdk.newreward.function.c.c.x r7 = r6.f4739i
            if (r7 == 0) goto L1a
            com.mbridge.msdk.newreward.function.c.a.b r8 = r6.f4738d
            com.mbridge.msdk.newreward.function.c.a.a r0 = r6.e
            r7.b(r8, r0, r6)
        L1a:
            return
        L1b:
            boolean r7 = r6.f4742l
            java.lang.String r8 = r6.f4735a
            if (r7 == 0) goto L29
            java.lang.String r7 = ".zip"
        L23:
            java.lang.String r7 = a3.a.C(r8, r7)
            r3 = r7
            goto L2c
        L29:
            java.lang.String r7 = ".html"
            goto L23
        L2c:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = r6.f4736b
            java.lang.String r7 = a3.a.o(r7, r8, r3)
            r6.f4741k = r7
            com.mbridge.msdk.foundation.download.DownloadMessage r0 = new com.mbridge.msdk.foundation.download.DownloadMessage
            com.mbridge.msdk.newreward.function.c.a.b r1 = r6.f4738d
            java.lang.String r2 = r6.g
            boolean r7 = r6.f4742l
            if (r7 == 0) goto L47
            com.mbridge.msdk.foundation.download.DownloadResourceType r7 = com.mbridge.msdk.foundation.download.DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_ZIP
        L45:
            r5 = r7
            goto L4a
        L47:
            com.mbridge.msdk.foundation.download.DownloadResourceType r7 = com.mbridge.msdk.foundation.download.DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_HTML
            goto L45
        L4a:
            r4 = 100
            r0.<init>(r1, r2, r3, r4, r5)
            com.mbridge.msdk.foundation.download.MBDownloadManager r7 = com.mbridge.msdk.foundation.download.MBDownloadManager.getInstance()
            com.mbridge.msdk.foundation.download.core.DownloadRequestBuilder r7 = r7.download(r0)
            r0 = 30000(0x7530, double:1.4822E-319)
            com.mbridge.msdk.foundation.download.core.DownloadRequestBuilder r7 = r7.withReadTimeout(r0)
            com.mbridge.msdk.foundation.download.core.DownloadRequestBuilder r7 = r7.withConnectTimeout(r0)
            com.mbridge.msdk.foundation.download.core.RequestBuilder r7 = r7.withWriteTimeout(r0)
            com.mbridge.msdk.foundation.download.DownloadPriority r8 = com.mbridge.msdk.foundation.download.DownloadPriority.IMMEDIATE
            com.mbridge.msdk.foundation.download.core.RequestBuilder r7 = r7.withDownloadPriority(r8)
            r8 = 5
            com.mbridge.msdk.foundation.download.core.RequestBuilder r7 = r7.withHttpRetryCounter(r8)
            java.lang.String r8 = r6.f4736b
            com.mbridge.msdk.foundation.download.core.RequestBuilder r7 = r7.withDirectoryPathInternal(r8)
            com.mbridge.msdk.foundation.download.core.RequestBuilder r7 = r7.withDownloadStateListener(r6)
            com.mbridge.msdk.foundation.download.core.RequestBuilder r7 = r7.withProgressStateListener(r6)
            r0 = 60000(0xea60, double:2.9644E-319)
            com.mbridge.msdk.foundation.download.core.RequestBuilder r7 = r7.withTimeout(r0)
            com.mbridge.msdk.newreward.function.c.c.c r8 = r6.f
            if (r8 != 0) goto L8a
            goto L97
        L8a:
            int r8 = r8.b_()
            r0 = 2
            if (r8 == r0) goto La0
            r0 = 3
            if (r8 == r0) goto L9d
            r0 = 4
            if (r8 == r0) goto L9a
        L97:
            java.lang.String r8 = "un_known"
            goto La2
        L9a:
            java.lang.String r8 = "download_end_card"
            goto La2
        L9d:
            java.lang.String r8 = "download_big_template"
            goto La2
        La0:
            java.lang.String r8 = "download_template"
        La2:
            java.lang.String r0 = "download_scene"
            com.mbridge.msdk.foundation.download.core.RequestBuilder r7 = r7.with(r0, r8)
            r8 = 1
            java.lang.String r8 = java.lang.Boolean.toString(r8)
            java.lang.String r0 = "do_us_fi_re"
            com.mbridge.msdk.foundation.download.core.RequestBuilder r7 = r7.with(r0, r8)
            com.mbridge.msdk.foundation.download.core.DownloadRequest r7 = r7.build()
            r6.h = r7
            r7.start()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.c.c.v.a(int, com.mbridge.msdk.newreward.function.c.c.x):void");
    }

    @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
    public final void onCancelDownload(DownloadMessage<com.mbridge.msdk.newreward.function.c.a.b> downloadMessage) {
        this.f.a(TextUtils.equals(this.h.get("cache", "2"), "2") ? 2 : 1);
        this.f.b(false);
        this.f.a(false);
        boolean zD = this.f.d();
        x xVar = this.f4739i;
        if (zD) {
            if (xVar != null) {
                xVar.b(this.f4738d, this.e, this);
            }
        } else if (xVar != null) {
            xVar.a(this.f4738d, this.e, this, new MBridgeError(4, MBridgeError.ERROR_MESSAGE_DOWNLOAD_DOWNLOAD_TIMEOUT));
        }
    }

    @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
    public final void onDownloadComplete(DownloadMessage<com.mbridge.msdk.newreward.function.c.a.b> downloadMessage) {
        String str = MBridgeError.ERROR_MESSAGE_DOWNLOAD_UN_ZIP_ERROR;
        Exception exc = null;
        try {
            try {
                if (this.f4742l) {
                    MBResourceManager.getInstance().unZip(this.f4741k, this.f4737c);
                }
                String resDirFromCampaign = this.f4742l ? ResourceManager.getinstance().getResDirFromCampaign(this.g) : HTMLResourceManager.getInstance().getHtmlContentFromUrl(this.g);
                this.f.b(true);
                this.f.a(false);
                this.f.a(TextUtils.equals(this.h.get("cache", "2"), "2") ? 2 : 1);
                this.f.a(resDirFromCampaign);
                boolean zD = this.f.d();
                x xVar = this.f4739i;
                if (zD) {
                    if (xVar != null) {
                        xVar.b(this.f4738d, this.e, this);
                    }
                } else if (xVar != null) {
                    xVar.a(this.f4738d, this.e, this, new MBridgeError(6, MBridgeError.ERROR_MESSAGE_DOWNLOAD_UN_ZIP_ERROR));
                }
            } catch (Exception e) {
                exc = e;
                if (MBridgeConstans.DEBUG) {
                    af.a("MBridgeDownloader", "onDownloadComplete.unZip: " + exc.getMessage());
                }
                boolean zD2 = this.f.d();
                x xVar2 = this.f4739i;
                if (zD2) {
                    if (xVar2 != null) {
                        xVar2.b(this.f4738d, this.e, this);
                    }
                } else if (xVar2 != null) {
                    this.f4739i.a(this.f4738d, this.e, this, new MBridgeError(6, "unzip error:" + exc.getMessage()));
                }
            }
        } catch (Throwable th) {
            boolean zD3 = this.f.d();
            x xVar3 = this.f4739i;
            if (zD3) {
                if (xVar3 != null) {
                    xVar3.b(this.f4738d, this.e, this);
                }
            } else if (xVar3 != null) {
                if (exc != null) {
                    str = "unzip error:" + exc.getMessage();
                }
                this.f4739i.a(this.f4738d, this.e, this, new MBridgeError(6, str));
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0054  */
    @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onDownloadError(com.mbridge.msdk.foundation.download.DownloadMessage<com.mbridge.msdk.newreward.function.c.a.b> r3, com.mbridge.msdk.foundation.download.DownloadError r4) {
        /*
            r2 = this;
            com.mbridge.msdk.foundation.download.core.DownloadRequest<?> r3 = r2.h
            java.lang.String r0 = "cache"
            java.lang.String r1 = "2"
            java.lang.String r3 = r3.get(r0, r1)
            com.mbridge.msdk.newreward.function.c.c.c r0 = r2.f
            boolean r3 = android.text.TextUtils.equals(r3, r1)
            r1 = 2
            if (r3 == 0) goto L15
            r3 = r1
            goto L16
        L15:
            r3 = 1
        L16:
            r0.a(r3)
            com.mbridge.msdk.newreward.function.c.c.c r3 = r2.f
            r0 = 0
            r3.b(r0)
            com.mbridge.msdk.newreward.function.c.c.c r3 = r2.f
            r3.a(r0)
            com.mbridge.msdk.newreward.function.c.c.c r3 = r2.f
            boolean r3 = r3.d()
            com.mbridge.msdk.newreward.function.c.c.x r0 = r2.f4739i
            if (r3 == 0) goto L38
            if (r0 == 0) goto L6b
            com.mbridge.msdk.newreward.function.c.a.b r3 = r2.f4738d
            com.mbridge.msdk.newreward.function.c.a.a r4 = r2.e
            r0.b(r3, r4, r2)
            return
        L38:
            if (r0 == 0) goto L6b
            com.mbridge.msdk.newreward.function.c.c.c r3 = r2.f
            if (r3 == 0) goto L54
            int r3 = r3.b_()
            if (r3 == r1) goto L51
            r0 = 3
            if (r3 == r0) goto L4e
            r0 = 4
            if (r3 == r0) goto L4b
            goto L54
        L4b:
            java.lang.String r3 = "ec template error"
            goto L56
        L4e:
            java.lang.String r3 = "big template error"
            goto L56
        L51:
            java.lang.String r3 = "video template error"
            goto L56
        L54:
            java.lang.String r3 = "network error"
        L56:
            com.mbridge.msdk.newreward.function.common.MBridgeError r0 = new com.mbridge.msdk.newreward.function.common.MBridgeError
            r0.<init>(r1, r3)
            java.lang.Exception r3 = r4.getException()
            r0.setException(r3)
            com.mbridge.msdk.newreward.function.c.c.x r3 = r2.f4739i
            com.mbridge.msdk.newreward.function.c.a.b r4 = r2.f4738d
            com.mbridge.msdk.newreward.function.c.a.a r1 = r2.e
            r3.a(r4, r1, r2, r0)
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.c.c.v.onDownloadError(com.mbridge.msdk.foundation.download.DownloadMessage, com.mbridge.msdk.foundation.download.DownloadError):void");
    }

    @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
    public final void onDownloadStart(DownloadMessage<com.mbridge.msdk.newreward.function.c.a.b> downloadMessage) {
    }

    @Override // com.mbridge.msdk.foundation.download.OnProgressStateListener
    public final void onProgress(DownloadMessage<com.mbridge.msdk.newreward.function.c.a.b> downloadMessage, DownloadProgress downloadProgress) {
    }
}
