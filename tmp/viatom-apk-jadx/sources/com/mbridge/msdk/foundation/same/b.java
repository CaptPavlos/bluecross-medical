package com.mbridge.msdk.foundation.same;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.ah;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f3634a;

    /* renamed from: b, reason: collision with root package name */
    private Boolean f3635b = null;

    private b() {
    }

    public final boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.equals("new_bridge_reward_video")) {
            boolean zA = ah.a().a("new_bridge_reward_video", false, false);
            this.f3635b = Boolean.valueOf(zA);
            return zA;
        }
        if (str.equals("new_bridge_reward_show")) {
            return ah.a().a("new_bridge_reward_show", false, false);
        }
        return false;
    }

    public final Boolean b() {
        return this.f3635b;
    }

    public static b a() {
        if (f3634a == null) {
            synchronized (b.class) {
                try {
                    if (f3634a == null) {
                        f3634a = new b();
                    }
                } finally {
                }
            }
        }
        return f3634a;
    }
}
