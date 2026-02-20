package a4;

import a3.x;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.internal.measurement.k4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.WeakHashMap;
import l4.n5;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class c {
    public static final c f = new c();
    public static final Handler g = new Handler(Looper.getMainLooper());
    public static Handler h = null;

    /* renamed from: i, reason: collision with root package name */
    public static final b f203i = new b(0);

    /* renamed from: j, reason: collision with root package name */
    public static final b f204j = new b(1);

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f205a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f206b = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final e f208d = new e();

    /* renamed from: c, reason: collision with root package name */
    public final t1.c f207c = new t1.c(11);
    public final f e = new f(new x(3), 0);

    public static void b() {
        if (h == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            h = handler;
            handler.post(f203i);
            h.postDelayed(f204j, 200L);
        }
    }

    public final void a(View view, n5 n5Var, JSONObject jSONObject, boolean z9) {
        Object obj;
        boolean z10;
        if (k4.a(view) == null) {
            e eVar = this.f208d;
            char c10 = eVar.f214d.contains(view) ? (char) 1 : eVar.f216j ? (char) 2 : (char) 3;
            if (c10 == 3) {
                return;
            }
            JSONObject jSONObjectP = n5Var.P(view);
            z3.b.c(jSONObject, jSONObjectP);
            HashMap map = eVar.f211a;
            if (map.size() == 0) {
                obj = null;
            } else {
                obj = (String) map.get(view);
                if (obj != null) {
                    map.remove(view);
                }
            }
            boolean z11 = false;
            if (obj != null) {
                try {
                    jSONObjectP.put("adSessionId", obj);
                } catch (JSONException e) {
                    Log.e("OMIDLIB", "Error with setting ad session id", e);
                }
                WeakHashMap weakHashMap = eVar.f215i;
                if (weakHashMap.containsKey(view)) {
                    weakHashMap.put(view, Boolean.TRUE);
                } else {
                    z11 = true;
                }
                try {
                    jSONObjectP.put("hasWindowFocus", Boolean.valueOf(z11));
                } catch (JSONException e3) {
                    Log.e("OMIDLIB", "Error with setting has window focus", e3);
                }
                boolean zContains = eVar.h.contains(obj);
                Object objValueOf = Boolean.valueOf(zContains);
                if (zContains) {
                    try {
                        jSONObjectP.put("isPipActive", objValueOf);
                    } catch (JSONException e7) {
                        Log.e("OMIDLIB", "Error with setting is picture-in-picture active", e7);
                    }
                }
                eVar.f216j = true;
                return;
            }
            HashMap map2 = eVar.f212b;
            d dVar = (d) map2.get(view);
            if (dVar != null) {
                map2.remove(view);
            }
            if (dVar != null) {
                w3.f fVar = dVar.f209a;
                JSONArray jSONArray = new JSONArray();
                ArrayList arrayList = dVar.f210b;
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj2 = arrayList.get(i10);
                    i10++;
                    jSONArray.put((String) obj2);
                }
                try {
                    jSONObjectP.put("isFriendlyObstructionFor", jSONArray);
                    jSONObjectP.put("friendlyObstructionClass", fVar.f13505b);
                    jSONObjectP.put("friendlyObstructionPurpose", fVar.f13506c);
                    jSONObjectP.put("friendlyObstructionReason", (Object) null);
                } catch (JSONException e10) {
                    Log.e("OMIDLIB", "Error with setting friendly obstruction", e10);
                }
                z10 = true;
            } else {
                z10 = false;
            }
            boolean z12 = z9 || z10;
            boolean z13 = c10 == 1;
            n5Var.getClass();
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (!z13) {
                    for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                        a(viewGroup.getChildAt(i11), n5Var, jSONObjectP, z12);
                    }
                    return;
                }
                HashMap map3 = new HashMap();
                for (int i12 = 0; i12 < viewGroup.getChildCount(); i12++) {
                    View childAt = viewGroup.getChildAt(i12);
                    ArrayList arrayList2 = (ArrayList) map3.get(Float.valueOf(childAt.getZ()));
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                        map3.put(Float.valueOf(childAt.getZ()), arrayList2);
                    }
                    arrayList2.add(childAt);
                }
                ArrayList arrayList3 = new ArrayList(map3.keySet());
                Collections.sort(arrayList3);
                int size2 = arrayList3.size();
                int i13 = 0;
                while (i13 < size2) {
                    Object obj3 = arrayList3.get(i13);
                    i13++;
                    ArrayList arrayList4 = (ArrayList) map3.get((Float) obj3);
                    int size3 = arrayList4.size();
                    int i14 = 0;
                    while (i14 < size3) {
                        Object obj4 = arrayList4.get(i14);
                        i14++;
                        a((View) obj4, n5Var, jSONObjectP, z12);
                    }
                }
            }
        }
    }
}
