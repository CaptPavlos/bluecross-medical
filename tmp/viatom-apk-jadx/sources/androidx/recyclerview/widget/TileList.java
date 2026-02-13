package androidx.recyclerview.widget;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import java.lang.reflect.Array;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
class TileList<T> {
    Tile<T> mLastAccessedTile;
    final int mTileSize;
    private final SparseArray<Tile<T>> mTiles = new SparseArray<>(10);

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class Tile<T> {
        public int mItemCount;
        public final T[] mItems;
        Tile<T> mNext;
        public int mStartPosition;

        public Tile(@NonNull Class<T> cls, int i10) {
            this.mItems = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i10));
        }

        public boolean containsPosition(int i10) {
            int i11 = this.mStartPosition;
            return i11 <= i10 && i10 < i11 + this.mItemCount;
        }

        public T getByPosition(int i10) {
            return this.mItems[i10 - this.mStartPosition];
        }
    }

    public TileList(int i10) {
        this.mTileSize = i10;
    }

    public Tile<T> addOrReplace(Tile<T> tile) {
        int iIndexOfKey = this.mTiles.indexOfKey(tile.mStartPosition);
        SparseArray<Tile<T>> sparseArray = this.mTiles;
        if (iIndexOfKey < 0) {
            sparseArray.put(tile.mStartPosition, tile);
            return null;
        }
        Tile<T> tileValueAt = sparseArray.valueAt(iIndexOfKey);
        this.mTiles.setValueAt(iIndexOfKey, tile);
        if (this.mLastAccessedTile == tileValueAt) {
            this.mLastAccessedTile = tile;
        }
        return tileValueAt;
    }

    public void clear() {
        this.mTiles.clear();
    }

    public Tile<T> getAtIndex(int i10) {
        if (i10 < 0 || i10 >= this.mTiles.size()) {
            return null;
        }
        return this.mTiles.valueAt(i10);
    }

    public T getItemAt(int i10) {
        Tile<T> tile = this.mLastAccessedTile;
        if (tile == null || !tile.containsPosition(i10)) {
            int iIndexOfKey = this.mTiles.indexOfKey(i10 - (i10 % this.mTileSize));
            if (iIndexOfKey < 0) {
                return null;
            }
            this.mLastAccessedTile = this.mTiles.valueAt(iIndexOfKey);
        }
        return this.mLastAccessedTile.getByPosition(i10);
    }

    public Tile<T> removeAtPos(int i10) {
        Tile<T> tile = this.mTiles.get(i10);
        if (this.mLastAccessedTile == tile) {
            this.mLastAccessedTile = null;
        }
        this.mTiles.delete(i10);
        return tile;
    }

    public int size() {
        return this.mTiles.size();
    }
}
