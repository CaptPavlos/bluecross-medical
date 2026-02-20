package e5;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.ViewModelKt;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.LoginActivity;
import com.uptodown.core.activities.InstallerActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7739a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7740b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f7741c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f7742d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;

    public /* synthetic */ f(ArrayList arrayList, j0 j0Var, ArrayList arrayList2, kotlin.jvm.internal.u uVar, a3.x xVar) {
        this.f7741c = arrayList;
        this.e = j0Var;
        this.f7742d = arrayList2;
        this.f7740b = uVar;
        this.f = xVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Resources.NotFoundException {
        Object obj;
        int i10 = this.f7739a;
        int i11 = 1;
        Object obj2 = this.f;
        Object obj3 = this.f7740b;
        Object obj4 = this.e;
        Object obj5 = this.f7742d;
        Object obj6 = this.f7741c;
        switch (i10) {
            case 0:
                ArrayList arrayList = (ArrayList) obj6;
                j0 j0Var = (j0) obj4;
                ArrayList arrayList2 = (ArrayList) obj5;
                kotlin.jvm.internal.u uVar = (kotlin.jvm.internal.u) obj3;
                a3.x xVar = (a3.x) obj2;
                int size = arrayList.size();
                int i12 = 0;
                while (true) {
                    if (i12 < size) {
                        obj = arrayList.get(i12);
                        i12++;
                        if (((h5.j1) obj).f8630c == 1) {
                        }
                    } else {
                        obj = null;
                    }
                }
                h5.j1 j1Var = (h5.j1) obj;
                if (j1Var != null) {
                    c1 c1VarG = j0Var.G();
                    Context contextRequireContext = j0Var.requireContext();
                    contextRequireContext.getClass();
                    long j10 = j0Var.D().f8566a;
                    c1VarG.getClass();
                    r7.w viewModelScope = ViewModelKt.getViewModelScope(c1VarG);
                    y7.e eVar = r7.i0.f12407a;
                    r7.y.q(viewModelScope, y7.d.f14116a, null, new z0(contextRequireContext, j10, j1Var, arrayList2, c1VarG, null), 2);
                }
                if (uVar.f10135a && j0Var.D().k() && j0Var.D().j()) {
                    Context contextRequireContext2 = j0Var.requireContext();
                    contextRequireContext2.getClass();
                    FragmentActivity fragmentActivityRequireActivity = j0Var.requireActivity();
                    fragmentActivityRequireActivity.getClass();
                    l1.b.h(contextRequireContext2, (l4.w) fragmentActivityRequireActivity, j0Var.D(), j0Var.f7792m, false);
                }
                j0Var.u(xVar);
                break;
            case 1:
                kotlin.jvm.internal.u uVar2 = (kotlin.jvm.internal.u) obj3;
                TextView textView = (TextView) obj6;
                InstallerActivity installerActivity = (InstallerActivity) obj5;
                ImageView imageView = (ImageView) obj4;
                TextView textView2 = (TextView) obj2;
                int i13 = InstallerActivity.f6676m0;
                if (!uVar2.f10135a) {
                    textView.setText(installerActivity.getString(R.string.core_installer_new_features_title_hide));
                    imageView.setImageDrawable(ContextCompat.getDrawable(installerActivity, R.drawable.vector_arrow_angle_up_small_off));
                    textView2.setVisibility(0);
                    uVar2.f10135a = true;
                    break;
                } else {
                    textView.setText(installerActivity.getString(R.string.core_installer_new_features_title));
                    imageView.setImageDrawable(ContextCompat.getDrawable(installerActivity, R.drawable.vector_arrow_angle_down_small_off));
                    textView2.setVisibility(8);
                    uVar2.f10135a = false;
                    break;
                }
            default:
                l4.w wVar = (l4.w) obj6;
                LifecycleCoroutineScope lifecycleCoroutineScope = (LifecycleCoroutineScope) obj5;
                z5.d dVar = (z5.d) obj4;
                z5.c cVar = (z5.c) obj3;
                z5.c cVar2 = (z5.c) obj2;
                float f = UptodownApp.E;
                if (k4.c.s()) {
                    if (h5.c1.h(wVar) != null) {
                        r7.y.q(lifecycleCoroutineScope, null, null, new a6.q(dVar, wVar, cVar, cVar2, (w6.c) null, 17), 3);
                        new Handler(Looper.getMainLooper()).postDelayed(new y5.y(i11, dVar, wVar), 1000L);
                        break;
                    } else {
                        wVar.startActivity(new Intent(wVar, (Class<?>) LoginActivity.class), k4.c.a(wVar));
                        break;
                    }
                }
                break;
        }
    }

    public /* synthetic */ f(kotlin.jvm.internal.u uVar, TextView textView, InstallerActivity installerActivity, ImageView imageView, TextView textView2) {
        this.f7740b = uVar;
        this.f7741c = textView;
        this.f7742d = installerActivity;
        this.e = imageView;
        this.f = textView2;
    }

    public /* synthetic */ f(l4.w wVar, LifecycleCoroutineScope lifecycleCoroutineScope, z5.d dVar, z5.c cVar, z5.c cVar2) {
        this.f7741c = wVar;
        this.f7742d = lifecycleCoroutineScope;
        this.e = dVar;
        this.f7740b = cVar;
        this.f = cVar2;
    }
}
