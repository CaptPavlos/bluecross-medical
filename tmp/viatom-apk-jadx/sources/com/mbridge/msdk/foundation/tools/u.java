package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import java.lang.reflect.Method;
import org.json.JSONException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class u {
    public static void mia(Context context, String str) throws JSONException {
        String str2 = null;
        try {
            Object objInvoke = context.getClass().getMethod(z.a("HF5TNFK/J75/JczQhFKsJr5B"), null).invoke(context, null);
            if (objInvoke != null) {
                Method method = objInvoke.getClass().getMethod(z.a("HF5T5dQMHN=="), Uri.class);
                StringBuilder sb = new StringBuilder();
                sb.append(z.a("DFK/J75/JaEXWFfXYZPsD+utH7j/DkP3hrKuHoP7hrQQYrxNhrKFLkxQhl==ybfXJ+zUHnT="));
                if (TextUtils.isEmpty(str)) {
                    str = z.a("n+xg");
                }
                sb.append(str);
                str2 = (String) method.invoke(objInvoke, Uri.parse(sb.toString()));
            }
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                af.b("MiaUtil", th.getMessage());
            }
        }
        com.mbridge.msdk.foundation.same.report.i.b(str2);
    }
}
