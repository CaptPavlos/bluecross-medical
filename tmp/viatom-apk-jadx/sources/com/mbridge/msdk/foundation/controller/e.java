package com.mbridge.msdk.foundation.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.af;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private String f3398a;
    private int e;
    private boolean g;
    private boolean h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f3402i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f3403j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f3404k;

    /* renamed from: l, reason: collision with root package name */
    private a f3405l;

    /* renamed from: m, reason: collision with root package name */
    private final SharedPreferences f3406m;

    /* renamed from: b, reason: collision with root package name */
    private String f3399b = "";

    /* renamed from: c, reason: collision with root package name */
    private String f3400c = "";

    /* renamed from: d, reason: collision with root package name */
    private String f3401d = "";
    private boolean f = false;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface a {
        void a();
    }

    public e(Context context) {
        this.f3398a = "";
        this.e = 0;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        this.f3406m = defaultSharedPreferences;
        if (defaultSharedPreferences != null) {
            defaultSharedPreferences.registerOnSharedPreferenceChangeListener(this);
        }
        if (defaultSharedPreferences != null) {
            this.f3398a = defaultSharedPreferences.getString("IABTCF_TCString", "");
            this.e = defaultSharedPreferences.getInt("IABTCF_gdprApplies", 0);
            a(defaultSharedPreferences.getString("IABTCF_PurposeConsents", ""));
            b(defaultSharedPreferences.getString("IABTCF_VendorConsents", ""));
            c(defaultSharedPreferences.getString("IABTCF_AddtlConsent", ""));
        }
    }

    private boolean a(String str, int i10) {
        return d(str) && i10 <= str.length() && i10 >= 1 && '1' == str.charAt(i10 - 1);
    }

    private void c(String str) {
        this.f3401d = str;
        if (TextUtils.isEmpty(str)) {
            this.f3403j = true;
            return;
        }
        if (MBridgeConstans.GOOGLE_ATP_ID == -1) {
            this.f3404k = false;
            return;
        }
        this.f3404k = true;
        try {
            String[] strArrSplit = str.split("~");
            if (strArrSplit.length > 1) {
                if (TextUtils.isEmpty(strArrSplit[1])) {
                    this.f3403j = false;
                } else {
                    this.f3403j = str.contains(String.valueOf(MBridgeConstans.GOOGLE_ATP_ID));
                }
            }
        } catch (Throwable th) {
            af.b("TCStringManager", th.getMessage());
        }
    }

    private boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("[01]+");
    }

    public final boolean b() {
        if (this.e == 0) {
            this.f = true;
            return true;
        }
        if (!d(this.f3399b) || !d(this.f3400c)) {
            this.f = z;
        } else if (MBridgeConstans.VERIFY_ATP_CONSENT) {
            this.f = (this.f3402i || (this.f3404k && this.f3403j)) && this.g && this.h;
        } else {
            if (!this.f3402i || !this.g || !this.h) {
                z = false;
            }
            this.f = z;
        }
        return this.f;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            switch (str.hashCode()) {
                case -2004976699:
                    if (str.equals("IABTCF_PurposeConsents")) {
                        a(sharedPreferences.getString("IABTCF_PurposeConsents", ""));
                        break;
                    }
                    break;
                case 83641339:
                    if (str.equals("IABTCF_gdprApplies")) {
                        this.e = sharedPreferences.getInt("IABTCF_gdprApplies", 0);
                        break;
                    }
                    break;
                case 1218895378:
                    if (str.equals("IABTCF_TCString")) {
                        this.f3398a = sharedPreferences.getString("IABTCF_TCString", "");
                        break;
                    }
                    break;
                case 1342914771:
                    if (str.equals("IABTCF_AddtlConsent")) {
                        c(sharedPreferences.getString("IABTCF_AddtlConsent", ""));
                        break;
                    }
                    break;
                case 1450203731:
                    if (str.equals("IABTCF_VendorConsents")) {
                        b(sharedPreferences.getString("IABTCF_VendorConsents", ""));
                        break;
                    }
                    break;
            }
            a aVar = this.f3405l;
            if (aVar != null) {
                aVar.a();
            }
        } catch (Throwable th) {
            af.b("TCStringManager", th.getMessage());
        }
    }

    public final String a() {
        return this.f3398a;
    }

    private void a(String str) {
        this.g = a(str, 1);
        this.h = a(str, 2);
        this.f3399b = str;
    }

    public final void a(a aVar) {
        if (aVar != null) {
            this.f3405l = aVar;
        }
    }

    private void b(String str) {
        this.f3402i = a(str, 867);
        this.f3400c = str;
    }
}
