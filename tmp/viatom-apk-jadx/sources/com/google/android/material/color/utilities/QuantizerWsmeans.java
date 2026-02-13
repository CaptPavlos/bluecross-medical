package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public final class QuantizerWsmeans {
    private static final int MAX_ITERATIONS = 10;
    private static final double MIN_MOVEMENT_DISTANCE = 3.0d;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Distance implements Comparable<Distance> {
        int index = -1;
        double distance = -1.0d;

        @Override // java.lang.Comparable
        public int compareTo(Distance distance) {
            return Double.valueOf(this.distance).compareTo(Double.valueOf(distance.distance));
        }
    }

    private QuantizerWsmeans() {
    }

    public static Map<Integer, Integer> quantize(int[] iArr, int[] iArr2, int i10) {
        boolean z9;
        double[] dArr;
        double[] dArr2;
        Random random = new Random(272008L);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        double[][] dArr3 = new double[iArr.length][];
        int[] iArr3 = new int[iArr.length];
        PointProviderLab pointProviderLab = new PointProviderLab();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            z9 = true;
            if (i11 >= iArr.length) {
                break;
            }
            int i13 = iArr[i11];
            Integer num = (Integer) linkedHashMap.get(Integer.valueOf(i13));
            if (num == null) {
                dArr3[i12] = pointProviderLab.fromInt(i13);
                iArr3[i12] = i13;
                i12++;
                linkedHashMap.put(Integer.valueOf(i13), 1);
            } else {
                linkedHashMap.put(Integer.valueOf(i13), Integer.valueOf(num.intValue() + 1));
            }
            i11++;
        }
        int[] iArr4 = new int[i12];
        for (int i14 = 0; i14 < i12; i14++) {
            iArr4[i14] = ((Integer) linkedHashMap.get(Integer.valueOf(iArr3[i14]))).intValue();
        }
        int iMin = Math.min(i10, i12);
        if (iArr2.length != 0) {
            iMin = Math.min(iMin, iArr2.length);
        }
        double[][] dArr4 = new double[iMin][];
        int i15 = 0;
        for (int i16 = 0; i16 < iArr2.length; i16++) {
            dArr4[i16] = pointProviderLab.fromInt(iArr2[i16]);
            i15++;
        }
        int i17 = iMin - i15;
        if (i17 > 0) {
            for (int i18 = 0; i18 < i17; i18++) {
            }
        }
        int[] iArr5 = new int[i12];
        for (int i19 = 0; i19 < i12; i19++) {
            iArr5[i19] = random.nextInt(iMin);
        }
        int[][] iArr6 = new int[iMin][];
        for (int i20 = 0; i20 < iMin; i20++) {
            iArr6[i20] = new int[iMin];
        }
        Distance[][] distanceArr = new Distance[iMin][];
        for (int i21 = 0; i21 < iMin; i21++) {
            distanceArr[i21] = new Distance[iMin];
            for (int i22 = 0; i22 < iMin; i22++) {
                distanceArr[i21][i22] = new Distance();
            }
        }
        int[] iArr7 = new int[iMin];
        int i23 = 0;
        while (i23 < 10) {
            int i24 = 0;
            while (i24 < iMin) {
                int i25 = i24 + 1;
                int i26 = i25;
                while (i26 < iMin) {
                    int[] iArr8 = iArr4;
                    double dDistance = pointProviderLab.distance(dArr4[i24], dArr4[i26]);
                    Distance distance = distanceArr[i26][i24];
                    distance.distance = dDistance;
                    distance.index = i24;
                    Distance distance2 = distanceArr[i24][i26];
                    distance2.distance = dDistance;
                    distance2.index = i26;
                    i26++;
                    iArr4 = iArr8;
                    iArr5 = iArr5;
                    z9 = z9;
                }
                int[] iArr9 = iArr4;
                int[] iArr10 = iArr5;
                boolean z10 = z9;
                Arrays.sort(distanceArr[i24]);
                for (int i27 = 0; i27 < iMin; i27++) {
                    iArr6[i24][i27] = distanceArr[i24][i27].index;
                }
                iArr4 = iArr9;
                iArr5 = iArr10;
                i24 = i25;
                z9 = z10;
            }
            int[] iArr11 = iArr4;
            int[] iArr12 = iArr5;
            boolean z11 = z9;
            int i28 = 0;
            int i29 = 0;
            while (i28 < i12) {
                double[] dArr5 = dArr3[i28];
                int i30 = iArr12[i28];
                double dDistance2 = pointProviderLab.distance(dArr5, dArr4[i30]);
                int i31 = i28;
                double d8 = dDistance2;
                int i32 = -1;
                int i33 = 0;
                while (i33 < iMin) {
                    int i34 = i29;
                    int[][] iArr13 = iArr6;
                    if (distanceArr[i30][i33].distance < 4.0d * dDistance2) {
                        double dDistance3 = pointProviderLab.distance(dArr5, dArr4[i33]);
                        if (dDistance3 < d8) {
                            d8 = dDistance3;
                            i32 = i33;
                        }
                    }
                    i33++;
                    iArr6 = iArr13;
                    i29 = i34;
                }
                int i35 = i29;
                int[][] iArr14 = iArr6;
                if (i32 == -1 || Math.abs(Math.sqrt(d8) - Math.sqrt(dDistance2)) <= 3.0d) {
                    i29 = i35;
                } else {
                    i29 = i35 + 1;
                    iArr12[i31] = i32;
                }
                i28 = i31 + 1;
                iArr6 = iArr14;
            }
            int[][] iArr15 = iArr6;
            if (i29 == 0 && i23 != 0) {
                break;
            }
            double[] dArr6 = new double[iMin];
            double[] dArr7 = new double[iMin];
            double[] dArr8 = new double[iMin];
            boolean z12 = false;
            Arrays.fill(iArr7, 0);
            int i36 = 0;
            while (i36 < i12) {
                int i37 = iArr12[i36];
                double[] dArr9 = dArr3[i36];
                boolean z13 = z12;
                int i38 = iArr11[i36];
                iArr7[i37] = iArr7[i37] + i38;
                double d10 = i38;
                dArr6[i37] = (dArr9[z13 ? 1 : 0] * d10) + dArr6[i37];
                dArr7[i37] = (dArr9[z11 ? 1 : 0] * d10) + dArr7[i37];
                dArr8[i37] = (dArr9[2] * d10) + dArr8[i37];
                i36++;
                z12 = false;
            }
            int i39 = 0;
            while (i39 < iMin) {
                int i40 = iArr7[i39];
                if (i40 == 0) {
                    dArr4[i39] = new double[]{0.0d, 0.0d, 0.0d};
                    dArr = dArr6;
                    dArr2 = dArr7;
                } else {
                    double d11 = dArr6[i39];
                    dArr = dArr6;
                    dArr2 = dArr7;
                    double d12 = i40;
                    double d13 = d11 / d12;
                    double d14 = dArr2[i39] / d12;
                    double d15 = dArr8[i39] / d12;
                    double[] dArr10 = dArr4[i39];
                    dArr10[0] = d13;
                    dArr10[z11 ? 1 : 0] = d14;
                    dArr10[2] = d15;
                }
                i39++;
                dArr6 = dArr;
                dArr7 = dArr2;
            }
            i23++;
            iArr4 = iArr11;
            iArr5 = iArr12;
            z9 = z11 ? 1 : 0;
            iArr6 = iArr15;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (int i41 = 0; i41 < iMin; i41++) {
            int i42 = iArr7[i41];
            if (i42 != 0) {
                int i43 = pointProviderLab.toInt(dArr4[i41]);
                if (!linkedHashMap2.containsKey(Integer.valueOf(i43))) {
                    linkedHashMap2.put(Integer.valueOf(i43), Integer.valueOf(i42));
                }
            }
        }
        return linkedHashMap2;
    }
}
