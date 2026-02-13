package com.google.android.material.textfield;

import android.view.View;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class b implements View.OnFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2401a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EndIconDelegate f2402b;

    public /* synthetic */ b(EndIconDelegate endIconDelegate, int i10) {
        this.f2401a = i10;
        this.f2402b = endIconDelegate;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z9) {
        switch (this.f2401a) {
            case 0:
                ((ClearTextEndIconDelegate) this.f2402b).lambda$new$1(view, z9);
                break;
            default:
                ((DropdownMenuEndIconDelegate) this.f2402b).lambda$new$1(view, z9);
                break;
        }
    }
}
