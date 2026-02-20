package s5;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.tv.ui.fragment.TvMyAppsFragment;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class v implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12675a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h5.f f12676b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TvMyAppsFragment f12677c;

    public /* synthetic */ v(TvMyAppsFragment tvMyAppsFragment, h5.f fVar, int i10) {
        this.f12675a = i10;
        this.f12677c = tvMyAppsFragment;
        this.f12676b = fVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f12675a) {
            case 0:
                h5.f fVar = this.f12676b;
                TvMyAppsFragment tvMyAppsFragment = this.f12677c;
                try {
                    if (fVar.f8526c != null) {
                        PackageManager packageManager = tvMyAppsFragment.requireContext().getPackageManager();
                        String str = fVar.f8526c;
                        str.getClass();
                        Intent leanbackLaunchIntentForPackage = packageManager.getLeanbackLaunchIntentForPackage(str);
                        if (leanbackLaunchIntentForPackage == null) {
                            PackageManager packageManager2 = tvMyAppsFragment.requireContext().getPackageManager();
                            String str2 = fVar.f8526c;
                            str2.getClass();
                            leanbackLaunchIntentForPackage = packageManager2.getLaunchIntentForPackage(str2);
                        }
                        if (leanbackLaunchIntentForPackage != null) {
                            tvMyAppsFragment.startActivity(leanbackLaunchIntentForPackage);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                AlertDialog alertDialog = tvMyAppsFragment.f6710c;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                    break;
                }
                break;
            case 1:
                h5.f fVar2 = this.f12676b;
                String str3 = fVar2.f8526c;
                TvMyAppsFragment tvMyAppsFragment2 = this.f12677c;
                if (str3 != null) {
                    Context contextRequireContext = tvMyAppsFragment2.requireContext();
                    contextRequireContext.getClass();
                    String str4 = fVar2.f8526c;
                    str4.getClass();
                    Intent intent = new Intent("android.intent.action.DELETE", Uri.parse("package:".concat(str4)));
                    intent.addFlags(268435456);
                    contextRequireContext.startActivity(intent);
                }
                AlertDialog alertDialog2 = tvMyAppsFragment2.f6710c;
                if (alertDialog2 != null) {
                    alertDialog2.dismiss();
                    break;
                }
                break;
            case 2:
                TvMyAppsFragment tvMyAppsFragment3 = this.f12677c;
                Context contextRequireContext2 = tvMyAppsFragment3.requireContext();
                contextRequireContext2.getClass();
                h5.f fVar3 = this.f12676b;
                new c1.l(contextRequireContext2, fVar3.f8541w, new i0.k(29, tvMyAppsFragment3, fVar3), LifecycleOwnerKt.getLifecycleScope(tvMyAppsFragment3));
                AlertDialog alertDialog3 = tvMyAppsFragment3.f6710c;
                if (alertDialog3 != null) {
                    alertDialog3.dismiss();
                    break;
                }
                break;
            default:
                TvMyAppsFragment tvMyAppsFragment4 = this.f12677c;
                AlertDialog alertDialog4 = tvMyAppsFragment4.f6710c;
                if (alertDialog4 != null) {
                    alertDialog4.dismiss();
                }
                t3.h hVar = v5.g.f13148u;
                Context contextRequireContext3 = tvMyAppsFragment4.requireContext();
                contextRequireContext3.getClass();
                v5.g gVarL = hVar.l(contextRequireContext3);
                gVarL.a();
                h5.f fVar4 = this.f12676b;
                if (fVar4.f8532m == 0) {
                    fVar4.f8532m = 1;
                    fVar4.g = h5.e.f8507b;
                    String str5 = fVar4.f8526c;
                    str5.getClass();
                    gVarL.m(str5);
                    Context contextRequireContext4 = tvMyAppsFragment4.requireContext();
                    contextRequireContext4.getClass();
                    r0.f.o(contextRequireContext4);
                } else {
                    fVar4.f8532m = 0;
                }
                gVarL.Z(fVar4);
                gVarL.b();
                break;
        }
    }

    public /* synthetic */ v(h5.f fVar, TvMyAppsFragment tvMyAppsFragment, int i10) {
        this.f12675a = i10;
        this.f12676b = fVar;
        this.f12677c = tvMyAppsFragment;
    }
}
