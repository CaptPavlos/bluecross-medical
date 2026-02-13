package androidx.core.view;

import android.annotation.SuppressLint;
import android.view.WindowInsetsAnimationController;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.Insets;
import com.google.android.material.color.utilities.Contrast;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class WindowInsetsAnimationControllerCompat {
    private final Impl mImpl;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @RequiresApi(30)
    public static class Impl30 extends Impl {
        private final WindowInsetsAnimationController mController;

        public Impl30(@NonNull WindowInsetsAnimationController windowInsetsAnimationController) {
            this.mController = windowInsetsAnimationController;
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public void finish(boolean z9) {
            this.mController.finish(z9);
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public float getCurrentAlpha() {
            return this.mController.getCurrentAlpha();
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public float getCurrentFraction() {
            return this.mController.getCurrentFraction();
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        @NonNull
        public Insets getCurrentInsets() {
            return Insets.toCompatInsets(this.mController.getCurrentInsets());
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        @NonNull
        public Insets getHiddenStateInsets() {
            return Insets.toCompatInsets(this.mController.getHiddenStateInsets());
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        @NonNull
        public Insets getShownStateInsets() {
            return Insets.toCompatInsets(this.mController.getShownStateInsets());
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        @SuppressLint({"WrongConstant"})
        public int getTypes() {
            return this.mController.getTypes();
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public boolean isCancelled() {
            return this.mController.isCancelled();
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public boolean isFinished() {
            return this.mController.isFinished();
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public void setInsetsAndAlpha(@Nullable Insets insets, float f, float f10) {
            this.mController.setInsetsAndAlpha(insets == null ? null : insets.toPlatformInsets(), f, f10);
        }
    }

    @RequiresApi(30)
    public WindowInsetsAnimationControllerCompat(@NonNull WindowInsetsAnimationController windowInsetsAnimationController) {
        this.mImpl = new Impl30(windowInsetsAnimationController);
    }

    public void finish(boolean z9) {
        this.mImpl.finish(z9);
    }

    public float getCurrentAlpha() {
        return this.mImpl.getCurrentAlpha();
    }

    @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
    public float getCurrentFraction() {
        return this.mImpl.getCurrentFraction();
    }

    @NonNull
    public Insets getCurrentInsets() {
        return this.mImpl.getCurrentInsets();
    }

    @NonNull
    public Insets getHiddenStateInsets() {
        return this.mImpl.getHiddenStateInsets();
    }

    @NonNull
    public Insets getShownStateInsets() {
        return this.mImpl.getShownStateInsets();
    }

    public int getTypes() {
        return this.mImpl.getTypes();
    }

    public boolean isCancelled() {
        return this.mImpl.isCancelled();
    }

    public boolean isFinished() {
        return this.mImpl.isFinished();
    }

    public boolean isReady() {
        return (isFinished() || isCancelled()) ? false : true;
    }

    public void setInsetsAndAlpha(@Nullable Insets insets, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10) {
        this.mImpl.setInsetsAndAlpha(insets, f, f10);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class Impl {
        public float getCurrentAlpha() {
            return 0.0f;
        }

        @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
        public float getCurrentFraction() {
            return 0.0f;
        }

        @NonNull
        public Insets getCurrentInsets() {
            return Insets.NONE;
        }

        @NonNull
        public Insets getHiddenStateInsets() {
            return Insets.NONE;
        }

        @NonNull
        public Insets getShownStateInsets() {
            return Insets.NONE;
        }

        public int getTypes() {
            return 0;
        }

        public boolean isCancelled() {
            return true;
        }

        public boolean isFinished() {
            return false;
        }

        public void finish(boolean z9) {
        }

        public void setInsetsAndAlpha(@Nullable Insets insets, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10) {
        }
    }
}
