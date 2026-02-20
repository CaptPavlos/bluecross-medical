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

public final class doai {
    private final byte[] doa;
    private int doab;
    private int doac;
    private int doad;
    private int doae;
    private int doaf;
    private int doag;
    private int doah;
    private int doai;
    private int doaj;
    private int doak;
    private int doal;

    public doai(byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"bytes");
        this.doa = byArray;
        this.doab = doah.doa.doah(ArraysKt.copyOfRange((byte[])byArray, (int)0, (int)2));
        this.doac = doah.doab.doa(byArray[2]);
        this.doad = doah.doab.doa(byArray[3]);
        this.doae = doah.doab.doa(byArray[4]);
        this.doaf = doah.doab.doa(byArray[5]);
        this.doag = doah.doab.doa(byArray[6]);
        this.doah = doah.doab.doa(byArray[7]);
        this.doai = doah.doa.doah(ArraysKt.copyOfRange((byte[])byArray, (int)8, (int)10));
        this.doaj = doah.doa.doah(ArraysKt.copyOfRange((byte[])byArray, (int)10, (int)12));
        this.doak = doah.doa.doah(ArraysKt.copyOfRange((byte[])byArray, (int)12, (int)14));
        this.doal = doah.doa.doah(ArraysKt.copyOfRange((byte[])byArray, (int)14, (int)16));
    }

    public final int doak() {
        return this.doab;
    }

    public final int doaf() {
        return this.doac;
    }

    public final int doa() {
        return this.doad;
    }

    public final int doac() {
        return this.doae;
    }

    public final int doae() {
        return this.doaf;
    }

    public final int doah() {
        return this.doag;
    }

    public final int doai() {
        return this.doah;
    }

    public final int doaj() {
        return this.doai;
    }

    public final int doab() {
        return this.doaj;
    }

    public final int doad() {
        return this.doak;
    }

    public final int doag() {
        return this.doal;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n                RtResult : \n                bytes : ").append(doah.doa.doa(this.doa)).append("\n                year : ").append(this.doab).append("\n                month : ").append(this.doac).append("\n                day : ").append(this.doad).append("\n                hour : ").append(this.doae).append("\n                minute : ").append(this.doaf).append("\n                second : ").append(this.doag).append("\n                stateCode : ").append(this.doah).append("\n                sys : ").append(this.doai).append("\n                dia : ").append(this.doaj).append("\n                mean : ").append(this.doak).append("\n                pr : ");
        stringBuilder.append(this.doal).append("\n            ");
        return StringsKt.trimIndent((String)stringBuilder.toString());
    }
}
