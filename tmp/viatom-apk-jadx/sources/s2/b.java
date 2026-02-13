package s2;

import r1.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {
    public static final /* synthetic */ int h = 0;

    /* renamed from: a, reason: collision with root package name */
    public final String f12522a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12523b;

    /* renamed from: c, reason: collision with root package name */
    public final String f12524c;

    /* renamed from: d, reason: collision with root package name */
    public final String f12525d;
    public final long e;
    public final long f;
    public final String g;

    static {
        byte b10 = (byte) (((byte) (0 | 2)) | 1);
        if (b10 == 3) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        if ((b10 & 1) == 0) {
            sb.append(" expiresInSecs");
        }
        if ((b10 & 2) == 0) {
            sb.append(" tokenCreationEpochInSecs");
        }
        androidx.window.layout.c.g(i.e(sb, "Missing required properties:"));
    }

    public b(String str, int i10, String str2, String str3, long j10, long j11, String str4) {
        this.f12522a = str;
        this.f12523b = i10;
        this.f12524c = str2;
        this.f12525d = str3;
        this.e = j10;
        this.f = j11;
        this.g = str4;
    }

    public final a a() {
        a aVar = new a();
        aVar.f12518a = this.f12522a;
        aVar.f12519b = this.f12523b;
        aVar.f12520c = this.f12524c;
        aVar.f12521d = this.f12525d;
        aVar.e = this.e;
        aVar.f = this.f;
        aVar.g = this.g;
        aVar.h = (byte) 3;
        return aVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        String str = bVar.f12522a;
        String str2 = this.f12522a;
        if (str2 == null) {
            if (str != null) {
                return false;
            }
        } else if (!str2.equals(str)) {
            return false;
        }
        if (!c.i.a(this.f12523b, bVar.f12523b)) {
            return false;
        }
        String str3 = bVar.f12524c;
        String str4 = this.f12524c;
        if (str4 == null) {
            if (str3 != null) {
                return false;
            }
        } else if (!str4.equals(str3)) {
            return false;
        }
        String str5 = bVar.f12525d;
        String str6 = this.f12525d;
        if (str6 == null) {
            if (str5 != null) {
                return false;
            }
        } else if (!str6.equals(str5)) {
            return false;
        }
        if (this.e != bVar.e || this.f != bVar.f) {
            return false;
        }
        String str7 = bVar.g;
        String str8 = this.g;
        return str8 == null ? str7 == null : str8.equals(str7);
    }

    public final int hashCode() {
        String str = this.f12522a;
        int iHashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ c.i.c(this.f12523b)) * 1000003;
        String str2 = this.f12524c;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f12525d;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        long j10 = this.e;
        int i10 = (iHashCode3 ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        long j11 = this.f;
        int i11 = (i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        String str4 = this.g;
        return (str4 != null ? str4.hashCode() : 0) ^ i11;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PersistedInstallationEntry{firebaseInstallationId=");
        sb.append(this.f12522a);
        sb.append(", registrationStatus=");
        int i10 = this.f12523b;
        sb.append(i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? i10 != 5 ? "null" : "REGISTER_ERROR" : "REGISTERED" : "UNREGISTERED" : "NOT_GENERATED" : "ATTEMPT_MIGRATION");
        sb.append(", authToken=");
        sb.append(this.f12524c);
        sb.append(", refreshToken=");
        sb.append(this.f12525d);
        sb.append(", expiresInSecs=");
        sb.append(this.e);
        sb.append(", tokenCreationEpochInSecs=");
        sb.append(this.f);
        sb.append(", fisError=");
        return a3.a.o(sb, this.g, "}");
    }
}
