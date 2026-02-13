package androidx.graphics.shapes;

import androidx.annotation.IntRange;
import androidx.collection.FloatFloatPair;
import androidx.collection.MutableFloatList;
import androidx.graphics.shapes.Feature;
import com.google.android.gms.internal.measurement.a4;
import com.google.android.gms.internal.measurement.l5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l7.d;
import s6.i;
import t6.l;
import t6.n;
import t6.x;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class RoundedPolygonKt {
    public static final RoundedPolygon RoundedPolygon(float[] fArr, CornerRounding cornerRounding, List<CornerRounding> list, float f, float f10) {
        CornerRounding cornerRounding2;
        Float fValueOf = Float.valueOf(1.0f);
        fArr.getClass();
        cornerRounding.getClass();
        if (fArr.length < 6) {
            com.google.gson.internal.a.n("Polygons must have at least 3 vertices");
            return null;
        }
        int i10 = 2;
        int i11 = 1;
        if (fArr.length % 2 == 1) {
            com.google.gson.internal.a.n("The vertices array should have even size");
            return null;
        }
        if (list != null && list.size() * 2 != fArr.length) {
            com.google.gson.internal.a.n("perVertexRounding list should be either null or the same size as the number of vertices (vertices.size / 2)");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int length = fArr.length / 2;
        ArrayList arrayList2 = new ArrayList();
        int i12 = 0;
        int i13 = 0;
        while (i13 < length) {
            CornerRounding cornerRounding3 = (list == null || (cornerRounding2 = list.get(i13)) == null) ? cornerRounding : cornerRounding2;
            int i14 = (((i13 + length) - 1) % length) * 2;
            int i15 = i13 + 1;
            int i16 = (i15 % length) * 2;
            int i17 = i13 * 2;
            arrayList2.add(new RoundedCorner(FloatFloatPair.m9constructorimpl(fArr[i14], fArr[i14 + 1]), FloatFloatPair.m9constructorimpl(fArr[i17], fArr[i17 + 1]), FloatFloatPair.m9constructorimpl(fArr[i16], fArr[i16 + 1]), cornerRounding3, null));
            i13 = i15;
        }
        d dVarN = l5.N(0, length);
        ArrayList arrayList3 = new ArrayList(n.V(dVarN, 10));
        Iterator it = dVarN.iterator();
        while (it.hasNext()) {
            int iNextInt = ((x) it).nextInt();
            int i18 = (iNextInt + 1) % length;
            float expectedRoundCut = ((RoundedCorner) arrayList2.get(iNextInt)).getExpectedRoundCut() + ((RoundedCorner) arrayList2.get(i18)).getExpectedRoundCut();
            float expectedCut = ((RoundedCorner) arrayList2.get(iNextInt)).getExpectedCut() + ((RoundedCorner) arrayList2.get(i18)).getExpectedCut();
            int i19 = iNextInt * 2;
            int i20 = i18 * 2;
            float fDistance = Utils.distance(fArr[i19] - fArr[i20], fArr[i19 + 1] - fArr[i20 + 1]);
            arrayList3.add(expectedRoundCut > fDistance ? new i(Float.valueOf(fDistance / expectedRoundCut), Float.valueOf(0.0f)) : expectedCut > fDistance ? new i(fValueOf, Float.valueOf((fDistance - expectedRoundCut) / (expectedCut - expectedRoundCut))) : new i(fValueOf, fValueOf));
        }
        for (int i21 = 0; i21 < length; i21++) {
            MutableFloatList mutableFloatList = new MutableFloatList(2);
            for (int i22 = 0; i22 < 2; i22++) {
                i iVar = (i) arrayList3.get((((i21 + length) - 1) + i22) % length);
                mutableFloatList.add(((((RoundedCorner) arrayList2.get(i21)).getExpectedCut() - ((RoundedCorner) arrayList2.get(i21)).getExpectedRoundCut()) * ((Number) iVar.f12694b).floatValue()) + (((RoundedCorner) arrayList2.get(i21)).getExpectedRoundCut() * ((Number) iVar.f12693a).floatValue()));
            }
            arrayList.add(((RoundedCorner) arrayList2.get(i21)).getCubics(mutableFloatList.get(0), mutableFloatList.get(1)));
        }
        ArrayList arrayList4 = new ArrayList();
        while (i12 < length) {
            int i23 = i12 + 1;
            int i24 = i23 % length;
            int i25 = i12 * 2;
            long jM9constructorimpl = FloatFloatPair.m9constructorimpl(fArr[i25], fArr[i25 + i11]);
            int i26 = (((i12 + length) - i11) % length) * i10;
            long jM9constructorimpl2 = FloatFloatPair.m9constructorimpl(fArr[i26], fArr[i26 + i11]);
            int i27 = i24 * 2;
            arrayList4.add(new Feature.Corner((List) arrayList.get(i12), jM9constructorimpl, ((RoundedCorner) arrayList2.get(i12)).m71getCenter1ufDz9w(), PointKt.m50clockwiseybeJwSQ(PointKt.m62minusybeJwSQ(jM9constructorimpl, jM9constructorimpl2), PointKt.m62minusybeJwSQ(FloatFloatPair.m9constructorimpl(fArr[i27], fArr[i27 + i11]), jM9constructorimpl)), null));
            arrayList4.add(new Feature.Edge(a4.u(Cubic.Companion.straightLine(((Cubic) l.i0((List) arrayList.get(i12))).getAnchor1X(), ((Cubic) l.i0((List) arrayList.get(i12))).getAnchor1Y(), ((Cubic) l.c0((List) arrayList.get(i24))).getAnchor0X(), ((Cubic) l.c0((List) arrayList.get(i24))).getAnchor0Y()))));
            i12 = i23;
            i10 = 2;
            i11 = 1;
        }
        long jCalculateCenter = (f == Float.MIN_VALUE || f10 == Float.MIN_VALUE) ? calculateCenter(fArr) : FloatFloatPair.m9constructorimpl(f, f10);
        return new RoundedPolygon(arrayList4, Float.intBitsToFloat((int) (jCalculateCenter >> 32)), Float.intBitsToFloat((int) (jCalculateCenter & 4294967295L)));
    }

    public static /* synthetic */ RoundedPolygon RoundedPolygon$default(int i10, float f, float f10, float f11, CornerRounding cornerRounding, List list, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            f = 1.0f;
        }
        if ((i11 & 4) != 0) {
            f10 = 0.0f;
        }
        if ((i11 & 8) != 0) {
            f11 = 0.0f;
        }
        if ((i11 & 16) != 0) {
            cornerRounding = CornerRounding.Unrounded;
        }
        if ((i11 & 32) != 0) {
            list = null;
        }
        List list2 = list;
        return RoundedPolygon(i10, f, f10, f11, cornerRounding, list2);
    }

    private static final long calculateCenter(float[] fArr) {
        float f = 0.0f;
        int i10 = 0;
        float f10 = 0.0f;
        while (i10 < fArr.length) {
            int i11 = i10 + 1;
            f += fArr[i10];
            i10 += 2;
            f10 += fArr[i11];
        }
        float f11 = 2;
        return FloatFloatPair.m9constructorimpl((f / fArr.length) / f11, (f10 / fArr.length) / f11);
    }

    private static final float[] verticesFromNumVerts(int i10, float f, float f10, float f11) {
        float[] fArr = new float[i10 * 2];
        int i11 = 0;
        int i12 = 0;
        while (i11 < i10) {
            float f12 = f;
            long jM63plusybeJwSQ = PointKt.m63plusybeJwSQ(Utils.m79radialToCartesianL6JJ3z0$default(f12, (Utils.getFloatPi() / i10) * 2 * i11, 0L, 4, null), FloatFloatPair.m9constructorimpl(f10, f11));
            int i13 = i12 + 1;
            fArr[i12] = PointKt.m59getXDnnuFBc(jM63plusybeJwSQ);
            i12 += 2;
            fArr[i13] = PointKt.m60getYDnnuFBc(jM63plusybeJwSQ);
            i11++;
            f = f12;
        }
        return fArr;
    }

    public static /* synthetic */ RoundedPolygon RoundedPolygon$default(float[] fArr, CornerRounding cornerRounding, List list, float f, float f10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            cornerRounding = CornerRounding.Unrounded;
        }
        if ((i10 & 4) != 0) {
            list = null;
        }
        if ((i10 & 8) != 0) {
            f = Float.MIN_VALUE;
        }
        if ((i10 & 16) != 0) {
            f10 = Float.MIN_VALUE;
        }
        return RoundedPolygon(fArr, cornerRounding, (List<CornerRounding>) list, f, f10);
    }

    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i10, float f) {
        return RoundedPolygon$default(i10, f, 0.0f, 0.0f, null, null, 60, null);
    }

    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i10, float f, float f10) {
        return RoundedPolygon$default(i10, f, f10, 0.0f, null, null, 56, null);
    }

    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i10, float f, float f10, float f11) {
        return RoundedPolygon$default(i10, f, f10, f11, null, null, 48, null);
    }

    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i10, float f, float f10, float f11, CornerRounding cornerRounding) {
        cornerRounding.getClass();
        return RoundedPolygon$default(i10, f, f10, f11, cornerRounding, null, 32, null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] fArr) {
        fArr.getClass();
        return RoundedPolygon$default(fArr, null, null, 0.0f, 0.0f, 30, null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] fArr, CornerRounding cornerRounding) {
        fArr.getClass();
        cornerRounding.getClass();
        return RoundedPolygon$default(fArr, cornerRounding, null, 0.0f, 0.0f, 28, null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] fArr, CornerRounding cornerRounding, List<CornerRounding> list) {
        fArr.getClass();
        cornerRounding.getClass();
        return RoundedPolygon$default(fArr, cornerRounding, list, 0.0f, 0.0f, 24, null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] fArr, CornerRounding cornerRounding, List<CornerRounding> list, float f) {
        fArr.getClass();
        cornerRounding.getClass();
        return RoundedPolygon$default(fArr, cornerRounding, list, f, 0.0f, 16, null);
    }

    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i10, float f, float f10, float f11, CornerRounding cornerRounding, List<CornerRounding> list) {
        cornerRounding.getClass();
        return RoundedPolygon(verticesFromNumVerts(i10, f, f10, f11), cornerRounding, list, f10, f11);
    }

    public static final RoundedPolygon RoundedPolygon(RoundedPolygon roundedPolygon) {
        roundedPolygon.getClass();
        return new RoundedPolygon(roundedPolygon.getFeatures$graphics_shapes_release(), roundedPolygon.getCenterX(), roundedPolygon.getCenterY());
    }

    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i10) {
        return RoundedPolygon$default(i10, 0.0f, 0.0f, 0.0f, null, null, 62, null);
    }
}
