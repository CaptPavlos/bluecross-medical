package com.mbridge.msdk.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.OrientationEventListener;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.mbridge.msdk.foundation.d.b;
import com.mbridge.msdk.foundation.tools.af;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class MBBaseActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private Display f2627a;

    /* renamed from: b, reason: collision with root package name */
    private OrientationEventListener f2628b;

    /* renamed from: c, reason: collision with root package name */
    private int f2629c = -1;

    private void a() {
        try {
            getWindow().addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
            getWindow().getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
        } catch (Throwable th) {
            af.b("MBBaseActivity", th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b() {
        if (this.f2627a == null) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.f2627a = getDisplay();
            } else {
                this.f2627a = ((WindowManager) getSystemService("window")).getDefaultDisplay();
            }
        }
        Display display = this.f2627a;
        if (display != null) {
            return display.getRotation();
        }
        return -1;
    }

    public static /* synthetic */ void e(MBBaseActivity mBBaseActivity) {
        OrientationEventListener orientationEventListener = new OrientationEventListener(mBBaseActivity, 1) { // from class: com.mbridge.msdk.activity.MBBaseActivity.2
            @Override // android.view.OrientationEventListener
            public final void onOrientationChanged(int i10) {
                int rotation = MBBaseActivity.this.f2627a != null ? MBBaseActivity.this.f2627a.getRotation() : 0;
                if (rotation == 1 && MBBaseActivity.this.f2629c != 1) {
                    MBBaseActivity.this.f2629c = 1;
                    MBBaseActivity.this.getNotchParams();
                    af.b("MBBaseActivity", "Orientation Left");
                    return;
                }
                if (rotation == 3 && MBBaseActivity.this.f2629c != 2) {
                    MBBaseActivity.this.f2629c = 2;
                    MBBaseActivity.this.getNotchParams();
                    af.b("MBBaseActivity", "Orientation Right");
                } else if (rotation == 0 && MBBaseActivity.this.f2629c != 3) {
                    MBBaseActivity.this.f2629c = 3;
                    MBBaseActivity.this.getNotchParams();
                    af.b("MBBaseActivity", "Orientation Top");
                } else {
                    if (rotation != 2 || MBBaseActivity.this.f2629c == 4) {
                        return;
                    }
                    MBBaseActivity.this.f2629c = 4;
                    MBBaseActivity.this.getNotchParams();
                    af.b("MBBaseActivity", "Orientation Bottom");
                }
            }
        };
        mBBaseActivity.f2628b = orientationEventListener;
        boolean zCanDetectOrientation = orientationEventListener.canDetectOrientation();
        OrientationEventListener orientationEventListener2 = mBBaseActivity.f2628b;
        if (zCanDetectOrientation) {
            orientationEventListener2.enable();
        } else {
            orientationEventListener2.disable();
            mBBaseActivity.f2628b = null;
        }
    }

    public void getNotchParams() {
        getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.mbridge.msdk.activity.MBBaseActivity.1
            @Override // java.lang.Runnable
            public final void run() {
                int i10;
                int i11;
                int i12;
                DisplayCutout displayCutout;
                try {
                    WindowInsets rootWindowInsets = MBBaseActivity.this.getWindow().getDecorView().getRootWindowInsets();
                    int i13 = -1;
                    int i14 = 0;
                    if (rootWindowInsets == null || Build.VERSION.SDK_INT < 28 || (displayCutout = rootWindowInsets.getDisplayCutout()) == null) {
                        i10 = 0;
                        i11 = 0;
                        i12 = 0;
                    } else {
                        int safeInsetLeft = displayCutout.getSafeInsetLeft();
                        int safeInsetRight = displayCutout.getSafeInsetRight();
                        int safeInsetTop = displayCutout.getSafeInsetTop();
                        int safeInsetBottom = displayCutout.getSafeInsetBottom();
                        af.b("MBBaseActivity", "NOTCH Left:" + safeInsetLeft + " Right:" + safeInsetRight + " Top:" + safeInsetTop + " Bottom:" + safeInsetBottom);
                        Display display = MBBaseActivity.this.f2627a;
                        MBBaseActivity mBBaseActivity = MBBaseActivity.this;
                        int rotation = display != null ? mBBaseActivity.f2627a.getRotation() : mBBaseActivity.b();
                        if (MBBaseActivity.this.f2629c == -1) {
                            MBBaseActivity.this.f2629c = rotation == 0 ? 3 : rotation == 1 ? 1 : rotation == 2 ? 4 : rotation == 3 ? 2 : -1;
                            af.b("MBBaseActivity", MBBaseActivity.this.f2629c + "");
                        }
                        if (rotation == 0) {
                            i13 = 0;
                        } else if (rotation == 1) {
                            i13 = 90;
                        } else if (rotation == 2) {
                            i13 = SubsamplingScaleImageView.ORIENTATION_180;
                        } else if (rotation == 3) {
                            i13 = SubsamplingScaleImageView.ORIENTATION_270;
                        }
                        i14 = safeInsetLeft;
                        i10 = safeInsetRight;
                        i11 = safeInsetTop;
                        i12 = safeInsetBottom;
                    }
                    MBBaseActivity.this.setTopControllerPadding(i13, i14, i10, i11, i12);
                    if (MBBaseActivity.this.f2628b == null) {
                        MBBaseActivity.e(MBBaseActivity.this);
                    }
                } catch (Exception e) {
                    af.b("MBBaseActivity", e.getMessage());
                }
            }
        }, 500L);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            getWindow().addFlags(512);
            a();
            b();
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            }
        } catch (Exception e) {
            af.b("MBBaseActivity", e.getMessage());
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        OrientationEventListener orientationEventListener = this.f2628b;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
            this.f2628b = null;
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (b.f3437c) {
            return;
        }
        getNotchParams();
        a();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z9) {
        super.onWindowFocusChanged(z9);
        a();
    }

    public abstract void setTopControllerPadding(int i10, int i11, int i12, int i13, int i14);
}
