package com.google.android.material.bottomappbar;

import android.view.View;
import com.google.android.material.internal.ViewUtils;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2304a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f2305b;

    public /* synthetic */ a(View view, int i10) {
        this.f2304a = i10;
        this.f2305b = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2304a) {
            case 0:
                this.f2305b.requestLayout();
                break;
            default:
                ViewUtils.requestFocusAndShowKeyboard(this.f2305b, false);
                break;
        }
    }
}
