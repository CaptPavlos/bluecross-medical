package j$.time.format;

import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;

/* loaded from: classes2.dex */
public final class h implements f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9219a;

    public /* synthetic */ h(int i10) {
        this.f9219a = i10;
    }

    @Override // j$.time.format.f
    public final boolean e(p pVar, StringBuilder sb) {
        switch (this.f9219a) {
            case 0:
                Long lA = pVar.a(j$.time.temporal.a.INSTANT_SECONDS);
                j$.time.temporal.n nVar = pVar.f9242a;
                j$.time.temporal.a aVar = j$.time.temporal.a.NANO_OF_SECOND;
                Long lValueOf = nVar.c(aVar) ? Long.valueOf(nVar.q(aVar)) : null;
                int i10 = 0;
                if (lA == null) {
                    return false;
                }
                long jLongValue = lA.longValue();
                int iA = aVar.f9282b.a(lValueOf != null ? lValueOf.longValue() : 0L, aVar);
                if (jLongValue >= -62167219200L) {
                    long j10 = jLongValue - 253402300800L;
                    long jB = j$.com.android.tools.r8.a.B(j10, 315569520000L) + 1;
                    LocalDateTime localDateTimeZ = LocalDateTime.z(j$.com.android.tools.r8.a.A(j10, 315569520000L) - 62167219200L, 0, ZoneOffset.UTC);
                    if (jB > 0) {
                        sb.append('+');
                        sb.append(jB);
                    }
                    sb.append(localDateTimeZ);
                    if (localDateTimeZ.f9136b.f9259c == 0) {
                        sb.append(":00");
                    }
                } else {
                    long j11 = jLongValue + 62167219200L;
                    long j12 = j11 / 315569520000L;
                    long j13 = j11 % 315569520000L;
                    LocalDateTime localDateTimeZ2 = LocalDateTime.z(j13 - 62167219200L, 0, ZoneOffset.UTC);
                    int length = sb.length();
                    sb.append(localDateTimeZ2);
                    if (localDateTimeZ2.f9136b.f9259c == 0) {
                        sb.append(":00");
                    }
                    if (j12 < 0) {
                        if (localDateTimeZ2.f9135a.f9251a == -10000) {
                            sb.replace(length, length + 2, Long.toString(j12 - 1));
                        } else if (j13 == 0) {
                            sb.insert(length, j12);
                        } else {
                            sb.insert(length + 1, Math.abs(j12));
                        }
                    }
                }
                if (iA > 0) {
                    sb.append('.');
                    int i11 = 100000000;
                    while (true) {
                        if (iA > 0 || i10 % 3 != 0 || i10 < -2) {
                            int i12 = iA / i11;
                            sb.append((char) (i12 + 48));
                            iA -= i12 * i11;
                            i11 /= 10;
                            i10++;
                        }
                    }
                }
                sb.append('Z');
                return true;
            default:
                a aVar2 = n.f;
                j$.time.temporal.n nVar2 = pVar.f9242a;
                Object objK = nVar2.k(aVar2);
                if (objK == null && pVar.f9244c == 0) {
                    throw new j$.time.b("Unable to extract " + aVar2 + " from temporal " + nVar2);
                }
                ZoneId zoneId = (ZoneId) objK;
                if (zoneId == null) {
                    return false;
                }
                sb.append(zoneId.d());
                return true;
        }
    }

    public final String toString() {
        switch (this.f9219a) {
            case 0:
                return "Instant()";
            default:
                return "ZoneRegionId()";
        }
    }
}
