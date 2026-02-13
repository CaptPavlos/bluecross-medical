package r3;

import java.util.Arrays;
import java.util.List;
import p3.t;
import p3.v;
import p8.u;
import r1.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f extends a {
    public final /* synthetic */ int e;
    public k3.c f;
    public l3.a g;

    public /* synthetic */ f(int i10) {
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
                    List list = t.f11914b;
                    aVar2.getClass();
                    l3.a.a(strA, list, aVar);
                    break;
                } catch (Exception e) {
                    u.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode UsTxGpcSegment '", str, "'"), e);
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
                    List list2 = p3.u.f11915a;
                    aVar4.getClass();
                    l3.a.a(strA2, list2, aVar3);
                    break;
                } catch (Exception e3) {
                    u.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode UsUtCoreSegment '", str, "'"), e3);
                    return;
                }
            default:
                p3.a aVar5 = (p3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((p3.a) this.f12365a).c(aVar5);
                }
                try {
                    this.f.getClass();
                    String strA3 = k3.b.a(str);
                    l3.a aVar6 = this.g;
                    List list3 = v.f11916a;
                    aVar6.getClass();
                    l3.a.a(strA3, list3, aVar5);
                    break;
                } catch (Exception e7) {
                    u.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode UsVaCoreSegment '", str, "'"), e7);
                }
                break;
        }
    }

    @Override // r3.a
    public final String d(p3.b bVar) {
        switch (this.e) {
            case 0:
                l3.a aVar = this.g;
                List list = t.f11914b;
                aVar.getClass();
                return this.f.b(l3.a.b((p3.a) bVar, list));
            case 1:
                l3.a aVar2 = this.g;
                List list2 = p3.u.f11915a;
                aVar2.getClass();
                return this.f.b(l3.a.b((p3.a) bVar, list2));
            default:
                l3.a aVar3 = this.g;
                List list3 = v.f11916a;
                aVar3.getClass();
                return this.f.b(l3.a.b((p3.a) bVar, list3));
        }
    }

    @Override // r3.a
    public final p3.b f() {
        switch (this.e) {
            case 0:
                p3.a aVar = new p3.a();
                List list = t.f11913a;
                aVar.b("GpcSegmentType", new m3.d(2, (Integer) 1));
                aVar.b("GpcSegmentIncluded", new m3.c(Boolean.TRUE));
                aVar.b("Gpc", new m3.c(Boolean.FALSE));
                return aVar;
            case 1:
                e eVar = new e(13);
                e eVar2 = new e(14);
                e eVar3 = new e(15);
                p3.a aVar2 = new p3.a();
                List list2 = p3.u.f11915a;
                aVar2.b("Version", new m3.d(6, (Integer) 1));
                m3.d dVar = new m3.d(2, (Integer) 0);
                dVar.f11177b = eVar;
                m3.d dVarF = i.f(aVar2, "SharingNotice", dVar, 2, 0);
                dVarF.f11177b = eVar;
                m3.d dVarF2 = i.f(aVar2, "SaleOptOutNotice", dVarF, 2, 0);
                dVarF2.f11177b = eVar;
                m3.d dVarF3 = i.f(aVar2, "TargetedAdvertisingOptOutNotice", dVarF2, 2, 0);
                dVarF3.f11177b = eVar;
                m3.d dVarF4 = i.f(aVar2, "SensitiveDataProcessingOptOutNotice", dVarF3, 2, 0);
                dVarF4.f11177b = eVar;
                m3.d dVarF5 = i.f(aVar2, "SaleOptOut", dVarF4, 2, 0);
                dVarF5.f11177b = eVar;
                aVar2.b("TargetedAdvertisingOptOut", dVarF5);
                m3.d dVar2 = new m3.d(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0), 2);
                dVar2.f11177b = eVar3;
                aVar2.b("SensitiveDataProcessing", dVar2);
                m3.d dVar3 = new m3.d(2, (Integer) 0);
                dVar3.f11177b = eVar;
                m3.d dVarF6 = i.f(aVar2, "KnownChildSensitiveDataConsents", dVar3, 2, 1);
                dVarF6.f11177b = eVar2;
                m3.d dVarF7 = i.f(aVar2, "MspaCoveredTransaction", dVarF6, 2, 0);
                dVarF7.f11177b = eVar;
                m3.d dVarF8 = i.f(aVar2, "MspaOptOutOptionMode", dVarF7, 2, 0);
                dVarF8.f11177b = eVar;
                aVar2.b("MspaServiceProviderMode", dVarF8);
                return aVar2;
            default:
                e eVar4 = new e(16);
                e eVar5 = new e(17);
                e eVar6 = new e(18);
                p3.a aVar3 = new p3.a();
                List list3 = v.f11916a;
                aVar3.b("Version", new m3.d(6, (Integer) 1));
                m3.d dVar4 = new m3.d(2, (Integer) 0);
                dVar4.f11177b = eVar4;
                m3.d dVarF9 = i.f(aVar3, "SharingNotice", dVar4, 2, 0);
                dVarF9.f11177b = eVar4;
                m3.d dVarF10 = i.f(aVar3, "SaleOptOutNotice", dVarF9, 2, 0);
                dVarF10.f11177b = eVar4;
                m3.d dVarF11 = i.f(aVar3, "TargetedAdvertisingOptOutNotice", dVarF10, 2, 0);
                dVarF11.f11177b = eVar4;
                m3.d dVarF12 = i.f(aVar3, "SaleOptOut", dVarF11, 2, 0);
                dVarF12.f11177b = eVar4;
                aVar3.b("TargetedAdvertisingOptOut", dVarF12);
                m3.d dVar5 = new m3.d(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0), 2);
                dVar5.f11177b = eVar6;
                aVar3.b("SensitiveDataProcessing", dVar5);
                m3.d dVar6 = new m3.d(2, (Integer) 0);
                dVar6.f11177b = eVar4;
                m3.d dVarF13 = i.f(aVar3, "KnownChildSensitiveDataConsents", dVar6, 2, 1);
                dVarF13.f11177b = eVar5;
                m3.d dVarF14 = i.f(aVar3, "MspaCoveredTransaction", dVarF13, 2, 0);
                dVarF14.f11177b = eVar4;
                m3.d dVarF15 = i.f(aVar3, "MspaOptOutOptionMode", dVarF14, 2, 0);
                dVarF15.f11177b = eVar4;
                aVar3.b("MspaServiceProviderMode", dVarF15);
                return aVar3;
        }
    }
}
