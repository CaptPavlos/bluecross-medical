package com.mbridge.msdk.newreward.player;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.player.presenter.ActivityPresenter;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class BaseActivity extends Activity {
    private final String TAG = "BaseActivity";
    ActivityPresenter activityPresenter;

    private void hideNavigationBar() {
        try {
            getWindow().addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
            getWindow().getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
        } catch (Throwable th) {
            af.b("BaseActivity", th.getMessage());
        }
    }

    private void setActivityFull() {
        try {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            getWindow().addFlags(512);
            hideNavigationBar();
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            }
        } catch (Exception e) {
            af.b("BaseActivity", e.getMessage());
        }
    }

    private void updateScreenSize(boolean z9) {
        if (z9) {
            int i10 = getResources().getDisplayMetrics().widthPixels;
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        ActivityPresenter activityPresenter = this.activityPresenter;
        if (activityPresenter == null) {
            return;
        }
        activityPresenter.bindMethodName("onBackPressed");
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setActivityFull();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ActivityPresenter activityPresenter = this.activityPresenter;
        if (activityPresenter == null) {
            return;
        }
        activityPresenter.bindMethodName("onDestroy");
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        ActivityPresenter activityPresenter = this.activityPresenter;
        if (activityPresenter == null) {
            return;
        }
        activityPresenter.bindMethodName("onPause");
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        ActivityPresenter activityPresenter = this.activityPresenter;
        if (activityPresenter == null) {
            return;
        }
        activityPresenter.bindMethodName("onResume");
        c.m().a(this);
        hideNavigationBar();
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        ActivityPresenter activityPresenter = this.activityPresenter;
        if (activityPresenter == null) {
            return;
        }
        activityPresenter.bindMethodName("onStart");
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        ActivityPresenter activityPresenter = this.activityPresenter;
        if (activityPresenter == null) {
            return;
        }
        activityPresenter.bindMethodName("onStop");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z9) {
        super.onWindowFocusChanged(z9);
        hideNavigationBar();
        updateScreenSize(z9);
    }
}
