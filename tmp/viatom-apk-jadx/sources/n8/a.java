package n8;

import c.i;
import com.google.android.gms.internal.measurement.a4;
import com.inmobi.cmp.core.model.mspa.USRegulationData;
import java.util.List;
import p3.g;
import p3.h;
import p3.j;
import p3.k;
import p3.l;
import p3.m;
import p3.o;
import p3.p;
import p3.q;
import p3.s;
import p3.t;
import p3.u;
import p3.v;
import w2.r;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a extends r {
    public final /* synthetic */ int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(int i10) {
        super(21);
        this.g = i10;
    }

    @Override // w2.r
    public final String c(int i10) {
        switch (this.g) {
            case 0:
                if (i10 == 0) {
                    throw null;
                }
                int iC = i.c(i10);
                if (iC == 1) {
                    List list = g.f11888a;
                    return "SaleOptOutNotice";
                }
                if (iC == 2) {
                    List list2 = g.f11888a;
                    return "SharingOptOutNotice";
                }
                if (iC == 5) {
                    List list3 = g.f11888a;
                    return "SensitiveDataLimitUseNotice";
                }
                if (iC == 7) {
                    List list4 = g.f11888a;
                    return "SaleOptOut";
                }
                if (iC == 8) {
                    List list5 = g.f11888a;
                    return "SharingOptOut";
                }
                switch (iC) {
                    case 10:
                        List list6 = g.f11888a;
                        return "SensitiveDataProcessing";
                    case 11:
                        List list7 = g.f11888a;
                        return "KnownChildSensitiveDataConsents";
                    case 12:
                        List list8 = g.f11888a;
                        return "PersonalDataConsents";
                    case 13:
                        List list9 = g.f11888a;
                        return "MspaCoveredTransaction";
                    case 14:
                        List list10 = g.f11888a;
                        return "MspaOptOutOptionMode";
                    case 15:
                        List list11 = g.f11888a;
                        return "MspaServiceProviderMode";
                    default:
                        return "";
                }
            case 1:
                if (i10 == 0) {
                    throw null;
                }
                int iC2 = i.c(i10);
                if (iC2 == 0) {
                    List list12 = h.f11890a;
                    return "SharingNotice";
                }
                if (iC2 == 1) {
                    List list13 = h.f11890a;
                    return "SaleOptOutNotice";
                }
                if (iC2 == 3) {
                    List list14 = h.f11890a;
                    return "TargetedAdvertisingOptOutNotice";
                }
                if (iC2 == 7) {
                    List list15 = h.f11890a;
                    return "SaleOptOut";
                }
                switch (iC2) {
                    case 9:
                        List list16 = h.f11890a;
                        return "TargetedAdvertisingOptOut";
                    case 10:
                        List list17 = h.f11890a;
                        return "SensitiveDataProcessing";
                    case 11:
                        List list18 = h.f11890a;
                        return "KnownChildSensitiveDataConsents";
                    default:
                        switch (iC2) {
                            case 13:
                                List list19 = h.f11890a;
                                return "MspaCoveredTransaction";
                            case 14:
                                List list20 = h.f11890a;
                                return "MspaOptOutOptionMode";
                            case 15:
                                List list21 = h.f11890a;
                                return "MspaServiceProviderMode";
                            default:
                                return "";
                        }
                }
            case 2:
                if (i10 == 0) {
                    throw null;
                }
                int iC3 = i.c(i10);
                if (iC3 == 0) {
                    List list22 = p3.i.f11892a;
                    return "SharingNotice";
                }
                if (iC3 == 1) {
                    List list23 = p3.i.f11892a;
                    return "SaleOptOutNotice";
                }
                if (iC3 == 3) {
                    List list24 = p3.i.f11892a;
                    return "TargetedAdvertisingOptOutNotice";
                }
                if (iC3 == 7) {
                    List list25 = p3.i.f11892a;
                    return "SaleOptOut";
                }
                switch (iC3) {
                    case 9:
                        List list26 = p3.i.f11892a;
                        return "TargetedAdvertisingOptOut";
                    case 10:
                        List list27 = p3.i.f11892a;
                        return "SensitiveDataProcessing";
                    case 11:
                        List list28 = p3.i.f11892a;
                        return "KnownChildSensitiveDataConsents";
                    default:
                        switch (iC3) {
                            case 13:
                                List list29 = p3.i.f11892a;
                                return "MspaCoveredTransaction";
                            case 14:
                                List list30 = p3.i.f11892a;
                                return "MspaOptOutOptionMode";
                            case 15:
                                List list31 = p3.i.f11892a;
                                return "MspaServiceProviderMode";
                            default:
                                return "";
                        }
                }
            case 3:
                if (i10 == 0) {
                    throw null;
                }
                int iC4 = i.c(i10);
                if (iC4 == 1) {
                    List list32 = j.f11894a;
                    return "SaleOptOutNotice";
                }
                if (iC4 == 3) {
                    List list33 = j.f11894a;
                    return "TargetedAdvertisingOptOutNotice";
                }
                if (iC4 == 6) {
                    List list34 = j.f11894a;
                    return "ProcessingNotice";
                }
                if (iC4 == 7) {
                    List list35 = j.f11894a;
                    return "SaleOptOut";
                }
                switch (iC4) {
                    case 9:
                        List list36 = j.f11894a;
                        return "TargetedAdvertisingOptOut";
                    case 10:
                        List list37 = j.f11894a;
                        return "SensitiveDataProcessing";
                    case 11:
                        List list38 = j.f11894a;
                        return "KnownChildSensitiveDataConsents";
                    case 12:
                        List list39 = j.f11894a;
                        return "AdditionalDataProcessingConsent";
                    case 13:
                        List list40 = j.f11894a;
                        return "MspaCoveredTransaction";
                    case 14:
                        List list41 = j.f11894a;
                        return "MspaOptOutOptionMode";
                    case 15:
                        List list42 = j.f11894a;
                        return "MspaServiceProviderMode";
                    default:
                        return "";
                }
            case 4:
                if (i10 == 0) {
                    throw null;
                }
                int iC5 = i.c(i10);
                if (iC5 == 1) {
                    List list43 = k.f11896a;
                    return "SaleOptOutNotice";
                }
                if (iC5 == 3) {
                    List list44 = k.f11896a;
                    return "TargetedAdvertisingOptOutNotice";
                }
                if (iC5 == 6) {
                    List list45 = k.f11896a;
                    return "ProcessingNotice";
                }
                if (iC5 == 7) {
                    List list46 = k.f11896a;
                    return "SaleOptOut";
                }
                switch (iC5) {
                    case 9:
                        List list47 = k.f11896a;
                        return "TargetedAdvertisingOptOut";
                    case 10:
                        List list48 = k.f11896a;
                        return "SensitiveDataProcessing";
                    case 11:
                        List list49 = k.f11896a;
                        return "KnownChildSensitiveDataConsents";
                    case 12:
                        List list50 = k.f11896a;
                        return "AdditionalDataProcessingConsent";
                    case 13:
                        List list51 = k.f11896a;
                        return "MspaCoveredTransaction";
                    case 14:
                        List list52 = k.f11896a;
                        return "MspaOptOutOptionMode";
                    case 15:
                        List list53 = k.f11896a;
                        return "MspaServiceProviderMode";
                    default:
                        return "";
                }
            case 5:
                if (i10 == 0) {
                    throw null;
                }
                switch (i.c(i10)) {
                    case 1:
                        List list54 = l.f11897a;
                        return "SaleOptOutNotice";
                    case 2:
                    case 5:
                    case 8:
                    case 12:
                    default:
                        return "";
                    case 3:
                        List list55 = l.f11897a;
                        return "TargetedAdvertisingOptOutNotice";
                    case 4:
                        List list56 = l.f11897a;
                        return "SensitiveDataOptOutNotice";
                    case 6:
                        List list57 = l.f11897a;
                        return "ProcessingNotice";
                    case 7:
                        List list58 = l.f11897a;
                        return "SaleOptOut";
                    case 9:
                        List list59 = l.f11897a;
                        return "TargetedAdvertisingOptOut";
                    case 10:
                        List list60 = l.f11897a;
                        return "SensitiveDataProcessing";
                    case 11:
                        List list61 = l.f11897a;
                        return "KnownChildSensitiveDataConsents";
                    case 13:
                        List list62 = l.f11897a;
                        return "MspaCoveredTransaction";
                    case 14:
                        List list63 = l.f11897a;
                        return "MspaOptOutOptionMode";
                    case 15:
                        List list64 = l.f11897a;
                        return "MspaServiceProviderMode";
                }
            case 6:
                if (i10 == 0) {
                    throw null;
                }
                int iC6 = i.c(i10);
                if (iC6 == 0) {
                    List list65 = m.f11899a;
                    return "SharingNotice";
                }
                if (iC6 == 1) {
                    List list66 = m.f11899a;
                    return "SaleOptOutNotice";
                }
                if (iC6 == 3) {
                    List list67 = m.f11899a;
                    return "TargetedAdvertisingOptOutNotice";
                }
                if (iC6 == 7) {
                    List list68 = m.f11899a;
                    return "SaleOptOut";
                }
                switch (iC6) {
                    case 9:
                        List list69 = m.f11899a;
                        return "TargetedAdvertisingOptOut";
                    case 10:
                        List list70 = m.f11899a;
                        return "SensitiveDataProcessing";
                    case 11:
                        List list71 = m.f11899a;
                        return "KnownChildSensitiveDataConsents";
                    case 12:
                        List list72 = m.f11899a;
                        return "AdditionalDataProcessingConsent";
                    case 13:
                        List list73 = m.f11899a;
                        return "MspaCoveredTransaction";
                    case 14:
                        List list74 = m.f11899a;
                        return "MspaOptOutOptionMode";
                    case 15:
                        List list75 = m.f11899a;
                        return "MspaServiceProviderMode";
                    default:
                        return "";
                }
            case 7:
                if (i10 == 0) {
                    throw null;
                }
                int iC7 = i.c(i10);
                if (iC7 == 1) {
                    List list76 = o.f11903a;
                    return "SaleOptOutNotice";
                }
                if (iC7 == 3) {
                    List list77 = o.f11903a;
                    return "TargetedAdvertisingOptOutNotice";
                }
                if (iC7 == 6) {
                    List list78 = o.f11903a;
                    return "ProcessingNotice";
                }
                if (iC7 == 7) {
                    List list79 = o.f11903a;
                    return "SaleOptOut";
                }
                switch (iC7) {
                    case 9:
                        List list80 = o.f11903a;
                        return "TargetedAdvertisingOptOut";
                    case 10:
                        List list81 = o.f11903a;
                        return "SensitiveDataProcessing";
                    case 11:
                        List list82 = o.f11903a;
                        return "KnownChildSensitiveDataConsents";
                    case 12:
                        List list83 = o.f11903a;
                        return "AdditionalDataProcessingConsent";
                    case 13:
                        List list84 = o.f11903a;
                        return "MspaCoveredTransaction";
                    case 14:
                        List list85 = o.f11903a;
                        return "MspaOptOutOptionMode";
                    case 15:
                        List list86 = o.f11903a;
                        return "MspaServiceProviderMode";
                    default:
                        return "";
                }
            case 8:
                if (i10 == 0) {
                    throw null;
                }
                int iC8 = i.c(i10);
                if (iC8 == 1) {
                    List list87 = p.f11905a;
                    return "SaleOptOutNotice";
                }
                if (iC8 == 3) {
                    List list88 = p.f11905a;
                    return "TargetedAdvertisingOptOutNotice";
                }
                if (iC8 == 6) {
                    List list89 = p.f11905a;
                    return "ProcessingNotice";
                }
                if (iC8 == 7) {
                    List list90 = p.f11905a;
                    return "SaleOptOut";
                }
                switch (iC8) {
                    case 9:
                        List list91 = p.f11905a;
                        return "TargetedAdvertisingOptOut";
                    case 10:
                        List list92 = p.f11905a;
                        return "SensitiveDataProcessing";
                    case 11:
                        List list93 = p.f11905a;
                        return "KnownChildSensitiveDataConsents";
                    case 12:
                        List list94 = p.f11905a;
                        return "AdditionalDataProcessingConsent";
                    case 13:
                        List list95 = p.f11905a;
                        return "MspaCoveredTransaction";
                    case 14:
                        List list96 = p.f11905a;
                        return "MspaOptOutOptionMode";
                    case 15:
                        List list97 = p.f11905a;
                        return "MspaServiceProviderMode";
                    default:
                        return "";
                }
            case 9:
                if (i10 == 0) {
                    throw null;
                }
                int iC9 = i.c(i10);
                if (iC9 == 1) {
                    List list98 = q.f11907a;
                    return "SaleOptOutNotice";
                }
                if (iC9 == 3) {
                    List list99 = q.f11907a;
                    return "TargetedAdvertisingOptOutNotice";
                }
                if (iC9 == 6) {
                    List list100 = q.f11907a;
                    return "ProcessingNotice";
                }
                if (iC9 == 7) {
                    List list101 = q.f11907a;
                    return "SaleOptOut";
                }
                switch (iC9) {
                    case 9:
                        List list102 = q.f11907a;
                        return "TargetedAdvertisingOptOut";
                    case 10:
                        List list103 = q.f11907a;
                        return "SensitiveDataProcessing";
                    case 11:
                        List list104 = q.f11907a;
                        return "KnownChildSensitiveDataConsents";
                    case 12:
                        List list105 = q.f11907a;
                        return "AdditionalDataProcessingConsent";
                    case 13:
                        List list106 = q.f11907a;
                        return "MspaCoveredTransaction";
                    case 14:
                        List list107 = q.f11907a;
                        return "MspaOptOutOptionMode";
                    case 15:
                        List list108 = q.f11907a;
                        return "MspaServiceProviderMode";
                    default:
                        return "";
                }
            case 10:
                if (i10 == 0) {
                    throw null;
                }
                int iC10 = i.c(i10);
                if (iC10 == 1) {
                    List list109 = p3.r.f11909a;
                    return "SaleOptOutNotice";
                }
                if (iC10 == 3) {
                    List list110 = p3.r.f11909a;
                    return "TargetedAdvertisingOptOutNotice";
                }
                if (iC10 == 6) {
                    List list111 = p3.r.f11909a;
                    return "ProcessingNotice";
                }
                if (iC10 == 7) {
                    List list112 = p3.r.f11909a;
                    return "SaleOptOut";
                }
                switch (iC10) {
                    case 9:
                        List list113 = p3.r.f11909a;
                        return "TargetedAdvertisingOptOut";
                    case 10:
                        List list114 = p3.r.f11909a;
                        return "SensitiveDataProcessing";
                    case 11:
                        List list115 = p3.r.f11909a;
                        return "KnownChildSensitiveDataConsents";
                    case 12:
                        List list116 = p3.r.f11909a;
                        return "AdditionalDataProcessingConsent";
                    case 13:
                        List list117 = p3.r.f11909a;
                        return "MspaCoveredTransaction";
                    case 14:
                        List list118 = p3.r.f11909a;
                        return "MspaOptOutOptionMode";
                    case 15:
                        List list119 = p3.r.f11909a;
                        return "MspaServiceProviderMode";
                    default:
                        return "";
                }
            case 11:
                if (i10 == 0) {
                    throw null;
                }
                int iC11 = i.c(i10);
                if (iC11 == 1) {
                    List list120 = s.f11911a;
                    return "SaleOptOutNotice";
                }
                if (iC11 == 3) {
                    List list121 = s.f11911a;
                    return "TargetedAdvertisingOptOutNotice";
                }
                if (iC11 == 6) {
                    List list122 = s.f11911a;
                    return "ProcessingNotice";
                }
                if (iC11 == 7) {
                    List list123 = s.f11911a;
                    return "SaleOptOut";
                }
                switch (iC11) {
                    case 9:
                        List list124 = s.f11911a;
                        return "TargetedAdvertisingOptOut";
                    case 10:
                        List list125 = s.f11911a;
                        return "SensitiveDataProcessing";
                    case 11:
                        List list126 = s.f11911a;
                        return "KnownChildSensitiveDataConsents";
                    case 12:
                        List list127 = s.f11911a;
                        return "AdditionalDataProcessingConsent";
                    case 13:
                        List list128 = s.f11911a;
                        return "MspaCoveredTransaction";
                    case 14:
                        List list129 = s.f11911a;
                        return "MspaOptOutOptionMode";
                    case 15:
                        List list130 = s.f11911a;
                        return "MspaServiceProviderMode";
                    default:
                        return "";
                }
            case 12:
                if (i10 == 0) {
                    throw null;
                }
                int iC12 = i.c(i10);
                if (iC12 == 1) {
                    List list131 = t.f11913a;
                    return "SaleOptOutNotice";
                }
                if (iC12 == 3) {
                    List list132 = t.f11913a;
                    return "TargetedAdvertisingOptOutNotice";
                }
                if (iC12 == 6) {
                    List list133 = t.f11913a;
                    return "ProcessingNotice";
                }
                if (iC12 == 7) {
                    List list134 = t.f11913a;
                    return "SaleOptOut";
                }
                switch (iC12) {
                    case 9:
                        List list135 = t.f11913a;
                        return "TargetedAdvertisingOptOut";
                    case 10:
                        List list136 = t.f11913a;
                        return "SensitiveDataProcessing";
                    case 11:
                        List list137 = t.f11913a;
                        return "KnownChildSensitiveDataConsents";
                    case 12:
                        List list138 = t.f11913a;
                        return "AdditionalDataProcessingConsent";
                    case 13:
                        List list139 = t.f11913a;
                        return "MspaCoveredTransaction";
                    case 14:
                        List list140 = t.f11913a;
                        return "MspaOptOutOptionMode";
                    case 15:
                        List list141 = t.f11913a;
                        return "MspaServiceProviderMode";
                    default:
                        return "";
                }
            case 13:
                if (i10 == 0) {
                    throw null;
                }
                switch (i.c(i10)) {
                    case 0:
                        List list142 = u.f11915a;
                        return "SharingNotice";
                    case 1:
                        List list143 = u.f11915a;
                        return "SaleOptOutNotice";
                    case 2:
                    case 5:
                    case 6:
                    case 8:
                    case 12:
                    default:
                        return "";
                    case 3:
                        List list144 = u.f11915a;
                        return "TargetedAdvertisingOptOutNotice";
                    case 4:
                        List list145 = u.f11915a;
                        return "SensitiveDataProcessingOptOutNotice";
                    case 7:
                        List list146 = u.f11915a;
                        return "SaleOptOut";
                    case 9:
                        List list147 = u.f11915a;
                        return "TargetedAdvertisingOptOut";
                    case 10:
                        List list148 = u.f11915a;
                        return "SensitiveDataProcessing";
                    case 11:
                        List list149 = u.f11915a;
                        return "KnownChildSensitiveDataConsents";
                    case 13:
                        List list150 = u.f11915a;
                        return "MspaCoveredTransaction";
                    case 14:
                        List list151 = u.f11915a;
                        return "MspaOptOutOptionMode";
                    case 15:
                        List list152 = u.f11915a;
                        return "MspaServiceProviderMode";
                }
            default:
                if (i10 == 0) {
                    throw null;
                }
                int iC13 = i.c(i10);
                if (iC13 == 0) {
                    List list153 = v.f11916a;
                    return "SharingNotice";
                }
                if (iC13 == 1) {
                    List list154 = v.f11916a;
                    return "SaleOptOutNotice";
                }
                if (iC13 == 3) {
                    List list155 = v.f11916a;
                    return "TargetedAdvertisingOptOutNotice";
                }
                if (iC13 == 7) {
                    List list156 = v.f11916a;
                    return "SaleOptOut";
                }
                switch (iC13) {
                    case 9:
                        List list157 = v.f11916a;
                        return "TargetedAdvertisingOptOut";
                    case 10:
                        List list158 = v.f11916a;
                        return "SensitiveDataProcessing";
                    case 11:
                        List list159 = v.f11916a;
                        return "KnownChildSensitiveDataConsents";
                    default:
                        switch (iC13) {
                            case 13:
                                List list160 = v.f11916a;
                                return "MspaCoveredTransaction";
                            case 14:
                                List list161 = v.f11916a;
                                return "MspaOptOutOptionMode";
                            case 15:
                                List list162 = v.f11916a;
                                return "MspaServiceProviderMode";
                            default:
                                return "";
                        }
                }
        }
    }

    @Override // w2.r
    public void h(int i10, boolean z9) {
        int i11;
        switch (this.g) {
            case 1:
                if (i10 == 0) {
                    throw null;
                }
                i11 = z9 ? 1 : 2;
                g(i10, Integer.valueOf(i11));
                ((USRegulationData) this.e).setKnownChildSensitiveDataConsents(a4.u(Integer.valueOf(i11)));
                return;
            case 2:
            case 4:
            case 6:
            case 8:
            case 10:
            default:
                super.h(i10, z9);
                return;
            case 3:
                if (i10 == 0) {
                    throw null;
                }
                List<Integer> listQ = z9 ? t6.m.Q(1, 1, 1, 1, 1) : t6.m.Q(2, 2, 2, 2, 2);
                g(i10, listQ);
                ((USRegulationData) this.e).setKnownChildSensitiveDataConsents(listQ);
                return;
            case 5:
                if (i10 == 0) {
                    throw null;
                }
                i11 = z9 ? 1 : 2;
                g(i10, Integer.valueOf(i11));
                ((USRegulationData) this.e).setKnownChildSensitiveDataConsents(a4.u(Integer.valueOf(i11)));
                return;
            case 7:
                if (i10 == 0) {
                    throw null;
                }
                i11 = z9 ? 1 : 2;
                g(i10, Integer.valueOf(i11));
                ((USRegulationData) this.e).setKnownChildSensitiveDataConsents(a4.u(Integer.valueOf(i11)));
                return;
            case 9:
                if (i10 == 0) {
                    throw null;
                }
                List<Integer> listQ2 = z9 ? t6.m.Q(1, 1, 1, 1, 1) : t6.m.Q(2, 2, 2, 2, 2);
                g(i10, listQ2);
                ((USRegulationData) this.e).setKnownChildSensitiveDataConsents(listQ2);
                return;
            case 11:
                if (i10 == 0) {
                    throw null;
                }
                i11 = z9 ? 1 : 2;
                g(i10, Integer.valueOf(i11));
                ((USRegulationData) this.e).setKnownChildSensitiveDataConsents(a4.u(Integer.valueOf(i11)));
                return;
            case 12:
                if (i10 == 0) {
                    throw null;
                }
                i11 = z9 ? 1 : 2;
                g(i10, Integer.valueOf(i11));
                ((USRegulationData) this.e).setKnownChildSensitiveDataConsents(a4.u(Integer.valueOf(i11)));
                return;
            case 13:
                if (i10 == 0) {
                    throw null;
                }
                i11 = z9 ? 1 : 2;
                g(i10, Integer.valueOf(i11));
                ((USRegulationData) this.e).setKnownChildSensitiveDataConsents(a4.u(Integer.valueOf(i11)));
                return;
            case 14:
                if (i10 == 0) {
                    throw null;
                }
                i11 = z9 ? 1 : 2;
                g(i10, Integer.valueOf(i11));
                ((USRegulationData) this.e).setKnownChildSensitiveDataConsents(a4.u(Integer.valueOf(i11)));
                return;
        }
    }

    @Override // w2.r
    public void j(Boolean bool, int i10) {
        switch (this.g) {
            case 3:
                if (i10 == 0) {
                    throw null;
                }
                Boolean bool2 = Boolean.TRUE;
                int i11 = kotlin.jvm.internal.l.a(bool, bool2) ? 1 : 2;
                ((USRegulationData) this.e).setAdditionalProcessingDataConsent(kotlin.jvm.internal.l.a(bool, bool2) ? 1 : 2);
                g(i10, Integer.valueOf(i11));
                return;
            case 4:
                if (i10 == 0) {
                    throw null;
                }
                Boolean bool3 = Boolean.TRUE;
                int i12 = kotlin.jvm.internal.l.a(bool, bool3) ? 1 : 2;
                ((USRegulationData) this.e).setAdditionalProcessingDataConsent(kotlin.jvm.internal.l.a(bool, bool3) ? 1 : 2);
                g(i10, Integer.valueOf(i12));
                return;
            case 5:
            default:
                super.j(bool, i10);
                return;
            case 6:
                if (i10 == 0) {
                    throw null;
                }
                Boolean bool4 = Boolean.TRUE;
                int i13 = kotlin.jvm.internal.l.a(bool, bool4) ? 1 : 2;
                ((USRegulationData) this.e).setAdditionalProcessingDataConsent(kotlin.jvm.internal.l.a(bool, bool4) ? 1 : 2);
                g(i10, Integer.valueOf(i13));
                return;
            case 7:
                if (i10 == 0) {
                    throw null;
                }
                Boolean bool5 = Boolean.TRUE;
                int i14 = kotlin.jvm.internal.l.a(bool, bool5) ? 1 : 2;
                ((USRegulationData) this.e).setAdditionalProcessingDataConsent(kotlin.jvm.internal.l.a(bool, bool5) ? 1 : 2);
                g(i10, Integer.valueOf(i14));
                return;
            case 8:
                if (i10 == 0) {
                    throw null;
                }
                Boolean bool6 = Boolean.TRUE;
                int i15 = kotlin.jvm.internal.l.a(bool, bool6) ? 1 : 2;
                ((USRegulationData) this.e).setAdditionalProcessingDataConsent(kotlin.jvm.internal.l.a(bool, bool6) ? 1 : 2);
                g(i10, Integer.valueOf(i15));
                return;
            case 9:
                if (i10 == 0) {
                    throw null;
                }
                Boolean bool7 = Boolean.TRUE;
                int i16 = kotlin.jvm.internal.l.a(bool, bool7) ? 1 : 2;
                ((USRegulationData) this.e).setAdditionalProcessingDataConsent(kotlin.jvm.internal.l.a(bool, bool7) ? 1 : 2);
                g(i10, Integer.valueOf(i16));
                return;
            case 10:
                if (i10 == 0) {
                    throw null;
                }
                Boolean bool8 = Boolean.TRUE;
                int i17 = kotlin.jvm.internal.l.a(bool, bool8) ? 1 : 2;
                ((USRegulationData) this.e).setAdditionalProcessingDataConsent(kotlin.jvm.internal.l.a(bool, bool8) ? 1 : 2);
                g(i10, Integer.valueOf(i17));
                return;
            case 11:
                if (i10 == 0) {
                    throw null;
                }
                Boolean bool9 = Boolean.TRUE;
                int i18 = kotlin.jvm.internal.l.a(bool, bool9) ? 1 : 2;
                ((USRegulationData) this.e).setAdditionalProcessingDataConsent(kotlin.jvm.internal.l.a(bool, bool9) ? 1 : 2);
                g(i10, Integer.valueOf(i18));
                return;
            case 12:
                if (i10 == 0) {
                    throw null;
                }
                Boolean bool10 = Boolean.TRUE;
                int i19 = kotlin.jvm.internal.l.a(bool, bool10) ? 1 : 2;
                ((USRegulationData) this.e).setAdditionalProcessingDataConsent(kotlin.jvm.internal.l.a(bool, bool10) ? 1 : 2);
                g(i10, Integer.valueOf(i19));
                return;
        }
    }

    @Override // w2.r
    public void l(boolean z9) {
        switch (this.g) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                break;
            default:
                super.l(z9);
                break;
        }
    }

    @Override // w2.r
    public final String p() {
        switch (this.g) {
            case 0:
                return "usca";
            case 1:
                return "usco";
            case 2:
                return "usct";
            case 3:
                return "usde";
            case 4:
                return "usfl";
            case 5:
                return "usia";
            case 6:
                return "usmt";
            case 7:
                return "usne";
            case 8:
                return "usnh";
            case 9:
                return "usnj";
            case 10:
                return "usor";
            case 11:
                return "ustn";
            case 12:
                return "ustx";
            case 13:
                return "usut";
            default:
                return "usva";
        }
    }

    @Override // w2.r
    public void r(boolean z9) {
        switch (this.g) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 14:
                break;
            case 5:
            case 13:
            default:
                super.r(z9);
                break;
        }
    }

    @Override // w2.r
    public final int t() {
        switch (this.g) {
            case 0:
                return 8;
            case 1:
                return 10;
            case 2:
                return 12;
            case 3:
                return 17;
            case 4:
                return 13;
            case 5:
                return 18;
            case 6:
                return 14;
            case 7:
                return 19;
            case 8:
                return 20;
            case 9:
                return 21;
            case 10:
                return 15;
            case 11:
                return 22;
            case 12:
                return 16;
            case 13:
                return 11;
            default:
                return 9;
        }
    }

    @Override // w2.r
    public void u(boolean z9) {
        switch (this.g) {
            case 0:
                break;
            default:
                super.u(z9);
                break;
        }
    }

    @Override // w2.r
    public void v(boolean z9) {
        switch (this.g) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                break;
            default:
                super.v(z9);
                break;
        }
    }

    @Override // w2.r
    public void w(boolean z9) {
        switch (this.g) {
            case 0:
                break;
            default:
                super.w(z9);
                break;
        }
    }

    private final void A0(boolean z9) {
    }

    private final void B0(boolean z9) {
    }

    private final void C0(boolean z9) {
    }

    private final void D0(boolean z9) {
    }

    private final void E0(boolean z9) {
    }

    private final void F0(boolean z9) {
    }

    private final void G0(boolean z9) {
    }

    private final void H0(boolean z9) {
    }

    private final void I0(boolean z9) {
    }

    private final void S(boolean z9) {
    }

    private final void T(boolean z9) {
    }

    private final void U(boolean z9) {
    }

    private final void V(boolean z9) {
    }

    private final void W(boolean z9) {
    }

    private final void X(boolean z9) {
    }

    private final void Y(boolean z9) {
    }

    private final void Z(boolean z9) {
    }

    private final void a0(boolean z9) {
    }

    private final void b0(boolean z9) {
    }

    private final void c0(boolean z9) {
    }

    private final void d0(boolean z9) {
    }

    private final void e0(boolean z9) {
    }

    private final void f0(boolean z9) {
    }

    private final void g0(boolean z9) {
    }

    private final void h0(boolean z9) {
    }

    private final void i0(boolean z9) {
    }

    private final void j0(boolean z9) {
    }

    private final void k0(boolean z9) {
    }

    private final void l0(boolean z9) {
    }

    private final void m0(boolean z9) {
    }

    private final void n0(boolean z9) {
    }

    private final void o0(boolean z9) {
    }

    private final void p0(boolean z9) {
    }

    private final void q0(boolean z9) {
    }

    private final void r0(boolean z9) {
    }

    private final void s0(boolean z9) {
    }

    private final void t0(boolean z9) {
    }

    private final void u0(boolean z9) {
    }

    private final void v0(boolean z9) {
    }

    private final void w0(boolean z9) {
    }

    private final void x0(boolean z9) {
    }

    private final void y0(boolean z9) {
    }

    private final void z0(boolean z9) {
    }
}
