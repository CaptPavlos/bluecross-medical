package e6;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import kotlin.jvm.internal.l;
import l9.n;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Observer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7925a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f7926b;

    public /* synthetic */ b(c cVar, int i10) {
        this.f7925a = i10;
        this.f7926b = cVar;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        FragmentManager supportFragmentManager;
        FragmentManager supportFragmentManager2;
        int i10 = this.f7925a;
        Fragment fragmentFindFragmentByTag = null;
        c cVar = this.f7926b;
        switch (i10) {
            case 0:
                n nVar = cVar.C;
                if (nVar == null) {
                    l.i("stacksAdapter");
                    throw null;
                }
                d dVar = cVar.B;
                if (dVar == null) {
                    l.i("viewModel");
                    throw null;
                }
                nVar.f11145a = dVar.e();
                nVar.notifyDataSetChanged();
                return;
            case 1:
                FragmentActivity activity = cVar.getActivity();
                if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
                    fragmentFindFragmentByTag = supportFragmentManager.findFragmentByTag("e");
                }
                BottomSheetDialogFragment bottomSheetDialogFragment = (BottomSheetDialogFragment) fragmentFindFragmentByTag;
                if (bottomSheetDialogFragment != null) {
                    bottomSheetDialogFragment.dismiss();
                }
                FragmentActivity activity2 = cVar.getActivity();
                if (activity2 == null) {
                    return;
                }
                activity2.finish();
                return;
            default:
                FragmentActivity activity3 = cVar.getActivity();
                if (activity3 != null && (supportFragmentManager2 = activity3.getSupportFragmentManager()) != null) {
                    fragmentFindFragmentByTag = supportFragmentManager2.findFragmentByTag("e");
                }
                BottomSheetDialogFragment bottomSheetDialogFragment2 = (BottomSheetDialogFragment) fragmentFindFragmentByTag;
                if (bottomSheetDialogFragment2 != null) {
                    bottomSheetDialogFragment2.dismiss();
                }
                FragmentActivity activity4 = cVar.getActivity();
                if (activity4 == null) {
                    return;
                }
                activity4.finish();
                return;
        }
    }
}
