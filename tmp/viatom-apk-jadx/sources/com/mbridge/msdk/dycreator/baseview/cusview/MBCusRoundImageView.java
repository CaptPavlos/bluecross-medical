package com.mbridge.msdk.dycreator.baseview.cusview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.mbridge.msdk.dycreator.a.b;
import com.mbridge.msdk.dycreator.a.c;
import com.mbridge.msdk.dycreator.baseview.GradientOrientationUtils;
import com.mbridge.msdk.foundation.tools.af;
import java.util.HashMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBCusRoundImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private int f3016a;

    /* renamed from: b, reason: collision with root package name */
    private int f3017b;

    /* renamed from: c, reason: collision with root package name */
    private int f3018c;

    /* renamed from: d, reason: collision with root package name */
    private int f3019d;
    private Xfermode e;
    private int f;
    private int g;
    private int h;

    /* renamed from: i, reason: collision with root package name */
    private int f3020i;

    /* renamed from: j, reason: collision with root package name */
    private int f3021j;

    /* renamed from: k, reason: collision with root package name */
    private int f3022k;

    /* renamed from: l, reason: collision with root package name */
    private int f3023l;

    /* renamed from: m, reason: collision with root package name */
    private int f3024m;

    /* renamed from: n, reason: collision with root package name */
    private int f3025n;

    /* renamed from: o, reason: collision with root package name */
    private float[] f3026o;

    /* renamed from: p, reason: collision with root package name */
    private float[] f3027p;

    /* renamed from: q, reason: collision with root package name */
    private RectF f3028q;

    /* renamed from: r, reason: collision with root package name */
    private RectF f3029r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f3030s;
    private boolean t;

    /* renamed from: u, reason: collision with root package name */
    private Path f3031u;

    /* renamed from: v, reason: collision with root package name */
    private Paint f3032v;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3033a;

        static {
            int[] iArr = new int[c.values().length];
            f3033a = iArr;
            try {
                iArr[c.id.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3033a[c.src.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3033a[c.background.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3033a[c.contentDescription.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3033a[c.tag.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3033a[c.visibility.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3033a[c.scaleType.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3033a[c.padding.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3033a[c.paddingTop.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f3033a[c.paddingBottom.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f3033a[c.paddingLeft.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f3033a[c.paddingRight.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f3033a[c.layout_width.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f3033a[c.layout_height.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f3033a[c.gravity.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f3033a[c.layout_gravity.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    public MBCusRoundImageView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3031u = new Path();
        this.f3032v = new Paint();
        this.f3026o = new float[8];
        this.f3027p = new float[8];
        this.f3029r = new RectF();
        this.f3028q = new RectF();
        this.e = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }

    public ViewGroup.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        HashMap<String, c> mapC = b.a().c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i10 = 0; i10 < attributeCount; i10++) {
            c cVar = mapC.get(attributeSet.getAttributeName(i10));
            if (cVar != null) {
                int i11 = AnonymousClass1.f3033a[cVar.ordinal()];
                if (i11 == 6) {
                    String attributeValue = attributeSet.getAttributeValue(i10);
                    if (!TextUtils.isEmpty(attributeValue)) {
                        if (attributeValue.equals("invisible")) {
                            setVisibility(4);
                        } else if (attributeValue.equalsIgnoreCase("gone")) {
                            setVisibility(8);
                        }
                    }
                } else if (i11 == 13) {
                    String attributeValue2 = attributeSet.getAttributeValue(i10);
                    if (attributeValue2.startsWith("f") || attributeValue2.startsWith("m")) {
                        layoutParams.width = -1;
                    } else if (attributeValue2.startsWith("wrap")) {
                        layoutParams.width = -2;
                    } else {
                        layoutParams.width = b.a().b(attributeValue2);
                    }
                } else if (i11 == 14) {
                    String attributeValue3 = attributeSet.getAttributeValue(i10);
                    if (attributeValue3.startsWith("f") || attributeValue3.startsWith("m")) {
                        layoutParams.height = -1;
                    } else if (attributeValue3.startsWith("wrap")) {
                        layoutParams.height = -2;
                    } else {
                        layoutParams.height = b.a().b(attributeValue3);
                    }
                }
            }
        }
        return layoutParams;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        try {
            canvas.saveLayer(this.f3028q, null, 31);
            int i10 = this.f;
            int i11 = this.f3024m;
            int i12 = this.g;
            canvas.scale(((i10 - (i11 * 2)) * 1.0f) / i10, ((i12 - (i11 * 2)) * 1.0f) / i12, i10 / 2.0f, i12 / 2.0f);
            super.onDraw(canvas);
            Paint paint = this.f3032v;
            if (paint != null) {
                paint.reset();
                this.f3032v.setAntiAlias(true);
                this.f3032v.setStyle(Paint.Style.FILL);
                this.f3032v.setXfermode(this.e);
            }
            Path path = this.f3031u;
            if (path != null) {
                path.reset();
                this.f3031u.addRoundRect(this.f3028q, this.f3027p, Path.Direction.CCW);
            }
            canvas.drawPath(this.f3031u, this.f3032v);
            Paint paint2 = this.f3032v;
            if (paint2 != null) {
                paint2.setXfermode(null);
            }
            canvas.restore();
            if (this.f3030s) {
                int i13 = this.f3024m;
                int i14 = this.f3025n;
                RectF rectF = this.f3029r;
                float[] fArr = this.f3026o;
                try {
                    Path path2 = this.f3031u;
                    if (path2 != null) {
                        path2.reset();
                    }
                    Paint paint3 = this.f3032v;
                    if (paint3 != null) {
                        paint3.setStrokeWidth(i13);
                        this.f3032v.setColor(i14);
                        this.f3032v.setStyle(Paint.Style.STROKE);
                    }
                    Path path3 = this.f3031u;
                    if (path3 != null) {
                        path3.addRoundRect(rectF, fArr, Path.Direction.CCW);
                    }
                    canvas.drawPath(this.f3031u, this.f3032v);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e3) {
            af.a("MBridgeImageView", e3.getMessage());
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16;
        super.onSizeChanged(i10, i11, i12, i13);
        try {
            this.f = i10;
            this.g = i11;
            boolean z9 = this.t;
            float[] fArr = this.f3026o;
            int i17 = 0;
            if (z9) {
                if (fArr != null) {
                    try {
                        if (this.f3027p != null) {
                            while (true) {
                                i14 = 2;
                                if (i17 >= 2) {
                                    break;
                                }
                                float[] fArr2 = this.f3026o;
                                int i18 = this.f3020i;
                                fArr2[i17] = i18;
                                this.f3027p[i17] = i18 - (this.f3024m / 2.0f);
                                i17++;
                            }
                            while (true) {
                                i15 = 4;
                                if (i14 >= 4) {
                                    break;
                                }
                                float[] fArr3 = this.f3026o;
                                int i19 = this.f3021j;
                                fArr3[i14] = i19;
                                this.f3027p[i14] = i19 - (this.f3024m / 2.0f);
                                i14++;
                            }
                            while (true) {
                                if (i15 >= 6) {
                                    break;
                                }
                                float[] fArr4 = this.f3026o;
                                int i20 = this.f3022k;
                                fArr4[i15] = i20;
                                this.f3027p[i15] = i20 - (this.f3024m / 2.0f);
                                i15++;
                            }
                            for (i16 = 6; i16 < 8; i16++) {
                                float[] fArr5 = this.f3026o;
                                int i21 = this.f3023l;
                                fArr5[i16] = i21;
                                this.f3027p[i16] = i21 - (this.f3024m / 2.0f);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else if (fArr != null && this.f3027p != null) {
                while (true) {
                    try {
                        float[] fArr6 = this.f3026o;
                        if (i17 >= fArr6.length) {
                            break;
                        }
                        int i22 = this.h;
                        fArr6[i17] = i22;
                        this.f3027p[i17] = i22 - (this.f3024m / 2.0f);
                        i17++;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            }
            RectF rectF = this.f3029r;
            if (rectF != null) {
                int i23 = this.f3024m;
                rectF.set(i23 / 2.0f, i23 / 2.0f, this.f - (i23 / 2.0f), this.g - (i23 / 2.0f));
            }
            RectF rectF2 = this.f3028q;
            if (rectF2 != null) {
                rectF2.set(0.0f, 0.0f, this.f, this.g);
            }
        } catch (Exception e7) {
            af.b("MBridgeImageView", e7.getMessage());
        }
    }

    public void setAttributeSet(AttributeSet attributeSet) throws NumberFormatException {
        String[] strArrSplit;
        HashMap<String, c> mapC = b.a().c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i10 = 0; i10 < attributeCount; i10++) {
            c cVar = mapC.get(attributeSet.getAttributeName(i10));
            if (cVar != null) {
                switch (AnonymousClass1.f3033a[cVar.ordinal()]) {
                    case 1:
                        String attributeValue = attributeSet.getAttributeValue(i10);
                        if (attributeValue.startsWith("@+id/")) {
                            setId(attributeValue.substring(5).hashCode());
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        b.a().a(attributeSet.getAttributeValue(i10), this);
                        break;
                    case 3:
                        String attributeValue2 = attributeSet.getAttributeValue(i10);
                        if (!attributeValue2.startsWith("#")) {
                            if (attributeValue2.startsWith("@drawable/")) {
                                attributeValue2 = attributeValue2.substring(10);
                            }
                            setBackgroundResource(getResources().getIdentifier(attributeValue2, "drawable", getContext().getPackageName()));
                            break;
                        } else {
                            try {
                                strArrSplit = attributeValue2.split("-");
                            } catch (Exception unused) {
                                strArrSplit = null;
                            }
                            if (strArrSplit != null && strArrSplit.length <= 2) {
                                setBackgroundColor(b.a().a(attributeSet.getAttributeValue(i10)));
                                break;
                            } else if (strArrSplit == null || strArrSplit.length != 3) {
                                setBackgroundColor(b.a().a(attributeSet.getAttributeValue(i10)));
                                break;
                            } else {
                                try {
                                    GradientDrawable gradientDrawable = new GradientDrawable(GradientOrientationUtils.getOrientation(strArrSplit[2]), new int[]{Color.parseColor(strArrSplit[0]), Color.parseColor(strArrSplit[1])});
                                    gradientDrawable.setGradientType(0);
                                    setBackground(gradientDrawable);
                                    break;
                                } catch (Exception unused2) {
                                }
                            }
                        }
                        break;
                    case 4:
                        String attributeValue3 = attributeSet.getAttributeValue(i10);
                        if (TextUtils.isEmpty(attributeValue3)) {
                            break;
                        } else {
                            CharSequence charSequence = (String) com.mbridge.msdk.dycreator.e.b.f3249a.get(attributeValue3.substring(8));
                            if (TextUtils.isEmpty(charSequence)) {
                                break;
                            } else {
                                setContentDescription(charSequence);
                                break;
                            }
                        }
                    case 5:
                        String attributeValue4 = attributeSet.getAttributeValue(i10);
                        if (TextUtils.isEmpty(attributeValue4)) {
                            break;
                        } else {
                            String str = com.mbridge.msdk.dycreator.e.b.f3249a.get(attributeValue4.substring(8));
                            if (TextUtils.isEmpty(str)) {
                                break;
                            } else {
                                setTag(str);
                                break;
                            }
                        }
                    case 6:
                        String attributeValue5 = attributeSet.getAttributeValue(i10);
                        if (TextUtils.isEmpty(attributeValue5)) {
                            break;
                        } else if (attributeValue5.equals("invisible")) {
                            setVisibility(4);
                            break;
                        } else if (attributeValue5.equalsIgnoreCase("gone")) {
                            setVisibility(8);
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        String attributeValue6 = attributeSet.getAttributeValue(i10);
                        if (TextUtils.isEmpty(attributeValue6)) {
                            break;
                        } else if (attributeValue6.equals("fitXY")) {
                            setScaleType(ImageView.ScaleType.FIT_XY);
                            break;
                        } else if (attributeValue6.equals("centerInside")) {
                            setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                            break;
                        } else if (attributeValue6.equals("centerCrop")) {
                            setScaleType(ImageView.ScaleType.CENTER_CROP);
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        int iB = b.a().b(attributeSet.getAttributeValue(i10));
                        this.f3019d = iB;
                        this.f3018c = iB;
                        this.f3017b = iB;
                        this.f3016a = iB;
                        setPadding(iB, iB, iB, iB);
                        break;
                    case 9:
                        int iB2 = b.a().b(attributeSet.getAttributeValue(i10));
                        this.f3017b = iB2;
                        setPadding(this.f3016a, iB2, this.f3018c, this.f3019d);
                        break;
                    case 10:
                        int iB3 = b.a().b(attributeSet.getAttributeValue(i10));
                        this.f3019d = iB3;
                        setPadding(this.f3016a, this.f3017b, this.f3018c, iB3);
                        break;
                    case 11:
                        int iB4 = b.a().b(attributeSet.getAttributeValue(i10));
                        this.f3016a = iB4;
                        setPadding(iB4, this.f3017b, this.f3018c, this.f3019d);
                        break;
                    case 12:
                        int iB5 = b.a().b(attributeSet.getAttributeValue(i10));
                        this.f3018c = iB5;
                        setPadding(this.f3016a, this.f3017b, iB5, this.f3019d);
                        break;
                }
            }
        }
    }

    public void setBorder(int i10, int i11, int i12) {
        this.f3030s = true;
        this.f3024m = i11;
        this.f3025n = i12;
        this.h = i10;
    }

    public void setCornerRadius(int i10) {
        this.h = i10;
    }

    public void setCustomBorder(int i10, int i11, int i12, int i13, int i14, int i15) {
        this.f3030s = true;
        this.t = true;
        this.f3024m = i14;
        this.f3025n = i15;
        this.f3020i = i10;
        this.f3022k = i12;
        this.f3021j = i11;
        this.f3023l = i13;
    }

    public MBCusRoundImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, 0);
        try {
            setAttributeSet(attributeSet);
            setLayoutParams(generateLayoutParams(context, attributeSet));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MBCusRoundImageView(Context context) {
        this(context, null);
    }
}
