package o;

import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class s extends e0 {

    /* renamed from: a, reason: collision with root package name */
    public final long f11646a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f11647b;

    /* renamed from: c, reason: collision with root package name */
    public final a0 f11648c;

    /* renamed from: d, reason: collision with root package name */
    public final long f11649d;
    public final byte[] e;
    public final String f;
    public final long g;
    public final i0 h;

    /* renamed from: i, reason: collision with root package name */
    public final b0 f11650i;

    public s(long j10, Integer num, a0 a0Var, long j11, byte[] bArr, String str, long j12, i0 i0Var, b0 b0Var) {
        this.f11646a = j10;
        this.f11647b = num;
        this.f11648c = a0Var;
        this.f11649d = j11;
        this.e = bArr;
        this.f = str;
        this.g = j12;
        this.h = i0Var;
        this.f11650i = b0Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e0) {
            e0 e0Var = (e0) obj;
            s sVar = (s) e0Var;
            if (this.f11646a == sVar.f11646a) {
                Integer num = sVar.f11647b;
                Integer num2 = this.f11647b;
                if (num2 != null ? num2.equals(num) : num == null) {
                    a0 a0Var = sVar.f11648c;
                    a0 a0Var2 = this.f11648c;
                    if (a0Var2 != null ? a0Var2.equals(a0Var) : a0Var == null) {
                        if (this.f11649d == sVar.f11649d) {
                            if (Arrays.equals(this.e, e0Var instanceof s ? ((s) e0Var).e : sVar.e)) {
                                String str = sVar.f;
                                String str2 = this.f;
                                if (str2 != null ? str2.equals(str) : str == null) {
                                    if (this.g == sVar.g) {
                                        i0 i0Var = sVar.h;
                                        i0 i0Var2 = this.h;
                                        if (i0Var2 != null ? i0Var2.equals(i0Var) : i0Var == null) {
                                            b0 b0Var = sVar.f11650i;
                                            b0 b0Var2 = this.f11650i;
                                            if (b0Var2 != null ? b0Var2.equals(b0Var) : b0Var == null) {
                                                return true;
                                            }
                                        }
                                    }
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
        long j10 = this.f11646a;
        int i10 = (((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f11647b;
        int iHashCode = (i10 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        a0 a0Var = this.f11648c;
        int iHashCode2 = (iHashCode ^ (a0Var == null ? 0 : a0Var.hashCode())) * 1000003;
        long j11 = this.f11649d;
        int iHashCode3 = (((iHashCode2 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.e)) * 1000003;
        String str = this.f;
        int iHashCode4 = (iHashCode3 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j12 = this.g;
        int i11 = (iHashCode4 ^ ((int) (j12 ^ (j12 >>> 32)))) * 1000003;
        i0 i0Var = this.h;
        int iHashCode5 = (i11 ^ (i0Var == null ? 0 : i0Var.hashCode())) * 1000003;
        b0 b0Var = this.f11650i;
        return iHashCode5 ^ (b0Var != null ? b0Var.hashCode() : 0);
    }

    public final String toString() {
        return "LogEvent{eventTimeMs=" + this.f11646a + ", eventCode=" + this.f11647b + ", complianceData=" + this.f11648c + ", eventUptimeMs=" + this.f11649d + ", sourceExtension=" + Arrays.toString(this.e) + ", sourceExtensionJsonProto3=" + this.f + ", timezoneOffsetSeconds=" + this.g + ", networkConnectionInfo=" + this.h + ", experimentIds=" + this.f11650i + "}";
    }
}
