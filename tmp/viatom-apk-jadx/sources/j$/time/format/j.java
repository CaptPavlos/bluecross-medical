package j$.time.format;

import j$.util.Objects;

/* loaded from: classes2.dex */
public final class j implements f {

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f9224d = {"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS", "+HHmmss", "+HH:mm:ss", "+H", "+Hmm", "+H:mm", "+HMM", "+H:MM", "+HMMss", "+H:MM:ss", "+HMMSS", "+H:MM:SS", "+Hmmss", "+H:mm:ss"};
    public static final j e = new j("+HH:MM:ss", "Z");

    /* renamed from: a, reason: collision with root package name */
    public final String f9225a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9226b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9227c;

    static {
        new j("+HH:MM:ss", "0");
    }

    public j(String str, String str2) {
        Objects.requireNonNull(str, "pattern");
        Objects.requireNonNull(str2, "noOffsetText");
        for (int i10 = 0; i10 < 22; i10++) {
            if (f9224d[i10].equals(str)) {
                this.f9226b = i10;
                this.f9227c = i10 % 11;
                this.f9225a = str2;
                return;
            }
        }
        j$.time.g.c("Invalid zone offset pattern: ".concat(str));
        throw null;
    }

    @Override // j$.time.format.f
    public final boolean e(p pVar, StringBuilder sb) {
        Long lA = pVar.a(j$.time.temporal.a.OFFSET_SECONDS);
        boolean z9 = false;
        if (lA == null) {
            return false;
        }
        long jLongValue = lA.longValue();
        int i10 = (int) jLongValue;
        if (jLongValue != i10) {
            throw new ArithmeticException();
        }
        String str = this.f9225a;
        if (i10 == 0) {
            sb.append(str);
            return true;
        }
        int iAbs = Math.abs((i10 / 3600) % 100);
        int iAbs2 = Math.abs((i10 / 60) % 60);
        int iAbs3 = Math.abs(i10 % 60);
        int length = sb.length();
        sb.append(i10 < 0 ? "-" : "+");
        if (this.f9226b >= 11 && iAbs < 10) {
            sb.append((char) (iAbs + 48));
        } else {
            a(false, iAbs, sb);
        }
        int i11 = this.f9227c;
        if ((i11 >= 3 && i11 <= 8) || ((i11 >= 9 && iAbs3 > 0) || (i11 >= 1 && iAbs2 > 0))) {
            a(i11 > 0 && i11 % 2 == 0, iAbs2, sb);
            iAbs += iAbs2;
            if (i11 == 7 || i11 == 8 || (i11 >= 5 && iAbs3 > 0)) {
                if (i11 > 0 && i11 % 2 == 0) {
                    z9 = true;
                }
                a(z9, iAbs3, sb);
                iAbs += iAbs3;
            }
        }
        if (iAbs == 0) {
            sb.setLength(length);
            sb.append(str);
        }
        return true;
    }

    public static void a(boolean z9, int i10, StringBuilder sb) {
        sb.append(z9 ? ":" : "");
        sb.append((char) ((i10 / 10) + 48));
        sb.append((char) ((i10 % 10) + 48));
    }

    public final String toString() {
        String strReplace = this.f9225a.replace("'", "''");
        return "Offset(" + f9224d[this.f9226b] + ",'" + strReplace + "')";
    }
}
