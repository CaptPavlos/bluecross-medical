package r3;

import j$.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p3.h;
import p3.i;
import p3.j;
import p3.k;
import p3.l;
import p3.m;
import p3.n;
import p3.o;
import p3.p;
import p3.q;
import p3.r;
import p3.s;
import p3.t;
import p3.v;
import p8.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends a {
    public final /* synthetic */ int e;
    public k3.c f;
    public l3.a g;

    public /* synthetic */ b(int i10) {
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
                    List list = p3.d.f11880a;
                    aVar2.getClass();
                    l3.a.a(strA, list, aVar);
                    break;
                } catch (Exception e) {
                    u.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode HeaderV1CoreSegment '", str, "'"), e);
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
                    List list2 = p3.e.f11881a;
                    aVar4.getClass();
                    l3.a.a(strA2, list2, aVar3);
                    break;
                } catch (Exception e3) {
                    u.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode TcfCaV1CoreSegment '", str, "'"), e3);
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
                    List list3 = p3.e.f11883c;
                    aVar6.getClass();
                    l3.a.a(strA3, list3, aVar5);
                    break;
                } catch (Exception e7) {
                    u.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode TcfCaV1DisclosedVendorsSegment '", str, "'"), e7);
                    return;
                }
                break;
            case 3:
                p3.a aVar7 = (p3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((p3.a) this.f12365a).c(aVar7);
                }
                try {
                    this.f.getClass();
                    String strA4 = k3.b.a(str);
                    l3.a aVar8 = this.g;
                    List list4 = p3.e.f11882b;
                    aVar8.getClass();
                    l3.a.a(strA4, list4, aVar7);
                    break;
                } catch (Exception e10) {
                    u.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode TcfCaV1PublisherPurposesSegment '", str, "'"), e10);
                    return;
                }
            case 4:
                p3.a aVar9 = (p3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((p3.a) this.f12365a).c(aVar9);
                }
                try {
                    this.f.getClass();
                    String strA5 = k3.b.a(str);
                    l3.a aVar10 = this.g;
                    List list5 = p3.g.f11888a;
                    aVar10.getClass();
                    l3.a.a(strA5, list5, aVar9);
                    break;
                } catch (Exception e11) {
                    u.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode UsCaCoreSegment '", str, "'"), e11);
                    return;
                }
                break;
            case 5:
                p3.a aVar11 = (p3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((p3.a) this.f12365a).c(aVar11);
                }
                try {
                    this.f.getClass();
                    String strA6 = k3.b.a(str);
                    l3.a aVar12 = this.g;
                    List list6 = p3.g.f11889b;
                    aVar12.getClass();
                    l3.a.a(strA6, list6, aVar11);
                    break;
                } catch (Exception e12) {
                    u.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode UsCaGpcSegment '", str, "'"), e12);
                    return;
                }
                break;
            case 6:
                p3.a aVar13 = (p3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((p3.a) this.f12365a).c(aVar13);
                }
                try {
                    this.f.getClass();
                    String strA7 = k3.b.a(str);
                    l3.a aVar14 = this.g;
                    List list7 = h.f11890a;
                    aVar14.getClass();
                    l3.a.a(strA7, list7, aVar13);
                    break;
                } catch (Exception e13) {
                    u.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode UsCoCoreSegment '", str, "'"), e13);
                    return;
                }
            case 7:
                p3.a aVar15 = (p3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((p3.a) this.f12365a).c(aVar15);
                }
                try {
                    this.f.getClass();
                    String strA8 = k3.b.a(str);
                    l3.a aVar16 = this.g;
                    List list8 = h.f11891b;
                    aVar16.getClass();
                    l3.a.a(strA8, list8, aVar15);
                    break;
                } catch (Exception e14) {
                    u.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode UsCoGpcSegment '", str, "'"), e14);
                    return;
                }
                break;
            case 8:
                p3.a aVar17 = (p3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((p3.a) this.f12365a).c(aVar17);
                }
                try {
                    this.f.getClass();
                    String strA9 = k3.b.a(str);
                    l3.a aVar18 = this.g;
                    List list9 = i.f11892a;
                    aVar18.getClass();
                    l3.a.a(strA9, list9, aVar17);
                    break;
                } catch (Exception e15) {
                    u.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode UsCtCoreSegment '", str, "'"), e15);
                    return;
                }
                break;
            case 9:
                p3.a aVar19 = (p3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((p3.a) this.f12365a).c(aVar19);
                }
                try {
                    this.f.getClass();
                    String strA10 = k3.b.a(str);
                    l3.a aVar20 = this.g;
                    List list10 = i.f11893b;
                    aVar20.getClass();
                    l3.a.a(strA10, list10, aVar19);
                    break;
                } catch (Exception e16) {
                    u.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode UsCtGpcSegment '", str, "'"), e16);
                    return;
                }
                break;
            case 10:
                p3.a aVar21 = (p3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((p3.a) this.f12365a).c(aVar21);
                }
                try {
                    this.f.getClass();
                    String strA11 = k3.b.a(str);
                    l3.a aVar22 = this.g;
                    List list11 = j.f11894a;
                    aVar22.getClass();
                    l3.a.a(strA11, list11, aVar21);
                    break;
                } catch (Exception e17) {
                    u.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode UsDeCoreSegment '", str, "'"), e17);
                    return;
                }
                break;
            case 11:
                p3.a aVar23 = (p3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((p3.a) this.f12365a).c(aVar23);
                }
                try {
                    this.f.getClass();
                    String strA12 = k3.b.a(str);
                    l3.a aVar24 = this.g;
                    List list12 = j.f11895b;
                    aVar24.getClass();
                    l3.a.a(strA12, list12, aVar23);
                    break;
                } catch (Exception e18) {
                    u.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode UsDeGpcSegment '", str, "'"), e18);
                    return;
                }
            case 12:
                p3.a aVar25 = (p3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((p3.a) this.f12365a).c(aVar25);
                }
                try {
                    this.f.getClass();
                    String strA13 = k3.b.a(str);
                    l3.a aVar26 = this.g;
                    List list13 = k.f11896a;
                    aVar26.getClass();
                    l3.a.a(strA13, list13, aVar25);
                    break;
                } catch (Exception e19) {
                    u.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode UsFlCoreSegment '", str, "'"), e19);
                    return;
                }
                break;
            case 13:
                p3.a aVar27 = (p3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((p3.a) this.f12365a).c(aVar27);
                }
                try {
                    this.f.getClass();
                    String strA14 = k3.b.a(str);
                    l3.a aVar28 = this.g;
                    List list14 = l.f11897a;
                    aVar28.getClass();
                    l3.a.a(strA14, list14, aVar27);
                    break;
                } catch (Exception e20) {
                    u.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode UsIaCoreSegment '", str, "'"), e20);
                    return;
                }
                break;
            case 14:
                p3.a aVar29 = (p3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((p3.a) this.f12365a).c(aVar29);
                }
                try {
                    this.f.getClass();
                    String strA15 = k3.b.a(str);
                    l3.a aVar30 = this.g;
                    List list15 = l.f11898b;
                    aVar30.getClass();
                    l3.a.a(strA15, list15, aVar29);
                    break;
                } catch (Exception e21) {
                    u.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode UsIaGpcSegment '", str, "'"), e21);
                    return;
                }
            case 15:
                p3.a aVar31 = (p3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((p3.a) this.f12365a).c(aVar31);
                }
                try {
                    this.f.getClass();
                    String strA16 = k3.b.a(str);
                    l3.a aVar32 = this.g;
                    List list16 = m.f11899a;
                    aVar32.getClass();
                    l3.a.a(strA16, list16, aVar31);
                    break;
                } catch (Exception e22) {
                    u.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode UsMtCoreSegment '", str, "'"), e22);
                    return;
                }
                break;
            case 16:
                p3.a aVar33 = (p3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((p3.a) this.f12365a).c(aVar33);
                }
                try {
                    this.f.getClass();
                    String strA17 = k3.b.a(str);
                    l3.a aVar34 = this.g;
                    List list17 = m.f11900b;
                    aVar34.getClass();
                    l3.a.a(strA17, list17, aVar33);
                    break;
                } catch (Exception e23) {
                    u.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode UsMtGpcSegment '", str, "'"), e23);
                    return;
                }
                break;
            case 17:
                p3.a aVar35 = (p3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((p3.a) this.f12365a).c(aVar35);
                }
                try {
                    this.f.getClass();
                    String strA18 = k3.b.a(str);
                    if (strA18.length() == 66) {
                        strA18 = strA18.substring(0, 48) + "00000000" + strA18.substring(48, 52) + "00" + strA18.substring(52, 62);
                    }
                    l3.a aVar36 = this.g;
                    List list18 = n.f11901a;
                    aVar36.getClass();
                    l3.a.a(strA18, list18, aVar35);
                    break;
                } catch (Exception e24) {
                    u.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode UsNatCoreSegment '", str, "'"), e24);
                    return;
                }
            case 18:
                p3.a aVar37 = (p3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((p3.a) this.f12365a).c(aVar37);
                }
                try {
                    this.f.getClass();
                    String strA19 = k3.b.a(str);
                    l3.a aVar38 = this.g;
                    List list19 = n.f11902b;
                    aVar38.getClass();
                    l3.a.a(strA19, list19, aVar37);
                    break;
                } catch (Exception e25) {
                    u.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode UsNatGpcSegment '", str, "'"), e25);
                    return;
                }
                break;
            case 19:
                p3.a aVar39 = (p3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((p3.a) this.f12365a).c(aVar39);
                }
                try {
                    this.f.getClass();
                    String strA20 = k3.b.a(str);
                    l3.a aVar40 = this.g;
                    List list20 = o.f11903a;
                    aVar40.getClass();
                    l3.a.a(strA20, list20, aVar39);
                    break;
                } catch (Exception e26) {
                    u.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode UsNeCoreSegment '", str, "'"), e26);
                    return;
                }
                break;
            case 20:
                p3.a aVar41 = (p3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((p3.a) this.f12365a).c(aVar41);
                }
                try {
                    this.f.getClass();
                    String strA21 = k3.b.a(str);
                    l3.a aVar42 = this.g;
                    List list21 = o.f11904b;
                    aVar42.getClass();
                    l3.a.a(strA21, list21, aVar41);
                    break;
                } catch (Exception e27) {
                    u.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode UsNeGpcSegment '", str, "'"), e27);
                    return;
                }
            case 21:
                p3.a aVar43 = (p3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((p3.a) this.f12365a).c(aVar43);
                }
                try {
                    this.f.getClass();
                    String strA22 = k3.b.a(str);
                    l3.a aVar44 = this.g;
                    List list22 = p.f11905a;
                    aVar44.getClass();
                    l3.a.a(strA22, list22, aVar43);
                    break;
                } catch (Exception e28) {
                    u.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode UsNhCoreSegment '", str, "'"), e28);
                    return;
                }
                break;
            case 22:
                p3.a aVar45 = (p3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((p3.a) this.f12365a).c(aVar45);
                }
                try {
                    this.f.getClass();
                    String strA23 = k3.b.a(str);
                    l3.a aVar46 = this.g;
                    List list23 = p.f11906b;
                    aVar46.getClass();
                    l3.a.a(strA23, list23, aVar45);
                    break;
                } catch (Exception e29) {
                    u.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode UsNhGpcSegment '", str, "'"), e29);
                    return;
                }
                break;
            case 23:
                p3.a aVar47 = (p3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((p3.a) this.f12365a).c(aVar47);
                }
                try {
                    this.f.getClass();
                    String strA24 = k3.b.a(str);
                    l3.a aVar48 = this.g;
                    List list24 = q.f11907a;
                    aVar48.getClass();
                    l3.a.a(strA24, list24, aVar47);
                    break;
                } catch (Exception e30) {
                    u.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode UsNjCoreSegment '", str, "'"), e30);
                    return;
                }
                break;
            case 24:
                p3.a aVar49 = (p3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((p3.a) this.f12365a).c(aVar49);
                }
                try {
                    this.f.getClass();
                    String strA25 = k3.b.a(str);
                    l3.a aVar50 = this.g;
                    List list25 = q.f11908b;
                    aVar50.getClass();
                    l3.a.a(strA25, list25, aVar49);
                    break;
                } catch (Exception e31) {
                    u.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode UsNjGpcSegment '", str, "'"), e31);
                    return;
                }
                break;
            case 25:
                p3.a aVar51 = (p3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((p3.a) this.f12365a).c(aVar51);
                }
                try {
                    this.f.getClass();
                    String strA26 = k3.b.a(str);
                    l3.a aVar52 = this.g;
                    List list26 = r.f11909a;
                    aVar52.getClass();
                    l3.a.a(strA26, list26, aVar51);
                    break;
                } catch (Exception e32) {
                    u.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode UsOrCoreSegment '", str, "'"), e32);
                    return;
                }
            case 26:
                p3.a aVar53 = (p3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((p3.a) this.f12365a).c(aVar53);
                }
                try {
                    this.f.getClass();
                    String strA27 = k3.b.a(str);
                    l3.a aVar54 = this.g;
                    List list27 = r.f11910b;
                    aVar54.getClass();
                    l3.a.a(strA27, list27, aVar53);
                    break;
                } catch (Exception e33) {
                    u.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode UsOrGpcSegment '", str, "'"), e33);
                    return;
                }
                break;
            case 27:
                p3.a aVar55 = (p3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((p3.a) this.f12365a).c(aVar55);
                }
                try {
                    this.f.getClass();
                    String strA28 = k3.b.a(str);
                    l3.a aVar56 = this.g;
                    List list28 = s.f11911a;
                    aVar56.getClass();
                    l3.a.a(strA28, list28, aVar55);
                    break;
                } catch (Exception e34) {
                    u.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode UsTnCoreSegment '", str, "'"), e34);
                    return;
                }
                break;
            case 28:
                p3.a aVar57 = (p3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((p3.a) this.f12365a).c(aVar57);
                }
                try {
                    this.f.getClass();
                    String strA29 = k3.b.a(str);
                    l3.a aVar58 = this.g;
                    List list29 = s.f11912b;
                    aVar58.getClass();
                    l3.a.a(strA29, list29, aVar57);
                    break;
                } catch (Exception e35) {
                    u.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode UsTnGpcSegment '", str, "'"), e35);
                    return;
                }
            default:
                p3.a aVar59 = (p3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((p3.a) this.f12365a).c(aVar59);
                }
                try {
                    this.f.getClass();
                    String strA30 = k3.b.a(str);
                    l3.a aVar60 = this.g;
                    List list30 = t.f11913a;
                    aVar60.getClass();
                    l3.a.a(strA30, list30, aVar59);
                    break;
                } catch (Exception e36) {
                    u.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Unable to decode UsTxCoreSegment '", str, "'"), e36);
                }
                break;
        }
    }

    @Override // r3.a
    public final String d(p3.b bVar) {
        switch (this.e) {
            case 0:
                l3.a aVar = this.g;
                List list = p3.d.f11880a;
                aVar.getClass();
                return this.f.b(l3.a.b((p3.a) bVar, list));
            case 1:
                l3.a aVar2 = this.g;
                List list2 = p3.e.f11881a;
                aVar2.getClass();
                return this.f.b(l3.a.b((p3.a) bVar, list2));
            case 2:
                l3.a aVar3 = this.g;
                List list3 = p3.e.f11883c;
                aVar3.getClass();
                return this.f.b(l3.a.b((p3.a) bVar, list3));
            case 3:
                l3.a aVar4 = this.g;
                List list4 = p3.e.f11882b;
                aVar4.getClass();
                return this.f.b(l3.a.b((p3.a) bVar, list4));
            case 4:
                l3.a aVar5 = this.g;
                List list5 = p3.g.f11888a;
                aVar5.getClass();
                return this.f.b(l3.a.b((p3.a) bVar, list5));
            case 5:
                l3.a aVar6 = this.g;
                List list6 = p3.g.f11889b;
                aVar6.getClass();
                return this.f.b(l3.a.b((p3.a) bVar, list6));
            case 6:
                l3.a aVar7 = this.g;
                List list7 = h.f11890a;
                aVar7.getClass();
                return this.f.b(l3.a.b((p3.a) bVar, list7));
            case 7:
                l3.a aVar8 = this.g;
                List list8 = h.f11891b;
                aVar8.getClass();
                return this.f.b(l3.a.b((p3.a) bVar, list8));
            case 8:
                l3.a aVar9 = this.g;
                List list9 = i.f11892a;
                aVar9.getClass();
                return this.f.b(l3.a.b((p3.a) bVar, list9));
            case 9:
                l3.a aVar10 = this.g;
                List list10 = i.f11893b;
                aVar10.getClass();
                return this.f.b(l3.a.b((p3.a) bVar, list10));
            case 10:
                l3.a aVar11 = this.g;
                List list11 = j.f11894a;
                aVar11.getClass();
                return this.f.b(l3.a.b((p3.a) bVar, list11));
            case 11:
                l3.a aVar12 = this.g;
                List list12 = j.f11895b;
                aVar12.getClass();
                return this.f.b(l3.a.b((p3.a) bVar, list12));
            case 12:
                l3.a aVar13 = this.g;
                List list13 = k.f11896a;
                aVar13.getClass();
                return this.f.b(l3.a.b((p3.a) bVar, list13));
            case 13:
                l3.a aVar14 = this.g;
                List list14 = l.f11897a;
                aVar14.getClass();
                return this.f.b(l3.a.b((p3.a) bVar, list14));
            case 14:
                l3.a aVar15 = this.g;
                List list15 = l.f11898b;
                aVar15.getClass();
                return this.f.b(l3.a.b((p3.a) bVar, list15));
            case 15:
                l3.a aVar16 = this.g;
                List list16 = m.f11899a;
                aVar16.getClass();
                return this.f.b(l3.a.b((p3.a) bVar, list16));
            case 16:
                l3.a aVar17 = this.g;
                List list17 = m.f11900b;
                aVar17.getClass();
                return this.f.b(l3.a.b((p3.a) bVar, list17));
            case 17:
                l3.a aVar18 = this.g;
                List list18 = n.f11901a;
                aVar18.getClass();
                return this.f.b(l3.a.b((p3.a) bVar, list18));
            case 18:
                l3.a aVar19 = this.g;
                List list19 = n.f11902b;
                aVar19.getClass();
                return this.f.b(l3.a.b((p3.a) bVar, list19));
            case 19:
                l3.a aVar20 = this.g;
                List list20 = o.f11903a;
                aVar20.getClass();
                return this.f.b(l3.a.b((p3.a) bVar, list20));
            case 20:
                l3.a aVar21 = this.g;
                List list21 = o.f11904b;
                aVar21.getClass();
                return this.f.b(l3.a.b((p3.a) bVar, list21));
            case 21:
                l3.a aVar22 = this.g;
                List list22 = p.f11905a;
                aVar22.getClass();
                return this.f.b(l3.a.b((p3.a) bVar, list22));
            case 22:
                l3.a aVar23 = this.g;
                List list23 = p.f11906b;
                aVar23.getClass();
                return this.f.b(l3.a.b((p3.a) bVar, list23));
            case 23:
                l3.a aVar24 = this.g;
                List list24 = q.f11907a;
                aVar24.getClass();
                return this.f.b(l3.a.b((p3.a) bVar, list24));
            case 24:
                l3.a aVar25 = this.g;
                List list25 = q.f11908b;
                aVar25.getClass();
                return this.f.b(l3.a.b((p3.a) bVar, list25));
            case 25:
                l3.a aVar26 = this.g;
                List list26 = r.f11909a;
                aVar26.getClass();
                return this.f.b(l3.a.b((p3.a) bVar, list26));
            case 26:
                l3.a aVar27 = this.g;
                List list27 = r.f11910b;
                aVar27.getClass();
                return this.f.b(l3.a.b((p3.a) bVar, list27));
            case 27:
                l3.a aVar28 = this.g;
                List list28 = s.f11911a;
                aVar28.getClass();
                return this.f.b(l3.a.b((p3.a) bVar, list28));
            case 28:
                l3.a aVar29 = this.g;
                List list29 = s.f11912b;
                aVar29.getClass();
                return this.f.b(l3.a.b((p3.a) bVar, list29));
            default:
                l3.a aVar30 = this.g;
                List list30 = t.f11913a;
                aVar30.getClass();
                return this.f.b(l3.a.b((p3.a) bVar, list30));
        }
    }

    @Override // r3.a
    public final p3.b f() {
        switch (this.e) {
            case 0:
                p3.a aVar = new p3.a();
                List list = p3.d.f11880a;
                aVar.b("Id", new m3.d(6, (Integer) 3));
                aVar.b("Version", new m3.d(6, (Integer) 1));
                ArrayList arrayList = new ArrayList();
                m3.c cVar = new m3.c(true);
                cVar.setValue(arrayList);
                aVar.b("SectionIds", cVar);
                return aVar;
            case 1:
                ZonedDateTime zonedDateTimeNow = ZonedDateTime.now();
                p3.a aVar2 = new p3.a();
                List list2 = p3.e.f11881a;
                aVar2.b("Version", new m3.d(6, (Integer) 1));
                aVar2.b("Created", new m3.c(zonedDateTimeNow));
                aVar2.b("LastUpdated", new m3.c(zonedDateTimeNow));
                aVar2.b("ConsentScreen", r1.i.f(aVar2, "CmpVersion", r1.i.f(aVar2, "CmpId", new m3.d(12, (Integer) 0), 12, 0), 6, 0));
                aVar2.b("ConsentLanguage", new m3.c("EN"));
                aVar2.b("VendorListVersion", new m3.d(12, (Integer) 0));
                aVar2.b("TcfPolicyVersion", new m3.d(6, (Integer) 2));
                Boolean bool = Boolean.FALSE;
                aVar2.b("UseNonStandardStacks", new m3.c(bool));
                aVar2.b("SpecialFeatureExpressConsent", new m3.d(Arrays.asList(bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool), 0));
                aVar2.b("PurposesExpressConsent", new m3.d(Arrays.asList(bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool), 0));
                aVar2.b("PurposesImpliedConsent", new m3.d(Arrays.asList(bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool), 0));
                aVar2.b("VendorExpressConsent", new m3.c(new ArrayList(), 5));
                aVar2.b("VendorImpliedConsent", new m3.c(new ArrayList(), 5));
                aVar2.b("PubRestrictions", new m3.c(new ArrayList(), 0));
                return aVar2;
            case 2:
                p3.a aVar3 = new p3.a();
                List list3 = p3.e.f11881a;
                aVar3.b("DisclosedVendorsSegmentType", new m3.d(3, (Integer) 1));
                aVar3.b("DisclosedVendors", new m3.c(new ArrayList(), 5));
                return aVar3;
            case 3:
                p3.a aVar4 = new p3.a();
                List list4 = p3.e.f11881a;
                aVar4.b("PubPurposesSegmentType", new m3.d(3, (Integer) 3));
                Boolean bool2 = Boolean.FALSE;
                aVar4.b("PubPurposesExpressConsent", new m3.d(Arrays.asList(bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2), 0));
                aVar4.b("PubPurposesImpliedConsent", new m3.d(Arrays.asList(bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2), 0));
                m3.d dVar = new m3.d(6, (Integer) 0);
                aVar4.b("NumCustomPurposes", dVar);
                c cVar2 = new c(dVar, 0);
                aVar4.b("CustomPurposesExpressConsent", new m3.e(cVar2, new ArrayList()));
                aVar4.b("CustomPurposesImpliedConsent", new m3.e(cVar2, new ArrayList()));
                return aVar4;
            case 4:
                m3.i iVar = new m3.i(1);
                m3.i iVar2 = new m3.i(2);
                m3.i iVar3 = new m3.i(3);
                p3.a aVar5 = new p3.a();
                List list5 = p3.g.f11888a;
                aVar5.b("Version", new m3.d(6, (Integer) 1));
                m3.d dVar2 = new m3.d(2, (Integer) 0);
                dVar2.f11177b = iVar;
                m3.d dVarF = r1.i.f(aVar5, "SaleOptOutNotice", dVar2, 2, 0);
                dVarF.f11177b = iVar;
                m3.d dVarF2 = r1.i.f(aVar5, "SharingOptOutNotice", dVarF, 2, 0);
                dVarF2.f11177b = iVar;
                m3.d dVarF3 = r1.i.f(aVar5, "SensitiveDataLimitUseNotice", dVarF2, 2, 0);
                dVarF3.f11177b = iVar;
                m3.d dVarF4 = r1.i.f(aVar5, "SaleOptOut", dVarF3, 2, 0);
                dVarF4.f11177b = iVar;
                aVar5.b("SharingOptOut", dVarF4);
                m3.d dVar3 = new m3.d(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0), 2);
                dVar3.f11177b = iVar3;
                aVar5.b("SensitiveDataProcessing", dVar3);
                m3.d dVar4 = new m3.d(Arrays.asList(0, 0), 2);
                dVar4.f11177b = iVar3;
                aVar5.b("KnownChildSensitiveDataConsents", dVar4);
                m3.d dVar5 = new m3.d(2, (Integer) 0);
                dVar5.f11177b = iVar;
                m3.d dVarF5 = r1.i.f(aVar5, "PersonalDataConsents", dVar5, 2, 1);
                dVarF5.f11177b = iVar2;
                m3.d dVarF6 = r1.i.f(aVar5, "MspaCoveredTransaction", dVarF5, 2, 0);
                dVarF6.f11177b = iVar;
                m3.d dVarF7 = r1.i.f(aVar5, "MspaOptOutOptionMode", dVarF6, 2, 0);
                dVarF7.f11177b = iVar;
                aVar5.b("MspaServiceProviderMode", dVarF7);
                return aVar5;
            case 5:
                p3.a aVar6 = new p3.a();
                List list6 = p3.g.f11888a;
                aVar6.b("GpcSegmentType", new m3.d(2, (Integer) 1));
                aVar6.b("GpcSegmentIncluded", new m3.c(Boolean.TRUE));
                aVar6.b("Gpc", new m3.c(Boolean.FALSE));
                return aVar6;
            case 6:
                m3.i iVar4 = new m3.i(4);
                m3.i iVar5 = new m3.i(5);
                m3.i iVar6 = new m3.i(6);
                p3.a aVar7 = new p3.a();
                List list7 = h.f11890a;
                aVar7.b("Version", new m3.d(6, (Integer) 1));
                m3.d dVar6 = new m3.d(2, (Integer) 0);
                dVar6.f11177b = iVar4;
                m3.d dVarF8 = r1.i.f(aVar7, "SharingNotice", dVar6, 2, 0);
                dVarF8.f11177b = iVar4;
                m3.d dVarF9 = r1.i.f(aVar7, "SaleOptOutNotice", dVarF8, 2, 0);
                dVarF9.f11177b = iVar4;
                m3.d dVarF10 = r1.i.f(aVar7, "TargetedAdvertisingOptOutNotice", dVarF9, 2, 0);
                dVarF10.f11177b = iVar4;
                m3.d dVarF11 = r1.i.f(aVar7, "SaleOptOut", dVarF10, 2, 0);
                dVarF11.f11177b = iVar4;
                aVar7.b("TargetedAdvertisingOptOut", dVarF11);
                m3.d dVar7 = new m3.d(Arrays.asList(0, 0, 0, 0, 0, 0, 0), 2);
                dVar7.f11177b = iVar6;
                aVar7.b("SensitiveDataProcessing", dVar7);
                m3.d dVar8 = new m3.d(2, (Integer) 0);
                dVar8.f11177b = iVar4;
                m3.d dVarF12 = r1.i.f(aVar7, "KnownChildSensitiveDataConsents", dVar8, 2, 1);
                dVarF12.f11177b = iVar5;
                m3.d dVarF13 = r1.i.f(aVar7, "MspaCoveredTransaction", dVarF12, 2, 0);
                dVarF13.f11177b = iVar4;
                m3.d dVarF14 = r1.i.f(aVar7, "MspaOptOutOptionMode", dVarF13, 2, 0);
                dVarF14.f11177b = iVar4;
                aVar7.b("MspaServiceProviderMode", dVarF14);
                return aVar7;
            case 7:
                p3.a aVar8 = new p3.a();
                List list8 = h.f11890a;
                aVar8.b("GpcSegmentType", new m3.d(2, (Integer) 1));
                aVar8.b("GpcSegmentIncluded", new m3.c(Boolean.TRUE));
                aVar8.b("Gpc", new m3.c(Boolean.FALSE));
                return aVar8;
            case 8:
                m3.i iVar7 = new m3.i(7);
                m3.i iVar8 = new m3.i(8);
                m3.i iVar9 = new m3.i(9);
                p3.a aVar9 = new p3.a();
                List list9 = i.f11892a;
                aVar9.b("Version", new m3.d(6, (Integer) 1));
                m3.d dVar9 = new m3.d(2, (Integer) 0);
                dVar9.f11177b = iVar7;
                m3.d dVarF15 = r1.i.f(aVar9, "SharingNotice", dVar9, 2, 0);
                dVarF15.f11177b = iVar7;
                m3.d dVarF16 = r1.i.f(aVar9, "SaleOptOutNotice", dVarF15, 2, 0);
                dVarF16.f11177b = iVar7;
                m3.d dVarF17 = r1.i.f(aVar9, "TargetedAdvertisingOptOutNotice", dVarF16, 2, 0);
                dVarF17.f11177b = iVar7;
                m3.d dVarF18 = r1.i.f(aVar9, "SaleOptOut", dVarF17, 2, 0);
                dVarF18.f11177b = iVar7;
                aVar9.b("TargetedAdvertisingOptOut", dVarF18);
                m3.d dVar10 = new m3.d(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0), 2);
                dVar10.f11177b = iVar9;
                aVar9.b("SensitiveDataProcessing", dVar10);
                m3.d dVar11 = new m3.d(Arrays.asList(0, 0, 0), 2);
                dVar11.f11177b = iVar9;
                aVar9.b("KnownChildSensitiveDataConsents", dVar11);
                m3.d dVar12 = new m3.d(2, (Integer) 1);
                dVar12.f11177b = iVar8;
                m3.d dVarF19 = r1.i.f(aVar9, "MspaCoveredTransaction", dVar12, 2, 0);
                dVarF19.f11177b = iVar7;
                m3.d dVarF20 = r1.i.f(aVar9, "MspaOptOutOptionMode", dVarF19, 2, 0);
                dVarF20.f11177b = iVar7;
                aVar9.b("MspaServiceProviderMode", dVarF20);
                return aVar9;
            case 9:
                p3.a aVar10 = new p3.a();
                List list10 = i.f11892a;
                aVar10.b("GpcSegmentType", new m3.d(2, (Integer) 1));
                aVar10.b("GpcSegmentIncluded", new m3.c(Boolean.TRUE));
                aVar10.b("Gpc", new m3.c(Boolean.FALSE));
                return aVar10;
            case 10:
                m3.i iVar10 = new m3.i(10);
                m3.i iVar11 = new m3.i(11);
                m3.i iVar12 = new m3.i(12);
                p3.a aVar11 = new p3.a();
                List list11 = j.f11894a;
                aVar11.b("Version", new m3.d(6, (Integer) 1));
                m3.d dVar13 = new m3.d(2, (Integer) 0);
                dVar13.f11177b = iVar10;
                m3.d dVarF21 = r1.i.f(aVar11, "ProcessingNotice", dVar13, 2, 0);
                dVarF21.f11177b = iVar10;
                m3.d dVarF22 = r1.i.f(aVar11, "SaleOptOutNotice", dVarF21, 2, 0);
                dVarF22.f11177b = iVar10;
                m3.d dVarF23 = r1.i.f(aVar11, "TargetedAdvertisingOptOutNotice", dVarF22, 2, 0);
                dVarF23.f11177b = iVar10;
                m3.d dVarF24 = r1.i.f(aVar11, "SaleOptOut", dVarF23, 2, 0);
                dVarF24.f11177b = iVar10;
                aVar11.b("TargetedAdvertisingOptOut", dVarF24);
                m3.d dVar14 = new m3.d(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0), 2);
                dVar14.f11177b = iVar12;
                aVar11.b("SensitiveDataProcessing", dVar14);
                List list12 = v.f11916a;
                m3.d dVar15 = new m3.d(Arrays.asList(0, 0, 0, 0, 0), 2);
                dVar15.f11177b = iVar12;
                aVar11.b("KnownChildSensitiveDataConsents", dVar15);
                m3.d dVar16 = new m3.d(2, (Integer) 0);
                dVar16.f11177b = iVar10;
                m3.d dVarF25 = r1.i.f(aVar11, "AdditionalDataProcessingConsent", dVar16, 2, 1);
                dVarF25.f11177b = iVar11;
                m3.d dVarF26 = r1.i.f(aVar11, "MspaCoveredTransaction", dVarF25, 2, 0);
                dVarF26.f11177b = iVar10;
                m3.d dVarF27 = r1.i.f(aVar11, "MspaOptOutOptionMode", dVarF26, 2, 0);
                dVarF27.f11177b = iVar10;
                aVar11.b("MspaServiceProviderMode", dVarF27);
                return aVar11;
            case 11:
                p3.a aVar12 = new p3.a();
                List list13 = j.f11894a;
                aVar12.b("GpcSegmentType", new m3.d(2, (Integer) 1));
                aVar12.b("GpcSegmentIncluded", new m3.c(Boolean.TRUE));
                aVar12.b("Gpc", new m3.c(Boolean.FALSE));
                return aVar12;
            case 12:
                m3.i iVar13 = new m3.i(13);
                m3.i iVar14 = new m3.i(14);
                m3.i iVar15 = new m3.i(15);
                p3.a aVar13 = new p3.a();
                List list14 = k.f11896a;
                aVar13.b("Version", new m3.d(6, (Integer) 1));
                m3.d dVar17 = new m3.d(2, (Integer) 0);
                dVar17.f11177b = iVar13;
                m3.d dVarF28 = r1.i.f(aVar13, "ProcessingNotice", dVar17, 2, 0);
                dVarF28.f11177b = iVar13;
                m3.d dVarF29 = r1.i.f(aVar13, "SaleOptOutNotice", dVarF28, 2, 0);
                dVarF29.f11177b = iVar13;
                m3.d dVarF30 = r1.i.f(aVar13, "TargetedAdvertisingOptOutNotice", dVarF29, 2, 0);
                dVarF30.f11177b = iVar13;
                m3.d dVarF31 = r1.i.f(aVar13, "SaleOptOut", dVarF30, 2, 0);
                dVarF31.f11177b = iVar13;
                aVar13.b("TargetedAdvertisingOptOut", dVarF31);
                m3.d dVar18 = new m3.d(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0), 2);
                dVar18.f11177b = iVar15;
                aVar13.b("SensitiveDataProcessing", dVar18);
                m3.d dVar19 = new m3.d(Arrays.asList(0, 0, 0), 2);
                dVar19.f11177b = iVar15;
                aVar13.b("KnownChildSensitiveDataConsents", dVar19);
                m3.d dVar20 = new m3.d(2, (Integer) 0);
                dVar20.f11177b = iVar13;
                m3.d dVarF32 = r1.i.f(aVar13, "AdditionalDataProcessingConsent", dVar20, 2, 1);
                dVarF32.f11177b = iVar14;
                m3.d dVarF33 = r1.i.f(aVar13, "MspaCoveredTransaction", dVarF32, 2, 0);
                dVarF33.f11177b = iVar13;
                m3.d dVarF34 = r1.i.f(aVar13, "MspaOptOutOptionMode", dVarF33, 2, 0);
                dVarF34.f11177b = iVar13;
                aVar13.b("MspaServiceProviderMode", dVarF34);
                return aVar13;
            case 13:
                m3.i iVar16 = new m3.i(16);
                m3.i iVar17 = new m3.i(17);
                m3.i iVar18 = new m3.i(18);
                p3.a aVar14 = new p3.a();
                List list15 = l.f11897a;
                aVar14.b("Version", new m3.d(6, (Integer) 1));
                m3.d dVar21 = new m3.d(2, (Integer) 0);
                dVar21.f11177b = iVar16;
                m3.d dVarF35 = r1.i.f(aVar14, "ProcessingNotice", dVar21, 2, 0);
                dVarF35.f11177b = iVar16;
                m3.d dVarF36 = r1.i.f(aVar14, "SaleOptOutNotice", dVarF35, 2, 0);
                dVarF36.f11177b = iVar16;
                m3.d dVarF37 = r1.i.f(aVar14, "TargetedAdvertisingOptOutNotice", dVarF36, 2, 0);
                dVarF37.f11177b = iVar16;
                m3.d dVarF38 = r1.i.f(aVar14, "SensitiveDataOptOutNotice", dVarF37, 2, 0);
                dVarF38.f11177b = iVar16;
                m3.d dVarF39 = r1.i.f(aVar14, "SaleOptOut", dVarF38, 2, 0);
                dVarF39.f11177b = iVar16;
                aVar14.b("TargetedAdvertisingOptOut", dVarF39);
                m3.d dVar22 = new m3.d(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0), 2);
                dVar22.f11177b = iVar18;
                aVar14.b("SensitiveDataProcessing", dVar22);
                List list16 = v.f11916a;
                m3.d dVar23 = new m3.d(2, (Integer) 0);
                dVar23.f11177b = iVar16;
                m3.d dVarF40 = r1.i.f(aVar14, "KnownChildSensitiveDataConsents", dVar23, 2, 1);
                dVarF40.f11177b = iVar17;
                m3.d dVarF41 = r1.i.f(aVar14, "MspaCoveredTransaction", dVarF40, 2, 0);
                dVarF41.f11177b = iVar16;
                m3.d dVarF42 = r1.i.f(aVar14, "MspaOptOutOptionMode", dVarF41, 2, 0);
                dVarF42.f11177b = iVar16;
                aVar14.b("MspaServiceProviderMode", dVarF42);
                return aVar14;
            case 14:
                p3.a aVar15 = new p3.a();
                List list17 = l.f11897a;
                aVar15.b("GpcSegmentType", new m3.d(2, (Integer) 1));
                aVar15.b("GpcSegmentIncluded", new m3.c(Boolean.TRUE));
                aVar15.b("Gpc", new m3.c(Boolean.FALSE));
                return aVar15;
            case 15:
                m3.i iVar19 = new m3.i(19);
                m3.i iVar20 = new m3.i(20);
                m3.i iVar21 = new m3.i(21);
                p3.a aVar16 = new p3.a();
                List list18 = m.f11899a;
                aVar16.b("Version", new m3.d(6, (Integer) 1));
                m3.d dVar24 = new m3.d(2, (Integer) 0);
                dVar24.f11177b = iVar19;
                m3.d dVarF43 = r1.i.f(aVar16, "SharingNotice", dVar24, 2, 0);
                dVarF43.f11177b = iVar19;
                m3.d dVarF44 = r1.i.f(aVar16, "SaleOptOutNotice", dVarF43, 2, 0);
                dVarF44.f11177b = iVar19;
                m3.d dVarF45 = r1.i.f(aVar16, "TargetedAdvertisingOptOutNotice", dVarF44, 2, 0);
                dVarF45.f11177b = iVar19;
                m3.d dVarF46 = r1.i.f(aVar16, "SaleOptOut", dVarF45, 2, 0);
                dVarF46.f11177b = iVar19;
                aVar16.b("TargetedAdvertisingOptOut", dVarF46);
                m3.d dVar25 = new m3.d(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0), 2);
                dVar25.f11177b = iVar21;
                aVar16.b("SensitiveDataProcessing", dVar25);
                m3.d dVar26 = new m3.d(Arrays.asList(0, 0, 0), 2);
                dVar26.f11177b = iVar21;
                aVar16.b("KnownChildSensitiveDataConsents", dVar26);
                m3.d dVar27 = new m3.d(2, (Integer) 0);
                dVar27.f11177b = iVar19;
                m3.d dVarF47 = r1.i.f(aVar16, "AdditionalDataProcessingConsent", dVar27, 2, 1);
                dVarF47.f11177b = iVar20;
                m3.d dVarF48 = r1.i.f(aVar16, "MspaCoveredTransaction", dVarF47, 2, 0);
                dVarF48.f11177b = iVar19;
                m3.d dVarF49 = r1.i.f(aVar16, "MspaOptOutOptionMode", dVarF48, 2, 0);
                dVarF49.f11177b = iVar19;
                aVar16.b("MspaServiceProviderMode", dVarF49);
                return aVar16;
            case 16:
                p3.a aVar17 = new p3.a();
                List list19 = m.f11899a;
                aVar17.b("GpcSegmentType", new m3.d(2, (Integer) 1));
                aVar17.b("GpcSegmentIncluded", new m3.c(Boolean.TRUE));
                aVar17.b("Gpc", new m3.c(Boolean.FALSE));
                return aVar17;
            case 17:
                m3.i iVar22 = new m3.i(22);
                m3.i iVar23 = new m3.i(23);
                m3.i iVar24 = new m3.i(24);
                p3.a aVar18 = new p3.a();
                List list20 = n.f11901a;
                aVar18.b("Version", new m3.d(6, (Integer) 1));
                m3.d dVar28 = new m3.d(2, (Integer) 0);
                dVar28.f11177b = iVar22;
                m3.d dVarF50 = r1.i.f(aVar18, "SharingNotice", dVar28, 2, 0);
                dVarF50.f11177b = iVar22;
                m3.d dVarF51 = r1.i.f(aVar18, "SaleOptOutNotice", dVarF50, 2, 0);
                dVarF51.f11177b = iVar22;
                m3.d dVarF52 = r1.i.f(aVar18, "SharingOptOutNotice", dVarF51, 2, 0);
                dVarF52.f11177b = iVar22;
                m3.d dVarF53 = r1.i.f(aVar18, "TargetedAdvertisingOptOutNotice", dVarF52, 2, 0);
                dVarF53.f11177b = iVar22;
                m3.d dVarF54 = r1.i.f(aVar18, "SensitiveDataProcessingOptOutNotice", dVarF53, 2, 0);
                dVarF54.f11177b = iVar22;
                m3.d dVarF55 = r1.i.f(aVar18, "SensitiveDataLimitUseNotice", dVarF54, 2, 0);
                dVarF55.f11177b = iVar22;
                m3.d dVarF56 = r1.i.f(aVar18, "SaleOptOut", dVarF55, 2, 0);
                dVarF56.f11177b = iVar22;
                m3.d dVarF57 = r1.i.f(aVar18, "SharingOptOut", dVarF56, 2, 0);
                dVarF57.f11177b = iVar22;
                aVar18.b("TargetedAdvertisingOptOut", dVarF57);
                m3.d dVar29 = new m3.d(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 2);
                dVar29.f11177b = iVar24;
                aVar18.b("SensitiveDataProcessing", dVar29);
                m3.d dVar30 = new m3.d(Arrays.asList(0, 0, 0), 2);
                dVar30.f11177b = iVar24;
                aVar18.b("KnownChildSensitiveDataConsents", dVar30);
                m3.d dVar31 = new m3.d(2, (Integer) 0);
                dVar31.f11177b = iVar22;
                m3.d dVarF58 = r1.i.f(aVar18, "PersonalDataConsents", dVar31, 2, 1);
                dVarF58.f11177b = iVar23;
                m3.d dVarF59 = r1.i.f(aVar18, "MspaCoveredTransaction", dVarF58, 2, 0);
                dVarF59.f11177b = iVar22;
                m3.d dVarF60 = r1.i.f(aVar18, "MspaOptOutOptionMode", dVarF59, 2, 0);
                dVarF60.f11177b = iVar22;
                aVar18.b("MspaServiceProviderMode", dVarF60);
                return aVar18;
            case 18:
                p3.a aVar19 = new p3.a();
                List list21 = n.f11901a;
                aVar19.b("GpcSegmentType", new m3.d(2, (Integer) 1));
                aVar19.b("GpcSegmentIncluded", new m3.c(Boolean.TRUE));
                aVar19.b("Gpc", new m3.c(Boolean.FALSE));
                return aVar19;
            case 19:
                m3.i iVar25 = new m3.i(25);
                m3.i iVar26 = new m3.i(26);
                m3.i iVar27 = new m3.i(27);
                p3.a aVar20 = new p3.a();
                List list22 = o.f11903a;
                aVar20.b("Version", new m3.d(6, (Integer) 1));
                m3.d dVar32 = new m3.d(2, (Integer) 0);
                dVar32.f11177b = iVar25;
                m3.d dVarF61 = r1.i.f(aVar20, "ProcessingNotice", dVar32, 2, 0);
                dVarF61.f11177b = iVar25;
                m3.d dVarF62 = r1.i.f(aVar20, "SaleOptOutNotice", dVarF61, 2, 0);
                dVarF62.f11177b = iVar25;
                m3.d dVarF63 = r1.i.f(aVar20, "TargetedAdvertisingOptOutNotice", dVarF62, 2, 0);
                dVarF63.f11177b = iVar25;
                m3.d dVarF64 = r1.i.f(aVar20, "SaleOptOut", dVarF63, 2, 0);
                dVarF64.f11177b = iVar25;
                aVar20.b("TargetedAdvertisingOptOut", dVarF64);
                m3.d dVar33 = new m3.d(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0), 2);
                dVar33.f11177b = iVar27;
                aVar20.b("SensitiveDataProcessing", dVar33);
                List list23 = v.f11916a;
                m3.d dVar34 = new m3.d(2, (Integer) 0);
                dVar34.f11177b = iVar25;
                m3.d dVarF65 = r1.i.f(aVar20, "KnownChildSensitiveDataConsents", dVar34, 2, 0);
                dVarF65.f11177b = iVar25;
                m3.d dVarF66 = r1.i.f(aVar20, "AdditionalDataProcessingConsent", dVarF65, 2, 1);
                dVarF66.f11177b = iVar26;
                m3.d dVarF67 = r1.i.f(aVar20, "MspaCoveredTransaction", dVarF66, 2, 0);
                dVarF67.f11177b = iVar25;
                m3.d dVarF68 = r1.i.f(aVar20, "MspaOptOutOptionMode", dVarF67, 2, 0);
                dVarF68.f11177b = iVar25;
                aVar20.b("MspaServiceProviderMode", dVarF68);
                return aVar20;
            case 20:
                p3.a aVar21 = new p3.a();
                List list24 = o.f11903a;
                aVar21.b("GpcSegmentType", new m3.d(2, (Integer) 1));
                aVar21.b("GpcSegmentIncluded", new m3.c(Boolean.TRUE));
                aVar21.b("Gpc", new m3.c(Boolean.FALSE));
                return aVar21;
            case 21:
                m3.i iVar28 = new m3.i(28);
                m3.i iVar29 = new m3.i(29);
                e eVar = new e(0);
                p3.a aVar22 = new p3.a();
                List list25 = p.f11905a;
                aVar22.b("Version", new m3.d(6, (Integer) 1));
                m3.d dVar35 = new m3.d(2, (Integer) 0);
                dVar35.f11177b = iVar28;
                m3.d dVarF69 = r1.i.f(aVar22, "ProcessingNotice", dVar35, 2, 0);
                dVarF69.f11177b = iVar28;
                m3.d dVarF70 = r1.i.f(aVar22, "SaleOptOutNotice", dVarF69, 2, 0);
                dVarF70.f11177b = iVar28;
                m3.d dVarF71 = r1.i.f(aVar22, "TargetedAdvertisingOptOutNotice", dVarF70, 2, 0);
                dVarF71.f11177b = iVar28;
                m3.d dVarF72 = r1.i.f(aVar22, "SaleOptOut", dVarF71, 2, 0);
                dVarF72.f11177b = iVar28;
                aVar22.b("TargetedAdvertisingOptOut", dVarF72);
                m3.d dVar36 = new m3.d(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0), 2);
                dVar36.f11177b = eVar;
                aVar22.b("SensitiveDataProcessing", dVar36);
                m3.d dVar37 = new m3.d(Arrays.asList(0, 0, 0), 2);
                dVar37.f11177b = eVar;
                aVar22.b("KnownChildSensitiveDataConsents", dVar37);
                m3.d dVar38 = new m3.d(2, (Integer) 0);
                dVar38.f11177b = iVar28;
                m3.d dVarF73 = r1.i.f(aVar22, "AdditionalDataProcessingConsent", dVar38, 2, 1);
                dVarF73.f11177b = iVar29;
                m3.d dVarF74 = r1.i.f(aVar22, "MspaCoveredTransaction", dVarF73, 2, 0);
                dVarF74.f11177b = iVar28;
                m3.d dVarF75 = r1.i.f(aVar22, "MspaOptOutOptionMode", dVarF74, 2, 0);
                dVarF75.f11177b = iVar28;
                aVar22.b("MspaServiceProviderMode", dVarF75);
                return aVar22;
            case 22:
                p3.a aVar23 = new p3.a();
                List list26 = p.f11905a;
                aVar23.b("GpcSegmentType", new m3.d(2, (Integer) 1));
                aVar23.b("GpcSegmentIncluded", new m3.c(Boolean.TRUE));
                aVar23.b("Gpc", new m3.c(Boolean.FALSE));
                return aVar23;
            case 23:
                e eVar2 = new e(1);
                e eVar3 = new e(2);
                e eVar4 = new e(3);
                p3.a aVar24 = new p3.a();
                List list27 = q.f11907a;
                aVar24.b("Version", new m3.d(6, (Integer) 1));
                m3.d dVar39 = new m3.d(2, (Integer) 0);
                dVar39.f11177b = eVar2;
                m3.d dVarF76 = r1.i.f(aVar24, "ProcessingNotice", dVar39, 2, 0);
                dVarF76.f11177b = eVar2;
                m3.d dVarF77 = r1.i.f(aVar24, "SaleOptOutNotice", dVarF76, 2, 0);
                dVarF77.f11177b = eVar2;
                m3.d dVarF78 = r1.i.f(aVar24, "TargetedAdvertisingOptOutNotice", dVarF77, 2, 0);
                dVarF78.f11177b = eVar2;
                m3.d dVarF79 = r1.i.f(aVar24, "SaleOptOut", dVarF78, 2, 0);
                dVarF79.f11177b = eVar2;
                aVar24.b("TargetedAdvertisingOptOut", dVarF79);
                m3.d dVar40 = new m3.d(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 2);
                dVar40.f11177b = eVar4;
                aVar24.b("SensitiveDataProcessing", dVar40);
                m3.d dVar41 = new m3.d(Arrays.asList(0, 0, 0, 0, 0), 2);
                dVar41.f11177b = eVar4;
                aVar24.b("KnownChildSensitiveDataConsents", dVar41);
                m3.d dVar42 = new m3.d(2, (Integer) 0);
                dVar42.f11177b = eVar2;
                m3.d dVarF80 = r1.i.f(aVar24, "AdditionalDataProcessingConsent", dVar42, 2, 1);
                dVarF80.f11177b = eVar3;
                m3.d dVarF81 = r1.i.f(aVar24, "MspaCoveredTransaction", dVarF80, 2, 0);
                dVarF81.f11177b = eVar2;
                m3.d dVarF82 = r1.i.f(aVar24, "MspaOptOutOptionMode", dVarF81, 2, 0);
                dVarF82.f11177b = eVar2;
                aVar24.b("MspaServiceProviderMode", dVarF82);
                return aVar24;
            case 24:
                p3.a aVar25 = new p3.a();
                List list28 = q.f11907a;
                aVar25.b("GpcSegmentType", new m3.d(2, (Integer) 1));
                aVar25.b("GpcSegmentIncluded", new m3.c(Boolean.TRUE));
                aVar25.b("Gpc", new m3.c(Boolean.FALSE));
                return aVar25;
            case 25:
                e eVar5 = new e(4);
                e eVar6 = new e(5);
                e eVar7 = new e(6);
                p3.a aVar26 = new p3.a();
                List list29 = r.f11909a;
                aVar26.b("Version", new m3.d(6, (Integer) 1));
                m3.d dVar43 = new m3.d(2, (Integer) 0);
                dVar43.f11177b = eVar5;
                m3.d dVarF83 = r1.i.f(aVar26, "ProcessingNotice", dVar43, 2, 0);
                dVarF83.f11177b = eVar5;
                m3.d dVarF84 = r1.i.f(aVar26, "SaleOptOutNotice", dVarF83, 2, 0);
                dVarF84.f11177b = eVar5;
                m3.d dVarF85 = r1.i.f(aVar26, "TargetedAdvertisingOptOutNotice", dVarF84, 2, 0);
                dVarF85.f11177b = eVar5;
                m3.d dVarF86 = r1.i.f(aVar26, "SaleOptOut", dVarF85, 2, 0);
                dVarF86.f11177b = eVar5;
                aVar26.b("TargetedAdvertisingOptOut", dVarF86);
                m3.d dVar44 = new m3.d(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 2);
                dVar44.f11177b = eVar7;
                aVar26.b("SensitiveDataProcessing", dVar44);
                m3.d dVar45 = new m3.d(Arrays.asList(0, 0, 0), 2);
                dVar45.f11177b = eVar7;
                aVar26.b("KnownChildSensitiveDataConsents", dVar45);
                m3.d dVar46 = new m3.d(2, (Integer) 0);
                dVar46.f11177b = eVar5;
                m3.d dVarF87 = r1.i.f(aVar26, "AdditionalDataProcessingConsent", dVar46, 2, 1);
                dVarF87.f11177b = eVar6;
                m3.d dVarF88 = r1.i.f(aVar26, "MspaCoveredTransaction", dVarF87, 2, 0);
                dVarF88.f11177b = eVar5;
                m3.d dVarF89 = r1.i.f(aVar26, "MspaOptOutOptionMode", dVarF88, 2, 0);
                dVarF89.f11177b = eVar5;
                aVar26.b("MspaServiceProviderMode", dVarF89);
                return aVar26;
            case 26:
                p3.a aVar27 = new p3.a();
                List list30 = r.f11909a;
                aVar27.b("GpcSegmentType", new m3.d(2, (Integer) 1));
                aVar27.b("GpcSegmentIncluded", new m3.c(Boolean.TRUE));
                aVar27.b("Gpc", new m3.c(Boolean.FALSE));
                return aVar27;
            case 27:
                e eVar8 = new e(7);
                e eVar9 = new e(8);
                e eVar10 = new e(9);
                p3.a aVar28 = new p3.a();
                List list31 = s.f11911a;
                aVar28.b("Version", new m3.d(6, (Integer) 1));
                m3.d dVar47 = new m3.d(2, (Integer) 0);
                dVar47.f11177b = eVar8;
                m3.d dVarF90 = r1.i.f(aVar28, "ProcessingNotice", dVar47, 2, 0);
                dVarF90.f11177b = eVar8;
                m3.d dVarF91 = r1.i.f(aVar28, "SaleOptOutNotice", dVarF90, 2, 0);
                dVarF91.f11177b = eVar8;
                m3.d dVarF92 = r1.i.f(aVar28, "TargetedAdvertisingOptOutNotice", dVarF91, 2, 0);
                dVarF92.f11177b = eVar8;
                m3.d dVarF93 = r1.i.f(aVar28, "SaleOptOut", dVarF92, 2, 0);
                dVarF93.f11177b = eVar8;
                aVar28.b("TargetedAdvertisingOptOut", dVarF93);
                m3.d dVar48 = new m3.d(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0), 2);
                dVar48.f11177b = eVar10;
                aVar28.b("SensitiveDataProcessing", dVar48);
                m3.d dVar49 = new m3.d(2, (Integer) 0);
                dVar49.f11177b = eVar8;
                m3.d dVarF94 = r1.i.f(aVar28, "KnownChildSensitiveDataConsents", dVar49, 2, 0);
                dVarF94.f11177b = eVar8;
                m3.d dVarF95 = r1.i.f(aVar28, "AdditionalDataProcessingConsent", dVarF94, 2, 1);
                dVarF95.f11177b = eVar9;
                m3.d dVarF96 = r1.i.f(aVar28, "MspaCoveredTransaction", dVarF95, 2, 0);
                dVarF96.f11177b = eVar8;
                m3.d dVarF97 = r1.i.f(aVar28, "MspaOptOutOptionMode", dVarF96, 2, 0);
                dVarF97.f11177b = eVar8;
                aVar28.b("MspaServiceProviderMode", dVarF97);
                return aVar28;
            case 28:
                p3.a aVar29 = new p3.a();
                List list32 = s.f11911a;
                aVar29.b("GpcSegmentType", new m3.d(2, (Integer) 1));
                aVar29.b("GpcSegmentIncluded", new m3.c(Boolean.TRUE));
                aVar29.b("Gpc", new m3.c(Boolean.FALSE));
                return aVar29;
            default:
                e eVar11 = new e(10);
                e eVar12 = new e(11);
                e eVar13 = new e(12);
                p3.a aVar30 = new p3.a();
                List list33 = t.f11913a;
                aVar30.b("Version", new m3.d(6, (Integer) 1));
                m3.d dVar50 = new m3.d(2, (Integer) 0);
                dVar50.f11177b = eVar11;
                m3.d dVarF98 = r1.i.f(aVar30, "ProcessingNotice", dVar50, 2, 0);
                dVarF98.f11177b = eVar11;
                m3.d dVarF99 = r1.i.f(aVar30, "SaleOptOutNotice", dVarF98, 2, 0);
                dVarF99.f11177b = eVar11;
                m3.d dVarF100 = r1.i.f(aVar30, "TargetedAdvertisingOptOutNotice", dVarF99, 2, 0);
                dVarF100.f11177b = eVar11;
                m3.d dVarF101 = r1.i.f(aVar30, "SaleOptOut", dVarF100, 2, 0);
                dVarF101.f11177b = eVar11;
                aVar30.b("TargetedAdvertisingOptOut", dVarF101);
                m3.d dVar51 = new m3.d(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0), 2);
                dVar51.f11177b = eVar13;
                aVar30.b("SensitiveDataProcessing", dVar51);
                List list34 = v.f11916a;
                m3.d dVar52 = new m3.d(2, (Integer) 0);
                dVar52.f11177b = eVar11;
                m3.d dVarF102 = r1.i.f(aVar30, "KnownChildSensitiveDataConsents", dVar52, 2, 0);
                dVarF102.f11177b = eVar11;
                m3.d dVarF103 = r1.i.f(aVar30, "AdditionalDataProcessingConsent", dVarF102, 2, 1);
                dVarF103.f11177b = eVar12;
                m3.d dVarF104 = r1.i.f(aVar30, "MspaCoveredTransaction", dVarF103, 2, 0);
                dVarF104.f11177b = eVar11;
                m3.d dVarF105 = r1.i.f(aVar30, "MspaOptOutOptionMode", dVarF104, 2, 0);
                dVarF105.f11177b = eVar11;
                aVar30.b("MspaServiceProviderMode", dVarF105);
                return aVar30;
        }
    }
}
