package androidx.leanback.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.leanback.util.MathUtil;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class PlaybackControlsRow extends Row {
    private long mBufferedProgressMs;
    private long mCurrentTimeMs;
    private Drawable mImageDrawable;
    private Object mItem;
    private OnPlaybackProgressCallback mListener;
    private ObjectAdapter mPrimaryActionsAdapter;
    private ObjectAdapter mSecondaryActionsAdapter;
    private long mTotalTimeMs;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class MoreActions extends Action {
        public MoreActions(Context context) {
            super(androidx.leanback.R.id.lb_control_more_actions);
            setIcon(context.getResources().getDrawable(androidx.leanback.R.drawable.lb_ic_more));
            setLabel1(context.getString(androidx.leanback.R.string.lb_playback_controls_more_actions));
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static abstract class MultiAction extends Action {
        private Drawable[] mDrawables;
        private int mIndex;
        private String[] mLabels;
        private String[] mLabels2;

        public MultiAction(int i10) {
            super(i10);
        }

        public int getActionCount() {
            Drawable[] drawableArr = this.mDrawables;
            if (drawableArr != null) {
                return drawableArr.length;
            }
            String[] strArr = this.mLabels;
            if (strArr != null) {
                return strArr.length;
            }
            return 0;
        }

        public Drawable getDrawable(int i10) {
            Drawable[] drawableArr = this.mDrawables;
            if (drawableArr == null) {
                return null;
            }
            return drawableArr[i10];
        }

        public int getIndex() {
            return this.mIndex;
        }

        public String getLabel(int i10) {
            String[] strArr = this.mLabels;
            if (strArr == null) {
                return null;
            }
            return strArr[i10];
        }

        public String getSecondaryLabel(int i10) {
            String[] strArr = this.mLabels2;
            if (strArr == null) {
                return null;
            }
            return strArr[i10];
        }

        public void nextIndex() {
            setIndex(this.mIndex < getActionCount() + (-1) ? this.mIndex + 1 : 0);
        }

        public void setDrawables(Drawable[] drawableArr) {
            this.mDrawables = drawableArr;
            setIndex(0);
        }

        public void setIndex(int i10) {
            this.mIndex = i10;
            Drawable[] drawableArr = this.mDrawables;
            if (drawableArr != null) {
                setIcon(drawableArr[i10]);
            }
            String[] strArr = this.mLabels;
            if (strArr != null) {
                setLabel1(strArr[this.mIndex]);
            }
            String[] strArr2 = this.mLabels2;
            if (strArr2 != null) {
                setLabel2(strArr2[this.mIndex]);
            }
        }

        public void setLabels(String[] strArr) {
            this.mLabels = strArr;
            setIndex(0);
        }

        public void setSecondaryLabels(String[] strArr) {
            this.mLabels2 = strArr;
            setIndex(0);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class PictureInPictureAction extends Action {
        public PictureInPictureAction(Context context) {
            super(androidx.leanback.R.id.lb_control_picture_in_picture);
            setIcon(PlaybackControlsRow.getStyledDrawable(context, androidx.leanback.R.styleable.lbPlaybackControlsActionIcons_picture_in_picture));
            setLabel1(context.getString(androidx.leanback.R.string.lb_playback_controls_picture_in_picture));
            addKeyCode(171);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class PlayPauseAction extends MultiAction {
        public static final int INDEX_PAUSE = 1;
        public static final int INDEX_PLAY = 0;

        @Deprecated
        public static final int PAUSE = 1;

        @Deprecated
        public static final int PLAY = 0;

        public PlayPauseAction(Context context) {
            super(androidx.leanback.R.id.lb_control_play_pause);
            setDrawables(new Drawable[]{PlaybackControlsRow.getStyledDrawable(context, androidx.leanback.R.styleable.lbPlaybackControlsActionIcons_play), PlaybackControlsRow.getStyledDrawable(context, androidx.leanback.R.styleable.lbPlaybackControlsActionIcons_pause)});
            setLabels(new String[]{context.getString(androidx.leanback.R.string.lb_playback_controls_play), context.getString(androidx.leanback.R.string.lb_playback_controls_pause)});
            addKeyCode(85);
            addKeyCode(126);
            addKeyCode(127);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class SkipNextAction extends Action {
        public SkipNextAction(Context context) {
            super(androidx.leanback.R.id.lb_control_skip_next);
            setIcon(PlaybackControlsRow.getStyledDrawable(context, androidx.leanback.R.styleable.lbPlaybackControlsActionIcons_skip_next));
            setLabel1(context.getString(androidx.leanback.R.string.lb_playback_controls_skip_next));
            addKeyCode(87);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class SkipPreviousAction extends Action {
        public SkipPreviousAction(Context context) {
            super(androidx.leanback.R.id.lb_control_skip_previous);
            setIcon(PlaybackControlsRow.getStyledDrawable(context, androidx.leanback.R.styleable.lbPlaybackControlsActionIcons_skip_previous));
            setLabel1(context.getString(androidx.leanback.R.string.lb_playback_controls_skip_previous));
            addKeyCode(88);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static abstract class ThumbsAction extends MultiAction {
        public static final int INDEX_OUTLINE = 1;
        public static final int INDEX_SOLID = 0;

        @Deprecated
        public static final int OUTLINE = 1;

        @Deprecated
        public static final int SOLID = 0;

        public ThumbsAction(int i10, Context context, int i11, int i12) {
            super(i10);
            setDrawables(new Drawable[]{PlaybackControlsRow.getStyledDrawable(context, i11), PlaybackControlsRow.getStyledDrawable(context, i12)});
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class ThumbsDownAction extends ThumbsAction {
        public ThumbsDownAction(Context context) {
            super(androidx.leanback.R.id.lb_control_thumbs_down, context, androidx.leanback.R.styleable.lbPlaybackControlsActionIcons_thumb_down, androidx.leanback.R.styleable.lbPlaybackControlsActionIcons_thumb_down_outline);
            String[] strArr = new String[getActionCount()];
            strArr[0] = context.getString(androidx.leanback.R.string.lb_playback_controls_thumb_down);
            strArr[1] = context.getString(androidx.leanback.R.string.lb_playback_controls_thumb_down_outline);
            setLabels(strArr);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class ThumbsUpAction extends ThumbsAction {
        public ThumbsUpAction(Context context) {
            super(androidx.leanback.R.id.lb_control_thumbs_up, context, androidx.leanback.R.styleable.lbPlaybackControlsActionIcons_thumb_up, androidx.leanback.R.styleable.lbPlaybackControlsActionIcons_thumb_up_outline);
            String[] strArr = new String[getActionCount()];
            strArr[0] = context.getString(androidx.leanback.R.string.lb_playback_controls_thumb_up);
            strArr[1] = context.getString(androidx.leanback.R.string.lb_playback_controls_thumb_up_outline);
            setLabels(strArr);
        }
    }

    public PlaybackControlsRow(Object obj) {
        this.mItem = obj;
    }

    public static Bitmap createBitmap(Bitmap bitmap, int i10) {
        Bitmap bitmapCopy = bitmap.copy(bitmap.getConfig(), true);
        Canvas canvas = new Canvas(bitmapCopy);
        Paint paint = new Paint();
        paint.setColorFilter(new PorterDuffColorFilter(i10, PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return bitmapCopy;
    }

    public static int getIconHighlightColor(Context context) {
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(androidx.leanback.R.attr.playbackControlsIconHighlightColor, typedValue, true) ? typedValue.data : context.getResources().getColor(androidx.leanback.R.color.lb_playback_icon_highlight_no_theme);
    }

    public static Drawable getStyledDrawable(Context context, int i10) throws Resources.NotFoundException {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(androidx.leanback.R.attr.playbackControlsActionIcons, typedValue, false)) {
            return null;
        }
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(typedValue.data, androidx.leanback.R.styleable.lbPlaybackControlsActionIcons);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(i10);
        typedArrayObtainStyledAttributes.recycle();
        return drawable;
    }

    public Action getActionForKeyCode(ObjectAdapter objectAdapter, int i10) {
        if (objectAdapter != this.mPrimaryActionsAdapter && objectAdapter != this.mSecondaryActionsAdapter) {
            com.google.gson.internal.a.n("Invalid adapter");
            return null;
        }
        for (int i11 = 0; i11 < objectAdapter.size(); i11++) {
            Action action = (Action) objectAdapter.get(i11);
            if (action.respondsToKeyCode(i10)) {
                return action;
            }
        }
        return null;
    }

    public long getBufferedPosition() {
        return this.mBufferedProgressMs;
    }

    @Deprecated
    public int getBufferedProgress() {
        return MathUtil.safeLongToInt(getBufferedPosition());
    }

    @Deprecated
    public long getBufferedProgressLong() {
        return this.mBufferedProgressMs;
    }

    public long getCurrentPosition() {
        return this.mCurrentTimeMs;
    }

    @Deprecated
    public int getCurrentTime() {
        return MathUtil.safeLongToInt(getCurrentTimeLong());
    }

    @Deprecated
    public long getCurrentTimeLong() {
        return this.mCurrentTimeMs;
    }

    public long getDuration() {
        return this.mTotalTimeMs;
    }

    public final Drawable getImageDrawable() {
        return this.mImageDrawable;
    }

    public final Object getItem() {
        return this.mItem;
    }

    public final ObjectAdapter getPrimaryActionsAdapter() {
        return this.mPrimaryActionsAdapter;
    }

    public final ObjectAdapter getSecondaryActionsAdapter() {
        return this.mSecondaryActionsAdapter;
    }

    @Deprecated
    public int getTotalTime() {
        return MathUtil.safeLongToInt(getTotalTimeLong());
    }

    @Deprecated
    public long getTotalTimeLong() {
        return this.mTotalTimeMs;
    }

    public void setBufferedPosition(long j10) {
        if (this.mBufferedProgressMs != j10) {
            this.mBufferedProgressMs = j10;
            OnPlaybackProgressCallback onPlaybackProgressCallback = this.mListener;
            if (onPlaybackProgressCallback != null) {
                onPlaybackProgressCallback.onBufferedPositionChanged(this, j10);
            }
        }
    }

    @Deprecated
    public void setBufferedProgress(int i10) {
        setBufferedPosition(i10);
    }

    @Deprecated
    public void setBufferedProgressLong(long j10) {
        setBufferedPosition(j10);
    }

    public void setCurrentPosition(long j10) {
        if (this.mCurrentTimeMs != j10) {
            this.mCurrentTimeMs = j10;
            OnPlaybackProgressCallback onPlaybackProgressCallback = this.mListener;
            if (onPlaybackProgressCallback != null) {
                onPlaybackProgressCallback.onCurrentPositionChanged(this, j10);
            }
        }
    }

    @Deprecated
    public void setCurrentTime(int i10) {
        setCurrentTimeLong(i10);
    }

    @Deprecated
    public void setCurrentTimeLong(long j10) {
        setCurrentPosition(j10);
    }

    public void setDuration(long j10) {
        if (this.mTotalTimeMs != j10) {
            this.mTotalTimeMs = j10;
            OnPlaybackProgressCallback onPlaybackProgressCallback = this.mListener;
            if (onPlaybackProgressCallback != null) {
                onPlaybackProgressCallback.onDurationChanged(this, j10);
            }
        }
    }

    public final void setImageBitmap(Context context, Bitmap bitmap) {
        this.mImageDrawable = new BitmapDrawable(context.getResources(), bitmap);
    }

    public final void setImageDrawable(Drawable drawable) {
        this.mImageDrawable = drawable;
    }

    public void setOnPlaybackProgressChangedListener(OnPlaybackProgressCallback onPlaybackProgressCallback) {
        this.mListener = onPlaybackProgressCallback;
    }

    public final void setPrimaryActionsAdapter(ObjectAdapter objectAdapter) {
        this.mPrimaryActionsAdapter = objectAdapter;
    }

    public final void setSecondaryActionsAdapter(ObjectAdapter objectAdapter) {
        this.mSecondaryActionsAdapter = objectAdapter;
    }

    @Deprecated
    public void setTotalTime(int i10) {
        setDuration(i10);
    }

    @Deprecated
    public void setTotalTimeLong(long j10) {
        setDuration(j10);
    }

    public PlaybackControlsRow() {
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class OnPlaybackProgressCallback {
        public void onBufferedPositionChanged(PlaybackControlsRow playbackControlsRow, long j10) {
        }

        public void onCurrentPositionChanged(PlaybackControlsRow playbackControlsRow, long j10) {
        }

        public void onDurationChanged(PlaybackControlsRow playbackControlsRow, long j10) {
        }
    }

    public Action getActionForKeyCode(int i10) {
        Action actionForKeyCode = getActionForKeyCode(getPrimaryActionsAdapter(), i10);
        return actionForKeyCode != null ? actionForKeyCode : getActionForKeyCode(getSecondaryActionsAdapter(), i10);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class ClosedCaptioningAction extends MultiAction {
        public static final int INDEX_OFF = 0;
        public static final int INDEX_ON = 1;

        @Deprecated
        public static final int OFF = 0;

        @Deprecated
        public static final int ON = 1;

        public ClosedCaptioningAction(Context context, int i10) {
            super(androidx.leanback.R.id.lb_control_closed_captioning);
            BitmapDrawable bitmapDrawable = (BitmapDrawable) PlaybackControlsRow.getStyledDrawable(context, androidx.leanback.R.styleable.lbPlaybackControlsActionIcons_closed_captioning);
            setDrawables(new Drawable[]{bitmapDrawable, new BitmapDrawable(context.getResources(), PlaybackControlsRow.createBitmap(bitmapDrawable.getBitmap(), i10))});
            setLabels(new String[]{context.getString(androidx.leanback.R.string.lb_playback_controls_closed_captioning_enable), context.getString(androidx.leanback.R.string.lb_playback_controls_closed_captioning_disable)});
        }

        public ClosedCaptioningAction(Context context) {
            this(context, PlaybackControlsRow.getIconHighlightColor(context));
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class HighQualityAction extends MultiAction {
        public static final int INDEX_OFF = 0;
        public static final int INDEX_ON = 1;

        @Deprecated
        public static final int OFF = 0;

        @Deprecated
        public static final int ON = 1;

        public HighQualityAction(Context context, int i10) {
            super(androidx.leanback.R.id.lb_control_high_quality);
            BitmapDrawable bitmapDrawable = (BitmapDrawable) PlaybackControlsRow.getStyledDrawable(context, androidx.leanback.R.styleable.lbPlaybackControlsActionIcons_high_quality);
            setDrawables(new Drawable[]{bitmapDrawable, new BitmapDrawable(context.getResources(), PlaybackControlsRow.createBitmap(bitmapDrawable.getBitmap(), i10))});
            setLabels(new String[]{context.getString(androidx.leanback.R.string.lb_playback_controls_high_quality_enable), context.getString(androidx.leanback.R.string.lb_playback_controls_high_quality_disable)});
        }

        public HighQualityAction(Context context) {
            this(context, PlaybackControlsRow.getIconHighlightColor(context));
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class ShuffleAction extends MultiAction {
        public static final int INDEX_OFF = 0;
        public static final int INDEX_ON = 1;

        @Deprecated
        public static final int OFF = 0;

        @Deprecated
        public static final int ON = 1;

        public ShuffleAction(Context context, int i10) {
            super(androidx.leanback.R.id.lb_control_shuffle);
            BitmapDrawable bitmapDrawable = (BitmapDrawable) PlaybackControlsRow.getStyledDrawable(context, androidx.leanback.R.styleable.lbPlaybackControlsActionIcons_shuffle);
            setDrawables(new Drawable[]{bitmapDrawable, new BitmapDrawable(context.getResources(), PlaybackControlsRow.createBitmap(bitmapDrawable.getBitmap(), i10))});
            setLabels(new String[]{context.getString(androidx.leanback.R.string.lb_playback_controls_shuffle_enable), context.getString(androidx.leanback.R.string.lb_playback_controls_shuffle_disable)});
        }

        public ShuffleAction(Context context) {
            this(context, PlaybackControlsRow.getIconHighlightColor(context));
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class RepeatAction extends MultiAction {

        @Deprecated
        public static final int ALL = 1;
        public static final int INDEX_ALL = 1;
        public static final int INDEX_NONE = 0;
        public static final int INDEX_ONE = 2;

        @Deprecated
        public static final int NONE = 0;

        @Deprecated
        public static final int ONE = 2;

        public RepeatAction(Context context, int i10, int i11) {
            super(androidx.leanback.R.id.lb_control_repeat);
            BitmapDrawable bitmapDrawable = (BitmapDrawable) PlaybackControlsRow.getStyledDrawable(context, androidx.leanback.R.styleable.lbPlaybackControlsActionIcons_repeat);
            BitmapDrawable bitmapDrawable2 = (BitmapDrawable) PlaybackControlsRow.getStyledDrawable(context, androidx.leanback.R.styleable.lbPlaybackControlsActionIcons_repeat_one);
            setDrawables(new Drawable[]{bitmapDrawable, bitmapDrawable == null ? null : new BitmapDrawable(context.getResources(), PlaybackControlsRow.createBitmap(bitmapDrawable.getBitmap(), i10)), bitmapDrawable2 != null ? new BitmapDrawable(context.getResources(), PlaybackControlsRow.createBitmap(bitmapDrawable2.getBitmap(), i11)) : null});
            setLabels(new String[]{context.getString(androidx.leanback.R.string.lb_playback_controls_repeat_all), context.getString(androidx.leanback.R.string.lb_playback_controls_repeat_one), context.getString(androidx.leanback.R.string.lb_playback_controls_repeat_none)});
        }

        public RepeatAction(Context context, int i10) {
            this(context, i10, i10);
        }

        public RepeatAction(Context context) {
            this(context, PlaybackControlsRow.getIconHighlightColor(context));
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class FastForwardAction extends MultiAction {
        public FastForwardAction(Context context, int i10) {
            super(androidx.leanback.R.id.lb_control_fast_forward);
            if (i10 < 1) {
                com.google.gson.internal.a.n("numSpeeds must be > 0");
                throw null;
            }
            Drawable[] drawableArr = new Drawable[i10 + 1];
            drawableArr[0] = PlaybackControlsRow.getStyledDrawable(context, androidx.leanback.R.styleable.lbPlaybackControlsActionIcons_fast_forward);
            setDrawables(drawableArr);
            String[] strArr = new String[getActionCount()];
            strArr[0] = context.getString(androidx.leanback.R.string.lb_playback_controls_fast_forward);
            String[] strArr2 = new String[getActionCount()];
            strArr2[0] = strArr[0];
            int i11 = 1;
            while (i11 <= i10) {
                int i12 = i11 + 1;
                strArr[i11] = context.getResources().getString(androidx.leanback.R.string.lb_control_display_fast_forward_multiplier, Integer.valueOf(i12));
                strArr2[i11] = context.getResources().getString(androidx.leanback.R.string.lb_playback_controls_fast_forward_multiplier, Integer.valueOf(i12));
                i11 = i12;
            }
            setLabels(strArr);
            setSecondaryLabels(strArr2);
            addKeyCode(90);
        }

        public FastForwardAction(Context context) {
            this(context, 1);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class RewindAction extends MultiAction {
        public RewindAction(Context context, int i10) throws Resources.NotFoundException {
            super(androidx.leanback.R.id.lb_control_fast_rewind);
            if (i10 < 1) {
                com.google.gson.internal.a.n("numSpeeds must be > 0");
                throw null;
            }
            Drawable[] drawableArr = new Drawable[i10 + 1];
            drawableArr[0] = PlaybackControlsRow.getStyledDrawable(context, androidx.leanback.R.styleable.lbPlaybackControlsActionIcons_rewind);
            setDrawables(drawableArr);
            String[] strArr = new String[getActionCount()];
            strArr[0] = context.getString(androidx.leanback.R.string.lb_playback_controls_rewind);
            String[] strArr2 = new String[getActionCount()];
            strArr2[0] = strArr[0];
            int i11 = 1;
            while (i11 <= i10) {
                int i12 = i11 + 1;
                String string = context.getResources().getString(androidx.leanback.R.string.lb_control_display_rewind_multiplier, Integer.valueOf(i12));
                strArr[i11] = string;
                strArr[i11] = string;
                strArr2[i11] = context.getResources().getString(androidx.leanback.R.string.lb_playback_controls_rewind_multiplier, Integer.valueOf(i12));
                i11 = i12;
            }
            setLabels(strArr);
            setSecondaryLabels(strArr2);
            addKeyCode(89);
        }

        public RewindAction(Context context) {
            this(context, 1);
        }
    }
}
