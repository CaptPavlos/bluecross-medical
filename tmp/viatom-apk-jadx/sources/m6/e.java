package m6;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.uptodown.R;
import java.util.List;
import o7.i;
import o7.k;
import t6.l;
import t6.m;
import t6.t;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e extends k.a {

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f11220m = 0;

    /* renamed from: a, reason: collision with root package name */
    public ConstraintLayout f11221a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f11222b;

    /* renamed from: c, reason: collision with root package name */
    public Button f11223c;

    /* renamed from: d, reason: collision with root package name */
    public Button f11224d;
    public Button e;
    public TextView f;
    public TextView g;
    public TextView h;

    /* renamed from: i, reason: collision with root package name */
    public f f11225i;

    /* renamed from: j, reason: collision with root package name */
    public Typeface f11226j;

    /* renamed from: k, reason: collision with root package name */
    public Typeface f11227k;

    /* renamed from: l, reason: collision with root package name */
    public d9.d f11228l;

    @Override // k.a
    public final void b(ViewStub viewStub) {
        viewStub.setLayoutResource(R.layout.gdpr_privacy_bottom_sheet);
        View viewInflate = viewStub.inflate();
        viewInflate.getClass();
        this.f11221a = (ConstraintLayout) viewInflate.findViewById(R.id.privacy_container);
        this.f11222b = (ImageView) viewInflate.findViewById(R.id.iv_cmp_logo);
        this.f11223c = (Button) viewInflate.findViewById(R.id.btn_more_options);
        this.f11224d = (Button) viewInflate.findViewById(R.id.btn_disagree);
        this.e = (Button) viewInflate.findViewById(R.id.btn_agree);
        this.f = (TextView) viewInflate.findViewById(R.id.tv_login_and_continue);
        this.g = (TextView) viewInflate.findViewById(R.id.tv_message);
        this.h = (TextView) viewInflate.findViewById(R.id.tv_title);
    }

    public final void c(String str, SpannableString spannableString, String str2, ClickableSpan clickableSpan, boolean z9) {
        Object next;
        List listQ;
        str2.getClass();
        n7.d dVarA = k.a(new k(str2, 0), str);
        if (((g7.a) dVarA.f11575b).invoke() == null) {
            dVarA = null;
        }
        if (dVarA == null) {
            listQ = null;
        } else {
            if (z9) {
                n7.e eVar = new n7.e(dVarA);
                if (!eVar.hasNext()) {
                    com.google.gson.internal.a.o("Sequence is empty.");
                    return;
                } else {
                    next = eVar.next();
                    while (eVar.hasNext()) {
                        next = eVar.next();
                    }
                }
            } else {
                n7.e eVar2 = new n7.e(dVarA);
                if (!eVar2.hasNext()) {
                    com.google.gson.internal.a.o("Sequence is empty.");
                    return;
                }
                next = eVar2.next();
            }
            l7.d dVarB = ((i) next).b();
            listQ = m.Q(Integer.valueOf(dVarB.f11084a), Integer.valueOf(str2.length() + dVarB.f11084a));
        }
        if (listQ == null) {
            listQ = t.f12808a;
        }
        if (listQ.isEmpty()) {
            return;
        }
        spannableString.setSpan(clickableSpan, ((Number) l.c0(listQ)).intValue(), ((Number) l.i0(listQ)).intValue(), 33);
        Context context = getContext();
        if (context == null) {
            return;
        }
        d9.d dVar = this.f11228l;
        Integer num = dVar != null ? dVar.f7478l : null;
        spannableString.setSpan(new ForegroundColorSpan(num == null ? ContextCompat.getColor(context, R.color.colorBlueAccent) : num.intValue()), ((Number) l.c0(listQ)).intValue(), ((Number) l.i0(listQ)).intValue(), 33);
    }

    @Override // k.a, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        ViewModelStore viewModelStore = activity.getViewModelStore();
        viewModelStore.getClass();
        this.f11225i = (f) new ViewModelProvider(viewModelStore, new c6.i(8)).get(f.class);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00a2  */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.lang.Object, java.util.List] */
    @Override // k.a, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onViewCreated(android.view.View r12, android.os.Bundle r13) {
        /*
            Method dump skipped, instructions count: 969
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m6.e.onViewCreated(android.view.View, android.os.Bundle):void");
    }
}
