package com.inmobi.cmp.core.model;

import android.content.SharedPreferences;
import androidx.annotation.Keep;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.core.cmpapi.map.ConsentMap;
import com.inmobi.cmp.core.cmpapi.map.OutOfBandMap;
import com.inmobi.cmp.core.cmpapi.map.PublisherMap;
import com.inmobi.cmp.core.cmpapi.status.CmpStatus;
import com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode;
import d0.i;
import f6.b;
import f6.g;
import f6.h;
import f6.m;
import i9.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import m8.e;
import t6.l;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@Keep
/* loaded from: classes3.dex */
public final class GDPRData {
    private Integer cmpId;
    private CmpStatus cmpStatus;
    private Integer cmpVersion;
    private Boolean gdprApplies;
    private String gppString;
    private boolean isServiceSpecific;
    private final OutOfBandMap outOfBand;
    private PrivacyEncodingMode privacyEncodingMode;
    private final PublisherMap publisher;
    private String publisherCC;
    private final ConsentMap purpose;
    private boolean purposeOneTreatment;
    private Map<String, Boolean> specialFeaturesOptions;
    private String tcString;
    private final int tcfPolicyVersion;
    private boolean useNonStandardStacks;
    private final ConsentMap vendor;

    public GDPRData(Set<Integer> set) {
        this.tcfPolicyVersion = 2;
        this.cmpStatus = CmpStatus.LOADING;
        PrivacyEncodingMode privacyEncodingMode = null;
        this.purpose = new ConsentMap(null, null, 3, null);
        this.vendor = new ConsentMap(null, null, 3, null);
        this.specialFeaturesOptions = new LinkedHashMap();
        this.publisher = new PublisherMap(0, null, null, null, null, 31, null);
        this.outOfBand = new OutOfBandMap(null, null, 3, null);
        m tcModel$app_release = ChoiceCmp.INSTANCE.getTcModel$app_release();
        i iVarJ = a.j();
        if (tcModel$app_release == null) {
            return;
        }
        String str = a.h().f11814b.I;
        if (str != null) {
            String upperCase = str.toUpperCase(Locale.ROOT);
            upperCase.getClass();
            privacyEncodingMode = upperCase.equals("TCF") ? PrivacyEncodingMode.TCF : upperCase.equals("GPP") ? PrivacyEncodingMode.GPP : PrivacyEncodingMode.TCF_AND_GPP;
        }
        setPrivacyEncodingMode(privacyEncodingMode == null ? PrivacyEncodingMode.TCF_AND_GPP : privacyEncodingMode);
        PrivacyEncodingMode privacyEncodingMode2 = getPrivacyEncodingMode();
        int i10 = privacyEncodingMode2 == null ? -1 : b.f8070a[privacyEncodingMode2.ordinal()];
        if (i10 == 1) {
            setTcString(iVarJ.t(8));
        } else if (i10 != 2) {
            setTcString(iVarJ.t(8));
            setGppString(iVarJ.t(63));
        } else {
            setGppString(iVarJ.t(63));
        }
        setServiceSpecific(tcModel$app_release.e);
        setUseNonStandardStacks(tcModel$app_release.f);
        setPurposeOneTreatment(tcModel$app_release.g);
        setPublisherCC(tcModel$app_release.h);
        setCmpId(Integer.valueOf(tcModel$app_release.f8105m));
        setCmpVersion(Integer.valueOf(tcModel$app_release.f8106n));
        setGdprApplies(Boolean.valueOf(((SharedPreferences) iVarJ.f6781b).getInt("IABTCF_gdprApplies", 0) == 1));
        OutOfBandMap outOfBand = getOutOfBand();
        outOfBand.setAllowedVendors(e.f(tcModel$app_release.F, set));
        outOfBand.setDisclosedVendors(e.f(tcModel$app_release.E, set));
        ConsentMap purpose = getPurpose();
        purpose.setConsents(e.e(tcModel$app_release.f8110r));
        purpose.setLegitimateInterests(e.e(tcModel$app_release.f8111s));
        ConsentMap vendor = getVendor();
        vendor.setConsents(e.e(tcModel$app_release.f8116z));
        vendor.setLegitimateInterests(e.e(tcModel$app_release.C));
        setSpecialFeaturesOptions(e.e(tcModel$app_release.f8109q));
        PublisherMap publisher = getPublisher();
        publisher.setVendorId(getPublisherVendorId());
        publisher.setConsents(e.e(tcModel$app_release.f8113v));
        publisher.setLegitimateInterests(e.e(tcModel$app_release.f8114w));
        ConsentMap customPurpose = publisher.getCustomPurpose();
        customPurpose.setConsents(e.e(tcModel$app_release.f8115x));
        customPurpose.setLegitimateInterests(e.e(tcModel$app_release.y));
        publisher.setRestrictions(createRestrictions(tcModel$app_release.G));
    }

