package com.google.gson;

import j$.util.Objects;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h extends d {

    /* renamed from: a, reason: collision with root package name */
    public final Serializable f2465a;

    public h(Boolean bool) {
        Objects.requireNonNull(bool);
        this.f2465a = bool;
    }

    public static boolean e(h hVar) {
        Serializable serializable = hVar.f2465a;
        if (!(serializable instanceof Number)) {
            return false;
        }
        Number number = (Number) serializable;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    public final BigInteger b() {
        Serializable serializable = this.f2465a;
        if (serializable instanceof BigInteger) {
            return (BigInteger) serializable;
        }
        if (e(this)) {
            return BigInteger.valueOf(c().longValue());
        }
        String strD = d();
        com.google.gson.internal.f.c(strD);
        return new BigInteger(strD);
    }

    public final Number c() {
        Serializable serializable = this.f2465a;
        if (serializable instanceof Number) {
            return (Number) serializable;
        }
        if (serializable instanceof String) {
            return new com.google.gson.internal.h((String) serializable);
        }
        a2.a.m("Primitive is neither a number nor a string");
        return null;
    }

    public final String d() {
        Serializable serializable = this.f2465a;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        if (serializable instanceof Number) {
            return c().toString();
        }
        if (serializable instanceof Boolean) {
            return ((Boolean) serializable).toString();
        }
        throw new AssertionError("Unexpected value type: " + serializable.getClass());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        Serializable serializable = hVar.f2465a;
        Serializable serializable2 = this.f2465a;
        if (serializable2 == null) {
            return serializable == null;
        }
        if (e(this) && e(hVar)) {
            return ((serializable2 instanceof BigInteger) || (serializable instanceof BigInteger)) ? b().equals(hVar.b()) : c().longValue() == hVar.c().longValue();
        }
        if (!(serializable2 instanceof Number) || !(serializable instanceof Number)) {
            return serializable2.equals(serializable);
        }
        if ((serializable2 instanceof BigDecimal) && (serializable instanceof BigDecimal)) {
            return (serializable2 instanceof BigDecimal ? (BigDecimal) serializable2 : com.google.gson.internal.f.i(d())).compareTo(serializable instanceof BigDecimal ? (BigDecimal) serializable : com.google.gson.internal.f.i(hVar.d())) == 0;
        }
        double dDoubleValue = serializable2 instanceof Number ? c().doubleValue() : Double.parseDouble(d());
        double dDoubleValue2 = serializable instanceof Number ? hVar.c().doubleValue() : Double.parseDouble(hVar.d());
        if (dDoubleValue != dDoubleValue2) {
            return Double.isNaN(dDoubleValue) && Double.isNaN(dDoubleValue2);
        }
        return true;
    }

    public final int hashCode() {
        long jDoubleToLongBits;
        Serializable serializable = this.f2465a;
        if (serializable == null) {
            return 31;
        }
        if (e(this)) {
            jDoubleToLongBits = c().longValue();
        } else {
            if (!(serializable instanceof Number)) {
                return serializable.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(c().doubleValue());
        }
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }

    public h(Number number) {
        Objects.requireNonNull(number);
        this.f2465a = number;
    }

    public h(String str) {
        Objects.requireNonNull(str);
        this.f2465a = str;
    }
}
