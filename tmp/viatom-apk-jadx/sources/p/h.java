package p;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final String f11849a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f11850b;

    /* renamed from: c, reason: collision with root package name */
    public final k f11851c;

    /* renamed from: d, reason: collision with root package name */
    public final long f11852d;
    public final long e;
    public final Map f;
    public final Integer g;
    public final String h;

    /* renamed from: i, reason: collision with root package name */
    public final byte[] f11853i;

    /* renamed from: j, reason: collision with root package name */
    public final byte[] f11854j;

    public h(String str, Integer num, k kVar, long j10, long j11, HashMap map, Integer num2, String str2, byte[] bArr, byte[] bArr2) {
        this.f11849a = str;
        this.f11850b = num;
        this.f11851c = kVar;
        this.f11852d = j10;
        this.e = j11;
        this.f = map;
        this.g = num2;
        this.h = str2;
        this.f11853i = bArr;
        this.f11854j = bArr2;
    }

    public final String a(String str) {
        String str2 = (String) this.f.get(str);
        return str2 == null ? "" : str2;
    }

    public final int b(String str) {
        String str2 = (String) this.f.get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    public final d5.h c() {
        d5.h hVar = new d5.h();
        String str = this.f11849a;
        if (str == null) {
            androidx.window.layout.c.k("Null transportName");
            return null;
        }
        hVar.f7082b = str;
        hVar.f = this.f11850b;
        hVar.f7087k = this.g;
        hVar.f7083c = this.h;
        hVar.f7084d = this.f11853i;
        hVar.e = this.f11854j;
        k kVar = this.f11851c;
        if (kVar == null) {
            androidx.window.layout.c.k("Null encodedPayload");
            return null;
        }
        hVar.g = kVar;
        hVar.h = Long.valueOf(this.f11852d);
        hVar.f7085i = Long.valueOf(this.e);
        hVar.f7086j = new HashMap(this.f);
        return hVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (this.f11849a.equals(hVar.f11849a)) {
                Integer num = hVar.f11850b;
                Integer num2 = this.f11850b;
                if (num2 != null ? num2.equals(num) : num == null) {
                    if (this.f11851c.equals(hVar.f11851c) && this.f11852d == hVar.f11852d && this.e == hVar.e && this.f.equals(hVar.f)) {
                        Integer num3 = hVar.g;
                        Integer num4 = this.g;
                        if (num4 != null ? num4.equals(num3) : num3 == null) {
                            String str = hVar.h;
                            String str2 = this.h;
                            if (str2 != null ? str2.equals(str) : str == null) {
                                if (Arrays.equals(this.f11853i, hVar.f11853i) && Arrays.equals(this.f11854j, hVar.f11854j)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f11849a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f11850b;
        int iHashCode2 = (((iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f11851c.hashCode()) * 1000003;
        long j10 = this.f11852d;
        int i10 = (iHashCode2 ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        long j11 = this.e;
        int iHashCode3 = (((i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ this.f.hashCode()) * 1000003;
        Integer num2 = this.g;
        int iHashCode4 = (iHashCode3 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
        String str = this.h;
        return ((((iHashCode4 ^ (str != null ? str.hashCode() : 0)) * 1000003) ^ Arrays.hashCode(this.f11853i)) * 1000003) ^ Arrays.hashCode(this.f11854j);
    }

    public final String toString() {
        return "EventInternal{transportName=" + this.f11849a + ", code=" + this.f11850b + ", encodedPayload=" + this.f11851c + ", eventMillis=" + this.f11852d + ", uptimeMillis=" + this.e + ", autoMetadata=" + this.f + ", productId=" + this.g + ", pseudonymousId=" + this.h + ", experimentIdsClear=" + Arrays.toString(this.f11853i) + ", experimentIdsEncrypted=" + Arrays.toString(this.f11854j) + "}";
    }
}
