package com.uptodown;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import c1.e5;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.ACData;
import com.inmobi.cmp.core.model.GDPRData;
import com.inmobi.cmp.core.model.gbc.GoogleBasicConsents;
import com.inmobi.cmp.core.model.mspa.USRegulationData;
import com.inmobi.cmp.model.ActionButton;
import com.inmobi.cmp.model.ChoiceError;
import com.inmobi.cmp.model.DisplayInfo;
import com.inmobi.cmp.model.NonIABData;
import com.inmobi.cmp.model.PingReturn;
import com.mbridge.msdk.out.MBridgeSDKFactory;
import com.mbridge.msdk.system.MBridgeSDKImpl;
import e4.e;
import h5.f;
import h5.l;
import i5.a;
import java.util.ArrayList;
import java.util.HashMap;
import o4.b;
import r7.i0;
import r7.y;
import w7.c;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class UptodownApp extends b implements ChoiceCmpCallback {
    public static float E = 1.0f;
    public static String F;
    public static String G;
    public static String H;
    public static String I;
    public static String J;
    public static String K;
    public static String L;
    public static String M;
    public static String N;
    public static int O;
    public static int P;
    public static int Q;
    public static int R;
    public static int S;
    public static e T;
    public static e U;
    public static boolean X;
    public static boolean Y;
    public static l Z;

    /* renamed from: k0, reason: collision with root package name */
    public static ArrayList f6634k0;
    public static f l0;

    /* renamed from: m0, reason: collision with root package name */
    public static long f6635m0;

    /* renamed from: n0, reason: collision with root package name */
    public static ArrayList f6636n0;
    public a A;
    public a B;
    public e5 C;
    public final c D = y.a(t1.M(y.c(), i0.f12407a));
    public static final HashMap V = new HashMap();
    public static final i5.f W = new i5.f(2, null);

    /* renamed from: j0, reason: collision with root package name */
    public static final Object f6633j0 = new Object();

    /* renamed from: o0, reason: collision with root package name */
    public static final Object f6637o0 = new Object();

    /* renamed from: p0, reason: collision with root package name */
    public static final Object f6638p0 = new Object();

    /* renamed from: q0, reason: collision with root package name */
    public static final ArrayList f6639q0 = new ArrayList();

    public final void d(String str, boolean z9) {
        Bundle bundle = new Bundle();
        if (z9) {
            bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "accepted");
        } else {
            bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "rejected");
        }
        bundle.putString("consent_version", str);
        new t1.c(this, 4).e(bundle, "user_consent_mintegral");
    }

    @Override // com.inmobi.cmp.ChoiceCmpCallback
    public final void onActionButtonClicked(ActionButton actionButton) {
        actionButton.getClass();
    }

    @Override // com.inmobi.cmp.ChoiceCmpCallback
    public final void onCCPAConsentGiven(String str) {
        str.getClass();
    }

    @Override // com.inmobi.cmp.ChoiceCmpCallback
    public final void onCMPUIStatusChanged(DisplayInfo displayInfo) {
        displayInfo.getClass();
    }

    @Override // com.inmobi.cmp.ChoiceCmpCallback
    public final void onCmpError(ChoiceError choiceError) {
        choiceError.getClass();
    }

    @Override // com.inmobi.cmp.ChoiceCmpCallback
    public final void onCmpLoaded(PingReturn pingReturn) {
        pingReturn.getClass();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03ad A[Catch: Exception -> 0x03b1, TRY_LEAVE, TryCatch #4 {Exception -> 0x03b1, blocks: (B:114:0x03a1, B:116:0x03ad), top: B:139:0x03a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02fe  */
    @Override // o4.b, android.app.Application
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onCreate() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 992
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.UptodownApp.onCreate():void");
    }

    @Override // com.inmobi.cmp.ChoiceCmpCallback
    public final void onGoogleBasicConsentChange(GoogleBasicConsents googleBasicConsents) {
        googleBasicConsents.getClass();
    }

    @Override // com.inmobi.cmp.ChoiceCmpCallback
    public final void onGoogleVendorConsentGiven(ACData aCData) {
        aCData.getClass();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v8 */
    @Override // com.inmobi.cmp.ChoiceCmpCallback
    public final void onIABVendorConsentGiven(GDPRData gDPRData) {
        gDPRData.getClass();
        Boolean bool = gDPRData.getVendor().getConsents().get("867");
        ?? BooleanValue = bool != null ? bool.booleanValue() : 0;
        Context applicationContext = getApplicationContext();
        applicationContext.getClass();
        MBridgeSDKImpl mBridgeSDK = MBridgeSDKFactory.getMBridgeSDK();
        mBridgeSDK.getClass();
        mBridgeSDK.setConsentStatus(applicationContext, (int) BooleanValue);
        d("gdpr", BooleanValue);
    }

    @Override // com.inmobi.cmp.ChoiceCmpCallback
    public final void onNonIABVendorConsentGiven(NonIABData nonIABData) {
        nonIABData.getClass();
    }

    @Override // com.inmobi.cmp.ChoiceCmpCallback
    public final void onReceiveUSRegulationsConsent(USRegulationData uSRegulationData) {
        uSRegulationData.getClass();
        boolean z9 = false;
        boolean z10 = uSRegulationData.getSaleOptOut() == 2;
        boolean z11 = uSRegulationData.getSharingOptOut() == 2;
        boolean z12 = uSRegulationData.getPersonalDataConsents() == 2;
        if (z10 && z11 && z12) {
            z9 = true;
        }
        MBridgeSDKImpl mBridgeSDK = MBridgeSDKFactory.getMBridgeSDK();
        mBridgeSDK.getClass();
        mBridgeSDK.setDoNotTrackStatus(!z9);
        d("mspa", z9);
    }

    @Override // android.app.Application
    public final void onTerminate() {
        super.onTerminate();
        y.f(this.D);
        new t1.c(this);
        Object systemService = getSystemService("connectivity");
        systemService.getClass();
        ((ConnectivityManager) systemService).unregisterNetworkCallback(new ConnectivityManager.NetworkCallback());
        try {
            a aVar = this.A;
            if (aVar != null) {
                unregisterReceiver(aVar);
                this.A = null;
            }
            a aVar2 = this.B;
            if (aVar2 != null) {
                unregisterReceiver(aVar2);
                this.B = null;
            }
            e5 e5Var = this.C;
            if (e5Var != null) {
                unregisterReceiver(e5Var);
                this.C = null;
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Override // com.inmobi.cmp.ChoiceCmpCallback
    public final void onUserMovedToOtherState() {
    }
}
