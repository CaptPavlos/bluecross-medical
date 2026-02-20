package b0;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.internal.measurement.l5;
import d5.j;
import g0.e;
import g0.f;
import h0.n;
import i0.o;
import u0.d;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends l5 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f819a;

    @Override // com.google.android.gms.internal.measurement.l5
    public g0.b h(Context context, Looper looper, j jVar, Object obj, e eVar, f fVar) {
        switch (this.f819a) {
            case 0:
                return new d(context, looper, jVar, (c) obj, (n) eVar, (n) fVar);
            case 1:
                return new d0.e(context, looper, jVar, (GoogleSignInOptions) obj, (n) eVar, (n) fVar);
            case 2:
                jVar.getClass();
                Integer num = (Integer) jVar.g;
                Bundle bundle = new Bundle();
                bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", null);
                if (num != null) {
                    bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
                }
                bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
                bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
                bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
                bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
                bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
                bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
                bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
                bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
                return new f1.a(context, looper, jVar, bundle, eVar, fVar);
            case 3:
                obj.getClass();
                throw new ClassCastException();
            default:
                return super.h(context, looper, jVar, obj, eVar, fVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.l5
    public /* synthetic */ g0.b i(Context context, Looper looper, j jVar, Object obj, n nVar, n nVar2) {
        switch (this.f819a) {
            case 4:
                return new k0.c(context, looper, jVar, (o) obj, nVar, nVar2);
            default:
                return super.i(context, looper, jVar, obj, nVar, nVar2);
        }
    }
}
