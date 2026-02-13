package com.mbridge.msdk.newreward.player.view.floatview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.newreward.player.presenter.AbsPresenter;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class AlertTempleView extends FrameLayout {
    public static final int TYPE_IV = 0;
    public static final int TYPE_PL = 2;
    public static final int TYPE_RV = 1;
    private final String TAG;
    private final View.OnClickListener buttonClickListener;
    String closeBtnText;
    Button closeButton;
    String content;
    TextView contentView;
    String continueBtnText;
    Button continueButton;
    public AbsPresenter mPresenter;
    String title;
    TextView titleView;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface AlertType {
    }

    public AlertTempleView(@NonNull Context context, AbsPresenter absPresenter) {
        super(context);
        this.TAG = "AlertTempleView";
        this.title = "";
        this.content = "";
        this.closeBtnText = "";
        this.continueBtnText = "";
        this.buttonClickListener = new View.OnClickListener() { // from class: com.mbridge.msdk.newreward.player.view.floatview.AlertTempleView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AbsPresenter absPresenter2 = AlertTempleView.this.mPresenter;
                if (absPresenter2 != null) {
                    absPresenter2.click(view);
                }
            }
        };
        this.mPresenter = absPresenter;
        initView();
    }

    private void initView() {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setBackgroundColor(-1073741824);
        setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.newreward.player.view.floatview.AlertTempleView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        View viewInflate = LayoutInflater.from(getContext()).inflate(x.a(getContext(), "mbridge_alertview_layout", TtmlNode.TAG_LAYOUT), (ViewGroup) this, true);
        if (viewInflate != null) {
            this.titleView = (TextView) viewInflate.findViewById(x.a(getContext(), "mbridge_alertview_titleview", "id"));
            this.contentView = (TextView) viewInflate.findViewById(x.a(getContext(), "mbridge_alertview_contentview", "id"));
            this.closeButton = (Button) viewInflate.findViewById(x.a(getContext(), "mbridge_alertview_close_button", "id"));
            this.continueButton = (Button) viewInflate.findViewById(x.a(getContext(), "mbridge_alertview_continue_button", "id"));
            this.closeButton.setOnClickListener(this.buttonClickListener);
            this.continueButton.setOnClickListener(this.buttonClickListener);
        }
    }

    private void setIVAlertViewContent(int i10, String str) {
        try {
            this.title = an.a(getContext(), "MBridge_ConfirmTitle" + str, "").toString();
            this.content = an.a(getContext(), "MBridge_ConfirmContent" + str, "").toString();
            this.continueBtnText = an.a(getContext(), "MBridge_CancelText" + str, "").toString();
            this.closeBtnText = an.a(getContext(), "MBridge_ConfirmText" + str, "").toString();
        } catch (Exception e) {
            af.a("AlertTempleView", e.getMessage());
        }
        if (TextUtils.isEmpty(this.title) && TextUtils.isEmpty(this.content) && TextUtils.isEmpty(this.closeBtnText) && TextUtils.isEmpty(this.continueBtnText)) {
            String language = Locale.getDefault().getLanguage();
            if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                int i11 = a.H;
                this.title = i10 == i11 ? "Confirm" : "Tips";
                this.content = i10 == i11 ? "If you choose to continue, you will receive a reward after the end. Confirm closed?" : "If you choose to continue, you will receive a reward after the end. Whether to continue?";
                this.continueBtnText = "Continue";
                this.closeBtnText = i10 == i11 ? "Close" : "Cancel";
            } else {
                int i12 = a.H;
                this.title = i10 == i12 ? "确认关闭？" : "提示";
                this.content = i10 == i12 ? "如果你选择继续，结束后将会获得奖励。确认关闭吗？" : "如果你选择继续，结束后将会获得奖励。是否继续？";
                this.continueBtnText = "继续";
                this.closeBtnText = i10 == i12 ? "确认关闭" : "取消";
            }
        }
        setViewContent(this.title, this.content, this.closeBtnText, this.continueBtnText);
    }

    private void setPlayableAlertViewContent() {
        g gVarS = androidx.constraintlayout.core.widgets.analyzer.a.s(h.a());
        this.title = gVarS.z();
        this.content = gVarS.x();
        this.continueBtnText = gVarS.v();
        this.closeBtnText = gVarS.y();
        String language = Locale.getDefault().getLanguage();
        if (TextUtils.isEmpty(this.title) && TextUtils.isEmpty(this.content) && TextUtils.isEmpty(this.closeBtnText) && TextUtils.isEmpty(this.continueBtnText)) {
            if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                this.title = "Confirm to close? ";
                this.content = "You will not be rewarded after closing the window";
                this.closeBtnText = "Close it";
                this.continueBtnText = "Continue";
            } else {
                this.title = "确认关闭？";
                this.content = "关闭后您将不会获得任何奖励噢~ ";
                this.closeBtnText = "确认关闭";
                this.continueBtnText = "继续试玩";
            }
        }
        setViewContent(this.title, this.content, this.closeBtnText, this.continueBtnText);
    }

    private void setRVAlertViewContent(String str) {
        try {
            this.title = an.a(getContext(), "MBridge_ConfirmTitle" + str, "").toString();
            this.content = an.a(getContext(), "MBridge_ConfirmContent" + str, "").toString();
            this.continueBtnText = an.a(getContext(), "MBridge_CancelText" + str, "").toString();
            this.closeBtnText = an.a(getContext(), "MBridge_ConfirmText" + str, "").toString();
            g gVarB = h.a().b(c.m().k());
            if (TextUtils.isEmpty(this.title) && TextUtils.isEmpty(this.content) && TextUtils.isEmpty(this.closeBtnText) && TextUtils.isEmpty(this.continueBtnText) && gVarB != null) {
                this.title = gVarB.z();
                this.content = gVarB.x();
                this.closeBtnText = gVarB.y();
                this.continueBtnText = gVarB.w();
            }
            if (TextUtils.isEmpty(this.title) && TextUtils.isEmpty(this.content) && TextUtils.isEmpty(this.closeBtnText) && TextUtils.isEmpty(this.continueBtnText)) {
                String language = Locale.getDefault().getLanguage();
                if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                    this.title = "Confirm to close? ";
                    this.content = "You will not be rewarded after closing the window";
                    this.continueBtnText = "Continue";
                    this.closeBtnText = "Close it";
                } else {
                    this.title = "确认关闭？";
                    this.content = "关闭后您将不会获得任何奖励噢~ ";
                    this.continueBtnText = "继续观看";
                    this.closeBtnText = "确认关闭";
                }
            }
            setViewContent(this.title, this.content, this.closeBtnText, this.continueBtnText);
        } catch (Exception e) {
            af.a("AlertTempleView", e.getMessage());
        }
    }

    private void setViewContent(String str, String str2, String str3, String str4) {
        this.titleView.setText(str);
        this.contentView.setText(str2);
        this.closeButton.setText(str3);
        this.continueButton.setText(str4);
    }

    public void setAlertType(int i10, String str, int i11) {
        if (i10 == 0) {
            setIVAlertViewContent(i11, str);
        } else if (i10 == 1) {
            setRVAlertViewContent(str);
        } else if (i10 == 2) {
            setPlayableAlertViewContent();
        }
    }

    public void setPresenter(AbsPresenter absPresenter) {
        this.mPresenter = absPresenter;
    }

    public AlertTempleView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = "AlertTempleView";
        this.title = "";
        this.content = "";
        this.closeBtnText = "";
        this.continueBtnText = "";
        this.buttonClickListener = new View.OnClickListener() { // from class: com.mbridge.msdk.newreward.player.view.floatview.AlertTempleView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AbsPresenter absPresenter2 = AlertTempleView.this.mPresenter;
                if (absPresenter2 != null) {
                    absPresenter2.click(view);
                }
            }
        };
        initView();
    }
}
