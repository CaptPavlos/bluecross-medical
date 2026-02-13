package androidx.viewpager.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class PagerAdapter {
    public static final int POSITION_NONE = -2;
    public static final int POSITION_UNCHANGED = -1;
    private final DataSetObservable mObservable = new DataSetObservable();
    private DataSetObserver mViewPagerObserver;

    @Deprecated
    public void destroyItem(@NonNull View view, int i10, @NonNull Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void finishUpdate(@NonNull ViewGroup viewGroup) {
        finishUpdate((View) viewGroup);
    }

    public abstract int getCount();

    public int getItemPosition(@NonNull Object obj) {
        return -1;
    }

    @Nullable
    public CharSequence getPageTitle(int i10) {
        return null;
    }

    public float getPageWidth(int i10) {
        return 1.0f;
    }

    @NonNull
    @Deprecated
    public Object instantiateItem(@NonNull View view, int i10) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public abstract boolean isViewFromObject(@NonNull View view, @NonNull Object obj);

    public void notifyDataSetChanged() {
        synchronized (this) {
            try {
                DataSetObserver dataSetObserver = this.mViewPagerObserver;
                if (dataSetObserver != null) {
                    dataSetObserver.onChanged();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.mObservable.notifyChanged();
    }

    public void registerDataSetObserver(@NonNull DataSetObserver dataSetObserver) {
        this.mObservable.registerObserver(dataSetObserver);
    }

    @Nullable
    public Parcelable saveState() {
        return null;
    }

    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i10, @NonNull Object obj) {
        setPrimaryItem((View) viewGroup, i10, obj);
    }

    public void setViewPagerObserver(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.mViewPagerObserver = dataSetObserver;
        }
    }

    public void startUpdate(@NonNull ViewGroup viewGroup) {
        startUpdate((View) viewGroup);
    }

    public void unregisterDataSetObserver(@NonNull DataSetObserver dataSetObserver) {
        this.mObservable.unregisterObserver(dataSetObserver);
    }

    @Deprecated
    public void finishUpdate(@NonNull View view) {
    }

    @Deprecated
    public void setPrimaryItem(@NonNull View view, int i10, @NonNull Object obj) {
    }

    @Deprecated
    public void startUpdate(@NonNull View view) {
    }

    public void destroyItem(@NonNull ViewGroup viewGroup, int i10, @NonNull Object obj) {
        destroyItem((View) viewGroup, i10, obj);
    }

    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i10) {
        return instantiateItem((View) viewGroup, i10);
    }

    public void restoreState(@Nullable Parcelable parcelable, @Nullable ClassLoader classLoader) {
    }
}
