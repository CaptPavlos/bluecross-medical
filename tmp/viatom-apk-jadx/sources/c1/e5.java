package c1;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.google.android.gms.internal.measurement.j8;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e5 extends BroadcastReceiver {

    /* renamed from: c, reason: collision with root package name */
    public static String f1150c;

    /* renamed from: d, reason: collision with root package name */
    public static long f1151d;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1152a;

    /* renamed from: b, reason: collision with root package name */
    public Object f1153b;

    public /* synthetic */ e5(Object obj, int i10) {
        this.f1152a = i10;
        this.f1153b = obj;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data;
        String schemeSpecificPart;
        switch (this.f1152a) {
            case 0:
                u1 u1Var = (u1) this.f1153b;
                if (intent != null) {
                    String action = intent.getAction();
                    if (action != null) {
                        int iHashCode = action.hashCode();
                        if (iHashCode == -1928239649) {
                            if (action.equals("com.google.android.gms.measurement.TRIGGERS_AVAILABLE")) {
                                j8.a();
                                if (u1Var.f1478d.q(null, f0.R0)) {
                                    w0 w0Var = u1Var.f;
                                    u1.m(w0Var);
                                    w0Var.f1545n.b("App receiver notified triggers are available");
                                    r1 r1Var = u1Var.g;
                                    u1.m(r1Var);
                                    r1Var.p(new a4.a(u1Var, 7));
                                    break;
                                }
                            }
                        } else if (iHashCode == 1279883384 && action.equals("com.google.android.gms.measurement.BATCHES_AVAILABLE")) {
                            w0 w0Var2 = u1Var.f;
                            u1.m(w0Var2);
                            w0Var2.f1545n.b("[sgtm] App Receiver notified batches are available");
                            r1 r1Var2 = u1Var.g;
                            u1.m(r1Var2);
                            r1Var2.p(new a4.a(this, 6));
                            break;
                        }
                        w0 w0Var3 = u1Var.f;
                        u1.m(w0Var3);
                        w0Var3.f1540i.b("App receiver called with unknown action");
                        break;
                    } else {
                        w0 w0Var4 = u1Var.f;
                        u1.m(w0Var4);
                        w0Var4.f1540i.b("App receiver called with null action");
                        break;
                    }
                } else {
                    w0 w0Var5 = u1Var.f;
                    u1.m(w0Var5);
                    w0Var5.f1540i.b("App receiver called with null intent");
                    break;
                }
                break;
            case 1:
                context.getClass();
                intent.getClass();
                Activity activity = o4.b.g;
                this.f1153b = r0.f.h(context);
                String action2 = intent.getAction();
                if (action2 != null && action2.equalsIgnoreCase("android.intent.action.PACKAGE_REMOVED") && !intent.getBooleanExtra("android.intent.extra.REPLACING", false) && (data = intent.getData()) != null && (schemeSpecificPart = data.getSchemeSpecificPart()) != null) {
                    String strConcat = action2.concat(schemeSpecificPart);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    boolean z9 = !strConcat.equalsIgnoreCase(f1150c) || jCurrentTimeMillis - f1151d > AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS;
                    f1151d = jCurrentTimeMillis;
                    f1150c = strConcat;
                    if (z9) {
                        BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
                        y7.e eVar = r7.i0.f12407a;
                        r7.y.q(r7.y.a(y7.d.f14116a), null, null, new i5.b(this, schemeSpecificPart, pendingResultGoAsync, null, 1), 3);
                        break;
                    }
                }
                break;
            default:
                j4.n nVar = (j4.n) this.f1153b;
                if (intent != null) {
                    String action3 = intent.getAction();
                    if (!"android.intent.action.AIRPLANE_MODE".equals(action3)) {
                        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action3)) {
                            StringBuilder sb = j4.l0.f9987a;
                            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                            j4.l lVar = nVar.h;
                            lVar.sendMessage(lVar.obtainMessage(9, activeNetworkInfo));
                            break;
                        }
                    } else if (intent.hasExtra(MRAIDCommunicatorUtil.KEY_STATE)) {
                        boolean booleanExtra = intent.getBooleanExtra(MRAIDCommunicatorUtil.KEY_STATE, false);
                        j4.l lVar2 = nVar.h;
                        lVar2.sendMessage(lVar2.obtainMessage(10, booleanExtra ? 1 : 0, 0));
                        break;
                    }
                }
                break;
        }
    }

    public /* synthetic */ e5() {
        this.f1152a = 1;
    }
}
