package com.mbridge.msdk.dycreator.baseview;

import android.content.Context;
import android.util.AttributeSet;
import com.mbridge.msdk.dycreator.binding.response.SplashResData;
import com.mbridge.msdk.dycreator.bus.EventBus;
import com.mbridge.msdk.dycreator.listener.action.EAction;
import com.mbridge.msdk.e.a.b;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBCountDownView extends MBTextView {

    /* renamed from: a, reason: collision with root package name */
    private b f2931a;

    /* renamed from: b, reason: collision with root package name */
    private MBCountDownView f2932b;

    public MBCountDownView(Context context) {
        super(context);
        this.f2932b = this;
    }

    public void initView(final String str, final String str2, int i10) {
        this.f2931a = new b().b(i10 * 1000).a(1000L).a(new com.mbridge.msdk.e.a.a() { // from class: com.mbridge.msdk.dycreator.baseview.MBCountDownView.1
            @Override // com.mbridge.msdk.e.a.a
            public void onFinish() {
                MBCountDownView.this.f2931a.a();
                SplashResData splashResData = new SplashResData();
                splashResData.seteAction(EAction.CLOSE);
                EventBus.getDefault().post(splashResData);
            }

            @Override // com.mbridge.msdk.e.a.a
            public void onTick(long j10) {
                boolean zStartsWith = str2.startsWith("zh");
                MBCountDownView mBCountDownView = MBCountDownView.this;
                if (zStartsWith) {
                    mBCountDownView.f2932b.setText((j10 / 1000) + "s" + str);
                    return;
                }
                mBCountDownView.f2932b.setText(MBCountDownView.this.f2932b + " " + (j10 / 1000) + "s");
            }
        });
    }

    @Override // com.mbridge.msdk.dycreator.baseview.MBTextView, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b bVar = this.f2931a;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // com.mbridge.msdk.dycreator.baseview.MBTextView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b bVar = this.f2931a;
        if (bVar != null) {
            bVar.a();
        }
    }

    public MBCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2932b = this;
    }

    public MBCountDownView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2932b = this;
    }
}
