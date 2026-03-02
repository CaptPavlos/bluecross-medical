package o7;

import com.google.android.gms.internal.measurement.a4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import l4.i3;
import z1.t1;

/* loaded from: classes3.dex */
public abstract class m extends u {
    public static boolean d0(CharSequence charSequence, CharSequence charSequence2, boolean z9) {
        charSequence.getClass();
        charSequence2.getClass();
        if (charSequence2 instanceof String) {
            if (k0(charSequence, (String) charSequence2, 0, z9, 2) >= 0) {
                return true;
            }
        } else if (i0(charSequence, charSequence2, 0, charSequence.length(), z9, false) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean e0(String str, char c10) {
        str.getClass();
        return j0(str, c10, 0, 2) >= 0;
    }

    public static String f0(int i10, String str) {
        str.getClass();
        if (i10 < 0) {
            z8.f.b(a3.a.g(i10, "Requested character count ", " is less than zero."));
            return null;
        }
        int length = str.length();
        if (i10 > length) {
            i10 = length;
        }
        return str.substring(i10);
    }

    public static int g0(CharSequence charSequence) {
        charSequence.getClass();
        return charSequence.length() - 1;
    }

    public static final int h0(CharSequence charSequence, String str, int i10, boolean z9) {
        charSequence.getClass();
        str.getClass();
        return (z9 || !(charSequence instanceof String)) ? i0(charSequence, str, i10, charSequence.length(), z9, false) : ((String) charSequence).indexOf(str, i10);
    }

    public static final int i0(CharSequence charSequence, CharSequence charSequence2, int i10, int i11, boolean z9, boolean z10) {
        l7.b bVar;
        CharSequence charSequence3 = charSequence2;
        int i12 = i10;
        int i13 = i11;
        if (z10) {
            int iG0 = g0(charSequence);
            if (i12 > iG0) {
                i12 = iG0;
            }
            if (i13 < 0) {
                i13 = 0;
            }
            bVar = new l7.b(i12, i13, -1);
        } else {
            if (i12 < 0) {
                i12 = 0;
            }
            int length = charSequence.length();
            if (i13 > length) {
                i13 = length;
            }
            bVar = new l7.d(i12, i13, 1);
        }
        boolean z11 = charSequence instanceof String;
        int i14 = bVar.f11086c;
        int i15 = bVar.f11085b;
        int i16 = bVar.f11084a;
        if (z11 && (charSequence3 instanceof String)) {
            if ((i14 > 0 && i16 <= i15) || (i14 < 0 && i15 <= i16)) {
                int i17 = i16;
                while (true) {
                    String str = (String) charSequence3;
                    String str2 = (String) charSequence;
                    int length2 = str.length();
                    if (!(!z9 ? str.regionMatches(0, str2, i17, length2) : str.regionMatches(z9, 0, str2, i17, length2))) {
                        if (i17 == i15) {
                            break;
                        }
                        i17 += i14;
                    } else {
                        return i17;
                    }
                }
            }
        } else if ((i14 > 0 && i16 <= i15) || (i14 < 0 && i15 <= i16)) {
            int i18 = i16;
            while (!q0(charSequence3, 0, charSequence, i18, charSequence3.length(), z9)) {
                if (i18 != i15) {
                    i18 += i14;
                    charSequence3 = charSequence2;
                }
            }
            return i18;
        }
        return -1;
    }

    public static int j0(CharSequence charSequence, char c10, int i10, int i11) {
        char c11 = 0;
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        charSequence.getClass();
        if (charSequence instanceof String) {
            return ((String) charSequence).indexOf(c10, i10);
        }
        char[] cArr = {c10};
        if (charSequence instanceof String) {
            int length = cArr.length;
            if (length == 0) {
                com.google.gson.internal.a.o("Array is empty.");
            } else if (length == 1) {
                c11 = cArr[0];
            } else {
                com.google.gson.internal.a.n("Array has more than one element.");
            }
            return ((String) charSequence).indexOf(c11, i10);
        }
        if (i10 < 0) {
            i10 = 0;
        }
        int length2 = charSequence.length() - 1;
        if (i10 > length2) {
            return -1;
        }
        while (!t1.n(cArr[0], charSequence.charAt(i10), false)) {
            if (i10 == length2) {
                return -1;
            }
            i10++;
        }
        return i10;
    }

    public static /* synthetic */ int k0(CharSequence charSequence, String str, int i10, boolean z9, int i11) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z9 = false;
        }
        return h0(charSequence, str, i10, z9);
    }

