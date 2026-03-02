package com.mbridge.msdk.newreward.function.c.c;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadProgress;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ab;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t extends r {
    public t(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.function.c.a.a aVar, b bVar2) {
        super(bVar, aVar, bVar2);
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.r, com.mbridge.msdk.newreward.function.c.c.p
    public final /* bridge */ /* synthetic */ void a(int i10, x xVar) {
        super.a(i10, xVar);
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.r
    public final String b() {
        CampaignEx campaignExH;
        if (super.c() != null && super.c().h() != null && (campaignExH = super.c().h()) != null && !TextUtils.isEmpty(campaignExH.getendcard_url())) {
            Context contextX = super.d().x();
            if (contextX == null) {
                contextX = com.mbridge.msdk.foundation.controller.c.m().c();
            }
            try {
                StringBuilder sb = new StringBuilder("template_");
                sb.append(com.mbridge.msdk.e.b.a() ? "cn" : "en");
                sb.append("_");
                sb.append(ab.s(contextX.getApplicationContext()));
                return sb.toString();
            } catch (Exception unused) {
            }
        }
        return "";
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.r
    public final /* bridge */ /* synthetic */ com.mbridge.msdk.newreward.function.c.a.a c() {
        return super.c();
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.r
    public final /* bridge */ /* synthetic */ com.mbridge.msdk.newreward.function.c.a.b d() {
        return super.d();
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.r
    public final /* bridge */ /* synthetic */ a e() {
        return super.e();
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.r, com.mbridge.msdk.foundation.download.OnDownloadStateListener
    public final /* bridge */ /* synthetic */ void onCancelDownload(DownloadMessage<com.mbridge.msdk.newreward.function.c.a.b> downloadMessage) {
        super.onCancelDownload(downloadMessage);
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.r, com.mbridge.msdk.foundation.download.OnDownloadStateListener
    public final /* bridge */ /* synthetic */ void onDownloadComplete(DownloadMessage<com.mbridge.msdk.newreward.function.c.a.b> downloadMessage) {
        super.onDownloadComplete(downloadMessage);
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.r, com.mbridge.msdk.foundation.download.OnDownloadStateListener
    public final /* bridge */ /* synthetic */ void onDownloadError(DownloadMessage<com.mbridge.msdk.newreward.function.c.a.b> downloadMessage, DownloadError downloadError) {
        super.onDownloadError(downloadMessage, downloadError);
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.r, com.mbridge.msdk.foundation.download.OnDownloadStateListener
    public final /* bridge */ /* synthetic */ void onDownloadStart(DownloadMessage<com.mbridge.msdk.newreward.function.c.a.b> downloadMessage) {
        super.onDownloadStart(downloadMessage);
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.r, com.mbridge.msdk.foundation.download.OnProgressStateListener
    public final /* bridge */ /* synthetic */ void onProgress(DownloadMessage<com.mbridge.msdk.newreward.function.c.a.b> downloadMessage, DownloadProgress downloadProgress) {
        super.onProgress(downloadMessage, downloadProgress);
    }

    @Override // com.mbridge.msdk.newreward.function.c.c.r
    public final boolean a() {
        return false;
    }
}
