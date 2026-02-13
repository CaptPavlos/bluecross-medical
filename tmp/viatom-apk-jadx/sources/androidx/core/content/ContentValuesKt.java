package androidx.core.content;

import android.content.ContentValues;
import s6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ContentValuesKt {
    public static final ContentValues contentValuesOf(i... iVarArr) {
        ContentValues contentValues = new ContentValues(iVarArr.length);
        for (i iVar : iVarArr) {
            String str = (String) iVar.f12693a;
            Object obj = iVar.f12694b;
            if (obj == null) {
                contentValues.putNull(str);
            } else if (obj instanceof String) {
                contentValues.put(str, (String) obj);
            } else if (obj instanceof Integer) {
                contentValues.put(str, (Integer) obj);
            } else if (obj instanceof Long) {
                contentValues.put(str, (Long) obj);
            } else if (obj instanceof Boolean) {
                contentValues.put(str, (Boolean) obj);
            } else if (obj instanceof Float) {
                contentValues.put(str, (Float) obj);
            } else if (obj instanceof Double) {
                contentValues.put(str, (Double) obj);
            } else if (obj instanceof byte[]) {
                contentValues.put(str, (byte[]) obj);
            } else if (obj instanceof Byte) {
                contentValues.put(str, (Byte) obj);
            } else {
                if (!(obj instanceof Short)) {
                    androidx.constraintlayout.core.state.b.h(34, obj.getClass().getCanonicalName(), " for key \"", str, "Illegal value type ");
                    return null;
                }
                contentValues.put(str, (Short) obj);
            }
        }
        return contentValues;
    }
}
