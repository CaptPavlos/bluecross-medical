package com.google.android.material.color.utilities;

import a6.h;
import androidx.annotation.RestrictTo;
import j$.util.Comparator$CC;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public final class TemperatureCache {
    private final Hct input;
    private Hct precomputedComplement;
    private List<Hct> precomputedHctsByHue;
    private List<Hct> precomputedHctsByTemp;
    private Map<Hct, Double> precomputedTempsByHct;

    private TemperatureCache() {
        throw new UnsupportedOperationException();
    }

    private Hct getColdest() {
        return getHctsByTemp().get(0);
    }

    private List<Hct> getHctsByHue() {
        List<Hct> list = this.precomputedHctsByHue;
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (double d8 = 0.0d; d8 <= 360.0d; d8 += 1.0d) {
            arrayList.add(Hct.from(d8, this.input.getChroma(), this.input.getTone()));
        }
        List<Hct> listUnmodifiableList = DesugarCollections.unmodifiableList(arrayList);
        this.precomputedHctsByHue = listUnmodifiableList;
        return listUnmodifiableList;
    }

    private List<Hct> getHctsByTemp() {
        List<Hct> list = this.precomputedHctsByTemp;
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList(getHctsByHue());
        arrayList.add(this.input);
        Collections.sort(arrayList, Comparator$CC.comparing(new a(this, 2), new h(4)));
        this.precomputedHctsByTemp = arrayList;
        return arrayList;
    }

    private Map<Hct, Double> getTempsByHct() {
        Map<Hct, Double> map = this.precomputedTempsByHct;
        if (map != null) {
            return map;
        }
        ArrayList arrayList = new ArrayList(getHctsByHue());
        arrayList.add(this.input);
        HashMap map2 = new HashMap();
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            Hct hct = (Hct) obj;
            map2.put(hct, Double.valueOf(rawTemperature(hct)));
        }
        this.precomputedTempsByHct = map2;
        return map2;
    }

    private Hct getWarmest() {
        return getHctsByTemp().get(getHctsByTemp().size() - 1);
    }

    private static boolean isBetween(double d8, double d10, double d11) {
        return d10 < d11 ? d10 <= d8 && d8 <= d11 : d10 <= d8 || d8 <= d11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Double lambda$getHctsByTemp$0(Hct hct) {
        return getTempsByHct().get(hct);
    }

    public static double rawTemperature(Hct hct) {
        double[] dArrLabFromArgb = ColorUtils.labFromArgb(hct.toInt());
        double dSanitizeDegreesDouble = MathUtils.sanitizeDegreesDouble(Math.toDegrees(Math.atan2(dArrLabFromArgb[2], dArrLabFromArgb[1])));
        return (Math.cos(Math.toRadians(MathUtils.sanitizeDegreesDouble(dSanitizeDegreesDouble - 50.0d))) * (Math.pow(Math.hypot(dArrLabFromArgb[1], dArrLabFromArgb[2]), 1.07d) * 0.02d)) - 0.5d;
    }

    public List<Hct> getAnalogousColors(int i10, int i11) {
        int iRound = (int) Math.round(this.input.getHue());
        Hct hct = getHctsByHue().get(iRound);
        double relativeTemperature = getRelativeTemperature(hct);
        ArrayList arrayList = new ArrayList();
        arrayList.add(hct);
        double dAbs = 0.0d;
        double dAbs2 = 0.0d;
        int i12 = 0;
        while (i12 < 360) {
            double relativeTemperature2 = getRelativeTemperature(getHctsByHue().get(MathUtils.sanitizeDegreesInt(iRound + i12)));
            dAbs2 += Math.abs(relativeTemperature2 - relativeTemperature);
            i12++;
            relativeTemperature = relativeTemperature2;
        }
        double d8 = dAbs2 / i11;
        double relativeTemperature3 = getRelativeTemperature(hct);
        int i13 = 1;
        while (true) {
            if (arrayList.size() >= i11) {
                break;
            }
            Hct hct2 = getHctsByHue().get(MathUtils.sanitizeDegreesInt(iRound + i13));
            double relativeTemperature4 = getRelativeTemperature(hct2);
            dAbs += Math.abs(relativeTemperature4 - relativeTemperature3);
            boolean z9 = dAbs >= ((double) arrayList.size()) * d8;
            int i14 = 1;
            while (z9 && arrayList.size() < i11) {
                arrayList.add(hct2);
                int i15 = i13;
                z9 = dAbs >= ((double) (arrayList.size() + i14)) * d8;
                i14++;
                i13 = i15;
            }
            i13++;
            if (i13 > 360) {
                while (arrayList.size() < i11) {
                    arrayList.add(hct2);
                }
            } else {
                relativeTemperature3 = relativeTemperature4;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.input);
        int iFloor = (int) Math.floor((i10 - 1.0d) / 2.0d);
        for (int i16 = 1; i16 < iFloor + 1; i16++) {
            int size = 0 - i16;
            while (size < 0) {
                size += arrayList.size();
            }
            if (size >= arrayList.size()) {
                size %= arrayList.size();
            }
            arrayList2.add(0, (Hct) arrayList.get(size));
        }
        int i17 = i10 - iFloor;
        for (int i18 = 1; i18 < i17; i18++) {
            int size2 = i18;
            while (size2 < 0) {
                size2 += arrayList.size();
            }
            if (size2 >= arrayList.size()) {
                size2 %= arrayList.size();
            }
            arrayList2.add((Hct) arrayList.get(size2));
        }
        return arrayList2;
    }

    public Hct getComplement() {
        double d8;
        Hct hct = this.precomputedComplement;
        if (hct != null) {
            return hct;
        }
        double hue = getColdest().getHue();
        double dDoubleValue = getTempsByHct().get(getColdest()).doubleValue();
        double hue2 = getWarmest().getHue();
        double dDoubleValue2 = getTempsByHct().get(getWarmest()).doubleValue() - dDoubleValue;
        boolean zIsBetween = isBetween(this.input.getHue(), hue, hue2);
        double d10 = zIsBetween ? hue2 : hue;
        double d11 = zIsBetween ? hue : hue2;
        Hct hct2 = getHctsByHue().get((int) Math.round(this.input.getHue()));
        double d12 = 1.0d;
        double relativeTemperature = 1.0d - getRelativeTemperature(this.input);
        double d13 = 1000.0d;
        double d14 = 0.0d;
        while (d14 <= 360.0d) {
            double dSanitizeDegreesDouble = MathUtils.sanitizeDegreesDouble((d12 * d14) + d10);
            if (isBetween(dSanitizeDegreesDouble, d10, d11)) {
                d8 = d12;
                Hct hct3 = getHctsByHue().get((int) Math.round(dSanitizeDegreesDouble));
                double dAbs = Math.abs(relativeTemperature - ((getTempsByHct().get(hct3).doubleValue() - dDoubleValue) / dDoubleValue2));
                if (dAbs < d13) {
                    hct2 = hct3;
                    d13 = dAbs;
                }
            } else {
                d8 = d12;
            }
            d14 += d8;
            d12 = d8;
        }
        this.precomputedComplement = hct2;
        return hct2;
    }

    public double getRelativeTemperature(Hct hct) {
        double dDoubleValue = getTempsByHct().get(getWarmest()).doubleValue() - getTempsByHct().get(getColdest()).doubleValue();
        double dDoubleValue2 = getTempsByHct().get(hct).doubleValue() - getTempsByHct().get(getColdest()).doubleValue();
        if (dDoubleValue == 0.0d) {
            return 0.5d;
        }
        return dDoubleValue2 / dDoubleValue;
    }

    public TemperatureCache(Hct hct) {
        this.input = hct;
    }

    public List<Hct> getAnalogousColors() {
        return getAnalogousColors(5, 12);
    }
}
