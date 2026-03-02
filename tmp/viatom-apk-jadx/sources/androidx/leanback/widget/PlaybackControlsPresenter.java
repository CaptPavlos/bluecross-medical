package androidx.leanback.widget;

import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.leanback.util.MathUtil;
import androidx.leanback.widget.ControlBarPresenter;
import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.PlaybackControlsRow;
import androidx.leanback.widget.Presenter;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
class PlaybackControlsPresenter extends ControlBarPresenter {
    private static int sChildMarginBigger;
    private static int sChildMarginBiggest;
    private boolean mMoreActionsEnabled;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class BoundData extends ControlBarPresenter.BoundData {
        ObjectAdapter secondaryActionsAdapter;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class ViewHolder extends ControlBarPresenter.ViewHolder {
        final TextView mCurrentTime;
        long mCurrentTimeInMs;
        int mCurrentTimeMarginStart;
        StringBuilder mCurrentTimeStringBuilder;
        ObjectAdapter mMoreActionsAdapter;
        final FrameLayout mMoreActionsDock;
        ObjectAdapter.DataObserver mMoreActionsObserver;
        boolean mMoreActionsShowing;
        Presenter.ViewHolder mMoreActionsViewHolder;
        final ProgressBar mProgressBar;
        long mSecondaryProgressInMs;
        final TextView mTotalTime;
        long mTotalTimeInMs;
        int mTotalTimeMarginEnd;
        StringBuilder mTotalTimeStringBuilder;

        public ViewHolder(View view) {
            super(view);
            this.mCurrentTimeInMs = -1L;
            this.mTotalTimeInMs = -1L;
            this.mSecondaryProgressInMs = -1L;
            this.mTotalTimeStringBuilder = new StringBuilder();
            this.mCurrentTimeStringBuilder = new StringBuilder();
            this.mMoreActionsDock = (FrameLayout) view.findViewById(androidx.leanback.R.id.more_actions_dock);
            TextView textView = (TextView) view.findViewById(androidx.leanback.R.id.current_time);
            this.mCurrentTime = textView;
            TextView textView2 = (TextView) view.findViewById(androidx.leanback.R.id.total_time);
            this.mTotalTime = textView2;
            this.mProgressBar = (ProgressBar) view.findViewById(androidx.leanback.R.id.playback_progress);
            this.mMoreActionsObserver = new ObjectAdapter.DataObserver() { // from class: androidx.leanback.widget.PlaybackControlsPresenter.ViewHolder.1
                @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
                public void onChanged() {
                    ViewHolder viewHolder = ViewHolder.this;
                    if (viewHolder.mMoreActionsShowing) {
                        viewHolder.showControls(viewHolder.mPresenter);
                    }
                }

                @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
                public void onItemRangeChanged(int i10, int i11) {
                    if (ViewHolder.this.mMoreActionsShowing) {
                        for (int i12 = 0; i12 < i11; i12++) {
                            ViewHolder viewHolder = ViewHolder.this;
                            viewHolder.bindControlToAction(i10 + i12, viewHolder.mPresenter);
                        }
                    }
                }
            };
            this.mCurrentTimeMarginStart = ((ViewGroup.MarginLayoutParams) textView.getLayoutParams()).getMarginStart();
            this.mTotalTimeMarginEnd = ((ViewGroup.MarginLayoutParams) textView2.getLayoutParams()).getMarginEnd();
        }

        @Override // androidx.leanback.widget.ControlBarPresenter.ViewHolder
        public int getChildMarginFromCenter(Context context, int i10) {
            int childMarginBigger;
            int controlIconWidth = PlaybackControlsPresenter.this.getControlIconWidth(context);
            if (i10 < 4) {
                childMarginBigger = PlaybackControlsPresenter.this.getChildMarginBiggest(context);
            } else {
                PlaybackControlsPresenter playbackControlsPresenter = PlaybackControlsPresenter.this;
                childMarginBigger = i10 < 6 ? playbackControlsPresenter.getChildMarginBigger(context) : playbackControlsPresenter.getChildMarginDefault(context);
            }
            return controlIconWidth + childMarginBigger;
        }

        public long getCurrentTime() {
            return this.mTotalTimeInMs;
        }

        @Override // androidx.leanback.widget.ControlBarPresenter.ViewHolder
        public ObjectAdapter getDisplayedAdapter() {
            return this.mMoreActionsShowing ? this.mMoreActionsAdapter : this.mAdapter;
        }

        public long getSecondaryProgress() {
            return this.mSecondaryProgressInMs;
        }

        public long getTotalTime() {
            return this.mTotalTimeInMs;
        }

        public void setCurrentTime(long j10) {
            long j11 = j10 / 1000;
            if (j10 != this.mCurrentTimeInMs) {
                this.mCurrentTimeInMs = j10;
                PlaybackControlsPresenter.formatTime(j11, this.mCurrentTimeStringBuilder);
                this.mCurrentTime.setText(this.mCurrentTimeStringBuilder.toString());
            }
            this.mProgressBar.setProgress((int) ((this.mCurrentTimeInMs / this.mTotalTimeInMs) * 2.147483647E9d));
        }

        public void setSecondaryProgress(long j10) {
            this.mSecondaryProgressInMs = j10;
            this.mProgressBar.setSecondaryProgress((int) ((j10 / this.mTotalTimeInMs) * 2.147483647E9d));
        }

        public void setTotalTime(long j10) {
            TextView textView = this.mTotalTime;
            if (j10 <= 0) {
                textView.setVisibility(8);
                this.mProgressBar.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            this.mProgressBar.setVisibility(0);
            this.mTotalTimeInMs = j10;
            PlaybackControlsPresenter.formatTime(j10 / 1000, this.mTotalTimeStringBuilder);
            this.mTotalTime.setText(this.mTotalTimeStringBuilder.toString());
            this.mProgressBar.setMax(Integer.MAX_VALUE);
        }

        public void showMoreActions(boolean z9) {
            Presenter.ViewHolder viewHolder = this.mMoreActionsViewHolder;
            if (!z9) {
                if (viewHolder == null || viewHolder.view.getParent() == null) {
                    return;
                }
                this.mMoreActionsDock.removeView(this.mMoreActionsViewHolder.view);
                return;
            }
            if (viewHolder == null) {
                PlaybackControlsRow.MoreActions moreActions = new PlaybackControlsRow.MoreActions(this.mMoreActionsDock.getContext());
                Presenter.ViewHolder viewHolderOnCreateViewHolder = this.mPresenter.onCreateViewHolder(this.mMoreActionsDock);
                this.mMoreActionsViewHolder = viewHolderOnCreateViewHolder;
                this.mPresenter.onBindViewHolder(viewHolderOnCreateViewHolder, moreActions);
                this.mPresenter.setOnClickListener(this.mMoreActionsViewHolder, new View.OnClickListener() { // from class: androidx.leanback.widget.PlaybackControlsPresenter.ViewHolder.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ViewHolder.this.toggleMoreActions();
                    }
                });
            }
            if (this.mMoreActionsViewHolder.view.getParent() == null) {
                this.mMoreActionsDock.addView(this.mMoreActionsViewHolder.view);
            }
        }

        public void toggleMoreActions() {
            this.mMoreActionsShowing = !this.mMoreActionsShowing;
            showControls(this.mPresenter);
        }
    }

    public PlaybackControlsPresenter(int i10) {
        super(i10);
        this.mMoreActionsEnabled = true;
    }

    public static void formatTime(long j10, StringBuilder sb) {
        long j11 = j10 / 60;
        long j12 = j11 / 60;
        long j13 = j10 - (j11 * 60);
        long j14 = j11 - (60 * j12);
        sb.setLength(0);
        if (j12 > 0) {
            sb.append(j12);
            sb.append(':');
            if (j14 < 10) {
                sb.append('0');
            }
        }
        sb.append(j14);
        sb.append(':');
        if (j13 < 10) {
            sb.append('0');
        }
        sb.append(j13);
    }

    public boolean areMoreActionsEnabled() {
        return this.mMoreActionsEnabled;
    }

    public void enableSecondaryActions(boolean z9) {
        this.mMoreActionsEnabled = z9;
    }

    public void enableTimeMargins(ViewHolder viewHolder, boolean z9) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewHolder.mCurrentTime.getLayoutParams();
        marginLayoutParams.setMarginStart(z9 ? viewHolder.mCurrentTimeMarginStart : 0);
        viewHolder.mCurrentTime.setLayoutParams(marginLayoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) viewHolder.mTotalTime.getLayoutParams();
        marginLayoutParams2.setMarginEnd(z9 ? viewHolder.mTotalTimeMarginEnd : 0);
        viewHolder.mTotalTime.setLayoutParams(marginLayoutParams2);
    }

