package j$.time.format;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/* loaded from: classes2.dex */
public final class g extends i {
    public final boolean g;

    public g(j$.time.temporal.q qVar, int i10, int i11, boolean z9, int i12) {
        super(qVar, i10, i11, u.NOT_NEGATIVE, i12);
        this.g = z9;
    }

    @Override // j$.time.format.i
    public final i a() {
        if (this.e == -1) {
            return this;
        }
        return new g(this.f9220a, this.f9221b, this.f9222c, this.g, -1);
    }

    @Override // j$.time.format.i
    public final i b(int i10) {
        return new g(this.f9220a, this.f9221b, this.f9222c, this.g, this.e + i10);
    }

    @Override // j$.time.format.i, j$.time.format.f
    public final boolean e(p pVar, StringBuilder sb) {
        j$.time.temporal.q qVar = this.f9220a;
        Long lA = pVar.a(qVar);
        if (lA == null) {
            return false;
        }
        s sVar = pVar.f9243b.f9210c;
        long jLongValue = lA.longValue();
        j$.time.temporal.u uVarRange = qVar.range();
        uVarRange.b(jLongValue, qVar);
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(uVarRange.f9304a);
        BigDecimal bigDecimalAdd = BigDecimal.valueOf(uVarRange.f9307d).subtract(bigDecimalValueOf).add(BigDecimal.ONE);
        BigDecimal bigDecimalSubtract = BigDecimal.valueOf(jLongValue).subtract(bigDecimalValueOf);
        RoundingMode roundingMode = RoundingMode.FLOOR;
        BigDecimal bigDecimalDivide = bigDecimalSubtract.divide(bigDecimalAdd, 9, roundingMode);
        BigDecimal bigDecimal = BigDecimal.ZERO;
        if (bigDecimalDivide.compareTo(bigDecimal) != 0) {
            bigDecimal = bigDecimalDivide.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : bigDecimalDivide.stripTrailingZeros();
        }
        int iScale = bigDecimal.scale();
        boolean z9 = this.g;
        int i10 = this.f9221b;
        if (iScale != 0) {
            String strSubstring = bigDecimal.setScale(Math.min(Math.max(bigDecimal.scale(), i10), this.f9222c), roundingMode).toPlainString().substring(2);
            sVar.getClass();
            if (z9) {
                sb.append('.');
            }
            sb.append(strSubstring);
            return true;
        }
        if (i10 > 0) {
            if (z9) {
                sVar.getClass();
                sb.append('.');
            }
            for (int i11 = 0; i11 < i10; i11++) {
                sVar.getClass();
                sb.append('0');
            }
        }
        return true;
    }

    @Override // j$.time.format.i
    public final String toString() {
        return "Fraction(" + this.f9220a + "," + this.f9221b + "," + this.f9222c + (this.g ? ",DecimalPoint" : "") + ")";
    }
}
