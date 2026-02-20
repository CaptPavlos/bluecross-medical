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

public final class dobl {
    private final byte[] doa;
    private int doab;
    private int doac;
    private int doad;
    private int doae;
    private int doaf;
    private int doag;
    private float doah;

    public dobl(byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"bytes");
        this.doa = byArray;
        this.doab = doah.doab.doa(byArray[0]) + 2000;
        this.doac = doah.doab.doa(byArray[1]);
        this.doad = doah.doab.doa(byArray[2]);
        this.doae = doah.doab.doa(byArray[3]);
        this.doaf = doah.doab.doa(byArray[4]);
        this.doag = doah.doa.doah(ArraysKt.copyOfRange((byte[])byArray, (int)6, (int)8));
        this.doah = (float)doah.doa.doah(ArraysKt.copyOfRange((byte[])byArray, (int)6, (int)8)) / 18.0f;
    }

    public final int doag() {
        return this.doab;
    }

    public final int doad() {
        return this.doac;
    }

    public final int doa() {
        return this.doad;
    }

    public final int doab() {
        return this.doae;
    }

    public final int doac() {
        return this.doaf;
    }

    public final int doae() {
        return this.doag;
    }

    public final float doaf() {
        return this.doah;
    }

    public String toString() {
        return StringsKt.trimIndent((String)("\n                GluData : \n                bytes : " + doah.doa.doa(this.doa) + "\n                year : " + this.doab + "\n                month : " + this.doac + "\n                day : " + this.doad + "\n                hour : " + this.doae + "\n                minute : " + this.doaf + "\n                resultMg : " + this.doag + "\n                resultMmol : " + this.doah + "\n            "));
    }
}