    public int getChildMarginBigger(Context context) {
        if (sChildMarginBigger == 0) {
            sChildMarginBigger = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_playback_controls_child_margin_bigger);
        }
        return sChildMarginBigger;
    }

    public int getChildMarginBiggest(Context context) {
        if (sChildMarginBiggest == 0) {
            sChildMarginBiggest = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_playback_controls_child_margin_biggest);
        }
        return sChildMarginBiggest;
    }

    public int getCurrentTime(ViewHolder viewHolder) {
        return MathUtil.safeLongToInt(getCurrentTimeLong(viewHolder));
    }

    public long getCurrentTimeLong(ViewHolder viewHolder) {
        return viewHolder.getCurrentTime();
    }

    public int getSecondaryProgress(ViewHolder viewHolder) {
        return MathUtil.safeLongToInt(getSecondaryProgressLong(viewHolder));
    }

    public long getSecondaryProgressLong(ViewHolder viewHolder) {
        return viewHolder.getSecondaryProgress();
    }

    public int getTotalTime(ViewHolder viewHolder) {
        return MathUtil.safeLongToInt(getTotalTimeLong(viewHolder));
    }

    public long getTotalTimeLong(ViewHolder viewHolder) {
        return viewHolder.getTotalTime();
    }

    @Override // androidx.leanback.widget.ControlBarPresenter, androidx.leanback.widget.Presenter
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        ObjectAdapter objectAdapter = viewHolder2.mMoreActionsAdapter;
        ObjectAdapter objectAdapter2 = ((BoundData) obj).secondaryActionsAdapter;
        if (objectAdapter != objectAdapter2) {
            viewHolder2.mMoreActionsAdapter = objectAdapter2;
            objectAdapter2.registerObserver(viewHolder2.mMoreActionsObserver);
            viewHolder2.mMoreActionsShowing = false;
        }
        super.onBindViewHolder(viewHolder, obj);
        viewHolder2.showMoreActions(this.mMoreActionsEnabled);
    }

    @Override // androidx.leanback.widget.ControlBarPresenter, androidx.leanback.widget.Presenter
    public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(getLayoutResourceId(), viewGroup, false));
    }

    @Override // androidx.leanback.widget.ControlBarPresenter, androidx.leanback.widget.Presenter
    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        super.onUnbindViewHolder(viewHolder);
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        ObjectAdapter objectAdapter = viewHolder2.mMoreActionsAdapter;
        if (objectAdapter != null) {
            objectAdapter.unregisterObserver(viewHolder2.mMoreActionsObserver);
            viewHolder2.mMoreActionsAdapter = null;
        }
    }

    public void resetFocus(ViewHolder viewHolder) {
        viewHolder.mControlBar.requestFocus();
    }

    public void setCurrentTime(ViewHolder viewHolder, int i10) {
        setCurrentTimeLong(viewHolder, i10);
    }

    public void setCurrentTimeLong(ViewHolder viewHolder, long j10) {
        viewHolder.setCurrentTime(j10);
    }

    public void setProgressColor(ViewHolder viewHolder, @ColorInt int i10) {
        ((LayerDrawable) viewHolder.mProgressBar.getProgressDrawable()).setDrawableByLayerId(android.R.id.progress, new ClipDrawable(new ColorDrawable(i10), 3, 1));
    }

    public void setSecondaryProgress(ViewHolder viewHolder, int i10) {
        setSecondaryProgressLong(viewHolder, i10);
    }

    public void setSecondaryProgressLong(ViewHolder viewHolder, long j10) {
        viewHolder.setSecondaryProgress(j10);
    }

    public void setTotalTime(ViewHolder viewHolder, int i10) {
        setTotalTimeLong(viewHolder, i10);
    }

    public void setTotalTimeLong(ViewHolder viewHolder, long j10) {
        viewHolder.setTotalTime(j10);
    }

    public void showPrimaryActions(ViewHolder viewHolder) {
        if (viewHolder.mMoreActionsShowing) {
            viewHolder.toggleMoreActions();
        }
    }
}
