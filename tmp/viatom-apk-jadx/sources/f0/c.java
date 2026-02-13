package f0;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import i0.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class c extends DialogFragment {

    /* renamed from: a, reason: collision with root package name */
    public Dialog f7994a;

    /* renamed from: b, reason: collision with root package name */
    public DialogInterface.OnCancelListener f7995b;

    /* renamed from: c, reason: collision with root package name */
    public AlertDialog f7996c;

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f7995b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f7994a;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.f7996c == null) {
            Activity activity = getActivity();
            y.g(activity);
            this.f7996c = new AlertDialog.Builder(activity).create();
        }
        return this.f7996c;
    }
}
