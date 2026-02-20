package com.inmobi.cmp.core.cmpapi.map;

import androidx.annotation.Keep;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@Keep
/* loaded from: classes3.dex */
public final class ConsentMap {
    private Map<String, Boolean> consents;
    private Map<String, Boolean> legitimateInterests;

    public /* synthetic */ ConsentMap(Map map, Map map2, int i10, g gVar) {
        this((i10 & 1) != 0 ? new LinkedHashMap() : map, (i10 & 2) != 0 ? new LinkedHashMap() : map2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConsentMap copy$default(ConsentMap consentMap, Map map, Map map2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            map = consentMap.consents;
        }
        if ((i10 & 2) != 0) {
            map2 = consentMap.legitimateInterests;
        }
        return consentMap.copy(map, map2);
    }

    public final Map<String, Boolean> component1() {
        return this.consents;
    }

    public final Map<String, Boolean> component2() {
        return this.legitimateInterests;
    }

    public final ConsentMap copy(Map<String, Boolean> map, Map<String, Boolean> map2) {
        map.getClass();
        map2.getClass();
        return new ConsentMap(map, map2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConsentMap)) {
            return false;
        }
        ConsentMap consentMap = (ConsentMap) obj;
        return l.a(this.consents, consentMap.consents) && l.a(this.legitimateInterests, consentMap.legitimateInterests);
    }

    public final Map<String, Boolean> getConsents() {
        return this.consents;
    }

    public final Map<String, Boolean> getLegitimateInterests() {
        return this.legitimateInterests;
    }

    public int hashCode() {
        return this.legitimateInterests.hashCode() + (this.consents.hashCode() * 31);
    }

    public final void setConsents(Map<String, Boolean> map) {
        map.getClass();
        this.consents = map;
    }

    public final void setLegitimateInterests(Map<String, Boolean> map) {
        map.getClass();
        this.legitimateInterests = map;
    }

    public String toString() {
        return "ConsentMap(consents=" + this.consents + ", legitimateInterests=" + this.legitimateInterests + ')';
    }

    public ConsentMap(Map<String, Boolean> map, Map<String, Boolean> map2) {
        map.getClass();
        map2.getClass();
        this.consents = map;
        this.legitimateInterests = map2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ConsentMap() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }
}
