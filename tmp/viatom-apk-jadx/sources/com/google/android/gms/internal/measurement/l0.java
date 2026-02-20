package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface l0 extends IInterface {
    void beginAdUnitExposure(String str, long j10);

    void clearConditionalUserProperty(String str, String str2, Bundle bundle);

    void clearMeasurementEnabled(long j10);

    void endAdUnitExposure(String str, long j10);

    void generateEventId(n0 n0Var);

    void getAppInstanceId(n0 n0Var);

    void getCachedAppInstanceId(n0 n0Var);

    void getConditionalUserProperties(String str, String str2, n0 n0Var);

    void getCurrentScreenClass(n0 n0Var);

    void getCurrentScreenName(n0 n0Var);

    void getGmpAppId(n0 n0Var);

    void getMaxUserProperties(String str, n0 n0Var);

    void getSessionId(n0 n0Var);

    void getTestFlag(n0 n0Var, int i10);

    void getUserProperties(String str, String str2, boolean z9, n0 n0Var);

    void initForTests(Map map);

    void initialize(q0.a aVar, v0 v0Var, long j10);

    void isDataCollectionEnabled(n0 n0Var);

    void logEvent(String str, String str2, Bundle bundle, boolean z9, boolean z10, long j10);

    void logEventAndBundle(String str, String str2, Bundle bundle, n0 n0Var, long j10);

    void logHealthData(int i10, String str, q0.a aVar, q0.a aVar2, q0.a aVar3);

    void onActivityCreated(q0.a aVar, Bundle bundle, long j10);

    void onActivityCreatedByScionActivityInfo(x0 x0Var, Bundle bundle, long j10);

    void onActivityDestroyed(q0.a aVar, long j10);

    void onActivityDestroyedByScionActivityInfo(x0 x0Var, long j10);

    void onActivityPaused(q0.a aVar, long j10);

    void onActivityPausedByScionActivityInfo(x0 x0Var, long j10);

    void onActivityResumed(q0.a aVar, long j10);

    void onActivityResumedByScionActivityInfo(x0 x0Var, long j10);

    void onActivitySaveInstanceState(q0.a aVar, n0 n0Var, long j10);

    void onActivitySaveInstanceStateByScionActivityInfo(x0 x0Var, n0 n0Var, long j10);

    void onActivityStarted(q0.a aVar, long j10);

    void onActivityStartedByScionActivityInfo(x0 x0Var, long j10);

    void onActivityStopped(q0.a aVar, long j10);

    void onActivityStoppedByScionActivityInfo(x0 x0Var, long j10);

    void performAction(Bundle bundle, n0 n0Var, long j10);

    void registerOnMeasurementEventListener(s0 s0Var);

    void resetAnalyticsData(long j10);

    void retrieveAndUploadBatches(p0 p0Var);

    void setConditionalUserProperty(Bundle bundle, long j10);

    void setConsent(Bundle bundle, long j10);

    void setConsentThirdParty(Bundle bundle, long j10);

    void setCurrentScreen(q0.a aVar, String str, String str2, long j10);

    void setCurrentScreenByScionActivityInfo(x0 x0Var, String str, String str2, long j10);

    void setDataCollectionEnabled(boolean z9);

    void setDefaultEventParameters(Bundle bundle);

    void setEventInterceptor(s0 s0Var);

    void setInstanceIdProvider(u0 u0Var);

    void setMeasurementEnabled(boolean z9, long j10);

    void setMinimumSessionDuration(long j10);

    void setSessionTimeoutDuration(long j10);

    void setSgtmDebugInfo(Intent intent);

    void setUserId(String str, long j10);

    void setUserProperty(String str, String str2, q0.a aVar, boolean z9, long j10);

    void unregisterOnMeasurementEventListener(s0 s0Var);
}
