package e5;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.net.Uri;
import android.view.MenuItem;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppInstalledDetailsActivity;
import com.uptodown.activities.SearchActivity;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class h implements ActivityResultCallback, Toolbar.OnMenuItemClickListener, NestedScrollView.OnScrollChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7761a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j0 f7762b;

    public /* synthetic */ h(j0 j0Var, int i10) {
        this.f7761a = i10;
        this.f7762b = j0Var;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        SharedPreferences sharedPreferences;
        int i10 = this.f7761a;
        w6.c cVar = null;
        j0 j0Var = this.f7762b;
        ActivityResult activityResult = (ActivityResult) obj;
        switch (i10) {
            case 0:
                if (activityResult.getResultCode() == 1) {
                    Context contextRequireContext = j0Var.requireContext();
                    contextRequireContext.getClass();
                    SharedPreferences sharedPreferences2 = contextRequireContext.getSharedPreferences("SharedPreferencesUser", 0);
                    try {
                        sharedPreferences = contextRequireContext.getSharedPreferences("SettingsPreferences", 0);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    String string = sharedPreferences.contains("UTOKEN") ? sharedPreferences.getString("UTOKEN", null) : null;
                    if (string != null || sharedPreferences2.getString("is_turbo", null) != null) {
                        float f = UptodownApp.E;
                        Context contextRequireContext2 = j0Var.requireContext();
                        contextRequireContext2.getClass();
                        k4.c.B(contextRequireContext2);
                        Context contextRequireContext3 = j0Var.requireContext();
                        contextRequireContext3.getClass();
                        k4.c.A(contextRequireContext3);
                        if (((CharSequence) j0Var.G().H.getValue()).length() > 0) {
                            j0Var.Z((String) j0Var.G().H.getValue());
                            FragmentActivity activity = j0Var.getActivity();
                            activity.getClass();
                            AlertDialog alertDialog = ((l4.w) activity).f10935w;
                            if (alertDialog != null) {
                                alertDialog.dismiss();
                            }
                        }
                        j0Var.t();
                        break;
                    }
                }
                break;
            default:
                w wVar = new w(j0Var, 9);
                LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(j0Var);
                y7.e eVar = r7.i0.f12407a;
                r7.y.q(lifecycleScope, y7.d.f14116a, null, new a3.o(j0Var, wVar, cVar, 10), 2);
                break;
        }
    }

    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        FragmentActivity activity;
        menuItem.getClass();
        float f = UptodownApp.E;
        if (k4.c.s()) {
            int itemId = menuItem.getItemId();
            j0 j0Var = this.f7762b;
            if (itemId == R.id.action_search) {
                Intent intent = new Intent(j0Var.getContext(), (Class<?>) SearchActivity.class);
                intent.setFlags(603979776);
                FragmentActivity fragmentActivityRequireActivity = j0Var.requireActivity();
                fragmentActivityRequireActivity.getClass();
                j0Var.startActivity(intent, k4.c.a(fragmentActivityRequireActivity));
                return true;
            }
            w6.c cVar = null;
            if (menuItem.getItemId() == R.id.action_share) {
                if (j0Var.getContext() != null) {
                    LifecycleOwner viewLifecycleOwner = j0Var.getViewLifecycleOwner();
                    viewLifecycleOwner.getClass();
                    r7.y.q(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new b0(j0Var, cVar, 16), 3);
                    return true;
                }
            } else {
                if (menuItem.getItemId() == R.id.action_antivirus_report) {
                    j0Var.V();
                    return true;
                }
                if (menuItem.getItemId() == R.id.action_uninstall) {
                    String str = j0Var.D().f8595w;
                    if (str != null && str.length() != 0 && (activity = j0Var.getActivity()) != null) {
                        String str2 = j0Var.D().f8595w;
                        str2.getClass();
                        Intent intent2 = new Intent("android.intent.action.DELETE", Uri.parse("package:".concat(str2)));
                        intent2.addFlags(268435456);
                        activity.startActivity(intent2);
                        return true;
                    }
                } else {
                    if (menuItem.getItemId() == R.id.action_wishlist) {
                        j0Var.q();
                        return true;
                    }
                    if (menuItem.getItemId() == R.id.action_recommended) {
                        j0Var.p();
                        return true;
                    }
                    if (menuItem.getItemId() == R.id.action_exclude) {
                        String str3 = j0Var.D().f8595w;
                        if (str3 != null && str3.length() != 0 && j0Var.getContext() != null) {
                            t3.h hVar = v5.g.f13148u;
                            Context contextRequireContext = j0Var.requireContext();
                            contextRequireContext.getClass();
                            v5.g gVarL = hVar.l(contextRequireContext);
                            gVarL.a();
                            String str4 = j0Var.D().f8595w;
                            str4.getClass();
                            h5.f fVarR = gVarL.r(str4);
                            if (fVarR != null) {
                                if (fVarR.f8532m == 0) {
                                    fVarR.f8532m = 1;
                                    h5.e eVar = fVarR.g;
                                    h5.e eVar2 = h5.e.f8507b;
                                    if (eVar != eVar2) {
                                        fVarR.g = eVar2;
                                        String str5 = fVarR.f8526c;
                                        str5.getClass();
                                        gVarL.m(str5);
                                        Context contextRequireContext2 = j0Var.requireContext();
                                        contextRequireContext2.getClass();
                                        r0.f.o(contextRequireContext2);
                                    }
                                } else {
                                    fVarR.f8532m = 0;
                                }
                                gVarL.a0(fVarR);
                                u7.m0 m0Var = j0Var.G().C;
                                m0Var.getClass();
                                m0Var.g(null, fVarR);
                                Context contextRequireContext3 = j0Var.requireContext();
                                contextRequireContext3.getClass();
                                v5.a.i(contextRequireContext3);
                            }
                            gVarL.b();
                            j0Var.B();
                            return true;
                        }
                    } else if (menuItem.getItemId() == R.id.action_app_details_settings) {
                        if (j0Var.getActivity() != null && !j0Var.requireActivity().isFinishing()) {
                            Intent intent3 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                            intent3.setData(Uri.fromParts("package", j0Var.D().f8595w, null));
                            intent3.addFlags(268435456);
                            intent3.addFlags(8388608);
                            try {
                                j0Var.startActivity(intent3);
                            } catch (ActivityNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    } else if (menuItem.getItemId() == R.id.action_app_installed_details) {
                        if (j0Var.getContext() != null) {
                            t3.h hVar2 = v5.g.f13148u;
                            FragmentActivity fragmentActivityRequireActivity2 = j0Var.requireActivity();
                            fragmentActivityRequireActivity2.getClass();
                            v5.g gVarL2 = hVar2.l(fragmentActivityRequireActivity2);
                            gVarL2.a();
                            String str6 = j0Var.D().f8595w;
                            str6.getClass();
                            h5.f fVarR2 = gVarL2.r(str6);
                            gVarL2.b();
                            Intent intent4 = new Intent(j0Var.requireActivity(), (Class<?>) AppInstalledDetailsActivity.class);
                            intent4.putExtra("appInstalled", fVarR2);
                            intent4.putExtra("appInfo", j0Var.D());
                            FragmentActivity fragmentActivityRequireActivity3 = j0Var.requireActivity();
                            fragmentActivityRequireActivity3.getClass();
                            j0Var.startActivity(intent4, k4.c.a(fragmentActivityRequireActivity3));
                            return true;
                        }
                    } else {
                        if (menuItem.getItemId() != R.id.action_remote_install) {
                            return false;
                        }
                        if (j0Var.G().f7714z.getValue() instanceof v5.l) {
                            Object value = j0Var.G().f7714z.getValue();
                            value.getClass();
                            j0Var.n0((ArrayList) ((v5.l) value).f13168a);
                            return true;
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
    public void onScrollChange(NestedScrollView nestedScrollView, int i10, int i11, int i12, int i13) {
        boolean zBooleanValue;
        Rect rect = new Rect();
        j0 j0Var = this.f7762b;
        d5.b bVar = j0Var.f7785b;
        bVar.getClass();
        bVar.V.getHitRect(rect);
        j0Var.k0(rect);
        d5.b bVar2 = j0Var.f7785b;
        bVar2.getClass();
        if (bVar2.J.f6927r.getLocalVisibleRect(rect)) {
            d5.b bVar3 = j0Var.f7785b;
            bVar3.getClass();
            bVar3.f6869c.setTitle("");
            u7.m0 m0Var = j0Var.G().P;
            Boolean bool = Boolean.TRUE;
            m0Var.getClass();
            m0Var.g(null, bool);
            return;
        }
        boolean zBooleanValue2 = ((Boolean) j0Var.G().P.getValue()).booleanValue();
        u7.m0 m0Var2 = j0Var.G().P;
        Boolean bool2 = Boolean.FALSE;
        m0Var2.getClass();
        m0Var2.g(null, bool2);
        String str = j0Var.D().f8567b;
        if (str == null || str.length() == 0) {
            return;
        }
        ArrayList arrayList = j0Var.D().P;
        if (arrayList == null || arrayList.isEmpty()) {
            String strE = j0Var.D().e();
            if (strE == null || strE.length() == 0) {
                d5.b bVar4 = j0Var.f7785b;
                bVar4.getClass();
                bVar4.f6869c.setTitleEnabled(false);
                zBooleanValue = true;
            } else {
                zBooleanValue = ((Boolean) j0Var.G().O.getValue()).booleanValue();
            }
        } else {
            zBooleanValue = ((Boolean) j0Var.G().O.getValue()).booleanValue();
        }
        if (zBooleanValue2 && zBooleanValue) {
            if (j0Var.getResources().getConfiguration().getLayoutDirection() == 1) {
                String str2 = j0Var.D().f8567b;
                str2.getClass();
                int length = str2.length() - 1;
                int i14 = 0;
                for (int i15 = 0; i15 < length; i15++) {
                    String str3 = j0Var.D().f8567b;
                    str3.getClass();
                    char cCharAt = str3.charAt(i15);
                    if (cCharAt != ' ') {
                        ConcurrentHashMap concurrentHashMap = v5.n.f13169a;
                        if (1424 > cCharAt || cCharAt >= 1792) {
                            i14++;
                        }
                    }
                }
                if (i14 > 0) {
                    d5.b bVar5 = j0Var.f7785b;
                    bVar5.getClass();
                    bVar5.f6869c.setRtlTextDirectionHeuristicsEnabled(false);
                    d5.b bVar6 = j0Var.f7785b;
                    bVar6.getClass();
                    bVar6.f6869c.setLayoutDirection(0);
                }
            }
            d5.b bVar7 = j0Var.f7785b;
            bVar7.getClass();
            CollapsingToolbarLayout collapsingToolbarLayout = bVar7.f6869c;
            String str4 = j0Var.D().f8567b;
            str4.getClass();
            collapsingToolbarLayout.setTitle(str4);
        }
    }
}
