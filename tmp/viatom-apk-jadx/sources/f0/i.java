package f0;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import i0.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class i extends DialogFragment {

    /* renamed from: a, reason: collision with root package name */
    public Dialog f8011a;

    /* renamed from: b, reason: collision with root package name */
    public DialogInterface.OnCancelListener f8012b;

    /* renamed from: c, reason: collision with root package name */
    public AlertDialog f8013c;

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f8012b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f8011a;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.f8013c == null) {
            Context context = getContext();
            y.g(context);
            this.f8013c = new AlertDialog.Builder(context).create();
        }
        return this.f8013c;
    }
}
