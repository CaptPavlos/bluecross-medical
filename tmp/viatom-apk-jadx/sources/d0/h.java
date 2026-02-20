package d0;

import a6.o;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import com.google.android.gms.auth.api.signin.internal.SignInHubActivity;
import com.google.android.gms.internal.measurement.h0;
import java.util.Iterator;
import p8.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final o f6778a = new o("GoogleSignInCommon", new String[0]);

    public static Intent a(Context context, GoogleSignInOptions googleSignInOptions) {
        f6778a.b("getSignInIntent()", new Object[0]);
        SignInConfiguration signInConfiguration = new SignInConfiguration(context.getPackageName(), googleSignInOptions);
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setPackage(context.getPackageName());
        intent.setClass(context, SignInHubActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("config", signInConfiguration);
        intent.putExtra("config", bundle);
        return intent;
    }

    public static void b(Context context) {
        i.E(context).F();
        Iterator it = g0.g.a().iterator();
        if (it.hasNext()) {
            ((g0.g) it.next()).getClass();
            u.p();
            return;
        }
        synchronized (h0.e.f8361q) {
            try {
                h0.e eVar = h0.e.f8362r;
                if (eVar != null) {
                    eVar.f8367i.incrementAndGet();
                    h0 h0Var = eVar.f8371m;
                    h0Var.sendMessageAtFrontOfQueue(h0Var.obtainMessage(10));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
