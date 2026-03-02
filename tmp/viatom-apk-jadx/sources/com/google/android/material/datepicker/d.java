package com.google.android.material.datepicker;

import android.view.View;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2347a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MaterialDatePicker f2348b;

    public /* synthetic */ d(MaterialDatePicker materialDatePicker, int i10) {
        this.f2347a = i10;
        this.f2348b = materialDatePicker;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f2347a) {
            case 0:
                this.f2348b.lambda$initHeaderToggle$0(view);
                break;
            case 1:
                this.f2348b.onPositiveButtonClick(view);
                break;
            default:
                this.f2348b.onNegativeButtonClick(view);
                break;
        }
    }
}
