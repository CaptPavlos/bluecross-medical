package androidx.leanback.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class Presenter implements FacetProvider {
    private Map<Class<?>, Object> mFacets;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class ViewHolder implements FacetProvider {
        private Map<Class<?>, Object> mFacets;
        public final View view;

        public ViewHolder(View view) {
            this.view = view;
        }

        @Override // androidx.leanback.widget.FacetProvider
        public final Object getFacet(Class<?> cls) {
            Map<Class<?>, Object> map = this.mFacets;
            if (map == null) {
                return null;
            }
            return map.get(cls);
        }

        public final void setFacet(Class<?> cls, Object obj) {
            if (this.mFacets == null) {
                this.mFacets = new ArrayMap();
            }
            this.mFacets.put(cls, obj);
        }
    }

    public static void cancelAnimationsRecursive(View view) {
        if (view == null || !view.hasTransientState()) {
            return;
        }
        view.animate().cancel();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; view.hasTransientState() && i10 < childCount; i10++) {
                cancelAnimationsRecursive(viewGroup.getChildAt(i10));
            }
        }
    }

    @Override // androidx.leanback.widget.FacetProvider
    public final Object getFacet(Class<?> cls) {
        Map<Class<?>, Object> map = this.mFacets;
        if (map == null) {
            return null;
        }
        return map.get(cls);
    }

    public abstract void onBindViewHolder(ViewHolder viewHolder, Object obj);

    public void onBindViewHolder(ViewHolder viewHolder, Object obj, List<Object> list) {
        onBindViewHolder(viewHolder, obj);
    }

    public abstract ViewHolder onCreateViewHolder(ViewGroup viewGroup);

    public abstract void onUnbindViewHolder(ViewHolder viewHolder);

    public void onViewDetachedFromWindow(ViewHolder viewHolder) {
        cancelAnimationsRecursive(viewHolder.view);
    }

    public final void setFacet(Class<?> cls, Object obj) {
        if (this.mFacets == null) {
            this.mFacets = new ArrayMap();
        }
        this.mFacets.put(cls, obj);
    }

    public void setOnClickListener(ViewHolder viewHolder, View.OnClickListener onClickListener) {
        viewHolder.view.setOnClickListener(onClickListener);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static abstract class ViewHolderTask {
        public void run(ViewHolder viewHolder) {
        }
    }

    public void onViewAttachedToWindow(ViewHolder viewHolder) {
    }
}
