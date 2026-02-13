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
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

public final class doah {
    private final byte[] doa;
    private int doab;
    private int doac;

    public doah(byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"bytes");
        this.doa = byArray;
        this.doab = doah.doa.doah(ArraysKt.copyOfRange((byte[])byArray, (int)0, (int)2)) / 100;
        this.doac = doah.doa.doah(ArraysKt.copyOfRange((byte[])byArray, (int)2, (int)4)) / 100;
    }

    public final int doa() {
        return this.doab;
    }

    public String toString() {
        return StringsKt.trimIndent((String)("\n                RtData : \n                bytes : " + doah.doa.doa(this.doa) + "\n                pressureStatic : " + this.doab + "\n                pressurePulse : " + this.doac + "\n            "));
    }
}
