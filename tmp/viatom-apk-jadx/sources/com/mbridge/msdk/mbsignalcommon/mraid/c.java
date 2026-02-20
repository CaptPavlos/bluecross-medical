package com.mbridge.msdk.mbsignalcommon.mraid;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.mbsignalcommon.mraid.a;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import j$.util.DesugarCollections;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, String> f4380a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static ArrayList<String> f4381b = new ArrayList<>();

    public static com.mbridge.msdk.mbsignalcommon.windvane.a a(WindVaneWebView windVaneWebView, String str) {
        Set<String> setUnmodifiableSet;
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme) || !scheme.contains(CampaignEx.JSON_KEY_MRAID)) {
            return null;
        }
        com.mbridge.msdk.mbsignalcommon.windvane.a aVar = new com.mbridge.msdk.mbsignalcommon.windvane.a();
        aVar.f4408d = z.a("n+ztLkxpVTzBLkxgHN==");
        aVar.e = uri.getHost();
        int i10 = 0;
        if (f4381b.size() == 0) {
            for (Method method : b.class.getDeclaredMethods()) {
                f4381b.add(method.getName());
            }
        }
        if (!f4381b.contains(aVar.e) && windVaneWebView != null) {
            String campaignId = windVaneWebView.getCampaignId();
            String str2 = aVar.e;
            if (!TextUtils.isEmpty(campaignId)) {
                if (f4380a.containsKey(campaignId)) {
                    String strConcat = f4380a.get(campaignId);
                    if (!TextUtils.isEmpty(str2) && !strConcat.contains(str2)) {
                        if (strConcat.length() > 0) {
                            strConcat = strConcat.concat(",");
                        }
                        f4380a.put(campaignId, strConcat.concat(str2));
                    }
                } else {
                    f4380a.put(campaignId, str2);
                }
            }
            a.C0039a.f4379a.a(windVaneWebView, aVar.e);
            a.C0039a.f4379a.a(windVaneWebView, aVar.e, "Specified command is not implemented");
            return null;
        }
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            setUnmodifiableSet = Collections.EMPTY_SET;
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            do {
                int iIndexOf = encodedQuery.indexOf(38, i10);
                if (iIndexOf == -1) {
                    iIndexOf = encodedQuery.length();
                }
                int iIndexOf2 = encodedQuery.indexOf(61, i10);
                if (iIndexOf2 > iIndexOf || iIndexOf2 == -1) {
                    iIndexOf2 = iIndexOf;
                }
                linkedHashSet.add(Uri.decode(encodedQuery.substring(i10, iIndexOf2)));
                i10 = iIndexOf + 1;
            } while (i10 < encodedQuery.length());
            setUnmodifiableSet = DesugarCollections.unmodifiableSet(linkedHashSet);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str3 : setUnmodifiableSet) {
                jSONObject.put(str3, uri.getQueryParameter(str3));
            }
            aVar.f = jSONObject.toString();
            return aVar;
        } catch (Exception e) {
            e.printStackTrace();
            return aVar;
        }
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f4380a.remove(str);
    }

    public static String a(String str) {
        if (f4380a.containsKey(str)) {
            return f4380a.get(str);
        }
        return null;
    }
}
