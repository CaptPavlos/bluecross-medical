package e5;

import androidx.fragment.app.FragmentActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class u implements g7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7876a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j0 f7877b;

    public /* synthetic */ u(j0 j0Var, int i10) {
        this.f7876a = i10;
        this.f7877b = j0Var;
    }

    @Override // g7.a
    public final Object invoke() {
        switch (this.f7876a) {
            case 0:
                this.f7877b.A();
                break;
            case 1:
                j0 j0Var = this.f7877b;
                FragmentActivity fragmentActivityRequireActivity = j0Var.requireActivity();
                fragmentActivityRequireActivity.getClass();
                j0Var.s(fragmentActivityRequireActivity);
                break;
            case 2:
                this.f7877b.A();
                break;
            default:
                j0 j0Var2 = this.f7877b;
                FragmentActivity fragmentActivityRequireActivity2 = j0Var2.requireActivity();
                fragmentActivityRequireActivity2.getClass();
                j0Var2.s(fragmentActivityRequireActivity2);
                break;
        }
        return s6.w.f12711a;
    }
}
