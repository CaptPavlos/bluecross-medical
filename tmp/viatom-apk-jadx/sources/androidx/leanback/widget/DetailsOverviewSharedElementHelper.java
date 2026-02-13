package androidx.leanback.widget;

import android.app.Activity;
import android.graphics.Matrix;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.app.ActivityCompat;
import androidx.core.app.SharedElementCallback;
import androidx.core.view.ViewCompat;
import androidx.leanback.transition.TransitionHelper;
import androidx.leanback.transition.TransitionListener;
import androidx.leanback.widget.DetailsOverviewRowPresenter;
import java.lang.ref.WeakReference;
import java.util.List;
import z8.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final class DetailsOverviewSharedElementHelper extends SharedElementCallback {
    static final boolean DEBUG = false;
    static final String TAG = "DetailsTransitionHelper";
    Activity mActivityToRunTransition;
    int mRightPanelHeight;
    int mRightPanelWidth;
    private Matrix mSavedMatrix;
    private ImageView.ScaleType mSavedScaleType;
    String mSharedElementName;
    boolean mStartedPostpone;
    WeakReference<DetailsOverviewRowPresenter.ViewHolder> mViewHolder = new WeakReference<>(null);

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class TransitionTimeOutRunnable implements Runnable {
        final WeakReference<DetailsOverviewSharedElementHelper> mHelperRef;

        public TransitionTimeOutRunnable(DetailsOverviewSharedElementHelper detailsOverviewSharedElementHelper) {
            this.mHelperRef = new WeakReference<>(detailsOverviewSharedElementHelper);
        }

        @Override // java.lang.Runnable
        public void run() {
            DetailsOverviewSharedElementHelper detailsOverviewSharedElementHelper = this.mHelperRef.get();
            if (detailsOverviewSharedElementHelper == null) {
                return;
            }
            detailsOverviewSharedElementHelper.startPostponedEnterTransition();
        }
    }

    private static void changeImageViewScale(DetailsOverviewRowPresenter.ViewHolder viewHolder, View view) {
        ImageView imageView = (ImageView) view;
        ImageView imageView2 = viewHolder.mImageView;
        imageView2.setScaleType(imageView.getScaleType());
        if (imageView.getScaleType() == ImageView.ScaleType.MATRIX) {
            imageView2.setImageMatrix(imageView.getImageMatrix());
        }
        updateImageViewAfterScaleTypeChange(imageView2);
    }

    private boolean hasImageViewScaleChange(View view) {
        return view instanceof ImageView;
    }

    private void restoreImageViewScale(DetailsOverviewRowPresenter.ViewHolder viewHolder) {
        ImageView.ScaleType scaleType = this.mSavedScaleType;
        if (scaleType != null) {
            ImageView imageView = viewHolder.mImageView;
            imageView.setScaleType(scaleType);
            if (this.mSavedScaleType == ImageView.ScaleType.MATRIX) {
                imageView.setImageMatrix(this.mSavedMatrix);
            }
            this.mSavedScaleType = null;
            updateImageViewAfterScaleTypeChange(imageView);
        }
    }

    private void saveImageViewScale() {
        DetailsOverviewRowPresenter.ViewHolder viewHolder = this.mViewHolder.get();
        if (this.mSavedScaleType != null || viewHolder == null) {
            return;
        }
        ImageView imageView = viewHolder.mImageView;
        ImageView.ScaleType scaleType = imageView.getScaleType();
        this.mSavedScaleType = scaleType;
        this.mSavedMatrix = scaleType == ImageView.ScaleType.MATRIX ? imageView.getMatrix() : null;
    }

    private static void updateImageViewAfterScaleTypeChange(ImageView imageView) {
        imageView.measure(View.MeasureSpec.makeMeasureSpec(imageView.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(imageView.getMeasuredHeight(), 1073741824));
        imageView.layout(imageView.getLeft(), imageView.getTop(), imageView.getRight(), imageView.getBottom());
    }

    public void onBindToDrawable(DetailsOverviewRowPresenter.ViewHolder viewHolder) {
        DetailsOverviewRowPresenter.ViewHolder viewHolder2 = this.mViewHolder.get();
        if (viewHolder2 != null) {
            ViewCompat.setTransitionName(viewHolder2.mOverviewFrame, null);
        }
        this.mViewHolder = new WeakReference<>(viewHolder);
        viewHolder.mRightPanel.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.leanback.widget.DetailsOverviewSharedElementHelper.1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                view.removeOnLayoutChangeListener(this);
                DetailsOverviewRowPresenter.ViewHolder viewHolder3 = DetailsOverviewSharedElementHelper.this.mViewHolder.get();
                if (viewHolder3 != null) {
                    DetailsOverviewSharedElementHelper.this.mRightPanelWidth = viewHolder3.mRightPanel.getWidth();
                    DetailsOverviewSharedElementHelper.this.mRightPanelHeight = viewHolder3.mRightPanel.getHeight();
                }
            }
        });
        viewHolder.mRightPanel.postOnAnimation(new Runnable() { // from class: androidx.leanback.widget.DetailsOverviewSharedElementHelper.2
            @Override // java.lang.Runnable
            public void run() {
                DetailsOverviewRowPresenter.ViewHolder viewHolder3 = DetailsOverviewSharedElementHelper.this.mViewHolder.get();
                if (viewHolder3 == null) {
                    return;
                }
                ViewCompat.setTransitionName(viewHolder3.mOverviewFrame, DetailsOverviewSharedElementHelper.this.mSharedElementName);
                Object sharedElementEnterTransition = TransitionHelper.getSharedElementEnterTransition(DetailsOverviewSharedElementHelper.this.mActivityToRunTransition.getWindow());
                if (sharedElementEnterTransition != null) {
                    TransitionHelper.addTransitionListener(sharedElementEnterTransition, new TransitionListener() { // from class: androidx.leanback.widget.DetailsOverviewSharedElementHelper.2.1
                        @Override // androidx.leanback.transition.TransitionListener
                        public void onTransitionEnd(Object obj) {
                            DetailsOverviewRowPresenter.ViewHolder viewHolder4 = DetailsOverviewSharedElementHelper.this.mViewHolder.get();
                            if (viewHolder4 != null && viewHolder4.mActionsRow.isFocused()) {
                                viewHolder4.mActionsRow.requestFocus();
                            }
                            TransitionHelper.removeTransitionListener(obj, this);
                        }
                    });
                }
                DetailsOverviewSharedElementHelper.this.startPostponedEnterTransition();
            }
        });
    }

    @Override // androidx.core.app.SharedElementCallback
    public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
        if (list2.size() < 1) {
            return;
        }
        DetailsOverviewRowPresenter.ViewHolder viewHolder = this.mViewHolder.get();
        View view = list2.get(0);
        if (viewHolder == null || viewHolder.mOverviewFrame != view) {
            return;
        }
        restoreImageViewScale(viewHolder);
        viewHolder.mActionsRow.setDescendantFocusability(131072);
        viewHolder.mActionsRow.setVisibility(0);
        viewHolder.mActionsRow.setDescendantFocusability(262144);
        viewHolder.mActionsRow.requestFocus();
        viewHolder.mDetailsDescriptionFrame.setVisibility(0);
    }

    @Override // androidx.core.app.SharedElementCallback
    public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
        if (list2.size() < 1) {
            return;
        }
        DetailsOverviewRowPresenter.ViewHolder viewHolder = this.mViewHolder.get();
        View view = list2.get(0);
        if (viewHolder == null || viewHolder.mOverviewFrame != view) {
            return;
        }
        View view2 = list3.get(0);
        if (hasImageViewScaleChange(view2)) {
            saveImageViewScale();
            changeImageViewScale(viewHolder, view2);
        }
        ImageView imageView = viewHolder.mImageView;
        int width = view.getWidth();
        int height = view.getHeight();
        imageView.measure(View.MeasureSpec.makeMeasureSpec(width, 1073741824), View.MeasureSpec.makeMeasureSpec(height, 1073741824));
        imageView.layout(0, 0, width, height);
        ViewGroup viewGroup = viewHolder.mRightPanel;
        int i10 = this.mRightPanelWidth;
        if (i10 == 0 || this.mRightPanelHeight == 0) {
            viewGroup.offsetLeftAndRight(width - viewGroup.getLeft());
        } else {
            viewGroup.measure(View.MeasureSpec.makeMeasureSpec(i10, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mRightPanelHeight, 1073741824));
            viewGroup.layout(width, viewGroup.getTop(), this.mRightPanelWidth + width, viewGroup.getTop() + this.mRightPanelHeight);
        }
        viewHolder.mActionsRow.setVisibility(4);
        viewHolder.mDetailsDescriptionFrame.setVisibility(4);
    }

    public void setSharedElementEnterTransition(Activity activity, String str, long j10) {
        if ((activity == null && !TextUtils.isEmpty(str)) || (activity != null && TextUtils.isEmpty(str))) {
            f.a();
            return;
        }
        if (activity == this.mActivityToRunTransition && TextUtils.equals(str, this.mSharedElementName)) {
            return;
        }
        Activity activity2 = this.mActivityToRunTransition;
        if (activity2 != null) {
            ActivityCompat.setEnterSharedElementCallback(activity2, null);
        }
        this.mActivityToRunTransition = activity;
        this.mSharedElementName = str;
        ActivityCompat.setEnterSharedElementCallback(activity, this);
        ActivityCompat.postponeEnterTransition(this.mActivityToRunTransition);
        if (j10 > 0) {
            new Handler().postDelayed(new TransitionTimeOutRunnable(this), j10);
        }
    }

    public void startPostponedEnterTransition() {
        if (this.mStartedPostpone) {
            return;
        }
        ActivityCompat.startPostponedEnterTransition(this.mActivityToRunTransition);
        this.mStartedPostpone = true;
    }
}
