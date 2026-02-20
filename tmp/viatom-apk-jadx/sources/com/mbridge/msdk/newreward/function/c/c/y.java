package com.mbridge.msdk.newreward.function.c.c;

import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadProgress;
import com.mbridge.msdk.foundation.download.DownloadResourceType;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.OnProgressStateListener;
import com.mbridge.msdk.foundation.download.core.DownloadRequest;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.io.File;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class y extends q implements OnDownloadStateListener<com.mbridge.msdk.newreward.function.c.a.b>, OnProgressStateListener<com.mbridge.msdk.newreward.function.c.a.b> {

    /* renamed from: a, reason: collision with root package name */
    private final com.mbridge.msdk.newreward.function.c.a.b f4746a;

    /* renamed from: b, reason: collision with root package name */
    private final com.mbridge.msdk.newreward.function.c.a.a f4747b;

    /* renamed from: c, reason: collision with root package name */
    private final n f4748c;

    /* renamed from: d, reason: collision with root package name */
    private final String f4749d;
    private final String e;
    private final String f;
    private final int h;

    /* renamed from: i, reason: collision with root package name */
    private DownloadRequest f4750i;

    /* renamed from: j, reason: collision with root package name */
    private x f4751j;
    private boolean g = false;

    /* renamed from: k, reason: collision with root package name */
    private volatile boolean f4752k = false;

    /* renamed from: l, reason: collision with root package name */
    private boolean f4753l = false;

    public y(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.function.c.a.a aVar, n nVar, int i10) {
        this.f4746a = bVar;
        this.f4747b = aVar;
        this.f4748c = nVar;
        this.h = i10;
        String strJ = nVar.j();
        this.f4749d = strJ;
        String str = com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_VC) + File.separator;
        this.e = str;
        String strA = com.mbridge.msdk.newreward.function.h.c.a(strJ);
        this.f = strA;
        String strC = a3.a.C(str, strA);
        nVar.a(new File(strC));
        nVar.a(true);
        File file = new File(strC);
        if (file.exists() && file.isFile()) {
            nVar.a(1);
            nVar.b(true);
            nVar.a(false);
        }
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.p
    public final void a(int i10, x xVar) {
        DownloadMessage<?> downloadMessage;
        int i11;
        this.f4751j = xVar;
        if (TextUtils.isEmpty(this.f4749d)) {
            boolean zD = this.f4748c.d();
            x xVar2 = this.f4751j;
            if (zD) {
                if (xVar2 != null) {
                    xVar2.a(this.f4746a, this.f4747b, this);
                    this.f4751j.b(this.f4746a, this.f4747b, this);
                    return;
                }
                return;
            }
            if (xVar2 != null) {
                xVar2.a(this.f4746a, this.f4747b, this);
                this.f4751j.a(this.f4746a, this.f4747b, this, new MBridgeError(5, MBridgeError.ERROR_MESSAGE_DOWNLOAD_RESOURCE_URL_ERROR));
                return;
            }
            return;
        }
        if (this.f4753l) {
            x xVar3 = this.f4751j;
            if (xVar3 != null) {
                xVar3.b(this.f4746a, this.f4747b, this);
                return;
            }
            return;
        }
        this.f4752k = false;
        int videoCtnType = this.f4747b.h().getVideoCtnType();
        if (i10 == 1 || (i11 = this.h) == 100 || videoCtnType == 1) {
            this.g = false;
            downloadMessage = new DownloadMessage<>(this.f4746a, this.f4749d, this.f, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_VIDEO);
        } else {
            this.g = true;
            downloadMessage = new DownloadMessage<>(this.f4746a, this.f4749d, this.f, i11, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_VIDEO);
        }
        DownloadRequest downloadRequestBuild = MBDownloadManager.getInstance().download(downloadMessage).withReadTimeout(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS).withConnectTimeout(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS).withWriteTimeout(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS).withDownloadPriority(DownloadPriority.IMMEDIATE).withHttpRetryCounter(5).withDirectoryPathInternal(this.e).withDownloadStateListener(this).withProgressStateListener(this).withTimeout(ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS).with("download_scene", "download_video").with("do_us_fi_re", Boolean.toString(true)).build();
        this.f4750i = downloadRequestBuild;
        downloadRequestBuild.start();
    }

    @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
    public final void onCancelDownload(DownloadMessage<com.mbridge.msdk.newreward.function.c.a.b> downloadMessage) {
        boolean z9 = this.f4752k;
        x xVar = this.f4751j;
        if (z9) {
            if (xVar != null) {
                xVar.b(this.f4746a, this.f4747b, this, new MBridgeError(4, MBridgeError.ERROR_MESSAGE_DOWNLOAD_DOWNLOAD_TIMEOUT));
            }
        } else if (xVar != null) {
            xVar.a(this.f4746a, this.f4747b, this, new MBridgeError(2, MBridgeError.ERROR_MESSAGE_DOWNLOAD_NETWORK_ERROR));
        }
    }

    @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
    public final void onDownloadComplete(DownloadMessage<com.mbridge.msdk.newreward.function.c.a.b> downloadMessage) {
        this.f4748c.a(TextUtils.equals(this.f4750i.get("cache", "2"), "2") ? 2 : 1);
        this.f4748c.b(true);
        this.f4748c.a(false);
        this.f4753l = true;
        x xVar = this.f4751j;
        if (xVar != null) {
            xVar.b(this.f4746a, this.f4747b, this);
        }
    }

    @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
    public final void onDownloadError(DownloadMessage<com.mbridge.msdk.newreward.function.c.a.b> downloadMessage, DownloadError downloadError) {
        this.f4748c.a(TextUtils.equals(this.f4750i.get("cache", "2"), "2") ? 2 : 1);
        this.f4748c.b(false);
        this.f4748c.a(false);
        MBridgeError mBridgeError = new MBridgeError(2, MBridgeError.ERROR_MESSAGE_DOWNLOAD_VIDEO_ERROR);
        mBridgeError.setException(downloadError.getException());
        x xVar = this.f4751j;
        if (xVar != null) {
            xVar.a(this.f4746a, this.f4747b, this, mBridgeError);
        }
    }

    @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
    public final void onDownloadStart(DownloadMessage<com.mbridge.msdk.newreward.function.c.a.b> downloadMessage) {
        x xVar = this.f4751j;
        if (xVar != null) {
            xVar.a(this.f4746a, this.f4747b, this);
        }
    }

    @Override // com.mbridge.msdk.foundation.download.OnProgressStateListener
    public final void onProgress(DownloadMessage<com.mbridge.msdk.newreward.function.c.a.b> downloadMessage, DownloadProgress downloadProgress) {
        if (downloadProgress.getCurrentDownloadRate() >= this.h) {
            this.f4748c.a(TextUtils.equals(this.f4750i.get("cache", "2"), "2") ? 2 : 1);
            this.f4748c.b(true);
            this.f4748c.a(false);
            if (this.g) {
                this.f4750i.cancel(downloadMessage);
            }
        }
    }
}
