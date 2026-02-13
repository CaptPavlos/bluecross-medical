package s5;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.tv.ui.fragment.TvMyDownloadsFragment;
import java.io.File;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b0 implements OnItemViewClickedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TvMyDownloadsFragment f12614a;

    public b0(TvMyDownloadsFragment tvMyDownloadsFragment) {
        this.f12614a = tvMyDownloadsFragment;
    }

    @Override // androidx.leanback.widget.BaseOnItemViewClickedListener
    public final void onItemClicked(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        if (obj instanceof h5.q) {
            final h5.q qVar = (h5.q) obj;
            final TvMyDownloadsFragment tvMyDownloadsFragment = this.f12614a;
            AlertDialog alertDialog = tvMyDownloadsFragment.f6713b;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            if (tvMyDownloadsFragment.getActivity() == null || tvMyDownloadsFragment.requireActivity().isFinishing()) {
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(tvMyDownloadsFragment.getContext());
            LayoutInflater layoutInflater = tvMyDownloadsFragment.getLayoutInflater();
            layoutInflater.getClass();
            View viewInflate = layoutInflater.inflate(R.layout.tv_apk_clicked_dialog, (ViewGroup) null, false);
            final int i10 = 0;
            ((TextView) viewInflate.findViewById(R.id.tv_install)).setOnClickListener(new View.OnClickListener() { // from class: s5.a0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    File fileG;
                    int i11 = i10;
                    TvMyDownloadsFragment tvMyDownloadsFragment2 = tvMyDownloadsFragment;
                    h5.q qVar2 = qVar;
                    switch (i11) {
                        case 0:
                            if (qVar2.c() && (fileG = qVar2.g()) != null) {
                                float f = UptodownApp.E;
                                FragmentActivity fragmentActivityRequireActivity = tvMyDownloadsFragment2.requireActivity();
                                fragmentActivityRequireActivity.getClass();
                                k4.c.q(fragmentActivityRequireActivity, fileG, null);
                            }
                            AlertDialog alertDialog2 = tvMyDownloadsFragment2.f6713b;
                            if (alertDialog2 != null) {
                                alertDialog2.dismiss();
                                break;
                            }
                            break;
                        default:
                            qVar2.d();
                            t3.h hVar = v5.g.f13148u;
                            Context contextRequireContext = tvMyDownloadsFragment2.requireContext();
                            contextRequireContext.getClass();
                            v5.g gVarL = hVar.l(contextRequireContext);
                            gVarL.a();
                            gVarL.j(qVar2);
                            gVarL.b();
                            ArrayObjectAdapter arrayObjectAdapter = tvMyDownloadsFragment2.f6712a;
                            arrayObjectAdapter.getClass();
                            arrayObjectAdapter.remove(qVar2);
                            AlertDialog alertDialog3 = tvMyDownloadsFragment2.f6713b;
                            if (alertDialog3 != null) {
                                alertDialog3.dismiss();
                                break;
                            }
                            break;
                    }
                }
            });
            final int i11 = 1;
            ((TextView) viewInflate.findViewById(R.id.tv_delete)).setOnClickListener(new View.OnClickListener() { // from class: s5.a0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    File fileG;
                    int i112 = i11;
                    TvMyDownloadsFragment tvMyDownloadsFragment2 = tvMyDownloadsFragment;
                    h5.q qVar2 = qVar;
                    switch (i112) {
                        case 0:
                            if (qVar2.c() && (fileG = qVar2.g()) != null) {
                                float f = UptodownApp.E;
                                FragmentActivity fragmentActivityRequireActivity = tvMyDownloadsFragment2.requireActivity();
                                fragmentActivityRequireActivity.getClass();
                                k4.c.q(fragmentActivityRequireActivity, fileG, null);
                            }
                            AlertDialog alertDialog2 = tvMyDownloadsFragment2.f6713b;
                            if (alertDialog2 != null) {
                                alertDialog2.dismiss();
                                break;
                            }
                            break;
                        default:
                            qVar2.d();
                            t3.h hVar = v5.g.f13148u;
                            Context contextRequireContext = tvMyDownloadsFragment2.requireContext();
                            contextRequireContext.getClass();
                            v5.g gVarL = hVar.l(contextRequireContext);
                            gVarL.a();
                            gVarL.j(qVar2);
                            gVarL.b();
                            ArrayObjectAdapter arrayObjectAdapter = tvMyDownloadsFragment2.f6712a;
                            arrayObjectAdapter.getClass();
                            arrayObjectAdapter.remove(qVar2);
                            AlertDialog alertDialog3 = tvMyDownloadsFragment2.f6713b;
                            if (alertDialog3 != null) {
                                alertDialog3.dismiss();
                                break;
                            }
                            break;
                    }
                }
            });
            builder.setView(viewInflate);
            AlertDialog alertDialogCreate = builder.create();
            tvMyDownloadsFragment.f6713b = alertDialogCreate;
            if (alertDialogCreate != null) {
                alertDialogCreate.show();
            }
        }
    }
}
