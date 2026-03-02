package com.mbridge.msdk.e;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.out.MBConfiguration;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile Boolean f3306a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile Boolean f3307b;

    public static boolean a() {
        if (f3306a == null) {
            try {
                boolean z9 = Integer.parseInt(String.valueOf(MBConfiguration.SDK_VERSION.charAt(10))) == 2;
                f3306a = Boolean.valueOf(z9);
                return z9;
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    af.b("CommonUtils", "isChina", e);
                }
            }
        }
        return f3306a != null && f3306a.booleanValue();
    }

    public static boolean b() {
        if (f3307b == null) {
            try {
                boolean z9 = Integer.parseInt(String.valueOf(MBConfiguration.SDK_VERSION.charAt(10))) == 1;
                f3307b = Boolean.valueOf(z9);
                return z9;
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    af.b("CommonUtils", "isOversea", e);
                }
            }
        }
        return f3307b != null && f3307b.booleanValue();
    }
}
