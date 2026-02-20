package com.mbridge.msdk.dycreator.wrapper;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mbridge.msdk.dycreator.a.b;
import com.mbridge.msdk.dycreator.b.a;
import com.mbridge.msdk.dycreator.e.f;
import com.mbridge.msdk.dycreator.viewmodel.BaseViewModel;
import com.mbridge.msdk.dycreator.viewmodel.MBCommonViewVModel;
import com.mbridge.msdk.dycreator.viewmodel.MBRewardViewVModel;
import com.mbridge.msdk.dycreator.viewmodel.MBSplashViewVModel;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.File;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class DynamicViewCreator {

    /* renamed from: a, reason: collision with root package name */
    private static volatile DynamicViewCreator f3298a = null;

    /* renamed from: b, reason: collision with root package name */
    private static int f3299b = -201;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.dycreator.wrapper.DynamicViewCreator$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3300a;

        static {
            int[] iArr = new int[DyAdType.values().length];
            f3300a = iArr;
            try {
                iArr[DyAdType.SPLASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3300a[DyAdType.REWARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private DynamicViewCreator() {
        b.a().a(c.m().c());
    }

    private View a(Context context, DyOption dyOption) throws JSONException {
        List<String> fileDirs;
        if (dyOption == null || (fileDirs = dyOption.getFileDirs()) == null) {
            return null;
        }
        int i10 = 0;
        ViewGroup viewGroup = null;
        int i11 = 0;
        while (i11 < fileDirs.size()) {
            try {
                if (!TextUtils.isEmpty(fileDirs.get(i11))) {
                    if (i11 == 0) {
                        viewGroup = (ViewGroup) f.a(context).a(fileDirs.get(i11));
                    } else {
                        String str = fileDirs.get(i11);
                        if (context != null && viewGroup != null && !TextUtils.isEmpty(str)) {
                            try {
                                JSONObject jSONObject = new JSONObject(str);
                                String string = jSONObject.getString("folder_dir");
                                if (!TextUtils.isEmpty(string)) {
                                    JSONArray jSONArray = new JSONArray(jSONObject.optString("ext_template"));
                                    if (jSONArray.length() != 0) {
                                        int i12 = i10;
                                        while (i12 < jSONArray.length()) {
                                            JSONObject jSONObject2 = jSONArray.getJSONObject(i12);
                                            if (jSONObject2 != null) {
                                                View viewA = f.a(context).a(string + File.separator + jSONObject2.optString(RewardPlus.NAME));
                                                if (viewA != null) {
                                                    JSONObject jSONObject3 = jSONObject2.getJSONObject(TtmlNode.TAG_LAYOUT);
                                                    if (jSONObject3 != null) {
                                                        try {
                                                            String strOptString = jSONObject3.optString("parent_id");
                                                            ViewGroup viewGroup2 = !TextUtils.isEmpty(strOptString) ? (ViewGroup) f.a(context).a(viewGroup, strOptString) : viewGroup;
                                                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewGroup2.getLayoutParams();
                                                            if (layoutParams != null) {
                                                                String strOptString2 = jSONObject3.optString("below", "");
                                                                if (!TextUtils.isEmpty(strOptString2)) {
                                                                    layoutParams.addRule(3, strOptString2.hashCode());
                                                                }
                                                                String strOptString3 = jSONObject3.optString("left_of", "");
                                                                if (!TextUtils.isEmpty(strOptString3)) {
                                                                    layoutParams.addRule(i10, strOptString3.hashCode());
                                                                }
                                                                String strOptString4 = jSONObject3.optString("right_of", "");
                                                                if (!TextUtils.isEmpty(strOptString4)) {
                                                                    layoutParams.addRule(1, strOptString4.hashCode());
                                                                }
                                                                int iOptInt = jSONObject3.optInt("index", -2);
                                                                int iOptInt2 = jSONObject3.optInt("visibility", -1);
                                                                if (iOptInt2 != -1) {
                                                                    viewA.setVisibility(iOptInt2);
                                                                }
                                                                if (iOptInt != -2) {
                                                                    viewGroup2.addView(viewA, iOptInt, layoutParams);
                                                                } else {
                                                                    viewGroup2.addView(viewA, layoutParams);
                                                                }
                                                            }
                                                        } catch (Exception e) {
                                                            af.b("DynamicViewCreator", e.getMessage());
                                                        }
                                                    } else {
                                                        viewGroup.addView(viewA, 3);
                                                    }
                                                }
                                            }
                                            i12++;
                                            i10 = 0;
                                        }
                                    }
                                }
                            } catch (Exception e3) {
                                af.b("DynamicViewCreator", e3.getMessage());
                            }
                        }
                    }
                }
                i11++;
                i10 = 0;
            } catch (Exception e7) {
                af.b("DynamicViewCreator", e7.getMessage());
            }
        }
        return viewGroup;
    }

    public static DynamicViewCreator getInstance() {
        if (f3298a == null) {
            synchronized (DynamicViewCreator.class) {
                try {
                    if (f3298a == null) {
                        f3298a = new DynamicViewCreator();
                    }
                } finally {
                }
            }
        }
        return f3298a;
    }

    public void createDynamicView(DyOption dyOption, DynamicViewBackListener dynamicViewBackListener) {
        boolean z9;
        BaseViewModel mBSplashViewVModel;
        BaseViewModel mBCommonViewVModel;
        if (dyOption == null) {
            dynamicViewBackListener.viewCreateFail(new a(com.mbridge.msdk.dycreator.b.b.NOT_FOUND_DYNAMIC_OPTION));
            return;
        }
        if (dynamicViewBackListener == null) {
            return;
        }
        Context contextC = c.m().c();
        if (contextC == null) {
            dynamicViewBackListener.viewCreateFail(new a(com.mbridge.msdk.dycreator.b.b.NOT_FOUND_CONTEXT));
            return;
        }
        boolean z10 = false;
        if (dyOption.getCampaignEx() == null) {
            dynamicViewBackListener.viewCreateFail(new a(com.mbridge.msdk.dycreator.b.b.NOT_FOUND_CAMPAIGN));
            z9 = false;
        } else {
            z9 = true;
        }
        if (dyOption.getFile() != null || dyOption.getFileDirs() == null) {
            z10 = z9;
        } else {
            dynamicViewBackListener.viewCreateFail(new a(com.mbridge.msdk.dycreator.b.b.BIND_DATA_FILE_OR_DIR));
        }
        if (z10) {
            try {
                View viewA = a(contextC, dyOption);
                if (viewA == null) {
                    dynamicViewBackListener.viewCreateFail(new a(com.mbridge.msdk.dycreator.b.b.FILE_CREATE_VIEW_FILE));
                    return;
                }
                int i10 = AnonymousClass1.f3300a[dyOption.getDyAdType().ordinal()];
                if (i10 == 1) {
                    mBSplashViewVModel = new MBSplashViewVModel(dyOption);
                } else {
                    if (i10 != 2) {
                        mBCommonViewVModel = new MBCommonViewVModel();
                        mBCommonViewVModel.setDynamicViewBackListener(dynamicViewBackListener);
                        com.mbridge.msdk.dycreator.binding.b.a().a(mBCommonViewVModel);
                        mBCommonViewVModel.setModelDataAndBind();
                        dynamicViewBackListener.viewCreatedSuccess(viewA);
                    }
                    mBSplashViewVModel = new MBRewardViewVModel(dyOption);
                }
                mBCommonViewVModel = mBSplashViewVModel;
                mBCommonViewVModel.setDynamicViewBackListener(dynamicViewBackListener);
                com.mbridge.msdk.dycreator.binding.b.a().a(mBCommonViewVModel);
                mBCommonViewVModel.setModelDataAndBind();
                dynamicViewBackListener.viewCreatedSuccess(viewA);
            } catch (Exception e) {
                af.b("DynamicViewCreator", e.getMessage());
                dynamicViewBackListener.viewCreateFail(new a(f3299b, e.getMessage()));
            }
        }
    }

    public View createDynamicView(DyOption dyOption) {
        Context contextC;
        if (dyOption == null || (contextC = c.m().c()) == null) {
            return null;
        }
        return a(contextC, dyOption);
    }
}
