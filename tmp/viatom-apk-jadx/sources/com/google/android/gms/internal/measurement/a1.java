package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a1 extends h1 {
    public final /* synthetic */ int e;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object g;
    public final /* synthetic */ Object h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a1(k1 k1Var, Activity activity, i0 i0Var) {
        super(k1Var.f2021a, true);
        this.e = 3;
        this.g = activity;
        this.h = i0Var;
        this.f = k1Var;
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public final void a() {
        Boolean boolValueOf;
        Bundle bundle;
        switch (this.e) {
            case 0:
                try {
                    Context context = (Context) this.g;
                    i0.y.g(context);
                    String strA = c1.l2.a(context);
                    Resources resources = context.getResources();
                    if (TextUtils.isEmpty(strA)) {
                        strA = c1.l2.a(context);
                    }
                    int identifier = resources.getIdentifier("google_analytics_force_disable_updates", "bool", strA);
                    l0 l0VarAsInterface = null;
                    if (identifier == 0) {
                        boolValueOf = null;
                    } else {
                        try {
                            boolValueOf = Boolean.valueOf(resources.getBoolean(identifier));
                        } catch (Resources.NotFoundException unused) {
                        }
                    }
                    l1 l1Var = (l1) this.f;
                    boolean z9 = boolValueOf == null || !boolValueOf.booleanValue();
                    l1Var.getClass();
                    try {
                        l0VarAsInterface = k0.asInterface(r0.e.c(context, z9 ? r0.e.f12300c : r0.e.f12299b, ModuleDescriptor.MODULE_ID).b("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
                    } catch (r0.b e) {
                        l1Var.b(e, true, false);
                    }
                    l1Var.f = l0VarAsInterface;
                    if (l1Var.f != null) {
                        int iA = r0.e.a(context, ModuleDescriptor.MODULE_ID);
                        v0 v0Var = new v0(133005L, Math.max(iA, r6), Boolean.TRUE.equals(boolValueOf) || r0.e.d(context, ModuleDescriptor.MODULE_ID, false) < iA, (Bundle) this.h, c1.l2.a(context));
                        l0 l0Var = l1Var.f;
                        i0.y.g(l0Var);
                        l0Var.initialize(new q0.b(context), v0Var, this.f1976a);
                        break;
                    } else {
                        Log.w("FA", "Failed to connect to measurement client.");
                        break;
                    }
                } catch (Exception e3) {
                    ((l1) this.f).b(e3, true, false);
                    return;
                }
                break;
            case 1:
                l0 l0Var2 = ((l1) this.f).f;
                i0.y.g(l0Var2);
                l0Var2.getMaxUserProperties((String) this.g, (i0) this.h);
                break;
            case 2:
                Bundle bundle2 = (Bundle) this.h;
                if (bundle2 != null) {
                    bundle = new Bundle();
                    if (bundle2.containsKey("com.google.app_measurement.screen_service")) {
                        Object obj = bundle2.get("com.google.app_measurement.screen_service");
                        if (obj instanceof Bundle) {
                            bundle.putBundle("com.google.app_measurement.screen_service", (Bundle) obj);
                        }
                    }
                } else {
                    bundle = null;
                }
                l0 l0Var3 = ((k1) this.f).f2021a.f;
                i0.y.g(l0Var3);
                l0Var3.onActivityCreatedByScionActivityInfo(x0.b((Activity) this.g), bundle, this.f1977b);
                break;
            default:
                l0 l0Var4 = ((k1) this.f).f2021a.f;
                i0.y.g(l0Var4);
                l0Var4.onActivitySaveInstanceStateByScionActivityInfo(x0.b((Activity) this.g), (i0) this.h, this.f1977b);
                break;
        }
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void b() {
        switch (this.e) {
            case 1:
                ((i0) this.h).u(null);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a1(l1 l1Var, Object obj, Object obj2, int i10) {
        super(l1Var, true);
        this.e = i10;
        this.g = obj;
        this.h = obj2;
        this.f = l1Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a1(k1 k1Var, Bundle bundle, Activity activity) {
        super(k1Var.f2021a, true);
        this.e = 2;
        this.h = bundle;
        this.g = activity;
        this.f = k1Var;
    }
}
