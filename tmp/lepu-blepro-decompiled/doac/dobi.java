/*
 * Decompiled with CFR 0.152.
 */
package doac;

import doad.doga;
import java.util.Date;

public abstract class dobi {
    public static byte[] doab() {
        doga doga2 = new doga(new Date());
        byte by = (byte)(doga2.doah() - 2000);
        byte by2 = (byte)doga2.doaf();
        byte by3 = (byte)doga2.doac();
        byte by4 = (byte)doga2.doad();
        byte by5 = (byte)doga2.doae();
        byte by6 = (byte)doga2.doag();
        byte[] byArray = new byte[6];
        byte[] byArray2 = byArray;
        byArray[0] = by;
        byArray[1] = by2;
        byArray[2] = by3;
        byArray[3] = by4;
        byArray[4] = by5;
        byArray[5] = by6;
        return dobi.doa(0, byArray2);
    }

    public static byte[] doa() {
        doga doga2 = new doga(new Date());
        byte by = (byte)(doga2.doah() - 2000);
        byte by2 = (byte)doga2.doaf();
        byte by3 = (byte)doga2.doac();
        byte by4 = (byte)doga2.doad();
        byte by5 = (byte)doga2.doae();
        byte by6 = (byte)doga2.doag();
        byte[] byArray = new byte[6];
        byte[] byArray2 = byArray;
        byArray[0] = by;
        byArray[1] = by2;
        byArray[2] = by3;
        byArray[3] = by4;
        byArray[4] = by5;
        byArray[5] = by6;
        return dobi.doa(3, byArray2);
    }

    private static byte[] doa(int n, byte[] byArray) {
        int n2 = byArray.length;
        int n3 = n2 + 4;
        byte[] byArray2 = new byte[n3];
        byte[] byArray3 = byArray2;
        byArray3[0] = 90;
        byArray3[1] = (byte)n3;
        byArray3[2] = (byte)n;
        n = byArray.length;
        System.arraycopy(byArray, 0, byArray3, 3, n);
        n = n2 + 3;
        byArray2[n] = dobi.doa(byArray2);
        return byArray2;
    }

    public static byte doa(byte[] byArray) {
        int n = 0;
        for (int i = 0; i < byArray.length - 1; ++i) {
            n = (byte)(n + byArray[i] & 0xFF);
        }
        return (byte)(n + 2);
    }
}
