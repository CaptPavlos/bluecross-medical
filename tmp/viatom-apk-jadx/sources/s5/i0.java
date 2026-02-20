package s5;

import android.os.Process;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerSchedulerBroadcastReceiver;
import com.uptodown.tv.ui.fragment.TvSearchFragment;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class i0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12643a;

    public /* synthetic */ i0(TvSearchFragment tvSearchFragment) {
        this.f12643a = 0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f12643a) {
            case 0:
                int i10 = TvSearchFragment.f6719d;
                break;
            case 1:
                int i11 = AlarmManagerSchedulerBroadcastReceiver.f1821a;
                break;
            default:
                Process.killProcess(Process.myPid());
                break;
        }
    }

    public /* synthetic */ i0(int i10) {
        this.f12643a = i10;
    }
}
