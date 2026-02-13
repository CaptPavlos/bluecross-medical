package f6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l extends kotlin.jvm.internal.m implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8095a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f8096b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(m mVar, int i10) {
        super(2);
        this.f8095a = i10;
        this.f8096b = mVar;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object, java.util.List] */
    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        LinkedHashMap linkedHashMap;
        LinkedHashMap linkedHashMap2;
        LinkedHashMap linkedHashMap3;
        LinkedHashMap linkedHashMap4;
        switch (this.f8095a) {
            case 0:
                int iIntValue = ((Number) obj).intValue();
                ((Boolean) obj2).getClass();
                o8.i iVarH = i9.a.h();
                ?? r02 = iVarH.f11815c.f11810a;
                ArrayList arrayList = new ArrayList();
                for (Object obj3 : r02) {
                    if (iIntValue == ((o8.g) obj3).f11806a) {
                        arrayList.add(obj3);
                    }
                }
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj4 = arrayList.get(i10);
                    i10++;
                    ?? r52 = iVarH.f11814b.h;
                    ArrayList arrayList2 = ((o8.g) obj4).f;
                    if (!arrayList2.isEmpty()) {
                        int size2 = arrayList2.size();
                        int i11 = 0;
                        while (true) {
                            if (i11 < size2) {
                                Object obj5 = arrayList2.get(i11);
                                i11++;
                                if (r52.contains(Integer.valueOf(((Number) obj5).intValue()))) {
                                    this.f8096b.A.set(iIntValue);
                                }
                            }
                        }
                    }
                }
                break;
            case 1:
                int iIntValue2 = ((Number) obj).intValue();
                ((Boolean) obj2).getClass();
                m mVar = this.f8096b;
                k8.c cVar = mVar.f8097a;
                k8.h hVar = (cVar == null || (linkedHashMap = cVar.h) == null) ? null : (k8.h) linkedHashMap.get(String.valueOf(iIntValue2));
                if (hVar != null && m.c(hVar)) {
                    mVar.f8116z.set(iIntValue2);
                }
                break;
            case 2:
                int iIntValue3 = ((Number) obj).intValue();
                ((Boolean) obj2).getClass();
                m mVar2 = this.f8096b;
                k8.c cVar2 = mVar2.f8097a;
                k8.h hVar2 = (cVar2 == null || (linkedHashMap2 = cVar2.h) == null) ? null : (k8.h) linkedHashMap2.get(String.valueOf(iIntValue3));
                if (hVar2 != null && m.b(mVar2, hVar2)) {
                    mVar2.C.set(iIntValue3);
                }
                break;
            case 3:
                int iIntValue4 = ((Number) obj).intValue();
                ((Boolean) obj2).getClass();
                m mVar3 = this.f8096b;
                k8.c cVar3 = mVar3.f8097a;
                k8.h hVar3 = (cVar3 == null || (linkedHashMap3 = cVar3.h) == null) ? null : (k8.h) linkedHashMap3.get(String.valueOf(iIntValue4));
                if (hVar3 != null && !m.c(hVar3) && !m.b(mVar3, hVar3)) {
                    ?? r12 = i9.a.h().f11814b.f11785l;
                    Set set = hVar3.g;
                    if (set == null || !set.isEmpty()) {
                        Iterator it = set.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (r12.contains(Integer.valueOf(((Number) it.next()).intValue()))) {
                                    mVar3.C.set(iIntValue4);
                                }
                            }
                        }
                    }
                }
                break;
            default:
                int iIntValue5 = ((Number) obj).intValue();
                ((Boolean) obj2).getClass();
                m mVar4 = this.f8096b;
                k8.c cVar4 = mVar4.f8097a;
                k8.h hVar4 = (cVar4 == null || (linkedHashMap4 = cVar4.h) == null) ? null : (k8.h) linkedHashMap4.get(String.valueOf(iIntValue5));
                if (hVar4 != null && m.c(hVar4)) {
                    mVar4.f8116z.unset(iIntValue5);
                }
                break;
        }
        return w.f12711a;
    }
}
