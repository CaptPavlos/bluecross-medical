package i6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import c6.i;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends l9.a {
    public static final /* synthetic */ int H = 0;
    public TextView A;
    public TextView B;
    public TextView C;
    public TextView D;
    public ImageView E;
    public b F;
    public e G;

    /* renamed from: m, reason: collision with root package name */
    public TextView f9043m;

    /* renamed from: n, reason: collision with root package name */
    public TextView f9044n;

    /* renamed from: o, reason: collision with root package name */
    public TextView f9045o;

    /* renamed from: p, reason: collision with root package name */
    public TextView f9046p;

    /* renamed from: q, reason: collision with root package name */
    public TextView f9047q;

    /* renamed from: r, reason: collision with root package name */
    public TextView f9048r;

    /* renamed from: s, reason: collision with root package name */
    public TextView f9049s;
    public TextView t;

    /* renamed from: u, reason: collision with root package name */
    public TextView f9050u;

    /* renamed from: v, reason: collision with root package name */
    public TextView f9051v;

    /* renamed from: w, reason: collision with root package name */
    public TextView f9052w;

    /* renamed from: x, reason: collision with root package name */
    public TextView f9053x;
    public TextView y;

    /* renamed from: z, reason: collision with root package name */
    public TextView f9054z;

    public static void a(TextView textView, TextView textView2, String str, String str2) {
        if (str.length() > 0 && textView != null) {
            textView.setText(str);
        }
        if (str2.length() > 0) {
            if (textView2 == null) {
                return;
            }
            textView2.setText(str2);
        } else {
            if (textView != null) {
                textView.setVisibility(8);
            }
            if (textView2 == null) {
                return;
            }
            textView2.setVisibility(8);
        }
    }

    @Override // l9.a, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        b bVar = arguments == null ? null : (b) l5.a.a(arguments, "partner_detail_args", b.class);
        if (bVar == null) {
            bVar = new b((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, 0, (String) null, 65535);
        }
        this.F = bVar;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        ViewModelStore viewModelStore = activity.getViewModelStore();
        viewModelStore.getClass();
        this.G = (e) new ViewModelProvider(viewModelStore, new i(3)).get(e.class);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View viewInflate = layoutInflater.inflate(R.layout.dialog_partners_detail, viewGroup, false);
        viewInflate.getClass();
        return viewInflate;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    @Override // l9.a, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onViewCreated(android.view.View r14, android.os.Bundle r15) {
        /*
            Method dump skipped, instructions count: 1185
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i6.d.onViewCreated(android.view.View, android.os.Bundle):void");
    }
}
