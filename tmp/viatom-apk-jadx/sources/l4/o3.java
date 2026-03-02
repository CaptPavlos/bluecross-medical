package l4;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.Updates;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o3 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10682a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f10683b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Bundle f10684c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f10685d;
    public final /* synthetic */ a4 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o3(int i10, Bundle bundle, a4 a4Var, String str, w6.c cVar, int i11) {
        super(2, cVar);
        this.f10682a = i11;
        this.f10683b = i10;
        this.f10684c = bundle;
        this.e = a4Var;
        this.f10685d = str;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10682a) {
            case 0:
                return new o3(this.f10683b, this.f10684c, (MyApps) this.e, this.f10685d, cVar, 0);
            default:
                return new o3(this.f10683b, this.f10684c, (Updates) this.e, this.f10685d, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) throws Resources.NotFoundException {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10682a) {
            case 0:
                o3 o3Var = (o3) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                o3Var.invokeSuspend(wVar2);
                return wVar2;
            default:
                o3 o3Var2 = (o3) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                o3Var2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws Resources.NotFoundException {
        int iB0;
        h5.f fVar;
        String str;
        int iB02;
        n4.w0 w0Var;
        h5.f fVar2;
        String str2;
        ArrayList arrayList;
        ArrayList arrayListH;
        ArrayList arrayList2;
        h5.f fVar3;
        boolean z9 = true;
        w6.c cVar = null;
        switch (this.f10682a) {
            case 0:
                String str3 = this.f10685d;
                MyApps myApps = (MyApps) this.e;
                s6.a.e(obj);
                int i10 = this.f10683b;
                if (i10 == 102) {
                    Bundle bundle = new Bundle();
                    if (str3 != null) {
                        bundle.putString("packagename", str3);
                    }
                    t1.c cVar2 = myApps.f10934v;
                    if (cVar2 != null) {
                        cVar2.e(bundle, "update_download_failed");
                    }
                    String string = myApps.getString(R.string.descarga_error);
                    string.getClass();
                    myApps.C(string);
                } else if (i10 != 108) {
                    if (i10 != 110) {
                        if (i10 != 201) {
                            switch (i10) {
                                case 104:
                                    String string2 = myApps.getString(R.string.no_free_space);
                                    string2.getClass();
                                    myApps.C(string2);
                                    break;
                                case 105:
                                    Bundle bundle2 = this.f10684c;
                                    if (bundle2 != null) {
                                        ArrayList parcelableArrayList = Build.VERSION.SDK_INT >= 34 ? bundle2.getParcelableArrayList("apps_parcelable", h5.f.class) : bundle2.getParcelableArrayList("apps_parcelable");
                                        if (parcelableArrayList != null) {
                                            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(myApps);
                                            y7.e eVar = r7.i0.f12407a;
                                            r7.y.q(lifecycleScope, w7.n.f13548a, null, new a6.j(myApps, parcelableArrayList, cVar, 28), 2);
                                            break;
                                        }
                                    }
                                    break;
                                case 106:
                                    String string3 = myApps.getString(R.string.download_cancelled);
                                    string3.getClass();
                                    myApps.C(string3);
                                    break;
                            }
                        } else {
                            n4.p pVar = myApps.W;
                            if (pVar != null) {
                                Iterator it = pVar.f11451d.iterator();
                                int i11 = 0;
                                while (true) {
                                    if (it.hasNext()) {
                                        int i12 = i11 + 1;
                                        Object next = it.next();
                                        if ((!(next instanceof h5.f) || (str = (fVar = (h5.f) next).f8526c) == null || str.length() == 0 || !o7.u.Z(fVar.f8526c, str3, true)) && (!(next instanceof n4.u0) || !o7.u.Z(((n4.u0) next).f11494b.f8795b, str3, true))) {
                                            i11 = i12;
                                        }
                                    } else {
                                        i11 = -1;
                                    }
                                }
                                if (i11 >= 0) {
                                    pVar.notifyItemChanged(i11);
                                }
                            }
                            z9 = false;
                        }
                    }
                } else if (str3 != null && str3.length() != 0) {
                    int i13 = MyApps.f6655j0;
                    t3.h hVar = v5.g.f13148u;
                    Context applicationContext = myApps.getApplicationContext();
                    applicationContext.getClass();
                    v5.g gVarL = hVar.l(applicationContext);
                    gVarL.a();
                    h5.y0 y0VarM = gVarL.M(str3);
                    h5.q qVarA = y0VarM != null ? y0VarM.a(myApps) : null;
                    h5.f fVarR = gVarL.r(str3);
                    gVarL.b();
                    if (qVarA != null && qVarA.c()) {
                        UptodownApp.l0 = fVarR;
                        File fileG = qVarA.g();
                        if (fileG != null) {
                            if (y0VarM.g == 1) {
                                myApps.t0(y0VarM, fileG);
                            } else {
                                myApps.U(fileG, null);
                            }
                        }
                    }
                }
                if (myApps.O) {
                    LifecycleCoroutineScope lifecycleScope2 = LifecycleOwnerKt.getLifecycleScope(myApps);
                    y7.e eVar2 = r7.i0.f12407a;
                    r7.y.q(lifecycleScope2, w7.n.f13548a, null, new u3(i10, myApps, null), 2);
                }
                if (z9 && (iB0 = MyApps.B0(myApps, str3)) > -1) {
                    n4.p pVar2 = myApps.W;
                    pVar2.getClass();
                    pVar2.notifyItemChanged(iB0);
                }
                return s6.w.f12711a;
            default:
                String str4 = this.f10685d;
                Updates updates = (Updates) this.e;
                s6.a.e(obj);
                int i14 = this.f10683b;
                if (i14 != 110) {
                    if (i14 == 201) {
                        Updates.C0(updates, str4);
                        n4.w0 w0Var2 = updates.X;
                        if (w0Var2 != null) {
                            Iterator it2 = w0Var2.a().iterator();
                            int i15 = 0;
                            while (true) {
                                if (it2.hasNext()) {
                                    int i16 = i15 + 1;
                                    Object next2 = it2.next();
                                    if ((!(next2 instanceof h5.f) || (str2 = (fVar2 = (h5.f) next2).f8526c) == null || str2.length() == 0 || !o7.u.Z(fVar2.f8526c, str4, true)) && (!(next2 instanceof n4.u0) || !o7.u.Z(((n4.u0) next2).f11494b.f8795b, str4, true))) {
                                        i15 = i16;
                                    }
                                } else {
                                    i15 = -1;
                                }
                            }
                            if (i15 >= 0) {
                                w0Var2.notifyItemChanged(i15);
                            }
                        }
                    } else if (i14 != 205 && i14 != 206) {
                        switch (i14) {
                            case 102:
                                Bundle bundle3 = new Bundle();
                                if (str4 != null) {
                                    bundle3.putString("packagename", str4);
                                }
                                t1.c cVar3 = updates.f10934v;
                                if (cVar3 != null) {
                                    cVar3.e(bundle3, "update_download_failed");
                                }
                                AlertDialog alertDialog = updates.f10935w;
                                if (alertDialog == null || !alertDialog.isShowing()) {
                                    String string4 = updates.getString(R.string.download_error_message);
                                    string4.getClass();
                                    updates.N(string4);
                                }
                                if (!updates.Y.isEmpty()) {
                                    if (str4 != null) {
                                        updates.F0(str4);
                                    } else {
                                        updates.Y.remove(0).getClass();
                                    }
                                    updates.G0();
                                    break;
                                }
                                break;
                            case 103:
                                float f = UptodownApp.E;
                                synchronized (UptodownApp.f6638p0) {
                                    arrayList = UptodownApp.f6639q0;
                                }
                                if (arrayList.isEmpty() && ((arrayListH = k4.c.h()) == null || arrayListH.isEmpty())) {
                                    int i17 = Updates.f6656p0;
                                    updates.M0(false);
                                    break;
                                }
                                break;
                            case 104:
                                String string5 = updates.getString(R.string.no_free_space);
                                string5.getClass();
                                updates.C(string5);
                                updates.P0();
                                break;
                            case 105:
                                Bundle bundle4 = this.f10684c;
                                if (bundle4 != null) {
                                    ArrayList parcelableArrayList2 = Build.VERSION.SDK_INT >= 34 ? bundle4.getParcelableArrayList("apps_parcelable", h5.f.class) : bundle4.getParcelableArrayList("apps_parcelable");
                                    if (parcelableArrayList2 != null) {
                                        int i18 = Updates.f6656p0;
                                        if (updates.L) {
                                            LifecycleCoroutineScope lifecycleScope3 = LifecycleOwnerKt.getLifecycleScope(updates);
                                            y7.e eVar3 = r7.i0.f12407a;
                                            r7.y.q(lifecycleScope3, w7.n.f13548a, null, new u4(updates, parcelableArrayList2, cVar, 11), 2);
                                            break;
                                        }
                                    }
                                }
                                break;
                            case 106:
                                int i19 = Updates.f6656p0;
                                updates.G0();
                                break;
                            case 107:
                                Updates.C0(updates, str4);
                                n4.w0 w0Var3 = updates.X;
                                if (w0Var3 != null) {
                                    w0Var3.notifyDataSetChanged();
                                    break;
                                }
                                break;
                            case 108:
                                if (updates.Y.isEmpty() && (arrayList2 = updates.W) != null && !arrayList2.isEmpty()) {
                                    ArrayList arrayList3 = updates.W;
                                    arrayList3.getClass();
                                    Iterator it3 = arrayList3.iterator();
                                    it3.getClass();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            Object next3 = it3.next();
                                            next3.getClass();
                                            n4.u0 u0Var = (n4.u0) next3;
                                            fVar3 = u0Var.f11493a;
                                            if (o7.u.Z(fVar3.f8526c, str4, false)) {
                                                v5.g gVarL2 = v5.g.f13148u.l(updates);
                                                gVarL2.a();
                                                h5.q qVar = u0Var.f11494b.f8798i;
                                                qVar.getClass();
                                                h5.q qVarZ = gVarL2.z(qVar.f8700a);
                                                gVarL2.b();
                                                if (qVarZ == null || !qVarZ.c()) {
                                                }
                                            }
                                        }
                                    }
                                    fVar3 = null;
                                    if (fVar3 != null) {
                                        updates.Y.add(fVar3);
                                    }
                                }
                                updates.G0();
                                break;
                        }
                    }
                    z9 = false;
                } else {
                    int i20 = Updates.f6656p0;
                    updates.P0();
                }
                if (updates.O) {
                    LifecycleCoroutineScope lifecycleScope4 = LifecycleOwnerKt.getLifecycleScope(updates);
                    y7.e eVar4 = r7.i0.f12407a;
                    r7.y.q(lifecycleScope4, w7.n.f13548a, null, new u3(i14, updates, null), 2);
                }
                if (z9 && (iB02 = Updates.B0(updates, str4)) > -1 && (w0Var = updates.X) != null) {
                    w0Var.notifyItemChanged(iB02);
                }
                return s6.w.f12711a;
        }
    }
}
