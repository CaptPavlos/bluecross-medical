package com.google.android.gms.internal.measurement;

import androidx.exifinterface.media.ExifInterface;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g implements n {

    /* renamed from: a, reason: collision with root package name */
    public final Double f1959a;

    public g(Double d8) {
        if (d8 == null) {
            this.f1959a = Double.valueOf(Double.NaN);
        } else {
            this.f1959a = d8;
        }
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Iterator b() {
        return null;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Boolean e() {
        Double d8 = this.f1959a;
        boolean z9 = false;
        if (!Double.isNaN(d8.doubleValue()) && d8.doubleValue() != 0.0d) {
            z9 = true;
        }
        return Boolean.valueOf(z9);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            return this.f1959a.equals(((g) obj).f1959a);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final String f() throws NumberFormatException {
        Double d8 = this.f1959a;
        if (Double.isNaN(d8.doubleValue())) {
            return "NaN";
        }
        if (Double.isInfinite(d8.doubleValue())) {
            return d8.doubleValue() > 0.0d ? "Infinity" : "-Infinity";
        }
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(d8.doubleValue());
        BigDecimal bigDecimal = bigDecimalValueOf.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : bigDecimalValueOf.stripTrailingZeros();
        DecimalFormat decimalFormat = new DecimalFormat("0E0");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        decimalFormat.setMinimumFractionDigits((bigDecimal.scale() > 0 ? bigDecimal.precision() : bigDecimal.scale()) - 1);
        String str = decimalFormat.format(bigDecimal);
        int iIndexOf = str.indexOf(ExifInterface.LONGITUDE_EAST);
        if (iIndexOf <= 0) {
            return str;
        }
        int i10 = Integer.parseInt(str.substring(iIndexOf + 1));
        return ((i10 >= 0 || i10 <= -7) && (i10 < 0 || i10 >= 21)) ? str.replace("E-", "e-").replace(ExifInterface.LONGITUDE_EAST, "e+") : bigDecimal.toPlainString();
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Double g() {
        return this.f1959a;
    }

    public final int hashCode() {
        return this.f1959a.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n i(String str, w2.r rVar, ArrayList arrayList) throws NumberFormatException {
        if ("toString".equals(str)) {
            return new q(f());
        }
        throw new IllegalArgumentException(f() + "." + str + " is not a function.");
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n l() {
        return new g(this.f1959a);
    }

    public final String toString() {
        return f();
    }
}
