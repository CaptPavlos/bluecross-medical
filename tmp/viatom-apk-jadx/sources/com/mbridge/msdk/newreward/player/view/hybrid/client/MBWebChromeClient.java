package com.mbridge.msdk.newreward.player.view.hybrid.client;

import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.player.view.hybrid.MBWebView;
import com.mbridge.msdk.newreward.player.view.hybrid.communicator.CommunicatorParameter;
import com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicator;
import com.mbridge.msdk.newreward.player.view.hybrid.listener.WebViewEventListener;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBWebChromeClient extends WebChromeClient {
    private final String TAG = "MBWebChromeViewClient";
    private WebViewEventListener mEventListener;
    private HybridCommunicator mMBCommunicator;
    private MBWebView mWebView;

    private void findAndCallClassMethod(HybridCommunicator hybridCommunicator, CommunicatorParameter communicatorParameter) {
        if (hybridCommunicator == null) {
            return;
        }
        try {
            Method method = null;
            for (Method method2 : hybridCommunicator.getClass().getMethods()) {
                if (method2.getName().equals("callNotSupportMethod")) {
                    method = method2;
                }
                if (method2.getName().equals(communicatorParameter.getPath())) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    if (parameterTypes.length == 1 && parameterTypes[0].isInstance(communicatorParameter)) {
                        method2.invoke(hybridCommunicator, communicatorParameter);
                        return;
                    }
                }
            }
            if (method != null) {
                method.invoke(hybridCommunicator, communicatorParameter);
            }
        } catch (Throwable th) {
            af.b("MBWebChromeViewClient", th.getMessage());
        }
    }

    private String getUriToken(String str) {
        try {
        } catch (Throwable th) {
            af.b("MBWebChromeViewClient", th.getMessage());
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] strArrSplit = str.split(":");
        if (!TextUtils.isEmpty(strArrSplit[2])) {
            String[] strArrSplit2 = strArrSplit[2].split("/");
            if (!TextUtils.isEmpty(strArrSplit2[0])) {
                return strArrSplit2[0];
            }
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean onReceiveMessage(java.lang.String r12) {
        /*
            r11 = this;
            java.lang.String r1 = "MBWebChromeViewClient"
            java.lang.String r0 = "onConsoleMessage: message.length() = "
            r2 = 0
            java.lang.String r3 = "mv:"
            boolean r3 = r12.startsWith(r3)     // Catch: java.lang.Throwable -> L16
            if (r3 != 0) goto L1a
            java.lang.String r3 = "mraid:"
            boolean r3 = r12.startsWith(r3)     // Catch: java.lang.Throwable -> L16
            if (r3 == 0) goto La8
            goto L1a
        L16:
            r0 = move-exception
            r12 = r0
            goto La1
        L1a:
            java.lang.String r3 = "wv_hybrid:"
            boolean r3 = r12.contains(r3)     // Catch: java.lang.Throwable -> L16
            r4 = 1
            java.lang.String r5 = " "
            if (r3 == 0) goto L2e
            int r3 = r12.lastIndexOf(r5)     // Catch: java.lang.Throwable -> L16
            int r3 = r3 + r4
            java.lang.String r12 = r12.substring(r2, r3)     // Catch: java.lang.Throwable -> L16
        L2e:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L16
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L16
            int r0 = r12.length()     // Catch: java.lang.Throwable -> L16
            r3.append(r0)     // Catch: java.lang.Throwable -> L16
            r3.append(r5)     // Catch: java.lang.Throwable -> L16
            r3.append(r12)     // Catch: java.lang.Throwable -> L16
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L16
            com.mbridge.msdk.foundation.tools.af.a(r1, r0)     // Catch: java.lang.Throwable -> L16
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch: java.lang.Throwable -> L16
            if (r0 != 0) goto La0
            android.net.Uri r0 = android.net.Uri.parse(r12)     // Catch: java.lang.Throwable -> L16
            java.lang.String r7 = r0.getScheme()     // Catch: java.lang.Throwable -> L16
            java.lang.String r9 = r11.getUriToken(r12)     // Catch: java.lang.Throwable -> L16
            java.lang.String r12 = r0.getLastPathSegment()     // Catch: java.lang.Throwable -> L16
            java.lang.String r3 = "mraid"
            if (r7 == 0) goto L6b
            boolean r5 = r7.equals(r3)     // Catch: java.lang.Throwable -> L16
            if (r5 == 0) goto L6b
            java.lang.String r12 = r0.getHost()     // Catch: java.lang.Throwable -> L16
        L6b:
            r8 = r12
            java.lang.String r12 = r0.getEncodedQuery()     // Catch: java.lang.Throwable -> L16
            boolean r5 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L16
            if (r5 != 0) goto L9f
            boolean r5 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Throwable -> L16
            if (r5 == 0) goto L7d
            goto L9f
        L7d:
            boolean r3 = j$.util.Objects.equals(r7, r3)     // Catch: java.lang.Throwable -> L16
            if (r3 == 0) goto L8f
            java.lang.String r0 = com.mbridge.msdk.newreward.player.view.hybrid.util.MBHybridUtil.getQueryParameters(r0)     // Catch: java.lang.Throwable -> L16
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L16
            if (r3 != 0) goto L8f
            r10 = r0
            goto L90
        L8f:
            r10 = r12
        L90:
            com.mbridge.msdk.newreward.player.view.hybrid.communicator.CommunicatorParameter r5 = new com.mbridge.msdk.newreward.player.view.hybrid.communicator.CommunicatorParameter     // Catch: java.lang.Throwable -> L16
            com.mbridge.msdk.newreward.player.view.hybrid.MBWebView r6 = r11.mWebView     // Catch: java.lang.Throwable -> L16
            r5.<init>(r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L16
            com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicator r12 = r11.mMBCommunicator     // Catch: java.lang.Throwable -> L16
            if (r12 == 0) goto La0
            r11.findAndCallClassMethod(r12, r5)     // Catch: java.lang.Throwable -> L16
            goto La0
        L9f:
            return r2
        La0:
            return r4
        La1:
            java.lang.String r12 = r12.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r1, r12)
        La8:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.player.view.hybrid.client.MBWebChromeClient.onReceiveMessage(java.lang.String):boolean");
    }

    public HybridCommunicator getHybridCommunicator() {
        return this.mMBCommunicator;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage.messageLevel() != ConsoleMessage.MessageLevel.LOG) {
            return super.onConsoleMessage(consoleMessage);
        }
        if (TextUtils.isEmpty(consoleMessage.message()) || !onReceiveMessage(consoleMessage.message())) {
            return super.onConsoleMessage(consoleMessage);
        }
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (TextUtils.isEmpty(str2) || !onReceiveMessage(str2)) {
            return false;
        }
        jsPromptResult.confirm("");
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i10) {
        super.onProgressChanged(webView, i10);
        WebViewEventListener webViewEventListener = this.mEventListener;
        if (webViewEventListener != null) {
            webViewEventListener.onProgressChanged(webView, i10);
        }
    }

    public void setHybridCommunicator(HybridCommunicator hybridCommunicator) {
        this.mMBCommunicator = hybridCommunicator;
    }

    public void setWeView(MBWebView mBWebView) {
        this.mWebView = mBWebView;
    }

    public void setWebViewEventListener(WebViewEventListener webViewEventListener) {
        this.mEventListener = webViewEventListener;
    }
}
