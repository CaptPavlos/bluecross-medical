package androidx.graphics.shapes;

import androidx.annotation.FloatRange;
import androidx.collection.FloatList;
import androidx.collection.MutableFloatList;
import androidx.graphics.shapes.Feature;
import com.google.android.gms.internal.measurement.a4;
import com.google.android.gms.internal.measurement.l5;
import com.google.android.material.color.utilities.Contrast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.g;
import s6.i;
import t6.e;
import t6.l;
import t6.m;
import t6.n;
import u6.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class MeasuredPolygon extends e {
    public static final Companion Companion = new Companion(null);
    private final List<MeasuredCubic> cubics;
    private final List<ProgressableFeature> features;
    private final Measurer measurer;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public final class MeasuredCubic {
        private final Cubic cubic;
        private float endOutlineProgress;
        private final float measuredSize;
        private float startOutlineProgress;
        final /* synthetic */ MeasuredPolygon this$0;

        public MeasuredCubic(MeasuredPolygon measuredPolygon, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) Cubic cubic, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f, float f10) {
            cubic.getClass();
            this.this$0 = measuredPolygon;
            this.cubic = cubic;
            if (f10 < f) {
                com.google.gson.internal.a.n("endOutlineProgress is expected to be equal or greater than startOutlineProgress");
                throw null;
            }
            this.measuredSize = measuredPolygon.measurer.measureCubic(cubic);
            this.startOutlineProgress = f;
            this.endOutlineProgress = f10;
        }

        public static /* synthetic */ void updateProgressRange$graphics_shapes_release$default(MeasuredCubic measuredCubic, float f, float f10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                f = measuredCubic.startOutlineProgress;
            }
            if ((i10 & 2) != 0) {
                f10 = measuredCubic.endOutlineProgress;
            }
            measuredCubic.updateProgressRange$graphics_shapes_release(f, f10);
        }

        public final i cutAtProgress(float f) {
            float fM = l5.m(f, this.startOutlineProgress, this.endOutlineProgress);
            float f10 = this.endOutlineProgress;
            float f11 = this.startOutlineProgress;
            float fFindCubicCutPoint = this.this$0.measurer.findCubicCutPoint(this.cubic, ((fM - f11) / (f10 - f11)) * this.measuredSize);
            if (0.0f > fFindCubicCutPoint || fFindCubicCutPoint > 1.0f) {
                com.google.gson.internal.a.n("Cubic cut point is expected to be between 0 and 1");
                return null;
            }
            String unused = PolygonMeasureKt.LOG_TAG;
            i iVarSplit = this.cubic.split(fFindCubicCutPoint);
            return new i(new MeasuredCubic(this.this$0, (Cubic) iVarSplit.f12693a, this.startOutlineProgress, fM), new MeasuredCubic(this.this$0, (Cubic) iVarSplit.f12694b, fM, this.endOutlineProgress));
        }

        public final Cubic getCubic() {
            return this.cubic;
        }

        public final float getEndOutlineProgress() {
            return this.endOutlineProgress;
        }

        public final float getMeasuredSize() {
            return this.measuredSize;
        }

        public final float getStartOutlineProgress() {
            return this.startOutlineProgress;
        }

        public String toString() {
            return "MeasuredCubic(outlineProgress=[" + this.startOutlineProgress + " .. " + this.endOutlineProgress + "], size=" + this.measuredSize + ", cubic=" + this.cubic + ')';
        }

        public final void updateProgressRange$graphics_shapes_release(float f, float f10) {
            if (f10 < f) {
                com.google.gson.internal.a.n("endOutlineProgress is expected to be equal or greater than startOutlineProgress");
            } else {
                this.startOutlineProgress = f;
                this.endOutlineProgress = f10;
            }
        }
    }

    private MeasuredPolygon(Measurer measurer, List<ProgressableFeature> list, List<? extends Cubic> list2, FloatList floatList) {
        if (floatList.getSize() != list2.size() + 1) {
            com.google.gson.internal.a.n("Outline progress size is expected to be the cubics size + 1");
            throw null;
        }
        if (floatList.first() != 0.0f) {
            com.google.gson.internal.a.n("First outline progress value is expected to be zero");
            throw null;
        }
        if (floatList.last() != 1.0f) {
            com.google.gson.internal.a.n("Last outline progress value is expected to be one");
            throw null;
        }
        this.measurer = measurer;
        this.features = list;
        ArrayList arrayList = new ArrayList();
        int size = list2.size();
        int i10 = 0;
        float f = 0.0f;
        while (i10 < size) {
            int i11 = i10 + 1;
            if (floatList.get(i11) - floatList.get(i10) > 1.0E-4f) {
                arrayList.add(new MeasuredCubic(this, list2.get(i10), f, floatList.get(i11)));
                f = floatList.get(i11);
            }
            i10 = i11;
        }
        MeasuredCubic.updateProgressRange$graphics_shapes_release$default((MeasuredCubic) arrayList.get(arrayList.size() - 1), 0.0f, 1.0f, 1, null);
        this.cubics = arrayList;
    }

    @Override // t6.a, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof MeasuredCubic) {
            return contains((MeasuredCubic) obj);
        }
        return false;
    }

    public final MeasuredPolygon cutAndShift(float f) {
        if (0.0f > f || f > 1.0f) {
            com.google.gson.internal.a.n("Cutting point is expected to be between 0 and 1");
            return null;
        }
        if (f < 1.0E-4f) {
            return this;
        }
        Iterator<MeasuredCubic> it = this.cubics.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            }
            MeasuredCubic next = it.next();
            float startOutlineProgress = next.getStartOutlineProgress();
            if (f <= next.getEndOutlineProgress() && startOutlineProgress <= f) {
                break;
            }
            i10++;
        }
        i iVarCutAtProgress = this.cubics.get(i10).cutAtProgress(f);
        MeasuredCubic measuredCubic = (MeasuredCubic) iVarCutAtProgress.f12693a;
        MeasuredCubic measuredCubic2 = (MeasuredCubic) iVarCutAtProgress.f12694b;
        String unused = PolygonMeasureKt.LOG_TAG;
        ArrayList arrayListR = m.R(measuredCubic2.getCubic());
        int size = this.cubics.size();
        for (int i11 = 1; i11 < size; i11++) {
            List<MeasuredCubic> list = this.cubics;
            arrayListR.add(list.get((i11 + i10) % list.size()).getCubic());
        }
        arrayListR.add(measuredCubic.getCubic());
        MutableFloatList mutableFloatList = new MutableFloatList(this.cubics.size() + 2);
        int size2 = this.cubics.size() + 2;
        int i12 = 0;
        while (i12 < size2) {
            mutableFloatList.add(i12 == 0 ? 0.0f : i12 == this.cubics.size() + 1 ? 1.0f : Utils.positiveModulo(this.cubics.get(((i10 + i12) - 1) % this.cubics.size()).getEndOutlineProgress() - f, 1.0f));
            i12++;
        }
        c cVarL = a4.l();
        int size3 = this.features.size();
        for (int i13 = 0; i13 < size3; i13++) {
            cVarL.add(new ProgressableFeature(Utils.positiveModulo(this.features.get(i13).getProgress() - f, 1.0f), this.features.get(i13).getFeature()));
        }
        return new MeasuredPolygon(this.measurer, a4.h(cVarL), arrayListR, mutableFloatList);
    }

    @Override // java.util.List
    public MeasuredCubic get(int i10) {
        return this.cubics.get(i10);
    }

    public final List<ProgressableFeature> getFeatures() {
        return this.features;
    }

    @Override // t6.a
    public int getSize() {
        return this.cubics.size();
    }

    @Override // t6.e, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof MeasuredCubic) {
            return indexOf((MeasuredCubic) obj);
        }
        return -1;
    }

    @Override // t6.e, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof MeasuredCubic) {
            return lastIndexOf((MeasuredCubic) obj);
        }
        return -1;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final MeasuredPolygon measurePolygon$graphics_shapes_release(Measurer measurer, RoundedPolygon roundedPolygon) {
            List listU;
            measurer.getClass();
            roundedPolygon.getClass();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = roundedPolygon.getFeatures$graphics_shapes_release().size();
            for (int i10 = 0; i10 < size; i10++) {
                Feature feature = roundedPolygon.getFeatures$graphics_shapes_release().get(i10);
                int size2 = feature.getCubics().size();
                for (int i11 = 0; i11 < size2; i11++) {
                    if ((feature instanceof Feature.Corner) && i11 == feature.getCubics().size() / 2) {
                        arrayList2.add(new i(feature, Integer.valueOf(arrayList.size())));
                    }
                    arrayList.add(feature.getCubics().get(i11));
                }
            }
            Float fValueOf = Float.valueOf(0.0f);
            int iV = n.V(arrayList, 9);
            if (iV == 0) {
                listU = a4.u(fValueOf);
            } else {
                ArrayList arrayList3 = new ArrayList(iV + 1);
                arrayList3.add(fValueOf);
                int size3 = arrayList.size();
                int i12 = 0;
                while (i12 < size3) {
                    Object obj = arrayList.get(i12);
                    i12++;
                    float fFloatValue = fValueOf.floatValue();
                    float fMeasureCubic = measurer.measureCubic((Cubic) obj);
                    if (fMeasureCubic < 0.0f) {
                        com.google.gson.internal.a.n("Measured cubic is expected to be greater or equal to zero");
                        return null;
                    }
                    fValueOf = Float.valueOf(fFloatValue + fMeasureCubic);
                    arrayList3.add(fValueOf);
                }
                listU = arrayList3;
            }
            float fFloatValue2 = ((Number) l.i0(listU)).floatValue();
            MutableFloatList mutableFloatList = new MutableFloatList(listU.size());
            int size4 = listU.size();
            for (int i13 = 0; i13 < size4; i13++) {
                mutableFloatList.add(((Number) listU.get(i13)).floatValue() / fFloatValue2);
            }
            String unused = PolygonMeasureKt.LOG_TAG;
            c cVarL = a4.l();
            int size5 = arrayList2.size();
            for (int i14 = 0; i14 < size5; i14++) {
                int iIntValue = ((Number) ((i) arrayList2.get(i14)).f12694b).intValue();
                cVarL.add(new ProgressableFeature((mutableFloatList.get(iIntValue + 1) + mutableFloatList.get(iIntValue)) / 2, (Feature) ((i) arrayList2.get(i14)).f12693a));
            }
            return new MeasuredPolygon(measurer, a4.h(cVarL), arrayList, mutableFloatList, null);
        }

        private Companion() {
        }
    }

    public /* bridge */ boolean contains(MeasuredCubic measuredCubic) {
        return super.contains((Object) measuredCubic);
    }

    public /* bridge */ int indexOf(MeasuredCubic measuredCubic) {
        return super.indexOf((Object) measuredCubic);
    }

    public /* bridge */ int lastIndexOf(MeasuredCubic measuredCubic) {
        return super.lastIndexOf((Object) measuredCubic);
    }

    public /* synthetic */ MeasuredPolygon(Measurer measurer, List list, List list2, FloatList floatList, g gVar) {
        this(measurer, list, list2, floatList);
    }
}
