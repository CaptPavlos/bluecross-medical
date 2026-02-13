package com.uptodown.tv.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import k4.a;
import l4.x4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes3.dex */
public final class CropImageViewTv extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    public x4 f6723a;

    /* renamed from: b, reason: collision with root package name */
    public int f6724b;

    public CropImageViewTv(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f6724b = -1;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.f10048a);
        typedArrayObtainStyledAttributes.getClass();
        this.f6724b = typedArrayObtainStyledAttributes.getInt(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        a();
    }

    public final void a() {
        setScaleType(ImageView.ScaleType.MATRIX);
        if (getDrawable() != null) {
            this.f6723a = new x4(this, 20);
        }
    }

    public final int getCropType() {
        return this.f6724b;
    }

    public final void setCropType(int i10) {
        this.f6724b = i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a3  */
    @Override // android.widget.ImageView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean setFrame(int r17, int r18, int r19, int r20) {
        /*
            r16 = this;
            r0 = r16
            boolean r1 = super.setFrame(r17, r18, r19, r20)
            boolean r2 = r0.isInEditMode()
            if (r2 != 0) goto Laa
            l4.x4 r2 = r0.f6723a
            if (r2 == 0) goto Laa
            android.graphics.drawable.Drawable r2 = r0.getDrawable()
            if (r2 == 0) goto Laa
            l4.x4 r2 = r0.f6723a
            r2.getClass()
            java.lang.Object r2 = r2.f10987b
            com.uptodown.tv.utils.CropImageViewTv r2 = (com.uptodown.tv.utils.CropImageViewTv) r2
            int r3 = r2.getWidth()
            int r4 = r2.getPaddingLeft()
            int r3 = r3 - r4
            int r4 = r2.getPaddingRight()
            int r3 = r3 - r4
            int r4 = r2.getHeight()
            int r5 = r2.getPaddingTop()
            int r4 = r4 - r5
            int r5 = r2.getPaddingBottom()
            int r4 = r4 - r5
            int r5 = r2.getCropType()
            android.graphics.drawable.Drawable r6 = r2.getDrawable()
            r7 = -1
            if (r5 == r7) goto Laa
            if (r4 <= 0) goto Laa
            if (r3 <= 0) goto Laa
            if (r6 == 0) goto Laa
            android.graphics.Matrix r7 = r2.getImageMatrix()
            r7.getClass()
            int r8 = r6.getIntrinsicWidth()
            int r6 = r6.getIntrinsicHeight()
            float r4 = (float) r4
            float r6 = (float) r6
            float r9 = r4 / r6
            float r3 = (float) r3
            float r8 = (float) r8
            float r10 = r3 / r8
            int r11 = (r10 > r9 ? 1 : (r10 == r9 ? 0 : -1))
            if (r11 <= 0) goto L68
            r9 = r10
        L68:
            r7.setScale(r9, r9)
            r10 = 1
            if (r11 <= 0) goto L70
            r11 = r10
            goto L71
        L70:
            r11 = 0
        L71:
            float r8 = r8 * r9
            r14 = 7
            r15 = 5
            r12 = 4
            r18 = 1073741824(0x40000000, float:2.0)
            if (r11 != 0) goto L8c
            r13 = 3
            if (r5 == r13) goto L8a
            if (r5 == r12) goto L8a
            if (r5 == r15) goto L8a
            r13 = 6
            if (r5 == r13) goto L86
            if (r5 == r14) goto L86
            goto L8c
        L86:
            float r3 = r3 - r8
            float r3 = r3 / r18
            goto L8d
        L8a:
            float r3 = r3 - r8
            goto L8d
        L8c:
            r3 = 0
        L8d:
            float r6 = r6 * r9
            if (r11 == 0) goto La3
            if (r5 == r10) goto L9f
            r8 = 2
            if (r5 == r8) goto L9c
            if (r5 == r12) goto L9f
            if (r5 == r15) goto L9c
            if (r5 == r14) goto L9c
            goto La3
        L9c:
            float r12 = r4 - r6
            goto La4
        L9f:
            float r4 = r4 - r6
            float r12 = r4 / r18
            goto La4
        La3:
            r12 = 0
        La4:
            r7.postTranslate(r3, r12)
            r2.setImageMatrix(r7)
        Laa:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.tv.utils.CropImageViewTv.setFrame(int, int, int, int):boolean");
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        bitmap.getClass();
        super.setImageBitmap(bitmap);
        a();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        a();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i10) {
        super.setImageResource(i10);
        a();
    }
}
