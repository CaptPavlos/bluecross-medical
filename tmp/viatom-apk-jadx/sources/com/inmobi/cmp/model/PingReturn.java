package com.inmobi.cmp.model;

import androidx.annotation.Keep;
import com.inmobi.cmp.core.cmpapi.status.CmpStatus;
import com.inmobi.cmp.core.cmpapi.status.DisplayStatus;
import com.mbridge.msdk.MBridgeConstans;
import j9.a;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@Keep
/* loaded from: classes3.dex */
public final class PingReturn {
    public static final a Companion = new a();
    private static final PingReturn LOADING_PING;
    private static final PingReturn STUB_PING;
    private String apiVersion;
    private Integer cmpId;
    private boolean cmpLoaded;
    private CmpStatus cmpStatus;
    private String cmpVersion;
    private DisplayStatus displayStatus;
    private Boolean gdprApplies;
    private Integer gvlVersion;
    private Integer tcfPolicyVersion;
    private Boolean usRegulationApplies;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        CmpStatus cmpStatus = CmpStatus.STUB;
        DisplayStatus displayStatus = DisplayStatus.HIDDEN;
        STUB_PING = new PingReturn(null, false, cmpStatus, displayStatus, MBridgeConstans.NATIVE_VIDEO_VERSION, null, null, null, null, null, 512, null);
        LOADING_PING = new PingReturn(null, false, CmpStatus.LOADING, displayStatus, MBridgeConstans.NATIVE_VIDEO_VERSION, "0.1", 10, null == true ? 1 : 0, null, null, 512, null);
    }

    public PingReturn(Boolean bool, boolean z9, CmpStatus cmpStatus, DisplayStatus displayStatus, String str, String str2, Integer num, Integer num2, Integer num3, Boolean bool2) {
        cmpStatus.getClass();
        displayStatus.getClass();
        str.getClass();
        this.gdprApplies = bool;
        this.cmpLoaded = z9;
        this.cmpStatus = cmpStatus;
        this.displayStatus = displayStatus;
        this.apiVersion = str;
        this.cmpVersion = str2;
        this.cmpId = num;
        this.gvlVersion = num2;
        this.tcfPolicyVersion = num3;
        this.usRegulationApplies = bool2;
    }

    public static /* synthetic */ PingReturn copy$default(PingReturn pingReturn, Boolean bool, boolean z9, CmpStatus cmpStatus, DisplayStatus displayStatus, String str, String str2, Integer num, Integer num2, Integer num3, Boolean bool2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            bool = pingReturn.gdprApplies;
        }
        if ((i10 & 2) != 0) {
            z9 = pingReturn.cmpLoaded;
        }
        if ((i10 & 4) != 0) {
            cmpStatus = pingReturn.cmpStatus;
        }
        if ((i10 & 8) != 0) {
            displayStatus = pingReturn.displayStatus;
        }
        if ((i10 & 16) != 0) {
            str = pingReturn.apiVersion;
        }
        if ((i10 & 32) != 0) {
            str2 = pingReturn.cmpVersion;
        }
        if ((i10 & 64) != 0) {
            num = pingReturn.cmpId;
        }
        if ((i10 & 128) != 0) {
            num2 = pingReturn.gvlVersion;
        }
        if ((i10 & 256) != 0) {
            num3 = pingReturn.tcfPolicyVersion;
        }
        if ((i10 & 512) != 0) {
            bool2 = pingReturn.usRegulationApplies;
        }
        Integer num4 = num3;
        Boolean bool3 = bool2;
        Integer num5 = num;
        Integer num6 = num2;
        String str3 = str;
        String str4 = str2;
        return pingReturn.copy(bool, z9, cmpStatus, displayStatus, str3, str4, num5, num6, num4, bool3);
    }

    public final Boolean component1() {
        return this.gdprApplies;
    }

    public final Boolean component10() {
        return this.usRegulationApplies;
    }

    public final boolean component2() {
        return this.cmpLoaded;
    }

    public final CmpStatus component3() {
        return this.cmpStatus;
    }

    public final DisplayStatus component4() {
        return this.displayStatus;
    }

    public final String component5() {
        return this.apiVersion;
    }

    public final String component6() {
        return this.cmpVersion;
    }

    public final Integer component7() {
        return this.cmpId;
    }

    public final Integer component8() {
        return this.gvlVersion;
    }

    public final Integer component9() {
        return this.tcfPolicyVersion;
    }

    public final PingReturn copy(Boolean bool, boolean z9, CmpStatus cmpStatus, DisplayStatus displayStatus, String str, String str2, Integer num, Integer num2, Integer num3, Boolean bool2) {
        cmpStatus.getClass();
        displayStatus.getClass();
        str.getClass();
        return new PingReturn(bool, z9, cmpStatus, displayStatus, str, str2, num, num2, num3, bool2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PingReturn)) {
            return false;
        }
        PingReturn pingReturn = (PingReturn) obj;
        return l.a(this.gdprApplies, pingReturn.gdprApplies) && this.cmpLoaded == pingReturn.cmpLoaded && this.cmpStatus == pingReturn.cmpStatus && this.displayStatus == pingReturn.displayStatus && l.a(this.apiVersion, pingReturn.apiVersion) && l.a(this.cmpVersion, pingReturn.cmpVersion) && l.a(this.cmpId, pingReturn.cmpId) && l.a(this.gvlVersion, pingReturn.gvlVersion) && l.a(this.tcfPolicyVersion, pingReturn.tcfPolicyVersion) && l.a(this.usRegulationApplies, pingReturn.usRegulationApplies);
    }

    public final String getApiVersion() {
        return this.apiVersion;
    }

    public final Integer getCmpId() {
        return this.cmpId;
    }

    public final boolean getCmpLoaded() {
        return this.cmpLoaded;
    }

    public final CmpStatus getCmpStatus() {
        return this.cmpStatus;
    }

    public final String getCmpVersion() {
        return this.cmpVersion;
    }

    public final DisplayStatus getDisplayStatus() {
        return this.displayStatus;
    }

    public final Boolean getGdprApplies() {
        return this.gdprApplies;
    }

    public final Integer getGvlVersion() {
        return this.gvlVersion;
    }

    public final Integer getTcfPolicyVersion() {
        return this.tcfPolicyVersion;
    }

    public final Boolean getUsRegulationApplies() {
        return this.usRegulationApplies;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Boolean bool = this.gdprApplies;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        boolean z9 = this.cmpLoaded;
        int i10 = z9;
        if (z9 != 0) {
            i10 = 1;
        }
        int iB = a.a.b(this.apiVersion, (this.displayStatus.hashCode() + ((this.cmpStatus.hashCode() + ((iHashCode + i10) * 31)) * 31)) * 31);
        String str = this.cmpVersion;
        int iHashCode2 = (iB + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.cmpId;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.gvlVersion;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.tcfPolicyVersion;
        int iHashCode5 = (iHashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Boolean bool2 = this.usRegulationApplies;
        return iHashCode5 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public final void setApiVersion(String str) {
        str.getClass();
        this.apiVersion = str;
    }

    public final void setCmpId(Integer num) {
        this.cmpId = num;
    }

    public final void setCmpLoaded(boolean z9) {
        this.cmpLoaded = z9;
    }

    public final void setCmpStatus(CmpStatus cmpStatus) {
        cmpStatus.getClass();
        this.cmpStatus = cmpStatus;
    }

    public final void setCmpVersion(String str) {
        this.cmpVersion = str;
    }

    public final void setDisplayStatus(DisplayStatus displayStatus) {
        displayStatus.getClass();
        this.displayStatus = displayStatus;
    }

    public final void setGdprApplies(Boolean bool) {
        this.gdprApplies = bool;
    }

    public final void setGvlVersion(Integer num) {
        this.gvlVersion = num;
    }

    public final void setTcfPolicyVersion(Integer num) {
        this.tcfPolicyVersion = num;
    }

    public final void setUsRegulationApplies(Boolean bool) {
        this.usRegulationApplies = bool;
    }

    public String toString() {
        return "PingReturn(gdprApplies=" + this.gdprApplies + ", cmpLoaded=" + this.cmpLoaded + ", cmpStatus=" + this.cmpStatus + ", displayStatus=" + this.displayStatus + ", apiVersion=" + this.apiVersion + ", cmpVersion=" + ((Object) this.cmpVersion) + ", cmpId=" + this.cmpId + ", gvlVersion=" + this.gvlVersion + ", tcfPolicyVersion=" + this.tcfPolicyVersion + ", usRegulationApplies=" + this.usRegulationApplies + ')';
    }

    public /* synthetic */ PingReturn(Boolean bool, boolean z9, CmpStatus cmpStatus, DisplayStatus displayStatus, String str, String str2, Integer num, Integer num2, Integer num3, Boolean bool2, int i10, g gVar) {
        this(bool, z9, cmpStatus, displayStatus, str, str2, num, num2, num3, (i10 & 512) != 0 ? null : bool2);
    }
}
