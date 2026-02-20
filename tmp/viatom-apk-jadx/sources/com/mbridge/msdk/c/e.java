package com.mbridge.msdk.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public int f2713a;

    /* renamed from: b, reason: collision with root package name */
    private HashMap<String, f> f2714b;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final e f2715a = new e();
    }

    private e() {
        this.f2713a = 6;
        this.f2714b = new HashMap<>();
    }

    public final int a(String str) {
        HashMap<String, f> map;
        f fVar;
        if (TextUtils.isEmpty(str) || (map = this.f2714b) == null || !map.containsKey(str) || (fVar = this.f2714b.get(str)) == null) {
            return 0;
        }
        int i10 = fVar.b() ? 1 : fVar.a() >= this.f2713a ? 2 : 0;
        fVar.a(false);
        return i10;
    }

    public final void b(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (this.f2714b == null) {
                this.f2714b = new HashMap<>();
            }
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String string = jSONObject.getString(next);
                f fVar = new f();
                fVar.a(next);
                fVar.b(string);
                this.f2714b.put(next, fVar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static e a() {
        return a.f2715a;
    }
}
