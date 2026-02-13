package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public final class Score {
    private static final int BLUE_500 = -12417548;
    private static final double CUTOFF_CHROMA = 5.0d;
    private static final double CUTOFF_EXCITED_PROPORTION = 0.01d;
    private static final int MAX_COLOR_COUNT = 4;
    private static final double TARGET_CHROMA = 48.0d;
    private static final double WEIGHT_CHROMA_ABOVE = 0.3d;
    private static final double WEIGHT_CHROMA_BELOW = 0.1d;
    private static final double WEIGHT_PROPORTION = 0.7d;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class ScoredHCT {
        public final Hct hct;
        public final double score;

        public ScoredHCT(Hct hct, double d8) {
            this.hct = hct;
            this.score = d8;
        }
    }

    private Score() {
    }

    public static List<Integer> score(Map<Integer, Integer> map, int i10, int i11, boolean z9) {
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[360];
        double d8 = 0.0d;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Hct hctFromInt = Hct.fromInt(entry.getKey().intValue());
            arrayList.add(hctFromInt);
            int iFloor = (int) Math.floor(hctFromInt.getHue());
            int iIntValue = entry.getValue().intValue();
            iArr[iFloor] = iArr[iFloor] + iIntValue;
            d8 += iIntValue;
        }
        double[] dArr = new double[360];
        int i12 = 0;
        for (int i13 = 0; i13 < 360; i13++) {
            double d10 = iArr[i13] / d8;
            for (int i14 = i13 - 14; i14 < i13 + 16; i14++) {
                int iSanitizeDegreesInt = MathUtils.sanitizeDegreesInt(i14);
                dArr[iSanitizeDegreesInt] = dArr[iSanitizeDegreesInt] + d10;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i15 = 0;
        while (i15 < size) {
            Object obj = arrayList.get(i15);
            i15++;
            Hct hct = (Hct) obj;
            double d11 = dArr[MathUtils.sanitizeDegreesInt((int) Math.round(hct.getHue()))];
            if (!z9 || (hct.getChroma() >= CUTOFF_CHROMA && d11 > CUTOFF_EXCITED_PROPORTION)) {
                arrayList2.add(new ScoredHCT(hct, ((hct.getChroma() - TARGET_CHROMA) * (hct.getChroma() < TARGET_CHROMA ? WEIGHT_CHROMA_BELOW : WEIGHT_CHROMA_ABOVE)) + (d11 * 100.0d * WEIGHT_PROPORTION)));
            }
        }
        Collections.sort(arrayList2, new ScoredComparator());
        ArrayList arrayList3 = new ArrayList();
        for (int i16 = 90; i16 >= 15; i16--) {
            arrayList3.clear();
            int size2 = arrayList2.size();
            int i17 = 0;
            while (i17 < size2) {
                Object obj2 = arrayList2.get(i17);
                i17++;
                Hct hct2 = ((ScoredHCT) obj2).hct;
                int size3 = arrayList3.size();
                int i18 = 0;
                while (true) {
                    if (i18 >= size3) {
                        arrayList3.add(hct2);
                        break;
                    }
                    Object obj3 = arrayList3.get(i18);
                    i18++;
                    if (MathUtils.differenceDegrees(hct2.getHue(), ((Hct) obj3).getHue()) < i16) {
                        break;
                    }
                }
                if (arrayList3.size() >= i10) {
                    break;
                }
            }
            if (arrayList3.size() >= i10) {
                break;
            }
        }
        ArrayList arrayList4 = new ArrayList();
        if (arrayList3.isEmpty()) {
            arrayList4.add(Integer.valueOf(i11));
            return arrayList4;
        }
        int size4 = arrayList3.size();
        while (i12 < size4) {
            Object obj4 = arrayList3.get(i12);
            i12++;
            arrayList4.add(Integer.valueOf(((Hct) obj4).toInt()));
        }
        return arrayList4;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class ScoredComparator implements Comparator<ScoredHCT> {
        @Override // java.util.Comparator
        public int compare(ScoredHCT scoredHCT, ScoredHCT scoredHCT2) {
            return Double.compare(scoredHCT2.score, scoredHCT.score);
        }
    }

    public static List<Integer> score(Map<Integer, Integer> map, int i10) {
        return score(map, i10, BLUE_500, true);
    }

    public static List<Integer> score(Map<Integer, Integer> map, int i10, int i11) {
        return score(map, i10, i11, true);
    }

    public static List<Integer> score(Map<Integer, Integer> map) {
        return score(map, 4, BLUE_500, true);
    }
}
