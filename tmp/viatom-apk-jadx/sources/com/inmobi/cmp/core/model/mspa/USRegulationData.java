package com.inmobi.cmp.core.model.mspa;

import a.a;
import androidx.annotation.Keep;
import java.util.List;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import m8.e;
import t6.t;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@Keep
/* loaded from: classes3.dex */
public final class USRegulationData {
    private int additionalProcessingDataConsent;
    private String gppString;
    private List<Integer> knownChildSensitiveDataConsents;
    private int mspaCoveredTransaction;
    private int mspaOptOutOptionMode;
    private int mspaServiceProviderMode;
    private int personalDataConsents;
    private int processingNotice;
    private int saleOptOut;
    private int saleOptOutNotice;
    private int sensitiveDataLimitUseNotice;
    private List<Integer> sensitiveDataProcessing;
    private int sensitiveDataProcessingOptOutNotice;
    private int sharingNotice;
    private int sharingOptOut;
    private int sharingOptOutNotice;
    private int targetedAdvertisingOptOut;
    private int targetedAdvertisingOptOutNotice;
    private int version;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ USRegulationData(int i10, String str, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, List list, List list2, int i21, int i22, int i23, int i24, int i25, int i26, g gVar) {
        int i27 = (i26 & 1) != 0 ? 0 : i10;
        String str2 = (i26 & 2) != 0 ? "" : str;
        int i28 = (i26 & 4) != 0 ? 0 : i11;
        int i29 = (i26 & 8) != 0 ? 0 : i12;
        int i30 = (i26 & 16) != 0 ? 0 : i13;
        int i31 = (i26 & 32) != 0 ? 0 : i14;
        int i32 = (i26 & 64) != 0 ? 0 : i15;
        int i33 = (i26 & 128) != 0 ? 0 : i16;
        int i34 = (i26 & 256) != 0 ? 0 : i17;
        int i35 = (i26 & 512) != 0 ? 0 : i18;
        int i36 = (i26 & 1024) != 0 ? 0 : i19;
        int i37 = (i26 & 2048) != 0 ? 0 : i20;
        int i38 = i26 & 4096;
        List list3 = t.f12808a;
        this(i27, str2, i28, i29, i30, i31, i32, i33, i34, i35, i36, i37, i38 != 0 ? list3 : list, (i26 & 8192) == 0 ? list2 : list3, (i26 & 16384) != 0 ? 0 : i21, (i26 & 32768) != 0 ? 0 : i22, (i26 & 65536) != 0 ? 0 : i23, (i26 & 131072) != 0 ? 0 : i24, (i26 & 262144) != 0 ? 0 : i25);
    }

    public static /* synthetic */ USRegulationData copy$default(USRegulationData uSRegulationData, int i10, String str, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, List list, List list2, int i21, int i22, int i23, int i24, int i25, int i26, Object obj) {
        int i27;
        int i28;
        int i29 = (i26 & 1) != 0 ? uSRegulationData.version : i10;
        String str2 = (i26 & 2) != 0 ? uSRegulationData.gppString : str;
        int i30 = (i26 & 4) != 0 ? uSRegulationData.sharingNotice : i11;
        int i31 = (i26 & 8) != 0 ? uSRegulationData.saleOptOutNotice : i12;
        int i32 = (i26 & 16) != 0 ? uSRegulationData.sharingOptOutNotice : i13;
        int i33 = (i26 & 32) != 0 ? uSRegulationData.targetedAdvertisingOptOutNotice : i14;
        int i34 = (i26 & 64) != 0 ? uSRegulationData.sensitiveDataProcessingOptOutNotice : i15;
        int i35 = (i26 & 128) != 0 ? uSRegulationData.sensitiveDataLimitUseNotice : i16;
        int i36 = (i26 & 256) != 0 ? uSRegulationData.processingNotice : i17;
        int i37 = (i26 & 512) != 0 ? uSRegulationData.saleOptOut : i18;
        int i38 = (i26 & 1024) != 0 ? uSRegulationData.sharingOptOut : i19;
        int i39 = (i26 & 2048) != 0 ? uSRegulationData.targetedAdvertisingOptOut : i20;
        List list3 = (i26 & 4096) != 0 ? uSRegulationData.sensitiveDataProcessing : list;
        List list4 = (i26 & 8192) != 0 ? uSRegulationData.knownChildSensitiveDataConsents : list2;
        int i40 = i29;
        int i41 = (i26 & 16384) != 0 ? uSRegulationData.personalDataConsents : i21;
        int i42 = (i26 & 32768) != 0 ? uSRegulationData.additionalProcessingDataConsent : i22;
        int i43 = (i26 & 65536) != 0 ? uSRegulationData.mspaCoveredTransaction : i23;
        int i44 = (i26 & 131072) != 0 ? uSRegulationData.mspaOptOutOptionMode : i24;
        if ((i26 & 262144) != 0) {
            i28 = i44;
            i27 = uSRegulationData.mspaServiceProviderMode;
        } else {
            i27 = i25;
            i28 = i44;
        }
        return uSRegulationData.copy(i40, str2, i30, i31, i32, i33, i34, i35, i36, i37, i38, i39, list3, list4, i41, i42, i43, i28, i27);
    }

