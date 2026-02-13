/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.Charsets
 *  kotlin.text.StringsKt
 */
package doac;

import com.lepu.blepro.utils.HexString;
import doah.doa;
import doah.doab;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

public final class dobk {
    private final byte[] doa;
    private String doab;
    private int doac;
    private int doad;
    private int doae;
    private int doaf;
    private String doag;

    public dobk(byte[] byArray) {
        dobk dobk2 = object;
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"bytes");
        ((dobk)object).doa = byArray;
        ((dobk)object).doab = doah.doa.doab(byArray[0]);
        ((dobk)object).doac = doah.doab.doa(byArray[1]);
        ((dobk)object).doad = doah.doab.doa(byArray[2]);
        ((dobk)object).doae = doah.doab.doa(byArray[3]);
        ((dobk)object).doaf = doah.doab.doa(byArray[4]);
        Object object = ArraysKt.copyOfRange((byte[])byArray, (int)5, (int)byArray.length);
        String string = HexString.trimStr(new String((byte[])object, Charsets.UTF_8));
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"trimStr(...)");
        dobk2.doag = string;
    }

    public final String doaf() {
        return this.doab;
    }

    public final int doab() {
        return this.doac;
    }

    public final int doa() {
        return this.doad;
    }

    public final int doad() {
        return this.doae;
    }

    public final int doac() {
        return this.doaf;
    }

    public final String doae() {
        return this.doag;
    }

    public String toString() {
        return StringsKt.trimIndent((String)("\n                DeviceInfo : \n                bytes : " + doah.doa.doa(this.doa) + "\n                version : " + this.doab + "\n                customerType : " + this.doac + "\n                battery : " + this.doad + "\n                deviceType : " + this.doae + "\n                deviceCode : " + this.doaf + "\n                sn : " + this.doag + "\n            "));
    }
}
