package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import com.google.android.gms.internal.measurement.a4;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import s6.i;
import t6.m;
import u6.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class RoundedPolygon {
    public static final Companion Companion = new Companion(null);
    private final float centerX;
    private final float centerY;
    private final List<Cubic> cubics;
    private final List<Feature> features;

    /* JADX WARN: Multi-variable type inference failed */
    public RoundedPolygon(List<? extends Feature> list, float f, float f10) {
        ArrayList arrayListR;
        ArrayList arrayListR2;
        Cubic cubic;
        List<Cubic> cubics;
        list.getClass();
        this.features = list;
        this.centerX = f;
        this.centerY = f10;
        c cVarL = a4.l();
        int i10 = 0;
        Cubic cubic2 = null;
        if (list.size() <= 0 || ((Feature) list.get(0)).getCubics().size() != 3) {
            arrayListR = null;
            arrayListR2 = null;
        } else {
            i iVarSplit = ((Feature) list.get(0)).getCubics().get(1).split(0.5f);
            Cubic cubic3 = (Cubic) iVarSplit.f12693a;
            Cubic cubic4 = (Cubic) iVarSplit.f12694b;
            arrayListR2 = m.R(((Feature) list.get(0)).getCubics().get(0), cubic3);
            arrayListR = m.R(cubic4, ((Feature) list.get(0)).getCubics().get(2));
        }
        int size = list.size();
        if (size >= 0) {
            int i11 = 0;
            Cubic cubic5 = null;
            while (true) {
                if (i11 == 0 && arrayListR != null) {
                    cubics = arrayListR;
                } else if (i11 != this.features.size()) {
                    cubics = this.features.get(i11).getCubics();
                } else if (arrayListR2 == null) {
                    break;
                } else {
                    cubics = arrayListR2;
                }
                int size2 = cubics.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    Cubic cubic6 = cubics.get(i12);
                    if (!cubic6.zeroLength$graphics_shapes_release()) {
                        if (cubic5 != null) {
                            cVarL.add(cubic5);
                        }
                        if (cubic2 == null) {
                            cubic2 = cubic6;
                            cubic5 = cubic2;
                        } else {
                            cubic5 = cubic6;
                        }
                    } else if (cubic5 != null) {
                        cubic5.getPoints$graphics_shapes_release()[6] = cubic6.getAnchor1X();
                        cubic5.getPoints$graphics_shapes_release()[7] = cubic6.getAnchor1Y();
                    }
                }
                if (i11 == size) {
                    break;
                } else {
                    i11++;
                }
            }
            cubic = cubic2;
            cubic2 = cubic5;
        } else {
            cubic = null;
        }
        if (cubic2 != null && cubic != null) {
            cVarL.add(CubicKt.Cubic(cubic2.getAnchor0X(), cubic2.getAnchor0Y(), cubic2.getControl0X(), cubic2.getControl0Y(), cubic2.getControl1X(), cubic2.getControl1Y(), cubic.getAnchor0X(), cubic.getAnchor0Y()));
        }
        c cVarH = a4.h(cVarL);
        this.cubics = cVarH;
        Object obj = cVarH.get(cVarH.c() - 1);
        int iC = cVarH.c();
        while (i10 < iC) {
            Cubic cubic7 = this.cubics.get(i10);
            Cubic cubic8 = (Cubic) obj;
            if (Math.abs(cubic7.getAnchor0X() - cubic8.getAnchor1X()) > 1.0E-4f || Math.abs(cubic7.getAnchor0Y() - cubic8.getAnchor1Y()) > 1.0E-4f) {
                com.google.gson.internal.a.n("RoundedPolygon must be contiguous, with the anchor points of all curves matching the anchor points of the preceding and succeeding cubics");
                throw null;
            }
            i10++;
            obj = cubic7;
        }
    }

    public static /* synthetic */ float[] calculateBounds$default(RoundedPolygon roundedPolygon, float[] fArr, boolean z9, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            fArr = new float[4];
        }
        if ((i10 & 2) != 0) {
            z9 = true;
        }
        return roundedPolygon.calculateBounds(fArr, z9);
    }

    public static /* synthetic */ float[] calculateMaxBounds$default(RoundedPolygon roundedPolygon, float[] fArr, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            fArr = new float[4];
        }
        return roundedPolygon.calculateMaxBounds(fArr);
    }

    public final float[] calculateBounds(float[] fArr, boolean z9) {
        fArr.getClass();
        if (fArr.length < 4) {
            com.google.gson.internal.a.n("Required bounds size of 4");
            return null;
        }
        int size = this.cubics.size();
        float fMax = Float.MIN_VALUE;
        float fMin = Float.MAX_VALUE;
        float fMin2 = Float.MAX_VALUE;
        float fMax2 = Float.MIN_VALUE;
        for (int i10 = 0; i10 < size; i10++) {
            this.cubics.get(i10).calculateBounds$graphics_shapes_release(fArr, z9);
            fMin = Math.min(fMin, fArr[0]);
            fMin2 = Math.min(fMin2, fArr[1]);
            fMax = Math.max(fMax, fArr[2]);
            fMax2 = Math.max(fMax2, fArr[3]);
        }
        fArr[0] = fMin;
        fArr[1] = fMin2;
        fArr[2] = fMax;
        fArr[3] = fMax2;
        return fArr;
    }

    public final float[] calculateMaxBounds(float[] fArr) {
        fArr.getClass();
        if (fArr.length < 4) {
            com.google.gson.internal.a.n("Required bounds size of 4");
            return null;
        }
        int size = this.cubics.size();
        float fMax = 0.0f;
        for (int i10 = 0; i10 < size; i10++) {
            Cubic cubic = this.cubics.get(i10);
            float fDistanceSquared = Utils.distanceSquared(cubic.getAnchor0X() - this.centerX, cubic.getAnchor0Y() - this.centerY);
            long jM47pointOnCurveOOQOV4g$graphics_shapes_release = cubic.m47pointOnCurveOOQOV4g$graphics_shapes_release(0.5f);
            fMax = Math.max(fMax, Math.max(fDistanceSquared, Utils.distanceSquared(PointKt.m59getXDnnuFBc(jM47pointOnCurveOOQOV4g$graphics_shapes_release) - this.centerX, PointKt.m60getYDnnuFBc(jM47pointOnCurveOOQOV4g$graphics_shapes_release) - this.centerY)));
        }
        float fSqrt = (float) Math.sqrt(fMax);
        float f = this.centerX;
        fArr[0] = f - fSqrt;
        float f10 = this.centerY;
        fArr[1] = f10 - fSqrt;
        fArr[2] = f + fSqrt;
        fArr[3] = f10 + fSqrt;
        return fArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RoundedPolygon) {
            return l.a(this.features, ((RoundedPolygon) obj).features);
        }
        return false;
    }

    public final float getCenterX() {
        return this.centerX;
    }

    public final float getCenterY() {
        return this.centerY;
    }

    public final List<Cubic> getCubics() {
        return this.cubics;
    }

    public final List<Feature> getFeatures$graphics_shapes_release() {
        return this.features;
    }

    public int hashCode() {
        return this.features.hashCode();
    }

    public final RoundedPolygon normalized() {
        float[] fArrCalculateBounds$default = calculateBounds$default(this, null, false, 3, null);
        float f = fArrCalculateBounds$default[2] - fArrCalculateBounds$default[0];
        float f10 = fArrCalculateBounds$default[3] - fArrCalculateBounds$default[1];
        final float fMax = Math.max(f, f10);
        float f11 = 2;
        final float f12 = ((fMax - f) / f11) - fArrCalculateBounds$default[0];
        final float f13 = ((fMax - f10) / f11) - fArrCalculateBounds$default[1];
        return transformed(new PointTransformer() { // from class: androidx.graphics.shapes.RoundedPolygon.normalized.1
            @Override // androidx.graphics.shapes.PointTransformer
            /* renamed from: transform-XgqJiTY */
            public final long mo68transformXgqJiTY(float f14, float f15) {
                float f16 = f14 + f12;
                float f17 = fMax;
                return FloatFloatPair.m9constructorimpl(f16 / f17, (f15 + f13) / f17);
            }
        });
    }

    public String toString() {
        return "[RoundedPolygon. Cubics = " + t6.l.h0(this.cubics, null, null, null, null, 63) + " || Features = " + t6.l.h0(this.features, null, null, null, null, 63) + " || Center = (" + this.centerX + ", " + this.centerY + ")]";
    }

    public final RoundedPolygon transformed(PointTransformer pointTransformer) {
        pointTransformer.getClass();
        long jM66transformedso9K2fw = PointKt.m66transformedso9K2fw(FloatFloatPair.m9constructorimpl(this.centerX, this.centerY), pointTransformer);
        c cVarL = a4.l();
        int size = this.features.size();
        for (int i10 = 0; i10 < size; i10++) {
            cVarL.add(this.features.get(i10).transformed$graphics_shapes_release(pointTransformer));
        }
        return new RoundedPolygon(a4.h(cVarL), PointKt.m59getXDnnuFBc(jM66transformedso9K2fw), PointKt.m60getYDnnuFBc(jM66transformedso9K2fw));
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }
    }

    public final float[] calculateBounds(float[] fArr) {
        fArr.getClass();
        return calculateBounds$default(this, fArr, false, 2, null);
    }

    public final float[] calculateBounds() {
        return calculateBounds$default(this, null, false, 3, null);
    }
}