    public final int component1() {
        return this.version;
    }

    public final int component10() {
        return this.saleOptOut;
    }

    public final int component11() {
        return this.sharingOptOut;
    }

    public final int component12() {
        return this.targetedAdvertisingOptOut;
    }

    public final List<Integer> component13() {
        return this.sensitiveDataProcessing;
    }

    public final List<Integer> component14() {
        return this.knownChildSensitiveDataConsents;
    }

    public final int component15() {
        return this.personalDataConsents;
    }

    public final int component16() {
        return this.additionalProcessingDataConsent;
    }

    public final int component17() {
        return this.mspaCoveredTransaction;
    }

    public final int component18() {
        return this.mspaOptOutOptionMode;
    }

    public final int component19() {
        return this.mspaServiceProviderMode;
    }

    public final String component2() {
        return this.gppString;
    }

    public final int component3() {
        return this.sharingNotice;
    }

    public final int component4() {
        return this.saleOptOutNotice;
    }

    public final int component5() {
        return this.sharingOptOutNotice;
    }

    public final int component6() {
        return this.targetedAdvertisingOptOutNotice;
    }

    public final int component7() {
        return this.sensitiveDataProcessingOptOutNotice;
    }

    public final int component8() {
        return this.sensitiveDataLimitUseNotice;
    }

    public final int component9() {
        return this.processingNotice;
    }

