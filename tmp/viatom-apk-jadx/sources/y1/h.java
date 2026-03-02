package y1;

import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f13759b = Charset.forName(C.UTF8_NAME);

    /* renamed from: a, reason: collision with root package name */
    public final c2.d f13760a;

    public h(c2.d dVar) {
        this.f13760a = dVar;
    }

    public static HashMap a(String str) {
        JSONObject jSONObject = new JSONObject(str);
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strOptString = null;
            if (!jSONObject.isNull(next)) {
                strOptString = jSONObject.optString(next, null);
            }
            map.put(next, strOptString);
        }
        return map;
    }

    public static ArrayList b(String str) throws JSONException {
        JSONArray jSONArray = new JSONObject(str).getJSONArray("rolloutsState");
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            String string = jSONArray.getString(i10);
            try {
                arrayList.add(n.a(string));
            } catch (Exception e) {
                Log.w("FirebaseCrashlytics", "Failed de-serializing rollouts state. " + string, e);
            }
        }
        return arrayList;
    }

    public static String e(List list) {
        HashMap map = new HashMap();
        JSONArray jSONArray = new JSONArray();
        for (int i10 = 0; i10 < list.size(); i10++) {
            try {
                jSONArray.put(new JSONObject(n.f13774a.w(list.get(i10))));
            } catch (JSONException e) {
                Log.w("FirebaseCrashlytics", "Exception parsing rollout assignment!", e);
            }
        }
        map.put("rolloutsState", jSONArray);
        return new JSONObject(map).toString();
    }

    public static void f(File file) {
        if (file.exists() && file.delete()) {
            Log.i("FirebaseCrashlytics", "Deleted corrupt file: " + file.getAbsolutePath(), null);
        }
    }

    public static void g(File file, String str) {
        if (file.exists() && file.delete()) {
            Log.i("FirebaseCrashlytics", "Deleted corrupt file: " + file.getAbsolutePath() + "\nReason: " + str, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.Closeable] */
    public final Map c(String str, boolean z9) throws Throwable {
        Throwable th;
        FileInputStream fileInputStream;
        Exception e;
        c2.d dVar = this.f13760a;
        File fileH = z9 ? dVar.h(str, "internal-keys") : dVar.h(str, "keys");
        if (!fileH.exists() || fileH.length() == 0) {
            g(fileH, "The file has a length of zero for session: " + str);
            return Collections.EMPTY_MAP;
        }
        try {
            try {
                fileInputStream = new FileInputStream(fileH);
                try {
                    HashMap mapA = a(w1.g.i(fileInputStream));
                    w1.g.b(fileInputStream, "Failed to close user metadata file.");
                    return mapA;
                } catch (Exception e3) {
                    e = e3;
                    Log.w("FirebaseCrashlytics", "Error deserializing user metadata.", e);
                    f(fileH);
                    w1.g.b(fileInputStream, "Failed to close user metadata file.");
                    return Collections.EMPTY_MAP;
                }
            } catch (Throwable th2) {
                th = th2;
                w1.g.b(, "Failed to close user metadata file.");
                throw th;
            }
        } catch (Exception e7) {
            fileInputStream = null;
            e = e7;
        } catch (Throwable th3) {
            ?? r12 = 0;
            th = th3;
            w1.g.b(r12, "Failed to close user metadata file.");
            throw th;
        }
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    public final String d(String str) {
        FileInputStream fileInputStream;
        File fileH = this.f13760a.h(str, "user-data");
        Closeable closeable = null;
        if (fileH.exists()) {
            ?? r32 = (fileH.length() > 0L ? 1 : (fileH.length() == 0L ? 0 : -1));
            try {
                if (r32 != 0) {
                    try {
                        fileInputStream = new FileInputStream(fileH);
                        try {
                            JSONObject jSONObject = new JSONObject(w1.g.i(fileInputStream));
                            String strOptString = !jSONObject.isNull("userId") ? jSONObject.optString("userId", null) : null;
                            String str2 = "Loaded userId " + strOptString + " for session " + str;
                            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                                Log.d("FirebaseCrashlytics", str2, null);
                            }
                            w1.g.b(fileInputStream, "Failed to close user metadata file.");
                            return strOptString;
                        } catch (Exception e) {
                            e = e;
                            Log.w("FirebaseCrashlytics", "Error deserializing user metadata.", e);
                            f(fileH);
                            w1.g.b(fileInputStream, "Failed to close user metadata file.");
                            return null;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        fileInputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        w1.g.b(closeable, "Failed to close user metadata file.");
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                closeable = r32;
            }
        }
        String strI = a3.a.i("No userId set for session ", str);
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", strI, null);
        }
        f(fileH);
        return null;
    }

    public final void h(String str, Map map, boolean z9) {
        String string;
        BufferedWriter bufferedWriter;
        c2.d dVar = this.f13760a;
        File fileH = z9 ? dVar.h(str, "internal-keys") : dVar.h(str, "keys");
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                string = new JSONObject(map).toString();
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileH), f13759b));
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            bufferedWriter.write(string);
            bufferedWriter.flush();
            w1.g.b(bufferedWriter, "Failed to close key/value metadata file.");
        } catch (Exception e3) {
            e = e3;
            bufferedWriter2 = bufferedWriter;
            Log.w("FirebaseCrashlytics", "Error serializing key/value metadata.", e);
            f(fileH);
            w1.g.b(bufferedWriter2, "Failed to close key/value metadata file.");
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter2 = bufferedWriter;
            w1.g.b(bufferedWriter2, "Failed to close key/value metadata file.");
            throw th;
        }
    }
}
