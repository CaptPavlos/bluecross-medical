package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.HashMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class k0 extends y implements l0 {
    public static l0 asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        return iInterfaceQueryLocalInterface instanceof l0 ? (l0) iInterfaceQueryLocalInterface : new j0(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService", 0);
    }

    @Override // com.google.android.gms.internal.measurement.y
    public final boolean a(int i10, Parcel parcel, Parcel parcel2) {
        boolean z9;
        n0 m0Var = null;
        p0 o0Var = null;
        n0 m0Var2 = null;
        n0 m0Var3 = null;
        n0 m0Var4 = null;
        n0 m0Var5 = null;
        s0 q0Var = null;
        s0 q0Var2 = null;
        s0 q0Var3 = null;
        n0 m0Var6 = null;
        n0 m0Var7 = null;
        n0 m0Var8 = null;
        n0 m0Var9 = null;
        n0 m0Var10 = null;
        n0 m0Var11 = null;
        u0 t0Var = null;
        n0 m0Var12 = null;
        n0 m0Var13 = null;
        n0 m0Var14 = null;
        n0 m0Var15 = null;
        n0 m0Var16 = null;
        switch (i10) {
            case 1:
                q0.a aVarI = q0.b.I(parcel.readStrongBinder());
                v0 v0Var = (v0) z.a(parcel, v0.CREATOR);
                long j10 = parcel.readLong();
                z.d(parcel);
                initialize(aVarI, v0Var, j10);
                break;
            case 2:
                String string = parcel.readString();
                String string2 = parcel.readString();
                Bundle bundle = (Bundle) z.a(parcel, Bundle.CREATOR);
                boolean z10 = parcel.readInt() != 0;
                boolean z11 = parcel.readInt() != 0;
                long j11 = parcel.readLong();
                z.d(parcel);
                logEvent(string, string2, bundle, z10, z11, j11);
                break;
            case 3:
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                Bundle bundle2 = (Bundle) z.a(parcel, Bundle.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    m0Var = iInterfaceQueryLocalInterface instanceof n0 ? (n0) iInterfaceQueryLocalInterface : new m0(strongBinder);
                }
                n0 n0Var = m0Var;
                long j12 = parcel.readLong();
                z.d(parcel);
                logEventAndBundle(string3, string4, bundle2, n0Var, j12);
                break;
            case 4:
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                q0.a aVarI2 = q0.b.I(parcel.readStrongBinder());
                ClassLoader classLoader = z.f2275a;
                z9 = parcel.readInt() != 0;
                long j13 = parcel.readLong();
                z.d(parcel);
                setUserProperty(string5, string6, aVarI2, z9, j13);
                break;
            case 5:
                String string7 = parcel.readString();
                String string8 = parcel.readString();
                ClassLoader classLoader2 = z.f2275a;
                z9 = parcel.readInt() != 0;
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    m0Var16 = iInterfaceQueryLocalInterface2 instanceof n0 ? (n0) iInterfaceQueryLocalInterface2 : new m0(strongBinder2);
                }
                z.d(parcel);
                getUserProperties(string7, string8, z9, m0Var16);
                break;
            case 6:
                String string9 = parcel.readString();
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    m0Var15 = iInterfaceQueryLocalInterface3 instanceof n0 ? (n0) iInterfaceQueryLocalInterface3 : new m0(strongBinder3);
                }
                z.d(parcel);
                getMaxUserProperties(string9, m0Var15);
                break;
            case 7:
                String string10 = parcel.readString();
                long j14 = parcel.readLong();
                z.d(parcel);
                setUserId(string10, j14);
                break;
            case 8:
                Bundle bundle3 = (Bundle) z.a(parcel, Bundle.CREATOR);
                long j15 = parcel.readLong();
                z.d(parcel);
                setConditionalUserProperty(bundle3, j15);
                break;
            case 9:
                String string11 = parcel.readString();
                String string12 = parcel.readString();
                Bundle bundle4 = (Bundle) z.a(parcel, Bundle.CREATOR);
                z.d(parcel);
                clearConditionalUserProperty(string11, string12, bundle4);
                break;
            case 10:
                String string13 = parcel.readString();
                String string14 = parcel.readString();
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    m0Var14 = iInterfaceQueryLocalInterface4 instanceof n0 ? (n0) iInterfaceQueryLocalInterface4 : new m0(strongBinder4);
                }
                z.d(parcel);
                getConditionalUserProperties(string13, string14, m0Var14);
                break;
            case 11:
                ClassLoader classLoader3 = z.f2275a;
                z9 = parcel.readInt() != 0;
                long j16 = parcel.readLong();
                z.d(parcel);
                setMeasurementEnabled(z9, j16);
                break;
            case 12:
                long j17 = parcel.readLong();
                z.d(parcel);
                resetAnalyticsData(j17);
                break;
            case 13:
                long j18 = parcel.readLong();
                z.d(parcel);
                setMinimumSessionDuration(j18);
                break;
            case 14:
                long j19 = parcel.readLong();
                z.d(parcel);
                setSessionTimeoutDuration(j19);
                break;
            case 15:
                q0.a aVarI3 = q0.b.I(parcel.readStrongBinder());
                String string15 = parcel.readString();
                String string16 = parcel.readString();
                long j20 = parcel.readLong();
                z.d(parcel);
                setCurrentScreen(aVarI3, string15, string16, j20);
                break;
            case 16:
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    m0Var13 = iInterfaceQueryLocalInterface5 instanceof n0 ? (n0) iInterfaceQueryLocalInterface5 : new m0(strongBinder5);
                }
                z.d(parcel);
                getCurrentScreenName(m0Var13);
                break;
            case 17:
                IBinder strongBinder6 = parcel.readStrongBinder();
                if (strongBinder6 != null) {
                    IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    m0Var12 = iInterfaceQueryLocalInterface6 instanceof n0 ? (n0) iInterfaceQueryLocalInterface6 : new m0(strongBinder6);
                }
                z.d(parcel);
                getCurrentScreenClass(m0Var12);
                break;
            case 18:
                IBinder strongBinder7 = parcel.readStrongBinder();
                if (strongBinder7 != null) {
                    IInterface iInterfaceQueryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
                    t0Var = iInterfaceQueryLocalInterface7 instanceof u0 ? (u0) iInterfaceQueryLocalInterface7 : new t0(strongBinder7, "com.google.android.gms.measurement.api.internal.IStringProvider", 0);
                }
                z.d(parcel);
                setInstanceIdProvider(t0Var);
                break;
            case 19:
                IBinder strongBinder8 = parcel.readStrongBinder();
                if (strongBinder8 != null) {
                    IInterface iInterfaceQueryLocalInterface8 = strongBinder8.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    m0Var11 = iInterfaceQueryLocalInterface8 instanceof n0 ? (n0) iInterfaceQueryLocalInterface8 : new m0(strongBinder8);
                }
                z.d(parcel);
                getCachedAppInstanceId(m0Var11);
                break;
            case 20:
                IBinder strongBinder9 = parcel.readStrongBinder();
                if (strongBinder9 != null) {
                    IInterface iInterfaceQueryLocalInterface9 = strongBinder9.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    m0Var10 = iInterfaceQueryLocalInterface9 instanceof n0 ? (n0) iInterfaceQueryLocalInterface9 : new m0(strongBinder9);
                }
                z.d(parcel);
                getAppInstanceId(m0Var10);
                break;
            case 21:
                IBinder strongBinder10 = parcel.readStrongBinder();
                if (strongBinder10 != null) {
                    IInterface iInterfaceQueryLocalInterface10 = strongBinder10.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    m0Var9 = iInterfaceQueryLocalInterface10 instanceof n0 ? (n0) iInterfaceQueryLocalInterface10 : new m0(strongBinder10);
                }
                z.d(parcel);
                getGmpAppId(m0Var9);
                break;
            case 22:
                IBinder strongBinder11 = parcel.readStrongBinder();
                if (strongBinder11 != null) {
                    IInterface iInterfaceQueryLocalInterface11 = strongBinder11.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    m0Var8 = iInterfaceQueryLocalInterface11 instanceof n0 ? (n0) iInterfaceQueryLocalInterface11 : new m0(strongBinder11);
                }
                z.d(parcel);
                generateEventId(m0Var8);
                break;
            case 23:
                String string17 = parcel.readString();
                long j21 = parcel.readLong();
                z.d(parcel);
                beginAdUnitExposure(string17, j21);
                break;
            case 24:
                String string18 = parcel.readString();
                long j22 = parcel.readLong();
                z.d(parcel);
                endAdUnitExposure(string18, j22);
                break;
            case 25:
                q0.a aVarI4 = q0.b.I(parcel.readStrongBinder());
                long j23 = parcel.readLong();
                z.d(parcel);
                onActivityStarted(aVarI4, j23);
                break;
            case 26:
                q0.a aVarI5 = q0.b.I(parcel.readStrongBinder());
                long j24 = parcel.readLong();
                z.d(parcel);
                onActivityStopped(aVarI5, j24);
                break;
            case 27:
                q0.a aVarI6 = q0.b.I(parcel.readStrongBinder());
                Bundle bundle5 = (Bundle) z.a(parcel, Bundle.CREATOR);
                long j25 = parcel.readLong();
                z.d(parcel);
                onActivityCreated(aVarI6, bundle5, j25);
                break;
            case 28:
                q0.a aVarI7 = q0.b.I(parcel.readStrongBinder());
                long j26 = parcel.readLong();
                z.d(parcel);
                onActivityDestroyed(aVarI7, j26);
                break;
            case 29:
                q0.a aVarI8 = q0.b.I(parcel.readStrongBinder());
                long j27 = parcel.readLong();
                z.d(parcel);
                onActivityPaused(aVarI8, j27);
                break;
            case 30:
                q0.a aVarI9 = q0.b.I(parcel.readStrongBinder());
                long j28 = parcel.readLong();
                z.d(parcel);
                onActivityResumed(aVarI9, j28);
                break;
            case 31:
                q0.a aVarI10 = q0.b.I(parcel.readStrongBinder());
                IBinder strongBinder12 = parcel.readStrongBinder();
                if (strongBinder12 != null) {
                    IInterface iInterfaceQueryLocalInterface12 = strongBinder12.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    m0Var7 = iInterfaceQueryLocalInterface12 instanceof n0 ? (n0) iInterfaceQueryLocalInterface12 : new m0(strongBinder12);
                }
                long j29 = parcel.readLong();
                z.d(parcel);
                onActivitySaveInstanceState(aVarI10, m0Var7, j29);
                break;
            case 32:
                Bundle bundle6 = (Bundle) z.a(parcel, Bundle.CREATOR);
                IBinder strongBinder13 = parcel.readStrongBinder();
                if (strongBinder13 != null) {
                    IInterface iInterfaceQueryLocalInterface13 = strongBinder13.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    m0Var6 = iInterfaceQueryLocalInterface13 instanceof n0 ? (n0) iInterfaceQueryLocalInterface13 : new m0(strongBinder13);
                }
                long j30 = parcel.readLong();
                z.d(parcel);
                performAction(bundle6, m0Var6, j30);
                break;
            case 33:
                int i11 = parcel.readInt();
                String string19 = parcel.readString();
                q0.a aVarI11 = q0.b.I(parcel.readStrongBinder());
                q0.a aVarI12 = q0.b.I(parcel.readStrongBinder());
                q0.a aVarI13 = q0.b.I(parcel.readStrongBinder());
                z.d(parcel);
                logHealthData(i11, string19, aVarI11, aVarI12, aVarI13);
                break;
            case 34:
                IBinder strongBinder14 = parcel.readStrongBinder();
                if (strongBinder14 != null) {
                    IInterface iInterfaceQueryLocalInterface14 = strongBinder14.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    q0Var3 = iInterfaceQueryLocalInterface14 instanceof s0 ? (s0) iInterfaceQueryLocalInterface14 : new q0(strongBinder14);
                }
                z.d(parcel);
                setEventInterceptor(q0Var3);
                break;
            case 35:
                IBinder strongBinder15 = parcel.readStrongBinder();
                if (strongBinder15 != null) {
                    IInterface iInterfaceQueryLocalInterface15 = strongBinder15.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    q0Var2 = iInterfaceQueryLocalInterface15 instanceof s0 ? (s0) iInterfaceQueryLocalInterface15 : new q0(strongBinder15);
                }
                z.d(parcel);
                registerOnMeasurementEventListener(q0Var2);
                break;
            case 36:
                IBinder strongBinder16 = parcel.readStrongBinder();
                if (strongBinder16 != null) {
                    IInterface iInterfaceQueryLocalInterface16 = strongBinder16.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    q0Var = iInterfaceQueryLocalInterface16 instanceof s0 ? (s0) iInterfaceQueryLocalInterface16 : new q0(strongBinder16);
                }
                z.d(parcel);
                unregisterOnMeasurementEventListener(q0Var);
                break;
            case 37:
                HashMap hashMap = parcel.readHashMap(z.f2275a);
                z.d(parcel);
                initForTests(hashMap);
                break;
            case 38:
                IBinder strongBinder17 = parcel.readStrongBinder();
                if (strongBinder17 != null) {
                    IInterface iInterfaceQueryLocalInterface17 = strongBinder17.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    m0Var5 = iInterfaceQueryLocalInterface17 instanceof n0 ? (n0) iInterfaceQueryLocalInterface17 : new m0(strongBinder17);
                }
                int i12 = parcel.readInt();
                z.d(parcel);
                getTestFlag(m0Var5, i12);
                break;
            case 39:
                ClassLoader classLoader4 = z.f2275a;
                z9 = parcel.readInt() != 0;
                z.d(parcel);
                setDataCollectionEnabled(z9);
                break;
            case 40:
                IBinder strongBinder18 = parcel.readStrongBinder();
                if (strongBinder18 != null) {
                    IInterface iInterfaceQueryLocalInterface18 = strongBinder18.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    m0Var4 = iInterfaceQueryLocalInterface18 instanceof n0 ? (n0) iInterfaceQueryLocalInterface18 : new m0(strongBinder18);
                }
                z.d(parcel);
                isDataCollectionEnabled(m0Var4);
                break;
            case 41:
            case 47:
            case 49:
            default:
                return false;
            case 42:
                Bundle bundle7 = (Bundle) z.a(parcel, Bundle.CREATOR);
                z.d(parcel);
                setDefaultEventParameters(bundle7);
                break;
            case 43:
                long j31 = parcel.readLong();
                z.d(parcel);
                clearMeasurementEnabled(j31);
                break;
            case 44:
                Bundle bundle8 = (Bundle) z.a(parcel, Bundle.CREATOR);
                long j32 = parcel.readLong();
                z.d(parcel);
                setConsent(bundle8, j32);
                break;
            case 45:
                Bundle bundle9 = (Bundle) z.a(parcel, Bundle.CREATOR);
                long j33 = parcel.readLong();
                z.d(parcel);
                setConsentThirdParty(bundle9, j33);
                break;
            case 46:
                IBinder strongBinder19 = parcel.readStrongBinder();
                if (strongBinder19 != null) {
                    IInterface iInterfaceQueryLocalInterface19 = strongBinder19.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    m0Var3 = iInterfaceQueryLocalInterface19 instanceof n0 ? (n0) iInterfaceQueryLocalInterface19 : new m0(strongBinder19);
                }
                z.d(parcel);
                getSessionId(m0Var3);
                break;
            case 48:
                Intent intent = (Intent) z.a(parcel, Intent.CREATOR);
                z.d(parcel);
                setSgtmDebugInfo(intent);
                break;
            case 50:
                x0 x0Var = (x0) z.a(parcel, x0.CREATOR);
                String string20 = parcel.readString();
                String string21 = parcel.readString();
                long j34 = parcel.readLong();
                z.d(parcel);
                setCurrentScreenByScionActivityInfo(x0Var, string20, string21, j34);
                break;
            case 51:
                x0 x0Var2 = (x0) z.a(parcel, x0.CREATOR);
                long j35 = parcel.readLong();
                z.d(parcel);
                onActivityStartedByScionActivityInfo(x0Var2, j35);
                break;
            case 52:
                x0 x0Var3 = (x0) z.a(parcel, x0.CREATOR);
                long j36 = parcel.readLong();
                z.d(parcel);
                onActivityStoppedByScionActivityInfo(x0Var3, j36);
                break;
            case 53:
                x0 x0Var4 = (x0) z.a(parcel, x0.CREATOR);
                Bundle bundle10 = (Bundle) z.a(parcel, Bundle.CREATOR);
                long j37 = parcel.readLong();
                z.d(parcel);
                onActivityCreatedByScionActivityInfo(x0Var4, bundle10, j37);
                break;
            case 54:
                x0 x0Var5 = (x0) z.a(parcel, x0.CREATOR);
                long j38 = parcel.readLong();
                z.d(parcel);
                onActivityDestroyedByScionActivityInfo(x0Var5, j38);
                break;
            case 55:
                x0 x0Var6 = (x0) z.a(parcel, x0.CREATOR);
                long j39 = parcel.readLong();
                z.d(parcel);
                onActivityPausedByScionActivityInfo(x0Var6, j39);
                break;
            case 56:
                x0 x0Var7 = (x0) z.a(parcel, x0.CREATOR);
                long j40 = parcel.readLong();
                z.d(parcel);
                onActivityResumedByScionActivityInfo(x0Var7, j40);
                break;
            case 57:
                x0 x0Var8 = (x0) z.a(parcel, x0.CREATOR);
                IBinder strongBinder20 = parcel.readStrongBinder();
                if (strongBinder20 != null) {
                    IInterface iInterfaceQueryLocalInterface20 = strongBinder20.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    m0Var2 = iInterfaceQueryLocalInterface20 instanceof n0 ? (n0) iInterfaceQueryLocalInterface20 : new m0(strongBinder20);
                }
                long j41 = parcel.readLong();
                z.d(parcel);
                onActivitySaveInstanceStateByScionActivityInfo(x0Var8, m0Var2, j41);
                break;
            case 58:
                IBinder strongBinder21 = parcel.readStrongBinder();
                if (strongBinder21 != null) {
                    IInterface iInterfaceQueryLocalInterface21 = strongBinder21.queryLocalInterface("com.google.android.gms.measurement.api.internal.IDynamiteUploadBatchesCallback");
                    o0Var = iInterfaceQueryLocalInterface21 instanceof p0 ? (p0) iInterfaceQueryLocalInterface21 : new o0(strongBinder21, "com.google.android.gms.measurement.api.internal.IDynamiteUploadBatchesCallback", 0);
                }
                z.d(parcel);
                retrieveAndUploadBatches(o0Var);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
