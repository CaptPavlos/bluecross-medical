package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.leanback.widget.ControlBarPresenter;
import androidx.leanback.widget.PlaybackControlsPresenter;
import androidx.leanback.widget.PlaybackControlsRow;
import androidx.leanback.widget.PlaybackRowPresenter;
import androidx.leanback.widget.PlaybackSeekDataProvider;
import androidx.leanback.widget.PlaybackSeekUi;
import androidx.leanback.widget.PlaybackTransportRowView;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowPresenter;
import androidx.leanback.widget.SeekBar;
import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class PlaybackTransportRowPresenter extends PlaybackRowPresenter {
    Presenter mDescriptionPresenter;
    OnActionClickedListener mOnActionClickedListener;
    private final ControlBarPresenter.OnControlClickedListener mOnControlClickedListener;
    private final ControlBarPresenter.OnControlSelectedListener mOnControlSelectedListener;
    ControlBarPresenter mPlaybackControlsPresenter;
    boolean mProgressColorSet;
    ControlBarPresenter mSecondaryControlsPresenter;
    boolean mSecondaryProgressColorSet;
    float mDefaultSeekIncrement = 0.01f;
    int mProgressColor = 0;
    int mSecondaryProgressColor = 0;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class BoundData extends PlaybackControlsPresenter.BoundData {
        ViewHolder mRowViewHolder;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class ViewHolder extends PlaybackRowPresenter.ViewHolder implements PlaybackSeekUi {
        BoundData mControlsBoundData;
        final ViewGroup mControlsDock;
        ControlBarPresenter.ViewHolder mControlsVh;
        final TextView mCurrentTime;
        long mCurrentTimeInMs;
        final ViewGroup mDescriptionDock;
        final Presenter.ViewHolder mDescriptionViewHolder;
        final ImageView mImageView;
        boolean mInSeek;
        final PlaybackControlsRow.OnPlaybackProgressCallback mListener;
        PlaybackControlsRow.PlayPauseAction mPlayPauseAction;
        long[] mPositions;
        int mPositionsLength;
        final SeekBar mProgressBar;
        BoundData mSecondaryBoundData;
        final ViewGroup mSecondaryControlsDock;
        ControlBarPresenter.ViewHolder mSecondaryControlsVh;
        long mSecondaryProgressInMs;
        PlaybackSeekUi.Client mSeekClient;
        PlaybackSeekDataProvider mSeekDataProvider;
        Object mSelectedItem;
        Presenter.ViewHolder mSelectedViewHolder;
        final StringBuilder mTempBuilder;
        int mThumbHeroIndex;
        PlaybackSeekDataProvider.ResultCallback mThumbResult;
        final ThumbsBar mThumbsBar;
        final TextView mTotalTime;
        long mTotalTimeInMs;

        public ViewHolder(View view, Presenter presenter) {
            super(view);
            this.mTotalTimeInMs = Long.MIN_VALUE;
            this.mCurrentTimeInMs = Long.MIN_VALUE;
            this.mTempBuilder = new StringBuilder();
            this.mControlsBoundData = new BoundData();
            this.mSecondaryBoundData = new BoundData();
            this.mThumbHeroIndex = -1;
            this.mListener = new PlaybackControlsRow.OnPlaybackProgressCallback() { // from class: androidx.leanback.widget.PlaybackTransportRowPresenter.ViewHolder.1
                @Override // androidx.leanback.widget.PlaybackControlsRow.OnPlaybackProgressCallback
                public void onBufferedPositionChanged(PlaybackControlsRow playbackControlsRow, long j10) {
                    ViewHolder.this.setBufferedPosition(j10);
                }

                @Override // androidx.leanback.widget.PlaybackControlsRow.OnPlaybackProgressCallback
                public void onCurrentPositionChanged(PlaybackControlsRow playbackControlsRow, long j10) {
                    ViewHolder.this.setCurrentPosition(j10);
                }

                @Override // androidx.leanback.widget.PlaybackControlsRow.OnPlaybackProgressCallback
                public void onDurationChanged(PlaybackControlsRow playbackControlsRow, long j10) {
                    ViewHolder.this.setTotalTime(j10);
                }
            };
            this.mThumbResult = new PlaybackSeekDataProvider.ResultCallback() { // from class: androidx.leanback.widget.PlaybackTransportRowPresenter.ViewHolder.2
                @Override // androidx.leanback.widget.PlaybackSeekDataProvider.ResultCallback
                public void onThumbnailLoaded(Bitmap bitmap, int i10) {
                    ViewHolder viewHolder = ViewHolder.this;
                    int childCount = i10 - (viewHolder.mThumbHeroIndex - (viewHolder.mThumbsBar.getChildCount() / 2));
                    if (childCount < 0 || childCount >= ViewHolder.this.mThumbsBar.getChildCount()) {
                        return;
                    }
                    ViewHolder.this.mThumbsBar.setThumbBitmap(childCount, bitmap);
                }
            };
            this.mImageView = (ImageView) view.findViewById(androidx.leanback.R.id.image);
            ViewGroup viewGroup = (ViewGroup) view.findViewById(androidx.leanback.R.id.description_dock);
            this.mDescriptionDock = viewGroup;
            this.mCurrentTime = (TextView) view.findViewById(androidx.leanback.R.id.current_time);
            this.mTotalTime = (TextView) view.findViewById(androidx.leanback.R.id.total_time);
            SeekBar seekBar = (SeekBar) view.findViewById(androidx.leanback.R.id.playback_progress);
            this.mProgressBar = seekBar;
            seekBar.setOnClickListener(new View.OnClickListener() { // from class: androidx.leanback.widget.PlaybackTransportRowPresenter.ViewHolder.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    ViewHolder viewHolder = ViewHolder.this;
                    PlaybackTransportRowPresenter.this.onProgressBarClicked(viewHolder);
                }
            });
            seekBar.setOnKeyListener(new View.OnKeyListener() { // from class: androidx.leanback.widget.PlaybackTransportRowPresenter.ViewHolder.4
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view2, int i10, KeyEvent keyEvent) {
                    if (i10 != 4) {
                        if (i10 != 66) {
                            if (i10 != 69) {
                                if (i10 != 81) {
                                    if (i10 != 111) {
                                        if (i10 != 89) {
                                            if (i10 != 90) {
                                                switch (i10) {
                                                    case 19:
                                                    case 20:
                                                        return ViewHolder.this.mInSeek;
                                                    case 21:
                                                        break;
                                                    case 22:
                                                        break;
                                                    case 23:
                                                        break;
                                                    default:
                                                        return false;
                                                }
                                            }
                                        }
                                    }
                                }
                                if (keyEvent.getAction() == 0) {
                                    ViewHolder.this.onForward();
                                }
                                return true;
                            }
                            if (keyEvent.getAction() == 0) {
                                ViewHolder.this.onBackward();
                            }
                            return true;
                        }
                        if (!ViewHolder.this.mInSeek) {
                            return false;
                        }
                        if (keyEvent.getAction() == 1) {
                            ViewHolder.this.stopSeek(false);
                        }
                        return true;
                    }
                    if (!ViewHolder.this.mInSeek) {
                        return false;
                    }
                    if (keyEvent.getAction() == 1) {
                        ViewHolder.this.stopSeek(!r3.mProgressBar.isAccessibilityFocused());
                    }
                    return true;
                }
            });
            seekBar.setAccessibilitySeekListener(new SeekBar.AccessibilitySeekListener() { // from class: androidx.leanback.widget.PlaybackTransportRowPresenter.ViewHolder.5
                @Override // androidx.leanback.widget.SeekBar.AccessibilitySeekListener
                public boolean onAccessibilitySeekBackward() {
                    return ViewHolder.this.onBackward();
                }

                @Override // androidx.leanback.widget.SeekBar.AccessibilitySeekListener
                public boolean onAccessibilitySeekForward() {
                    return ViewHolder.this.onForward();
                }
            });
            seekBar.setMax(Integer.MAX_VALUE);
            this.mControlsDock = (ViewGroup) view.findViewById(androidx.leanback.R.id.controls_dock);
            this.mSecondaryControlsDock = (ViewGroup) view.findViewById(androidx.leanback.R.id.secondary_controls_dock);
            Presenter.ViewHolder viewHolderOnCreateViewHolder = presenter == null ? null : presenter.onCreateViewHolder(viewGroup);
            this.mDescriptionViewHolder = viewHolderOnCreateViewHolder;
            if (viewHolderOnCreateViewHolder != null) {
                viewGroup.addView(viewHolderOnCreateViewHolder.view);
            }
            this.mThumbsBar = (ThumbsBar) view.findViewById(androidx.leanback.R.id.thumbs_row);
        }

        public void dispatchItemSelection() {
            if (isSelected()) {
                if (this.mSelectedViewHolder == null) {
                    if (getOnItemViewSelectedListener() != null) {
                        getOnItemViewSelectedListener().onItemSelected(null, null, this, getRow());
                    }
                } else if (getOnItemViewSelectedListener() != null) {
                    getOnItemViewSelectedListener().onItemSelected(this.mSelectedViewHolder, this.mSelectedItem, this, getRow());
                }
            }
        }

        public final TextView getCurrentPositionView() {
            return this.mCurrentTime;
        }

        public final Presenter.ViewHolder getDescriptionViewHolder() {
            return this.mDescriptionViewHolder;
        }

        public final TextView getDurationView() {
            return this.mTotalTime;
        }

        public Presenter getPresenter(boolean z9) {
            ObjectAdapter primaryActionsAdapter = z9 ? ((PlaybackControlsRow) getRow()).getPrimaryActionsAdapter() : ((PlaybackControlsRow) getRow()).getSecondaryActionsAdapter();
            if (primaryActionsAdapter == null) {
                return null;
            }
            if (primaryActionsAdapter.getPresenterSelector() instanceof ControlButtonPresenterSelector) {
                return ((ControlButtonPresenterSelector) primaryActionsAdapter.getPresenterSelector()).getSecondaryPresenter();
            }
            return primaryActionsAdapter.getPresenter(primaryActionsAdapter.size() > 0 ? primaryActionsAdapter.get(0) : null);
        }

        public boolean onBackward() {
            if (!startSeek()) {
                return false;
            }
            updateProgressInSeek(false);
            return true;
        }

        public boolean onForward() {
            if (!startSeek()) {
                return false;
            }
            updateProgressInSeek(true);
            return true;
        }

        public void onSetCurrentPositionLabel(long j10) {
            if (this.mCurrentTime != null) {
                PlaybackTransportRowPresenter.formatTime(j10, this.mTempBuilder);
                this.mCurrentTime.setText(this.mTempBuilder.toString());
            }
        }

        public void onSetDurationLabel(long j10) {
            if (this.mTotalTime != null) {
                PlaybackTransportRowPresenter.formatTime(j10, this.mTempBuilder);
                this.mTotalTime.setText(this.mTempBuilder.toString());
            }
        }

        public void setBufferedPosition(long j10) {
            this.mSecondaryProgressInMs = j10;
            this.mProgressBar.setSecondaryProgress((int) ((j10 / this.mTotalTimeInMs) * 2.147483647E9d));
        }

        public void setCurrentPosition(long j10) {
            if (j10 != this.mCurrentTimeInMs) {
                this.mCurrentTimeInMs = j10;
                onSetCurrentPositionLabel(j10);
            }
            if (this.mInSeek) {
                return;
            }
            long j11 = this.mTotalTimeInMs;
            this.mProgressBar.setProgress(j11 > 0 ? (int) ((this.mCurrentTimeInMs / j11) * 2.147483647E9d) : 0);
        }

        @Override // androidx.leanback.widget.PlaybackSeekUi
        public void setPlaybackSeekUiClient(PlaybackSeekUi.Client client) {
            this.mSeekClient = client;
        }

        public void setTotalTime(long j10) {
            if (this.mTotalTimeInMs != j10) {
                this.mTotalTimeInMs = j10;
                onSetDurationLabel(j10);
            }
        }

        public boolean startSeek() {
            if (this.mInSeek) {
                return true;
            }
            PlaybackSeekUi.Client client = this.mSeekClient;
            if (client == null || !client.isSeekEnabled() || this.mTotalTimeInMs <= 0) {
                return false;
            }
            this.mInSeek = true;
            this.mSeekClient.onSeekStarted();
            PlaybackSeekDataProvider playbackSeekDataProvider = this.mSeekClient.getPlaybackSeekDataProvider();
            this.mSeekDataProvider = playbackSeekDataProvider;
            long[] seekPositions = playbackSeekDataProvider != null ? playbackSeekDataProvider.getSeekPositions() : null;
            this.mPositions = seekPositions;
            if (seekPositions != null) {
                int iBinarySearch = Arrays.binarySearch(seekPositions, this.mTotalTimeInMs);
                if (iBinarySearch >= 0) {
                    this.mPositionsLength = iBinarySearch + 1;
                } else {
                    this.mPositionsLength = (-1) - iBinarySearch;
                }
            } else {
                this.mPositionsLength = 0;
            }
            this.mControlsVh.view.setVisibility(8);
            this.mSecondaryControlsVh.view.setVisibility(4);
            this.mDescriptionViewHolder.view.setVisibility(4);
            this.mThumbsBar.setVisibility(0);
            return true;
        }

        public void stopSeek(boolean z9) {
            if (this.mInSeek) {
                this.mInSeek = false;
                this.mSeekClient.onSeekFinished(z9);
                PlaybackSeekDataProvider playbackSeekDataProvider = this.mSeekDataProvider;
                if (playbackSeekDataProvider != null) {
                    playbackSeekDataProvider.reset();
                }
                this.mThumbHeroIndex = -1;
                this.mThumbsBar.clearThumbBitmaps();
                this.mSeekDataProvider = null;
                this.mPositions = null;
                this.mPositionsLength = 0;
                this.mControlsVh.view.setVisibility(0);
                this.mSecondaryControlsVh.view.setVisibility(0);
                this.mDescriptionViewHolder.view.setVisibility(0);
                this.mThumbsBar.setVisibility(4);
            }
        }

        public void updateProgressInSeek(boolean z9) {
            long j10 = this.mCurrentTimeInMs;
            int i10 = this.mPositionsLength;
            long j11 = 0;
            if (i10 > 0) {
                int i11 = 0;
                int iBinarySearch = Arrays.binarySearch(this.mPositions, 0, i10, j10);
                if (z9) {
                    int i12 = this.mPositionsLength;
                    if (iBinarySearch < 0) {
                        int i13 = (-1) - iBinarySearch;
                        if (i13 <= i12 - 1) {
                            j11 = this.mPositions[i13];
                            i11 = i13;
                        } else {
                            j11 = this.mTotalTimeInMs;
                            if (i13 > 0) {
                                i11 = (-2) - iBinarySearch;
                            }
                        }
                    } else if (iBinarySearch < i12 - 1) {
                        i11 = iBinarySearch + 1;
                        j11 = this.mPositions[i11];
                    } else {
                        j11 = this.mTotalTimeInMs;
                        i11 = iBinarySearch;
                    }
                } else if (iBinarySearch >= 0) {
                    if (iBinarySearch > 0) {
                        i11 = iBinarySearch - 1;
                        j11 = this.mPositions[i11];
                    }
                } else if ((-1) - iBinarySearch > 0) {
                    i11 = (-2) - iBinarySearch;
                    j11 = this.mPositions[i11];
                }
                updateThumbsInSeek(i11, z9);
            } else {
                long defaultSeekIncrement = (long) (PlaybackTransportRowPresenter.this.getDefaultSeekIncrement() * this.mTotalTimeInMs);
                if (!z9) {
                    defaultSeekIncrement = -defaultSeekIncrement;
                }
                long j12 = j10 + defaultSeekIncrement;
                long j13 = this.mTotalTimeInMs;
                if (j12 > j13) {
                    j11 = j13;
                } else if (j12 >= 0) {
                    j11 = j12;
                }
            }
            this.mProgressBar.setProgress((int) ((j11 / this.mTotalTimeInMs) * 2.147483647E9d));
            this.mSeekClient.onSeekPositionChanged(j11);
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x0085 A[ADDED_TO_REGION, LOOP:0: B:30:0x0085->B:31:0x0087, LOOP_START, PHI: r7
          0x0085: PHI (r7v13 int) = (r7v12 int), (r7v14 int) binds: [B:29:0x0083, B:31:0x0087] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0091 A[ADDED_TO_REGION, LOOP:3: B:32:0x0091->B:33:0x0093, LOOP_START, PHI: r5
          0x0091: PHI (r5v9 int) = (r5v8 int), (r5v10 int) binds: [B:29:0x0083, B:33:0x0093] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00a5 A[LOOP:1: B:34:0x009d->B:36:0x00a5, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00b2 A[LOOP:2: B:38:0x00b0->B:39:0x00b2, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00ad A[EDGE_INSN: B:44:0x00ad->B:37:0x00ad BREAK  A[LOOP:1: B:34:0x009d->B:36:0x00a5], SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void updateThumbsInSeek(int r12, boolean r13) {
            /*
                Method dump skipped, instructions count: 193
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.PlaybackTransportRowPresenter.ViewHolder.updateThumbsInSeek(int, boolean):void");
        }
    }

    public PlaybackTransportRowPresenter() {
        ControlBarPresenter.OnControlSelectedListener onControlSelectedListener = new ControlBarPresenter.OnControlSelectedListener() { // from class: androidx.leanback.widget.PlaybackTransportRowPresenter.1
            @Override // androidx.leanback.widget.ControlBarPresenter.OnControlSelectedListener
            public void onControlSelected(Presenter.ViewHolder viewHolder, Object obj, ControlBarPresenter.BoundData boundData) {
                ViewHolder viewHolder2 = ((BoundData) boundData).mRowViewHolder;
                if (viewHolder2.mSelectedViewHolder == viewHolder && viewHolder2.mSelectedItem == obj) {
                    return;
                }
                viewHolder2.mSelectedViewHolder = viewHolder;
                viewHolder2.mSelectedItem = obj;
                viewHolder2.dispatchItemSelection();
            }
        };
        this.mOnControlSelectedListener = onControlSelectedListener;
        ControlBarPresenter.OnControlClickedListener onControlClickedListener = new ControlBarPresenter.OnControlClickedListener() { // from class: androidx.leanback.widget.PlaybackTransportRowPresenter.2
            @Override // androidx.leanback.widget.ControlBarPresenter.OnControlClickedListener
            public void onControlClicked(Presenter.ViewHolder viewHolder, Object obj, ControlBarPresenter.BoundData boundData) {
                RowPresenter.ViewHolder viewHolder2 = ((BoundData) boundData).mRowViewHolder;
                if (viewHolder2.getOnItemViewClickedListener() != null) {
                    viewHolder2.getOnItemViewClickedListener().onItemClicked(viewHolder, obj, viewHolder2, viewHolder2.getRow());
                }
                OnActionClickedListener onActionClickedListener = PlaybackTransportRowPresenter.this.mOnActionClickedListener;
                if (onActionClickedListener == null || !(obj instanceof Action)) {
                    return;
                }
                onActionClickedListener.onActionClicked((Action) obj);
            }
        };
        this.mOnControlClickedListener = onControlClickedListener;
        setHeaderPresenter(null);
        setSelectEffectEnabled(false);
        int i10 = androidx.leanback.R.layout.lb_control_bar;
        ControlBarPresenter controlBarPresenter = new ControlBarPresenter(i10);
        this.mPlaybackControlsPresenter = controlBarPresenter;
        controlBarPresenter.setDefaultFocusToMiddle(false);
        ControlBarPresenter controlBarPresenter2 = new ControlBarPresenter(i10);
        this.mSecondaryControlsPresenter = controlBarPresenter2;
        controlBarPresenter2.setDefaultFocusToMiddle(false);
        this.mPlaybackControlsPresenter.setOnControlSelectedListener(onControlSelectedListener);
        this.mSecondaryControlsPresenter.setOnControlSelectedListener(onControlSelectedListener);
        this.mPlaybackControlsPresenter.setOnControlClickedListener(onControlClickedListener);
        this.mSecondaryControlsPresenter.setOnControlClickedListener(onControlClickedListener);
    }

    public static void formatTime(long j10, StringBuilder sb) {
        sb.setLength(0);
        if (j10 < 0) {
            sb.append("--");
            return;
        }
        long j11 = j10 / 1000;
        long j12 = j11 / 60;
        long j13 = j12 / 60;
        long j14 = j11 - (j12 * 60);
        long j15 = j12 - (60 * j13);
        if (j13 > 0) {
            sb.append(j13);
            sb.append(':');
            if (j15 < 10) {
                sb.append('0');
            }
        }
        sb.append(j15);
        sb.append(':');
        if (j14 < 10) {
            sb.append('0');
        }
        sb.append(j14);
    }

    private static int getDefaultProgressColor(Context context) {
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(androidx.leanback.R.attr.playbackProgressPrimaryColor, typedValue, true) ? context.getResources().getColor(typedValue.resourceId) : context.getResources().getColor(androidx.leanback.R.color.lb_playback_progress_color_no_theme);
    }

    private static int getDefaultSecondaryProgressColor(Context context) {
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(androidx.leanback.R.attr.playbackProgressSecondaryColor, typedValue, true) ? context.getResources().getColor(typedValue.resourceId) : context.getResources().getColor(androidx.leanback.R.color.lb_playback_progress_secondary_color_no_theme);
    }

    private void initRow(final ViewHolder viewHolder) {
        viewHolder.mControlsVh = (ControlBarPresenter.ViewHolder) this.mPlaybackControlsPresenter.onCreateViewHolder(viewHolder.mControlsDock);
        viewHolder.mProgressBar.setProgressColor(this.mProgressColorSet ? this.mProgressColor : getDefaultProgressColor(viewHolder.mControlsDock.getContext()));
        viewHolder.mProgressBar.setSecondaryProgressColor(this.mSecondaryProgressColorSet ? this.mSecondaryProgressColor : getDefaultSecondaryProgressColor(viewHolder.mControlsDock.getContext()));
        viewHolder.mControlsDock.addView(viewHolder.mControlsVh.view);
        ControlBarPresenter.ViewHolder viewHolder2 = (ControlBarPresenter.ViewHolder) this.mSecondaryControlsPresenter.onCreateViewHolder(viewHolder.mSecondaryControlsDock);
        viewHolder.mSecondaryControlsVh = viewHolder2;
        viewHolder.mSecondaryControlsDock.addView(viewHolder2.view);
        ((PlaybackTransportRowView) viewHolder.view.findViewById(androidx.leanback.R.id.transport_row)).setOnUnhandledKeyListener(new PlaybackTransportRowView.OnUnhandledKeyListener() { // from class: androidx.leanback.widget.PlaybackTransportRowPresenter.3
            @Override // androidx.leanback.widget.PlaybackTransportRowView.OnUnhandledKeyListener
            public boolean onUnhandledKey(KeyEvent keyEvent) {
                if (viewHolder.getOnKeyListener() != null) {
                    return viewHolder.getOnKeyListener().onKey(viewHolder.view, keyEvent.getKeyCode(), keyEvent);
                }
                return false;
            }
        });
    }

    @Override // androidx.leanback.widget.RowPresenter
    public RowPresenter.ViewHolder createRowViewHolder(ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(androidx.leanback.R.layout.lb_playback_transport_controls_row, viewGroup, false), this.mDescriptionPresenter);
        initRow(viewHolder);
        return viewHolder;
    }

    public float getDefaultSeekIncrement() {
        return this.mDefaultSeekIncrement;
    }

    public OnActionClickedListener getOnActionClickedListener() {
        return this.mOnActionClickedListener;
    }

    @ColorInt
    public int getProgressColor() {
        return this.mProgressColor;
    }

    @ColorInt
    public int getSecondaryProgressColor() {
        return this.mSecondaryProgressColor;
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onBindRowViewHolder(RowPresenter.ViewHolder viewHolder, Object obj) {
        super.onBindRowViewHolder(viewHolder, obj);
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        PlaybackControlsRow playbackControlsRow = (PlaybackControlsRow) viewHolder2.getRow();
        Object item = playbackControlsRow.getItem();
        ViewGroup viewGroup = viewHolder2.mDescriptionDock;
        if (item == null) {
            viewGroup.setVisibility(8);
        } else {
            viewGroup.setVisibility(0);
            Presenter.ViewHolder viewHolder3 = viewHolder2.mDescriptionViewHolder;
            if (viewHolder3 != null) {
                this.mDescriptionPresenter.onBindViewHolder(viewHolder3, playbackControlsRow.getItem());
            }
        }
        Drawable imageDrawable = playbackControlsRow.getImageDrawable();
        ImageView imageView = viewHolder2.mImageView;
        if (imageDrawable == null) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
        }
        viewHolder2.mImageView.setImageDrawable(playbackControlsRow.getImageDrawable());
        viewHolder2.mControlsBoundData.adapter = playbackControlsRow.getPrimaryActionsAdapter();
        viewHolder2.mControlsBoundData.presenter = viewHolder2.getPresenter(true);
        BoundData boundData = viewHolder2.mControlsBoundData;
        boundData.mRowViewHolder = viewHolder2;
        this.mPlaybackControlsPresenter.onBindViewHolder(viewHolder2.mControlsVh, boundData);
        viewHolder2.mSecondaryBoundData.adapter = playbackControlsRow.getSecondaryActionsAdapter();
        viewHolder2.mSecondaryBoundData.presenter = viewHolder2.getPresenter(false);
        BoundData boundData2 = viewHolder2.mSecondaryBoundData;
        boundData2.mRowViewHolder = viewHolder2;
        this.mSecondaryControlsPresenter.onBindViewHolder(viewHolder2.mSecondaryControlsVh, boundData2);
        viewHolder2.setTotalTime(playbackControlsRow.getDuration());
        viewHolder2.setCurrentPosition(playbackControlsRow.getCurrentPosition());
        viewHolder2.setBufferedPosition(playbackControlsRow.getBufferedPosition());
        playbackControlsRow.setOnPlaybackProgressChangedListener(viewHolder2.mListener);
    }

    public void onProgressBarClicked(ViewHolder viewHolder) {
        if (viewHolder != null) {
            if (viewHolder.mPlayPauseAction == null) {
                viewHolder.mPlayPauseAction = new PlaybackControlsRow.PlayPauseAction(viewHolder.view.getContext());
            }
            if (viewHolder.getOnItemViewClickedListener() != null) {
                viewHolder.getOnItemViewClickedListener().onItemClicked(viewHolder, viewHolder.mPlayPauseAction, viewHolder, viewHolder.getRow());
            }
            OnActionClickedListener onActionClickedListener = this.mOnActionClickedListener;
            if (onActionClickedListener != null) {
                onActionClickedListener.onActionClicked(viewHolder.mPlayPauseAction);
            }
        }
    }

    @Override // androidx.leanback.widget.PlaybackRowPresenter
    public void onReappear(RowPresenter.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        if (viewHolder2.view.hasFocus()) {
            viewHolder2.mProgressBar.requestFocus();
        }
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onRowViewAttachedToWindow(RowPresenter.ViewHolder viewHolder) {
        super.onRowViewAttachedToWindow(viewHolder);
        Presenter presenter = this.mDescriptionPresenter;
        if (presenter != null) {
            presenter.onViewAttachedToWindow(((ViewHolder) viewHolder).mDescriptionViewHolder);
        }
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onRowViewDetachedFromWindow(RowPresenter.ViewHolder viewHolder) {
        super.onRowViewDetachedFromWindow(viewHolder);
        Presenter presenter = this.mDescriptionPresenter;
        if (presenter != null) {
            presenter.onViewDetachedFromWindow(((ViewHolder) viewHolder).mDescriptionViewHolder);
        }
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onRowViewSelected(RowPresenter.ViewHolder viewHolder, boolean z9) {
        super.onRowViewSelected(viewHolder, z9);
        if (z9) {
            ((ViewHolder) viewHolder).dispatchItemSelection();
        }
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onUnbindRowViewHolder(RowPresenter.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        PlaybackControlsRow playbackControlsRow = (PlaybackControlsRow) viewHolder2.getRow();
        Presenter.ViewHolder viewHolder3 = viewHolder2.mDescriptionViewHolder;
        if (viewHolder3 != null) {
            this.mDescriptionPresenter.onUnbindViewHolder(viewHolder3);
        }
        this.mPlaybackControlsPresenter.onUnbindViewHolder(viewHolder2.mControlsVh);
        this.mSecondaryControlsPresenter.onUnbindViewHolder(viewHolder2.mSecondaryControlsVh);
        playbackControlsRow.setOnPlaybackProgressChangedListener(null);
        super.onUnbindRowViewHolder(viewHolder);
    }

    public void setDefaultSeekIncrement(float f) {
        this.mDefaultSeekIncrement = f;
    }

    public void setDescriptionPresenter(Presenter presenter) {
        this.mDescriptionPresenter = presenter;
    }

    public void setOnActionClickedListener(OnActionClickedListener onActionClickedListener) {
        this.mOnActionClickedListener = onActionClickedListener;
    }

    public void setProgressColor(@ColorInt int i10) {
        this.mProgressColor = i10;
        this.mProgressColorSet = true;
    }

    public void setSecondaryProgressColor(@ColorInt int i10) {
        this.mSecondaryProgressColor = i10;
        this.mSecondaryProgressColorSet = true;
    }
}
