package androidx.work;

import androidx.work.Data;
import kotlin.jvm.internal.l;
import s6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class DataKt {
    public static final <T> boolean hasKeyWithValueOfType(Data data, String str) {
        data.getClass();
        str.getClass();
        l.h();
        throw null;
    }

    public static final Data workDataOf(i... iVarArr) {
        iVarArr.getClass();
        Data.Builder builder = new Data.Builder();
        for (i iVar : iVarArr) {
            builder.put((String) iVar.f12693a, iVar.f12694b);
        }
        return builder.build();
    }
}
