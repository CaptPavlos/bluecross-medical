package com.mbridge.msdk.foundation.controller.authoritycontroller;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.out.OnCompletionListener;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: c, reason: collision with root package name */
    private static boolean f3369c = true;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f3370d = true;

    /* renamed from: b, reason: collision with root package name */
    protected AuthorityInfoBean f3372b;
    private e g;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<String> f3371a = new ArrayList<>();
    private int e = 3;
    private String f = "";

    public b() {
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        boolean zB = this.g.b();
        c(this.g.a());
        c(zB ? 1 : 2);
        this.f3372b.authDeviceIdStatus(zB ? 1 : 0);
    }

    public final void a(String str, int i10) {
        if (this.f3372b != null) {
            if (str.equals(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                this.f3372b.authGenDataStatus(i10);
                return;
            }
            if (str.equals(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                this.f3372b.authDeviceIdStatus(i10);
                return;
            }
            if (str.equals(MBridgeConstans.AUTHORITY_ALL_INFO)) {
                this.f3372b.a(i10);
            } else if (str.equals(MBridgeConstans.AUTHORITY_SERIAL_ID)) {
                this.f3372b.authSerialIdStatus(i10);
            } else if (str.equals(MBridgeConstans.AUTHORITY_OTHER)) {
                this.f3372b.authOther(i10);
            }
        }
    }

    public abstract int b(String str);

    public final void b(int i10) {
        com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.AUTHORITY_DNT, i10);
    }

    public final void c() {
        this.f3372b = new AuthorityInfoBean();
        try {
            if (com.mbridge.msdk.foundation.a.a.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA).equals("")) {
                this.f3372b.authGenDataStatus(1);
            }
            if (com.mbridge.msdk.foundation.a.a.a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID).equals("")) {
                this.f3372b.authDeviceIdStatus(1);
            }
            if (com.mbridge.msdk.foundation.a.a.a.a().a(MBridgeConstans.AUTHORITY_SERIAL_ID).equals("")) {
                this.f3372b.authSerialIdStatus(1);
            }
            if (com.mbridge.msdk.foundation.a.a.a.a().a(MBridgeConstans.AUTHORITY_OTHER).equals("")) {
                this.f3372b.authOther(1);
            }
            this.f3371a.add(MBridgeConstans.AUTHORITY_GENERAL_DATA);
            this.f3371a.add(MBridgeConstans.AUTHORITY_DEVICE_ID);
            this.f3371a.add(MBridgeConstans.AUTHORITY_SERIAL_ID);
            this.f3371a.add(MBridgeConstans.AUTHORITY_OTHER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final AuthorityInfoBean d() {
        AuthorityInfoBean authorityInfoBean = this.f3372b;
        if (authorityInfoBean != null) {
            return authorityInfoBean;
        }
        AuthorityInfoBean authorityInfoBean2 = new AuthorityInfoBean();
        authorityInfoBean2.a(1);
        return authorityInfoBean2;
    }

    public final boolean e() {
        int i10 = this.e;
        return i10 == 1 || i10 == 3;
    }

    public final int f() {
        return com.mbridge.msdk.foundation.a.a.a.a().a(MBridgeConstans.AUTHORITY_COPPA, 0);
    }

    public final int g() {
        return this.e;
    }

    public final String h() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (int i10 = 0; i10 < this.f3371a.size(); i10++) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("keyname", String.valueOf(this.f3371a.get(i10)));
                jSONObject.put("client_status", a(this.f3371a.get(i10)));
                jSONObject.put("server_status", b(this.f3371a.get(i10)));
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONArray.toString();
    }

    public final String i() {
        return this.f;
    }

    public static boolean b() {
        return f3370d;
    }

    public static void b(boolean z9) {
        f3370d = z9;
    }

    public static boolean a() {
        return f3369c;
    }

    public static void a(boolean z9) {
        f3369c = z9;
    }

    public final void a(int i10) {
        if (this.f3372b != null) {
            c(i10);
        }
    }

    public final void a(final Context context, final OnCompletionListener onCompletionListener) {
        if (onCompletionListener != null) {
            com.mbridge.msdk.foundation.same.f.a.b().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.controller.authoritycontroller.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.a(context);
                    onCompletionListener.onCompletion();
                }
            });
        } else {
            a(context);
        }
    }

    public final int a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String strA = com.mbridge.msdk.foundation.a.a.a.a().a(str);
                if (TextUtils.isEmpty(strA)) {
                    return 0;
                }
                return Integer.parseInt(strA);
            }
        } catch (Exception e) {
            af.b("SDKAuthorityController", e.getMessage());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        try {
            if (this.g == null) {
                e eVar = new e(context);
                this.g = eVar;
                eVar.a(new e.a() { // from class: com.mbridge.msdk.foundation.controller.authoritycontroller.b.2
                    @Override // com.mbridge.msdk.foundation.controller.e.a
                    public final void a() {
                        b.this.j();
                    }
                });
            }
            j();
        } catch (Throwable th) {
            af.b("SDKAuthorityController", th.getMessage());
        }
    }

    private void c(int i10) {
        this.e = i10 != 1 ? 2 : 1;
    }

    private void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f = str;
    }
}
