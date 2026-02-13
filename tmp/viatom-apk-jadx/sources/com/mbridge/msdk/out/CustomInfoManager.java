package com.mbridge.msdk.out;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.system.NoProGuard;
import j$.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class CustomInfoManager implements NoProGuard {
    private static CustomInfoManager INSTANCE = null;
    private static String TAG = "CustomInfoManager";
    public static final int TYPE_BID = 6;
    public static final int TYPE_BIDLOAD = 7;
    public static final int TYPE_LOAD = 8;
    private ConcurrentHashMap<String, String> infoMap = new ConcurrentHashMap<>();

    private CustomInfoManager() {
    }

    public static synchronized CustomInfoManager getInstance() {
        try {
            if (INSTANCE == null) {
                synchronized (CustomInfoManager.class) {
                    try {
                        if (INSTANCE == null) {
                            INSTANCE = new CustomInfoManager();
                        }
                    } finally {
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return INSTANCE;
    }

    public String getCustomInfoByType(String str, int i10) {
        return TextUtils.isEmpty(str) ? "" : getCustomInfoByUnitId(str, i10);
    }

    public String getCustomInfoByUnitId(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            Uri uri = Uri.parse(str2);
            if (uri != null) {
                String host = uri.getHost();
                String path = uri.getPath();
                if (!TextUtils.isEmpty(host) && host.contains(CampaignEx.JSON_KEY_HB) && !TextUtils.isEmpty(path) && path.contains("bid")) {
                    return getCustomInfoByUnitId(str, 6);
                }
                if (!TextUtils.isEmpty(host) && host.contains(CampaignEx.JSON_KEY_HB) && !TextUtils.isEmpty(path) && path.contains("load")) {
                    return getCustomInfoByUnitId(str, 7);
                }
                if (!TextUtils.isEmpty(path) && path.contains("v3")) {
                    return getCustomInfoByUnitId(str, 8);
                }
            }
        } catch (Throwable th) {
            af.b(TAG, "Exception", th);
        }
        return "";
    }

    public void setCustomInfo(String str, int i10, String str2) {
        if (TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        String strB = z.b(str2);
        if (i10 == 6) {
            this.infoMap.put(str + "_bid", strB);
            return;
        }
        if (i10 != 7) {
            if (i10 != 8) {
                return;
            }
            this.infoMap.put(str, strB);
        } else {
            this.infoMap.put(str + "_bidload", strB);
        }
    }

    public String getCustomInfoByUnitId(String str, int i10) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (i10 == 6) {
            return this.infoMap.get(str + "_bid");
        }
        if (i10 != 7) {
            return i10 != 8 ? "" : this.infoMap.get(str);
        }
        return this.infoMap.get(str + "_bidload");
    }
}
