package t6;

import com.google.android.gms.internal.measurement.a4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public abstract class j extends a.a {
    public static boolean f0(int[] iArr, int i10) {
        int length = iArr.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                i11 = -1;
                break;
            }
            if (i10 == iArr[i11]) {
                break;
            }
            i11++;
        }
        return i11 >= 0;
    }

    public static boolean g0(Object[] objArr, Object[] objArr2) {
        if (objArr == objArr2) {
            return true;
        }
        if (objArr.length == objArr2.length) {
            int length = objArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                Object obj = objArr[i10];
                Object obj2 = objArr2[i10];
                if (obj != obj2) {
                    if (obj != null && obj2 != null) {
                        if ((obj instanceof Object[]) && (obj2 instanceof Object[])) {
                            if (!g0((Object[]) obj, (Object[]) obj2)) {
                            }
                        } else if ((obj instanceof byte[]) && (obj2 instanceof byte[])) {
                            if (!Arrays.equals((byte[]) obj, (byte[]) obj2)) {
                            }
                        } else if ((obj instanceof short[]) && (obj2 instanceof short[])) {
                            if (!Arrays.equals((short[]) obj, (short[]) obj2)) {
                            }
                        } else if ((obj instanceof int[]) && (obj2 instanceof int[])) {
                            if (!Arrays.equals((int[]) obj, (int[]) obj2)) {
                            }
                        } else if ((obj instanceof long[]) && (obj2 instanceof long[])) {
                            if (!Arrays.equals((long[]) obj, (long[]) obj2)) {
                            }
                        } else if ((obj instanceof float[]) && (obj2 instanceof float[])) {
                            if (!Arrays.equals((float[]) obj, (float[]) obj2)) {
                            }
                        } else if ((obj instanceof double[]) && (obj2 instanceof double[])) {
                            if (!Arrays.equals((double[]) obj, (double[]) obj2)) {
                            }
                        } else if ((obj instanceof char[]) && (obj2 instanceof char[])) {
                            if (!Arrays.equals((char[]) obj, (char[]) obj2)) {
                            }
                        } else if ((obj instanceof boolean[]) && (obj2 instanceof boolean[])) {
                            if (!Arrays.equals((boolean[]) obj, (boolean[]) obj2)) {
                            }
                        } else if ((obj instanceof s6.o) && (obj2 instanceof s6.o)) {
                            if (!Arrays.equals(((s6.o) obj).f12703a, ((s6.o) obj2).f12703a)) {
                            }
                        } else if ((obj instanceof s6.v) && (obj2 instanceof s6.v)) {
                            if (!Arrays.equals(((s6.v) obj).f12710a, ((s6.v) obj2).f12710a)) {
                            }
                        } else if ((obj instanceof s6.q) && (obj2 instanceof s6.q)) {
                            if (!Arrays.equals(((s6.q) obj).f12705a, ((s6.q) obj2).f12705a)) {
                            }
                        } else if ((obj instanceof s6.s) && (obj2 instanceof s6.s)) {
                            if (!Arrays.equals(((s6.s) obj).f12707a, ((s6.s) obj2).f12707a)) {
                            }
                        } else if (!obj.equals(obj2)) {
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static final void h0(Object[] objArr, StringBuilder sb, ArrayList arrayList) {
        if (arrayList.contains(objArr)) {
            sb.append("[...]");
            return;
        }
        arrayList.add(objArr);
        sb.append('[');
        int length = objArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 != 0) {
                sb.append(", ");
            }
            Object obj = objArr[i10];
            if (obj == null) {
                sb.append("null");
            } else if (obj instanceof Object[]) {
                h0((Object[]) obj, sb, arrayList);
            } else if (obj instanceof byte[]) {
                String string = Arrays.toString((byte[]) obj);
                string.getClass();
                sb.append(string);
            } else if (obj instanceof short[]) {
                String string2 = Arrays.toString((short[]) obj);
                string2.getClass();
                sb.append(string2);
            } else if (obj instanceof int[]) {
                String string3 = Arrays.toString((int[]) obj);
                string3.getClass();
                sb.append(string3);
            } else if (obj instanceof long[]) {
                String string4 = Arrays.toString((long[]) obj);
                string4.getClass();
                sb.append(string4);
            } else if (obj instanceof float[]) {
                String string5 = Arrays.toString((float[]) obj);
                string5.getClass();
                sb.append(string5);
            } else if (obj instanceof double[]) {
                String string6 = Arrays.toString((double[]) obj);
                string6.getClass();
                sb.append(string6);
            } else if (obj instanceof char[]) {
                String string7 = Arrays.toString((char[]) obj);
                string7.getClass();
                sb.append(string7);
            } else if (obj instanceof boolean[]) {
                String string8 = Arrays.toString((boolean[]) obj);
                string8.getClass();
                sb.append(string8);
            } else if (obj instanceof s6.o) {
                sb.append(l.h0(new s6.o(((s6.o) obj).f12703a), ", ", "[", "]", null, 56));
            } else if (obj instanceof s6.v) {
                sb.append(l.h0(new s6.v(((s6.v) obj).f12710a), ", ", "[", "]", null, 56));
            } else if (obj instanceof s6.q) {
                sb.append(l.h0(new s6.q(((s6.q) obj).f12705a), ", ", "[", "]", null, 56));
            } else if (obj instanceof s6.s) {
                sb.append(l.h0(new s6.s(((s6.s) obj).f12707a), ", ", "[", "]", null, 56));
            } else {
                sb.append(obj.toString());
            }
        }
        sb.append(']');
        arrayList.remove(arrayList.size() - 1);
    }

    public static void i0(int i10, int i11, int i12, Object[] objArr, Object[] objArr2) {
        objArr.getClass();
        objArr2.getClass();
        System.arraycopy(objArr, i11, objArr2, i10, i12 - i11);
    }

    public static void j0(int i10, int i11, int[] iArr, int[] iArr2, int i12) {
        iArr.getClass();
        iArr2.getClass();
        System.arraycopy(iArr, i11, iArr2, i10, i12 - i11);
    }

    public static void k0(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        bArr.getClass();
        bArr2.getClass();
        System.arraycopy(bArr, i11, bArr2, i10, i12 - i11);
    }

    public static void l0(float[] fArr, int i10, float[] fArr2, int i11, int i12) {
        fArr.getClass();
        fArr2.getClass();
        System.arraycopy(fArr, i11, fArr2, i10, i12 - i11);
    }

    public static void m0(long[] jArr, long[] jArr2, int i10, int i11, int i12) {
        jArr.getClass();
        jArr2.getClass();
        System.arraycopy(jArr, i11, jArr2, i10, i12 - i11);
    }

    public static /* synthetic */ void n0(int i10, int i11, int[] iArr, int[] iArr2, int i12) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 8) != 0) {
            i11 = iArr.length;
        }
        j0(i10, 0, iArr, iArr2, i11);
    }

    public static /* synthetic */ void o0(Object[] objArr, Object[] objArr2, int i10, int i11, int i12, int i13) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = objArr.length;
        }
        i0(i10, i11, i12, objArr, objArr2);
    }

    public static Object[] p0(Object[] objArr, int i10, int i11) {
        objArr.getClass();
        a.a.m(i11, objArr.length);
        Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr, i10, i11);
        objArrCopyOfRange.getClass();
        return objArrCopyOfRange;
    }

    public static void q0(Object obj, Object[] objArr, int i10, int i11) {
        objArr.getClass();
        Arrays.fill(objArr, i10, i11, obj);
    }

    public static void r0(long[] jArr) {
        int length = jArr.length;
        jArr.getClass();
        Arrays.fill(jArr, 0, length, -9187201950435737472L);
    }

    public static ArrayList t0(Object[] objArr) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static int u0(int[] iArr) {
        if (iArr.length != 0) {
            return iArr[0];
        }
        com.google.gson.internal.a.o("Array is empty.");
        return 0;
    }

    public static int v0(Object[] objArr, Object obj) {
        objArr.getClass();
        int i10 = 0;
        if (obj == null) {
            int length = objArr.length;
            while (i10 < length) {
                if (objArr[i10] == null) {
                    return i10;
                }
                i10++;
            }
            return -1;
        }
        int length2 = objArr.length;
        while (i10 < length2) {
            if (obj.equals(objArr[i10])) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static String w0(String str, int i10, byte[] bArr) {
        c9.a aVar = c9.a.f1819c;
        String str2 = (i10 & 2) != 0 ? "" : "[";
        String str3 = (i10 & 4) == 0 ? "]" : "";
        if ((i10 & 32) != 0) {
            aVar = null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) str2);
        int i11 = 0;
        for (byte b10 : bArr) {
            i11++;
            if (i11 > 1) {
                sb.append((CharSequence) str);
            }
            if (aVar != null) {
                sb.append((CharSequence) aVar.invoke(Byte.valueOf(b10)));
            } else {
                sb.append((CharSequence) String.valueOf((int) b10));
            }
        }
        sb.append((CharSequence) str3);
        return sb.toString();
    }

    public static List x0(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return t.f12808a;
        }
        if (length == 1) {
            return a4.u(Integer.valueOf(iArr[0]));
        }
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i10 : iArr) {
            arrayList.add(Integer.valueOf(i10));
        }
        return arrayList;
    }

    public static List y0(Object[] objArr) {
        objArr.getClass();
        int length = objArr.length;
        return length != 0 ? length != 1 ? new ArrayList(new h(objArr, false)) : a4.u(objArr[0]) : t.f12808a;
    }

    public static Set z0(Object[] objArr) {
        objArr.getClass();
        int length = objArr.length;
        if (length == 0) {
            return v.f12810a;
        }
        if (length == 1) {
            Set setSingleton = Collections.singleton(objArr[0]);
            setSingleton.getClass();
            return setSingleton;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(a0.h0(objArr.length));
        for (Object obj : objArr) {
            linkedHashSet.add(obj);
        }
        return linkedHashSet;
    }
}
