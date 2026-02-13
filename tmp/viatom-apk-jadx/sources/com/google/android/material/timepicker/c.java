package com.google.android.material.timepicker;

import com.google.android.material.button.MaterialButtonToggleGroup;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class c implements MaterialButtonToggleGroup.OnButtonCheckedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2414a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2415b;

    public /* synthetic */ c(Object obj, int i10) {
        this.f2414a = i10;
        this.f2415b = obj;
    }

    @Override // com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener
    public final void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, int i10, boolean z9) {
        switch (this.f2414a) {
            case 0:
                ((TimePickerTextInputPresenter) this.f2415b).lambda$setupPeriodToggle$0(materialButtonToggleGroup, i10, z9);
                break;
            default:
                ((TimePickerView) this.f2415b).lambda$new$0(materialButtonToggleGroup, i10, z9);
                break;
        }
    }
}
