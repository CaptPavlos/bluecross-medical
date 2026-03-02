package com.google.android.material.carousel;

import android.view.View;
import com.google.android.material.navigation.NavigationBarItemView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2310a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2311b;

    public /* synthetic */ a(Object obj, int i10) {
        this.f2310a = i10;
        this.f2311b = obj;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        switch (this.f2310a) {
            case 0:
                ((CarouselLayoutManager) this.f2311b).lambda$new$0(view, i10, i11, i12, i13, i14, i15, i16, i17);
                break;
            default:
                ((NavigationBarItemView) this.f2311b).lambda$new$0(view, i10, i11, i12, i13, i14, i15, i16, i17);
                break;
        }
    }
}
