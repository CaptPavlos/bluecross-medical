package com.mbridge.msdk.dycreator.baseview;

import android.content.ContentProviderClient;
import android.content.res.TypedArray;
import android.drm.DrmManagerClient;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.provider.b;
import androidx.sqlite.SQLiteStatement;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkRequest;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.report.k;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.uptodown.activities.preferences.PreferencesActivity;
import d5.k0;
import e5.j0;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import u7.m0;
import z8.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract /* synthetic */ class a {
    public static boolean a(SQLiteStatement sQLiteStatement, int i10) {
        return sQLiteStatement.getLong(i10) != 0;
    }

    public static ArrayList b(SQLiteStatement sQLiteStatement) {
        int columnCount = sQLiteStatement.getColumnCount();
        ArrayList arrayList = new ArrayList(columnCount);
        for (int i10 = 0; i10 < columnCount; i10++) {
            arrayList.add(sQLiteStatement.getColumnName(i10));
        }
        return arrayList;
    }

    public static /* synthetic */ String c(int i10) {
        switch (i10) {
            case 1:
                return "IABTCF_CmpSdkID";
            case 2:
                return "IABTCF_CmpSdkVersion";
            case 3:
                return "IABTCF_PolicyVersion";
            case 4:
                return "IABTCF_gdprApplies";
            case 5:
                return "IABTCF_PublisherCC";
            case 6:
                return "IABTCF_PurposeOneTreatment";
            case 7:
                return "IABTCF_UseNonStandardStacks";
            case 8:
                return "IABTCF_TCString";
            case 9:
                return "IABTCF_VendorConsents";
            case 10:
                return "IABTCF_VendorLegitimateInterests";
            case 11:
                return "IABTCF_PurposeConsents";
            case 12:
                return "IABTCF_PurposeLegitimateInterests";
            case 13:
                return "IABTCF_SpecialFeaturesOptIns";
            case 14:
                return "IABTCF_PublisherRestrictions";
            case 15:
                return "IABTCF_PublisherConsent";
            case 16:
                return "IABTCF_PublisherLegitimateInterests";
            case 17:
                return "IABTCF_PublisherCustomPurposesConsents";
            case 18:
                return "IABTCF_PublisherCustomPurposesLegitimateInterests";
            case 19:
                return "GVL";
            case 20:
                return "Cmp";
            case 21:
                return "portal_config";
            case 22:
                return "option_hash";
            case 23:
                return "non_IAB_vendor_hash";
            case 24:
                return "portal_config_hash";
            case 25:
                return "gvl_version";
            case 26:
                return "gvl_last_updated";
            case 27:
                return "portal_non_hash";
            case 28:
                return "translations_text";
            case 29:
                return "googleVendorList";
            case 30:
                return "googleVendorLastUpdate";
            case 31:
                return "IABTCF_AddtlConsent";
            case 32:
                return "google_enabled";
            case 33:
                return "lang_";
            case 34:
                return "IABTCF_NonIABConsentEncoded";
            case 35:
                return "IABTCF_NonIABConsent";
            case 36:
                return "IABTCF_NonIABLegInterests";
            case 37:
                return "IABUSPrivacy_String";
            case 38:
                return "IABUSSavedPrivacyString";
            case 39:
                return "GBCPurposeHash";
            case 40:
                return "GBCConsentString";
            case 41:
                return "GBCResponse";
            case 42:
                return "MSPAPurposes";
            case 43:
                return "IABGPP_TCFEU2_CmpSdkID";
            case 44:
                return "IABGPP_TCFEU2_CmpSdkVersion";
            case 45:
                return "IABGPP_TCFEU2_PolicyVersion";
            case 46:
                return "IABGPP_TCFEU2_gdprApplies";
            case 47:
                return "IABGPP_TCFEU2_PublisherCC";
            case 48:
                return "IABGPP_TCFEU2_PurposeOneTreatment";
            case 49:
                return "IABGPP_TCFEU2_UseNonStandardStacks";
            case 50:
                return "IABGPP_2_TCString";
            case 51:
                return "IABGPP_TCFEU2_VendorConsents";
            case 52:
                return "IABGPP_TCFEU2_VendorLegitimateInterests";
            case 53:
                return "IABGPP_TCFEU2_PurposeConsents";
            case 54:
                return "IABGPP_TCFEU2_PurposeLegitimateInterests";
            case 55:
                return "IABGPP_TCFEU2_SpecialFeaturesOptIns";
            case 56:
                return "IABGPP_TCFEU2_PublisherRestrictions";
            case 57:
                return "IABGPP_TCFEU2_PublisherConsent";
            case 58:
                return "IABGPP_TCFEU2_PublisherLegitimateInterests";
            case 59:
                return "IABGPP_TCFEU2_PublisherCustomPurposesConsents";
            case 60:
                return "IABGPP_TCFEU2_PublisherCustomPurposesLegitimateInterests";
            case 61:
                return "IABGPP_HDR_Version";
            case 62:
                return "IABGPP_HDR_Sections";
            case 63:
                return "IABGPP_HDR_GppString";
            case 64:
                return "IABGPP_GppSID";
            case 65:
                return "IABGPP_[SectionID]_String";
            case 66:
                return "MSPAPurposeHash";
            case 67:
                return "MSPAShown";
            case 68:
                return "SavedSectionId";
            case 69:
                return "MSPAJurisdiction";
            case 70:
                return "SavedRegion";
            case 71:
                return "MSPAPurposesConsent";
            case 72:
                return "MSPASensitivePurposeConsent";
            case 73:
                return "MSPAStatus";
            case 74:
                return "MSPAConsentGivenExplicitly";
            case 75:
                return "GDPRShown";
            case 76:
                return "GDPRStatus";
            case 77:
                return "CCPAShown";
            case 78:
                return "CCPAConsentGivenExplicitly";
            case 79:
                return "LastVisitTime";
            case 80:
                return "GDPR_Consent_LastStoredTimeStamp";
            case 81:
                return "ConfigThemeUUID";
            case 82:
                return "ConfigLanguage";
            case 83:
                return "ConfigCOPApplicable";
            case 84:
                return "ConfigADVApplicable";
            case 85:
                return "ConfigGBCApplicable";
            case 86:
                return "MSPAConfigThemeUUID";
            case 87:
                return "MSPAConfigLanguage";
            case 88:
                return "MSPAConfigGBCApplicable";
            case 89:
                return "CCPAConfigThemeUUID";
            case 90:
                return "CCPAConfigLanguage";
            case 91:
                return "CCPAConfigGBCApplicable";
            case 92:
                return "GBCShown";
            case 93:
                return "GBCStatus";
            default:
                throw null;
        }
    }

    public static /* synthetic */ String d(int i10) {
        if (i10 == 1) {
            return "N";
        }
        if (i10 == 2) {
            return "Y";
        }
        throw null;
    }

    public static int e(float f) {
        return ak.a(c.m().c(), f);
    }

    public static Bundle f(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(str, str2);
        return bundle;
    }

    public static View g(ViewGroup viewGroup, int i10, ViewGroup viewGroup2, boolean z9) {
        viewGroup.getClass();
        return LayoutInflater.from(viewGroup.getContext()).inflate(i10, viewGroup2, z9);
    }

    public static WorkRequest.Builder h(Class cls, String str) {
        return new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) cls).addTag(str);
    }

    public static k i(String str) {
        return new k.a(str).a();
    }

    public static k0 j(PreferencesActivity preferencesActivity, int i10, TextView textView) {
        textView.setText(preferencesActivity.getString(i10));
        return preferencesActivity.p0();
    }

    public static HashMap k(Class cls, m2.a aVar) {
        HashMap map = new HashMap();
        map.put(cls, aVar);
        return map;
    }

    public static Map l(HashMap map) {
        return DesugarCollections.unmodifiableMap(new HashMap(map));
    }

    public static void m(int i10, String str, String str2) {
        af.a(str2, str + i10);
    }

    public static void n(int i10, HashMap map, String str, int i11, String str2) {
        map.put(str, Integer.valueOf(i10));
        map.put(str2, Integer.valueOf(i11));
    }

    public static void o(int i10, m0 m0Var, Object obj) {
        Integer numValueOf = Integer.valueOf(i10);
        m0Var.getClass();
        m0Var.g(obj, numValueOf);
    }

    public static void p(View view, int i10, ImageView imageView) {
        imageView.setImageDrawable(ContextCompat.getDrawable(view.getContext(), i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void q(SQLiteStatement sQLiteStatement) throws Exception {
        if (sQLiteStatement instanceof AutoCloseable) {
            sQLiteStatement.close();
            return;
        }
        if (sQLiteStatement instanceof ExecutorService) {
            b.e((ExecutorService) sQLiteStatement);
            return;
        }
        if (sQLiteStatement instanceof TypedArray) {
            ((TypedArray) sQLiteStatement).recycle();
            return;
        }
        if (sQLiteStatement instanceof MediaMetadataRetriever) {
            ((MediaMetadataRetriever) sQLiteStatement).release();
            return;
        }
        if (sQLiteStatement instanceof MediaDrm) {
            ((MediaDrm) sQLiteStatement).release();
            return;
        }
        if (sQLiteStatement instanceof DrmManagerClient) {
            ((DrmManagerClient) sQLiteStatement).release();
        } else if (sQLiteStatement instanceof ContentProviderClient) {
            ((ContentProviderClient) sQLiteStatement).release();
        } else {
            f.a();
        }
    }

    public static void r(j0 j0Var, int i10, ImageView imageView) {
        imageView.setImageDrawable(ContextCompat.getDrawable(j0Var.requireContext(), i10));
    }

    public static /* synthetic */ void s(Object obj) {
        if (obj == null) {
            return;
        }
        com.google.gson.internal.a.k();
    }

    public static void t(String str, int i10, RelativeLayout.LayoutParams layoutParams, int i11) {
        layoutParams.addRule(i11, str.substring(i10).hashCode());
    }

    public static void u(String str, String str2, Throwable th) {
        af.b(str2, str + th);
    }

    public static void v(Throwable th, StringBuilder sb, String str) {
        sb.append(th.getMessage());
        af.a(str, sb.toString());
    }

    public static /* synthetic */ boolean w(Object obj) {
        return obj != null;
    }

    public static View x(ViewGroup viewGroup, int i10, ViewGroup viewGroup2, boolean z9) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(i10, viewGroup2, z9);
        viewInflate.getClass();
        return viewInflate;
    }

    public static /* synthetic */ String y(int i10) {
        switch (i10) {
            case 1:
                return "BEGIN_ARRAY";
            case 2:
                return "END_ARRAY";
            case 3:
                return "BEGIN_OBJECT";
            case 4:
                return "END_OBJECT";
            case 5:
                return "NAME";
            case 6:
                return "STRING";
            case 7:
                return "NUMBER";
            case 8:
                return "BOOLEAN";
            case 9:
                return "NULL";
            case 10:
                return "END_DOCUMENT";
            default:
                return "null";
        }
    }
}
