package k;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class a extends BottomSheetDialogFragment {
    public final void a() {
        FragmentActivity activity;
        if (!isAdded() || (activity = getActivity()) == null) {
            return;
        }
        activity.isFinishing();
    }

    public abstract void b(ViewStub viewStub);

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        dialogInterface.getClass();
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, R.style.SheetDialog);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View viewInflate = layoutInflater.inflate(R.layout.base_bottom_sheet, viewGroup, false);
        viewInflate.getClass();
        ViewStub viewStub = (ViewStub) viewInflate.findViewById(R.id.container_vs);
        if (viewStub == null) {
            return viewInflate;
        }
        b(viewStub);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        Resources resources;
        DisplayMetrics displayMetrics;
        super.onResume();
        View view = getView();
        if (view == null) {
            return;
        }
        Object parent = view.getParent();
        View view2 = parent instanceof View ? (View) parent : null;
        if (view2 == null) {
            return;
        }
        BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from(view2);
        bottomSheetBehaviorFrom.getClass();
        Context context = getContext();
        if (context == null || (resources = context.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            return;
        }
        int i10 = displayMetrics.heightPixels;
        bottomSheetBehaviorFrom.setPeekHeight(i10);
        ViewStub viewStub = (ViewStub) view2.findViewById(R.id.container_vs);
        if (viewStub == null) {
            return;
        }
        viewStub.inflate().setMinimumHeight((int) (i10 * 0.25d));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        super.onViewCreated(view, bundle);
    }
}
