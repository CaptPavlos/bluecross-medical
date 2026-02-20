package e5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class u0 implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7878a;

    public /* synthetic */ u0(int i10) {
        this.f7878a = i10;
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        w6.b bVar;
        switch (this.f7878a) {
            case 0:
                return Integer.valueOf(((h5.u0) obj).f8755b - ((h5.u0) obj2).f8755b);
            case 1:
                return Integer.valueOf(kotlin.jvm.internal.l.d(((h5.f) obj2).f8533n, ((h5.f) obj).f8533n));
            case 2:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                return bool;
            case 3:
                return ((w6.h) obj).plus((w6.f) obj2);
            case 4:
                return ((w6.h) obj).plus((w6.f) obj2);
            case 5:
                return Integer.valueOf(((h5.u0) obj).f8755b - ((h5.u0) obj2).f8755b);
            case 6:
                h5.f fVar = (h5.f) obj;
                h5.f fVar2 = (h5.f) obj2;
                fVar.getClass();
                fVar2.getClass();
                return Integer.valueOf(fVar.g.compareTo(fVar2.g));
            case 7:
                String str = (String) obj;
                String str2 = (String) obj2;
                str.getClass();
                str2.getClass();
                return Integer.valueOf(str.compareToIgnoreCase(str2));
            case 8:
                h5.f fVar3 = (h5.f) obj;
                h5.f fVar4 = (h5.f) obj2;
                fVar3.getClass();
                fVar4.getClass();
                return Integer.valueOf(kotlin.jvm.internal.l.d(fVar4.f8534o, fVar3.f8534o));
            case 9:
                h5.f fVar5 = (h5.f) obj;
                h5.f fVar6 = (h5.f) obj2;
                fVar5.getClass();
                fVar6.getClass();
                return Integer.valueOf(kotlin.jvm.internal.l.d(fVar6.f8534o, fVar5.f8534o));
            case 10:
                h5.f fVar7 = (h5.f) obj;
                h5.f fVar8 = (h5.f) obj2;
                fVar7.getClass();
                fVar8.getClass();
                return Integer.valueOf(kotlin.jvm.internal.l.d(fVar8.f8533n, fVar7.f8533n));
            case 11:
                return Integer.valueOf(((Integer) obj).intValue() + 1);
            case 12:
                String str3 = (String) obj;
                w6.f fVar9 = (w6.f) obj2;
                str3.getClass();
                fVar9.getClass();
                if (str3.length() == 0) {
                    return fVar9.toString();
                }
                return str3 + ", " + fVar9;
            case 13:
                w6.h hVar = (w6.h) obj;
                w6.f fVar10 = (w6.f) obj2;
                hVar.getClass();
                fVar10.getClass();
                w6.h hVarMinusKey = hVar.minusKey(fVar10.getKey());
                w6.i iVar = w6.i.f13523a;
                if (hVarMinusKey == iVar) {
                    return fVar10;
                }
                w6.d dVar = w6.d.f13522a;
                w6.e eVar = (w6.e) hVarMinusKey.get(dVar);
                if (eVar == null) {
                    bVar = new w6.b(fVar10, hVarMinusKey);
                } else {
                    w6.h hVarMinusKey2 = hVarMinusKey.minusKey(dVar);
                    if (hVarMinusKey2 == iVar) {
                        return new w6.b(eVar, fVar10);
                    }
                    bVar = new w6.b(eVar, new w6.b(fVar10, hVarMinusKey2));
                }
                return bVar;
            case 14:
                w6.f fVar11 = (w6.f) obj2;
                if (!(fVar11 instanceof w7.v)) {
                    return obj;
                }
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                int iIntValue = num != null ? num.intValue() : 1;
                return iIntValue == 0 ? fVar11 : Integer.valueOf(iIntValue + 1);
            case 15:
                w7.v vVar = (w7.v) obj;
                w6.f fVar12 = (w6.f) obj2;
                if (vVar != null) {
                    return vVar;
                }
                if (fVar12 instanceof w7.v) {
                    return (w7.v) fVar12;
                }
                return null;
            case 16:
                w7.y yVar = (w7.y) obj;
                w6.f fVar13 = (w6.f) obj2;
                if (fVar13 instanceof w7.v) {
                    w7.v vVar2 = (w7.v) fVar13;
                    w6.h hVar2 = yVar.f13564a;
                    ThreadLocal threadLocal = vVar2.f13559b;
                    Object obj3 = threadLocal.get();
                    threadLocal.set(vVar2.f13558a);
                    Object[] objArr = yVar.f13565b;
                    int i10 = yVar.f13567d;
                    objArr[i10] = obj3;
                    w7.v[] vVarArr = yVar.f13566c;
                    yVar.f13567d = i10 + 1;
                    vVarArr[i10] = vVar2;
                }
                return yVar;
            case 17:
                ((u4.e) obj).getClass();
                ((u4.e) obj2).getClass();
                return Integer.valueOf(Boolean.compare(!r4.f12905b, !r5.f12905b));
            default:
                ((u4.e) obj).getClass();
                ((u4.e) obj2).getClass();
                return Integer.valueOf(Boolean.compare(!r4.f12905b, !r5.f12905b));
        }
    }
}
