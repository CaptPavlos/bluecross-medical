package n4;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.FeedActivity;
import com.uptodown.activities.PublicListActivity;
import com.uptodown.activities.RepliesActivity;
import com.uptodown.util.views.UsernameTextView;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f11309a;

    /* renamed from: b, reason: collision with root package name */
    public final d0.i f11310b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f11311c;

    public c(ArrayList arrayList, d0.i iVar) {
        arrayList.getClass();
        iVar.getClass();
        this.f11309a = arrayList;
        this.f11310b = iVar;
    }

    public final void a(boolean z9) {
        this.f11311c = z9;
        if (z9) {
            notifyItemInserted(getItemCount());
        } else {
            notifyItemRemoved(getItemCount());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f11309a.size() + (this.f11311c ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i10) {
        ArrayList arrayList = this.f11309a;
        if (i10 == arrayList.size()) {
            return 2;
        }
        Object obj = arrayList.get(i10);
        obj.getClass();
        return kotlin.jvm.internal.l.a(((h5.v) obj).f8759b, "subscription") ? 1 : 0;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        viewHolder.getClass();
        boolean z9 = viewHolder instanceof y5.n;
        ArrayList arrayList = this.f11309a;
        if (!z9) {
            if (viewHolder instanceof y5.q) {
                final y5.q qVar = (y5.q) viewHolder;
                Object obj = arrayList.get(i10);
                obj.getClass();
                final h5.v vVar = (h5.v) obj;
                j4.y yVarD = j4.y.d();
                String str = vVar.h;
                j4.d0 d0VarE = yVarD.e(str != null ? a3.a.o(a3.a.v(str), UptodownApp.N, ":webp") : null);
                float f = UptodownApp.E;
                Context context = qVar.f13971c;
                context.getClass();
                d0VarE.g(k4.c.y(context));
                d5.n nVar = qVar.f13969a;
                ImageView imageView = (ImageView) nVar.f7241c;
                ImageView imageView2 = (ImageView) nVar.f7242d;
                TextView textView = (TextView) nVar.h;
                UsernameTextView usernameTextView = (UsernameTextView) nVar.f7244j;
                d0VarE.e(imageView, null);
                ((ImageView) nVar.e).setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_feed_subscription));
                final int i11 = 0;
                ((RelativeLayout) nVar.f7243i).setOnClickListener(new View.OnClickListener() { // from class: y5.o
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        switch (i11) {
                            case 0:
                                qVar.f13970b.B(vVar.f8760c);
                                break;
                            default:
                                qVar.f13970b.B(vVar.f8760c);
                                break;
                        }
                    }
                });
                int i12 = vVar.g;
                ImageView imageView3 = (ImageView) nVar.f7241c;
                if (i12 == 1) {
                    int dimension = (int) imageView3.getContext().getResources().getDimension(R.dimen.border_radius_xs);
                    imageView3.setForeground(ContextCompat.getDrawable(imageView3.getContext(), R.drawable.shape_stroke_review_avatar_turbo));
                    imageView3.setPadding(dimension, dimension, dimension, dimension);
                    imageView2.setVisibility(0);
                } else {
                    imageView3.setForeground(null);
                    imageView3.setPadding(0, 0, 0, 0);
                    imageView2.setVisibility(8);
                }
                usernameTextView.setText(vVar.f8761d);
                int i13 = UsernameTextView.f6728j;
                final int i14 = 1;
                l1.b.j(usernameTextView, vVar.g == 1, vVar.f8763j);
                usernameTextView.setOnClickListener(new View.OnClickListener() { // from class: y5.o
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        switch (i14) {
                            case 0:
                                qVar.f13970b.B(vVar.f8760c);
                                break;
                            default:
                                qVar.f13970b.B(vVar.f8760c);
                                break;
                        }
                    }
                });
                ((TextView) nVar.g).setText(vVar.f);
                ((TextView) nVar.f).setText(vVar.f8762i);
                h5.e1 e1VarH = h5.c1.h(context);
                if (e1VarH == null || !e1VarH.d()) {
                    textView.setVisibility(8);
                    return;
                } else {
                    textView.setOnClickListener(new y5.p(qVar, 0));
                    textView.setVisibility(0);
                    return;
                }
            }
            return;
        }
        final y5.n nVar2 = (y5.n) viewHolder;
        Object obj2 = arrayList.get(i10);
        obj2.getClass();
        final h5.v vVar2 = (h5.v) obj2;
        Context context2 = nVar2.f13943c;
        d5.n nVar3 = nVar2.f13941a;
        j4.y yVarD2 = j4.y.d();
        String str2 = vVar2.h;
        j4.d0 d0VarE2 = yVarD2.e(str2 != null ? a3.a.o(a3.a.v(str2), UptodownApp.F, ":webp") : null);
        float f10 = UptodownApp.E;
        context2.getClass();
        d0VarE2.g(k4.c.z(context2));
        ImageView imageView4 = (ImageView) nVar3.f7241c;
        ImageView imageView5 = (ImageView) nVar3.f7242d;
        ImageView imageView6 = (ImageView) nVar3.f;
        FrameLayout frameLayout = (FrameLayout) nVar3.f7243i;
        UsernameTextView usernameTextView2 = (UsernameTextView) nVar3.f7244j;
        d0VarE2.e(imageView4, null);
        final int i15 = 4;
        ((ImageView) nVar3.f7241c).setOnClickListener(new View.OnClickListener() { // from class: y5.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i16 = i15;
                h5.v vVar3 = vVar2;
                n nVar4 = nVar2;
                switch (i16) {
                    case 0:
                        nVar4.f13942b.A(vVar3.f8772s, vVar3.f8773u);
                        break;
                    case 1:
                        d0.i iVar = nVar4.f13942b;
                        int i17 = iVar.f6780a;
                        Object obj3 = iVar.f6781b;
                        switch (i17) {
                            case 11:
                                e5.m1 m1Var = (e5.m1) obj3;
                                float f11 = UptodownApp.E;
                                if (k4.c.s()) {
                                    h5.t0 t0Var = new h5.t0();
                                    t0Var.f8739a = vVar3.f8771r;
                                    t0Var.f8740b = String.valueOf(vVar3.f8764k);
                                    t0Var.f8741c = vVar3.f8761d;
                                    t0Var.f8748n = vVar3.f8763j;
                                    t0Var.f = vVar3.f8765l;
                                    t0Var.f8747m = vVar3.g;
                                    t0Var.g = vVar3.f8766m;
                                    t0Var.f8742d = vVar3.h;
                                    t0Var.f8743i = vVar3.f8762i;
                                    t0Var.f8746l = vVar3.t;
                                    t0Var.f8744j = vVar3.f8776x;
                                    t0Var.f8749o = 1;
                                    Intent intent = new Intent(m1Var.requireContext(), (Class<?>) RepliesActivity.class);
                                    intent.putExtra("review", t0Var);
                                    intent.putExtra("appName", vVar3.t);
                                    intent.putExtra("appIconUrl", vVar3.f8775w);
                                    FragmentActivity fragmentActivityRequireActivity = m1Var.requireActivity();
                                    fragmentActivityRequireActivity.getClass();
                                    m1Var.startActivity(intent, k4.c.a(fragmentActivityRequireActivity));
                                    break;
                                }
                                break;
                            default:
                                FeedActivity feedActivity = (FeedActivity) obj3;
                                float f12 = UptodownApp.E;
                                if (k4.c.s()) {
                                    h5.t0 t0Var2 = new h5.t0();
                                    t0Var2.f8739a = vVar3.f8771r;
                                    t0Var2.f8740b = String.valueOf(vVar3.f8764k);
                                    t0Var2.f8741c = vVar3.f8761d;
                                    t0Var2.f8748n = vVar3.f8763j;
                                    t0Var2.f = vVar3.f8765l;
                                    t0Var2.f8747m = vVar3.g;
                                    t0Var2.g = vVar3.f8766m;
                                    t0Var2.f8742d = vVar3.h;
                                    t0Var2.f8743i = vVar3.f8762i;
                                    t0Var2.f8746l = vVar3.t;
                                    t0Var2.f8744j = vVar3.f8776x;
                                    t0Var2.f8749o = 1;
                                    Intent intent2 = new Intent(feedActivity, (Class<?>) RepliesActivity.class);
                                    intent2.putExtra("review", t0Var2);
                                    intent2.putExtra("appName", vVar3.t);
                                    intent2.putExtra("appIconUrl", vVar3.f8775w);
                                    intent2.putExtra("appUrl", vVar3.f8773u);
                                    feedActivity.startActivity(intent2, k4.c.a(feedActivity));
                                    break;
                                }
                                break;
                        }
                    case 2:
                        nVar4.f13942b.A(vVar3.f8772s, vVar3.f8773u);
                        break;
                    case 3:
                        d0.i iVar2 = nVar4.f13942b;
                        long j10 = vVar3.f8760c;
                        String str3 = vVar3.f8761d;
                        switch (iVar2.f6780a) {
                            case 11:
                                e5.m1 m1Var2 = (e5.m1) iVar2.f6781b;
                                float f13 = UptodownApp.E;
                                if (k4.c.s()) {
                                    h5.e1 e1Var = new h5.e1();
                                    e1Var.f8512a = String.valueOf(j10);
                                    e1Var.f8515d = str3;
                                    Intent intent3 = new Intent(m1Var2.requireContext(), (Class<?>) PublicListActivity.class);
                                    intent3.putExtra("user", e1Var);
                                    FragmentActivity fragmentActivityRequireActivity2 = m1Var2.requireActivity();
                                    fragmentActivityRequireActivity2.getClass();
                                    m1Var2.startActivity(intent3, k4.c.a(fragmentActivityRequireActivity2));
                                    break;
                                }
                                break;
                            default:
                                FeedActivity feedActivity2 = (FeedActivity) iVar2.f6781b;
                                float f14 = UptodownApp.E;
                                if (k4.c.s()) {
                                    h5.e1 e1Var2 = new h5.e1();
                                    e1Var2.f8512a = String.valueOf(j10);
                                    e1Var2.f8515d = str3;
                                    Intent intent4 = new Intent(feedActivity2, (Class<?>) PublicListActivity.class);
                                    intent4.putExtra("user", e1Var2);
                                    feedActivity2.startActivity(intent4, k4.c.a(feedActivity2));
                                    break;
                                }
                                break;
                        }
                    case 4:
                        nVar4.f13942b.B(vVar3.f8760c);
                        break;
                    case 5:
                        nVar4.f13942b.B(vVar3.f8760c);
                        break;
                    case 6:
                        d0.i iVar3 = nVar4.f13942b;
                        long j11 = vVar3.f8760c;
                        switch (iVar3.f6780a) {
                            case 11:
                                e5.m1 m1Var3 = (e5.m1) iVar3.f6781b;
                                float f15 = UptodownApp.E;
                                if (k4.c.s()) {
                                    l4.f0 f0VarB = m1Var3.b();
                                    Context contextRequireContext = m1Var3.requireContext();
                                    contextRequireContext.getClass();
                                    String strValueOf = String.valueOf(j11);
                                    f0VarB.getClass();
                                    strValueOf.getClass();
                                    r7.w viewModelScope = ViewModelKt.getViewModelScope(f0VarB);
                                    y7.e eVar = r7.i0.f12407a;
                                    r7.y.q(viewModelScope, y7.d.f14116a, null, new b9.p((Object) f0VarB, (Object) contextRequireContext, strValueOf, (w6.c) null, 8), 2);
                                    break;
                                }
                                break;
                            default:
                                FeedActivity feedActivity3 = (FeedActivity) iVar3.f6781b;
                                float f16 = UptodownApp.E;
                                if (k4.c.s()) {
                                    int i18 = FeedActivity.L;
                                    l4.f0 f0VarO0 = feedActivity3.o0();
                                    String strValueOf2 = String.valueOf(j11);
                                    f0VarO0.getClass();
                                    strValueOf2.getClass();
                                    r7.w viewModelScope2 = ViewModelKt.getViewModelScope(f0VarO0);
                                    y7.e eVar2 = r7.i0.f12407a;
                                    r7.y.q(viewModelScope2, y7.d.f14116a, null, new b9.p((Object) f0VarO0, (Object) feedActivity3, strValueOf2, (w6.c) null, 8), 2);
                                    break;
                                }
                                break;
                        }
                    default:
                        nVar4.f13942b.A(vVar3.f8772s, vVar3.f8773u);
                        break;
                }
            }
        });
        int i16 = vVar2.g;
        ImageView imageView7 = (ImageView) nVar3.e;
        if (i16 == 1) {
            imageView7.setVisibility(0);
        } else {
            imageView7.setVisibility(8);
        }
        usernameTextView2.setText(vVar2.f8761d);
        int i17 = UsernameTextView.f6728j;
        l1.b.j(usernameTextView2, vVar2.g == 1, vVar2.f8763j);
        final int i18 = 5;
        usernameTextView2.setOnClickListener(new View.OnClickListener() { // from class: y5.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i162 = i18;
                h5.v vVar3 = vVar2;
                n nVar4 = nVar2;
                switch (i162) {
                    case 0:
                        nVar4.f13942b.A(vVar3.f8772s, vVar3.f8773u);
                        break;
                    case 1:
                        d0.i iVar = nVar4.f13942b;
                        int i172 = iVar.f6780a;
                        Object obj3 = iVar.f6781b;
                        switch (i172) {
                            case 11:
                                e5.m1 m1Var = (e5.m1) obj3;
                                float f11 = UptodownApp.E;
                                if (k4.c.s()) {
                                    h5.t0 t0Var = new h5.t0();
                                    t0Var.f8739a = vVar3.f8771r;
                                    t0Var.f8740b = String.valueOf(vVar3.f8764k);
                                    t0Var.f8741c = vVar3.f8761d;
                                    t0Var.f8748n = vVar3.f8763j;
                                    t0Var.f = vVar3.f8765l;
                                    t0Var.f8747m = vVar3.g;
                                    t0Var.g = vVar3.f8766m;
                                    t0Var.f8742d = vVar3.h;
                                    t0Var.f8743i = vVar3.f8762i;
                                    t0Var.f8746l = vVar3.t;
                                    t0Var.f8744j = vVar3.f8776x;
                                    t0Var.f8749o = 1;
                                    Intent intent = new Intent(m1Var.requireContext(), (Class<?>) RepliesActivity.class);
                                    intent.putExtra("review", t0Var);
                                    intent.putExtra("appName", vVar3.t);
                                    intent.putExtra("appIconUrl", vVar3.f8775w);
                                    FragmentActivity fragmentActivityRequireActivity = m1Var.requireActivity();
                                    fragmentActivityRequireActivity.getClass();
                                    m1Var.startActivity(intent, k4.c.a(fragmentActivityRequireActivity));
                                    break;
                                }
                                break;
                            default:
                                FeedActivity feedActivity = (FeedActivity) obj3;
                                float f12 = UptodownApp.E;
                                if (k4.c.s()) {
                                    h5.t0 t0Var2 = new h5.t0();
                                    t0Var2.f8739a = vVar3.f8771r;
                                    t0Var2.f8740b = String.valueOf(vVar3.f8764k);
                                    t0Var2.f8741c = vVar3.f8761d;
                                    t0Var2.f8748n = vVar3.f8763j;
                                    t0Var2.f = vVar3.f8765l;
                                    t0Var2.f8747m = vVar3.g;
                                    t0Var2.g = vVar3.f8766m;
                                    t0Var2.f8742d = vVar3.h;
                                    t0Var2.f8743i = vVar3.f8762i;
                                    t0Var2.f8746l = vVar3.t;
                                    t0Var2.f8744j = vVar3.f8776x;
                                    t0Var2.f8749o = 1;
                                    Intent intent2 = new Intent(feedActivity, (Class<?>) RepliesActivity.class);
                                    intent2.putExtra("review", t0Var2);
                                    intent2.putExtra("appName", vVar3.t);
                                    intent2.putExtra("appIconUrl", vVar3.f8775w);
                                    intent2.putExtra("appUrl", vVar3.f8773u);
                                    feedActivity.startActivity(intent2, k4.c.a(feedActivity));
                                    break;
                                }
                                break;
                        }
                    case 2:
                        nVar4.f13942b.A(vVar3.f8772s, vVar3.f8773u);
                        break;
                    case 3:
                        d0.i iVar2 = nVar4.f13942b;
                        long j10 = vVar3.f8760c;
                        String str3 = vVar3.f8761d;
                        switch (iVar2.f6780a) {
                            case 11:
                                e5.m1 m1Var2 = (e5.m1) iVar2.f6781b;
                                float f13 = UptodownApp.E;
                                if (k4.c.s()) {
                                    h5.e1 e1Var = new h5.e1();
                                    e1Var.f8512a = String.valueOf(j10);
                                    e1Var.f8515d = str3;
                                    Intent intent3 = new Intent(m1Var2.requireContext(), (Class<?>) PublicListActivity.class);
                                    intent3.putExtra("user", e1Var);
                                    FragmentActivity fragmentActivityRequireActivity2 = m1Var2.requireActivity();
                                    fragmentActivityRequireActivity2.getClass();
                                    m1Var2.startActivity(intent3, k4.c.a(fragmentActivityRequireActivity2));
                                    break;
                                }
                                break;
                            default:
                                FeedActivity feedActivity2 = (FeedActivity) iVar2.f6781b;
                                float f14 = UptodownApp.E;
                                if (k4.c.s()) {
                                    h5.e1 e1Var2 = new h5.e1();
                                    e1Var2.f8512a = String.valueOf(j10);
                                    e1Var2.f8515d = str3;
                                    Intent intent4 = new Intent(feedActivity2, (Class<?>) PublicListActivity.class);
                                    intent4.putExtra("user", e1Var2);
                                    feedActivity2.startActivity(intent4, k4.c.a(feedActivity2));
                                    break;
                                }
                                break;
                        }
                    case 4:
                        nVar4.f13942b.B(vVar3.f8760c);
                        break;
                    case 5:
                        nVar4.f13942b.B(vVar3.f8760c);
                        break;
                    case 6:
                        d0.i iVar3 = nVar4.f13942b;
                        long j11 = vVar3.f8760c;
                        switch (iVar3.f6780a) {
                            case 11:
                                e5.m1 m1Var3 = (e5.m1) iVar3.f6781b;
                                float f15 = UptodownApp.E;
                                if (k4.c.s()) {
                                    l4.f0 f0VarB = m1Var3.b();
                                    Context contextRequireContext = m1Var3.requireContext();
                                    contextRequireContext.getClass();
                                    String strValueOf = String.valueOf(j11);
                                    f0VarB.getClass();
                                    strValueOf.getClass();
                                    r7.w viewModelScope = ViewModelKt.getViewModelScope(f0VarB);
                                    y7.e eVar = r7.i0.f12407a;
                                    r7.y.q(viewModelScope, y7.d.f14116a, null, new b9.p((Object) f0VarB, (Object) contextRequireContext, strValueOf, (w6.c) null, 8), 2);
                                    break;
                                }
                                break;
                            default:
                                FeedActivity feedActivity3 = (FeedActivity) iVar3.f6781b;
                                float f16 = UptodownApp.E;
                                if (k4.c.s()) {
                                    int i182 = FeedActivity.L;
                                    l4.f0 f0VarO0 = feedActivity3.o0();
                                    String strValueOf2 = String.valueOf(j11);
                                    f0VarO0.getClass();
                                    strValueOf2.getClass();
                                    r7.w viewModelScope2 = ViewModelKt.getViewModelScope(f0VarO0);
                                    y7.e eVar2 = r7.i0.f12407a;
                                    r7.y.q(viewModelScope2, y7.d.f14116a, null, new b9.p((Object) f0VarO0, (Object) feedActivity3, strValueOf2, (w6.c) null, 8), 2);
                                    break;
                                }
                                break;
                        }
                    default:
                        nVar4.f13942b.A(vVar3.f8772s, vVar3.f8773u);
                        break;
                }
            }
        });
        ((TextView) nVar3.g).setText(vVar2.f);
        ((TextView) nVar3.h).setText(vVar2.f8762i);
        frameLayout.setVisibility(0);
        imageView5.setVisibility(8);
        frameLayout.removeAllViews();
        String str3 = vVar2.f8759b;
        if (str3 != null) {
            switch (str3.hashCode()) {
                case -1268958287:
                    if (str3.equals("follow")) {
                        imageView6.setImageDrawable(ContextCompat.getDrawable(context2, R.drawable.vector_feed_follow));
                        frameLayout.setVisibility(8);
                        imageView5.setVisibility(0);
                        final int i19 = 6;
                        imageView5.setOnClickListener(new View.OnClickListener() { // from class: y5.m
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                int i162 = i19;
                                h5.v vVar3 = vVar2;
                                n nVar4 = nVar2;
                                switch (i162) {
                                    case 0:
                                        nVar4.f13942b.A(vVar3.f8772s, vVar3.f8773u);
                                        break;
                                    case 1:
                                        d0.i iVar = nVar4.f13942b;
                                        int i172 = iVar.f6780a;
                                        Object obj3 = iVar.f6781b;
                                        switch (i172) {
                                            case 11:
                                                e5.m1 m1Var = (e5.m1) obj3;
                                                float f11 = UptodownApp.E;
                                                if (k4.c.s()) {
                                                    h5.t0 t0Var = new h5.t0();
                                                    t0Var.f8739a = vVar3.f8771r;
                                                    t0Var.f8740b = String.valueOf(vVar3.f8764k);
                                                    t0Var.f8741c = vVar3.f8761d;
                                                    t0Var.f8748n = vVar3.f8763j;
                                                    t0Var.f = vVar3.f8765l;
                                                    t0Var.f8747m = vVar3.g;
                                                    t0Var.g = vVar3.f8766m;
                                                    t0Var.f8742d = vVar3.h;
                                                    t0Var.f8743i = vVar3.f8762i;
                                                    t0Var.f8746l = vVar3.t;
                                                    t0Var.f8744j = vVar3.f8776x;
                                                    t0Var.f8749o = 1;
                                                    Intent intent = new Intent(m1Var.requireContext(), (Class<?>) RepliesActivity.class);
                                                    intent.putExtra("review", t0Var);
                                                    intent.putExtra("appName", vVar3.t);
                                                    intent.putExtra("appIconUrl", vVar3.f8775w);
                                                    FragmentActivity fragmentActivityRequireActivity = m1Var.requireActivity();
                                                    fragmentActivityRequireActivity.getClass();
                                                    m1Var.startActivity(intent, k4.c.a(fragmentActivityRequireActivity));
                                                    break;
                                                }
                                                break;
                                            default:
                                                FeedActivity feedActivity = (FeedActivity) obj3;
                                                float f12 = UptodownApp.E;
                                                if (k4.c.s()) {
                                                    h5.t0 t0Var2 = new h5.t0();
                                                    t0Var2.f8739a = vVar3.f8771r;
                                                    t0Var2.f8740b = String.valueOf(vVar3.f8764k);
                                                    t0Var2.f8741c = vVar3.f8761d;
                                                    t0Var2.f8748n = vVar3.f8763j;
                                                    t0Var2.f = vVar3.f8765l;
                                                    t0Var2.f8747m = vVar3.g;
                                                    t0Var2.g = vVar3.f8766m;
                                                    t0Var2.f8742d = vVar3.h;
                                                    t0Var2.f8743i = vVar3.f8762i;
                                                    t0Var2.f8746l = vVar3.t;
                                                    t0Var2.f8744j = vVar3.f8776x;
                                                    t0Var2.f8749o = 1;
                                                    Intent intent2 = new Intent(feedActivity, (Class<?>) RepliesActivity.class);
                                                    intent2.putExtra("review", t0Var2);
                                                    intent2.putExtra("appName", vVar3.t);
                                                    intent2.putExtra("appIconUrl", vVar3.f8775w);
                                                    intent2.putExtra("appUrl", vVar3.f8773u);
                                                    feedActivity.startActivity(intent2, k4.c.a(feedActivity));
                                                    break;
                                                }
                                                break;
                                        }
                                    case 2:
                                        nVar4.f13942b.A(vVar3.f8772s, vVar3.f8773u);
                                        break;
                                    case 3:
                                        d0.i iVar2 = nVar4.f13942b;
                                        long j10 = vVar3.f8760c;
                                        String str32 = vVar3.f8761d;
                                        switch (iVar2.f6780a) {
                                            case 11:
                                                e5.m1 m1Var2 = (e5.m1) iVar2.f6781b;
                                                float f13 = UptodownApp.E;
                                                if (k4.c.s()) {
                                                    h5.e1 e1Var = new h5.e1();
                                                    e1Var.f8512a = String.valueOf(j10);
                                                    e1Var.f8515d = str32;
                                                    Intent intent3 = new Intent(m1Var2.requireContext(), (Class<?>) PublicListActivity.class);
                                                    intent3.putExtra("user", e1Var);
                                                    FragmentActivity fragmentActivityRequireActivity2 = m1Var2.requireActivity();
                                                    fragmentActivityRequireActivity2.getClass();
                                                    m1Var2.startActivity(intent3, k4.c.a(fragmentActivityRequireActivity2));
                                                    break;
                                                }
                                                break;
                                            default:
                                                FeedActivity feedActivity2 = (FeedActivity) iVar2.f6781b;
                                                float f14 = UptodownApp.E;
                                                if (k4.c.s()) {
                                                    h5.e1 e1Var2 = new h5.e1();
                                                    e1Var2.f8512a = String.valueOf(j10);
                                                    e1Var2.f8515d = str32;
                                                    Intent intent4 = new Intent(feedActivity2, (Class<?>) PublicListActivity.class);
                                                    intent4.putExtra("user", e1Var2);
                                                    feedActivity2.startActivity(intent4, k4.c.a(feedActivity2));
                                                    break;
                                                }
                                                break;
                                        }
                                    case 4:
                                        nVar4.f13942b.B(vVar3.f8760c);
                                        break;
                                    case 5:
                                        nVar4.f13942b.B(vVar3.f8760c);
                                        break;
                                    case 6:
                                        d0.i iVar3 = nVar4.f13942b;
                                        long j11 = vVar3.f8760c;
                                        switch (iVar3.f6780a) {
                                            case 11:
                                                e5.m1 m1Var3 = (e5.m1) iVar3.f6781b;
                                                float f15 = UptodownApp.E;
                                                if (k4.c.s()) {
                                                    l4.f0 f0VarB = m1Var3.b();
                                                    Context contextRequireContext = m1Var3.requireContext();
                                                    contextRequireContext.getClass();
                                                    String strValueOf = String.valueOf(j11);
                                                    f0VarB.getClass();
                                                    strValueOf.getClass();
                                                    r7.w viewModelScope = ViewModelKt.getViewModelScope(f0VarB);
                                                    y7.e eVar = r7.i0.f12407a;
                                                    r7.y.q(viewModelScope, y7.d.f14116a, null, new b9.p((Object) f0VarB, (Object) contextRequireContext, strValueOf, (w6.c) null, 8), 2);
                                                    break;
                                                }
                                                break;
                                            default:
                                                FeedActivity feedActivity3 = (FeedActivity) iVar3.f6781b;
                                                float f16 = UptodownApp.E;
                                                if (k4.c.s()) {
                                                    int i182 = FeedActivity.L;
                                                    l4.f0 f0VarO0 = feedActivity3.o0();
                                                    String strValueOf2 = String.valueOf(j11);
                                                    f0VarO0.getClass();
                                                    strValueOf2.getClass();
                                                    r7.w viewModelScope2 = ViewModelKt.getViewModelScope(f0VarO0);
                                                    y7.e eVar2 = r7.i0.f12407a;
                                                    r7.y.q(viewModelScope2, y7.d.f14116a, null, new b9.p((Object) f0VarO0, (Object) feedActivity3, strValueOf2, (w6.c) null, 8), 2);
                                                    break;
                                                }
                                                break;
                                        }
                                    default:
                                        nVar4.f13942b.A(vVar3.f8772s, vVar3.f8773u);
                                        break;
                                }
                            }
                        });
                        break;
                    }
                    break;
                case -938102371:
                    if (str3.equals(CampaignEx.JSON_KEY_STAR)) {
                        d5.n nVarL = d5.n.l(LayoutInflater.from(context2));
                        TextView textView2 = (TextView) nVarL.g;
                        RelativeLayout relativeLayout = (RelativeLayout) nVarL.f7240b;
                        j4.y yVarD3 = j4.y.d();
                        String str4 = vVar2.f8775w;
                        j4.d0 d0VarE3 = yVarD3.e(str4 != null ? a3.a.o(a3.a.v(str4), UptodownApp.G, ":webp") : null);
                        d0VarE3.g(k4.c.y(context2));
                        d0VarE3.e((ImageView) nVarL.f7241c, null);
                        imageView6.setImageDrawable(ContextCompat.getDrawable(context2, R.drawable.vector_feed_review));
                        final int i20 = 7;
                        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: y5.m
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                int i162 = i20;
                                h5.v vVar3 = vVar2;
                                n nVar4 = nVar2;
                                switch (i162) {
                                    case 0:
                                        nVar4.f13942b.A(vVar3.f8772s, vVar3.f8773u);
                                        break;
                                    case 1:
                                        d0.i iVar = nVar4.f13942b;
                                        int i172 = iVar.f6780a;
                                        Object obj3 = iVar.f6781b;
                                        switch (i172) {
                                            case 11:
                                                e5.m1 m1Var = (e5.m1) obj3;
                                                float f11 = UptodownApp.E;
                                                if (k4.c.s()) {
                                                    h5.t0 t0Var = new h5.t0();
                                                    t0Var.f8739a = vVar3.f8771r;
                                                    t0Var.f8740b = String.valueOf(vVar3.f8764k);
                                                    t0Var.f8741c = vVar3.f8761d;
                                                    t0Var.f8748n = vVar3.f8763j;
                                                    t0Var.f = vVar3.f8765l;
                                                    t0Var.f8747m = vVar3.g;
                                                    t0Var.g = vVar3.f8766m;
                                                    t0Var.f8742d = vVar3.h;
                                                    t0Var.f8743i = vVar3.f8762i;
                                                    t0Var.f8746l = vVar3.t;
                                                    t0Var.f8744j = vVar3.f8776x;
                                                    t0Var.f8749o = 1;
                                                    Intent intent = new Intent(m1Var.requireContext(), (Class<?>) RepliesActivity.class);
                                                    intent.putExtra("review", t0Var);
                                                    intent.putExtra("appName", vVar3.t);
                                                    intent.putExtra("appIconUrl", vVar3.f8775w);
                                                    FragmentActivity fragmentActivityRequireActivity = m1Var.requireActivity();
                                                    fragmentActivityRequireActivity.getClass();
                                                    m1Var.startActivity(intent, k4.c.a(fragmentActivityRequireActivity));
                                                    break;
                                                }
                                                break;
                                            default:
                                                FeedActivity feedActivity = (FeedActivity) obj3;
                                                float f12 = UptodownApp.E;
                                                if (k4.c.s()) {
                                                    h5.t0 t0Var2 = new h5.t0();
                                                    t0Var2.f8739a = vVar3.f8771r;
                                                    t0Var2.f8740b = String.valueOf(vVar3.f8764k);
                                                    t0Var2.f8741c = vVar3.f8761d;
                                                    t0Var2.f8748n = vVar3.f8763j;
                                                    t0Var2.f = vVar3.f8765l;
                                                    t0Var2.f8747m = vVar3.g;
                                                    t0Var2.g = vVar3.f8766m;
                                                    t0Var2.f8742d = vVar3.h;
                                                    t0Var2.f8743i = vVar3.f8762i;
                                                    t0Var2.f8746l = vVar3.t;
                                                    t0Var2.f8744j = vVar3.f8776x;
                                                    t0Var2.f8749o = 1;
                                                    Intent intent2 = new Intent(feedActivity, (Class<?>) RepliesActivity.class);
                                                    intent2.putExtra("review", t0Var2);
                                                    intent2.putExtra("appName", vVar3.t);
                                                    intent2.putExtra("appIconUrl", vVar3.f8775w);
                                                    intent2.putExtra("appUrl", vVar3.f8773u);
                                                    feedActivity.startActivity(intent2, k4.c.a(feedActivity));
                                                    break;
                                                }
                                                break;
                                        }
                                    case 2:
                                        nVar4.f13942b.A(vVar3.f8772s, vVar3.f8773u);
                                        break;
                                    case 3:
                                        d0.i iVar2 = nVar4.f13942b;
                                        long j10 = vVar3.f8760c;
                                        String str32 = vVar3.f8761d;
                                        switch (iVar2.f6780a) {
                                            case 11:
                                                e5.m1 m1Var2 = (e5.m1) iVar2.f6781b;
                                                float f13 = UptodownApp.E;
                                                if (k4.c.s()) {
                                                    h5.e1 e1Var = new h5.e1();
                                                    e1Var.f8512a = String.valueOf(j10);
                                                    e1Var.f8515d = str32;
                                                    Intent intent3 = new Intent(m1Var2.requireContext(), (Class<?>) PublicListActivity.class);
                                                    intent3.putExtra("user", e1Var);
                                                    FragmentActivity fragmentActivityRequireActivity2 = m1Var2.requireActivity();
                                                    fragmentActivityRequireActivity2.getClass();
                                                    m1Var2.startActivity(intent3, k4.c.a(fragmentActivityRequireActivity2));
                                                    break;
                                                }
                                                break;
                                            default:
                                                FeedActivity feedActivity2 = (FeedActivity) iVar2.f6781b;
                                                float f14 = UptodownApp.E;
                                                if (k4.c.s()) {
                                                    h5.e1 e1Var2 = new h5.e1();
                                                    e1Var2.f8512a = String.valueOf(j10);
                                                    e1Var2.f8515d = str32;
                                                    Intent intent4 = new Intent(feedActivity2, (Class<?>) PublicListActivity.class);
                                                    intent4.putExtra("user", e1Var2);
                                                    feedActivity2.startActivity(intent4, k4.c.a(feedActivity2));
                                                    break;
                                                }
                                                break;
                                        }
                                    case 4:
                                        nVar4.f13942b.B(vVar3.f8760c);
                                        break;
                                    case 5:
                                        nVar4.f13942b.B(vVar3.f8760c);
                                        break;
                                    case 6:
                                        d0.i iVar3 = nVar4.f13942b;
                                        long j11 = vVar3.f8760c;
                                        switch (iVar3.f6780a) {
                                            case 11:
                                                e5.m1 m1Var3 = (e5.m1) iVar3.f6781b;
                                                float f15 = UptodownApp.E;
                                                if (k4.c.s()) {
                                                    l4.f0 f0VarB = m1Var3.b();
                                                    Context contextRequireContext = m1Var3.requireContext();
                                                    contextRequireContext.getClass();
                                                    String strValueOf = String.valueOf(j11);
                                                    f0VarB.getClass();
                                                    strValueOf.getClass();
                                                    r7.w viewModelScope = ViewModelKt.getViewModelScope(f0VarB);
                                                    y7.e eVar = r7.i0.f12407a;
                                                    r7.y.q(viewModelScope, y7.d.f14116a, null, new b9.p((Object) f0VarB, (Object) contextRequireContext, strValueOf, (w6.c) null, 8), 2);
                                                    break;
                                                }
                                                break;
                                            default:
                                                FeedActivity feedActivity3 = (FeedActivity) iVar3.f6781b;
                                                float f16 = UptodownApp.E;
                                                if (k4.c.s()) {
                                                    int i182 = FeedActivity.L;
                                                    l4.f0 f0VarO0 = feedActivity3.o0();
                                                    String strValueOf2 = String.valueOf(j11);
                                                    f0VarO0.getClass();
                                                    strValueOf2.getClass();
                                                    r7.w viewModelScope2 = ViewModelKt.getViewModelScope(f0VarO0);
                                                    y7.e eVar2 = r7.i0.f12407a;
                                                    r7.y.q(viewModelScope2, y7.d.f14116a, null, new b9.p((Object) f0VarO0, (Object) feedActivity3, strValueOf2, (w6.c) null, 8), 2);
                                                    break;
                                                }
                                                break;
                                        }
                                    default:
                                        nVar4.f13942b.A(vVar3.f8772s, vVar3.f8773u);
                                        break;
                                }
                            }
                        });
                        textView2.setTypeface(o4.b.f11719r);
                        textView2.setText(vVar2.t);
                        ((TextView) nVarL.h).setVisibility(8);
                        nVar2.a(vVar2, nVarL);
                        frameLayout.addView(relativeLayout);
                        break;
                    }
                    break;
                case 950398559:
                    if (str3.equals("comment")) {
                        d5.n nVarL2 = d5.n.l(LayoutInflater.from(context2));
                        RelativeLayout relativeLayout2 = (RelativeLayout) nVarL2.f7240b;
                        TextView textView3 = (TextView) nVarL2.h;
                        TextView textView4 = (TextView) nVarL2.g;
                        ImageView imageView8 = (ImageView) nVarL2.f7241c;
                        j4.y yVarD4 = j4.y.d();
                        String str5 = vVar2.f8775w;
                        j4.d0 d0VarE4 = yVarD4.e(str5 != null ? a3.a.o(a3.a.v(str5), UptodownApp.G, ":webp") : null);
                        d0VarE4.g(k4.c.y(context2));
                        d0VarE4.e(imageView8, null);
                        imageView6.setImageDrawable(ContextCompat.getDrawable(context2, R.drawable.vector_feed_review));
                        final int i21 = 0;
                        imageView8.setOnClickListener(new View.OnClickListener() { // from class: y5.m
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                int i162 = i21;
                                h5.v vVar3 = vVar2;
                                n nVar4 = nVar2;
                                switch (i162) {
                                    case 0:
                                        nVar4.f13942b.A(vVar3.f8772s, vVar3.f8773u);
                                        break;
                                    case 1:
                                        d0.i iVar = nVar4.f13942b;
                                        int i172 = iVar.f6780a;
                                        Object obj3 = iVar.f6781b;
                                        switch (i172) {
                                            case 11:
                                                e5.m1 m1Var = (e5.m1) obj3;
                                                float f11 = UptodownApp.E;
                                                if (k4.c.s()) {
                                                    h5.t0 t0Var = new h5.t0();
                                                    t0Var.f8739a = vVar3.f8771r;
                                                    t0Var.f8740b = String.valueOf(vVar3.f8764k);
                                                    t0Var.f8741c = vVar3.f8761d;
                                                    t0Var.f8748n = vVar3.f8763j;
                                                    t0Var.f = vVar3.f8765l;
                                                    t0Var.f8747m = vVar3.g;
                                                    t0Var.g = vVar3.f8766m;
                                                    t0Var.f8742d = vVar3.h;
                                                    t0Var.f8743i = vVar3.f8762i;
                                                    t0Var.f8746l = vVar3.t;
                                                    t0Var.f8744j = vVar3.f8776x;
                                                    t0Var.f8749o = 1;
                                                    Intent intent = new Intent(m1Var.requireContext(), (Class<?>) RepliesActivity.class);
                                                    intent.putExtra("review", t0Var);
                                                    intent.putExtra("appName", vVar3.t);
                                                    intent.putExtra("appIconUrl", vVar3.f8775w);
                                                    FragmentActivity fragmentActivityRequireActivity = m1Var.requireActivity();
                                                    fragmentActivityRequireActivity.getClass();
                                                    m1Var.startActivity(intent, k4.c.a(fragmentActivityRequireActivity));
                                                    break;
                                                }
                                                break;
                                            default:
                                                FeedActivity feedActivity = (FeedActivity) obj3;
                                                float f12 = UptodownApp.E;
                                                if (k4.c.s()) {
                                                    h5.t0 t0Var2 = new h5.t0();
                                                    t0Var2.f8739a = vVar3.f8771r;
                                                    t0Var2.f8740b = String.valueOf(vVar3.f8764k);
                                                    t0Var2.f8741c = vVar3.f8761d;
                                                    t0Var2.f8748n = vVar3.f8763j;
                                                    t0Var2.f = vVar3.f8765l;
                                                    t0Var2.f8747m = vVar3.g;
                                                    t0Var2.g = vVar3.f8766m;
                                                    t0Var2.f8742d = vVar3.h;
                                                    t0Var2.f8743i = vVar3.f8762i;
                                                    t0Var2.f8746l = vVar3.t;
                                                    t0Var2.f8744j = vVar3.f8776x;
                                                    t0Var2.f8749o = 1;
                                                    Intent intent2 = new Intent(feedActivity, (Class<?>) RepliesActivity.class);
                                                    intent2.putExtra("review", t0Var2);
                                                    intent2.putExtra("appName", vVar3.t);
                                                    intent2.putExtra("appIconUrl", vVar3.f8775w);
                                                    intent2.putExtra("appUrl", vVar3.f8773u);
                                                    feedActivity.startActivity(intent2, k4.c.a(feedActivity));
                                                    break;
                                                }
                                                break;
                                        }
                                    case 2:
                                        nVar4.f13942b.A(vVar3.f8772s, vVar3.f8773u);
                                        break;
                                    case 3:
                                        d0.i iVar2 = nVar4.f13942b;
                                        long j10 = vVar3.f8760c;
                                        String str32 = vVar3.f8761d;
                                        switch (iVar2.f6780a) {
                                            case 11:
                                                e5.m1 m1Var2 = (e5.m1) iVar2.f6781b;
                                                float f13 = UptodownApp.E;
                                                if (k4.c.s()) {
                                                    h5.e1 e1Var = new h5.e1();
                                                    e1Var.f8512a = String.valueOf(j10);
                                                    e1Var.f8515d = str32;
                                                    Intent intent3 = new Intent(m1Var2.requireContext(), (Class<?>) PublicListActivity.class);
                                                    intent3.putExtra("user", e1Var);
                                                    FragmentActivity fragmentActivityRequireActivity2 = m1Var2.requireActivity();
                                                    fragmentActivityRequireActivity2.getClass();
                                                    m1Var2.startActivity(intent3, k4.c.a(fragmentActivityRequireActivity2));
                                                    break;
                                                }
                                                break;
                                            default:
                                                FeedActivity feedActivity2 = (FeedActivity) iVar2.f6781b;
                                                float f14 = UptodownApp.E;
                                                if (k4.c.s()) {
                                                    h5.e1 e1Var2 = new h5.e1();
                                                    e1Var2.f8512a = String.valueOf(j10);
                                                    e1Var2.f8515d = str32;
                                                    Intent intent4 = new Intent(feedActivity2, (Class<?>) PublicListActivity.class);
                                                    intent4.putExtra("user", e1Var2);
                                                    feedActivity2.startActivity(intent4, k4.c.a(feedActivity2));
                                                    break;
                                                }
                                                break;
                                        }
                                    case 4:
                                        nVar4.f13942b.B(vVar3.f8760c);
                                        break;
                                    case 5:
                                        nVar4.f13942b.B(vVar3.f8760c);
                                        break;
                                    case 6:
                                        d0.i iVar3 = nVar4.f13942b;
                                        long j11 = vVar3.f8760c;
                                        switch (iVar3.f6780a) {
                                            case 11:
                                                e5.m1 m1Var3 = (e5.m1) iVar3.f6781b;
                                                float f15 = UptodownApp.E;
                                                if (k4.c.s()) {
                                                    l4.f0 f0VarB = m1Var3.b();
                                                    Context contextRequireContext = m1Var3.requireContext();
                                                    contextRequireContext.getClass();
                                                    String strValueOf = String.valueOf(j11);
                                                    f0VarB.getClass();
                                                    strValueOf.getClass();
                                                    r7.w viewModelScope = ViewModelKt.getViewModelScope(f0VarB);
                                                    y7.e eVar = r7.i0.f12407a;
                                                    r7.y.q(viewModelScope, y7.d.f14116a, null, new b9.p((Object) f0VarB, (Object) contextRequireContext, strValueOf, (w6.c) null, 8), 2);
                                                    break;
                                                }
                                                break;
                                            default:
                                                FeedActivity feedActivity3 = (FeedActivity) iVar3.f6781b;
                                                float f16 = UptodownApp.E;
                                                if (k4.c.s()) {
                                                    int i182 = FeedActivity.L;
                                                    l4.f0 f0VarO0 = feedActivity3.o0();
                                                    String strValueOf2 = String.valueOf(j11);
                                                    f0VarO0.getClass();
                                                    strValueOf2.getClass();
                                                    r7.w viewModelScope2 = ViewModelKt.getViewModelScope(f0VarO0);
                                                    y7.e eVar2 = r7.i0.f12407a;
                                                    r7.y.q(viewModelScope2, y7.d.f14116a, null, new b9.p((Object) f0VarO0, (Object) feedActivity3, strValueOf2, (w6.c) null, 8), 2);
                                                    break;
                                                }
                                                break;
                                        }
                                    default:
                                        nVar4.f13942b.A(vVar3.f8772s, vVar3.f8773u);
                                        break;
                                }
                            }
                        });
                        textView4.setTypeface(o4.b.f11719r);
                        textView4.setText(vVar2.t);
                        textView3.setTypeface(o4.b.f11720s);
                        textView3.setText(vVar2.f8765l);
                        final int i22 = 1;
                        relativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: y5.m
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                int i162 = i22;
                                h5.v vVar3 = vVar2;
                                n nVar4 = nVar2;
                                switch (i162) {
                                    case 0:
                                        nVar4.f13942b.A(vVar3.f8772s, vVar3.f8773u);
                                        break;
                                    case 1:
                                        d0.i iVar = nVar4.f13942b;
                                        int i172 = iVar.f6780a;
                                        Object obj3 = iVar.f6781b;
                                        switch (i172) {
                                            case 11:
                                                e5.m1 m1Var = (e5.m1) obj3;
                                                float f11 = UptodownApp.E;
                                                if (k4.c.s()) {
                                                    h5.t0 t0Var = new h5.t0();
                                                    t0Var.f8739a = vVar3.f8771r;
                                                    t0Var.f8740b = String.valueOf(vVar3.f8764k);
                                                    t0Var.f8741c = vVar3.f8761d;
                                                    t0Var.f8748n = vVar3.f8763j;
                                                    t0Var.f = vVar3.f8765l;
                                                    t0Var.f8747m = vVar3.g;
                                                    t0Var.g = vVar3.f8766m;
                                                    t0Var.f8742d = vVar3.h;
                                                    t0Var.f8743i = vVar3.f8762i;
                                                    t0Var.f8746l = vVar3.t;
                                                    t0Var.f8744j = vVar3.f8776x;
                                                    t0Var.f8749o = 1;
                                                    Intent intent = new Intent(m1Var.requireContext(), (Class<?>) RepliesActivity.class);
                                                    intent.putExtra("review", t0Var);
                                                    intent.putExtra("appName", vVar3.t);
                                                    intent.putExtra("appIconUrl", vVar3.f8775w);
                                                    FragmentActivity fragmentActivityRequireActivity = m1Var.requireActivity();
                                                    fragmentActivityRequireActivity.getClass();
                                                    m1Var.startActivity(intent, k4.c.a(fragmentActivityRequireActivity));
                                                    break;
                                                }
                                                break;
                                            default:
                                                FeedActivity feedActivity = (FeedActivity) obj3;
                                                float f12 = UptodownApp.E;
                                                if (k4.c.s()) {
                                                    h5.t0 t0Var2 = new h5.t0();
                                                    t0Var2.f8739a = vVar3.f8771r;
                                                    t0Var2.f8740b = String.valueOf(vVar3.f8764k);
                                                    t0Var2.f8741c = vVar3.f8761d;
                                                    t0Var2.f8748n = vVar3.f8763j;
                                                    t0Var2.f = vVar3.f8765l;
                                                    t0Var2.f8747m = vVar3.g;
                                                    t0Var2.g = vVar3.f8766m;
                                                    t0Var2.f8742d = vVar3.h;
                                                    t0Var2.f8743i = vVar3.f8762i;
                                                    t0Var2.f8746l = vVar3.t;
                                                    t0Var2.f8744j = vVar3.f8776x;
                                                    t0Var2.f8749o = 1;
                                                    Intent intent2 = new Intent(feedActivity, (Class<?>) RepliesActivity.class);
                                                    intent2.putExtra("review", t0Var2);
                                                    intent2.putExtra("appName", vVar3.t);
                                                    intent2.putExtra("appIconUrl", vVar3.f8775w);
                                                    intent2.putExtra("appUrl", vVar3.f8773u);
                                                    feedActivity.startActivity(intent2, k4.c.a(feedActivity));
                                                    break;
                                                }
                                                break;
                                        }
                                    case 2:
                                        nVar4.f13942b.A(vVar3.f8772s, vVar3.f8773u);
                                        break;
                                    case 3:
                                        d0.i iVar2 = nVar4.f13942b;
                                        long j10 = vVar3.f8760c;
                                        String str32 = vVar3.f8761d;
                                        switch (iVar2.f6780a) {
                                            case 11:
                                                e5.m1 m1Var2 = (e5.m1) iVar2.f6781b;
                                                float f13 = UptodownApp.E;
                                                if (k4.c.s()) {
                                                    h5.e1 e1Var = new h5.e1();
                                                    e1Var.f8512a = String.valueOf(j10);
                                                    e1Var.f8515d = str32;
                                                    Intent intent3 = new Intent(m1Var2.requireContext(), (Class<?>) PublicListActivity.class);
                                                    intent3.putExtra("user", e1Var);
                                                    FragmentActivity fragmentActivityRequireActivity2 = m1Var2.requireActivity();
                                                    fragmentActivityRequireActivity2.getClass();
                                                    m1Var2.startActivity(intent3, k4.c.a(fragmentActivityRequireActivity2));
                                                    break;
                                                }
                                                break;
                                            default:
                                                FeedActivity feedActivity2 = (FeedActivity) iVar2.f6781b;
                                                float f14 = UptodownApp.E;
                                                if (k4.c.s()) {
                                                    h5.e1 e1Var2 = new h5.e1();
                                                    e1Var2.f8512a = String.valueOf(j10);
                                                    e1Var2.f8515d = str32;
                                                    Intent intent4 = new Intent(feedActivity2, (Class<?>) PublicListActivity.class);
                                                    intent4.putExtra("user", e1Var2);
                                                    feedActivity2.startActivity(intent4, k4.c.a(feedActivity2));
                                                    break;
                                                }
                                                break;
                                        }
                                    case 4:
                                        nVar4.f13942b.B(vVar3.f8760c);
                                        break;
                                    case 5:
                                        nVar4.f13942b.B(vVar3.f8760c);
                                        break;
                                    case 6:
                                        d0.i iVar3 = nVar4.f13942b;
                                        long j11 = vVar3.f8760c;
                                        switch (iVar3.f6780a) {
                                            case 11:
                                                e5.m1 m1Var3 = (e5.m1) iVar3.f6781b;
                                                float f15 = UptodownApp.E;
                                                if (k4.c.s()) {
                                                    l4.f0 f0VarB = m1Var3.b();
                                                    Context contextRequireContext = m1Var3.requireContext();
                                                    contextRequireContext.getClass();
                                                    String strValueOf = String.valueOf(j11);
                                                    f0VarB.getClass();
                                                    strValueOf.getClass();
                                                    r7.w viewModelScope = ViewModelKt.getViewModelScope(f0VarB);
                                                    y7.e eVar = r7.i0.f12407a;
                                                    r7.y.q(viewModelScope, y7.d.f14116a, null, new b9.p((Object) f0VarB, (Object) contextRequireContext, strValueOf, (w6.c) null, 8), 2);
                                                    break;
                                                }
                                                break;
                                            default:
                                                FeedActivity feedActivity3 = (FeedActivity) iVar3.f6781b;
                                                float f16 = UptodownApp.E;
                                                if (k4.c.s()) {
                                                    int i182 = FeedActivity.L;
                                                    l4.f0 f0VarO0 = feedActivity3.o0();
                                                    String strValueOf2 = String.valueOf(j11);
                                                    f0VarO0.getClass();
                                                    strValueOf2.getClass();
                                                    r7.w viewModelScope2 = ViewModelKt.getViewModelScope(f0VarO0);
                                                    y7.e eVar2 = r7.i0.f12407a;
                                                    r7.y.q(viewModelScope2, y7.d.f14116a, null, new b9.p((Object) f0VarO0, (Object) feedActivity3, strValueOf2, (w6.c) null, 8), 2);
                                                    break;
                                                }
                                                break;
                                        }
                                    default:
                                        nVar4.f13942b.A(vVar3.f8772s, vVar3.f8773u);
                                        break;
                                }
                            }
                        });
                        nVar2.a(vVar2, nVarL2);
                        frameLayout.addView(relativeLayout2);
                        break;
                    }
                    break;
                case 1345968512:
                    if (str3.equals("list_add")) {
                        View viewInflate = LayoutInflater.from(context2).inflate(R.layout.feed_item_add_list, (ViewGroup) null, false);
                        int i23 = R.id.iv_icon_feed_item;
                        ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_icon_feed_item);
                        if (imageView9 != null) {
                            i23 = R.id.tv_app_name_feed_item;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_app_name_feed_item);
                            if (textView5 != null) {
                                i23 = R.id.tv_app_short_description_feed_item;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_app_short_description_feed_item);
                                if (textView6 != null) {
                                    i23 = R.id.tv_list_feed_item;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_list_feed_item);
                                    if (textView7 != null) {
                                        RelativeLayout relativeLayout3 = (RelativeLayout) viewInflate;
                                        j4.y yVarD5 = j4.y.d();
                                        String str6 = vVar2.f8775w;
                                        j4.d0 d0VarE5 = yVarD5.e(str6 != null ? a3.a.o(a3.a.v(str6), UptodownApp.G, ":webp") : null);
                                        d0VarE5.g(k4.c.y(context2));
                                        d0VarE5.e(imageView9, null);
                                        imageView6.setImageDrawable(ContextCompat.getDrawable(context2, R.drawable.vector_feed_recommended));
                                        final int i24 = 2;
                                        relativeLayout3.setOnClickListener(new View.OnClickListener() { // from class: y5.m
                                            @Override // android.view.View.OnClickListener
                                            public final void onClick(View view) {
                                                int i162 = i24;
                                                h5.v vVar3 = vVar2;
                                                n nVar4 = nVar2;
                                                switch (i162) {
                                                    case 0:
                                                        nVar4.f13942b.A(vVar3.f8772s, vVar3.f8773u);
                                                        break;
                                                    case 1:
                                                        d0.i iVar = nVar4.f13942b;
                                                        int i172 = iVar.f6780a;
                                                        Object obj3 = iVar.f6781b;
                                                        switch (i172) {
                                                            case 11:
                                                                e5.m1 m1Var = (e5.m1) obj3;
                                                                float f11 = UptodownApp.E;
                                                                if (k4.c.s()) {
                                                                    h5.t0 t0Var = new h5.t0();
                                                                    t0Var.f8739a = vVar3.f8771r;
                                                                    t0Var.f8740b = String.valueOf(vVar3.f8764k);
                                                                    t0Var.f8741c = vVar3.f8761d;
                                                                    t0Var.f8748n = vVar3.f8763j;
                                                                    t0Var.f = vVar3.f8765l;
                                                                    t0Var.f8747m = vVar3.g;
                                                                    t0Var.g = vVar3.f8766m;
                                                                    t0Var.f8742d = vVar3.h;
                                                                    t0Var.f8743i = vVar3.f8762i;
                                                                    t0Var.f8746l = vVar3.t;
                                                                    t0Var.f8744j = vVar3.f8776x;
                                                                    t0Var.f8749o = 1;
                                                                    Intent intent = new Intent(m1Var.requireContext(), (Class<?>) RepliesActivity.class);
                                                                    intent.putExtra("review", t0Var);
                                                                    intent.putExtra("appName", vVar3.t);
                                                                    intent.putExtra("appIconUrl", vVar3.f8775w);
                                                                    FragmentActivity fragmentActivityRequireActivity = m1Var.requireActivity();
                                                                    fragmentActivityRequireActivity.getClass();
                                                                    m1Var.startActivity(intent, k4.c.a(fragmentActivityRequireActivity));
                                                                    break;
                                                                }
                                                                break;
                                                            default:
                                                                FeedActivity feedActivity = (FeedActivity) obj3;
                                                                float f12 = UptodownApp.E;
                                                                if (k4.c.s()) {
                                                                    h5.t0 t0Var2 = new h5.t0();
                                                                    t0Var2.f8739a = vVar3.f8771r;
                                                                    t0Var2.f8740b = String.valueOf(vVar3.f8764k);
                                                                    t0Var2.f8741c = vVar3.f8761d;
                                                                    t0Var2.f8748n = vVar3.f8763j;
                                                                    t0Var2.f = vVar3.f8765l;
                                                                    t0Var2.f8747m = vVar3.g;
                                                                    t0Var2.g = vVar3.f8766m;
                                                                    t0Var2.f8742d = vVar3.h;
                                                                    t0Var2.f8743i = vVar3.f8762i;
                                                                    t0Var2.f8746l = vVar3.t;
                                                                    t0Var2.f8744j = vVar3.f8776x;
                                                                    t0Var2.f8749o = 1;
                                                                    Intent intent2 = new Intent(feedActivity, (Class<?>) RepliesActivity.class);
                                                                    intent2.putExtra("review", t0Var2);
                                                                    intent2.putExtra("appName", vVar3.t);
                                                                    intent2.putExtra("appIconUrl", vVar3.f8775w);
                                                                    intent2.putExtra("appUrl", vVar3.f8773u);
                                                                    feedActivity.startActivity(intent2, k4.c.a(feedActivity));
                                                                    break;
                                                                }
                                                                break;
                                                        }
                                                    case 2:
                                                        nVar4.f13942b.A(vVar3.f8772s, vVar3.f8773u);
                                                        break;
                                                    case 3:
                                                        d0.i iVar2 = nVar4.f13942b;
                                                        long j10 = vVar3.f8760c;
                                                        String str32 = vVar3.f8761d;
                                                        switch (iVar2.f6780a) {
                                                            case 11:
                                                                e5.m1 m1Var2 = (e5.m1) iVar2.f6781b;
                                                                float f13 = UptodownApp.E;
                                                                if (k4.c.s()) {
                                                                    h5.e1 e1Var = new h5.e1();
                                                                    e1Var.f8512a = String.valueOf(j10);
                                                                    e1Var.f8515d = str32;
                                                                    Intent intent3 = new Intent(m1Var2.requireContext(), (Class<?>) PublicListActivity.class);
                                                                    intent3.putExtra("user", e1Var);
                                                                    FragmentActivity fragmentActivityRequireActivity2 = m1Var2.requireActivity();
                                                                    fragmentActivityRequireActivity2.getClass();
                                                                    m1Var2.startActivity(intent3, k4.c.a(fragmentActivityRequireActivity2));
                                                                    break;
                                                                }
                                                                break;
                                                            default:
                                                                FeedActivity feedActivity2 = (FeedActivity) iVar2.f6781b;
                                                                float f14 = UptodownApp.E;
                                                                if (k4.c.s()) {
                                                                    h5.e1 e1Var2 = new h5.e1();
                                                                    e1Var2.f8512a = String.valueOf(j10);
                                                                    e1Var2.f8515d = str32;
                                                                    Intent intent4 = new Intent(feedActivity2, (Class<?>) PublicListActivity.class);
                                                                    intent4.putExtra("user", e1Var2);
                                                                    feedActivity2.startActivity(intent4, k4.c.a(feedActivity2));
                                                                    break;
                                                                }
                                                                break;
                                                        }
                                                    case 4:
                                                        nVar4.f13942b.B(vVar3.f8760c);
                                                        break;
                                                    case 5:
                                                        nVar4.f13942b.B(vVar3.f8760c);
                                                        break;
                                                    case 6:
                                                        d0.i iVar3 = nVar4.f13942b;
                                                        long j11 = vVar3.f8760c;
                                                        switch (iVar3.f6780a) {
                                                            case 11:
                                                                e5.m1 m1Var3 = (e5.m1) iVar3.f6781b;
                                                                float f15 = UptodownApp.E;
                                                                if (k4.c.s()) {
                                                                    l4.f0 f0VarB = m1Var3.b();
                                                                    Context contextRequireContext = m1Var3.requireContext();
                                                                    contextRequireContext.getClass();
                                                                    String strValueOf = String.valueOf(j11);
                                                                    f0VarB.getClass();
                                                                    strValueOf.getClass();
                                                                    r7.w viewModelScope = ViewModelKt.getViewModelScope(f0VarB);
                                                                    y7.e eVar = r7.i0.f12407a;
                                                                    r7.y.q(viewModelScope, y7.d.f14116a, null, new b9.p((Object) f0VarB, (Object) contextRequireContext, strValueOf, (w6.c) null, 8), 2);
                                                                    break;
                                                                }
                                                                break;
                                                            default:
                                                                FeedActivity feedActivity3 = (FeedActivity) iVar3.f6781b;
                                                                float f16 = UptodownApp.E;
                                                                if (k4.c.s()) {
                                                                    int i182 = FeedActivity.L;
                                                                    l4.f0 f0VarO0 = feedActivity3.o0();
                                                                    String strValueOf2 = String.valueOf(j11);
                                                                    f0VarO0.getClass();
                                                                    strValueOf2.getClass();
                                                                    r7.w viewModelScope2 = ViewModelKt.getViewModelScope(f0VarO0);
                                                                    y7.e eVar2 = r7.i0.f12407a;
                                                                    r7.y.q(viewModelScope2, y7.d.f14116a, null, new b9.p((Object) f0VarO0, (Object) feedActivity3, strValueOf2, (w6.c) null, 8), 2);
                                                                    break;
                                                                }
                                                                break;
                                                        }
                                                    default:
                                                        nVar4.f13942b.A(vVar3.f8772s, vVar3.f8773u);
                                                        break;
                                                }
                                            }
                                        });
                                        textView7.setTypeface(o4.b.f11719r);
                                        final int i25 = 3;
                                        textView7.setOnClickListener(new View.OnClickListener() { // from class: y5.m
                                            @Override // android.view.View.OnClickListener
                                            public final void onClick(View view) {
                                                int i162 = i25;
                                                h5.v vVar3 = vVar2;
                                                n nVar4 = nVar2;
                                                switch (i162) {
                                                    case 0:
                                                        nVar4.f13942b.A(vVar3.f8772s, vVar3.f8773u);
                                                        break;
                                                    case 1:
                                                        d0.i iVar = nVar4.f13942b;
                                                        int i172 = iVar.f6780a;
                                                        Object obj3 = iVar.f6781b;
                                                        switch (i172) {
                                                            case 11:
                                                                e5.m1 m1Var = (e5.m1) obj3;
                                                                float f11 = UptodownApp.E;
                                                                if (k4.c.s()) {
                                                                    h5.t0 t0Var = new h5.t0();
                                                                    t0Var.f8739a = vVar3.f8771r;
                                                                    t0Var.f8740b = String.valueOf(vVar3.f8764k);
                                                                    t0Var.f8741c = vVar3.f8761d;
                                                                    t0Var.f8748n = vVar3.f8763j;
                                                                    t0Var.f = vVar3.f8765l;
                                                                    t0Var.f8747m = vVar3.g;
                                                                    t0Var.g = vVar3.f8766m;
                                                                    t0Var.f8742d = vVar3.h;
                                                                    t0Var.f8743i = vVar3.f8762i;
                                                                    t0Var.f8746l = vVar3.t;
                                                                    t0Var.f8744j = vVar3.f8776x;
                                                                    t0Var.f8749o = 1;
                                                                    Intent intent = new Intent(m1Var.requireContext(), (Class<?>) RepliesActivity.class);
                                                                    intent.putExtra("review", t0Var);
                                                                    intent.putExtra("appName", vVar3.t);
                                                                    intent.putExtra("appIconUrl", vVar3.f8775w);
                                                                    FragmentActivity fragmentActivityRequireActivity = m1Var.requireActivity();
                                                                    fragmentActivityRequireActivity.getClass();
                                                                    m1Var.startActivity(intent, k4.c.a(fragmentActivityRequireActivity));
                                                                    break;
                                                                }
                                                                break;
                                                            default:
                                                                FeedActivity feedActivity = (FeedActivity) obj3;
                                                                float f12 = UptodownApp.E;
                                                                if (k4.c.s()) {
                                                                    h5.t0 t0Var2 = new h5.t0();
                                                                    t0Var2.f8739a = vVar3.f8771r;
                                                                    t0Var2.f8740b = String.valueOf(vVar3.f8764k);
                                                                    t0Var2.f8741c = vVar3.f8761d;
                                                                    t0Var2.f8748n = vVar3.f8763j;
                                                                    t0Var2.f = vVar3.f8765l;
                                                                    t0Var2.f8747m = vVar3.g;
                                                                    t0Var2.g = vVar3.f8766m;
                                                                    t0Var2.f8742d = vVar3.h;
                                                                    t0Var2.f8743i = vVar3.f8762i;
                                                                    t0Var2.f8746l = vVar3.t;
                                                                    t0Var2.f8744j = vVar3.f8776x;
                                                                    t0Var2.f8749o = 1;
                                                                    Intent intent2 = new Intent(feedActivity, (Class<?>) RepliesActivity.class);
                                                                    intent2.putExtra("review", t0Var2);
                                                                    intent2.putExtra("appName", vVar3.t);
                                                                    intent2.putExtra("appIconUrl", vVar3.f8775w);
                                                                    intent2.putExtra("appUrl", vVar3.f8773u);
                                                                    feedActivity.startActivity(intent2, k4.c.a(feedActivity));
                                                                    break;
                                                                }
                                                                break;
                                                        }
                                                    case 2:
                                                        nVar4.f13942b.A(vVar3.f8772s, vVar3.f8773u);
                                                        break;
                                                    case 3:
                                                        d0.i iVar2 = nVar4.f13942b;
                                                        long j10 = vVar3.f8760c;
                                                        String str32 = vVar3.f8761d;
                                                        switch (iVar2.f6780a) {
                                                            case 11:
                                                                e5.m1 m1Var2 = (e5.m1) iVar2.f6781b;
                                                                float f13 = UptodownApp.E;
                                                                if (k4.c.s()) {
                                                                    h5.e1 e1Var = new h5.e1();
                                                                    e1Var.f8512a = String.valueOf(j10);
                                                                    e1Var.f8515d = str32;
                                                                    Intent intent3 = new Intent(m1Var2.requireContext(), (Class<?>) PublicListActivity.class);
                                                                    intent3.putExtra("user", e1Var);
                                                                    FragmentActivity fragmentActivityRequireActivity2 = m1Var2.requireActivity();
                                                                    fragmentActivityRequireActivity2.getClass();
                                                                    m1Var2.startActivity(intent3, k4.c.a(fragmentActivityRequireActivity2));
                                                                    break;
                                                                }
                                                                break;
                                                            default:
                                                                FeedActivity feedActivity2 = (FeedActivity) iVar2.f6781b;
                                                                float f14 = UptodownApp.E;
                                                                if (k4.c.s()) {
                                                                    h5.e1 e1Var2 = new h5.e1();
                                                                    e1Var2.f8512a = String.valueOf(j10);
                                                                    e1Var2.f8515d = str32;
                                                                    Intent intent4 = new Intent(feedActivity2, (Class<?>) PublicListActivity.class);
                                                                    intent4.putExtra("user", e1Var2);
                                                                    feedActivity2.startActivity(intent4, k4.c.a(feedActivity2));
                                                                    break;
                                                                }
                                                                break;
                                                        }
                                                    case 4:
                                                        nVar4.f13942b.B(vVar3.f8760c);
                                                        break;
                                                    case 5:
                                                        nVar4.f13942b.B(vVar3.f8760c);
                                                        break;
                                                    case 6:
                                                        d0.i iVar3 = nVar4.f13942b;
                                                        long j11 = vVar3.f8760c;
                                                        switch (iVar3.f6780a) {
                                                            case 11:
                                                                e5.m1 m1Var3 = (e5.m1) iVar3.f6781b;
                                                                float f15 = UptodownApp.E;
                                                                if (k4.c.s()) {
                                                                    l4.f0 f0VarB = m1Var3.b();
                                                                    Context contextRequireContext = m1Var3.requireContext();
                                                                    contextRequireContext.getClass();
                                                                    String strValueOf = String.valueOf(j11);
                                                                    f0VarB.getClass();
                                                                    strValueOf.getClass();
                                                                    r7.w viewModelScope = ViewModelKt.getViewModelScope(f0VarB);
                                                                    y7.e eVar = r7.i0.f12407a;
                                                                    r7.y.q(viewModelScope, y7.d.f14116a, null, new b9.p((Object) f0VarB, (Object) contextRequireContext, strValueOf, (w6.c) null, 8), 2);
                                                                    break;
                                                                }
                                                                break;
                                                            default:
                                                                FeedActivity feedActivity3 = (FeedActivity) iVar3.f6781b;
                                                                float f16 = UptodownApp.E;
                                                                if (k4.c.s()) {
                                                                    int i182 = FeedActivity.L;
                                                                    l4.f0 f0VarO0 = feedActivity3.o0();
                                                                    String strValueOf2 = String.valueOf(j11);
                                                                    f0VarO0.getClass();
                                                                    strValueOf2.getClass();
                                                                    r7.w viewModelScope2 = ViewModelKt.getViewModelScope(f0VarO0);
                                                                    y7.e eVar2 = r7.i0.f12407a;
                                                                    r7.y.q(viewModelScope2, y7.d.f14116a, null, new b9.p((Object) f0VarO0, (Object) feedActivity3, strValueOf2, (w6.c) null, 8), 2);
                                                                    break;
                                                                }
                                                                break;
                                                        }
                                                    default:
                                                        nVar4.f13942b.A(vVar3.f8772s, vVar3.f8773u);
                                                        break;
                                                }
                                            }
                                        });
                                        textView5.setTypeface(o4.b.f11719r);
                                        textView5.setText(vVar2.t);
                                        textView6.setTypeface(o4.b.f11720s);
                                        textView6.setText(vVar2.f8774v);
                                        frameLayout.addView(relativeLayout3);
                                        break;
                                    }
                                }
                            }
                        }
                        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i23)));
                        break;
                    }
                    break;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00b5 A[PHI: r1
      0x00b5: PHI (r1v18 int) = (r1v17 int), (r1v22 int) binds: [B:19:0x0070, B:25:0x008f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x014d A[PHI: r1
      0x014d: PHI (r1v3 int) = (r1v2 int), (r1v5 int) binds: [B:42:0x00e2, B:46:0x00f9] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup r24, int r25) {
        /*
            Method dump skipped, instructions count: 353
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n4.c.onCreateViewHolder(android.view.ViewGroup, int):androidx.recyclerview.widget.RecyclerView$ViewHolder");
    }
}
