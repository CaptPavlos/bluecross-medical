package e5;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.provider.Settings;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.widget.Presenter;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.viewbinding.ViewBindings;
import c1.w4;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MoreInfo;
import com.uptodown.activities.PublicListActivity;
import com.uptodown.activities.PublicProfileActivity;
import com.uptodown.activities.RecommendedActivity;
import com.uptodown.activities.Updates;
import com.uptodown.activities.UserActivity;
import com.uptodown.activities.UserDeviceDetailsActivity;
import com.uptodown.activities.preferences.AdvancedPreferencesActivity;
import com.uptodown.activities.preferences.PreferencesActivity;
import com.uptodown.core.activities.InstallerActivity;
import com.uptodown.tv.ui.fragment.TvMyAppsFragment;
import java.util.ArrayList;
import java.util.Arrays;
import l4.a4;
import l4.hb;
import l4.ib;
import l4.r3;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class j implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7780a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7781b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f7782c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f7783d;

    public /* synthetic */ j(Context context, j0 j0Var, c2.d dVar) {
        this.f7780a = 3;
        this.f7783d = context;
        this.f7781b = j0Var;
        this.f7782c = dVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Resources.NotFoundException {
        int i10 = this.f7780a;
        int i11 = 1;
        Object obj = this.f7782c;
        Object obj2 = this.f7783d;
        Object obj3 = this.f7781b;
        switch (i10) {
            case 0:
                j0 j0Var = (j0) obj3;
                d5.s0 s0Var = (d5.s0) obj2;
                h5.t0 t0Var = (h5.t0) obj;
                float f = UptodownApp.E;
                if (k4.c.s()) {
                    Context context = view.getContext();
                    context.getClass();
                    if (h5.c1.h(context) == null) {
                        j0Var.S();
                        break;
                    } else {
                        Context contextRequireContext = j0Var.requireContext();
                        contextRequireContext.getClass();
                        new w4(contextRequireContext, 5, false).F(s0Var.e);
                        if (!v5.n.f13172d.contains(Long.valueOf(t0Var.f8739a))) {
                            j0Var.O(t0Var);
                            s0Var.f7341p.setText(String.valueOf(t0Var.f8744j + 1));
                            break;
                        }
                    }
                }
                break;
            case 1:
                j0 j0Var2 = (j0) obj3;
                d5.q0 q0Var = (d5.q0) obj2;
                h5.t0 t0Var2 = (h5.t0) obj;
                float f10 = UptodownApp.E;
                if (k4.c.s()) {
                    Context context2 = view.getContext();
                    context2.getClass();
                    if (h5.c1.h(context2) == null) {
                        if (j0Var2.getActivity() != null) {
                            FragmentActivity activity = j0Var2.getActivity();
                            activity.getClass();
                            String string = j0Var2.getString(R.string.login_required_like_title);
                            string.getClass();
                            String string2 = j0Var2.getString(R.string.login_required_like_msg);
                            string2.getClass();
                            a.a.q((l4.w) activity, string, string2);
                            break;
                        }
                    } else {
                        Context contextRequireContext2 = j0Var2.requireContext();
                        contextRequireContext2.getClass();
                        new w4(contextRequireContext2, 5, false).F(q0Var.e);
                        if (!v5.n.f13172d.contains(Long.valueOf(t0Var2.f8739a))) {
                            j0Var2.O(t0Var2);
                            q0Var.f7305o.setText(String.valueOf(t0Var2.f8744j + 1));
                            break;
                        }
                    }
                }
                break;
            case 2:
                j0 j0Var3 = (j0) obj3;
                c2.d dVar = (c2.d) obj2;
                Drawable drawable = (Drawable) obj;
                float f11 = UptodownApp.E;
                if (k4.c.s()) {
                    com.mbridge.msdk.dycreator.baseview.a.o(5, j0Var3.G().S, null);
                    ((ImageView) dVar.f1643d).setImageDrawable(drawable);
                    ((ImageView) dVar.e).setImageDrawable(drawable);
                    ((ImageView) dVar.f).setImageDrawable(drawable);
                    ((ImageView) dVar.g).setImageDrawable(drawable);
                    ((ImageView) dVar.h).setImageDrawable(drawable);
                    break;
                }
                break;
            case 3:
                Context context3 = (Context) obj2;
                j0 j0Var4 = (j0) obj3;
                c2.d dVar2 = (c2.d) obj;
                float f12 = UptodownApp.E;
                if (k4.c.s()) {
                    h5.e1 e1VarH = h5.c1.h(context3);
                    u7.m0 m0Var = j0Var4.G().H;
                    Editable text = ((EditText) dVar2.f1642c).getText();
                    text.getClass();
                    m0Var.f(o7.m.v0(text).toString());
                    if ((e1VarH != null ? e1VarH.f8512a : null) != null) {
                        String str = e1VarH.f8512a;
                        str.getClass();
                        if (str.length() > 0) {
                            j0Var4.Z((String) j0Var4.G().H.getValue());
                            FragmentActivity activity2 = j0Var4.getActivity();
                            activity2.getClass();
                            AlertDialog alertDialog = ((l4.w) activity2).f10935w;
                            if (alertDialog != null) {
                                alertDialog.dismiss();
                                break;
                            }
                        }
                    }
                    j0Var4.S();
                    break;
                }
                break;
            case 4:
                TextView textView = (TextView) obj2;
                View view2 = (View) obj;
                int i12 = MoreInfo.P;
                view2.setVisibility(8);
                int maxLines = textView.getMaxLines();
                int i13 = ((MoreInfo) obj3).O;
                if (maxLines == i13) {
                    textView.setMaxLines(Integer.MAX_VALUE);
                } else {
                    textView.setMaxLines(i13);
                }
                view2.setVisibility(0);
                break;
            case 5:
                a4 a4Var = (a4) obj3;
                h5.f fVar = (h5.f) obj2;
                h5.y0 y0Var = (h5.y0) obj;
                float f13 = UptodownApp.E;
                if (k4.c.s()) {
                    AlertDialog alertDialog2 = a4Var.f10935w;
                    alertDialog2.getClass();
                    alertDialog2.dismiss();
                    a4Var.O = false;
                    AlertDialog.Builder builder = new AlertDialog.Builder(a4Var);
                    View viewInflate = a4Var.getLayoutInflater().inflate(R.layout.version_details_dialog, (ViewGroup) null, false);
                    int i14 = R.id.tv_app_name_vd;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_app_name_vd);
                    if (textView2 != null) {
                        i14 = R.id.tv_filename_vd;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_filename_vd);
                        if (textView3 != null) {
                            i14 = R.id.tv_installed_version_vd;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_installed_version_vd);
                            if (textView4 != null) {
                                i14 = R.id.tv_label_app_name_vd;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_label_app_name_vd);
                                if (textView5 != null) {
                                    i14 = R.id.tv_label_filename_vd;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_label_filename_vd);
                                    if (textView6 != null) {
                                        i14 = R.id.tv_label_installed_version_vd;
                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_label_installed_version_vd);
                                        if (textView7 != null) {
                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_label_packagename_vd);
                                            if (textView8 != null) {
                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_label_size_vd);
                                                if (textView9 != null) {
                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_label_update_version_vd);
                                                    if (textView10 != null) {
                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_packagename_vd);
                                                        if (textView11 != null) {
                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_size_vd);
                                                            if (textView12 != null) {
                                                                TextView textView13 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_title_vd);
                                                                if (textView13 != null) {
                                                                    TextView textView14 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_update_version_vd);
                                                                    if (textView14 != null) {
                                                                        TextView textView15 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_version_details_accept);
                                                                        if (textView15 != null) {
                                                                            LinearLayout linearLayout = (LinearLayout) viewInflate;
                                                                            v5.g gVarL = v5.g.f13148u.l(a4Var);
                                                                            gVarL.a();
                                                                            h5.q qVar = y0Var.f8798i;
                                                                            long jK = qVar != null ? qVar.k() : 0L;
                                                                            gVarL.b();
                                                                            textView13.setTypeface(o4.b.f11719r);
                                                                            textView5.setTypeface(o4.b.f11720s);
                                                                            textView2.setTypeface(o4.b.f11719r);
                                                                            textView2.setText(fVar.f8525b);
                                                                            textView7.setTypeface(o4.b.f11720s);
                                                                            textView4.setTypeface(o4.b.f11719r);
                                                                            textView4.setText(String.format("%s(%s)", Arrays.copyOf(new Object[]{fVar.e, Long.valueOf(fVar.f8527d)}, 2)));
                                                                            textView10.setTypeface(o4.b.f11720s);
                                                                            textView14.setTypeface(o4.b.f11719r);
                                                                            textView14.setText(String.format("%s(%s)", Arrays.copyOf(new Object[]{y0Var.f8797d, Long.valueOf(y0Var.f8796c)}, 2)));
                                                                            textView8.setTypeface(o4.b.f11720s);
                                                                            textView11.setTypeface(o4.b.f11719r);
                                                                            textView11.setText(fVar.f8526c);
                                                                            textView9.setTypeface(o4.b.f11720s);
                                                                            textView12.setTypeface(o4.b.f11719r);
                                                                            textView12.setText(l1.b.M(a4Var, jK));
                                                                            textView6.setTypeface(o4.b.f11720s);
                                                                            textView3.setTypeface(o4.b.f11719r);
                                                                            textView3.setText(a4Var.getString(R.string.version_details_filename_not_found, fVar.f8525b));
                                                                            textView15.setTypeface(o4.b.f11719r);
                                                                            textView15.setOnClickListener(new r3(a4Var, 2));
                                                                            builder.setView(linearLayout);
                                                                            a4Var.f10935w = builder.create();
                                                                            if (!a4Var.isFinishing()) {
                                                                                AlertDialog alertDialog3 = a4Var.f10935w;
                                                                                alertDialog3.getClass();
                                                                                Window window = alertDialog3.getWindow();
                                                                                if (window != null) {
                                                                                    a3.a.A(window, 0);
                                                                                }
                                                                                AlertDialog alertDialog4 = a4Var.f10935w;
                                                                                alertDialog4.getClass();
                                                                                alertDialog4.show();
                                                                                break;
                                                                            }
                                                                        } else {
                                                                            i14 = R.id.tv_version_details_accept;
                                                                        }
                                                                    } else {
                                                                        i14 = R.id.tv_update_version_vd;
                                                                    }
                                                                } else {
                                                                    i14 = R.id.tv_title_vd;
                                                                }
                                                            } else {
                                                                i14 = R.id.tv_size_vd;
                                                            }
                                                        } else {
                                                            i14 = R.id.tv_packagename_vd;
                                                        }
                                                    } else {
                                                        i14 = R.id.tv_label_update_version_vd;
                                                    }
                                                } else {
                                                    i14 = R.id.tv_label_size_vd;
                                                }
                                            } else {
                                                i14 = R.id.tv_label_packagename_vd;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i14)));
                    break;
                }
                break;
            case 6:
                a4 a4Var2 = (a4) obj3;
                h5.y0 y0Var2 = (h5.y0) obj2;
                v5.g gVar = (v5.g) obj;
                float f14 = UptodownApp.E;
                if (k4.c.s()) {
                    AlertDialog alertDialog5 = a4Var2.f10935w;
                    alertDialog5.getClass();
                    alertDialog5.dismiss();
                    a4Var2.O = false;
                    if (y0Var2.b()) {
                        y0Var2.f = 0;
                    } else {
                        y0Var2.f = 1;
                        h5.q qVar2 = y0Var2.f8798i;
                        if (qVar2 != null) {
                            qVar2.s(a4Var2);
                        }
                    }
                    gVar.a();
                    gVar.c0(y0Var2);
                    gVar.b();
                    a4Var2.y0();
                    k4.c.E(a4Var2);
                    break;
                }
                break;
            case 7:
                kotlin.jvm.internal.x xVar = (kotlin.jvm.internal.x) obj3;
                h5.e1 e1Var = (h5.e1) obj2;
                PublicProfileActivity publicProfileActivity = (PublicProfileActivity) obj;
                Object obj4 = xVar.f10138a;
                obj4.getClass();
                if (!kotlin.jvm.internal.l.a(((h5.e1) obj4).f8512a, e1Var != null ? e1Var.f8512a : null)) {
                    Intent intent = new Intent(publicProfileActivity, (Class<?>) PublicListActivity.class);
                    intent.putExtra("user", (Parcelable) xVar.f10138a);
                    float f15 = UptodownApp.E;
                    publicProfileActivity.startActivity(intent, k4.c.a(publicProfileActivity));
                    break;
                } else {
                    Intent intent2 = new Intent(publicProfileActivity, (Class<?>) RecommendedActivity.class);
                    float f16 = UptodownApp.E;
                    publicProfileActivity.startActivity(intent2, k4.c.a(publicProfileActivity));
                    break;
                }
            case 8:
                ArrayList arrayList = (ArrayList) obj2;
                Updates updates = (Updates) obj;
                ((kotlin.jvm.internal.u) obj3).f10135a = true;
                h5.f fVar2 = arrayList.size() == 1 ? (h5.f) arrayList.get(0) : null;
                float f17 = UptodownApp.E;
                if (!k4.c.o(updates, "DownloadUpdatesWorker")) {
                    updates.A0(fVar2 != null ? fVar2.f8526c : null, true);
                    updates.P0();
                } else if (fVar2 != null) {
                    a4.r0(fVar2);
                }
                AlertDialog alertDialog6 = updates.f10935w;
                if (alertDialog6 != null) {
                    alertDialog6.dismiss();
                    break;
                }
                break;
            case 9:
                UserActivity userActivity = (UserActivity) obj3;
                int i15 = UserActivity.Q;
                userActivity.n0((Context) obj2);
                userActivity.setResult(-1);
                Object obj5 = ((kotlin.jvm.internal.x) obj).f10138a;
                obj5.getClass();
                ((AlertDialog) obj5).dismiss();
                break;
            case 10:
                UserDeviceDetailsActivity userDeviceDetailsActivity = (UserDeviceDetailsActivity) obj3;
                int i16 = UserDeviceDetailsActivity.N;
                ib ibVarO0 = userDeviceDetailsActivity.o0();
                long j10 = ((h5.h1) obj2).f8605a;
                String string3 = ((EditText) ((a4.f) obj).f219c).getText().toString();
                ibVarO0.getClass();
                string3.getClass();
                r7.w viewModelScope = ViewModelKt.getViewModelScope(ibVarO0);
                y7.e eVar = r7.i0.f12407a;
                r7.y.q(viewModelScope, y7.d.f14116a, null, new hb(userDeviceDetailsActivity, j10, string3, ibVarO0, (w6.c) null), 2);
                userDeviceDetailsActivity.Q();
                break;
            case 11:
                kotlin.jvm.internal.v vVar = (kotlin.jvm.internal.v) obj3;
                AdvancedPreferencesActivity advancedPreferencesActivity = (AdvancedPreferencesActivity) obj2;
                d5.s sVar = (d5.s) obj;
                TextView textView16 = sVar.f7329d;
                int i17 = AdvancedPreferencesActivity.J;
                if (vVar.f10136a == 4) {
                    String string4 = Settings.Secure.getString(advancedPreferencesActivity.getContentResolver(), "android_id");
                    textView16.setText(((Object) textView16.getText()) + " id:" + string4);
                    sVar.f7327b.setOnLongClickListener(new b5.c(i11, advancedPreferencesActivity, string4));
                }
                int i18 = vVar.f10136a;
                if (i18 < 5) {
                    vVar.f10136a = i18 + 1;
                    break;
                }
                break;
            case 12:
                int i19 = PreferencesActivity.M;
                ((g7.l) obj3).invoke(Integer.valueOf(((kotlin.jvm.internal.v) obj2).f10136a));
                ((PreferencesActivity) obj).Q();
                break;
            case 13:
                InstallerActivity installerActivity = (InstallerActivity) obj3;
                CheckBox checkBox = (CheckBox) obj2;
                ArrayList arrayList2 = (ArrayList) obj;
                installerActivity.T = true;
                AlertDialog alertDialog7 = installerActivity.O;
                if (alertDialog7 != null) {
                    alertDialog7.dismiss();
                }
                if (checkBox.isChecked()) {
                    try {
                        SharedPreferences.Editor editorEdit = installerActivity.getSharedPreferences("CoreSettings", 0).edit();
                        editorEdit.putBoolean("warn_installed", false);
                        editorEdit.apply();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                installerActivity.J(installerActivity, arrayList2);
                break;
            case 14:
                TvMyAppsFragment tvMyAppsFragment = (TvMyAppsFragment) obj3;
                long j11 = ((h5.f) obj2).f8541w;
                Context contextRequireContext3 = tvMyAppsFragment.requireContext();
                contextRequireContext3.getClass();
                new c1.l(contextRequireContext3, j11, new s5.y(tvMyAppsFragment, (Presenter.ViewHolder) obj), LifecycleOwnerKt.getLifecycleScope(tvMyAppsFragment));
                AlertDialog alertDialog8 = tvMyAppsFragment.f6710c;
                if (alertDialog8 != null) {
                    alertDialog8.dismiss();
                    break;
                }
                break;
            case 15:
                MainActivity mainActivity = (MainActivity) obj3;
                View view3 = (View) obj;
                AlertDialog.Builder builder2 = new AlertDialog.Builder(mainActivity);
                View viewInflate2 = LayoutInflater.from(mainActivity).inflate(R.layout.dialog_changelog, (ViewGroup) null);
                ((TextView) viewInflate2.findViewById(R.id.tv_title_cd)).setTypeface(o4.b.f11720s);
                TextView textView17 = (TextView) viewInflate2.findViewById(R.id.tv_changelog_cd);
                textView17.setTypeface(o4.b.f11720s);
                TextView textView18 = (TextView) viewInflate2.findViewById(R.id.tv_accept_cd);
                textView18.setTypeface(o4.b.f11719r);
                textView17.setText((String) obj2);
                AlertDialog alertDialogCreate = builder2.setView(viewInflate2).create();
                Window window2 = alertDialogCreate.getWindow();
                if (window2 != null) {
                    window2.setBackgroundDrawableResource(android.R.color.transparent);
                }
                textView18.setOnClickListener(new s(alertDialogCreate, 26));
                alertDialogCreate.show();
                ViewParent parent = view3.getParent();
                ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup != null) {
                    viewGroup.removeView(view3);
                    break;
                }
                break;
            default:
                h5.i1 i1Var = (h5.i1) obj2;
                h5.k kVar = (h5.k) obj;
                g5.x xVar2 = ((y5.a2) obj3).f13806d;
                if (xVar2 != null) {
                    xVar2.n(i1Var.f8616a, kVar);
                    break;
                }
                break;
        }
    }

    public /* synthetic */ j(Object obj, Object obj2, Object obj3, int i10) {
        this.f7780a = i10;
        this.f7781b = obj;
        this.f7783d = obj2;
        this.f7782c = obj3;
    }

    public /* synthetic */ j(a4 a4Var, h5.y0 y0Var, v5.g gVar, int i10) {
        this.f7780a = 6;
        this.f7781b = a4Var;
        this.f7783d = y0Var;
        this.f7782c = gVar;
    }
}
