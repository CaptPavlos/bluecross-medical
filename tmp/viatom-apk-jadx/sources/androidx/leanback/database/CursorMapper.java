package androidx.leanback.database;

import android.database.Cursor;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class CursorMapper {
    private Cursor mCursor;

    public abstract Object bind(Cursor cursor);

    public abstract void bindColumns(Cursor cursor);

    public Object convert(Cursor cursor) {
        if (cursor != this.mCursor) {
            this.mCursor = cursor;
            bindColumns(cursor);
        }
        return bind(this.mCursor);
    }
}
