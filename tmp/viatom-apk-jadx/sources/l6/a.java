package l6;

import java.util.Collections;
import java.util.Map;
import s6.i;
import t6.a0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Map f11082a;

    /* renamed from: b, reason: collision with root package name */
    public static final Object f11083b;

    static {
        Map mapSingletonMap = Collections.singletonMap("core", new String[]{"version", "created", "lastUpdated", "cmpId", "cmpVersion", "consentScreen", "consentLanguage", "vendorListVersion", "purposeConsents", "vendorConsents"});
        mapSingletonMap.getClass();
        f11082a = mapSingletonMap;
        f11083b = a0.i0(new i("core", new String[]{"version", "created", "lastUpdated", "cmpId", "cmpVersion", "consentScreen", "consentLanguage", "vendorListVersion", "policyVersion", "isServiceSpecific", "useNonStandardStacks", "specialFeatureOptions", "purposeConsents", "purposeLegitimateInterests", "purposeOneTreatment", "publisherCountryCode", "vendorConsents", "vendorLegitimateInterests", "publisherRestrictions"}), new i("publisherTC", new String[]{"publisherConsents", "publisherLegitimateInterests", "numCustomPurposes", "publisherCustomConsents", "publisherCustomLegitimateInterests"}), new i("vendorsAllowed", new String[]{"vendorsAllowed"}), new i("vendorsDisclosed", new String[]{"vendorsDisclosed"}));
    }
}
