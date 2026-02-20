package c1;

import android.os.Bundle;
import j$.util.Objects;
import java.util.EnumMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p {
    public static final p f = new p((Boolean) null, 100, (Boolean) null, (String) null);

    /* renamed from: a, reason: collision with root package name */
    public final int f1393a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1394b;

    /* renamed from: c, reason: collision with root package name */
    public final Boolean f1395c;

    /* renamed from: d, reason: collision with root package name */
    public final String f1396d;
    public final EnumMap e;

    public p(Boolean bool, int i10, Boolean bool2, String str) {
        EnumMap enumMap = new EnumMap(j2.class);
        this.e = enumMap;
        enumMap.put((EnumMap) j2.AD_USER_DATA, (j2) (bool == null ? h2.UNINITIALIZED : bool.booleanValue() ? h2.GRANTED : h2.DENIED));
        this.f1393a = i10;
        this.f1394b = d();
        this.f1395c = bool2;
        this.f1396d = str;
    }

    public static p b(String str) throws NumberFormatException {
        if (str == null || str.length() <= 0) {
            return f;
        }
        String[] strArrSplit = str.split(":");
        int i10 = Integer.parseInt(strArrSplit[0]);
        EnumMap enumMap = new EnumMap(j2.class);
        j2[] j2VarArr = i2.DMA.f1273a;
        int length = j2VarArr.length;
        int i11 = 1;
        int i12 = 0;
        while (i12 < length) {
            enumMap.put((EnumMap) j2VarArr[i12], (j2) k2.e(strArrSplit[i11].charAt(0)));
            i12++;
            i11++;
        }
        return new p(enumMap, i10, (Boolean) null, (String) null);
    }

    public static p c(int i10, Bundle bundle) {
        if (bundle == null) {
            return new p((Boolean) null, i10, (Boolean) null, (String) null);
        }
        EnumMap enumMap = new EnumMap(j2.class);
        for (j2 j2Var : i2.DMA.f1273a) {
            enumMap.put((EnumMap) j2Var, (j2) k2.d(bundle.getString(j2Var.f1290a)));
        }
        return new p(enumMap, i10, bundle.containsKey("is_dma_region") ? Boolean.valueOf(bundle.getString("is_dma_region")) : null, bundle.getString("cps_display_str"));
    }

    public final h2 a() {
        h2 h2Var = (h2) this.e.get(j2.AD_USER_DATA);
        return h2Var == null ? h2.UNINITIALIZED : h2Var;
    }

    public final String d() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1393a);
        for (j2 j2Var : i2.DMA.f1273a) {
            sb.append(":");
            sb.append(k2.h((h2) this.e.get(j2Var)));
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        if (this.f1394b.equalsIgnoreCase(pVar.f1394b) && Objects.equals(this.f1395c, pVar.f1395c)) {
            return Objects.equals(this.f1396d, pVar.f1396d);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.f1395c;
        int i10 = bool == null ? 3 : true != bool.booleanValue() ? 13 : 7;
        String str = this.f1396d;
        return ((str == null ? 17 : str.hashCode()) * 137) + this.f1394b.hashCode() + (i10 * 29);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(k2.a(this.f1393a));
        for (j2 j2Var : i2.DMA.f1273a) {
            sb.append(",");
            sb.append(j2Var.f1290a);
            sb.append("=");
            h2 h2Var = (h2) this.e.get(j2Var);
            if (h2Var == null) {
                sb.append("uninitialized");
            } else {
                int iOrdinal = h2Var.ordinal();
                if (iOrdinal == 0) {
                    sb.append("uninitialized");
                } else if (iOrdinal == 1) {
                    sb.append("eu_consent_policy");
                } else if (iOrdinal == 2) {
                    sb.append("denied");
                } else if (iOrdinal == 3) {
                    sb.append("granted");
                }
            }
        }
        Boolean bool = this.f1395c;
        if (bool != null) {
            sb.append(",isDmaRegion=");
            sb.append(bool);
        }
        String str = this.f1396d;
        if (str != null) {
            sb.append(",cpsDisplayStr=");
            sb.append(str);
        }
        return sb.toString();
    }

    public p(EnumMap enumMap, int i10, Boolean bool, String str) {
        EnumMap enumMap2 = new EnumMap(j2.class);
        this.e = enumMap2;
        enumMap2.putAll(enumMap);
        this.f1393a = i10;
        this.f1394b = d();
        this.f1395c = bool;
        this.f1396d = str;
    }
}
