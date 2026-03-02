package com.uptodown.util.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class UsernameTextView extends AppCompatTextView {

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f6728j = 0;

    /* renamed from: a, reason: collision with root package name */
    public ValueAnimator f6729a;

    /* renamed from: b, reason: collision with root package name */
    public float f6730b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f6731c;

    /* renamed from: d, reason: collision with root package name */
    public Integer f6732d;
    public long e;
    public long f;
    public boolean g;
    public String h;

    /* renamed from: i, reason: collision with root package name */
    public Handler f6733i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UsernameTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        context.getClass();
        this.f6733i = new Handler(Looper.getMainLooper());
        this.f6732d = Integer.valueOf(getCurrentTextColor());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r2 = this;
            android.text.TextPaint r0 = r2.getPaint()
            r1 = 0
            r0.setShader(r1)
            java.lang.String r0 = r2.h
            if (r0 == 0) goto L52
            int r1 = r0.hashCode()
            switch(r1) {
                case 110843959: goto L3e;
                case 110843960: goto L29;
                case 110843961: goto L14;
                default: goto L13;
            }
        L13:
            goto L52
        L14:
            java.lang.String r1 = "type3"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L1d
            goto L52
        L1d:
            android.content.Context r0 = r2.getContext()
            r1 = 2131100855(0x7f0604b7, float:1.7814103E38)
            int r0 = androidx.core.content.ContextCompat.getColor(r0, r1)
            goto L5d
        L29:
            java.lang.String r1 = "type2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L32
            goto L52
        L32:
            android.content.Context r0 = r2.getContext()
            r1 = 2131100853(0x7f0604b5, float:1.78141E38)
            int r0 = androidx.core.content.ContextCompat.getColor(r0, r1)
            goto L5d
        L3e:
            java.lang.String r1 = "type1"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L52
            android.content.Context r0 = r2.getContext()
            r1 = 2131100851(0x7f0604b3, float:1.7814095E38)
            int r0 = androidx.core.content.ContextCompat.getColor(r0, r1)
            goto L5d
        L52:
            android.content.Context r0 = r2.getContext()
            r1 = 2131100835(0x7f0604a3, float:1.7814063E38)
            int r0 = androidx.core.content.ContextCompat.getColor(r0, r1)
        L5d:
            r2.setTextColor(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.util.views.UsernameTextView.a():void");
    }

    public final Handler getAnimationHandler() {
        return this.f6733i;
    }

    public final String getUsernameFormat() {
        return this.h;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        canvas.getClass();
        if (this.f6731c != null) {
            ValueAnimator valueAnimator = this.f6729a;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                a();
            } else {
                float width = getWidth();
                int[] iArr = this.f6731c;
                iArr.getClass();
                float f = this.f6730b;
                getPaint().setShader(new LinearGradient(0.0f, 0.0f, width, 0.0f, iArr, new float[]{0.0f, f, f, f, 1.0f}, Shader.TileMode.CLAMP));
            }
        } else {
            Integer num = this.f6732d;
            if (num != null) {
                num.getClass();
                setTextColor(num.intValue());
            }
        }
        super.onDraw(canvas);
    }

    public final void setAnimationHandler(Handler handler) {
        this.f6733i = handler;
    }

    public final void setTurbo(boolean z9) {
        this.g = z9;
    }

    public final void setUsernameFormat(String str) {
        this.h = str;
    }
}
