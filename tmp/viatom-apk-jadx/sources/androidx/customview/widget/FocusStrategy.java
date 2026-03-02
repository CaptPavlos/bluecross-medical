package androidx.customview.widget;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.internal.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
class FocusStrategy {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface BoundsAdapter<T> {
        void obtainBounds(T t, Rect rect);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface CollectionAdapter<T, V> {
        V get(T t, int i10);

        int size(T t);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class SequentialComparator<T> implements Comparator<T> {
        private final BoundsAdapter<T> mAdapter;
        private final boolean mIsLayoutRtl;
        private final Rect mTemp1 = new Rect();
        private final Rect mTemp2 = new Rect();

        public SequentialComparator(boolean z9, BoundsAdapter<T> boundsAdapter) {
            this.mIsLayoutRtl = z9;
            this.mAdapter = boundsAdapter;
        }

        @Override // java.util.Comparator
        public int compare(T t, T t9) {
            Rect rect = this.mTemp1;
            Rect rect2 = this.mTemp2;
            this.mAdapter.obtainBounds(t, rect);
            this.mAdapter.obtainBounds(t9, rect2);
            int i10 = rect.top;
            int i11 = rect2.top;
            if (i10 < i11) {
                return -1;
            }
            if (i10 > i11) {
                return 1;
            }
            int i12 = rect.left;
            int i13 = rect2.left;
            if (i12 < i13) {
                return this.mIsLayoutRtl ? 1 : -1;
            }
            if (i12 > i13) {
                return this.mIsLayoutRtl ? -1 : 1;
            }
            int i14 = rect.bottom;
            int i15 = rect2.bottom;
            if (i14 < i15) {
                return -1;
            }
            if (i14 > i15) {
                return 1;
            }
            int i16 = rect.right;
            int i17 = rect2.right;
            if (i16 < i17) {
                return this.mIsLayoutRtl ? 1 : -1;
            }
            if (i16 > i17) {
                return this.mIsLayoutRtl ? -1 : 1;
            }
            return 0;
        }
    }

    private FocusStrategy() {
    }

    private static boolean beamBeats(int i10, @NonNull Rect rect, @NonNull Rect rect2, @NonNull Rect rect3) {
        boolean zBeamsOverlap = beamsOverlap(i10, rect, rect2);
        if (beamsOverlap(i10, rect, rect3) || !zBeamsOverlap) {
            return false;
        }
        return !isToDirectionOf(i10, rect, rect3) || i10 == 17 || i10 == 66 || majorAxisDistance(i10, rect, rect2) < majorAxisDistanceToFarEdge(i10, rect, rect3);
    }

    private static boolean beamsOverlap(int i10, @NonNull Rect rect, @NonNull Rect rect2) {
        if (i10 != 17) {
            if (i10 != 33) {
                if (i10 != 66) {
                    if (i10 != 130) {
                        a.n("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                        return false;
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    public static <L, T> T findNextFocusInAbsoluteDirection(@NonNull L l10, @NonNull CollectionAdapter<L, T> collectionAdapter, @NonNull BoundsAdapter<T> boundsAdapter, @Nullable T t, @NonNull Rect rect, int i10) {
        Rect rect2 = new Rect(rect);
        if (i10 == 17) {
            rect2.offset(rect.width() + 1, 0);
        } else if (i10 == 33) {
            rect2.offset(0, rect.height() + 1);
        } else if (i10 == 66) {
            rect2.offset(-(rect.width() + 1), 0);
        } else {
            if (i10 != 130) {
                a.n("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                return null;
            }
            rect2.offset(0, -(rect.height() + 1));
        }
        int size = collectionAdapter.size(l10);
        Rect rect3 = new Rect();
        T t9 = null;
        for (int i11 = 0; i11 < size; i11++) {
            T t10 = collectionAdapter.get(l10, i11);
            if (t10 != t) {
                boundsAdapter.obtainBounds(t10, rect3);
                if (isBetterCandidate(i10, rect, rect3, rect2)) {
                    rect2.set(rect3);
                    t9 = t10;
                }
            }
        }
        return t9;
    }

    public static <L, T> T findNextFocusInRelativeDirection(@NonNull L l10, @NonNull CollectionAdapter<L, T> collectionAdapter, @NonNull BoundsAdapter<T> boundsAdapter, @Nullable T t, int i10, boolean z9, boolean z10) {
        int size = collectionAdapter.size(l10);
        ArrayList arrayList = new ArrayList(size);
        for (int i11 = 0; i11 < size; i11++) {
            arrayList.add(collectionAdapter.get(l10, i11));
        }
        Collections.sort(arrayList, new SequentialComparator(z9, boundsAdapter));
        if (i10 == 1) {
            return (T) getPreviousFocusable(t, arrayList, z10);
        }
        if (i10 == 2) {
            return (T) getNextFocusable(t, arrayList, z10);
        }
        a.n("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
        return null;
    }

    private static <T> T getNextFocusable(T t, ArrayList<T> arrayList, boolean z9) {
        int size = arrayList.size();
        int iLastIndexOf = (t == null ? -1 : arrayList.lastIndexOf(t)) + 1;
        if (iLastIndexOf < size) {
            return arrayList.get(iLastIndexOf);
        }
        if (!z9 || size <= 0) {
            return null;
        }
        return arrayList.get(0);
    }

    private static <T> T getPreviousFocusable(T t, ArrayList<T> arrayList, boolean z9) {
        int size = arrayList.size();
        int iIndexOf = (t == null ? size : arrayList.indexOf(t)) - 1;
        if (iIndexOf >= 0) {
            return arrayList.get(iIndexOf);
        }
        if (!z9 || size <= 0) {
            return null;
        }
        return arrayList.get(size - 1);
    }

    private static int getWeightedDistanceFor(int i10, int i11) {
        return (i11 * i11) + (i10 * 13 * i10);
    }

    private static boolean isBetterCandidate(int i10, @NonNull Rect rect, @NonNull Rect rect2, @NonNull Rect rect3) {
        if (!isCandidate(rect, rect2, i10)) {
            return false;
        }
        if (isCandidate(rect, rect3, i10) && !beamBeats(i10, rect, rect2, rect3)) {
            return !beamBeats(i10, rect, rect3, rect2) && getWeightedDistanceFor(majorAxisDistance(i10, rect, rect2), minorAxisDistance(i10, rect, rect2)) < getWeightedDistanceFor(majorAxisDistance(i10, rect, rect3), minorAxisDistance(i10, rect, rect3));
        }
        return true;
    }

    private static boolean isCandidate(@NonNull Rect rect, @NonNull Rect rect2, int i10) {
        if (i10 == 17) {
            int i11 = rect.right;
            int i12 = rect2.right;
            return (i11 > i12 || rect.left >= i12) && rect.left > rect2.left;
        }
        if (i10 == 33) {
            int i13 = rect.bottom;
            int i14 = rect2.bottom;
            return (i13 > i14 || rect.top >= i14) && rect.top > rect2.top;
        }
        if (i10 == 66) {
            int i15 = rect.left;
            int i16 = rect2.left;
            return (i15 < i16 || rect.right <= i16) && rect.right < rect2.right;
        }
        if (i10 != 130) {
            a.n("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            return false;
        }
        int i17 = rect.top;
        int i18 = rect2.top;
        return (i17 < i18 || rect.bottom <= i18) && rect.bottom < rect2.bottom;
    }

    private static boolean isToDirectionOf(int i10, @NonNull Rect rect, @NonNull Rect rect2) {
        if (i10 == 17) {
            return rect.left >= rect2.right;
        }
        if (i10 == 33) {
            return rect.top >= rect2.bottom;
        }
        if (i10 == 66) {
            return rect.right <= rect2.left;
        }
        if (i10 == 130) {
            return rect.bottom <= rect2.top;
        }
        a.n("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        return false;
    }

    private static int majorAxisDistance(int i10, @NonNull Rect rect, @NonNull Rect rect2) {
        return Math.max(0, majorAxisDistanceRaw(i10, rect, rect2));
    }

    private static int majorAxisDistanceRaw(int i10, @NonNull Rect rect, @NonNull Rect rect2) {
        if (i10 == 17) {
            return rect.left - rect2.right;
        }
        if (i10 == 33) {
            return rect.top - rect2.bottom;
        }
        if (i10 == 66) {
            return rect2.left - rect.right;
        }
        if (i10 == 130) {
            return rect2.top - rect.bottom;
        }
        a.n("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        return 0;
    }

    private static int majorAxisDistanceToFarEdge(int i10, @NonNull Rect rect, @NonNull Rect rect2) {
        return Math.max(1, majorAxisDistanceToFarEdgeRaw(i10, rect, rect2));
    }

    private static int majorAxisDistanceToFarEdgeRaw(int i10, @NonNull Rect rect, @NonNull Rect rect2) {
        if (i10 == 17) {
            return rect.left - rect2.left;
        }
        if (i10 == 33) {
            return rect.top - rect2.top;
        }
        if (i10 == 66) {
            return rect2.right - rect.right;
        }
        if (i10 == 130) {
            return rect2.bottom - rect.bottom;
        }
        a.n("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        return 0;
    }

    private static int minorAxisDistance(int i10, @NonNull Rect rect, @NonNull Rect rect2) {
        if (i10 != 17) {
            if (i10 != 33) {
                if (i10 != 66) {
                    if (i10 != 130) {
                        a.n("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                        return 0;
                    }
                }
            }
            return Math.abs(((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left));
        }
        return Math.abs(((rect.height() / 2) + rect.top) - ((rect2.height() / 2) + rect2.top));
    }
}
