package androidx.graphics.shapes;

import androidx.graphics.shapes.MeasuredPolygon;
import com.google.android.gms.internal.measurement.a4;
import g7.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.g;
import s6.i;
import u6.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class Morph {
    public static final Companion Companion = new Companion(null);
    private final List<i> _morphMatch;
    private final RoundedPolygon end;
    private final RoundedPolygon start;

    public Morph(RoundedPolygon roundedPolygon, RoundedPolygon roundedPolygon2) {
        roundedPolygon.getClass();
        roundedPolygon2.getClass();
        this.start = roundedPolygon;
        this.end = roundedPolygon2;
        this._morphMatch = Companion.match$graphics_shapes_release(roundedPolygon, roundedPolygon2);
    }

    public static /* synthetic */ float[] calculateBounds$default(Morph morph, float[] fArr, boolean z9, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            fArr = new float[4];
        }
        if ((i10 & 2) != 0) {
            z9 = true;
        }
        return morph.calculateBounds(fArr, z9);
    }

    public static /* synthetic */ float[] calculateMaxBounds$default(Morph morph, float[] fArr, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            fArr = new float[4];
        }
        return morph.calculateMaxBounds(fArr);
    }

    public static void forEachCubic$default(Morph morph, float f, MutableCubic mutableCubic, l lVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            mutableCubic = new MutableCubic();
        }
        mutableCubic.getClass();
        lVar.getClass();
        int size = morph.getMorphMatch().size();
        for (int i11 = 0; i11 < size; i11++) {
            mutableCubic.interpolate((Cubic) morph.getMorphMatch().get(i11).f12693a, (Cubic) morph.getMorphMatch().get(i11).f12694b, f);
            lVar.invoke(mutableCubic);
        }
    }

    public final List<Cubic> asCubics(float f) {
        c cVarL = a4.l();
        int size = this._morphMatch.size();
        Cubic cubic = null;
        Cubic cubic2 = null;
        int i10 = 0;
        while (i10 < size) {
            float[] fArr = new float[8];
            for (int i11 = 0; i11 < 8; i11++) {
                fArr[i11] = Utils.interpolate(((Cubic) this._morphMatch.get(i10).f12693a).getPoints$graphics_shapes_release()[i11], ((Cubic) this._morphMatch.get(i10).f12694b).getPoints$graphics_shapes_release()[i11], f);
            }
            Cubic cubic3 = new Cubic(fArr);
            if (cubic2 == null) {
                cubic2 = cubic3;
            }
            if (cubic != null) {
                cVarL.add(cubic);
            }
            i10++;
            cubic = cubic3;
        }
        if (cubic != null && cubic2 != null) {
            cVarL.add(CubicKt.Cubic(cubic.getAnchor0X(), cubic.getAnchor0Y(), cubic.getControl0X(), cubic.getControl0Y(), cubic.getControl1X(), cubic.getControl1Y(), cubic2.getAnchor0X(), cubic2.getAnchor0Y()));
        }
        return a4.h(cVarL);
    }

    public final float[] calculateBounds(float[] fArr, boolean z9) {
        fArr.getClass();
        this.start.calculateBounds(fArr, z9);
        float f = fArr[0];
        float f10 = fArr[1];
        float f11 = fArr[2];
        float f12 = fArr[3];
        this.end.calculateBounds(fArr, z9);
        fArr[0] = Math.min(f, fArr[0]);
        fArr[1] = Math.min(f10, fArr[1]);
        fArr[2] = Math.max(f11, fArr[2]);
        fArr[3] = Math.max(f12, fArr[3]);
        return fArr;
    }

    public final float[] calculateMaxBounds(float[] fArr) {
        fArr.getClass();
        this.start.calculateMaxBounds(fArr);
        float f = fArr[0];
        float f10 = fArr[1];
        float f11 = fArr[2];
        float f12 = fArr[3];
        this.end.calculateMaxBounds(fArr);
        fArr[0] = Math.min(f, fArr[0]);
        fArr[1] = Math.min(f10, fArr[1]);
        fArr[2] = Math.max(f11, fArr[2]);
        fArr[3] = Math.max(f12, fArr[3]);
        return fArr;
    }

    public final void forEachCubic(float f, l lVar) {
        lVar.getClass();
        MutableCubic mutableCubic = new MutableCubic();
        int size = getMorphMatch().size();
        for (int i10 = 0; i10 < size; i10++) {
            mutableCubic.interpolate((Cubic) getMorphMatch().get(i10).f12693a, (Cubic) getMorphMatch().get(i10).f12694b, f);
            lVar.invoke(mutableCubic);
        }
    }

    public final List<i> getMorphMatch() {
        return this._morphMatch;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final List<i> match$graphics_shapes_release(RoundedPolygon roundedPolygon, RoundedPolygon roundedPolygon2) {
            i iVarCutAtProgress;
            i iVarCutAtProgress2;
            roundedPolygon.getClass();
            roundedPolygon2.getClass();
            MeasuredPolygon.Companion companion = MeasuredPolygon.Companion;
            MeasuredPolygon measuredPolygonMeasurePolygon$graphics_shapes_release = companion.measurePolygon$graphics_shapes_release(new AngleMeasurer(roundedPolygon.getCenterX(), roundedPolygon.getCenterY()), roundedPolygon);
            MeasuredPolygon measuredPolygonMeasurePolygon$graphics_shapes_release2 = companion.measurePolygon$graphics_shapes_release(new AngleMeasurer(roundedPolygon2.getCenterX(), roundedPolygon2.getCenterY()), roundedPolygon2);
            DoubleMapper doubleMapperFeatureMapper = FeatureMappingKt.featureMapper(measuredPolygonMeasurePolygon$graphics_shapes_release.getFeatures(), measuredPolygonMeasurePolygon$graphics_shapes_release2.getFeatures());
            float map = doubleMapperFeatureMapper.map(0.0f);
            String unused = MorphKt.LOG_TAG;
            MeasuredPolygon measuredPolygonCutAndShift = measuredPolygonMeasurePolygon$graphics_shapes_release2.cutAndShift(map);
            ArrayList arrayList = new ArrayList();
            MeasuredPolygon.MeasuredCubic measuredCubic = (MeasuredPolygon.MeasuredCubic) t6.l.d0(measuredPolygonMeasurePolygon$graphics_shapes_release, 0);
            MeasuredPolygon.MeasuredCubic measuredCubic2 = (MeasuredPolygon.MeasuredCubic) t6.l.d0(measuredPolygonCutAndShift, 0);
            int i10 = 1;
            int i11 = 1;
            while (measuredCubic != null && measuredCubic2 != null) {
                float endOutlineProgress = i10 == measuredPolygonMeasurePolygon$graphics_shapes_release.size() ? 1.0f : measuredCubic.getEndOutlineProgress();
                float fMapBack = i11 == measuredPolygonCutAndShift.size() ? 1.0f : doubleMapperFeatureMapper.mapBack(Utils.positiveModulo(measuredCubic2.getEndOutlineProgress() + map, 1.0f));
                float fMin = Math.min(endOutlineProgress, fMapBack);
                String unused2 = MorphKt.LOG_TAG;
                float f = 1.0E-6f + fMin;
                if (endOutlineProgress > f) {
                    String unused3 = MorphKt.LOG_TAG;
                    iVarCutAtProgress = measuredCubic.cutAtProgress(fMin);
                } else {
                    i iVar = new i(measuredCubic, t6.l.d0(measuredPolygonMeasurePolygon$graphics_shapes_release, i10));
                    i10++;
                    iVarCutAtProgress = iVar;
                }
                MeasuredPolygon.MeasuredCubic measuredCubic3 = (MeasuredPolygon.MeasuredCubic) iVarCutAtProgress.f12693a;
                measuredCubic = (MeasuredPolygon.MeasuredCubic) iVarCutAtProgress.f12694b;
                if (fMapBack > f) {
                    String unused4 = MorphKt.LOG_TAG;
                    iVarCutAtProgress2 = measuredCubic2.cutAtProgress(Utils.positiveModulo(doubleMapperFeatureMapper.map(fMin) - map, 1.0f));
                } else {
                    i iVar2 = new i(measuredCubic2, t6.l.d0(measuredPolygonCutAndShift, i11));
                    i11++;
                    iVarCutAtProgress2 = iVar2;
                }
                MeasuredPolygon.MeasuredCubic measuredCubic4 = (MeasuredPolygon.MeasuredCubic) iVarCutAtProgress2.f12693a;
                measuredCubic2 = (MeasuredPolygon.MeasuredCubic) iVarCutAtProgress2.f12694b;
                String unused5 = MorphKt.LOG_TAG;
                arrayList.add(new i(measuredCubic3.getCubic(), measuredCubic4.getCubic()));
            }
            if (measuredCubic == null && measuredCubic2 == null) {
                return arrayList;
            }
            com.google.gson.internal.a.n("Expected both Polygon's Cubic to be fully matched");
            return null;
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void getMorphMatch$annotations() {
    }

    public final void forEachCubic(float f, MutableCubic mutableCubic, l lVar) {
        mutableCubic.getClass();
        lVar.getClass();
        int size = getMorphMatch().size();
        for (int i10 = 0; i10 < size; i10++) {
            mutableCubic.interpolate((Cubic) getMorphMatch().get(i10).f12693a, (Cubic) getMorphMatch().get(i10).f12694b, f);
            lVar.invoke(mutableCubic);
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
