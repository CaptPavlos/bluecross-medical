package androidx.leanback.app;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import androidx.leanback.media.PlaybackGlue;
import androidx.leanback.widget.DetailsParallax;
import androidx.leanback.widget.Parallax;
import androidx.leanback.widget.ParallaxEffect;
import androidx.leanback.widget.ParallaxTarget;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final class DetailsBackgroundVideoHelper {
    private static final long BACKGROUND_CROSS_FADE_DURATION = 500;
    private static final long CROSSFADE_DELAY = 1000;
    static final int INITIAL = 0;
    static final int NO_VIDEO = 2;
    static final int PLAY_VIDEO = 1;
    ValueAnimator mBackgroundAnimator;
    Drawable mBackgroundDrawable;
    private final DetailsParallax mDetailsParallax;
    private ParallaxEffect mParallaxEffect;
    private PlaybackGlue mPlaybackGlue;
    private int mCurrentState = 0;
    PlaybackControlStateCallback mControlStateCallback = new PlaybackControlStateCallback();
    private boolean mBackgroundDrawableVisible = true;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class PlaybackControlStateCallback extends PlaybackGlue.PlayerCallback {
        public PlaybackControlStateCallback() {
        }

        @Override // androidx.leanback.media.PlaybackGlue.PlayerCallback
        public void onPreparedStateChanged(PlaybackGlue playbackGlue) {
            if (playbackGlue.isPrepared()) {
                DetailsBackgroundVideoHelper.this.internalStartPlayback();
            }
        }
    }

    public DetailsBackgroundVideoHelper(PlaybackGlue playbackGlue, DetailsParallax detailsParallax, Drawable drawable) {
        this.mPlaybackGlue = playbackGlue;
        this.mDetailsParallax = detailsParallax;
        this.mBackgroundDrawable = drawable;
        drawable.setAlpha(255);
        startParallax();
    }

    private void applyState() {
        int i10 = this.mCurrentState;
        if (i10 != 1) {
            if (i10 != 2) {
                return;
            }
            crossFadeBackgroundToVideo(false);
            PlaybackGlue playbackGlue = this.mPlaybackGlue;
            if (playbackGlue != null) {
                playbackGlue.removePlayerCallback(this.mControlStateCallback);
                this.mPlaybackGlue.pause();
                return;
            }
            return;
        }
        PlaybackGlue playbackGlue2 = this.mPlaybackGlue;
        if (playbackGlue2 == null) {
            crossFadeBackgroundToVideo(false);
        } else if (playbackGlue2.isPrepared()) {
            internalStartPlayback();
        } else {
            this.mPlaybackGlue.addPlayerCallback(this.mControlStateCallback);
        }
    }

    public void crossFadeBackgroundToVideo(boolean z9, boolean z10) {
        boolean z11 = !z9;
        if (this.mBackgroundDrawableVisible == z11) {
            if (z10) {
                ValueAnimator valueAnimator = this.mBackgroundAnimator;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                    this.mBackgroundAnimator = null;
                }
                Drawable drawable = this.mBackgroundDrawable;
                if (drawable != null) {
                    drawable.setAlpha(z9 ? 0 : 255);
                    return;
                }
                return;
            }
            return;
        }
        this.mBackgroundDrawableVisible = z11;
        ValueAnimator valueAnimator2 = this.mBackgroundAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.mBackgroundAnimator = null;
        }
        float f = z9 ? 1.0f : 0.0f;
        float f10 = z9 ? 0.0f : 1.0f;
        Drawable drawable2 = this.mBackgroundDrawable;
        if (drawable2 == null) {
            return;
        }
        if (z10) {
            drawable2.setAlpha(z9 ? 0 : 255);
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f10);
        this.mBackgroundAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(BACKGROUND_CROSS_FADE_DURATION);
        this.mBackgroundAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.leanback.app.DetailsBackgroundVideoHelper.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator3) {
                DetailsBackgroundVideoHelper.this.mBackgroundDrawable.setAlpha((int) (((Float) valueAnimator3.getAnimatedValue()).floatValue() * 255.0f));
            }
        });
        this.mBackgroundAnimator.addListener(new Animator.AnimatorListener() { // from class: androidx.leanback.app.DetailsBackgroundVideoHelper.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                DetailsBackgroundVideoHelper.this.mBackgroundAnimator = null;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        this.mBackgroundAnimator.start();
    }

    public void internalStartPlayback() {
        PlaybackGlue playbackGlue = this.mPlaybackGlue;
        if (playbackGlue != null) {
            playbackGlue.play();
        }
        this.mDetailsParallax.getRecyclerView().postDelayed(new Runnable() { // from class: androidx.leanback.app.DetailsBackgroundVideoHelper.2
            @Override // java.lang.Runnable
            public void run() {
                DetailsBackgroundVideoHelper.this.crossFadeBackgroundToVideo(true);
            }
        }, 1000L);
    }

    public boolean isVideoVisible() {
        return this.mCurrentState == 1;
    }

    public void setPlaybackGlue(PlaybackGlue playbackGlue) {
        PlaybackGlue playbackGlue2 = this.mPlaybackGlue;
        if (playbackGlue2 != null) {
            playbackGlue2.removePlayerCallback(this.mControlStateCallback);
        }
        this.mPlaybackGlue = playbackGlue;
        applyState();
    }

    public void startParallax() {
        if (this.mParallaxEffect != null) {
            return;
        }
        Parallax.IntProperty overviewRowTop = this.mDetailsParallax.getOverviewRowTop();
        this.mParallaxEffect = this.mDetailsParallax.addEffect(overviewRowTop.atFraction(1.0f), overviewRowTop.atFraction(0.0f)).target(new ParallaxTarget() { // from class: androidx.leanback.app.DetailsBackgroundVideoHelper.1
            @Override // androidx.leanback.widget.ParallaxTarget
            public void update(float f) {
                DetailsBackgroundVideoHelper detailsBackgroundVideoHelper = DetailsBackgroundVideoHelper.this;
                if (f == 1.0f) {
                    detailsBackgroundVideoHelper.updateState(2);
                } else {
                    detailsBackgroundVideoHelper.updateState(1);
                }
            }
        });
        this.mDetailsParallax.updateValues();
    }

    public void stopParallax() {
        this.mDetailsParallax.removeEffect(this.mParallaxEffect);
    }

    public void updateState(int i10) {
        if (i10 == this.mCurrentState) {
            return;
        }
        this.mCurrentState = i10;
        applyState();
    }

    public void crossFadeBackgroundToVideo(boolean z9) {
        crossFadeBackgroundToVideo(z9, false);
    }
}
