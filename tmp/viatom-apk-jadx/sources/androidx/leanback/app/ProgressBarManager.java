package androidx.leanback.app;

import android.R;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.google.gson.internal.a;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ProgressBarManager {
    private static final long DEFAULT_PROGRESS_BAR_DELAY = 1000;
    boolean mIsShowing;
    View mProgressBarView;
    boolean mUserProvidedProgressBar;
    ViewGroup rootView;
    private long mInitialDelay = 1000;
    private Handler mHandler = new Handler();
    boolean mEnableProgressBar = true;
    private Runnable runnable = new Runnable() { // from class: androidx.leanback.app.ProgressBarManager.1
        @Override // java.lang.Runnable
        public void run() {
            ProgressBarManager progressBarManager = ProgressBarManager.this;
            if (progressBarManager.mEnableProgressBar) {
                boolean z9 = progressBarManager.mUserProvidedProgressBar;
                if ((z9 || progressBarManager.rootView != null) && progressBarManager.mIsShowing) {
                    View view = progressBarManager.mProgressBarView;
                    if (view != null) {
                        if (z9) {
                            view.setVisibility(0);
                        }
                    } else {
                        progressBarManager.mProgressBarView = new ProgressBar(ProgressBarManager.this.rootView.getContext(), null, R.attr.progressBarStyleLarge);
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams.gravity = 17;
                        ProgressBarManager progressBarManager2 = ProgressBarManager.this;
                        progressBarManager2.rootView.addView(progressBarManager2.mProgressBarView, layoutParams);
                    }
                }
            }
        }
    };

    public void disableProgressBar() {
        this.mEnableProgressBar = false;
    }

    public void enableProgressBar() {
        this.mEnableProgressBar = true;
    }

    public long getInitialDelay() {
        return this.mInitialDelay;
    }

    public void hide() {
        this.mIsShowing = false;
        boolean z9 = this.mUserProvidedProgressBar;
        View view = this.mProgressBarView;
        if (z9) {
            view.setVisibility(4);
        } else if (view != null) {
            this.rootView.removeView(view);
            this.mProgressBarView = null;
        }
        this.mHandler.removeCallbacks(this.runnable);
    }

    public void setInitialDelay(long j10) {
        this.mInitialDelay = j10;
    }

    public void setProgressBarView(View view) {
        if (view != null && view.getParent() == null) {
            a.n("Must have a parent");
            return;
        }
        this.mProgressBarView = view;
        if (view != null) {
            view.setVisibility(4);
            this.mUserProvidedProgressBar = true;
        }
    }

    public void setRootView(ViewGroup viewGroup) {
        this.rootView = viewGroup;
    }

    public void show() {
        if (this.mEnableProgressBar) {
            this.mIsShowing = true;
            this.mHandler.postDelayed(this.runnable, this.mInitialDelay);
        }
    }
}