    public final USRegulationData copy(int i10, String str, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, List<Integer> list, List<Integer> list2, int i21, int i22, int i23, int i24, int i25) {
        str.getClass();
        list.getClass();
        list2.getClass();
        return new USRegulationData(i10, str, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, list, list2, i21, i22, i23, i24, i25);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof USRegulationData)) {
            return false;
        }
        USRegulationData uSRegulationData = (USRegulationData) obj;
        return this.version == uSRegulationData.version && l.a(this.gppString, uSRegulationData.gppString) && this.sharingNotice == uSRegulationData.sharingNotice && this.saleOptOutNotice == uSRegulationData.saleOptOutNotice && this.sharingOptOutNotice == uSRegulationData.sharingOptOutNotice && this.targetedAdvertisingOptOutNotice == uSRegulationData.targetedAdvertisingOptOutNotice && this.sensitiveDataProcessingOptOutNotice == uSRegulationData.sensitiveDataProcessingOptOutNotice && this.sensitiveDataLimitUseNotice == uSRegulationData.sensitiveDataLimitUseNotice && this.processingNotice == uSRegulationData.processingNotice && this.saleOptOut == uSRegulationData.saleOptOut && this.sharingOptOut == uSRegulationData.sharingOptOut && this.targetedAdvertisingOptOut == uSRegulationData.targetedAdvertisingOptOut && l.a(this.sensitiveDataProcessing, uSRegulationData.sensitiveDataProcessing) && l.a(this.knownChildSensitiveDataConsents, uSRegulationData.knownChildSensitiveDataConsents) && this.personalDataConsents == uSRegulationData.personalDataConsents && this.additionalProcessingDataConsent == uSRegulationData.additionalProcessingDataConsent && this.mspaCoveredTransaction == uSRegulationData.mspaCoveredTransaction && this.mspaOptOutOptionMode == uSRegulationData.mspaOptOutOptionMode && this.mspaServiceProviderMode == uSRegulationData.mspaServiceProviderMode;
    }

    public final int getAdditionalProcessingDataConsent() {
        return this.additionalProcessingDataConsent;
    }

    public final String getGppString() {
        return this.gppString;
    }

    public final List<Integer> getKnownChildSensitiveDataConsents() {
        return this.knownChildSensitiveDataConsents;
    }

    public final int getMspaCoveredTransaction() {
        return this.mspaCoveredTransaction;
    }

    public final int getMspaOptOutOptionMode() {
        return this.mspaOptOutOptionMode;
    }

    public final int getMspaServiceProviderMode() {
        return this.mspaServiceProviderMode;
    }

    public final int getPersonalDataConsents() {
        return this.personalDataConsents;
    }

    public final int getProcessingNotice() {
        return this.processingNotice;
    }

    public final int getSaleOptOut() {
        return this.saleOptOut;
    }

    public final int getSaleOptOutNotice() {
        return this.saleOptOutNotice;
    }

    public final int getSensitiveDataLimitUseNotice() {
        return this.sensitiveDataLimitUseNotice;
    }

    public final List<Integer> getSensitiveDataProcessing() {
        return this.sensitiveDataProcessing;
    }

    public final int getSensitiveDataProcessingOptOutNotice() {
        return this.sensitiveDataProcessingOptOutNotice;
    }

    public final int getSharingNotice() {
        return this.sharingNotice;
    }

    public final int getSharingOptOut() {
        return this.sharingOptOut;
    }

    public final int getSharingOptOutNotice() {
        return this.sharingOptOutNotice;
    }

    public final int getTargetedAdvertisingOptOut() {
        return this.targetedAdvertisingOptOut;
    }

    public final int getTargetedAdvertisingOptOutNotice() {
        return this.targetedAdvertisingOptOutNotice;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return this.mspaServiceProviderMode + ((this.mspaOptOutOptionMode + ((this.mspaCoveredTransaction + ((this.additionalProcessingDataConsent + ((this.personalDataConsents + e.a(e.a((this.targetedAdvertisingOptOut + ((this.sharingOptOut + ((this.saleOptOut + ((this.processingNotice + ((this.sensitiveDataLimitUseNotice + ((this.sensitiveDataProcessingOptOutNotice + ((this.targetedAdvertisingOptOutNotice + ((this.sharingOptOutNotice + ((this.saleOptOutNotice + ((this.sharingNotice + a.b(this.gppString, this.version * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31, this.sensitiveDataProcessing), this.knownChildSensitiveDataConsents)) * 31)) * 31)) * 31)) * 31);
    }

    public final void setAdditionalProcessingDataConsent(int i10) {
        this.additionalProcessingDataConsent = i10;
    }

    public final void setGppString(String str) {
        str.getClass();
        this.gppString = str;
    }

    public final void setKnownChildSensitiveDataConsents(List<Integer> list) {
        list.getClass();
        this.knownChildSensitiveDataConsents = list;
    }

    public final void setMspaCoveredTransaction(int i10) {
        this.mspaCoveredTransaction = i10;
    }

    public final void setMspaOptOutOptionMode(int i10) {
        this.mspaOptOutOptionMode = i10;
    }

    public final void setMspaServiceProviderMode(int i10) {
        this.mspaServiceProviderMode = i10;
    }

    public final void setPersonalDataConsents(int i10) {
        this.personalDataConsents = i10;
    }

    public final void setProcessingNotice(int i10) {
        this.processingNotice = i10;
    }

    public final void setSaleOptOut(int i10) {
        this.saleOptOut = i10;
    }

    public final void setSaleOptOutNotice(int i10) {
        this.saleOptOutNotice = i10;
    }

    public final void setSensitiveDataLimitUseNotice(int i10) {
        this.sensitiveDataLimitUseNotice = i10;
    }

    public final void setSensitiveDataProcessing(List<Integer> list) {
        list.getClass();
        this.sensitiveDataProcessing = list;
    }

    public final void setSensitiveDataProcessingOptOutNotice(int i10) {
        this.sensitiveDataProcessingOptOutNotice = i10;
    }

    public final void setSharingNotice(int i10) {
        this.sharingNotice = i10;
    }

    public final void setSharingOptOut(int i10) {
        this.sharingOptOut = i10;
    }

    public final void setSharingOptOutNotice(int i10) {
        this.sharingOptOutNotice = i10;
    }

    public final void setTargetedAdvertisingOptOut(int i10) {
        this.targetedAdvertisingOptOut = i10;
    }

    public final void setTargetedAdvertisingOptOutNotice(int i10) {
        this.targetedAdvertisingOptOutNotice = i10;
    }

    public final void setVersion(int i10) {
        this.version = i10;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("USRegulationData(version=");
        sb.append(this.version);
        sb.append(", gppString=");
        sb.append(this.gppString);
        sb.append(", sharingNotice=");
        sb.append(this.sharingNotice);
        sb.append(", saleOptOutNotice=");
        sb.append(this.saleOptOutNotice);
        sb.append(", sharingOptOutNotice=");
        sb.append(this.sharingOptOutNotice);
        sb.append(", targetedAdvertisingOptOutNotice=");
        sb.append(this.targetedAdvertisingOptOutNotice);
        sb.append(", sensitiveDataProcessingOptOutNotice=");
        sb.append(this.sensitiveDataProcessingOptOutNotice);
        sb.append(", sensitiveDataLimitUseNotice=");
        sb.append(this.sensitiveDataLimitUseNotice);
        sb.append(", processingNotice=");
        sb.append(this.processingNotice);
        sb.append(", saleOptOut=");
        sb.append(this.saleOptOut);
        sb.append(", sharingOptOut=");
        sb.append(this.sharingOptOut);
        sb.append(", targetedAdvertisingOptOut=");
        sb.append(this.targetedAdvertisingOptOut);
        sb.append(", sensitiveDataProcessing=");
        sb.append(this.sensitiveDataProcessing);
        sb.append(", knownChildSensitiveDataConsents=");
        sb.append(this.knownChildSensitiveDataConsents);
        sb.append(", personalDataConsents=");
        sb.append(this.personalDataConsents);
        sb.append(", additionalProcessingDataConsent=");
        sb.append(this.additionalProcessingDataConsent);
        sb.append(", mspaCoveredTransaction=");
        sb.append(this.mspaCoveredTransaction);
        sb.append(", mspaOptOutOptionMode=");
        sb.append(this.mspaOptOutOptionMode);
        sb.append(", mspaServiceProviderMode=");
        return a3.a.k(sb, this.mspaServiceProviderMode, ')');
    }

    public USRegulationData(int i10, String str, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, List<Integer> list, List<Integer> list2, int i21, int i22, int i23, int i24, int i25) {
        str.getClass();
        list.getClass();
        list2.getClass();
        this.version = i10;
        this.gppString = str;
        this.sharingNotice = i11;
        this.saleOptOutNotice = i12;
        this.sharingOptOutNotice = i13;
        this.targetedAdvertisingOptOutNotice = i14;
        this.sensitiveDataProcessingOptOutNotice = i15;
        this.sensitiveDataLimitUseNotice = i16;
        this.processingNotice = i17;
        this.saleOptOut = i18;
        this.sharingOptOut = i19;
        this.targetedAdvertisingOptOut = i20;
        this.sensitiveDataProcessing = list;
        this.knownChildSensitiveDataConsents = list2;
        this.personalDataConsents = i21;
        this.additionalProcessingDataConsent = i22;
        this.mspaCoveredTransaction = i23;
        this.mspaOptOutOptionMode = i24;
        this.mspaServiceProviderMode = i25;
    }

    public USRegulationData() {
        this(0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, 0, 0, 0, 0, 0, 524287, null);
    }
}
