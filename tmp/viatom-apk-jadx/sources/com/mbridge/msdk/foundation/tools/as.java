package com.mbridge.msdk.foundation.tools;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class as {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f3971a = false;

    /* JADX WARN: Removed duplicated region for block: B:53:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(android.view.View r8, int r9) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.as.a(android.view.View, int):boolean");
    }

    private static boolean a(View view, View view2, int i10) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        Rect rect2 = new Rect();
        view2.getGlobalVisibleRect(rect2);
        if (Rect.intersects(rect, rect2)) {
            int iMin = Math.min(rect.right, rect2.right) - Math.max(rect.left, rect2.left);
            int iMin2 = Math.min(rect.bottom, rect2.bottom) - Math.max(rect.top, rect2.top);
            if (i10 != 1) {
                if (iMin * iMin2 * 2 < view.getMeasuredWidth() * view.getMeasuredHeight()) {
                }
                return true;
            }
            if (i10 == 1) {
                if (iMin * iMin2 >= view.getMeasuredWidth() * view.getMeasuredHeight()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean a(View view, ViewGroup viewGroup, int i10) {
        for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
            af.b("ViewUtils", "View Judge : Start Loop");
            View childAt = viewGroup.getChildAt(i11);
            if (childAt.getVisibility() == 0 && a(view, childAt, i10)) {
                if ((childAt instanceof WebView) && childAt.getVisibility() == 0) {
                    af.b("ViewUtils", "View Judge : View Covered by WebView.");
                    f3971a = true;
                }
                if (a(childAt)) {
                    af.b("ViewUtils", "View Judge : View Covered and Cover ViewGroup is not transparent.");
                    f3971a = true;
                }
                if (f3971a) {
                    break;
                }
                if (childAt instanceof ViewGroup) {
                    a(view, (ViewGroup) childAt, i10);
                }
            }
        }
        return f3971a;
    }

    private static int a(View view, ViewGroup viewGroup) {
        int i10 = 0;
        while (i10 < viewGroup.getChildCount() && viewGroup.getChildAt(i10) != view) {
            i10++;
        }
        return i10;
    }

    private static boolean a(View view) {
        return !(view != null && (view.getTag() instanceof String) && "mb_wm".equals(view.getTag())) && view.getBackground() != null && view.getBackground().getAlpha() > 127 && view.getAlpha() > 0.5f;
    }
}
