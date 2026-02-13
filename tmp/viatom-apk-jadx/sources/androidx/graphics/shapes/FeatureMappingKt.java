package androidx.graphics.shapes;

import androidx.graphics.shapes.Feature;
import com.google.android.gms.internal.measurement.a4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import l7.c;
import l7.d;
import s6.i;
import t6.l;
import t6.m;
import t6.x;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class FeatureMappingKt {
    private static final String LOG_TAG = "FeatureMapping";

    public static final List<ProgressableFeature> doMapping(List<ProgressableFeature> list, List<ProgressableFeature> list2) {
        list.getClass();
        list2.getClass();
        Iterator it = new d(0, list2.size() - 1, 1).iterator();
        c cVar = (c) it;
        if (!cVar.f11089c) {
            com.google.gson.internal.a.b();
            return null;
        }
        x xVar = (x) it;
        int iNextInt = xVar.nextInt();
        if (cVar.f11089c) {
            float fFeatureDistSquared = featureDistSquared(list.get(0).getFeature(), list2.get(iNextInt).getFeature());
            do {
                int iNextInt2 = xVar.nextInt();
                float fFeatureDistSquared2 = featureDistSquared(list.get(0).getFeature(), list2.get(iNextInt2).getFeature());
                if (Float.compare(fFeatureDistSquared, fFeatureDistSquared2) > 0) {
                    iNextInt = iNextInt2;
                    fFeatureDistSquared = fFeatureDistSquared2;
                }
            } while (cVar.f11089c);
        }
        int size = list.size();
        int size2 = list2.size();
        ArrayList arrayListR = m.R(list2.get(iNextInt));
        int i10 = iNextInt;
        for (int i11 = 1; i11 < size; i11++) {
            int i12 = iNextInt - (size - i11);
            if (i12 <= i10) {
                i12 += size2;
            }
            Iterator it2 = new d(i10 + 1, i12, 1).iterator();
            c cVar2 = (c) it2;
            if (!cVar2.f11089c) {
                com.google.gson.internal.a.b();
                return null;
            }
            x xVar2 = (x) it2;
            int iNextInt3 = xVar2.nextInt();
            if (cVar2.f11089c) {
                float fFeatureDistSquared3 = featureDistSquared(list.get(i11).getFeature(), list2.get(iNextInt3 % size2).getFeature());
                do {
                    int iNextInt4 = xVar2.nextInt();
                    float fFeatureDistSquared4 = featureDistSquared(list.get(i11).getFeature(), list2.get(iNextInt4 % size2).getFeature());
                    if (Float.compare(fFeatureDistSquared3, fFeatureDistSquared4) > 0) {
                        iNextInt3 = iNextInt4;
                        fFeatureDistSquared3 = fFeatureDistSquared4;
                    }
                } while (cVar2.f11089c);
            }
            i10 = iNextInt3;
            arrayListR.add(list2.get(i10 % size2));
        }
        return arrayListR;
    }

    public static final float featureDistSquared(Feature feature, Feature feature2) {
        feature.getClass();
        feature2.getClass();
        if ((feature instanceof Feature.Corner) && (feature2 instanceof Feature.Corner) && ((Feature.Corner) feature).getConvex() != ((Feature.Corner) feature2).getConvex()) {
            return Float.MAX_VALUE;
        }
        float anchor1X = (((Cubic) l.i0(feature.getCubics())).getAnchor1X() + ((Cubic) l.c0(feature.getCubics())).getAnchor0X()) / 2.0f;
        float anchor1Y = (((Cubic) l.i0(feature.getCubics())).getAnchor1Y() + ((Cubic) l.c0(feature.getCubics())).getAnchor0Y()) / 2.0f;
        float anchor1X2 = (((Cubic) l.i0(feature2.getCubics())).getAnchor1X() + ((Cubic) l.c0(feature2.getCubics())).getAnchor0X()) / 2.0f;
        float f = anchor1X - anchor1X2;
        float anchor1Y2 = anchor1Y - ((((Cubic) l.i0(feature2.getCubics())).getAnchor1Y() + ((Cubic) l.c0(feature2.getCubics())).getAnchor0Y()) / 2.0f);
        return (anchor1Y2 * anchor1Y2) + (f * f);
    }

    public static final DoubleMapper featureMapper(List<ProgressableFeature> list, List<ProgressableFeature> list2) {
        list.getClass();
        list2.getClass();
        u6.c cVarL = a4.l();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (list.get(i10).getFeature() instanceof Feature.Corner) {
                cVarL.add(list.get(i10));
            }
        }
        u6.c cVarH = a4.h(cVarL);
        u6.c cVarL2 = a4.l();
        int size2 = list2.size();
        for (int i11 = 0; i11 < size2; i11++) {
            if (list2.get(i11).getFeature() instanceof Feature.Corner) {
                cVarL2.add(list2.get(i11));
            }
        }
        u6.c cVarH2 = a4.h(cVarL2);
        i iVar = cVarH.c() > cVarH2.c() ? new i(doMapping(cVarH2, cVarH), cVarH2) : new i(cVarH, doMapping(cVarH, cVarH2));
        List list3 = (List) iVar.f12693a;
        List list4 = (List) iVar.f12694b;
        u6.c cVarL3 = a4.l();
        int size3 = list3.size();
        for (int i12 = 0; i12 < size3 && i12 != list4.size(); i12++) {
            cVarL3.add(new i(Float.valueOf(((ProgressableFeature) list3.get(i12)).getProgress()), Float.valueOf(((ProgressableFeature) list4.get(i12)).getProgress())));
        }
        i[] iVarArr = (i[]) a4.h(cVarL3).toArray(new i[0]);
        return new DoubleMapper((i[]) Arrays.copyOf(iVarArr, iVarArr.length));
    }
}
