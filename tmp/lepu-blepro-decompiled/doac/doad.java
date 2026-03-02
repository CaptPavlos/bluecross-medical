/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 */
package doac;

import doah.doa;
import doah.doab;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

public final class doad {
    private final byte[] doa;
    private int doab;
    private int doac;
    private int doad;
    private int doae;
    private int doaf;
    private int doag;
    private byte[] doah;
    private int doai;

    public doad(byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"bytes");
        this.doa = byArray;
        this.doab = doah.doab.doa(byArray[0]);
        this.doac = doah.doab.doa(byArray[1]);
        this.doad = doah.doab.doa(byArray[2]);
        this.doae = doah.doab.doa(byArray[3]);
        this.doag = doah.doa.doah(ArraysKt.copyOfRange((byte[])byArray, (int)4, (int)8)) & Integer.MAX_VALUE;
        this.doaf = (doah.doab.doa(byArray[7]) & 0x80) >> 7;
        this.doah = ArraysKt.copyOfRange((byte[])byArray, (int)8, (int)(8 + this.doag));
        this.doai = doah.doab.doa(byArray[8 + this.doag]);
    }

    public final byte[] doa() {
        return this.doa;
    }

    public final int doab() {
        return this.doae;
    }

    public final int doae() {
        return this.doaf;
    }

    public final int doad() {
        return this.doag;
    }

    public final byte[] doac() {
        return this.doah;
    }

    public String toString() {
        return StringsKt.trimIndent((String)("\n                BleResponse : \n                bytes : " + doah.doa.doa(this.doa) + "\n                head : " + this.doab + "\n                pkgNo : " + this.doac + "\n                ack : " + this.doad + "\n                cmd : " + this.doae + "\n                len : " + this.doag + "\n                content : " + doah.doa.doa(this.doah) + "\n                crc : " + this.doai + "\n            "));
    }
}
