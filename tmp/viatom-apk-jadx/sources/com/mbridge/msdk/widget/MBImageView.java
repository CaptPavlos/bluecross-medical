package com.mbridge.msdk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.mbridge.msdk.foundation.same.c.b;
import com.mbridge.msdk.foundation.same.c.c;
import com.mbridge.msdk.foundation.tools.af;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes3.dex */
public class MBImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private Bitmap f6609a;

    /* renamed from: b, reason: collision with root package name */
    private String f6610b;

    public MBImageView(Context context) {
        super(context);
        this.f6609a = null;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap = this.f6609a;
        if (bitmap == null || !bitmap.isRecycled()) {
            super.onDraw(canvas);
            return;
        }
        af.b("mb-widget-imageview", "onDraw bitmap recycled");
        if (getContext() != null) {
            b.a(getContext()).a(this.f6610b, new c() { // from class: com.mbridge.msdk.widget.MBImageView.1
                @Override // com.mbridge.msdk.foundation.same.c.c
                public final void onFailedLoad(String str, String str2) {
                    af.b("mb-widget-imageview", str2 + " load failed:" + str);
                }

                @Override // com.mbridge.msdk.foundation.same.c.c
                public final void onSuccessLoad(Bitmap bitmap2, String str) {
                    MBImageView.this.setImageBitmap(bitmap2);
                }
            });
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.f6609a = bitmap;
        if (bitmap == null || !bitmap.isRecycled()) {
            super.setImageBitmap(bitmap);
            return;
        }
        this.f6609a = null;
        super.setImageBitmap(null);
        af.b("mb-widget-imageview", "setImageBitmap recycled");
    }

    public void setImageUrl(String str) {
        this.f6610b = str;
    }

    public MBImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6609a = null;
    }

    public MBImageView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f6609a = null;
    }
}
