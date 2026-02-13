package com.mbridge.msdk.foundation.same.g;

import android.webkit.DownloadListener;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a implements DownloadListener {

    /* renamed from: a, reason: collision with root package name */
    private String f3695a;

    /* renamed from: b, reason: collision with root package name */
    private CampaignEx f3696b;

    public a(CampaignEx campaignEx) {
        this.f3696b = campaignEx;
    }

    public final void a(String str) {
        this.f3695a = str;
    }

    public a() {
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
    }
}
