package com.mbridge.msdk.videocommon.download;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.download.ResourceManager;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.aq;
import java.io.File;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private static String f6569a = "ResourceManager";

    /* renamed from: b, reason: collision with root package name */
    private String f6570b;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static g f6572a = new g(null);
    }

    private g() {
        this.f6570b = com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_RES);
    }

    public final String a(String str) {
        String strSubstring;
        try {
            String str2 = this.f6570b + "/" + SameMD5.getMD5(aq.b(str));
            List<String> queryParameters = Uri.parse(str).getQueryParameters(ResourceManager.KEY_INDEX_HTML);
            if (queryParameters == null || queryParameters.size() <= 0) {
                return null;
            }
            String str3 = queryParameters.get(0);
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            String str4 = str2 + "/" + str3 + "/" + str3 + ".html";
            if (!ad.d(str4)) {
                return null;
            }
            try {
                com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
                if (gVarB != null && !TextUtils.isEmpty(gVarB.W())) {
                    com.mbridge.msdk.foundation.same.d.a(str, new File(str4));
                }
                strSubstring = str.substring(str.indexOf("?") + 1);
            } catch (Exception unused) {
                strSubstring = "";
            }
            return "file://" + str4 + (TextUtils.isEmpty(strSubstring) ? "" : "?".concat(strSubstring));
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            e.printStackTrace();
            return null;
        }
    }

    public /* synthetic */ g(AnonymousClass1 anonymousClass1) {
        this();
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.videocommon.download.g$1, reason: invalid class name */
    public class AnonymousClass1 extends com.mbridge.msdk.foundation.same.e.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f6571a;

        @Override // com.mbridge.msdk.foundation.same.e.a
        public final void runTask() {
            ad.a(this.f6571a.f6570b);
        }

        @Override // com.mbridge.msdk.foundation.same.e.a
        public final void cancelTask() {
        }

        @Override // com.mbridge.msdk.foundation.same.e.a
        public final void pauseTask(boolean z9) {
        }
    }

    public static g a() {
        return a.f6572a;
    }
}
