package e5;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelKt;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.InformationActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MoreInfo;
import com.uptodown.activities.OldVersionsActivity;
import com.uptodown.activities.OrganizationActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7729a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j0 f7730b;

    public /* synthetic */ e(j0 j0Var, int i10) {
        this.f7729a = i10;
        this.f7730b = j0Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        int i10 = this.f7729a;
        j0 j0Var = this.f7730b;
        switch (i10) {
            case 0:
                Context contextRequireContext = j0Var.requireContext();
                contextRequireContext.getClass();
                FragmentActivity fragmentActivityRequireActivity = j0Var.requireActivity();
                fragmentActivityRequireActivity.getClass();
                l1.b.h(contextRequireContext, (l4.w) fragmentActivityRequireActivity, j0Var.D(), j0Var.f7792m, false);
                break;
            case 1:
                j0Var.v();
                break;
            case 2:
                FragmentActivity activity = j0Var.getActivity();
                activity.getClass();
                AlertDialog alertDialog = ((l4.w) activity).f10935w;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                    break;
                }
                break;
            case 3:
                float f = UptodownApp.E;
                if (k4.c.s()) {
                    c1 c1VarG = j0Var.G();
                    Context contextRequireContext2 = j0Var.requireContext();
                    contextRequireContext2.getClass();
                    long j10 = j0Var.D().f8566a;
                    String str2 = j0Var.D().f8567b;
                    str2.getClass();
                    String strI = j0Var.D().i();
                    d5.b bVar = j0Var.f7785b;
                    bVar.getClass();
                    boolean zIsChecked = bVar.T.isChecked();
                    c1VarG.getClass();
                    r7.w viewModelScope = ViewModelKt.getViewModelScope(c1VarG);
                    y7.e eVar = r7.i0.f12407a;
                    r7.y.q(viewModelScope, y7.d.f14116a, null, new q0(c1VarG, j10, str2, strI, zIsChecked, contextRequireContext2, null), 2);
                    break;
                }
                break;
            case 4:
                j0Var.v();
                break;
            case 5:
                j0Var.o0();
                break;
            case 6:
                if (j0Var.getActivity() != null) {
                    if (!(j0Var.getActivity() instanceof MainActivity)) {
                        if (j0Var.getActivity() instanceof AppDetailActivity) {
                            FragmentActivity activity2 = j0Var.getActivity();
                            activity2.getClass();
                            ((AppDetailActivity) activity2).finish();
                            break;
                        }
                    } else {
                        FragmentActivity activity3 = j0Var.getActivity();
                        activity3.getClass();
                        ((MainActivity) activity3).P0();
                        break;
                    }
                }
                break;
            case 7:
                j0Var.T();
                break;
            case 8:
                if (!j0Var.requireActivity().isFinishing()) {
                    Intent intent = new Intent(j0Var.requireActivity(), (Class<?>) MoreInfo.class);
                    intent.putExtra("appInfo", j0Var.D());
                    float f10 = UptodownApp.E;
                    FragmentActivity fragmentActivityRequireActivity2 = j0Var.requireActivity();
                    fragmentActivityRequireActivity2.getClass();
                    j0Var.startActivity(intent, k4.c.a(fragmentActivityRequireActivity2));
                    break;
                }
                break;
            case 9:
                if (!j0Var.requireActivity().isFinishing() && j0Var.D().k()) {
                    Intent intent2 = new Intent(j0Var.requireActivity(), (Class<?>) OldVersionsActivity.class);
                    intent2.putExtra("appInfo", j0Var.D());
                    float f11 = UptodownApp.E;
                    FragmentActivity fragmentActivityRequireActivity3 = j0Var.requireActivity();
                    fragmentActivityRequireActivity3.getClass();
                    j0Var.startActivity(intent2, k4.c.a(fragmentActivityRequireActivity3));
                    break;
                }
                break;
            case 10:
                if (j0Var.getActivity() != null && !j0Var.requireActivity().isFinishing()) {
                    String string = j0Var.getString(R.string.dmca_title);
                    string.getClass();
                    String string2 = j0Var.getString(R.string.url_dmca);
                    string2.getClass();
                    FragmentActivity fragmentActivityRequireActivity4 = j0Var.requireActivity();
                    fragmentActivityRequireActivity4.getClass();
                    v5.c.e(fragmentActivityRequireActivity4, string2, string);
                    break;
                }
                break;
            case 11:
                h5.k kVar = new h5.k(0, (String) null, 7);
                h5.h0 h0Var = j0Var.D().E0;
                h0Var.getClass();
                if (h0Var.f8603c > -1) {
                    h5.h0 h0Var2 = j0Var.D().E0;
                    h0Var2.getClass();
                    kVar.f8632a = h0Var2.f8603c;
                    h5.h0 h0Var3 = j0Var.D().E0;
                    h0Var3.getClass();
                    kVar.f = h0Var3.e;
                } else {
                    h5.h0 h0Var4 = j0Var.D().E0;
                    h0Var4.getClass();
                    if (h0Var4.f8602b > -1) {
                        h5.h0 h0Var5 = j0Var.D().E0;
                        h0Var5.getClass();
                        kVar.f8632a = h0Var5.f8602b;
                        kVar.f8635d = true;
                    }
                }
                h5.h0 h0Var6 = j0Var.D().E0;
                h0Var6.getClass();
                String str3 = h0Var6.f8604d;
                if (str3 != null && str3.length() != 0) {
                    h5.h0 h0Var7 = j0Var.D().E0;
                    h0Var7.getClass();
                    kVar.f8633b = h0Var7.f8604d;
                }
                j0Var.R(kVar);
                break;
            case 12:
                j0Var.T();
                break;
            case 13:
                if (!j0Var.requireActivity().isFinishing()) {
                    Intent intent3 = new Intent(j0Var.requireActivity(), (Class<?>) InformationActivity.class);
                    float f12 = UptodownApp.E;
                    FragmentActivity fragmentActivityRequireActivity5 = j0Var.requireActivity();
                    fragmentActivityRequireActivity5.getClass();
                    j0Var.startActivity(intent3, k4.c.a(fragmentActivityRequireActivity5));
                    break;
                }
                break;
            case 14:
                float f13 = UptodownApp.E;
                if (k4.c.s() && j0Var.G().C.getValue() != null) {
                    Context contextRequireContext3 = j0Var.requireContext();
                    contextRequireContext3.getClass();
                    Object value = j0Var.G().C.getValue();
                    value.getClass();
                    String str4 = ((h5.f) value).f8526c;
                    str4.getClass();
                    Intent intent4 = new Intent("android.intent.action.DELETE", Uri.parse("package:".concat(str4)));
                    intent4.addFlags(268435456);
                    contextRequireContext3.startActivity(intent4);
                    break;
                }
                break;
            case 15:
                float f14 = UptodownApp.E;
                if (k4.c.s()) {
                    FragmentActivity activity4 = j0Var.getActivity();
                    activity4.getClass();
                    AlertDialog alertDialog2 = ((l4.w) activity4).f10935w;
                    if (alertDialog2 != null) {
                        alertDialog2.dismiss();
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(j0Var.getContext());
                    View viewInflate = j0Var.getLayoutInflater().inflate(R.layout.dialog_user_list_selector, (ViewGroup) null, false);
                    int i11 = R.id.iv_recommended_option;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_recommended_option);
                    if (imageView != null) {
                        i11 = R.id.iv_wishlist_option;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_wishlist_option);
                        if (imageView2 != null) {
                            i11 = R.id.ll_recommended_option;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_recommended_option);
                            if (relativeLayout != null) {
                                i11 = R.id.ll_wishlist_option;
                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_wishlist_option);
                                if (relativeLayout2 != null) {
                                    i11 = R.id.tv_recommended_option;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_recommended_option);
                                    if (textView != null) {
                                        i11 = R.id.tv_title_dialog_rename;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_title_dialog_rename);
                                        if (textView2 != null) {
                                            i11 = R.id.tv_wishlist_option;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_wishlist_option);
                                            if (textView3 != null) {
                                                LinearLayout linearLayout = (LinearLayout) viewInflate;
                                                if (j0Var.getActivity() != null && !j0Var.requireActivity().isFinishing()) {
                                                    textView2.setTypeface(o4.b.f11719r);
                                                    textView3.setTypeface(o4.b.f11719r);
                                                    textView.setTypeface(o4.b.f11719r);
                                                    if (((Number) j0Var.G().E.getValue()).intValue() == 1) {
                                                        relativeLayout2.setBackground(ContextCompat.getDrawable(j0Var.requireContext(), R.drawable.ripple_blue_primary_button));
                                                        textView3.setTextColor(ContextCompat.getColor(j0Var.requireContext(), R.color.white));
                                                        imageView2.setVisibility(0);
                                                    }
                                                    if (((Number) j0Var.G().F.getValue()).intValue() == 1) {
                                                        relativeLayout.setBackground(ContextCompat.getDrawable(j0Var.requireContext(), R.drawable.ripple_blue_primary_button));
                                                        textView.setTextColor(ContextCompat.getColor(j0Var.requireContext(), R.color.white));
                                                        imageView.setVisibility(0);
                                                    }
                                                    relativeLayout.setOnClickListener(new r(j0Var, 10));
                                                    relativeLayout2.setOnClickListener(new r(j0Var, 11));
                                                    builder.setView(linearLayout);
                                                    builder.setCancelable(true);
                                                    j0Var.l0(builder);
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i11)));
                    break;
                }
                break;
            case 16:
                j0Var.T();
                break;
            case 17:
                float f15 = UptodownApp.E;
                if (k4.c.s() && !((Boolean) j0Var.G().T.getValue()).booleanValue()) {
                    j0Var.V();
                    break;
                }
                break;
            case 18:
                float f16 = UptodownApp.E;
                if (k4.c.s()) {
                    j0Var.p();
                    break;
                }
                break;
            case 19:
                float f17 = UptodownApp.E;
                if (k4.c.s()) {
                    j0Var.q();
                    break;
                }
                break;
            case 20:
                if (!j0Var.requireActivity().isFinishing()) {
                    Intent intent5 = new Intent(j0Var.requireActivity(), (Class<?>) OrganizationActivity.class);
                    intent5.putExtra("organizationID", j0Var.D().f8574k0);
                    intent5.putExtra("organizationName", j0Var.D().f8578n);
                    float f18 = UptodownApp.E;
                    FragmentActivity fragmentActivityRequireActivity6 = j0Var.requireActivity();
                    fragmentActivityRequireActivity6.getClass();
                    j0Var.startActivity(intent5, k4.c.a(fragmentActivityRequireActivity6));
                    break;
                }
                break;
            case 21:
                String str5 = j0Var.D().f8580o;
                if (str5 != null && str5.length() != 0) {
                    d5.b bVar2 = j0Var.f7785b;
                    bVar2.getClass();
                    int visibility = bVar2.U.getVisibility();
                    d5.b bVar3 = j0Var.f7785b;
                    if (visibility != 0) {
                        bVar3.getClass();
                        bVar3.f6897w0.setText(R.string.read_more_desc_app_detail);
                        d5.b bVar4 = j0Var.f7785b;
                        bVar4.getClass();
                        bVar4.U.setVisibility(0);
                        d5.b bVar5 = j0Var.f7785b;
                        bVar5.getClass();
                        bVar5.N.setVisibility(8);
                        d5.b bVar6 = j0Var.f7785b;
                        bVar6.getClass();
                        bVar6.Z.setMaxLines(6);
                        d5.b bVar7 = j0Var.f7785b;
                        bVar7.getClass();
                        bVar7.Z.setEllipsize(TextUtils.TruncateAt.END);
                        d5.b bVar8 = j0Var.f7785b;
                        bVar8.getClass();
                        bVar8.H.setVisibility(8);
                        d5.b bVar9 = j0Var.f7785b;
                        bVar9.getClass();
                        NestedScrollView nestedScrollView = bVar9.V;
                        d5.b bVar10 = j0Var.f7785b;
                        bVar10.getClass();
                        nestedScrollView.smoothScrollTo(0, bVar10.J.f6927r.getBottom(), 1000);
                        break;
                    } else {
                        bVar3.getClass();
                        bVar3.f6897w0.setText(R.string.read_less_desc_app_detail);
                        d5.b bVar11 = j0Var.f7785b;
                        bVar11.getClass();
                        bVar11.U.setVisibility(8);
                        String str6 = j0Var.D().I;
                        if ((str6 != null && str6.length() != 0) || ((str = j0Var.D().H) != null && str.length() != 0)) {
                            d5.b bVar12 = j0Var.f7785b;
                            bVar12.getClass();
                            bVar12.N.setVisibility(0);
                        }
                        d5.b bVar13 = j0Var.f7785b;
                        bVar13.getClass();
                        bVar13.Z.setMaxLines(Integer.MAX_VALUE);
                        d5.b bVar14 = j0Var.f7785b;
                        bVar14.getClass();
                        bVar14.Z.setEllipsize(null);
                        String str7 = j0Var.D().l0;
                        if (str7 != null && str7.length() != 0) {
                            d5.b bVar15 = j0Var.f7785b;
                            bVar15.getClass();
                            bVar15.H.setVisibility(0);
                            break;
                        }
                    }
                }
                break;
            case 22:
                String str8 = j0Var.D().T;
                if (str8 != null && str8.length() != 0) {
                    d5.b bVar16 = j0Var.f7785b;
                    bVar16.getClass();
                    int visibility2 = ((View) bVar16.O.e).getVisibility();
                    d5.b bVar17 = j0Var.f7785b;
                    if (visibility2 != 0) {
                        bVar17.getClass();
                        ((TextView) bVar17.O.f196b).setText(R.string.read_more_desc_app_detail);
                        d5.b bVar18 = j0Var.f7785b;
                        bVar18.getClass();
                        ((View) bVar18.O.e).setVisibility(0);
                        d5.b bVar19 = j0Var.f7785b;
                        bVar19.getClass();
                        ((TextView) bVar19.O.f198d).setMaxLines(6);
                        d5.b bVar20 = j0Var.f7785b;
                        bVar20.getClass();
                        ((TextView) bVar20.O.f198d).setEllipsize(TextUtils.TruncateAt.END);
                        d5.b bVar21 = j0Var.f7785b;
                        bVar21.getClass();
                        NestedScrollView nestedScrollView2 = bVar21.V;
                        d5.b bVar22 = j0Var.f7785b;
                        bVar22.getClass();
                        nestedScrollView2.smoothScrollTo(0, ((TextView) bVar22.O.f197c).getTop(), 1000);
                        break;
                    } else {
                        bVar17.getClass();
                        ((TextView) bVar17.O.f196b).setText(R.string.read_less_desc_app_detail);
                        d5.b bVar23 = j0Var.f7785b;
                        bVar23.getClass();
                        ((View) bVar23.O.e).setVisibility(8);
                        d5.b bVar24 = j0Var.f7785b;
                        bVar24.getClass();
                        ((TextView) bVar24.O.f198d).setMaxLines(Integer.MAX_VALUE);
                        d5.b bVar25 = j0Var.f7785b;
                        bVar25.getClass();
                        ((TextView) bVar25.O.f198d).setEllipsize(null);
                        break;
                    }
                }
                break;
            case 23:
                j0Var.T();
                break;
            case 24:
                j0Var.v();
                break;
            case 25:
                j0Var.v();
                break;
            case 26:
                if (j0Var.getActivity() instanceof l4.w) {
                    FragmentActivity fragmentActivityRequireActivity7 = j0Var.requireActivity();
                    fragmentActivityRequireActivity7.getClass();
                    a.a.p((l4.w) fragmentActivityRequireActivity7, j0Var.D().e);
                    break;
                }
                break;
            case 27:
                if (j0Var.getActivity() instanceof l4.w) {
                    FragmentActivity fragmentActivityRequireActivity8 = j0Var.requireActivity();
                    fragmentActivityRequireActivity8.getClass();
                    a.a.p((l4.w) fragmentActivityRequireActivity8, j0Var.D().e);
                    break;
                }
                break;
            case 28:
                FragmentActivity activity5 = j0Var.getActivity();
                activity5.getClass();
                AlertDialog alertDialog3 = ((l4.w) activity5).f10935w;
                if (alertDialog3 != null) {
                    alertDialog3.dismiss();
                    break;
                }
                break;
            default:
                Context contextRequireContext4 = j0Var.requireContext();
                contextRequireContext4.getClass();
                FragmentActivity fragmentActivityRequireActivity9 = j0Var.requireActivity();
                fragmentActivityRequireActivity9.getClass();
                l1.b.h(contextRequireContext4, (l4.w) fragmentActivityRequireActivity9, j0Var.D(), j0Var.f7792m, false);
                break;
        }
    }
}
