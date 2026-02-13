package com.mbridge.msdk.out;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.material.card.MaterialCardViewHelper;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.ab;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class BannerSize {
    public static final int DEV_SET_TYPE = 5;
    public static final int LARGE_TYPE = 1;
    public static final int MEDIUM_TYPE = 2;
    public static final int SMART_TYPE = 3;
    public static final int STANDARD_TYPE = 4;
    private int height;
    private int width;

    public BannerSize(int i10, int i11, int i12) {
        if (i10 == 1) {
            this.height = 90;
            this.width = 320;
            return;
        }
        if (i10 == 2) {
            this.height = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
            this.width = MaterialCardViewHelper.DEFAULT_FADE_ANIM_DURATION;
            return;
        }
        if (i10 == 3) {
            setSmartMode();
            return;
        }
        if (i10 == 4) {
            this.height = 50;
            this.width = 320;
        } else {
            if (i10 != 5) {
                return;
            }
            this.height = i12;
            this.width = i11;
        }
    }

    private void setSmartMode() {
        if (ab.h(c.m().c()) < 720) {
            this.height = 50;
            this.width = 320;
        } else {
            this.height = 90;
            this.width = 728;
        }
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }
}
