package com.mbridge.msdk.foundation.same.report.d;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, String> f3843a = new HashMap();

    public final void a(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        try {
            if (obj instanceof String) {
                if (TextUtils.isEmpty((String) obj)) {
                    return;
                }
                this.f3843a.put(str, (String) obj);
            } else {
                this.f3843a.put(str, obj + "");
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public final Object b(String str) {
        return this.f3843a.get(str);
    }

    public final void c(String str) {
        if (this.f3843a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f3843a.remove(str);
    }

    public final boolean a(String str) {
        return this.f3843a.containsKey(str);
    }

    public final Map<String, String> a() {
        return this.f3843a;
    }

    public final void a(e eVar) {
        Map<String, String> map;
        Map<String, String> map2;
        if (eVar == null || (map = eVar.f3843a) == null || (map2 = this.f3843a) == null) {
            return;
        }
        map2.putAll(map);
    }

    public final void a(Map map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        this.f3843a.putAll(map);
    }
}
