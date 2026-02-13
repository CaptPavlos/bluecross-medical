package m3;

import j$.util.function.Predicate$CC;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class i implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11188a;

    public /* synthetic */ Predicate and(Predicate predicate) {
        int i10 = this.f11188a;
        return Predicate$CC.$default$and(this, predicate);
    }

    public /* synthetic */ Predicate negate() {
        switch (this.f11188a) {
        }
        return Predicate$CC.$default$negate(this);
    }

    public /* synthetic */ Predicate or(Predicate predicate) {
        int i10 = this.f11188a;
        return Predicate$CC.$default$or(this, predicate);
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f11188a) {
            case 0:
                break;
            case 1:
                Integer num = (Integer) obj;
                if (num.intValue() < 0 || num.intValue() > 2) {
                }
                break;
            case 2:
                Integer num2 = (Integer) obj;
                if (num2.intValue() < 1 || num2.intValue() > 2) {
                }
                break;
            case 3:
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    int iIntValue = ((Integer) it.next()).intValue();
                    if (iIntValue < 0 || iIntValue > 2) {
                        break;
                    }
                }
                break;
            case 4:
                Integer num3 = (Integer) obj;
                if (num3.intValue() < 0 || num3.intValue() > 2) {
                }
                break;
            case 5:
                Integer num4 = (Integer) obj;
                if (num4.intValue() < 1 || num4.intValue() > 2) {
                }
                break;
            case 6:
                Iterator it2 = ((List) obj).iterator();
                while (it2.hasNext()) {
                    int iIntValue2 = ((Integer) it2.next()).intValue();
                    if (iIntValue2 < 0 || iIntValue2 > 2) {
                        break;
                    }
                }
                break;
            case 7:
                Integer num5 = (Integer) obj;
                if (num5.intValue() < 0 || num5.intValue() > 2) {
                }
                break;
            case 8:
                Integer num6 = (Integer) obj;
                if (num6.intValue() < 1 || num6.intValue() > 2) {
                }
                break;
            case 9:
                Iterator it3 = ((List) obj).iterator();
                while (it3.hasNext()) {
                    int iIntValue3 = ((Integer) it3.next()).intValue();
                    if (iIntValue3 < 0 || iIntValue3 > 2) {
                        break;
                    }
                }
                break;
            case 10:
                Integer num7 = (Integer) obj;
                if (num7.intValue() < 0 || num7.intValue() > 2) {
                }
                break;
            case 11:
                Integer num8 = (Integer) obj;
                if (num8.intValue() < 1 || num8.intValue() > 2) {
                }
                break;
            case 12:
                Iterator it4 = ((List) obj).iterator();
                while (it4.hasNext()) {
                    int iIntValue4 = ((Integer) it4.next()).intValue();
                    if (iIntValue4 < 0 || iIntValue4 > 2) {
                        break;
                    }
                }
                break;
            case 13:
                Integer num9 = (Integer) obj;
                if (num9.intValue() < 0 || num9.intValue() > 2) {
                }
                break;
            case 14:
                Integer num10 = (Integer) obj;
                if (num10.intValue() < 1 || num10.intValue() > 2) {
                }
                break;
            case 15:
                Iterator it5 = ((List) obj).iterator();
                while (it5.hasNext()) {
                    int iIntValue5 = ((Integer) it5.next()).intValue();
                    if (iIntValue5 < 0 || iIntValue5 > 2) {
                        break;
                    }
                }
                break;
            case 16:
                Integer num11 = (Integer) obj;
                if (num11.intValue() < 0 || num11.intValue() > 2) {
                }
                break;
            case 17:
                Integer num12 = (Integer) obj;
                if (num12.intValue() < 1 || num12.intValue() > 2) {
                }
                break;
            case 18:
                Iterator it6 = ((List) obj).iterator();
                while (it6.hasNext()) {
                    int iIntValue6 = ((Integer) it6.next()).intValue();
                    if (iIntValue6 < 0 || iIntValue6 > 2) {
                        break;
                    }
                }
                break;
            case 19:
                Integer num13 = (Integer) obj;
                if (num13.intValue() < 0 || num13.intValue() > 2) {
                }
                break;
            case 20:
                Integer num14 = (Integer) obj;
                if (num14.intValue() < 1 || num14.intValue() > 2) {
                }
                break;
            case 21:
                Iterator it7 = ((List) obj).iterator();
                while (it7.hasNext()) {
                    int iIntValue7 = ((Integer) it7.next()).intValue();
                    if (iIntValue7 < 0 || iIntValue7 > 2) {
                        break;
                    }
                }
                break;
            case 22:
                Integer num15 = (Integer) obj;
                if (num15.intValue() < 0 || num15.intValue() > 2) {
                }
                break;
            case 23:
                Integer num16 = (Integer) obj;
                if (num16.intValue() < 1 || num16.intValue() > 2) {
                }
                break;
            case 24:
                Iterator it8 = ((List) obj).iterator();
                while (it8.hasNext()) {
                    int iIntValue8 = ((Integer) it8.next()).intValue();
                    if (iIntValue8 < 0 || iIntValue8 > 2) {
                        break;
                    }
                }
                break;
            case 25:
                Integer num17 = (Integer) obj;
                if (num17.intValue() < 0 || num17.intValue() > 2) {
                }
                break;
            case 26:
                Integer num18 = (Integer) obj;
                if (num18.intValue() < 1 || num18.intValue() > 2) {
                }
                break;
            case 27:
                Iterator it9 = ((List) obj).iterator();
                while (it9.hasNext()) {
                    int iIntValue9 = ((Integer) it9.next()).intValue();
                    if (iIntValue9 < 0 || iIntValue9 > 2) {
                        break;
                    }
                }
                break;
            case 28:
                Integer num19 = (Integer) obj;
                if (num19.intValue() < 0 || num19.intValue() > 2) {
                }
                break;
            default:
                Integer num20 = (Integer) obj;
                if (num20.intValue() < 1 || num20.intValue() > 2) {
                }
                break;
        }
        return true;
    }
}
