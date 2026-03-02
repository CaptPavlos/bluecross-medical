package androidx.activity;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.activity.SystemBarStyle;
import androidx.annotation.VisibleForTesting;
import g7.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class EdgeToEdge {
    private static EdgeToEdgeImpl Impl;
    private static final int DefaultLightScrim = Color.argb(230, 255, 255, 255);
    private static final int DefaultDarkScrim = Color.argb(128, 27, 27, 27);

    public static final void enable(ComponentActivity componentActivity, SystemBarStyle systemBarStyle, SystemBarStyle systemBarStyle2) {
        componentActivity.getClass();
        systemBarStyle.getClass();
        systemBarStyle2.getClass();
        View decorView = componentActivity.getWindow().getDecorView();
        decorView.getClass();
        l detectDarkMode$activity_release = systemBarStyle.getDetectDarkMode$activity_release();
        Resources resources = decorView.getResources();
        resources.getClass();
        boolean zBooleanValue = ((Boolean) detectDarkMode$activity_release.invoke(resources)).booleanValue();
        l detectDarkMode$activity_release2 = systemBarStyle2.getDetectDarkMode$activity_release();
        Resources resources2 = decorView.getResources();
        resources2.getClass();
        boolean zBooleanValue2 = ((Boolean) detectDarkMode$activity_release2.invoke(resources2)).booleanValue();
        EdgeToEdgeImpl edgeToEdgeApi29 = Impl;
        if (edgeToEdgeApi29 == null) {
            int i10 = Build.VERSION.SDK_INT;
            edgeToEdgeApi29 = i10 >= 29 ? new EdgeToEdgeApi29() : i10 >= 26 ? new EdgeToEdgeApi26() : new EdgeToEdgeApi23();
        }
        EdgeToEdgeImpl edgeToEdgeImpl = edgeToEdgeApi29;
        Window window = componentActivity.getWindow();
        window.getClass();
        edgeToEdgeImpl.setUp(systemBarStyle, systemBarStyle2, window, decorView, zBooleanValue, zBooleanValue2);
    }

    public static /* synthetic */ void enable$default(ComponentActivity componentActivity, SystemBarStyle systemBarStyle, SystemBarStyle systemBarStyle2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            systemBarStyle = SystemBarStyle.Companion.auto$default(SystemBarStyle.Companion, 0, 0, null, 4, null);
        }
        if ((i10 & 2) != 0) {
            systemBarStyle2 = SystemBarStyle.Companion.auto$default(SystemBarStyle.Companion, DefaultLightScrim, DefaultDarkScrim, null, 4, null);
        }
        enable(componentActivity, systemBarStyle, systemBarStyle2);
    }

    public static final int getDefaultDarkScrim() {
        return DefaultDarkScrim;
    }

    public static final int getDefaultLightScrim() {
        return DefaultLightScrim;
    }

    @VisibleForTesting
    public static /* synthetic */ void getDefaultDarkScrim$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getDefaultLightScrim$annotations() {
    }

    public static final void enable(ComponentActivity componentActivity, SystemBarStyle systemBarStyle) {
        componentActivity.getClass();
        systemBarStyle.getClass();
        enable$default(componentActivity, systemBarStyle, null, 2, null);
    }

    public static final void enable(ComponentActivity componentActivity) {
        componentActivity.getClass();
        enable$default(componentActivity, null, null, 3, null);
    }
}
