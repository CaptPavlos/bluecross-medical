package com.mbridge.msdk.foundation.same.net.e;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.net.f.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ap;
import com.mbridge.msdk.foundation.tools.aq;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3725a = "b";

    public static void a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.startsWith("http")) {
                str = aq.a(str);
            }
            TextUtils.isEmpty(str);
        } catch (Throwable th) {
            af.b(f3725a, th.getMessage());
        }
    }

    public static void a(e eVar, String str, String str2) {
        if (eVar != null) {
            try {
                if (!ap.a(str) && !ap.a(str2)) {
                    eVar.a(str, str2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
