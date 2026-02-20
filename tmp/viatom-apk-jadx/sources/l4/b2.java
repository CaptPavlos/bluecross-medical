package l4;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.lifecycle.LifecycleOwnerKt;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class b2 extends w {
    public static final /* synthetic */ int K = 0;
    public c0.a H;
    public final ActivityResultLauncher I;
    public final ActivityResultLauncher J;

    public b2() {
        final int i10 = 0;
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback(this) { // from class: l4.y1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b2 f11015b;

            {
                this.f11015b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                GoogleSignInAccount googleSignInAccount;
                GoogleSignInAccount googleSignInAccount2;
                ActivityResult activityResult = (ActivityResult) obj;
                switch (i10) {
                    case 0:
                        Intent data = activityResult.getData();
                        b2 b2Var = this.f11015b;
                        if (data != null) {
                            h1.p pVarS = com.google.android.gms.internal.measurement.a4.s(activityResult.getData());
                            if (pVarS.i() && (googleSignInAccount = (GoogleSignInAccount) pVarS.g()) != null) {
                                r7.y.q(LifecycleOwnerKt.getLifecycleScope(b2Var), null, null, new a2(googleSignInAccount, b2Var, null, 0), 3);
                            }
                        }
                        b2Var.n0();
                        break;
                    default:
                        if (activityResult.getData() != null) {
                            h1.p pVarS2 = com.google.android.gms.internal.measurement.a4.s(activityResult.getData());
                            if (pVarS2.i() && (googleSignInAccount2 = (GoogleSignInAccount) pVarS2.g()) != null) {
                                b2 b2Var2 = this.f11015b;
                                r7.y.q(LifecycleOwnerKt.getLifecycleScope(b2Var2), null, null, new a2(googleSignInAccount2, b2Var2, null, 1), 3);
                                break;
                            }
                        }
                        break;
                }
            }
        });
        activityResultLauncherRegisterForActivityResult.getClass();
        this.I = activityResultLauncherRegisterForActivityResult;
        final int i11 = 1;
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback(this) { // from class: l4.y1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b2 f11015b;

            {
                this.f11015b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                GoogleSignInAccount googleSignInAccount;
                GoogleSignInAccount googleSignInAccount2;
                ActivityResult activityResult = (ActivityResult) obj;
                switch (i11) {
                    case 0:
                        Intent data = activityResult.getData();
                        b2 b2Var = this.f11015b;
                        if (data != null) {
                            h1.p pVarS = com.google.android.gms.internal.measurement.a4.s(activityResult.getData());
                            if (pVarS.i() && (googleSignInAccount = (GoogleSignInAccount) pVarS.g()) != null) {
                                r7.y.q(LifecycleOwnerKt.getLifecycleScope(b2Var), null, null, new a2(googleSignInAccount, b2Var, null, 0), 3);
                            }
                        }
                        b2Var.n0();
                        break;
                    default:
                        if (activityResult.getData() != null) {
                            h1.p pVarS2 = com.google.android.gms.internal.measurement.a4.s(activityResult.getData());
                            if (pVarS2.i() && (googleSignInAccount2 = (GoogleSignInAccount) pVarS2.g()) != null) {
                                b2 b2Var2 = this.f11015b;
                                r7.y.q(LifecycleOwnerKt.getLifecycleScope(b2Var2), null, null, new a2(googleSignInAccount2, b2Var2, null, 1), 3);
                                break;
                            }
                        }
                        break;
                }
            }
        });
        activityResultLauncherRegisterForActivityResult2.getClass();
        this.J = activityResultLauncherRegisterForActivityResult2;
    }

    public abstract void n0();

    public h5.e1 o0() {
        return null;
    }

    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        GoogleSignInOptions googleSignInOptions = GoogleSignInOptions.f1832k;
        new HashSet();
        new HashMap();
        i0.y.g(googleSignInOptions);
        HashSet hashSet = new HashSet(googleSignInOptions.f1839b);
        boolean z9 = googleSignInOptions.e;
        boolean z10 = googleSignInOptions.f;
        String str = googleSignInOptions.g;
        Account account = googleSignInOptions.f1840c;
        String str2 = googleSignInOptions.h;
        HashMap mapC = GoogleSignInOptions.c(googleSignInOptions.f1842i);
        String str3 = googleSignInOptions.f1843j;
        hashSet.add(GoogleSignInOptions.f1833l);
        i0.y.d("699621046070-qajra0rrsahiqmumvkg7fagujfd78tm8.apps.googleusercontent.com");
        i0.y.a("two different server client ids provided", str == null || str.equals("699621046070-qajra0rrsahiqmumvkg7fagujfd78tm8.apps.googleusercontent.com"));
        if (hashSet.contains(GoogleSignInOptions.f1836o)) {
            Scope scope = GoogleSignInOptions.f1835n;
            if (hashSet.contains(scope)) {
                hashSet.remove(scope);
            }
        }
        if (account == null || !hashSet.isEmpty()) {
            hashSet.add(GoogleSignInOptions.f1834m);
        }
        this.H = com.google.android.gms.internal.measurement.a4.o(this, new GoogleSignInOptions(3, new ArrayList(hashSet), account, true, z9, z10, "699621046070-qajra0rrsahiqmumvkg7fagujfd78tm8.apps.googleusercontent.com", str2, mapC, str3));
    }

    public final void p0() {
        GoogleSignInOptions googleSignInOptions = GoogleSignInOptions.f1832k;
        new HashSet();
        new HashMap();
        i0.y.g(googleSignInOptions);
        HashSet hashSet = new HashSet(googleSignInOptions.f1839b);
        boolean z9 = googleSignInOptions.e;
        boolean z10 = googleSignInOptions.f;
        String str = googleSignInOptions.g;
        Account account = googleSignInOptions.f1840c;
        String str2 = googleSignInOptions.h;
        HashMap mapC = GoogleSignInOptions.c(googleSignInOptions.f1842i);
        String str3 = googleSignInOptions.f1843j;
        hashSet.add(GoogleSignInOptions.f1833l);
        i0.y.d("699621046070-qajra0rrsahiqmumvkg7fagujfd78tm8.apps.googleusercontent.com");
        i0.y.a("two different server client ids provided", str == null || str.equals("699621046070-qajra0rrsahiqmumvkg7fagujfd78tm8.apps.googleusercontent.com"));
        if (hashSet.contains(GoogleSignInOptions.f1836o)) {
            Scope scope = GoogleSignInOptions.f1835n;
            if (hashSet.contains(scope)) {
                hashSet.remove(scope);
            }
        }
        if (account == null || !hashSet.isEmpty()) {
            hashSet.add(GoogleSignInOptions.f1834m);
        }
        this.J.launch(com.google.android.gms.internal.measurement.a4.o(this, new GoogleSignInOptions(3, new ArrayList(hashSet), account, true, z9, z10, "699621046070-qajra0rrsahiqmumvkg7fagujfd78tm8.apps.googleusercontent.com", str2, mapC, str3)).b());
    }

    public abstract void r0(h5.e1 e1Var);

    public abstract void s0(h5.e1 e1Var, String str);

    public abstract void t0();

    public abstract void u0();

    public void q0() {
    }
}
