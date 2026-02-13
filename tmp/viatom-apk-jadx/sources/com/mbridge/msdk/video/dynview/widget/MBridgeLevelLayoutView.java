package com.mbridge.msdk.video.dynview.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.mbridge.msdk.foundation.tools.x;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBridgeLevelLayoutView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private static int f5872d = 18;

    /* renamed from: a, reason: collision with root package name */
    private double f5873a;

    /* renamed from: b, reason: collision with root package name */
    private int f5874b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f5875c;

    public MBridgeLevelLayoutView(Context context) {
        super(context);
    }

    private void a() throws Resources.NotFoundException {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        if (this.f5875c) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, dip2px(getContext(), f5872d));
            linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(0);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout2 = new LinearLayout(getContext());
            linearLayout2.setOrientation(0);
            linearLayout2.setLayoutParams(layoutParams);
        } else {
            linearLayout = null;
            linearLayout2 = null;
        }
        removeAllViews();
        if (linearLayout2 != null) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, dip2px(getContext(), f5872d));
            TextView textView = new TextView(getContext());
            textView.setTypeface(Typeface.defaultFromStyle(1));
            textView.setText("(");
            textView.setTextColor(Color.parseColor("#5f5f5f"));
            TextView textView2 = new TextView(getContext());
            textView2.setTypeface(Typeface.defaultFromStyle(1));
            textView2.setGravity(17);
            textView2.setTextColor(Color.parseColor("#5f5f5f"));
            Drawable drawable = getResources().getDrawable(x.a(getContext(), "mbridge_reward_user", "drawable"));
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView2.setCompoundDrawables(drawable, null, null, null);
            textView2.setText(this.f5874b + " )");
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            textView2.setLines(1);
            linearLayout2.addView(textView, layoutParams2);
            linearLayout2.addView(textView2, layoutParams2);
        }
        double d8 = this.f5873a;
        if (d8 == 0.0d) {
            d8 = 5.0d;
        }
        for (int i10 = 0; i10 < 5; i10++) {
            ImageView imageView = new ImageView(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dip2px(getContext(), 15.0f), dip2px(getContext(), f5872d));
            if (i10 < d8) {
                imageView.setImageResource(x.a(getContext(), "mbridge_download_message_dialog_star_sel", "drawable"));
            } else {
                imageView.setImageResource(x.a(getContext(), "mbridge_download_message_dilaog_star_nor", "drawable"));
            }
            layoutParams3.weight = 1.0f;
            layoutParams3.setMargins(dip2px(getContext(), 2.0f), 0, 0, 0);
            if (linearLayout != null) {
                linearLayout.addView(imageView, layoutParams3);
            } else {
                addView(imageView, layoutParams3);
            }
        }
        if (linearLayout != null) {
            addView(linearLayout);
            addView(linearLayout2);
        }
    }

    public static int dip2px(Context context, float f) {
        Resources resources;
        if (context == null || (resources = context.getResources()) == null) {
            return 0;
        }
        return (int) ((f * resources.getDisplayMetrics().density) + 0.5f);
    }

    public void setRating(int i10) throws Resources.NotFoundException {
        this.f5873a = i10;
        a();
    }

    public void setRatingAndUser(double d8, int i10) throws Resources.NotFoundException {
        this.f5873a = d8;
        if (i10 == 0) {
            i10 = (int) (((Math.random() * 9.0d) + 1.0d) * 10000.0d);
        }
        this.f5874b = i10;
        this.f5875c = true;
        a();
    }

    public MBridgeLevelLayoutView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBridgeLevelLayoutView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
