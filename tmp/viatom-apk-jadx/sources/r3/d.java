package r3;

import j$.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p8.u;
import r1.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends a {
    public final /* synthetic */ int e;
    public k3.d f;
    public l3.a g;

    public /* synthetic */ d(int i10) {
        this.e = i10;
    }

    @Override // r3.a
    public final void b(String str, p3.b bVar) {
        switch (this.e) {
            case 0:
                p3.a aVar = (p3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((p3.a) this.f12365a).c(aVar);
                }
                try {
                    this.f.getClass();
                    String strA = k3.b.a(str);
                    l3.a aVar2 = this.g;
                    List list = p3.f.f11884a;
                    aVar2.getClass();
                    l3.a.a(strA, list, aVar);
                    break;
                } catch (Exception e) {
                    u.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode TcfEuV2CoreSegment '", str, "'"), e);
                    return;
                }
                break;
            case 1:
                p3.a aVar3 = (p3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((p3.a) this.f12365a).c(aVar3);
                }
                try {
                    this.f.getClass();
                    String strA2 = k3.b.a(str);
                    l3.a aVar4 = this.g;
                    List list2 = p3.f.f11885b;
                    aVar4.getClass();
                    l3.a.a(strA2, list2, aVar3);
                    break;
                } catch (Exception e3) {
                    u.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode TcfEuV2PublisherPurposesSegment '", str, "'"), e3);
                    return;
                }
                break;
            case 2:
                p3.a aVar5 = (p3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((p3.a) this.f12365a).c(aVar5);
                }
                try {
                    this.f.getClass();
                    String strA3 = k3.b.a(str);
                    l3.a aVar6 = this.g;
                    List list3 = p3.f.f11886c;
                    aVar6.getClass();
                    l3.a.a(strA3, list3, aVar5);
                    break;
                } catch (Exception e7) {
                    u.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode TcfEuV2VendorsAllowedSegment '", str, "'"), e7);
                    return;
                }
            default:
                p3.a aVar7 = (p3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((p3.a) this.f12365a).c(aVar7);
                }
                try {
                    this.f.getClass();
                    String strA4 = k3.b.a(str);
                    l3.a aVar8 = this.g;
                    List list4 = p3.f.f11887d;
                    aVar8.getClass();
                    l3.a.a(strA4, list4, aVar7);
                    break;
                } catch (Exception e10) {
                    u.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode TcfEuV2VendorsDisclosedSegment '", str, "'"), e10);
                }
                break;
        }
    }

    @Override // r3.a
    public final String d(p3.b bVar) {
        switch (this.e) {
            case 0:
                l3.a aVar = this.g;
                List list = p3.f.f11884a;
                aVar.getClass();
                return this.f.b(l3.a.b((p3.a) bVar, list));
            case 1:
                l3.a aVar2 = this.g;
                List list2 = p3.f.f11885b;
                aVar2.getClass();
                return this.f.b(l3.a.b((p3.a) bVar, list2));
            case 2:
                l3.a aVar3 = this.g;
                List list3 = p3.f.f11886c;
                aVar3.getClass();
                return this.f.b(l3.a.b((p3.a) bVar, list3));
            default:
                l3.a aVar4 = this.g;
                List list4 = p3.f.f11887d;
                aVar4.getClass();
                return this.f.b(l3.a.b((p3.a) bVar, list4));
        }
    }

    @Override // r3.a
    public final p3.b f() {
        switch (this.e) {
            case 0:
                ZonedDateTime zonedDateTimeNow = ZonedDateTime.now();
                p3.a aVar = new p3.a();
                List list = p3.f.f11884a;
                aVar.b("Version", new m3.d(6, (Integer) 2));
                aVar.b("Created", new m3.c(zonedDateTimeNow));
                aVar.b("LastUpdated", new m3.c(zonedDateTimeNow));
                aVar.b("ConsentScreen", i.f(aVar, "CmpVersion", i.f(aVar, "CmpId", new m3.d(12, (Integer) 0), 12, 0), 6, 0));
                aVar.b("ConsentLanguage", new m3.c("EN"));
                aVar.b("VendorListVersion", new m3.d(12, (Integer) 0));
                aVar.b("PolicyVersion", new m3.d(6, (Integer) 2));
                Boolean bool = Boolean.FALSE;
                aVar.b("IsServiceSpecific", new m3.c(bool));
                aVar.b("UseNonStandardStacks", new m3.c(bool));
                aVar.b("SpecialFeatureOptins", new m3.d(Arrays.asList(bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool), 0));
                aVar.b("PurposeConsents", new m3.d(Arrays.asList(bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool), 0));
                aVar.b("PurposeLegitimateInterests", new m3.d(Arrays.asList(bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool), 0));
                aVar.b("PurposeOneTreatment", new m3.c(bool));
                aVar.b("PublisherCountryCode", new m3.c("AA"));
                aVar.b("VendorConsents", new m3.c(new ArrayList(), 5));
                aVar.b("VendorLegitimateInterests", new m3.c(new ArrayList(), 5));
                aVar.b("PublisherRestrictions", new m3.c(new ArrayList(), 0));
                return aVar;
            case 1:
                p3.a aVar2 = new p3.a();
                List list2 = p3.f.f11884a;
                aVar2.b("PublisherPurposesSegmentType", new m3.d(3, (Integer) 3));
                Boolean bool2 = Boolean.FALSE;
                aVar2.b("PublisherConsents", new m3.d(Arrays.asList(bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2), 0));
                aVar2.b("PublisherLegitimateInterests", new m3.d(Arrays.asList(bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2), 0));
                m3.d dVar = new m3.d(6, (Integer) 0);
                aVar2.b("NumCustomPurposes", dVar);
                c cVar = new c(dVar, 1);
                aVar2.b("PublisherCustomConsents", new m3.e(cVar, new ArrayList()));
                aVar2.b("PublisherCustomLegitimateInterests", new m3.e(cVar, new ArrayList()));
                return aVar2;
            case 2:
                p3.a aVar3 = new p3.a();
                List list3 = p3.f.f11884a;
                aVar3.b("VendorsAllowedSegmentType", new m3.d(3, (Integer) 2));
                aVar3.b("VendorsAllowed", new m3.c(new ArrayList(), 5));
                return aVar3;
            default:
                p3.a aVar4 = new p3.a();
                List list4 = p3.f.f11884a;
                aVar4.b("VendorsDisclosedSegmentType", new m3.d(3, (Integer) 1));
                aVar4.b("VendorsDisclosed", new m3.c(new ArrayList(), 5));
                return aVar4;
        }
    }
}
