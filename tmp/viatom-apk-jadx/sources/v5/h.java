package v5;

import android.app.Activity;
import android.app.AlertDialog;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.Updates;
import l4.j2;
import l4.t;
import l4.w;
import r7.i0;
import r7.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h extends ConnectivityManager.NetworkCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t1.c f13165a;

    public h(t1.c cVar) {
        this.f13165a = cVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        MainActivity mainActivity;
        RelativeLayout relativeLayout;
        network.getClass();
        if (a.a.f0a) {
            return;
        }
        int i10 = 1;
        a.a.f0a = true;
        Activity activity = o4.b.g;
        if (activity != null) {
            float f = UptodownApp.E;
            k4.c.d((UptodownApp) this.f13165a.f12751b);
            if (activity instanceof w) {
                y.q(y.a(i0.f12407a), null, null, new t((w) activity, null), 3);
            }
            if ((activity instanceof MainActivity) && (relativeLayout = (mainActivity = (MainActivity) activity).V) != null && relativeLayout.getVisibility() == 0) {
                mainActivity.runOnUiThread(new j2(i10, mainActivity));
            }
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        Updates updates;
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        UptodownApp uptodownApp = (UptodownApp) this.f13165a.f12751b;
        network.getClass();
        networkCapabilities.getClass();
        super.onCapabilitiesChanged(network, networkCapabilities);
        boolean z9 = true;
        boolean zHasTransport = networkCapabilities.hasTransport(1);
        boolean z10 = a.a.f3d;
        int linkDownstreamBandwidthKbps = networkCapabilities.getLinkDownstreamBandwidthKbps();
        int i10 = a.a.f1b;
        int i11 = a.a.f2c;
        a.a.f3d = zHasTransport;
        a.a.f1b = networkCapabilities.getLinkDownstreamBandwidthKbps();
        a.a.f2c = networkCapabilities.getLinkUpstreamBandwidthKbps();
        if (i10 == 0 || i11 == 0) {
            float f = UptodownApp.E;
            k4.c.d(uptodownApp);
            return;
        }
        if (z10 == zHasTransport) {
            if (4300 >= linkDownstreamBandwidthKbps ? i10 <= 4300 : i10 >= 4300) {
                z9 = false;
            }
            if (a.a.f3d || !z9) {
                return;
            }
            float f10 = UptodownApp.E;
            k4.c.d(uptodownApp);
            return;
        }
        float f11 = UptodownApp.E;
        k4.c.d(uptodownApp);
        if (a.a.f3d) {
            k4.c.E(uptodownApp);
            Activity activity = o4.b.g;
            if (activity != null && (activity instanceof Updates) && (alertDialog = (updates = (Updates) activity).f10935w) != null && alertDialog.isShowing() && a.a.f3d) {
                AlertDialog alertDialog3 = updates.f10935w;
                if ((alertDialog3 != null ? (TextView) alertDialog3.findViewById(R.id.tv_title_dialog_no_wifi_connection) : null) == null || (alertDialog2 = updates.f10935w) == null) {
                    return;
                }
                alertDialog2.dismiss();
            }
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        network.getClass();
        a.a.f0a = false;
        a.a.f3d = false;
    }
}
