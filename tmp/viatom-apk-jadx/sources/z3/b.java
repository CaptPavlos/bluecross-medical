package z3;

import android.content.res.Resources;
import android.graphics.Point;
import android.util.Log;
import android.view.WindowManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static WindowManager f14402a;

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f14403b = {"x", "y", "width", "height"};

    /* renamed from: c, reason: collision with root package name */
    public static float f14404c = Resources.getSystem().getDisplayMetrics().density;

    public static JSONObject a(int i10, int i11, int i12, int i13) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", i10 / f14404c);
            jSONObject.put("y", i11 / f14404c);
            jSONObject.put("width", i12 / f14404c);
            jSONObject.put("height", i13 / f14404c);
            return jSONObject;
        } catch (JSONException e) {
            Log.e("OMIDLIB", "Error with creating viewStateObject", e);
            return jSONObject;
        }
    }

    public static void b(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (NullPointerException | JSONException e) {
            Log.e("OMIDLIB", "JSONException during JSONObject.put for name [" + str + "]", e);
        }
    }

    public static void c(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("childViews");
            if (jSONArrayOptJSONArray == null) {
                jSONArrayOptJSONArray = new JSONArray();
                jSONObject.put("childViews", jSONArrayOptJSONArray);
            }
            jSONArrayOptJSONArray.put(jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void d(JSONObject jSONObject) throws JSONException {
        float f;
        float f10;
        if (f14402a != null) {
            Point point = new Point(0, 0);
            f14402a.getDefaultDisplay().getRealSize(point);
            float f11 = point.x;
            float f12 = f14404c;
            f = f11 / f12;
            f10 = point.y / f12;
        } else {
            f = 0.0f;
            f10 = 0.0f;
        }
        try {
            jSONObject.put("width", f);
            jSONObject.put("height", f10);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e5 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean e(org.json.JSONObject r7, org.json.JSONObject r8) {
        /*
            if (r7 != 0) goto L6
            if (r8 != 0) goto L6
            goto Le5
        L6:
            r0 = 0
            if (r7 == 0) goto Le7
            if (r8 != 0) goto Ld
            goto Le7
        Ld:
            r1 = r0
        Le:
            r2 = 4
            if (r1 >= r2) goto L26
            java.lang.String[] r2 = z3.b.f14403b
            r2 = r2[r1]
            double r3 = r7.optDouble(r2)
            double r5 = r8.optDouble(r2)
            int r2 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r2 == 0) goto L23
            goto Le7
        L23:
            int r1 = r1 + 1
            goto Le
        L26:
            java.lang.String r1 = "adSessionId"
            java.lang.String r2 = ""
            java.lang.String r3 = r7.optString(r1, r2)
            java.lang.String r1 = r8.optString(r1, r2)
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto Le7
            java.lang.String r1 = "noOutputDevice"
            boolean r3 = r7.optBoolean(r1)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            boolean r1 = r8.optBoolean(r1)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto Le7
            java.lang.String r1 = "hasWindowFocus"
            boolean r3 = r7.optBoolean(r1)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            boolean r1 = r8.optBoolean(r1)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto Le7
            java.lang.String r1 = "isFriendlyObstructionFor"
            org.json.JSONArray r3 = r7.optJSONArray(r1)
            org.json.JSONArray r1 = r8.optJSONArray(r1)
            if (r3 != 0) goto L77
            if (r1 != 0) goto L77
            goto La5
        L77:
            if (r3 != 0) goto L7c
            if (r1 != 0) goto L7c
            goto L8c
        L7c:
            if (r3 == 0) goto Le7
            if (r1 != 0) goto L82
            goto Le7
        L82:
            int r4 = r3.length()
            int r5 = r1.length()
            if (r4 != r5) goto Le7
        L8c:
            r4 = r0
        L8d:
            int r5 = r3.length()
            if (r4 >= r5) goto La5
            java.lang.String r5 = r3.optString(r4, r2)
            java.lang.String r6 = r1.optString(r4, r2)
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto La2
            goto Le7
        La2:
            int r4 = r4 + 1
            goto L8d
        La5:
            java.lang.String r1 = "childViews"
            org.json.JSONArray r7 = r7.optJSONArray(r1)
            org.json.JSONArray r8 = r8.optJSONArray(r1)
            if (r7 != 0) goto Lb4
            if (r8 != 0) goto Lb4
            goto Le2
        Lb4:
            r1 = 0
            if (r7 != 0) goto Lba
            if (r8 != 0) goto Lba
            goto Lc9
        Lba:
            if (r7 == 0) goto Le3
            if (r8 != 0) goto Lbf
            goto Le3
        Lbf:
            int r2 = r7.length()
            int r3 = r8.length()
            if (r2 != r3) goto Le3
        Lc9:
            r2 = r1
        Lca:
            int r3 = r7.length()
            if (r2 >= r3) goto Le2
            org.json.JSONObject r3 = r7.optJSONObject(r2)
            org.json.JSONObject r4 = r8.optJSONObject(r2)
            boolean r3 = e(r3, r4)
            if (r3 != 0) goto Ldf
            goto Le3
        Ldf:
            int r2 = r2 + 1
            goto Lca
        Le2:
            r1 = 1
        Le3:
            if (r1 == 0) goto Le7
        Le5:
            r7 = 1
            return r7
        Le7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: z3.b.e(org.json.JSONObject, org.json.JSONObject):boolean");
    }
}
