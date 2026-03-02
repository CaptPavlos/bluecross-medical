package com.mbridge.msdk.mbbanner.common.c;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.out.MBridgeIds;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4190a = "a";
    private static volatile a h;

    /* renamed from: b, reason: collision with root package name */
    private Context f4191b = com.mbridge.msdk.foundation.controller.c.m().c();

    /* renamed from: c, reason: collision with root package name */
    private com.mbridge.msdk.mbbanner.common.util.a f4192c = new com.mbridge.msdk.mbbanner.common.util.a();

    /* renamed from: d, reason: collision with root package name */
    private Map<String, com.mbridge.msdk.mbbanner.common.a.b> f4193d = new ConcurrentHashMap();
    private Map<String, Boolean> e = new ConcurrentHashMap();
    private Map<String, Handler> f = new ConcurrentHashMap();
    private Map<String, Integer> g = new ConcurrentHashMap();

    private a() {
    }

    public final void a(String str, String str2, final com.mbridge.msdk.mbbanner.common.a.a aVar, com.mbridge.msdk.mbbanner.common.b.b bVar) {
        com.mbridge.msdk.mbbanner.common.a.b bVar2;
        Boolean bool;
        MBridgeIds mBridgeIds = new MBridgeIds(str, str2);
        String strE = aVar.e();
        com.mbridge.msdk.foundation.same.report.d.c cVarA = com.mbridge.msdk.mbbanner.common.d.a.a(str2, strE);
        cVarA.i(!TextUtils.isEmpty(aVar.c()) ? "1" : "0");
        cVarA.e(aVar.c());
        cVarA.b(aVar.f() ? "1" : "2");
        cVarA.d(aVar.f() ? 1 : 2);
        cVarA.e(aVar.b());
        com.mbridge.msdk.mbbanner.common.d.a.a("2000123", cVarA, null);
        if (this.f4191b == null) {
            com.mbridge.msdk.foundation.c.b bVar3 = new com.mbridge.msdk.foundation.c.b(880025);
            bVar3.a(mBridgeIds);
            bVar3.b(strE);
            this.f4192c.a(bVar, bVar3);
            return;
        }
        if (bVar == null) {
            com.mbridge.msdk.foundation.c.b bVar4 = new com.mbridge.msdk.foundation.c.b(880001);
            bVar4.a(mBridgeIds);
            bVar4.b(strE);
            this.f4192c.a(bVar, bVar4);
            return;
        }
        Map<String, Boolean> map = this.e;
        if (map != null && map.containsKey(str2) && (bool = this.e.get(str2)) != null && bool.booleanValue()) {
            com.mbridge.msdk.foundation.c.b bVar5 = new com.mbridge.msdk.foundation.c.b(880016, "Current unit is loading!");
            bVar5.a(mBridgeIds);
            bVar5.b(strE);
            this.f4192c.a(bVar, bVar5);
            return;
        }
        this.e.put(str2, Boolean.TRUE);
        if (this.f4193d.containsKey(str2)) {
            bVar2 = this.f4193d.get(str2);
        } else {
            k kVarD = h.a().d(com.mbridge.msdk.foundation.controller.c.m().k(), str2);
            if (kVarD == null) {
                kVarD = k.d(str2);
            }
            com.mbridge.msdk.mbbanner.common.a.b bVar6 = new com.mbridge.msdk.mbbanner.common.a.b(str2, "", 0, kVarD.w());
            this.f4193d.put(str2, bVar6);
            bVar2 = bVar6;
        }
        bVar2.b(strE);
        new b(this.f4191b, bVar2, bVar, this.f4192c).a(str, str2, aVar, new com.mbridge.msdk.mbbanner.common.b.d() { // from class: com.mbridge.msdk.mbbanner.common.c.a.1
            @Override // com.mbridge.msdk.mbbanner.common.b.d
            public final void a(String str3) {
                synchronized (a.a()) {
                    aVar.a("");
                    a.this.e.put(str3, Boolean.FALSE);
                }
            }
        });
        com.mbridge.msdk.mbbanner.common.d.a.a("2000125", cVarA, null);
    }

    public final void b(final String str, final String str2, final com.mbridge.msdk.mbbanner.common.a.a aVar, final com.mbridge.msdk.mbbanner.common.b.b bVar) {
        Handler handler;
        final MBridgeIds mBridgeIds = new MBridgeIds(str, str2);
        if (aVar == null || aVar.b() <= 0) {
            af.b(f4190a, "doUnitRotation: Illegal banner request parameters! && unitId=" + str2);
            return;
        }
        if (this.f.containsKey(str2)) {
            handler = this.f.get(str2);
        } else {
            handler = new Handler();
            this.f.put(str2, handler);
        }
        Handler handler2 = handler;
        Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.mbbanner.common.c.a.2
            @Override // java.lang.Runnable
            public final void run() {
                Boolean bool;
                if (a.this.e == null || !a.this.e.containsKey(str2) || (bool = (Boolean) a.this.e.get(str2)) == null || !bool.booleanValue()) {
                    if (a.this.g.containsKey(str2)) {
                        Integer num = (Integer) a.this.g.get(str2);
                        int iIntValue = num != null ? num.intValue() : 0;
                        if (iIntValue == 2 || iIntValue == 4) {
                            String str3 = a.f4190a;
                            StringBuilder sbR = a3.a.r(iIntValue, "doUnitRotation: autoRotationStatus=", " && unitId=");
                            sbR.append(str2);
                            af.b(str3, sbR.toString());
                            if (a.this.f4192c != null) {
                                com.mbridge.msdk.foundation.c.b bVar2 = new com.mbridge.msdk.foundation.c.b(880026);
                                bVar2.a(mBridgeIds);
                                a.this.f4192c.a(bVar, bVar2);
                                return;
                            }
                            return;
                        }
                    }
                    a.this.a(str, str2, aVar, bVar);
                }
            }
        };
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
            handler2.postDelayed(runnable, aVar.b());
        }
    }

    public final void b() {
        Map<String, com.mbridge.msdk.mbbanner.common.a.b> map = this.f4193d;
        if (map != null) {
            map.clear();
        }
        Map<String, Boolean> map2 = this.e;
        if (map2 != null) {
            map2.clear();
        }
        Map<String, Handler> map3 = this.f;
        if (map3 != null) {
            for (Map.Entry<String, Handler> entry : map3.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().removeCallbacksAndMessages(null);
                }
            }
            this.f.clear();
        }
        Map<String, Integer> map4 = this.g;
        if (map4 != null) {
            map4.clear();
        }
    }

    public static a a() {
        if (h == null) {
            synchronized (a.class) {
                try {
                    if (h == null) {
                        h = new a();
                    }
                } finally {
                }
            }
        }
        return h;
    }

    public final void a(String str) {
        if (this.f.containsKey(str)) {
            Handler handler = this.f.get(str);
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.f.remove(str);
        }
    }

    public final void a(int i10, String str, String str2, com.mbridge.msdk.mbbanner.common.a.a aVar, com.mbridge.msdk.mbbanner.common.b.b bVar) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Integer num;
        int iIntValue = (!this.g.containsKey(str2) || (num = this.g.get(str2)) == null) ? 0 : num.intValue();
        if (i10 == 1) {
            if (this.f.containsKey(str2) && (handler = this.f.get(str2)) != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.g.put(str2, Integer.valueOf(i10));
            return;
        }
        if (i10 == 2) {
            if (iIntValue == 1) {
                if (this.f.containsKey(str2) && (handler2 = this.f.get(str2)) != null) {
                    handler2.removeCallbacksAndMessages(null);
                }
                this.g.put(str2, Integer.valueOf(i10));
                return;
            }
            return;
        }
        if (i10 == 3) {
            if (iIntValue == 2 || iIntValue == 4) {
                this.g.put(str2, 1);
                b(str, str2, aVar, bVar);
                return;
            }
            return;
        }
        if (i10 != 4) {
            return;
        }
        if (iIntValue == 0) {
            this.g.put(str2, 0);
            return;
        }
        if (this.f.containsKey(str2) && (handler3 = this.f.get(str2)) != null) {
            handler3.removeCallbacksAndMessages(null);
        }
        this.g.put(str2, Integer.valueOf(i10));
    }
}
