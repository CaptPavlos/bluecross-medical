package e5;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelKt;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.uptodown.UptodownApp;
import com.uptodown.activities.FreeUpSpaceActivity;
import com.uptodown.workers.DownloadWorker;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class r implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7839a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j0 f7840b;

    public /* synthetic */ r(j0 j0Var, int i10) {
        this.f7839a = i10;
        this.f7840b = j0Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f7839a;
        j0 j0Var = this.f7840b;
        switch (i10) {
            case 0:
                if (j0Var.getActivity() != null && j0Var.isAdded() && !j0Var.requireActivity().isFinishing()) {
                    FragmentActivity activity = j0Var.getActivity();
                    activity.getClass();
                    AlertDialog alertDialog = ((l4.w) activity).f10935w;
                    if (alertDialog != null) {
                        alertDialog.dismiss();
                        break;
                    }
                }
                break;
            case 1:
                j0Var.v();
                break;
            case 2:
                Context contextRequireContext = j0Var.requireContext();
                contextRequireContext.getClass();
                FragmentActivity fragmentActivityRequireActivity = j0Var.requireActivity();
                fragmentActivityRequireActivity.getClass();
                l1.b.h(contextRequireContext, (l4.w) fragmentActivityRequireActivity, j0Var.D(), j0Var.f7792m, false);
                break;
            case 3:
                FragmentActivity activity2 = j0Var.getActivity();
                activity2.getClass();
                ((l4.w) activity2).Q();
                break;
            case 4:
                j0Var.Q();
                break;
            case 5:
                Intent intent = new Intent(j0Var.requireActivity(), (Class<?>) FreeUpSpaceActivity.class);
                intent.putExtra("appInfo", j0Var.D());
                float f = UptodownApp.E;
                FragmentActivity fragmentActivityRequireActivity2 = j0Var.requireActivity();
                fragmentActivityRequireActivity2.getClass();
                j0Var.startActivity(intent, k4.c.a(fragmentActivityRequireActivity2));
                break;
            case 6:
                j0Var.Q();
                break;
            case 7:
                Context contextRequireContext2 = j0Var.requireContext();
                contextRequireContext2.getClass();
                FragmentActivity fragmentActivityRequireActivity3 = j0Var.requireActivity();
                fragmentActivityRequireActivity3.getClass();
                l1.b.h(contextRequireContext2, (l4.w) fragmentActivityRequireActivity3, j0Var.D(), j0Var.f7792m, false);
                break;
            case 8:
                if (!a.a.D(j0Var.D().f8566a)) {
                    String str = j0Var.D().f8595w;
                    str.getClass();
                    if (!a.a.F(str)) {
                    }
                }
                if (!DownloadWorker.f) {
                    t3.h hVar = v5.g.f13148u;
                    Context contextRequireContext3 = j0Var.requireContext();
                    contextRequireContext3.getClass();
                    v5.g gVarL = hVar.l(contextRequireContext3);
                    gVarL.a();
                    String str2 = j0Var.D().f8595w;
                    str2.getClass();
                    h5.q qVarB = gVarL.B(j0Var.D().B, str2);
                    if (qVarB == null) {
                        String str3 = j0Var.D().f8595w;
                        str3.getClass();
                        qVarB = gVarL.B(j0Var.D().f8569d, str3);
                    }
                    gVarL.b();
                    if (qVarB != null && a.a.E(qVarB)) {
                        t1.c cVar = j0Var.f7787d;
                        if (cVar != null) {
                            Bundle bundle = new Bundle();
                            bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "paused");
                            cVar.e(bundle, "download");
                        }
                        DownloadWorker.f = true;
                        j0Var.i0(null);
                        break;
                    }
                } else {
                    DownloadWorker.f = false;
                    DownloadWorker.e = false;
                    break;
                }
                break;
            case 9:
                j0Var.v();
                break;
            case 10:
                j0Var.p();
                FragmentActivity activity3 = j0Var.getActivity();
                activity3.getClass();
                ((l4.w) activity3).Q();
                break;
            case 11:
                j0Var.q();
                FragmentActivity activity4 = j0Var.getActivity();
                activity4.getClass();
                ((l4.w) activity4).Q();
                break;
            case 12:
                Context contextRequireContext4 = j0Var.requireContext();
                contextRequireContext4.getClass();
                j0Var.s(contextRequireContext4);
                Context contextRequireContext5 = j0Var.requireContext();
                contextRequireContext5.getClass();
                FragmentActivity fragmentActivityRequireActivity4 = j0Var.requireActivity();
                fragmentActivityRequireActivity4.getClass();
                l1.b.h(contextRequireContext5, (l4.w) fragmentActivityRequireActivity4, j0Var.D(), j0Var.f7792m, false);
                FragmentActivity activity5 = j0Var.getActivity();
                activity5.getClass();
                ((l4.w) activity5).Q();
                break;
            case 13:
                if (((Number) j0Var.G().R.getValue()).intValue() >= 0) {
                    Context contextRequireContext6 = j0Var.requireContext();
                    contextRequireContext6.getClass();
                    boolean z9 = ((Number) j0Var.G().R.getValue()).intValue() > 0;
                    try {
                        SharedPreferences.Editor editorEdit = contextRequireContext6.getSharedPreferences("SettingsPreferences", 0).edit();
                        editorEdit.putBoolean("storage_sdcard", z9);
                        editorEdit.apply();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    FragmentActivity activity6 = j0Var.getActivity();
                    activity6.getClass();
                    AlertDialog alertDialog2 = ((l4.w) activity6).f10935w;
                    if (alertDialog2 != null) {
                        alertDialog2.dismiss();
                    }
                    j0Var.e0();
                    break;
                }
                break;
            case 14:
                Context contextRequireContext7 = j0Var.requireContext();
                contextRequireContext7.getClass();
                FragmentActivity fragmentActivityRequireActivity5 = j0Var.requireActivity();
                fragmentActivityRequireActivity5.getClass();
                l1.b.h(contextRequireContext7, (l4.w) fragmentActivityRequireActivity5, j0Var.D(), j0Var.f7792m, false);
                break;
            case 15:
                Context contextRequireContext8 = j0Var.requireContext();
                contextRequireContext8.getClass();
                j0Var.s(contextRequireContext8);
                FragmentActivity activity7 = j0Var.getActivity();
                activity7.getClass();
                AlertDialog alertDialog3 = ((l4.w) activity7).f10935w;
                if (alertDialog3 != null) {
                    alertDialog3.dismiss();
                    break;
                }
                break;
            case 16:
                j0Var.S();
                FragmentActivity activity8 = j0Var.getActivity();
                activity8.getClass();
                AlertDialog alertDialog4 = ((l4.w) activity8).f10935w;
                if (alertDialog4 != null) {
                    alertDialog4.dismiss();
                    break;
                }
                break;
            case 17:
                FragmentActivity activity9 = j0Var.getActivity();
                activity9.getClass();
                AlertDialog alertDialog5 = ((l4.w) activity9).f10935w;
                if (alertDialog5 != null) {
                    alertDialog5.dismiss();
                    break;
                }
                break;
            case 18:
                FragmentActivity activity10 = j0Var.getActivity();
                activity10.getClass();
                AlertDialog alertDialog6 = ((l4.w) activity10).f10935w;
                if (alertDialog6 != null) {
                    alertDialog6.dismiss();
                    break;
                }
                break;
            case 19:
                c1 c1VarG = j0Var.G();
                Context contextRequireContext9 = j0Var.requireContext();
                contextRequireContext9.getClass();
                long j10 = j0Var.D().f8566a;
                c1VarG.getClass();
                r7.w viewModelScope = ViewModelKt.getViewModelScope(c1VarG);
                y7.e eVar = r7.i0.f12407a;
                r7.y.q(viewModelScope, y7.d.f14116a, null, new r0(c1VarG, contextRequireContext9, j10, (w6.c) null), 2);
                FragmentActivity activity11 = j0Var.getActivity();
                activity11.getClass();
                AlertDialog alertDialog7 = ((l4.w) activity11).f10935w;
                if (alertDialog7 != null) {
                    alertDialog7.dismiss();
                    break;
                }
                break;
            case 20:
                FragmentActivity activity12 = j0Var.getActivity();
                activity12.getClass();
                AlertDialog alertDialog8 = ((l4.w) activity12).f10935w;
                if (alertDialog8 != null) {
                    alertDialog8.dismiss();
                    break;
                }
                break;
            case 21:
                j0Var.A();
                if (j0Var.getActivity() != null) {
                    FragmentActivity activity13 = j0Var.getActivity();
                    activity13.getClass();
                    AlertDialog alertDialog9 = ((l4.w) activity13).f10935w;
                    if (alertDialog9 != null) {
                        alertDialog9.dismiss();
                        break;
                    }
                }
                break;
            case 22:
                Intent intent2 = new Intent(j0Var.requireActivity(), (Class<?>) FreeUpSpaceActivity.class);
                intent2.putExtra("appInfo", j0Var.D());
                float f10 = UptodownApp.E;
                FragmentActivity fragmentActivityRequireActivity6 = j0Var.requireActivity();
                fragmentActivityRequireActivity6.getClass();
                j0Var.startActivity(intent2, k4.c.a(fragmentActivityRequireActivity6));
                break;
            default:
                j0Var.o0();
                break;
        }
    }
}