    private final Map<String, Map<String, f6.i>> createRestrictions(h hVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = hVar.f8083c;
        Iterator it = linkedHashMap2.entrySet().iterator();
        int iMax = 0;
        while (it.hasNext()) {
            Integer num = (Integer) l.k0((Iterable) ((Map.Entry) it.next()).getValue());
            iMax = Math.max(iMax, num == null ? 0 : num.intValue());
        }
        if (iMax > 0) {
            Iterator it2 = linkedHashMap2.entrySet().iterator();
            int iMax2 = 0;
            while (it2.hasNext()) {
                Integer num2 = (Integer) l.k0((Iterable) ((Map.Entry) it2.next()).getValue());
                iMax2 = Math.max(iMax2, num2 == null ? 0 : num2.intValue());
            }
            int i10 = 1;
            if (1 <= iMax2) {
                while (true) {
                    int i11 = i10 + 1;
                    Integer numValueOf = Integer.valueOf(i10);
                    ArrayList arrayList = new ArrayList();
                    for (Map.Entry entry : linkedHashMap2.entrySet()) {
                        if (((Set) entry.getValue()).contains(numValueOf)) {
                            arrayList.add(t1.a((String) entry.getKey()));
                        }
                    }
                    int size = arrayList.size();
                    int i12 = 0;
                    while (i12 < size) {
                        Object obj = arrayList.get(i12);
                        i12++;
                        g gVar = (g) obj;
                        int i13 = gVar.f8079a;
                        if (!linkedHashMap.containsKey(String.valueOf(i13))) {
                            linkedHashMap.put(String.valueOf(i13), new LinkedHashMap());
                        }
                        Map map = (Map) linkedHashMap.get(String.valueOf(i13));
                        if (map != null) {
                        }
                    }
                    if (i10 == iMax2) {
                        break;
                    }
                    i10 = i11;
                }
            }
        }
        return linkedHashMap;
    }

    private final int getPublisherVendorId() {
        int i10 = b6.a.f854a;
        return -1;
    }

    public final Integer getCmpId() {
        return this.cmpId;
    }

    public final CmpStatus getCmpStatus() {
        return this.cmpStatus;
    }

    public final Integer getCmpVersion() {
        return this.cmpVersion;
    }

    public final Boolean getGdprApplies() {
        return this.gdprApplies;
    }

    public final String getGppString() {
        return this.gppString;
    }

    public final OutOfBandMap getOutOfBand() {
        return this.outOfBand;
    }

    public final PrivacyEncodingMode getPrivacyEncodingMode() {
        return this.privacyEncodingMode;
    }

    public final PublisherMap getPublisher() {
        return this.publisher;
    }

    public final String getPublisherCC() {
        return this.publisherCC;
    }

    public final ConsentMap getPurpose() {
        return this.purpose;
    }

    public final boolean getPurposeOneTreatment() {
        return this.purposeOneTreatment;
    }

    public final Map<String, Boolean> getSpecialFeaturesOptions() {
        return this.specialFeaturesOptions;
    }

    public final String getTcString() {
        return this.tcString;
    }

    public final int getTcfPolicyVersion() {
        return this.tcfPolicyVersion;
    }

    public final boolean getUseNonStandardStacks() {
        return this.useNonStandardStacks;
    }

    public final ConsentMap getVendor() {
        return this.vendor;
    }

    public final boolean isServiceSpecific() {
        return this.isServiceSpecific;
    }

    public final void setCmpId(Integer num) {
        this.cmpId = num;
    }

    public final void setCmpStatus(CmpStatus cmpStatus) {
        cmpStatus.getClass();
        this.cmpStatus = cmpStatus;
    }

    public final void setCmpVersion(Integer num) {
        this.cmpVersion = num;
    }

    public final void setGdprApplies(Boolean bool) {
        this.gdprApplies = bool;
    }

    public final void setGppString(String str) {
        this.gppString = str;
    }

    public final void setPrivacyEncodingMode(PrivacyEncodingMode privacyEncodingMode) {
        this.privacyEncodingMode = privacyEncodingMode;
    }

    public final void setPublisherCC(String str) {
        this.publisherCC = str;
    }

    public final void setPurposeOneTreatment(boolean z9) {
        this.purposeOneTreatment = z9;
    }

    public final void setServiceSpecific(boolean z9) {
        this.isServiceSpecific = z9;
    }

    public final void setSpecialFeaturesOptions(Map<String, Boolean> map) {
        map.getClass();
        this.specialFeaturesOptions = map;
    }

    public final void setTcString(String str) {
        this.tcString = str;
    }

    public final void setUseNonStandardStacks(boolean z9) {
        this.useNonStandardStacks = z9;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GDPRData() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ GDPRData(Set set, int i10, kotlin.jvm.internal.g gVar) {
        this((i10 & 1) != 0 ? null : set);
    }
}
