package g6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c6.i;
import com.uptodown.R;
import e5.s;
import java.util.ArrayList;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends l9.a {

    /* renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f8233o = 0;

    /* renamed from: m, reason: collision with root package name */
    public c f8234m;

    /* renamed from: n, reason: collision with root package name */
    public b f8235n;

    @Override // l9.a, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        b bVar = arguments == null ? null : (b) l5.a.a(arguments, "partner_disclosure_args", b.class);
        if (bVar == null) {
            bVar = new b(new ArrayList());
        }
        this.f8235n = bVar;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        ViewModelStore viewModelStore = activity.getViewModelStore();
        viewModelStore.getClass();
        this.f8234m = (c) new ViewModelProvider(viewModelStore, new i(2)).get(c.class);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View viewInflate = layoutInflater.inflate(R.layout.dialog_partners_disclosures, viewGroup, false);
        viewInflate.getClass();
        return viewInflate;
    }

    @Override // l9.a, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        Integer num;
        view.getClass();
        super.onViewCreated(view, bundle);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_disclosures);
        if (recyclerView != null) {
            b bVar = this.f8235n;
            if (bVar == null) {
                l.i("args");
                throw null;
            }
            recyclerView.setAdapter(new l9.d(bVar.f8231a));
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        }
        TextView textView = this.f11096b;
        if (textView != null) {
            c cVar = this.f8234m;
            if (cVar == null) {
                l.i("viewModel");
                throw null;
            }
            textView.setText(cVar.f8232a.f7567a);
        }
        ImageView imageView = this.f11097c;
        if (imageView != null) {
            imageView.setOnClickListener(new s(this, 3));
            c cVar2 = this.f8234m;
            if (cVar2 == null) {
                l.i("viewModel");
                throw null;
            }
            imageView.setContentDescription(cVar2.f8232a.f7568b);
        }
        d9.d dVar = this.f11100j;
        if (dVar == null || (num = dVar.g) == null) {
            return;
        }
        view.setBackgroundColor(num.intValue());
    }
}
