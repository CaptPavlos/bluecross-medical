package i5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.uptodown.workers.AppInstalledWorker;
import com.uptodown.workers.AppUpdatedWorker;
import w3.k;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a extends BroadcastReceiver {

    /* renamed from: b, reason: collision with root package name */
    public static String f9012b;

    /* renamed from: c, reason: collision with root package name */
    public static long f9013c;

    /* renamed from: d, reason: collision with root package name */
    public static String f9014d;
    public static long e;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9015a;

    public /* synthetic */ a(int i10) {
        this.f9015a = i10;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data;
        Uri data2;
        boolean z9;
        boolean z10;
        switch (this.f9015a) {
            case 0:
                context.getClass();
                intent.getClass();
                String action = intent.getAction();
                if (action != null && action.equalsIgnoreCase("android.intent.action.PACKAGE_ADDED") && (data = intent.getData()) != null) {
                    String schemeSpecificPart = data.getSchemeSpecificPart();
                    boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
                    if (schemeSpecificPart != null && !booleanExtra) {
                        String strConcat = action.concat(schemeSpecificPart);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        boolean z11 = !strConcat.equalsIgnoreCase(f9012b) || jCurrentTimeMillis - f9013c > AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS;
                        f9013c = jCurrentTimeMillis;
                        f9012b = strConcat;
                        if (z11) {
                            WorkManager.Companion.getInstance(context).enqueue(new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) AppInstalledWorker.class).setInputData(new Data.Builder().putString("packagename", schemeSpecificPart).build()).addTag("AppInstalledWorker").build());
                            break;
                        }
                    }
                }
                break;
            case 1:
                context.getClass();
                intent.getClass();
                String action2 = intent.getAction();
                if (action2 != null && action2.equalsIgnoreCase("android.intent.action.PACKAGE_REPLACED") && (data2 = intent.getData()) != null) {
                    String schemeSpecificPart2 = data2.getSchemeSpecificPart();
                    boolean booleanExtra2 = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
                    if (schemeSpecificPart2 != null && booleanExtra2) {
                        String strConcat2 = action2.concat(schemeSpecificPart2);
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        boolean z12 = !strConcat2.equalsIgnoreCase(f9014d) || jCurrentTimeMillis2 - e > AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS;
                        e = jCurrentTimeMillis2;
                        f9014d = strConcat2;
                        if (z12) {
                            WorkManager.Companion.getInstance(context).enqueue(new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) AppUpdatedWorker.class).setInputData(new Data.Builder().putString("packagename", schemeSpecificPart2).build()).addTag("AppUpdatedWorker").build());
                            break;
                        }
                    }
                }
                break;
            case 2:
                k kVar = k.f13516d;
                if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                    z9 = kVar.f13519c;
                    z10 = true;
                } else if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
                    z9 = kVar.f13519c;
                    z10 = false;
                }
                kVar.a(z10, z9);
                kVar.f13518b = z10;
                break;
            default:
                if (intent.getAction() == "android.media.action.HDMI_AUDIO_PLUG") {
                    int intExtra = intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", -1);
                    if (intExtra != 0) {
                        if (intExtra == 1) {
                            r0.f.e = 2;
                            break;
                        }
                    } else {
                        r0.f.e = 1;
                        break;
                    }
                }
                break;
        }
    }
}
