package com.google.android.material.textfield;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2405a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2406b;

    public /* synthetic */ d(Object obj, int i10) {
        this.f2405a = i10;
        this.f2406b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2405a) {
            case 0:
                ((ClearTextEndIconDelegate) this.f2406b).lambda$tearDown$2();
                break;
            case 1:
                ((DropdownMenuEndIconDelegate) this.f2406b).lambda$afterEditTextChanged$3();
                break;
            default:
                ((TextInputLayout) this.f2406b).lambda$onGlobalLayout$1();
                break;
        }
    }
}
