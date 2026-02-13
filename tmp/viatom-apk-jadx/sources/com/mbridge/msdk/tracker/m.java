package com.mbridge.msdk.tracker;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m {

    /* renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, m> f5369b = new ConcurrentHashMap<>();

    /* renamed from: a, reason: collision with root package name */
    private final k f5370a;

    private m(String str, Context context, w wVar) {
        k kVar = new k(str, this);
        this.f5370a = kVar;
        kVar.a(context);
        kVar.a(wVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(e eVar) {
        if (y.a(eVar) || TextUtils.isEmpty(eVar.a())) {
            return false;
        }
        return this.f5370a.a(eVar);
    }

    public static m[] d() {
        ConcurrentHashMap<String, m> concurrentHashMap = f5369b;
        m[] mVarArr = new m[concurrentHashMap.size()];
        try {
            Iterator<Map.Entry<String, m>> it = concurrentHashMap.entrySet().iterator();
            int i10 = 0;
            while (it.hasNext()) {
                mVarArr[i10] = it.next().getValue();
                i10++;
            }
        } catch (Exception e) {
            if (a.f5328a) {
                Log.e("TrackManager", "getAllTrackManager error", e);
            }
        }
        return mVarArr;
    }

    public final void a(final e eVar) {
        if (this.f5370a.r()) {
            if (a.f5328a) {
                Log.d("TrackManager", "SDK is shutdown, track event will not be processed");
                return;
            }
            return;
        }
        try {
            this.f5370a.i().a(new Runnable() { // from class: com.mbridge.msdk.tracker.m.2
                @Override // java.lang.Runnable
                public final void run() throws JSONException {
                    if (m.this.c(eVar)) {
                        m.this.f5370a.h().a(eVar);
                        eVar.c(m.this.f5370a.d().f);
                        JSONObject jSONObjectD = eVar.d();
                        if (jSONObjectD != null) {
                            try {
                                jSONObjectD.put("session_id", m.this.b());
                                long[] jArrH = m.this.h();
                                jSONObjectD.put("track_time", jArrH[0]);
                                jSONObjectD.put("track_count", jArrH[1]);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            eVar.a(jSONObjectD);
                        }
                        m.this.f5370a.h().b(eVar);
                    }
                }
            });
        } catch (Exception e) {
            if (a.f5328a) {
                Log.e("TrackManager", "trackEvent error", e);
            }
        }
    }

    public final String b() {
        return this.f5370a.b();
    }

    public final boolean e() {
        return !this.f5370a.r();
    }

    public final void f() {
        try {
            this.f5370a.i().a(new Runnable() { // from class: com.mbridge.msdk.tracker.m.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        t.a().c();
                        m.this.f5370a.o().b();
                    } catch (Exception e) {
                        if (a.f5328a) {
                            Log.e("TrackManager", "flush error", e);
                        }
                    }
                }
            });
        } catch (Exception e) {
            if (a.f5328a) {
                Log.e("TrackManager", "flush error", e);
            }
        }
    }

    public final JSONObject g() {
        return this.f5370a.f();
    }

    public final long[] h() {
        return this.f5370a.h().a();
    }

    public final void i() {
        this.f5370a.s();
    }

    private boolean b(e eVar) {
        try {
            return c(eVar);
        } catch (Exception unused) {
            return false;
        }
    }

    public final String c() {
        return this.f5370a.c();
    }

    public static m a(String str, Context context, w wVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ConcurrentHashMap<String, m> concurrentHashMap = f5369b;
        m mVar = concurrentHashMap.get(str);
        if (!y.a(mVar)) {
            return mVar;
        }
        m mVar2 = new m(str, context, wVar);
        concurrentHashMap.put(str, mVar2);
        return mVar2;
    }

    public final String a() {
        if (e()) {
            if (a.f5328a) {
                Log.e("TrackManager", "MBridgeTrackManager is already running");
            }
            return this.f5370a.b();
        }
        return this.f5370a.a();
    }

    public final void a(JSONObject jSONObject) {
        this.f5370a.a(jSONObject);
    }

    public final boolean a(String str) {
        return b(new e(str));
    }
}
