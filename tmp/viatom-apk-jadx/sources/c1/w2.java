package c1;

import android.os.Bundle;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.Iterator;
import java.util.TreeSet;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w2 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1549a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bundle f1550b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c3 f1551c;

    public /* synthetic */ w2(c3 c3Var, Bundle bundle, int i10) {
        this.f1549a = i10;
        this.f1550b = bundle;
        this.f1551c = c3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle;
        switch (this.f1549a) {
            case 0:
                c3 c3Var = this.f1551c;
                c3Var.g();
                c3Var.h();
                Bundle bundle2 = this.f1550b;
                String string = bundle2.getString(RewardPlus.NAME);
                String string2 = bundle2.getString(TtmlNode.ATTR_TTS_ORIGIN);
                i0.y.d(string);
                i0.y.d(string2);
                i0.y.g(bundle2.get("value"));
                u1 u1Var = c3Var.f1149a;
                if (!u1Var.d()) {
                    w0 w0Var = u1Var.f;
                    u1.m(w0Var);
                    w0Var.f1545n.b("Conditional property not set since app measurement is disabled");
                    break;
                } else {
                    y4 y4Var = new y4(bundle2.getLong("triggered_timestamp"), bundle2.get("value"), string, string2);
                    try {
                        b5 b5Var = u1Var.f1479i;
                        u1.k(b5Var);
                        bundle2.getString(MBridgeConstans.APP_ID);
                        v vVarJ = b5Var.J(bundle2.getString("triggered_event_name"), bundle2.getBundle("triggered_event_params"), string2, 0L, true);
                        u1.k(b5Var);
                        bundle2.getString(MBridgeConstans.APP_ID);
                        v vVarJ2 = b5Var.J(bundle2.getString("timed_out_event_name"), bundle2.getBundle("timed_out_event_params"), string2, 0L, true);
                        bundle2.getString(MBridgeConstans.APP_ID);
                        u1Var.p().z(new e(bundle2.getString(MBridgeConstans.APP_ID), string2, y4Var, bundle2.getLong("creation_timestamp"), false, bundle2.getString("trigger_event_name"), vVarJ2, bundle2.getLong("trigger_timeout"), vVarJ, bundle2.getLong("time_to_live"), b5Var.J(bundle2.getString("expired_event_name"), bundle2.getBundle("expired_event_params"), string2, 0L, true)));
                        break;
                    } catch (IllegalArgumentException unused) {
                        return;
                    }
                }
            case 1:
                c3 c3Var2 = this.f1551c;
                c3Var2.g();
                c3Var2.h();
                Bundle bundle3 = this.f1550b;
                String string3 = bundle3.getString(RewardPlus.NAME);
                i0.y.d(string3);
                u1 u1Var2 = c3Var2.f1149a;
                if (!u1Var2.d()) {
                    w0 w0Var2 = u1Var2.f;
                    u1.m(w0Var2);
                    w0Var2.f1545n.b("Conditional property not cleared since app measurement is disabled");
                    break;
                } else {
                    y4 y4Var2 = new y4(0L, null, string3, "");
                    try {
                        b5 b5Var2 = u1Var2.f1479i;
                        u1.k(b5Var2);
                        bundle3.getString(MBridgeConstans.APP_ID);
                        u1Var2.p().z(new e(bundle3.getString(MBridgeConstans.APP_ID), "", y4Var2, bundle3.getLong("creation_timestamp"), bundle3.getBoolean("active"), bundle3.getString("trigger_event_name"), null, bundle3.getLong("trigger_timeout"), null, bundle3.getLong("time_to_live"), b5Var2.J(bundle3.getString("expired_event_name"), bundle3.getBundle("expired_event_params"), "", bundle3.getLong("creation_timestamp"), true)));
                        break;
                    } catch (IllegalArgumentException unused2) {
                        return;
                    }
                }
            default:
                c3 c3Var3 = this.f1551c;
                y2.c cVar = c3Var3.f1091w;
                u1 u1Var3 = c3Var3.f1149a;
                Bundle bundle4 = this.f1550b;
                if (bundle4.isEmpty()) {
                    bundle = bundle4;
                } else {
                    h1 h1Var = u1Var3.e;
                    b5 b5Var3 = u1Var3.f1479i;
                    g gVar = u1Var3.f1478d;
                    w0 w0Var3 = u1Var3.f;
                    u1.k(h1Var);
                    bundle = new Bundle(h1Var.y.I());
                    for (String str : bundle4.keySet()) {
                        Object obj = bundle4.get(str);
                        if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                            u1.k(b5Var3);
                            if (b5.p0(obj)) {
                                b5.w(cVar, null, 27, null, null, 0);
                            }
                            u1.m(w0Var3);
                            w0Var3.f1542k.d(str, "Invalid default event parameter type. Name, value", obj);
                        } else if (b5.F(str)) {
                            u1.m(w0Var3);
                            w0Var3.f1542k.c(str, "Invalid default event parameter name. Name");
                        } else if (obj == null) {
                            bundle.remove(str);
                        } else {
                            u1.k(b5Var3);
                            gVar.getClass();
                            if (b5Var3.q0("param", str, 500, obj)) {
                                b5Var3.v(obj, str, bundle);
                            }
                        }
                    }
                    u1.k(b5Var3);
                    b5 b5Var4 = gVar.f1149a.f1479i;
                    u1.k(b5Var4);
                    int i10 = b5Var4.M(201500000) ? 100 : 25;
                    if (bundle.size() > i10) {
                        Iterator it = new TreeSet(bundle.keySet()).iterator();
                        int i11 = 0;
                        while (it.hasNext()) {
                            String str2 = (String) it.next();
                            i11++;
                            if (i11 > i10) {
                                bundle.remove(str2);
                            }
                        }
                        u1.k(b5Var3);
                        b5.w(cVar, null, 26, null, null, 0);
                        u1.m(w0Var3);
                        w0Var3.f1542k.b("Too many default event parameters set. Discarding beyond event parameter limit");
                    }
                }
                h1 h1Var2 = u1Var3.e;
                u1.k(h1Var2);
                h1Var2.y.M(bundle);
                if (!bundle4.isEmpty() || u1Var3.f1478d.q(null, f0.X0)) {
                    u1Var3.p().l(bundle);
                    break;
                }
                break;
        }
    }
}
