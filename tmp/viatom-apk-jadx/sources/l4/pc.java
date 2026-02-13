package l4;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class pc extends ViewModel {

    /* renamed from: a, reason: collision with root package name */
    public final u7.m0 f10742a;

    /* renamed from: b, reason: collision with root package name */
    public final u7.m0 f10743b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f10744c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f10745d;
    public int e;

    public pc() {
        u7.m0 m0VarA = u7.i0.a(v5.j.f13166a);
        this.f10742a = m0VarA;
        this.f10743b = m0VarA;
    }

    public final void a(Context context) {
        this.f10745d = true;
        u7.m0 m0Var = this.f10742a;
        m0Var.getClass();
        m0Var.g(null, v5.j.f13166a);
        r7.y.q(ViewModelKt.getViewModelScope(this), null, null, new b9.p(context, this, new n5(this, 14), (w6.c) null, 22), 3);
    }
}
