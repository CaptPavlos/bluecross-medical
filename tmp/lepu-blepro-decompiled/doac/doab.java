/*
 * Decompiled with CFR 0.152.
 */
package doac;

import doah.doa;
import doah.doad;
import doah.doah;
import java.util.Calendar;

public abstract class doab {
    public static byte[] doak() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        byte by = (byte)calendar.get(1);
        byte by2 = (byte)(calendar.get(1) >> 8);
        byte by3 = (byte)(calendar.get(2) + 1);
        byte by4 = (byte)calendar.get(5);
        byte by5 = (byte)calendar.get(11);
        byte by6 = (byte)calendar.get(12);
        byte by7 = (byte)calendar.get(13);
        byte[] byArray = new byte[7];
        byte[] byArray2 = byArray;
        byArray[0] = by;
        byArray[1] = by2;
        byArray[2] = by3;
        byArray[3] = by4;
        byArray[4] = by5;
        byArray[5] = by6;
        byArray[6] = by7;
        doah.doa("setTime===" + doa.doa(byArray2));
        return doab.doa(236, byArray2);
    }

    public static byte[] doag() {
        return doab.doa(225, new byte[0]);
    }

    public static byte[] doaj() {
        return doab.doa(226, new byte[0]);
    }

    public static byte[] doab() {
        return doab.doa(227, new byte[0]);
    }

    public static byte[] doac() {
        return doab.doa(238, new byte[0]);
    }

    public static byte[] doad() {
        return doab.doa(228, new byte[0]);
    }

    public static byte[] doa(byte[] byArray, byte by) {
        byte[] byArray2 = new byte[20];
        byte[] byArray3 = byArray2;
        int n = Math.min(byArray.length, 16);
        System.arraycopy(byArray, 0, byArray3, 0, n);
        byArray3[16] = by;
        byArray3[17] = (byte)(by >> 8);
        byArray3[18] = (byte)(by >> 16);
        byArray2[19] = (byte)(by >> 24);
        return doab.doa(242, byArray3);
    }

    public static byte[] doai() {
        return doab.doa(244, new byte[0]);
    }

    public static byte[] doab(int n) {
        int n2 = n;
        n = (byte)n2;
        byte by = (byte)(n2 >> 8);
        byte by2 = (byte)(n2 >> 16);
        byte by3 = (byte)(n2 >> 24);
        byte[] byArray = new byte[4];
        byte[] byArray2 = byArray;
        byArray[0] = n;
        byArray[1] = by;
        byArray[2] = by2;
        byArray[3] = by3;
        return doab.doa(243, byArray2);
    }

    public static byte[] doaf() {
        return doab.doa(241, new byte[0]);
    }

    public static byte[] doae() {
        return doab.doa(0, new byte[0]);
    }

    public static byte[] doa() {
        return doab.doa(1, new byte[0]);
    }

    public static byte[] doa(int n) {
        return doab.doa(2, doa.doa(n));
    }

    public static byte[] doac(int n) {
        return doab.doa(3, doa.doa(n));
    }

    public static byte[] doah() {
        return doab.doa(6, new byte[0]);
    }

    public static byte[] doal() {
        return doab.doa(8, new byte[0]);
    }

    public static byte[] doa(boolean bl) {
        byte[] byArray = new byte[2];
        if (!bl) {
            byArray[0] = 1;
        }
        return doab.doa(9, byArray);
    }

    private static byte[] doa(int n, byte[] byArray) {
        byte[] byArray2;
        int n2 = byArray.length;
        byte[] byArray3 = new byte[n2 + 9];
        byte[] byArray4 = byArray2 = byArray3;
        byArray4[0] = -91;
        byArray4[1] = 0;
        byArray2[2] = 0;
        byArray2[3] = (byte)n;
        byArray2[4] = (byte)n2;
        byArray2[5] = (byte)(n2 >> 8);
        byArray2[6] = (byte)(n2 >> 16);
        byArray2[7] = (byte)(n2 >> 24);
        System.arraycopy(byArray, 0, byArray2, 8, n2);
        n = n2 + 8;
        byArray3[n] = doad.doac(byArray3);
        return byArray3;
    }
}
