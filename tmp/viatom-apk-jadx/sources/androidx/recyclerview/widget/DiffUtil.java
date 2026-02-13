package androidx.recyclerview.widget;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.transformation.FabTransformationScrimBehavior;
import com.google.gson.internal.a;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class DiffUtil {
    private static final Comparator<Diagonal> DIAGONAL_COMPARATOR = new Comparator<Diagonal>() { // from class: androidx.recyclerview.widget.DiffUtil.1
        @Override // java.util.Comparator
        public int compare(Diagonal diagonal, Diagonal diagonal2) {
            return diagonal.f605x - diagonal2.f605x;
        }
    };

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int i10, int i11);

        public abstract boolean areItemsTheSame(int i10, int i11);

        @Nullable
        public Object getChangePayload(int i10, int i11) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class CenteredArray {
        private final int[] mData;
        private final int mMid;

        public CenteredArray(int i10) {
            int[] iArr = new int[i10];
            this.mData = iArr;
            this.mMid = iArr.length / 2;
        }

        public int[] backingData() {
            return this.mData;
        }

        public void fill(int i10) {
            Arrays.fill(this.mData, i10);
        }

        public int get(int i10) {
            return this.mData[i10 + this.mMid];
        }

        public void set(int i10, int i11) {
            this.mData[i10 + this.mMid] = i11;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class Diagonal {
        public final int size;

        /* renamed from: x, reason: collision with root package name */
        public final int f605x;
        public final int y;

        public Diagonal(int i10, int i11, int i12) {
            this.f605x = i10;
            this.y = i11;
            this.size = i12;
        }

        public int endX() {
            return this.f605x + this.size;
        }

        public int endY() {
            return this.y + this.size;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static abstract class ItemCallback<T> {
        public abstract boolean areContentsTheSame(@NonNull T t, @NonNull T t9);

        public abstract boolean areItemsTheSame(@NonNull T t, @NonNull T t9);

        @Nullable
        public Object getChangePayload(@NonNull T t, @NonNull T t9) {
            return null;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class PostponedUpdate {
        int currentPos;
        int posInOwnerList;
        boolean removal;

        public PostponedUpdate(int i10, int i11, boolean z9) {
            this.posInOwnerList = i10;
            this.currentPos = i11;
            this.removal = z9;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class Snake {
        public int endX;
        public int endY;
        public boolean reverse;
        public int startX;
        public int startY;

        public int diagonalSize() {
            return Math.min(this.endX - this.startX, this.endY - this.startY);
        }

        public boolean hasAdditionOrRemoval() {
            return this.endY - this.startY != this.endX - this.startX;
        }

        public boolean isAddition() {
            return this.endY - this.startY > this.endX - this.startX;
        }

        @NonNull
        public Diagonal toDiagonal() {
            if (!hasAdditionOrRemoval()) {
                int i10 = this.startX;
                return new Diagonal(i10, this.startY, this.endX - i10);
            }
            if (this.reverse) {
                return new Diagonal(this.startX, this.startY, diagonalSize());
            }
            boolean zIsAddition = isAddition();
            int i11 = this.startX;
            return zIsAddition ? new Diagonal(i11, this.startY + 1, diagonalSize()) : new Diagonal(i11 + 1, this.startY, diagonalSize());
        }
    }

    private DiffUtil() {
    }

    @Nullable
    private static Snake backward(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i10) {
        int i11;
        int i12;
        int i13;
        boolean z9 = (range.oldSize() - range.newSize()) % 2 == 0;
        int iOldSize = range.oldSize() - range.newSize();
        int i14 = -i10;
        for (int i15 = i14; i15 <= i10; i15 += 2) {
            if (i15 == i14 || (i15 != i10 && centeredArray2.get(i15 + 1) < centeredArray2.get(i15 - 1))) {
                i11 = centeredArray2.get(i15 + 1);
                i12 = i11;
            } else {
                i11 = centeredArray2.get(i15 - 1);
                i12 = i11 - 1;
            }
            int i16 = range.newListEnd - ((range.oldListEnd - i12) - i15);
            int i17 = (i10 == 0 || i12 != i11) ? i16 : i16 + 1;
            while (i12 > range.oldListStart && i16 > range.newListStart && callback.areItemsTheSame(i12 - 1, i16 - 1)) {
                i12--;
                i16--;
            }
            centeredArray2.set(i15, i12);
            if (z9 && (i13 = iOldSize - i15) >= i14 && i13 <= i10 && centeredArray.get(i13) >= i12) {
                Snake snake = new Snake();
                snake.startX = i12;
                snake.startY = i16;
                snake.endX = i11;
                snake.endY = i17;
                snake.reverse = true;
                return snake;
            }
        }
        return null;
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback, boolean z9) {
        int oldListSize = callback.getOldListSize();
        int newListSize = callback.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Range(0, oldListSize, 0, newListSize));
        int i10 = ((((oldListSize + newListSize) + 1) / 2) * 2) + 1;
        CenteredArray centeredArray = new CenteredArray(i10);
        CenteredArray centeredArray2 = new CenteredArray(i10);
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            Range range = (Range) arrayList2.remove(arrayList2.size() - 1);
            Snake snakeMidPoint = midPoint(range, callback, centeredArray, centeredArray2);
            if (snakeMidPoint != null) {
                if (snakeMidPoint.diagonalSize() > 0) {
                    arrayList.add(snakeMidPoint.toDiagonal());
                }
                Range range2 = arrayList3.isEmpty() ? new Range() : (Range) arrayList3.remove(arrayList3.size() - 1);
                range2.oldListStart = range.oldListStart;
                range2.newListStart = range.newListStart;
                range2.oldListEnd = snakeMidPoint.startX;
                range2.newListEnd = snakeMidPoint.startY;
                arrayList2.add(range2);
                range.oldListEnd = range.oldListEnd;
                range.newListEnd = range.newListEnd;
                range.oldListStart = snakeMidPoint.endX;
                range.newListStart = snakeMidPoint.endY;
                arrayList2.add(range);
            } else {
                arrayList3.add(range);
            }
        }
        Collections.sort(arrayList, DIAGONAL_COMPARATOR);
        return new DiffResult(callback, arrayList, centeredArray.backingData(), centeredArray2.backingData(), z9);
    }

    @Nullable
    private static Snake forward(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i10) {
        int i11;
        int i12;
        int i13;
        boolean z9 = Math.abs(range.oldSize() - range.newSize()) % 2 == 1;
        int iOldSize = range.oldSize() - range.newSize();
        int i14 = -i10;
        for (int i15 = i14; i15 <= i10; i15 += 2) {
            if (i15 == i14 || (i15 != i10 && centeredArray.get(i15 + 1) > centeredArray.get(i15 - 1))) {
                i11 = centeredArray.get(i15 + 1);
                i12 = i11;
            } else {
                i11 = centeredArray.get(i15 - 1);
                i12 = i11 + 1;
            }
            int i16 = ((i12 - range.oldListStart) + range.newListStart) - i15;
            int i17 = (i10 == 0 || i12 != i11) ? i16 : i16 - 1;
            while (i12 < range.oldListEnd && i16 < range.newListEnd && callback.areItemsTheSame(i12, i16)) {
                i12++;
                i16++;
            }
            centeredArray.set(i15, i12);
            if (z9 && (i13 = iOldSize - i15) >= i14 + 1 && i13 <= i10 - 1 && centeredArray2.get(i13) <= i12) {
                Snake snake = new Snake();
                snake.startX = i11;
                snake.startY = i17;
                snake.endX = i12;
                snake.endY = i16;
                snake.reverse = false;
                return snake;
            }
        }
        return null;
    }

    @Nullable
    private static Snake midPoint(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2) {
        if (range.oldSize() >= 1 && range.newSize() >= 1) {
            int iOldSize = ((range.oldSize() + range.newSize()) + 1) / 2;
            centeredArray.set(1, range.oldListStart);
            centeredArray2.set(1, range.oldListEnd);
            for (int i10 = 0; i10 < iOldSize; i10++) {
                Snake snakeForward = forward(range, callback, centeredArray, centeredArray2, i10);
                if (snakeForward != null) {
                    return snakeForward;
                }
                Snake snakeBackward = backward(range, callback, centeredArray, centeredArray2, i10);
                if (snakeBackward != null) {
                    return snakeBackward;
                }
            }
        }
        return null;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class Range {
        int newListEnd;
        int newListStart;
        int oldListEnd;
        int oldListStart;

        public Range(int i10, int i11, int i12, int i13) {
            this.oldListStart = i10;
            this.oldListEnd = i11;
            this.newListStart = i12;
            this.newListEnd = i13;
        }

        public int newSize() {
            return this.newListEnd - this.newListStart;
        }

        public int oldSize() {
            return this.oldListEnd - this.oldListStart;
        }

        public Range() {
        }
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback) {
        return calculateDiff(callback, true);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class DiffResult {
        private static final int FLAG_CHANGED = 2;
        private static final int FLAG_MASK = 15;
        private static final int FLAG_MOVED = 12;
        private static final int FLAG_MOVED_CHANGED = 4;
        private static final int FLAG_MOVED_NOT_CHANGED = 8;
        private static final int FLAG_NOT_CHANGED = 1;
        private static final int FLAG_OFFSET = 4;
        public static final int NO_POSITION = -1;
        private final Callback mCallback;
        private final boolean mDetectMoves;
        private final List<Diagonal> mDiagonals;
        private final int[] mNewItemStatuses;
        private final int mNewListSize;
        private final int[] mOldItemStatuses;
        private final int mOldListSize;

        public DiffResult(Callback callback, List<Diagonal> list, int[] iArr, int[] iArr2, boolean z9) {
            this.mDiagonals = list;
            this.mOldItemStatuses = iArr;
            this.mNewItemStatuses = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.mCallback = callback;
            this.mOldListSize = callback.getOldListSize();
            this.mNewListSize = callback.getNewListSize();
            this.mDetectMoves = z9;
            addEdgeDiagonals();
            findMatchingItems();
        }

        private void addEdgeDiagonals() {
            Diagonal diagonal = this.mDiagonals.isEmpty() ? null : this.mDiagonals.get(0);
            if (diagonal == null || diagonal.f605x != 0 || diagonal.y != 0) {
                this.mDiagonals.add(0, new Diagonal(0, 0, 0));
            }
            this.mDiagonals.add(new Diagonal(this.mOldListSize, this.mNewListSize, 0));
        }

        private void findMatchingAddition(int i10) {
            int size = this.mDiagonals.size();
            int iEndY = 0;
            for (int i11 = 0; i11 < size; i11++) {
                Diagonal diagonal = this.mDiagonals.get(i11);
                while (iEndY < diagonal.y) {
                    if (this.mNewItemStatuses[iEndY] == 0 && this.mCallback.areItemsTheSame(i10, iEndY)) {
                        int i12 = this.mCallback.areContentsTheSame(i10, iEndY) ? 8 : 4;
                        this.mOldItemStatuses[i10] = (iEndY << 4) | i12;
                        this.mNewItemStatuses[iEndY] = (i10 << 4) | i12;
                        return;
                    }
                    iEndY++;
                }
                iEndY = diagonal.endY();
            }
        }

        private void findMatchingItems() {
            for (Diagonal diagonal : this.mDiagonals) {
                for (int i10 = 0; i10 < diagonal.size; i10++) {
                    int i11 = diagonal.f605x + i10;
                    int i12 = diagonal.y + i10;
                    int i13 = this.mCallback.areContentsTheSame(i11, i12) ? 1 : 2;
                    this.mOldItemStatuses[i11] = (i12 << 4) | i13;
                    this.mNewItemStatuses[i12] = (i11 << 4) | i13;
                }
            }
            if (this.mDetectMoves) {
                findMoveMatches();
            }
        }

        private void findMoveMatches() {
            int iEndX = 0;
            for (Diagonal diagonal : this.mDiagonals) {
                while (iEndX < diagonal.f605x) {
                    if (this.mOldItemStatuses[iEndX] == 0) {
                        findMatchingAddition(iEndX);
                    }
                    iEndX++;
                }
                iEndX = diagonal.endX();
            }
        }

        @Nullable
        private static PostponedUpdate getPostponedUpdate(Collection<PostponedUpdate> collection, int i10, boolean z9) {
            PostponedUpdate next;
            Iterator<PostponedUpdate> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.posInOwnerList == i10 && next.removal == z9) {
                    it.remove();
                    break;
                }
            }
            while (it.hasNext()) {
                PostponedUpdate next2 = it.next();
                if (z9) {
                    next2.currentPos--;
                } else {
                    next2.currentPos++;
                }
            }
            return next;
        }

        public int convertNewPositionToOld(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10) {
            if (i10 < 0 || i10 >= this.mNewListSize) {
                a.f(this.mNewListSize, a3.a.r(i10, "Index out of bounds - passed position = ", ", new list size = "));
                return 0;
            }
            int i11 = this.mNewItemStatuses[i10];
            if ((i11 & 15) == 0) {
                return -1;
            }
            return i11 >> 4;
        }

        public int convertOldPositionToNew(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10) {
            if (i10 < 0 || i10 >= this.mOldListSize) {
                a.f(this.mOldListSize, a3.a.r(i10, "Index out of bounds - passed position = ", ", old list size = "));
                return 0;
            }
            int i11 = this.mOldItemStatuses[i10];
            if ((i11 & 15) == 0) {
                return -1;
            }
            return i11 >> 4;
        }

        public void dispatchUpdatesTo(@NonNull ListUpdateCallback listUpdateCallback) {
            int i10;
            BatchingListUpdateCallback batchingListUpdateCallback = listUpdateCallback instanceof BatchingListUpdateCallback ? (BatchingListUpdateCallback) listUpdateCallback : new BatchingListUpdateCallback(listUpdateCallback);
            int i11 = this.mOldListSize;
            ArrayDeque arrayDeque = new ArrayDeque();
            int i12 = this.mOldListSize;
            int i13 = this.mNewListSize;
            for (int size = this.mDiagonals.size() - 1; size >= 0; size--) {
                Diagonal diagonal = this.mDiagonals.get(size);
                int iEndX = diagonal.endX();
                int iEndY = diagonal.endY();
                while (true) {
                    if (i12 <= iEndX) {
                        break;
                    }
                    i12--;
                    int i14 = this.mOldItemStatuses[i12];
                    if ((i14 & 12) != 0) {
                        int i15 = i14 >> 4;
                        PostponedUpdate postponedUpdate = getPostponedUpdate(arrayDeque, i15, false);
                        if (postponedUpdate != null) {
                            int i16 = (i11 - postponedUpdate.currentPos) - 1;
                            batchingListUpdateCallback.onMoved(i12, i16);
                            if ((i14 & 4) != 0) {
                                batchingListUpdateCallback.onChanged(i16, 1, this.mCallback.getChangePayload(i12, i15));
                            }
                        } else {
                            arrayDeque.add(new PostponedUpdate(i12, (i11 - i12) - 1, true));
                        }
                    } else {
                        batchingListUpdateCallback.onRemoved(i12, 1);
                        i11--;
                    }
                }
                while (i13 > iEndY) {
                    i13--;
                    int i17 = this.mNewItemStatuses[i13];
                    if ((i17 & 12) != 0) {
                        int i18 = i17 >> 4;
                        PostponedUpdate postponedUpdate2 = getPostponedUpdate(arrayDeque, i18, true);
                        if (postponedUpdate2 == null) {
                            arrayDeque.add(new PostponedUpdate(i13, i11 - i12, false));
                        } else {
                            batchingListUpdateCallback.onMoved((i11 - postponedUpdate2.currentPos) - 1, i12);
                            if ((i17 & 4) != 0) {
                                batchingListUpdateCallback.onChanged(i12, 1, this.mCallback.getChangePayload(i18, i13));
                            }
                        }
                    } else {
                        batchingListUpdateCallback.onInserted(i12, 1);
                        i11++;
                    }
                }
                int i19 = diagonal.f605x;
                int i20 = diagonal.y;
                for (i10 = 0; i10 < diagonal.size; i10++) {
                    if ((this.mOldItemStatuses[i19] & 15) == 2) {
                        batchingListUpdateCallback.onChanged(i19, 1, this.mCallback.getChangePayload(i19, i20));
                    }
                    i19++;
                    i20++;
                }
                i12 = diagonal.f605x;
                i13 = diagonal.y;
            }
            batchingListUpdateCallback.dispatchLastEvent();
        }

        public void dispatchUpdatesTo(@NonNull RecyclerView.Adapter adapter) {
            dispatchUpdatesTo(new AdapterListUpdateCallback(adapter));
        }
    }
}
