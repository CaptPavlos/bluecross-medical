package com.mbridge.msdk.dycreator.baseview.extview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.mbridge.msdk.dycreator.a.b;
import com.mbridge.msdk.dycreator.a.c;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeFramLayout;
import com.mbridge.msdk.dycreator.baseview.inter.InterBase;
import com.mbridge.msdk.dycreator.e.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBExtFrameLayout extends MBridgeFramLayout implements InterBase {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, String> f3098a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, Boolean> f3099b;

    /* renamed from: c, reason: collision with root package name */
    private String f3100c;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.dycreator.baseview.extview.MBExtFrameLayout$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3101a;

        static {
            int[] iArr = new int[c.values().length];
            f3101a = iArr;
            try {
                iArr[c.layout_width.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3101a[c.layout_height.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3101a[c.layout_gravity.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3101a[c.layout_margin.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3101a[c.layout_marginLeft.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3101a[c.layout_marginRight.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3101a[c.layout_marginTop.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3101a[c.layout_marginBottom.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public MBExtFrameLayout(Context context, AttributeSet attributeSet) {
        super(context);
        this.f3100c = "";
        try {
            this.f3098a = com.mbridge.msdk.dycreator.e.c.a(context, attributeSet);
            a.a(this, attributeSet);
            setLayoutParams(generateLayoutParams(attributeSet));
            com.mbridge.msdk.dycreator.e.c.a(this.f3098a, this);
        } catch (Exception e) {
            af.b("MBExtFrameLayout", e.getMessage());
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) throws NumberFormatException {
        FrameLayout.LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        HashMap mapB = b.a().b();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i10 = 0; i10 < attributeCount; i10++) {
            c cVar = (c) mapB.get(attributeSet.getAttributeName(i10));
            if (cVar != null) {
                switch (AnonymousClass1.f3101a[cVar.ordinal()]) {
                    case 1:
                        String attributeValue = attributeSet.getAttributeValue(i10);
                        if (!attributeValue.startsWith("f") && !attributeValue.startsWith("m")) {
                            if (attributeValue.startsWith("w")) {
                                layoutParamsGenerateDefaultLayoutParams.width = -2;
                                break;
                            } else {
                                layoutParamsGenerateDefaultLayoutParams.width = b.a().b(attributeValue);
                                break;
                            }
                        } else {
                            layoutParamsGenerateDefaultLayoutParams.width = -1;
                            break;
                        }
                    case 2:
                        String attributeValue2 = attributeSet.getAttributeValue(i10);
                        if (!attributeValue2.startsWith("f") && !attributeValue2.startsWith("m")) {
                            if (attributeValue2.startsWith("w")) {
                                layoutParamsGenerateDefaultLayoutParams.width = -2;
                                break;
                            } else {
                                layoutParamsGenerateDefaultLayoutParams.height = b.a().b(attributeValue2);
                                break;
                            }
                        } else {
                            layoutParamsGenerateDefaultLayoutParams.width = -1;
                            break;
                        }
                        break;
                    case 3:
                        layoutParamsGenerateDefaultLayoutParams.gravity = b.a().c(attributeSet.getAttributeValue(i10));
                        break;
                    case 4:
                        int iB = b.a().b(attributeSet.getAttributeValue(i10));
                        layoutParamsGenerateDefaultLayoutParams.setMargins(iB, iB, iB, iB);
                        break;
                    case 5:
                        layoutParamsGenerateDefaultLayoutParams.leftMargin = b.a().b(attributeSet.getAttributeValue(i10));
                        break;
                    case 6:
                        layoutParamsGenerateDefaultLayoutParams.rightMargin = b.a().b(attributeSet.getAttributeValue(i10));
                        break;
                    case 7:
                        layoutParamsGenerateDefaultLayoutParams.topMargin = b.a().b(attributeSet.getAttributeValue(i10));
                        break;
                    case 8:
                        layoutParamsGenerateDefaultLayoutParams.bottomMargin = b.a().b(attributeSet.getAttributeValue(i10));
                        break;
                }
            }
        }
        return layoutParamsGenerateDefaultLayoutParams;
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getActionDes() {
        Map<String, String> map = this.f3098a;
        return (map == null || !map.containsKey("mbridgeAction")) ? "" : this.f3098a.get("mbridgeAction");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getBindDataDes() {
        Map<String, String> map = this.f3098a;
        return (map == null || !map.containsKey("mbridgeData")) ? "" : this.f3098a.get("mbridgeData");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getEffectDes() {
        Map<String, String> map = this.f3098a;
        return (map == null || !map.containsKey("mbridgeEffect")) ? "" : this.f3098a.get("mbridgeEffect");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getReportDes() {
        Map<String, String> map = this.f3098a;
        return (map == null || !map.containsKey("mbridgeReport")) ? "" : this.f3098a.get("mbridgeReport");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getStrategyDes() {
        Map<String, String> map = this.f3098a;
        return (map == null || !map.containsKey("mbridgeStrategy")) ? "" : this.f3098a.get("mbridgeStrategy");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.cusview.MBridgeFramLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Map<String, Boolean> map = this.f3099b;
        if (map != null && map.containsKey("mbridgeAttached") && this.f3099b.get("mbridgeAttached").booleanValue()) {
            com.mbridge.msdk.dycreator.baseview.a.i("mbridgeAttached").a(this.f3100c);
        }
    }

    @Override // com.mbridge.msdk.dycreator.baseview.cusview.MBridgeFramLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Map<String, Boolean> map = this.f3099b;
        if (map != null && map.containsKey("mbridgeDetached") && this.f3099b.get("mbridgeDetached").booleanValue()) {
            com.mbridge.msdk.dycreator.baseview.a.i("mbridgeDetached").a(this.f3100c);
        }
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public void setDynamicReport(String str, CampaignEx campaignEx) {
        this.f3099b = com.mbridge.msdk.dycreator.e.c.a(str);
        if (campaignEx != null) {
            this.f3100c = campaignEx.getCampaignUnitId();
        }
    }

    public MBExtFrameLayout(Context context) {
        super(context);
        this.f3100c = "";
    }

    public MBExtFrameLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3100c = "";
    }
}
