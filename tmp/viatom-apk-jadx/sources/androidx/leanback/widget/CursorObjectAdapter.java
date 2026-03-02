package androidx.leanback.widget;

import android.database.Cursor;
import android.util.LruCache;
import androidx.leanback.database.CursorMapper;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class CursorObjectAdapter extends ObjectAdapter {
    private static final int CACHE_SIZE = 100;
    private Cursor mCursor;
    private final LruCache<Integer, Object> mItemCache;
    private CursorMapper mMapper;

    public CursorObjectAdapter(PresenterSelector presenterSelector) {
        super(presenterSelector);
        this.mItemCache = new LruCache<>(100);
    }

    public void changeCursor(Cursor cursor) {
        Cursor cursor2 = this.mCursor;
        if (cursor == cursor2) {
            return;
        }
        if (cursor2 != null) {
            cursor2.close();
        }
        this.mCursor = cursor;
        this.mItemCache.trimToSize(0);
        onCursorChanged();
    }

    public void close() {
        Cursor cursor = this.mCursor;
        if (cursor != null) {
            cursor.close();
            this.mCursor = null;
        }
    }

    @Override // androidx.leanback.widget.ObjectAdapter
    public Object get(int i10) {
        Cursor cursor = this.mCursor;
        if (cursor == null) {
            return null;
        }
        if (!cursor.moveToPosition(i10)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Object obj = this.mItemCache.get(Integer.valueOf(i10));
        if (obj != null) {
            return obj;
        }
        Object objConvert = this.mMapper.convert(this.mCursor);
        this.mItemCache.put(Integer.valueOf(i10), objConvert);
        return objConvert;
    }

    public final Cursor getCursor() {
        return this.mCursor;
    }

    public final CursorMapper getMapper() {
        return this.mMapper;
    }

    public final void invalidateCache(int i10) {
        this.mItemCache.remove(Integer.valueOf(i10));
    }

    public boolean isClosed() {
        Cursor cursor = this.mCursor;
        return cursor == null || cursor.isClosed();
    }

    @Override // androidx.leanback.widget.ObjectAdapter
    public boolean isImmediateNotifySupported() {
        return true;
    }

    public void onCursorChanged() {
        notifyChanged();
    }

    public final void setMapper(CursorMapper cursorMapper) {
        boolean z9 = this.mMapper != cursorMapper;
        this.mMapper = cursorMapper;
        if (z9) {
            onMapperChanged();
        }
    }

    @Override // androidx.leanback.widget.ObjectAdapter
    public int size() {
        Cursor cursor = this.mCursor;
        if (cursor == null) {
            return 0;
        }
        return cursor.getCount();
    }

    public Cursor swapCursor(Cursor cursor) {
        Cursor cursor2 = this.mCursor;
        if (cursor == cursor2) {
            return cursor2;
        }
        this.mCursor = cursor;
        this.mItemCache.trimToSize(0);
        onCursorChanged();
        return cursor2;
    }

    public final void invalidateCache(int i10, int i11) {
        int i12 = i11 + i10;
        while (i10 < i12) {
            invalidateCache(i10);
            i10++;
        }
    }

    public CursorObjectAdapter(Presenter presenter) {
        super(presenter);
        this.mItemCache = new LruCache<>(100);
    }

    public CursorObjectAdapter() {
        this.mItemCache = new LruCache<>(100);
    }

    public void onMapperChanged() {
    }
}
