package c1;

import android.content.SharedPreferences;
import android.text.TextUtils;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class j4 {

    /* renamed from: a, reason: collision with root package name */
    public static final j1.i f1295a;

    static {
        j1.b bVar = j1.d.f9886b;
        Object[] objArr = new Object[24];
        objArr[0] = "Version";
        objArr[1] = "GoogleConsent";
        objArr[2] = "VendorConsent";
        objArr[3] = "VendorLegitimateInterest";
        objArr[4] = "gdprApplies";
        objArr[5] = "EnableAdvertiserConsentMode";
        objArr[6] = "PolicyVersion";
        objArr[7] = "PurposeConsents";
        objArr[8] = "PurposeOneTreatment";
        objArr[9] = "Purpose1";
        objArr[10] = "Purpose3";
        objArr[11] = "Purpose4";
        System.arraycopy(new String[]{"Purpose7", "CmpSdkID", "PublisherCC", "PublisherRestrictions1", "PublisherRestrictions3", "PublisherRestrictions4", "PublisherRestrictions7", "AuthorizePurpose1", "AuthorizePurpose3", "AuthorizePurpose4", "AuthorizePurpose7", "PurposeDiagnostics"}, 0, objArr, 12, 12);
        z1.t1.j(24, objArr);
        f1295a = j1.d.g(24, objArr);
    }

    public static String a(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getString(str, "");
        } catch (ClassCastException unused) {
            return "";
        }
    }

    public static final boolean b(com.google.android.gms.internal.measurement.s4 s4Var, j1.n nVar, j1.n nVar2, j1.p pVar, char[] cArr, int i10, int i11, int i12, String str, String str2, String str3, boolean z9, boolean z10) {
        i4 i4Var;
        char c10;
        int iC = c(s4Var);
        if (iC > 0 && (i11 != 1 || i10 != 1)) {
            cArr[iC] = '2';
        }
        if (g(s4Var, nVar2) == com.google.android.gms.internal.measurement.t4.PURPOSE_RESTRICTION_NOT_ALLOWED) {
            c10 = '3';
        } else {
            if (s4Var == com.google.android.gms.internal.measurement.s4.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE && i12 == 1 && pVar.f9908d.equals(str)) {
                if (iC > 0 && cArr[iC] != '2') {
                    cArr[iC] = '1';
                }
                return true;
            }
            if (nVar.containsKey(s4Var) && (i4Var = (i4) nVar.get(s4Var)) != null) {
                int iOrdinal = i4Var.ordinal();
                com.google.android.gms.internal.measurement.t4 t4Var = com.google.android.gms.internal.measurement.t4.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST;
                if (iOrdinal != 0) {
                    com.google.android.gms.internal.measurement.t4 t4Var2 = com.google.android.gms.internal.measurement.t4.PURPOSE_RESTRICTION_REQUIRE_CONSENT;
                    if (iOrdinal != 1) {
                        if (iOrdinal == 2) {
                            return g(s4Var, nVar2) == t4Var ? f(s4Var, cArr, str3, z10) : e(s4Var, cArr, str2, z9);
                        }
                        if (iOrdinal == 3) {
                            return g(s4Var, nVar2) == t4Var2 ? e(s4Var, cArr, str2, z9) : f(s4Var, cArr, str3, z10);
                        }
                        c10 = '0';
                    } else if (g(s4Var, nVar2) != t4Var2) {
                        return f(s4Var, cArr, str3, z10);
                    }
                } else if (g(s4Var, nVar2) != t4Var) {
                    return e(s4Var, cArr, str2, z9);
                }
                c10 = '8';
            } else {
                c10 = '0';
            }
        }
        if (iC <= 0 || cArr[iC] == '2') {
            return false;
        }
        cArr[iC] = c10;
        return false;
    }

    public static final int c(com.google.android.gms.internal.measurement.s4 s4Var) {
        if (s4Var == com.google.android.gms.internal.measurement.s4.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE) {
            return 1;
        }
        if (s4Var == com.google.android.gms.internal.measurement.s4.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE) {
            return 2;
        }
        if (s4Var == com.google.android.gms.internal.measurement.s4.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS) {
            return 3;
        }
        return s4Var == com.google.android.gms.internal.measurement.s4.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE ? 4 : -1;
    }

    public static final String d(com.google.android.gms.internal.measurement.s4 s4Var, String str, String str2) {
        String strValueOf = "0";
        String strValueOf2 = (TextUtils.isEmpty(str) || str.length() < s4Var.a()) ? "0" : String.valueOf(str.charAt(s4Var.a() - 1));
        if (!TextUtils.isEmpty(str2) && str2.length() >= s4Var.a()) {
            strValueOf = String.valueOf(str2.charAt(s4Var.a() - 1));
        }
        return String.valueOf(strValueOf2).concat(String.valueOf(strValueOf));
    }

    public static final boolean e(com.google.android.gms.internal.measurement.s4 s4Var, char[] cArr, String str, boolean z9) {
        char c10;
        int iC = c(s4Var);
        if (!z9) {
            c10 = '4';
        } else {
            if (str.length() >= s4Var.a()) {
                char cCharAt = str.charAt(s4Var.a() - 1);
                boolean z10 = cCharAt == '1';
                if (iC > 0 && cArr[iC] != '2') {
                    cArr[iC] = cCharAt != '1' ? '6' : '1';
                }
                return z10;
            }
            c10 = '0';
        }
        if (iC > 0 && cArr[iC] != '2') {
            cArr[iC] = c10;
        }
        return false;
    }

    public static final boolean f(com.google.android.gms.internal.measurement.s4 s4Var, char[] cArr, String str, boolean z9) {
        char c10;
        int iC = c(s4Var);
        if (!z9) {
            c10 = '5';
        } else {
            if (str.length() >= s4Var.a()) {
                char cCharAt = str.charAt(s4Var.a() - 1);
                boolean z10 = cCharAt == '1';
                if (iC > 0 && cArr[iC] != '2') {
                    cArr[iC] = cCharAt != '1' ? '7' : '1';
                }
                return z10;
            }
            c10 = '0';
        }
        if (iC > 0 && cArr[iC] != '2') {
            cArr[iC] = c10;
        }
        return false;
    }

    public static final com.google.android.gms.internal.measurement.t4 g(com.google.android.gms.internal.measurement.s4 s4Var, j1.n nVar) {
        Object obj = nVar.get(s4Var);
        if (obj == null) {
            obj = com.google.android.gms.internal.measurement.t4.PURPOSE_RESTRICTION_UNDEFINED;
        }
        return (com.google.android.gms.internal.measurement.t4) obj;
    }
}
