package com.mbridge.msdk.dycreator.baseview.cusview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.mbridge.msdk.foundation.tools.x;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class SoundImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private boolean f3091a;

    public SoundImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3091a = true;
    }

    public boolean getStatus() {
        return this.f3091a;
    }

    public void setSoundStatus(boolean z9) {
        this.f3091a = z9;
        if (z9) {
            setImageResource(x.a(getContext(), "mbridge_reward_sound_open", "drawable"));
        } else {
            setImageResource(x.a(getContext(), "mbridge_reward_sound_close", "drawable"));
        }
    }

    public SoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3091a = true;
    }

    public SoundImageView(Context context) {
        super(context);
        this.f3091a = true;
    }
}
