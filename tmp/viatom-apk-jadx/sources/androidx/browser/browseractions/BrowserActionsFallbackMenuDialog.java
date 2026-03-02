package androidx.browser.browseractions;

import a3.a;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Dialog;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@Deprecated
/* loaded from: classes.dex */
class BrowserActionsFallbackMenuDialog extends Dialog {
    private static final long ENTER_ANIMATION_DURATION_MS = 250;
    private static final long EXIT_ANIMATION_DURATION_MS = 150;
    private final View mContentView;

    public BrowserActionsFallbackMenuDialog(Context context, View view) {
        super(context);
        this.mContentView = view;
    }

    private void startAnimation(final boolean z9) {
        float f = z9 ? 0.0f : 1.0f;
        float f10 = z9 ? 1.0f : 0.0f;
        long j10 = z9 ? ENTER_ANIMATION_DURATION_MS : 150L;
        this.mContentView.setScaleX(f);
        this.mContentView.setScaleY(f);
        this.mContentView.animate().scaleX(f10).scaleY(f10).setDuration(j10).setInterpolator(new LinearOutSlowInInterpolator()).setListener(new AnimatorListenerAdapter() { // from class: androidx.browser.browseractions.BrowserActionsFallbackMenuDialog.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (z9) {
                    return;
                }
                BrowserActionsFallbackMenuDialog.super.dismiss();
            }
        }).start();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        startAnimation(false);
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // android.app.Dialog
    public void show() {
        a.A(getWindow(), 0);
        startAnimation(true);
        super.show();
    }
}
