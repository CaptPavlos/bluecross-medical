package com.mbridge.msdk.dycreator.baseview;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mbridge.msdk.dycreator.a.b;
import com.mbridge.msdk.dycreator.a.c;
import com.mbridge.msdk.dycreator.baseview.inter.InterBase;
import com.mbridge.msdk.dycreator.baseview.inter.InterEffect;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBTextView extends TextView implements InterBase, InterEffect {

    /* renamed from: a, reason: collision with root package name */
    private boolean f3011a;
    public AttributeSet attrs;

    /* renamed from: b, reason: collision with root package name */
    private Animator f3012b;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, String> f3013c;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, Boolean> f3014d;
    private String e;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.dycreator.baseview.MBTextView$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3015a;

        static {
            int[] iArr = new int[c.values().length];
            f3015a = iArr;
            try {
                iArr[c.layout_width.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3015a[c.layout_height.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public MBTextView(Context context, AttributeSet attributeSet) {
        super(context);
        this.f3011a = false;
        this.e = "";
        this.attrs = attributeSet;
        try {
            this.f3013c = com.mbridge.msdk.dycreator.e.c.a(context, attributeSet);
            com.mbridge.msdk.dycreator.e.a.a(this, attributeSet);
            setLayoutParams(generateLayoutParams(attributeSet));
            com.mbridge.msdk.dycreator.e.c.a(this.f3013c, this);
        } catch (Exception e) {
            af.b("TextView", e.getMessage());
        }
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        HashMap mapB = b.a().b();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i10 = 0; i10 < attributeCount; i10++) {
            c cVar = (c) mapB.get(attributeSet.getAttributeName(i10));
            if (cVar != null) {
                int i11 = AnonymousClass1.f3015a[cVar.ordinal()];
                if (i11 == 1) {
                    String attributeValue = attributeSet.getAttributeValue(i10);
                    if (attributeValue.startsWith("f") || attributeValue.startsWith("m")) {
                        layoutParams.width = -1;
                    } else if (attributeValue.startsWith("wrap")) {
                        layoutParams.width = -2;
                    } else {
                        layoutParams.width = b.a().b(attributeValue);
                    }
                } else if (i11 == 2) {
                    String attributeValue2 = attributeSet.getAttributeValue(i10);
                    if (attributeValue2.startsWith("f") || attributeValue2.startsWith("m")) {
                        layoutParams.height = -1;
                    } else if (attributeValue2.startsWith("wrap")) {
                        layoutParams.height = -2;
                    } else {
                        layoutParams.height = b.a().b(attributeValue2);
                    }
                }
            }
        }
        return layoutParams;
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getActionDes() {
        Map<String, String> map = this.f3013c;
        return (map == null || !map.containsKey("mbridgeAction")) ? "" : this.f3013c.get("mbridgeAction");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getBindDataDes() {
        Map<String, String> map = this.f3013c;
        return (map == null || !map.containsKey("mbridgeData")) ? "" : this.f3013c.get("mbridgeData");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getEffectDes() {
        Map<String, String> map = this.f3013c;
        return (map == null || !map.containsKey("mbridgeEffect")) ? "" : this.f3013c.get("mbridgeEffect");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getReportDes() {
        Map<String, String> map = this.f3013c;
        return (map == null || !map.containsKey("mbridgeReport")) ? "" : this.f3013c.get("mbridgeReport");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getStrategyDes() {
        Map<String, String> map = this.f3013c;
        return (map == null || !map.containsKey("mbridgeStrategy")) ? "" : this.f3013c.get("mbridgeStrategy");
    }

    @Override // android.view.View
    public boolean isFocused() {
        if (this.f3011a) {
            return true;
        }
        return super.isFocused();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Animator animator = this.f3012b;
        if (animator != null) {
            try {
                animator.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Map<String, Boolean> map = this.f3014d;
        if (map != null && map.containsKey("mbridgeAttached") && this.f3014d.get("mbridgeAttached").booleanValue()) {
            a.i("mbridgeAttached").a(this.e);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Animator animator = this.f3012b;
        if (animator != null) {
            try {
                animator.cancel();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Map<String, Boolean> map = this.f3014d;
        if (map != null && map.containsKey("mbridgeDetached") && this.f3014d.get("mbridgeDetached").booleanValue()) {
            a.i("mbridgeDetached").a(this.e);
        }
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterEffect
    public void setAnimator(Animator animator) {
        this.f3012b = animator;
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public void setDynamicReport(String str, CampaignEx campaignEx) {
        this.f3014d = com.mbridge.msdk.dycreator.e.c.a(str);
        if (campaignEx != null) {
            this.e = campaignEx.getCampaignUnitId();
        }
    }

    public MBTextView(Context context) {
        super(context);
        this.f3011a = false;
        this.e = "";
    }

    public MBTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3011a = false;
        this.e = "";
    }
}
