package e5;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MoreInfo;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7669a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f7670b;

    public /* synthetic */ a(d dVar, int i10) {
        this.f7669a = i10;
        this.f7670b = dVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f7669a) {
            case 0:
                d dVar = this.f7670b;
                FragmentActivity activity = dVar.getActivity();
                if (!(activity instanceof MainActivity)) {
                    if (!(activity instanceof AppDetailActivity)) {
                        if (activity instanceof MoreInfo) {
                            FragmentActivity activity2 = dVar.getActivity();
                            activity2.getClass();
                            ((MoreInfo) activity2).finish();
                            break;
                        }
                    } else {
                        FragmentActivity activity3 = dVar.getActivity();
                        activity3.getClass();
                        ((AppDetailActivity) activity3).finish();
                        break;
                    }
                } else {
                    FragmentActivity activity4 = dVar.getActivity();
                    activity4.getClass();
                    ((MainActivity) activity4).P0();
                    break;
                }
                break;
            default:
                FragmentActivity activity5 = this.f7670b.getActivity();
                activity5.getClass();
                ((l4.w) activity5).Q();
                break;
        }
    }
}
