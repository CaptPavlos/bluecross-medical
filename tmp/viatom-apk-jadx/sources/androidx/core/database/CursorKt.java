package androidx.core.database;

import android.database.Cursor;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class CursorKt {
    public static final byte[] getBlobOrNull(Cursor cursor, int i10) {
        if (cursor.isNull(i10)) {
            return null;
        }
        return cursor.getBlob(i10);
    }

    public static final Double getDoubleOrNull(Cursor cursor, int i10) {
        if (cursor.isNull(i10)) {
            return null;
        }
        return Double.valueOf(cursor.getDouble(i10));
    }

    public static final Float getFloatOrNull(Cursor cursor, int i10) {
        if (cursor.isNull(i10)) {
            return null;
        }
        return Float.valueOf(cursor.getFloat(i10));
    }

    public static final Integer getIntOrNull(Cursor cursor, int i10) {
        if (cursor.isNull(i10)) {
            return null;
        }
        return Integer.valueOf(cursor.getInt(i10));
    }

    public static final Long getLongOrNull(Cursor cursor, int i10) {
        if (cursor.isNull(i10)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i10));
    }

    public static final Short getShortOrNull(Cursor cursor, int i10) {
        if (cursor.isNull(i10)) {
            return null;
        }
        return Short.valueOf(cursor.getShort(i10));
    }

    public static final String getStringOrNull(Cursor cursor, int i10) {
        if (cursor.isNull(i10)) {
            return null;
        }
        return cursor.getString(i10);
    }
}
