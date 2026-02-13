package androidx.activity;

import android.view.View;
import n7.i;
import r7.q;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ViewTreeFullyDrawnReporterOwner {
    public static final FullyDrawnReporterOwner get(View view) {
        view.getClass();
        n7.f fVarT = i.T(ViewTreeFullyDrawnReporterOwner$findViewTreeFullyDrawnReporterOwner$1.INSTANCE, view);
        ViewTreeFullyDrawnReporterOwner$findViewTreeFullyDrawnReporterOwner$2 viewTreeFullyDrawnReporterOwner$findViewTreeFullyDrawnReporterOwner$2 = ViewTreeFullyDrawnReporterOwner$findViewTreeFullyDrawnReporterOwner$2.INSTANCE;
        viewTreeFullyDrawnReporterOwner$findViewTreeFullyDrawnReporterOwner$2.getClass();
        n7.c cVar = new n7.c(new n7.d(new n7.d(fVarT, viewTreeFullyDrawnReporterOwner$findViewTreeFullyDrawnReporterOwner$2), new q(1)));
        return (FullyDrawnReporterOwner) (!cVar.hasNext() ? null : cVar.next());
    }

    public static final void set(View view, FullyDrawnReporterOwner fullyDrawnReporterOwner) {
        view.getClass();
        fullyDrawnReporterOwner.getClass();
        view.setTag(R.id.report_drawn, fullyDrawnReporterOwner);
    }
}
