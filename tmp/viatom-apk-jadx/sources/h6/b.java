package h6;

import com.google.android.gms.internal.measurement.l5;
import f6.g;
import g7.p;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.x;
import s6.w;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends m implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8808a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x f8809b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(x xVar, int i10) {
        super(2);
        this.f8808a = i10;
        this.f8809b = xVar;
    }

    /* JADX WARN: Type inference failed for: r10v5, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r4v12, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object, java.util.Map] */
    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        int i10 = this.f8808a;
        w wVar = w.f12711a;
        x xVar = this.f8809b;
        switch (i10) {
            case 0:
                int iIntValue = ((Number) obj).intValue();
                boolean zBooleanValue = ((Boolean) obj2).booleanValue();
                if (iIntValue > 0 && iIntValue <= o7.m.g0((CharSequence) xVar.f10138a) + 1) {
                    StringBuilder sb = new StringBuilder((String) xVar.f10138a);
                    sb.setCharAt(iIntValue - 1, zBooleanValue ? '1' : '0');
                    xVar.f10138a = sb.toString();
                    break;
                }
                break;
            default:
                String str = (String) obj;
                Set set = (Set) obj2;
                str.getClass();
                set.getClass();
                g gVarA = t1.a(str);
                String str2 = (String) xVar.f10138a;
                Integer numValueOf = Integer.valueOf(gVarA.f8079a);
                Object obj3 = c.f8810a;
                ?? r52 = c.f8811b;
                Integer num = (Integer) r52.get(d.g);
                String strG = l.g(l5.c(numValueOf, num == null ? 0 : num.intValue()), str2);
                xVar.f10138a = strG;
                Integer numValueOf2 = Integer.valueOf(gVarA.f8080b.f8088a);
                Integer num2 = (Integer) r52.get(d.h);
                xVar.f10138a = l.g(l5.c(numValueOf2, num2 == null ? 0 : num2.intValue()), strG);
                List listM0 = t6.l.m0(set);
                int size = listM0.size();
                String strG2 = "";
                int i11 = 0;
                int i12 = 0;
                int i13 = 0;
                while (i11 < size) {
                    int i14 = i11 + 1;
                    int iIntValue2 = ((Number) listM0.get(i11)).intValue();
                    if (i13 == 0) {
                        i12++;
                        i13 = iIntValue2;
                    }
                    if (i11 == listM0.size() - 1 || ((Number) listM0.get(i14)).intValue() > iIntValue2 + 1) {
                        boolean z9 = iIntValue2 != i13;
                        String strG3 = l.g(z9 ? "1" : "0", strG2);
                        Integer numValueOf3 = Integer.valueOf(i13);
                        Object obj4 = c.f8810a;
                        ?? r10 = c.f8811b;
                        d dVar = d.f8819k;
                        Integer num3 = (Integer) r10.get(dVar);
                        strG2 = l.g(l5.c(numValueOf3, num3 == null ? 0 : num3.intValue()), strG3);
                        if (z9) {
                            Integer numValueOf4 = Integer.valueOf(iIntValue2);
                            Integer num4 = (Integer) r10.get(dVar);
                            strG2 = l.g(l5.c(numValueOf4, num4 == null ? 0 : num4.intValue()), strG2);
                        }
                        i13 = 0;
                    }
                    i11 = i14;
                }
                String str3 = (String) xVar.f10138a;
                Integer numValueOf5 = Integer.valueOf(i12);
                Object obj5 = c.f8810a;
                Integer num5 = (Integer) c.f8811b.get(d.e);
                String strG4 = l.g(l5.c(numValueOf5, num5 != null ? num5.intValue() : 0), str3);
                xVar.f10138a = strG4;
                xVar.f10138a = l.g(strG2, strG4);
                break;
        }
        return wVar;
    }
}
