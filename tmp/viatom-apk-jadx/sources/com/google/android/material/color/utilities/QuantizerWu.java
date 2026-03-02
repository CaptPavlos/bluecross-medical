package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public final class QuantizerWu implements Quantizer {
    private static final int INDEX_BITS = 5;
    private static final int INDEX_COUNT = 33;
    private static final int TOTAL_SIZE = 35937;
    Box[] cubes;
    double[] moments;
    int[] momentsB;
    int[] momentsG;
    int[] momentsR;
    int[] weights;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Box {

        /* renamed from: b0, reason: collision with root package name */
        int f2323b0;
        int b1;

        /* renamed from: g0, reason: collision with root package name */
        int f2324g0;

        /* renamed from: g1, reason: collision with root package name */
        int f2325g1;

        /* renamed from: r0, reason: collision with root package name */
        int f2326r0;

        /* renamed from: r1, reason: collision with root package name */
        int f2327r1;
        int vol;

        private Box() {
            this.f2326r0 = 0;
            this.f2327r1 = 0;
            this.f2324g0 = 0;
            this.f2325g1 = 0;
            this.f2323b0 = 0;
            this.b1 = 0;
            this.vol = 0;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class CreateBoxesResult {
        int resultCount;

        public CreateBoxesResult(int i10, int i11) {
            this.resultCount = i11;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public enum Direction {
        RED,
        GREEN,
        BLUE
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class MaximizeResult {
        int cutLocation;
        double maximum;

        public MaximizeResult(int i10, double d8) {
            this.cutLocation = i10;
            this.maximum = d8;
        }
    }

    public static int bottom(Box box, Direction direction, int[] iArr) {
        int i10;
        int i11;
        int iOrdinal = direction.ordinal();
        if (iOrdinal == 0) {
            i10 = (-iArr[getIndex(box.f2326r0, box.f2325g1, box.b1)]) + iArr[getIndex(box.f2326r0, box.f2325g1, box.f2323b0)] + iArr[getIndex(box.f2326r0, box.f2324g0, box.b1)];
            i11 = iArr[getIndex(box.f2326r0, box.f2324g0, box.f2323b0)];
        } else if (iOrdinal == 1) {
            i10 = (-iArr[getIndex(box.f2327r1, box.f2324g0, box.b1)]) + iArr[getIndex(box.f2327r1, box.f2324g0, box.f2323b0)] + iArr[getIndex(box.f2326r0, box.f2324g0, box.b1)];
            i11 = iArr[getIndex(box.f2326r0, box.f2324g0, box.f2323b0)];
        } else {
            if (iOrdinal != 2) {
                androidx.window.layout.c.j(direction, "unexpected direction ");
                return 0;
            }
            i10 = (-iArr[getIndex(box.f2327r1, box.f2325g1, box.f2323b0)]) + iArr[getIndex(box.f2327r1, box.f2324g0, box.f2323b0)] + iArr[getIndex(box.f2326r0, box.f2325g1, box.f2323b0)];
            i11 = iArr[getIndex(box.f2326r0, box.f2324g0, box.f2323b0)];
        }
        return i10 - i11;
    }

    public static int getIndex(int i10, int i11, int i12) {
        return (i10 << 10) + (i10 << 6) + i10 + (i11 << 5) + i11 + i12;
    }

    public static int top(Box box, Direction direction, int i10, int[] iArr) {
        int i11;
        int i12;
        int iOrdinal = direction.ordinal();
        if (iOrdinal == 0) {
            i11 = (iArr[getIndex(i10, box.f2325g1, box.b1)] - iArr[getIndex(i10, box.f2325g1, box.f2323b0)]) - iArr[getIndex(i10, box.f2324g0, box.b1)];
            i12 = iArr[getIndex(i10, box.f2324g0, box.f2323b0)];
        } else if (iOrdinal == 1) {
            i11 = (iArr[getIndex(box.f2327r1, i10, box.b1)] - iArr[getIndex(box.f2327r1, i10, box.f2323b0)]) - iArr[getIndex(box.f2326r0, i10, box.b1)];
            i12 = iArr[getIndex(box.f2326r0, i10, box.f2323b0)];
        } else {
            if (iOrdinal != 2) {
                androidx.window.layout.c.j(direction, "unexpected direction ");
                return 0;
            }
            i11 = (iArr[getIndex(box.f2327r1, box.f2325g1, i10)] - iArr[getIndex(box.f2327r1, box.f2324g0, i10)]) - iArr[getIndex(box.f2326r0, box.f2325g1, i10)];
            i12 = iArr[getIndex(box.f2326r0, box.f2324g0, i10)];
        }
        return i11 + i12;
    }

    public static int volume(Box box, int[] iArr) {
        return ((((((iArr[getIndex(box.f2327r1, box.f2325g1, box.b1)] - iArr[getIndex(box.f2327r1, box.f2325g1, box.f2323b0)]) - iArr[getIndex(box.f2327r1, box.f2324g0, box.b1)]) + iArr[getIndex(box.f2327r1, box.f2324g0, box.f2323b0)]) - iArr[getIndex(box.f2326r0, box.f2325g1, box.b1)]) + iArr[getIndex(box.f2326r0, box.f2325g1, box.f2323b0)]) + iArr[getIndex(box.f2326r0, box.f2324g0, box.b1)]) - iArr[getIndex(box.f2326r0, box.f2324g0, box.f2323b0)];
    }

    public void constructHistogram(Map<Integer, Integer> map) {
        this.weights = new int[TOTAL_SIZE];
        this.momentsR = new int[TOTAL_SIZE];
        this.momentsG = new int[TOTAL_SIZE];
        this.momentsB = new int[TOTAL_SIZE];
        this.moments = new double[TOTAL_SIZE];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            int iIntValue2 = entry.getValue().intValue();
            int iRedFromArgb = ColorUtils.redFromArgb(iIntValue);
            int iGreenFromArgb = ColorUtils.greenFromArgb(iIntValue);
            int iBlueFromArgb = ColorUtils.blueFromArgb(iIntValue);
            int index = getIndex((iRedFromArgb >> 3) + 1, (iGreenFromArgb >> 3) + 1, (iBlueFromArgb >> 3) + 1);
            int[] iArr = this.weights;
            iArr[index] = iArr[index] + iIntValue2;
            int[] iArr2 = this.momentsR;
            iArr2[index] = (iRedFromArgb * iIntValue2) + iArr2[index];
            int[] iArr3 = this.momentsG;
            iArr3[index] = (iGreenFromArgb * iIntValue2) + iArr3[index];
            int[] iArr4 = this.momentsB;
            iArr4[index] = (iBlueFromArgb * iIntValue2) + iArr4[index];
            double[] dArr = this.moments;
            int i10 = iBlueFromArgb * iBlueFromArgb;
            dArr[index] = dArr[index] + ((i10 + (iGreenFromArgb * iGreenFromArgb) + (iRedFromArgb * iRedFromArgb)) * iIntValue2);
        }
    }

    public CreateBoxesResult createBoxes(int i10) {
        int i11;
        this.cubes = new Box[i10];
        for (int i12 = 0; i12 < i10; i12++) {
            this.cubes[i12] = new Box();
        }
        double[] dArr = new double[i10];
        Box box = this.cubes[0];
        box.f2327r1 = 32;
        box.f2325g1 = 32;
        box.b1 = 32;
        int i13 = 0;
        int i14 = 1;
        while (true) {
            if (i14 >= i10) {
                i11 = i10;
                break;
            }
            Box[] boxArr = this.cubes;
            if (cut(boxArr[i13], boxArr[i14]).booleanValue()) {
                Box box2 = this.cubes[i13];
                dArr[i13] = box2.vol > 1 ? variance(box2) : 0.0d;
                Box box3 = this.cubes[i14];
                dArr[i14] = box3.vol > 1 ? variance(box3) : 0.0d;
            } else {
                dArr[i13] = 0.0d;
                i14--;
            }
            double d8 = dArr[0];
            int i15 = 0;
            for (int i16 = 1; i16 <= i14; i16++) {
                double d10 = dArr[i16];
                if (d10 > d8) {
                    i15 = i16;
                    d8 = d10;
                }
            }
            if (d8 <= 0.0d) {
                i11 = i14 + 1;
                break;
            }
            i14++;
            i13 = i15;
        }
        return new CreateBoxesResult(i10, i11);
    }

    public void createMoments() {
        int i10 = 1;
        while (true) {
            int i11 = 33;
            if (i10 >= 33) {
                return;
            }
            int[] iArr = new int[33];
            int[] iArr2 = new int[33];
            int[] iArr3 = new int[33];
            int[] iArr4 = new int[33];
            double[] dArr = new double[33];
            int i12 = 1;
            while (i12 < i11) {
                int i13 = 0;
                int i14 = 0;
                double d8 = 0.0d;
                int i15 = 1;
                int i16 = 0;
                int i17 = 0;
                while (i15 < i11) {
                    int index = getIndex(i10, i12, i15);
                    i13 += this.weights[index];
                    i16 += this.momentsR[index];
                    i17 += this.momentsG[index];
                    i14 += this.momentsB[index];
                    d8 += this.moments[index];
                    iArr[i15] = iArr[i15] + i13;
                    iArr2[i15] = iArr2[i15] + i16;
                    iArr3[i15] = iArr3[i15] + i17;
                    iArr4[i15] = iArr4[i15] + i14;
                    dArr[i15] = dArr[i15] + d8;
                    int index2 = getIndex(i10 - 1, i12, i15);
                    int i18 = i15;
                    int[] iArr5 = this.weights;
                    iArr5[index] = iArr5[index2] + iArr[i18];
                    int[] iArr6 = this.momentsR;
                    iArr6[index] = iArr6[index2] + iArr2[i18];
                    int[] iArr7 = this.momentsG;
                    iArr7[index] = iArr7[index2] + iArr3[i18];
                    int[] iArr8 = this.momentsB;
                    iArr8[index] = iArr8[index2] + iArr4[i18];
                    double[] dArr2 = this.moments;
                    dArr2[index] = dArr2[index2] + dArr[i18];
                    i15 = i18 + 1;
                    i11 = 33;
                }
                i12++;
                i11 = 33;
            }
            i10++;
        }
    }

    public List<Integer> createResult(int i10) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < i10; i11++) {
            Box box = this.cubes[i11];
            int iVolume = volume(box, this.weights);
            if (iVolume > 0) {
                int iVolume2 = volume(box, this.momentsR) / iVolume;
                int iVolume3 = volume(box, this.momentsG) / iVolume;
                arrayList.add(Integer.valueOf(((volume(box, this.momentsB) / iVolume) & 255) | ((iVolume2 & 255) << 16) | ViewCompat.MEASURED_STATE_MASK | ((iVolume3 & 255) << 8)));
            }
        }
        return arrayList;
    }

    public Boolean cut(Box box, Box box2) {
        int iVolume = volume(box, this.momentsR);
        int iVolume2 = volume(box, this.momentsG);
        int iVolume3 = volume(box, this.momentsB);
        int iVolume4 = volume(box, this.weights);
        Direction direction = Direction.RED;
        MaximizeResult maximizeResultMaximize = maximize(box, direction, box.f2326r0 + 1, box.f2327r1, iVolume, iVolume2, iVolume3, iVolume4);
        Direction direction2 = Direction.GREEN;
        MaximizeResult maximizeResultMaximize2 = maximize(box, direction2, box.f2324g0 + 1, box.f2325g1, iVolume, iVolume2, iVolume3, iVolume4);
        Direction direction3 = Direction.BLUE;
        MaximizeResult maximizeResultMaximize3 = maximize(box, direction3, box.f2323b0 + 1, box.b1, iVolume, iVolume2, iVolume3, iVolume4);
        double d8 = maximizeResultMaximize.maximum;
        double d10 = maximizeResultMaximize2.maximum;
        double d11 = maximizeResultMaximize3.maximum;
        if (d8 < d10 || d8 < d11) {
            if (d10 >= d8 && d10 >= d11) {
                direction3 = direction2;
            }
        } else {
            if (maximizeResultMaximize.cutLocation < 0) {
                return Boolean.FALSE;
            }
            direction3 = direction;
        }
        box2.f2327r1 = box.f2327r1;
        box2.f2325g1 = box.f2325g1;
        box2.b1 = box.b1;
        int iOrdinal = direction3.ordinal();
        if (iOrdinal == 0) {
            int i10 = maximizeResultMaximize.cutLocation;
            box.f2327r1 = i10;
            box2.f2326r0 = i10;
            box2.f2324g0 = box.f2324g0;
            box2.f2323b0 = box.f2323b0;
        } else if (iOrdinal == 1) {
            int i11 = maximizeResultMaximize2.cutLocation;
            box.f2325g1 = i11;
            box2.f2326r0 = box.f2326r0;
            box2.f2324g0 = i11;
            box2.f2323b0 = box.f2323b0;
        } else if (iOrdinal == 2) {
            int i12 = maximizeResultMaximize3.cutLocation;
            box.b1 = i12;
            box2.f2326r0 = box.f2326r0;
            box2.f2324g0 = box.f2324g0;
            box2.f2323b0 = i12;
        }
        box.vol = (box.b1 - box.f2323b0) * (box.f2325g1 - box.f2324g0) * (box.f2327r1 - box.f2326r0);
        box2.vol = (box2.b1 - box2.f2323b0) * (box2.f2325g1 - box2.f2324g0) * (box2.f2327r1 - box2.f2326r0);
        return Boolean.TRUE;
    }

    public MaximizeResult maximize(Box box, Direction direction, int i10, int i11, int i12, int i13, int i14, int i15) {
        QuantizerWu quantizerWu = this;
        Box box2 = box;
        int iBottom = bottom(box2, direction, quantizerWu.momentsR);
        int iBottom2 = bottom(box2, direction, quantizerWu.momentsG);
        int iBottom3 = bottom(box2, direction, quantizerWu.momentsB);
        int iBottom4 = bottom(box2, direction, quantizerWu.weights);
        int i16 = -1;
        double d8 = 0.0d;
        int i17 = i10;
        while (i17 < i11) {
            int pVar = top(box2, direction, i17, quantizerWu.momentsR) + iBottom;
            int pVar2 = top(box2, direction, i17, quantizerWu.momentsG) + iBottom2;
            int pVar3 = top(box2, direction, i17, quantizerWu.momentsB) + iBottom3;
            int pVar4 = top(box2, direction, i17, quantizerWu.weights) + iBottom4;
            if (pVar4 != 0) {
                double d10 = ((pVar3 * pVar3) + ((pVar2 * pVar2) + (pVar * pVar))) / pVar4;
                int i18 = i12 - pVar;
                int i19 = i13 - pVar2;
                int i20 = i14 - pVar3;
                int i21 = i15 - pVar4;
                if (i21 != 0) {
                    int i22 = i20 * i20;
                    double d11 = ((i22 + ((i19 * i19) + (i18 * i18))) / i21) + d10;
                    if (d11 > d8) {
                        i16 = i17;
                        d8 = d11;
                    }
                }
            }
            i17++;
            quantizerWu = this;
            box2 = box;
        }
        return new MaximizeResult(i16, d8);
    }

    @Override // com.google.android.material.color.utilities.Quantizer
    public QuantizerResult quantize(int[] iArr, int i10) {
        constructHistogram(new QuantizerMap().quantize(iArr, i10).colorToCount);
        createMoments();
        List<Integer> listCreateResult = createResult(createBoxes(i10).resultCount);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Integer num : listCreateResult) {
            num.intValue();
            linkedHashMap.put(num, 0);
        }
        return new QuantizerResult(linkedHashMap);
    }

    public double variance(Box box) {
        int iVolume = volume(box, this.momentsR);
        int iVolume2 = volume(box, this.momentsG);
        int iVolume3 = volume(box, this.momentsB);
        int i10 = iVolume3 * iVolume3;
        return (((((((this.moments[getIndex(box.f2327r1, box.f2325g1, box.b1)] - this.moments[getIndex(box.f2327r1, box.f2325g1, box.f2323b0)]) - this.moments[getIndex(box.f2327r1, box.f2324g0, box.b1)]) + this.moments[getIndex(box.f2327r1, box.f2324g0, box.f2323b0)]) - this.moments[getIndex(box.f2326r0, box.f2325g1, box.b1)]) + this.moments[getIndex(box.f2326r0, box.f2325g1, box.f2323b0)]) + this.moments[getIndex(box.f2326r0, box.f2324g0, box.b1)]) - this.moments[getIndex(box.f2326r0, box.f2324g0, box.f2323b0)]) - ((i10 + ((iVolume2 * iVolume2) + (iVolume * iVolume))) / volume(box, this.weights));
    }
}
