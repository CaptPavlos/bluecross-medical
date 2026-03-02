package c5;

import android.content.Context;
import androidx.lifecycle.LifecycleCoroutineScope;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class x {

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f1768c = new AtomicBoolean(false);

    /* renamed from: a, reason: collision with root package name */
    public final Context f1769a;

    /* renamed from: b, reason: collision with root package name */
    public final r7.w f1770b;

    public x(Context context, LifecycleCoroutineScope lifecycleCoroutineScope) {
        context.getClass();
        lifecycleCoroutineScope.getClass();
        this.f1769a = context;
        this.f1770b = lifecycleCoroutineScope;
    }

    public final void a(String str, g5.q qVar) {
        str.getClass();
        if (f1768c.compareAndSet(false, true)) {
            y7.e eVar = r7.i0.f12407a;
            r7.y.q(this.f1770b, y7.d.f14116a, null, new b9.p(this, str, qVar, (w6.c) null), 2);
        }
    }
}
