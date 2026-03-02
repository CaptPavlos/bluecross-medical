package com.mbridge.msdk.newreward.function.h;

import android.text.TextUtils;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.newreward.function.common.MBridgeTaskManager;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {
    public static String a(File file) throws Throwable {
        FileInputStream fileInputStream;
        StringBuilder sb = new StringBuilder();
        FileInputStream fileInputStream2 = null;
        try {
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception unused2) {
        }
        try {
            byte[] bArr = new byte[1024];
            for (int i10 = fileInputStream.read(bArr); i10 > 0; i10 = fileInputStream.read(bArr)) {
                sb.append(new String(bArr, 0, i10));
            }
            fileInputStream.close();
        } catch (Exception unused3) {
            fileInputStream2 = fileInputStream;
            sb.setLength(0);
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            return sb.toString();
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Exception unused4) {
                }
            }
            throw th;
        }
        return sb.toString();
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return ak.i(str);
    }

    public static boolean c(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String[] strArrSplit2 = str.split("_");
            if (strArrSplit2.length < 4) {
                return false;
            }
            String str2 = strArrSplit2[3];
            if (!TextUtils.isEmpty(str2) && (strArrSplit = z.a(str2).split("\\|")) != null) {
                if (strArrSplit.length != 0) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public static double d(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str)) {
            return 0.0d;
        }
        try {
            strArrSplit = str.split("_");
        } catch (Exception unused) {
        }
        if (strArrSplit.length < 4) {
            return 0.0d;
        }
        String str2 = strArrSplit[3];
        if (TextUtils.isEmpty(str2)) {
            return 0.0d;
        }
        String[] strArrSplit2 = z.a(str2).split("\\|");
        if (strArrSplit2.length > 0) {
            return Double.parseDouble(strArrSplit2[0]);
        }
        return 0.0d;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String path = new URL(str).getPath();
            return path.substring(path.lastIndexOf(47) + 1);
        } catch (Exception unused) {
            return str;
        }
    }

    public static void a(final String str, final int i10, final int i11, final int i12) {
        MBridgeTaskManager.commonExecute(new Runnable() { // from class: com.mbridge.msdk.newreward.function.h.c.1
            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ivRewardEnable", 1);
                    jSONObject.put("ivRewardMode", i10 == com.mbridge.msdk.foundation.same.a.H ? 0 : 1);
                    jSONObject.put("ivRewardPlayValueMode", i11 == com.mbridge.msdk.foundation.same.a.J ? 0 : 1);
                    jSONObject.put("ivRewardPlayValue", i12);
                    h.a().f(str, jSONObject.toString());
                } catch (Exception unused) {
                }
            }
        });
    }
}
