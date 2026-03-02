/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.internal.Intrinsics
 */
package doac;

import doah.doab;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

public final class dobj {
    private final byte[] doa;
    private int doab;
    private int doac;
    private int doad;
    private byte[] doae;

    public dobj(byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"bytes");
        this.doa = byArray;
        this.doab = doah.doab.doa(byArray[0]);
        this.doac = doah.doab.doa(byArray[1]);
        this.doad = doah.doab.doa(byArray[2]);
        this.doae = ArraysKt.copyOfRange((byte[])byArray, (int)3, (int)(byArray.length - 1));
    }

    public final byte[] doa() {
        return this.doa;
    }

    public final int doab() {
        return this.doad;
    }

    public final byte[] doac() {
        return this.doae;
    }
}
