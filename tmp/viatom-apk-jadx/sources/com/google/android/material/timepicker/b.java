package com.google.android.material.timepicker;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2412a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2413b;

    public /* synthetic */ b(Object obj, int i10) {
        this.f2412a = i10;
        this.f2413b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2412a) {
            case 0:
                ((RadialViewGroup) this.f2413b).updateLayoutParams();
                break;
            default:
                ((MaterialTimePicker) this.f2413b).lambda$onViewCreated$0();
                break;
        }
    }
}
