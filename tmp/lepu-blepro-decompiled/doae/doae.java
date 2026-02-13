/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.Charsets
 *  kotlin.text.StringsKt
 */
package doae;

import com.lepu.blepro.utils.HexString;
import doah.doa;
import doah.doab;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

public final class doae {
    private final byte[] doa;
    private int doab;
    private int doac;
    private String doad;

    public doae(byte[] byArray) {
        doae doae2 = object;
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"bytes");
        ((doae)object).doa = byArray;
        ((doae)object).doab = doah.doab.doa(byArray[0]);
        ((doae)object).doac = doah.doab.doa(byArray[1]);
        Object object = ArraysKt.copyOfRange((byte[])byArray, (int)2, (int)22);
        String string = HexString.trimStr(new String((byte[])object, Charsets.UTF_8));
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"trimStr(...)");
        doae2.doad = string;
    }

    public String toString() {
        return StringsKt.trimIndent((String)("\n            DeviceNetwork :\n            bytes : " + doah.doa.doa(this.doa) + "\n            mode : " + this.doab + "\n            valid : " + this.doac + "\n            iccid : " + this.doad + "\n        "));
    }
}
