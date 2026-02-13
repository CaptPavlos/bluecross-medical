package androidx.core.widget;

import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class PopupWindowCompat {
    private static final String TAG = "PopupWindowCompatApi21";
    private static Method sGetWindowLayoutTypeMethod;
    private static boolean sGetWindowLayoutTypeMethodAttempted;
    private static Field sOverlapAnchorField;
    private static boolean sOverlapAnchorFieldAttempted;
    private static Method sSetWindowLayoutTypeMethod;
    private static boolean sSetWindowLayoutTypeMethodAttempted;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static boolean getOverlapAnchor(PopupWindow popupWindow) {
            return popupWindow.getOverlapAnchor();
        }

        @DoNotInline
        public static int getWindowLayoutType(PopupWindow popupWindow) {
            return popupWindow.getWindowLayoutType();
        }

        @DoNotInline
        public static void setOverlapAnchor(PopupWindow popupWindow, boolean z9) {
            popupWindow.setOverlapAnchor(z9);
        }

        @DoNotInline
        public static void setWindowLayoutType(PopupWindow popupWindow, int i10) {
            popupWindow.setWindowLayoutType(i10);
        }
    }

    private PopupWindowCompat() {
    }

    public static boolean getOverlapAnchor(@NonNull PopupWindow popupWindow) {
        return Api23Impl.getOverlapAnchor(popupWindow);
    }

    public static int getWindowLayoutType(@NonNull PopupWindow popupWindow) {
        return Api23Impl.getWindowLayoutType(popupWindow);
    }

    public static void setOverlapAnchor(@NonNull PopupWindow popupWindow, boolean z9) {
        Api23Impl.setOverlapAnchor(popupWindow, z9);
    }

    public static void setWindowLayoutType(@NonNull PopupWindow popupWindow, int i10) {
        Api23Impl.setWindowLayoutType(popupWindow, i10);
    }

    public static void showAsDropDown(@NonNull PopupWindow popupWindow, @NonNull View view, int i10, int i11, int i12) {
        popupWindow.showAsDropDown(view, i10, i11, i12);
    }
}
