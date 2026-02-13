package com.mbridge.msdk.dycreator.baseview;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
public class MBInduceClickView extends FrameLayout implements InterBase, InterEffect {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, String> f2953a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, Boolean> f2954b;

    /* renamed from: c, reason: collision with root package name */
    private String f2955c;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.dycreator.baseview.MBInduceClickView$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2956a;

        static {
            int[] iArr = new int[c.values().length];
            f2956a = iArr;
            try {
                iArr[c.layout_width.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2956a[c.layout_height.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2956a[c.layout_gravity.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2956a[c.layout_marginLeft.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2956a[c.layout_margin.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public MBInduceClickView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context);
        this.f2955c = "";
        if (context != null && attributeSet != null) {
            try {
                this.f2953a = com.mbridge.msdk.dycreator.e.c.a(context, attributeSet);
            } catch (Exception e) {
                af.b("MBInduceClickView", e.getMessage());
                return;
            }
        }
        com.mbridge.msdk.dycreator.e.a.a(this, attributeSet);
        setLayoutParams(generateLayoutParams(attributeSet));
        com.mbridge.msdk.dycreator.e.c.a(this.f2953a, this);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) throws NumberFormatException {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(0, 0);
        HashMap mapB = b.a().b();
        layoutParams.width = -2;
        layoutParams.height = -2;
        int attributeCount = attributeSet.getAttributeCount();
        for (int i10 = 0; i10 < attributeCount; i10++) {
            c cVar = (c) mapB.get(attributeSet.getAttributeName(i10));
            if (cVar != null) {
                int i11 = AnonymousClass1.f2956a[cVar.ordinal()];
                if (i11 == 1) {
                    String attributeValue = attributeSet.getAttributeValue(i10);
                    if (attributeValue.startsWith("f") || attributeValue.startsWith("m")) {
                        layoutParams.width = -1;
                    } else if (attributeValue.startsWith("w")) {
                        layoutParams.width = -2;
                    } else {
                        layoutParams.width = b.a().b(attributeValue);
                    }
                } else if (i11 == 2) {
                    String attributeValue2 = attributeSet.getAttributeValue(i10);
                    if (attributeValue2.startsWith("f") || attributeValue2.startsWith("m")) {
                        layoutParams.width = -1;
                    } else if (attributeValue2.startsWith("w")) {
                        layoutParams.width = -2;
                    } else {
                        layoutParams.height = b.a().b(attributeValue2);
                    }
                } else if (i11 == 3) {
                    layoutParams.gravity = b.a().c(attributeSet.getAttributeValue(i10));
                } else if (i11 == 4) {
                    layoutParams.leftMargin = b.a().b(attributeSet.getAttributeValue(i10));
                } else if (i11 == 5) {
                    int iB = b.a().b(attributeSet.getAttributeValue(i10));
                    layoutParams.setMargins(iB, iB, iB, iB);
                }
            }
        }
        return layoutParams;
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getActionDes() {
        Map<String, String> map = this.f2953a;
        return (map == null || !map.containsKey("mbridgeAction")) ? "" : this.f2953a.get("mbridgeAction");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getBindDataDes() {
        Map<String, String> map = this.f2953a;
        return (map == null || !map.containsKey("mbridgeData")) ? "" : this.f2953a.get("mbridgeData");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getEffectDes() {
        Map<String, String> map = this.f2953a;
        return (map == null || !map.containsKey("mbridgeEffect")) ? "" : this.f2953a.get("mbridgeEffect");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getReportDes() {
        Map<String, String> map = this.f2953a;
        return (map == null || !map.containsKey("mbridgeReport")) ? "" : this.f2953a.get("mbridgeReport");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getStrategyDes() {
        Map<String, String> map = this.f2953a;
        return (map == null || !map.containsKey("mbridgeStrategy")) ? "" : this.f2953a.get("mbridgeStrategy");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Map<String, Boolean> map = this.f2954b;
        if (map != null && map.containsKey("mbridgeAttached") && this.f2954b.get("mbridgeAttached").booleanValue()) {
            a.i("mbridgeAttached").a(this.f2955c);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Map<String, Boolean> map = this.f2954b;
        if (map != null && map.containsKey("mbridgeDetached") && this.f2954b.get("mbridgeDetached").booleanValue()) {
            a.i("mbridgeDetached").a(this.f2955c);
        }
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public void setDynamicReport(String str, CampaignEx campaignEx) {
        this.f2954b = com.mbridge.msdk.dycreator.e.c.a(str);
        if (campaignEx != null) {
            this.f2955c = campaignEx.getCampaignUnitId();
        }
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterEffect
    public void setAnimator(Animator animator) {
    }

    public MBInduceClickView(@NonNull Context context) {
        super(context);
        this.f2955c = "";
    }

    public MBInduceClickView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2955c = "";
    }
}
