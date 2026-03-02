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
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

public final class doag {
    private final byte[] doa;
    private int doab;
    private List doac;

    public doag(byte[] byArray) {
        int n;
        doag doag2 = this;
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"bytes");
        doag2.doa = byArray;
        doag2.doac = new ArrayList();
        this.doab = n = doah.doab.doa(byArray[0]);
        int n2 = 1;
        for (int i = 0; i < n; ++i) {
            int n3 = n2;
            n2 = n3 + 16;
            byte[] byArray2 = ArraysKt.copyOfRange((byte[])this.doa, (int)n3, (int)n2);
            String string = HexString.trimStr(new String(byArray2, Charsets.UTF_8));
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"trimStr(...)");
            this.doac.add(string);
        }
    }

    public String toString() {
        return StringsKt.trimIndent((String)("\n                FileList : \n                bytes : " + doah.doa.doa(this.doa) + "\n                size : " + this.doab + "\n                fileNames : " + this.doac + "\n            "));
    }
}
