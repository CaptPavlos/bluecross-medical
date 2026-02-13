package com.inmobi.cmp.model;

import a.a;
import androidx.annotation.Keep;
import java.util.Map;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@Keep
/* loaded from: classes3.dex */
public final class NonIABData {
    private boolean gdprApplies;
    private boolean hasGlobalConsent;
    private boolean hasGlobalScope;
    private String metadata;
    private Map<Integer, Boolean> nonIabVendorConsents;

    public NonIABData(boolean z9, boolean z10, boolean z11, String str, Map<Integer, Boolean> map) {
        str.getClass();
        map.getClass();
        this.gdprApplies = z9;
        this.hasGlobalConsent = z10;
        this.hasGlobalScope = z11;
        this.metadata = str;
        this.nonIabVendorConsents = map;
    }

    public static /* synthetic */ NonIABData copy$default(NonIABData nonIABData, boolean z9, boolean z10, boolean z11, String str, Map map, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z9 = nonIABData.gdprApplies;
        }
        if ((i10 & 2) != 0) {
            z10 = nonIABData.hasGlobalConsent;
        }
        if ((i10 & 4) != 0) {
            z11 = nonIABData.hasGlobalScope;
        }
        if ((i10 & 8) != 0) {
            str = nonIABData.metadata;
        }
        if ((i10 & 16) != 0) {
            map = nonIABData.nonIabVendorConsents;
        }
        Map map2 = map;
        boolean z12 = z11;
        return nonIABData.copy(z9, z10, z12, str, map2);
    }

    public final boolean component1() {
        return this.gdprApplies;
    }

    public final boolean component2() {
        return this.hasGlobalConsent;
    }

    public final boolean component3() {
        return this.hasGlobalScope;
    }

    public final String component4() {
        return this.metadata;
    }

    public final Map<Integer, Boolean> component5() {
        return this.nonIabVendorConsents;
    }

    public final NonIABData copy(boolean z9, boolean z10, boolean z11, String str, Map<Integer, Boolean> map) {
        str.getClass();
        map.getClass();
        return new NonIABData(z9, z10, z11, str, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NonIABData)) {
            return false;
        }
        NonIABData nonIABData = (NonIABData) obj;
        return this.gdprApplies == nonIABData.gdprApplies && this.hasGlobalConsent == nonIABData.hasGlobalConsent && this.hasGlobalScope == nonIABData.hasGlobalScope && l.a(this.metadata, nonIABData.metadata) && l.a(this.nonIabVendorConsents, nonIABData.nonIabVendorConsents);
    }

    public final boolean getGdprApplies() {
        return this.gdprApplies;
    }

    public final boolean getHasGlobalConsent() {
        return this.hasGlobalConsent;
    }

    public final boolean getHasGlobalScope() {
        return this.hasGlobalScope;
    }

    public final String getMetadata() {
        return this.metadata;
    }

    public final Map<Integer, Boolean> getNonIabVendorConsents() {
        return this.nonIabVendorConsents;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public int hashCode() {
        boolean z9 = this.gdprApplies;
        ?? r02 = z9;
        if (z9) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        ?? r22 = this.hasGlobalConsent;
        int i11 = r22;
        if (r22 != 0) {
            i11 = 1;
        }
        int i12 = (i10 + i11) * 31;
        boolean z10 = this.hasGlobalScope;
        return this.nonIabVendorConsents.hashCode() + a.b(this.metadata, (i12 + (z10 ? 1 : z10 ? 1 : 0)) * 31);
    }

    public final void setGdprApplies(boolean z9) {
        this.gdprApplies = z9;
    }

    public final void setHasGlobalConsent(boolean z9) {
        this.hasGlobalConsent = z9;
    }

    public final void setHasGlobalScope(boolean z9) {
        this.hasGlobalScope = z9;
    }

    public final void setMetadata(String str) {
        str.getClass();
        this.metadata = str;
    }

    public final void setNonIabVendorConsents(Map<Integer, Boolean> map) {
        map.getClass();
        this.nonIabVendorConsents = map;
    }

    public String toString() {
        return "NonIABData(gdprApplies=" + this.gdprApplies + ", hasGlobalConsent=" + this.hasGlobalConsent + ", hasGlobalScope=" + this.hasGlobalScope + ", metadata=" + this.metadata + ", nonIabVendorConsents=" + this.nonIabVendorConsents + ')';
    }
}
