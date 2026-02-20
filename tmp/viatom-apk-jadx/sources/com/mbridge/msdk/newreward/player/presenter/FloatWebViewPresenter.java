package com.mbridge.msdk.newreward.player.presenter;

import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.d.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.newout.RewardVideoListener;
import com.mbridge.msdk.newreward.a.b.b;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.player.iview.IBaseWebView;
import com.mbridge.msdk.newreward.player.model.BaseWebContentModel;
import com.mbridge.msdk.newreward.player.redirect.RedirectType;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MBCommunicatorUtil;
import com.mbridge.msdk.widget.MBAdChoice;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class FloatWebViewPresenter extends AbsPresenter implements b {
    final int EXPAND_VIEW_BUILD_TYPE;
    final int MINI_CARD_BUILD_TYPE;
    private final String TAG;
    boolean isLoadResourceError;
    boolean isShown;
    Handler mHandler;
    IBaseWebView mWebContentView;
    int muteState;
    public Runnable nativeCloseBtnVisibleRunnable;
    int webCloseViewStatus;
    BaseWebContentModel webContentModel;

    public FloatWebViewPresenter(IBaseWebView iBaseWebView, int i10) {
        super(iBaseWebView);
        this.TAG = "MiniCardPresenter";
        this.webCloseViewStatus = -1;
        this.muteState = -1;
        this.isLoadResourceError = false;
        this.isShown = false;
        this.MINI_CARD_BUILD_TYPE = 3;
        this.EXPAND_VIEW_BUILD_TYPE = 4;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.nativeCloseBtnVisibleRunnable = new Runnable() { // from class: com.mbridge.msdk.newreward.player.presenter.FloatWebViewPresenter.1
            @Override // java.lang.Runnable
            public void run() {
                FloatWebViewPresenter floatWebViewPresenter = FloatWebViewPresenter.this;
                if (floatWebViewPresenter.webCloseViewStatus != -1) {
                    return;
                }
                floatWebViewPresenter.mWebContentView.setNativeCloseButtonVisibility(0);
            }
        };
        this.mWebContentView = iBaseWebView;
        BaseWebContentModel baseWebContentModel = new BaseWebContentModel();
        this.webContentModel = baseWebContentModel;
        baseWebContentModel.setCommandManager(this.commandManager);
        this.webContentModel.setAdapterModel(this.adapterModel);
        this.webContentModel.setCallbackListener(this);
        this.TEMPLATE_MARK_TYPE = i10 != 273 ? 5 : 4;
    }

    private void addAdChoice() {
        try {
            CampaignEx campaignEx = this.campaignEx;
            if (campaignEx == null || campaignEx.getPrivacyButtonTemplateVisibility() == 0) {
                return;
            }
            MBAdChoice mBAdChoice = new MBAdChoice(c.m().c());
            mBAdChoice.setCampaign(this.campaignEx);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ak.a(c.m().c(), 12.0f), ak.a(c.m().c(), 12.0f));
            layoutParams.gravity = 8388693;
            layoutParams.bottomMargin = 30;
            layoutParams.rightMargin = 30;
            mBAdChoice.setLayoutParams(layoutParams);
            mBAdChoice.setFeedbackDialogEventListener(new a() { // from class: com.mbridge.msdk.newreward.player.presenter.FloatWebViewPresenter.2
                @Override // com.mbridge.msdk.foundation.d.a
                public void close() {
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public void showed() {
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public void summit(String str) {
                }
            });
            this.mWebContentView.addViewToCurrentViewGroup(mBAdChoice);
        } catch (Throwable th) {
            af.b("MiniCardPresenter", th.getMessage());
        }
    }

    private void addWaterMark(String str) {
        try {
            BitmapDrawable bitmapDrawableA = c.m().a(str, 296);
            if (bitmapDrawableA != null) {
                ImageView imageView = new ImageView(c.m().c());
                imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                ak.a(imageView, bitmapDrawableA, this.mWebContentView.getWebView().getResources().getDisplayMetrics());
                this.mWebContentView.addViewToCurrentViewGroup(imageView);
            }
        } catch (Throwable th) {
            af.b("MiniCardPresenter", th.getMessage());
        }
    }

    private void render(String str) {
        if (TextUtils.isEmpty(str) || this.mWebContentView.getWebView() == null) {
            return;
        }
        this.mWebContentView.getWebView().setHybridCommunicator(this.webContentModel);
        this.mWebContentView.getWebView().setWebViewEventListener(this.webContentModel);
        this.mWebContentView.getWebView().loadUrl(str);
    }

    public void changeNativeCloseButton() {
        int cbd = this.adapterModel.U().getCbd();
        if (cbd < 0) {
            cbd = this.adapterModel.x().b().p();
        }
        this.mHandler.postDelayed(this.nativeCloseBtnVisibleRunnable, cbd * 1000);
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void click(View view) {
        IBaseWebView iBaseWebView = this.mWebContentView;
        if (iBaseWebView != null) {
            iBaseWebView.removeTempleFromSuperView(null);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void finish(boolean z9) {
        this.mWebContentView.onDestroyWebContent(this.TEMPLATE_MARK_TYPE);
    }

    public int getCampaignOrientation() {
        try {
            if (this.adapterModel.U() != null) {
                return this.adapterModel.U().getRewardTemplateMode().b();
            }
            return 0;
        } catch (Throwable th) {
            af.b("MiniCardPresenter", th.getMessage());
            return 0;
        }
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void getView() {
        initDataForView(null);
    }

    public String getWebViewShowExtraData() throws JSONException {
        if (this.reward == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(RewardPlus.NAME, this.reward.a());
            jSONObject2.put(RewardPlus.AMOUNT, this.reward.b());
            jSONObject2.put("id", "");
            jSONObject.put("userId", "");
            jSONObject.put("reward", jSONObject2);
            jSONObject.put("playVideoMute", this.muteState);
            jSONObject.put("extra", this.adapterModel.W());
            return jSONObject.toString();
        } catch (JSONException e) {
            com.google.gson.internal.a.j(e);
            return null;
        }
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void initDataForView(com.mbridge.msdk.video.dynview.a aVar) {
        this.mWebContentView.initViews(false);
        addWaterMark(this.adapterModel.H());
        addAdChoice();
    }

    public void onActivityLifeCycleCallback(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.getClass();
        switch (str) {
            case "onDestroy":
                str2 = "onSystemDestory";
                break;
            case "onPause":
                str2 = "onSystemPause";
                break;
            case "onBackPressed":
                str2 = "onSystemBackPressed";
                break;
            case "onResume":
                str2 = "onSystemResume";
                break;
            default:
                str2 = "";
                break;
        }
        if (!TextUtils.isEmpty(str2)) {
            MBCommunicatorUtil.fireEvent(this.mWebContentView.getWebView(), str2, "");
        }
        if (str.equals("onBackPressed") && this.isShown) {
            click(null);
        }
    }

    public void onDetachedFromWindow() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void onShown() {
        this.isShown = true;
    }

    public void onWebContentError() {
        if (this.isLoadResourceError) {
            return;
        }
        this.isLoadResourceError = true;
        this.mWebContentView.onDestroyWebContent(this.TEMPLATE_MARK_TYPE);
        this.mWebContentView.removeTempleFromSuperView(this.data.getRootViewGroup());
    }

    public void renderMRAID(String str) {
        CampaignEx campaignEx;
        try {
            if (TextUtils.isEmpty(str) && (campaignEx = this.campaignEx) != null && !TextUtils.isEmpty(campaignEx.getMraid())) {
                str = "file:////" + this.campaignEx.getMraid();
            }
            render(str);
        } catch (Throwable th) {
            af.b("MiniCardPresenter", th.getMessage());
        }
    }

    public void renderPauseUrl() {
        try {
            if (this.adapterModel.U() != null) {
                String strV = this.adapterModel.V();
                String strI = "";
                if (!TextUtils.isEmpty(strV)) {
                    Iterator<com.mbridge.msdk.newreward.function.c.a.a> it = this.adapterModel.D().b().u().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        com.mbridge.msdk.newreward.function.c.a.a next = it.next();
                        if (next.g().equals(strV)) {
                            strI = next.a().i();
                            break;
                        }
                    }
                }
                render(strI);
            }
        } catch (Throwable th) {
            af.b("MiniCardPresenter", th.getMessage());
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.mbridge.msdk.newreward.a.b.b
    public void reqSuccessful(Object obj) {
        try {
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() > 0) {
                    String string = jSONObject.getString("action");
                    int i10 = 0;
                    switch (string.hashCode()) {
                        case -1765453640:
                            if (string.equals("toggleCloseBtn")) {
                                int iOptInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS, 1);
                                this.webCloseViewStatus = iOptInt;
                                IBaseWebView iBaseWebView = this.mWebContentView;
                                if (iOptInt != 1) {
                                    i10 = 4;
                                }
                                iBaseWebView.setNativeCloseButtonVisibility(i10);
                                break;
                            }
                            break;
                        case -1488920312:
                            if (string.equals("onReceivedError")) {
                                onWebContentError();
                                break;
                            }
                            break;
                        case -505277536:
                            if (string.equals("onPageFinished")) {
                                this.mWebContentView.onWebViewShow(this.TEMPLATE_MARK_TYPE);
                                break;
                            }
                            break;
                        case 94750088:
                            if (string.equals(CampaignEx.JSON_NATIVE_VIDEO_CLICK)) {
                                com.mbridge.msdk.newreward.function.command.c cVar = this.commandManager;
                                cVar.f(cVar.a("campaign_redirect", this.redirectModel.setRedirectType(RedirectType.AD_TRACKING_CLICK_URL)), f.CAMPAIGN_REDIRECT);
                                RewardVideoListener rewardVideoListener = this.rewardVideoListener;
                                if (rewardVideoListener != null) {
                                    rewardVideoListener.onVideoAdClicked(this.mBridgeIds);
                                    break;
                                }
                            }
                            break;
                        case 94756344:
                            if (string.equals(CampaignEx.JSON_NATIVE_VIDEO_CLOSE)) {
                                this.mWebContentView.onCloseViewClick(3);
                                break;
                            }
                            break;
                        case 96046965:
                            if (string.equals("readyStatus")) {
                                if (jSONObject.optInt(NotificationCompat.CATEGORY_STATUS, 1) != 1) {
                                    onWebContentError();
                                    break;
                                } else {
                                    this.mWebContentView.onWebViewShow(this.TEMPLATE_MARK_TYPE);
                                    break;
                                }
                            }
                            break;
                    }
                }
            }
        } catch (Throwable th) {
            af.b("MiniCardPresenter", th.getMessage());
        }
    }

    public void setNotchData(String str) {
        this.webContentModel.sendNotchData(this.mWebContentView.getWebView(), str);
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void releaseSource() {
    }

    @Override // com.mbridge.msdk.newreward.a.b.b
    public void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
    }
}
