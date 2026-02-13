/*
 * Decompiled with CFR 0.152.
 */
package doah;

public abstract class doab {
    public static byte[] doa(long l) {
        long l2 = l;
        byte by = (byte)(l2 >> 24 & 0xFFL);
        byte by2 = (byte)(l2 >> 16 & 0xFFL);
        byte by3 = (byte)(l2 >> 8 & 0xFFL);
        byte by4 = (byte)(l2 & 0xFFL);
        return new byte[]{by, by2, by3, by4};
    }

    public static float doa(int n) {
        return Float.intBitsToFloat(n);
    }

    public static int doa(byte by) {
        return by & 0xFF;
    }

    public static short doab(byte by, byte by2) {
        return (short)((by & 0xFF) + ((by2 & 0xFF) << 8));
    }

    public static int doa(byte by, byte by2) {
        return ((by & 0xFF) << 8) + (by2 & 0xFF);
    }

    public static int doa(byte by, byte by2, byte by3, byte by4) {
        return ((by & 0xFF) << 24) + ((by2 & 0xFF) << 16) + ((by3 & 0xFF) << 8) + (by4 & 0xFF);
    }
}
