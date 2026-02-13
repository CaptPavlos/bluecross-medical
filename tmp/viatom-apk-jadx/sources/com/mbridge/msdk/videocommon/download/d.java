package com.mbridge.msdk.videocommon.download;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Patterns;
import android.webkit.URLUtil;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.videocommon.download.e;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: c, reason: collision with root package name */
    private static d f6562c;

    /* renamed from: a, reason: collision with root package name */
    private CopyOnWriteArrayList<String> f6563a;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentMap<String, Object> f6564b;

    /* renamed from: d, reason: collision with root package name */
    private g f6565d;
    private e e;
    private boolean f;
    private final String g = CampaignEx.JSON_KEY_LOCAL_REQUEST_ID;
    private final String h = "down_type";

    private d() {
        this.f = false;
        try {
            this.f6565d = g.a();
            this.e = e.a.f6568a;
            this.f6563a = new CopyOnWriteArrayList<>();
            this.f6564b = new ConcurrentHashMap();
            com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
            if (gVarB != null) {
                this.f = gVarB.z(1);
            }
        } catch (Throwable th) {
            af.b("H5DownLoadManager", th.getMessage(), th);
        }
    }

    public final String a(String str) {
        try {
            if (!Patterns.WEB_URL.matcher(str).matches() && !URLUtil.isValidUrl(str)) {
                return str;
            }
            Uri uri = Uri.parse(str);
            String path = uri.getPath();
            if (!TextUtils.isEmpty(path) && TextUtils.isEmpty(uri.getQueryParameter("urlDebug"))) {
                if (!path.toLowerCase().endsWith(".zip")) {
                    e eVar = this.e;
                    return eVar != null ? eVar.a(str) : str;
                }
                g gVar = this.f6565d;
                if (gVar != null) {
                    return gVar.a(str);
                }
                return null;
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static synchronized d a() {
        try {
            if (f6562c == null) {
                f6562c = new d();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f6562c;
    }
}
