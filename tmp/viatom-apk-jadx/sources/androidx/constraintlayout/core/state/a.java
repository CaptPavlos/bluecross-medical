package androidx.constraintlayout.core.state;

import com.google.gson.e;
import com.google.gson.internal.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Interpolator, m {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f458a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f459b;

    public /* synthetic */ a(String str, int i10) {
        this.f458a = i10;
        this.f459b = str;
    }

    @Override // com.google.gson.internal.m
    public Object d() {
        switch (this.f458a) {
            case 1:
                throw new e(this.f459b);
            case 2:
                throw new e(this.f459b);
            default:
                throw new e(this.f459b);
        }
    }

    @Override // androidx.constraintlayout.core.state.Interpolator
    public float getInterpolation(float f) {
        return Transition.lambda$getInterpolator$0(this.f459b, f);
    }
}
