package com.inmobi.cmp.core.cmpapi.map;

import androidx.annotation.Keep;
import f6.i;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@Keep
/* loaded from: classes3.dex */
public final class PublisherMap {
    private Map<String, Boolean> consents;
    private final ConsentMap customPurpose;
    private Map<String, Boolean> legitimateInterests;
    private Map<String, Map<String, i>> restrictions;
    private int vendorId;

    public /* synthetic */ PublisherMap(int i10, Map map, Map map2, ConsentMap consentMap, Map map3, int i11, g gVar) {
        this((i11 & 1) != 0 ? 0 : i10, (i11 & 2) != 0 ? new LinkedHashMap() : map, (i11 & 4) != 0 ? new LinkedHashMap() : map2, (i11 & 8) != 0 ? new ConsentMap(null, null, 3, null) : consentMap, (i11 & 16) != 0 ? new LinkedHashMap() : map3);
    }

    public static /* synthetic */ PublisherMap copy$default(PublisherMap publisherMap, int i10, Map map, Map map2, ConsentMap consentMap, Map map3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = publisherMap.vendorId;
        }
        if ((i11 & 2) != 0) {
            map = publisherMap.consents;
        }
        if ((i11 & 4) != 0) {
            map2 = publisherMap.legitimateInterests;
        }
        if ((i11 & 8) != 0) {
            consentMap = publisherMap.customPurpose;
        }
        if ((i11 & 16) != 0) {
            map3 = publisherMap.restrictions;
        }
        Map map4 = map3;
        Map map5 = map2;
        return publisherMap.copy(i10, map, map5, consentMap, map4);
    }

    public final int component1() {
        return this.vendorId;
    }

    public final Map<String, Boolean> component2() {
        return this.consents;
    }

    public final Map<String, Boolean> component3() {
        return this.legitimateInterests;
    }

    public final ConsentMap component4() {
        return this.customPurpose;
    }

    public final Map<String, Map<String, i>> component5() {
        return this.restrictions;
    }

    public final PublisherMap copy(int i10, Map<String, Boolean> map, Map<String, Boolean> map2, ConsentMap consentMap, Map<String, Map<String, i>> map3) {
        map.getClass();
        map2.getClass();
        consentMap.getClass();
        map3.getClass();
        return new PublisherMap(i10, map, map2, consentMap, map3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PublisherMap)) {
            return false;
        }
        PublisherMap publisherMap = (PublisherMap) obj;
        return this.vendorId == publisherMap.vendorId && l.a(this.consents, publisherMap.consents) && l.a(this.legitimateInterests, publisherMap.legitimateInterests) && l.a(this.customPurpose, publisherMap.customPurpose) && l.a(this.restrictions, publisherMap.restrictions);
    }

    public final Map<String, Boolean> getConsents() {
        return this.consents;
    }

    public final ConsentMap getCustomPurpose() {
        return this.customPurpose;
    }

    public final Map<String, Boolean> getLegitimateInterests() {
        return this.legitimateInterests;
    }

    public final Map<String, Map<String, i>> getRestrictions() {
        return this.restrictions;
    }

    public final int getVendorId() {
        return this.vendorId;
    }

    public int hashCode() {
        return this.restrictions.hashCode() + ((this.customPurpose.hashCode() + ((this.legitimateInterests.hashCode() + ((this.consents.hashCode() + (this.vendorId * 31)) * 31)) * 31)) * 31);
    }

    public final void setConsents(Map<String, Boolean> map) {
        map.getClass();
        this.consents = map;
    }

    public final void setLegitimateInterests(Map<String, Boolean> map) {
        map.getClass();
        this.legitimateInterests = map;
    }

    public final void setRestrictions(Map<String, Map<String, i>> map) {
        map.getClass();
        this.restrictions = map;
    }

    public final void setVendorId(int i10) {
        this.vendorId = i10;
    }

    public String toString() {
        return "PublisherMap(vendorId=" + this.vendorId + ", consents=" + this.consents + ", legitimateInterests=" + this.legitimateInterests + ", customPurpose=" + this.customPurpose + ", restrictions=" + this.restrictions + ')';
    }

    public PublisherMap(int i10, Map<String, Boolean> map, Map<String, Boolean> map2, ConsentMap consentMap, Map<String, Map<String, i>> map3) {
        map.getClass();
        map2.getClass();
        consentMap.getClass();
        map3.getClass();
        this.vendorId = i10;
        this.consents = map;
        this.legitimateInterests = map2;
        this.customPurpose = consentMap;
        this.restrictions = map3;
    }

    public PublisherMap() {
        this(0, null, null, null, null, 31, null);
    }
}
