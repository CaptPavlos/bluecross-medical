package l4;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.uptodown.activities.AppInstalledDetailsActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10446a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppInstalledDetailsActivity f10447b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(AppInstalledDetailsActivity appInstalledDetailsActivity, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10446a = i10;
        this.f10447b = appInstalledDetailsActivity;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10446a) {
            case 0:
                return new h(this.f10447b, cVar, 0);
            case 1:
                return new h(this.f10447b, cVar, 1);
            default:
                return new h(this.f10447b, cVar, 2);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10446a) {
            case 0:
                h hVar = (h) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                hVar.invokeSuspend(wVar2);
                return wVar2;
            case 1:
                h hVar2 = (h) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                hVar2.invokeSuspend(wVar3);
                return wVar3;
            default:
                h hVar3 = (h) create(wVar, cVar);
                s6.w wVar4 = s6.w.f12711a;
                hVar3.invokeSuspend(wVar4);
                return wVar4;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        PackageInfo packageInfoF;
        PermissionInfo[] permissionInfoArr;
        switch (this.f10446a) {
            case 0:
                s6.a.e(obj);
                AppInstalledDetailsActivity.C0(this.f10447b);
                break;
            case 1:
                AppInstalledDetailsActivity appInstalledDetailsActivity = this.f10447b;
                s6.a.e(obj);
                try {
                    PackageManager packageManager = appInstalledDetailsActivity.getPackageManager();
                    packageManager.getClass();
                    h5.f fVar = appInstalledDetailsActivity.V;
                    fVar.getClass();
                    String str = fVar.f8526c;
                    str.getClass();
                    packageInfoF = l5.a.f(packageManager, str, 4096);
                } catch (PackageManager.NameNotFoundException unused) {
                    packageInfoF = null;
                }
                if (packageInfoF != null && (permissionInfoArr = packageInfoF.permissions) != null) {
                    appInstalledDetailsActivity.X = new ArrayList();
                    int i10 = 0;
                    while (i10 < permissionInfoArr.length) {
                        int i11 = i10 + 1;
                        try {
                            PermissionInfo permissionInfo = permissionInfoArr[i10];
                            h5.e0 e0Var = new h5.e0();
                            String.valueOf(permissionInfo.loadDescription(appInstalledDetailsActivity.getPackageManager()));
                            e0Var.f8510a = permissionInfo.name;
                            ArrayList arrayList = appInstalledDetailsActivity.X;
                            arrayList.getClass();
                            arrayList.add(e0Var);
                            i10 = i11;
                        } catch (ArrayIndexOutOfBoundsException e) {
                            com.google.gson.internal.a.o(e.getMessage());
                            return null;
                        }
                    }
                }
                break;
            default:
                s6.a.e(obj);
                AppInstalledDetailsActivity appInstalledDetailsActivity2 = this.f10447b;
                ArrayList arrayList2 = appInstalledDetailsActivity2.X;
                int size = 0;
                if (arrayList2 == null || arrayList2.isEmpty()) {
                    appInstalledDetailsActivity2.F0().f7000o.setVisibility(8);
                } else {
                    ArrayList arrayList3 = appInstalledDetailsActivity2.X;
                    arrayList3.getClass();
                    LinearLayout linearLayout = appInstalledDetailsActivity2.F0().h;
                    int size2 = arrayList3.size();
                    while (size < size2) {
                        d5.u uVarA = d5.u.a(LayoutInflater.from(appInstalledDetailsActivity2.getApplicationContext()));
                        TextView textView = uVarA.f7366c;
                        textView.setTypeface(o4.b.f11720s);
                        textView.setText(((h5.e0) arrayList3.get(size)).f8510a);
                        linearLayout.addView(uVarA.f7365b);
                        size++;
                    }
                    ArrayList arrayList4 = appInstalledDetailsActivity2.X;
                    arrayList4.getClass();
                    size = arrayList4.size();
                }
                appInstalledDetailsActivity2.F0().K.setText(String.valueOf(size));
                break;
        }
        return s6.w.f12711a;
    }
}
