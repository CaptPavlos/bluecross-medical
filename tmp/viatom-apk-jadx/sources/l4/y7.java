package l4;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class y7 extends ViewModel {

    /* renamed from: a, reason: collision with root package name */
    public final u7.m0 f11031a;

    /* renamed from: b, reason: collision with root package name */
    public final u7.m0 f11032b;

    /* renamed from: c, reason: collision with root package name */
    public final u7.m0 f11033c;

    /* renamed from: d, reason: collision with root package name */
    public final u7.m0 f11034d;
    public final u7.m0 e;
    public final u7.m0 f;
    public final u7.m0 g;
    public final u7.m0 h;

    /* renamed from: i, reason: collision with root package name */
    public final u7.m0 f11035i;

    /* renamed from: j, reason: collision with root package name */
    public final u7.m0 f11036j;

    /* renamed from: k, reason: collision with root package name */
    public final u7.m0 f11037k;

    /* renamed from: l, reason: collision with root package name */
    public final u7.m0 f11038l;

    /* renamed from: m, reason: collision with root package name */
    public final u7.m0 f11039m;

    /* renamed from: n, reason: collision with root package name */
    public final u7.m0 f11040n;

    /* renamed from: o, reason: collision with root package name */
    public final u7.m0 f11041o;

    /* renamed from: p, reason: collision with root package name */
    public final u7.m0 f11042p;

    /* renamed from: q, reason: collision with root package name */
    public final u7.m0 f11043q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f11044r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f11045s;

    public y7() {
        v5.j jVar = v5.j.f13166a;
        u7.m0 m0VarA = u7.i0.a(jVar);
        this.f11031a = m0VarA;
        this.f11032b = m0VarA;
        u7.m0 m0VarA2 = u7.i0.a(jVar);
        this.f11033c = m0VarA2;
        this.f11034d = m0VarA2;
        v5.k kVar = v5.k.f13167a;
        u7.m0 m0VarA3 = u7.i0.a(kVar);
        this.e = m0VarA3;
        this.f = m0VarA3;
        u7.m0 m0VarA4 = u7.i0.a(jVar);
        this.g = m0VarA4;
        this.h = m0VarA4;
        u7.m0 m0VarA5 = u7.i0.a(kVar);
        this.f11035i = m0VarA5;
        this.f11036j = m0VarA5;
        this.f11037k = u7.i0.a("");
        this.f11038l = u7.i0.a("");
        this.f11039m = u7.i0.a(null);
        this.f11040n = u7.i0.a(null);
        this.f11041o = u7.i0.a(null);
        this.f11042p = u7.i0.a(0L);
        this.f11043q = u7.i0.a(null);
        this.f11044r = true;
    }

    public final void a(Context context, int i10, String str) {
        if (i10 == 1) {
            r7.w viewModelScope = ViewModelKt.getViewModelScope(this);
            y7.e eVar = r7.i0.f12407a;
            r7.y.q(viewModelScope, y7.d.f14116a, null, new x7(context, str, this, null, 1), 2);
        } else {
            r7.w viewModelScope2 = ViewModelKt.getViewModelScope(this);
            y7.e eVar2 = r7.i0.f12407a;
            r7.y.q(viewModelScope2, y7.d.f14116a, null, new x7(context, str, this, null, 0), 2);
        }
    }
}
