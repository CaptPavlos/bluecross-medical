package com.mbridge.msdk.newreward.function.h;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ak;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return SameMD5.getMD5(ak.d());
        }
        try {
            String[] strArrSplit = str.split("_");
            String str2 = (strArrSplit == null || strArrSplit.length < 3) ? "" : strArrSplit[2];
            return TextUtils.isEmpty(str2) ? SameMD5.getMD5(ak.d()) : str2;
        } catch (Exception unused) {
            return SameMD5.getMD5(ak.d());
        }
    }
}