    public static boolean l0(CharSequence charSequence) {
        charSequence.getClass();
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            if (!t1.F(charSequence.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    public static int m0(String str, CharSequence charSequence, int i10) {
        int iG0 = (i10 & 2) != 0 ? g0(charSequence) : 0;
        charSequence.getClass();
        str.getClass();
        return !(charSequence instanceof String) ? i0(charSequence, str, iG0, 0, false, true) : ((String) charSequence).lastIndexOf(str, iG0);
    }

    public static List n0(String str) {
        g gVar = new g(str);
        if (!gVar.hasNext()) {
            return t6.t.f12808a;
        }
        Object next = gVar.next();
        if (!gVar.hasNext()) {
            return a4.u(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (gVar.hasNext()) {
            arrayList.add(gVar.next());
        }
        return arrayList;
    }

    public static String o0(int i10, String str) {
        CharSequence charSequenceSubSequence;
        str.getClass();
        if (i10 < 0) {
            com.google.gson.internal.a.n(a3.a.g(i10, "Desired length ", " is less than zero."));
            return null;
        }
        if (i10 <= str.length()) {
            charSequenceSubSequence = str.subSequence(0, str.length());
        } else {
            StringBuilder sb = new StringBuilder(i10);
            sb.append((CharSequence) str);
            int length = i10 - str.length();
            int i11 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append('0');
                    if (i11 == length) {
                        break;
                    }
                    i11++;
                }
            }
            charSequenceSubSequence = sb;
        }
        return charSequenceSubSequence.toString();
    }

    public static String p0(int i10, String str) {
        CharSequence charSequenceSubSequence;
        str.getClass();
        if (i10 < 0) {
            com.google.gson.internal.a.n(a3.a.g(i10, "Desired length ", " is less than zero."));
            return null;
        }
        if (i10 <= str.length()) {
            charSequenceSubSequence = str.subSequence(0, str.length());
        } else {
            StringBuilder sb = new StringBuilder(i10);
            int length = i10 - str.length();
            int i11 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append('0');
                    if (i11 == length) {
                        break;
                    }
                    i11++;
                }
            }
            sb.append((CharSequence) str);
            charSequenceSubSequence = sb;
        }
        return charSequenceSubSequence.toString();
    }

    public static final boolean q0(CharSequence charSequence, int i10, CharSequence charSequence2, int i11, int i12, boolean z9) {
        charSequence.getClass();
        charSequence2.getClass();
        if (i11 < 0 || i10 < 0 || i10 > charSequence.length() - i12 || i11 > charSequence2.length() - i12) {
            return false;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            if (!t1.n(charSequence.charAt(i10 + i13), charSequence2.charAt(i11 + i13), z9)) {
                return false;
            }
        }
        return true;
    }

    public static final List r0(String str, CharSequence charSequence) {
        int iH0 = h0(charSequence, str, 0, false);
        if (iH0 == -1) {
            return a4.u(charSequence.toString());
        }
        ArrayList arrayList = new ArrayList(10);
        int length = 0;
        do {
            arrayList.add(charSequence.subSequence(length, iH0).toString());
            length = str.length() + iH0;
            iH0 = h0(charSequence, str, length, false);
        } while (iH0 != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static List s0(String str, String[] strArr) {
        str.getClass();
        if (strArr.length == 1) {
            String str2 = strArr[0];
            if (str2.length() != 0) {
                return r0(str2, str);
            }
        }
        List listAsList = Arrays.asList(strArr);
        listAsList.getClass();
        n7.k kVar = new n7.k(new n7.d(str, new i3(listAsList, 2)), 0);
        ArrayList arrayList = new ArrayList(t6.n.V(kVar, 10));
        Iterator it = kVar.iterator();
        while (true) {
            b bVar = (b) it;
            if (!bVar.hasNext()) {
                return arrayList;
            }
            l7.d dVar = (l7.d) bVar.next();
            dVar.getClass();
            arrayList.add(str.subSequence(dVar.f11084a, dVar.f11085b + 1).toString());
        }
    }

    public static String t0(String str, String str2) {
        int iK0 = k0(str, str2, 0, false, 6);
        return iK0 == -1 ? str : str.substring(str2.length() + iK0, str.length());
    }

    public static String u0(String str) {
        int length = str.length();
        if (127 <= length) {
            length = 127;
        }
        return str.substring(0, length);
    }

    public static CharSequence v0(CharSequence charSequence) {
        charSequence.getClass();
        int length = charSequence.length() - 1;
        int i10 = 0;
        boolean z9 = false;
        while (i10 <= length) {
            boolean zF = t1.F(charSequence.charAt(!z9 ? i10 : length));
            if (z9) {
                if (!zF) {
                    break;
                }
                length--;
            } else if (zF) {
                i10++;
            } else {
                z9 = true;
            }
        }
        return charSequence.subSequence(i10, length + 1);
    }
}
