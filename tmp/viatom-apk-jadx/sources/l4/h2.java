package l4;

import android.os.Handler;
import android.os.Looper;
import android.widget.ProgressBar;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.uptodown.R;
import com.uptodown.activities.MainActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class h2 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10451a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MainActivity f10452b;

    public /* synthetic */ h2(int i10, MainActivity mainActivity) {
        this.f10451a = i10;
        this.f10452b = mainActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f10451a;
        int i11 = 0;
        MainActivity mainActivity = this.f10452b;
        switch (i10) {
            case 0:
                int i12 = MainActivity.B0;
                ProgressBar progressBar = (ProgressBar) mainActivity.findViewById(R.id.pb_splash);
                if (progressBar != null) {
                    progressBar.setVisibility(0);
                    break;
                }
                break;
            default:
                int i13 = MainActivity.B0;
                new Handler(Looper.getMainLooper()).postDelayed(new h2(i11, mainActivity), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                break;
        }
    }
}
