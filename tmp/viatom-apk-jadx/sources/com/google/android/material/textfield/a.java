package com.google.android.material.textfield;

import android.view.View;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2399a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EndIconDelegate f2400b;

    public /* synthetic */ a(EndIconDelegate endIconDelegate, int i10) {
        this.f2399a = i10;
        this.f2400b = endIconDelegate;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f2399a) {
            case 0:
                ((ClearTextEndIconDelegate) this.f2400b).lambda$new$0(view);
                break;
            case 1:
                ((DropdownMenuEndIconDelegate) this.f2400b).lambda$new$0(view);
                break;
            default:
                ((PasswordToggleEndIconDelegate) this.f2400b).lambda$new$0(view);
                break;
        }
    }
}
