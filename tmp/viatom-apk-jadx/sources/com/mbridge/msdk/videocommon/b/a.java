package com.mbridge.msdk.videocommon.b;

import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private String f6486a;

    /* renamed from: b, reason: collision with root package name */
    private String f6487b;

    private a(String str, String str2) {
        this.f6486a = str;
        this.f6487b = str2;
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                return new a(jSONObject.optString("appId"), jSONObject.optString("placementId"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
