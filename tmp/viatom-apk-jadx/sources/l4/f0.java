package l4;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f0 extends ViewModel {

    /* renamed from: a, reason: collision with root package name */
    public final u7.m0 f10376a;

    /* renamed from: b, reason: collision with root package name */
    public final u7.m0 f10377b;

    /* renamed from: c, reason: collision with root package name */
    public final u7.m0 f10378c;

    /* renamed from: d, reason: collision with root package name */
    public final u7.m0 f10379d;
    public int e;
    public boolean f;
    public boolean g;

    public f0() {
        v5.k kVar = v5.k.f13167a;
        u7.m0 m0VarA = u7.i0.a(kVar);
        this.f10376a = m0VarA;
        this.f10377b = m0VarA;
        u7.m0 m0VarA2 = u7.i0.a(kVar);
        this.f10378c = m0VarA2;
        this.f10379d = m0VarA2;
        this.f = true;
    }

    public final void a(Context context) {
        r7.w viewModelScope = ViewModelKt.getViewModelScope(this);
        y7.e eVar = r7.i0.f12407a;
        r7.y.q(viewModelScope, y7.d.f14116a, null, new a6.j((Object) this, context, (w6.c) null, 22), 2);
    }
}
