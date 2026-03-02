package t2;

import android.content.Context;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import i0.y;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;
import r2.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f12762d = Pattern.compile("[0-9]+s");
    public static final Charset e = Charset.forName(C.UTF8_NAME);

    /* renamed from: a, reason: collision with root package name */
    public final Context f12763a;

    /* renamed from: b, reason: collision with root package name */
    public final q2.b f12764b;

    /* renamed from: c, reason: collision with root package name */
    public final n.b f12765c = new n.b();

    public c(Context context, q2.b bVar) {
        this.f12763a = context;
        this.f12764b = bVar;
    }

    public static URL a(String str) {
        try {
            return new URL("https://firebaseinstallations.googleapis.com/v1/".concat(str));
        } catch (MalformedURLException e3) {
            throw new e(e3.getMessage());
        }
    }

    public static void b(HttpURLConnection httpURLConnection, String str, String str2, String str3) throws IOException {
        InputStream errorStream = httpURLConnection.getErrorStream();
        String str4 = null;
        if (errorStream != null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream, e));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                    sb.append('\n');
                }
                str4 = String.format("Error when communicating with the Firebase Installations server API. HTTP response: [%d %s: %s]", Integer.valueOf(httpURLConnection.getResponseCode()), httpURLConnection.getResponseMessage(), sb);
            } catch (IOException unused) {
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (IOException unused2) {
                }
                throw th;
            }
            try {
                bufferedReader.close();
            } catch (IOException unused3) {
            }
        }
        if (TextUtils.isEmpty(str4)) {
            return;
        }
        Log.w("Firebase-Installations", str4);
        Log.w("Firebase-Installations", "Firebase options used while communicating with Firebase server APIs: " + str2 + ", " + str3 + (TextUtils.isEmpty(str) ? "" : a3.a.i(", ", str)));
    }

    public static long d(String str) {
        y.a("Invalid Expiration Timestamp.", f12762d.matcher(str).matches());
        if (str == null || str.length() == 0) {
            return 0L;
        }
        return Long.parseLong(str.substring(0, str.length() - 1));
    }

    public static a e(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = httpURLConnection.getInputStream();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, e));
        byte b10 = (byte) (0 | 1);
        jsonReader.beginObject();
        String strNextString = null;
        String strNextString2 = null;
        b bVar = null;
        long jD = 0;
        String strNextString3 = null;
        String strNextString4 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if (strNextName.equals(RewardPlus.NAME)) {
                strNextString3 = jsonReader.nextString();
            } else if (strNextName.equals("fid")) {
                strNextString4 = jsonReader.nextString();
            } else if (strNextName.equals("refreshToken")) {
                strNextString2 = jsonReader.nextString();
            } else if (strNextName.equals("authToken")) {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName2 = jsonReader.nextName();
                    if (strNextName2.equals("token")) {
                        strNextString = jsonReader.nextString();
                    } else if (strNextName2.equals("expiresIn")) {
                        b10 = (byte) (b10 | 1);
                        jD = d(jsonReader.nextString());
                    } else {
                        jsonReader.skipValue();
                    }
                }
                if (b10 != 1) {
                    androidx.window.layout.c.g("Missing required properties: tokenExpirationTimestamp");
                    return null;
                }
                bVar = new b(0, jD, strNextString);
                jsonReader.endObject();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        inputStream.close();
        return new a(strNextString3, strNextString4, strNextString2, bVar, 1);
    }

    public static b f(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = httpURLConnection.getInputStream();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, e));
        byte b10 = (byte) (0 | 1);
        jsonReader.beginObject();
        String strNextString = null;
        long jD = 0;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if (strNextName.equals("token")) {
                strNextString = jsonReader.nextString();
            } else if (strNextName.equals("expiresIn")) {
                jD = d(jsonReader.nextString());
                b10 = (byte) (b10 | 1);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        inputStream.close();
        if (b10 == 1) {
            return new b(1, jD, strNextString);
        }
        androidx.window.layout.c.g("Missing required properties: tokenExpirationTimestamp");
        return null;
    }

    public static void g(HttpURLConnection httpURLConnection, String str, String str2) throws JSONException, IOException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("fid", str);
            jSONObject.put("appId", str2);
            jSONObject.put("authVersion", "FIS_v2");
            jSONObject.put("sdkVersion", "a:19.0.1");
            i(httpURLConnection, jSONObject.toString().getBytes(C.UTF8_NAME));
        } catch (JSONException e3) {
            throw new IllegalStateException(e3);
        }
    }

    public static void h(HttpURLConnection httpURLConnection) throws JSONException, IOException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sdkVersion", "a:19.0.1");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("installation", jSONObject);
            i(httpURLConnection, jSONObject2.toString().getBytes(C.UTF8_NAME));
        } catch (JSONException e3) {
            throw new IllegalStateException(e3);
        }
    }

    public static void i(HttpURLConnection httpURLConnection, byte[] bArr) throws IOException {
        OutputStream outputStream = httpURLConnection.getOutputStream();
        if (outputStream == null) {
            com.google.gson.internal.a.m("Cannot send request to FIS servers. No OutputStream available.");
            return;
        }
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        try {
            gZIPOutputStream.write(bArr);
        } finally {
            try {
                gZIPOutputStream.close();
                outputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a5 A[Catch: NameNotFoundException -> 0x00b9, TryCatch #0 {NameNotFoundException -> 0x00b9, blocks: (B:15:0x006c, B:17:0x007e, B:23:0x0088, B:29:0x0095, B:32:0x00a5, B:35:0x00bb, B:37:0x00c5, B:38:0x00de), top: B:46:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bb A[Catch: NameNotFoundException -> 0x00b9, TryCatch #0 {NameNotFoundException -> 0x00b9, blocks: (B:15:0x006c, B:17:0x007e, B:23:0x0088, B:29:0x0095, B:32:0x00a5, B:35:0x00bb, B:37:0x00c5, B:38:0x00de), top: B:46:0x006c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.net.HttpURLConnection c(java.net.URL r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t2.c.c(java.net.URL, java.lang.String):java.net.HttpURLConnection");
    }
}
