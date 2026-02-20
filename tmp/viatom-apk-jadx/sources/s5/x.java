package s5;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.tv.ui.fragment.TvMyAppsFragment;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class x implements OnItemViewClickedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TvMyAppsFragment f12678a;

    public x(TvMyAppsFragment tvMyAppsFragment) {
        this.f12678a = tvMyAppsFragment;
    }

    @Override // androidx.leanback.widget.BaseOnItemViewClickedListener
    public final void onItemClicked(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        boolean z9;
        viewHolder.getClass();
        obj.getClass();
        if (obj instanceof h5.f) {
            TvMyAppsFragment tvMyAppsFragment = this.f12678a;
            if (tvMyAppsFragment.e) {
                h5.f fVar = (h5.f) obj;
                Context contextRequireContext = tvMyAppsFragment.requireContext();
                contextRequireContext.getClass();
                new c1.l(contextRequireContext, fVar.f8541w, new i0.k(29, tvMyAppsFragment, fVar), LifecycleOwnerKt.getLifecycleScope(tvMyAppsFragment));
                return;
            }
            if (tvMyAppsFragment.f6711d) {
                long j10 = ((h5.f) obj).f8541w;
                Context contextRequireContext2 = tvMyAppsFragment.requireContext();
                contextRequireContext2.getClass();
                new c1.l(contextRequireContext2, j10, new y(tvMyAppsFragment, viewHolder), LifecycleOwnerKt.getLifecycleScope(tvMyAppsFragment));
                return;
            }
            h5.f fVar2 = (h5.f) obj;
            if (tvMyAppsFragment.getParentFragmentManager().isDestroyed()) {
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(tvMyAppsFragment.requireContext());
            LayoutInflater layoutInflater = tvMyAppsFragment.getLayoutInflater();
            layoutInflater.getClass();
            int i10 = 0;
            View viewInflate = layoutInflater.inflate(R.layout.tv_dialog_app_selected, (ViewGroup) null, false);
            TextView textView = (TextView) viewInflate.findViewById(R.id.tv_title_das);
            textView.setTypeface(o4.b.f11719r);
            textView.setText(fVar2.f8525b);
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_see_on_uptodown);
            int i11 = 1;
            if (fVar2.f8541w > 0) {
                textView2.setTypeface(o4.b.f11720s);
                textView2.setOnClickListener(new e5.j(tvMyAppsFragment, fVar2, viewHolder, 14));
                z9 = true;
            } else {
                textView2.setVisibility(8);
                z9 = false;
            }
            TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_open);
            TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_uninstall);
            if (tvMyAppsFragment.getContext() == null || o7.u.Z(tvMyAppsFragment.requireContext().getPackageName(), fVar2.f8526c, true)) {
                textView3.setVisibility(8);
                textView4.setVisibility(8);
            } else {
                textView3.setTypeface(o4.b.f11720s);
                textView3.setOnClickListener(new v(fVar2, tvMyAppsFragment, i10));
                if (fVar2.c()) {
                    textView4.setVisibility(8);
                } else {
                    textView4.setTypeface(o4.b.f11720s);
                    textView4.setOnClickListener(new v(fVar2, tvMyAppsFragment, i11));
                }
                z9 = true;
            }
            float f = UptodownApp.E;
            TextView textView5 = (TextView) viewInflate.findViewById(R.id.tv_old_versions);
            if (tvMyAppsFragment.getContext() == null || o7.u.Z(tvMyAppsFragment.requireContext().getPackageName(), fVar2.f8526c, true)) {
                textView5.setVisibility(8);
            } else {
                textView5.setTypeface(o4.b.f11720s);
                textView5.setOnClickListener(new v(tvMyAppsFragment, fVar2, 2));
            }
            TextView textView6 = (TextView) viewInflate.findViewById(R.id.tv_exclude);
            if (fVar2.f8532m == 0) {
                textView6.setText(tvMyAppsFragment.getString(R.string.not_offer_updates));
            } else {
                textView6.setText(tvMyAppsFragment.getString(R.string.offer_updates_again));
            }
            textView6.setTypeface(o4.b.f11720s);
            textView6.setOnClickListener(new v(tvMyAppsFragment, fVar2, 3));
            if (z9) {
                builder.setView(viewInflate);
                AlertDialog alertDialogCreate = builder.create();
                tvMyAppsFragment.f6710c = alertDialogCreate;
                alertDialogCreate.getClass();
                alertDialogCreate.show();
            }
        }
    }
}
