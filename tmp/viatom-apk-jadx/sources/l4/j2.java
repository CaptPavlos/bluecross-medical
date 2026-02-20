package l4;

import android.content.res.Resources;
import android.widget.LinearLayout;
import com.uptodown.R;
import com.uptodown.activities.MainActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j2 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10515a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MainActivity f10516b;

    public /* synthetic */ j2(int i10, MainActivity mainActivity) {
        this.f10515a = i10;
        this.f10516b = mainActivity;
    }

    @Override // java.lang.Runnable
    public final void run() throws Resources.NotFoundException {
        int i10 = this.f10515a;
        MainActivity mainActivity = this.f10516b;
        switch (i10) {
            case 0:
                LinearLayout linearLayout = (LinearLayout) mainActivity.findViewById(R.id.ll_auto_update);
                if (linearLayout != null && linearLayout.getVisibility() == 0) {
                    mainActivity.S0();
                    break;
                }
                break;
            default:
                int i11 = MainActivity.B0;
                mainActivity.U0();
                break;
        }
    }
}
