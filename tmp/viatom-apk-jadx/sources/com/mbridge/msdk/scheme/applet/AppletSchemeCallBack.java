package com.mbridge.msdk.scheme.applet;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.af;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class AppletSchemeCallBack implements IAppletSchemeCallBack {
    private static final String TAG = "AppletSchemeCallBack";

    @Override // com.mbridge.msdk.scheme.applet.IAppletSchemeCallBack
    public void onAppletSchemeRequestFailed(int i10, String str, String str2) {
        try {
            onRequestFailed(i10, str, str2);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.b(TAG, e.getMessage());
            }
        }
    }

    @Override // com.mbridge.msdk.scheme.applet.IAppletSchemeCallBack
    public void onAppletSchemeRequestStart() {
        try {
            onRequestStart();
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.b(TAG, e.getMessage());
            }
        }
    }

    @Override // com.mbridge.msdk.scheme.applet.IAppletSchemeCallBack
    public void onAppletSchemeRequestSuccess(String str) {
        try {
            onRequestSuccess(str);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.b(TAG, e.getMessage());
            }
        }
    }

    @Override // com.mbridge.msdk.scheme.applet.IAppletSchemeCallBack
    public void onNetworkError(int i10, String str, String str2) {
        try {
            onRequestFailed(i10, str, str2);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.b(TAG, e.getMessage());
            }
        }
    }

    public abstract void onRequestFailed(int i10, String str, String str2);

    public abstract void onRequestStart();

    public abstract void onRequestSuccess(String str);
}
