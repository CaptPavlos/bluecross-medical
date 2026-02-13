package androidx.core.util;

import androidx.annotation.RestrictTo;
import java.io.PrintWriter;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class TimeUtils {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int HUNDRED_DAY_FIELD_LEN = 19;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static final Object sFormatSync = new Object();
    private static char[] sFormatStr = new char[24];

    private TimeUtils() {
    }

    private static int accumField(int i10, int i11, boolean z9, int i12) {
        if (i10 > 99 || (z9 && i12 >= 3)) {
            return i11 + 3;
        }
        if (i10 > 9 || (z9 && i12 >= 2)) {
            return i11 + 2;
        }
        if (z9 || i10 > 0) {
            return i11 + 1;
        }
        return 0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j10, PrintWriter printWriter, int i10) {
        synchronized (sFormatSync) {
            printWriter.print(new String(sFormatStr, 0, formatDurationLocked(j10, i10)));
        }
    }

    private static int formatDurationLocked(long j10, int i10) {
        char c10;
        int i11;
        int i12;
        int i13;
        int i14;
        long j11 = j10;
        if (sFormatStr.length < i10) {
            sFormatStr = new char[i10];
        }
        char[] cArr = sFormatStr;
        if (j11 == 0) {
            int i15 = i10 - 1;
            while (i15 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (j11 > 0) {
            c10 = '+';
        } else {
            j11 = -j11;
            c10 = '-';
        }
        int i16 = (int) (j11 % 1000);
        int iFloor = (int) Math.floor(j11 / 1000);
        if (iFloor > SECONDS_PER_DAY) {
            i11 = iFloor / SECONDS_PER_DAY;
            iFloor -= SECONDS_PER_DAY * i11;
        } else {
            i11 = 0;
        }
        if (iFloor > SECONDS_PER_HOUR) {
            i12 = iFloor / SECONDS_PER_HOUR;
            iFloor -= i12 * SECONDS_PER_HOUR;
        } else {
            i12 = 0;
        }
        if (iFloor > 60) {
            int i17 = iFloor / 60;
            iFloor -= i17 * 60;
            i13 = i17;
        } else {
            i13 = 0;
        }
        if (i10 != 0) {
            int iAccumField = accumField(i11, 1, false, 0);
            int iAccumField2 = iAccumField + accumField(i12, 1, iAccumField > 0, 2);
            int iAccumField3 = iAccumField2 + accumField(i13, 1, iAccumField2 > 0, 2);
            int iAccumField4 = iAccumField3 + accumField(iFloor, 1, iAccumField3 > 0, 2);
            i14 = 0;
            for (int iAccumField5 = accumField(i16, 2, true, iAccumField4 > 0 ? 3 : 0) + 1 + iAccumField4; iAccumField5 < i10; iAccumField5++) {
                cArr[i14] = ' ';
                i14++;
            }
        } else {
            i14 = 0;
        }
        cArr[i14] = c10;
        int i18 = i14 + 1;
        boolean z9 = i10 != 0;
        int iPrintField = printField(cArr, i11, 'd', i18, false, 0);
        int iPrintField2 = printField(cArr, i12, 'h', iPrintField, iPrintField != i18, z9 ? 2 : 0);
        int iPrintField3 = printField(cArr, i13, 'm', iPrintField2, iPrintField2 != i18, z9 ? 2 : 0);
        int iPrintField4 = printField(cArr, iFloor, 's', iPrintField3, iPrintField3 != i18, z9 ? 2 : 0);
        int iPrintField5 = printField(cArr, i16, 'm', iPrintField4, true, (!z9 || iPrintField4 == i18) ? 0 : 3);
        cArr[iPrintField5] = 's';
        return iPrintField5 + 1;
    }

    private static int printField(char[] cArr, int i10, char c10, int i11, boolean z9, int i12) {
        int i13;
        if (!z9 && i10 <= 0) {
            return i11;
        }
        if ((!z9 || i12 < 3) && i10 <= 99) {
            i13 = i11;
        } else {
            int i14 = i10 / 100;
            cArr[i11] = (char) (i14 + 48);
            i13 = i11 + 1;
            i10 -= i14 * 100;
        }
        if ((z9 && i12 >= 2) || i10 > 9 || i11 != i13) {
            int i15 = i10 / 10;
            cArr[i13] = (char) (i15 + 48);
            i13++;
            i10 -= i15 * 10;
        }
        cArr[i13] = (char) (i10 + 48);
        cArr[i13 + 1] = c10;
        return i13 + 2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j10, StringBuilder sb) {
        synchronized (sFormatSync) {
            sb.append(sFormatStr, 0, formatDurationLocked(j10, 0));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j10, PrintWriter printWriter) {
        formatDuration(j10, printWriter, 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j10, long j11, PrintWriter printWriter) {
        if (j10 == 0) {
            printWriter.print("--");
        } else {
            formatDuration(j10 - j11, printWriter, 0);
        }
    }
}
