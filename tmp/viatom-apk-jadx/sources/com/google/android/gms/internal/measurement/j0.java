package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j0 extends x implements l0 {
    @Override // com.google.android.gms.internal.measurement.l0
    public final void beginAdUnitExposure(String str, long j10) {
        Parcel parcelG = G();
        parcelG.writeString(str);
        parcelG.writeLong(j10);
        H(parcelG, 23);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        Parcel parcelG = G();
        parcelG.writeString(str);
        parcelG.writeString(str2);
        z.b(parcelG, bundle);
        H(parcelG, 9);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public final void endAdUnitExposure(String str, long j10) {
        Parcel parcelG = G();
        parcelG.writeString(str);
        parcelG.writeLong(j10);
        H(parcelG, 24);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public final void generateEventId(n0 n0Var) {
        Parcel parcelG = G();
        z.c(parcelG, n0Var);
        H(parcelG, 22);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public final void getCachedAppInstanceId(n0 n0Var) {
        Parcel parcelG = G();
        z.c(parcelG, n0Var);
        H(parcelG, 19);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public final void getConditionalUserProperties(String str, String str2, n0 n0Var) {
        Parcel parcelG = G();
        parcelG.writeString(str);
        parcelG.writeString(str2);
        z.c(parcelG, n0Var);
        H(parcelG, 10);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public final void getCurrentScreenClass(n0 n0Var) {
        Parcel parcelG = G();
        z.c(parcelG, n0Var);
        H(parcelG, 17);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public final void getCurrentScreenName(n0 n0Var) {
        Parcel parcelG = G();
        z.c(parcelG, n0Var);
        H(parcelG, 16);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public final void getGmpAppId(n0 n0Var) {
        Parcel parcelG = G();
        z.c(parcelG, n0Var);
        H(parcelG, 21);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public final void getMaxUserProperties(String str, n0 n0Var) {
        Parcel parcelG = G();
        parcelG.writeString(str);
        z.c(parcelG, n0Var);
        H(parcelG, 6);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public final void getUserProperties(String str, String str2, boolean z9, n0 n0Var) {
        Parcel parcelG = G();
        parcelG.writeString(str);
        parcelG.writeString(str2);
        ClassLoader classLoader = z.f2275a;
        parcelG.writeInt(z9 ? 1 : 0);
        z.c(parcelG, n0Var);
        H(parcelG, 5);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public final void initialize(q0.a aVar, v0 v0Var, long j10) {
        Parcel parcelG = G();
        z.c(parcelG, aVar);
        z.b(parcelG, v0Var);
        parcelG.writeLong(j10);
        H(parcelG, 1);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public final void logEvent(String str, String str2, Bundle bundle, boolean z9, boolean z10, long j10) {
        Parcel parcelG = G();
        parcelG.writeString(str);
        parcelG.writeString(str2);
        z.b(parcelG, bundle);
        parcelG.writeInt(z9 ? 1 : 0);
        parcelG.writeInt(1);
        parcelG.writeLong(j10);
        H(parcelG, 2);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public final void logHealthData(int i10, String str, q0.a aVar, q0.a aVar2, q0.a aVar3) {
        Parcel parcelG = G();
        parcelG.writeInt(5);
        parcelG.writeString("Error with data collection. Data lost.");
        z.c(parcelG, aVar);
        z.c(parcelG, aVar2);
        z.c(parcelG, aVar3);
        H(parcelG, 33);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public final void onActivityCreatedByScionActivityInfo(x0 x0Var, Bundle bundle, long j10) {
        Parcel parcelG = G();
        z.b(parcelG, x0Var);
        z.b(parcelG, bundle);
        parcelG.writeLong(j10);
        H(parcelG, 53);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public final void onActivityDestroyedByScionActivityInfo(x0 x0Var, long j10) {
        Parcel parcelG = G();
        z.b(parcelG, x0Var);
        parcelG.writeLong(j10);
        H(parcelG, 54);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public final void onActivityPausedByScionActivityInfo(x0 x0Var, long j10) {
        Parcel parcelG = G();
        z.b(parcelG, x0Var);
        parcelG.writeLong(j10);
        H(parcelG, 55);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public final void onActivityResumedByScionActivityInfo(x0 x0Var, long j10) {
        Parcel parcelG = G();
        z.b(parcelG, x0Var);
        parcelG.writeLong(j10);
        H(parcelG, 56);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public final void onActivitySaveInstanceStateByScionActivityInfo(x0 x0Var, n0 n0Var, long j10) {
        Parcel parcelG = G();
        z.b(parcelG, x0Var);
        z.c(parcelG, n0Var);
        parcelG.writeLong(j10);
        H(parcelG, 57);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public final void onActivityStartedByScionActivityInfo(x0 x0Var, long j10) {
        Parcel parcelG = G();
        z.b(parcelG, x0Var);
        parcelG.writeLong(j10);
        H(parcelG, 51);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public final void onActivityStoppedByScionActivityInfo(x0 x0Var, long j10) {
        Parcel parcelG = G();
        z.b(parcelG, x0Var);
        parcelG.writeLong(j10);
        H(parcelG, 52);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public final void registerOnMeasurementEventListener(s0 s0Var) {
        Parcel parcelG = G();
        z.c(parcelG, s0Var);
        H(parcelG, 35);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public final void retrieveAndUploadBatches(p0 p0Var) {
        Parcel parcelG = G();
        z.c(parcelG, p0Var);
        H(parcelG, 58);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public final void setConditionalUserProperty(Bundle bundle, long j10) {
        Parcel parcelG = G();
        z.b(parcelG, bundle);
        parcelG.writeLong(j10);
        H(parcelG, 8);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public final void setCurrentScreenByScionActivityInfo(x0 x0Var, String str, String str2, long j10) {
        Parcel parcelG = G();
        z.b(parcelG, x0Var);
        parcelG.writeString(str);
        parcelG.writeString(str2);
        parcelG.writeLong(j10);
        H(parcelG, 50);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public final void setDataCollectionEnabled(boolean z9) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public final void setMeasurementEnabled(boolean z9, long j10) {
        Parcel parcelG = G();
        ClassLoader classLoader = z.f2275a;
        parcelG.writeInt(z9 ? 1 : 0);
        parcelG.writeLong(j10);
        H(parcelG, 11);
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public final void setUserProperty(String str, String str2, q0.a aVar, boolean z9, long j10) {
        Parcel parcelG = G();
        parcelG.writeString("fcm");
        parcelG.writeString("_ln");
        z.c(parcelG, aVar);
        parcelG.writeInt(1);
        parcelG.writeLong(j10);
        H(parcelG, 4);
    }
}
