package androidx.room.util;

import kotlin.jvm.internal.l;
import o7.n;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class FtsTableInfoKt {
    public static final boolean equalsCommon(FtsTableInfo ftsTableInfo, Object obj) {
        ftsTableInfo.getClass();
        if (ftsTableInfo == obj) {
            return true;
        }
        if (!(obj instanceof FtsTableInfo)) {
            return false;
        }
        FtsTableInfo ftsTableInfo2 = (FtsTableInfo) obj;
        if (l.a(ftsTableInfo.name, ftsTableInfo2.name) && l.a(ftsTableInfo.columns, ftsTableInfo2.columns)) {
            return l.a(ftsTableInfo.options, ftsTableInfo2.options);
        }
        return false;
    }

    public static final int hashCodeCommon(FtsTableInfo ftsTableInfo) {
        ftsTableInfo.getClass();
        return ftsTableInfo.options.hashCode() + ((ftsTableInfo.columns.hashCode() + (ftsTableInfo.name.hashCode() * 31)) * 31);
    }

    public static final String toStringCommon(FtsTableInfo ftsTableInfo) {
        ftsTableInfo.getClass();
        return n.R("\n            |FtsTableInfo {\n            |   name = '" + ftsTableInfo.name + "',\n            |   columns = {" + TableInfoKt.formatString(t6.l.m0(ftsTableInfo.columns)) + "\n            |   options = {" + TableInfoKt.formatString(t6.l.m0(ftsTableInfo.options)) + "\n            |}\n        ");
    }
}
