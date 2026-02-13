package e5;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MainActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c implements g5.i, g5.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f7692a;

    public /* synthetic */ c(d dVar) {
        this.f7692a = dVar;
    }

    @Override // g5.i
    public void f(int i10) {
        d dVar = this.f7692a;
        if (dVar.getActivity() instanceof l4.w) {
            FragmentActivity activity = dVar.getActivity();
            activity.getClass();
            String string = dVar.getString(R.string.error_generico);
            string.getClass();
            ((l4.w) activity).N(string);
        }
    }

    @Override // g5.i
    public void l(h5.h hVar) {
        d dVar = this.f7692a;
        Context contextRequireContext = dVar.requireContext();
        contextRequireContext.getClass();
        FragmentActivity fragmentActivityRequireActivity = dVar.requireActivity();
        fragmentActivityRequireActivity.getClass();
        l1.b.h(contextRequireContext, (l4.w) fragmentActivityRequireActivity, hVar, new a4.f(dVar, hVar, 17, false), true);
    }

    @Override // g5.c
    public void z(h5.h hVar) {
        hVar.getClass();
        float f = UptodownApp.E;
        if (k4.c.s()) {
            d dVar = this.f7692a;
            if (dVar.getActivity() != null && (dVar.getActivity() instanceof MainActivity)) {
                FragmentActivity activity = dVar.getActivity();
                activity.getClass();
                ((MainActivity) activity).Y(hVar.f8566a);
            } else {
                if (dVar.getActivity() == null || !(dVar.getActivity() instanceof l4.w)) {
                    return;
                }
                FragmentActivity activity2 = dVar.getActivity();
                activity2.getClass();
                ((l4.w) activity2).Y(hVar.f8566a);
            }
        }
    }
}
