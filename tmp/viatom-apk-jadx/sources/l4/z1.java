package l4;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class z1 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11055a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.j4 f11056b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b2 f11057c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ z1(com.google.android.gms.internal.measurement.j4 j4Var, b2 b2Var, w6.c cVar, int i10) {
        super(2, cVar);
        this.f11055a = i10;
        this.f11056b = j4Var;
        this.f11057c = b2Var;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f11055a) {
            case 0:
                return new z1(this.f11056b, this.f11057c, cVar, 0);
            default:
                return new z1(this.f11056b, this.f11057c, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f11055a) {
            case 0:
                z1 z1Var = (z1) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                z1Var.invokeSuspend(wVar2);
                return wVar2;
            default:
                z1 z1Var2 = (z1) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                z1Var2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        SharedPreferences sharedPreferences;
        String str;
        SharedPreferences sharedPreferences2;
        int i10 = this.f11055a;
        s6.w wVar = s6.w.f12711a;
        b2 b2Var = this.f11057c;
        com.google.android.gms.internal.measurement.j4 j4Var = this.f11056b;
        switch (i10) {
            case 0:
                s6.a.e(obj);
                boolean z9 = j4Var.f2007a;
                h5.e1 e1Var = (h5.e1) j4Var.f2008b;
                if (z9) {
                    b2Var.s0(e1Var, (String) j4Var.f2009c);
                    b2Var.setResult(-1);
                } else {
                    b2Var.r0(e1Var);
                    b2Var.u0();
                    b2Var.setResult(1);
                    Bundle bundle = new Bundle();
                    bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "success");
                    bundle.putString("loginSource", "google");
                    t1.c cVar = b2Var.f10934v;
                    if (cVar != null) {
                        cVar.e(bundle, "login");
                    }
                }
                b2Var.n0();
                SharedPreferences sharedPreferences3 = b2Var.getSharedPreferences("SharedPreferencesUser", 0);
                try {
                    sharedPreferences = b2Var.getSharedPreferences("SettingsPreferences", 0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String string = sharedPreferences.contains("UTOKEN") ? sharedPreferences.getString("UTOKEN", null) : null;
                if (string != null || sharedPreferences3.getString("is_turbo", null) != null) {
                    b2Var.finish();
                    break;
                } else {
                    b2Var.getOnBackPressedDispatcher().onBackPressed();
                    break;
                }
                break;
            default:
                s6.a.e(obj);
                if (j4Var.f2007a) {
                    b2Var.setResult(-1);
                } else {
                    h5.e1 e1Var2 = (h5.e1) j4Var.f2008b;
                    int i11 = b2.K;
                    if (e1Var2 != null) {
                        e1Var2.e(b2Var);
                    }
                    if (e1Var2 != null) {
                        try {
                            str = e1Var2.f8515d;
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    } else {
                        str = null;
                    }
                    if (str != null && str.length() != 0) {
                        String str2 = e1Var2.f8515d;
                        str2.getClass();
                        AccountManager.get(b2Var.getBaseContext()).addAccountExplicitly(new Account(str2, b2Var.getString(R.string.account)), null, null);
                    }
                    b2Var.u0();
                    b2Var.setResult(1);
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "success");
                    bundle2.putString("loginSource", "google");
                    t1.c cVar2 = b2Var.f10934v;
                    if (cVar2 != null) {
                        cVar2.e(bundle2, "login");
                    }
                }
                SharedPreferences sharedPreferences4 = b2Var.getSharedPreferences("SharedPreferencesUser", 0);
                try {
                    sharedPreferences2 = b2Var.getSharedPreferences("SettingsPreferences", 0);
                } catch (Exception e7) {
                    e7.printStackTrace();
                }
                String string2 = sharedPreferences2.contains("UTOKEN") ? sharedPreferences2.getString("UTOKEN", null) : null;
                if (string2 != null || sharedPreferences4.getString("is_turbo", null) != null) {
                    b2Var.o0();
                    b2Var.q0();
                    break;
                }
                break;
        }
        return wVar;
    }
}
