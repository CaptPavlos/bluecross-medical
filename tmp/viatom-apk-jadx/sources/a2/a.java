package a2;

import a3.u0;
import a3.v0;
import a3.z0;
import android.util.Log;
import android.window.OnBackInvokedDispatcher;
import androidx.constraintlayout.core.state.Interpolator;
import androidx.constraintlayout.core.state.Transition;
import com.google.firebase.sessions.FirebaseSessionsRegistrar;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import m.e;
import q1.d;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements e, d, Interpolator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20a;

    public static /* bridge */ /* synthetic */ OnBackInvokedDispatcher d(Object obj) {
        return (OnBackInvokedDispatcher) obj;
    }

    public static /* synthetic */ void e() {
        throw new ConcurrentModificationException();
    }

    public static /* synthetic */ void f(int i10, int i11) {
        throw new IllegalArgumentException("Start (" + i10 + ((Object) ") is more than end (") + i11 + ')');
    }

    public static /* synthetic */ void g(int i10, String str) {
        throw new IllegalStateException((str + i10).toString());
    }

    public static /* synthetic */ void i(Object obj, String str, Object obj2) {
        throw new NoSuchElementException(str + obj + obj2);
    }

    public static /* synthetic */ void j(String str) {
        throw new RuntimeException(str);
    }

    public static /* synthetic */ void k(String str, float f, Object obj) {
        throw new IllegalArgumentException(str + f + obj);
    }

    public static /* synthetic */ void m(String str) {
        throw new UnsupportedOperationException(str);
    }

    @Override // m.e
    public Object apply(Object obj) {
        String strW = v0.f170b.w((u0) obj);
        strW.getClass();
        Log.d("FirebaseSessions", "Session Event Type: SESSION_START");
        byte[] bytes = strW.getBytes(o7.a.f11749a);
        bytes.getClass();
        return bytes;
    }

    @Override // q1.d
    public Object c(z0 z0Var) {
        switch (this.f20a) {
            case 8:
                return FirebaseSessionsRegistrar.getComponents$lambda$0(z0Var);
            default:
                return FirebaseSessionsRegistrar.getComponents$lambda$1(z0Var);
        }
    }

    @Override // androidx.constraintlayout.core.state.Interpolator
    public float getInterpolation(float f) {
        switch (this.f20a) {
            case 25:
                return Transition.lambda$getInterpolator$1(f);
            case 26:
                return Transition.lambda$getInterpolator$2(f);
            case 27:
                return Transition.lambda$getInterpolator$3(f);
            case 28:
                return Transition.lambda$getInterpolator$4(f);
            default:
                return Transition.lambda$getInterpolator$5(f);
        }
    }

    public /* synthetic */ a(int i10) {
        this.f20a = i10;
    }
}
