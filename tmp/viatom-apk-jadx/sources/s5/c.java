package s5;

import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import com.uptodown.UptodownApp;
import com.uptodown.tv.ui.fragment.TvAppDetailFragment;
import java.io.File;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class c implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12615a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h5.q f12616b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TvAppDetailFragment f12617c;

    public /* synthetic */ c(TvAppDetailFragment tvAppDetailFragment, h5.q qVar) {
        this.f12617c = tvAppDetailFragment;
        this.f12616b = qVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        int i11 = this.f12615a;
        TvAppDetailFragment tvAppDetailFragment = this.f12617c;
        h5.q qVar = this.f12616b;
        switch (i11) {
            case 0:
                dialogInterface.getClass();
                tvAppDetailFragment.i(qVar);
                dialogInterface.dismiss();
                break;
            default:
                dialogInterface.getClass();
                dialogInterface.dismiss();
                File fileG = qVar.g();
                if (fileG != null) {
                    float f = UptodownApp.E;
                    FragmentActivity fragmentActivityRequireActivity = tvAppDetailFragment.requireActivity();
                    fragmentActivityRequireActivity.getClass();
                    k4.c.q(fragmentActivityRequireActivity, fileG, null);
                    break;
                }
                break;
        }
    }

    public /* synthetic */ c(h5.q qVar, TvAppDetailFragment tvAppDetailFragment) {
        this.f12616b = qVar;
        this.f12617c = tvAppDetailFragment;
    }
}
