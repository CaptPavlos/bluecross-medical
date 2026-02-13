package com.mbridge.msdk.videocommon;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<String, C0071a> f6475a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static ConcurrentHashMap<String, C0071a> f6476b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private static ConcurrentHashMap<String, C0071a> f6477c = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private static ConcurrentHashMap<String, C0071a> f6478d = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C0071a> e = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C0071a> f = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C0071a> g = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C0071a> h = new ConcurrentHashMap<>();

    /* renamed from: i, reason: collision with root package name */
    private static ConcurrentHashMap<String, C0071a> f6479i = new ConcurrentHashMap<>();

    /* renamed from: j, reason: collision with root package name */
    private static ConcurrentHashMap<String, C0071a> f6480j = new ConcurrentHashMap<>();

    public static C0071a a(int i10, CampaignEx campaignEx) {
        if (campaignEx == null) {
            return null;
        }
        try {
            String requestIdNotice = campaignEx.getRequestIdNotice();
            if (i10 == 288) {
                requestIdNotice = campaignEx.getKeyIaUrl();
            }
            if (i10 != 94) {
                if (i10 != 287) {
                    if (i10 != 288) {
                        ConcurrentHashMap<String, C0071a> concurrentHashMap = f6475a;
                        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
                            return f6475a.get(requestIdNotice);
                        }
                    } else {
                        ConcurrentHashMap<String, C0071a> concurrentHashMap2 = f6478d;
                        if (concurrentHashMap2 != null && concurrentHashMap2.size() > 0) {
                            return f6478d.get(requestIdNotice);
                        }
                    }
                } else if (campaignEx.isBidCampaign()) {
                    ConcurrentHashMap<String, C0071a> concurrentHashMap3 = f6477c;
                    if (concurrentHashMap3 != null && concurrentHashMap3.size() > 0) {
                        return f6477c.get(requestIdNotice);
                    }
                } else {
                    ConcurrentHashMap<String, C0071a> concurrentHashMap4 = f;
                    if (concurrentHashMap4 != null && concurrentHashMap4.size() > 0) {
                        return f.get(requestIdNotice);
                    }
                }
            } else if (campaignEx.isBidCampaign()) {
                ConcurrentHashMap<String, C0071a> concurrentHashMap5 = f6476b;
                if (concurrentHashMap5 != null && concurrentHashMap5.size() > 0) {
                    return f6476b.get(requestIdNotice);
                }
            } else {
                ConcurrentHashMap<String, C0071a> concurrentHashMap6 = e;
                if (concurrentHashMap6 != null && concurrentHashMap6.size() > 0) {
                    return e.get(requestIdNotice);
                }
            }
        } catch (Exception e3) {
            if (MBridgeConstans.DEBUG) {
                e3.printStackTrace();
            }
        }
        return null;
    }

    public static void b(int i10, CampaignEx campaignEx) {
        if (campaignEx == null) {
            return;
        }
        try {
            String requestIdNotice = campaignEx.getRequestIdNotice();
            if (i10 == 288) {
                requestIdNotice = campaignEx.getKeyIaUrl();
            }
            if (i10 == 94) {
                if (campaignEx.isBidCampaign()) {
                    ConcurrentHashMap<String, C0071a> concurrentHashMap = f6476b;
                    if (concurrentHashMap != null) {
                        concurrentHashMap.remove(requestIdNotice);
                        return;
                    }
                    return;
                }
                ConcurrentHashMap<String, C0071a> concurrentHashMap2 = e;
                if (concurrentHashMap2 != null) {
                    concurrentHashMap2.remove(requestIdNotice);
                    return;
                }
                return;
            }
            if (i10 != 287) {
                if (i10 != 288) {
                    ConcurrentHashMap<String, C0071a> concurrentHashMap3 = f6475a;
                    if (concurrentHashMap3 != null) {
                        concurrentHashMap3.remove(requestIdNotice);
                        return;
                    }
                    return;
                }
                ConcurrentHashMap<String, C0071a> concurrentHashMap4 = f6478d;
                if (concurrentHashMap4 != null) {
                    concurrentHashMap4.remove(requestIdNotice);
                    return;
                }
                return;
            }
            if (campaignEx.isBidCampaign()) {
                ConcurrentHashMap<String, C0071a> concurrentHashMap5 = f6477c;
                if (concurrentHashMap5 != null) {
                    concurrentHashMap5.remove(requestIdNotice);
                    return;
                }
                return;
            }
            ConcurrentHashMap<String, C0071a> concurrentHashMap6 = f;
            if (concurrentHashMap6 != null) {
                concurrentHashMap6.remove(requestIdNotice);
            }
        } catch (Exception e3) {
            if (MBridgeConstans.DEBUG) {
                e3.printStackTrace();
            }
        }
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            g.clear();
        } else {
            for (String str2 : g.keySet()) {
                if (!TextUtils.isEmpty(str2) && str2.startsWith(str)) {
                    g.remove(str2);
                }
            }
        }
        h.clear();
    }

    public static void d(String str) {
        for (Map.Entry<String, C0071a> entry : g.entrySet()) {
            if (entry.getKey().contains(str)) {
                g.remove(entry.getKey());
            }
        }
    }

    public static void e(String str) {
        for (Map.Entry<String, C0071a> entry : h.entrySet()) {
            if (entry.getKey().contains(str)) {
                h.remove(entry.getKey());
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.videocommon.a$a, reason: collision with other inner class name */
    public static class C0071a {

        /* renamed from: a, reason: collision with root package name */
        private WindVaneWebView f6481a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f6482b;

        public final void a(String str) {
            WindVaneWebView windVaneWebView = this.f6481a;
            if (windVaneWebView != null) {
                windVaneWebView.setTag(str);
            }
        }

        public final String b() {
            WindVaneWebView windVaneWebView = this.f6481a;
            return windVaneWebView != null ? (String) windVaneWebView.getTag() : "";
        }

        public final boolean c() {
            return this.f6482b;
        }

        public final void a(WindVaneWebView windVaneWebView) {
            this.f6481a = windVaneWebView;
        }

        public final WindVaneWebView a() {
            return this.f6481a;
        }

        public final void a(boolean z9) {
            this.f6482b = z9;
        }
    }

    public static void b(String str) {
        if (g.containsKey(str)) {
            g.remove(str);
        }
        if (f6479i.containsKey(str)) {
            f6479i.remove(str);
        }
        if (h.containsKey(str)) {
            h.remove(str);
        }
        if (f6480j.containsKey(str)) {
            f6480j.remove(str);
        }
    }

    public static void b(int i10, String str, C0071a c0071a) {
        try {
            if (i10 == 94) {
                if (e == null) {
                    e = new ConcurrentHashMap<>();
                }
                e.put(str, c0071a);
            } else if (i10 == 287) {
                if (f == null) {
                    f = new ConcurrentHashMap<>();
                }
                f.put(str, c0071a);
            } else if (i10 != 288) {
                if (f6475a == null) {
                    f6475a = new ConcurrentHashMap<>();
                }
                f6475a.put(str, c0071a);
            } else {
                if (f6478d == null) {
                    f6478d = new ConcurrentHashMap<>();
                }
                f6478d.put(str, c0071a);
            }
        } catch (Exception e3) {
            if (MBridgeConstans.DEBUG) {
                e3.printStackTrace();
            }
        }
    }

    public static void a(String str, C0071a c0071a, boolean z9, boolean z10) {
        if (z9) {
            if (z10) {
                h.put(str, c0071a);
                return;
            } else {
                g.put(str, c0071a);
                return;
            }
        }
        if (z10) {
            f6480j.put(str, c0071a);
        } else {
            f6479i.put(str, c0071a);
        }
    }

    public static void a() {
        f6479i.clear();
        f6480j.clear();
    }

    public static C0071a a(String str) {
        if (g.containsKey(str)) {
            return g.get(str);
        }
        if (h.containsKey(str)) {
            return h.get(str);
        }
        if (f6479i.containsKey(str)) {
            return f6479i.get(str);
        }
        if (f6480j.containsKey(str)) {
            return f6480j.get(str);
        }
        return null;
    }

    public static void a(int i10, String str, C0071a c0071a) {
        try {
            if (i10 == 94) {
                if (f6476b == null) {
                    f6476b = new ConcurrentHashMap<>();
                }
                f6476b.put(str, c0071a);
            } else {
                if (i10 != 287) {
                    return;
                }
                if (f6477c == null) {
                    f6477c = new ConcurrentHashMap<>();
                }
                f6477c.put(str, c0071a);
            }
        } catch (Exception e3) {
            if (MBridgeConstans.DEBUG) {
                e3.printStackTrace();
            }
        }
    }
}
