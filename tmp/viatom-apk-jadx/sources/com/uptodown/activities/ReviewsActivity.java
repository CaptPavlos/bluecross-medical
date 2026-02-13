package com.uptodown.activities;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import com.uptodown.R;
import d5.t0;
import kotlin.jvm.internal.y;
import l4.b8;
import l4.f8;
import l4.g8;
import l4.k8;
import l4.n5;
import l4.u4;
import l4.w;
import l4.x2;
import n4.i0;
import s6.m;
import y7.d;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class ReviewsActivity extends w {
    public static final /* synthetic */ int M = 0;
    public i0 J;
    public final ActivityResultLauncher L;
    public final m H = new m(new x2(this, 11));
    public final ViewModelLazy I = new ViewModelLazy(y.a(k8.class), new g8(this, 0), new f8(this), new g8(this, 1));
    public final n5 K = new n5(this, 7);

    public ReviewsActivity() {
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new b8(this));
        activityResultLauncherRegisterForActivityResult.getClass();
        this.L = activityResultLauncherRegisterForActivityResult;
    }

    public final t0 n0() {
        return (t0) this.H.getValue();
    }

    public final void o0() {
        if (p0().f10564m) {
            k8 k8VarP0 = p0();
            k8VarP0.getClass();
            r7.w viewModelScope = ViewModelKt.getViewModelScope(k8VarP0);
            e eVar = r7.i0.f12407a;
            r7.y.q(viewModelScope, d.f14116a, null, new u4(k8VarP0, this, null, 10), 2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00df  */
    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onCreate(android.os.Bundle r10) {
        /*
            Method dump skipped, instructions count: 959
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.ReviewsActivity.onCreate(android.os.Bundle):void");
    }

    public final k8 p0() {
        return (k8) this.I.getValue();
    }

    public final void q0() {
        n0().f7356l.setAdapter(null);
        this.J = null;
        p0().f10564m = true;
        p0().f10566o = 0;
        o0();
    }

    public final void r0(String str) {
        int iIntValue = ((Number) p0().f10563l.getValue()).intValue();
        if (1 > iIntValue || iIntValue >= 6) {
            String string = getString(R.string.error_review_no_valoration);
            string.getClass();
            C(string);
        } else {
            k8 k8VarP0 = p0();
            k8VarP0.getClass();
            r7.w viewModelScope = ViewModelKt.getViewModelScope(k8VarP0);
            e eVar = r7.i0.f12407a;
            r7.y.q(viewModelScope, d.f14116a, null, new c5.m(this, str, k8VarP0, null, 13), 2);
        }
    }
}
