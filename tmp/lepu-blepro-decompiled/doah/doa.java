/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.UInt
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package doah;

import doah.doab;
import kotlin.UInt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

public abstract class doa {
    private static final char[] doa;

    public static final String doab(byte[] object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        object = (Object)doah.doa$doa.doa;
        return ArraysKt.joinToString$default((byte[])object, (CharSequence)"", null, null, (int)0, null, (Function1)object, (int)30, null);
    }

    public static final byte[] doa(byte[] byArray, byte[] byArray2) {
        Intrinsics.checkNotNullParameter((Object)byArray2, (String)"add");
        if (byArray == null) {
            return byArray2;
        }
        byte[] byArray3 = new byte[byArray.length + byArray2.length];
        for (byte byArray3[i] : byArray) {
        }
        int n = byArray2.length;
        for (int i = 0; i < n; ++i) {
            byte by;
            byArray3[i + byArray.length] = by = byArray2[i];
        }
        return byArray3;
    }

    public static final long doae(byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"bytes");
        long l = 0L;
        int n = byArray.length;
        for (int i = 0; i < n; ++i) {
            l |= ((long)byArray[i] & 0xFFL) << i * 8;
        }
        return l;
    }

    public static final int doah(byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"bytes");
        int n = 0;
        int n2 = byArray.length;
        for (int i = 0; i < n2; ++i) {
            n = UInt.constructor-impl((int)(n | UInt.constructor-impl((int)(UInt.constructor-impl((int)(UInt.constructor-impl((int)byArray[i]) & 0xFF)) << i * 8))));
        }
        return n;
    }

    public static final int doac(byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"bytes");
        int n = 0;
        int n2 = byArray.length;
        for (int i = 0; i < n2; ++i) {
            n |= (byArray[i] & 0xFF) << i * 8;
        }
        return n;
    }

    public static final long doaf(byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"bytes");
        long l = 0L;
        int n = byArray.length;
        for (int i = 0; i < n; ++i) {
            l |= ((long)byArray[i] & 0xFFL) << (byArray.length - 1 - i) * 8;
        }
        return l;
    }

    public static final int doad(byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"bytes");
        int n = 0;
        int n2 = byArray.length;
        for (int i = 0; i < n2; ++i) {
            n |= (byArray[i] & 0xFF) << (byArray.length - 1 - i) * 8;
        }
        return n;
    }

    public static final short doa(byte by, byte by2) {
        return (short)(by2 << 8 | by & 0xFF);
    }

    public static final byte[] doac(int n) {
        int n2 = n;
        n = (byte)(n2 >>> 8);
        byte by = (byte)n2;
        return new byte[]{n, by};
    }

    public static final byte[] doa(long l, int n) {
        byte[] byArray = new byte[n];
        for (int i = 0; i < n; ++i) {
            byArray[i] = (byte)(l >> (n - 1 - i) * 8 & 0xFFL);
        }
        return byArray;
    }

    public static final byte[] doa(int n) {
        int n2 = n;
        n = (byte)(n2 & 0xFF);
        byte by = (byte)(n2 >> 8 & 0xFF);
        return ArraysKt.plus((byte[])new byte[]{n}, (byte)by);
    }

    public static final byte[] doab(int n) {
        int n2 = n;
        n = (byte)(n2 & 0xFF);
        byte by = (byte)(n2 >> 8 & 0xFF);
        byte by2 = (byte)(n2 >> 16 & 0xFF);
        return ArraysKt.plus((byte[])ArraysKt.plus((byte[])ArraysKt.plus((byte[])new byte[]{n}, (byte)by), (byte)by2), (byte)((byte)(n2 >> 24 & 0xFF)));
    }

    public static final String doag(byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"bytes");
        String string = "";
        int n = byArray.length;
        for (int i = 0; i < n; ++i) {
            string = string + (char)byArray[i];
        }
        return string;
    }

    public static final String doa(byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"bytes");
        char[] cArray = new char[byArray.length * 2];
        int n = byArray.length;
        for (int i = 0; i < n; ++i) {
            int n2 = byArray[i];
            int n3 = n2 & 0xFF;
            int n4 = i * 2;
            char[] cArray2 = doa;
            int n5 = n2;
            cArray[n4] = cArray2[n3 >>> 4];
            n2 = n4 + 1;
            cArray[n2] = doa[n5 & 0xF];
        }
        return new String(cArray);
    }

    public static final String doa(byte by) {
        int n = by & 0xFF;
        by = (byte)doa[n >>> 4];
        n = doa[by & 0xF];
        char[] cArray = new char[2];
        char[] cArray2 = cArray;
        cArray[0] = (char)by;
        cArray[1] = n;
        by = (byte)cArray2[0];
        return (char)by + "." + cArray2[1];
    }

    public static final String doab(byte by) {
        String string = String.valueOf(doab.doa(by));
        int n = string.length();
        char[] cArray = new char[n];
        for (int i = 0; i < n; ++i) {
            cArray[i] = string.charAt(i);
        }
        return ArraysKt.joinToString$default((char[])cArray, (CharSequence)".", null, null, (int)0, null, null, (int)62, null);
    }

    public static final String doac(byte by) {
        int n = by & 0xFF;
        return "" + (n >>> 4) + '.' + (by & 0xF);
    }

    static {
        char[] cArray = "0123456789ABCDEF".toCharArray();
        Intrinsics.checkNotNullExpressionValue((Object)cArray, (String)"toCharArray(...)");
        doa = cArray;
    }
}
