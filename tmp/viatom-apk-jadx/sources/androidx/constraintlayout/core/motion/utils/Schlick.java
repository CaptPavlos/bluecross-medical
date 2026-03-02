package androidx.constraintlayout.core.motion.utils;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class Schlick extends Easing {
    private static final boolean DEBUG = false;
    double mEps;
    double mS;
    double mT;

    public Schlick(String str) {
        this.mStr = str;
        int iIndexOf = str.indexOf(40);
        int iIndexOf2 = str.indexOf(44, iIndexOf);
        this.mS = Double.parseDouble(str.substring(iIndexOf + 1, iIndexOf2).trim());
        int i10 = iIndexOf2 + 1;
        this.mT = Double.parseDouble(str.substring(i10, str.indexOf(44, i10)).trim());
    }

    private double dfunc(double d8) {
        double d10 = this.mT;
        double d11 = this.mS;
        if (d8 < d10) {
            return ((d11 * d10) * d10) / ((((d10 - d8) * d11) + d8) * (((d10 - d8) * d11) + d8));
        }
        double d12 = d10 - d8;
        return ((d10 - 1.0d) * ((d10 - 1.0d) * d11)) / (((((d10 - d8) * (-d11)) - d8) + 1.0d) * (((d12 * (-d11)) - d8) + 1.0d));
    }

    private double func(double d8) {
        double d10 = this.mT;
        double d11 = this.mS;
        if (d8 < d10) {
            return (d10 * d8) / (((d10 - d8) * d11) + d8);
        }
        return ((d8 - 1.0d) * (1.0d - d10)) / ((1.0d - d8) - ((d10 - d8) * d11));
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double get(double d8) {
        return func(d8);
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double getDiff(double d8) {
        return dfunc(d8);
    }
}
