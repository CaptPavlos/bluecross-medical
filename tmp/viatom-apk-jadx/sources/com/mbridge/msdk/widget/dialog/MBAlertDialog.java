package com.mbridge.msdk.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.Locale;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBAlertDialog extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private Button f6612a;

    /* renamed from: b, reason: collision with root package name */
    private Button f6613b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f6614c;

    /* renamed from: d, reason: collision with root package name */
    private a f6615d;
    private TextView e;

    public MBAlertDialog(Context context, final a aVar) {
        super(context);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        requestWindowFeature(1);
        View viewInflate = LayoutInflater.from(context).inflate(x.a(context, "mbridge_cm_alertview", TtmlNode.TAG_LAYOUT), (ViewGroup) null);
        this.f6615d = aVar;
        if (viewInflate != null) {
            setContentView(viewInflate);
            try {
                this.e = (TextView) viewInflate.findViewById(x.a(context, "mbridge_video_common_alertview_titleview", "id"));
            } catch (Exception e) {
                af.a("MBAlertDialog", e.getMessage());
            }
            try {
                this.f6614c = (TextView) viewInflate.findViewById(x.a(context, "mbridge_video_common_alertview_contentview", "id"));
                this.f6613b = (Button) viewInflate.findViewById(x.a(context, "mbridge_video_common_alertview_confirm_button", "id"));
                this.f6612a = (Button) viewInflate.findViewById(x.a(context, "mbridge_video_common_alertview_cancel_button", "id"));
            } catch (Exception e3) {
                af.a("MBAlertDialog", e3.getMessage());
            }
        }
        Button button = this.f6612a;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.widget.dialog.MBAlertDialog.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                    MBAlertDialog.this.cancel();
                    MBAlertDialog.this.clear();
                }
            });
        }
        Button button2 = this.f6613b;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.widget.dialog.MBAlertDialog.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.b();
                    }
                    MBAlertDialog.this.cancel();
                    MBAlertDialog.this.clear();
                }
            });
        }
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    private void a(String str, String str2, String str3, String str4) {
        setTitle(str);
        setContent(str2);
        setConfirmText(str3);
        setCancelText(str4);
    }

    public void clear() {
        if (this.f6615d != null) {
            this.f6615d = null;
        }
    }

    public a getListener() {
        return this.f6615d;
    }

    public void hideNavigationBar(Window window) {
        if (window != null) {
            window.setFlags(1024, 1024);
            window.addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
            window.getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                window.setAttributes(attributes);
            }
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-1, -1);
            window.setGravity(17);
        }
    }

    public void makeIVAlertView(int i10, String str) {
        try {
            String string = an.a(getContext(), "MBridge_ConfirmTitle" + str, "").toString();
            String string2 = an.a(getContext(), "MBridge_ConfirmContent" + str, "").toString();
            String string3 = an.a(getContext(), "MBridge_CancelText" + str, "").toString();
            String string4 = an.a(getContext(), "MBridge_ConfirmText" + str, "").toString();
            if (!TextUtils.isEmpty(string) || !TextUtils.isEmpty(string2) || !TextUtils.isEmpty(string3) || !TextUtils.isEmpty(string4)) {
                a(string, string2, string3, string4);
                return;
            }
            String language = Locale.getDefault().getLanguage();
            if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                setTitle(i10 == com.mbridge.msdk.foundation.same.a.H ? "Confirm" : "Tips");
                setContent(i10 == com.mbridge.msdk.foundation.same.a.H ? "If you choose to continue, you will receive a reward after the end. Confirm closed?" : "If you choose to continue, you will receive a reward after the end. Whether to continue?");
                setConfirmText(i10 == com.mbridge.msdk.foundation.same.a.H ? "Close" : "Cancel");
                setCancelText("Continue");
                return;
            }
            setTitle(i10 == com.mbridge.msdk.foundation.same.a.H ? "确认关闭？" : "提示");
            setContent(i10 == com.mbridge.msdk.foundation.same.a.H ? "如果你选择继续，结束后将会获得奖励。确认关闭吗？" : "如果你选择继续，结束后将会获得奖励。是否继续？");
            setConfirmText(i10 == com.mbridge.msdk.foundation.same.a.H ? "确认关闭" : "取消");
            setCancelText("继续");
        } catch (Exception e) {
            af.a("MBAlertDialog", e.getMessage());
        }
    }

    public void makePlayableAlertView() {
        g gVarS = androidx.constraintlayout.core.widgets.analyzer.a.s(h.a());
        if (gVarS != null) {
            a(gVarS.z(), gVarS.x(), gVarS.y(), gVarS.v());
            return;
        }
        String language = Locale.getDefault().getLanguage();
        if (TextUtils.isEmpty(language) || !language.equals("zh")) {
            setTitle("Confirm to close? ");
            setContent("You will not be rewarded after closing the window");
            setConfirmText("Close it");
            setCancelText("Continue");
            return;
        }
        setTitle("确认关闭？");
        setContent("关闭后您将不会获得任何奖励噢~ ");
        setConfirmText("确认关闭");
        setCancelText("继续试玩");
    }

    public void makeRVAlertView(String str) {
        try {
            String string = an.a(getContext(), "MBridge_ConfirmTitle" + str, "").toString();
            String string2 = an.a(getContext(), "MBridge_ConfirmContent" + str, "").toString();
            String string3 = an.a(getContext(), "MBridge_CancelText" + str, "").toString();
            String string4 = an.a(getContext(), "MBridge_ConfirmText" + str, "").toString();
            g gVarB = h.a().b(c.m().k());
            if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2) && TextUtils.isEmpty(string3) && TextUtils.isEmpty(string4)) {
                if (gVarB != null) {
                    a(gVarB.z(), gVarB.x(), gVarB.y(), gVarB.w());
                    return;
                }
                String language = Locale.getDefault().getLanguage();
                if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                    setTitle("Confirm to close? ");
                    setContent("You will not be rewarded after closing the window");
                    setConfirmText("Close it");
                    setCancelText("Continue");
                    return;
                }
                setTitle("确认关闭？");
                setContent("关闭后您将不会获得任何奖励噢~ ");
                setConfirmText("确认关闭");
                setCancelText("继续观看");
                return;
            }
            String language2 = Locale.getDefault().getLanguage();
            if (TextUtils.isEmpty(string)) {
                if (gVarB != null) {
                    string = gVarB.z();
                } else if (TextUtils.isEmpty(language2) || !language2.equals("zh")) {
                    setTitle("Confirm to close? ");
                } else {
                    setTitle("确认关闭？");
                }
            }
            if (TextUtils.isEmpty(string2)) {
                if (gVarB != null) {
                    string2 = gVarB.x();
                } else if (TextUtils.isEmpty(language2) || !language2.equals("zh")) {
                    setContent("You will not be rewarded after closing the window");
                } else {
                    setContent("关闭后您将不会获得任何奖励噢~ ");
                }
            }
            if (TextUtils.isEmpty(string4)) {
                if (gVarB != null) {
                    string4 = gVarB.y();
                } else if (TextUtils.isEmpty(language2) || !language2.equals("zh")) {
                    setConfirmText("Close it");
                } else {
                    setConfirmText("确认关闭");
                }
            }
            if (TextUtils.isEmpty(string3)) {
                if (gVarB != null) {
                    string3 = gVarB.w();
                } else if (TextUtils.isEmpty(language2) || !language2.equals("zh")) {
                    setCancelText("Continue");
                } else {
                    setCancelText("继续观看");
                }
            }
            a(string, string2, string4, string3);
        } catch (Exception e) {
            af.a("MBAlertDialog", e.getMessage());
        }
    }

    public void onlyShow() {
        super.show();
    }

    public void setCancelText(String str) {
        Button button = this.f6612a;
        if (button != null) {
            button.setText(str);
        }
    }

    public void setConfirmText(String str) {
        Button button = this.f6613b;
        if (button != null) {
            button.setText(str);
        }
    }

    public void setContent(String str) {
        TextView textView = this.f6614c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTitle(String str) {
        TextView textView = this.e;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        try {
            getWindow().setFlags(8, 8);
            super.show();
            hideNavigationBar(getWindow());
            getWindow().clearFlags(8);
        } catch (Exception e) {
            af.b("MBAlertDialog", e.getMessage());
            super.show();
        }
    }

    public void makeDownloadAlert(String str) {
    }

    public void makeInsAlert(String str) {
    }
}
