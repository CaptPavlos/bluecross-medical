package com.mbridge.msdk.newreward.function.c.c;

import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadProgress;
import com.mbridge.msdk.foundation.download.DownloadResourceType;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.OnProgressStateListener;
import com.mbridge.msdk.foundation.download.core.DownloadRequest;
import com.mbridge.msdk.foundation.download.resource.MBResourceManager;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
abstract class r extends q implements OnDownloadStateListener<com.mbridge.msdk.newreward.function.c.a.b>, OnProgressStateListener<com.mbridge.msdk.newreward.function.c.a.b> {

    /* renamed from: a, reason: collision with root package name */
    private final com.mbridge.msdk.newreward.function.c.a.b f4729a;

    /* renamed from: b, reason: collision with root package name */
    private final com.mbridge.msdk.newreward.function.c.a.a f4730b;

    /* renamed from: c, reason: collision with root package name */
    private final b f4731c;

    /* renamed from: d, reason: collision with root package name */
    private final String f4732d;
    private final String e;
    private DownloadRequest<?> f;
    private final String g;
    private x h;

    /* renamed from: i, reason: collision with root package name */
    private final String f4733i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f4734j;

    public r(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.function.c.a.a aVar, b bVar2) {
        this.f4734j = false;
        this.f4729a = bVar;
        this.f4730b = aVar;
        this.f4731c = bVar2;
        String strJ = bVar2.j();
        this.f4732d = strJ;
        String str = com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_XML) + File.separator;
        this.f4733i = str;
        String strA = com.mbridge.msdk.newreward.function.h.c.a(strJ);
        this.e = strA;
        String strC = a3.a.C(str, strA.replace(".zip", "").replace(".xml", ""));
        this.g = strC;
        bVar2.a(true);
        File fileA = a(strC);
        if (fileA == null || !fileA.exists()) {
            return;
        }
        this.f4734j = true;
        bVar2.a(1);
        bVar2.a(fileA);
        bVar2.b(true);
        bVar2.a(false);
    }

    private File b(String str) throws Throwable {
        JSONArray jSONArray;
        String strA = com.mbridge.msdk.newreward.function.h.c.a(new File(a3.a.o(a3.a.v(str), File.separator, "template_config.json")));
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        try {
            jSONArray = new JSONArray(strA);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.a("MBridgeDownloader", "findTemplateFile: " + e.getMessage());
            }
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i10);
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("xml_type", "");
                if (!TextUtils.isEmpty(strOptString) && TextUtils.equals(strOptString, b())) {
                    File file = new File(str + File.separator + jSONObjectOptJSONObject.optString(RewardPlus.NAME, ""));
                    if (file.exists()) {
                        return file;
                    }
                }
            }
        }
        return null;
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.p
    public void a(int i10, x xVar) {
        this.h = xVar;
        if (xVar != null) {
            xVar.a(this.f4729a, this.f4730b, this);
        }
        if (a()) {
            if (xVar != null) {
                xVar.b(this.f4729a, this.f4730b, this);
                return;
            }
            return;
        }
        if (this.f4734j) {
            if (xVar != null) {
                xVar.b(this.f4729a, this.f4730b, this);
            }
        } else {
            if (!TextUtils.isEmpty(this.f4732d)) {
                DownloadRequest<?> downloadRequestBuild = MBDownloadManager.getInstance().download(new DownloadMessage<>(this.f4729a, this.f4732d, this.e, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_ZIP)).withReadTimeout(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS).withConnectTimeout(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS).withWriteTimeout(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS).withDownloadPriority(DownloadPriority.HIGH).withHttpRetryCounter(5).withDirectoryPathInternal(this.f4733i).withDownloadStateListener(this).withProgressStateListener(this).withTimeout(ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS).with("download_scene", "download_dynamic_view").with("do_us_fi_re", Boolean.toString(true)).build();
                this.f = downloadRequestBuild;
                downloadRequestBuild.start();
                return;
            }
            if (this.f4731c.d()) {
                if (xVar != null) {
                    xVar.b(this.f4729a, this.f4730b, this);
                }
            } else if (xVar != null) {
                xVar.a(this.f4729a, this.f4730b, this, new MBridgeError(5, MBridgeError.ERROR_MESSAGE_DOWNLOAD_RESOURCE_URL_ERROR));
            }
        }
    }

    public abstract boolean a();

    public abstract String b();

    public com.mbridge.msdk.newreward.function.c.a.a c() {
        return this.f4730b;
    }

    public com.mbridge.msdk.newreward.function.c.a.b d() {
        return this.f4729a;
    }

    public a<?> e() {
        return this.f4731c;
    }

    @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
    public void onCancelDownload(DownloadMessage<com.mbridge.msdk.newreward.function.c.a.b> downloadMessage) {
        this.f4731c.a(TextUtils.equals(this.f.get("cache", "2"), "2") ? 2 : 1);
        this.f4731c.b(false);
        this.f4731c.a(false);
        boolean zD = this.f4731c.d();
        x xVar = this.h;
        if (zD) {
            if (xVar != null) {
                xVar.b(this.f4729a, this.f4730b, this);
            }
        } else if (xVar != null) {
            xVar.a(this.f4729a, this.f4730b, this, new MBridgeError(4, MBridgeError.ERROR_MESSAGE_DOWNLOAD_DOWNLOAD_TIMEOUT));
        }
    }

    @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
    public void onDownloadComplete(DownloadMessage<com.mbridge.msdk.newreward.function.c.a.b> downloadMessage) {
        try {
            try {
                MBResourceManager.getInstance().unZip(downloadMessage.getSaveFilePath(), this.f4733i);
                this.f4731c.a(TextUtils.equals(this.f.get("cache", "2"), "2") ? 2 : 1);
                this.f4731c.b(true);
                this.f4731c.a(false);
                this.f4731c.a(a(this.g));
                this.f4731c.a(2);
                com.mbridge.msdk.newreward.function.command.c cVarB = com.mbridge.msdk.newreward.function.command.d.a().b();
                if (cVarB != null) {
                    cVarB.a(cVarB.a("metrics_config_path", this.g + File.separator + "metrics_config.json", "resource_type", Integer.valueOf(e().b_())), "SharePreReceiver");
                }
                boolean zD = this.f4731c.d();
                x xVar = this.h;
                if (zD) {
                    if (xVar != null) {
                        xVar.b(this.f4729a, this.f4730b, this);
                    }
                } else if (xVar != null) {
                    xVar.a(this.f4729a, this.f4730b, this, new MBridgeError(6, MBridgeError.ERROR_MESSAGE_DOWNLOAD_UN_ZIP_ERROR));
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    af.a("MBridgeDownloader", "onDownloadComplete.unZip: " + e.getMessage());
                }
                boolean zD2 = this.f4731c.d();
                x xVar2 = this.h;
                if (zD2) {
                    if (xVar2 != null) {
                        xVar2.b(this.f4729a, this.f4730b, this);
                    }
                } else if (xVar2 != null) {
                    xVar2.a(this.f4729a, this.f4730b, this, new MBridgeError(6, MBridgeError.ERROR_MESSAGE_DOWNLOAD_UN_ZIP_ERROR));
                }
            }
        } catch (Throwable th) {
            boolean zD3 = this.f4731c.d();
            x xVar3 = this.h;
            if (zD3) {
                if (xVar3 != null) {
                    xVar3.b(this.f4729a, this.f4730b, this);
                }
            } else if (xVar3 != null) {
                xVar3.a(this.f4729a, this.f4730b, this, new MBridgeError(6, MBridgeError.ERROR_MESSAGE_DOWNLOAD_UN_ZIP_ERROR));
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0042  */
    @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onDownloadError(com.mbridge.msdk.foundation.download.DownloadMessage<com.mbridge.msdk.newreward.function.c.a.b> r3, com.mbridge.msdk.foundation.download.DownloadError r4) {
        /*
            r2 = this;
            com.mbridge.msdk.foundation.download.core.DownloadRequest<?> r3 = r2.f
            java.lang.String r0 = "cache"
            java.lang.String r1 = "2"
            java.lang.String r3 = r3.get(r0, r1)
            com.mbridge.msdk.newreward.function.c.c.b r0 = r2.f4731c
            boolean r3 = android.text.TextUtils.equals(r3, r1)
            r1 = 2
            if (r3 == 0) goto L15
            r3 = r1
            goto L16
        L15:
            r3 = 1
        L16:
            r0.a(r3)
            com.mbridge.msdk.newreward.function.c.c.b r3 = r2.f4731c
            r0 = 0
            r3.b(r0)
            com.mbridge.msdk.newreward.function.c.c.b r3 = r2.f4731c
            r3.a(r0)
            com.mbridge.msdk.newreward.function.c.c.x r3 = r2.h
            if (r3 == 0) goto L59
            com.mbridge.msdk.newreward.function.c.c.b r3 = r2.f4731c
            if (r3 == 0) goto L42
            int r3 = r3.b_()
            if (r3 == r1) goto L3f
            r0 = 3
            if (r3 == r0) goto L3c
            r0 = 4
            if (r3 == r0) goto L39
            goto L42
        L39:
            java.lang.String r3 = "ec template error"
            goto L44
        L3c:
            java.lang.String r3 = "big template error"
            goto L44
        L3f:
            java.lang.String r3 = "video template error"
            goto L44
        L42:
            java.lang.String r3 = "network error"
        L44:
            com.mbridge.msdk.newreward.function.common.MBridgeError r0 = new com.mbridge.msdk.newreward.function.common.MBridgeError
            r0.<init>(r1, r3)
            java.lang.Exception r3 = r4.getException()
            r0.setException(r3)
            com.mbridge.msdk.newreward.function.c.c.x r3 = r2.h
            com.mbridge.msdk.newreward.function.c.a.b r4 = r2.f4729a
            com.mbridge.msdk.newreward.function.c.a.a r1 = r2.f4730b
            r3.a(r4, r1, r2, r0)
        L59:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.c.c.r.onDownloadError(com.mbridge.msdk.foundation.download.DownloadMessage, com.mbridge.msdk.foundation.download.DownloadError):void");
    }

    @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
    public void onDownloadStart(DownloadMessage<com.mbridge.msdk.newreward.function.c.a.b> downloadMessage) {
    }

    @Override // com.mbridge.msdk.foundation.download.OnProgressStateListener
    public void onProgress(DownloadMessage<com.mbridge.msdk.newreward.function.c.a.b> downloadMessage, DownloadProgress downloadProgress) {
    }

    private File a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(a3.a.C(str, ".xml"));
        return (file.isFile() && file.exists()) ? file : b(str);
    }
}
