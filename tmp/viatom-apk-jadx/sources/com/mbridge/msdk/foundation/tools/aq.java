package com.mbridge.msdk.foundation.tools;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import java.net.URL;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class aq {
    public static String a(String str) {
        try {
            return (TextUtils.isEmpty(str) || !URLUtil.isValidUrl(str)) ? "" : new URL(str).getHost();
        } catch (Exception e) {
            af.b("UriUtil", e.getMessage());
            return "";
        }
    }

    public static String b(String str) {
        try {
            return (TextUtils.isEmpty(str) || !URLUtil.isValidUrl(str)) ? str : new URL(str).getPath();
        } catch (Exception e) {
            af.b("UriUtil", e.getMessage());
            return "";
        }
    }

    public static int c(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (!URLUtil.isValidUrl(str)) {
                    if (str != null && str.length() > 5 && str.substring(0, 6).equalsIgnoreCase("tcp://")) {
                    }
                }
                return Uri.parse(str).getQueryParameterNames().size();
            }
        } catch (Exception e) {
            af.b("UriUtil", e.getMessage());
        }
        return 0;
    }

    public static String d(String str) {
        try {
            Uri uri = Uri.parse(str);
            return uri.getScheme() + "://" + uri.getHost() + uri.getPath();
        } catch (Exception e) {
            af.b("UriUtil", e.getMessage());
            return "";
        }
    }

    public static String a(String str, String str2) {
        try {
            return (TextUtils.isEmpty(str) || !URLUtil.isValidUrl(str)) ? str : Uri.parse(str).getQueryParameter(str2);
        } catch (Exception e) {
            af.b("UriUtil", e.getMessage());
            return "";
        }
    }
}
