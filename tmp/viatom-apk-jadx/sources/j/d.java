package j;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.RecyclerView;
import c.h;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.Vector;
import com.inmobi.cmp.core.model.gbc.GoogleBasicConsents;
import com.inmobi.cmp.core.model.portalconfig.GBCConsentValue;
import com.uptodown.R;
import d0.i;
import f6.o;
import java.util.ArrayList;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class d extends Fragment implements c.b {
    public static final /* synthetic */ int g = 0;

    /* renamed from: a, reason: collision with root package name */
    public TextView f9870a;

    /* renamed from: b, reason: collision with root package name */
    public RecyclerView f9871b;

    /* renamed from: c, reason: collision with root package name */
    public c f9872c;

    /* renamed from: d, reason: collision with root package name */
    public d9.d f9873d;
    public Typeface e;
    public Typeface f;

    public final void a() {
        c cVar = this.f9872c;
        if (cVar == null) {
            l.i("viewModel");
            throw null;
        }
        RecyclerView recyclerView = this.f9871b;
        RecyclerView.Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
        if (adapter == null) {
            androidx.window.layout.c.k("null cannot be cast to non-null type com.inmobi.cmp.presentation.components.switchlist.SwitchAdapter");
            return;
        }
        ArrayList arrayList = ((c.g) adapter).f958a;
        arrayList.getClass();
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            h hVar = (h) obj;
            Boolean bool = hVar.f965b;
            k8.d dVar = hVar.f964a;
            if (l.a(bool, Boolean.TRUE)) {
                boolean z9 = g.f9878a;
                int i11 = dVar.f10088a;
                GBCConsentValue.GRANTED.getClass();
                g.f9879b.set(i11);
            } else {
                boolean z10 = g.f9878a;
                int i12 = dVar.f10088a;
                GBCConsentValue gBCConsentValue = GBCConsentValue.DENIED;
                gBCConsentValue.getClass();
                if (gBCConsentValue == GBCConsentValue.GRANTED) {
                    g.f9879b.set(i12);
                } else {
                    g.f9879b.unset(i12);
                }
            }
        }
        i iVar = cVar.f9866a;
        boolean z11 = g.f9878a;
        Vector vectorV = iVar.v(40);
        Vector vector = g.f9879b;
        vector.getClass();
        if (vectorV != null) {
            vectorV.forEach(new o(2, vector));
        }
        iVar.n(40, vector);
        ChoiceCmpCallback choiceCmpCallback = cVar.f9867b;
        if (choiceCmpCallback == null) {
            return;
        }
        choiceCmpCallback.onGoogleBasicConsentChange(new GoogleBasicConsents(c.a("adStorage", arrayList), c.a("adUserData", arrayList), c.a("adPersonalization", arrayList), c.a("analyticsStorage", arrayList)));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getActivity() == null) {
            return;
        }
        ViewModelStore viewModelStore = getViewModelStore();
        viewModelStore.getClass();
        this.f9872c = (c) new ViewModelProvider(viewModelStore, new c6.i(4)).get(c.class);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View viewInflate = layoutInflater.inflate(R.layout.gbc_purpose_container, viewGroup, false);
        viewInflate.getClass();
        return viewInflate;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00e1  */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.Iterable, java.lang.Object] */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onViewCreated(android.view.View r25, android.os.Bundle r26) {
        /*
            Method dump skipped, instructions count: 393
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j.d.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    @Override // c.b
    public final void g(h hVar) {
    }

    @Override // c.b
    public final void h(h hVar) {
    }
}
