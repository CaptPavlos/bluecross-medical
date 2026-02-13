package n4;

import android.view.View;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class i1 implements View.OnLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11378a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j1 f11379b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h5.h f11380c;

    public /* synthetic */ i1(j1 j1Var, h5.h hVar, int i10, int i11) {
        this.f11378a = i11;
        this.f11379b = j1Var;
        this.f11380c = hVar;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        switch (this.f11378a) {
            case 0:
                this.f11379b.f11388c.c(this.f11380c);
                break;
            default:
                this.f11379b.f11388c.c(this.f11380c);
                break;
        }
        return true;
    }
}
