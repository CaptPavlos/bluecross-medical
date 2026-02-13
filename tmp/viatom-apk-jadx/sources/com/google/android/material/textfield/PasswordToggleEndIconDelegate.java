package com.google.android.material.textfield;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.google.android.material.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
class PasswordToggleEndIconDelegate extends EndIconDelegate {

    @Nullable
    private EditText editText;
    private int iconResId;
    private final View.OnClickListener onIconClickListener;

    public PasswordToggleEndIconDelegate(@NonNull EndCompoundLayout endCompoundLayout, @DrawableRes int i10) {
        super(endCompoundLayout);
        this.iconResId = R.drawable.design_password_eye;
        this.onIconClickListener = new a(this, 2);
        if (i10 != 0) {
            this.iconResId = i10;
        }
    }

    private boolean hasPasswordTransformation() {
        EditText editText = this.editText;
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private static boolean isInputTypePassword(EditText editText) {
        if (editText != null) {
            return editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        EditText editText = this.editText;
        if (editText == null) {
            return;
        }
        int selectionEnd = editText.getSelectionEnd();
        boolean zHasPasswordTransformation = hasPasswordTransformation();
        EditText editText2 = this.editText;
        if (zHasPasswordTransformation) {
            editText2.setTransformationMethod(null);
        } else {
            editText2.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        if (selectionEnd >= 0) {
            this.editText.setSelection(selectionEnd);
        }
        refreshIconState();
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void beforeEditTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        refreshIconState();
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    @StringRes
    public int getIconContentDescriptionResId() {
        return R.string.password_toggle_content_description;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    @DrawableRes
    public int getIconDrawableResId() {
        return this.iconResId;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public View.OnClickListener getOnIconClickListener() {
        return this.onIconClickListener;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public boolean isIconCheckable() {
        return true;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public boolean isIconChecked() {
        return !hasPasswordTransformation();
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void onEditTextAttached(@Nullable EditText editText) {
        this.editText = editText;
        refreshIconState();
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void setUp() {
        if (isInputTypePassword(this.editText)) {
            this.editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void tearDown() {
        EditText editText = this.editText;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
