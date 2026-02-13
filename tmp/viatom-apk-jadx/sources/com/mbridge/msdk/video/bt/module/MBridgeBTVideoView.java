package com.mbridge.msdk.video.bt.module;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.dycreator.baseview.cusview.SoundImageView;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.ap;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener;
import com.mbridge.msdk.playercommon.PlayerErrorConstant;
import com.mbridge.msdk.playercommon.PlayerView;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.video.bt.a.d;
import com.mbridge.msdk.widget.FeedBackButton;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
import t3.b;
import t3.j;
import w3.f;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBridgeBTVideoView extends BTBaseView {
    private static boolean K = false;
    private static long Q;
    private b A;
    private t3.a B;
    private u3.b C;
    private a D;
    private int E;
    private int F;
    private boolean G;
    private int H;
    private int I;
    private String J;
    private boolean L;
    private boolean M;
    private boolean N;
    private RelativeLayout O;
    private ProgressBar P;

    /* renamed from: p, reason: collision with root package name */
    private PlayerView f5629p;

    /* renamed from: q, reason: collision with root package name */
    private SoundImageView f5630q;

    /* renamed from: r, reason: collision with root package name */
    private TextView f5631r;

    /* renamed from: s, reason: collision with root package name */
    private View f5632s;
    private FeedBackButton t;

    /* renamed from: u, reason: collision with root package name */
    private ImageView f5633u;

    /* renamed from: v, reason: collision with root package name */
    private WebView f5634v;

    /* renamed from: w, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.download.a f5635w;

    /* renamed from: x, reason: collision with root package name */
    private int f5636x;
    private int y;

    /* renamed from: z, reason: collision with root package name */
    private int f5637z;

    public MBridgeBTVideoView(Context context) {
        super(context);
        this.f5636x = 0;
        this.y = 0;
        this.f5637z = 0;
        this.E = 2;
        this.G = false;
        this.H = 2;
        this.I = 1;
        this.L = false;
        this.M = false;
        this.N = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(int i10, int i11) {
        if (i11 != 0) {
            try {
                return ak.a(Double.valueOf(i10 / i11)) + "";
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return i11 + "";
    }

    private boolean c() {
        try {
            this.f5629p = (PlayerView) findViewById(findID("mbridge_vfpv"));
            this.f5630q = (SoundImageView) findViewById(findID("mbridge_sound_switch"));
            this.f5631r = (TextView) findViewById(findID("mbridge_tv_count"));
            this.f5632s = findViewById(findID("mbridge_rl_playing_close"));
            this.O = (RelativeLayout) findViewById(findID("mbridge_top_control"));
            this.P = (ProgressBar) findViewById(findID("mbridge_video_progress_bar"));
            this.f5629p.setIsBTVideo(true);
            this.t = (FeedBackButton) findViewById(findID("mbridge_native_endcard_feed_btn"));
            this.f5633u = (ImageView) findViewById(findID("mbridge_iv_link"));
            return isNotNULL(this.f5629p, this.f5630q, this.f5631r, this.f5632s);
        } catch (Throwable th) {
            af.b(BTBaseView.TAG, th.getMessage(), th);
            return false;
        }
    }

    private String d() {
        String videoUrlEncode = "";
        try {
            videoUrlEncode = this.f5568b.getVideoUrlEncode();
            com.mbridge.msdk.videocommon.download.a aVar = this.f5635w;
            if (aVar != null) {
                String strH = aVar.h();
                if (!ap.a(strH)) {
                    if (new File(strH).exists()) {
                        return strH;
                    }
                }
            }
            return videoUrlEncode;
        } catch (Throwable th) {
            af.b(BTBaseView.TAG, th.getMessage(), th);
            return videoUrlEncode;
        }
    }

    private int e() {
        try {
            com.mbridge.msdk.videocommon.d.a aVarB = com.mbridge.msdk.videocommon.d.b.a().b();
            if (aVarB == null) {
                com.mbridge.msdk.videocommon.d.b.a().c();
            }
            iH = aVarB != null ? (int) aVarB.h() : 5;
            af.c(BTBaseView.TAG, "MBridgeBaseView buffetTimeout:" + iH);
            return iH;
        } catch (Throwable th) {
            th.printStackTrace();
            return iH;
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.BTBaseView
    public final void a() {
        super.a();
        if (this.h) {
            this.f5630q.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.bt.module.MBridgeBTVideoView.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws JSONException {
                    boolean zIsSilent = MBridgeBTVideoView.this.f5629p.isSilent();
                    if (MBridgeBTVideoView.this.f5634v != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("code", BTBaseView.f5565n);
                            jSONObject.put("id", MBridgeBTVideoView.this.f5570d);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(CampaignEx.JSON_NATIVE_VIDEO_MUTE, MBridgeBTVideoView.this.E);
                            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                            g.a().a(MBridgeBTVideoView.this.f5634v, "onPlayerMuteBtnClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                            af.a("OperateViews", "onPlayerMuteBtnClicked isMute = " + zIsSilent + " mute = " + MBridgeBTVideoView.this.E);
                        } catch (Exception e) {
                            d.c().a(MBridgeBTVideoView.this.f5634v, e.getMessage());
                        }
                    }
                }
            });
            this.f5632s.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.bt.module.MBridgeBTVideoView.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws JSONException {
                    if (MBridgeBTVideoView.this.f5634v != null) {
                        BTBaseView.a(MBridgeBTVideoView.this.f5634v, "onPlayerCloseBtnClicked", MBridgeBTVideoView.this.f5570d);
                    }
                }
            });
            setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.bt.module.MBridgeBTVideoView.3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws JSONException {
                    if (MBridgeBTVideoView.this.C != null) {
                        try {
                            MBridgeBTVideoView.this.C.a();
                            af.a("omsdk", "btv adUserInteraction click");
                        } catch (Exception e) {
                            af.b("omsdk", e.getMessage());
                        }
                    }
                    if (MBridgeBTVideoView.this.f5634v != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("code", BTBaseView.f5565n);
                            jSONObject.put("id", MBridgeBTVideoView.this.f5570d);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("x", String.valueOf(view.getX()));
                            jSONObject2.put("y", String.valueOf(view.getY()));
                            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                            g.a().a(MBridgeBTVideoView.this.f5634v, "onClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                        } catch (Exception unused) {
                            d.c().a(MBridgeBTVideoView.this.f5634v, "onClicked", MBridgeBTVideoView.this.f5570d);
                        }
                    }
                }
            });
        }
    }

    public t3.a getAdEvents() {
        return this.B;
    }

    public b getAdSession() {
        return this.A;
    }

    public int getMute() {
        return this.E;
    }

    public u3.b getVideoEvents() {
        return this.C;
    }

    @Override // com.mbridge.msdk.video.bt.module.BTBaseView
    public void init(Context context) {
        int iFindLayout = findLayout("mbridge_reward_videoview_item");
        if (iFindLayout > 0) {
            this.f.inflate(iFindLayout, this);
            boolean zC = c();
            this.h = zC;
            if (!zC) {
                af.b(BTBaseView.TAG, "MBridgeVideoView init fail");
            }
            a();
        }
        K = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        View rootView;
        super.onAttachedToWindow();
        if (!this.N) {
            this.H = d.c().e(this.f5569c);
        }
        View view = this.f5632s;
        if (view != null) {
            view.setVisibility(this.y == 0 ? 8 : 0);
        }
        SoundImageView soundImageView = this.f5630q;
        if (soundImageView != null) {
            soundImageView.setVisibility(this.f5637z == 0 ? 8 : 0);
        }
        CampaignEx campaignEx = this.f5568b;
        if (campaignEx != null) {
            campaignEx.setCampaignUnitId(this.f5569c);
            com.mbridge.msdk.foundation.d.b.a().a(a3.a.o(new StringBuilder(), this.f5569c, "_1"), this.f5568b);
        }
        TextView textView = this.f5631r;
        if (textView != null) {
            textView.setVisibility(this.f5636x == 0 ? 8 : 0);
            if (this.f5631r.getVisibility() == 0 && com.mbridge.msdk.foundation.d.b.a().b()) {
                com.mbridge.msdk.foundation.d.b.a().a(a3.a.o(new StringBuilder(), this.f5569c, "_1"), this.t);
            }
        }
        if (this.A == null || (rootView = getRootView()) == null) {
            return;
        }
        j jVar = (j) this.A;
        if (jVar.g) {
            return;
        }
        w3.g gVar = jVar.f12793c;
        gVar.getClass();
        int i10 = w3.g.f13507b;
        f fVarA = gVar.a(rootView);
        if (fVarA != null) {
            gVar.f13508a.remove(fVarA);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.BTBaseView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.mbridge.msdk.video.bt.module.BTBaseView
    public void onDestory() {
        try {
            if (this.f5629p != null) {
                b bVar = this.A;
                if (bVar != null) {
                    bVar.c();
                }
                this.f5629p.setOnClickListener(null);
                this.f5629p.release();
                this.f5629p = null;
                e eVar = new e();
                eVar.a(TypedValues.TransitionType.S_DURATION, Long.valueOf(System.currentTimeMillis() - Q));
                com.mbridge.msdk.foundation.same.report.d.d.a().a("2000146", this.f5568b, eVar);
            }
            SoundImageView soundImageView = this.f5630q;
            if (soundImageView != null) {
                soundImageView.setOnClickListener(null);
            }
            View view = this.f5632s;
            if (view != null) {
                view.setOnClickListener(null);
            }
            if (this.f5634v != null) {
                this.f5634v = null;
            }
            if (this.A != null) {
                this.A = null;
            }
            if (this.C != null) {
                this.C = null;
            }
            setOnClickListener(null);
        } catch (Throwable th) {
            af.a(BTBaseView.TAG, th.getMessage());
        }
    }

    public void onPause() {
        PlayerView playerView = this.f5629p;
        if (playerView != null) {
            boolean zIsPlayIng = playerView.isPlayIng();
            this.M = zIsPlayIng;
            this.f5629p.setIsBTVideoPlaying(zIsPlayIng);
            u3.b bVar = this.C;
            if (bVar != null) {
                this.f5629p.setVideoEvents(bVar);
            }
            this.f5629p.onPause();
        }
    }

    public void onResume() {
        PlayerView playerView = this.f5629p;
        if (playerView != null) {
            playerView.setDesk(true);
            this.f5629p.setIsCovered(false);
            if (this.M) {
                this.f5629p.start(true);
            }
            this.f5629p.resumeOMSDK();
        }
    }

    public void onStop() {
        PlayerView playerView = this.f5629p;
        if (playerView != null) {
            playerView.setIsCovered(true);
        }
    }

    public void pause() {
        try {
            PlayerView playerView = this.f5629p;
            if (playerView != null) {
                playerView.pause();
                WebView webView = this.f5634v;
                if (webView != null) {
                    BTBaseView.a(webView, "onPlayerPause", this.f5570d);
                }
            }
        } catch (Exception e) {
            af.b(BTBaseView.TAG, e.getMessage(), e);
        }
    }

    public void play() {
        a aVar;
        try {
            if (!this.N) {
                String strD = d();
                this.J = strD;
                this.f5629p.initVFPData(strD, this.f5568b.getVideoUrlEncode(), this.D);
                if (this.H == 1) {
                    playMute();
                } else {
                    playUnMute();
                }
                try {
                    if (this.B != null) {
                        af.b("omsdk", "bt impressionOccurred");
                        this.B.b();
                    }
                } catch (Throwable th) {
                    af.a(BTBaseView.TAG, th.getMessage());
                }
                if (!this.f5629p.playVideo() && (aVar = this.D) != null) {
                    aVar.onPlayError("play video failed");
                }
                this.N = true;
                return;
            }
            boolean z9 = this.G;
            PlayerView playerView = this.f5629p;
            if (z9) {
                playerView.playVideo(0);
                this.G = false;
            } else {
                playerView.start(false);
            }
            try {
                u3.b bVar = this.C;
                if (bVar != null) {
                    bVar.c();
                    af.a("omsdk", "btv play2:  videoEvents.resume()");
                }
            } catch (Throwable th2) {
                af.a(BTBaseView.TAG, th2.getMessage());
            }
            WebView webView = this.f5634v;
            if (webView != null) {
                BTBaseView.a(webView, "onPlayerPlay", this.f5570d);
                return;
            }
            return;
        } catch (Exception e) {
            af.b(BTBaseView.TAG, e.getMessage(), e);
        }
        af.b(BTBaseView.TAG, e.getMessage(), e);
    }

    public boolean playMute() {
        try {
            PlayerView playerView = this.f5629p;
            if (playerView != null && this.f5634v != null) {
                playerView.closeSound();
                this.f5630q.setSoundStatus(false);
                this.E = 1;
                try {
                    u3.b bVar = this.C;
                    if (bVar != null) {
                        bVar.f(0.0f);
                    }
                } catch (Exception e) {
                    af.a("OMSDK", e.getMessage());
                }
                BTBaseView.a(this.f5634v, "onPlayerMute", this.f5570d);
                return true;
            }
        } catch (Exception e3) {
            af.b(BTBaseView.TAG, e3.getMessage());
        }
        return false;
    }

    public boolean playUnMute() {
        try {
            PlayerView playerView = this.f5629p;
            if (playerView == null || this.f5634v == null) {
                return false;
            }
            playerView.openSound();
            this.f5630q.setSoundStatus(true);
            this.E = 2;
            try {
                u3.b bVar = this.C;
                if (bVar != null) {
                    bVar.f(1.0f);
                }
            } catch (Exception e) {
                af.a("OMSDK", e.getMessage());
            }
            BTBaseView.a(this.f5634v, "onUnmute", this.f5570d);
            return true;
        } catch (Exception e3) {
            af.b(BTBaseView.TAG, e3.getMessage());
            return false;
        }
    }

    public void preLoadData() {
        String str;
        if (this.f5568b.getAdType() == 94 || this.f5568b.getAdType() == 287) {
            str = this.f5568b.getRequestId() + this.f5568b.getId() + this.f5568b.getVideoUrlEncode();
        } else {
            str = this.f5568b.getId() + this.f5568b.getVideoUrlEncode() + this.f5568b.getBidToken();
        }
        com.mbridge.msdk.videocommon.download.a aVarA = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.f5569c, str);
        if (aVarA != null) {
            this.f5635w = aVarA;
        }
        this.F = e();
        String strD = d();
        this.J = strD;
        if (this.h && !TextUtils.isEmpty(strD) && this.f5568b != null) {
            b bVar = this.A;
            if (bVar != null) {
                bVar.d(this.f5629p);
                b bVar2 = this.A;
                SoundImageView soundImageView = this.f5630q;
                t3.e eVar = t3.e.f12778d;
                bVar2.a(soundImageView, eVar);
                this.A.a(this.f5631r, eVar);
                this.A.a(this.f5632s, t3.e.f12775a);
            }
            a aVar = new a(this, this.f5634v, this.C);
            this.D = aVar;
            CampaignEx campaignEx = this.f5568b;
            int iR = (campaignEx == null || campaignEx.getReady_rate() == -1) ? com.mbridge.msdk.videocommon.d.b.a().a(c.m().k(), this.f5569c, false).r() : campaignEx.getReady_rate();
            aVar.a(iR, com.mbridge.msdk.videocommon.d.b.a().a(c.m().k(), this.f5569c, false).s());
            this.f5629p.setDesk(false);
            this.f5629p.initBufferIngParam(this.F);
            soundOperate(this.E, -1, null);
        }
        K = false;
    }

    public void resume() {
        try {
            PlayerView playerView = this.f5629p;
            if (playerView != null) {
                if (this.G) {
                    playerView.playVideo(0);
                    this.G = false;
                } else {
                    playerView.onResume();
                }
                try {
                    u3.b bVar = this.C;
                    if (bVar != null) {
                        bVar.c();
                        af.a("omsdk", "btv play3:  videoEvents.resume()");
                    }
                } catch (Throwable th) {
                    af.a(BTBaseView.TAG, th.getMessage());
                }
                WebView webView = this.f5634v;
                if (webView != null) {
                    BTBaseView.a(webView, "onPlayerResume", this.f5570d);
                }
            }
        } catch (Exception e) {
            af.b(BTBaseView.TAG, e.getMessage());
        }
    }

    public void setAdEvents(t3.a aVar) {
        this.B = aVar;
    }

    public void setAdSession(b bVar) {
        this.A = bVar;
    }

    @Override // com.mbridge.msdk.video.bt.module.BTBaseView
    public void setCampaign(CampaignEx campaignEx) {
        super.setCampaign(campaignEx);
        if (campaignEx == null || campaignEx.getVideoCompleteTime() <= 0) {
            this.f5631r.setBackgroundResource(x.a(c.m().c(), "mbridge_reward_shape_progress", "drawable"));
            this.f5631r.setWidth(ak.a(c.m().c(), 30.0f));
            return;
        }
        this.f5631r.setBackgroundResource(x.a(c.m().c(), "mbridge_reward_video_time_count_num_bg", "drawable"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.mbridge.msdk.dycreator.baseview.a.e(30.0f));
        int iA = ak.a(c.m().c(), 5.0f);
        layoutParams.setMargins(iA, 0, 0, 0);
        this.f5631r.setPadding(iA, 0, iA, 0);
        this.f5631r.setLayoutParams(layoutParams);
    }

    public void setCloseViewVisable(int i10) {
        this.f5632s.setVisibility(i10 == 0 ? 4 : 0);
    }

    public void setCountDownTextViewVisable(int i10) {
        this.f5631r.setVisibility(i10 == 0 ? 4 : 0);
    }

    public void setCreateWebView(WebView webView) {
        this.f5634v = webView;
    }

    public void setNotchPadding(int i10, int i11, int i12, int i13) {
        if (i10 <= 0) {
            i10 = this.O.getPaddingLeft();
        }
        if (i11 <= 0) {
            i11 = this.O.getPaddingRight();
        }
        if (i12 <= 0) {
            i12 = this.O.getPaddingTop();
        }
        if (i13 <= 0) {
            i13 = this.O.getPaddingBottom();
        }
        af.b(BTBaseView.TAG, "NOTCH BTVideoView ".concat(String.format("%1s-%2s-%3s-%4s", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13))));
        this.O.setPadding(i10, i12, i11, i13);
    }

    public void setOrientation(int i10) {
        this.I = i10;
    }

    public void setPlaybackParams(float f) {
        PlayerView playerView = this.f5629p;
        if (playerView != null) {
            playerView.setPlaybackParams(f);
        }
    }

    public void setProgressBarState(int i10) {
        ProgressBar progressBar = this.P;
        if (progressBar != null) {
            progressBar.setVisibility(i10 == 0 ? 8 : 0);
            CampaignEx campaignEx = this.f5568b;
            if (campaignEx == null || campaignEx.getProgressBarShow() != 1) {
                return;
            }
            this.P.setVisibility(0);
        }
    }

    public void setShowClose(int i10) {
        this.y = i10;
    }

    public void setShowMute(int i10) {
        this.f5637z = i10;
    }

    public void setShowTime(int i10) {
        this.f5636x = i10;
    }

    public void setSoundImageViewVisble(int i10) {
        this.f5630q.setVisibility(i10 == 0 ? 4 : 0);
    }

    public void setVideoEvents(u3.b bVar) {
        this.C = bVar;
        a aVar = this.D;
        if (aVar != null) {
            aVar.f5643c = bVar;
        }
        PlayerView playerView = this.f5629p;
        if (playerView != null) {
            playerView.setVideoEvents(bVar);
        }
    }

    public void setVolume(float f, float f10) {
        PlayerView playerView = this.f5629p;
        if (playerView != null) {
            playerView.setVolume(f, f10);
        }
    }

    public void soundOperate(int i10, int i11, String str) {
        if (this.h) {
            this.E = i10;
            if (i10 == 1) {
                this.f5630q.setSoundStatus(false);
                this.f5629p.closeSound();
            } else if (i10 == 2) {
                this.f5630q.setSoundStatus(true);
                this.f5629p.openSound();
            }
            if (i11 == 1) {
                this.f5630q.setVisibility(8);
            } else if (i11 == 2) {
                this.f5630q.setVisibility(0);
            }
            u3.b bVar = this.C;
            if (bVar != null) {
                try {
                    bVar.f(this.f5629p.getVolume());
                } catch (Exception e) {
                    af.b("omsdk", e.getMessage());
                }
            }
        }
    }

    public void stop() {
        try {
            PlayerView playerView = this.f5629p;
            if (playerView != null) {
                playerView.pause();
                this.f5629p.stop();
                this.G = true;
                WebView webView = this.f5634v;
                if (webView != null) {
                    BTBaseView.a(webView, "onPlayerStop", this.f5570d);
                }
            }
        } catch (Exception e) {
            af.b(BTBaseView.TAG, e.getMessage(), e);
        }
    }

    public MBridgeBTVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5636x = 0;
        this.y = 0;
        this.f5637z = 0;
        this.E = 2;
        this.G = false;
        this.H = 2;
        this.I = 1;
        this.L = false;
        this.M = false;
        this.N = false;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class a extends DefaultVideoPlayerStatusListener {

        /* renamed from: a, reason: collision with root package name */
        private MBridgeBTVideoView f5641a;

        /* renamed from: b, reason: collision with root package name */
        private WebView f5642b;

        /* renamed from: c, reason: collision with root package name */
        private u3.b f5643c;

        /* renamed from: d, reason: collision with root package name */
        private String f5644d;
        private String e;
        private int f;
        private int g;
        private boolean h;

        /* renamed from: l, reason: collision with root package name */
        private int f5648l;

        /* renamed from: m, reason: collision with root package name */
        private int f5649m;

        /* renamed from: i, reason: collision with root package name */
        private boolean f5645i = false;

        /* renamed from: j, reason: collision with root package name */
        private boolean f5646j = false;

        /* renamed from: k, reason: collision with root package name */
        private boolean f5647k = false;

        /* renamed from: n, reason: collision with root package name */
        private boolean f5650n = false;

        /* renamed from: o, reason: collision with root package name */
        private boolean f5651o = false;

        public a(MBridgeBTVideoView mBridgeBTVideoView, WebView webView, u3.b bVar) {
            this.f5641a = mBridgeBTVideoView;
            this.f5642b = webView;
            this.f5643c = bVar;
            if (mBridgeBTVideoView != null) {
                this.f5644d = mBridgeBTVideoView.f5570d;
                this.e = mBridgeBTVideoView.f5569c;
            }
        }

        public final void a(int i10, int i11) {
            int i12;
            MBridgeBTVideoView mBridgeBTVideoView;
            CampaignEx campaignEx;
            String str;
            this.f5648l = i10;
            this.f5649m = i11;
            if (!ah.a().a("h_c_r_w_p_c", false) || (i12 = this.f5648l) == 100 || this.f5649m != 0 || this.f5650n || i12 == 0 || (mBridgeBTVideoView = this.f5641a) == null || (campaignEx = mBridgeBTVideoView.f5568b) == null) {
                return;
            }
            try {
                if (campaignEx.getAdType() == 94 || this.f5641a.f5568b.getAdType() == 287) {
                    str = this.f5641a.f5568b.getRequestId() + this.f5641a.f5568b.getId() + this.f5641a.f5568b.getVideoUrlEncode();
                } else {
                    str = this.f5641a.f5568b.getId() + this.f5641a.f5568b.getVideoUrlEncode() + this.f5641a.f5568b.getBidToken();
                }
                com.mbridge.msdk.videocommon.download.a aVarA = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.e, str);
                if (aVarA != null) {
                    aVarA.p();
                    this.f5650n = true;
                    if (MBridgeConstans.DEBUG) {
                        af.b("DefaultVideoPlayerStatusListener", "CDRate is : 0  and start download when player create!");
                    }
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    af.b("DefaultVideoPlayerStatusListener", e.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public final void onBufferingEnd() {
            try {
                super.onBufferingEnd();
                if (this.f5643c == null || !this.f5651o) {
                    return;
                }
                af.b("omsdk", "bt onBufferingEnd");
                this.f5651o = false;
                j jVar = this.f5643c.f12887a;
                t1.d(jVar);
                jVar.e.a("bufferFinish", null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public final void onBufferingStart(String str) throws JSONException {
            try {
                af.b("omsdk", "bt onBufferingStart1");
                super.onBufferingStart(str);
                if (this.f5643c != null) {
                    af.b("omsdk", "bt onBufferingStart");
                    j jVar = this.f5643c.f12887a;
                    t1.d(jVar);
                    jVar.e.a("bufferStart", null);
                    this.f5651o = true;
                }
                if ((str.equals(PlayerErrorConstant.PREPARE_TIMEOUT) || str.equals(PlayerErrorConstant.PLAYERING_TIMEOUT)) && this.f5642b != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", BTBaseView.f5565n);
                        jSONObject.put("id", this.f5644d);
                        jSONObject.put(DataSchemeDataSource.SCHEME_DATA, new JSONObject());
                        g.a().a(this.f5642b, "onPlayerTimeout", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e) {
                        d.c().a(this.f5642b, e.getMessage());
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public final void onPlayCompleted() throws JSONException {
            super.onPlayCompleted();
            MBridgeBTVideoView mBridgeBTVideoView = this.f5641a;
            CampaignEx campaignEx = mBridgeBTVideoView.f5568b;
            if (campaignEx != null) {
                int videoCompleteTime = campaignEx.getVideoCompleteTime();
                MBridgeBTVideoView mBridgeBTVideoView2 = this.f5641a;
                if (videoCompleteTime > 0) {
                    mBridgeBTVideoView2.f5631r.setText(x.a(c.m().c(), "mbridge_reward_video_view_reward_time_complete", TypedValues.Custom.S_STRING));
                } else {
                    mBridgeBTVideoView2.f5631r.setText("0");
                }
            } else {
                mBridgeBTVideoView.f5631r.setText("0");
            }
            this.f5641a.f5629p.setClickable(false);
            WebView webView = this.f5642b;
            if (webView != null) {
                BTBaseView.a(webView, "onPlayerFinish", this.f5644d);
            }
            u3.b bVar = this.f5643c;
            if (bVar != null) {
                j jVar = bVar.f12887a;
                t1.d(jVar);
                jVar.e.a(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE, null);
                af.a("omsdk", "play:  videoEvents.complete()");
            }
            this.f = this.g;
            boolean unused = MBridgeBTVideoView.K = true;
            this.f5641a.stop();
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public final void onPlayError(String str) throws JSONException {
            super.onPlayError(str);
            if (this.f5642b != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", BTBaseView.f5566o);
                    jSONObject.put("id", this.f5644d);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, str);
                    jSONObject2.put("id", this.f5644d);
                    jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                    g.a().a(this.f5642b, "onPlayerFailed", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e) {
                    d.c().a(this.f5642b, e.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public final void onPlayProgress(int i10, int i11) throws JSONException {
            int i12;
            int i13;
            String str;
            int videoCompleteTime;
            StringBuilder sb;
            String str2;
            String string;
            super.onPlayProgress(i10, i11);
            if (MBridgeBTVideoView.Q == 0) {
                long unused = MBridgeBTVideoView.Q = System.currentTimeMillis();
            }
            MBridgeBTVideoView mBridgeBTVideoView = this.f5641a;
            if (mBridgeBTVideoView.h) {
                CampaignEx campaignEx = mBridgeBTVideoView.f5568b;
                if (campaignEx != null) {
                    videoCompleteTime = campaignEx.getVideoCompleteTime();
                    com.mbridge.msdk.foundation.d.b.a().b(this.f5641a.f5568b.getCampaignUnitId() + "_1", i10);
                } else {
                    videoCompleteTime = 0;
                }
                if (videoCompleteTime > i11 || videoCompleteTime <= 0) {
                    videoCompleteTime = i11;
                }
                int i14 = videoCompleteTime <= 0 ? i11 - i10 : videoCompleteTime - i10;
                if (i14 <= 0) {
                    string = videoCompleteTime <= 0 ? "0" : (String) this.f5641a.getContext().getResources().getText(x.a(c.m().c(), "mbridge_reward_video_view_reward_time_complete", TypedValues.Custom.S_STRING));
                } else {
                    if (videoCompleteTime <= 0) {
                        sb = new StringBuilder();
                        sb.append(i14);
                        str2 = "";
                    } else {
                        sb = new StringBuilder();
                        sb.append(i14);
                        str2 = (String) this.f5641a.getContext().getResources().getText(x.a(c.m().c(), "mbridge_reward_video_view_reward_time_left", TypedValues.Custom.S_STRING));
                    }
                    sb.append(str2);
                    string = sb.toString();
                }
                CampaignEx campaignEx2 = this.f5641a.f5568b;
                if (campaignEx2 != null && campaignEx2.getUseSkipTime() == 1) {
                    int iMin = Math.min(this.f5641a.f5568b.getVst(), i11);
                    if (iMin >= videoCompleteTime || iMin < 0) {
                        int i15 = videoCompleteTime - i10;
                        if (this.f5641a.f5568b.getAdType() == 287) {
                            if (i15 > 0) {
                                string = i15 + ((String) this.f5641a.getContext().getResources().getText(x.a(c.m().c(), "mbridge_reward_video_view_reward_time_left_skip_time", TypedValues.Custom.S_STRING)));
                            } else if (i15 == 0) {
                                this.f5641a.f5631r.setVisibility(4);
                            }
                        }
                    } else {
                        int i16 = iMin - i10;
                        if (i16 > 0) {
                            string = i16 + ((String) this.f5641a.getContext().getResources().getText(x.a(c.m().c(), "mbridge_reward_video_view_reward_time_left_skip_time", TypedValues.Custom.S_STRING)));
                        } else if (this.f5641a.f5568b.getAdType() == 287 && i16 == 0) {
                            this.f5641a.f5631r.setVisibility(4);
                        }
                    }
                }
                this.f5641a.f5631r.setText(string);
            }
            this.g = i11;
            this.f = i10;
            this.f5641a.P.setMax(this.g);
            this.f5641a.P.setProgress(this.f);
            if (this.f5642b != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", BTBaseView.f5565n);
                    jSONObject.put("id", this.f5644d);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("id", this.f5644d);
                    jSONObject2.put("progress", MBridgeBTVideoView.b(i10, i11));
                    jSONObject2.put("time", String.valueOf(i10));
                    jSONObject2.put(TypedValues.TransitionType.S_DURATION, String.valueOf(i11));
                    jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                    g.a().a(this.f5642b, "onPlayerProgressChanged", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e) {
                    d.c().a(this.f5642b, e.getMessage());
                }
            }
            u3.b bVar = this.f5643c;
            if (bVar != null) {
                j jVar = bVar.f12887a;
                int i17 = (i10 * 100) / i11;
                int i18 = ((i10 + 1) * 100) / i11;
                if (i17 <= 25 && 25 < i18 && !this.f5645i) {
                    this.f5645i = true;
                    t1.d(jVar);
                    jVar.e.a("firstQuartile", null);
                    af.a("omsdk", "play:  videoEvents.firstQuartile()");
                } else if (i17 <= 50 && 50 < i18 && !this.f5646j) {
                    this.f5646j = true;
                    t1.d(jVar);
                    jVar.e.a(CampaignEx.JSON_NATIVE_VIDEO_MIDPOINT, null);
                    af.a("omsdk", "play:  videoEvents.midpoint()");
                } else if (i17 <= 75 && 75 < i18 && !this.f5647k) {
                    this.f5647k = true;
                    t1.d(jVar);
                    jVar.e.a("thirdQuartile", null);
                    af.a("omsdk", "play:  videoEvents.thirdQuartile()");
                }
            }
            try {
                int i19 = this.f5648l;
                if (i19 == 100 || this.f5650n || i19 == 0 || (i12 = this.f5649m) < 0 || i10 < (i13 = (i11 * i12) / 100)) {
                    return;
                }
                if (this.f5641a.f5568b.getAdType() == 94 || this.f5641a.f5568b.getAdType() == 287) {
                    str = this.f5641a.f5568b.getRequestId() + this.f5641a.f5568b.getId() + this.f5641a.f5568b.getVideoUrlEncode();
                } else {
                    str = this.f5641a.f5568b.getId() + this.f5641a.f5568b.getVideoUrlEncode() + this.f5641a.f5568b.getBidToken();
                }
                com.mbridge.msdk.videocommon.download.a aVarA = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.e, str);
                if (aVarA != null) {
                    aVarA.p();
                    this.f5650n = true;
                    af.b("DefaultVideoPlayerStatusListener", "CDRate is : " + i13 + " and start download !");
                }
            } catch (Exception e3) {
                af.b("DefaultVideoPlayerStatusListener", e3.getMessage());
            }
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public final void onPlaySetDataSourceError(String str) {
            super.onPlaySetDataSourceError(str);
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public final void onPlayStarted(int i10) throws JSONException {
            super.onPlayStarted(i10);
            if (!this.h) {
                this.f5641a.P.setMax(i10);
                WebView webView = this.f5642b;
                if (webView != null) {
                    BTBaseView.a(webView, "onPlayerPlay", this.f5644d);
                }
                this.h = true;
                if (this.f5643c != null) {
                    try {
                        MBridgeBTVideoView mBridgeBTVideoView = this.f5641a;
                        this.f5643c.e(i10, (mBridgeBTVideoView == null || mBridgeBTVideoView.f5629p == null) ? 0.0f : this.f5641a.f5629p.getVolume());
                        af.a("omsdk", "play2: videoEvents.start()");
                    } catch (Exception e) {
                        af.b("omsdk", e.getMessage());
                    }
                }
            }
            boolean unused = MBridgeBTVideoView.K = false;
        }
    }
}
