package l1;

import android.content.Context;
import android.text.TextUtils;
import i0.k;
import i0.y;
import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final String f10187a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10188b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10189c;

    /* renamed from: d, reason: collision with root package name */
    public final String f10190d;
    public final String e;
    public final String f;
    public final String g;

    public i(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int i10 = n0.d.f11274a;
        y.i(true ^ (str == null || str.trim().isEmpty()), "ApplicationId must be set.");
        this.f10188b = str;
        this.f10187a = str2;
        this.f10189c = str3;
        this.f10190d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
    }

    public static i a(Context context) {
        k kVar = new k(context, 1);
        String strR = kVar.r("google_app_id");
        if (TextUtils.isEmpty(strR)) {
            return null;
        }
        return new i(strR, kVar.r("google_api_key"), kVar.r("firebase_database_url"), kVar.r("ga_trackingId"), kVar.r("gcm_defaultSenderId"), kVar.r("google_storage_bucket"), kVar.r("project_id"));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return y.j(this.f10188b, iVar.f10188b) && y.j(this.f10187a, iVar.f10187a) && y.j(this.f10189c, iVar.f10189c) && y.j(this.f10190d, iVar.f10190d) && y.j(this.e, iVar.e) && y.j(this.f, iVar.f) && y.j(this.g, iVar.g);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f10188b, this.f10187a, this.f10189c, this.f10190d, this.e, this.f, this.g});
    }

    public final String toString() {
        k kVar = new k(this);
        kVar.d(this.f10188b, "applicationId");
        kVar.d(this.f10187a, "apiKey");
        kVar.d(this.f10189c, "databaseUrl");
        kVar.d(this.e, "gcmSenderId");
        kVar.d(this.f, "storageBucket");
        kVar.d(this.g, "projectId");
        return kVar.toString();
    }
}
