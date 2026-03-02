package com.mbridge.msdk.system;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.MBridgeSDK;
import com.mbridge.msdk.foundation.controller.authoritycontroller.AuthorityInfoBean;
import com.mbridge.msdk.foundation.controller.authoritycontroller.CallBackForDeveloper;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.controller.d;
import com.mbridge.msdk.foundation.same.report.e;
import com.mbridge.msdk.foundation.same.report.f;
import com.mbridge.msdk.foundation.same.report.i;
import com.mbridge.msdk.foundation.tools.MIMManager;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.v;
import com.mbridge.msdk.out.DeveloperTransferIdInfo;
import com.mbridge.msdk.out.OnCompletionListener;
import com.mbridge.msdk.out.SDKInitStatusListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class a implements MBridgeSDK {
    protected static final String LOG_TAG = "com.mbridge.msdk";
    public static Map<String, String> map;
    private b mBridgeSDKImplDiff;
    protected volatile Context mContext;
    protected SDKInitStatusListener mStatusListener;
    protected volatile AtomicBoolean sdkInited;
    public boolean isCoolStart = true;
    protected volatile MBridgeSDK.PLUGIN_LOAD_STATUS STATUS = MBridgeSDK.PLUGIN_LOAD_STATUS.INITIAL;
    protected boolean initCallbacked = false;
    protected boolean isRegisteredLifeCycle = false;
    protected volatile boolean isMIMinited = false;
    private final Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.mbridge.msdk.system.a.1
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
            if (a.this.isMIMinited) {
                MIMManager.a().e();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(@NonNull Activity activity) {
            if (a.this.isMIMinited) {
                MIMManager.a().f();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(@NonNull Activity activity) {
            af.b("com.mbridge.msdk", "onActivityPaused currentActivityNum:" + c.m().f());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(@NonNull Activity activity) {
            int iF = c.m().f();
            af.b("com.mbridge.msdk", "onActivityStarted currentActivityNum:" + iF);
            af.b("com.mbridge.msdk", "onActivityStarted isCoolStart:" + a.this.isCoolStart);
            if (!a.this.isCoolStart && iF == 0) {
                i.a("1");
            }
            if (a.this.mBridgeSDKImplDiff != null) {
                b unused = a.this.mBridgeSDKImplDiff;
                a aVar = a.this;
                boolean z9 = aVar.isCoolStart;
                Context context = aVar.mContext;
            }
            a.this.isCoolStart = false;
            c.m().a(iF + 1);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(@NonNull Activity activity) {
            int iF = c.m().f();
            af.b("com.mbridge.msdk", "onActivityStopped currentActivityNum:" + iF);
            if (iF == 1 || iF == 0) {
                i.a("2");
            }
            c.m().a(iF - 1);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        }
    };

    private void init() {
        SDKInitStatusListener sDKInitStatusListener;
        SDKInitStatusListener sDKInitStatusListener2;
        if (this.sdkInited == null) {
            this.sdkInited = new AtomicBoolean(false);
        }
        this.initCallbacked = false;
        try {
            if (this.sdkInited.get() && (sDKInitStatusListener2 = this.mStatusListener) != null && !this.initCallbacked) {
                this.initCallbacked = true;
                sDKInitStatusListener2.onInitSuccess();
                return;
            }
        } catch (Exception e) {
            af.b("com.mbridge.msdk", e.getMessage());
        }
        if (this.mContext == null && (sDKInitStatusListener = this.mStatusListener) != null) {
            sDKInitStatusListener.onInitFail("Context can not be null.");
            this.initCallbacked = true;
            return;
        }
        try {
            this.mBridgeSDKImplDiff = new b();
            d.a().a(map, this.mContext);
            this.STATUS = MBridgeSDK.PLUGIN_LOAD_STATUS.COMPLETED;
            startTrackManager();
            ak.j();
            initMIMManager();
            if (this.mContext instanceof Application) {
                registerActivityLifecycleListener((Application) this.mContext);
                registerGlobalReceiver();
            }
            this.sdkInited.set(true);
        } catch (Exception e3) {
            af.b("com.mbridge.msdk", "INIT FAIL", e3);
            if (this.sdkInited != null) {
                this.sdkInited.set(false);
            }
            SDKInitStatusListener sDKInitStatusListener3 = this.mStatusListener;
            if (sDKInitStatusListener3 != null && !this.initCallbacked) {
                this.initCallbacked = true;
                sDKInitStatusListener3.onInitFail(e3.getMessage());
            }
        }
        SDKInitStatusListener sDKInitStatusListener4 = this.mStatusListener;
        if (sDKInitStatusListener4 != null && !this.initCallbacked) {
            this.initCallbacked = true;
            sDKInitStatusListener4.onInitSuccess();
        }
        try {
            e.a().b();
            com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
            if (this.sdkInited != null) {
                eVar.a(NotificationCompat.CATEGORY_STATUS, this.sdkInited.get() ? "1" : "2");
                eVar.a("is_allow_crash", c.m().d().b() ? "1" : "2");
                eVar.a("is_allow_anr", c.m().d().a() ? "1" : "2");
            }
            com.mbridge.msdk.foundation.same.report.d.c cVar = new com.mbridge.msdk.foundation.same.report.d.c();
            cVar.a("m_init_sdk", eVar);
            com.mbridge.msdk.foundation.same.report.d.d.a().a("m_init_sdk", cVar);
        } catch (Throwable th) {
            af.b("com.mbridge.msdk", th.getMessage());
        }
    }

    private void initMIMManager() {
        try {
            String str = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str) || !str.equals("Xiaomi")) {
                return;
            }
            this.isMIMinited = true;
            MIMManager.a().a(this.mContext.getApplicationContext());
        } catch (Throwable th) {
            af.b("com.mbridge.msdk", th.getMessage());
        }
    }

    private void startTrackManager() {
        f.a().c();
    }

    private void unregisterActivityLifecycleListener(Application application) {
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks;
        if (!this.isRegisteredLifeCycle || (activityLifecycleCallbacks = this.activityLifecycleCallbacks) == null) {
            return;
        }
        application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    public void checkAliveContext(Context context) {
        if (c.m().c() != null || context == null) {
            return;
        }
        c.m().b(context);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public boolean getConsentStatus(Context context) {
        checkAliveContext(context);
        return com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().e();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public Map<String, String> getMBConfigurationMap(String str, String str2, String str3) {
        HashMap map2 = new HashMap();
        map2.put(MBridgeConstans.ID_MBRIDGE_APPID, str);
        map2.put(MBridgeConstans.ID_MBRIDGE_APPKEY, str2);
        map2.put(MBridgeConstans.ID_MBRIDGE_WX_APPID, str3);
        map2.put(MBridgeConstans.ID_MBRIDGE_STARTUPCRASH, String.valueOf(1));
        return map2;
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public MBridgeSDK.PLUGIN_LOAD_STATUS getStatus() {
        return this.STATUS;
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void initAsync(Map<String, String> map2, Context context, SDKInitStatusListener sDKInitStatusListener) {
        this.mContext = context.getApplicationContext();
        this.mStatusListener = sDKInitStatusListener;
        map = map2;
        init();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void preload(Map<String, Object> map2) {
        if (this.STATUS == MBridgeSDK.PLUGIN_LOAD_STATUS.COMPLETED) {
            d.a().a(map2, 0);
        }
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void preloadFrame(Map<String, Object> map2) {
        d.a().a(map2, 1);
    }

    public void registerActivityLifecycleListener(Application application) {
        try {
        } catch (Exception e) {
            af.b("com.mbridge.msdk", e.getMessage());
        }
        boolean z9 = ah.a().a("c_r_a_l_c", 0) == 0;
        if (application == null || !z9) {
            return;
        }
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.activityLifecycleCallbacks;
        if (activityLifecycleCallbacks != null) {
            application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
        this.isRegisteredLifeCycle = true;
    }

    public void registerGlobalReceiver() {
        v.a().d();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void release() {
        if (this.STATUS == MBridgeSDK.PLUGIN_LOAD_STATUS.COMPLETED) {
            d.a().c();
        }
        if (this.mContext instanceof Application) {
            unregisterActivityLifecycleListener((Application) this.mContext);
        }
        v.a().e();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void setAllowAcquireIds(boolean z9) {
        com.mbridge.msdk.foundation.controller.authoritycontroller.b.a(z9);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void setAllowTransferIdsIfLimit(boolean z9) {
        com.mbridge.msdk.foundation.controller.authoritycontroller.b.b(z9);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void setConsentStatus(Context context) {
        checkAliveContext(context);
        com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().a(context, (OnCompletionListener) null);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void setCoppaStatus(Context context, boolean z9) {
        checkAliveContext(context);
        com.mbridge.msdk.foundation.controller.authoritycontroller.c.j();
        com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.AUTHORITY_COPPA, z9 ? 1 : 2);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void setDeveloperIds(DeveloperTransferIdInfo developerTransferIdInfo) {
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.b.a() || developerTransferIdInfo == null || TextUtils.isEmpty(developerTransferIdInfo.getGaid())) {
            return;
        }
        com.mbridge.msdk.foundation.tools.f.a(developerTransferIdInfo.getGaid());
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void setDoNotTrackStatus(Context context, boolean z9) {
        checkAliveContext(context);
        com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().b(z9 ? 1 : 0);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void setPlayVideoMute(int i10, int i11) {
        if (i10 == 94) {
            com.mbridge.msdk.foundation.same.a.W = i11;
        } else if (i10 == 287) {
            com.mbridge.msdk.foundation.same.a.X = i11;
        }
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void setUserPrivateInfoType(Context context, String str, int i10) {
        checkAliveContext(context);
        com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().a(str, i10);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void updateDialogWeakActivity(WeakReference<Activity> weakReference) {
        c.m().a(weakReference);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public AuthorityInfoBean userPrivateInfo(Context context) {
        checkAliveContext(context);
        return com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().d();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    @Deprecated
    public void setDoNotTrackStatus(boolean z9) {
        com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().b(z9 ? 1 : 0);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void setConsentStatus(Context context, int i10) {
        checkAliveContext(context);
        com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().a(i10);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void initAsync(Map<String, String> map2, Context context) {
        this.mContext = context.getApplicationContext();
        map = map2;
        init();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void setConsentStatus(Context context, OnCompletionListener onCompletionListener) {
        checkAliveContext(context);
        com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().a(context, onCompletionListener);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void initAsync(Map<String, String> map2, Application application, SDKInitStatusListener sDKInitStatusListener) {
        this.mContext = application;
        this.mStatusListener = sDKInitStatusListener;
        map = map2;
        init();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void initAsync(Map<String, String> map2, Application application) {
        this.mContext = application.getApplicationContext();
        map = map2;
        init();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void setThirdPartyFeatures(Map<String, Object> map2) {
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public Map<String, String> getMBConfigurationMap(String str, String str2, boolean z9) {
        return getMBConfigurationMap(str, str2, "");
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public Map<String, String> getMBConfigurationMap(String str, String str2) {
        return getMBConfigurationMap(str, str2, "");
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public Map<String, String> getMBConfigurationMap(String str, String str2, String str3, boolean z9) {
        return getMBConfigurationMap(str, str2, "");
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    @Deprecated
    public void showUserPrivateInfoTips(Context context, CallBackForDeveloper callBackForDeveloper) {
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void init(Map<String, String> map2, Context context) {
        this.mContext = context.getApplicationContext();
        map = map2;
        init();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void init(Map<String, String> map2, Application application, SDKInitStatusListener sDKInitStatusListener) {
        this.mContext = application;
        this.mStatusListener = sDKInitStatusListener;
        map = map2;
        init();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void init(Map<String, String> map2, Context context, SDKInitStatusListener sDKInitStatusListener) {
        this.mContext = context.getApplicationContext();
        this.mStatusListener = sDKInitStatusListener;
        map = map2;
        init();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void init(Map<String, String> map2, Application application) {
        this.mContext = application.getApplicationContext();
        map = map2;
        init();
    }

    public void init(Application application) {
        this.mContext = application.getApplicationContext();
        init();
    }
}
