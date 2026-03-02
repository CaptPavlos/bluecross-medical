package androidx.activity;

import android.view.View;
import n7.i;
import r7.q;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ViewTreeOnBackPressedDispatcherOwner {
    public static final OnBackPressedDispatcherOwner get(View view) {
        view.getClass();
        n7.f fVarT = i.T(ViewTreeOnBackPressedDispatcherOwner$findViewTreeOnBackPressedDispatcherOwner$1.INSTANCE, view);
        ViewTreeOnBackPressedDispatcherOwner$findViewTreeOnBackPressedDispatcherOwner$2 viewTreeOnBackPressedDispatcherOwner$findViewTreeOnBackPressedDispatcherOwner$2 = ViewTreeOnBackPressedDispatcherOwner$findViewTreeOnBackPressedDispatcherOwner$2.INSTANCE;
        viewTreeOnBackPressedDispatcherOwner$findViewTreeOnBackPressedDispatcherOwner$2.getClass();
        n7.c cVar = new n7.c(new n7.d(new n7.d(fVarT, viewTreeOnBackPressedDispatcherOwner$findViewTreeOnBackPressedDispatcherOwner$2), new q(1)));
        return (OnBackPressedDispatcherOwner) (!cVar.hasNext() ? null : cVar.next());
    }

    public static final void set(View view, OnBackPressedDispatcherOwner onBackPressedDispatcherOwner) {
        view.getClass();
        onBackPressedDispatcherOwner.getClass();
        view.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, onBackPressedDispatcherOwner);
    }
}
