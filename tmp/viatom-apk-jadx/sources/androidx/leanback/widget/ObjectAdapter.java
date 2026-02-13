package androidx.leanback.widget;

import android.annotation.SuppressLint;
import android.database.Observable;
import androidx.annotation.RestrictTo;
import androidx.window.layout.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class ObjectAdapter {
    public static final int NO_ID = -1;
    private boolean mHasStableIds;
    private final DataObservable mObservable = new DataObservable();
    private PresenterSelector mPresenterSelector;

    public ObjectAdapter(Presenter presenter) {
        setPresenterSelector(new SinglePresenterSelector(presenter));
    }

    public abstract Object get(int i10);

    public long getId(int i10) {
        return -1L;
    }

    public final Presenter getPresenter(Object obj) {
        PresenterSelector presenterSelector = this.mPresenterSelector;
        if (presenterSelector != null) {
            return presenterSelector.getPresenter(obj);
        }
        c.g("Presenter selector must not be null");
        return null;
    }

    public final PresenterSelector getPresenterSelector() {
        return this.mPresenterSelector;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final boolean hasObserver() {
        return this.mObservable.hasObserver();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public final boolean hasStableIds() {
        return this.mHasStableIds;
    }

    public boolean isImmediateNotifySupported() {
        return false;
    }

    public final void notifyChanged() {
        this.mObservable.notifyChanged();
    }

    public final void notifyItemMoved(int i10, int i11) {
        this.mObservable.notifyItemMoved(i10, i11);
    }

    public final void notifyItemRangeChanged(int i10, int i11) {
        this.mObservable.notifyItemRangeChanged(i10, i11);
    }

    public final void notifyItemRangeInserted(int i10, int i11) {
        this.mObservable.notifyItemRangeInserted(i10, i11);
    }

    public final void notifyItemRangeRemoved(int i10, int i11) {
        this.mObservable.notifyItemRangeRemoved(i10, i11);
    }

    public final void registerObserver(DataObserver dataObserver) {
        this.mObservable.registerObserver(dataObserver);
    }

    public final void setHasStableIds(boolean z9) {
        boolean z10 = this.mHasStableIds != z9;
        this.mHasStableIds = z9;
        if (z10) {
            onHasStableIdsChanged();
        }
    }

    public final void setPresenterSelector(PresenterSelector presenterSelector) {
        if (presenterSelector == null) {
            com.google.gson.internal.a.n("Presenter selector must not be null");
            return;
        }
        PresenterSelector presenterSelector2 = this.mPresenterSelector;
        boolean z9 = false;
        boolean z10 = presenterSelector2 != null;
        if (z10 && presenterSelector2 != presenterSelector) {
            z9 = true;
        }
        this.mPresenterSelector = presenterSelector;
        if (z9) {
            onPresenterSelectorChanged();
        }
        if (z10) {
            notifyChanged();
        }
    }

    public abstract int size();

    public final void unregisterAllObservers() {
        this.mObservable.unregisterAll();
    }

    public final void unregisterObserver(DataObserver dataObserver) {
        this.mObservable.unregisterObserver(dataObserver);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static abstract class DataObserver {
        public void onItemMoved(int i10, int i11) {
            onChanged();
        }

        public void onItemRangeChanged(int i10, int i11) {
            onChanged();
        }

        public void onItemRangeInserted(int i10, int i11) {
            onChanged();
        }

        public void onItemRangeRemoved(int i10, int i11) {
            onChanged();
        }

        public void onItemRangeChanged(int i10, int i11, Object obj) {
            onChanged();
        }

        public void onChanged() {
        }
    }

    public final void notifyItemRangeChanged(int i10, int i11, Object obj) {
        this.mObservable.notifyItemRangeChanged(i10, i11, obj);
    }

    public void onHasStableIdsChanged() {
    }

    public void onPresenterSelectorChanged() {
    }

    public ObjectAdapter(PresenterSelector presenterSelector) {
        setPresenterSelector(presenterSelector);
    }

    public ObjectAdapter() {
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class DataObservable extends Observable<DataObserver> {
        public boolean hasObserver() {
            return ((Observable) this).mObservers.size() > 0;
        }

        public void notifyChanged() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((DataObserver) ((Observable) this).mObservers.get(size)).onChanged();
            }
        }

        public void notifyItemMoved(int i10, int i11) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((DataObserver) ((Observable) this).mObservers.get(size)).onItemMoved(i10, i11);
            }
        }

        public void notifyItemRangeChanged(int i10, int i11) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((DataObserver) ((Observable) this).mObservers.get(size)).onItemRangeChanged(i10, i11);
            }
        }

        public void notifyItemRangeInserted(int i10, int i11) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((DataObserver) ((Observable) this).mObservers.get(size)).onItemRangeInserted(i10, i11);
            }
        }

        public void notifyItemRangeRemoved(int i10, int i11) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((DataObserver) ((Observable) this).mObservers.get(size)).onItemRangeRemoved(i10, i11);
            }
        }

        public void notifyItemRangeChanged(int i10, int i11, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((DataObserver) ((Observable) this).mObservers.get(size)).onItemRangeChanged(i10, i11, obj);
            }
        }
    }
}
