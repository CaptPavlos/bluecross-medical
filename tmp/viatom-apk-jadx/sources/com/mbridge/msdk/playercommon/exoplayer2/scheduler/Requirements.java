package com.mbridge.msdk.playercommon.exoplayer2.scheduler;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.PowerManager;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import p8.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class Requirements {
    private static final int DEVICE_CHARGING = 16;
    private static final int DEVICE_IDLE = 8;
    public static final int NETWORK_TYPE_ANY = 1;
    private static final int NETWORK_TYPE_MASK = 7;
    public static final int NETWORK_TYPE_METERED = 4;
    public static final int NETWORK_TYPE_NONE = 0;
    public static final int NETWORK_TYPE_NOT_ROAMING = 3;
    private static final String[] NETWORK_TYPE_STRINGS = null;
    public static final int NETWORK_TYPE_UNMETERED = 2;
    private static final String TAG = "Requirements";
    private final int requirements;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface NetworkType {
    }

    public Requirements(int i10, boolean z9, boolean z10) {
        this(i10 | (z9 ? 16 : 0) | (z10 ? 8 : 0));
    }

    private boolean checkChargingRequirement(Context context) {
        if (!isChargingRequired()) {
            return true;
        }
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver == null) {
            return false;
        }
        int intExtra = intentRegisterReceiver.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
        return intExtra == 2 || intExtra == 5;
    }

    private boolean checkIdleRequirement(Context context) {
        if (!isIdleRequired()) {
            return true;
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        int i10 = Util.SDK_INT;
        return i10 >= 23 ? !powerManager.isDeviceIdleMode() : i10 >= 20 ? !powerManager.isInteractive() : !powerManager.isScreenOn();
    }

    private static boolean checkInternetConnectivity(ConnectivityManager connectivityManager) {
        if (Util.SDK_INT < 23) {
            return true;
        }
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null) {
            logd("No active network.");
            return false;
        }
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
        boolean z9 = networkCapabilities == null || !networkCapabilities.hasCapability(16);
        logd("Network capability validated: " + z9);
        return !z9;
    }

    private boolean checkNetworkRequirements(Context context) {
        int requiredNetworkType = getRequiredNetworkType();
        if (requiredNetworkType == 0) {
            return true;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            logd("No network info or no connection.");
            return false;
        }
        if (!checkInternetConnectivity(connectivityManager)) {
            return false;
        }
        if (requiredNetworkType == 1) {
            return true;
        }
        if (requiredNetworkType == 3) {
            boolean zIsRoaming = activeNetworkInfo.isRoaming();
            logd("Roaming: " + zIsRoaming);
            return !zIsRoaming;
        }
        boolean zIsActiveNetworkMetered = isActiveNetworkMetered(connectivityManager, activeNetworkInfo);
        logd("Metered network: " + zIsActiveNetworkMetered);
        if (requiredNetworkType == 2) {
            return !zIsActiveNetworkMetered;
        }
        if (requiredNetworkType == 4) {
            return zIsActiveNetworkMetered;
        }
        u.e();
        return false;
    }

    private static boolean isActiveNetworkMetered(ConnectivityManager connectivityManager, NetworkInfo networkInfo) {
        if (Util.SDK_INT >= 16) {
            return connectivityManager.isActiveNetworkMetered();
        }
        int type = networkInfo.getType();
        return (type == 1 || type == 7 || type == 9) ? false : true;
    }

    public final boolean checkRequirements(Context context) {
        return checkNetworkRequirements(context) && checkChargingRequirement(context) && checkIdleRequirement(context);
    }

    public final int getRequiredNetworkType() {
        return this.requirements & 7;
    }

    public final int getRequirementsData() {
        return this.requirements;
    }

    public final boolean isChargingRequired() {
        return (this.requirements & 16) != 0;
    }

    public final boolean isIdleRequired() {
        return (this.requirements & 8) != 0;
    }

    public final String toString() {
        return super.toString();
    }

    public Requirements(int i10) {
        this.requirements = i10;
    }

    private static void logd(String str) {
    }
}
