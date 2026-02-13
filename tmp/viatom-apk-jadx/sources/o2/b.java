package o2;

import a3.z0;
import android.content.Context;
import com.google.firebase.messaging.FirebaseMessagingRegistrar;
import java.util.concurrent.Executor;
import q1.q;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class b implements q1.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11674a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q f11675b;

    public /* synthetic */ b(q qVar, int i10) {
        this.f11674a = i10;
        this.f11675b = qVar;
    }

    @Override // q1.d
    public final Object c(z0 z0Var) {
        switch (this.f11674a) {
            case 0:
                return new d((Context) z0Var.a(Context.class), ((l1.g) z0Var.a(l1.g.class)).d(), z0Var.o(e.class), z0Var.c(y2.b.class), (Executor) z0Var.f(this.f11675b));
            default:
                return FirebaseMessagingRegistrar.lambda$getComponents$0(this.f11675b, z0Var);
        }
    }
}
